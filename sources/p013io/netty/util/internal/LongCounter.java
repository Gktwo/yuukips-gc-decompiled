package p013io.netty.util.internal;

/* renamed from: io.netty.util.internal.LongCounter */
/* loaded from: grasscutter.jar:io/netty/util/internal/LongCounter.class */
public interface LongCounter {
    void add(long j);

    void increment();

    void decrement();

    long value();
}
