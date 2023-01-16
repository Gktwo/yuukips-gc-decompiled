package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AvatarGainCostumeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarGainCostumeNotify.class */
public class PacketAvatarGainCostumeNotify extends BasePacket {
    public PacketAvatarGainCostumeNotify(int costumeId) {
        super(1625);
        setData(AvatarGainCostumeNotifyOuterClass.AvatarGainCostumeNotify.newBuilder().setCostumeId(costumeId).build());
    }
}
