package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarSatiationDataNotifyOuterClass;
import emu.grasscutter.net.proto.AvatarSatiationDataOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarSatiationDataNotify.class */
public class PacketAvatarSatiationDataNotify extends BasePacket {
    public PacketAvatarSatiationDataNotify(Avatar avatar, float finishTime, long penaltyTime) {
        super(PacketOpcodes.AvatarSatiationDataNotify);
        AvatarSatiationDataOuterClass.AvatarSatiationData.Builder avatarSatiation = AvatarSatiationDataOuterClass.AvatarSatiationData.newBuilder().setAvatarGuid(avatar.getGuid()).setFinishTime(finishTime);
        if (penaltyTime > 0) {
            avatarSatiation.setPenaltyFinishTime((float) penaltyTime);
        }
        avatarSatiation.build();
        setData(AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotify.newBuilder().addSatiationDataList(0, avatarSatiation).build());
    }

    public PacketAvatarSatiationDataNotify(float time, Avatar avatar) {
        super(PacketOpcodes.AvatarSatiationDataNotify);
        setData(AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotify.newBuilder().addSatiationDataList(0, AvatarSatiationDataOuterClass.AvatarSatiationData.newBuilder().setAvatarGuid(avatar.getGuid()).setFinishTime(time + (((float) avatar.getSatiation()) / 30.0f)).setPenaltyFinishTime(time + (((float) avatar.getSatiationPenalty()) / 100.0f)).build()).build());
    }
}
