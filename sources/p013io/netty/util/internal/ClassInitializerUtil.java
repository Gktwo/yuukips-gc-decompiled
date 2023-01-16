package p013io.netty.util.internal;

/* renamed from: io.netty.util.internal.ClassInitializerUtil */
/* loaded from: grasscutter.jar:io/netty/util/internal/ClassInitializerUtil.class */
public final class ClassInitializerUtil {
    private ClassInitializerUtil() {
    }

    public static void tryLoadClasses(Class<?> loadingClass, Class<?>... classes) {
        ClassLoader loader = PlatformDependent.getClassLoader(loadingClass);
        for (Class<?> clazz : classes) {
            tryLoadClass(loader, clazz.getName());
        }
    }

    private static void tryLoadClass(ClassLoader classLoader, String className) {
        try {
            Class.forName(className, true, classLoader);
        } catch (ClassNotFoundException e) {
        } catch (SecurityException e2) {
        }
    }
}
