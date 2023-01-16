package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetFriendShowNameCardInfoReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetFriendShowNameCardInfoRsp;

@Opcodes(PacketOpcodes.GetFriendShowNameCardInfoReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetFriendShowNameCardInfoReq.class */
public class HandlerGetFriendShowNameCardInfoReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        int targetUid = GetFriendShowNameCardInfoReqOuterClass.GetFriendShowNameCardInfoReq.parseFrom(payload).getUid();
        session.send(new PacketGetFriendShowNameCardInfoRsp(targetUid, session.getServer().getPlayerByUid(targetUid, true).getShowNameCardInfoList()));
    }
}
