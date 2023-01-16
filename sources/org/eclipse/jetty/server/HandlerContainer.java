package org.eclipse.jetty.server;

import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.LifeCycle;

@ManagedObject("Handler of Multiple Handlers")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HandlerContainer.class */
public interface HandlerContainer extends LifeCycle {
    @ManagedAttribute("handlers in this container")
    Handler[] getHandlers();

    @ManagedAttribute("all contained handlers")
    Handler[] getChildHandlers();

    Handler[] getChildHandlersByClass(Class<?> cls);

    <T extends Handler> T getChildHandlerByClass(Class<T> cls);
}
