package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.WeaponPromoteReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(637)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerWeaponPromoteReq.class */
public class HandlerWeaponPromoteReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getServer().getInventorySystem().promoteWeapon(session.getPlayer(), WeaponPromoteReqOuterClass.WeaponPromoteReq.parseFrom(payload).getTargetWeaponGuid());
    }
}
