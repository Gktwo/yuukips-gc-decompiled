package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QuestDestroyEntityReqOuterClass;
import emu.grasscutter.net.proto.QuestDestroyEntityRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketQuestDestroyEntityRsp.class */
public class PacketQuestDestroyEntityRsp extends BasePacket {
    public PacketQuestDestroyEntityRsp(boolean success, QuestDestroyEntityReqOuterClass.QuestDestroyEntityReq req) {
        super(PacketOpcodes.QuestDestroyEntityRsp);
        setData(QuestDestroyEntityRspOuterClass.QuestDestroyEntityRsp.newBuilder().setQuestId(req.getQuestId()).setEntityId(req.getEntityId()).setSceneId(req.getSceneId()).setRetcode(success ? 0 : -1));
    }
}
