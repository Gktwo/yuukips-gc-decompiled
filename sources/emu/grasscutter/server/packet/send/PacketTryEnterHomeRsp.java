package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.TryEnterHomeRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketTryEnterHomeRsp.class */
public class PacketTryEnterHomeRsp extends BasePacket {
    public PacketTryEnterHomeRsp() {
        super(PacketOpcodes.TryEnterHomeRsp);
        setData(TryEnterHomeRspOuterClass.TryEnterHomeRsp.newBuilder().setRetcode(1).build());
    }

    public PacketTryEnterHomeRsp(int uid) {
        super(PacketOpcodes.TryEnterHomeRsp);
        setData(TryEnterHomeRspOuterClass.TryEnterHomeRsp.newBuilder().setRetcode(0).setTargetUid(uid).build());
    }

    public PacketTryEnterHomeRsp(int retCode, int uid) {
        super(PacketOpcodes.TryEnterHomeRsp);
        setData(TryEnterHomeRspOuterClass.TryEnterHomeRsp.newBuilder().setRetcode(retCode).setTargetUid(uid).build());
    }
}
