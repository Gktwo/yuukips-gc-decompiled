package org.eclipse.jetty.util.log;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.annotation.ManagedAttribute;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/log/Log.class */
public class Log {
    public static final String EXCEPTION = "EXCEPTION ";
    public static final String IGNORED = "IGNORED EXCEPTION ";
    public static String __logClass;
    public static boolean __ignored;
    protected static final Properties __props = new Properties();
    private static final ConcurrentMap<String, Logger> __loggers = new ConcurrentHashMap();
    private static boolean __initialized;
    private static Logger LOG;

    static {
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.eclipse.jetty.util.log.Log.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                Log.loadProperties("jetty-logging.properties", Log.__props);
                String osName = System.getProperty("os.name");
                if (osName != null && osName.length() > 0) {
                    Log.loadProperties("jetty-logging-" + osName.toLowerCase(Locale.ENGLISH).replace(' ', '-') + ".properties", Log.__props);
                }
                Enumeration<?> propertyNames = System.getProperties().propertyNames();
                while (propertyNames.hasMoreElements()) {
                    String key = (String) propertyNames.nextElement();
                    String val = System.getProperty(key);
                    if (val != null) {
                        Log.__props.setProperty(key, val);
                    }
                }
                Log.__logClass = Log.__props.getProperty("org.eclipse.jetty.util.log.class", "org.eclipse.jetty.util.log.Slf4jLog");
                Log.__ignored = Boolean.parseBoolean(Log.__props.getProperty("org.eclipse.jetty.util.log.IGNORED", "false"));
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public static void loadProperties(String resourceName, Properties props) {
        URL testProps = Loader.getResource(resourceName);
        if (testProps != null) {
            try {
                InputStream in = testProps.openStream();
                Properties p = new Properties();
                p.load(in);
                for (Object key : p.keySet()) {
                    Object value = p.get(key);
                    if (value != null) {
                        props.put(key, value);
                    }
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.err.println("[WARN] Error loading logging config: " + testProps);
                e.printStackTrace();
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x0073
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static void initialized() {
        /*
            java.lang.Class<org.eclipse.jetty.util.log.Log> r0 = org.eclipse.jetty.util.log.Log.class
            r1 = r0
            r8 = r1
            monitor-enter(r0)
            boolean r0 = org.eclipse.jetty.util.log.Log.__initialized     // Catch: all -> 0x00b1
            if (r0 == 0) goto L_0x000e
            r0 = r8
            monitor-exit(r0)     // Catch: all -> 0x00b1
            return
        L_0x000e:
            r0 = 1
            org.eclipse.jetty.util.log.Log.__initialized = r0     // Catch: all -> 0x00b1
            java.util.Properties r0 = org.eclipse.jetty.util.log.Log.__props     // Catch: all -> 0x00b1
            java.lang.String r1 = "org.eclipse.jetty.util.log.announce"
            java.lang.String r2 = "true"
            java.lang.String r0 = r0.getProperty(r1, r2)     // Catch: all -> 0x00b1
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch: all -> 0x00b1
            r9 = r0
            java.lang.Class<org.eclipse.jetty.util.log.Log> r0 = org.eclipse.jetty.util.log.Log.class
            java.lang.String r1 = org.eclipse.jetty.util.log.Log.__logClass     // Catch: all -> 0x00b1, Throwable -> 0x0073
            java.lang.Class r0 = org.eclipse.jetty.util.Loader.loadClass(r0, r1)     // Catch: all -> 0x00b1, Throwable -> 0x0073
            r10 = r0
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.util.log.Log.LOG     // Catch: all -> 0x00b1, Throwable -> 0x0073
            if (r0 == 0) goto L_0x003c
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.util.log.Log.LOG     // Catch: all -> 0x00b1, Throwable -> 0x0073
            java.lang.Class r0 = r0.getClass()     // Catch: all -> 0x00b1, Throwable -> 0x0073
            r1 = r10
            boolean r0 = r0.equals(r1)     // Catch: all -> 0x00b1, Throwable -> 0x0073
            if (r0 != 0) goto L_0x0070
        L_0x003c:
            r0 = r10
            r1 = 0
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch: all -> 0x00b1, Throwable -> 0x0073
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r1)     // Catch: all -> 0x00b1, Throwable -> 0x0073
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: all -> 0x00b1, Throwable -> 0x0073
            java.lang.Object r0 = r0.newInstance(r1)     // Catch: all -> 0x00b1, Throwable -> 0x0073
            org.eclipse.jetty.util.log.Logger r0 = (org.eclipse.jetty.util.log.Logger) r0     // Catch: all -> 0x00b1, Throwable -> 0x0073
            org.eclipse.jetty.util.log.Log.LOG = r0     // Catch: all -> 0x00b1, Throwable -> 0x0073
            r0 = r9
            if (r0 == 0) goto L_0x0070
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.util.log.Log.LOG     // Catch: all -> 0x00b1, Throwable -> 0x0073
            java.lang.String r1 = "Logging to {} via {}"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: all -> 0x00b1, Throwable -> 0x0073
            r3 = r2
            r4 = 0
            org.eclipse.jetty.util.log.Logger r5 = org.eclipse.jetty.util.log.Log.LOG     // Catch: all -> 0x00b1, Throwable -> 0x0073
            r3[r4] = r5     // Catch: all -> 0x00b1, Throwable -> 0x0073
            r3 = r2
            r4 = 1
            r5 = r10
            java.lang.String r5 = r5.getName()     // Catch: all -> 0x00b1, Throwable -> 0x0073
            r3[r4] = r5     // Catch: all -> 0x00b1, Throwable -> 0x0073
            r0.debug(r1, r2)     // Catch: all -> 0x00b1, Throwable -> 0x0073
        L_0x0070:
            goto L_0x0078
        L_0x0073:
            r10 = move-exception
            r0 = r10
            initStandardLogging(r0)     // Catch: all -> 0x00b1
        L_0x0078:
            r0 = r9
            if (r0 == 0) goto L_0x00ac
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.util.log.Log.LOG     // Catch: all -> 0x00b1
            if (r0 == 0) goto L_0x00ac
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.util.log.Log.LOG     // Catch: all -> 0x00b1
            java.lang.String r1 = "Logging initialized @%dms to %s"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: all -> 0x00b1
            r3 = r2
            r4 = 0
            long r5 = org.eclipse.jetty.util.Uptime.getUptime()     // Catch: all -> 0x00b1
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: all -> 0x00b1
            r3[r4] = r5     // Catch: all -> 0x00b1
            r3 = r2
            r4 = 1
            org.eclipse.jetty.util.log.Logger r5 = org.eclipse.jetty.util.log.Log.LOG     // Catch: all -> 0x00b1
            java.lang.Class r5 = r5.getClass()     // Catch: all -> 0x00b1
            java.lang.String r5 = r5.getName()     // Catch: all -> 0x00b1
            r3[r4] = r5     // Catch: all -> 0x00b1
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch: all -> 0x00b1
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: all -> 0x00b1
            r0.info(r1, r2)     // Catch: all -> 0x00b1
        L_0x00ac:
            r0 = r8
            monitor-exit(r0)     // Catch: all -> 0x00b1
            goto L_0x00b6
        L_0x00b1:
            r11 = move-exception
            r0 = r8
            monitor-exit(r0)     // Catch: all -> 0x00b1
            r0 = r11
            throw r0
        L_0x00b6:
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.util.log.Log.LOG
            java.lang.String r1 = "Root Logger may not be null"
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.log.Log.initialized():void");
    }

    private static void initStandardLogging(Throwable e) {
        if (__ignored) {
            e.printStackTrace();
        }
        if (LOG == null) {
            LOG = new StdErrLog();
        }
    }

    public static Logger getLog() {
        initialized();
        return LOG;
    }

    public static void setLog(Logger log) {
        LOG = (Logger) Objects.requireNonNull(log, "Root Logger may not be null");
        __logClass = null;
    }

    public static Logger getRootLogger() {
        initialized();
        return LOG;
    }

    /* access modifiers changed from: package-private */
    public static boolean isIgnored() {
        return __ignored;
    }

    public static void setLogToParent(String name) {
        ClassLoader loader = Log.class.getClassLoader();
        if (loader == null || loader.getParent() == null) {
            setLog(getLogger(name));
            return;
        }
        try {
            setLog(new LoggerLog(loader.getParent().loadClass("org.eclipse.jetty.util.log.Log").getMethod("getLogger", String.class).invoke(null, name)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }

    public static Logger getLogger(String name) {
        initialized();
        Logger logger = null;
        if (name == null) {
            logger = LOG;
        }
        if (logger == null) {
            logger = __loggers.get(name);
        }
        if (logger == null && LOG != null) {
            logger = LOG.getLogger(name);
        }
        Objects.requireNonNull(logger, "Logger with name [" + name + "]");
        return logger;
    }

    /* access modifiers changed from: package-private */
    public static ConcurrentMap<String, Logger> getMutableLoggers() {
        return __loggers;
    }

    @ManagedAttribute("list of all instantiated loggers")
    public static Map<String, Logger> getLoggers() {
        return Collections.unmodifiableMap(__loggers);
    }

    public static Properties getProperties() {
        return __props;
    }
}
