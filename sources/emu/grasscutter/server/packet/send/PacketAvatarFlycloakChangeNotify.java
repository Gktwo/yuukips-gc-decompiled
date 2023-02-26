package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AvatarFlycloakChangeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarFlycloakChangeNotify.class */
public class PacketAvatarFlycloakChangeNotify extends BasePacket {
    public PacketAvatarFlycloakChangeNotify(Avatar avatar) {
        super(1626);
        setData(AvatarFlycloakChangeNotifyOuterClass.AvatarFlycloakChangeNotify.newBuilder().setAvatarGuid(avatar.getGuid()).setFlycloakId(avatar.getFlyCloak()).build());
    }
}
