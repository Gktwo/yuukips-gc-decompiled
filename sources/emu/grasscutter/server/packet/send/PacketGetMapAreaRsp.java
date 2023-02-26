package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetMapAreaRspOuterClass;
import emu.grasscutter.net.proto.MapAreaInfoOuterClass;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetMapAreaRsp.class */
public class PacketGetMapAreaRsp extends BasePacket {
    public PacketGetMapAreaRsp() {
        super(PacketOpcodes.GetMapAreaRsp);
        Map<Integer, Boolean> data = Map.ofEntries(Map.entry(11, true), Map.entry(34, true), Map.entry(23, true), Map.entry(3, true), Map.entry(14, true), Map.entry(37, true), Map.entry(17, true), Map.entry(41, true), Map.entry(18, true), Map.entry(24, true), Map.entry(1, true), Map.entry(6, true), Map.entry(22, true), Map.entry(12, true), Map.entry(35, true), Map.entry(13, true), Map.entry(2, true), Map.entry(25, true), Map.entry(36, true), Map.entry(32, true), Map.entry(9, true), Map.entry(5, true), Map.entry(8, true), Map.entry(31, true), Map.entry(30, true), Map.entry(7, true), Map.entry(40, true), Map.entry(4, true), Map.entry(44, true), Map.entry(21, true), Map.entry(39, true), Map.entry(16, true), Map.entry(42, true), Map.entry(20, true), Map.entry(43, true), Map.entry(15, true), Map.entry(38, true), Map.entry(10, true), Map.entry(33, true));
        GetMapAreaRspOuterClass.GetMapAreaRsp.Builder proto = GetMapAreaRspOuterClass.GetMapAreaRsp.newBuilder().setRetcode(0);
        data.entrySet().forEach(entry -> {
            proto.addMapAreaInfoList(MapAreaInfoOuterClass.MapAreaInfo.newBuilder().setMapAreaId(((Integer) entry.getKey()).intValue()).setIsOpen(((Boolean) entry.getValue()).booleanValue()).build());
        });
        setData(proto.build());
    }
}
