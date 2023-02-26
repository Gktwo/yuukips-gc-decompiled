package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.event.player.PlayerTeleportEvent;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketBackMyWorldRsp;

@Opcodes(PacketOpcodes.BackMyWorldReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerBackMyWorldReq.class */
public class HandlerBackMyWorldReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        int prevScene = session.getPlayer().getScene().getPrevScene();
        if (prevScene >= 2000 && prevScene <= 2400) {
            prevScene = 3;
        }
        session.getPlayer().getWorld().transferPlayerToScene(session.getPlayer(), prevScene, PlayerTeleportEvent.TeleportType.WAYPOINT, session.getPlayer().getPrevPos());
        session.send(new PacketBackMyWorldRsp());
    }
}
