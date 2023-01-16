package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.FireWorkDataOuterClass;
import emu.grasscutter.net.proto.FireWorkNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketFireworkNotify.class */
public class PacketFireworkNotify extends BasePacket {
    public PacketFireworkNotify(FireWorkDataOuterClass.FireWorkData pinfo) {
        super(PacketOpcodes.FireworkNotify);
        FireWorkNotifyOuterClass.FireWorkNotify.Builder proto = FireWorkNotifyOuterClass.FireWorkNotify.newBuilder();
        proto.addFireWorkData(pinfo);
        setData(proto.build());
    }
}
