package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AvatarPropNotifyOuterClass;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarPropNotify.class */
public class PacketAvatarPropNotify extends BasePacket {
    public PacketAvatarPropNotify(Avatar avatar) {
        super(1224);
        setData(AvatarPropNotifyOuterClass.AvatarPropNotify.newBuilder().setAvatarGuid(avatar.getGuid()).putPropMap(PlayerProperty.PROP_LEVEL.getId(), (long) avatar.getLevel()).putPropMap(PlayerProperty.PROP_EXP.getId(), (long) avatar.getExp()).putPropMap(PlayerProperty.PROP_BREAK_LEVEL.getId(), (long) avatar.getPromoteLevel()).putPropMap(PlayerProperty.PROP_SATIATION_VAL.getId(), (long) avatar.getSatiation()).putPropMap(PlayerProperty.PROP_SATIATION_PENALTY_TIME.getId(), (long) avatar.getSatiationPenalty()).build());
    }

    public PacketAvatarPropNotify(Avatar avatar, PlayerProperty prop, int value) {
        super(1224);
        setData(AvatarPropNotifyOuterClass.AvatarPropNotify.newBuilder().setAvatarGuid(avatar.getGuid()).putPropMap(prop.getId(), (long) value).build());
    }

    public PacketAvatarPropNotify(Avatar avatar, Map<Integer, Long> propMap) {
        super(1224);
        setData(AvatarPropNotifyOuterClass.AvatarPropNotify.newBuilder().setAvatarGuid(avatar.getGuid()).putAllPropMap(propMap).build());
    }
}
