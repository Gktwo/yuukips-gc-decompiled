package com.mchange.p009v2.coalesce;

import com.mchange.p006v1.identicator.IdHashMap;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.coalesce.StrongCcCoalescer */
/* loaded from: grasscutter.jar:com/mchange/v2/coalesce/StrongCcCoalescer.class */
public final class StrongCcCoalescer extends AbstractStrongCoalescer implements Coalescer {
    /* access modifiers changed from: package-private */
    public StrongCcCoalescer(CoalesceChecker coalesceChecker) {
        super(new IdHashMap(new CoalesceIdenticator(coalesceChecker)));
    }
}
