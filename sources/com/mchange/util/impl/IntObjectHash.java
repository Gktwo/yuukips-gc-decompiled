package com.mchange.util.impl;

import com.mchange.util.IntEnumeration;
import com.mchange.util.IntObjectMap;
import java.util.NoSuchElementException;

/* loaded from: grasscutter.jar:com/mchange/util/impl/IntObjectHash.class */
public class IntObjectHash implements IntObjectMap {
    IOHRecord[] records;
    int init_capacity;
    float load_factor;
    int threshold;
    int size;

    public IntObjectHash(int i, float f) {
        this.init_capacity = i;
        this.load_factor = f;
        clear();
    }

    public IntObjectHash() {
        this(101, 0.75f);
    }

    @Override // com.mchange.util.IntObjectMap
    public synchronized Object get(int i) {
        int index = getIndex(i);
        Object obj = null;
        if (this.records[index] != null) {
            obj = this.records[index].get(i);
        }
        return obj;
    }

    @Override // com.mchange.util.IntObjectMap
    public synchronized void put(int i, Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null values not permitted.");
        }
        int index = getIndex(i);
        if (this.records[index] == null) {
            this.records[index] = new IOHRecord(index);
        }
        if (!this.records[index].add(i, obj, true)) {
            this.size++;
        }
        if (this.size > this.threshold) {
            rehash();
        }
    }

    @Override // com.mchange.util.IntObjectMap
    public synchronized boolean putNoReplace(int i, Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null values not permitted.");
        }
        int index = getIndex(i);
        if (this.records[index] == null) {
            this.records[index] = new IOHRecord(index);
        }
        if (this.records[index].add(i, obj, false)) {
            return false;
        }
        this.size++;
        if (this.size <= this.threshold) {
            return true;
        }
        rehash();
        return true;
    }

    @Override // com.mchange.util.IntObjectMap
    public int getSize() {
        return this.size;
    }

    @Override // com.mchange.util.IntObjectMap
    public synchronized boolean containsInt(int i) {
        int index = getIndex(i);
        return (this.records[index] == null || this.records[index].findInt(i) == null) ? false : true;
    }

    private int getIndex(int i) {
        return Math.abs(i % this.records.length);
    }

    @Override // com.mchange.util.IntObjectMap
    public synchronized Object remove(int i) {
        IOHRecord iOHRecord = this.records[getIndex(i)];
        Object remove = iOHRecord == null ? null : iOHRecord.remove(i);
        if (remove != null) {
            this.size--;
        }
        return remove;
    }

    @Override // com.mchange.util.IntObjectMap
    public synchronized void clear() {
        this.records = new IOHRecord[this.init_capacity];
        this.threshold = (int) (this.load_factor * ((float) this.init_capacity));
        this.size = 0;
    }

    @Override // com.mchange.util.IntObjectMap
    public synchronized IntEnumeration ints() {
        return new IntEnumerationHelperBase() { // from class: com.mchange.util.impl.IntObjectHash.1
            int index = -1;
            IOHRecElem finger;

            {
                nextIndex();
            }

            @Override // com.mchange.util.impl.IntEnumerationHelperBase, com.mchange.util.IntEnumeration
            public boolean hasMoreInts() {
                return this.index < IntObjectHash.this.records.length;
            }

            @Override // com.mchange.util.impl.IntEnumerationHelperBase, com.mchange.util.IntEnumeration
            public int nextInt() {
                try {
                    int i = this.finger.num;
                    findNext();
                    return i;
                } catch (NullPointerException e) {
                    throw new NoSuchElementException();
                }
            }

            private void findNext() {
                if (this.finger.next != null) {
                    this.finger = this.finger.next;
                } else {
                    nextIndex();
                }
            }

            private void nextIndex() {
                try {
                    int length = IntObjectHash.this.records.length;
                    do {
                        this.index++;
                        if (IntObjectHash.this.records[this.index] != null) {
                            break;
                        }
                    } while (this.index <= length);
                    this.finger = IntObjectHash.this.records[this.index].next;
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.finger = null;
                }
            }
        };
    }

    protected void rehash() {
        IOHRecord[] iOHRecordArr = new IOHRecord[this.records.length * 2];
        for (int i = 0; i < this.records.length; i++) {
            if (this.records[i] != null) {
                iOHRecordArr[i] = this.records[i];
                iOHRecordArr[i * 2] = this.records[i].split(iOHRecordArr.length);
            }
        }
        this.records = iOHRecordArr;
        this.threshold = (int) (this.load_factor * ((float) this.records.length));
    }
}
