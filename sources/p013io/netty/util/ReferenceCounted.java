package p013io.netty.util;

/* renamed from: io.netty.util.ReferenceCounted */
/* loaded from: grasscutter.jar:io/netty/util/ReferenceCounted.class */
public interface ReferenceCounted {
    int refCnt();

    ReferenceCounted retain();

    ReferenceCounted retain(int i);

    ReferenceCounted touch();

    ReferenceCounted touch(Object obj);

    boolean release();

    boolean release(int i);
}
