package p013io.netty.util.concurrent;

import java.lang.Thread;

/* renamed from: io.netty.util.concurrent.ThreadProperties */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/ThreadProperties.class */
public interface ThreadProperties {
    Thread.State state();

    int priority();

    boolean isInterrupted();

    boolean isDaemon();

    String name();

    /* renamed from: id */
    long mo1172id();

    StackTraceElement[] stackTrace();

    boolean isAlive();
}
