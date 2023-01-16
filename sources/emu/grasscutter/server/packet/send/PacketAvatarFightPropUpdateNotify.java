package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarFightPropUpdateNotify.class */
public class PacketAvatarFightPropUpdateNotify extends BasePacket {
    public PacketAvatarFightPropUpdateNotify(Avatar avatar, FightProperty prop) {
        super(1243);
        setData(AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotify.newBuilder().setAvatarGuid(avatar.getGuid()).putFightPropMap(prop.getId(), avatar.getFightProperty(prop)).build());
    }

    public PacketAvatarFightPropUpdateNotify(Avatar avatar, Map<Integer, Float> propUpdateList) {
        super(1243);
        setData(AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotify.newBuilder().setAvatarGuid(avatar.getGuid()).putAllFightPropMap(propUpdateList).build());
    }
}
