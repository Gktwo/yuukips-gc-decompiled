package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.World;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PlayerRTTInfoOuterClass;
import emu.grasscutter.net.proto.WorldPlayerRTTNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWorldPlayerRTTNotify.class */
public class PacketWorldPlayerRTTNotify extends BasePacket {
    public PacketWorldPlayerRTTNotify(World world) {
        super(37);
        WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotify.Builder proto = WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotify.newBuilder();
        for (Player player : world.getPlayers()) {
            proto.addPlayerRttList(PlayerRTTInfoOuterClass.PlayerRTTInfo.newBuilder().setUid(player.getUid()).setRtt(10));
        }
        setData(proto);
    }
}
