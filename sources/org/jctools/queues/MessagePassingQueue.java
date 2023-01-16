package org.jctools.queues;

/* loaded from: grasscutter.jar:org/jctools/queues/MessagePassingQueue.class */
public interface MessagePassingQueue<T> {
    public static final int UNBOUNDED_CAPACITY = -1;

    /* loaded from: grasscutter.jar:org/jctools/queues/MessagePassingQueue$Consumer.class */
    public interface Consumer<T> {
        void accept(T t);
    }

    /* loaded from: grasscutter.jar:org/jctools/queues/MessagePassingQueue$ExitCondition.class */
    public interface ExitCondition {
        boolean keepRunning();
    }

    /* loaded from: grasscutter.jar:org/jctools/queues/MessagePassingQueue$Supplier.class */
    public interface Supplier<T> {
        T get();
    }

    /* loaded from: grasscutter.jar:org/jctools/queues/MessagePassingQueue$WaitStrategy.class */
    public interface WaitStrategy {
        int idle(int i);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    boolean offer(T t);

    @Override // org.jctools.queues.MessagePassingQueue
    T poll();

    @Override // org.jctools.queues.MessagePassingQueue
    T peek();

    @Override // java.util.Collection, org.jctools.queues.MessagePassingQueue
    int size();

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    void clear();

    @Override // java.util.Collection, org.jctools.queues.MessagePassingQueue
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
