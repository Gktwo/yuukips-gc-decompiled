package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.platform.EntityPlatform;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlatformStopRouteNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlatformStopRouteNotify.class */
public class PacketPlatformStopRouteNotify extends BasePacket {
    public PacketPlatformStopRouteNotify(EntityPlatform entity, Scene scene) {
        super(PacketOpcodes.PlatformStopRouteNotify);
        setData(PlatformStopRouteNotifyOuterClass.PlatformStopRouteNotify.newBuilder().setPlatform(entity.onStopRoute()).setSceneTime(scene.getSceneTime()).setEntityId(entity.getId()).build());
    }
}
