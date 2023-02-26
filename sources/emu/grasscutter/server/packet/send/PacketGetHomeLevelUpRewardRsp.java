package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetHomeLevelUpRewardRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetHomeLevelUpRewardRsp.class */
public class PacketGetHomeLevelUpRewardRsp extends BasePacket {
    public PacketGetHomeLevelUpRewardRsp(int level, int rewardId) {
        super(PacketOpcodes.GetHomeLevelUpRewardRsp);
        setData(GetHomeLevelUpRewardRspOuterClass.GetHomeLevelUpRewardRsp.newBuilder().setLevel(level).setRetcode(rewardId == 0 ? 1 : 0).build());
    }
}
