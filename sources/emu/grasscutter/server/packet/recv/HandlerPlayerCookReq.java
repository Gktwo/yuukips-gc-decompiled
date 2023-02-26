package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.PlayerCookReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(175)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPlayerCookReq.class */
public class HandlerPlayerCookReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getCookingManager().handlePlayerCookReq(PlayerCookReqOuterClass.PlayerCookReq.parseFrom(payload));
    }
}
