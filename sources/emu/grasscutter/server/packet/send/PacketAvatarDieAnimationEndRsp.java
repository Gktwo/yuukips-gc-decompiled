package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarDieAnimationEndRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarDieAnimationEndRsp.class */
public class PacketAvatarDieAnimationEndRsp extends BasePacket {
    public PacketAvatarDieAnimationEndRsp(long dieGuid, int skillId) {
        super(PacketOpcodes.AvatarDieAnimationEndRsp);
        setData(AvatarDieAnimationEndRspOuterClass.AvatarDieAnimationEndRsp.newBuilder().setDieGuid(dieGuid).setSkillId(skillId).build());
    }
}
