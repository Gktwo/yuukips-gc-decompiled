package org.quartz.impl;

import org.quartz.spi.ThreadExecutor;

/* loaded from: grasscutter.jar:org/quartz/impl/DefaultThreadExecutor.class */
public class DefaultThreadExecutor implements ThreadExecutor {
    @Override // org.quartz.spi.ThreadExecutor
    public void initialize() {
    }

    @Override // org.quartz.spi.ThreadExecutor
    public void execute(Thread thread) {
        thread.start();
    }
}
