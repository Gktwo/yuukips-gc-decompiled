package emu.grasscutter.game.activity;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Transient;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.ActivityWatcherData;
import emu.grasscutter.data.excels.RewardData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.net.proto.ActivityWatcherInfoOuterClass;
import emu.grasscutter.server.packet.send.PacketActivityUpdateWatcherNotify;
import emu.grasscutter.utils.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Entity("activities")
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/PlayerActivityData.class */
public class PlayerActivityData {
    @AbstractC1283Id

    /* renamed from: id */
    private String f560id;
    private int uid;
    private int activityId;
    private Map<Integer, WatcherInfo> watcherInfoMap;
    private String detail;
    @Transient
    private Player player;
    @Transient
    private ActivityHandler activityHandler;

    /*  JADX ERROR: Dependency scan failed at insn: 0x001C: INVOKE_CUSTOM r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x001C: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, method: emu.grasscutter.game.activity.PlayerActivityData.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, Ljava/util/Map;, Ljava/lang/String;, Lemu/grasscutter/game/player/Player;, Lemu/grasscutter/game/activity/ActivityHandler;)Ljava/lang/String;}, PlayerActivityData(id=, uid=, activityId=, watcherInfoMap=, detail=, player=, activityHandler=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, Ljava/util/Map;, Ljava/lang/String;, Lemu/grasscutter/game/player/Player;, Lemu/grasscutter/game/activity/ActivityHandler;)Ljava/lang/String;}, PlayerActivityData(id=, uid=, activityId=, watcherInfoMap=, detail=, player=, activityHandler=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r8 = this;
            r0 = r8
            java.lang.String r0 = r0.getId()
            r1 = r8
            int r1 = r1.getUid()
            r2 = r8
            int r2 = r2.getActivityId()
            r3 = r8
            java.util.Map r3 = r3.getWatcherInfoMap()
            r4 = r8
            java.lang.String r4 = r4.getDetail()
            r5 = r8
            emu.grasscutter.game.player.Player r5 = r5.getPlayer()
            r6 = r8
            emu.grasscutter.game.activity.ActivityHandler r6 = r6.getActivityHandler()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, Ljava/util/Map;, Ljava/lang/String;, Lemu/grasscutter/game/player/Player;, Lemu/grasscutter/game/activity/ActivityHandler;)Ljava/lang/String;}, PlayerActivityData(id=, uid=, activityId=, watcherInfoMap=, detail=, player=, activityHandler=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.PlayerActivityData.toString():java.lang.String");
    }

    public void setId(String id) {
        this.f560id = id;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public void setWatcherInfoMap(Map<Integer, WatcherInfo> watcherInfoMap) {
        this.watcherInfoMap = watcherInfoMap;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setActivityHandler(ActivityHandler activityHandler) {
        this.activityHandler = activityHandler;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PlayerActivityData)) {
            return false;
        }
        PlayerActivityData other = (PlayerActivityData) o;
        if (!other.canEqual(this) || getUid() != other.getUid() || getActivityId() != other.getActivityId()) {
            return false;
        }
        Object this$id = getId();
        Object other$id = other.getId();
        if (this$id == null) {
            if (other$id != null) {
                return false;
            }
        } else if (!this$id.equals(other$id)) {
            return false;
        }
        Object this$watcherInfoMap = getWatcherInfoMap();
        Object other$watcherInfoMap = other.getWatcherInfoMap();
        if (this$watcherInfoMap == null) {
            if (other$watcherInfoMap != null) {
                return false;
            }
        } else if (!this$watcherInfoMap.equals(other$watcherInfoMap)) {
            return false;
        }
        Object this$detail = getDetail();
        Object other$detail = other.getDetail();
        if (this$detail == null) {
            if (other$detail != null) {
                return false;
            }
        } else if (!this$detail.equals(other$detail)) {
            return false;
        }
        Object this$player = getPlayer();
        Object other$player = other.getPlayer();
        if (this$player == null) {
            if (other$player != null) {
                return false;
            }
        } else if (!this$player.equals(other$player)) {
            return false;
        }
        Object this$activityHandler = getActivityHandler();
        Object other$activityHandler = other.getActivityHandler();
        return this$activityHandler == null ? other$activityHandler == null : this$activityHandler.equals(other$activityHandler);
    }

    protected boolean canEqual(Object other) {
        return other instanceof PlayerActivityData;
    }

    public int hashCode() {
        int result = (((1 * 59) + getUid()) * 59) + getActivityId();
        Object $id = getId();
        int result2 = (result * 59) + ($id == null ? 43 : $id.hashCode());
        Object $watcherInfoMap = getWatcherInfoMap();
        int result3 = (result2 * 59) + ($watcherInfoMap == null ? 43 : $watcherInfoMap.hashCode());
        Object $detail = getDetail();
        int result4 = (result3 * 59) + ($detail == null ? 43 : $detail.hashCode());
        Object $player = getPlayer();
        int result5 = (result4 * 59) + ($player == null ? 43 : $player.hashCode());
        Object $activityHandler = getActivityHandler();
        return (result5 * 59) + ($activityHandler == null ? 43 : $activityHandler.hashCode());
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/activity/PlayerActivityData$PlayerActivityDataBuilder.class */
    public static class PlayerActivityDataBuilder {

