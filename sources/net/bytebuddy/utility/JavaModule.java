package net.bytebuddy.utility;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.AnnotatedElement;
import java.security.AccessController;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

/* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaModule.class */
public class JavaModule implements NamedElement.WithOptionalName, AnnotationSource {
    public static final JavaModule UNSUPPORTED = null;
    protected static final Resolver RESOLVER = (Resolver) AccessController.doPrivileged(JavaDispatcher.m62of(Resolver.class));
    protected static final Module MODULE = (Module) AccessController.doPrivileged(JavaDispatcher.m62of(Module.class));
    private final AnnotatedElement module;

    /* access modifiers changed from: protected */
    @JavaDispatcher.Proxied("java.lang.Module")
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaModule$Module.class */
    public interface Module {
        @JavaDispatcher.Instance
        boolean isInstance(Object obj);

        boolean isNamed(Object obj);

        String getName(Object obj);

        InputStream getResourceAsStream(Object obj, String str) throws IOException;

        ClassLoader getClassLoader(Object obj);

        boolean isExported(Object obj, String str, @JavaDispatcher.Proxied("java.lang.Module") Object obj2);

        boolean isOpen(Object obj, String str, @JavaDispatcher.Proxied("java.lang.Module") Object obj2);

        boolean canRead(Object obj, @JavaDispatcher.Proxied("java.lang.Module") Object obj2);
    }

    /* access modifiers changed from: protected */
    @JavaDispatcher.Proxied("java.lang.Class")
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaModule$Resolver.class */
    public interface Resolver {
        @JavaDispatcher.Defaults
        Object getModule(Class<?> cls);
    }

    protected JavaModule(AnnotatedElement module) {
        this.module = module;
    }

    public static JavaModule ofType(Class<?> type) {
        Object module = RESOLVER.getModule(type);
        return module == null ? UNSUPPORTED : new JavaModule((AnnotatedElement) module);
    }

    /* renamed from: of */
    public static JavaModule m64of(Object module) {
        if (MODULE.isInstance(module)) {
            return new JavaModule((AnnotatedElement) module);
        }
        throw new IllegalArgumentException("Not a Java module: " + module);
    }

    public static boolean isSupported() {
        return ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V9);
    }

    @Override // net.bytebuddy.description.NamedElement.WithOptionalName
    public boolean isNamed() {
        return MODULE.isNamed(this.module);
    }

    @Override // net.bytebuddy.description.NamedElement
    public String getActualName() {
        return MODULE.getName(this.module);
    }

    public InputStream getResourceAsStream(String name) throws IOException {
        return MODULE.getResourceAsStream(this.module, name);
    }

    public ClassLoader getClassLoader() {
        return MODULE.getClassLoader(this.module);
    }

    public Object unwrap() {
        return this.module;
    }

    public boolean canRead(JavaModule module) {
        return MODULE.canRead(this.module, module.unwrap());
    }

    public boolean isExported(PackageDescription packageDescription, JavaModule module) {
        return packageDescription == null || MODULE.isExported(this.module, packageDescription.getName(), module.unwrap());
    }

    public boolean isOpened(PackageDescription packageDescription, JavaModule module) {
        return packageDescription == null || MODULE.isOpen(this.module, packageDescription.getName(), module.unwrap());
    }

    @Override // net.bytebuddy.description.annotation.AnnotationSource
    public AnnotationList getDeclaredAnnotations() {
        return new AnnotationList.ForLoadedAnnotations(this.module.getDeclaredAnnotations());
    }

    public int hashCode() {
        return this.module.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JavaModule)) {
            return false;
        }
        return this.module.equals(((JavaModule) other).module);
    }

    public String toString() {
        return this.module.toString();
    }
}
