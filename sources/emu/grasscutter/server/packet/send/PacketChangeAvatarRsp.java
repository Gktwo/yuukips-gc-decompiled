package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChangeAvatarRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketChangeAvatarRsp.class */
public class PacketChangeAvatarRsp extends BasePacket {
    public PacketChangeAvatarRsp(long guid) {
        super(PacketOpcodes.ChangeAvatarRsp);
        setData(ChangeAvatarRspOuterClass.ChangeAvatarRsp.newBuilder().setRetcode(0).setCurGuid(guid).build());
    }
}
