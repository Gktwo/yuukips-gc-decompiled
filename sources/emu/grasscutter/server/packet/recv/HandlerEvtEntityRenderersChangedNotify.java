package emu.grasscutter.server.packet.recv;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEvtEntityRenderersChangedNotify;

@Opcodes(350)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerEvtEntityRenderersChangedNotify.class */
public class HandlerEvtEntityRenderersChangedNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotify req = EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotify.parseFrom(payload);
        switch (req.getForwardType()) {
            case FORWARD_TYPE_TO_ALL:
                session.getPlayer().getScene().broadcastPacket(new PacketEvtEntityRenderersChangedNotify(req));
                return;
            case FORWARD_TYPE_TO_ALL_EXCEPT_CUR:
                session.getPlayer().getScene().broadcastPacketToOthers(session.getPlayer(), new PacketEvtEntityRenderersChangedNotify(req));
                return;
            case FORWARD_TYPE_TO_HOST:
                session.getPlayer().getScene().getWorld().getHost().sendPacket(new PacketEvtEntityRenderersChangedNotify(req));
                return;
            default:
                Grasscutter.getLogger().warn("EvtEntityRenderersChangedNotify UK: {}", req.getForwardType().toString());
                return;
        }
    }
}
