package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.ForgeQueueManipulateReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(653)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerForgeQueueManipulateReq.class */
public class HandlerForgeQueueManipulateReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getForgingManager().handleForgeQueueManipulateReq(ForgeQueueManipulateReqOuterClass.ForgeQueueManipulateReq.parseFrom(payload));
    }
}
