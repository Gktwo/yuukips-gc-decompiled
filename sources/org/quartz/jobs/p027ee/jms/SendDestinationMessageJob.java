package org.quartz.jobs.p027ee.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* renamed from: org.quartz.jobs.ee.jms.SendDestinationMessageJob */
/* loaded from: grasscutter.jar:org/quartz/jobs/ee/jms/SendDestinationMessageJob.class */
public final class SendDestinationMessageJob implements Job {
    @Override // org.quartz.Job
    public void execute(JobExecutionContext jobCtx) throws JobExecutionException {
        Connection conn = null;
        Session sess = null;
        MessageProducer producer = null;
        try {
            try {
                JobDataMap dataMap = jobCtx.getMergedJobDataMap();
                Context namingCtx = JmsHelper.getInitialContext(dataMap);
                ConnectionFactory connFactory = (ConnectionFactory) namingCtx.lookup(dataMap.getString(JmsHelper.JMS_CONNECTION_FACTORY_JNDI));
                if (!JmsHelper.isDestinationSecure(dataMap)) {
                    conn = connFactory.createConnection();
                } else {
                    conn = connFactory.createConnection(dataMap.getString(JmsHelper.JMS_USER), dataMap.getString(JmsHelper.JMS_PASSWORD));
                }
                sess = conn.createSession(JmsHelper.useTransaction(dataMap), dataMap.getInt(JmsHelper.JMS_ACK_MODE));
                producer = sess.createProducer((Destination) namingCtx.lookup(dataMap.getString(JmsHelper.JMS_DESTINATION_JNDI)));
                producer.send(JmsHelper.getMessageFactory(dataMap.getString(JmsHelper.JMS_MSG_FACTORY_CLASS_NAME)).createMessage(dataMap, sess));
                JmsHelper.closeResource(producer);
                JmsHelper.closeResource(sess);
                JmsHelper.closeResource(conn);
            } catch (Exception e) {
                throw new JobExecutionException(e);
            }
        } catch (Throwable th) {
            JmsHelper.closeResource(producer);
            JmsHelper.closeResource(sess);
            JmsHelper.closeResource(conn);
            throw th;
        }
    }
}
