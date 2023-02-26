package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DailyTaskUnlockedCitiesNotifyOuterClass;
import java.util.Set;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDailyTaskUnlockedCitiesNotify.class */
public class PacketDailyTaskUnlockedCitiesNotify extends BasePacket {
    public PacketDailyTaskUnlockedCitiesNotify(Set<Integer> unlockedCities) {
        super(131);
        setData(DailyTaskUnlockedCitiesNotifyOuterClass.DailyTaskUnlockedCitiesNotify.newBuilder().addAllUnlockedCityList(unlockedCities).build());
    }
}
