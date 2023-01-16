package p013io.netty.handler.codec.serialization;

import java.util.Map;

/* renamed from: io.netty.handler.codec.serialization.CachingClassResolver */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/CachingClassResolver.class */
class CachingClassResolver implements ClassResolver {
    private final Map<String, Class<?>> classCache;
    private final ClassResolver delegate;

    /* access modifiers changed from: package-private */
    public CachingClassResolver(ClassResolver delegate, Map<String, Class<?>> classCache) {
        this.delegate = delegate;
        this.classCache = classCache;
    }

    @Override // p013io.netty.handler.codec.serialization.ClassResolver
    public Class<?> resolve(String className) throws ClassNotFoundException {
        Class<?> clazz = this.classCache.get(className);
        if (clazz != null) {
            return clazz;
        }
        Class<?> clazz2 = this.delegate.resolve(className);
        this.classCache.put(className, clazz2);
        return clazz2;
    }
}
