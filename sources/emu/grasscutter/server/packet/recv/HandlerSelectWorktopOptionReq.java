package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.SelectWorktopOptionReqOuterClass;
import emu.grasscutter.scripts.data.ScriptArgs;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketSelectWorktopOptionRsp;

@Opcodes(900)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSelectWorktopOptionReq.class */
public class HandlerSelectWorktopOptionReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SelectWorktopOptionReqOuterClass.SelectWorktopOptionReq req = SelectWorktopOptionReqOuterClass.SelectWorktopOptionReq.parseFrom(payload);
        try {
            GameEntity entity = session.getPlayer().getScene().getEntityById(req.getGadgetEntityId());
            if (entity instanceof EntityGadget) {
                session.getPlayer().getScene().selectWorktopOptionWith(req);
                session.getPlayer().getScene().getScriptManager().callEvent(new ScriptArgs(9, entity.getConfigId(), req.getOptionId()));
                session.getPlayer().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_WORKTOP_SELECT, entity.getConfigId(), req.getOptionId());
                session.send(new PacketSelectWorktopOptionRsp(req.getGadgetEntityId(), req.getOptionId()));
            }
        } finally {
            session.send(new PacketSelectWorktopOptionRsp(req.getGadgetEntityId(), req.getOptionId()));
        }
    }
}
