package org.quartz.simpl;

import java.io.Serializable;
import java.util.Comparator;
import org.quartz.Trigger;

/* compiled from: RAMJobStore.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/quartz/simpl/TriggerWrapperComparator.class */
public class TriggerWrapperComparator implements Comparator<TriggerWrapper>, Serializable {
    private static final long serialVersionUID = 8809557142191514261L;
    Trigger.TriggerTimeComparator ttc = new Trigger.TriggerTimeComparator();

    public int compare(TriggerWrapper trig1, TriggerWrapper trig2) {
        return this.ttc.compare((Trigger) trig1.trigger, (Trigger) trig2.trigger);
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(Object obj) {
        return obj instanceof TriggerWrapperComparator;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return hashCode();
    }
}
