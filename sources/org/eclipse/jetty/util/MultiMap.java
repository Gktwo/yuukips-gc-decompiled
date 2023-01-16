package org.eclipse.jetty.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/MultiMap.class */
public class MultiMap<V> extends LinkedHashMap<String, List<V>> {
    public MultiMap() {
    }

    public MultiMap(Map<String, List<V>> map) {
        super(map);
    }

    public MultiMap(MultiMap<V> map) {
        super(map);
    }

    public List<V> getValues(String name) {
        List<V> vals = (List) get(name);
        if (vals == null || vals.isEmpty()) {
            return null;
        }
        return vals;
    }

    public V getValue(String name, int i) {
        List<V> vals = getValues(name);
        if (vals == null) {
            return null;
        }
        if (i != 0 || !vals.isEmpty()) {
            return vals.get(i);
        }
        return null;
    }

    public String getString(String name) {
        List<V> vals = (List) get(name);
        if (vals == null || vals.isEmpty()) {
            return null;
        }
        if (vals.size() == 1) {
            return vals.get(0).toString();
        }
        StringBuilder values = new StringBuilder(128);
        for (V e : vals) {
            if (e != null) {
                if (values.length() > 0) {
                    values.append(',');
                }
                values.append(e.toString());
            }
        }
        return values.toString();
    }

    public List<V> put(String name, V value) {
        if (value == null) {
            return (List) put((MultiMap<V>) name, (String) null);
        }
        List<V> vals = new ArrayList<>();
        vals.add(value);
        return (List) put((Object) name, (Object) vals);
    }

    public void putAllValues(Map<String, V> input) {
        for (Map.Entry<String, V> entry : input.entrySet()) {
            put(entry.getKey(), (String) entry.getValue());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<V> */
    /* JADX WARN: Multi-variable type inference failed */
    public List<V> putValues(String name, List<V> values) {
        return (List) put((MultiMap<V>) name, (String) values);
    }

    @SafeVarargs
    public final List<V> putValues(String name, V... values) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(values));
        return (List) put((MultiMap<V>) name, (String) arrayList);
    }

    public void add(String name, V value) {
        List list = (List) get(name);
        if (list == null) {
            list = new ArrayList();
        }
        list.add(value);
        put((MultiMap<V>) name, (String) list);
    }

    public void addValues(String name, List<V> values) {
        List<V> lo = (List) get(name);
        if (lo == null) {
            lo = new ArrayList<>();
        }
        lo.addAll(values);
        put((Object) name, (Object) lo);
    }

    public void addValues(String name, V[] values) {
        List<V> lo = (List) get(name);
        if (lo == null) {
            lo = new ArrayList<>();
        }
        lo.addAll(Arrays.asList(values));
        put((Object) name, (Object) lo);
    }

    public boolean addAllValues(MultiMap<V> map) {
        boolean merged = false;
        if (map == null || map.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, V> entry : map.entrySet()) {
            String name = entry.getKey();
            List<V> values = (List) entry.getValue();
            if (containsKey(name)) {
                merged = true;
            }
            addValues(name, values);
        }
        return merged;
    }

    public boolean removeValue(String name, V value) {
        List<V> lo = (List) get(name);
        if (lo == null || lo.isEmpty()) {
            return false;
        }
        boolean ret = lo.remove(value);
        if (lo.isEmpty()) {
            remove(name);
        } else {
            put((Object) name, (Object) lo);
        }
        return ret;
    }

    public boolean containsSimpleValue(V value) {
        for (V vals : values()) {
            if (vals.size() == 1 && vals.contains(value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        boolean delim = false;
        for (Map.Entry<String, V> entry : entrySet()) {
            if (delim) {
                sb.append(", ");
            }
            String key = entry.getKey();
            List<V> vals = (List) entry.getValue();
            sb.append(key);
            sb.append('=');
            if (vals.size() == 1) {
                sb.append(vals.get(0));
            } else {
                sb.append(vals);
            }
            delim = true;
        }
        sb.append('}');
        return sb.toString();
    }

    public Map<String, String[]> toStringArrayMap() {
        Map<String, String[]> map = new LinkedHashMap<String, String[]>((size() * 3) / 2) { // from class: org.eclipse.jetty.util.MultiMap.1
            @Override // java.util.AbstractMap, java.lang.Object
            public String toString() {
                StringBuilder b = new StringBuilder();
                b.append('{');
                for (String k : keySet()) {
                    if (b.length() > 1) {
                        b.append(',');
                    }
                    b.append(k);
                    b.append('=');
                    b.append(Arrays.asList((String[]) get(k)));
                }
                b.append('}');
                return b.toString();
            }
        };
        for (Map.Entry<String, V> entry : entrySet()) {
            String[] a = null;
            if (entry.getValue() != null) {
                a = (String[]) ((List) entry.getValue()).toArray(new String[((List) entry.getValue()).size()]);
            }
            map.put(entry.getKey(), a);
        }
        return map;
    }
}
