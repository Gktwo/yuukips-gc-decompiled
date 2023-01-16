package com.mchange.p009v2.holders;

import com.mchange.p009v2.ser.UnsupportedVersionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.mchange.v2.holders.SynchronizedDoubleHolder */
/* loaded from: grasscutter.jar:com/mchange/v2/holders/SynchronizedDoubleHolder.class */
public class SynchronizedDoubleHolder implements ThreadSafeDoubleHolder, Serializable {
    transient double value;
    static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    @Override // com.mchange.p009v2.holders.ThreadSafeDoubleHolder
    public synchronized double getValue() {
        return this.value;
    }

    @Override // com.mchange.p009v2.holders.ThreadSafeDoubleHolder
    public synchronized void setValue(double d) {
        this.value = d;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeShort(1);
        objectOutputStream.writeDouble(this.value);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        short readShort = objectInputStream.readShort();
        switch (readShort) {
            case 1:
                this.value = objectInputStream.readDouble();
                return;
            default:
                throw new UnsupportedVersionException(this, readShort);
        }
    }
}
