package p013io.netty.util;

@Deprecated
/* renamed from: io.netty.util.ResourceLeak */
/* loaded from: grasscutter.jar:io/netty/util/ResourceLeak.class */
public interface ResourceLeak {
    void record();

    void record(Object obj);

    boolean close();
}
