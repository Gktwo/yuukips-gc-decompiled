package emu.grasscutter.server.packet.recv;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.quest.QuestManager;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPostEnterSceneRsp;

@Opcodes(PacketOpcodes.PostEnterSceneReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPostEnterSceneReq.class */
public class HandlerPostEnterSceneReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        int sceneId = session.getPlayer().getSceneId();
        QuestManager questManager = session.getPlayer().getQuestManager();
        switch (session.getPlayer().getScene().getSceneType()) {
            case SCENE_ROOM:
                questManager.queueEvent(QuestTrigger.QUEST_CONTENT_ENTER_ROOM, sceneId, 0);
                break;
            case SCENE_WORLD:
                questManager.queueEvent(QuestTrigger.QUEST_CONTENT_ENTER_MY_WORLD, sceneId);
                questManager.queueEvent(QuestTrigger.QUEST_CONTENT_ENTER_MY_WORLD_SCENE, sceneId);
                break;
            default:
                Grasscutter.getLogger().debug("PostEnterSceneReq UK: {}", session.getPlayer().getScene().getSceneType().toString());
                break;
        }
        session.send(new PacketPostEnterSceneRsp(session.getPlayer()));
    }
}
