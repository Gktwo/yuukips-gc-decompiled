package javax.servlet;

import java.util.EventObject;

/* loaded from: grasscutter.jar:javax/servlet/ServletContextEvent.class */
public class ServletContextEvent extends EventObject {
    private static final long serialVersionUID = -7501701636134222423L;

    public ServletContextEvent(ServletContext source) {
        super(source);
    }

    public ServletContext getServletContext() {
        return (ServletContext) getSource();
    }
}
