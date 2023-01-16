package emu.grasscutter.game.dungeons;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.DataLoader;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.DungeonData;
import emu.grasscutter.data.excels.DungeonPassConfigData;
import emu.grasscutter.game.dungeons.dungeon_results.BaseDungeonResult;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.game.quest.QuestManager;
import emu.grasscutter.game.quest.enums.LogicType;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.data.ScriptArgs;
import emu.grasscutter.server.packet.send.PacketDungeonWayPointNotify;
import emu.grasscutter.server.packet.send.PacketGadgetAutoPickDropInfoNotify;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.NonNull;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import p014it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import p014it.unimi.dsi.fastutil.ints.IntSet;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/DungeonManager.class */
public class DungeonManager {
    private final Scene scene;
    private final DungeonData dungeonData;
    private final DungeonPassConfigData passConfigData;
    private final int[] finishedConditions;
    private final IntSet rewardedPlayers = new IntOpenHashSet();
    private int newestWayPoint = 0;
    private boolean ended = false;
    private Set<Integer> activeDungeonWayPoints = new HashSet();
    private static final Int2ObjectMap<List<DungeonDropEntry>> dungeonDropData = new Int2ObjectOpenHashMap();

    public Scene getScene() {
        return this.scene;
    }

    public DungeonData getDungeonData() {
        return this.dungeonData;
    }

    public DungeonPassConfigData getPassConfigData() {
        return this.passConfigData;
    }

    public int[] getFinishedConditions() {
        return this.finishedConditions;
    }

    public static void initialize() {
        try {
            DataLoader.loadList("DungeonDrop.json", DungeonDrop.class).forEach(entry -> {
                dungeonDropData.put(entry.getDungeonId(), (int) entry.getDrops());
            });
            Grasscutter.getLogger().warn("Loaded {} dungeon drop data entries.", Integer.valueOf(dungeonDropData.size()));
        } catch (Exception ex) {
            Grasscutter.getLogger().error("Unable to load dungeon drop data.", (Throwable) ex);
        }
    }

    public DungeonManager(@NonNull Scene scene, @NonNull DungeonData dungeonData) {
        if (scene == null) {
            throw new NullPointerException("scene is marked non-null but is null");
        } else if (dungeonData == null) {
            throw new NullPointerException("dungeonData is marked non-null but is null");
        } else {
            int id = dungeonData.getPassCond();
            this.scene = scene;
            this.dungeonData = dungeonData;
            this.passConfigData = GameData.getDungeonPassConfigDataMap().get(id);
            if (this.passConfigData == null || this.passConfigData.getConds() == null) {
                this.finishedConditions = new int[0];
                Grasscutter.getLogger().error("No config found dungeon");
            } else {
                this.finishedConditions = new int[this.passConfigData.getConds().size()];
                Grasscutter.getLogger().info("Start Dungeon {} with pass id {}", Integer.valueOf(dungeonData.getId()), Integer.valueOf(id));
            }
            this.scene.setDungeonManager(this);
        }
    }

    public void triggerEvent(DungeonPassConditionType conditionType, int... params) {
        if (!this.ended && this.passConfigData != null) {
            int total_pass = this.passConfigData.getConds().size();
            for (int i = 0; i < total_pass; i++) {
                DungeonPassConfigData.DungeonPassCondition cond = this.passConfigData.getConds().get(i);
                if (!(cond == null || cond.getCondType() == null || conditionType != cond.getCondType())) {
                    Grasscutter.getLogger().info(" -> Add {}", conditionType.name());
                    Grasscutter.getLogger().info("--> {}", cond.getParam());
                    if (getScene().getWorld().getServer().getDungeonSystem().triggerCondition(cond, params)) {
                        this.finishedConditions[i] = 1;
                    } else {
                        Grasscutter.getLogger().error("---> Faild?");
                    }
                }
            }
            if (isFinishedSuccessfully()) {
                finishDungeon();
            }
        }
    }

    public boolean isFinishedSuccessfully() {
        if (this.passConfigData != null) {
            return LogicType.calculate(this.passConfigData.getLogicType(), this.finishedConditions);
        }
        Grasscutter.getLogger().info("isFinishedSuccessfully: No found");
        return false;
    }

    public int getLevelForMonster(int id) {
        return this.dungeonData.getShowLevel();
    }

    public boolean activateRespawnPoint(int pointId) {
        if (GameData.getScenePointEntryById(this.scene.getId(), pointId) == null) {
            Grasscutter.getLogger().warn("trying to activate unknown respawn point {}", Integer.valueOf(pointId));
            return false;
        }
        this.scene.broadcastPacket(new PacketDungeonWayPointNotify(this.activeDungeonWayPoints.add(Integer.valueOf(pointId)), this.activeDungeonWayPoints));
        this.newestWayPoint = pointId;
        Grasscutter.getLogger().warn("[implemented respawn] activated respawn point {}", Integer.valueOf(pointId));
        return true;
    }

    public boolean getStatueDrops(Player player, boolean useCondensed) {
        if (!isFinishedSuccessfully() || this.dungeonData.getRewardPreviewData() == null || this.dungeonData.getRewardPreviewData().getPreviewItems().length == 0 || this.rewardedPlayers.contains(player.getUid()) || !handleCost(player, useCondensed)) {
            return false;
        }
        List<GameItem> rewards = new ArrayList<>(rollRewards(useCondensed));
        player.getInventory().addItems(rewards, ActionReason.DungeonStatueDrop);
        player.sendPacket(new PacketGadgetAutoPickDropInfoNotify(rewards));
        this.rewardedPlayers.add(player.getUid());
        this.scene.getScriptManager().callEvent(new ScriptArgs(33));
        return true;
    }

