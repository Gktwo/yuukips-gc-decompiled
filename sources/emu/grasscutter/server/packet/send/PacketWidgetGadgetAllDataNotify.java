package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.WidgetGadgetAllDataNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWidgetGadgetAllDataNotify.class */
public class PacketWidgetGadgetAllDataNotify extends BasePacket {
    public PacketWidgetGadgetAllDataNotify() {
        super(PacketOpcodes.AllWidgetDataNotify);
        setData(WidgetGadgetAllDataNotifyOuterClass.WidgetGadgetAllDataNotify.newBuilder().build());
    }
}
