package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(616)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerWeaponUpgradeReq.class */
public class HandlerWeaponUpgradeReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        WeaponUpgradeReqOuterClass.WeaponUpgradeReq req = WeaponUpgradeReqOuterClass.WeaponUpgradeReq.parseFrom(payload);
        session.getServer().getInventorySystem().upgradeWeapon(session.getPlayer(), req.getTargetWeaponGuid(), req.getFoodWeaponGuidListList(), req.getItemParamListList());
    }
}
