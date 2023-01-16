package emu.grasscutter.server.packet.recv;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.ScenePointEntry;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.SceneTransToPointReqOuterClass;
import emu.grasscutter.server.event.player.PlayerTeleportEvent;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketSceneTransToPointRsp;

@Opcodes(216)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSceneTransToPointReq.class */
public class HandlerSceneTransToPointReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SceneTransToPointReqOuterClass.SceneTransToPointReq req = SceneTransToPointReqOuterClass.SceneTransToPointReq.parseFrom(payload);
        Player player = session.getPlayer();
        ScenePointEntry scenePointEntry = GameData.getScenePointEntryById(req.getSceneId(), req.getPointId());
        if (scenePointEntry == null || scenePointEntry.getPointData() == null || scenePointEntry.getPointData().getTranPos() == null) {
            Grasscutter.getLogger().error("Failed SceneTransToPointReq with {}", Integer.valueOf(req.getPointId()));
        } else if (player.getWorld().transferPlayerToScene(player, req.getSceneId(), PlayerTeleportEvent.TeleportType.WAYPOINT, scenePointEntry.getPointData().getTranPos().clone())) {
            session.send(new PacketSceneTransToPointRsp(player, req.getPointId(), req.getSceneId()));
            return;
        }
        session.send(new PacketSceneTransToPointRsp());
    }
}
