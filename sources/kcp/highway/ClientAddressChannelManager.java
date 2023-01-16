package kcp.highway;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p013io.netty.channel.socket.DatagramPacket;

/* loaded from: grasscutter.jar:kcp/highway/ClientAddressChannelManager.class */
public class ClientAddressChannelManager implements IChannelManager {
    private Map<SocketAddress, Ukcp> ukcpMap = new ConcurrentHashMap();

    @Override // kcp.highway.IChannelManager
    public Ukcp get(DatagramPacket msg) {
        return this.ukcpMap.get(msg.recipient());
    }

    @Override // kcp.highway.IChannelManager
    public void New(SocketAddress socketAddress, Ukcp ukcp, DatagramPacket msg) {
        this.ukcpMap.put(socketAddress, ukcp);
    }

    @Override // kcp.highway.IChannelManager
    public void del(Ukcp ukcp) {
        this.ukcpMap.remove(ukcp.user().getLocalAddress());
        ukcp.user().getChannel().close();
    }

    @Override // kcp.highway.IChannelManager
    public Collection<Ukcp> getAll() {
        return this.ukcpMap.values();
    }
}
