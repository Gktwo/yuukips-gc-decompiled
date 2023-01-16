package com.mongodb.management;

import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;

/* loaded from: grasscutter.jar:com/mongodb/management/JMXMBeanServer.class */
class JMXMBeanServer implements MBeanServer {
    private static final Logger LOGGER = Loggers.getLogger("management");
    private final MBeanServer server = ManagementFactory.getPlatformMBeanServer();

    @Override // com.mongodb.management.MBeanServer
    public void registerMBean(Object mBean, String mBeanName) {
        try {
            this.server.registerMBean(mBean, new ObjectName(mBeanName));
        } catch (Exception e) {
            LOGGER.warn("Unable to register MBean " + mBeanName, e);
        }
    }

    @Override // com.mongodb.management.MBeanServer
    public void unregisterMBean(String mBeanName) {
        try {
            ObjectName objectName = new ObjectName(mBeanName);
            if (this.server.isRegistered(objectName)) {
                this.server.unregisterMBean(objectName);
            }
        } catch (Exception e) {
            LOGGER.warn("Unable to unregister MBean " + mBeanName, e);
        }
    }
}
