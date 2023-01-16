package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarSkillInfoNotifyOuterClass;
import emu.grasscutter.net.proto.AvatarSkillInfoOuterClass;
import p014it.unimi.dsi.fastutil.ints.Int2IntMap;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarSkillInfoNotify.class */
public class PacketAvatarSkillInfoNotify extends BasePacket {
    public PacketAvatarSkillInfoNotify(long avatarGuid, Int2IntMap skillExtraChargeMap) {
        super(PacketOpcodes.AvatarSkillInfoNotify);
        AvatarSkillInfoNotifyOuterClass.AvatarSkillInfoNotify.Builder proto = AvatarSkillInfoNotifyOuterClass.AvatarSkillInfoNotify.newBuilder().setGuid(avatarGuid);
        skillExtraChargeMap.forEach(skillId, count -> {
            proto.putSkillMap(skillId.intValue(), AvatarSkillInfoOuterClass.AvatarSkillInfo.newBuilder().setMaxChargeCount(count.intValue()).build());
        });
        setData(proto);
    }
}
