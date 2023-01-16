package org.quartz.utils;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.quartz.SchedulerException;

/* loaded from: grasscutter.jar:org/quartz/utils/HikariCpPoolingConnectionProvider.class */
public class HikariCpPoolingConnectionProvider implements PoolingConnectionProvider {
    public static final String POOLING_PROVIDER_NAME = "hikaricp";
    private static final String DB_DISCARD_IDLE_CONNECTIONS_SECONDS = "discardIdleConnectionsSeconds";
    private HikariDataSource datasource;

    public HikariCpPoolingConnectionProvider(String dbDriver, String dbURL, String dbUser, String dbPassword, int maxConnections, String dbValidationQuery) throws SQLException, SchedulerException {
        initialize(dbDriver, dbURL, dbUser, dbPassword, maxConnections, dbValidationQuery, 0);
    }

    public HikariCpPoolingConnectionProvider(Properties config) throws SchedulerException, SQLException {
        PropertiesParser cfg = new PropertiesParser(config);
        initialize(cfg.getStringProperty("driver"), cfg.getStringProperty("URL"), cfg.getStringProperty("user", ""), cfg.getStringProperty("password", ""), cfg.getIntProperty("maxConnections", 10), cfg.getStringProperty("validationQuery"), cfg.getIntProperty(DB_DISCARD_IDLE_CONNECTIONS_SECONDS, 0));
    }

    private void initialize(String dbDriver, String dbURL, String dbUser, String dbPassword, int maxConnections, String dbValidationQuery, int maxIdleSeconds) throws SQLException, SchedulerException {
        if (dbURL == null) {
            throw new SQLException("DBPool could not be created: DB URL cannot be null");
        } else if (dbDriver == null) {
            throw new SQLException("DBPool '" + dbURL + "' could not be created: DB driver class name cannot be null!");
        } else if (maxConnections < 0) {
            throw new SQLException("DBPool '" + dbURL + "' could not be created: Max connections must be greater than zero!");
        } else {
            this.datasource = new HikariDataSource();
            this.datasource.setDriverClassName(dbDriver);
            this.datasource.setJdbcUrl(dbURL);
            this.datasource.setUsername(dbUser);
            this.datasource.setPassword(dbPassword);
            this.datasource.setMaximumPoolSize(maxConnections);
            this.datasource.setIdleTimeout((long) maxIdleSeconds);
            if (dbValidationQuery != null) {
                this.datasource.setConnectionTestQuery(dbValidationQuery);
            }
        }
    }

    @Override // org.quartz.utils.PoolingConnectionProvider
    public HikariDataSource getDataSource() {
        return this.datasource;
    }

    @Override // org.quartz.utils.ConnectionProvider
    public Connection getConnection() throws SQLException {
        return this.datasource.getConnection();
    }

    @Override // org.quartz.utils.ConnectionProvider
    public void shutdown() throws SQLException {
        this.datasource.close();
    }

    @Override // org.quartz.utils.ConnectionProvider
    public void initialize() throws SQLException {
    }
}
