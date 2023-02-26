package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.DoGachaReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(1587)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerDoGachaReq.class */
public class HandlerDoGachaReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        DoGachaReqOuterClass.DoGachaReq req = DoGachaReqOuterClass.DoGachaReq.parseFrom(payload);
        session.getServer().getGachaSystem().doPulls(session.getPlayer(), req.getGachaScheduleId(), req.getGachaTimes());
    }
}
