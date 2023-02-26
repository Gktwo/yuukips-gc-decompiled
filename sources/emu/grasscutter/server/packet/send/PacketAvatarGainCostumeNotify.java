package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarGainCostumeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarGainCostumeNotify.class */
public class PacketAvatarGainCostumeNotify extends BasePacket {
    public PacketAvatarGainCostumeNotify(int costumeId) {
        super(PacketOpcodes.AvatarGainCostumeNotify);
        setData(AvatarGainCostumeNotifyOuterClass.AvatarGainCostumeNotify.newBuilder().setCostumeId(costumeId).build());
    }
}
