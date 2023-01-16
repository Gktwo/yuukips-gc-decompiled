package p013io.netty.channel.unix;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import org.jline.builtins.Tmux;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.socket.InternetProtocolFamily;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.NetUtil;

/* renamed from: io.netty.channel.unix.Socket */
/* loaded from: grasscutter.jar:io/netty/channel/unix/Socket.class */
public class Socket extends FileDescriptor {
    private static volatile boolean isIpv6Preferred;
    @Deprecated
    public static final int UDS_SUN_PATH_SIZE = 100;
    protected final boolean ipv6;

    private static native boolean isIPv6Preferred0(boolean z);

    private static native boolean isIPv6(int i);

    private static native int shutdown(int i, boolean z, boolean z2);

    private static native int connect(int i, boolean z, byte[] bArr, int i2, int i3);

    private static native int connectDomainSocket(int i, byte[] bArr);

    private static native int finishConnect(int i);

    private static native int disconnect(int i, boolean z);

    private static native int bind(int i, boolean z, byte[] bArr, int i2, int i3);

    private static native int bindDomainSocket(int i, byte[] bArr);

    private static native int listen(int i, int i2);

    private static native int accept(int i, byte[] bArr);

    private static native byte[] remoteAddress(int i);

    private static native byte[] localAddress(int i);

    private static native int sendTo(int i, boolean z, ByteBuffer byteBuffer, int i2, int i3, byte[] bArr, int i4, int i5, int i6);

    private static native int sendToAddress(int i, boolean z, long j, int i2, int i3, byte[] bArr, int i4, int i5, int i6);

    private static native int sendToAddresses(int i, boolean z, long j, int i2, byte[] bArr, int i3, int i4, int i5);

    private static native int sendToDomainSocket(int i, ByteBuffer byteBuffer, int i2, int i3, byte[] bArr);

    private static native int sendToAddressDomainSocket(int i, long j, int i2, int i3, byte[] bArr);

    private static native int sendToAddressesDomainSocket(int i, long j, int i2, byte[] bArr);

    private static native DatagramSocketAddress recvFrom(int i, ByteBuffer byteBuffer, int i2, int i3) throws IOException;

    private static native DatagramSocketAddress recvFromAddress(int i, long j, int i2, int i3) throws IOException;

    private static native DomainDatagramSocketAddress recvFromDomainSocket(int i, ByteBuffer byteBuffer, int i2, int i3) throws IOException;

    private static native DomainDatagramSocketAddress recvFromAddressDomainSocket(int i, long j, int i2, int i3) throws IOException;

    private static native int recvFd(int i);

    private static native int sendFd(int i, int i2);

    private static native int msgFastopen();

    private static native int newSocketStreamFd(boolean z);

    private static native int newSocketDgramFd(boolean z);

    private static native int newSocketDomainFd();

    private static native int newSocketDomainDgramFd();

    private static native int isReuseAddress(int i) throws IOException;

    private static native int isReusePort(int i) throws IOException;

    private static native int getReceiveBufferSize(int i) throws IOException;

    private static native int getSendBufferSize(int i) throws IOException;

    private static native int isKeepAlive(int i) throws IOException;

    private static native int isTcpNoDelay(int i) throws IOException;

    private static native int isBroadcast(int i) throws IOException;

    private static native int getSoLinger(int i) throws IOException;

    private static native int getSoError(int i) throws IOException;

    private static native int getTrafficClass(int i, boolean z) throws IOException;

    private static native void setReuseAddress(int i, int i2) throws IOException;

    private static native void setReusePort(int i, int i2) throws IOException;

    private static native void setKeepAlive(int i, int i2) throws IOException;

    private static native void setReceiveBufferSize(int i, int i2) throws IOException;

    private static native void setSendBufferSize(int i, int i2) throws IOException;

    private static native void setTcpNoDelay(int i, int i2) throws IOException;

    private static native void setSoLinger(int i, int i2) throws IOException;

    private static native void setBroadcast(int i, int i2) throws IOException;

    private static native void setTrafficClass(int i, boolean z, int i2) throws IOException;

    private static native void setIntOpt(int i, int i2, int i3, int i4) throws IOException;

    private static native void setRawOptArray(int i, int i2, int i3, byte[] bArr, int i4, int i5) throws IOException;

