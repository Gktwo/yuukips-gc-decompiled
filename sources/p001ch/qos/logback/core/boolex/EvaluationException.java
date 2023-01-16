package p001ch.qos.logback.core.boolex;

/* renamed from: ch.qos.logback.core.boolex.EvaluationException */
/* loaded from: grasscutter.jar:ch/qos/logback/core/boolex/EvaluationException.class */
public class EvaluationException extends Exception {
    private static final long serialVersionUID = 1;

    public EvaluationException(String msg) {
        super(msg);
    }

    public EvaluationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public EvaluationException(Throwable cause) {
        super(cause);
    }
}
