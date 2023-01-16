package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityInfoNotifyOuterClass;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketActivityInfoNotify.class */
public class PacketActivityInfoNotify extends BasePacket {
    public PacketActivityInfoNotify(ActivityInfoOuterClass.ActivityInfo activityInfo) {
        super(PacketOpcodes.ActivityInfoNotify);
        ActivityInfoNotifyOuterClass.ActivityInfoNotify.Builder proto = ActivityInfoNotifyOuterClass.ActivityInfoNotify.newBuilder();
        proto.setActivityInfo(activityInfo);
        setData(proto);
    }
}
