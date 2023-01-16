package com.mchange.p009v2.c3p0;

import com.mchange.p009v2.c3p0.cfg.C3P0ConfigUtils;
import com.mchange.p009v2.c3p0.impl.C3P0Defaults;
import com.mchange.p009v2.c3p0.impl.IdentityTokenized;
import com.mchange.p009v2.c3p0.impl.IdentityTokenizedCoalesceChecker;
import com.mchange.p009v2.c3p0.management.ManagementCoordinator;
import com.mchange.p009v2.c3p0.management.NullManagementCoordinator;
import com.mchange.p009v2.coalesce.CoalesceChecker;
import com.mchange.p009v2.coalesce.Coalescer;
import com.mchange.p009v2.coalesce.CoalescerFactory;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.sql.SqlUtils;
import com.mchange.p009v2.util.DoubleWeakHashMap;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: com.mchange.v2.c3p0.C3P0Registry */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/C3P0Registry.class */
public final class C3P0Registry {
    private static final String MC_PARAM = "com.mchange.v2.c3p0.management.ManagementCoordinator";
    static final MLogger logger = MLog.getLogger(C3P0Registry.class);
    static boolean banner_printed = false;
    static boolean registry_mbean_registered = false;

    /* renamed from: CC */
    private static CoalesceChecker f397CC = IdentityTokenizedCoalesceChecker.INSTANCE;
    private static Coalescer idtCoalescer = CoalescerFactory.createCoalescer(f397CC, true, false);
    private static Map tokensToTokenized = new DoubleWeakHashMap();
    private static HashSet unclosedPooledDataSources = new HashSet();
    private static final Map classNamesToConnectionTesters = new HashMap();
    private static final Map classNamesToConnectionCustomizers = new HashMap();

    /* renamed from: mc */
    private static ManagementCoordinator f398mc;

