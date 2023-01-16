package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.WeaponAwakenReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(633)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerWeaponAwakenReq.class */
public class HandlerWeaponAwakenReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        WeaponAwakenReqOuterClass.WeaponAwakenReq req = WeaponAwakenReqOuterClass.WeaponAwakenReq.parseFrom(payload);
        session.getServer().getInventorySystem().refineWeapon(session.getPlayer(), req.getTargetWeaponGuid(), req.getItemGuid());
    }
}
