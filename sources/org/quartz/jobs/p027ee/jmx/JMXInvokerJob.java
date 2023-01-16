package org.quartz.jobs.p027ee.jmx;

import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p013io.javalin.http.sse.EmitterKt;

/* renamed from: org.quartz.jobs.ee.jmx.JMXInvokerJob */
/* loaded from: grasscutter.jar:org/quartz/jobs/ee/jmx/JMXInvokerJob.class */
public class JMXInvokerJob implements Job {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override // org.quartz.Job
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            Object[] params = null;
            String[] types = null;
            String objName = null;
            String objMethod = null;
            JobDataMap jobDataMap = context.getMergedJobDataMap();
            String[] keys = jobDataMap.getKeys();
            for (int i = 0; i < keys.length; i++) {
                String value = jobDataMap.getString(keys[i]);
                if ("JMX_OBJECTNAME".equalsIgnoreCase(keys[i])) {
                    objName = value;
                } else if ("JMX_METHOD".equalsIgnoreCase(keys[i])) {
                    objMethod = value;
                } else if ("JMX_PARAMDEFS".equalsIgnoreCase(keys[i])) {
                    String[] paramdefs = split(value, ",");
                    params = new Object[paramdefs.length];
                    types = new String[paramdefs.length];
                    for (int k = 0; k < paramdefs.length; k++) {
                        String[] parts = split(paramdefs[k], EmitterKt.COMMENT_PREFIX);
                        if (parts.length < 2) {
                            throw new Exception("Invalid parameter definition: required parts missing " + paramdefs[k]);
                        }
                        switch (parts[0].charAt(0)) {
                            case 'B':
                                params[k] = Boolean.valueOf(jobDataMap.getString(parts[1]));
                                types[k] = Boolean.class.getName();
                                break;
                            case 'D':
                                params[k] = Double.valueOf(jobDataMap.getString(parts[1]));
                                types[k] = Double.class.getName();
                                break;
                            case 'F':
                                params[k] = Float.valueOf(jobDataMap.getString(parts[1]));
                                types[k] = Float.class.getName();
                                break;
                            case 'I':
                                params[k] = Integer.valueOf(jobDataMap.getString(parts[1]));
                                types[k] = Integer.class.getName();
                                break;
                            case 'L':
                                params[k] = Long.valueOf(jobDataMap.getString(parts[1]));
                                types[k] = Long.class.getName();
                                break;
                            case 'b':
                                params[k] = Boolean.valueOf(jobDataMap.getString(parts[1]));
                                types[k] = Boolean.TYPE.getName();
                                break;
                            case 'd':
                                params[k] = Double.valueOf(jobDataMap.getString(parts[1]));
                                types[k] = Double.TYPE.getName();
                                break;
                            case 'f':
                                params[k] = Float.valueOf(jobDataMap.getString(parts[1]));
                                types[k] = Float.TYPE.getName();
                                break;
                            case 'i':
                                params[k] = Integer.valueOf(jobDataMap.getString(parts[1]));
                                types[k] = Integer.TYPE.getName();
                                break;
                            case 'l':
                                params[k] = Long.valueOf(jobDataMap.getString(parts[1]));
                                types[k] = Long.TYPE.getName();
                                break;
                            case 's':
                                params[k] = jobDataMap.getString(parts[1]);
                                types[k] = String.class.getName();
                                break;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
            if (objName == null || objMethod == null) {
                throw new Exception("Required parameters missing");
            }
            context.setResult(invoke(objName, objMethod, params, types));
        } catch (Exception e) {
            String m = "Caught a " + e.getClass().getName() + " exception : " + e.getMessage();
            getLog().error(m, (Throwable) e);
            throw new JobExecutionException(m, e, false);
        }
    }

    private String[] split(String str, String splitStr) {
        LinkedList<String> l = new LinkedList<>();
        StringTokenizer strTok = new StringTokenizer(str, splitStr);
        while (strTok.hasMoreTokens()) {
            l.add(strTok.nextToken());
        }
        return (String[]) l.toArray(new String[l.size()]);
    }

    private Object invoke(String objectName, String method, Object[] params, String[] types) throws Exception {
        MBeanServer server = (MBeanServer) MBeanServerFactory.findMBeanServer((String) null).get(0);
        ObjectName mbean = new ObjectName(objectName);
        if (server == null) {
            throw new Exception("Can't find mbean server");
        }
        getLog().info("invoking " + method);
        return server.invoke(mbean, method, params, types);
    }

    protected Logger getLog() {
        return this.log;
    }
}
