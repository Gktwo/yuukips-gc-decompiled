package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarChangeCostumeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarChangeCostumeNotify.class */
public class PacketAvatarChangeCostumeNotify extends BasePacket {
    public PacketAvatarChangeCostumeNotify(EntityAvatar entity) {
        super(PacketOpcodes.AvatarChangeCostumeNotify);
        setData(AvatarChangeCostumeNotifyOuterClass.AvatarChangeCostumeNotify.newBuilder().setEntityInfo(entity.toProto()).build());
    }
}
