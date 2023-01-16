package emu.grasscutter.server.packet.recv;

import emu.grasscutter.data.GameData;
import emu.grasscutter.game.quest.GameMainQuest;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.QuestTransmitReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketQuestTransmitRsp;
import emu.grasscutter.utils.Position;
import java.util.ArrayList;
import java.util.List;

@Opcodes(446)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerQuestTransmitReq.class */
public class HandlerQuestTransmitReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        QuestTransmitReqOuterClass.QuestTransmitReq req = QuestTransmitReqOuterClass.QuestTransmitReq.parseFrom(payload);
        GameMainQuest mainQuest = session.getPlayer().getQuestManager().getMainQuestById(req.getQuestId() / 100);
        List<Position> posAndRot = new ArrayList<>();
        boolean result = false;
        if (mainQuest.hasTeleportPostion(req.getQuestId(), posAndRot)) {
            result = session.getPlayer().getWorld().transferPlayerToScene(session.getPlayer(), GameData.getTeleportDataMap().get(req.getQuestId()).getTransmit_points().get(0).getScene_id(), posAndRot.get(0));
        }
        session.send(new PacketQuestTransmitRsp(result, req));
    }
}
