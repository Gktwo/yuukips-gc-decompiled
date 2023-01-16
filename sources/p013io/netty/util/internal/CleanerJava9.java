package p013io.netty.util.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.CleanerJava9 */
/* loaded from: grasscutter.jar:io/netty/util/internal/CleanerJava9.class */
public final class CleanerJava9 implements Cleaner {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(CleanerJava9.class);
    private static final Method INVOKE_CLEANER;

    static {
        Throwable error;
        Method method;
        if (PlatformDependent0.hasUnsafe()) {
            final ByteBuffer buffer = ByteBuffer.allocateDirect(1);
            Object maybeInvokeMethod = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.CleanerJava9.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Method m = PlatformDependent0.UNSAFE.getClass().getDeclaredMethod("invokeCleaner", ByteBuffer.class);
                        m.invoke(PlatformDependent0.UNSAFE, buffer);
                        return m;
                    } catch (IllegalAccessException e) {
                        return e;
                    } catch (NoSuchMethodException e2) {
                        return e2;
                    } catch (InvocationTargetException e3) {
                        return e3;
                    }
                }
            });
            if (maybeInvokeMethod instanceof Throwable) {
                method = null;
                error = (Throwable) maybeInvokeMethod;
            } else {
                method = (Method) maybeInvokeMethod;
                error = null;
            }
        } else {
            method = null;
            error = new UnsupportedOperationException("sun.misc.Unsafe unavailable");
        }
        if (error == null) {
            logger.debug("java.nio.ByteBuffer.cleaner(): available");
        } else {
            logger.debug("java.nio.ByteBuffer.cleaner(): unavailable", error);
        }
        INVOKE_CLEANER = method;
    }

    /* access modifiers changed from: package-private */
    public static boolean isSupported() {
        return INVOKE_CLEANER != null;
    }

    @Override // p013io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer buffer) {
        if (System.getSecurityManager() == null) {
            try {
                INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, buffer);
            } catch (Throwable cause) {
                PlatformDependent0.throwException(cause);
            }
        } else {
            freeDirectBufferPrivileged(buffer);
        }
    }

    private static void freeDirectBufferPrivileged(final ByteBuffer buffer) {
        Exception error = (Exception) AccessController.doPrivileged(new PrivilegedAction<Exception>() { // from class: io.netty.util.internal.CleanerJava9.2
            @Override // java.security.PrivilegedAction
            public Exception run() {
                try {
                    CleanerJava9.INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, buffer);
                    return null;
                } catch (IllegalAccessException e) {
                    return e;
                } catch (InvocationTargetException e2) {
                    return e2;
                }
            }
        });
        if (error != null) {
            PlatformDependent0.throwException(error);
        }
    }
}
