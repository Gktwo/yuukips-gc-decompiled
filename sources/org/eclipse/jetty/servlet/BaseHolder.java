package org.eclipse.jetty.servlet;

import java.io.IOException;
import java.util.function.BiFunction;
import javax.servlet.ServletContext;
import javax.servlet.UnavailableException;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/BaseHolder.class */
public abstract class BaseHolder<T> extends AbstractLifeCycle implements Dumpable {
    private static final Logger LOG = Log.getLogger(BaseHolder.class);
    private final Source _source;
    private Class<? extends T> _class;
    private String _className;
    private T _instance;
    private ServletHandler _servletHandler;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/BaseHolder$Wrapped.class */
    interface Wrapped<C> {
        C getWrapped();
    }

    /* access modifiers changed from: protected */
    public BaseHolder(Source source) {
        this._source = source;
    }

    public Source getSource() {
        return this._source;
    }

    public void initialize() throws Exception {
        if (!isStarted()) {
            throw new IllegalStateException("Not started: " + this);
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._class == null && (this._className == null || this._className.equals(""))) {
            throw new UnavailableException("No class in holder " + toString());
        } else if (this._class == null) {
            try {
                this._class = Loader.loadClass(this._className);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Holding {} from {}", this._class, this._class.getClassLoader());
                }
            } catch (Exception e) {
                LOG.warn(e);
                throw new UnavailableException("Class loading error for holder " + toString());
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        if (this._instance == null) {
            this._class = null;
        }
    }

    @ManagedAttribute(value = "Class Name", readonly = true)
    public String getClassName() {
        return this._className;
    }

    public Class<? extends T> getHeldClass() {
        return this._class;
    }

    public ServletHandler getServletHandler() {
        return this._servletHandler;
    }

    public void setServletHandler(ServletHandler servletHandler) {
        this._servletHandler = servletHandler;
    }

    public void setClassName(String className) {
        this._className = className;
        this._class = null;
    }

    public void setHeldClass(Class<? extends T> held) {
        this._class = held;
        if (held != null) {
            this._className = held.getName();
        }
    }

    protected void illegalStateIfContextStarted() {
        if (this._servletHandler != null) {
            ServletContext context = this._servletHandler.getServletContext();
            if ((context instanceof ContextHandler.Context) && ((ContextHandler.Context) context).getContextHandler().isStarted()) {
                throw new IllegalStateException("Started");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: org.eclipse.jetty.servlet.BaseHolder<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public synchronized void setInstance(T instance) {
        this._instance = instance;
        if (instance == null) {
            setHeldClass(null);
        } else {
            setHeldClass(instance.getClass());
        }
    }

    protected synchronized T getInstance() {
        return this._instance;
    }

    public synchronized boolean isInstance() {
        return this._instance != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    protected <W> T wrap(T component, Class<W> wrapperFunctionType, BiFunction<W, T, T> function) {
        T ret = component;
        ServletContextHandler contextHandler = getServletHandler().getServletContextHandler();
        if (contextHandler == null) {
            ContextHandler.Context context = ContextHandler.getCurrentContext();
            contextHandler = (ServletContextHandler) (context == null ? null : context.getContextHandler());
        }
        if (contextHandler != null) {
            for (T t : contextHandler.getBeans(wrapperFunctionType)) {
                ret = function.apply(t, ret);
            }
        }
        return ret;
    }

    protected T unwrap(T component) {
        T ret = component;
        while (ret instanceof Wrapped) {
            ret = (T) ((Wrapped) ret).getWrapped();
        }
        return ret;
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObject(out, this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return Dumpable.dump(this);
    }
}
