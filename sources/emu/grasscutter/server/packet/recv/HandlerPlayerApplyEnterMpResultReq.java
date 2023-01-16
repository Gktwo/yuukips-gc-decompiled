package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerApplyEnterMpResultReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPlayerApplyEnterMpResultRsp;

@Opcodes(PacketOpcodes.PlayerApplyEnterMpResultReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPlayerApplyEnterMpResultReq.class */
public class HandlerPlayerApplyEnterMpResultReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PlayerApplyEnterMpResultReqOuterClass.PlayerApplyEnterMpResultReq req = PlayerApplyEnterMpResultReqOuterClass.PlayerApplyEnterMpResultReq.parseFrom(payload);
        session.getServer().getMultiplayerSystem().applyEnterMpReply(session.getPlayer(), req.getApplyUid(), req.getIsAgreed());
        session.send(new PacketPlayerApplyEnterMpResultRsp(req.getApplyUid(), req.getIsAgreed()));
    }
}
