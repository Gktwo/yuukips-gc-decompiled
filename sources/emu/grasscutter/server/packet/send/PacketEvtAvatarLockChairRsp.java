package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.EvtAvatarLockChairReqOuterClass;
import emu.grasscutter.net.proto.EvtAvatarLockChairRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketEvtAvatarLockChairRsp.class */
public class PacketEvtAvatarLockChairRsp extends BasePacket {
    public PacketEvtAvatarLockChairRsp(int clientSequence, EntityAvatar entityAvatar, EvtAvatarLockChairReqOuterClass.EvtAvatarLockChairReq lockChairReq) {
        super(309);
        setData(EvtAvatarLockChairRspOuterClass.EvtAvatarLockChairRsp.newBuilder().setRetcode(0).setEntityId(entityAvatar.getId()).setPosition(lockChairReq.getPosition()).setChairId(lockChairReq.getChairId()).build());
    }
}
