package com.mongodb.management;

/* loaded from: grasscutter.jar:com/mongodb/management/MBeanServerFactory.class */
final class MBeanServerFactory {
    private static final MBeanServer M_BEAN_SERVER;

    private MBeanServerFactory() {
    }

    static {
        MBeanServer tmp;
        try {
            tmp = new JMXMBeanServer();
        } catch (Throwable th) {
            tmp = new NullMBeanServer();
        }
        M_BEAN_SERVER = tmp;
    }

    /* access modifiers changed from: package-private */
    public static MBeanServer getMBeanServer() {
        return M_BEAN_SERVER;
    }
}
