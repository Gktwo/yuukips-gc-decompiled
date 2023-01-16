package org.quartz.simpl;

import org.quartz.JobKey;
import org.quartz.TriggerKey;
import org.quartz.spi.OperableTrigger;

/* compiled from: RAMJobStore.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/quartz/simpl/TriggerWrapper.class */
public class TriggerWrapper {
    public final TriggerKey key;
    public final JobKey jobKey;
    public final OperableTrigger trigger;
    public int state = 0;
    public static final int STATE_WAITING = 0;
    public static final int STATE_ACQUIRED = 1;
    public static final int STATE_EXECUTING = 2;
    public static final int STATE_COMPLETE = 3;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_BLOCKED = 5;
    public static final int STATE_PAUSED_BLOCKED = 6;
    public static final int STATE_ERROR = 7;

    /* access modifiers changed from: package-private */
    public TriggerWrapper(OperableTrigger trigger) {
        if (trigger == null) {
            throw new IllegalArgumentException("Trigger cannot be null!");
        }
        this.trigger = trigger;
        this.key = trigger.getKey();
        this.jobKey = trigger.getJobKey();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TriggerWrapper) || !((TriggerWrapper) obj).key.equals(this.key)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public OperableTrigger getTrigger() {
        return this.trigger;
    }
}
