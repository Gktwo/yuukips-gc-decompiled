package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChatInfoOuterClass;
import emu.grasscutter.net.proto.PlayerChatReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPlayerChatRsp;

@Opcodes(PacketOpcodes.PlayerChatReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPlayerChatReq.class */
public class HandlerPlayerChatReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PlayerChatReqOuterClass.PlayerChatReq req = PlayerChatReqOuterClass.PlayerChatReq.parseFrom(payload);
        ChatInfoOuterClass.ChatInfo.ContentCase content = req.getChatInfo().getContentCase();
        if (content == ChatInfoOuterClass.ChatInfo.ContentCase.TEXT) {
            session.getServer().getChatSystem().sendTeamMessage(session.getPlayer(), req.getChannelId(), req.getChatInfo().getText());
        } else if (content == ChatInfoOuterClass.ChatInfo.ContentCase.ICON) {
            session.getServer().getChatSystem().sendTeamMessage(session.getPlayer(), req.getChannelId(), req.getChatInfo().getIcon());
        }
        session.send(new PacketPlayerChatRsp());
    }
}
