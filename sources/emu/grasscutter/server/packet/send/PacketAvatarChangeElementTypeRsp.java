package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarChangeElementTypeRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarChangeElementTypeRsp.class */
public class PacketAvatarChangeElementTypeRsp extends BasePacket {
    public PacketAvatarChangeElementTypeRsp() {
        super(PacketOpcodes.AvatarChangeElementTypeRsp);
    }

    public PacketAvatarChangeElementTypeRsp(int retcode) {
        super(PacketOpcodes.AvatarChangeElementTypeRsp);
        if (retcode > 0) {
            setData(AvatarChangeElementTypeRspOuterClass.AvatarChangeElementTypeRsp.newBuilder().setRetcode(retcode).build());
        }
    }
}
