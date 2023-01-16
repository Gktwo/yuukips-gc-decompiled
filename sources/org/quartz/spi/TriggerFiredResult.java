package org.quartz.spi;

/* loaded from: grasscutter.jar:org/quartz/spi/TriggerFiredResult.class */
public class TriggerFiredResult {
    private TriggerFiredBundle triggerFiredBundle;
    private Exception exception;

    public TriggerFiredResult(TriggerFiredBundle triggerFiredBundle) {
        this.triggerFiredBundle = triggerFiredBundle;
    }

    public TriggerFiredResult(Exception exception) {
        this.exception = exception;
    }

    public TriggerFiredBundle getTriggerFiredBundle() {
        return this.triggerFiredBundle;
    }

    public Exception getException() {
        return this.exception;
    }
}
