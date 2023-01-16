package kcp.highway;

import kcp.highway.erasure.fec.Snmp;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.socket.DatagramPacket;

/* loaded from: grasscutter.jar:kcp/highway/KcpOutPutImp.class */
public class KcpOutPutImp implements KcpOutput {
    @Override // kcp.highway.KcpOutput
    public void out(ByteBuf data, IKcp kcp2) {
        Snmp.snmp.OutPkts.increment();
        Snmp.snmp.OutBytes.add((long) data.writerIndex());
        User user = (User) kcp2.getUser();
        user.getChannel().writeAndFlush(new DatagramPacket(data, user.getRemoteAddress(), user.getLocalAddress()));
    }
}
