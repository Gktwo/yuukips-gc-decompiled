package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ForgeDataNotifyOuterClass;
import emu.grasscutter.net.proto.ForgeQueueDataOuterClass;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketForgeDataNotify.class */
public class PacketForgeDataNotify extends BasePacket {
    public PacketForgeDataNotify(Iterable<Integer> unlockedItem, int numQueues, Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> queueData) {
        super(604);
        ForgeDataNotifyOuterClass.ForgeDataNotify.Builder builder = ForgeDataNotifyOuterClass.ForgeDataNotify.newBuilder().addAllForgeIdList(unlockedItem).setMaxQueueNum(numQueues);
        for (Integer num : queueData.keySet()) {
            int queueId = num.intValue();
            builder.putForgeQueueMap(queueId, queueData.get(Integer.valueOf(queueId)));
        }
        setData(builder.build());
    }
}
