package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AvatarSkillMaxChargeCountNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarSkillMaxChargeCountNotify.class */
public class PacketAvatarSkillMaxChargeCountNotify extends BasePacket {
    public PacketAvatarSkillMaxChargeCountNotify(Avatar avatar, int skillId, int maxCharges) {
        super(1080);
        setData(AvatarSkillMaxChargeCountNotifyOuterClass.AvatarSkillMaxChargeCountNotify.newBuilder().setAvatarGuid(avatar.getGuid()).setSkillId(skillId).setMaxChargeCount(maxCharges).build());
    }
}
