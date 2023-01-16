package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ForgeStartRspOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketForgeStartRsp.class */
public class PacketForgeStartRsp extends BasePacket {
    public PacketForgeStartRsp(RetcodeOuterClass.Retcode retcode) {
        super(621);
        setData(ForgeStartRspOuterClass.ForgeStartRsp.newBuilder().setRetcode(retcode.getNumber()).build());
    }
}
