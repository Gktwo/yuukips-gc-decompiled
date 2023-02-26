package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.PlayerQuitDungeonReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPlayerQuitDungeonReq.class */
public class HandlerPlayerQuitDungeonReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getServer().getDungeonSystem().exitDungeon(session.getPlayer());
    }
}
