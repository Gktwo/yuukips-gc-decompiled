package org.quartz;

/* loaded from: grasscutter.jar:org/quartz/InterruptableJob.class */
public interface InterruptableJob extends Job {
    void interrupt() throws UnableToInterruptJobException;
}
