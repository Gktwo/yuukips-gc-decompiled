package javax.servlet.http;

import java.util.EventListener;

/* loaded from: grasscutter.jar:javax/servlet/http/HttpSessionListener.class */
public interface HttpSessionListener extends EventListener {
    void sessionCreated(HttpSessionEvent httpSessionEvent);

    void sessionDestroyed(HttpSessionEvent httpSessionEvent);
}