    static {
        resetConnectionTesterCache();
        String userManagementCoordinator = C3P0ConfigUtils.getPropsFileConfigProperty(MC_PARAM);
        if (userManagementCoordinator != null) {
            try {
                f398mc = (ManagementCoordinator) Class.forName(userManagementCoordinator).newInstance();
            } catch (Exception e) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "Could not instantiate user-specified ManagementCoordinator " + userManagementCoordinator + ". Using NullManagementCoordinator (c3p0 JMX management disabled!)", (Throwable) e);
                }
                f398mc = new NullManagementCoordinator();
            }
        } else {
            try {
                Class.forName("java.lang.management.ManagementFactory");
                f398mc = (ManagementCoordinator) Class.forName("com.mchange.v2.c3p0.management.ActiveManagementCoordinator").newInstance();
            } catch (Exception e2) {
                if (logger.isLoggable(MLevel.INFO)) {
                    logger.log(MLevel.INFO, "jdk1.5 management interfaces unavailable... JMX support disabled.", (Throwable) e2);
                }
                f398mc = new NullManagementCoordinator();
            }
        }
    }

    public static void markConfigRefreshed() {
        resetConnectionTesterCache();
    }

    public static ConnectionTester getDefaultConnectionTester() {
        return getConnectionTester(C3P0Defaults.connectionTesterClassName());
    }

    public static ConnectionTester getConnectionTester(String className) {
        ConnectionTester out;
        try {
            synchronized (classNamesToConnectionTesters) {
                out = (ConnectionTester) classNamesToConnectionTesters.get(className);
                if (out == null) {
                    out = (ConnectionTester) Class.forName(className).newInstance();
                    classNamesToConnectionTesters.put(className, out);
                }
            }
            return out;
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Could not create for find ConnectionTester with class name '" + className + "'. Using default.", (Throwable) e);
            }
            return recreateDefaultConnectionTester();
        }
    }

    private static ConnectionTester recreateDefaultConnectionTester() {
        try {
            return (ConnectionTester) Class.forName(C3P0Defaults.connectionTesterClassName()).newInstance();
        } catch (Exception e) {
            throw new Error("Huh? We cannot instantiate the hard-coded, default ConnectionTester? We are very broken.", e);
        }
    }

    private static void resetConnectionTesterCache() {
        synchronized (classNamesToConnectionTesters) {
            classNamesToConnectionTesters.clear();
            classNamesToConnectionTesters.put(C3P0Defaults.connectionTesterClassName(), recreateDefaultConnectionTester());
        }
    }

    public static ConnectionCustomizer getConnectionCustomizer(String className) throws SQLException {
        ConnectionCustomizer out;
        if (className == null || className.trim().equals("")) {
            return null;
        }
        try {
            synchronized (classNamesToConnectionCustomizers) {
                out = (ConnectionCustomizer) classNamesToConnectionCustomizers.get(className);
                if (out == null) {
                    out = (ConnectionCustomizer) Class.forName(className).newInstance();
                    classNamesToConnectionCustomizers.put(className, out);
                }
            }
            return out;
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Could not create for find ConnectionCustomizer with class name '" + className + "'.", (Throwable) e);
            }
            throw SqlUtils.toSQLException(e);
        }
    }

    private static void banner() {
        if (!banner_printed) {
            if (logger.isLoggable(MLevel.INFO)) {
                logger.info("Initializing c3p0-0.9.5.4 [built 23-March-2019 23:00:48 -0700; debug? true; trace: 10]");
            }
            banner_printed = true;
        }
    }

    private static void attemptRegisterRegistryMBean() {
        if (!registry_mbean_registered) {
            f398mc.attemptManageC3P0Registry();
            registry_mbean_registered = true;
        }
    }

    private static boolean isIncorporated(IdentityTokenized idt) {
        return tokensToTokenized.keySet().contains(idt.getIdentityToken());
    }

    private static void incorporate(IdentityTokenized idt) {
        tokensToTokenized.put(idt.getIdentityToken(), idt);
        if (idt instanceof PooledDataSource) {
            unclosedPooledDataSources.add(idt);
            f398mc.attemptManagePooledDataSource((PooledDataSource) idt);
        }
    }

    private static synchronized Object findTokenized(String identityToken) {
        return tokensToTokenized.get(identityToken);
    }

    public static Map extensionsForToken(String pooledDataSourceIdentityToken) throws NoSuchElementException, IllegalArgumentException {
        Object o = findTokenized(pooledDataSourceIdentityToken);
        if (o == null) {
            throw new NoSuchElementException("No object is known to be identified by token '" + pooledDataSourceIdentityToken + "'. Either it is a bad token, or the object was no longer in use and has been garbage collected.");
        } else if (o instanceof PooledDataSource) {
            return ((PooledDataSource) o).getExtensions();
        } else {
            throw new IllegalArgumentException("The object '" + o + "', identified by token '" + pooledDataSourceIdentityToken + "', is not a PooledDataSource and therefore cannot have extensions.");
        }
    }

    public static synchronized IdentityTokenized reregister(IdentityTokenized idt) {
        if (idt instanceof PooledDataSource) {
            banner();
            attemptRegisterRegistryMBean();
        }
        if (idt.getIdentityToken() == null) {
            throw new RuntimeException("[c3p0 issue] The identityToken of a registered object should be set prior to registration.");
        }
        IdentityTokenized coalesceCheck = (IdentityTokenized) idtCoalescer.coalesce(idt);
        if (!isIncorporated(coalesceCheck)) {
            incorporate(coalesceCheck);
        }
        return coalesceCheck;
    }

    public static synchronized void markClosed(PooledDataSource pds) {
        unclosedPooledDataSources.remove(pds);
        f398mc.attemptUnmanagePooledDataSource(pds);
        if (unclosedPooledDataSources.isEmpty()) {
            f398mc.attemptUnmanageC3P0Registry();
            registry_mbean_registered = false;
        }
    }

    public static synchronized Set getPooledDataSources() {
        return (Set) unclosedPooledDataSources.clone();
    }

    public static synchronized Set pooledDataSourcesByName(String dataSourceName) {
        Set out = new HashSet();
        Iterator ii = unclosedPooledDataSources.iterator();
        while (ii.hasNext()) {
            PooledDataSource pds = (PooledDataSource) ii.next();
            if (pds.getDataSourceName().equals(dataSourceName)) {
                out.add(pds);
            }
        }
        return out;
    }

    public static synchronized PooledDataSource pooledDataSourceByName(String dataSourceName) {
        Iterator ii = unclosedPooledDataSources.iterator();
        while (ii.hasNext()) {
            PooledDataSource pds = (PooledDataSource) ii.next();
            if (pds.getDataSourceName().equals(dataSourceName)) {
                return pds;
            }
        }
        return null;
    }

    public static synchronized Set allIdentityTokens() {
        return Collections.unmodifiableSet(tokensToTokenized.keySet());
    }

    public static synchronized Set allIdentityTokenized() {
        HashSet out = new HashSet();
        out.addAll(tokensToTokenized.values());
        return Collections.unmodifiableSet(out);
    }

    public static synchronized Set allPooledDataSources() {
        return Collections.unmodifiableSet(unclosedPooledDataSources);
    }

    public static synchronized int getNumPooledDataSources() {
        return unclosedPooledDataSources.size();
    }

    public static synchronized int getNumPoolsAllDataSources() throws SQLException {
        int count = 0;
        Iterator ii = unclosedPooledDataSources.iterator();
        while (ii.hasNext()) {
            count += ((PooledDataSource) ii.next()).getNumUserPools();
        }
        return count;
    }

    public synchronized int getNumThreadsAllThreadPools() throws SQLException {
        int count = 0;
        Iterator ii = unclosedPooledDataSources.iterator();
        while (ii.hasNext()) {
            count += ((PooledDataSource) ii.next()).getNumHelperThreads();
        }
        return count;
    }

    public static synchronized Map getConfigExtensionsForPooledDataSource(String identityToken) throws SQLException {
        try {
            PooledDataSource pds = (PooledDataSource) tokensToTokenized.get(identityToken);
            if (pds != null) {
                return pds.getExtensions();
            }
            throw new SQLException("No DataSource or registered IdentityTokenized has identityToken '" + identityToken + "'.");
        } catch (ClassCastException e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Tried to get config extensions for an entity that is not a PooledDataSource. (Extensions are available only on PooledDataSources.) Thowing SQLException.", (Throwable) e);
            }
            throw SqlUtils.toSQLException("Tried to get config extensions for an entity that is not a PooledDataSource. (Extensions are available only on PooledDataSources.)", e);
        }
    }
}
