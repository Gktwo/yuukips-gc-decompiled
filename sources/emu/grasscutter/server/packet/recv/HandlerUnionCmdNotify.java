package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.UnionCmdNotifyOuterClass;
import emu.grasscutter.net.proto.UnionCmdOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(42)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerUnionCmdNotify.class */
public class HandlerUnionCmdNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        for (UnionCmdOuterClass.UnionCmd cmd : UnionCmdNotifyOuterClass.UnionCmdNotify.parseFrom(payload).getCmdListList()) {
            session.logPacket("RECV in Union", cmd.getMessageId(), cmd.getBody().toByteArray());
            session.getServer().getPacketHandler().handle(session, cmd.getMessageId(), EMPTY_BYTE_ARRAY, cmd.getBody().toByteArray());
        }
        session.getPlayer().getCombatInvokeHandler().update(session.getPlayer());
        session.getPlayer().getAbilityInvokeHandler().update(session.getPlayer());
        while (!session.getPlayer().getAttackResults().isEmpty()) {
            session.getPlayer().getScene().handleAttack(session.getPlayer().getAttackResults().poll());
        }
    }
}
