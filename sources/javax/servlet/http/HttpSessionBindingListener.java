package javax.servlet.http;

import java.util.EventListener;

/* loaded from: grasscutter.jar:javax/servlet/http/HttpSessionBindingListener.class */
public interface HttpSessionBindingListener extends EventListener {
    void valueBound(HttpSessionBindingEvent httpSessionBindingEvent);

    void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent);
}
