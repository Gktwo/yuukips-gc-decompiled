package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.TakeAchievementRewardReqOuterClass;
import emu.grasscutter.server.game.GameSession;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketTakeAchievementRewardReq.class */
public class PacketTakeAchievementRewardReq extends BasePacket {
    public PacketTakeAchievementRewardReq(GameSession session) {
        super(PacketOpcodes.TakeAchievementRewardReq);
        setData(TakeAchievementRewardReqOuterClass.TakeAchievementRewardReq.newBuilder().build());
    }
}
