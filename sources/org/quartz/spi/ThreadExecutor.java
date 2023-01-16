package org.quartz.spi;

/* loaded from: grasscutter.jar:org/quartz/spi/ThreadExecutor.class */
public interface ThreadExecutor {
    void execute(Thread thread);

    void initialize();
}
