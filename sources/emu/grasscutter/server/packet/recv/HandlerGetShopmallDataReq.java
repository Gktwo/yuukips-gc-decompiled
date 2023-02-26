package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetShopmallDataRsp;

@Opcodes(PacketOpcodes.GetShopmallDataReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetShopmallDataReq.class */
public class HandlerGetShopmallDataReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetShopmallDataRsp());
    }
}
