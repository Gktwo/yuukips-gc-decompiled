package com.mchange.p009v2.c3p0;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.naming.Referenceable;

/* renamed from: com.mchange.v2.c3p0.ComboPooledDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/ComboPooledDataSource.class */
public final class ComboPooledDataSource extends AbstractComboPooledDataSource implements Serializable, Referenceable {
    private static final long serialVersionUID = 1;
    private static final short VERSION = 2;

    public ComboPooledDataSource() {
    }

    public ComboPooledDataSource(boolean autoregister) {
        super(autoregister);
    }

    public ComboPooledDataSource(String configName) {
        super(configName);
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeShort(2);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        short version = ois.readShort();
        switch (version) {
            case 2:
                return;
            default:
                throw new IOException("Unsupported Serialized Version: " + ((int) version));
        }
    }
}
