package p013io.netty.channel.kqueue;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.kqueue.KQueueStaticallyReferencedJniMethods */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueStaticallyReferencedJniMethods.class */
public final class KQueueStaticallyReferencedJniMethods {
    /* access modifiers changed from: package-private */
    public static native short evAdd();

    /* access modifiers changed from: package-private */
    public static native short evEnable();

    /* access modifiers changed from: package-private */
    public static native short evDisable();

    /* access modifiers changed from: package-private */
    public static native short evDelete();

    /* access modifiers changed from: package-private */
    public static native short evClear();

    /* access modifiers changed from: package-private */
    public static native short evEOF();

    /* access modifiers changed from: package-private */
    public static native short evError();

    /* access modifiers changed from: package-private */
    public static native short noteReadClosed();

    /* access modifiers changed from: package-private */
    public static native short noteConnReset();

    /* access modifiers changed from: package-private */
    public static native short noteDisconnected();

    /* access modifiers changed from: package-private */
    public static native short evfiltRead();

    /* access modifiers changed from: package-private */
    public static native short evfiltWrite();

    /* access modifiers changed from: package-private */
    public static native short evfiltUser();

    /* access modifiers changed from: package-private */
    public static native short evfiltSock();

    /* access modifiers changed from: package-private */
    public static native int connectResumeOnReadWrite();

    /* access modifiers changed from: package-private */
    public static native int connectDataIdempotent();

    /* access modifiers changed from: package-private */
    public static native int fastOpenClient();

    /* access modifiers changed from: package-private */
    public static native int fastOpenServer();

    private KQueueStaticallyReferencedJniMethods() {
    }
}
