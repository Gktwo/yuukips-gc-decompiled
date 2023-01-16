package com.mchange.util;

/* loaded from: grasscutter.jar:com/mchange/util/IntChecklist.class */
public interface IntChecklist {
    void check(int i);

    void uncheck(int i);

    boolean isChecked(int i);

    void clear();

    int countChecked();

    int[] getChecked();

    IntEnumeration checked();
}
