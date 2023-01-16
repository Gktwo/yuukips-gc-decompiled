package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChooseCurAvatarTeamReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.ChooseCurAvatarTeamReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerChooseCurAvatarTeamReq.class */
public class HandlerChooseCurAvatarTeamReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getTeamManager().setCurrentTeam(ChooseCurAvatarTeamReqOuterClass.ChooseCurAvatarTeamReq.parseFrom(payload).getTeamId());
    }
}
