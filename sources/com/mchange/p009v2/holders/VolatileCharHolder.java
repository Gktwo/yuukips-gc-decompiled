package com.mchange.p009v2.holders;

import com.mchange.p009v2.ser.UnsupportedVersionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.mchange.v2.holders.VolatileCharHolder */
/* loaded from: grasscutter.jar:com/mchange/v2/holders/VolatileCharHolder.class */
public class VolatileCharHolder implements ThreadSafeCharHolder, Serializable {
    volatile transient char value;
    static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    @Override // com.mchange.p009v2.holders.ThreadSafeCharHolder
    public char getValue() {
        return this.value;
    }

    @Override // com.mchange.p009v2.holders.ThreadSafeCharHolder
    public void setValue(char c) {
        this.value = c;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeShort(1);
        objectOutputStream.writeChar(this.value);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        short readShort = objectInputStream.readShort();
        switch (readShort) {
            case 1:
                this.value = objectInputStream.readChar();
                return;
            default:
                throw new UnsupportedVersionException(this, readShort);
        }
    }
}
