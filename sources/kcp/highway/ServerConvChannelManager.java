package kcp.highway;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.socket.DatagramPacket;

/* loaded from: grasscutter.jar:kcp/highway/ServerConvChannelManager.class */
public class ServerConvChannelManager implements IChannelManager {
    private final int convIndex;
    private final Map<Long, Ukcp> ukcpMap = new ConcurrentHashMap();

    public ServerConvChannelManager(int convIndex) {
        this.convIndex = convIndex;
    }

    @Override // kcp.highway.IChannelManager
    public Ukcp get(DatagramPacket msg) {
        return this.ukcpMap.get(Long.valueOf(getConv(msg)));
    }

    public boolean convExists(long conv) {
        return this.ukcpMap.containsKey(Long.valueOf(conv));
    }

    private long getConv(DatagramPacket msg) {
        ByteBuf byteBuf = (ByteBuf) msg.content();
        return byteBuf.getLong(byteBuf.readerIndex() + this.convIndex);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    @Override // kcp.highway.IChannelManager
    public void New(SocketAddress socketAddress, Ukcp ukcp, DatagramPacket msg) {
        char conv = ukcp.getConv();
        if (msg != null && conv == 0) {
            conv = getConv(msg);
            ukcp.setConv(conv);
        }
        this.ukcpMap.put(Long.valueOf(conv), ukcp);
    }

    @Override // kcp.highway.IChannelManager
    public void del(Ukcp ukcp) {
        this.ukcpMap.remove(Long.valueOf(ukcp.getConv()));
    }

    @Override // kcp.highway.IChannelManager
    public Collection<Ukcp> getAll() {
        return this.ukcpMap.values();
    }
}
