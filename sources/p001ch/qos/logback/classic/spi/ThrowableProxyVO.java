package p001ch.qos.logback.classic.spi;

import java.io.Serializable;
import java.util.Arrays;

/* renamed from: ch.qos.logback.classic.spi.ThrowableProxyVO */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/ThrowableProxyVO.class */
public class ThrowableProxyVO implements IThrowableProxy, Serializable {
    private static final long serialVersionUID = -773438177285807139L;
    private String className;
    private String message;
    private int commonFramesCount;
    private StackTraceElementProxy[] stackTraceElementProxyArray;
    private IThrowableProxy cause;
    private IThrowableProxy[] suppressed;

    @Override // p001ch.qos.logback.classic.spi.IThrowableProxy
    public String getMessage() {
        return this.message;
    }

    @Override // p001ch.qos.logback.classic.spi.IThrowableProxy
    public String getClassName() {
        return this.className;
    }

    @Override // p001ch.qos.logback.classic.spi.IThrowableProxy
    public int getCommonFrames() {
        return this.commonFramesCount;
    }

    @Override // p001ch.qos.logback.classic.spi.IThrowableProxy
    public IThrowableProxy getCause() {
        return this.cause;
    }

    @Override // p001ch.qos.logback.classic.spi.IThrowableProxy
    public StackTraceElementProxy[] getStackTraceElementProxyArray() {
        return this.stackTraceElementProxyArray;
    }

    @Override // p001ch.qos.logback.classic.spi.IThrowableProxy
    public IThrowableProxy[] getSuppressed() {
        return this.suppressed;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * 1) + (this.className == null ? 0 : this.className.hashCode());
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ThrowableProxyVO other = (ThrowableProxyVO) obj;
        if (this.className == null) {
            if (other.className != null) {
                return false;
            }
        } else if (!this.className.equals(other.className)) {
            return false;
        }
        if (!Arrays.equals(this.stackTraceElementProxyArray, other.stackTraceElementProxyArray) || !Arrays.equals(this.suppressed, other.suppressed)) {
            return false;
        }
        if (this.cause == null) {
            if (other.cause != null) {
                return false;
            }
            return true;
        } else if (!this.cause.equals(other.cause)) {
            return false;
        } else {
            return true;
        }
    }

    public static ThrowableProxyVO build(IThrowableProxy throwableProxy) {
        if (throwableProxy == null) {
            return null;
        }
        ThrowableProxyVO tpvo = new ThrowableProxyVO();
        tpvo.className = throwableProxy.getClassName();
        tpvo.message = throwableProxy.getMessage();
        tpvo.commonFramesCount = throwableProxy.getCommonFrames();
        tpvo.stackTraceElementProxyArray = throwableProxy.getStackTraceElementProxyArray();
        IThrowableProxy cause = throwableProxy.getCause();
        if (cause != null) {
            tpvo.cause = build(cause);
        }
        IThrowableProxy[] suppressed = throwableProxy.getSuppressed();
        if (suppressed != null) {
            tpvo.suppressed = new IThrowableProxy[suppressed.length];
            for (int i = 0; i < suppressed.length; i++) {
                tpvo.suppressed[i] = build(suppressed[i]);
            }
        }
        return tpvo;
    }
}
