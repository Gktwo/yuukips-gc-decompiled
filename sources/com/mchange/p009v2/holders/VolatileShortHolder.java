package com.mchange.p009v2.holders;

import com.mchange.p009v2.ser.UnsupportedVersionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.mchange.v2.holders.VolatileShortHolder */
/* loaded from: grasscutter.jar:com/mchange/v2/holders/VolatileShortHolder.class */
public class VolatileShortHolder implements ThreadSafeShortHolder, Serializable {
    volatile transient short value;
    static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    @Override // com.mchange.p009v2.holders.ThreadSafeShortHolder
    public short getValue() {
        return this.value;
    }

    @Override // com.mchange.p009v2.holders.ThreadSafeShortHolder
    public void setValue(short s) {
        this.value = s;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeShort(1);
        objectOutputStream.writeShort(this.value);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        short readShort = objectInputStream.readShort();
        switch (readShort) {
            case 1:
                this.value = objectInputStream.readShort();
                return;
            default:
                throw new UnsupportedVersionException(this, readShort);
        }
    }
}
