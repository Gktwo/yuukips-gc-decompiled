package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.platform.EntityPlatform;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlatformStartRouteNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlatformStartRouteNotify.class */
public class PacketPlatformStartRouteNotify extends BasePacket {
    public PacketPlatformStartRouteNotify(EntityPlatform entity, Scene scene) {
        super(PacketOpcodes.PlatformStartRouteNotify);
        setData(PlatformStartRouteNotifyOuterClass.PlatformStartRouteNotify.newBuilder().setEntityId(entity.getId()).setSceneTime(scene.getSceneTime()).setPlatform(entity.onStartRoute()).build());
    }
}
