package p013io.netty.channel.epoll;

/* renamed from: io.netty.channel.epoll.NativeStaticallyReferencedJniMethods */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/NativeStaticallyReferencedJniMethods.class */
final class NativeStaticallyReferencedJniMethods {
    /* access modifiers changed from: package-private */
    public static native int epollin();

    /* access modifiers changed from: package-private */
    public static native int epollout();

    /* access modifiers changed from: package-private */
    public static native int epollrdhup();

    /* access modifiers changed from: package-private */
    public static native int epollet();

    /* access modifiers changed from: package-private */
    public static native int epollerr();

    static native long ssizeMax();

    /* access modifiers changed from: package-private */
    public static native int tcpMd5SigMaxKeyLen();

    static native int iovMax();

    static native int uioMaxIov();

    /* access modifiers changed from: package-private */
    public static native boolean isSupportingSendmmsg();

    /* access modifiers changed from: package-private */
    public static native boolean isSupportingRecvmmsg();

    /* access modifiers changed from: package-private */
    public static native int tcpFastopenMode();

    /* access modifiers changed from: package-private */
    public static native String kernelVersion();

    private NativeStaticallyReferencedJniMethods() {
    }
}
