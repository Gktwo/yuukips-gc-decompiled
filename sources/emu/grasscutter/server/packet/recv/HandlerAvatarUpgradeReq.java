package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarUpgradeReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.AvatarUpgradeReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerAvatarUpgradeReq.class */
public class HandlerAvatarUpgradeReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        AvatarUpgradeReqOuterClass.AvatarUpgradeReq req = AvatarUpgradeReqOuterClass.AvatarUpgradeReq.parseFrom(payload);
        session.getServer().getInventorySystem().upgradeAvatar(session.getPlayer(), req.getAvatarGuid(), req.getItemId(), req.getCount());
    }
}
