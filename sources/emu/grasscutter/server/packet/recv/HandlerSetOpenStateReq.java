package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.SetOpenStateReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(188)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetOpenStateReq.class */
public class HandlerSetOpenStateReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SetOpenStateReqOuterClass.SetOpenStateReq req = SetOpenStateReqOuterClass.SetOpenStateReq.parseFrom(payload);
        session.getPlayer().getProgressManager().setOpenStateFromClient(req.getKey(), req.getValue());
    }
}
