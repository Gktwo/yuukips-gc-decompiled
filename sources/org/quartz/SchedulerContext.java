package org.quartz;

import java.io.Serializable;
import java.util.Map;
import org.quartz.utils.StringKeyDirtyFlagMap;

/* loaded from: grasscutter.jar:org/quartz/SchedulerContext.class */
public class SchedulerContext extends StringKeyDirtyFlagMap implements Serializable {
    private static final long serialVersionUID = -6659641334616491764L;

    public SchedulerContext() {
        super(15);
    }

    public SchedulerContext(Map<?, ?> map) {
        this();
        putAll(map);
    }
}
