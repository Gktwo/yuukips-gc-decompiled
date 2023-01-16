package p001ch.qos.logback.core;

/* renamed from: ch.qos.logback.core.LogbackException */
/* loaded from: grasscutter.jar:ch/qos/logback/core/LogbackException.class */
public class LogbackException extends RuntimeException {
    private static final long serialVersionUID = -799956346239073266L;

    public LogbackException(String msg) {
        super(msg);
    }

    public LogbackException(String msg, Throwable nested) {
        super(msg, nested);
    }
}
