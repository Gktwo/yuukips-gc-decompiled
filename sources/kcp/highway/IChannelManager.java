package kcp.highway;

import java.net.SocketAddress;
import java.util.Collection;
import p013io.netty.channel.socket.DatagramPacket;

/* loaded from: grasscutter.jar:kcp/highway/IChannelManager.class */
public interface IChannelManager {
    Ukcp get(DatagramPacket datagramPacket);

    void New(SocketAddress socketAddress, Ukcp ukcp, DatagramPacket datagramPacket);

    void del(Ukcp ukcp);

    Collection<Ukcp> getAll();
}
