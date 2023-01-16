package javax.servlet;

import java.io.IOException;

/* loaded from: grasscutter.jar:javax/servlet/FilterChain.class */
public interface FilterChain {
    void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException;
}
