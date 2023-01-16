package javax.servlet;

import java.util.EventListener;

/* loaded from: grasscutter.jar:javax/servlet/ServletRequestListener.class */
public interface ServletRequestListener extends EventListener {
    void requestDestroyed(ServletRequestEvent servletRequestEvent);

    void requestInitialized(ServletRequestEvent servletRequestEvent);
}
