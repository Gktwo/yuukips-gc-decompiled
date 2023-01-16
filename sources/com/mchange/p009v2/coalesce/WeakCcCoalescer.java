package com.mchange.p009v2.coalesce;

import com.mchange.p006v1.identicator.IdWeakHashMap;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.coalesce.WeakCcCoalescer */
/* loaded from: grasscutter.jar:com/mchange/v2/coalesce/WeakCcCoalescer.class */
public final class WeakCcCoalescer extends AbstractWeakCoalescer implements Coalescer {
    /* access modifiers changed from: package-private */
    public WeakCcCoalescer(CoalesceChecker coalesceChecker) {
        super(new IdWeakHashMap(new CoalesceIdenticator(coalesceChecker)));
    }
}
