package com.mchange.p009v2.holders;

import com.mchange.p009v2.ser.UnsupportedVersionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.mchange.v2.holders.SynchronizedIntHolder */
/* loaded from: grasscutter.jar:com/mchange/v2/holders/SynchronizedIntHolder.class */
public class SynchronizedIntHolder implements ThreadSafeIntHolder, Serializable {
    transient int value;
    static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    public SynchronizedIntHolder(int i) {
        this.value = i;
    }

    public SynchronizedIntHolder() {
        this(0);
    }

    @Override // com.mchange.p009v2.holders.ThreadSafeIntHolder
    public synchronized int getValue() {
        return this.value;
    }

    @Override // com.mchange.p009v2.holders.ThreadSafeIntHolder
    public synchronized void setValue(int i) {
        this.value = i;
    }

    public synchronized void increment() {
        this.value++;
    }

    public synchronized void decrement() {
        this.value--;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeShort(1);
        objectOutputStream.writeInt(this.value);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        short readShort = objectInputStream.readShort();
        switch (readShort) {
            case 1:
                this.value = objectInputStream.readInt();
                return;
            default:
                throw new UnsupportedVersionException(this, readShort);
        }
    }
}
