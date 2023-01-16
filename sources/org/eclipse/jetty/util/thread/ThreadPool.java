package org.eclipse.jetty.util.thread;

import java.util.concurrent.Executor;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject("Pool of Threads")
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ThreadPool.class */
public interface ThreadPool extends Executor {
    void join() throws InterruptedException;

    @ManagedAttribute("number of threads in pool")
    int getThreads();

    @ManagedAttribute("number of idle threads in pool")
    int getIdleThreads();

    @ManagedAttribute("indicates the pool is low on available threads")
    boolean isLowOnThreads();

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ThreadPool$SizedThreadPool.class */
    public interface SizedThreadPool extends ThreadPool {
        int getMinThreads();

        int getMaxThreads();

        void setMinThreads(int i);

        void setMaxThreads(int i);

        default ThreadPoolBudget getThreadPoolBudget() {
            return null;
        }
    }
}
