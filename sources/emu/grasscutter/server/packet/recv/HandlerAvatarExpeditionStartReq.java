package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarExpeditionStartReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketAvatarExpeditionStartRsp;
import emu.grasscutter.utils.Utils;

@Opcodes(PacketOpcodes.AvatarExpeditionStartReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerAvatarExpeditionStartReq.class */
public class HandlerAvatarExpeditionStartReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        AvatarExpeditionStartReqOuterClass.AvatarExpeditionStartReq req = AvatarExpeditionStartReqOuterClass.AvatarExpeditionStartReq.parseFrom(payload);
        Player player = session.getPlayer();
        player.addExpeditionInfo(req.getAvatarGuid(), req.getExpId(), req.getHourTime(), Utils.getCurrentSeconds());
        player.save();
        session.send(new PacketAvatarExpeditionStartRsp(player.getExpeditionInfo()));
    }
}
