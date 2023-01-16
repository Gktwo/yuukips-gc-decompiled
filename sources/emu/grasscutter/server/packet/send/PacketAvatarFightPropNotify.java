package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarFightPropNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarFightPropNotify.class */
public class PacketAvatarFightPropNotify extends BasePacket {
    public PacketAvatarFightPropNotify(Avatar avatar) {
        super(PacketOpcodes.AvatarFightPropNotify);
        setData(AvatarFightPropNotifyOuterClass.AvatarFightPropNotify.newBuilder().setAvatarGuid(avatar.getGuid()).putAllFightPropMap(avatar.getFightProperties()).build());
    }
}
