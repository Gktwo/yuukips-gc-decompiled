package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.DestroyMaterialReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(601)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerDestroyMaterialReq.class */
public class HandlerDestroyMaterialReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getServer().getInventorySystem().destroyMaterial(session.getPlayer(), DestroyMaterialReqOuterClass.DestroyMaterialReq.parseFrom(payload).getMaterialListList());
    }
}
