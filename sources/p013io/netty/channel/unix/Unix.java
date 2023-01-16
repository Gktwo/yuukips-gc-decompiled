package p013io.netty.channel.unix;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.PortUnreachableException;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.atomic.AtomicBoolean;
import p013io.netty.util.internal.ClassInitializerUtil;

/* renamed from: io.netty.channel.unix.Unix */
/* loaded from: grasscutter.jar:io/netty/channel/unix/Unix.class */
public final class Unix {
    private static final AtomicBoolean registered = new AtomicBoolean();

    static {
        ClassInitializerUtil.tryLoadClasses(Unix.class, OutOfMemoryError.class, RuntimeException.class, ClosedChannelException.class, IOException.class, PortUnreachableException.class, DatagramSocketAddress.class, DomainDatagramSocketAddress.class, InetSocketAddress.class);
    }

    public static synchronized void registerInternal(Runnable registerTask) {
        registerTask.run();
        Socket.initialize();
    }

    @Deprecated
    public static boolean isAvailable() {
        return false;
    }

    @Deprecated
    public static void ensureAvailability() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static Throwable unavailabilityCause() {
        return new UnsupportedOperationException();
    }

    private Unix() {
    }
}
