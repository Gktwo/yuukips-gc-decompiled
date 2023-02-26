package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetMapAreaRsp;

@Opcodes(PacketOpcodes.GetMapAreaReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetMapAreaReq.class */
public class HandlerGetMapAreaReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetMapAreaRsp());
    }
}
