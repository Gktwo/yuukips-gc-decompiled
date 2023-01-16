package javax.servlet.http;

import java.util.EventListener;

/* loaded from: grasscutter.jar:javax/servlet/http/HttpSessionAttributeListener.class */
public interface HttpSessionAttributeListener extends EventListener {
    void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent);

    void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent);

    void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent);
}
