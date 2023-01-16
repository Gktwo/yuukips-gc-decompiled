package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.props.LifeState;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass;
import emu.grasscutter.net.proto.PlayerDieTypeOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarLifeStateChangeNotify.class */
public class PacketAvatarLifeStateChangeNotify extends BasePacket {
    public PacketAvatarLifeStateChangeNotify(Avatar avatar) {
        super(1247);
        int i;
        AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotify.Builder avatarGuid = AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotify.newBuilder().setAvatarGuid(avatar.getGuid());
        if (avatar.getFightProperty(FightProperty.FIGHT_PROP_CUR_HP) > 0.0f) {
            i = LifeState.LIFE_ALIVE.getValue();
        } else {
            i = LifeState.LIFE_DEAD.getValue();
        }
        setData(avatarGuid.setLifeState(i).build());
    }

    public PacketAvatarLifeStateChangeNotify(Avatar avatar, int attackerId, LifeState lifeState) {
        super(1247);
        setData(AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotify.newBuilder().setAvatarGuid(avatar.getGuid()).setLifeState(lifeState.getValue()).setMoveReliableSeq(attackerId).build());
    }

    public PacketAvatarLifeStateChangeNotify(Avatar avatar, LifeState lifeState, PlayerDieTypeOuterClass.PlayerDieType dieType) {
        this(avatar, lifeState, null, "", dieType);
    }

    public PacketAvatarLifeStateChangeNotify(Avatar avatar, LifeState lifeState, GameEntity sourceEntity, String attackTag, PlayerDieTypeOuterClass.PlayerDieType dieType) {
        super(1247);
        AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotify.Builder proto = AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotify.newBuilder();
        proto.setAvatarGuid(avatar.getGuid());
        proto.setLifeState(lifeState.getValue());
        if (sourceEntity != null) {
            proto.setSourceEntityId(sourceEntity.getId());
        }
        proto.setDieType(dieType);
        proto.setAttackTag(attackTag);
        setData(proto.build());
    }
}
