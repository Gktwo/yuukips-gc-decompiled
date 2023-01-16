package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.MonsterAIConfigHashNotify)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerMonsterAIConfigHashNotify.class */
public class HandlerMonsterAIConfigHashNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
    }
}
