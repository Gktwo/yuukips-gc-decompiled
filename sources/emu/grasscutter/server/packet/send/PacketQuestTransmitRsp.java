package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QuestTransmitReqOuterClass;
import emu.grasscutter.net.proto.QuestTransmitRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketQuestTransmitRsp.class */
public class PacketQuestTransmitRsp extends BasePacket {
    public PacketQuestTransmitRsp(boolean result, QuestTransmitReqOuterClass.QuestTransmitReq req) {
        super(PacketOpcodes.QuestTransmitRsp);
        setData(QuestTransmitRspOuterClass.QuestTransmitRsp.newBuilder().setQuestId(req.getQuestId()).setPointId(req.getPointId()).setRetcode(result ? 0 : -1));
    }
}
