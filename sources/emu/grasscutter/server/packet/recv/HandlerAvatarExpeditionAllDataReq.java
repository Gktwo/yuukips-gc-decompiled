package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketAvatarExpeditionAllDataRsp;

@Opcodes(PacketOpcodes.AvatarExpeditionAllDataReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerAvatarExpeditionAllDataReq.class */
public class HandlerAvatarExpeditionAllDataReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        Player player = session.getPlayer();
        session.send(new PacketAvatarExpeditionAllDataRsp(player.getExpeditionInfo(), player.getExpeditionLimit()));
    }
}
