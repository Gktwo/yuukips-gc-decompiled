package org.quartz.jobs.p027ee.jms;

import java.util.Hashtable;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.quartz.JobDataMap;

/* renamed from: org.quartz.jobs.ee.jms.JmsHelper */
/* loaded from: grasscutter.jar:org/quartz/jobs/ee/jms/JmsHelper.class */
public final class JmsHelper {
    public static final String CREDENTIALS = "java.naming.security.credentials";
    public static final String INITIAL_CONTEXT_FACTORY = "java.naming.factory.initial";
    public static final String JMS_ACK_MODE = "jms.acknowledge";
    public static final String JMS_CONNECTION_FACTORY_JNDI = "jms.connection.factory";
    public static final String JMS_DESTINATION_JNDI = "jms.destination";
    public static final String JMS_MSG_FACTORY_CLASS_NAME = "jms.message.factory.class.name";
    public static final String JMS_PASSWORD = "jms.password";
    public static final String JMS_USE_TXN = "jms.use.transaction";
    public static final String JMS_USER = "jms.user";
    public static final String PRINCIPAL = "java.naming.security.principal";
    public static final String PROVIDER_URL = "java.naming.provider.url";

    public static void closeResource(Object resource) {
        if (resource != null) {
            try {
                resource.getClass().getMethod("close", new Class[0]).invoke(resource, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    public static InitialContext getInitialContext(JobDataMap dataMap) throws NamingException {
        Hashtable<String, String> params = new Hashtable<>(4);
        String initialContextFactory = dataMap.getString("java.naming.factory.initial");
        if (initialContextFactory != null) {
            params.put("java.naming.factory.initial", initialContextFactory);
        }
        String providerUrl = dataMap.getString("java.naming.provider.url");
        if (providerUrl != null) {
            params.put("java.naming.provider.url", providerUrl);
        }
        String principal = dataMap.getString("java.naming.security.principal");
        if (principal != null) {
            params.put("java.naming.security.principal", principal);
        }
        String credentials = dataMap.getString("java.naming.security.credentials");
        if (credentials != null) {
            params.put("java.naming.security.credentials", credentials);
        }
        if (params.size() == 0) {
            return new InitialContext();
        }
        return new InitialContext(params);
    }

    public static JmsMessageFactory getMessageFactory(String name) throws JmsJobException {
        try {
            return (JmsMessageFactory) Class.forName(name).newInstance();
        } catch (Exception e) {
            throw new JmsJobException(e.getMessage(), e);
        }
    }

    public static boolean isDestinationSecure(JobDataMap dataMap) {
        return (dataMap.getString(JMS_USER) == null || dataMap.getString(JMS_PASSWORD) == null) ? false : true;
    }

    public static boolean useTransaction(JobDataMap dataMap) {
        return dataMap.getBoolean(JMS_USE_TXN);
    }

    private JmsHelper() {
    }
}
