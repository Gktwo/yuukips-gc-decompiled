package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeChangeBgmRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketChangeHomeBgmRsp.class */
public class PacketChangeHomeBgmRsp extends BasePacket {
    public PacketChangeHomeBgmRsp() {
        super(PacketOpcodes.HomeChangeBgmRsp);
        setData(HomeChangeBgmRspOuterClass.HomeChangeBgmRsp.newBuilder().setRetcode(0).build());
    }
}