    private static native void setRawOptAddress(int i, int i2, int i3, long j, int i4) throws IOException;

    private static native int getIntOpt(int i, int i2, int i3) throws IOException;

    private static native void getRawOptArray(int i, int i2, int i3, byte[] bArr, int i4, int i5) throws IOException;

    private static native void getRawOptAddress(int i, int i2, int i3, long j, int i4) throws IOException;

    public Socket(int fd) {
        super(fd);
        this.ipv6 = isIPv6(fd);
    }

    private boolean useIpv6(InetAddress address) {
        return useIpv6(this, address);
    }

    protected static boolean useIpv6(Socket socket, InetAddress address) {
        return socket.ipv6 || (address instanceof Inet6Address);
    }

    public final void shutdown() throws IOException {
        shutdown(true, true);
    }

    public final void shutdown(boolean read, boolean write) throws IOException {
        int oldState;
        int newState;
        do {
            oldState = this.state;
            if (isClosed(oldState)) {
                throw new ClosedChannelException();
            }
            newState = oldState;
            if (read && !isInputShutdown(newState)) {
                newState = inputShutdown(newState);
            }
            if (write && !isOutputShutdown(newState)) {
                newState = outputShutdown(newState);
            }
            if (newState == oldState) {
                return;
            }
        } while (!casState(oldState, newState));
        int res = shutdown(this.f990fd, read, write);
        if (res < 0) {
            Errors.ioResult("shutdown", res);
        }
    }

    public final boolean isShutdown() {
        int state = this.state;
        return isInputShutdown(state) && isOutputShutdown(state);
    }

    public final boolean isInputShutdown() {
        return isInputShutdown(this.state);
    }

    public final boolean isOutputShutdown() {
        return isOutputShutdown(this.state);
    }

    public final int sendTo(ByteBuffer buf, int pos, int limit, InetAddress addr, int port) throws IOException {
        return sendTo(buf, pos, limit, addr, port, false);
    }

    public final int sendTo(ByteBuffer buf, int pos, int limit, InetAddress addr, int port, boolean fastOpen) throws IOException {
        int scopeId;
        byte[] address;
        if (addr instanceof Inet6Address) {
            address = addr.getAddress();
            scopeId = ((Inet6Address) addr).getScopeId();
        } else {
            scopeId = 0;
            address = NativeInetAddress.ipv4MappedIpv6Address(addr.getAddress());
        }
        int res = sendTo(this.f990fd, useIpv6(addr), buf, pos, limit, address, scopeId, port, fastOpen ? msgFastopen() : 0);
        if (res >= 0) {
            return res;
        }
        if (res == Errors.ERRNO_EINPROGRESS_NEGATIVE && fastOpen) {
            return 0;
        }
        if (res != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return Errors.ioResult("sendTo", res);
        }
        throw new PortUnreachableException("sendTo failed");
    }

    public final int sendToDomainSocket(ByteBuffer buf, int pos, int limit, byte[] path) throws IOException {
        int res = sendToDomainSocket(this.f990fd, buf, pos, limit, path);
        if (res >= 0) {
            return res;
        }
        return Errors.ioResult("sendToDomainSocket", res);
    }

    public final int sendToAddress(long memoryAddress, int pos, int limit, InetAddress addr, int port) throws IOException {
        return sendToAddress(memoryAddress, pos, limit, addr, port, false);
    }

    public final int sendToAddress(long memoryAddress, int pos, int limit, InetAddress addr, int port, boolean fastOpen) throws IOException {
        int scopeId;
        byte[] address;
        if (addr instanceof Inet6Address) {
            address = addr.getAddress();
            scopeId = ((Inet6Address) addr).getScopeId();
        } else {
            scopeId = 0;
            address = NativeInetAddress.ipv4MappedIpv6Address(addr.getAddress());
        }
        int res = sendToAddress(this.f990fd, useIpv6(addr), memoryAddress, pos, limit, address, scopeId, port, fastOpen ? msgFastopen() : 0);
        if (res >= 0) {
            return res;
        }
        if (res == Errors.ERRNO_EINPROGRESS_NEGATIVE && fastOpen) {
            return 0;
        }
        if (res != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return Errors.ioResult("sendToAddress", res);
        }
        throw new PortUnreachableException("sendToAddress failed");
    }

