package com.mchange.p006v1.identicator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.mchange.v1.identicator.IdHashMap */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/IdHashMap.class */
public final class IdHashMap extends IdMap implements Map {
    @Override // com.mchange.p006v1.identicator.IdMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // com.mchange.p006v1.identicator.IdMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return remove(obj);
    }

    @Override // com.mchange.p006v1.identicator.IdMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return get(obj);
    }

    @Override // com.mchange.p006v1.identicator.IdMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return containsKey(obj);
    }

    @Override // com.mchange.p006v1.identicator.IdMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put(obj, obj2);
    }

    public IdHashMap(Identicator identicator) {
        super(new HashMap(), identicator);
    }

    @Override // com.mchange.p006v1.identicator.IdMap
    protected IdHashKey createIdKey(Object obj) {
        return new StrongIdHashKey(obj, this.f382id);
    }
}
