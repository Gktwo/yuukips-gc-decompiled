package javax.servlet.http;

import java.util.EventObject;

/* loaded from: grasscutter.jar:javax/servlet/http/HttpSessionEvent.class */
public class HttpSessionEvent extends EventObject {
    private static final long serialVersionUID = -7622791603672342895L;

    public HttpSessionEvent(HttpSession source) {
        super(source);
    }

    public HttpSession getSession() {
        return (HttpSession) getSource();
    }
}
