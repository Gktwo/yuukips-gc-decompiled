package com.mchange.p009v2.c3p0.test;

import com.mchange.p009v2.c3p0.cfg.C3P0Config;
import com.mchange.p009v2.c3p0.impl.DriverManagerDataSourceBase;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.test.FreezableDriverManagerDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/FreezableDriverManagerDataSource.class */
public final class FreezableDriverManagerDataSource extends DriverManagerDataSourceBase implements DataSource {
    static final MLogger logger = MLog.getLogger(FreezableDriverManagerDataSource.class);
    static final File FREEZE_FILE = new File("/tmp/c3p0_freeze_file");
    Driver driver;
    boolean driver_class_loaded;
    private static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    public FreezableDriverManagerDataSource() {
        this(true);
    }

    public FreezableDriverManagerDataSource(boolean autoregister) {
        super(autoregister);
        this.driver_class_loaded = false;
        setUpPropertyListeners();
        String user = C3P0Config.initializeStringPropertyVar("user", null);
        String password = C3P0Config.initializeStringPropertyVar("password", null);
        if (user != null) {
            setUser(user);
        }
        if (password != null) {
            setPassword(password);
        }
    }

    private void waitNoFreezeFile() throws SQLException {
        while (FREEZE_FILE.exists()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.log(MLevel.WARNING, "Frozen cxn acquire interrupted.", (Throwable) e);
                throw new SQLException(e.toString());
            }
        }
    }

    private void setUpPropertyListeners() {
        addPropertyChangeListener(new PropertyChangeListener() { // from class: com.mchange.v2.c3p0.test.FreezableDriverManagerDataSource.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                evt.getNewValue();
                if ("driverClass".equals(evt.getPropertyName())) {
                    FreezableDriverManagerDataSource.this.setDriverClassLoaded(false);
                }
            }
        });
    }

    private synchronized boolean isDriverClassLoaded() {
        return this.driver_class_loaded;
    }

    /* access modifiers changed from: private */
    public synchronized void setDriverClassLoaded(boolean dcl) {
        this.driver_class_loaded = dcl;
    }

    private void ensureDriverLoaded() throws SQLException {
        try {
            if (!isDriverClassLoaded()) {
                if (this.driverClass != null) {
                    Class.forName(this.driverClass);
                }
                setDriverClassLoaded(true);
            }
        } catch (ClassNotFoundException e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Could not load driverClass " + this.driverClass, (Throwable) e);
            }
        }
    }

    @Override // javax.sql.DataSource
    public Connection getConnection() throws SQLException {
        ensureDriverLoaded();
        waitNoFreezeFile();
        Connection out = driver().connect(this.jdbcUrl, this.properties);
        if (out != null) {
            return out;
        }
        throw new SQLException("Apparently, jdbc URL '" + this.jdbcUrl + "' is not valid for the underlying driver [" + driver() + "].");
    }

    @Override // javax.sql.DataSource
    public Connection getConnection(String username, String password) throws SQLException {
        ensureDriverLoaded();
        waitNoFreezeFile();
        Connection out = driver().connect(this.jdbcUrl, overrideProps(username, password));
        if (out != null) {
            return out;
        }
        throw new SQLException("Apparently, jdbc URL '" + this.jdbcUrl + "' is not valid for the underlying driver [" + driver() + "].");
    }

    @Override // javax.sql.CommonDataSource
    public PrintWriter getLogWriter() throws SQLException {
        return DriverManager.getLogWriter();
    }

    @Override // javax.sql.CommonDataSource
    public void setLogWriter(PrintWriter out) throws SQLException {
        DriverManager.setLogWriter(out);
    }

    @Override // javax.sql.CommonDataSource
    public int getLoginTimeout() throws SQLException {
        return DriverManager.getLoginTimeout();
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int seconds) throws SQLException {
        DriverManager.setLoginTimeout(seconds);
    }

    @Override // com.mchange.p009v2.c3p0.impl.DriverManagerDataSourceBase
    public synchronized void setJdbcUrl(String jdbcUrl) {
        setJdbcUrl(jdbcUrl);
        clearDriver();
    }

    public synchronized void setUser(String user) {
        String oldUser = getUser();
        if (!eqOrBothNull(user, oldUser)) {
            if (user != null) {
                this.properties.put("user", user);
            } else {
                this.properties.remove("user");
            }
            this.pcs.firePropertyChange("user", oldUser, user);
        }
    }

    public synchronized String getUser() {
        return this.properties.getProperty("user");
    }

    public synchronized void setPassword(String password) {
        String oldPass = getPassword();
        if (!eqOrBothNull(password, oldPass)) {
            if (password != null) {
                this.properties.put("password", password);
            } else {
                this.properties.remove("password");
            }
            this.pcs.firePropertyChange("password", oldPass, password);
        }
    }

    public synchronized String getPassword() {
        return this.properties.getProperty("password");
    }

    private final Properties overrideProps(String user, String password) {
        Properties overriding = (Properties) this.properties.clone();
        if (user != null) {
            overriding.put("user", user);
        } else {
            overriding.remove("user");
        }
        if (password != null) {
            overriding.put("password", password);
        } else {
            overriding.remove("password");
        }
        return overriding;
    }

    private synchronized Driver driver() throws SQLException {
        if (this.driver == null) {
            this.driver = DriverManager.getDriver(this.jdbcUrl);
        }
        return this.driver;
    }

    private synchronized void clearDriver() {
        this.driver = null;
    }

    private static boolean eqOrBothNull(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
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
