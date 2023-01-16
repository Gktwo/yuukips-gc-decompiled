package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.EnterWorldAreaReqOuterClass;
import emu.grasscutter.net.proto.PacketHeadOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEnterWorldAreaRsp;

@Opcodes(PacketOpcodes.EnterWorldAreaReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerEnterWorldAreaReq.class */
public class HandlerEnterWorldAreaReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PacketHeadOuterClass.PacketHead head = PacketHeadOuterClass.PacketHead.parseFrom(header);
        session.send(new PacketEnterWorldAreaRsp(head.getClientSequenceId(), EnterWorldAreaReqOuterClass.EnterWorldAreaReq.parseFrom(payload)));
    }
}
