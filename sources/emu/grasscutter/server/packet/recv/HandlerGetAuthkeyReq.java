package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetAuthkeyRsp;

@Opcodes(1447)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetAuthkeyReq.class */
public class HandlerGetAuthkeyReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetAuthkeyRsp());
    }
}
