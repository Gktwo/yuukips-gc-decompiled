package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.props.LifeState;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass;
import emu.grasscutter.net.proto.PlayerDieTypeOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketLifeStateChangeNotify.class */
public class PacketLifeStateChangeNotify extends BasePacket {
    public PacketLifeStateChangeNotify(GameEntity target, LifeState lifeState) {
        super(1230);
        setData(LifeStateChangeNotifyOuterClass.LifeStateChangeNotify.newBuilder().setEntityId(target.getId()).setLifeState(lifeState.getValue()).build());
    }

    public PacketLifeStateChangeNotify(GameEntity attacker, GameEntity target, LifeState lifeState) {
        super(1230);
        setData(LifeStateChangeNotifyOuterClass.LifeStateChangeNotify.newBuilder().setEntityId(target.getId()).setLifeState(lifeState.getValue()).setSourceEntityId(attacker.getId()).build());
    }

    public PacketLifeStateChangeNotify(int attackerId, GameEntity target, LifeState lifeState) {
        super(1230);
        setData(LifeStateChangeNotifyOuterClass.LifeStateChangeNotify.newBuilder().setEntityId(target.getId()).setLifeState(lifeState.getValue()).setSourceEntityId(attackerId).build());
    }

    public PacketLifeStateChangeNotify(GameEntity entity, LifeState lifeState, PlayerDieTypeOuterClass.PlayerDieType dieType) {
        this(entity, lifeState, null, "", dieType);
    }

    public PacketLifeStateChangeNotify(GameEntity entity, LifeState lifeState, GameEntity sourceEntity, String attackTag, PlayerDieTypeOuterClass.PlayerDieType dieType) {
        super(1230);
        LifeStateChangeNotifyOuterClass.LifeStateChangeNotify.Builder proto = LifeStateChangeNotifyOuterClass.LifeStateChangeNotify.newBuilder();
        proto.setEntityId(entity.getId());
        proto.setLifeState(lifeState.getValue());
        if (sourceEntity != null) {
            proto.setSourceEntityId(sourceEntity.getId());
        }
        proto.setAttackTag(attackTag);
        proto.setDieType(dieType);
        setData(proto.build());
    }
}
