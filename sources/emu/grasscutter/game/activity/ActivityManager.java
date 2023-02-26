package emu.grasscutter.game.activity;

import emu.grasscutter.data.GameData;
import emu.grasscutter.game.activity.condition.ActivityConditionExecutor;
import emu.grasscutter.game.activity.condition.AllActivityConditionBuilder;
import emu.grasscutter.game.activity.condition.BasicActivityConditionExecutor;
import emu.grasscutter.game.activity.condition.PlayerActivityDataMappingBuilder;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActivityType;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import emu.grasscutter.server.packet.send.PacketActivityScheduleInfoNotify;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/ActivityManager.class */
public class ActivityManager extends BasePlayerManager {
    private static final Map<Integer, ActivityConfigItem> activityConfigItemMap = new HashMap();
    private static final Map<Integer, ActivityConfigItem> scheduleActivityConfigMap = new HashMap();
    private final Map<Integer, PlayerActivityData> playerActivityDataMap = new ConcurrentHashMap();
    private final ActivityConditionExecutor conditionExecutor = new BasicActivityConditionExecutor(activityConfigItemMap, GameData.getActivityCondExcelConfigDataMap(), PlayerActivityDataMappingBuilder.buildPlayerActivityDataByActivityCondId(this.playerActivityDataMap), AllActivityConditionBuilder.buildActivityConditions());

