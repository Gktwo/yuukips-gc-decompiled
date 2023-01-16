package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.battlepass.BattlePassMission;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.BattlePassMissionUpdateNotifyOuterClass;
import java.util.Collection;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketBattlePassMissionUpdateNotify.class */
public class PacketBattlePassMissionUpdateNotify extends BasePacket {
    public PacketBattlePassMissionUpdateNotify(BattlePassMission mission) {
        super(PacketOpcodes.BattlePassMissionUpdateNotify);
        setData(BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotify.newBuilder().addMissionList(mission.toProto()).build());
    }

    public PacketBattlePassMissionUpdateNotify(Collection<BattlePassMission> missions) {
        super(PacketOpcodes.BattlePassMissionUpdateNotify);
        BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotify.Builder proto = BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotify.newBuilder();
        missions.forEach(mission -> {
            proto.addMissionList(mission.toProto());
        });
        setData(proto.build());
    }
}
