package com.mchange.p009v2.c3p0.debug;

import com.mchange.p009v2.c3p0.AbstractComboPooledDataSource;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Referenceable;

/* renamed from: com.mchange.v2.c3p0.debug.AfterCloseLoggingComboPooledDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/debug/AfterCloseLoggingComboPooledDataSource.class */
public final class AfterCloseLoggingComboPooledDataSource extends AbstractComboPooledDataSource implements Serializable, Referenceable {
    private static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    public AfterCloseLoggingComboPooledDataSource() {
    }

    public AfterCloseLoggingComboPooledDataSource(boolean autoregister) {
        super(autoregister);
    }

    public AfterCloseLoggingComboPooledDataSource(String configName) {
        super(configName);
    }

    @Override // com.mchange.p009v2.c3p0.impl.AbstractPoolBackedDataSource, javax.sql.DataSource
    public Connection getConnection() throws SQLException {
        return AfterCloseLoggingConnectionWrapper.wrap(getConnection());
    }

    @Override // com.mchange.p009v2.c3p0.impl.AbstractPoolBackedDataSource, javax.sql.DataSource
    public Connection getConnection(String user, String password) throws SQLException {
        return AfterCloseLoggingConnectionWrapper.wrap(getConnection(user, password));
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeShort(1);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        short version = ois.readShort();
        switch (version) {
            case 1:
                return;
            default:
                throw new IOException("Unsupported Serialized Version: " + ((int) version));
        }
    }
}
