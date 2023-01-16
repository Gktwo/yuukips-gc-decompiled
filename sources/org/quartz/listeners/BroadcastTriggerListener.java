package org.quartz.listeners;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/* loaded from: grasscutter.jar:org/quartz/listeners/BroadcastTriggerListener.class */
public class BroadcastTriggerListener implements TriggerListener {
    private String name;
    private List<TriggerListener> listeners;

    public BroadcastTriggerListener(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Listener name cannot be null!");
        }
        this.name = name;
        this.listeners = new LinkedList();
    }

    public BroadcastTriggerListener(String name, List<TriggerListener> listeners) {
        this(name);
        this.listeners.addAll(listeners);
    }

    @Override // org.quartz.TriggerListener
    public String getName() {
        return this.name;
    }

    public void addListener(TriggerListener listener) {
        this.listeners.add(listener);
    }

    public boolean removeListener(TriggerListener listener) {
        return this.listeners.remove(listener);
    }

    public boolean removeListener(String listenerName) {
        Iterator<TriggerListener> itr = this.listeners.iterator();
        while (itr.hasNext()) {
            if (itr.next().getName().equals(listenerName)) {
                itr.remove();
                return true;
            }
        }
        return false;
    }

    public List<TriggerListener> getListeners() {
        return Collections.unmodifiableList(this.listeners);
    }

    @Override // org.quartz.TriggerListener
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        for (TriggerListener l : this.listeners) {
            l.triggerFired(trigger, context);
        }
    }

    @Override // org.quartz.TriggerListener
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        for (TriggerListener l : this.listeners) {
            if (l.vetoJobExecution(trigger, context)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.quartz.TriggerListener
    public void triggerMisfired(Trigger trigger) {
        for (TriggerListener l : this.listeners) {
            l.triggerMisfired(trigger);
        }
    }

    @Override // org.quartz.TriggerListener
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        for (TriggerListener l : this.listeners) {
            l.triggerComplete(trigger, context, triggerInstructionCode);
        }
    }
}
