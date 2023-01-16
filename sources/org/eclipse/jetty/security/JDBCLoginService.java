package org.eclipse.jetty.security;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.eclipse.jetty.security.AbstractLoginService;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.security.Credential;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/JDBCLoginService.class */
public class JDBCLoginService extends AbstractLoginService {
    private static final Logger LOG = Log.getLogger(JDBCLoginService.class);
    protected String _config;
    protected String _jdbcDriver;
    protected String _url;
    protected String _userName;
    protected String _password;
    protected String _userTableKey;
    protected String _userTablePasswordField;
    protected String _roleTableRoleField;
    protected Connection _con;
    protected String _userSql;
    protected String _roleSql;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/JDBCLoginService$JDBCUserPrincipal.class */
    public class JDBCUserPrincipal extends AbstractLoginService.UserPrincipal {
        int _userKey;

        public JDBCUserPrincipal(String name, Credential credential, int key) {
            super(name, credential);
            this._userKey = key;
        }

        public int getUserKey() {
            return this._userKey;
        }
    }

    public JDBCLoginService() throws IOException {
    }

    public JDBCLoginService(String name) throws IOException {
        setName(name);
    }

    public JDBCLoginService(String name, String config) throws IOException {
        setName(name);
        setConfig(config);
    }

    public JDBCLoginService(String name, IdentityService identityService, String config) throws IOException {
        setName(name);
        setIdentityService(identityService);
        setConfig(config);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        Properties properties = new Properties();
        InputStream in = Resource.newResource(this._config).getInputStream();
        try {
            properties.load(in);
            if (in != null) {
                in.close();
            }
            this._jdbcDriver = properties.getProperty("jdbcdriver");
            this._url = properties.getProperty("url");
            this._userName = properties.getProperty(SendMailJob.PROP_USERNAME);
            this._password = properties.getProperty("password");
            String userTable = properties.getProperty("usertable");
            this._userTableKey = properties.getProperty("usertablekey");
            String userTableUserField = properties.getProperty("usertableuserfield");
            this._userTablePasswordField = properties.getProperty("usertablepasswordfield");
            String roleTable = properties.getProperty("roletable");
            String roleTableKey = properties.getProperty("roletablekey");
            this._roleTableRoleField = properties.getProperty("roletablerolefield");
            String userRoleTable = properties.getProperty("userroletable");
            String userRoleTableUserKey = properties.getProperty("userroletableuserkey");
            String userRoleTableRoleKey = properties.getProperty("userroletablerolekey");
            if (this._jdbcDriver == null || this._jdbcDriver.equals("") || this._url == null || this._url.equals("") || this._userName == null || this._userName.equals("") || this._password == null) {
                LOG.warn("UserRealm " + getName() + " has not been properly configured", new Object[0]);
            }
            this._userSql = "select " + this._userTableKey + "," + this._userTablePasswordField + " from " + userTable + " where " + userTableUserField + " = ?";
            this._roleSql = "select r." + this._roleTableRoleField + " from " + roleTable + " r, " + userRoleTable + " u where u." + userRoleTableUserKey + " = ? and r." + roleTableKey + " = u." + userRoleTableRoleKey;
            Loader.loadClass(this._jdbcDriver).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            doStart();
        } catch (Throwable th) {
            if (in != null) {
                try {
                    in.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String getConfig() {
        return this._config;
    }

    public void setConfig(String config) {
        if (isRunning()) {
            throw new IllegalStateException("Running");
        }
        this._config = config;
    }

    public void connectDatabase() {
        try {
            Class.forName(this._jdbcDriver);
            this._con = DriverManager.getConnection(this._url, this._userName, this._password);
        } catch (ClassNotFoundException e) {
            LOG.warn("UserRealm " + getName() + " could not connect to database; will try later", e);
        } catch (SQLException e2) {
            LOG.warn("UserRealm " + getName() + " could not connect to database; will try later", e2);
        }
    }

    @Override // org.eclipse.jetty.security.AbstractLoginService
    public AbstractLoginService.UserPrincipal loadUserInfo(String username) {
        try {
            if (null == this._con) {
                connectDatabase();
            }
            if (null == this._con) {
                throw new SQLException("Can't connect to database");
            }
            PreparedStatement stat1 = this._con.prepareStatement(this._userSql);
            stat1.setObject(1, username);
            ResultSet rs1 = stat1.executeQuery();
            try {
                if (rs1.next()) {
                    JDBCUserPrincipal jDBCUserPrincipal = new JDBCUserPrincipal(username, Credential.getCredential(rs1.getString(this._userTablePasswordField)), rs1.getInt(this._userTableKey));
                    if (rs1 != null) {
                        rs1.close();
                    }
                    if (stat1 != null) {
                        stat1.close();
                    }
                    return jDBCUserPrincipal;
                }
                if (rs1 != null) {
                    rs1.close();
                }
                if (stat1 != null) {
                    stat1.close();
                }
                return null;
            } catch (Throwable th) {
                if (rs1 != null) {
                    try {
                        rs1.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (SQLException e) {
            LOG.warn("UserRealm " + getName() + " could not load user information from database", e);
            closeConnection();
            return null;
        }
    }

    @Override // org.eclipse.jetty.security.AbstractLoginService
    public String[] loadRoleInfo(AbstractLoginService.UserPrincipal user) {
        JDBCUserPrincipal jdbcUser = (JDBCUserPrincipal) user;
        try {
            if (null == this._con) {
                connectDatabase();
            }
            if (null == this._con) {
                throw new SQLException("Can't connect to database");
            }
            List<String> roles = new ArrayList<>();
            PreparedStatement stat2 = this._con.prepareStatement(this._roleSql);
            stat2.setInt(1, jdbcUser.getUserKey());
            ResultSet rs2 = stat2.executeQuery();
            while (rs2.next()) {
                try {
                    roles.add(rs2.getString(this._roleTableRoleField));
                } catch (Throwable th) {
                    if (rs2 != null) {
                        try {
                            rs2.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            String[] strArr = (String[]) roles.toArray(new String[roles.size()]);
            if (rs2 != null) {
                rs2.close();
            }
            if (stat2 != null) {
                stat2.close();
            }
            return strArr;
        } catch (SQLException e) {
            LOG.warn("UserRealm " + getName() + " could not load user information from database", e);
            closeConnection();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        closeConnection();
        doStop();
    }

    private void closeConnection() {
        if (this._con != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Closing db connection for JDBCUserRealm", new Object[0]);
            }
            try {
                this._con.close();
            } catch (Exception e) {
                LOG.ignore(e);
            }
        }
        this._con = null;
    }
}
