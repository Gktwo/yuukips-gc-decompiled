package org.terracotta.quartz.collections;

import java.util.Iterator;
import org.quartz.TriggerKey;
import org.terracotta.quartz.wrappers.TriggerWrapper;
import org.terracotta.toolkit.collections.ToolkitSortedSet;

/* loaded from: grasscutter.jar:org/terracotta/quartz/collections/TimeTriggerSet.class */
public class TimeTriggerSet {
    private final ToolkitSortedSet<TimeTrigger> timeTriggers;

    public TimeTriggerSet(ToolkitSortedSet<TimeTrigger> timeTriggers) {
        this.timeTriggers = timeTriggers;
    }

    public boolean add(TriggerWrapper wrapper) {
        return this.timeTriggers.add(new TimeTrigger(wrapper.getKey(), wrapper.getNextFireTime(), wrapper.getPriority()));
    }

    public boolean remove(TriggerWrapper wrapper) {
        return this.timeTriggers.remove(new TimeTrigger(wrapper.getKey(), wrapper.getNextFireTime(), wrapper.getPriority()));
    }

    public TriggerKey removeFirst() {
        Iterator<TimeTrigger> iter = this.timeTriggers.iterator();
        TimeTrigger tt = null;
        if (iter.hasNext()) {
            tt = iter.next();
            iter.remove();
        }
        if (tt == null) {
            return null;
        }
        return tt.getTriggerKey();
    }

    public boolean isDestroyed() {
        return this.timeTriggers.isDestroyed();
    }

    public void destroy() {
        this.timeTriggers.destroy();
    }

    public int size() {
        return this.timeTriggers.size();
    }
}
