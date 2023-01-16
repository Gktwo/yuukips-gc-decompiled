package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PullPrivateChatReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.PullPrivateChatReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPullPrivateChatReq.class */
public class HandlerPullPrivateChatReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getServer().getChatSystem().handlePullPrivateChatReq(session.getPlayer(), PullPrivateChatReqOuterClass.PullPrivateChatReq.parseFrom(payload).getTargetUid());
    }
}
