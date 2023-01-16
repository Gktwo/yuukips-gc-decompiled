package javax.servlet.http;

/* loaded from: grasscutter.jar:javax/servlet/http/HttpSessionBindingEvent.class */
public class HttpSessionBindingEvent extends HttpSessionEvent {
    private static final long serialVersionUID = 7308000419984825907L;
    private String name;
    private Object value;

    public HttpSessionBindingEvent(HttpSession session, String name) {
        super(session);
        this.name = name;
    }

    public HttpSessionBindingEvent(HttpSession session, String name, Object value) {
        super(session);
        this.name = name;
        this.value = value;
    }

    @Override // javax.servlet.http.HttpSessionEvent
    public HttpSession getSession() {
        return getSession();
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }
}
