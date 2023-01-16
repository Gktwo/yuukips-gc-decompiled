package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DailyTaskDataNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDailyTaskDataNotify.class */
public class PacketDailyTaskDataNotify extends BasePacket {
    public PacketDailyTaskDataNotify(int finished, int scoreRewardId) {
        super(124);
        setData(DailyTaskDataNotifyOuterClass.DailyTaskDataNotify.newBuilder().setFinishedNum(finished).setScoreRewardId(scoreRewardId).build());
    }
}
