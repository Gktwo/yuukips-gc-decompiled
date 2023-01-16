package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.activity.ActivityConfigItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass;
import emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass;
import java.util.Collection;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketActivityScheduleInfoNotify.class */
public class PacketActivityScheduleInfoNotify extends BasePacket {
    public PacketActivityScheduleInfoNotify(Collection<ActivityConfigItem> activityConfigItemList) {
        super(PacketOpcodes.ActivityScheduleInfoNotify);
        ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotify.Builder proto = ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotify.newBuilder();
        activityConfigItemList.forEach(item -> {
            proto.addActivityScheduleList(ActivityScheduleInfoOuterClass.ActivityScheduleInfo.newBuilder().setActivityId(item.getActivityId()).setScheduleId(item.getScheduleId()).setIsOpen(true).setBeginTime(item.getBeginTime()).setEndTime(item.getEndTime()).build());
        });
        setData(proto);
    }
}
