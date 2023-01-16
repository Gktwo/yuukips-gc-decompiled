package org.quartz.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.sql.XADataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/utils/JNDIConnectionProvider.class */
public class JNDIConnectionProvider implements ConnectionProvider {
    private String url;
    private Properties props;
    private Object datasource;
    private boolean alwaysLookup;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public JNDIConnectionProvider(String jndiUrl, boolean alwaysLookup) {
        this.alwaysLookup = false;
        this.url = jndiUrl;
        this.alwaysLookup = alwaysLookup;
        init();
    }

    public JNDIConnectionProvider(String jndiUrl, Properties jndiProps, boolean alwaysLookup) {
        this.alwaysLookup = false;
        this.url = jndiUrl;
        this.props = jndiProps;
        this.alwaysLookup = alwaysLookup;
        init();
    }

    protected Logger getLog() {
        return this.log;
    }

    private void init() {
        if (!isAlwaysLookup()) {
            Context ctx = null;
            try {
                try {
                    ctx = this.props != null ? new InitialContext(this.props) : new InitialContext();
                    this.datasource = (DataSource) ctx.lookup(this.url);
                    if (ctx != null) {
                        try {
                            ctx.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    getLog().error("Error looking up datasource: " + e2.getMessage(), (Throwable) e2);
                    if (ctx != null) {
                        try {
                            ctx.close();
                        } catch (Exception e3) {
                        }
                    }
                }
            } catch (Throwable th) {
                if (ctx != null) {
                    try {
                        ctx.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        }
    }

    @Override // org.quartz.utils.ConnectionProvider
    public Connection getConnection() throws SQLException {
        Context ctx;
        try {
            ctx = null;
            try {
                Object ds = this.datasource;
                if (ds == null || isAlwaysLookup()) {
                    ctx = this.props != null ? new InitialContext(this.props) : new InitialContext();
                    ds = ctx.lookup(this.url);
                    if (!isAlwaysLookup()) {
                        this.datasource = ds;
                    }
                }
                if (ds == null) {
                    throw new SQLException("There is no object at the JNDI URL '" + this.url + "'");
                } else if (ds instanceof XADataSource) {
                    Connection connection = ((XADataSource) ds).getXAConnection().getConnection();
                    if (ctx != null) {
                        try {
                            ctx.close();
                        } catch (Exception e) {
                        }
                    }
                    return connection;
                } else if (ds instanceof DataSource) {
                    Connection connection2 = ((DataSource) ds).getConnection();
                    if (ctx != null) {
                        try {
                            ctx.close();
                        } catch (Exception e2) {
                        }
                    }
                    return connection2;
                } else {
                    throw new SQLException("Object at JNDI URL '" + this.url + "' is not a DataSource.");
                }
            } catch (Exception e3) {
                this.datasource = null;
                throw new SQLException("Could not retrieve datasource via JNDI url '" + this.url + "' " + e3.getClass().getName() + ": " + e3.getMessage());
            }
        } catch (Throwable th) {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    public boolean isAlwaysLookup() {
        return this.alwaysLookup;
    }

    public void setAlwaysLookup(boolean b) {
        this.alwaysLookup = b;
    }

    @Override // org.quartz.utils.ConnectionProvider
    public void shutdown() throws SQLException {
    }

    @Override // org.quartz.utils.ConnectionProvider
    public void initialize() throws SQLException {
    }
}
