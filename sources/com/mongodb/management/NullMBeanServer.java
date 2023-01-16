package com.mongodb.management;

/* loaded from: grasscutter.jar:com/mongodb/management/NullMBeanServer.class */
class NullMBeanServer implements MBeanServer {
    @Override // com.mongodb.management.MBeanServer
    public void unregisterMBean(String mBeanName) {
    }

    @Override // com.mongodb.management.MBeanServer
    public void registerMBean(Object mBean, String mBeanName) {
    }
}
