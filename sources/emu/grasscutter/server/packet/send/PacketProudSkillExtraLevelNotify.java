package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ProudSkillExtraLevelNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketProudSkillExtraLevelNotify.class */
public class PacketProudSkillExtraLevelNotify extends BasePacket {
    public PacketProudSkillExtraLevelNotify(Avatar avatar, int talentIndex) {
        super(PacketOpcodes.ProudSkillExtraLevelNotify);
        setData(ProudSkillExtraLevelNotifyOuterClass.ProudSkillExtraLevelNotify.newBuilder().setAvatarGuid(avatar.getGuid()).setTalentType(3).setTalentIndex(talentIndex).setExtraLevel(3).build());
    }
}
