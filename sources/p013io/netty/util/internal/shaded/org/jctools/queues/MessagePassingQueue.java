package p013io.netty.util.internal.shaded.org.jctools.queues;

/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/MessagePassingQueue.class */
public interface MessagePassingQueue<T> {
    public static final int UNBOUNDED_CAPACITY = -1;

    /* renamed from: io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue$Consumer */
    /* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/MessagePassingQueue$Consumer.class */
    public interface Consumer<T> {
        void accept(T t);
    }

    /* renamed from: io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue$ExitCondition */
    /* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/MessagePassingQueue$ExitCondition.class */
    public interface ExitCondition {
        boolean keepRunning();
    }

    /* renamed from: io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue$Supplier */
    /* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/MessagePassingQueue$Supplier.class */
    public interface Supplier<T> {
        T get();
    }

    /* renamed from: io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue$WaitStrategy */
    /* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/MessagePassingQueue$WaitStrategy.class */
    public interface WaitStrategy {
        int idle(int i);
    }

    boolean offer(T t);

    T poll();

    T peek();

    int size();

    void clear();

    boolean isEmpty();

    int capacity();

    boolean relaxedOffer(T t);

    T relaxedPoll();

    T relaxedPeek();

    int drain(Consumer<T> consumer, int i);

    int fill(Supplier<T> supplier, int i);

    int drain(Consumer<T> consumer);

    int fill(Supplier<T> supplier);

    void drain(Consumer<T> consumer, WaitStrategy waitStrategy, ExitCondition exitCondition);

    void fill(Supplier<T> supplier, WaitStrategy waitStrategy, ExitCondition exitCondition);
}
