package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.GameData;
import emu.grasscutter.game.quest.GameMainQuest;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPersonalLineAllDataRsp.class */
public class PacketPersonalLineAllDataRsp extends BasePacket {
    public PacketPersonalLineAllDataRsp(Collection<GameMainQuest> gameMainQuestList) {
        super(PacketOpcodes.PersonalLineAllDataRsp);
        PersonalLineAllDataRspOuterClass.PersonalLineAllDataRsp.Builder proto = PersonalLineAllDataRspOuterClass.PersonalLineAllDataRsp.newBuilder();
        Set<Integer> questList = (Set) gameMainQuestList.stream().map((v0) -> {
            return v0.getChildQuests();
        }).map((v0) -> {
            return v0.values();
        }).flatMap((v0) -> {
            return v0.stream();
        }).map((v0) -> {
            return v0.getSubQuestId();
        }).collect(Collectors.toSet());
        GameData.getPersonalLineDataMap().values().stream().filter(i -> {
            return !questList.contains(Integer.valueOf(i.getStartQuestId()));
        }).forEach(i -> {
            proto.addCanBeUnlockedPersonalLineList(i.getId());
        });
        setData(proto);
    }
}
