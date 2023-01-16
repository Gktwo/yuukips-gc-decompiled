package org.eclipse.jetty.server;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/MultiPartCleanerListener.class */
public class MultiPartCleanerListener implements ServletRequestListener {
    public static final MultiPartCleanerListener INSTANCE = new MultiPartCleanerListener();

    protected MultiPartCleanerListener() {
    }

    @Override // javax.servlet.ServletRequestListener
    public void requestDestroyed(ServletRequestEvent sre) {
        MultiParts parts = (MultiParts) sre.getServletRequest().getAttribute(Request.MULTIPARTS);
        if (parts != null && parts.getContext() == sre.getServletContext()) {
            try {
                parts.close();
            } catch (Throwable e) {
                sre.getServletContext().log("Errors deleting multipart tmp files", e);
            }
        }
    }

    @Override // javax.servlet.ServletRequestListener
    public void requestInitialized(ServletRequestEvent sre) {
    }
}
