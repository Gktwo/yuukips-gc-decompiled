package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: grasscutter.jar:com/google/protobuf/MapFieldLite.class */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {
    private boolean isMutable = true;
    private static final MapFieldLite EMPTY_MAP_FIELD = new MapFieldLite();

    private MapFieldLite() {
    }

    private MapFieldLite(Map<K, V> mapData) {
        super(mapData);
    }

    static {
        EMPTY_MAP_FIELD.makeImmutable();
    }

    public static <K, V> MapFieldLite<K, V> emptyMapField() {
        return EMPTY_MAP_FIELD;
    }

    public void mergeFrom(MapFieldLite<K, V> other) {
        ensureMutable();
        if (!other.isEmpty()) {
            putAll(other);
        }
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : entrySet();
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public void clear() {
        ensureMutable();
        clear();
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public V put(K key, V value) {
        ensureMutable();
        Internal.checkNotNull(key);
        Internal.checkNotNull(value);
        return put(key, value);
    }

    public V put(Map.Entry<K, V> entry) {
        return put(entry.getKey(), entry.getValue());
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public void putAll(Map<? extends K, ? extends V> m) {
        ensureMutable();
        checkForNullKeysAndValues(m);
        putAll(m);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public V remove(Object key) {
        ensureMutable();
        return remove(key);
    }

    private static void checkForNullKeysAndValues(Map<?, ?> m) {
        for (Object key : m.keySet()) {
            Internal.checkNotNull(key);
            Internal.checkNotNull(m.get(key));
        }
    }

    private static boolean equals(Object a, Object b) {
        if (!(a instanceof byte[]) || !(b instanceof byte[])) {
            return a.equals(b);
        }
        return Arrays.equals((byte[]) a, (byte[]) b);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K, V> boolean equals(java.util.Map<K, V> r4, java.util.Map<K, V> r5) {
        /*
            r0 = r4
            r1 = r5
            if (r0 != r1) goto L_0x0007
            r0 = 1
            return r0
        L_0x0007:
            r0 = r4
            int r0 = r0.size()
            r1 = r5
            int r1 = r1.size()
            if (r0 == r1) goto L_0x0018
            r0 = 0
            return r0
        L_0x0018:
            r0 = r4
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r6 = r0
        L_0x0024:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0065
            r0 = r6
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r7 = r0
            r0 = r5
            r1 = r7
            java.lang.Object r1 = r1.getKey()
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x0048
            r0 = 0
            return r0
        L_0x0048:
            r0 = r7
            java.lang.Object r0 = r0.getValue()
            r1 = r5
            r2 = r7
            java.lang.Object r2 = r2.getKey()
            java.lang.Object r1 = r1.get(r2)
            boolean r0 = equals(r0, r1)
            if (r0 != 0) goto L_0x0062
            r0 = 0
            return r0
        L_0x0062:
            goto L_0x0024
        L_0x0065:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MapFieldLite.equals(java.util.Map, java.util.Map):boolean");
    }

    @Override // java.util.AbstractMap, java.util.Map, java.lang.Object
    public boolean equals(Object object) {
        return (object instanceof Map) && equals((Map) this, (Map) object);
    }

    private static int calculateHashCodeForObject(Object a) {
        if (a instanceof byte[]) {
            return Internal.hashCode((byte[]) a);
        }
        if (!(a instanceof Internal.EnumLite)) {
            return a.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public static <K, V> int calculateHashCodeForMap(Map<K, V> a) {
        int result = 0;
        for (Map.Entry<K, V> entry : a.entrySet()) {
            result += calculateHashCodeForObject(entry.getKey()) ^ calculateHashCodeForObject(entry.getValue());
        }
        return result;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.lang.Object
    public int hashCode() {
        return calculateHashCodeForMap(this);
    }

    private static Object copy(Object object) {
        if (!(object instanceof byte[])) {
            return object;
        }
        byte[] data = (byte[]) object;
        return Arrays.copyOf(data, data.length);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public static <K, V> Map<K, V> copy(Map<K, V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), copy(entry.getValue()));
        }
        return linkedHashMap;
    }

    public MapFieldLite<K, V> mutableCopy() {
        return isEmpty() ? new MapFieldLite<>() : new MapFieldLite<>(this);
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    private void ensureMutable() {
        if (!isMutable()) {
            throw new UnsupportedOperationException();
        }
    }
}
