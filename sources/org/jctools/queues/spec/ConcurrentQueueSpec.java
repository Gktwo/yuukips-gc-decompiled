package org.jctools.queues.spec;

@Deprecated
/* loaded from: grasscutter.jar:org/jctools/queues/spec/ConcurrentQueueSpec.class */
public final class ConcurrentQueueSpec {
    public final int producers;
    public final int consumers;
    public final int capacity;
    public final Ordering ordering;
    public final Preference preference;

    public static ConcurrentQueueSpec createBoundedSpsc(int capacity) {
        return new ConcurrentQueueSpec(1, 1, capacity, Ordering.FIFO, Preference.NONE);
    }

    public static ConcurrentQueueSpec createBoundedMpsc(int capacity) {
        return new ConcurrentQueueSpec(0, 1, capacity, Ordering.FIFO, Preference.NONE);
    }

    public static ConcurrentQueueSpec createBoundedSpmc(int capacity) {
        return new ConcurrentQueueSpec(1, 0, capacity, Ordering.FIFO, Preference.NONE);
    }

    public static ConcurrentQueueSpec createBoundedMpmc(int capacity) {
        return new ConcurrentQueueSpec(0, 0, capacity, Ordering.FIFO, Preference.NONE);
    }

    public ConcurrentQueueSpec(int producers, int consumers, int capacity, Ordering ordering, Preference preference) {
        this.producers = producers;
        this.consumers = consumers;
        this.capacity = capacity < 1 ? -1 : capacity;
        this.ordering = ordering;
        this.preference = preference;
    }

    public boolean isSpsc() {
        return this.consumers == 1 && this.producers == 1;
    }

    public boolean isMpsc() {
        return this.consumers == 1 && this.producers != 1;
    }

    public boolean isSpmc() {
        return this.consumers != 1 && this.producers == 1;
    }

    public boolean isMpmc() {
        return (this.consumers == 1 || this.producers == 1) ? false : true;
    }

    public boolean isBounded() {
        return this.capacity != -1;
    }
}
