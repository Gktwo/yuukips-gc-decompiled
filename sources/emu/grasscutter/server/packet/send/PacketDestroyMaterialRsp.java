package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DestroyMaterialRspOuterClass;
import p014it.unimi.dsi.fastutil.ints.Int2IntMap;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDestroyMaterialRsp.class */
public class PacketDestroyMaterialRsp extends BasePacket {
    public PacketDestroyMaterialRsp(Int2IntMap returnMaterialMap) {
        super(608);
        DestroyMaterialRspOuterClass.DestroyMaterialRsp.Builder proto = DestroyMaterialRspOuterClass.DestroyMaterialRsp.newBuilder();
        returnMaterialMap.forEach(id, count -> {
            proto.addItemIdList(id.intValue());
            proto.addItemCountList(count.intValue());
        });
        setData(proto);
    }
}
