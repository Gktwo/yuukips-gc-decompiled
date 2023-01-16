package org.quartz.listeners;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

/* loaded from: grasscutter.jar:org/quartz/listeners/BroadcastSchedulerListener.class */
public class BroadcastSchedulerListener implements SchedulerListener {
    private List<SchedulerListener> listeners;

    public BroadcastSchedulerListener() {
        this.listeners = new LinkedList();
    }

    public BroadcastSchedulerListener(List<SchedulerListener> listeners) {
        this();
        this.listeners.addAll(listeners);
    }

    public void addListener(SchedulerListener listener) {
        this.listeners.add(listener);
    }

    public boolean removeListener(SchedulerListener listener) {
        return this.listeners.remove(listener);
    }

    public List<SchedulerListener> getListeners() {
        return Collections.unmodifiableList(this.listeners);
    }

    @Override // org.quartz.SchedulerListener
    public void jobAdded(JobDetail jobDetail) {
        for (SchedulerListener l : this.listeners) {
            l.jobAdded(jobDetail);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void jobDeleted(JobKey jobKey) {
        for (SchedulerListener l : this.listeners) {
            l.jobDeleted(jobKey);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void jobScheduled(Trigger trigger) {
        for (SchedulerListener l : this.listeners) {
            l.jobScheduled(trigger);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void jobUnscheduled(TriggerKey triggerKey) {
        for (SchedulerListener l : this.listeners) {
            l.jobUnscheduled(triggerKey);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void triggerFinalized(Trigger trigger) {
        for (SchedulerListener l : this.listeners) {
            l.triggerFinalized(trigger);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void triggerPaused(TriggerKey key) {
        for (SchedulerListener l : this.listeners) {
            l.triggerPaused(key);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void triggersPaused(String triggerGroup) {
        for (SchedulerListener l : this.listeners) {
            l.triggersPaused(triggerGroup);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void triggerResumed(TriggerKey key) {
        for (SchedulerListener l : this.listeners) {
            l.triggerResumed(key);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void triggersResumed(String triggerGroup) {
        for (SchedulerListener l : this.listeners) {
            l.triggersResumed(triggerGroup);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void schedulingDataCleared() {
        for (SchedulerListener l : this.listeners) {
            l.schedulingDataCleared();
        }
    }

    @Override // org.quartz.SchedulerListener
    public void jobPaused(JobKey key) {
        for (SchedulerListener l : this.listeners) {
            l.jobPaused(key);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void jobsPaused(String jobGroup) {
        for (SchedulerListener l : this.listeners) {
            l.jobsPaused(jobGroup);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void jobResumed(JobKey key) {
        for (SchedulerListener l : this.listeners) {
            l.jobResumed(key);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void jobsResumed(String jobGroup) {
        for (SchedulerListener l : this.listeners) {
            l.jobsResumed(jobGroup);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerError(String msg, SchedulerException cause) {
        for (SchedulerListener l : this.listeners) {
            l.schedulerError(msg, cause);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerStarted() {
        for (SchedulerListener l : this.listeners) {
            l.schedulerStarted();
        }
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerStarting() {
        for (SchedulerListener l : this.listeners) {
            l.schedulerStarting();
        }
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerInStandbyMode() {
        for (SchedulerListener l : this.listeners) {
            l.schedulerInStandbyMode();
        }
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerShutdown() {
        for (SchedulerListener l : this.listeners) {
            l.schedulerShutdown();
        }
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerShuttingdown() {
        for (SchedulerListener l : this.listeners) {
            l.schedulerShuttingdown();
        }
    }
}
