package com.mchange.p009v2.holders;

import com.mchange.p009v2.ser.UnsupportedVersionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.mchange.v2.holders.SynchronizedLongHolder */
/* loaded from: grasscutter.jar:com/mchange/v2/holders/SynchronizedLongHolder.class */
public class SynchronizedLongHolder implements ThreadSafeLongHolder, Serializable {
    transient long value;
    static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    @Override // com.mchange.p009v2.holders.ThreadSafeLongHolder
    public synchronized long getValue() {
        return this.value;
    }

    @Override // com.mchange.p009v2.holders.ThreadSafeLongHolder
    public synchronized void setValue(long j) {
        this.value = j;
    }

    public SynchronizedLongHolder(long j) {
        this.value = j;
    }

    public SynchronizedLongHolder() {
        this(0);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeShort(1);
        objectOutputStream.writeLong(this.value);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        short readShort = objectInputStream.readShort();
        switch (readShort) {
            case 1:
                this.value = objectInputStream.readLong();
                return;
            default:
                throw new UnsupportedVersionException(this, readShort);
        }
    }
}