    /*  JADX ERROR: Dependency scan failed at insn: 0x0064: INVOKE_CUSTOM r-7
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
    /*  JADX ERROR: Failed to decode insn: 0x0064: INVOKE_CUSTOM r0, method: emu.grasscutter.game.activity.ActivityManager.loadActivityConfigData():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, api/genshin/event]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, api/genshin/event]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void loadActivityConfigData() {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r1 = r0
            r1.<init>()
            r5 = r0
            java.util.HashMap r0 = new java.util.HashMap
            r1 = r0
            r1.<init>()
            r6 = r0
            org.reflections.Reflections r0 = new org.reflections.Reflections
            r1 = r0
            java.lang.Class<emu.grasscutter.game.activity.ActivityManager> r2 = emu.grasscutter.game.activity.ActivityManager.class
            java.lang.Package r2 = r2.getPackage()
            java.lang.String r2 = r2.getName()
            r3 = 0
            org.reflections.scanners.Scanner[] r3 = new org.reflections.scanners.Scanner[r3]
            r1.<init>(r2, r3)
            r7 = r0
            r0 = r7
            java.lang.Class<emu.grasscutter.game.activity.ActivityHandler> r1 = emu.grasscutter.game.activity.ActivityHandler.class
            java.util.Set r0 = r0.getSubTypesOf(r1)
            r1 = r5
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$loadActivityConfigData$0(r1, v1);
            }
            r0.forEach(r1)
            r0 = r7
            java.lang.Class<emu.grasscutter.game.activity.ActivityWatcher> r1 = emu.grasscutter.game.activity.ActivityWatcher.class
            java.util.Set r0 = r0.getSubTypesOf(r1)
            r1 = r6
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$loadActivityConfigData$1(r1, v1);
            }
            r0.forEach(r1)
            java.lang.String r0 = ""
            r8 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r9 = r0
            emu.grasscutter.config.ConfigContainer$HTTP r0 = emu.grasscutter.config.Configuration.HTTP_INFO
            java.lang.String r0 = r0.APICloud
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x006d
            emu.grasscutter.config.ConfigContainer$HTTP r0 = emu.grasscutter.config.Configuration.HTTP_INFO
            java.lang.String r0 = r0.APICloud
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, api/genshin/event]}
            java.lang.String r0 = emu.grasscutter.utils.Utils.curl(r0)
            r8 = r0
            r0 = r8
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0087
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Event loaded from cloud"
            r0.info(r1)
            r0 = r8
            java.lang.Class<emu.grasscutter.game.activity.ActivityConfigItem> r1 = emu.grasscutter.game.activity.ActivityConfigItem.class
            java.util.List r0 = emu.grasscutter.utils.JsonUtils.decodeList(r0, r1)
            r9 = r0
            goto L_0x0098
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Event loaded from local data"
            r0.info(r1)
            java.lang.String r0 = "ActivityConfig.json"
            java.lang.Class<emu.grasscutter.game.activity.ActivityConfigItem> r1 = emu.grasscutter.game.activity.ActivityConfigItem.class
            java.util.List r0 = emu.grasscutter.data.DataLoader.loadList(r0, r1)
            r9 = r0
            r0 = r9
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00c3
            r0 = r9
            r1 = r5
            r2 = r6
            void r1 = (v2) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$loadActivityConfigData$2(r1, r2, v2);
            }
            r0.forEach(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Enable {} activities."
            java.util.Map<java.lang.Integer, emu.grasscutter.game.activity.ActivityConfigItem> r2 = emu.grasscutter.game.activity.ActivityManager.activityConfigItemMap
            int r2 = r2.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.info(r1, r2)
            goto L_0x00d0
            r8 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Unable to load activities config."
            r2 = r8
            r0.error(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.ActivityManager.loadActivityConfigData():void");
    }

    public static Map<Integer, ActivityConfigItem> getScheduleActivityConfigMap() {
        return scheduleActivityConfigMap;
    }

    public Map<Integer, PlayerActivityData> getPlayerActivityDataMap() {
        return this.playerActivityDataMap;
    }

    public ActivityConditionExecutor getConditionExecutor() {
        return this.conditionExecutor;
    }

    static {
        loadActivityConfigData();
    }

    public ActivityManager(Player player) {
        super(player);
        activityConfigItemMap.values().forEach(item -> {
            PlayerActivityData data = PlayerActivityData.getByPlayer(player, player.getActivityId());
            if (data == null) {
                data = player.getActivityHandler().initPlayerActivityData(player);
                data.save();
            }
            data.setPlayer(player);
            data.setActivityHandler(player.getActivityHandler());
            this.playerActivityDataMap.put(Integer.valueOf(player.getActivityId()), data);
        });
        player.sendPacket(new PacketActivityScheduleInfoNotify(activityConfigItemMap.values()));
    }

    public void triggerWatcher(WatcherTriggerType watcherTriggerType, String... params) {
        activityConfigItemMap.values().stream().map((v0) -> {
            return v0.getActivityHandler();
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).map((v0) -> {
            return v0.getWatchersMap();
        }).map(map -> {
            return (List) map.get(watcherTriggerType);
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).flatMap((v0) -> {
            return v0.stream();
        }).toList().forEach(watcher -> {
            params.trigger(this.playerActivityDataMap.get(Integer.valueOf(params.getActivityHandler().getActivityConfigItem().getActivityId())), params);
        });
    }

    public boolean isActivityActive(int activityId) {
        ActivityConfigItem activityConfig = activityConfigItemMap.get(Integer.valueOf(activityId));
        if (activityConfig == null) {
            return false;
        }
        Date now = new Date();
        return now.after(new Date((long) activityConfig.getBeginTime())) && now.before(new Date((long) activityConfig.getEndTime()));
    }

    public boolean hasActivityEnded(int activityId) {
        ActivityConfigItem activityConfig = activityConfigItemMap.get(Integer.valueOf(activityId));
        if (activityConfig == null) {
            return true;
        }
        return new Date().after(new Date((long) activityConfig.getEndTime()));
    }

    public boolean meetsCondition(int activityCondId) {
        return this.conditionExecutor.meetsCondition(activityCondId);
    }

    public ActivityInfoOuterClass.ActivityInfo getInfoProtoByActivityId(int activityId) {
        return activityConfigItemMap.get(Integer.valueOf(activityId)).getActivityHandler().toProto(this.playerActivityDataMap.get(Integer.valueOf(activityId)), this.conditionExecutor);
    }

    public Optional<ActivityHandler> getActivityHandler(ActivityType type) {
        return activityConfigItemMap.values().stream().map((v0) -> {
            return v0.getActivityHandler();
        }).filter(x -> {
            return type == ((GameActivity) x.getClass().getAnnotation(GameActivity.class)).value();
        }).findFirst();
    }

    public <T extends ActivityHandler> Optional<T> getActivityHandlerAs(ActivityType type, Class<T> clazz) {
        return (Optional<T>) getActivityHandler(type).map(x -> {
            return x;
        });
    }

    public Optional<Integer> getActivityIdByActivityType(ActivityType type) {
        return getActivityHandler(type).map((v0) -> {
            return v0.getActivityConfigItem();
        }).map((v0) -> {
            return v0.getActivityId();
        });
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.Optional<U>, java.util.Optional<emu.grasscutter.game.activity.PlayerActivityData> */
    public Optional<PlayerActivityData> getPlayerActivityDataByActivityType(ActivityType type) {
        Optional<Integer> activityIdByActivityType = getActivityIdByActivityType(type);
        Map<Integer, PlayerActivityData> map = this.playerActivityDataMap;
        Objects.requireNonNull(map);
        return activityIdByActivityType.map((v1) -> {
            return r1.get(v1);
        });
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.Optional<U>, java.util.Optional<emu.grasscutter.net.proto.ActivityInfoOuterClass$ActivityInfo> */
    public Optional<ActivityInfoOuterClass.ActivityInfo> getInfoProtoByActivityType(ActivityType type) {
        return getActivityIdByActivityType(type).map(arg0 -> {
            return getInfoProtoByActivityId(arg0.intValue());
        });
    }
}
