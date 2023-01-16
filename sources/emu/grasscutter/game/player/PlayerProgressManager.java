package emu.grasscutter.game.player;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.OpenStateData;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.enums.ParentQuestState;
import emu.grasscutter.game.quest.enums.QuestState;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.scripts.data.ScriptArgs;
import emu.grasscutter.server.packet.send.PacketOpenStateChangeNotify;
import emu.grasscutter.server.packet.send.PacketOpenStateUpdateNotify;
import emu.grasscutter.server.packet.send.PacketSceneAreaUnlockNotify;
import emu.grasscutter.server.packet.send.PacketScenePointUnlockNotify;
import emu.grasscutter.server.packet.send.PacketSetOpenStateRsp;
import java.util.Set;
import java.util.stream.Collectors;

/* loaded from: grasscutter.jar:emu/grasscutter/game/player/PlayerProgressManager.class */
public class PlayerProgressManager extends BasePlayerDataManager {
    public static final Set<Integer> BLACKLIST_OPEN_STATES = Set.of();
    public static final Set<Integer> DEFAULT_OPEN_STATES = (Set) GameData.getOpenStateList().stream().filter(s -> {
        return s.isDefaultState() || s.getId() == 1 || s.getId() == 48;
    }).filter(s -> {
        return !BLACKLIST_OPEN_STATES.contains(Integer.valueOf(s.getId()));
    }).map(s -> {
        return Integer.valueOf(s.getId());
    }).collect(Collectors.toSet());

    public PlayerProgressManager(Player player) {
        super(player);
    }

    public void onPlayerLogin() {
        tryUnlockOpenStates(false);
        this.player.getSession().send(new PacketOpenStateUpdateNotify(this.player));
    }

    public int getOpenState(int openState) {
        return this.player.getOpenStates().getOrDefault(Integer.valueOf(openState), 0).intValue();
    }

    private void setOpenState(int openState, int value, boolean sendNotify) {
        if (value != this.player.getOpenStates().getOrDefault(Integer.valueOf(openState), 0).intValue()) {
            this.player.getOpenStates().put(Integer.valueOf(openState), Integer.valueOf(value));
            if (sendNotify) {
                this.player.getSession().send(new PacketOpenStateChangeNotify(openState, value));
            }
        }
    }

    public void setOpenState(int openState, int value) {
        setOpenState(openState, value, true);
    }

    private boolean areConditionsMet(OpenStateData openState) {
        for (OpenStateData.OpenStateCond condition : openState.getCond()) {
            if (condition.getCondType() == OpenStateData.OpenStateCondType.OPEN_STATE_COND_PLAYER_LEVEL) {
                if (this.player.getLevel() < condition.getParam()) {
                    return false;
                }
            } else if (condition.getCondType() == OpenStateData.OpenStateCondType.OPEN_STATE_COND_QUEST) {
                GameQuest quest = this.player.getQuestManager().getQuestById(condition.getParam());
                if (quest == null || quest.getState() != QuestState.QUEST_STATE_FINISHED) {
                    return false;
                }
            } else if (condition.getCondType() == OpenStateData.OpenStateCondType.OPEN_STATE_COND_PARENT_QUEST) {
                GameQuest quest2 = this.player.getQuestManager().getQuestById(condition.getParam());
                if (quest2 == null || quest2.getMainQuest().getState() != ParentQuestState.PARENT_QUEST_STATE_FINISHED) {
                    return false;
                }
            } else if (condition.getCondType() == OpenStateData.OpenStateCondType.OPEN_STATE_OFFERING_LEVEL || condition.getCondType() == OpenStateData.OpenStateCondType.OPEN_STATE_CITY_REPUTATION_LEVEL) {
                return false;
            }
        }
        return true;
    }

    public void setOpenStateFromClient(int openState, int value) {
        OpenStateData data = GameData.getOpenStateDataMap().get(openState);
        if (data == null) {
            this.player.sendPacket(new PacketSetOpenStateRsp(RetcodeOuterClass.Retcode.RET_FAIL));
        } else if (!data.isAllowClientOpen() || !areConditionsMet(data)) {
            this.player.sendPacket(new PacketSetOpenStateRsp(RetcodeOuterClass.Retcode.RET_FAIL));
        } else {
            setOpenState(openState, value);
            this.player.sendPacket(new PacketSetOpenStateRsp(openState, value));
        }
    }

    public void tryUnlockOpenStates(boolean sendNotify) {
        for (OpenStateData state : GameData.getOpenStateList().stream().filter(s -> {
            return this.player.getOpenStates().getOrDefault(s, 0).intValue() == 0;
        }).toList()) {
            if (!state.isAllowClientOpen() && areConditionsMet(state) && !BLACKLIST_OPEN_STATES.contains(Integer.valueOf(state.getId()))) {
                setOpenState(state.getId(), 1, sendNotify);
            }
        }
    }

    public void tryUnlockOpenStates() {
        tryUnlockOpenStates(true);
    }

    public boolean unlockTransPoint(int sceneId, int pointId, boolean isStatue) {
        this.player.getUnlockedScenePoints(sceneId).add(Integer.valueOf(pointId));
        this.player.getInventory().addItem(201, 5, ActionReason.UnlockPointReward);
        this.player.getInventory().addItem(102, isStatue ? 50 : 10, ActionReason.UnlockPointReward);
        this.player.getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_UNLOCK_TRANS_POINT, sceneId, pointId);
        this.player.getScene().getScriptManager().callEvent(new ScriptArgs(27, sceneId, pointId));
        this.player.sendPacket(new PacketScenePointUnlockNotify(sceneId, pointId));
        return true;
    }

    public void unlockSceneArea(int sceneId, int areaId) {
        this.player.getUnlockedSceneAreas(sceneId).add(Integer.valueOf(areaId));
        this.player.sendPacket(new PacketSceneAreaUnlockNotify(sceneId, areaId));
        this.player.getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_UNLOCK_AREA, sceneId, areaId);
    }
}
