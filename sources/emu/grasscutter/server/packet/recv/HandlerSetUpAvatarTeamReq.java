package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetUpAvatarTeamReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.SetUpAvatarTeamReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetUpAvatarTeamReq.class */
public class HandlerSetUpAvatarTeamReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SetUpAvatarTeamReqOuterClass.SetUpAvatarTeamReq req = SetUpAvatarTeamReqOuterClass.SetUpAvatarTeamReq.parseFrom(payload);
        session.getPlayer().getTeamManager().setupAvatarTeam(req.getTeamId(), req.getAvatarTeamGuidListList());
    }
}
