package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarExpeditionCallBackReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketAvatarExpeditionCallBackRsp;

@Opcodes(PacketOpcodes.AvatarExpeditionCallBackReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerAvatarExpeditionCallBackReq.class */
public class HandlerAvatarExpeditionCallBackReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        AvatarExpeditionCallBackReqOuterClass.AvatarExpeditionCallBackReq req = AvatarExpeditionCallBackReqOuterClass.AvatarExpeditionCallBackReq.parseFrom(payload);
        Player player = session.getPlayer();
        for (int i = 0; i < req.getAvatarGuidCount(); i++) {
            player.removeExpeditionInfo(req.getAvatarGuid(i));
        }
        player.save();
        session.send(new PacketAvatarExpeditionCallBackRsp(player.getExpeditionInfo()));
    }
}
