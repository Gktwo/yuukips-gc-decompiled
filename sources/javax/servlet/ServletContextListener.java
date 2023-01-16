package javax.servlet;

import java.util.EventListener;

/* loaded from: grasscutter.jar:javax/servlet/ServletContextListener.class */
public interface ServletContextListener extends EventListener {
    void contextInitialized(ServletContextEvent servletContextEvent);

    void contextDestroyed(ServletContextEvent servletContextEvent);
}
