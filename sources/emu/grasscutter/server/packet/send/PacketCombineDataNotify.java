package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.CombineDataNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCombineDataNotify.class */
public class PacketCombineDataNotify extends BasePacket {
    public PacketCombineDataNotify(Iterable<Integer> unlockedCombines) {
        super(665);
        setData(CombineDataNotifyOuterClass.CombineDataNotify.newBuilder().addAllCombineIdList(unlockedCombines).build());
    }
}
