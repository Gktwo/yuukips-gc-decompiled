package org.eclipse.jetty.util.thread;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.function.Supplier;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/PrivilegedThreadFactory.class */
class PrivilegedThreadFactory {
    PrivilegedThreadFactory() {
    }

    /* access modifiers changed from: package-private */
    public static <T extends Thread> T newThread(final Supplier<T> newThreadSupplier) {
        return (T) ((Thread) AccessController.doPrivileged(new PrivilegedAction<T>() { // from class: org.eclipse.jetty.util.thread.PrivilegedThreadFactory.1
            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // java.security.PrivilegedAction
            public Thread run() {
                return (Thread) newThreadSupplier.get();
            }
        }));
    }
}
