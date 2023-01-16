package org.quartz;

/* loaded from: grasscutter.jar:org/quartz/JobExecutionException.class */
public class JobExecutionException extends SchedulerException {
    private static final long serialVersionUID = 1326342535829043325L;
    private boolean refire;
    private boolean unscheduleTrigg;
    private boolean unscheduleAllTriggs;

    public JobExecutionException() {
        this.refire = false;
        this.unscheduleTrigg = false;
        this.unscheduleAllTriggs = false;
    }

    public JobExecutionException(Throwable cause) {
        super(cause);
        this.refire = false;
        this.unscheduleTrigg = false;
        this.unscheduleAllTriggs = false;
    }

    public JobExecutionException(String msg) {
        super(msg);
        this.refire = false;
        this.unscheduleTrigg = false;
        this.unscheduleAllTriggs = false;
    }

    public JobExecutionException(boolean refireImmediately) {
        this.refire = false;
        this.unscheduleTrigg = false;
        this.unscheduleAllTriggs = false;
        this.refire = refireImmediately;
    }

    public JobExecutionException(Throwable cause, boolean refireImmediately) {
        super(cause);
        this.refire = false;
        this.unscheduleTrigg = false;
        this.unscheduleAllTriggs = false;
        this.refire = refireImmediately;
    }

    public JobExecutionException(String msg, Throwable cause) {
        super(msg, cause);
        this.refire = false;
        this.unscheduleTrigg = false;
        this.unscheduleAllTriggs = false;
    }

    public JobExecutionException(String msg, Throwable cause, boolean refireImmediately) {
        super(msg, cause);
        this.refire = false;
        this.unscheduleTrigg = false;
        this.unscheduleAllTriggs = false;
        this.refire = refireImmediately;
    }

    public JobExecutionException(String msg, boolean refireImmediately) {
        super(msg);
        this.refire = false;
        this.unscheduleTrigg = false;
        this.unscheduleAllTriggs = false;
        this.refire = refireImmediately;
    }

    public void setRefireImmediately(boolean refire) {
        this.refire = refire;
    }

    public boolean refireImmediately() {
        return this.refire;
    }

    public void setUnscheduleFiringTrigger(boolean unscheduleTrigg) {
        this.unscheduleTrigg = unscheduleTrigg;
    }

    public boolean unscheduleFiringTrigger() {
        return this.unscheduleTrigg;
    }

    public void setUnscheduleAllTriggers(boolean unscheduleAllTriggs) {
        this.unscheduleAllTriggs = unscheduleAllTriggs;
    }

    public boolean unscheduleAllTriggers() {
        return this.unscheduleAllTriggs;
    }
}
