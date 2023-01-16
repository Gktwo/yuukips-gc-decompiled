package javax.servlet;

import java.io.IOException;

/* loaded from: grasscutter.jar:javax/servlet/Filter.class */
public interface Filter {
    void init(FilterConfig filterConfig) throws ServletException;

    void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException;

    void destroy();
}
