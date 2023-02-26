package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetOnlinePlayerListRsp;

@Opcodes(70)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetOnlinePlayerListReq.class */
public class HandlerGetOnlinePlayerListReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetOnlinePlayerListRsp(session.getPlayer()));
    }
}
