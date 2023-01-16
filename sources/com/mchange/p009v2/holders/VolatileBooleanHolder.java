package com.mchange.p009v2.holders;

import com.mchange.p009v2.ser.UnsupportedVersionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.mchange.v2.holders.VolatileBooleanHolder */
/* loaded from: grasscutter.jar:com/mchange/v2/holders/VolatileBooleanHolder.class */
public class VolatileBooleanHolder implements ThreadSafeBooleanHolder, Serializable {
    volatile transient boolean value;
    static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    @Override // com.mchange.p009v2.holders.ThreadSafeBooleanHolder
    public boolean getValue() {
        return this.value;
    }

    @Override // com.mchange.p009v2.holders.ThreadSafeBooleanHolder
    public void setValue(boolean z) {
        this.value = z;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeShort(1);
        objectOutputStream.writeBoolean(this.value);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        short readShort = objectInputStream.readShort();
        switch (readShort) {
            case 1:
                this.value = objectInputStream.readBoolean();
                return;
            default:
                throw new UnsupportedVersionException(this, readShort);
        }
    }
}
