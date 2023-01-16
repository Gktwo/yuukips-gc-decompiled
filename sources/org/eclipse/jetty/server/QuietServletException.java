package org.eclipse.jetty.server;

import javax.servlet.ServletException;
import org.eclipse.jetty.p023io.QuietException;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/QuietServletException.class */
public class QuietServletException extends ServletException implements QuietException {
    public QuietServletException() {
    }

    public QuietServletException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    public QuietServletException(String message) {
        super(message);
    }

    public QuietServletException(Throwable rootCause) {
        super(rootCause);
    }
}
