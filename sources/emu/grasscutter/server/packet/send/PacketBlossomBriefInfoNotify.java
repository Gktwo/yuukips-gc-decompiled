package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.BlossomBriefInfoNotifyOuterClass;
import emu.grasscutter.net.proto.BlossomBriefInfoOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketBlossomBriefInfoNotify.class */
public class PacketBlossomBriefInfoNotify extends BasePacket {
    public PacketBlossomBriefInfoNotify(Iterable<BlossomBriefInfoOuterClass.BlossomBriefInfo> blossoms) {
        super(PacketOpcodes.BlossomBriefInfoNotify);
        setData(BlossomBriefInfoNotifyOuterClass.BlossomBriefInfoNotify.newBuilder().addAllBriefInfoList(blossoms));
    }
}
