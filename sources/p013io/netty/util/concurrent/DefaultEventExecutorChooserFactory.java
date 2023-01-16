package p013io.netty.util.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p013io.netty.util.concurrent.EventExecutorChooserFactory;

/* renamed from: io.netty.util.concurrent.DefaultEventExecutorChooserFactory */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/DefaultEventExecutorChooserFactory.class */
public final class DefaultEventExecutorChooserFactory implements EventExecutorChooserFactory {
    public static final DefaultEventExecutorChooserFactory INSTANCE = new DefaultEventExecutorChooserFactory();

    private DefaultEventExecutorChooserFactory() {
    }

    @Override // p013io.netty.util.concurrent.EventExecutorChooserFactory
    public EventExecutorChooserFactory.EventExecutorChooser newChooser(EventExecutor[] executors) {
        if (isPowerOfTwo(executors.length)) {
            return new PowerOfTwoEventExecutorChooser(executors);
        }
        return new GenericEventExecutorChooser(executors);
    }

    private static boolean isPowerOfTwo(int val) {
        return (val & (-val)) == val;
    }

    /* renamed from: io.netty.util.concurrent.DefaultEventExecutorChooserFactory$PowerOfTwoEventExecutorChooser */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/DefaultEventExecutorChooserFactory$PowerOfTwoEventExecutorChooser.class */
    private static final class PowerOfTwoEventExecutorChooser implements EventExecutorChooserFactory.EventExecutorChooser {
        private final AtomicInteger idx = new AtomicInteger();
        private final EventExecutor[] executors;

        PowerOfTwoEventExecutorChooser(EventExecutor[] executors) {
            this.executors = executors;
        }

        @Override // p013io.netty.util.concurrent.EventExecutorChooserFactory.EventExecutorChooser
        public EventExecutor next() {
            return this.executors[this.idx.getAndIncrement() & (this.executors.length - 1)];
        }
    }

    /* renamed from: io.netty.util.concurrent.DefaultEventExecutorChooserFactory$GenericEventExecutorChooser */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/DefaultEventExecutorChooserFactory$GenericEventExecutorChooser.class */
    private static final class GenericEventExecutorChooser implements EventExecutorChooserFactory.EventExecutorChooser {
        private final AtomicLong idx = new AtomicLong();
        private final EventExecutor[] executors;

        GenericEventExecutorChooser(EventExecutor[] executors) {
            this.executors = executors;
        }

        @Override // p013io.netty.util.concurrent.EventExecutorChooserFactory.EventExecutorChooser
        public EventExecutor next() {
            return this.executors[(int) Math.abs(this.idx.getAndIncrement() % ((long) this.executors.length))];
        }
    }
}
