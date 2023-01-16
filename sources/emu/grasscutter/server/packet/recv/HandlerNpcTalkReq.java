package emu.grasscutter.server.packet.recv;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.MainQuestData;
import emu.grasscutter.game.quest.GameMainQuest;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.NpcTalkReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketNpcTalkRsp;
import java.util.List;

@Opcodes(PacketOpcodes.NpcTalkReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerNpcTalkReq.class */
public class HandlerNpcTalkReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        NpcTalkReqOuterClass.NpcTalkReq req = NpcTalkReqOuterClass.NpcTalkReq.parseFrom(payload);
        int talkId = req.getTalkId();
        Grasscutter.getLogger().warn("NpcTalkReq {}", Integer.valueOf(talkId));
        int mainQuestId = talkId / 100;
        MainQuestData mainQuestData = GameData.getMainQuestDataMap().get(mainQuestId);
        if (mainQuestData != null) {
            MainQuestData.TalkData talkForQuest = new MainQuestData.TalkData(talkId, "");
            if (mainQuestData.getTalks() != null) {
                List<MainQuestData.TalkData> talks = mainQuestData.getTalks().stream().filter(p -> {
                    return p.getId() == talkId;
                }).toList();
                if (talks.size() > 0) {
                    talkForQuest = talks.get(0);
                }
            }
            GameMainQuest mainQuest = session.getPlayer().getQuestManager().getMainQuestById(mainQuestId);
            if (!(mainQuest == null || mainQuest.getTalks() == null)) {
                mainQuest.getTalks().put(Integer.valueOf(talkId), talkForQuest);
            }
            session.getPlayer().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_COMPLETE_ANY_TALK, String.valueOf(req.getTalkId()), 0, 0);
            session.getPlayer().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_COMPLETE_TALK, req.getTalkId(), 0);
            session.getPlayer().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_FINISH_PLOT, req.getTalkId(), 0);
        }
        session.send(new PacketNpcTalkRsp(req.getNpcEntityId(), req.getTalkId(), req.getEntityId()));
    }
}
