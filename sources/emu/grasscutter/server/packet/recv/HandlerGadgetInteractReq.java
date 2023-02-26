package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.GadgetInteractReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(805)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGadgetInteractReq.class */
public class HandlerGadgetInteractReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        GadgetInteractReqOuterClass.GadgetInteractReq req = GadgetInteractReqOuterClass.GadgetInteractReq.parseFrom(payload);
        session.getPlayer().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_INTERACT_GADGET, req.getGadgetId());
        session.getPlayer().interactWith(req.getGadgetEntityId(), req);
    }
}
