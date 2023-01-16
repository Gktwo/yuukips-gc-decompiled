package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SceneEntityDisappearNotifyOuterClass;
import emu.grasscutter.net.proto.VisionTypeOuterClass;
import java.util.Collection;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneEntityDisappearNotify.class */
public class PacketSceneEntityDisappearNotify extends BasePacket {
    public PacketSceneEntityDisappearNotify(GameEntity entity, VisionTypeOuterClass.VisionType disappearType) {
        super(PacketOpcodes.SceneEntityDisappearNotify);
        setData(SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotify.newBuilder().setDisappearType(disappearType).addEntityList(entity.getId()).build());
    }

    public PacketSceneEntityDisappearNotify(Collection<GameEntity> entities, VisionTypeOuterClass.VisionType disappearType) {
        super(PacketOpcodes.SceneEntityDisappearNotify);
        SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotify.Builder proto = SceneEntityDisappearNotifyOuterClass.SceneEntityDisappearNotify.newBuilder().setDisappearType(disappearType);
        entities.forEach(e -> {
            proto.addEntityList(e.getId());
        });
        setData(proto);
    }
}
