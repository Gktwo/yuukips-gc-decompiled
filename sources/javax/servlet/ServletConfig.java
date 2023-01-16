package javax.servlet;

import java.util.Enumeration;

/* loaded from: grasscutter.jar:javax/servlet/ServletConfig.class */
public interface ServletConfig {
    String getServletName();

    ServletContext getServletContext();

    String getInitParameter(String str);

    Enumeration<String> getInitParameterNames();
}
