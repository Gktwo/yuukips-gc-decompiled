package org.eclipse.jetty.servlet;

import java.util.EventListener;
import javax.servlet.ServletException;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.BaseHolder;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ListenerHolder.class */
public class ListenerHolder extends BaseHolder<EventListener> {
    private EventListener _listener;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ListenerHolder$WrapFunction.class */
    public interface WrapFunction {
        EventListener wrapEventListener(EventListener eventListener);
    }

    public ListenerHolder() {
        this(Source.EMBEDDED);
    }

    public ListenerHolder(Source source) {
        super(source);
    }

    public ListenerHolder(Class<? extends EventListener> listenerClass) {
        super(Source.EMBEDDED);
        setHeldClass(listenerClass);
    }

    public EventListener getListener() {
        return this._listener;
    }

    public void setListener(EventListener listener) {
        setInstance(listener);
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        doStart();
        if (!EventListener.class.isAssignableFrom(getHeldClass())) {
            String msg = getHeldClass() + " is not a java.util.EventListener";
            stop();
            throw new IllegalStateException(msg);
        }
        ContextHandler contextHandler = null;
        if (getServletHandler() != null) {
            contextHandler = getServletHandler().getServletContextHandler();
        }
        if (contextHandler == null && ContextHandler.getCurrentContext() != null) {
            contextHandler = ContextHandler.getCurrentContext().getContextHandler();
        }
        if (contextHandler == null) {
            throw new IllegalStateException("No Context");
        }
        this._listener = getInstance();
        if (this._listener == null) {
            try {
                this._listener = contextHandler.getServletContext().createListener(getHeldClass());
                this._listener = wrap(this._listener, WrapFunction.class, (v0, v1) -> {
                    return v0.wrapEventListener(v1);
                });
            } catch (ServletException ex) {
                throw ex;
            }
        }
        contextHandler.addEventListener(this._listener);
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
        if (this._listener != null) {
            try {
                ContextHandler contextHandler = ContextHandler.getCurrentContext().getContextHandler();
                if (contextHandler != null) {
                    contextHandler.removeEventListener(this._listener);
                }
                getServletHandler().destroyListener(unwrap(this._listener));
            } finally {
                this._listener = null;
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x{src=%s}", getClassName(), Integer.valueOf(hashCode()), getSource());
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ListenerHolder$Wrapper.class */
    public static class Wrapper implements EventListener, BaseHolder.Wrapped<EventListener> {
        final EventListener _listener;

        public Wrapper(EventListener listener) {
            this._listener = listener;
        }

        @Override // org.eclipse.jetty.servlet.BaseHolder.Wrapped
        public EventListener getWrapped() {
            return this._listener;
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("%s:%s", getClass().getSimpleName(), this._listener.toString());
        }
    }
}
