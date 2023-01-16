package p013io.netty.util.internal;

import java.lang.reflect.AccessibleObject;

/* renamed from: io.netty.util.internal.ReflectionUtil */
/* loaded from: grasscutter.jar:io/netty/util/internal/ReflectionUtil.class */
public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    public static Throwable trySetAccessible(AccessibleObject object, boolean checkAccessible) {
        if (checkAccessible && !PlatformDependent0.isExplicitTryReflectionSetAccessible()) {
            return new UnsupportedOperationException("Reflective setAccessible(true) disabled");
        }
        try {
            object.setAccessible(true);
            return null;
        } catch (SecurityException e) {
            return e;
        } catch (RuntimeException e2) {
            return handleInaccessibleObjectException(e2);
        }
    }

    private static RuntimeException handleInaccessibleObjectException(RuntimeException e) {
        if ("java.lang.reflect.InaccessibleObjectException".equals(e.getClass().getName())) {
            return e;
        }
        throw e;
    }
}
