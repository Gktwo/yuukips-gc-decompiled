package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityUpdateWatcherNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketActivityUpdateWatcherNotify.class */
public class PacketActivityUpdateWatcherNotify extends BasePacket {
    public PacketActivityUpdateWatcherNotify(int activityId, PlayerActivityData.WatcherInfo watcherInfo) {
        super(PacketOpcodes.ActivityUpdateWatcherNotify);
        ActivityUpdateWatcherNotifyOuterClass.ActivityUpdateWatcherNotify.Builder proto = ActivityUpdateWatcherNotifyOuterClass.ActivityUpdateWatcherNotify.newBuilder();
        proto.setActivityId(activityId).setWatcherInfo(watcherInfo.toProto());
        setData(proto);
    }
}
