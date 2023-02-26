package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.SetEquipLockStateReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(684)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetEquipLockStateReq.class */
public class HandlerSetEquipLockStateReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SetEquipLockStateReqOuterClass.SetEquipLockStateReq req = SetEquipLockStateReqOuterClass.SetEquipLockStateReq.parseFrom(payload);
        session.getServer().getInventorySystem().lockEquip(session.getPlayer(), req.getTargetEquipGuid(), req.getIsLocked());
    }
}
