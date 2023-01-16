package org.eclipse.jetty.util.preventers;

import javax.imageio.ImageIO;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/preventers/AppContextLeakPreventer.class */
public class AppContextLeakPreventer extends AbstractLeakPreventer {
    @Override // org.eclipse.jetty.util.preventers.AbstractLeakPreventer
    public void prevent(ClassLoader loader) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Pinning classloader for AppContext.getContext() with " + loader, new Object[0]);
        }
        ImageIO.getUseCache();
    }
}
