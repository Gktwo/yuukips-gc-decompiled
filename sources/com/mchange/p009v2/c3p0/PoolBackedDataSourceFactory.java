package com.mchange.p009v2.c3p0;

import com.mchange.p009v2.sql.SqlUtils;
import java.sql.SQLException;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.PoolBackedDataSourceFactory */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/PoolBackedDataSourceFactory.class */
public final class PoolBackedDataSourceFactory {
    public static DataSource createReferenceable(DataSource unpooledDataSource, int minPoolSize, int maxPoolSize, int acquireIncrement, int maxIdleTime, int maxStatements, String factoryLocation) throws SQLException {
        try {
            WrapperConnectionPoolDataSource cpds = new WrapperConnectionPoolDataSource();
            cpds.setNestedDataSource(unpooledDataSource);
            cpds.setMinPoolSize(minPoolSize);
            cpds.setMaxPoolSize(maxPoolSize);
            cpds.setAcquireIncrement(acquireIncrement);
            cpds.setMaxIdleTime(maxIdleTime);
            cpds.setMaxStatements(maxStatements);
            cpds.setFactoryClassLocation(factoryLocation);
            PoolBackedDataSource out = new PoolBackedDataSource();
            out.setConnectionPoolDataSource(cpds);
            return out;
        } catch (Exception e) {
            throw SqlUtils.toSQLException(e);
        }
    }

    public static DataSource createReferenceable(DataSource unpooledDataSource, String factoryLocation) throws SQLException {
        try {
            WrapperConnectionPoolDataSource cpds = new WrapperConnectionPoolDataSource();
            cpds.setNestedDataSource(unpooledDataSource);
            cpds.setFactoryClassLocation(factoryLocation);
            PoolBackedDataSource out = new PoolBackedDataSource();
            out.setConnectionPoolDataSource(cpds);
            return out;
        } catch (Exception e) {
            throw SqlUtils.toSQLException(e);
        }
    }

    public static DataSource createReferenceable(String jdbcDriverClass, String jdbcUrl, String user, String password, int minPoolSize, int maxPoolSize, int acquireIncrement, int maxIdleTime, int maxStatements, String factoryLocation) throws SQLException {
        return createReferenceable(DriverManagerDataSourceFactory.create(jdbcDriverClass, jdbcUrl, user, password), minPoolSize, maxPoolSize, acquireIncrement, maxIdleTime, maxStatements, factoryLocation);
    }

    public static DataSource createReferenceable(String jdbcDriverClass, String jdbcUrl, String user, String password, String factoryLocation) throws SQLException {
        return createReferenceable(DriverManagerDataSourceFactory.create(jdbcDriverClass, jdbcUrl, user, password), factoryLocation);
    }

    public static DataSource createSerializable(DataSource unpooledDataSource, int minPoolSize, int maxPoolSize, int acquireIncrement, int maxIdleTime, int maxStatements) throws SQLException {
        try {
            WrapperConnectionPoolDataSource cpds = new WrapperConnectionPoolDataSource();
            cpds.setNestedDataSource(unpooledDataSource);
            cpds.setMinPoolSize(minPoolSize);
            cpds.setMaxPoolSize(maxPoolSize);
            cpds.setAcquireIncrement(acquireIncrement);
            cpds.setMaxIdleTime(maxIdleTime);
            cpds.setMaxStatements(maxStatements);
            PoolBackedDataSource out = new PoolBackedDataSource();
            out.setConnectionPoolDataSource(cpds);
            return out;
        } catch (Exception e) {
            throw SqlUtils.toSQLException(e);
        }
    }

    public static DataSource createSerializable(DataSource unpooledDataSource) throws SQLException {
        try {
            WrapperConnectionPoolDataSource cpds = new WrapperConnectionPoolDataSource();
            cpds.setNestedDataSource(unpooledDataSource);
            PoolBackedDataSource out = new PoolBackedDataSource();
            out.setConnectionPoolDataSource(cpds);
            return out;
        } catch (Exception e) {
            throw SqlUtils.toSQLException(e);
        }
    }

    public static DataSource createSerializable(String jdbcDriverClass, String jdbcUrl, String user, String password, int minPoolSize, int maxPoolSize, int acquireIncrement, int maxIdleTime, int maxStatements) throws SQLException {
        return createSerializable(DriverManagerDataSourceFactory.create(jdbcDriverClass, jdbcUrl, user, password), minPoolSize, maxPoolSize, acquireIncrement, maxIdleTime, maxStatements);
    }

    public static DataSource createSerializable(String jdbcDriverClass, String jdbcUrl, String user, String password) throws SQLException {
        return createSerializable(DriverManagerDataSourceFactory.create(jdbcDriverClass, jdbcUrl, user, password));
    }

    public static DataSource create(DataSource unpooledDataSource, int minPoolSize, int maxPoolSize, int acquireIncrement, int maxIdleTime, int maxStatements, String factoryLocation) throws SQLException {
        return createReferenceable(unpooledDataSource, minPoolSize, maxPoolSize, acquireIncrement, maxIdleTime, maxStatements, factoryLocation);
    }

    public static DataSource create(DataSource unpooledDataSource, int minPoolSize, int maxPoolSize, int acquireIncrement, int maxIdleTime, int maxStatements) throws SQLException {
        return createReferenceable(unpooledDataSource, minPoolSize, maxPoolSize, acquireIncrement, maxIdleTime, maxStatements, null);
    }

    public static DataSource create(DataSource unpooledDataSource) throws SQLException {
        return createSerializable(unpooledDataSource);
    }

    public static DataSource create(String jdbcDriverClass, String jdbcUrl, String user, String password, int minPoolSize, int maxPoolSize, int acquireIncrement, int maxIdleTime, int maxStatements, String factoryLocation) throws SQLException {
        return createReferenceable(jdbcDriverClass, jdbcUrl, user, password, minPoolSize, maxPoolSize, acquireIncrement, maxIdleTime, maxStatements, factoryLocation);
    }

    public static DataSource create(String jdbcDriverClass, String jdbcUrl, String user, String password, int minPoolSize, int maxPoolSize, int acquireIncrement, int maxIdleTime, int maxStatements) throws SQLException {
        return createReferenceable(jdbcDriverClass, jdbcUrl, user, password, minPoolSize, maxPoolSize, acquireIncrement, maxIdleTime, maxStatements, null);
    }

    public static DataSource create(String jdbcUrl, String user, String password, int minPoolSize, int maxPoolSize, int acquireIncrement, int maxIdleTime, int maxStatements, String factoryLocation) throws SQLException {
        return create(null, jdbcUrl, user, password, minPoolSize, maxPoolSize, acquireIncrement, maxIdleTime, maxStatements, factoryLocation);
    }

    public static DataSource create(String jdbcUrl, String user, String password, int minPoolSize, int maxPoolSize, int acquireIncrement, int maxIdleTime, int maxStatements) throws SQLException {
        return create(null, jdbcUrl, user, password, minPoolSize, maxPoolSize, acquireIncrement, maxIdleTime, maxStatements, null);
    }

    public static DataSource create(String jdbcDriverClass, String jdbcUrl, String user, String password) throws SQLException {
        return createSerializable(jdbcDriverClass, jdbcUrl, user, password);
    }

    public static DataSource create(String jdbcUrl, String user, String password) throws SQLException {
        return create(null, jdbcUrl, user, password);
    }

    private PoolBackedDataSourceFactory() {
    }
}
