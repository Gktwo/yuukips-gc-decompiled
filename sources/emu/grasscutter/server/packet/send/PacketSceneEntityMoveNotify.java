package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.EntityMoveInfoOuterClass;
import emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneEntityMoveNotify.class */
public class PacketSceneEntityMoveNotify extends BasePacket {
    public PacketSceneEntityMoveNotify(EntityMoveInfoOuterClass.EntityMoveInfo moveInfo) {
        super((int) PacketOpcodes.SceneEntityMoveNotify, true);
        setData(SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotify.newBuilder().setMotionInfo(moveInfo.getMotionInfo()).setEntityId(moveInfo.getEntityId()).setSceneTime(moveInfo.getSceneTime()).setReliableSeq(moveInfo.getReliableSeq()).build());
    }
}
