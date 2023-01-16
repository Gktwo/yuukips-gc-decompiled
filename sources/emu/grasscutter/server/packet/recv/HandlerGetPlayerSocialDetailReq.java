package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetPlayerSocialDetailReqOuterClass;
import emu.grasscutter.net.proto.SocialDetailOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetPlayerSocialDetailRsp;

@Opcodes(PacketOpcodes.GetPlayerSocialDetailReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetPlayerSocialDetailReq.class */
public class HandlerGetPlayerSocialDetailReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        GetPlayerSocialDetailReqOuterClass.GetPlayerSocialDetailReq req = GetPlayerSocialDetailReqOuterClass.GetPlayerSocialDetailReq.parseFrom(payload);
        SocialDetailOuterClass.SocialDetail.Builder detail = session.getServer().getSocialDetailByUid(req.getUid());
        if (detail != null) {
            detail.setIsFriend(session.getPlayer().getFriendsList().isFriendsWith(req.getUid()));
        }
        session.send(new PacketGetPlayerSocialDetailRsp(detail));
    }
}
