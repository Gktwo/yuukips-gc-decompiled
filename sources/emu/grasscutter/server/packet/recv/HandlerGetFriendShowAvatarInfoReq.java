package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetFriendShowAvatarInfoReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetFriendShowAvatarInfoRsp;

@Opcodes(PacketOpcodes.GetFriendShowAvatarInfoReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetFriendShowAvatarInfoReq.class */
public class HandlerGetFriendShowAvatarInfoReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        int targetUid = GetFriendShowAvatarInfoReqOuterClass.GetFriendShowAvatarInfoReq.parseFrom(payload).getUid();
        Player targetPlayer = session.getServer().getPlayerByUid(targetUid, true);
        if (targetPlayer.isShowAvatars()) {
            session.send(new PacketGetFriendShowAvatarInfoRsp(targetUid, targetPlayer.getShowAvatarInfoList()));
        }
    }
}
