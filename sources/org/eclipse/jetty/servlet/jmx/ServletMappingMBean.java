package org.eclipse.jetty.servlet.jmx;

import org.eclipse.jetty.jmx.ObjectMBean;
import org.eclipse.jetty.servlet.ServletMapping;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/jmx/ServletMappingMBean.class */
public class ServletMappingMBean extends ObjectMBean {
    public ServletMappingMBean(Object managedObject) {
        super(managedObject);
    }

    public String getObjectNameBasis() {
        String name;
        if (this._managed == null || !(this._managed instanceof ServletMapping) || (name = ((ServletMapping) this._managed).getServletName()) == null) {
            return getObjectNameBasis();
        }
        return name;
    }
}
