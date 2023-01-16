package org.eclipse.jetty.util.preventers;

import java.sql.DriverManager;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/preventers/DriverManagerLeakPreventer.class */
public class DriverManagerLeakPreventer extends AbstractLeakPreventer {
    @Override // org.eclipse.jetty.util.preventers.AbstractLeakPreventer
    public void prevent(ClassLoader loader) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Pinning DriverManager classloader with " + loader, new Object[0]);
        }
        DriverManager.getDrivers();
    }
}
