package p013io.netty.channel;

import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SuppressJava6Requirement;
import p013io.netty.util.internal.ThrowableUtil;

/* renamed from: io.netty.channel.ChannelException */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelException.class */
public class ChannelException extends RuntimeException {
    private static final long serialVersionUID = 2908618315971075004L;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ChannelException.class.desiredAssertionStatus();
    }

    public ChannelException() {
    }

    public ChannelException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChannelException(String message) {
        super(message);
    }

    public ChannelException(Throwable cause) {
        super(cause);
    }

    /* access modifiers changed from: protected */
    @SuppressJava6Requirement(reason = "uses Java 7+ RuntimeException.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
    public ChannelException(String message, Throwable cause, boolean shared) {
        super(message, cause, false, true);
        if (!$assertionsDisabled && !shared) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public static ChannelException newStatic(String message, Class<?> clazz, String method) {
        ChannelException exception;
        if (PlatformDependent.javaVersion() >= 7) {
            exception = new StacklessChannelException(message, null, true);
        } else {
            exception = new StacklessChannelException(message, null);
        }
        return (ChannelException) ThrowableUtil.unknownStackTrace(exception, clazz, method);
    }

    /* renamed from: io.netty.channel.ChannelException$StacklessChannelException */
    /* loaded from: grasscutter.jar:io/netty/channel/ChannelException$StacklessChannelException.class */
    private static final class StacklessChannelException extends ChannelException {
        private static final long serialVersionUID = -6384642137753538579L;

        StacklessChannelException(String message, Throwable cause) {
            super(message, cause);
        }

        StacklessChannelException(String message, Throwable cause, boolean shared) {
            super(message, cause, shared);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }
}
