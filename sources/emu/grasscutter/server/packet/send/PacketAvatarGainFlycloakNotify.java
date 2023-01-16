package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarGainFlycloakNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarGainFlycloakNotify.class */
public class PacketAvatarGainFlycloakNotify extends BasePacket {
    public PacketAvatarGainFlycloakNotify(int flycloak) {
        super(PacketOpcodes.AvatarGainFlycloakNotify);
        setData(AvatarGainFlycloakNotifyOuterClass.AvatarGainFlycloakNotify.newBuilder().setFlycloakId(flycloak).build());
    }
}
