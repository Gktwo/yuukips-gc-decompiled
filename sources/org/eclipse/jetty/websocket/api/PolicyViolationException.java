package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/PolicyViolationException.class */
public class PolicyViolationException extends CloseException {
    public PolicyViolationException(String message) {
        super((int) StatusCode.POLICY_VIOLATION, message);
    }

    public PolicyViolationException(String message, Throwable t) {
        super(StatusCode.POLICY_VIOLATION, message, t);
    }

    public PolicyViolationException(Throwable t) {
        super((int) StatusCode.POLICY_VIOLATION, t);
    }
}
