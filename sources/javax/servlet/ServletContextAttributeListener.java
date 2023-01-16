package javax.servlet;

import java.util.EventListener;

/* loaded from: grasscutter.jar:javax/servlet/ServletContextAttributeListener.class */
public interface ServletContextAttributeListener extends EventListener {
    void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent);

    void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent);

    void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent);
}
