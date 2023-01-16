package org.eclipse.jetty.util.thread;

import java.io.Closeable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ThreadClassLoaderScope.class */
public class ThreadClassLoaderScope implements Closeable {
    private final ClassLoader old = Thread.currentThread().getContextClassLoader();
    private final ClassLoader scopedClassLoader;

    public ThreadClassLoaderScope(ClassLoader cl) {
        this.scopedClassLoader = cl;
        Thread.currentThread().setContextClassLoader(this.scopedClassLoader);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Thread.currentThread().setContextClassLoader(this.old);
    }

    public ClassLoader getScopedClassLoader() {
        return this.scopedClassLoader;
    }
}
