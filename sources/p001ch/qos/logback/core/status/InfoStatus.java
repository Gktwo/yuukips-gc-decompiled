package p001ch.qos.logback.core.status;

/* renamed from: ch.qos.logback.core.status.InfoStatus */
/* loaded from: grasscutter.jar:ch/qos/logback/core/status/InfoStatus.class */
public class InfoStatus extends StatusBase {
    public InfoStatus(String msg, Object origin) {
        super(0, msg, origin);
    }

    public InfoStatus(String msg, Object origin, Throwable t) {
        super(0, msg, origin, t);
    }
}
