package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QuestDestroyEntityReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketQuestDestroyEntityRsp;

@Opcodes(PacketOpcodes.QuestDestroyEntityReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerQuestDestroyEntityReq.class */
public class HandlerQuestDestroyEntityReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        QuestDestroyEntityReqOuterClass.QuestDestroyEntityReq req = QuestDestroyEntityReqOuterClass.QuestDestroyEntityReq.parseFrom(payload);
        Scene scene = session.getPlayer().getWorld().getSceneById(req.getSceneId());
        GameEntity entity = scene.getEntityById(req.getEntityId());
        if (entity != null) {
            scene.removeEntity(entity);
        }
        session.send(new PacketQuestDestroyEntityRsp(entity != null, req));
    }
}
