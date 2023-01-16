package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass;
import emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(1119)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerClientAbilityInitFinishNotify.class */
public class HandlerClientAbilityInitFinishNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotify notif = ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotify.parseFrom(payload);
        Player player = session.getPlayer();
        player.getAbilityManager().onSkillEnd(player);
        for (AbilityInvokeEntryOuterClass.AbilityInvokeEntry entry : notif.getInvokesList()) {
            player.getAbilityManager().onAbilityInvoke(entry);
            player.getClientAbilityInitFinishHandler().addEntry(entry.getForwardType(), entry);
        }
        if (notif.getInvokesList().size() > 0) {
            session.getPlayer().getClientAbilityInitFinishHandler().update(session.getPlayer());
        }
    }
}
