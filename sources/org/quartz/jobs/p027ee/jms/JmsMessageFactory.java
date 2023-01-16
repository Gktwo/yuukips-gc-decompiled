package org.quartz.jobs.p027ee.jms;

import javax.jms.Message;
import javax.jms.Session;
import org.quartz.JobDataMap;

/* renamed from: org.quartz.jobs.ee.jms.JmsMessageFactory */
/* loaded from: grasscutter.jar:org/quartz/jobs/ee/jms/JmsMessageFactory.class */
public interface JmsMessageFactory {
    Message createMessage(JobDataMap jobDataMap, Session session);
}
