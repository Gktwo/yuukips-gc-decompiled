package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.PlayerCompoundMaterialReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(146)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPlayerCompoundMaterialReq.class */
public class HandlerPlayerCompoundMaterialReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getCookingCompoundManager().handlePlayerCompoundMaterialReq(PlayerCompoundMaterialReqOuterClass.PlayerCompoundMaterialReq.parseFrom(payload));
    }
}
