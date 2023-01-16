package org.eclipse.jetty.util.preventers;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/preventers/Java2DLeakPreventer.class */
public class Java2DLeakPreventer extends AbstractLeakPreventer {
    @Override // org.eclipse.jetty.util.preventers.AbstractLeakPreventer
    public void prevent(ClassLoader loader) {
        try {
            Class.forName("sun.java2d.Disposer", true, loader);
        } catch (ClassNotFoundException e) {
            LOG.ignore(e);
        }
    }
}
