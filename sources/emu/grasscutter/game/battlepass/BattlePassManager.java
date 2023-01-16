package emu.grasscutter.game.battlepass;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Indexed;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.BattlePassRewardData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.data.excels.RewardData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.inventory.MaterialType;
import emu.grasscutter.game.player.BasePlayerDataManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.BattlePassMissionRefreshType;
import emu.grasscutter.game.props.BattlePassMissionStatus;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.net.proto.BattlePassCycleOuterClass;
import emu.grasscutter.net.proto.BattlePassRewardTagOuterClass;
import emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass;
import emu.grasscutter.net.proto.BattlePassScheduleOuterClass;
import emu.grasscutter.net.proto.BattlePassUnlockStatusOuterClass;
import emu.grasscutter.server.packet.send.PacketBattlePassCurScheduleUpdateNotify;
import emu.grasscutter.server.packet.send.PacketBattlePassMissionUpdateNotify;
import emu.grasscutter.server.packet.send.PacketTakeBattlePassRewardRsp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;

@Entity(value = "battlepass", useDiscriminator = false)
/* loaded from: grasscutter.jar:emu/grasscutter/game/battlepass/BattlePassManager.class */
public class BattlePassManager extends BasePlayerDataManager {
    @AbstractC1283Id

    /* renamed from: id */
    private ObjectId f565id;
    @Indexed
    private int ownerUid;
    private int point;
    private int cyclePoints;
    private int level;
    private boolean viewed;
    private boolean paid;
    private Map<Integer, BattlePassMission> missions;
    private Map<Integer, BattlePassReward> takenRewards;

