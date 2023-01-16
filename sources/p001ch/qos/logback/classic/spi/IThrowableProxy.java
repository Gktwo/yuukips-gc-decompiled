package p001ch.qos.logback.classic.spi;

/* renamed from: ch.qos.logback.classic.spi.IThrowableProxy */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/IThrowableProxy.class */
public interface IThrowableProxy {
    String getMessage();

    String getClassName();

    StackTraceElementProxy[] getStackTraceElementProxyArray();

    int getCommonFrames();

    IThrowableProxy getCause();

    IThrowableProxy[] getSuppressed();
}
