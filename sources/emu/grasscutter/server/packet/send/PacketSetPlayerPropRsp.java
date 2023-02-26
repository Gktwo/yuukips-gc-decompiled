package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.SetPlayerPropRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSetPlayerPropRsp.class */
public class PacketSetPlayerPropRsp extends BasePacket {
    public PacketSetPlayerPropRsp(int retCode) {
        super(113);
        SetPlayerPropRspOuterClass.SetPlayerPropRsp.Builder proto = SetPlayerPropRspOuterClass.SetPlayerPropRsp.newBuilder();
        if (retCode != 0) {
            proto.setRetcode(retCode);
        }
        setData(proto.build());
    }
}
