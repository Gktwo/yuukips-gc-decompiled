package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PlayerPropChangeReasonNotifyOuterClass;
import emu.grasscutter.net.proto.PropChangeReasonOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerPropChangeReasonNotify.class */
public class PacketPlayerPropChangeReasonNotify extends BasePacket {
    public PacketPlayerPropChangeReasonNotify(Player player, PlayerProperty prop, int oldValue, int newValue, PropChangeReasonOuterClass.PropChangeReason changeReason) {
        super(1214);
        buildHeader(0);
        setData(PlayerPropChangeReasonNotifyOuterClass.PlayerPropChangeReasonNotify.newBuilder().setPropType(prop.getId()).setReason(changeReason).setOldValue((float) oldValue).setCurValue((float) newValue).build());
    }
}
