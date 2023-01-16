package org.quartz.jobs.p027ee.jms;

import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* renamed from: org.quartz.jobs.ee.jms.SendTopicMessageJob */
/* loaded from: grasscutter.jar:org/quartz/jobs/ee/jms/SendTopicMessageJob.class */
public final class SendTopicMessageJob implements Job {
    @Override // org.quartz.Job
    public void execute(JobExecutionContext jobCtx) throws JobExecutionException {
        TopicConnection conn = null;
        TopicSession sess = null;
        TopicPublisher publisher = null;
        try {
            try {
                JobDataMap dataMap = jobCtx.getMergedJobDataMap();
                Context namingCtx = JmsHelper.getInitialContext(dataMap);
                TopicConnectionFactory connFactory = (TopicConnectionFactory) namingCtx.lookup(dataMap.getString(JmsHelper.JMS_CONNECTION_FACTORY_JNDI));
                if (!JmsHelper.isDestinationSecure(dataMap)) {
                    conn = connFactory.createTopicConnection();
                } else {
                    conn = connFactory.createTopicConnection(dataMap.getString(JmsHelper.JMS_USER), dataMap.getString(JmsHelper.JMS_PASSWORD));
                }
                sess = conn.createTopicSession(JmsHelper.useTransaction(dataMap), dataMap.getInt(JmsHelper.JMS_ACK_MODE));
                publisher = sess.createPublisher((Topic) namingCtx.lookup(dataMap.getString(JmsHelper.JMS_DESTINATION_JNDI)));
                publisher.publish(JmsHelper.getMessageFactory(dataMap.getString(JmsHelper.JMS_MSG_FACTORY_CLASS_NAME)).createMessage(dataMap, sess));
                JmsHelper.closeResource(publisher);
                JmsHelper.closeResource(sess);
                JmsHelper.closeResource(conn);
            } catch (Exception e) {
                throw new JobExecutionException(e);
            }
        } catch (Throwable th) {
            JmsHelper.closeResource(publisher);
            JmsHelper.closeResource(sess);
            JmsHelper.closeResource(conn);
            throw th;
        }
    }
}
