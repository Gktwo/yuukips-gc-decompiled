package org.eclipse.jetty.servlet.jmx;

import org.eclipse.jetty.jmx.ObjectMBean;
import org.eclipse.jetty.servlet.FilterMapping;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/jmx/FilterMappingMBean.class */
public class FilterMappingMBean extends ObjectMBean {
    public FilterMappingMBean(Object managedObject) {
        super(managedObject);
    }

    public String getObjectNameBasis() {
        String name;
        if (this._managed == null || !(this._managed instanceof FilterMapping) || (name = ((FilterMapping) this._managed).getFilterName()) == null) {
            return getObjectNameBasis();
        }
        return name;
    }
}
