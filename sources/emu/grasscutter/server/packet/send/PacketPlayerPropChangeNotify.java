package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PlayerPropChangeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerPropChangeNotify.class */
public class PacketPlayerPropChangeNotify extends BasePacket {
    public PacketPlayerPropChangeNotify(Player player, PlayerProperty prop, int delta) {
        super(146);
        buildHeader(0);
        setData(PlayerPropChangeNotifyOuterClass.PlayerPropChangeNotify.newBuilder().setPropType(prop.getId()).setPropDelta(delta).build());
    }
}
