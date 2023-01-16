package p001ch.qos.logback.core.status;

/* renamed from: ch.qos.logback.core.status.WarnStatus */
/* loaded from: grasscutter.jar:ch/qos/logback/core/status/WarnStatus.class */
public class WarnStatus extends StatusBase {
    public WarnStatus(String msg, Object origin) {
        super(1, msg, origin);
    }

    public WarnStatus(String msg, Object origin, Throwable t) {
        super(1, msg, origin, t);
    }
}
