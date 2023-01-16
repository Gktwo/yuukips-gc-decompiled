package org.quartz.simpl;

import java.net.InetAddress;
import org.quartz.SchedulerException;
import org.quartz.spi.InstanceIdGenerator;

/* loaded from: grasscutter.jar:org/quartz/simpl/HostnameInstanceIdGenerator.class */
public class HostnameInstanceIdGenerator implements InstanceIdGenerator {
    @Override // org.quartz.spi.InstanceIdGenerator
    public String generateInstanceId() throws SchedulerException {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            throw new SchedulerException("Couldn't get host name!", e);
        }
    }
}
