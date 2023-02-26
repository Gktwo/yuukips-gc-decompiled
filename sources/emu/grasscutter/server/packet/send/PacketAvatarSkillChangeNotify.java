package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarSkillChangeNotify.class */
public class PacketAvatarSkillChangeNotify extends BasePacket {
    public PacketAvatarSkillChangeNotify(Avatar avatar, int skillId, int oldLevel, int curLevel) {
        super(PacketOpcodes.AvatarSkillChangeNotify);
        setData(AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotify.newBuilder().setAvatarGuid(avatar.getGuid()).setEntityId(avatar.getEntityId()).setSkillDepotId(avatar.getSkillDepotId()).setAvatarSkillId(skillId).setOldLevel(oldLevel).setCurLevel(curLevel).build());
    }
}
