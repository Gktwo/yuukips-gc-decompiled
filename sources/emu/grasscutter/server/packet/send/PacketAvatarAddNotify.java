package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AvatarAddNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarAddNotify.class */
public class PacketAvatarAddNotify extends BasePacket {
    public PacketAvatarAddNotify(Avatar avatar, boolean addedToTeam) {
        super(1757);
        setData(AvatarAddNotifyOuterClass.AvatarAddNotify.newBuilder().setAvatar(avatar.toProto()).setIsInTeam(addedToTeam).build());
    }
}
