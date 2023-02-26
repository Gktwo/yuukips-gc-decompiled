package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.ForgeStartReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(652)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerForgeStartReq.class */
public class HandlerForgeStartReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getForgingManager().handleForgeStartReq(ForgeStartReqOuterClass.ForgeStartReq.parseFrom(payload));
    }
}
