package com.mchange.p009v2.c3p0;

import com.mchange.p009v2.c3p0.impl.JndiRefDataSourceBase;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.sql.SqlUtils;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.JndiRefForwardingDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/JndiRefForwardingDataSource.class */
final class JndiRefForwardingDataSource extends JndiRefDataSourceBase implements DataSource {
    static final MLogger logger = MLog.getLogger(JndiRefForwardingDataSource.class);
    transient DataSource cachedInner;
    private static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    public JndiRefForwardingDataSource() {
        this(true);
    }

    public JndiRefForwardingDataSource(boolean autoregister) {
        super(autoregister);
        setUpPropertyListeners();
    }

    private void setUpPropertyListeners() {
        addVetoableChangeListener(new VetoableChangeListener() { // from class: com.mchange.v2.c3p0.JndiRefForwardingDataSource.1
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                Object val = evt.getNewValue();
                if ("jndiName".equals(evt.getPropertyName()) && !(val instanceof Name) && !(val instanceof String)) {
                    throw new PropertyVetoException("jndiName must be a String or a javax.naming.Name", evt);
                }
            }
        });
        addPropertyChangeListener(new PropertyChangeListener() { // from class: com.mchange.v2.c3p0.JndiRefForwardingDataSource.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JndiRefForwardingDataSource.this.cachedInner = null;
            }
        });
    }

    private DataSource dereference() throws SQLException {
        InitialContext ctx;
        Object jndiName = getJndiName();
        Hashtable jndiEnv = getJndiEnv();
        try {
            if (jndiEnv != null) {
                ctx = new InitialContext(jndiEnv);
            } else {
                ctx = new InitialContext();
            }
            if (jndiName instanceof String) {
                return (DataSource) ctx.lookup((String) jndiName);
            }
            if (jndiName instanceof Name) {
                return (DataSource) ctx.lookup((Name) jndiName);
            }
            throw new SQLException("Could not find ConnectionPoolDataSource with JNDI name: " + jndiName);
        } catch (NamingException e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "An Exception occurred while trying to look up a target DataSource via JNDI!", (Throwable) e);
            }
            throw SqlUtils.toSQLException(e);
        }
    }

    private synchronized DataSource inner() throws SQLException {
        if (this.cachedInner != null) {
            return this.cachedInner;
        }
        DataSource out = dereference();
        if (isCaching()) {
            this.cachedInner = out;
        }
        return out;
    }

    @Override // javax.sql.DataSource
    public Connection getConnection() throws SQLException {
        return inner().getConnection();
    }

    @Override // javax.sql.DataSource
    public Connection getConnection(String username, String password) throws SQLException {
        return inner().getConnection(username, password);
    }

    @Override // javax.sql.CommonDataSource
    public PrintWriter getLogWriter() throws SQLException {
        return inner().getLogWriter();
    }

    @Override // javax.sql.CommonDataSource
    public void setLogWriter(PrintWriter out) throws SQLException {
        inner().setLogWriter(out);
    }

    @Override // javax.sql.CommonDataSource
    public int getLoginTimeout() throws SQLException {
        return inner().getLoginTimeout();
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int seconds) throws SQLException {
        inner().setLoginTimeout(seconds);
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeShort(1);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        short version = ois.readShort();
        switch (version) {
            case 1:
                setUpPropertyListeners();
                return;
            default:
                throw new IOException("Unsupported Serialized Version: " + ((int) version));
        }
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override // java.sql.Wrapper
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new SQLException(this + " is not a Wrapper for " + iface.getName());
    }
}
