package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarUnlockTalentNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarUnlockTalentNotify.class */
public class PacketAvatarUnlockTalentNotify extends BasePacket {
    public PacketAvatarUnlockTalentNotify(Avatar avatar, int talentId) {
        super(PacketOpcodes.AvatarUnlockTalentNotify);
        setData(AvatarUnlockTalentNotifyOuterClass.AvatarUnlockTalentNotify.newBuilder().setAvatarGuid(avatar.getGuid()).setEntityId(avatar.getEntityId()).setTalentId(talentId).setSkillDepotId(avatar.getSkillDepotId()).build());
    }
}
