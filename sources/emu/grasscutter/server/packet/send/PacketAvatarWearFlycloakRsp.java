package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarWearFlycloakRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarWearFlycloakRsp.class */
public class PacketAvatarWearFlycloakRsp extends BasePacket {
    public PacketAvatarWearFlycloakRsp(long avatarGuid, int costumeId) {
        super(PacketOpcodes.AvatarWearFlycloakRsp);
        setData(AvatarWearFlycloakRspOuterClass.AvatarWearFlycloakRsp.newBuilder().setAvatarGuid(avatarGuid).setFlycloakId(costumeId).build());
    }

    public PacketAvatarWearFlycloakRsp() {
        super(PacketOpcodes.AvatarWearFlycloakRsp);
        setData(AvatarWearFlycloakRspOuterClass.AvatarWearFlycloakRsp.newBuilder().setRetcode(1).build());
    }
}
