package com.lmax.disruptor.util;

@Deprecated
/* loaded from: grasscutter.jar:com/lmax/disruptor/util/ThreadHints.class */
public final class ThreadHints {
    private ThreadHints() {
    }

    @Deprecated
    public static void onSpinWait() {
        Thread.onSpinWait();
    }
}
