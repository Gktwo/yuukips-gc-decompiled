package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.activity.ActivityManager;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetActivityInfoRspOuterClass;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetActivityInfoRsp.class */
public class PacketGetActivityInfoRsp extends BasePacket {
    public PacketGetActivityInfoRsp(Set<Integer> activityIdList, ActivityManager activityManager) {
        super(PacketOpcodes.GetActivityInfoRsp);
        GetActivityInfoRspOuterClass.GetActivityInfoRsp.Builder proto = GetActivityInfoRspOuterClass.GetActivityInfoRsp.newBuilder();
        Stream<R> map = activityIdList.stream().map(arg0 -> {
            return activityManager.getInfoProtoByActivityId(arg0.intValue());
        });
        Objects.requireNonNull(proto);
        map.forEach(this::addActivityInfoList);
        setData(proto);
    }
}
