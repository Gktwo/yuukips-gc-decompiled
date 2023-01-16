package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DealAddFriendReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.DealAddFriendReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerDealAddFriendReq.class */
public class HandlerDealAddFriendReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        DealAddFriendReqOuterClass.DealAddFriendReq req = DealAddFriendReqOuterClass.DealAddFriendReq.parseFrom(payload);
        session.getPlayer().getFriendsList().handleFriendRequest(req.getTargetUid(), req.getDealAddFriendResult());
    }
}
