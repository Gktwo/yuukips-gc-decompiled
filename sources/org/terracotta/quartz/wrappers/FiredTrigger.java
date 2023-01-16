package org.terracotta.quartz.wrappers;

import java.io.Serializable;
import java.util.Date;
import org.quartz.TriggerKey;

/* loaded from: grasscutter.jar:org/terracotta/quartz/wrappers/FiredTrigger.class */
public class FiredTrigger implements Serializable {
    private final String clientId;
    private final TriggerKey triggerKey;
    private final long scheduledFireTime;
    private final long fireTime;

    public FiredTrigger(String clientId, TriggerKey triggerKey, long scheduledFireTime) {
        this(clientId, triggerKey, scheduledFireTime, System.currentTimeMillis());
    }

    public FiredTrigger(String clientId, TriggerKey triggerKey, long scheduledFireTime, long now) {
        this.clientId = clientId;
        this.triggerKey = triggerKey;
        this.scheduledFireTime = scheduledFireTime;
        this.fireTime = now;
    }

    public String getClientId() {
        return this.clientId;
    }

    public TriggerKey getTriggerKey() {
        return this.triggerKey;
    }

    public long getScheduledFireTime() {
        return this.scheduledFireTime;
    }

    public long getFireTime() {
        return this.fireTime;
    }

    @Override // java.lang.Object
    public String toString() {
        return getClass().getSimpleName() + "(" + this.triggerKey + ", " + getClientId() + ", " + new Date(this.fireTime) + ")";
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * 1) + (this.clientId == null ? 0 : this.clientId.hashCode()))) + ((int) (this.scheduledFireTime ^ (this.scheduledFireTime >>> 32))))) + ((int) (this.fireTime ^ (this.fireTime >>> 32))))) + (this.triggerKey == null ? 0 : this.triggerKey.hashCode());
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FiredTrigger other = (FiredTrigger) obj;
        if (this.clientId == null) {
            if (other.clientId != null) {
                return false;
            }
        } else if (!this.clientId.equals(other.clientId)) {
            return false;
        }
        if (this.scheduledFireTime == other.scheduledFireTime && this.fireTime == other.fireTime) {
            return this.triggerKey == null ? other.triggerKey == null : this.triggerKey.equals(other.triggerKey);
        }
        return false;
    }
}
