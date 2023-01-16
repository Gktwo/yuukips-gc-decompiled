package p013io.netty.util.concurrent;

/* renamed from: io.netty.util.concurrent.EventExecutorChooserFactory */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/EventExecutorChooserFactory.class */
public interface EventExecutorChooserFactory {

    /* renamed from: io.netty.util.concurrent.EventExecutorChooserFactory$EventExecutorChooser */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/EventExecutorChooserFactory$EventExecutorChooser.class */
    public interface EventExecutorChooser {
        EventExecutor next();
    }

    EventExecutorChooser newChooser(EventExecutor[] eventExecutorArr);
}
