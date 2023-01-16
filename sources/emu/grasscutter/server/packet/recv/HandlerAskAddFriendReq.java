package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AskAddFriendReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.AskAddFriendReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerAskAddFriendReq.class */
public class HandlerAskAddFriendReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getFriendsList().sendFriendRequest(AskAddFriendReqOuterClass.AskAddFriendReq.parseFrom(payload).getTargetUid());
    }
}
