package javax.servlet.http;

import java.util.EventListener;

/* loaded from: grasscutter.jar:javax/servlet/http/HttpSessionIdListener.class */
public interface HttpSessionIdListener extends EventListener {
    void sessionIdChanged(HttpSessionEvent httpSessionEvent, String str);
}