    /*  JADX ERROR: Dependency scan failed at insn: 0x00F1: INVOKE_CUSTOM r-8
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x00F1: INVOKE_CUSTOM r1, method: emu.grasscutter.game.battlepass.BattlePassManager.takeRewardsFromSelectChest(emu.grasscutter.data.excels.ItemData, int, emu.grasscutter.data.common.ItemParamData, java.util.List<emu.grasscutter.game.inventory.GameItem>):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid chest type for BP reward: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid chest type for BP reward: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private void takeRewardsFromSelectChest(emu.grasscutter.data.excels.ItemData r6, int r7, emu.grasscutter.data.common.ItemParamData r8, java.util.List<emu.grasscutter.game.inventory.GameItem> r9) {
        /*
            r5 = this;
            r0 = r6
            java.util.List r0 = r0.getItemUse()
            int r0 = r0.size()
            r1 = 1
            if (r0 >= r1) goto L_0x000e
            return
            r0 = r6
            java.util.List r0 = r0.getItemUse()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            emu.grasscutter.data.common.ItemUseData r0 = (emu.grasscutter.data.common.ItemUseData) r0
            java.lang.String[] r0 = r0.getUseParam()
            r1 = 0
            r0 = r0[r1]
            java.lang.String r1 = ","
            java.lang.String[] r0 = r0.split(r1)
            r10 = r0
            r0 = r10
            int r0 = r0.length
            r1 = r7
            if (r0 >= r1) goto L_0x002f
            return
            r0 = r10
            r1 = r7
            r2 = 1
            int r1 = r1 - r2
            r0 = r0[r1]
            int r0 = java.lang.Integer.parseInt(r0)
            r11 = r0
            r0 = r6
            java.util.List r0 = r0.getItemUse()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            emu.grasscutter.data.common.ItemUseData r0 = (emu.grasscutter.data.common.ItemUseData) r0
            emu.grasscutter.game.props.ItemUseOp r0 = r0.getUseOp()
            emu.grasscutter.game.props.ItemUseOp r1 = emu.grasscutter.game.props.ItemUseOp.ITEM_USE_ADD_SELECT_ITEM
            if (r0 != r1) goto L_0x0077
            emu.grasscutter.game.inventory.GameItem r0 = new emu.grasscutter.game.inventory.GameItem
            r1 = r0
            it.unimi.dsi.fastutil.ints.Int2ObjectMap r2 = emu.grasscutter.data.GameData.getItemDataMap()
            r3 = r11
            java.lang.Object r2 = r2.get(r3)
            emu.grasscutter.data.excels.ItemData r2 = (emu.grasscutter.data.excels.ItemData) r2
            r3 = r8
            int r3 = r3.getItemCount()
            r1.<init>(r2, r3)
            r12 = r0
            r0 = r9
            r1 = r12
            boolean r0 = r0.add(r1)
            goto L_0x00f9
            r0 = r6
            java.util.List r0 = r0.getItemUse()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            emu.grasscutter.data.common.ItemUseData r0 = (emu.grasscutter.data.common.ItemUseData) r0
            emu.grasscutter.game.props.ItemUseOp r0 = r0.getUseOp()
            emu.grasscutter.game.props.ItemUseOp r1 = emu.grasscutter.game.props.ItemUseOp.ITEM_USE_GRANT_SELECT_REWARD
            if (r0 != r1) goto L_0x00ec
            it.unimi.dsi.fastutil.ints.Int2ObjectMap r0 = emu.grasscutter.data.GameData.getRewardDataMap()
            r1 = r11
            java.lang.Object r0 = r0.get(r1)
            emu.grasscutter.data.excels.RewardData r0 = (emu.grasscutter.data.excels.RewardData) r0
            r12 = r0
            r0 = r12
            java.util.List r0 = r0.getRewardItemList()
            java.util.Iterator r0 = r0.iterator()
            r13 = r0
            r0 = r13
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00e9
            r0 = r13
            java.lang.Object r0 = r0.next()
            emu.grasscutter.data.common.ItemParamData r0 = (emu.grasscutter.data.common.ItemParamData) r0
            r14 = r0
            emu.grasscutter.game.inventory.GameItem r0 = new emu.grasscutter.game.inventory.GameItem
            r1 = r0
            it.unimi.dsi.fastutil.ints.Int2ObjectMap r2 = emu.grasscutter.data.GameData.getItemDataMap()
            r3 = r14
            int r3 = r3.getItemId()
            java.lang.Object r2 = r2.get(r3)
            emu.grasscutter.data.excels.ItemData r2 = (emu.grasscutter.data.excels.ItemData) r2
            r3 = r14
            int r3 = r3.getItemCount()
            r1.<init>(r2, r3)
            r15 = r0
            r0 = r9
            r1 = r15
            boolean r0 = r0.add(r1)
            goto L_0x00a8
            goto L_0x00f9
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r11
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid chest type for BP reward: ]}
            r0.warn(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.battlepass.BattlePassManager.takeRewardsFromSelectChest(emu.grasscutter.data.excels.ItemData, int, emu.grasscutter.data.common.ItemParamData, java.util.List):void");
    }

    public ObjectId getId() {
        return this.f565id;
    }

    public int getPoint() {
        return this.point;
    }

    public int getCyclePoints() {
        return this.cyclePoints;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isViewed() {
        return this.viewed;
    }

    @Deprecated(forRemoval = true)
    public BattlePassManager() {
    }

    public BattlePassManager(Player player) {
        super(player);
        this.ownerUid = player.getUid();
    }

    @Override // emu.grasscutter.game.player.BasePlayerDataManager
    public void setPlayer(Player player) {
        this.player = player;
        this.ownerUid = player.getUid();
    }

    public void updateViewed() {
        this.viewed = true;
    }

    public boolean setLevel(int level) {
        if (level < 0 || level > 50) {
            return false;
        }
        this.level = level;
        this.point = 0;
        this.player.sendPacket(new PacketBattlePassCurScheduleUpdateNotify(this.player));
        return true;
    }

    public void addPoints(int points) {
        addPointsDirectly(points, false);
        this.player.sendPacket(new PacketBattlePassCurScheduleUpdateNotify(this.player));
        save();
    }

    public void addPointsDirectly(int points, boolean isWeekly) {
        int amount = points;
        if (isWeekly) {
            amount = Math.min(amount, 10000 - this.cyclePoints);
        }
        if (amount > 0) {
            this.point += amount;
            this.cyclePoints += amount;
            if (this.point >= 1000 && getLevel() < 50) {
                int levelups = Math.floorDiv(this.point, 1000);
                int levelups2 = Math.min(levelups, 50 - levelups);
                this.point -= levelups2 * 1000;
                this.level += levelups2;
            }
        }
    }

    public Map<Integer, BattlePassMission> getMissions() {
        if (this.missions == null) {
            this.missions = new HashMap();
        }
        return this.missions;
    }

    public BattlePassMission loadMissionById(int id) {
        return getMissions().computeIfAbsent(Integer.valueOf(id), i -> {
            return new BattlePassMission(i.intValue());
        });
    }

    public boolean hasMission(int id) {
        return getMissions().containsKey(Integer.valueOf(id));
    }

    public boolean isPaid() {
        return true;
    }

    public Map<Integer, BattlePassReward> getTakenRewards() {
        if (this.takenRewards == null) {
            this.takenRewards = new HashMap();
        }
        return this.takenRewards;
    }

    public void triggerMission(WatcherTriggerType triggerType) {
        getPlayer().getServer().getBattlePassSystem().triggerMission(getPlayer(), triggerType);
    }

    public void triggerMission(WatcherTriggerType triggerType, int param, int progress) {
        getPlayer().getServer().getBattlePassSystem().triggerMission(getPlayer(), triggerType, param, progress);
    }

    public void takeMissionPoint(List<Integer> missionIdList) {
        if (missionIdList.size() <= GameData.getBattlePassMissionDataMap().size()) {
            List<BattlePassMission> updatedMissions = new ArrayList<>(missionIdList.size());
            for (Integer num : missionIdList) {
                int id = num.intValue();
                if (hasMission(id)) {
                    BattlePassMission mission = loadMissionById(id);
                    if (mission.getData() == null) {
                        getMissions().remove(Integer.valueOf(mission.getId()));
                    } else if (mission.getStatus() == BattlePassMissionStatus.MISSION_STATUS_FINISHED) {
                        addPointsDirectly(mission.getData().getAddPoint(), mission.getData().isCycleRefresh());
                        mission.setStatus(BattlePassMissionStatus.MISSION_STATUS_POINT_TAKEN);
                        updatedMissions.add(mission);
                    }
                }
            }
            if (updatedMissions.size() > 0) {
                save();
                getPlayer().sendPacket(new PacketBattlePassMissionUpdateNotify(updatedMissions));
                getPlayer().sendPacket(new PacketBattlePassCurScheduleUpdateNotify(getPlayer()));
            }
        }
    }

    public void takeReward(List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> takeOptionList) {
        List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> rewardList = new ArrayList<>();
        for (BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption option : takeOptionList) {
            if (option.getTag().getRewardId() != 0 && !getTakenRewards().containsKey(Integer.valueOf(option.getTag().getRewardId())) && option.getTag().getLevel() <= getLevel()) {
                BattlePassRewardData rewardData = GameData.getBattlePassRewardDataMap().get(200 + option.getTag().getLevel());
                if (rewardData.getFreeRewardIdList().contains(Integer.valueOf(option.getTag().getRewardId()))) {
                    rewardList.add(option);
                } else if (!isPaid() || !rewardData.getPaidRewardIdList().contains(Integer.valueOf(option.getTag().getRewardId()))) {
                    Grasscutter.getLogger().info("Not in rewards list: {}", Integer.valueOf(option.getTag().getRewardId()));
                } else {
                    rewardList.add(option);
                }
            }
        }
        List<GameItem> rewardItems = null;
        if (rewardList.size() > 0) {
            rewardItems = new ArrayList<>();
            for (BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption option2 : rewardList) {
                BattlePassRewardTagOuterClass.BattlePassRewardTag tag = option2.getTag();
                int index = option2.getOptionIdx();
                RewardData reward = GameData.getRewardDataMap().get(tag.getRewardId());
                if (reward != null) {
                    for (ItemParamData entry : reward.getRewardItemList()) {
                        ItemData rewardItemData = GameData.getItemDataMap().get(entry.getItemId());
                        if (rewardItemData.getMaterialType() == MaterialType.MATERIAL_SELECTABLE_CHEST) {
                            takeRewardsFromSelectChest(rewardItemData, index, entry, rewardItems);
                        } else {
                            rewardItems.add(new GameItem(rewardItemData, entry.getItemCount()));
                        }
                    }
                    BattlePassReward bpReward = new BattlePassReward(tag.getLevel(), tag.getRewardId(), tag.getUnlockStatus() == BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.BATTLE_PASS_UNLOCK_STATUS_PAID);
                    getTakenRewards().put(Integer.valueOf(bpReward.getRewardId()), bpReward);
                }
            }
            save();
            getPlayer().getInventory().addItems(rewardItems);
            getPlayer().sendPacket(new PacketBattlePassCurScheduleUpdateNotify(getPlayer()));
        }
        getPlayer().sendPacket(new PacketTakeBattlePassRewardRsp(takeOptionList, rewardItems));
    }

    public int buyLevels(int buyLevel) {
        int boughtLevels = Math.min(buyLevel, 50 - buyLevel);
        if (boughtLevels > 0) {
            if (getPlayer().getPrimogems() < 150 * boughtLevels) {
                return 0;
            }
            this.level += boughtLevels;
            save();
            getPlayer().sendPacket(new PacketBattlePassCurScheduleUpdateNotify(getPlayer()));
        }
        return boughtLevels;
    }

    public void resetDailyMissions() {
        ArrayList<BattlePassMission> resetMissions = new ArrayList<>();
        for (BattlePassMission mission : this.missions.values()) {
            if (mission.getData().getRefreshType() == null || mission.getData().getRefreshType() == BattlePassMissionRefreshType.BATTLE_PASS_MISSION_REFRESH_DAILY) {
                mission.setStatus(BattlePassMissionStatus.MISSION_STATUS_UNFINISHED);
                mission.setProgress(0);
                resetMissions.add(mission);
            }
        }
        getPlayer().sendPacket(new PacketBattlePassMissionUpdateNotify(resetMissions));
        getPlayer().sendPacket(new PacketBattlePassCurScheduleUpdateNotify(getPlayer()));
    }

    public void resetWeeklyMissions() {
        ArrayList<BattlePassMission> resetMissions = new ArrayList<>();
        for (BattlePassMission mission : this.missions.values()) {
            if (mission.getData().getRefreshType() == BattlePassMissionRefreshType.BATTLE_PASS_MISSION_REFRESH_CYCLE_CROSS_SCHEDULE) {
                mission.setStatus(BattlePassMissionStatus.MISSION_STATUS_UNFINISHED);
                mission.setProgress(0);
                resetMissions.add(mission);
            }
        }
        getPlayer().sendPacket(new PacketBattlePassMissionUpdateNotify(resetMissions));
        getPlayer().sendPacket(new PacketBattlePassCurScheduleUpdateNotify(getPlayer()));
    }

    public BattlePassScheduleOuterClass.BattlePassSchedule getScheduleProto() {
        LocalDate nextSundayDate;
        BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus battlePassUnlockStatus;
        LocalDate currentDate = LocalDate.now();
        if (currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            nextSundayDate = currentDate;
        } else {
            nextSundayDate = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        }
        LocalDateTime nextSundayTime = LocalDateTime.of(nextSundayDate.getYear(), nextSundayDate.getMonthValue(), nextSundayDate.getDayOfMonth(), 23, 59, 59);
        BattlePassScheduleOuterClass.BattlePassSchedule.Builder isViewed = BattlePassScheduleOuterClass.BattlePassSchedule.newBuilder().setScheduleId(2700).setLevel(getLevel()).setPoint(getPoint()).setBeginTime(0).setEndTime(2059483200).setIsViewed(isViewed());
        if (isPaid()) {
            battlePassUnlockStatus = BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.BATTLE_PASS_UNLOCK_STATUS_PAID;
        } else {
            battlePassUnlockStatus = BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.BATTLE_PASS_UNLOCK_STATUS_FREE;
        }
        BattlePassScheduleOuterClass.BattlePassSchedule.Builder schedule = isViewed.setUnlockStatus(battlePassUnlockStatus).setPaidPlatformFlags(2).setCurCyclePoints(getCyclePoints()).setCurCycle(BattlePassCycleOuterClass.BattlePassCycle.newBuilder().setBeginTime(0).setEndTime((int) nextSundayTime.atZone(ZoneId.systemDefault()).toEpochSecond()).setCycleIdx(3));
        for (BattlePassReward reward : getTakenRewards().values()) {
            schedule.addRewardTakenList(reward.toProto());
        }
        return schedule.build();
    }

    public void save() {
        DatabaseHelper.saveBattlePass(this);
    }
}
