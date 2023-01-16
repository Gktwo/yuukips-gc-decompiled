package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarChangeCostumeReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketAvatarChangeCostumeRsp;

@Opcodes(PacketOpcodes.AvatarChangeCostumeReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerAvatarChangeCostumeReq.class */
public class HandlerAvatarChangeCostumeReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        AvatarChangeCostumeReqOuterClass.AvatarChangeCostumeReq req = AvatarChangeCostumeReqOuterClass.AvatarChangeCostumeReq.parseFrom(payload);
        if (session.getPlayer().getAvatars().changeCostume(req.getAvatarGuid(), req.getCostumeId())) {
            session.getPlayer().sendPacket(new PacketAvatarChangeCostumeRsp(req.getAvatarGuid(), req.getCostumeId()));
        } else {
            session.getPlayer().sendPacket(new PacketAvatarChangeCostumeRsp());
        }
    }
}
