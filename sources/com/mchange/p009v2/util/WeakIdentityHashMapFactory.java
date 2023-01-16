package com.mchange.p009v2.util;

import com.mchange.p006v1.identicator.IdWeakHashMap;
import com.mchange.p006v1.identicator.StrongIdentityIdenticator;
import java.util.Map;

/* renamed from: com.mchange.v2.util.WeakIdentityHashMapFactory */
/* loaded from: grasscutter.jar:com/mchange/v2/util/WeakIdentityHashMapFactory.class */
public final class WeakIdentityHashMapFactory {
    public static Map create() {
        return new IdWeakHashMap(new StrongIdentityIdenticator());
    }
}
