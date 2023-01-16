package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.dungeons.DungeonManager;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DungeonSlipRevivePointActivateReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketDungeonSlipRevivePointActivateRsp;

@Opcodes(PacketOpcodes.DungeonWayPointActivateReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerDungeonSlipRevivePointActivateReq.class */
public class HandlerDungeonSlipRevivePointActivateReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        DungeonSlipRevivePointActivateReqOuterClass.DungeonSlipRevivePointActivateReq req = DungeonSlipRevivePointActivateReqOuterClass.DungeonSlipRevivePointActivateReq.parseFrom(payload);
        DungeonManager dungeonManager = session.getPlayer().getScene().getDungeonManager();
        boolean success = false;
        if (dungeonManager != null) {
            success = dungeonManager.activateRespawnPoint(req.getSlipRevivePointId());
        }
        session.send(new PacketDungeonSlipRevivePointActivateRsp(success, req.getSlipRevivePointId()));
    }
}
