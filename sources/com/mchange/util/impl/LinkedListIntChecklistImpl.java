package com.mchange.util.impl;

import com.mchange.util.IntChecklist;
import com.mchange.util.IntEnumeration;
import java.util.NoSuchElementException;

/* loaded from: grasscutter.jar:com/mchange/util/impl/LinkedListIntChecklistImpl.class */
public class LinkedListIntChecklistImpl implements IntChecklist {
    private final LLICIRecord headRecord = new LLICIRecord();
    private int num_checked = 0;

    @Override // com.mchange.util.IntChecklist
    public void check(int i) {
        LLICIRecord findPrevious = findPrevious(i);
        if (findPrevious.next == null || findPrevious.next.contained != i) {
            LLICIRecord lLICIRecord = new LLICIRecord();
            lLICIRecord.next = findPrevious.next;
            lLICIRecord.contained = i;
            findPrevious.next = lLICIRecord;
            this.num_checked++;
        }
    }

    @Override // com.mchange.util.IntChecklist
    public void uncheck(int i) {
        LLICIRecord findPrevious = findPrevious(i);
        if (findPrevious.next != null && findPrevious.next.contained == i) {
            findPrevious.next = findPrevious.next.next;
            this.num_checked--;
        }
    }

    @Override // com.mchange.util.IntChecklist
    public boolean isChecked(int i) {
        LLICIRecord findPrevious = findPrevious(i);
        return findPrevious.next != null && findPrevious.next.contained == i;
    }

    @Override // com.mchange.util.IntChecklist
    public void clear() {
        this.headRecord.next = null;
        this.num_checked = 0;
    }

    @Override // com.mchange.util.IntChecklist
    public int countChecked() {
        return this.num_checked;
    }

    @Override // com.mchange.util.IntChecklist
    public int[] getChecked() {
        int[] iArr = new int[this.num_checked];
        int i = 0;
        for (LLICIRecord lLICIRecord = this.headRecord; lLICIRecord.next != null; lLICIRecord = lLICIRecord.next) {
            i++;
            iArr[i] = lLICIRecord.next.contained;
        }
        return iArr;
    }

    @Override // com.mchange.util.IntChecklist
    public IntEnumeration checked() {
        return new IntEnumerationHelperBase() { // from class: com.mchange.util.impl.LinkedListIntChecklistImpl.1
            LLICIRecord finger;

            {
                this.finger = LinkedListIntChecklistImpl.this.headRecord;
            }

            @Override // com.mchange.util.impl.IntEnumerationHelperBase, com.mchange.util.IntEnumeration
            public int nextInt() {
                try {
                    this.finger = this.finger.next;
                    return this.finger.contained;
                } catch (NullPointerException e) {
                    throw new NoSuchElementException();
                }
            }

            @Override // com.mchange.util.impl.IntEnumerationHelperBase, com.mchange.util.IntEnumeration
            public boolean hasMoreInts() {
                return this.finger.next != null;
            }
        };
    }

    private LLICIRecord findPrevious(int i) {
        LLICIRecord lLICIRecord = this.headRecord;
        while (lLICIRecord.next != null && lLICIRecord.next.contained < i) {
            lLICIRecord = lLICIRecord.next;
        }
        return lLICIRecord;
    }
}
