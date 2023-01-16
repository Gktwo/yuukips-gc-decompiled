package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarFetterLevelRewardRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarFetterLevelRewardRsp.class */
public class PacketAvatarFetterLevelRewardRsp extends BasePacket {
    public PacketAvatarFetterLevelRewardRsp(long guid, int fetterLevel, int rewardId) {
        super(PacketOpcodes.AvatarFetterLevelRewardRsp);
        setData(AvatarFetterLevelRewardRspOuterClass.AvatarFetterLevelRewardRsp.newBuilder().setAvatarGuid(guid).setFetterLevel(fetterLevel).setRetcode(0).setRewardId(rewardId).build());
    }

    public PacketAvatarFetterLevelRewardRsp(long guid, int fetterLevel) {
        super(PacketOpcodes.AvatarFetterLevelRewardRsp);
        setData(AvatarFetterLevelRewardRspOuterClass.AvatarFetterLevelRewardRsp.newBuilder().setAvatarGuid(guid).setFetterLevel(fetterLevel).setRetcode(1).setRewardId(0).build());
    }
}
