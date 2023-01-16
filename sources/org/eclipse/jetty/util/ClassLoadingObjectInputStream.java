package org.eclipse.jetty.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Proxy;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ClassLoadingObjectInputStream.class */
public class ClassLoadingObjectInputStream extends ObjectInputStream {
    private ThreadLocal<ClassLoader> _classloader = new ClassLoaderThreadLocal();

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ClassLoadingObjectInputStream$ClassLoaderThreadLocal.class */
    public static class ClassLoaderThreadLocal extends ThreadLocal<ClassLoader> {
        protected static final ClassLoader UNSET = new ClassLoader() { // from class: org.eclipse.jetty.util.ClassLoadingObjectInputStream.ClassLoaderThreadLocal.1
        };

        protected ClassLoaderThreadLocal() {
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ClassLoader initialValue() {
            return UNSET;
        }
    }

    public ClassLoadingObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    public ClassLoadingObjectInputStream() throws IOException {
    }

    public Object readObject(ClassLoader loader) throws IOException, ClassNotFoundException {
        try {
            this._classloader.set(loader);
            return readObject();
        } finally {
            this._classloader.set(ClassLoaderThreadLocal.UNSET);
        }
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass cl) throws IOException, ClassNotFoundException {
        try {
            ClassLoader loader = this._classloader.get();
            if (ClassLoaderThreadLocal.UNSET == loader) {
                loader = Thread.currentThread().getContextClassLoader();
            }
            return Class.forName(cl.getName(), false, loader);
        } catch (ClassNotFoundException e) {
            return resolveClass(cl);
        }
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveProxyClass(String[] interfaces) throws IOException, ClassNotFoundException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        ClassLoader nonPublicLoader = null;
        boolean hasNonPublicInterface = false;
        Class<?>[] classObjs = new Class[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            Class<?> cl = Class.forName(interfaces[i], false, loader);
            if ((cl.getModifiers() & 1) == 0) {
                if (!hasNonPublicInterface) {
                    nonPublicLoader = cl.getClassLoader();
                    hasNonPublicInterface = true;
                } else if (nonPublicLoader != cl.getClassLoader()) {
                    throw new IllegalAccessError("conflicting non-public interface class loaders");
                }
            }
            classObjs[i] = cl;
        }
        try {
            return Proxy.getProxyClass(hasNonPublicInterface ? nonPublicLoader : loader, classObjs);
        } catch (IllegalArgumentException e) {
            throw new ClassNotFoundException(null, e);
        }
    }
}
