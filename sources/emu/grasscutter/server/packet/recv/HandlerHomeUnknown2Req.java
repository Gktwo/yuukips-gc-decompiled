package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketHomeUnknown2Rsp;

@Opcodes(PacketOpcodes.HomeEnterEditModeFinishReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerHomeUnknown2Req.class */
public class HandlerHomeUnknown2Req extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketHomeUnknown2Rsp());
    }
}
