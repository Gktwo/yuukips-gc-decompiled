package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.quest.GameMainQuest;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass;
import emu.grasscutter.net.proto.QuestVarOpOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketQuestUpdateQuestVarRsp;
import java.util.List;

@Opcodes(PacketOpcodes.QuestUpdateQuestVarReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerQuestUpdateQuestVarReq.class */
public class HandlerQuestUpdateQuestVarReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReq req = QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReq.parseFrom(payload);
        GameMainQuest mainQuest = session.getPlayer().getQuestManager().getMainQuestById(req.getQuestId() / 100);
        if (mainQuest != null) {
            List<Integer> update = mainQuest.getQuestVarsUpdate();
            if (update != null) {
                List<QuestVarOpOuterClass.QuestVarOp> questVars = req.getQuestVarOpListList();
                if (update.size() == 0) {
                    for (QuestVarOpOuterClass.QuestVarOp questVar : questVars) {
                        update.add(Integer.valueOf(questVar.getValue()));
                    }
                } else {
                    for (QuestVarOpOuterClass.QuestVarOp questVar2 : questVars) {
                        if (!questVar2.getIsAdd()) {
                            mainQuest.setQuestVar(questVar2.getIndex(), update.get(0).intValue());
                        } else if (questVar2.getValue() >= 0) {
                            mainQuest.incQuestVar(questVar2.getIndex(), questVar2.getValue());
                        } else {
                            mainQuest.decQuestVar(questVar2.getIndex(), questVar2.getValue());
                        }
                        update.remove(0);
                    }
                }
            }
            session.send(new PacketQuestUpdateQuestVarRsp(req.getQuestId()));
        }
    }
}
