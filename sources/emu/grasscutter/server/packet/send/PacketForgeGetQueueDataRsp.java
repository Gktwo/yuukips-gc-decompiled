package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass;
import emu.grasscutter.net.proto.ForgeQueueDataOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketForgeGetQueueDataRsp.class */
public class PacketForgeGetQueueDataRsp extends BasePacket {
    public PacketForgeGetQueueDataRsp(RetcodeOuterClass.Retcode retcode, int numQueues, Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> queueData) {
        super(667);
        ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRsp.Builder builder = ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRsp.newBuilder().setRetcode(retcode.getNumber()).setMaxQueueNum(numQueues);
        for (Integer num : queueData.keySet()) {
            int queueId = num.intValue();
            builder.putForgeQueueMap(queueId, queueData.get(Integer.valueOf(queueId)));
        }
        setData(builder.build());
    }
}
