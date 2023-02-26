package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ResinChangeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketResinChangeNotify.class */
public class PacketResinChangeNotify extends BasePacket {
    public PacketResinChangeNotify(Player player) {
        super(694);
        setData(ResinChangeNotifyOuterClass.ResinChangeNotify.newBuilder().setCurValue(player.getProperty(PlayerProperty.PROP_PLAYER_RESIN)).setNextAddTimestamp(player.getNextResinRefresh()).build());
    }
}
