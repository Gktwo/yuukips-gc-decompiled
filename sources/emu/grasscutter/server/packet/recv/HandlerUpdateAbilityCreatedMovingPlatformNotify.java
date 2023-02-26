package emu.grasscutter.server.packet.recv;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.entity.platform.EntityPlatform;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPlatformStartRouteNotify;
import emu.grasscutter.server.packet.send.PacketPlatformStopRouteNotify;

@Opcodes(813)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerUpdateAbilityCreatedMovingPlatformNotify.class */
public class HandlerUpdateAbilityCreatedMovingPlatformNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotify notify = UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotify.parseFrom(payload);
        GameEntity entity = session.getPlayer().getScene().getEntityById(notify.getEntityId());
        if (entity instanceof EntityPlatform) {
            Scene scene = ((EntityPlatform) entity).getOwner().getScene();
            switch (notify.getOpType()) {
                case OP_TYPE_ACTIVATE:
                    scene.broadcastPacket(new PacketPlatformStartRouteNotify((EntityPlatform) entity, scene));
                    return;
                case OP_TYPE_DEACTIVATE:
                    scene.broadcastPacket(new PacketPlatformStopRouteNotify((EntityPlatform) entity, scene));
                    return;
                default:
                    Grasscutter.getLogger().warn("UpdateAbilityCreatedMovingPlatformNotify UK: {}", notify.getOpType());
                    return;
            }
        }
    }
}
