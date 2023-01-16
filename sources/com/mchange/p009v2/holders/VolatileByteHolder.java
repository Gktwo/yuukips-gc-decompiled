package com.mchange.p009v2.holders;

import com.mchange.p009v2.ser.UnsupportedVersionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.mchange.v2.holders.VolatileByteHolder */
/* loaded from: grasscutter.jar:com/mchange/v2/holders/VolatileByteHolder.class */
public class VolatileByteHolder implements ThreadSafeByteHolder, Serializable {
    volatile transient byte value;
    static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    @Override // com.mchange.p009v2.holders.ThreadSafeByteHolder
    public byte getValue() {
        return this.value;
    }

    @Override // com.mchange.p009v2.holders.ThreadSafeByteHolder
    public void setValue(byte b) {
        this.value = b;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeShort(1);
        objectOutputStream.writeByte(this.value);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        short readShort = objectInputStream.readShort();
        switch (readShort) {
            case 1:
                this.value = objectInputStream.readByte();
                return;
            default:
                throw new UnsupportedVersionException(this, readShort);
        }
    }
}
