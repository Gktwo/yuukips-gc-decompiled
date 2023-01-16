package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.CanUseSkillNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCanUseSkillNotify.class */
public class PacketCanUseSkillNotify extends BasePacket {
    public PacketCanUseSkillNotify(boolean canUseSkill) {
        super(PacketOpcodes.CanUseSkillNotify);
        setData(CanUseSkillNotifyOuterClass.CanUseSkillNotify.newBuilder().setIsCanUseSkill(canUseSkill).build());
    }
}