    public boolean handleCost(Player player, boolean useCondensed) {
        int resinCost = this.dungeonData.getStatueCostCount() != 0 ? this.dungeonData.getStatueCostCount() : 20;
        if (resinCost == 0) {
            return true;
        }
        if (useCondensed) {
            if (resinCost != 20) {
                return false;
            }
            return player.getResinManager().useCondensedResin(1);
        } else if (this.dungeonData.getStatueCostID() == 106) {
            return player.getResinManager().useResin(resinCost);
        } else {
            return true;
        }
    }

    private List<GameItem> rollRewards(boolean useCondensed) {
        List<GameItem> rewards = new ArrayList<>();
        int dungeonId = this.dungeonData.getId();
        if (dungeonDropData.containsKey(dungeonId)) {
            for (DungeonDropEntry entry : dungeonDropData.get(dungeonId)) {
                List<Integer> candidateAmounts = (List) IntStream.range(entry.getCounts().get(0).intValue(), entry.getCounts().get(entry.getCounts().size() - 1).intValue() + 1).boxed().collect(Collectors.toList());
                int amount = ((Integer) Utils.drawRandomListElement(candidateAmounts, entry.getProbabilities())).intValue();
                if (useCondensed) {
                    amount += ((Integer) Utils.drawRandomListElement(candidateAmounts, entry.getProbabilities())).intValue();
                }
                if (entry.isMpDouble() && this.scene.getPlayerCount() > 1) {
                    amount *= 2;
                }
                if (entry.getItems().size() == 1) {
                    rewards.add(new GameItem(entry.getItems().get(0).intValue(), amount));
                } else {
                    for (int i = 0; i < amount; i++) {
                        rewards.add(new GameItem(((Integer) Utils.drawRandomListElement(entry.getItems(), entry.getItemProbabilities())).intValue(), 1));
                    }
                }
            }
        } else {
            Grasscutter.getLogger().info("No drop data found or dungeon {}, falling back to preview data ...", Integer.valueOf(dungeonId));
            ItemParamData[] previewItems = this.dungeonData.getRewardPreviewData().getPreviewItems();
            for (ItemParamData param : previewItems) {
                rewards.add(new GameItem(param.getId(), Math.max(param.getCount(), 1)));
            }
        }
        return rewards;
    }

    public void startDungeon() {
        this.scene.getPlayers().forEach(p -> {
            p.getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_ENTER_DUNGEON, this.dungeonData.getId());
        });
    }

    public void notifyEndDungeon(boolean successfully) {
        this.scene.getPlayers().forEach(p -> {
            QuestTrigger questTrigger;
            QuestManager questManager = successfully.getQuestManager();
            if (successfully) {
                questTrigger = QuestTrigger.QUEST_CONTENT_FINISH_DUNGEON;
            } else {
                questTrigger = QuestTrigger.QUEST_CONTENT_FAIL_DUNGEON;
            }
            questManager.queueEvent(questTrigger, this.dungeonData.getId());
            if (this.dungeonData.getType().isCountsToBattlepass() && successfully) {
                successfully.getBattlePassManager().triggerMission(WatcherTriggerType.TRIGGER_FINISH_DUNGEON);
            }
        });
        this.scene.getScriptManager().callEvent(new ScriptArgs(8, successfully ? 1 : 0));
        this.scene.getScriptManager().callEvent(new ScriptArgs(successfully ? 16 : 17).setParam2(0));
    }

    public void finishDungeon() {
        Grasscutter.getLogger().info("Dungeon {} is finish", Integer.valueOf(this.dungeonData.getId()));
        notifyEndDungeon(true);
        endDungeon(BaseDungeonResult.DungeonEndReason.COMPLETED);
    }

    public void quitDungeon() {
        Grasscutter.getLogger().info("Dungeon {} is quit", Integer.valueOf(this.dungeonData.getId()));
        notifyEndDungeon(false);
        endDungeon(BaseDungeonResult.DungeonEndReason.QUIT);
    }

    public void failDungeon() {
        Grasscutter.getLogger().debug("Dungeon {} is fail", Integer.valueOf(this.dungeonData.getId()));
        notifyEndDungeon(false);
        endDungeon(BaseDungeonResult.DungeonEndReason.FAILED);
    }

    public void endDungeon(BaseDungeonResult.DungeonEndReason endReason) {
        if (this.scene.getDungeonSettleListeners() != null) {
            this.scene.getDungeonSettleListeners().forEach(o -> {
                endReason.onDungeonSettle(this, endReason);
            });
        }
        this.ended = true;
    }

    public void restartDungeon() {
        this.scene.setKilledMonsterCount(0);
        this.rewardedPlayers.clear();
        Arrays.fill(this.finishedConditions, 0);
        this.ended = false;
        this.activeDungeonWayPoints.clear();
    }

    public void cleanUpScene() {
        this.scene.setDungeonManager(null);
        this.scene.setKilledMonsterCount(0);
    }
}
