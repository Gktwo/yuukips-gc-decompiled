package p013io.netty.util.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.CleanerJava6 */
/* loaded from: grasscutter.jar:io/netty/util/internal/CleanerJava6.class */
public final class CleanerJava6 implements Cleaner {
    private static final long CLEANER_FIELD_OFFSET;
    private static final Method CLEAN_METHOD;
    private static final Field CLEANER_FIELD;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(CleanerJava6.class);

    /* JADX WARN: Type inference failed for: r0v31, types: [long] */
    static {
        Field cleanerField;
        Method clean;
        char c;
        Object mayBeCleanerField;
        Object cleaner;
        Throwable error = null;
        final ByteBuffer direct = ByteBuffer.allocateDirect(1);
        try {
            mayBeCleanerField = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.CleanerJava6.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Field cleanerField2 = direct.getClass().getDeclaredField("cleaner");
                        if (!PlatformDependent.hasUnsafe()) {
                            cleanerField2.setAccessible(true);
                        }
                        return cleanerField2;
                    } catch (Throwable cause) {
                        return cause;
                    }
                }
            });
        } catch (Throwable t) {
            c = 65535;
            clean = null;
            error = t;
            cleanerField = null;
        }
        if (mayBeCleanerField instanceof Throwable) {
            throw ((Throwable) mayBeCleanerField);
        }
        cleanerField = (Field) mayBeCleanerField;
        if (PlatformDependent.hasUnsafe()) {
            c = PlatformDependent0.objectFieldOffset(cleanerField);
            cleaner = PlatformDependent0.getObject(direct, c);
        } else {
            c = 65535;
            cleaner = cleanerField.get(direct);
        }
        clean = cleaner.getClass().getDeclaredMethod("clean", new Class[0]);
        clean.invoke(cleaner, new Object[0]);
        if (error == null) {
            logger.debug("java.nio.ByteBuffer.cleaner(): available");
        } else {
            logger.debug("java.nio.ByteBuffer.cleaner(): unavailable", error);
        }
        CLEANER_FIELD = cleanerField;
        CLEANER_FIELD_OFFSET = c;
        CLEAN_METHOD = clean;
    }

    /* access modifiers changed from: package-private */
    public static boolean isSupported() {
        return (CLEANER_FIELD_OFFSET == -1 && CLEANER_FIELD == null) ? false : true;
    }

    @Override // p013io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer buffer) {
        if (buffer.isDirect()) {
            if (System.getSecurityManager() == null) {
                try {
                    freeDirectBuffer0(buffer);
                } catch (Throwable cause) {
                    PlatformDependent0.throwException(cause);
                }
            } else {
                freeDirectBufferPrivileged(buffer);
            }
        }
    }

    private static void freeDirectBufferPrivileged(final ByteBuffer buffer) {
        Throwable cause = (Throwable) AccessController.doPrivileged(new PrivilegedAction<Throwable>() { // from class: io.netty.util.internal.CleanerJava6.2
            @Override // java.security.PrivilegedAction
            public Throwable run() {
                try {
                    CleanerJava6.freeDirectBuffer0(buffer);
                    return null;
                } catch (Throwable cause2) {
                    return cause2;
                }
            }
        });
        if (cause != null) {
            PlatformDependent0.throwException(cause);
        }
    }

    /* access modifiers changed from: private */
    public static void freeDirectBuffer0(ByteBuffer buffer) throws Exception {
        Object cleaner;
        if (CLEANER_FIELD_OFFSET == -1) {
            cleaner = CLEANER_FIELD.get(buffer);
        } else {
            cleaner = PlatformDependent0.getObject(buffer, CLEANER_FIELD_OFFSET);
        }
        if (cleaner != null) {
            CLEAN_METHOD.invoke(cleaner, new Object[0]);
        }
    }
}
