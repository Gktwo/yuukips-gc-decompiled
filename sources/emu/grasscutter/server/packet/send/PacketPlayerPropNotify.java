package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PlayerPropNotifyOuterClass;
import emu.grasscutter.utils.ProtoHelper;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerPropNotify.class */
public class PacketPlayerPropNotify extends BasePacket {
    public PacketPlayerPropNotify(Player player, PlayerProperty prop) {
        super(129);
        buildHeader(0);
        setData(PlayerPropNotifyOuterClass.PlayerPropNotify.newBuilder().putPropMap(prop.getId(), ProtoHelper.newPropValue(prop, player.getProperty(prop))).build());
    }
}
