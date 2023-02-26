package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.TakeoffEquipReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketTakeoffEquipRsp;

@Opcodes(669)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerTakeoffEquipReq.class */
public class HandlerTakeoffEquipReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        TakeoffEquipReqOuterClass.TakeoffEquipReq req = TakeoffEquipReqOuterClass.TakeoffEquipReq.parseFrom(payload);
        if (session.getPlayer().getInventory().unequipItem(req.getAvatarGuid(), req.getSlot())) {
            session.send(new PacketTakeoffEquipRsp(req.getAvatarGuid(), req.getSlot()));
        }
    }
}
