package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarChangeCostumeRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarChangeCostumeRsp.class */
public class PacketAvatarChangeCostumeRsp extends BasePacket {
    public PacketAvatarChangeCostumeRsp(long avatarGuid, int costumeId) {
        super(PacketOpcodes.AvatarChangeCostumeRsp);
        setData(AvatarChangeCostumeRspOuterClass.AvatarChangeCostumeRsp.newBuilder().setAvatarGuid(avatarGuid).setCostumeId(costumeId).build());
    }

    public PacketAvatarChangeCostumeRsp() {
        super(PacketOpcodes.AvatarChangeCostumeRsp);
        setData(AvatarChangeCostumeRspOuterClass.AvatarChangeCostumeRsp.newBuilder().setRetcode(1).build());
    }
}
