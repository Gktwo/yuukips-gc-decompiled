package org.quartz.jobs.p027ee.ejb;

import java.util.Hashtable;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.quartz.Job;
import org.quartz.JobDataMap;

/* renamed from: org.quartz.jobs.ee.ejb.EJBInvokerJob */
/* loaded from: grasscutter.jar:org/quartz/jobs/ee/ejb/EJBInvokerJob.class */
public class EJBInvokerJob implements Job {
    public static final String EJB_JNDI_NAME_KEY = "ejb";
    public static final String EJB_METHOD_KEY = "method";
    public static final String EJB_ARG_TYPES_KEY = "argTypes";
    public static final String EJB_ARGS_KEY = "args";
    public static final String INITIAL_CONTEXT_FACTORY = "java.naming.factory.initial";
    public static final String PROVIDER_URL = "java.naming.provider.url";
    public static final String PRINCIPAL = "java.naming.security.principal";
    public static final String CREDENTIALS = "java.naming.security.credentials";

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:26:0x00c7
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.quartz.Job
    public void execute(org.quartz.JobExecutionContext r6) throws org.quartz.JobExecutionException {
        /*
        // Method dump skipped, instructions count: 428
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.jobs.p027ee.ejb.EJBInvokerJob.execute(org.quartz.JobExecutionContext):void");
    }

    protected InitialContext getInitialContext(JobDataMap jobDataMap) throws NamingException {
        Hashtable<String, String> params = new Hashtable<>(2);
        String initialContextFactory = jobDataMap.getString("java.naming.factory.initial");
        if (initialContextFactory != null) {
            params.put("java.naming.factory.initial", initialContextFactory);
        }
        String providerUrl = jobDataMap.getString("java.naming.provider.url");
        if (providerUrl != null) {
            params.put("java.naming.provider.url", providerUrl);
        }
        String principal = jobDataMap.getString("java.naming.security.principal");
        if (principal != null) {
            params.put("java.naming.security.principal", principal);
        }
        String credentials = jobDataMap.getString("java.naming.security.credentials");
        if (credentials != null) {
            params.put("java.naming.security.credentials", credentials);
        }
        return params.size() == 0 ? new InitialContext() : new InitialContext(params);
    }
}
