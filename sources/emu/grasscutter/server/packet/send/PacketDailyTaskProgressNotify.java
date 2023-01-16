package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DailyTaskInfoOuterClass;
import emu.grasscutter.net.proto.DailyTaskProgressNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDailyTaskProgressNotify.class */
public class PacketDailyTaskProgressNotify extends BasePacket {
    public PacketDailyTaskProgressNotify(DailyTaskInfoOuterClass.DailyTaskInfo info) {
        super(149);
        setData(DailyTaskProgressNotifyOuterClass.DailyTaskProgressNotify.newBuilder().setInfo(info).build());
    }
}
