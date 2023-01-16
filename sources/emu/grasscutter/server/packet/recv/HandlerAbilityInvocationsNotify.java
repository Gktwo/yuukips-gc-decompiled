package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AbilityInvocationsNotifyOuterClass;
import emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.AbilityInvocationsNotify)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerAbilityInvocationsNotify.class */
public class HandlerAbilityInvocationsNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        AbilityInvocationsNotifyOuterClass.AbilityInvocationsNotify notif = AbilityInvocationsNotifyOuterClass.AbilityInvocationsNotify.parseFrom(payload);
        Player player = session.getPlayer();
        for (AbilityInvokeEntryOuterClass.AbilityInvokeEntry entry : notif.getInvokesList()) {
            player.getAbilityManager().onAbilityInvoke(entry);
            player.getAbilityInvokeHandler().addEntry(entry.getForwardType(), entry);
        }
    }
}
