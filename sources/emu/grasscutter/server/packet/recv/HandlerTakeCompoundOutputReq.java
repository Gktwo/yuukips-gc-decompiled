package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.TakeCompoundOutputReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(134)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerTakeCompoundOutputReq.class */
public class HandlerTakeCompoundOutputReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getCookingCompoundManager().handleTakeCompoundOutputReq(TakeCompoundOutputReqOuterClass.TakeCompoundOutputReq.parseFrom(payload));
    }
}
