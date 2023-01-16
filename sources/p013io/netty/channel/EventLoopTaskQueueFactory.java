package p013io.netty.channel;

import java.util.Queue;

/* renamed from: io.netty.channel.EventLoopTaskQueueFactory */
/* loaded from: grasscutter.jar:io/netty/channel/EventLoopTaskQueueFactory.class */
public interface EventLoopTaskQueueFactory {
    Queue<Runnable> newTaskQueue(int i);
}
