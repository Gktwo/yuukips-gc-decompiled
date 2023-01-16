package com.mchange.util.impl;

import com.mchange.util.LongObjectMap;

/* loaded from: grasscutter.jar:com/mchange/util/impl/LongObjectHash.class */
public class LongObjectHash implements LongObjectMap {
    LOHRecord[] records;
    float load_factor;
    long threshold;
    long size;

    public LongObjectHash(int i, float f) {
        this.records = new LOHRecord[i];
        this.load_factor = f;
        this.threshold = (long) (f * ((float) i));
    }

    public LongObjectHash() {
        this(101, 0.75f);
    }

    @Override // com.mchange.util.LongObjectMap
    public synchronized Object get(long j) {
        int length = (int) (j % ((long) this.records.length));
        Object obj = null;
        if (this.records[length] != null) {
            obj = this.records[length].get(j);
        }
        return obj;
    }

    @Override // com.mchange.util.LongObjectMap
    public synchronized void put(long j, Object obj) {
        int length = (int) (j % ((long) this.records.length));
        if (this.records[length] == null) {
            this.records[length] = new LOHRecord((long) length);
        }
        if (!this.records[length].add(j, obj, true)) {
            this.size++;
        }
        if (this.size > this.threshold) {
            rehash();
        }
    }

    @Override // com.mchange.util.LongObjectMap
    public synchronized boolean putNoReplace(long j, Object obj) {
        int length = (int) (j % ((long) this.records.length));
        if (this.records[length] == null) {
            this.records[length] = new LOHRecord((long) length);
        }
        if (this.records[length].add(j, obj, false)) {
            return false;
        }
        this.size++;
        if (this.size <= this.threshold) {
            return true;
        }
        rehash();
        return true;
    }

    @Override // com.mchange.util.LongObjectMap
    public long getSize() {
        return this.size;
    }

    @Override // com.mchange.util.LongObjectMap
    public synchronized boolean containsLong(long j) {
        int length = (int) (j % ((long) this.records.length));
        return (this.records[length] == null || this.records[length].findLong(j) == null) ? false : true;
    }

    @Override // com.mchange.util.LongObjectMap
    public synchronized Object remove(long j) {
        LOHRecord lOHRecord = this.records[(int) (j % ((long) this.records.length))];
        Object remove = lOHRecord == null ? null : lOHRecord.remove(j);
        if (remove != null) {
            this.size--;
        }
        return remove;
    }

    protected void rehash() {
        if (((long) this.records.length) * 2 > 2147483647L) {
            throw new Error("Implementation of LongObjectHash allows a capacity of only 2147483647");
        }
        LOHRecord[] lOHRecordArr = new LOHRecord[this.records.length * 2];
        for (int i = 0; i < this.records.length; i++) {
            if (this.records[i] != null) {
                lOHRecordArr[i] = this.records[i];
                lOHRecordArr[i * 2] = this.records[i].split(lOHRecordArr.length);
            }
        }
        this.records = lOHRecordArr;
        this.threshold = (long) (this.load_factor * ((float) this.records.length));
    }
}
