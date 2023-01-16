package p013io.netty.channel.unix;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.channel.unix.UnixChannelUtil */
/* loaded from: grasscutter.jar:io/netty/channel/unix/UnixChannelUtil.class */
public final class UnixChannelUtil {
    private UnixChannelUtil() {
    }

    public static boolean isBufferCopyNeededForWrite(ByteBuf byteBuf) {
        return isBufferCopyNeededForWrite(byteBuf, Limits.IOV_MAX);
    }

    static boolean isBufferCopyNeededForWrite(ByteBuf byteBuf, int iovMax) {
        return !byteBuf.hasMemoryAddress() && (!byteBuf.isDirect() || byteBuf.nioBufferCount() > iovMax);
    }

    public static InetSocketAddress computeRemoteAddr(InetSocketAddress remoteAddr, InetSocketAddress osRemoteAddr) {
        if (osRemoteAddr == null) {
            return remoteAddr;
        }
        if (PlatformDependent.javaVersion() >= 7) {
            try {
                return new InetSocketAddress(InetAddress.getByAddress(remoteAddr.getHostString(), osRemoteAddr.getAddress().getAddress()), osRemoteAddr.getPort());
            } catch (UnknownHostException e) {
            }
        }
        return osRemoteAddr;
    }
}
