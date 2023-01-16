package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DeleteFriendReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.DeleteFriendReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerDeleteFriendReq.class */
public class HandlerDeleteFriendReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getFriendsList().deleteFriend(DeleteFriendReqOuterClass.DeleteFriendReq.parseFrom(payload).getTargetUid());
    }
}
