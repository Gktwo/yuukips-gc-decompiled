package com.mchange.p009v2.holders;

import com.mchange.p009v2.ser.UnsupportedVersionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.mchange.v2.holders.ChangeNotifyingSynchronizedIntHolder */
/* loaded from: grasscutter.jar:com/mchange/v2/holders/ChangeNotifyingSynchronizedIntHolder.class */
public final class ChangeNotifyingSynchronizedIntHolder implements ThreadSafeIntHolder, Serializable {
    transient int value;
    transient boolean notify_all;
    static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    public ChangeNotifyingSynchronizedIntHolder(int i, boolean z) {
        this.value = i;
        this.notify_all = z;
    }

    public ChangeNotifyingSynchronizedIntHolder() {
        this(0, true);
    }

    @Override // com.mchange.p009v2.holders.ThreadSafeIntHolder
    public synchronized int getValue() {
        return this.value;
    }

    @Override // com.mchange.p009v2.holders.ThreadSafeIntHolder
    public synchronized void setValue(int i) {
        if (i != this.value) {
            this.value = i;
            doNotify();
        }
    }

    public synchronized void increment() {
        this.value++;
        doNotify();
    }

    public synchronized void decrement() {
        this.value--;
        doNotify();
    }

    private void doNotify() {
        if (this.notify_all) {
            notifyAll();
        } else {
            notify();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeShort(1);
        objectOutputStream.writeInt(this.value);
        objectOutputStream.writeBoolean(this.notify_all);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        short readShort = objectInputStream.readShort();
        switch (readShort) {
            case 1:
                this.value = objectInputStream.readInt();
                this.notify_all = objectInputStream.readBoolean();
                return;
            default:
                throw new UnsupportedVersionException(this, readShort);
        }
    }
}
