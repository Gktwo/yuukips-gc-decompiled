package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PrivateChatReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.PrivateChatReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPrivateChatReq.class */
public class HandlerPrivateChatReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PrivateChatReqOuterClass.PrivateChatReq req = PrivateChatReqOuterClass.PrivateChatReq.parseFrom(payload);
        PrivateChatReqOuterClass.PrivateChatReq.ContentCase content = req.getContentCase();
        if (content == PrivateChatReqOuterClass.PrivateChatReq.ContentCase.TEXT) {
            session.getServer().getChatSystem().sendPrivateMessage(session.getPlayer(), req.getTargetUid(), req.getText());
        } else if (content == PrivateChatReqOuterClass.PrivateChatReq.ContentCase.ICON) {
            session.getServer().getChatSystem().sendPrivateMessage(session.getPlayer(), req.getTargetUid(), req.getIcon());
        }
    }
}
