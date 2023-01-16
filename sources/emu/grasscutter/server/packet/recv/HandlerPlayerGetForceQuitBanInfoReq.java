package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPlayerGetForceQuitBanInfoRsp;

@Opcodes(PacketOpcodes.PlayerGetForceQuitBanInfoReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPlayerGetForceQuitBanInfoReq.class */
public class HandlerPlayerGetForceQuitBanInfoReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        if (session.getServer().getMultiplayerSystem().leaveCoop(session.getPlayer())) {
            session.send(new PacketPlayerGetForceQuitBanInfoRsp(0));
        } else {
            session.send(new PacketPlayerGetForceQuitBanInfoRsp(1));
        }
    }
}
