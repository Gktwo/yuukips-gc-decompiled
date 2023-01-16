package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetMailItemReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetMailItemRsp;

@Opcodes(PacketOpcodes.GetMailItemReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetMailItemReq.class */
public class HandlerGetMailItemReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetMailItemRsp(session.getPlayer(), GetMailItemReqOuterClass.GetMailItemReq.parseFrom(payload).getMailIdListList()));
    }
}
