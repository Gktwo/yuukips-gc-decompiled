package org.quartz;

import org.quartz.utils.Key;

/* loaded from: grasscutter.jar:org/quartz/JobKey.class */
public final class JobKey extends Key<JobKey> {
    private static final long serialVersionUID = -6073883950062574010L;

    public JobKey(String name) {
        super(name, null);
    }

    public JobKey(String name, String group) {
        super(name, group);
    }

    public static JobKey jobKey(String name) {
        return new JobKey(name, null);
    }

    public static JobKey jobKey(String name, String group) {
        return new JobKey(name, group);
    }
}
