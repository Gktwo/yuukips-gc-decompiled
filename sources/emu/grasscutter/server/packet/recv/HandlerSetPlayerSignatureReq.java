package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetPlayerSignatureReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketSetPlayerSignatureRsp;

@Opcodes(PacketOpcodes.SetPlayerSignatureReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetPlayerSignatureReq.class */
public class HandlerSetPlayerSignatureReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SetPlayerSignatureReqOuterClass.SetPlayerSignatureReq req = SetPlayerSignatureReqOuterClass.SetPlayerSignatureReq.parseFrom(payload);
        if (req.getSignature() != null && req.getSignature().length() > 0) {
            session.getPlayer().setSignature(req.getSignature());
            session.send(new PacketSetPlayerSignatureRsp(session.getPlayer()));
        }
    }
}
