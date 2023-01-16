package p013io.netty.util;

/* renamed from: io.netty.util.ResourceLeakTracker */
/* loaded from: grasscutter.jar:io/netty/util/ResourceLeakTracker.class */
public interface ResourceLeakTracker<T> {
    @Override // p013io.netty.util.ResourceLeak
    void record();

    @Override // p013io.netty.util.ResourceLeak
    void record(Object obj);

    boolean close(T t);
}
