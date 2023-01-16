package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarUpgradeRsp.class */
public class PacketAvatarUpgradeRsp extends BasePacket {
    public PacketAvatarUpgradeRsp(Avatar avatar, int oldLevel, Map<Integer, Float> oldFightPropMap) {
        super(PacketOpcodes.AvatarUpgradeRsp);
        buildHeader(0);
        setData(AvatarUpgradeRspOuterClass.AvatarUpgradeRsp.newBuilder().setAvatarGuid(avatar.getGuid()).setOldLevel(oldLevel).setCurLevel(avatar.getLevel()).putAllOldFightPropMap(oldFightPropMap).putAllCurFightPropMap(avatar.getFightProperties()).build());
    }
}