        /* renamed from: id */
        private String f561id;
        private int uid;
        private int activityId;
        private Map<Integer, WatcherInfo> watcherInfoMap;
        private String detail;
        private Player player;
        private ActivityHandler activityHandler;

        /*  JADX ERROR: Dependency scan failed at insn: 0x001C: INVOKE_CUSTOM r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x001C: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, method: emu.grasscutter.game.activity.PlayerActivityData.PlayerActivityDataBuilder.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, Ljava/util/Map;, Ljava/lang/String;, Lemu/grasscutter/game/player/Player;, Lemu/grasscutter/game/activity/ActivityHandler;)Ljava/lang/String;}, PlayerActivityData.PlayerActivityDataBuilder(id=, uid=, activityId=, watcherInfoMap=, detail=, player=, activityHandler=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, Ljava/util/Map;, Ljava/lang/String;, Lemu/grasscutter/game/player/Player;, Lemu/grasscutter/game/activity/ActivityHandler;)Ljava/lang/String;}, PlayerActivityData.PlayerActivityDataBuilder(id=, uid=, activityId=, watcherInfoMap=, detail=, player=, activityHandler=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r8 = this;
                r0 = r8
                java.lang.String r0 = r0.f561id
                r1 = r8
                int r1 = r1.uid
                r2 = r8
                int r2 = r2.activityId
                r3 = r8
                java.util.Map<java.lang.Integer, emu.grasscutter.game.activity.PlayerActivityData$WatcherInfo> r3 = r3.watcherInfoMap
                r4 = r8
                java.lang.String r4 = r4.detail
                r5 = r8
                emu.grasscutter.game.player.Player r5 = r5.player
                r6 = r8
                emu.grasscutter.game.activity.ActivityHandler r6 = r6.activityHandler
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, Ljava/util/Map;, Ljava/lang/String;, Lemu/grasscutter/game/player/Player;, Lemu/grasscutter/game/activity/ActivityHandler;)Ljava/lang/String;}, PlayerActivityData.PlayerActivityDataBuilder(id=, uid=, activityId=, watcherInfoMap=, detail=, player=, activityHandler=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.PlayerActivityData.PlayerActivityDataBuilder.toString():java.lang.String");
        }

        PlayerActivityDataBuilder() {
        }

        /* renamed from: id */
        public PlayerActivityDataBuilder m1212id(String id) {
            this.f561id = id;
            return this;
        }

        public PlayerActivityDataBuilder uid(int uid) {
            this.uid = uid;
            return this;
        }

        public PlayerActivityDataBuilder activityId(int activityId) {
            this.activityId = activityId;
            return this;
        }

        public PlayerActivityDataBuilder watcherInfoMap(Map<Integer, WatcherInfo> watcherInfoMap) {
            this.watcherInfoMap = watcherInfoMap;
            return this;
        }

        public PlayerActivityDataBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public PlayerActivityDataBuilder player(Player player) {
            this.player = player;
            return this;
        }

        public PlayerActivityDataBuilder activityHandler(ActivityHandler activityHandler) {
            this.activityHandler = activityHandler;
            return this;
        }

        public PlayerActivityData build() {
            return new PlayerActivityData(this.f561id, this.uid, this.activityId, this.watcherInfoMap, this.detail, this.player, this.activityHandler);
        }
    }

