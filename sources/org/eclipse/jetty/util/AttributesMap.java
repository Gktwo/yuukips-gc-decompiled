package org.eclipse.jetty.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.util.component.Dumpable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/AttributesMap.class */
public class AttributesMap implements Attributes, Dumpable {
    private final AtomicReference<ConcurrentMap<String, Object>> _map = new AtomicReference<>();

    public AttributesMap() {
    }

    public AttributesMap(AttributesMap attributes) {
        ConcurrentMap<String, Object> map = attributes.map();
        if (map != null) {
            this._map.set(new ConcurrentHashMap(map));
        }
    }

    private ConcurrentMap<String, Object> map() {
        return this._map.get();
    }

    private ConcurrentMap<String, Object> ensureMap() {
        ConcurrentMap<String, Object> map;
        do {
            ConcurrentMap<String, Object> map2 = map();
            if (map2 != null) {
                return map2;
            }
            map = new ConcurrentHashMap<>();
        } while (!this._map.compareAndSet(null, map));
        return map;
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void removeAttribute(String name) {
        Map<String, Object> map = map();
        if (map != null) {
            map.remove(name);
        }
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void setAttribute(String name, Object attribute) {
        if (attribute == null) {
            removeAttribute(name);
        } else {
            ensureMap().put(name, attribute);
        }
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Object getAttribute(String name) {
        Map<String, Object> map = map();
        if (map == null) {
            return null;
        }
        return map.get(name);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Enumeration<String> getAttributeNames() {
        return Collections.enumeration(getAttributeNameSet());
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Set<String> getAttributeNameSet() {
        return keySet();
    }

    public Set<Map.Entry<String, Object>> getAttributeEntrySet() {
        Map<String, Object> map = map();
        return map == null ? Collections.emptySet() : map.entrySet();
    }

    public static Enumeration<String> getAttributeNamesCopy(Attributes attrs) {
        if (attrs instanceof AttributesMap) {
            return Collections.enumeration(((AttributesMap) attrs).keySet());
        }
        return Collections.enumeration(new ArrayList<>(Collections.list(attrs.getAttributeNames())));
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void clearAttributes() {
        Map<String, Object> map = map();
        if (map != null) {
            map.clear();
        }
    }

    public int size() {
        Map<String, Object> map = map();
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public String toString() {
        Map<String, Object> map = map();
        return map == null ? "{}" : map.toString();
    }

    private Set<String> keySet() {
        Map<String, Object> map = map();
        return map == null ? Collections.emptySet() : map.keySet();
    }

    public void addAll(Attributes attributes) {
        Enumeration<String> e = attributes.getAttributeNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            setAttribute(name, attributes.getAttribute(name));
        }
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return Dumpable.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObjects(out, indent, String.format("%s@%x", getClass().getSimpleName(), Integer.valueOf(hashCode())), map());
    }
}
