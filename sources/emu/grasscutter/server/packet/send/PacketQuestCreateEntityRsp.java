package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass;
import emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketQuestCreateEntityRsp.class */
public class PacketQuestCreateEntityRsp extends BasePacket {
    public PacketQuestCreateEntityRsp(int entityId, QuestCreateEntityReqOuterClass.QuestCreateEntityReq req) {
        super(424);
        setData(QuestCreateEntityRspOuterClass.QuestCreateEntityRsp.newBuilder().setQuestId(req.getQuestId()).setEntity(req.getEntity()).setParentQuestId(req.getParentQuestId()).setIsRewind(req.getIsRewind()).setEntityId(entityId).setRetcode(entityId != -1 ? 0 : -1));
    }
}
