package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetEntityClientDataNotifyOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.SetEntityClientDataNotify)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetEntityClientDataNotify.class */
public class HandlerSetEntityClientDataNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        if (session.getPlayer().getScene().getPlayerCount() > 1) {
            SetEntityClientDataNotifyOuterClass.SetEntityClientDataNotify notif = SetEntityClientDataNotifyOuterClass.SetEntityClientDataNotify.parseFrom(payload);
            BasePacket packet = new BasePacket((int) PacketOpcodes.SetEntityClientDataNotify, true);
            packet.setData(notif);
            session.getPlayer().getScene().broadcastPacket(packet);
        }
    }
}
