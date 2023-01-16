package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.FurnitureMakeStartReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.FurnitureMakeStartReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerFurnitureMakeStartReq.class */
public class HandlerFurnitureMakeStartReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        FurnitureMakeStartReqOuterClass.FurnitureMakeStartReq req = FurnitureMakeStartReqOuterClass.FurnitureMakeStartReq.parseFrom(payload);
        session.getPlayer().getFurnitureManager().startMake(req.getMakeId(), req.getAvatarId());
    }
}
