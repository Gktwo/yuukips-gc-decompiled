package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.EnterWorldAreaReqOuterClass;
import emu.grasscutter.net.proto.EnterWorldAreaRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketEnterWorldAreaRsp.class */
public class PacketEnterWorldAreaRsp extends BasePacket {
    public PacketEnterWorldAreaRsp(int clientSequence, EnterWorldAreaReqOuterClass.EnterWorldAreaReq enterWorld) {
        super(250, clientSequence);
        setData(EnterWorldAreaRspOuterClass.EnterWorldAreaRsp.newBuilder().setAreaType(enterWorld.getAreaType()).setAreaId(enterWorld.getAreaId()).build().toByteArray());
    }
}
