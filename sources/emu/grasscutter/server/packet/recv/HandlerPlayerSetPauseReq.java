package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.PacketHeadOuterClass;
import emu.grasscutter.net.proto.PlayerSetPauseReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPlayerSetPauseRsp;

@Opcodes(153)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPlayerSetPauseReq.class */
public class HandlerPlayerSetPauseReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PacketHeadOuterClass.PacketHead head = PacketHeadOuterClass.PacketHead.parseFrom(header);
        PlayerSetPauseReqOuterClass.PlayerSetPauseReq req = PlayerSetPauseReqOuterClass.PlayerSetPauseReq.parseFrom(payload);
        session.send(new PacketPlayerSetPauseRsp(head.getClientSequenceId()));
        session.getPlayer().setPaused(req.getIsPaused());
    }
}
