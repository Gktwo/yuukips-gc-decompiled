package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.PacketHeadOuterClass;
import emu.grasscutter.net.proto.PingReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPingRsp;

@Opcodes(20)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPingReq.class */
public class HandlerPingReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PacketHeadOuterClass.PacketHead head = PacketHeadOuterClass.PacketHead.parseFrom(header);
        PingReqOuterClass.PingReq ping = PingReqOuterClass.PingReq.parseFrom(payload);
        session.updateLastPingTime(ping.getClientTime());
        session.send(new PacketPingRsp(head.getClientSequenceId(), ping.getClientTime()));
    }
}
