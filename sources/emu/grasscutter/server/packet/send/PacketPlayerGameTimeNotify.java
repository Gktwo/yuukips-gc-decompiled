package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PlayerGameTimeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerGameTimeNotify.class */
public class PacketPlayerGameTimeNotify extends BasePacket {
    public PacketPlayerGameTimeNotify(Player player) {
        super(124);
        setData(PlayerGameTimeNotifyOuterClass.PlayerGameTimeNotify.newBuilder().setGameTime(player.getScene().getTime()).setUid(player.getUid()).build());
    }
}
