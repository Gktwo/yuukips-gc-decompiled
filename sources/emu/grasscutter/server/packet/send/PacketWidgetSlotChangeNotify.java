package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.WidgetSlotChangeNotifyOuterClass;
import emu.grasscutter.net.proto.WidgetSlotDataOuterClass;
import emu.grasscutter.net.proto.WidgetSlotOpOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWidgetSlotChangeNotify.class */
public class PacketWidgetSlotChangeNotify extends BasePacket {
    public PacketWidgetSlotChangeNotify(WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotify proto) {
        super(PacketOpcodes.WidgetSlotChangeNotify);
        setData(proto);
    }

    public PacketWidgetSlotChangeNotify(WidgetSlotOpOuterClass.WidgetSlotOp op) {
        super(PacketOpcodes.WidgetSlotChangeNotify);
        setData(WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotify.newBuilder().setOp(op).setSlot(WidgetSlotDataOuterClass.WidgetSlotData.newBuilder().setIsActive(true).build()).build());
    }

    public PacketWidgetSlotChangeNotify(int materialId) {
        super(PacketOpcodes.WidgetSlotChangeNotify);
        setData(WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotify.newBuilder().setSlot(WidgetSlotDataOuterClass.WidgetSlotData.newBuilder().setIsActive(true).setMaterialId(materialId).build()).build());
    }
}
