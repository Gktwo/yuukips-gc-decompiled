package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DelBackupAvatarTeamReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.DelBackupAvatarTeamReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerRemoveCustomTeamReq.class */
public class HandlerRemoveCustomTeamReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getTeamManager().removeCustomTeam(DelBackupAvatarTeamReqOuterClass.DelBackupAvatarTeamReq.parseFrom(payload).getBackupAvatarTeamId());
    }
}
