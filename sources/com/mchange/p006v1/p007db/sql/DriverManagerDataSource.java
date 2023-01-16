package com.mchange.p006v1.p007db.sql;

import com.mchange.p005io.UnsupportedVersionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;
import javax.naming.spi.ObjectFactory;
import javax.sql.DataSource;

/* renamed from: com.mchange.v1.db.sql.DriverManagerDataSource */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/DriverManagerDataSource.class */
public class DriverManagerDataSource implements DataSource, Serializable, Referenceable {
    static final String REF_FACTORY_NAME = DmdsObjectFactory.class.getName();
    static final String REF_JDBC_URL = "jdbcUrl";
    static final String REF_DFLT_USER = "dfltUser";
    static final String REF_DFLT_PWD = "dfltPassword";
    String jdbcUrl;
    String dfltUser;
    String dfltPassword;
    static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    public DriverManagerDataSource(String str, String str2, String str3) {
        this.jdbcUrl = str;
        this.dfltUser = str2;
        this.dfltPassword = str3;
    }

    public DriverManagerDataSource(String str) {
        this(str, null, null);
    }

    @Override // javax.sql.DataSource
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.jdbcUrl, createProps(null, null));
    }

    @Override // javax.sql.DataSource
    public Connection getConnection(String str, String str2) throws SQLException {
        return DriverManager.getConnection(this.jdbcUrl, createProps(str, str2));
    }

    @Override // javax.sql.CommonDataSource
    public PrintWriter getLogWriter() throws SQLException {
        return DriverManager.getLogWriter();
    }

    @Override // javax.sql.CommonDataSource
    public void setLogWriter(PrintWriter printWriter) throws SQLException {
        DriverManager.setLogWriter(printWriter);
    }

    @Override // javax.sql.CommonDataSource
    public int getLoginTimeout() throws SQLException {
        return DriverManager.getLoginTimeout();
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int i) throws SQLException {
        DriverManager.setLoginTimeout(i);
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class<?> cls) throws SQLException {
        return false;
    }

    @Override // java.sql.Wrapper
    public <T> T unwrap(Class<T> cls) throws SQLException {
        throw new SQLException(getClass().getName() + " is not a wrapper for an object implementing any interface.");
    }

    public Reference getReference() throws NamingException {
        Reference reference = new Reference(getClass().getName(), REF_FACTORY_NAME, (String) null);
        reference.add(new StringRefAddr(REF_JDBC_URL, this.jdbcUrl));
        reference.add(new StringRefAddr(REF_DFLT_USER, this.dfltUser));
        reference.add(new StringRefAddr(REF_DFLT_PWD, this.dfltPassword));
        return reference;
    }

    @Override // javax.sql.CommonDataSource
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException("javax.sql.DataSource.getParentLogger() is not currently supported by " + getClass().getName());
    }

    private Properties createProps(String str, String str2) {
        Properties properties = new Properties();
        if (str != null) {
            properties.put("user", str);
            properties.put("password", str2);
        } else if (this.dfltUser != null) {
            properties.put("user", this.dfltUser);
            properties.put("password", this.dfltPassword);
        }
        return properties;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeShort(1);
        objectOutputStream.writeUTF(this.jdbcUrl);
        objectOutputStream.writeUTF(this.dfltUser);
        objectOutputStream.writeUTF(this.dfltPassword);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        short readShort = objectInputStream.readShort();
        switch (readShort) {
            case 1:
                this.jdbcUrl = objectInputStream.readUTF();
                this.dfltUser = objectInputStream.readUTF();
                this.dfltPassword = objectInputStream.readUTF();
                return;
            default:
                throw new UnsupportedVersionException(this, readShort);
        }
    }

    /* renamed from: com.mchange.v1.db.sql.DriverManagerDataSource$DmdsObjectFactory */
    /* loaded from: grasscutter.jar:com/mchange/v1/db/sql/DriverManagerDataSource$DmdsObjectFactory.class */
    public static class DmdsObjectFactory implements ObjectFactory {
        public Object getObjectInstance(Object obj, Name name, Context context, Hashtable hashtable) throws Exception {
            String name2 = DriverManagerDataSource.class.getName();
            if (!(obj instanceof Reference)) {
                return null;
            }
            Reference reference = (Reference) obj;
            if (reference.getClassName().equals(name2)) {
                return new DriverManagerDataSource((String) reference.get(DriverManagerDataSource.REF_JDBC_URL).getContent(), (String) reference.get(DriverManagerDataSource.REF_DFLT_USER).getContent(), (String) reference.get(DriverManagerDataSource.REF_DFLT_PWD).getContent());
            }
            return null;
        }
    }
}
