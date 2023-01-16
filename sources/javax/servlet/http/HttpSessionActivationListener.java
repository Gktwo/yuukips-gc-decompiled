package javax.servlet.http;

import java.util.EventListener;

/* loaded from: grasscutter.jar:javax/servlet/http/HttpSessionActivationListener.class */
public interface HttpSessionActivationListener extends EventListener {
    void sessionWillPassivate(HttpSessionEvent httpSessionEvent);

    void sessionDidActivate(HttpSessionEvent httpSessionEvent);
}
