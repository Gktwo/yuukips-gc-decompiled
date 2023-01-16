package com.mchange.util.impl;

import com.mchange.util.IntChecklist;
import com.mchange.util.IntEnumeration;

/* loaded from: grasscutter.jar:com/mchange/util/impl/HashIntChecklist.class */
public class HashIntChecklist implements IntChecklist {
    private static final Object DUMMY = new Object();
    IntObjectHash ioh = new IntObjectHash();

    @Override // com.mchange.util.IntChecklist
    public void check(int i) {
        this.ioh.put(i, DUMMY);
    }

    @Override // com.mchange.util.IntChecklist
    public void uncheck(int i) {
        this.ioh.remove(i);
    }

    @Override // com.mchange.util.IntChecklist
    public boolean isChecked(int i) {
        return this.ioh.containsInt(i);
    }

    @Override // com.mchange.util.IntChecklist
    public void clear() {
        this.ioh.clear();
    }

    @Override // com.mchange.util.IntChecklist
    public int countChecked() {
        return this.ioh.getSize();
    }

    @Override // com.mchange.util.IntChecklist
    public int[] getChecked() {
        int[] iArr;
        synchronized (this.ioh) {
            iArr = new int[this.ioh.getSize()];
            IntEnumeration ints = this.ioh.ints();
            int i = 0;
            while (ints.hasMoreInts()) {
                iArr[i] = ints.nextInt();
                i++;
            }
        }
        return iArr;
    }

    @Override // com.mchange.util.IntChecklist
    public IntEnumeration checked() {
        return this.ioh.ints();
    }
}
