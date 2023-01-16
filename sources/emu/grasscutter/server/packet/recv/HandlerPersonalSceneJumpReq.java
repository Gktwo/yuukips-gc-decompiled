package emu.grasscutter.server.packet.recv;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.ScenePointEntry;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PersonalSceneJumpReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPersonalSceneJumpRsp;
import emu.grasscutter.utils.Position;

@Opcodes(PacketOpcodes.PersonalSceneJumpReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPersonalSceneJumpReq.class */
public class HandlerPersonalSceneJumpReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PersonalSceneJumpReqOuterClass.PersonalSceneJumpReq req = PersonalSceneJumpReqOuterClass.PersonalSceneJumpReq.parseFrom(payload);
        Player player = session.getPlayer();
        ScenePointEntry scenePointEntry = GameData.getScenePointEntryById(player.getSceneId(), req.getPointId());
        if (scenePointEntry != null && scenePointEntry.getPointData() != null) {
            try {
                Position pos = scenePointEntry.getPointData().getTranPos().clone();
                int sceneId = scenePointEntry.getPointData().getTranSceneId();
                player.getWorld().transferPlayerToScene(player, sceneId, pos);
                session.send(new PacketPersonalSceneJumpRsp(sceneId, pos));
            } catch (Exception e) {
            }
        }
    }
}
