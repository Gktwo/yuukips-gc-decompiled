package org.quartz.p026ee.jmx.jboss;

import java.util.Arrays;
import java.util.Properties;
import javax.management.AttributeList;
import javax.management.MBeanServerConnection;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.quartz.SchedulerException;
import org.quartz.impl.RemoteMBeanScheduler;

/* renamed from: org.quartz.ee.jmx.jboss.JBoss4RMIRemoteMBeanScheduler */
/* loaded from: grasscutter.jar:org/quartz/ee/jmx/jboss/JBoss4RMIRemoteMBeanScheduler.class */
public class JBoss4RMIRemoteMBeanScheduler extends RemoteMBeanScheduler {
    private static final String DEFAULT_PROVIDER_URL = "jnp://localhost:1099";
    private static final String RMI_ADAPTOR_JNDI_NAME = "jmx/rmi/RMIAdaptor";
    private MBeanServerConnection server = null;
    private String providerURL = DEFAULT_PROVIDER_URL;

    public void setProviderURL(String providerURL) {
        this.providerURL = providerURL;
    }

    @Override // org.quartz.impl.RemoteMBeanScheduler
    public void initialize() throws SchedulerException {
        InitialContext ctx;
        try {
            ctx = null;
            try {
                ctx = new InitialContext(getContextProperties());
                this.server = (MBeanServerConnection) ctx.lookup(RMI_ADAPTOR_JNDI_NAME);
                if (ctx != null) {
                    try {
                        ctx.close();
                    } catch (NamingException e) {
                    }
                }
            } catch (Exception e2) {
                throw new SchedulerException("Failed to lookup JBoss JMX RMI Adaptor.", e2);
            }
        } catch (Throwable th) {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException e3) {
                }
            }
            throw th;
        }
    }

    protected Properties getContextProperties() {
        Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        props.put("java.naming.provider.url", this.providerURL);
        return props;
    }

    @Override // org.quartz.impl.RemoteMBeanScheduler
    protected Object getAttribute(String attribute) throws SchedulerException {
        try {
            return this.server.getAttribute(getSchedulerObjectName(), attribute);
        } catch (Exception e) {
            throw new SchedulerException("Failed to get Scheduler MBean attribute: " + attribute, e);
        }
    }

    @Override // org.quartz.impl.RemoteMBeanScheduler
    protected AttributeList getAttributes(String[] attributes) throws SchedulerException {
        try {
            return this.server.getAttributes(getSchedulerObjectName(), attributes);
        } catch (Exception e) {
            throw new SchedulerException("Failed to get Scheduler MBean attributes: " + Arrays.asList(attributes), e);
        }
    }

    @Override // org.quartz.impl.RemoteMBeanScheduler
    protected Object invoke(String operationName, Object[] params, String[] signature) throws SchedulerException {
        try {
            return this.server.invoke(getSchedulerObjectName(), operationName, params, signature);
        } catch (Exception e) {
            throw new SchedulerException("Failed to invoke Scheduler MBean operation: " + operationName, e);
        }
    }
}
