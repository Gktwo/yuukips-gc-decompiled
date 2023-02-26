package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChangeMpTeamAvatarReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.ChangeMpTeamAvatarReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerChangeMpTeamAvatarReq.class */
public class HandlerChangeMpTeamAvatarReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getTeamManager().setupMpTeam(ChangeMpTeamAvatarReqOuterClass.ChangeMpTeamAvatarReq.parseFrom(payload).getAvatarGuidListList());
    }
}
