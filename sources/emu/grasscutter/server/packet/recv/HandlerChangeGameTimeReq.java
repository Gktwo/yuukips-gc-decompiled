package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.ChangeGameTimeReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketChangeGameTimeRsp;

@Opcodes(162)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerChangeGameTimeReq.class */
public class HandlerChangeGameTimeReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        ChangeGameTimeReqOuterClass.ChangeGameTimeReq req = ChangeGameTimeReqOuterClass.ChangeGameTimeReq.parseFrom(payload);
        session.getPlayer().getScene().changeTime(req.getGameTime());
        session.getPlayer().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_GAME_TIME_TICK, req.getGameTime() / 60, req.getExtraDays());
        session.getPlayer().sendPacket(new PacketChangeGameTimeRsp(session.getPlayer()));
    }
}
