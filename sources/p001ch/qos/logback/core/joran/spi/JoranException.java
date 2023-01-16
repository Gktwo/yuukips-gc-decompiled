package p001ch.qos.logback.core.joran.spi;

/* renamed from: ch.qos.logback.core.joran.spi.JoranException */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/spi/JoranException.class */
public class JoranException extends Exception {
    private static final long serialVersionUID = 1112493363728774021L;

    public JoranException(String msg) {
        super(msg);
    }

    public JoranException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
