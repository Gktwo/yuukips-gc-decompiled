package org.terracotta.quartz.wrappers;

import java.io.Serializable;
import java.util.Date;
import org.quartz.Calendar;
import org.quartz.JobKey;
import org.quartz.TriggerKey;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/terracotta/quartz/wrappers/TriggerWrapper.class */
public class TriggerWrapper implements Serializable {
    private final boolean jobDisallowsConcurrence;
    private volatile String lastTerracotaClientId = null;
    private volatile TriggerState state = TriggerState.WAITING;
    protected final OperableTrigger trigger;

    /* loaded from: grasscutter.jar:org/terracotta/quartz/wrappers/TriggerWrapper$TriggerState.class */
    public enum TriggerState {
        WAITING,
        ACQUIRED,
        COMPLETE,
        PAUSED,
        BLOCKED,
        PAUSED_BLOCKED,
        ERROR
    }

    /* access modifiers changed from: protected */
    public TriggerWrapper(OperableTrigger trigger, boolean jobDisallowsConcurrence) {
        this.trigger = trigger;
        this.jobDisallowsConcurrence = jobDisallowsConcurrence;
    }

    public boolean jobDisallowsConcurrence() {
        return this.jobDisallowsConcurrence;
    }

    public String getLastTerracotaClientId() {
        return this.lastTerracotaClientId;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getKey().hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return getClass().getSimpleName() + "( " + this.state + ", lastTC=" + this.lastTerracotaClientId + ", " + this.trigger + ")";
    }

    public TriggerKey getKey() {
        return this.trigger.getKey();
    }

    public JobKey getJobKey() {
        return this.trigger.getJobKey();
    }

    public void setState(TriggerState state, String terracottaId, TriggerFacade triggerFacade) {
        if (terracottaId == null) {
            throw new NullPointerException();
        }
        this.state = state;
        this.lastTerracotaClientId = terracottaId;
        rePut(triggerFacade);
    }

    public TriggerState getState() {
        return this.state;
    }

    public Date getNextFireTime() {
        return this.trigger.getNextFireTime();
    }

    public int getPriority() {
        return this.trigger.getPriority();
    }

    public boolean mayFireAgain() {
        return this.trigger.mayFireAgain();
    }

    public OperableTrigger getTriggerClone() {
        return (OperableTrigger) this.trigger.clone();
    }

    public void updateWithNewCalendar(Calendar cal, long misfireThreshold, TriggerFacade triggerFacade) {
        this.trigger.updateWithNewCalendar(cal, misfireThreshold);
        rePut(triggerFacade);
    }

    public String getCalendarName() {
        return this.trigger.getCalendarName();
    }

    public int getMisfireInstruction() {
        return this.trigger.getMisfireInstruction();
    }

    public void updateAfterMisfire(Calendar cal, TriggerFacade triggerFacade) {
        this.trigger.updateAfterMisfire(cal);
        rePut(triggerFacade);
    }

    public void setFireInstanceId(String firedInstanceId, TriggerFacade triggerFacade) {
        this.trigger.setFireInstanceId(firedInstanceId);
        rePut(triggerFacade);
    }

    public void triggered(Calendar cal, TriggerFacade triggerFacade) {
        this.trigger.triggered(cal);
        rePut(triggerFacade);
    }

    private void rePut(TriggerFacade triggerFacade) {
        triggerFacade.put(this.trigger.getKey(), this);
    }

    public boolean isInstanceof(Class clazz) {
        return clazz.isInstance(this.trigger);
    }
}
