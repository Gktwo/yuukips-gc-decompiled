package com.mchange.p009v2.coalesce;

import java.util.WeakHashMap;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.coalesce.WeakEqualsCoalescer */
/* loaded from: grasscutter.jar:com/mchange/v2/coalesce/WeakEqualsCoalescer.class */
public class WeakEqualsCoalescer extends AbstractWeakCoalescer {
    /* access modifiers changed from: package-private */
    public WeakEqualsCoalescer() {
        super(new WeakHashMap());
    }
}
