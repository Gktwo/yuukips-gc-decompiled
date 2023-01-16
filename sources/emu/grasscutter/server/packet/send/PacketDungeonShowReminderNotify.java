package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DungeonShowReminderNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDungeonShowReminderNotify.class */
public class PacketDungeonShowReminderNotify extends BasePacket {
    public PacketDungeonShowReminderNotify(int reminderId) {
        super(999);
        DungeonShowReminderNotifyOuterClass.DungeonShowReminderNotify.Builder proto = DungeonShowReminderNotifyOuterClass.DungeonShowReminderNotify.newBuilder();
        proto.setReminderId(reminderId);
        setData(proto);
    }
}
