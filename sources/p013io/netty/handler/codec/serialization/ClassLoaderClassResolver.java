package p013io.netty.handler.codec.serialization;

/* renamed from: io.netty.handler.codec.serialization.ClassLoaderClassResolver */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/ClassLoaderClassResolver.class */
class ClassLoaderClassResolver implements ClassResolver {
    private final ClassLoader classLoader;

    /* access modifiers changed from: package-private */
    public ClassLoaderClassResolver(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override // p013io.netty.handler.codec.serialization.ClassResolver
    public Class<?> resolve(String className) throws ClassNotFoundException {
        try {
            return this.classLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            return Class.forName(className, false, this.classLoader);
        }
    }
}
