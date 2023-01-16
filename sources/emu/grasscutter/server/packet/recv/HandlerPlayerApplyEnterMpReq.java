package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerApplyEnterMpReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPlayerApplyEnterMpRsp;

@Opcodes(PacketOpcodes.PlayerApplyEnterMpReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPlayerApplyEnterMpReq.class */
public class HandlerPlayerApplyEnterMpReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PlayerApplyEnterMpReqOuterClass.PlayerApplyEnterMpReq req = PlayerApplyEnterMpReqOuterClass.PlayerApplyEnterMpReq.parseFrom(payload);
        session.getServer().getMultiplayerSystem().applyEnterMp(session.getPlayer(), req.getTargetUid());
        session.send(new PacketPlayerApplyEnterMpRsp(req.getTargetUid()));
    }
}
