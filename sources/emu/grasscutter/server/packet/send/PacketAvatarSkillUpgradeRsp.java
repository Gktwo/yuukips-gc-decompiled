package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarSkillUpgradeRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarSkillUpgradeRsp.class */
public class PacketAvatarSkillUpgradeRsp extends BasePacket {
    public PacketAvatarSkillUpgradeRsp(Avatar avatar, int skillId, int oldLevel, int newLevel) {
        super(PacketOpcodes.AvatarSkillUpgradeRsp);
        setData(AvatarSkillUpgradeRspOuterClass.AvatarSkillUpgradeRsp.newBuilder().setAvatarGuid(avatar.getGuid()).setAvatarSkillId(skillId).setOldLevel(oldLevel).setCurLevel(newLevel).build());
    }
}
