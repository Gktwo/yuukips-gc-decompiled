package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.GetPlayerBlacklistReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetPlayerBlacklistReq.class */
public class HandlerGetPlayerBlacklistReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new BasePacket(PacketOpcodes.GetPlayerBlacklistRsp).buildHeader(3));
    }
}
