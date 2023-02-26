package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.ReliquaryDecomposeReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(640)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerReliquaryDecomposeReq.class */
public class HandlerReliquaryDecomposeReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReq req = ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReq.parseFrom(payload);
        session.getServer().getCombineSystem().decomposeReliquaries(session.getPlayer(), req.getConfigId(), req.getTargetCount(), req.getGuidListList());
    }
}
