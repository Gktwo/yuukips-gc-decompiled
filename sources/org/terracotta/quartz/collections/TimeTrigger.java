package org.terracotta.quartz.collections;

import java.io.Serializable;
import java.util.Date;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

/* loaded from: grasscutter.jar:org/terracotta/quartz/collections/TimeTrigger.class */
public class TimeTrigger implements Comparable<TimeTrigger>, Serializable {
    private final TriggerKey triggerKey;
    private final Long nextFireTime;
    private final int priority;

    /* access modifiers changed from: package-private */
    public TimeTrigger(TriggerKey triggerKey, Date next, int priority) {
        this.triggerKey = triggerKey;
        this.nextFireTime = next == null ? null : Long.valueOf(next.getTime());
        this.priority = priority;
    }

    /* access modifiers changed from: package-private */
    public TriggerKey getTriggerKey() {
        return this.triggerKey;
    }

    int getPriority() {
        return this.priority;
    }

    Date getNextFireTime() {
        if (this.nextFireTime == null) {
            return null;
        }
        return new Date(this.nextFireTime.longValue());
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof TimeTrigger) {
            return this.triggerKey.equals(((TimeTrigger) obj).triggerKey);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.triggerKey.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return "TimeTrigger [triggerKey=" + this.triggerKey + ", nextFireTime=" + new Date(this.nextFireTime.longValue()) + ", priority=" + this.priority + "]";
    }

    public int compareTo(TimeTrigger tt2) {
        return Trigger.TriggerTimeComparator.compare(getNextFireTime(), getPriority(), getTriggerKey(), tt2.getNextFireTime(), tt2.getPriority(), tt2.getTriggerKey());
    }
}
