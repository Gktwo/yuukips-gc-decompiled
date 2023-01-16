package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.UpdatePlayerShowAvatarListReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketUpdatePlayerShowAvatarListRsp;

@Opcodes(PacketOpcodes.UpdatePlayerShowAvatarListReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerUpdatePlayerShowAvatarListReq.class */
public class HandlerUpdatePlayerShowAvatarListReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        UpdatePlayerShowAvatarListReqOuterClass.UpdatePlayerShowAvatarListReq req = UpdatePlayerShowAvatarListReqOuterClass.UpdatePlayerShowAvatarListReq.parseFrom(payload);
        session.getPlayer().setShowAvatars(req.getIsShowAvatar());
        session.getPlayer().setShowAvatarList(req.getShowAvatarIdListList());
        session.send(new PacketUpdatePlayerShowAvatarListRsp(req.getIsShowAvatar(), req.getShowAvatarIdListList()));
    }
}
