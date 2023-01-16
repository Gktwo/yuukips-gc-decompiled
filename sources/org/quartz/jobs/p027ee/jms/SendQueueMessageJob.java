package org.quartz.jobs.p027ee.jms;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.Context;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* renamed from: org.quartz.jobs.ee.jms.SendQueueMessageJob */
/* loaded from: grasscutter.jar:org/quartz/jobs/ee/jms/SendQueueMessageJob.class */
public final class SendQueueMessageJob implements Job {
    @Override // org.quartz.Job
    public void execute(JobExecutionContext jobCtx) throws JobExecutionException {
        QueueSender sender;
        QueueSession sess;
        QueueConnection conn;
        try {
            conn = null;
            sess = null;
            sender = null;
            try {
                JobDataMap dataMap = jobCtx.getMergedJobDataMap();
                Context namingCtx = JmsHelper.getInitialContext(dataMap);
                QueueConnectionFactory connFactory = (QueueConnectionFactory) namingCtx.lookup(dataMap.getString(JmsHelper.JMS_CONNECTION_FACTORY_JNDI));
                if (!JmsHelper.isDestinationSecure(dataMap)) {
                    conn = connFactory.createQueueConnection();
                } else {
                    conn = connFactory.createQueueConnection(dataMap.getString(JmsHelper.JMS_USER), dataMap.getString(JmsHelper.JMS_PASSWORD));
                }
                sess = conn.createQueueSession(JmsHelper.useTransaction(dataMap), dataMap.getInt(JmsHelper.JMS_ACK_MODE));
                sender = sess.createSender((Queue) namingCtx.lookup(dataMap.getString(JmsHelper.JMS_DESTINATION_JNDI)));
                sender.send(JmsHelper.getMessageFactory(dataMap.getString(JmsHelper.JMS_MSG_FACTORY_CLASS_NAME)).createMessage(dataMap, sess));
                JmsHelper.closeResource(sender);
                JmsHelper.closeResource(sess);
                JmsHelper.closeResource(conn);
            } catch (Exception e) {
                throw new JobExecutionException(e.getMessage());
            }
        } catch (Throwable th) {
            JmsHelper.closeResource(sender);
            JmsHelper.closeResource(sess);
            JmsHelper.closeResource(conn);
            throw th;
        }
    }
}
