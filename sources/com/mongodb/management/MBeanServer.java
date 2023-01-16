package com.mongodb.management;

/* loaded from: grasscutter.jar:com/mongodb/management/MBeanServer.class */
interface MBeanServer {
    void unregisterMBean(String str);

    void registerMBean(Object obj, String str);
}
