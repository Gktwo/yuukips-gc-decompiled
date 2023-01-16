package org.eclipse.jetty.util.preventers;

import java.awt.Toolkit;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/preventers/AWTLeakPreventer.class */
public class AWTLeakPreventer extends AbstractLeakPreventer {
    @Override // org.eclipse.jetty.util.preventers.AbstractLeakPreventer
    public void prevent(ClassLoader loader) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Pinning classloader for java.awt.EventQueue using " + loader, new Object[0]);
        }
        Toolkit.getDefaultToolkit();
    }
}
