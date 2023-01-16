package com.mchange.p009v2.holders;

import com.mchange.p009v2.ser.UnsupportedVersionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.mchange.v2.holders.SynchronizedFloatHolder */
/* loaded from: grasscutter.jar:com/mchange/v2/holders/SynchronizedFloatHolder.class */
public class SynchronizedFloatHolder implements ThreadSafeFloatHolder, Serializable {
    transient float value;
    static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    @Override // com.mchange.p009v2.holders.ThreadSafeFloatHolder
    public synchronized float getValue() {
        return this.value;
    }

    @Override // com.mchange.p009v2.holders.ThreadSafeFloatHolder
    public synchronized void setValue(float f) {
        this.value = f;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeShort(1);
        objectOutputStream.writeFloat(this.value);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        short readShort = objectInputStream.readShort();
        switch (readShort) {
            case 1:
                this.value = objectInputStream.readFloat();
                return;
            default:
                throw new UnsupportedVersionException(this, readShort);
        }
    }
}
