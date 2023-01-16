package p013io.netty.channel.epoll;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import p013io.netty.channel.DefaultFileRegion;
import p013io.netty.channel.epoll.NativeDatagramPacketArray;
import p013io.netty.channel.unix.Errors;
import p013io.netty.channel.unix.PeerCredentials;
import p013io.netty.channel.unix.Socket;
import p013io.netty.channel.unix.Unix;
import p013io.netty.util.internal.ClassInitializerUtil;
import p013io.netty.util.internal.NativeLibraryLoader;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.ThrowableUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.epoll.Native */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/Native.class */
public final class Native {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Native.class);
    public static final int EPOLLIN;
    public static final int EPOLLOUT;
    public static final int EPOLLRDHUP;
    public static final int EPOLLET;
    public static final int EPOLLERR;
    public static final boolean IS_SUPPORTING_SENDMMSG;
    static final boolean IS_SUPPORTING_RECVMMSG;
    static final boolean IS_SUPPORTING_UDP_SEGMENT;
    private static final int TFO_ENABLED_CLIENT_MASK = 1;
    private static final int TFO_ENABLED_SERVER_MASK = 2;
    private static final int TCP_FASTOPEN_MODE;
    static final boolean IS_SUPPORTING_TCP_FASTOPEN_CLIENT;
    static final boolean IS_SUPPORTING_TCP_FASTOPEN_SERVER;
    @Deprecated
    public static final boolean IS_SUPPORTING_TCP_FASTOPEN;
    public static final int TCP_MD5SIG_MAXKEYLEN;
    public static final String KERNEL_VERSION;

    /* access modifiers changed from: private */
    public static native int registerUnix();

    private static native boolean isSupportingUdpSegment();

    private static native int eventFd();

    private static native int timerFd();

    public static native void eventFdWrite(int i, long j);

    public static native void eventFdRead(int i);

    private static native int epollCreate();

    private static native long epollWait0(int i, long j, int i2, int i3, int i4, int i5, long j2);

    private static native int epollWait(int i, long j, int i2, int i3);

    private static native int epollBusyWait0(int i, long j, int i2);

    private static native int epollCtlAdd0(int i, int i2, int i3);

    private static native int epollCtlMod0(int i, int i2, int i3);

    private static native int epollCtlDel0(int i, int i2);

    private static native int splice0(int i, long j, int i2, long j2, long j3);

    private static native int sendmmsg0(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3);

    private static native int recvmmsg0(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3);

    private static native int recvmsg0(int i, boolean z, NativeDatagramPacketArray.NativeDatagramPacket nativeDatagramPacket);

    public static native int sizeofEpollEvent();

    public static native int offsetofEpollData();

    static {
        Selector selector = null;
        try {
            selector = Selector.open();
        } catch (IOException e) {
        }
        try {
            ClassInitializerUtil.tryLoadClasses(Native.class, PeerCredentials.class, DefaultFileRegion.class, FileChannel.class, FileDescriptor.class, NativeDatagramPacketArray.NativeDatagramPacket.class);
            try {
                offsetofEpollData();
                if (selector != null) {
                    try {
                        selector.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (UnsatisfiedLinkError e3) {
                loadNativeLibrary();
                if (selector != null) {
                    try {
                        selector.close();
                    } catch (IOException e4) {
                    }
                }
            }
            Unix.registerInternal(new Runnable() { // from class: io.netty.channel.epoll.Native.1
                @Override // java.lang.Runnable
                public void run() {
                    Native.registerUnix();
                }
            });
            EPOLLIN = NativeStaticallyReferencedJniMethods.epollin();
            EPOLLOUT = NativeStaticallyReferencedJniMethods.epollout();
            EPOLLRDHUP = NativeStaticallyReferencedJniMethods.epollrdhup();
            EPOLLET = NativeStaticallyReferencedJniMethods.epollet();
            EPOLLERR = NativeStaticallyReferencedJniMethods.epollerr();
            IS_SUPPORTING_SENDMMSG = NativeStaticallyReferencedJniMethods.isSupportingSendmmsg();
            IS_SUPPORTING_RECVMMSG = NativeStaticallyReferencedJniMethods.isSupportingRecvmmsg();
            IS_SUPPORTING_UDP_SEGMENT = isSupportingUdpSegment();
            TCP_FASTOPEN_MODE = NativeStaticallyReferencedJniMethods.tcpFastopenMode();
            IS_SUPPORTING_TCP_FASTOPEN_CLIENT = (TCP_FASTOPEN_MODE & 1) == 1;
            IS_SUPPORTING_TCP_FASTOPEN_SERVER = (TCP_FASTOPEN_MODE & 2) == 2;
            IS_SUPPORTING_TCP_FASTOPEN = IS_SUPPORTING_TCP_FASTOPEN_CLIENT || IS_SUPPORTING_TCP_FASTOPEN_SERVER;
            TCP_MD5SIG_MAXKEYLEN = NativeStaticallyReferencedJniMethods.tcpMd5SigMaxKeyLen();
            KERNEL_VERSION = NativeStaticallyReferencedJniMethods.kernelVersion();
        } catch (Throwable th) {
            if (selector != null) {
                try {
                    selector.close();
                } catch (IOException e5) {
                    throw th;
                }
            }
            throw th;
        }
    }

    public static p013io.netty.channel.unix.FileDescriptor newEventFd() {
        return new p013io.netty.channel.unix.FileDescriptor(eventFd());
    }

    public static p013io.netty.channel.unix.FileDescriptor newTimerFd() {
        return new p013io.netty.channel.unix.FileDescriptor(timerFd());
    }

    public static p013io.netty.channel.unix.FileDescriptor newEpollCreate() {
        return new p013io.netty.channel.unix.FileDescriptor(epollCreate());
    }

    @Deprecated
    public static int epollWait(p013io.netty.channel.unix.FileDescriptor epollFd, EpollEventArray events, p013io.netty.channel.unix.FileDescriptor timerFd, int timeoutSec, int timeoutNs) throws IOException {
        return epollReady(epollWait(epollFd, events, timerFd, timeoutSec, timeoutNs, -1));
    }

    /* access modifiers changed from: package-private */
    public static long epollWait(p013io.netty.channel.unix.FileDescriptor epollFd, EpollEventArray events, p013io.netty.channel.unix.FileDescriptor timerFd, int timeoutSec, int timeoutNs, long millisThreshold) throws IOException {
        if (timeoutSec == 0 && timeoutNs == 0) {
            return ((long) epollWait(epollFd, events, 0)) << 32;
        }
        if (timeoutSec == Integer.MAX_VALUE) {
            timeoutSec = 0;
            timeoutNs = 0;
        }
        long result = epollWait0(epollFd.intValue(), events.memoryAddress(), events.length(), timerFd.intValue(), timeoutSec, timeoutNs, millisThreshold);
        int ready = epollReady(result);
        if (ready >= 0) {
            return result;
        }
        throw Errors.newIOException("epoll_wait", ready);
    }

    /* access modifiers changed from: package-private */
    public static int epollReady(long result) {
        return (int) (result >> 32);
    }

    /* access modifiers changed from: package-private */
    public static boolean epollTimerWasUsed(long result) {
        return (result & 255) != 0;
    }

    /* access modifiers changed from: package-private */
    public static int epollWait(p013io.netty.channel.unix.FileDescriptor epollFd, EpollEventArray events, boolean immediatePoll) throws IOException {
        return epollWait(epollFd, events, immediatePoll ? 0 : -1);
    }

    /* access modifiers changed from: package-private */
    public static int epollWait(p013io.netty.channel.unix.FileDescriptor epollFd, EpollEventArray events, int timeoutMillis) throws IOException {
        int ready = epollWait(epollFd.intValue(), events.memoryAddress(), events.length(), timeoutMillis);
        if (ready >= 0) {
            return ready;
        }
        throw Errors.newIOException("epoll_wait", ready);
    }

    public static int epollBusyWait(p013io.netty.channel.unix.FileDescriptor epollFd, EpollEventArray events) throws IOException {
        int ready = epollBusyWait0(epollFd.intValue(), events.memoryAddress(), events.length());
        if (ready >= 0) {
            return ready;
        }
        throw Errors.newIOException("epoll_wait", ready);
    }

    public static void epollCtlAdd(int efd, int fd, int flags) throws IOException {
        int res = epollCtlAdd0(efd, fd, flags);
        if (res < 0) {
            throw Errors.newIOException("epoll_ctl", res);
        }
    }

    public static void epollCtlMod(int efd, int fd, int flags) throws IOException {
        int res = epollCtlMod0(efd, fd, flags);
        if (res < 0) {
            throw Errors.newIOException("epoll_ctl", res);
        }
    }

    public static void epollCtlDel(int efd, int fd) throws IOException {
        int res = epollCtlDel0(efd, fd);
        if (res < 0) {
            throw Errors.newIOException("epoll_ctl", res);
        }
    }

    public static int splice(int fd, long offIn, int fdOut, long offOut, long len) throws IOException {
        int res = splice0(fd, offIn, fdOut, offOut, len);
        if (res >= 0) {
            return res;
        }
        return Errors.ioResult("splice", res);
    }

    @Deprecated
    public static int sendmmsg(int fd, NativeDatagramPacketArray.NativeDatagramPacket[] msgs, int offset, int len) throws IOException {
        return sendmmsg(fd, Socket.isIPv6Preferred(), msgs, offset, len);
    }

    /* access modifiers changed from: package-private */
    public static int sendmmsg(int fd, boolean ipv6, NativeDatagramPacketArray.NativeDatagramPacket[] msgs, int offset, int len) throws IOException {
        int res = sendmmsg0(fd, ipv6, msgs, offset, len);
        if (res >= 0) {
            return res;
        }
        return Errors.ioResult("sendmmsg", res);
    }

    /* access modifiers changed from: package-private */
    public static int recvmmsg(int fd, boolean ipv6, NativeDatagramPacketArray.NativeDatagramPacket[] msgs, int offset, int len) throws IOException {
        int res = recvmmsg0(fd, ipv6, msgs, offset, len);
        if (res >= 0) {
            return res;
        }
        return Errors.ioResult("recvmmsg", res);
    }

    /* access modifiers changed from: package-private */
    public static int recvmsg(int fd, boolean ipv6, NativeDatagramPacketArray.NativeDatagramPacket packet) throws IOException {
        int res = recvmsg0(fd, ipv6, packet);
        if (res >= 0) {
            return res;
        }
        return Errors.ioResult("recvmsg", res);
    }

    private static void loadNativeLibrary() {
        if (!"linux".equals(PlatformDependent.normalizedOs())) {
            throw new IllegalStateException("Only supported on Linux");
        }
        String sharedLibName = "netty_transport_native_epoll_" + PlatformDependent.normalizedArch();
        ClassLoader cl = PlatformDependent.getClassLoader(Native.class);
        try {
            NativeLibraryLoader.load(sharedLibName, cl);
        } catch (UnsatisfiedLinkError e1) {
            try {
                NativeLibraryLoader.load("netty_transport_native_epoll", cl);
                logger.debug("Failed to load {}", sharedLibName, e1);
            } catch (UnsatisfiedLinkError e2) {
                ThrowableUtil.addSuppressed(e1, e2);
                throw e1;
            }
        }
    }

    private Native() {
    }
}
