package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HitTreeNotifyOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.HitTreeNotify)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerHitTreeNotify.class */
public class HandlerHitTreeNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getDeforestationManager().onDeforestationInvoke(HitTreeNotifyOuterClass.HitTreeNotify.parseFrom(payload));
    }
}
