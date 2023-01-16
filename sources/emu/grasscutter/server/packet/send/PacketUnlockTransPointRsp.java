package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.net.proto.UnlockTransPointRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketUnlockTransPointRsp.class */
public class PacketUnlockTransPointRsp extends BasePacket {
    public PacketUnlockTransPointRsp(RetcodeOuterClass.Retcode retcode) {
        super(PacketOpcodes.UnlockTransPointRsp);
        setData(UnlockTransPointRspOuterClass.UnlockTransPointRsp.newBuilder().setRetcode(retcode.getNumber()).build());
    }
}
