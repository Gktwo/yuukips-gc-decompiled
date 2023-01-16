package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.BattlePassMissionData;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketBattlePassAllDataNotify.class */
public class PacketBattlePassAllDataNotify extends BasePacket {
    public PacketBattlePassAllDataNotify(Player player) {
        super(PacketOpcodes.BattlePassAllDataNotify);
        BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotify.Builder proto = BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotify.newBuilder();
        proto.setHaveCurSchedule(true).setCurSchedule(player.getBattlePassManager().getScheduleProto());
        ObjectIterator<BattlePassMissionData> it = GameData.getBattlePassMissionDataMap().values().iterator();
        while (it.hasNext()) {
            BattlePassMissionData missionData = it.next();
            if (missionData.isValidRefreshType()) {
                if (player.getBattlePassManager().hasMission(missionData.getId())) {
                    proto.addMissionList(player.getBattlePassManager().loadMissionById(missionData.getId()).toProto());
                } else {
                    proto.addMissionList(missionData.toProto());
                }
            }
        }
        setData(proto.build());
    }
}
