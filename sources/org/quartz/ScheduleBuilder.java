package org.quartz;

import org.quartz.Trigger;
import org.quartz.spi.MutableTrigger;

/* loaded from: grasscutter.jar:org/quartz/ScheduleBuilder.class */
public abstract class ScheduleBuilder<T extends Trigger> {
    /* access modifiers changed from: protected */
    public abstract MutableTrigger build();
}
