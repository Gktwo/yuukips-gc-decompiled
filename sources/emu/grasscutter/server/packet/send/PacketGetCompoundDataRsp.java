package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.CompoundQueueDataOuterClass;
import emu.grasscutter.net.proto.GetCompoundDataRspOuterClass;
import java.util.List;
import java.util.Set;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetCompoundDataRsp.class */
public class PacketGetCompoundDataRsp extends BasePacket {
    public PacketGetCompoundDataRsp(Set<Integer> unlockedCompounds, List<CompoundQueueDataOuterClass.CompoundQueueData> compoundQueueData) {
        super(115);
        setData(GetCompoundDataRspOuterClass.GetCompoundDataRsp.newBuilder().addAllUnlockCompoundList(unlockedCompounds).addAllCompoundQueueDataList(compoundQueueData).setRetcode(0).build());
    }
}