    PlayerActivityData(String id, int uid, int activityId, Map<Integer, WatcherInfo> watcherInfoMap, String detail, Player player, ActivityHandler activityHandler) {
        this.f560id = id;
        this.uid = uid;
        this.activityId = activityId;
        this.watcherInfoMap = watcherInfoMap;
        this.detail = detail;
        this.player = player;
        this.activityHandler = activityHandler;
    }

    /* renamed from: of */
    public static PlayerActivityDataBuilder m1213of() {
        return new PlayerActivityDataBuilder();
    }

    public String getId() {
        return this.f560id;
    }

    public int getUid() {
        return this.uid;
    }

    public int getActivityId() {
        return this.activityId;
    }

    public Map<Integer, WatcherInfo> getWatcherInfoMap() {
        return this.watcherInfoMap;
    }

    public String getDetail() {
        return this.detail;
    }

    public Player getPlayer() {
        return this.player;
    }

    public ActivityHandler getActivityHandler() {
        return this.activityHandler;
    }

    public void save() {
        DatabaseHelper.savePlayerActivityData(this);
    }

    public static PlayerActivityData getByPlayer(Player player, int activityId) {
        return DatabaseHelper.getPlayerActivityData(player.getUid(), activityId);
    }

    public synchronized void addWatcherProgress(int watcherId) {
        WatcherInfo watcherInfo = this.watcherInfoMap.get(Integer.valueOf(watcherId));
        if (watcherInfo != null && watcherInfo.curProgress < watcherInfo.totalProgress) {
            watcherInfo.curProgress++;
            getPlayer().sendPacket(new PacketActivityUpdateWatcherNotify(this.activityId, watcherInfo));
        }
    }

    public List<ActivityWatcherInfoOuterClass.ActivityWatcherInfo> getAllWatcherInfoList() {
        return this.watcherInfoMap.values().stream().map((v0) -> {
            return v0.toProto();
        }).toList();
    }

    public void setDetail(Object detail) {
        this.detail = JsonUtils.encode(detail);
    }

    public void takeWatcherReward(int watcherId) {
        WatcherInfo watcher = this.watcherInfoMap.get(Integer.valueOf(watcherId));
        if (!(watcher == null || watcher.isTakenReward())) {
            Optional<RewardData> reward = Optional.of(watcher).map((v0) -> {
                return v0.getMetadata();
            }).map((v0) -> {
                return v0.getRewardID();
            }).map(id -> {
                return GameData.getRewardDataMap().get(id.intValue());
            });
            if (!reward.isEmpty()) {
                List<GameItem> rewards = new ArrayList<>();
                for (ItemParamData param : reward.get().getRewardItemList()) {
                    rewards.add(new GameItem(param.getId(), Math.max(param.getCount(), 1)));
                }
                this.player.getInventory().addItems(rewards, ActionReason.ActivityWatcher);
                watcher.setTakenReward(true);
                save();
            }
        }
    }

