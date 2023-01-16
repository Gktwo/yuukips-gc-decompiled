package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.TakePlayerLevelRewardRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketTakePlayerLevelRewardRsp.class */
public class PacketTakePlayerLevelRewardRsp extends BasePacket {
    public PacketTakePlayerLevelRewardRsp(int level, int rewardId) {
        super(163);
        setData(TakePlayerLevelRewardRspOuterClass.TakePlayerLevelRewardRsp.newBuilder().setLevel(level).setRewardId(rewardId).setRetcode(rewardId == 0 ? 1 : 0).build());
    }
}
