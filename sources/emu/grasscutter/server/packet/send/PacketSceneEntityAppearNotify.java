package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SceneEntityAppearNotifyOuterClass;
import emu.grasscutter.net.proto.VisionTypeOuterClass;
import java.util.Collection;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneEntityAppearNotify.class */
public class PacketSceneEntityAppearNotify extends BasePacket {
    public PacketSceneEntityAppearNotify(GameEntity entity) {
        super((int) PacketOpcodes.SceneEntityAppearNotify, true);
        setData(SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotify.newBuilder().setAppearType(VisionTypeOuterClass.VisionType.VISION_TYPE_BORN).addEntityList(entity.toProto()).build());
    }

    public PacketSceneEntityAppearNotify(GameEntity entity, VisionTypeOuterClass.VisionType vision, int param) {
        super((int) PacketOpcodes.SceneEntityAppearNotify, true);
        setData(SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotify.newBuilder().setAppearType(vision).setParam(param).addEntityList(entity.toProto()).build());
    }

    public PacketSceneEntityAppearNotify(Player player) {
        this(player.getTeamManager().getCurrentAvatarEntity());
    }

    public PacketSceneEntityAppearNotify(Collection<? extends GameEntity> entities, VisionTypeOuterClass.VisionType visionType) {
        super((int) PacketOpcodes.SceneEntityAppearNotify, true);
        SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotify.Builder proto = SceneEntityAppearNotifyOuterClass.SceneEntityAppearNotify.newBuilder().setAppearType(visionType);
        entities.forEach(e -> {
            if (e != null) {
                proto.addEntityList(e.toProto());
            }
        });
        setData(proto.build());
    }
}
