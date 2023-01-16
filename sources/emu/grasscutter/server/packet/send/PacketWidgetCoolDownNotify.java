package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.WidgetCoolDownDataOuterClass;
import emu.grasscutter.net.proto.WidgetCoolDownNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWidgetCoolDownNotify.class */
public class PacketWidgetCoolDownNotify extends BasePacket {
    public PacketWidgetCoolDownNotify(int id, long coolDownTime, boolean isSuccess) {
        super(PacketOpcodes.WidgetCoolDownNotify);
        setData(WidgetCoolDownNotifyOuterClass.WidgetCoolDownNotify.newBuilder().addGroupCoolDownDataList(WidgetCoolDownDataOuterClass.WidgetCoolDownData.newBuilder().setId(id).setCoolDownTime(coolDownTime).setIsSuccess(isSuccess).build()).build());
    }
}
