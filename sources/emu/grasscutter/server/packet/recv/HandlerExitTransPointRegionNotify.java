package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.ExitTransPointRegionNotify)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerExitTransPointRegionNotify.class */
public class HandlerExitTransPointRegionNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getSotsManager().handleExitTransPointRegionNotify();
    }
}
