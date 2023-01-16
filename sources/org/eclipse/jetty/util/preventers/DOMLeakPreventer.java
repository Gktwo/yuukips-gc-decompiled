package org.eclipse.jetty.util.preventers;

import javax.xml.parsers.DocumentBuilderFactory;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/preventers/DOMLeakPreventer.class */
public class DOMLeakPreventer extends AbstractLeakPreventer {
    @Override // org.eclipse.jetty.util.preventers.AbstractLeakPreventer
    public void prevent(ClassLoader loader) {
        try {
            DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (Exception e) {
            LOG.warn(e);
        }
    }
}
