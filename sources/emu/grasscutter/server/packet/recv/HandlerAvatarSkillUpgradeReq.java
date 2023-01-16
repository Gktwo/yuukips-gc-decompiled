package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarSkillUpgradeReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.AvatarSkillUpgradeReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerAvatarSkillUpgradeReq.class */
public class HandlerAvatarSkillUpgradeReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        AvatarSkillUpgradeReqOuterClass.AvatarSkillUpgradeReq req = AvatarSkillUpgradeReqOuterClass.AvatarSkillUpgradeReq.parseFrom(payload);
        Avatar avatar = session.getPlayer().getAvatars().getAvatarByGuid(req.getAvatarGuid());
        if (avatar != null) {
            avatar.upgradeSkill(req.getAvatarSkillId());
        }
    }
}
