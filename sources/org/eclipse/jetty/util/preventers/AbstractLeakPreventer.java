package org.eclipse.jetty.util.preventers;

import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/preventers/AbstractLeakPreventer.class */
public abstract class AbstractLeakPreventer extends AbstractLifeCycle {
    protected static final Logger LOG = Log.getLogger(AbstractLeakPreventer.class);

    public abstract void prevent(ClassLoader classLoader);

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
            prevent(getClass().getClassLoader());
            doStart();
            Thread.currentThread().setContextClassLoader(loader);
        } catch (Throwable th) {
            Thread.currentThread().setContextClassLoader(loader);
            throw th;
        }
    }
}
