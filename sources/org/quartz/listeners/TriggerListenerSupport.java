package org.quartz.listeners;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/listeners/TriggerListenerSupport.class */
public abstract class TriggerListenerSupport implements TriggerListener {
    private final Logger log = LoggerFactory.getLogger(getClass());

    protected Logger getLog() {
        return this.log;
    }

    @Override // org.quartz.TriggerListener
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
    }

    @Override // org.quartz.TriggerListener
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return false;
    }

    @Override // org.quartz.TriggerListener
    public void triggerMisfired(Trigger trigger) {
    }

    @Override // org.quartz.TriggerListener
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
    }
}
