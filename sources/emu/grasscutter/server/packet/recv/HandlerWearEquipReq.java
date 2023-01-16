package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.WearEquipReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketWearEquipRsp;

@Opcodes(699)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerWearEquipReq.class */
public class HandlerWearEquipReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        WearEquipReqOuterClass.WearEquipReq req = WearEquipReqOuterClass.WearEquipReq.parseFrom(payload);
        if (session.getPlayer().getInventory().equipItem(req.getAvatarGuid(), req.getEquipGuid())) {
            session.send(new PacketWearEquipRsp(req.getAvatarGuid(), req.getEquipGuid()));
        }
    }
}
