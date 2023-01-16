package org.quartz.utils.weblogic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.quartz.utils.ConnectionProvider;
import weblogic.jdbc.jts.Driver;

/* loaded from: grasscutter.jar:org/quartz/utils/weblogic/WeblogicConnectionProvider.class */
public class WeblogicConnectionProvider implements ConnectionProvider {
    private String poolName;
    private Driver driver;

    public WeblogicConnectionProvider(String poolName) {
        this.poolName = poolName;
    }

    @Override // org.quartz.utils.ConnectionProvider
    public Connection getConnection() throws SQLException {
        return this.driver.connect("jdbc:weblogic:jts:" + this.poolName, (Properties) null);
    }

    @Override // org.quartz.utils.ConnectionProvider
    public void initialize() throws SQLException {
        try {
            this.driver = (Driver) Driver.class.newInstance();
        } catch (Exception e) {
            throw new SQLException("Could not get weblogic pool connection with name '" + this.poolName + "': " + e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override // org.quartz.utils.ConnectionProvider
    public void shutdown() throws SQLException {
    }
}
