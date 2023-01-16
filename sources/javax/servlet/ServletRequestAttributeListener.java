package javax.servlet;

import java.util.EventListener;

/* loaded from: grasscutter.jar:javax/servlet/ServletRequestAttributeListener.class */
public interface ServletRequestAttributeListener extends EventListener {
    void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent);

    void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent);

    void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent);
}
