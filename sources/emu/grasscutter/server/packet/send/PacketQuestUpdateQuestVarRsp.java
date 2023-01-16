package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.proto.QuestUpdateQuestVarRspOuterClass;

@Opcodes(476)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketQuestUpdateQuestVarRsp.class */
public class PacketQuestUpdateQuestVarRsp extends BasePacket {
    public PacketQuestUpdateQuestVarRsp(int questId) {
        super(416);
        setData(QuestUpdateQuestVarRspOuterClass.QuestUpdateQuestVarRsp.newBuilder().setQuestId(questId).build());
    }
}
