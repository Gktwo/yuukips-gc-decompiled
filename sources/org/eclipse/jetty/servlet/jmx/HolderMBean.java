package org.eclipse.jetty.servlet.jmx;

import org.eclipse.jetty.jmx.ObjectMBean;
import org.eclipse.jetty.servlet.Holder;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/jmx/HolderMBean.class */
public class HolderMBean extends ObjectMBean {
    public HolderMBean(Object managedObject) {
        super(managedObject);
    }

    public String getObjectNameBasis() {
        String name;
        if (this._managed == null || !(this._managed instanceof Holder) || (name = ((Holder) this._managed).getName()) == null) {
            return getObjectNameBasis();
        }
        return name;
    }
}
