package org.eclipse.jetty.util.component;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.jetty.util.Attributes;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/AttributeContainerMap.class */
public class AttributeContainerMap extends ContainerLifeCycle implements Attributes {
    private final Map<String, Object> _map = new HashMap();

    @Override // org.eclipse.jetty.util.Attributes
    public synchronized void setAttribute(String name, Object attribute) {
        updateBean(this._map.put(name, attribute), attribute);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public synchronized void removeAttribute(String name) {
        Object removed = this._map.remove(name);
        if (removed != null) {
            removeBean(removed);
        }
    }

    @Override // org.eclipse.jetty.util.Attributes
    public synchronized Object getAttribute(String name) {
        return this._map.get(name);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public synchronized Enumeration<String> getAttributeNames() {
        return Collections.enumeration(this._map.keySet());
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Set<String> getAttributeNameSet() {
        return this._map.keySet();
    }

    @Override // org.eclipse.jetty.util.Attributes
    public synchronized void clearAttributes() {
        this._map.clear();
        removeBeans();
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObject(out, this);
        Dumpable.dumpMapEntries(out, indent, this._map, true);
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x{size=%d}", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(this._map.size()));
    }
}
