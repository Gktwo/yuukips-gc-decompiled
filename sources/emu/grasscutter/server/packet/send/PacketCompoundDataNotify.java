package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.CompoundDataNotifyOuterClass;
import emu.grasscutter.net.proto.CompoundQueueDataOuterClass;
import java.util.List;
import java.util.Set;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCompoundDataNotify.class */
public class PacketCompoundDataNotify extends BasePacket {
    public PacketCompoundDataNotify(Set<Integer> unlockedCompounds, List<CompoundQueueDataOuterClass.CompoundQueueData> compoundQueueData) {
        super(164);
        setData(CompoundDataNotifyOuterClass.CompoundDataNotify.newBuilder().addAllUnlockCompoundList(unlockedCompounds).addAllCompoundQueueDataList(compoundQueueData).build());
    }
}
