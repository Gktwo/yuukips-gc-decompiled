package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSetWidgetSlotRsp.class */
public class PacketSetWidgetSlotRsp extends BasePacket {
    public PacketSetWidgetSlotRsp(int materialId) {
        super(PacketOpcodes.SetWidgetSlotRsp);
        setData(SetWidgetSlotRspOuterClass.SetWidgetSlotRsp.newBuilder().setRetcode(0).setMaterialId(materialId).build());
    }
}
