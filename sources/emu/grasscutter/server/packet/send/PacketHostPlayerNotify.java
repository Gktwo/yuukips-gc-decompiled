package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.world.World;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HostPlayerNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHostPlayerNotify.class */
public class PacketHostPlayerNotify extends BasePacket {
    public PacketHostPlayerNotify(World world) {
        super(PacketOpcodes.HostPlayerNotify);
        setData(HostPlayerNotifyOuterClass.HostPlayerNotify.newBuilder().setHostUid(world.getHost().getUid()).setHostPeerId(world.getHost().getPeerId()).build());
    }
}
