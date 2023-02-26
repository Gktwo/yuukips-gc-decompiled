package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEvtAvatarSitDownNotify;

@Opcodes(353)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerEvtAvatarSitDownNotify.class */
public class HandlerEvtAvatarSitDownNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getScene().broadcastPacket(new PacketEvtAvatarSitDownNotify(EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotify.parseFrom(payload)));
    }
}