    public final int sendToAddressDomainSocket(long memoryAddress, int pos, int limit, byte[] path) throws IOException {
        int res = sendToAddressDomainSocket(this.f990fd, memoryAddress, pos, limit, path);
        if (res >= 0) {
            return res;
        }
        return Errors.ioResult("sendToAddressDomainSocket", res);
    }

    public final int sendToAddresses(long memoryAddress, int length, InetAddress addr, int port) throws IOException {
        return sendToAddresses(memoryAddress, length, addr, port, false);
    }

    public final int sendToAddresses(long memoryAddress, int length, InetAddress addr, int port, boolean fastOpen) throws IOException {
        int scopeId;
        byte[] address;
        if (addr instanceof Inet6Address) {
            address = addr.getAddress();
            scopeId = ((Inet6Address) addr).getScopeId();
        } else {
            scopeId = 0;
            address = NativeInetAddress.ipv4MappedIpv6Address(addr.getAddress());
        }
        int res = sendToAddresses(this.f990fd, useIpv6(addr), memoryAddress, length, address, scopeId, port, fastOpen ? msgFastopen() : 0);
        if (res >= 0) {
            return res;
        }
        if (res == Errors.ERRNO_EINPROGRESS_NEGATIVE && fastOpen) {
            return 0;
        }
        if (res != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return Errors.ioResult("sendToAddresses", res);
        }
        throw new PortUnreachableException("sendToAddresses failed");
    }

    public final int sendToAddressesDomainSocket(long memoryAddress, int length, byte[] path) throws IOException {
        int res = sendToAddressesDomainSocket(this.f990fd, memoryAddress, length, path);
        if (res >= 0) {
            return res;
        }
        return Errors.ioResult("sendToAddressesDomainSocket", res);
    }

    public final DatagramSocketAddress recvFrom(ByteBuffer buf, int pos, int limit) throws IOException {
        return recvFrom(this.f990fd, buf, pos, limit);
    }

    public final DatagramSocketAddress recvFromAddress(long memoryAddress, int pos, int limit) throws IOException {
        return recvFromAddress(this.f990fd, memoryAddress, pos, limit);
    }

    public final DomainDatagramSocketAddress recvFromDomainSocket(ByteBuffer buf, int pos, int limit) throws IOException {
        return recvFromDomainSocket(this.f990fd, buf, pos, limit);
    }

    public final DomainDatagramSocketAddress recvFromAddressDomainSocket(long memoryAddress, int pos, int limit) throws IOException {
        return recvFromAddressDomainSocket(this.f990fd, memoryAddress, pos, limit);
    }

    public final int recvFd() throws IOException {
        int res = recvFd(this.f990fd);
        if (res > 0) {
            return res;
        }
        if (res == 0) {
            return -1;
        }
        if (res == Errors.ERRNO_EAGAIN_NEGATIVE || res == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        throw Errors.newIOException("recvFd", res);
    }

    public final int sendFd(int fdToSend) throws IOException {
        int res = sendFd(this.f990fd, fdToSend);
        if (res >= 0) {
            return res;
        }
        if (res == Errors.ERRNO_EAGAIN_NEGATIVE || res == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return -1;
        }
        throw Errors.newIOException("sendFd", res);
    }

    public final boolean connect(SocketAddress socketAddress) throws IOException {
        int res;
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            InetAddress inetAddress = inetSocketAddress.getAddress();
            NativeInetAddress address = NativeInetAddress.newInstance(inetAddress);
            res = connect(this.f990fd, useIpv6(inetAddress), address.address, address.scopeId, inetSocketAddress.getPort());
        } else if (socketAddress instanceof DomainSocketAddress) {
            res = connectDomainSocket(this.f990fd, ((DomainSocketAddress) socketAddress).path().getBytes(CharsetUtil.UTF_8));
        } else {
            throw new Error("Unexpected SocketAddress implementation " + socketAddress);
        }
        if (res < 0) {
            return Errors.handleConnectErrno("connect", res);
        }
        return true;
    }

    public final boolean finishConnect() throws IOException {
        int res = finishConnect(this.f990fd);
        if (res < 0) {
            return Errors.handleConnectErrno("finishConnect", res);
        }
        return true;
    }

