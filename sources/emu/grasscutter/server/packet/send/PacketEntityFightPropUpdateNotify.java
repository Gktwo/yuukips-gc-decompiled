package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.EntityFightPropUpdateNotifyOuterClass;
import java.util.Collection;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketEntityFightPropUpdateNotify.class */
public class PacketEntityFightPropUpdateNotify extends BasePacket {
    public PacketEntityFightPropUpdateNotify(GameEntity entity, FightProperty prop) {
        super(1219);
        setData(EntityFightPropUpdateNotifyOuterClass.EntityFightPropUpdateNotify.newBuilder().setEntityId(entity.getId()).putFightPropMap(prop.getId(), entity.getFightProperty(prop)).build());
    }

    public PacketEntityFightPropUpdateNotify(GameEntity entity, Collection<FightProperty> props) {
        super(1219);
        EntityFightPropUpdateNotifyOuterClass.EntityFightPropUpdateNotify.Builder protoBuilder = EntityFightPropUpdateNotifyOuterClass.EntityFightPropUpdateNotify.newBuilder().setEntityId(entity.getId());
        props.forEach(p -> {
            protoBuilder.putFightPropMap(p.getId(), entity.getFightProperty(p));
        });
        setData(protoBuilder);
    }
}
