package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetNameCardReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.SetNameCardReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetNameCardReq.class */
public class HandlerSetNameCardReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().setNameCard(SetNameCardReqOuterClass.SetNameCardReq.parseFrom(payload).getNameCardId());
    }
}
