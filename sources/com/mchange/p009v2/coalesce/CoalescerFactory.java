package com.mchange.p009v2.coalesce;

/* renamed from: com.mchange.v2.coalesce.CoalescerFactory */
/* loaded from: grasscutter.jar:com/mchange/v2/coalesce/CoalescerFactory.class */
public final class CoalescerFactory {
    public static Coalescer createCoalescer() {
        return createCoalescer(true, true);
    }

    public static Coalescer createCoalescer(boolean z, boolean z2) {
        return createCoalescer(null, z, z2);
    }

    public static Coalescer createCoalescer(CoalesceChecker coalesceChecker, boolean z, boolean z2) {
        Coalescer coalescer;
        if (coalesceChecker == null) {
            coalescer = z ? new WeakEqualsCoalescer() : new StrongEqualsCoalescer();
        } else {
            coalescer = z ? new WeakCcCoalescer(coalesceChecker) : new StrongCcCoalescer(coalesceChecker);
        }
        return z2 ? new SyncedCoalescer(coalescer) : coalescer;
    }
}
