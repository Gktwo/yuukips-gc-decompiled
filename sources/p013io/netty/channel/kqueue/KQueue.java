package p013io.netty.channel.kqueue;

import p013io.netty.channel.unix.FileDescriptor;
import p013io.netty.util.internal.SystemPropertyUtil;

/* renamed from: io.netty.channel.kqueue.KQueue */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueue.class */
public final class KQueue {
    private static final Throwable UNAVAILABILITY_CAUSE;

    static {
        Throwable cause = null;
        if (SystemPropertyUtil.getBoolean("io.netty.transport.noNative", false)) {
            cause = new UnsupportedOperationException("Native transport was explicit disabled with -Dio.netty.transport.noNative=true");
        } else {
            FileDescriptor kqueueFd = null;
            try {
                kqueueFd = Native.newKQueue();
                if (kqueueFd != null) {
                    try {
                        kqueueFd.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Throwable th) {
                if (kqueueFd != null) {
                    try {
                        kqueueFd.close();
                    } catch (Exception e2) {
                    }
                }
                throw th;
            }
        }
        UNAVAILABILITY_CAUSE = cause;
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static void ensureAvailability() {
        if (UNAVAILABILITY_CAUSE != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(UNAVAILABILITY_CAUSE));
        }
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    public static boolean isTcpFastOpenClientSideAvailable() {
        return isAvailable() && Native.IS_SUPPORTING_TCP_FASTOPEN_CLIENT;
    }

    public static boolean isTcpFastOpenServerSideAvailable() {
        return isAvailable() && Native.IS_SUPPORTING_TCP_FASTOPEN_SERVER;
    }

    private KQueue() {
    }
}
