package com.mchange.p009v2.coalesce;

import java.util.Iterator;

/* renamed from: com.mchange.v2.coalesce.Coalescer */
/* loaded from: grasscutter.jar:com/mchange/v2/coalesce/Coalescer.class */
public interface Coalescer {
    Object coalesce(Object obj);

    int countCoalesced();

    Iterator iterator();
}
