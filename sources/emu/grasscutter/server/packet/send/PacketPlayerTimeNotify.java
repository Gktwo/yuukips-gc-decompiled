package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PlayerTimeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerTimeNotify.class */
public class PacketPlayerTimeNotify extends BasePacket {
    public PacketPlayerTimeNotify(Player player) {
        super(103);
        setData(PlayerTimeNotifyOuterClass.PlayerTimeNotify.newBuilder().setIsPaused(player.isPaused()).setPlayerTime((long) player.getClientTime()).setServerTime(System.currentTimeMillis()).build());
    }
}
