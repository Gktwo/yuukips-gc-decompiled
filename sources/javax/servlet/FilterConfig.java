package javax.servlet;

import java.util.Enumeration;

/* loaded from: grasscutter.jar:javax/servlet/FilterConfig.class */
public interface FilterConfig {
    String getFilterName();

    ServletContext getServletContext();

    String getInitParameter(String str);

    Enumeration<String> getInitParameterNames();
}
