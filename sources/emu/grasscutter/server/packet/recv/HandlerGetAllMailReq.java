package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetAllMailReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetAllMailRsp;

@Opcodes(PacketOpcodes.GetAllMailReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetAllMailReq.class */
public class HandlerGetAllMailReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetAllMailRsp(session.getPlayer(), GetAllMailReqOuterClass.GetAllMailReq.parseFrom(payload).getIsCollected()));
    }
}
