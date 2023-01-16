package org.eclipse.jetty.util.thread;

import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.util.component.LifeCycle;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/Scheduler.class */
public interface Scheduler extends LifeCycle {

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/Scheduler$Task.class */
    public interface Task {
        boolean cancel();
    }

    Task schedule(Runnable runnable, long j, TimeUnit timeUnit);
}
