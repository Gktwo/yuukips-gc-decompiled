package javax.servlet;

import java.util.Set;

/* loaded from: grasscutter.jar:javax/servlet/ServletContainerInitializer.class */
public interface ServletContainerInitializer {
    void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException;
}
