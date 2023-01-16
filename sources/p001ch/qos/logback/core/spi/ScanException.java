package p001ch.qos.logback.core.spi;

/* renamed from: ch.qos.logback.core.spi.ScanException */
/* loaded from: grasscutter.jar:ch/qos/logback/core/spi/ScanException.class */
public class ScanException extends Exception {
    private static final long serialVersionUID = -3132040414328475658L;
    Throwable cause;

    public ScanException(String msg) {
        super(msg);
    }

    public ScanException(String msg, Throwable rootCause) {
        super(msg);
        this.cause = rootCause;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
