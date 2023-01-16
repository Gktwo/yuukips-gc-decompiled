package org.quartz.jobs.p027ee.jms;

import org.quartz.SchedulerException;

/* renamed from: org.quartz.jobs.ee.jms.JmsJobException */
/* loaded from: grasscutter.jar:org/quartz/jobs/ee/jms/JmsJobException.class */
public final class JmsJobException extends SchedulerException {
    private static final long serialVersionUID = 3045647075496522093L;

    public JmsJobException(String message) {
        super(message);
    }

    public JmsJobException(String message, Throwable cause) {
        super(message, cause);
    }

    public JmsJobException(Throwable cause) {
        super(cause);
    }
}
