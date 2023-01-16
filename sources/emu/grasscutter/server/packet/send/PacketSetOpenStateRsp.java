package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.net.proto.SetOpenStateRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSetOpenStateRsp.class */
public class PacketSetOpenStateRsp extends BasePacket {
    public PacketSetOpenStateRsp(int openState, int value) {
        super(144);
        setData(SetOpenStateRspOuterClass.SetOpenStateRsp.newBuilder().setKey(openState).setValue(value).build());
    }

    public PacketSetOpenStateRsp(RetcodeOuterClass.Retcode retcode) {
        super(144);
        setData(SetOpenStateRspOuterClass.SetOpenStateRsp.newBuilder().setRetcode(retcode.getNumber()).build());
    }
}
