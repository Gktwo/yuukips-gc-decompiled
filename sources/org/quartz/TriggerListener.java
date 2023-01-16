package org.quartz;

import org.quartz.Trigger;

/* loaded from: grasscutter.jar:org/quartz/TriggerListener.class */
public interface TriggerListener {
    String getName();

    void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext);

    boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext);

    void triggerMisfired(Trigger trigger);

    void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction);
}
