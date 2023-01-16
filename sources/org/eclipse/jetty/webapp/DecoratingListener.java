package org.eclipse.jetty.webapp;

import org.eclipse.jetty.servlet.ServletContextHandler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/DecoratingListener.class */
public class DecoratingListener extends org.eclipse.jetty.servlet.DecoratingListener {
    public static final String DECORATOR_ATTRIBUTE = "org.eclipse.jetty.webapp.decorator";

    public DecoratingListener() {
        this(DECORATOR_ATTRIBUTE);
    }

    public DecoratingListener(String attributeName) {
        this(WebAppContext.getCurrentWebAppContext(), attributeName);
    }

    public DecoratingListener(ServletContextHandler context) {
        this(context, DECORATOR_ATTRIBUTE);
    }

    public DecoratingListener(ServletContextHandler context, String attributeName) {
        super(context, attributeName);
        checkAndSetAttributeName();
    }

    protected void checkAndSetAttributeName() {
        if (getServletContext().getAttribute(getClass().getName()) != null) {
            throw new IllegalStateException("Multiple DecoratingListeners detected");
        }
        getServletContext().setAttribute(getClass().getName(), getAttributeName());
    }
}
