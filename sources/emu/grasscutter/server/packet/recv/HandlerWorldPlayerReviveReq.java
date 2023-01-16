package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketWorldPlayerReviveRsp;

@Opcodes(PacketOpcodes.WorldPlayerReviveReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerWorldPlayerReviveReq.class */
public class HandlerWorldPlayerReviveReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getTeamManager().respawnTeam();
        session.send(new PacketWorldPlayerReviveRsp());
    }
}
