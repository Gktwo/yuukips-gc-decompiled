package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEntityAiSyncNotify;

@Opcodes(304)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerEntityAiSyncNotify.class */
public class HandlerEntityAiSyncNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        EntityAiSyncNotifyOuterClass.EntityAiSyncNotify notify = EntityAiSyncNotifyOuterClass.EntityAiSyncNotify.parseFrom(payload);
        if (notify.getLocalAvatarAlertedMonsterListCount() > 0) {
            try {
                session.getPlayer().getScene().broadcastPacket(new PacketEntityAiSyncNotify(notify));
            } catch (Exception e) {
            }
        }
    }
}
