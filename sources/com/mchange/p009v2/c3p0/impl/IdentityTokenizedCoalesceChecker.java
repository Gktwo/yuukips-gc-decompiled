package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.coalesce.CoalesceChecker;

/* renamed from: com.mchange.v2.c3p0.impl.IdentityTokenizedCoalesceChecker */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/IdentityTokenizedCoalesceChecker.class */
public final class IdentityTokenizedCoalesceChecker implements CoalesceChecker {
    public static IdentityTokenizedCoalesceChecker INSTANCE = new IdentityTokenizedCoalesceChecker();

    @Override // com.mchange.p009v2.coalesce.CoalesceChecker
    public boolean checkCoalesce(Object a, Object b) {
        String ta = ((IdentityTokenized) a).getIdentityToken();
        String tb = ((IdentityTokenized) b).getIdentityToken();
        if (ta != null && tb != null) {
            return ta.equals(tb);
        }
        throw new NullPointerException("[c3p0 bug] An IdentityTokenized object has no identity token set?!?! " + (ta == null ? ta : tb));
    }

    @Override // com.mchange.p009v2.coalesce.CoalesceChecker
    public int coalesceHash(Object a) {
        String t = ((IdentityTokenized) a).getIdentityToken();
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    private IdentityTokenizedCoalesceChecker() {
    }
}
