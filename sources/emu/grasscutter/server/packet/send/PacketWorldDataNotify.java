package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.world.World;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PropValueOuterClass;
import emu.grasscutter.net.proto.WorldDataNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWorldDataNotify.class */
public class PacketWorldDataNotify extends BasePacket {
    public PacketWorldDataNotify(World world) {
        super(PacketOpcodes.WorldDataNotify);
        int worldLevel = world.getWorldLevel();
        int isMp = world.isMultiplayer() ? 1 : 0;
        setData(WorldDataNotifyOuterClass.WorldDataNotify.newBuilder().putWorldPropMap(1, PropValueOuterClass.PropValue.newBuilder().setType(1).setIval((long) worldLevel).setVal((long) worldLevel).build()).putWorldPropMap(2, PropValueOuterClass.PropValue.newBuilder().setType(2).setIval((long) isMp).setVal((long) isMp).build()).build());
    }
}
