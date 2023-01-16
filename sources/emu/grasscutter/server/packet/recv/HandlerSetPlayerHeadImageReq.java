package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetPlayerHeadImageReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketSetPlayerHeadImageRsp;

@Opcodes(PacketOpcodes.SetPlayerHeadImageReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetPlayerHeadImageReq.class */
public class HandlerSetPlayerHeadImageReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        int id = SetPlayerHeadImageReqOuterClass.SetPlayerHeadImageReq.parseFrom(payload).getAvatarId();
        if (session.getPlayer().getAvatars().hasAvatar(id)) {
            session.getPlayer().setHeadImage(id);
            session.send(new PacketSetPlayerHeadImageRsp(session.getPlayer()));
        }
    }
}
