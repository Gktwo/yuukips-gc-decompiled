package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.ChangeTeamNameReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(1631)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerChangeTeamNameReq.class */
public class HandlerChangeTeamNameReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        ChangeTeamNameReqOuterClass.ChangeTeamNameReq req = ChangeTeamNameReqOuterClass.ChangeTeamNameReq.parseFrom(payload);
        session.getPlayer().getTeamManager().setTeamName(req.getTeamId(), req.getTeamName());
    }
}
