package emu.grasscutter.server.packet.recv;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AddQuestContentProgressReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketAddQuestContentProgressRsp;
import java.util.List;
import java.util.stream.Stream;

@Opcodes(PacketOpcodes.AddQuestContentProgressReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerAddQuestContentProgressReq.class */
public class HandlerAddQuestContentProgressReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        AddQuestContentProgressReqOuterClass.AddQuestContentProgressReq req = AddQuestContentProgressReqOuterClass.AddQuestContentProgressReq.parseFrom(payload);
        if (req == null) {
            Grasscutter.getLogger().error("Quest AddQuestContentProgressReq null");
            return;
        }
        QuestData getdata = GameData.getQuestDataMap().get(req.getParam());
        if (getdata == null) {
            Grasscutter.getLogger().error("Quest {} not found", Integer.valueOf(req.getParam()));
            return;
        }
        List<QuestData.QuestCondition> allCondMatch = Stream.concat(Stream.concat(getdata.getAcceptCond().stream(), getdata.getFailCond().stream()), getdata.getFinishCond().stream()).filter(p -> {
            return p.getType().getValue() == req.getContentType();
        }).toList();
        Grasscutter.getLogger().warn("total condition found {} -> {}", Integer.valueOf(allCondMatch.size()), Integer.valueOf(req.getParam()));
        for (QuestData.QuestCondition cond : allCondMatch) {
            session.getPlayer().getQuestManager().queueEvent(QuestTrigger.getContentTriggerByValue(req.getContentType()), cond.getParam());
        }
        session.send(new PacketAddQuestContentProgressRsp(req.getContentType()));
    }
}
