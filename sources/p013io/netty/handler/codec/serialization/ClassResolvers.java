package p013io.netty.handler.codec.serialization;

import java.util.HashMap;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.handler.codec.serialization.ClassResolvers */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/ClassResolvers.class */
public final class ClassResolvers {
    public static ClassResolver cacheDisabled(ClassLoader classLoader) {
        return new ClassLoaderClassResolver(defaultClassLoader(classLoader));
    }

    public static ClassResolver weakCachingResolver(ClassLoader classLoader) {
        return new CachingClassResolver(new ClassLoaderClassResolver(defaultClassLoader(classLoader)), new WeakReferenceMap(new HashMap()));
    }

    public static ClassResolver softCachingResolver(ClassLoader classLoader) {
        return new CachingClassResolver(new ClassLoaderClassResolver(defaultClassLoader(classLoader)), new SoftReferenceMap(new HashMap()));
    }

    public static ClassResolver weakCachingConcurrentResolver(ClassLoader classLoader) {
        return new CachingClassResolver(new ClassLoaderClassResolver(defaultClassLoader(classLoader)), new WeakReferenceMap(PlatformDependent.newConcurrentHashMap()));
    }

    public static ClassResolver softCachingConcurrentResolver(ClassLoader classLoader) {
        return new CachingClassResolver(new ClassLoaderClassResolver(defaultClassLoader(classLoader)), new SoftReferenceMap(PlatformDependent.newConcurrentHashMap()));
    }

    static ClassLoader defaultClassLoader(ClassLoader classLoader) {
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader contextClassLoader = PlatformDependent.getContextClassLoader();
        if (contextClassLoader != null) {
            return contextClassLoader;
        }
        return PlatformDependent.getClassLoader(ClassResolvers.class);
    }

    private ClassResolvers() {
    }
}
