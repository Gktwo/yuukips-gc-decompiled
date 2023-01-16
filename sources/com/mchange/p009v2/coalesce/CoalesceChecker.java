package com.mchange.p009v2.coalesce;

/* renamed from: com.mchange.v2.coalesce.CoalesceChecker */
/* loaded from: grasscutter.jar:com/mchange/v2/coalesce/CoalesceChecker.class */
public interface CoalesceChecker {
    boolean checkCoalesce(Object obj, Object obj2);

    int coalesceHash(Object obj);
}
