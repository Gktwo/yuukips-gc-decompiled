package com.lmax.disruptor.util;

import java.util.concurrent.ThreadFactory;

/* loaded from: grasscutter.jar:com/lmax/disruptor/util/DaemonThreadFactory.class */
public enum DaemonThreadFactory implements ThreadFactory {
    INSTANCE;

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
