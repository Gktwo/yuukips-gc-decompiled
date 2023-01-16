package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ReliquaryDecomposeRspOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketReliquaryDecomposeRsp.class */
public class PacketReliquaryDecomposeRsp extends BasePacket {
    public PacketReliquaryDecomposeRsp(RetcodeOuterClass.Retcode retcode) {
        super(601);
        setData(ReliquaryDecomposeRspOuterClass.ReliquaryDecomposeRsp.newBuilder().setRetcode(retcode.getNumber()).build());
    }

    public PacketReliquaryDecomposeRsp(List<Long> output) {
        super(601);
        setData(ReliquaryDecomposeRspOuterClass.ReliquaryDecomposeRsp.newBuilder().addAllGuidList(output).build());
    }
}
