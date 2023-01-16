package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketHomeBasicInfoNotify;

@Opcodes(PacketOpcodes.HomeGetBasicInfoReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerHomeGetBasicInfoReq.class */
public class HandlerHomeGetBasicInfoReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketHomeBasicInfoNotify(session.getPlayer(), false));
    }
}