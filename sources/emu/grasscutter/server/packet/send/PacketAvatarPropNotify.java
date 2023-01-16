package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AvatarPropNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarPropNotify.class */
public class PacketAvatarPropNotify extends BasePacket {
    public PacketAvatarPropNotify(Avatar avatar) {
        super(1227);
        setData(AvatarPropNotifyOuterClass.AvatarPropNotify.newBuilder().setAvatarGuid(avatar.getGuid()).putPropMap(PlayerProperty.PROP_LEVEL.getId(), (long) avatar.getLevel()).putPropMap(PlayerProperty.PROP_EXP.getId(), (long) avatar.getExp()).putPropMap(PlayerProperty.PROP_BREAK_LEVEL.getId(), (long) avatar.getPromoteLevel()).putPropMap(PlayerProperty.PROP_SATIATION_VAL.getId(), 0).putPropMap(PlayerProperty.PROP_SATIATION_PENALTY_TIME.getId(), 0).build());
    }

    public PacketAvatarPropNotify(Avatar avatar, PlayerProperty prop, int value) {
        super(1227);
        setData(AvatarPropNotifyOuterClass.AvatarPropNotify.newBuilder().setAvatarGuid(avatar.getGuid()).putPropMap(prop.getId(), (long) value).build());
    }
}
