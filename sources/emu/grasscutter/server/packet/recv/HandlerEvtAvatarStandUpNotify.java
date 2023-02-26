package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.EvtAvatarStandUpNotifyOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEvtAvatarStandUpNotify;

@Opcodes(336)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerEvtAvatarStandUpNotify.class */
public class HandlerEvtAvatarStandUpNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getScene().broadcastPacket(new PacketEvtAvatarStandUpNotify(EvtAvatarStandUpNotifyOuterClass.EvtAvatarStandUpNotify.parseFrom(payload)));
    }
}
