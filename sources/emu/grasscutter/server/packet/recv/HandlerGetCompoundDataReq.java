package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.GetCompoundDataReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(167)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetCompoundDataReq.class */
public class HandlerGetCompoundDataReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getCookingCompoundManager().handleGetCompoundDataReq(GetCompoundDataReqOuterClass.GetCompoundDataReq.parseFrom(payload));
    }
}
