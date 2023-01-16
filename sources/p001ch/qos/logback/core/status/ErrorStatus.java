package p001ch.qos.logback.core.status;

/* renamed from: ch.qos.logback.core.status.ErrorStatus */
/* loaded from: grasscutter.jar:ch/qos/logback/core/status/ErrorStatus.class */
public class ErrorStatus extends StatusBase {
    public ErrorStatus(String msg, Object origin) {
        super(2, msg, origin);
    }

    public ErrorStatus(String msg, Object origin, Throwable t) {
        super(2, msg, origin, t);
    }
}
