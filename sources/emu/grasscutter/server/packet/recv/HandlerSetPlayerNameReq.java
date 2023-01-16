package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.SetPlayerNameReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketSetPlayerNameRsp;

@Opcodes(173)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetPlayerNameReq.class */
public class HandlerSetPlayerNameReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SetPlayerNameReqOuterClass.SetPlayerNameReq req = SetPlayerNameReqOuterClass.SetPlayerNameReq.parseFrom(payload);
        if (req.getNickName() != null && req.getNickName().length() > 0) {
            session.getPlayer().setNickname(req.getNickName());
            session.send(new PacketSetPlayerNameRsp(session.getPlayer()));
        }
    }
}
