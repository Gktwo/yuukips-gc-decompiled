package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.WidgetDoBagRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWidgetDoBagRsp.class */
public class PacketWidgetDoBagRsp extends BasePacket {
    public PacketWidgetDoBagRsp(int materialId) {
        super(PacketOpcodes.WidgetDoBagRsp);
        setData(WidgetDoBagRspOuterClass.WidgetDoBagRsp.newBuilder().setMaterialId(materialId).setRetcode(0).build());
    }

    public PacketWidgetDoBagRsp() {
        super(PacketOpcodes.WidgetDoBagRsp);
        setData(WidgetDoBagRspOuterClass.WidgetDoBagRsp.newBuilder().build());
    }
}
