package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.BackMyWorldRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketBackMyWorldRsp.class */
public class PacketBackMyWorldRsp extends BasePacket {
    public PacketBackMyWorldRsp() {
        super(PacketOpcodes.BackMyWorldRsp);
        setData(BackMyWorldRspOuterClass.BackMyWorldRsp.newBuilder().build());
    }
}