    public final void disconnect() throws IOException {
        int res = disconnect(this.f990fd, this.ipv6);
        if (res < 0) {
            Errors.handleConnectErrno("disconnect", res);
        }
    }

    public final void bind(SocketAddress socketAddress) throws IOException {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress addr = (InetSocketAddress) socketAddress;
            InetAddress inetAddress = addr.getAddress();
            NativeInetAddress address = NativeInetAddress.newInstance(inetAddress);
            int res = bind(this.f990fd, useIpv6(inetAddress), address.address, address.scopeId, addr.getPort());
            if (res < 0) {
                throw Errors.newIOException(Tmux.CMD_BIND, res);
            }
        } else if (socketAddress instanceof DomainSocketAddress) {
            int res2 = bindDomainSocket(this.f990fd, ((DomainSocketAddress) socketAddress).path().getBytes(CharsetUtil.UTF_8));
            if (res2 < 0) {
                throw Errors.newIOException(Tmux.CMD_BIND, res2);
            }
        } else {
            throw new Error("Unexpected SocketAddress implementation " + socketAddress);
        }
    }

    public final void listen(int backlog) throws IOException {
        int res = listen(this.f990fd, backlog);
        if (res < 0) {
            throw Errors.newIOException("listen", res);
        }
    }

    public final int accept(byte[] addr) throws IOException {
        int res = accept(this.f990fd, addr);
        if (res >= 0) {
            return res;
        }
        if (res == Errors.ERRNO_EAGAIN_NEGATIVE || res == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return -1;
        }
        throw Errors.newIOException("accept", res);
    }

    public final InetSocketAddress remoteAddress() {
        byte[] addr = remoteAddress(this.f990fd);
        if (addr == null) {
            return null;
        }
        return NativeInetAddress.address(addr, 0, addr.length);
    }

    public final InetSocketAddress localAddress() {
        byte[] addr = localAddress(this.f990fd);
        if (addr == null) {
            return null;
        }
        return NativeInetAddress.address(addr, 0, addr.length);
    }

    public final int getReceiveBufferSize() throws IOException {
        return getReceiveBufferSize(this.f990fd);
    }

    public final int getSendBufferSize() throws IOException {
        return getSendBufferSize(this.f990fd);
    }

    public final boolean isKeepAlive() throws IOException {
        return isKeepAlive(this.f990fd) != 0;
    }

    public final boolean isTcpNoDelay() throws IOException {
        return isTcpNoDelay(this.f990fd) != 0;
    }

    public final boolean isReuseAddress() throws IOException {
        return isReuseAddress(this.f990fd) != 0;
    }

    public final boolean isReusePort() throws IOException {
        return isReusePort(this.f990fd) != 0;
    }

    public final boolean isBroadcast() throws IOException {
        return isBroadcast(this.f990fd) != 0;
    }

    public final int getSoLinger() throws IOException {
        return getSoLinger(this.f990fd);
    }

    public final int getSoError() throws IOException {
        return getSoError(this.f990fd);
    }

    public final int getTrafficClass() throws IOException {
        return getTrafficClass(this.f990fd, this.ipv6);
    }

    public final void setKeepAlive(boolean keepAlive) throws IOException {
        setKeepAlive(this.f990fd, keepAlive ? 1 : 0);
    }

    public final void setReceiveBufferSize(int receiveBufferSize) throws IOException {
        setReceiveBufferSize(this.f990fd, receiveBufferSize);
    }

    public final void setSendBufferSize(int sendBufferSize) throws IOException {
        setSendBufferSize(this.f990fd, sendBufferSize);
    }

    public final void setTcpNoDelay(boolean tcpNoDelay) throws IOException {
        setTcpNoDelay(this.f990fd, tcpNoDelay ? 1 : 0);
    }

    public final void setSoLinger(int soLinger) throws IOException {
        setSoLinger(this.f990fd, soLinger);
    }

    public final void setReuseAddress(boolean reuseAddress) throws IOException {
        setReuseAddress(this.f990fd, reuseAddress ? 1 : 0);
    }

    public final void setReusePort(boolean reusePort) throws IOException {
        setReusePort(this.f990fd, reusePort ? 1 : 0);
    }

    public final void setBroadcast(boolean broadcast) throws IOException {
        setBroadcast(this.f990fd, broadcast ? 1 : 0);
    }

    public final void setTrafficClass(int trafficClass) throws IOException {
        setTrafficClass(this.f990fd, this.ipv6, trafficClass);
    }

    public void setIntOpt(int level, int optname, int optvalue) throws IOException {
        setIntOpt(this.f990fd, level, optname, optvalue);
    }

    public void setRawOpt(int level, int optname, ByteBuffer optvalue) throws IOException {
        int limit = optvalue.limit();
        if (optvalue.isDirect()) {
            setRawOptAddress(this.f990fd, level, optname, Buffer.memoryAddress(optvalue) + ((long) optvalue.position()), optvalue.remaining());
        } else if (optvalue.hasArray()) {
            setRawOptArray(this.f990fd, level, optname, optvalue.array(), optvalue.arrayOffset() + optvalue.position(), optvalue.remaining());
        } else {
            byte[] bytes = new byte[optvalue.remaining()];
            optvalue.duplicate().get(bytes);
            setRawOptArray(this.f990fd, level, optname, bytes, 0, bytes.length);
        }
        optvalue.position(limit);
    }

    public int getIntOpt(int level, int optname) throws IOException {
        return getIntOpt(this.f990fd, level, optname);
    }

    public void getRawOpt(int level, int optname, ByteBuffer out) throws IOException {
        if (out.isDirect()) {
            getRawOptAddress(this.f990fd, level, optname, Buffer.memoryAddress(out) + ((long) out.position()), out.remaining());
        } else if (out.hasArray()) {
            getRawOptArray(this.f990fd, level, optname, out.array(), out.position() + out.arrayOffset(), out.remaining());
        } else {
            byte[] outArray = new byte[out.remaining()];
            getRawOptArray(this.f990fd, level, optname, outArray, 0, outArray.length);
            out.put(outArray);
        }
        out.position(out.limit());
    }

    public static boolean isIPv6Preferred() {
        return isIpv6Preferred;
    }

    public static boolean shouldUseIpv6(InternetProtocolFamily family) {
        return family == null ? isIPv6Preferred() : family == InternetProtocolFamily.IPv6;
    }

    @Override // p013io.netty.channel.unix.FileDescriptor
    public String toString() {
        return "Socket{fd=" + this.f990fd + '}';
    }

    public static Socket newSocketStream() {
        return new Socket(newSocketStream0());
    }

    public static Socket newSocketDgram() {
        return new Socket(newSocketDgram0());
    }

    public static Socket newSocketDomain() {
        return new Socket(newSocketDomain0());
    }

    public static Socket newSocketDomainDgram() {
        return new Socket(newSocketDomainDgram0());
    }

    public static void initialize() {
        isIpv6Preferred = isIPv6Preferred0(NetUtil.isIpV4StackPreferred());
    }

    protected static int newSocketStream0() {
        return newSocketStream0(isIPv6Preferred());
    }

    protected static int newSocketStream0(InternetProtocolFamily protocol) {
        return newSocketStream0(shouldUseIpv6(protocol));
    }

    protected static int newSocketStream0(boolean ipv6) {
        int res = newSocketStreamFd(ipv6);
        if (res >= 0) {
            return res;
        }
        throw new ChannelException(Errors.newIOException("newSocketStream", res));
    }

    protected static int newSocketDgram0() {
        return newSocketDgram0(isIPv6Preferred());
    }

    protected static int newSocketDgram0(InternetProtocolFamily family) {
        return newSocketDgram0(shouldUseIpv6(family));
    }

    protected static int newSocketDgram0(boolean ipv6) {
        int res = newSocketDgramFd(ipv6);
        if (res >= 0) {
            return res;
        }
        throw new ChannelException(Errors.newIOException("newSocketDgram", res));
    }

    protected static int newSocketDomain0() {
        int res = newSocketDomainFd();
        if (res >= 0) {
            return res;
        }
        throw new ChannelException(Errors.newIOException("newSocketDomain", res));
    }

    protected static int newSocketDomainDgram0() {
        int res = newSocketDomainDgramFd();
        if (res >= 0) {
            return res;
        }
        throw new ChannelException(Errors.newIOException("newSocketDomainDgram", res));
    }
}
