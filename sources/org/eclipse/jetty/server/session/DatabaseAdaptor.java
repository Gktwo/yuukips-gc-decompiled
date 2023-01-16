package org.eclipse.jetty.server.session;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Locale;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/DatabaseAdaptor.class */
public class DatabaseAdaptor {
    static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    String _dbName;
    boolean _isLower;
    boolean _isUpper;
    protected String _blobType;
    protected String _longType;
    protected String _stringType;
    private String _driverClassName;
    private String _connectionUrl;
    private Driver _driver;
    private DataSource _datasource;
    private String _jndiName;

    public void adaptTo(DatabaseMetaData dbMeta) throws SQLException {
        this._dbName = dbMeta.getDatabaseProductName().toLowerCase(Locale.ENGLISH);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Using database {}", this._dbName);
        }
        this._isLower = dbMeta.storesLowerCaseIdentifiers();
        this._isUpper = dbMeta.storesUpperCaseIdentifiers();
    }

    public void setBlobType(String blobType) {
        this._blobType = blobType;
    }

    public String getBlobType() {
        if (this._blobType != null) {
            return this._blobType;
        }
        if (this._dbName.startsWith("postgres")) {
            return "bytea";
        }
        return "blob";
    }

    public void setLongType(String longType) {
        this._longType = longType;
    }

    public String getLongType() {
        if (this._longType != null) {
            return this._longType;
        }
        if (this._dbName == null) {
            throw new IllegalStateException("DbAdaptor missing metadata");
        } else if (this._dbName.startsWith("oracle")) {
            return "number(20)";
        } else {
            return "bigint";
        }
    }

    public void setStringType(String stringType) {
        this._stringType = stringType;
    }

    public String getStringType() {
        if (this._stringType != null) {
            return this._stringType;
        }
        return "varchar";
    }

    public String convertIdentifier(String identifier) {
        if (identifier == null) {
            return null;
        }
        if (this._dbName == null) {
            throw new IllegalStateException("DbAdaptor missing metadata");
        } else if (this._isLower) {
            return identifier.toLowerCase(Locale.ENGLISH);
        } else {
            if (this._isUpper) {
                return identifier.toUpperCase(Locale.ENGLISH);
            }
            return identifier;
        }
    }

    public String getDBName() {
        return this._dbName;
    }

    public InputStream getBlobInputStream(ResultSet result, String columnName) throws SQLException {
        if (this._dbName == null) {
            throw new IllegalStateException("DbAdaptor missing metadata");
        } else if (this._dbName.startsWith("postgres")) {
            return new ByteArrayInputStream(result.getBytes(columnName));
        } else {
            try {
                return result.getBlob(columnName).getBinaryStream();
            } catch (SQLFeatureNotSupportedException e) {
                return new ByteArrayInputStream(result.getBytes(columnName));
            }
        }
    }

    public boolean isEmptyStringNull() {
        if (this._dbName != null) {
            return this._dbName.startsWith("oracle");
        }
        throw new IllegalStateException("DbAdaptor missing metadata");
    }

    public boolean isRowIdReserved() {
        if (this._dbName != null) {
            return this._dbName != null && this._dbName.startsWith("oracle");
        }
        throw new IllegalStateException("DbAdaptor missing metadata");
    }

    public void setDriverInfo(String driverClassName, String connectionUrl) {
        this._driverClassName = driverClassName;
        this._connectionUrl = connectionUrl;
    }

    public void setDriverInfo(Driver driverClass, String connectionUrl) {
        this._driver = driverClass;
        this._connectionUrl = connectionUrl;
    }

    public void setDatasource(DataSource ds) {
        this._datasource = ds;
    }

    public void setDatasourceName(String jndi) {
        this._jndiName = jndi;
    }

    public String getDatasourceName() {
        return this._jndiName;
    }

    public DataSource getDatasource() {
        return this._datasource;
    }

    public String getDriverClassName() {
        return this._driverClassName;
    }

    public Driver getDriver() {
        return this._driver;
    }

    public String getConnectionUrl() {
        return this._connectionUrl;
    }

    public void initialize() throws Exception {
        if (this._datasource == null) {
            if (this._jndiName != null) {
                this._datasource = (DataSource) new InitialContext().lookup(this._jndiName);
            } else if (this._driver != null && this._connectionUrl != null) {
                DriverManager.registerDriver(this._driver);
            } else if (this._driverClassName == null || this._connectionUrl == null) {
                try {
                    this._datasource = (DataSource) new InitialContext().lookup("jdbc/sessions");
                } catch (NamingException e) {
                    throw new IllegalStateException("No database configured for sessions");
                }
            } else {
                Class.forName(this._driverClassName);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Connection getConnection() throws SQLException {
        if (this._datasource != null) {
            return this._datasource.getConnection();
        }
        return DriverManager.getConnection(this._connectionUrl);
    }

    public String toString() {
        return String.format("%s[jndi=%s,driver=%s]", toString(), this._jndiName, this._driverClassName);
    }
}
