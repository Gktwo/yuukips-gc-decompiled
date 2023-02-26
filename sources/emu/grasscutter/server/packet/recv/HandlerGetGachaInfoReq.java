package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetGachaInfoRsp;

@Opcodes(1505)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetGachaInfoReq.class */
public class HandlerGetGachaInfoReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetGachaInfoRsp(session.getServer().getGachaSystem(), session.getPlayer()));
    }
}
