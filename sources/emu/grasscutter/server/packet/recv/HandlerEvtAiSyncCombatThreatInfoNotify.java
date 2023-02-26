package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.server.game.GameSession;

@Opcodes(356)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerEvtAiSyncCombatThreatInfoNotify.class */
public class HandlerEvtAiSyncCombatThreatInfoNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
    }
}
