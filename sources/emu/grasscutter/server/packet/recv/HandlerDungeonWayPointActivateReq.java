package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.dungeons.DungeonManager;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DungeonWayPointActivateReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketDungeonWayPointActivateRsp;

@Opcodes(PacketOpcodes.DungeonWayPointActivateReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerDungeonWayPointActivateReq.class */
public class HandlerDungeonWayPointActivateReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        DungeonWayPointActivateReqOuterClass.DungeonWayPointActivateReq req = DungeonWayPointActivateReqOuterClass.DungeonWayPointActivateReq.parseFrom(payload);
        DungeonManager dungeonManager = session.getPlayer().getScene().getDungeonManager();
        boolean success = false;
        if (dungeonManager != null) {
            success = dungeonManager.activateRespawnPoint(req.getWayPointId());
        }
        session.send(new PacketDungeonWayPointActivateRsp(success, req.getWayPointId()));
    }
}
