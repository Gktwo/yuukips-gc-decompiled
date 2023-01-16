package com.mchange.p009v2.c3p0.util;

import com.mchange.p009v2.c3p0.C3P0ProxyConnection;
import com.mchange.p009v2.sql.SqlUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.util.TestUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/util/TestUtils.class */
public final class TestUtils {
    private static final Method OBJECT_EQUALS;
    private static final Method IDENTITY_HASHCODE;
    private static final Method IPCFP;

    static {
        try {
            OBJECT_EQUALS = Object.class.getMethod("equals", Object.class);
            IDENTITY_HASHCODE = System.class.getMethod("identityHashCode", Object.class);
            IPCFP = TestUtils.class.getMethod("isPhysicalConnectionForProxy", Connection.class, C3P0ProxyConnection.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Huh? Can't reflectively get ahold of expected methods?");
        }
    }

    public static boolean samePhysicalConnection(C3P0ProxyConnection con1, C3P0ProxyConnection con2) throws SQLException {
        try {
            return ((Boolean) con1.rawConnectionOperation(IPCFP, null, new Object[]{C3P0ProxyConnection.RAW_CONNECTION, con2})).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw SqlUtils.toSQLException(e);
        }
    }

    public static boolean isPhysicalConnectionForProxy(Connection physicalConnection, C3P0ProxyConnection proxy) throws SQLException {
        try {
            return ((Boolean) proxy.rawConnectionOperation(OBJECT_EQUALS, physicalConnection, new Object[]{C3P0ProxyConnection.RAW_CONNECTION})).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw SqlUtils.toSQLException(e);
        }
    }

    public static int physicalConnectionIdentityHashCode(C3P0ProxyConnection conn) throws SQLException {
        try {
            return ((Integer) conn.rawConnectionOperation(IDENTITY_HASHCODE, null, new Object[]{C3P0ProxyConnection.RAW_CONNECTION})).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw SqlUtils.toSQLException(e);
        }
    }

    public static DataSource unreliableCommitDataSource(DataSource ds) throws Exception {
        return (DataSource) Proxy.newProxyInstance(TestUtils.class.getClassLoader(), new Class[]{DataSource.class}, new StupidDataSourceInvocationHandler(ds));
    }

    private TestUtils() {
    }

    /* renamed from: com.mchange.v2.c3p0.util.TestUtils$StupidDataSourceInvocationHandler */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/util/TestUtils$StupidDataSourceInvocationHandler.class */
    static class StupidDataSourceInvocationHandler implements InvocationHandler {

        /* renamed from: ds */
        DataSource f407ds;

        /* renamed from: r */
        Random f408r = new Random();

        StupidDataSourceInvocationHandler(DataSource ds) {
            this.f407ds = ds;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (!"getConnection".equals(method.getName())) {
                return method.invoke(this.f407ds, args);
            }
            return Proxy.newProxyInstance(TestUtils.class.getClassLoader(), new Class[]{Connection.class}, new StupidConnectionInvocationHandler((Connection) method.invoke(this.f407ds, args)));
        }
    }

    /* renamed from: com.mchange.v2.c3p0.util.TestUtils$StupidConnectionInvocationHandler */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/util/TestUtils$StupidConnectionInvocationHandler.class */
    static class StupidConnectionInvocationHandler implements InvocationHandler {
        Connection conn;

        /* renamed from: r */
        Random f406r = new Random();
        boolean invalid = false;

        StupidConnectionInvocationHandler(Connection conn) {
            this.conn = conn;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("close".equals(method.getName())) {
                if (this.invalid) {
                    new Exception("Duplicate close() called on Connection!!!").printStackTrace();
                    return null;
                }
                this.invalid = true;
                return null;
            } else if (this.invalid) {
                throw new SQLException("Connection closed -- cannot " + method.getName());
            } else if ("commit".equals(method.getName()) && this.f406r.nextInt(100) == 0) {
                this.conn.rollback();
                throw new SQLException("Random commit exception!!!");
            } else if (this.f406r.nextInt(200) != 0) {
                return method.invoke(this.conn, args);
            } else {
                this.conn.rollback();
                this.conn.close();
                throw new SQLException("Random Fatal Exception Occurred!!!");
            }
        }
    }
}
