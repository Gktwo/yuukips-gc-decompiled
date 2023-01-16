package org.eclipse.jetty.server.handler.jmx;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.annotation.Name;

@ManagedObject("ContextHandler mbean wrapper")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/jmx/ContextHandlerMBean.class */
public class ContextHandlerMBean extends AbstractHandlerMBean {
    public ContextHandlerMBean(Object managedObject) {
        super(managedObject);
    }

    @ManagedAttribute("Map of context attributes")
    public Map<String, Object> getContextAttributes() {
        Map<String, Object> map = new HashMap<>();
        Attributes attrs = ((ContextHandler) this._managed).getAttributes();
        for (String name : attrs.getAttributeNameSet()) {
            map.put(name, attrs.getAttribute(name));
        }
        return map;
    }

    @ManagedOperation(value = "Set context attribute", impact = "ACTION")
    public void setContextAttribute(@Name(value = "name", description = "attribute name") String name, @Name(value = "value", description = "attribute value") Object value) {
        ((ContextHandler) this._managed).getAttributes().setAttribute(name, value);
    }

    @ManagedOperation(value = "Set context attribute", impact = "ACTION")
    public void setContextAttribute(@Name(value = "name", description = "attribute name") String name, @Name(value = "value", description = "attribute value") String value) {
        ((ContextHandler) this._managed).getAttributes().setAttribute(name, value);
    }

    @ManagedOperation(value = "Remove context attribute", impact = "ACTION")
    public void removeContextAttribute(@Name(value = "name", description = "attribute name") String name) {
        ((ContextHandler) this._managed).getAttributes().removeAttribute(name);
    }
}
