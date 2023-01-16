package emu.grasscutter.game.battlepass;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.BattlePassMissionData;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.BattlePassMissionStatus;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.packet.send.PacketBattlePassMissionUpdateNotify;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/game/battlepass/BattlePassSystem.class */
public class BattlePassSystem extends BaseGameSystem {
    private final Map<WatcherTriggerType, List<BattlePassMissionData>> cachedTriggers = new HashMap();

    public BattlePassSystem(GameServer server) {
        super(server);
        ObjectIterator<BattlePassMissionData> it = GameData.getBattlePassMissionDataMap().values().iterator();
        while (it.hasNext()) {
            BattlePassMissionData missionData = it.next();
            if (missionData.isValidRefreshType()) {
                getTriggers().computeIfAbsent(missionData.getTriggerType(), e -> {
                    return new ArrayList();
                }).add(missionData);
            }
        }
    }

    @Override // emu.grasscutter.server.game.BaseGameSystem
    public GameServer getServer() {
        return this.server;
    }

    private Map<WatcherTriggerType, List<BattlePassMissionData>> getTriggers() {
        return this.cachedTriggers;
    }

    public void triggerMission(Player player, WatcherTriggerType triggerType) {
        triggerMission(player, triggerType, 0, 1);
    }

    public void triggerMission(Player player, WatcherTriggerType triggerType, int param, int progress) {
        List<BattlePassMissionData> triggerList = getTriggers().get(triggerType);
        if (!(triggerList == null || triggerList.isEmpty())) {
            for (BattlePassMissionData data : triggerList) {
                if (param == 0 || data.getMainParams().contains(Integer.valueOf(param))) {
                    BattlePassMission mission = player.getBattlePassManager().loadMissionById(data.getId());
                    if (!mission.isFinshed()) {
                        mission.addProgress(progress, data.getProgress());
                        if (mission.getProgress() >= data.getProgress()) {
                            mission.setStatus(BattlePassMissionStatus.MISSION_STATUS_FINISHED);
                        }
                        player.getBattlePassManager().save();
                        player.sendPacket(new PacketBattlePassMissionUpdateNotify(mission));
                    }
                }
            }
        }
    }
}
