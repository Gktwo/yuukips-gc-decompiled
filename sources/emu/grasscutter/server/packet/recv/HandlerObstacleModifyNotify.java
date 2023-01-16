package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.ObstacleModifyNotify)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerObstacleModifyNotify.class */
public class HandlerObstacleModifyNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
    }
}
