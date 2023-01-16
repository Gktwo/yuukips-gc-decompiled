package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.World;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWorldPlayerLocationNotify.class */
public class PacketWorldPlayerLocationNotify extends BasePacket {
    public PacketWorldPlayerLocationNotify(World world) {
        super(PacketOpcodes.WorldPlayerLocationNotify);
        WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotify.Builder proto = WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotify.newBuilder();
        if (world != null) {
            for (Player p : world.getPlayers()) {
                proto.addPlayerWorldLocList(p.getWorldPlayerLocationInfo());
            }
        }
        setData(proto);
    }
}
