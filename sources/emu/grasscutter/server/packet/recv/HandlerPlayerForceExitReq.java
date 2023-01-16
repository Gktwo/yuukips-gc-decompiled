package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.server.game.GameSession;

@Opcodes(126)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPlayerForceExitReq.class */
public class HandlerPlayerForceExitReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new BasePacket(177));
        session.LogoutWait(true, 1, "PlayerForceExitReq");
    }
}
