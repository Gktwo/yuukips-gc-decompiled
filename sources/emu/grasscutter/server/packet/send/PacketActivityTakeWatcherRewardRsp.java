package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ActivityTakeWatcherRewardRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketActivityTakeWatcherRewardRsp.class */
public class PacketActivityTakeWatcherRewardRsp extends BasePacket {
    public PacketActivityTakeWatcherRewardRsp(int activityId, int watcherId) {
        super(2009);
        ActivityTakeWatcherRewardRspOuterClass.ActivityTakeWatcherRewardRsp.Builder proto = ActivityTakeWatcherRewardRspOuterClass.ActivityTakeWatcherRewardRsp.newBuilder();
        proto.setActivityId(activityId).setWatcherId(watcherId);
        setData(proto);
    }
}
