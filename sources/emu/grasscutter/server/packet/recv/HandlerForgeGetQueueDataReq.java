package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.server.game.GameSession;

@Opcodes(635)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerForgeGetQueueDataReq.class */
public class HandlerForgeGetQueueDataReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getForgingManager().handleForgeGetQueueDataReq();
    }
}
