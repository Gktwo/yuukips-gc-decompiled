package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PlayerLevelRewardUpdateNotifyOuterClass;
import java.util.Set;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerLevelRewardUpdateNotify.class */
public class PacketPlayerLevelRewardUpdateNotify extends BasePacket {
    public PacketPlayerLevelRewardUpdateNotify(Set<Integer> rewardedLevels) {
        super(154);
        PlayerLevelRewardUpdateNotifyOuterClass.PlayerLevelRewardUpdateNotify.Builder proto = PlayerLevelRewardUpdateNotifyOuterClass.PlayerLevelRewardUpdateNotify.newBuilder();
        for (Integer level : rewardedLevels) {
            proto.addLevelList(level.intValue());
        }
        setData(proto.build());
    }
}
