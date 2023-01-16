package p013io.netty.handler.codec.compression;

import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.codec.compression.Zstd */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Zstd.class */
public final class Zstd {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Zstd.class);
    private static final Throwable cause;

    static {
        Throwable t = null;
        try {
            Class.forName("com.github.luben.zstd.Zstd", false, PlatformDependent.getClassLoader(Zstd.class));
        } catch (ClassNotFoundException e) {
            t = e;
            logger.debug("zstd-jni not in the classpath; Zstd support will be unavailable.");
        } catch (Throwable e2) {
            t = e2;
            logger.debug("Failed to load zstd-jni; Zstd support will be unavailable.", t);
        }
        cause = t;
    }

    public static boolean isAvailable() {
        return cause == null;
    }

    public static void ensureAvailability() throws Throwable {
        if (cause != null) {
            throw cause;
        }
    }

    public static Throwable cause() {
        return cause;
    }

    private Zstd() {
    }
}
