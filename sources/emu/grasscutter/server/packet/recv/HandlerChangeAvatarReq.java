package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChangeAvatarReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.ChangeAvatarReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerChangeAvatarReq.class */
public class HandlerChangeAvatarReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getTeamManager().changeAvatar(ChangeAvatarReqOuterClass.ChangeAvatarReq.parseFrom(payload).getGuid());
    }
}
