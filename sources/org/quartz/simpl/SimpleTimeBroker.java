package org.quartz.simpl;

import java.util.Date;
import org.quartz.SchedulerConfigException;
import org.quartz.spi.TimeBroker;

/* loaded from: grasscutter.jar:org/quartz/simpl/SimpleTimeBroker.class */
public class SimpleTimeBroker implements TimeBroker {
    @Override // org.quartz.spi.TimeBroker
    public Date getCurrentTime() {
        return new Date();
    }

    @Override // org.quartz.spi.TimeBroker
    public void initialize() throws SchedulerConfigException {
    }

    @Override // org.quartz.spi.TimeBroker
    public void shutdown() {
    }
}
