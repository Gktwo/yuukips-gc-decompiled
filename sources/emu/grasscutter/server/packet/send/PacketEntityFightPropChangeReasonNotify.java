package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ChangeEnergyReasonOuterClass;
import emu.grasscutter.net.proto.ChangeHpReasonOuterClass;
import emu.grasscutter.net.proto.EntityFightPropChangeReasonNotifyOuterClass;
import emu.grasscutter.net.proto.PropChangeReasonOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketEntityFightPropChangeReasonNotify.class */
public class PacketEntityFightPropChangeReasonNotify extends BasePacket {
    public PacketEntityFightPropChangeReasonNotify(GameEntity entity, FightProperty prop, Float value, List<Integer> param, PropChangeReasonOuterClass.PropChangeReason reason, ChangeHpReasonOuterClass.ChangeHpReason changeHpReason) {
        super(1280);
        EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotify.Builder proto = EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotify.newBuilder().setEntityId(entity.getId()).setPropType(prop.getId()).setPropDelta(value.floatValue()).setReason(reason).setChangeHpReason(changeHpReason);
        for (Integer num : param) {
            proto.addParamList(num.intValue());
        }
        setData(proto);
    }

    public PacketEntityFightPropChangeReasonNotify(GameEntity entity, FightProperty prop, Float value, PropChangeReasonOuterClass.PropChangeReason reason, ChangeHpReasonOuterClass.ChangeHpReason changeHpReason) {
        super(1280);
        setData(EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotify.newBuilder().setEntityId(entity.getId()).setPropType(prop.getId()).setPropDelta(value.floatValue()).setReason(reason).setChangeHpReason(changeHpReason).build());
    }

    public PacketEntityFightPropChangeReasonNotify(GameEntity entity, FightProperty prop, Float value, PropChangeReasonOuterClass.PropChangeReason reason) {
        super(1280);
        setData(EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotify.newBuilder().setEntityId(entity.getId()).setPropType(prop.getId()).setPropDelta(value.floatValue()).setReason(reason).build());
    }

    public PacketEntityFightPropChangeReasonNotify(GameEntity entity, FightProperty prop, Float value, ChangeEnergyReasonOuterClass.ChangeEnergyReason reason) {
        super(1280);
        setData(EntityFightPropChangeReasonNotifyOuterClass.EntityFightPropChangeReasonNotify.newBuilder().setEntityId(entity.getId()).setPropType(prop.getId()).setPropDelta(value.floatValue()).setChangeEnergyReason(reason).build());
    }
}
