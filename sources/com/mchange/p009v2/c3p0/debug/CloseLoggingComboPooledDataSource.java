package com.mchange.p009v2.c3p0.debug;

import com.mchange.p009v2.c3p0.AbstractComboPooledDataSource;
import com.mchange.p009v2.log.MLevel;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Referenceable;

/* renamed from: com.mchange.v2.c3p0.debug.CloseLoggingComboPooledDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/debug/CloseLoggingComboPooledDataSource.class */
public final class CloseLoggingComboPooledDataSource extends AbstractComboPooledDataSource implements Serializable, Referenceable {
    volatile MLevel level = MLevel.INFO;
    private static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    public void setCloseLogLevel(MLevel level) {
        this.level = level;
    }

    public MLevel getCloseLogLevel() {
        return this.level;
    }

    public CloseLoggingComboPooledDataSource() {
    }

    public CloseLoggingComboPooledDataSource(boolean autoregister) {
        super(autoregister);
    }

    public CloseLoggingComboPooledDataSource(String configName) {
        super(configName);
    }

    @Override // com.mchange.p009v2.c3p0.impl.AbstractPoolBackedDataSource, javax.sql.DataSource
    public Connection getConnection() throws SQLException {
        return new CloseLoggingConnectionWrapper(getConnection(), this.level);
    }

    @Override // com.mchange.p009v2.c3p0.impl.AbstractPoolBackedDataSource, javax.sql.DataSource
    public Connection getConnection(String user, String password) throws SQLException {
        return new CloseLoggingConnectionWrapper(getConnection(user, password), this.level);
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
