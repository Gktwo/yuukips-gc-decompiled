package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass;
import emu.grasscutter.net.proto.ForgeQueueDataOuterClass;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketForgeQueueDataNotify.class */
public class PacketForgeQueueDataNotify extends BasePacket {
    public PacketForgeQueueDataNotify(Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> queueData, List<Integer> removedQueues) {
        super(695);
        ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotify.Builder builder = ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotify.newBuilder().addAllRemovedForgeQueueList(removedQueues);
        for (Integer num : queueData.keySet()) {
            int queueId = num.intValue();
            builder.putForgeQueueMap(queueId, queueData.get(Integer.valueOf(queueId)));
        }
        setData(builder.build());
    }
}