    @Entity
    /* loaded from: grasscutter.jar:emu/grasscutter/game/activity/PlayerActivityData$WatcherInfo.class */
    public static class WatcherInfo {
        private int watcherId;
        private int totalProgress;
        private int curProgress;
        private boolean isTakenReward;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0010: INVOKE_CUSTOM r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0010: INVOKE_CUSTOM r0, r1, r2, r3, method: emu.grasscutter.game.activity.PlayerActivityData.WatcherInfo.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Z)Ljava/lang/String;}, PlayerActivityData.WatcherInfo(watcherId=, totalProgress=, curProgress=, isTakenReward=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Z)Ljava/lang/String;}, PlayerActivityData.WatcherInfo(watcherId=, totalProgress=, curProgress=, isTakenReward=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r5 = this;
                r0 = r5
                int r0 = r0.getWatcherId()
                r1 = r5
                int r1 = r1.getTotalProgress()
                r2 = r5
                int r2 = r2.getCurProgress()
                r3 = r5
                boolean r3 = r3.isTakenReward()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Z)Ljava/lang/String;}, PlayerActivityData.WatcherInfo(watcherId=, totalProgress=, curProgress=, isTakenReward=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.PlayerActivityData.WatcherInfo.toString():java.lang.String");
        }

        public void setWatcherId(int watcherId) {
            this.watcherId = watcherId;
        }

        public void setTotalProgress(int totalProgress) {
            this.totalProgress = totalProgress;
        }

        public void setCurProgress(int curProgress) {
            this.curProgress = curProgress;
        }

        public void setTakenReward(boolean isTakenReward) {
            this.isTakenReward = isTakenReward;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof WatcherInfo)) {
                return false;
            }
            WatcherInfo other = (WatcherInfo) o;
            return other.canEqual(this) && getWatcherId() == other.getWatcherId() && getTotalProgress() == other.getTotalProgress() && getCurProgress() == other.getCurProgress() && isTakenReward() == other.isTakenReward();
        }

        protected boolean canEqual(Object other) {
            return other instanceof WatcherInfo;
        }

        public int hashCode() {
            return (((((((1 * 59) + getWatcherId()) * 59) + getTotalProgress()) * 59) + getCurProgress()) * 59) + (isTakenReward() ? 79 : 97);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/game/activity/PlayerActivityData$WatcherInfo$WatcherInfoBuilder.class */
        public static class WatcherInfoBuilder {
            private int watcherId;
            private int totalProgress;
            private int curProgress;
            private boolean isTakenReward;

            /*  JADX ERROR: Dependency scan failed at insn: 0x0010: INVOKE_CUSTOM r-4, r-3, r-2, r-1
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
            /*  JADX ERROR: Failed to decode insn: 0x0010: INVOKE_CUSTOM r0, r1, r2, r3, method: emu.grasscutter.game.activity.PlayerActivityData.WatcherInfo.WatcherInfoBuilder.toString():java.lang.String
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Z)Ljava/lang/String;}, PlayerActivityData.WatcherInfo.WatcherInfoBuilder(watcherId=, totalProgress=, curProgress=, isTakenReward=)]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Z)Ljava/lang/String;}, PlayerActivityData.WatcherInfo.WatcherInfoBuilder(watcherId=, totalProgress=, curProgress=, isTakenReward=)]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            public java.lang.String toString() {
                /*
                    r5 = this;
                    r0 = r5
                    int r0 = r0.watcherId
                    r1 = r5
                    int r1 = r1.totalProgress
                    r2 = r5
                    int r2 = r2.curProgress
                    r3 = r5
                    boolean r3 = r3.isTakenReward
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Z)Ljava/lang/String;}, PlayerActivityData.WatcherInfo.WatcherInfoBuilder(watcherId=, totalProgress=, curProgress=, isTakenReward=)]}
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.PlayerActivityData.WatcherInfo.WatcherInfoBuilder.toString():java.lang.String");
            }

            WatcherInfoBuilder() {
            }

            public WatcherInfoBuilder watcherId(int watcherId) {
                this.watcherId = watcherId;
                return this;
            }

            public WatcherInfoBuilder totalProgress(int totalProgress) {
                this.totalProgress = totalProgress;
                return this;
            }

            public WatcherInfoBuilder curProgress(int curProgress) {
                this.curProgress = curProgress;
                return this;
            }

            public WatcherInfoBuilder isTakenReward(boolean isTakenReward) {
                this.isTakenReward = isTakenReward;
                return this;
            }

            public WatcherInfo build() {
                return new WatcherInfo(this.watcherId, this.totalProgress, this.curProgress, this.isTakenReward);
            }
        }

        WatcherInfo(int watcherId, int totalProgress, int curProgress, boolean isTakenReward) {
            this.watcherId = watcherId;
            this.totalProgress = totalProgress;
            this.curProgress = curProgress;
            this.isTakenReward = isTakenReward;
        }

        /* renamed from: of */
        public static WatcherInfoBuilder m1211of() {
            return new WatcherInfoBuilder();
        }

        public int getWatcherId() {
            return this.watcherId;
        }

        public int getTotalProgress() {
            return this.totalProgress;
        }

        public int getCurProgress() {
            return this.curProgress;
        }

        public boolean isTakenReward() {
            return this.isTakenReward;
        }

        public ActivityWatcherData getMetadata() {
            return GameData.getActivityWatcherDataMap().get(this.watcherId);
        }

        public static WatcherInfo init(ActivityWatcher watcher) {
            return m1211of().watcherId(watcher.getWatcherId()).totalProgress(watcher.getActivityWatcherData().getProgress()).isTakenReward(false).build();
        }

        public ActivityWatcherInfoOuterClass.ActivityWatcherInfo toProto() {
            return ActivityWatcherInfoOuterClass.ActivityWatcherInfo.newBuilder().setWatcherId(this.watcherId).setCurProgress(this.curProgress).setTotalProgress(this.totalProgress).setIsTakenReward(this.isTakenReward).build();
        }
    }
}
