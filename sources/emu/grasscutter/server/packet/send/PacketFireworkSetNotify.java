package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.FireworkSetDataOuterClass;
import emu.grasscutter.net.proto.FireworkSetNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketFireworkSetNotify.class */
public class PacketFireworkSetNotify extends BasePacket {
    public PacketFireworkSetNotify(FireworkSetDataOuterClass.FireworkSetData notify) {
        super(PacketOpcodes.FireworkSetNotify);
        FireworkSetNotifyOuterClass.FireworkSetNotify.Builder proto = FireworkSetNotifyOuterClass.FireworkSetNotify.newBuilder();
        proto.setCode(1).addData(notify);
        setData(proto.build());
    }
}
