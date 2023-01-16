package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DelMailReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.DelMailReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerDelMailReq.class */
public class HandlerDelMailReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getMailHandler().deleteMail(DelMailReqOuterClass.DelMailReq.parseFrom(payload).getMailIdListList());
    }
}
