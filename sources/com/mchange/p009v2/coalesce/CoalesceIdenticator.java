package com.mchange.p009v2.coalesce;

import com.mchange.p006v1.identicator.Identicator;

/* renamed from: com.mchange.v2.coalesce.CoalesceIdenticator */
/* loaded from: grasscutter.jar:com/mchange/v2/coalesce/CoalesceIdenticator.class */
class CoalesceIdenticator implements Identicator {

    /* renamed from: cc */
    CoalesceChecker f412cc;

    /* access modifiers changed from: package-private */
    public CoalesceIdenticator(CoalesceChecker coalesceChecker) {
        this.f412cc = coalesceChecker;
    }

    @Override // com.mchange.p006v1.identicator.Identicator
    public boolean identical(Object obj, Object obj2) {
        return this.f412cc.checkCoalesce(obj, obj2);
    }

    @Override // com.mchange.p006v1.identicator.Identicator
    public int hash(Object obj) {
        return this.f412cc.coalesceHash(obj);
    }
}
