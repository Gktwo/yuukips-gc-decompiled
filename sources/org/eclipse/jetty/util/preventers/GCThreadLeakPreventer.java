package org.eclipse.jetty.util.preventers;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/preventers/GCThreadLeakPreventer.class */
public class GCThreadLeakPreventer extends AbstractLeakPreventer {
    @Override // org.eclipse.jetty.util.preventers.AbstractLeakPreventer
    public void prevent(ClassLoader loader) {
        try {
            Class.forName("sun.misc.GC").getMethod("requestLatency", Long.TYPE).invoke(null, 9223372036854775806L);
        } catch (ClassNotFoundException e) {
            LOG.ignore(e);
        } catch (Exception e2) {
            LOG.warn(e2);
        }
    }
}
