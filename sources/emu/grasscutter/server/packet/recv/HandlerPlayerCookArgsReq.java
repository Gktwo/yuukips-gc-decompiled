package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.PlayerCookArgsReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(109)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPlayerCookArgsReq.class */
public class HandlerPlayerCookArgsReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getCookingManager().handleCookArgsReq(PlayerCookArgsReqOuterClass.PlayerCookArgsReq.parseFrom(payload));
    }
}
