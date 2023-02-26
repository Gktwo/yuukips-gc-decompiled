package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeChangeModuleReqOuterClass;
import emu.grasscutter.server.event.player.PlayerTeleportEvent;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketHomeChangeModuleRsp;
import emu.grasscutter.server.packet.send.PacketHomeComfortInfoNotify;
import emu.grasscutter.server.packet.send.PacketPlayerHomeCompInfoNotify;

@Opcodes(PacketOpcodes.HomeChangeModuleReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerHomeChangeModuleReq.class */
public class HandlerHomeChangeModuleReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        HomeChangeModuleReqOuterClass.HomeChangeModuleReq req = HomeChangeModuleReqOuterClass.HomeChangeModuleReq.parseFrom(payload);
        session.getPlayer().setCurrentRealmId(req.getTargetModuleId());
        session.send(new PacketHomeChangeModuleRsp(req.getTargetModuleId()));
        session.send(new PacketPlayerHomeCompInfoNotify(session.getPlayer()));
        session.send(new PacketHomeComfortInfoNotify(session.getPlayer()));
        int realmId = 2000 + req.getTargetModuleId();
        session.getPlayer().getWorld().transferPlayerToScene(session.getPlayer(), realmId, PlayerTeleportEvent.TeleportType.WAYPOINT, session.getPlayer().getWorld().getSceneById(realmId).getScriptManager().getConfig().born_pos);
    }
}
