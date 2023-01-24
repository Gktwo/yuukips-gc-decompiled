package emu.grasscutter.scripts;

import com.github.davidmoten.rtreemulti.RTree;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.MonsterData;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.EntityMonster;
import emu.grasscutter.game.entity.EntityRegion;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.props.EntityType;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.VisionTypeOuterClass;
import emu.grasscutter.scripts.data.SceneBlock;
import emu.grasscutter.scripts.data.SceneConfig;
import emu.grasscutter.scripts.data.SceneGadget;
import emu.grasscutter.scripts.data.SceneGroup;
import emu.grasscutter.scripts.data.SceneMeta;
import emu.grasscutter.scripts.data.SceneMonster;
import emu.grasscutter.scripts.data.SceneRegion;
import emu.grasscutter.scripts.data.SceneSuite;
import emu.grasscutter.scripts.data.SceneTrigger;
import emu.grasscutter.scripts.data.ScriptArgs;
import emu.grasscutter.scripts.service.ScriptMonsterSpawnService;
import emu.grasscutter.scripts.service.ScriptMonsterTideService;
import emu.grasscutter.utils.Position;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import kotlin.Pair;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import p013io.netty.util.concurrent.FastThreadLocalThread;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/SceneScriptManager.class */
public class SceneScriptManager {
    private final Scene scene;
    private SceneMeta meta;
    private boolean isInit;
    private ScriptMonsterTideService scriptMonsterTideService;
    public static final ExecutorService eventExecutor = new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(1000), FastThreadLocalThread::new, new ThreadPoolExecutor.AbortPolicy());
    private final Map<Integer, Set<SceneTrigger>> currentTriggers = new ConcurrentHashMap();
    private final Map<String, Set<SceneTrigger>> triggersByGroupScene = new ConcurrentHashMap();
    private final Map<Integer, Set<Pair<String, Integer>>> activeGroupTimers = new ConcurrentHashMap();
    private final Map<Integer, EntityRegion> regions = new ConcurrentHashMap();
    private final Map<String, Integer> variables = new ConcurrentHashMap();
    private final Map<Integer, SceneGroup> sceneGroups = new ConcurrentHashMap();
    private ScriptMonsterSpawnService scriptMonsterSpawnService = new ScriptMonsterSpawnService(this);
    private final Map<Integer, Set<SceneGroup>> loadedGroupSetPerBlock = new ConcurrentHashMap();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0014: INVOKE_CUSTOM r-3, r-2
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x00DF: INVOKE_CUSTOM r-11, r-10
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
    /*  JADX ERROR: Failed to decode insn: 0x0014: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.scripts.SceneScriptManager.resetTriggersForGroupSuite(emu.grasscutter.scripts.data.SceneGroup, int):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, _]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, _]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x00DF: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.scripts.SceneScriptManager.resetTriggersForGroupSuite(emu.grasscutter.scripts.data.SceneGroup, int):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, _]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, _]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void resetTriggersForGroupSuite(emu.grasscutter.scripts.data.SceneGroup r5, int r6) {
        /*
            r4 = this;
            r0 = r5
            r1 = r6
            emu.grasscutter.scripts.data.SceneSuite r0 = r0.getSuiteByIndex(r1)
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L_0x000b
            return
            r0 = r4
            java.util.Map<java.lang.String, java.util.Set<emu.grasscutter.scripts.data.SceneTrigger>> r0 = r0.triggersByGroupScene
            r1 = r5
            int r1 = r1.f957id
            r2 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, _]}
            java.lang.Object r0 = r0.get(r1)
            java.util.Set r0 = (java.util.Set) r0
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L_0x0031
            java.util.HashSet r0 = new java.util.HashSet
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0096
            r0 = r8
            java.util.Iterator r0 = r0.iterator()
            r9 = r0
            r0 = r9
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x008f
            r0 = r9
            java.lang.Object r0 = r0.next()
            emu.grasscutter.scripts.data.SceneTrigger r0 = (emu.grasscutter.scripts.data.SceneTrigger) r0
            r10 = r0
            r0 = r4
            java.util.Map<java.lang.Integer, java.util.Set<emu.grasscutter.scripts.data.SceneTrigger>> r0 = r0.currentTriggers
            if (r0 != 0) goto L_0x0064
            goto L_0x0044
            r0 = r4
            java.util.Map<java.lang.Integer, java.util.Set<emu.grasscutter.scripts.data.SceneTrigger>> r0 = r0.currentTriggers
            r1 = r10
            int r1 = r1.event
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            java.util.Set r0 = (java.util.Set) r0
            r11 = r0
            r0 = r11
            if (r0 != 0) goto L_0x0082
            goto L_0x0044
            r0 = r11
            r1 = r10
            boolean r0 = r0.remove(r1)
            goto L_0x0044
            r0 = r8
            r0.clear()
            r0 = r7
            java.util.List<emu.grasscutter.scripts.data.SceneTrigger> r0 = r0.sceneTriggers
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00d6
            r0 = r8
            r1 = r7
            java.util.List<emu.grasscutter.scripts.data.SceneTrigger> r1 = r1.sceneTriggers
            boolean r0 = r0.addAll(r1)
            r0 = r8
            java.util.Iterator r0 = r0.iterator()
            r9 = r0
            r0 = r9
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00d6
            r0 = r9
            java.lang.Object r0 = r0.next()
            emu.grasscutter.scripts.data.SceneTrigger r0 = (emu.grasscutter.scripts.data.SceneTrigger) r0
            r10 = r0
            r0 = r4
            r1 = r10
            r0.registerTrigger(r1)
            goto L_0x00b7
            r0 = r4
            java.util.Map<java.lang.String, java.util.Set<emu.grasscutter.scripts.data.SceneTrigger>> r0 = r0.triggersByGroupScene
            r1 = r5
            int r1 = r1.f957id
            r2 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, _]}
            r2 = r8
            java.lang.Object r0 = r0.put(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.SceneScriptManager.resetTriggersForGroupSuite(emu.grasscutter.scripts.data.SceneGroup, int):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x016A: INVOKE_CUSTOM r-23
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
    /*  JADX ERROR: Failed to decode insn: 0x016A: INVOKE_CUSTOM r1, method: emu.grasscutter.scripts.SceneScriptManager.handleEventForTrigger(int, emu.grasscutter.scripts.data.ScriptArgs, emu.grasscutter.scripts.data.SceneTrigger):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ! Condition Trigger  triggered exception]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ! Condition Trigger  triggered exception]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private boolean handleEventForTrigger(int r6, emu.grasscutter.scripts.data.ScriptArgs r7, emu.grasscutter.scripts.data.SceneTrigger r8) {
        /*
        // Method dump skipped, instructions count: 395
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.SceneScriptManager.handleEventForTrigger(int, emu.grasscutter.scripts.data.ScriptArgs, emu.grasscutter.scripts.data.SceneTrigger):boolean");
    }

    public SceneScriptManager(Scene scene) {
        this.scene = scene;
        init();
    }

    public Scene getScene() {
        return this.scene;
    }

    public SceneConfig getConfig() {
        if (!this.isInit) {
            return null;
        }
        return this.meta.config;
    }

    public Map<Integer, SceneBlock> getBlocks() {
        return this.meta.blocks;
    }

    public Map<String, Integer> getVariables() {
        return this.variables;
    }

    public Set<SceneTrigger> getTriggersByEvent(int eventId) {
        return this.currentTriggers.computeIfAbsent(Integer.valueOf(eventId), e -> {
            return ConcurrentHashMap.newKeySet();
        });
    }

    public int getTriggerCount() {
        return this.currentTriggers.size();
    }

    public void registerTrigger(List<SceneTrigger> triggers) {
        triggers.forEach(this::registerTrigger);
    }

    public void registerTrigger(SceneTrigger trigger) {
        getTriggersByEvent(trigger.event).add(trigger);
        Grasscutter.getLogger().debug("Registered trigger {}", trigger.name);
    }

    public void deregisterTrigger(List<SceneTrigger> triggers) {
        triggers.forEach(this::deregisterTrigger);
    }

    public void deregisterTrigger(SceneTrigger trigger) {
        getTriggersByEvent(trigger.event).remove(trigger);
    }

    public void resetTriggers(int eventId) {
        this.currentTriggers.put(Integer.valueOf(eventId), ConcurrentHashMap.newKeySet());
    }

    public void refreshGroup(SceneGroup group) {
        if (!(group == null || group.suites == null)) {
            for (int i = 1; i <= group.suites.size(); i++) {
                refreshGroup(group, i);
            }
        }
    }

    public void refreshGroup(SceneGroup group, int suiteIndex) {
        SceneSuite suite;
        if (group != null && (suite = group.getSuiteByIndex(suiteIndex)) != null) {
            resetTriggersForGroupSuite(group, suiteIndex);
            spawnMonstersInGroup(group, suite);
            spawnGadgetsInGroup(group, suite);
        }
    }

    public EntityRegion getRegionById(int id) {
        return this.regions.get(Integer.valueOf(id));
    }

    public void registerRegion(EntityRegion region) {
        this.regions.put(Integer.valueOf(region.getId()), region);
        Grasscutter.getLogger().debug("Registered region {} from group {}", Integer.valueOf(region.getMetaRegion().config_id), Integer.valueOf(region.getGroupId()));
    }

    public void registerRegionInGroupSuite(SceneGroup group, SceneSuite suite) {
        suite.sceneRegions.stream().map(region -> {
            return new EntityRegion(getScene(), region);
        }).forEach(this::registerRegion);
    }

    public synchronized void deregisterRegion(SceneRegion region) {
        this.regions.values().stream().filter(r -> {
            return r.getConfigId() == region.config_id;
        }).findFirst().ifPresent(entityRegion -> {
            this.regions.remove(Integer.valueOf(entityRegion.getId()));
        });
    }

    public Map<Integer, Set<SceneGroup>> getLoadedGroupSetPerBlock() {
        return this.loadedGroupSetPerBlock;
    }

    public SceneGroup getGroupById(int groupId) {
        for (SceneBlock block : getScene().getLoadedBlocks()) {
            SceneGroup group = block.groups.get(Integer.valueOf(groupId));
            if (group != null) {
                if (!group.isLoaded()) {
                    getScene().onLoadGroup(List.of(group));
                }
                return group;
            }
        }
        return null;
    }

    private void init() {
        SceneMeta meta = ScriptLoader.getSceneMeta(getScene().getId());
        if (meta != null) {
            this.meta = meta;
            this.isInit = true;
        }
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void loadBlockFromScript(SceneBlock block) {
        block.load(this.scene.getId(), this.meta.context);
    }

    public void loadGroupFromScript(SceneGroup group) {
        group.load(getScene().getId());
        if (group.variables != null) {
            group.variables.forEach(var -> {
                getVariables().put(var.name, Integer.valueOf(var.value));
            });
        }
        this.sceneGroups.put(Integer.valueOf(group.f957id), group);
    }

    public void checkRegions() {
        if (this.regions.size() != 0) {
            for (EntityRegion region : this.regions.values()) {
                List<GameEntity> entities = getScene().getEntities().values().stream().filter(e -> {
                    return e.getEntityType() == EntityType.Avatar.getValue() && region.getMetaRegion().contains(e.getPosition());
                }).toList();
                Objects.requireNonNull(region);
                entities.forEach(this::addEntity);
                int targetID = 0;
                if (entities.size() > 0) {
                    targetID = entities.get(0).getId();
                }
                if (region.hasNewEntities()) {
                    callEvent(new ScriptArgs(4, region.getConfigId()).setSourceEntityId(region.getId()).setTargetEntityId(targetID));
                    region.resetNewEntities();
                }
                for (Integer num : region.getEntities()) {
                    int entityId = num.intValue();
                    if (getScene().getEntityById(entityId) == null || !region.getMetaRegion().contains(getScene().getEntityById(entityId).getPosition())) {
                        region.removeEntity(entityId);
                    }
                }
                if (region.entityLeave()) {
                    callEvent(new ScriptArgs(5, region.getConfigId()).setSourceEntityId(region.getId()).setTargetEntityId(region.getFirstEntityId()));
                    region.resetNewEntities();
                }
            }
        }
    }

    public List<EntityGadget> getGadgetsInGroupSuite(SceneGroup group, SceneSuite suite) {
        return suite.sceneGadgets.stream().map(g -> {
            return createGadget(group.f957id, group.block_id, group);
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).toList();
    }

    public List<EntityMonster> getMonstersInGroupSuite(SceneGroup group, SceneSuite suite) {
        return suite.sceneMonsters.stream().map(mob -> {
            return createMonster(group.f957id, group.block_id, group);
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).toList();
    }

    public void addGroupSuite(SceneGroup group, SceneSuite suite) {
        registerTrigger(suite.sceneTriggers);
        ArrayList<GameEntity> toCreate = new ArrayList<>();
        toCreate.addAll(getGadgetsInGroupSuite(group, suite));
        toCreate.addAll(getMonstersInGroupSuite(group, suite));
        addEntities(toCreate);
        registerRegionInGroupSuite(group, suite);
    }

    public void removeGroupSuite(SceneGroup group, SceneSuite suite) {
        deregisterTrigger(suite.sceneTriggers);
        removeMonstersInGroup(group, suite);
        removeGadgetsInGroup(group, suite);
        suite.sceneRegions.forEach(this::deregisterRegion);
    }

    public void spawnGadgetsInGroup(SceneGroup group, SceneSuite suite) {
        Collection<SceneGadget> gadgets = group.gadgets.values();
        if (suite != null) {
            gadgets = suite.sceneGadgets;
        }
        addEntities(gadgets.stream().map(g -> {
            return createGadget(group.group.f957id, group.block_id, group);
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).toList());
    }

    public void spawnMonstersInGroup(SceneGroup group, SceneSuite suite) {
        if (suite != null && group.monsters != null && suite.sceneMonsters.size() > 0) {
            addEntities(suite.sceneMonsters.stream().filter(m -> {
                GameEntity entity = this.scene.getEntityByConfigId(group.config_id);
                return entity == null || entity.getGroupId() != group.f957id;
            }).map(mob -> {
                return createMonster(group.f957id, group.block_id, group);
            }).toList());
        }
    }

    public void startMonsterTideInGroup(SceneGroup group, Integer[] ordersConfigId, int tideCount, int sceneLimit) {
        this.scriptMonsterTideService = new ScriptMonsterTideService(this, group, tideCount, sceneLimit, ordersConfigId);
    }

    public void unloadCurrentMonsterTide() {
        if (getScriptMonsterTideService() != null) {
            getScriptMonsterTideService().unload();
        }
    }

    public void spawnMonstersByConfigId(SceneGroup group, int configId, int delayTime) {
        getScene().addEntity(createMonster(group.f957id, group.block_id, group.monsters.get(Integer.valueOf(configId))));
    }

    public void callEvent(int eventType) {
        callEvent(new ScriptArgs(eventType));
    }

    public void callEvent(@Nonnull ScriptArgs params) {
        eventExecutor.submit(()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: INVOKE  
              (wrap: java.util.concurrent.ExecutorService : 0x0000: SGET  (r0v0 java.util.concurrent.ExecutorService A[REMOVE]) =  emu.grasscutter.scripts.SceneScriptManager.eventExecutor java.util.concurrent.ExecutorService)
              (wrap: java.lang.Runnable : 0x0005: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
              (r4v0 'this' emu.grasscutter.scripts.SceneScriptManager A[D('this' emu.grasscutter.scripts.SceneScriptManager), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r5v0 'params' emu.grasscutter.scripts.data.ScriptArgs A[D('params' emu.grasscutter.scripts.data.ScriptArgs), DONT_INLINE])
            
             handle type: INVOKE_INSTANCE
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r1 I:emu.grasscutter.scripts.SceneScriptManager), (r2 I:emu.grasscutter.scripts.data.ScriptArgs) type: VIRTUAL call: emu.grasscutter.scripts.SceneScriptManager.lambda$callEvent$11(emu.grasscutter.scripts.data.ScriptArgs):void)
             type: INTERFACE call: java.util.concurrent.ExecutorService.submit(java.lang.Runnable):java.util.concurrent.Future in method: emu.grasscutter.scripts.SceneScriptManager.callEvent(emu.grasscutter.scripts.data.ScriptArgs):void, file: grasscutter.jar:emu/grasscutter/scripts/SceneScriptManager.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            java.util.concurrent.ExecutorService r0 = emu.grasscutter.scripts.SceneScriptManager.eventExecutor
            r1 = r4
            r2 = r5
            void r1 = () -> { // java.lang.Runnable.run():void
                r1.lambda$callEvent$11(r2);
            }
            java.util.concurrent.Future r0 = r0.submit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.SceneScriptManager.callEvent(emu.grasscutter.scripts.data.ScriptArgs):void");
    }

    private void realCallEvent(@Nonnull ScriptArgs params) {
        try {
            try {
                ScriptLoader.getScriptLib().setSceneScriptManager(this);
                int eventType = params.type;
                Set<SceneTrigger> relevantTriggers = new HashSet<>();
                if (eventType != 4 && eventType != 5) {
                    for (SceneTrigger sceneTrigger : getTriggersByEvent(eventType)) {
                        relevantTriggers.add(sceneTrigger);
                    }
                } else if (params != null) {
                    relevantTriggers = new HashSet<>(getTriggersByEvent(eventType).stream().filter(p -> {
                        return p.condition.contains(String.valueOf(params.param1)) && (p.source.isEmpty() || p.source.equals(params.getEventSource()));
                    }).toList());
                }
                for (SceneTrigger trigger : relevantTriggers) {
                    handleEventForTrigger(eventType, params, trigger);
                }
                ScriptLoader.getScriptLib().removeSceneScriptManager();
            } catch (Exception e) {
                Grasscutter.getLogger().error("Unable to call event. Detailed exception: ", (Throwable) e);
                ScriptLoader.getScriptLib().removeSceneScriptManager();
            }
        } catch (Throwable th) {
            ScriptLoader.getScriptLib().removeSceneScriptManager();
            throw th;
        }
    }

    private LuaValue callScriptFunc(String funcName, SceneGroup group, ScriptArgs params) {
        LuaValue funcLua = null;
        if (funcName != null && !funcName.isEmpty()) {
            funcLua = (LuaValue) group.getBindings().get(funcName);
        }
        LuaValue ret = LuaValue.TRUE;
        if (funcLua != null) {
            LuaValue args = LuaValue.NIL;
            if (params != null) {
                args = CoerceJavaToLua.coerce(params);
            }
            ret = safetyCall(funcName, funcLua, args, group);
        }
        return ret;
    }

    public LuaValue safetyCall(String name, LuaValue func, LuaValue args, SceneGroup group) {
        try {
            return func.call(ScriptLoader.getScriptLibLua(), args);
        } catch (LuaError error) {
            ScriptLib.logger.debug("[LUA] call trigger failed in group {} with {}", Integer.valueOf(group.f957id), name, error);
            return error.getMessageObject();
        }
    }

    public ScriptMonsterTideService getScriptMonsterTideService() {
        return this.scriptMonsterTideService;
    }

    public ScriptMonsterSpawnService getScriptMonsterSpawnService() {
        return this.scriptMonsterSpawnService;
    }

    public EntityGadget createGadget(int groupId, int blockId, SceneGadget g) {
        if (g == null || getScene().getEntities().values().stream().filter(entity -> {
            return entity instanceof EntityGadget;
        }).filter(entity -> {
            return entity.getBlockId() == blockId;
        }).filter(entity -> {
            return entity.getGroupId() == groupId;
        }).filter(entity -> {
            return entity.getConfigId() == g.config_id;
        }).findFirst().isPresent()) {
            return null;
        }
        Position refPos = g.pos;
        if (getScene().getEntities().values().stream().filter(entity -> {
            return entity instanceof EntityGadget;
        }).filter(entity
        /*  JADX ERROR: Method code generation error
            java.lang.ClassCastException: class jadx.core.dex.instructions.args.LiteralArg cannot be cast to class jadx.core.dex.instructions.args.RegisterArg (jadx.core.dex.instructions.args.LiteralArg and jadx.core.dex.instructions.args.RegisterArg are in unnamed module of loader com.intellij.ide.plugins.cl.PluginClassLoader @362ff29)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:908)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:770)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:770)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:115)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            */
        /*
            this = this;
            r0 = r9
            if (r0 != 0) goto L_0x0006
            r0 = 0
            return r0
        L_0x0006:
            r0 = r6
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            java.util.Map r0 = r0.getEntities()
            java.util.Collection r0 = r0.values()
            java.util.stream.Stream r0 = r0.stream()
            emu.grasscutter.game.entity.EntityGadget r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$createGadget$16(v0);
            }
            java.util.stream.Stream r0 = r0.filter(r1)
            r1 = r8
            emu.grasscutter.game.entity.EntityGadget r1 = (v1) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$createGadget$17(r1, v1);
            }
            java.util.stream.Stream r0 = r0.filter(r1)
            r1 = r7
            emu.grasscutter.game.entity.EntityGadget r1 = (v1) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$createGadget$18(r1, v1);
            }
            java.util.stream.Stream r0 = r0.filter(r1)
            r1 = r9
            emu.grasscutter.game.entity.EntityGadget r1 = (v1) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$createGadget$19(r1, v1);
            }
            java.util.stream.Stream r0 = r0.filter(r1)
            java.util.Optional r0 = r0.findFirst()
            r10 = r0
            r0 = r10
            boolean r0 = r0.isPresent()
            if (r0 == 0) goto L_0x0053
            r0 = 0
            return r0
        L_0x0053:
            r0 = 1
            r11 = r0
            r0 = r9
            emu.grasscutter.utils.Position r0 = r0.pos
            r12 = r0
            r0 = r6
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            java.util.Map r0 = r0.getEntities()
            java.util.Collection r0 = r0.values()
            java.util.stream.Stream r0 = r0.stream()
            emu.grasscutter.game.entity.EntityGadget r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$createGadget$20(v0);
            }
            java.util.stream.Stream r0 = r0.filter(r1)
            r1 = r12
            r2 = r11
            emu.grasscutter.game.entity.EntityGadget r1 = (v2) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$createGadget$21(r1, r2, v2);
            }
            java.util.stream.Stream r0 = r0.filter(r1)
            java.util.Optional r0 = r0.findFirst()
            r13 = r0
            r0 = r13
            boolean r0 = r0.isPresent()
            if (r0 == 0) goto L_0x0096
            r0 = 0
            return r0
        L_0x0096:
            emu.grasscutter.game.entity.EntityGadget r0 = new emu.grasscutter.game.entity.EntityGadget
            r1 = r0
            r2 = r6
            emu.grasscutter.game.world.Scene r2 = r2.getScene()
            r3 = r9
            int r3 = r3.gadget_id
            r4 = r9
            emu.grasscutter.utils.Position r4 = r4.pos
            r1.<init>(r2, r3, r4)
            r14 = r0
            r0 = r14
            emu.grasscutter.data.excels.GadgetData r0 = r0.getGadgetData()
            if (r0 != 0) goto L_0x00b5
            r0 = 0
            return r0
        L_0x00b5:
            r0 = r14
            r1 = r8
            r0.setBlockId(r1)
            r0 = r14
            r1 = r9
            int r1 = r1.config_id
            r0.setConfigId(r1)
            r0 = r14
            r1 = r7
            r0.setGroupId(r1)
            r0 = r14
            emu.grasscutter.utils.Position r0 = r0.getRotation()
            r1 = r9
            emu.grasscutter.utils.Position r1 = r1.rot
            emu.grasscutter.utils.Position r0 = r0.set(r1)
            r0 = r14
            r1 = r9
            int r1 = r1.state
            r0.setState(r1)
            r0 = r14
            r1 = r9
            int r1 = r1.point_type
            r0.setPointType(r1)
            r0 = r14
            r1 = r9
            r0.setMetaGadget(r1)
            r0 = r14
            r0.buildContent()
            r0 = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.SceneScriptManager.createGadget(int, int, emu.grasscutter.scripts.data.SceneGadget):emu.grasscutter.game.entity.EntityGadget");
    }

    public EntityMonster createMonster(int groupId, int blockId, SceneMonster monster) {
        MonsterData data;
        if (monster == null || getScene().getEntities().values().stream().filter(entity -> {
            return entity instanceof EntityMonster;
        }).filter(entity -> {
            return entity.getBlockId() == blockId;
        }).filter(entity -> {
            return entity.getGroupId() == groupId;
        }).filter(entity -> {
            return entity.getConfigId() == monster.config_id;
        }).findFirst().isPresent()) {
            return null;
        }
        Position refPos = monster.pos;
        if (getScene().getEntities().values().stream().filter(entity -> {
            return entity instanceof EntityMonster;
        }).filter(entity
        /*  JADX ERROR: Method code generation error
            java.lang.ClassCastException: class jadx.core.dex.instructions.args.LiteralArg cannot be cast to class jadx.core.dex.instructions.args.RegisterArg (jadx.core.dex.instructions.args.LiteralArg and jadx.core.dex.instructions.args.RegisterArg are in unnamed module of loader com.intellij.ide.plugins.cl.PluginClassLoader @362ff29)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:908)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:770)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:770)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:95)
            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:117)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
            	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:84)
            	at jadx.core.codegen.ConditionGen.addAndOr(ConditionGen.java:151)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:70)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            */
        /*
        // Method dump skipped, instructions count: 342
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.SceneScriptManager.createMonster(int, int, emu.grasscutter.scripts.data.SceneMonster):emu.grasscutter.game.entity.EntityMonster");
    }

    public void addEntity(GameEntity gameEntity) {
        if (gameEntity != null) {
            getScene().addEntity(gameEntity);
        }
    }

    public void meetEntities(List<? extends GameEntity> gameEntity) {
        getScene().addEntities(gameEntity, VisionTypeOuterClass.VisionType.VISION_TYPE_MEET);
    }

    public void addEntities(List<? extends GameEntity> gameEntity) {
        getScene().addEntities(gameEntity);
    }

    public RTree<SceneBlock, Geometry> getBlocksIndex() {
        return this.meta.sceneBlockIndex;
    }

    public void removeMonstersInGroup(SceneGroup group, SceneSuite suite) {
        Set<Integer> configSet = (Set) suite.sceneMonsters.stream().map(m -> {
            return Integer.valueOf(m.config_id);
        }).collect(Collectors.toSet());
        getScene().removeEntities(getScene().getEntities().values().stream().filter(e -> {
            return e instanceof EntityMonster;
        }).filter(e -> {
            return e.getGroupId() == group.f957id;
        }).filter(e -> {
            return configSet.contains(Integer.valueOf(e.getConfigId()));
        }).toList(), VisionTypeOuterClass.VisionType.VISION_TYPE_MISS);
    }

    public void removeGadgetsInGroup(SceneGroup group, SceneSuite suite) {
        Set<Integer> configSet = (Set) suite.sceneGadgets.stream().map(m -> {
            return Integer.valueOf(m.config_id);
        }).collect(Collectors.toSet());
        getScene().removeEntities(getScene().getEntities().values().stream().filter(e -> {
            return e instanceof EntityGadget;
        }).filter(e -> {
            return e.getGroupId() == group.f957id;
        }).filter(e -> {
            return configSet.contains(Integer.valueOf(e.getConfigId()));
        }).toList(), VisionTypeOuterClass.VisionType.VISION_TYPE_MISS);
    }

    public int createGroupTimerEvent(int groupID, String source, double time) {
        SceneGroup group = getGroupById(groupID);
        if (group == null || group.triggers == null) {
            Grasscutter.getLogger().warn("trying to create a timer for unknown group with id {} and source {}", Integer.valueOf(groupID), source);
            return 1;
        }
        Grasscutter.getLogger().debug("creating group timer event for group {} with source {} and time {}", Integer.valueOf(groupID), source, Double.valueOf(time));
        for (SceneTrigger trigger : group.triggers.values()) {
            try {
                if (trigger.event == 15 && trigger.source.equals(source)) {
                    Grasscutter.getLogger().debug("[LUA] Found timer trigger with source {} for group {} : {}", source, Integer.valueOf(groupID), trigger.name);
                    this.activeGroupTimers.computeIfAbsent(Integer.valueOf(groupID), k -> {
                        return new HashSet();
                    }).add(new Pair<>(source, Integer.valueOf(Grasscutter.getGameServer().getScheduler().scheduleDelayedRepeatingTask(()
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00dc: INVOKE  
                          (wrap: java.util.Set<kotlin.Pair<java.lang.String, java.lang.Integer>> : 0x00c3: INVOKE  (r0v29 'groupTasks' java.util.Set<kotlin.Pair<java.lang.String, java.lang.Integer>> A[REMOVE]) = 
                          (wrap: java.util.Map<java.lang.Integer, java.util.Set<kotlin.Pair<java.lang.String, java.lang.Integer>>> : 0x00b7: IGET  (r0v28 java.util.Map<java.lang.Integer, java.util.Set<kotlin.Pair<java.lang.String, java.lang.Integer>>> A[REMOVE]) = 
                          (r8v0 'this' emu.grasscutter.scripts.SceneScriptManager A[D('this' emu.grasscutter.scripts.SceneScriptManager), IMMUTABLE_TYPE, THIS])
                         emu.grasscutter.scripts.SceneScriptManager.activeGroupTimers java.util.Map)
                          (wrap: java.lang.Integer : 0x00bb: INVOKE  (r1v9 java.lang.Integer A[REMOVE]) = (r9v0 'groupID' int A[D('groupID' int)]) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                          (wrap: java.util.function.Function<? super java.lang.Integer, ? extends java.util.Set<kotlin.Pair<java.lang.String, java.lang.Integer>>> : 0x00be: INVOKE_CUSTOM (r2v9 java.util.function.Function<? super java.lang.Integer, ? extends java.util.Set<kotlin.Pair<java.lang.String, java.lang.Integer>>> A[REMOVE]) = 
                         handle type: INVOKE_STATIC
                         lambda: java.util.function.Function.apply(java.lang.Object):java.lang.Object
                         call insn: ?: INVOKE  (v0 java.lang.Integer) type: STATIC call: emu.grasscutter.scripts.SceneScriptManager.lambda$createGroupTimerEvent$38(java.lang.Integer):java.util.Set)
                         type: INTERFACE call: java.util.Map.computeIfAbsent(java.lang.Object, java.util.function.Function):java.lang.Object)
                          (wrap: kotlin.Pair<java.lang.String, java.lang.Integer> : 0x00d9: CONSTRUCTOR  (r1v10 kotlin.Pair<java.lang.String, java.lang.Integer> A[REMOVE]) = 
                          (r10v0 'source' java.lang.String A[D('source' java.lang.String)])
                          (wrap: java.lang.Integer : 0x00d6: INVOKE  (r4v7 java.lang.Integer A[REMOVE]) = 
                          (wrap: int : 0x00b1: INVOKE  (r0v26 'taskIdentifier' int A[REMOVE]) = 
                          (wrap: emu.grasscutter.server.scheduler.ServerTaskScheduler : 0x00a3: INVOKE  (r0v25 emu.grasscutter.server.scheduler.ServerTaskScheduler A[REMOVE]) = 
                          (wrap: emu.grasscutter.server.game.GameServer : 0x00a0: INVOKE  (r0v24 emu.grasscutter.server.game.GameServer A[REMOVE]) =  type: STATIC call: emu.grasscutter.Grasscutter.getGameServer():emu.grasscutter.server.game.GameServer)
                         type: VIRTUAL call: emu.grasscutter.server.game.GameServer.getScheduler():emu.grasscutter.server.scheduler.ServerTaskScheduler)
                          (wrap: java.lang.Runnable : 0x00a8: INVOKE_CUSTOM (r1v7 java.lang.Runnable A[REMOVE]) = 
                          (r8v0 'this' emu.grasscutter.scripts.SceneScriptManager A[D('this' emu.grasscutter.scripts.SceneScriptManager), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                          (r10v0 'source' java.lang.String A[D('source' java.lang.String), DONT_INLINE])
                        
                         handle type: INVOKE_INSTANCE
                         lambda: java.lang.Runnable.run():void
                         call insn: ?: INVOKE  (r1 I:emu.grasscutter.scripts.SceneScriptManager), (r2 I:java.lang.String) type: VIRTUAL call: emu.grasscutter.scripts.SceneScriptManager.lambda$createGroupTimerEvent$37(java.lang.String):void)
                          (wrap: int : 0x00ae: CAST (r2v8 int A[REMOVE]) = (int) (r11v0 'time' double A[D('time' double)]))
                          (wrap: int : 0x00b0: CAST (r3v8 int A[REMOVE]) = (int) (r11v0 'time' double A[D('time' double)]))
                         type: VIRTUAL call: emu.grasscutter.server.scheduler.ServerTaskScheduler.scheduleDelayedRepeatingTask(java.lang.Runnable, int, int):int)
                         type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                         call: kotlin.Pair.<init>(java.lang.Object, java.lang.Object):void type: CONSTRUCTOR)
                         type: INTERFACE call: java.util.Set.add(java.lang.Object):boolean in method: emu.grasscutter.scripts.SceneScriptManager.createGroupTimerEvent(int, java.lang.String, double):int, file: grasscutter.jar:emu/grasscutter/scripts/SceneScriptManager.class
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:314)
                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:221)
                        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
                        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                        	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
                        	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:711)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:393)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                        	... 37 more
                        */
                    /*
                    // Method dump skipped, instructions count: 236
                    */
                    throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.SceneScriptManager.createGroupTimerEvent(int, java.lang.String, double):int");
                }

                public int cancelGroupTimerEvent(int groupID, String source) {
                    try {
                        Set<Pair<String, Integer>> groupTimers = this.activeGroupTimers.get(Integer.valueOf(groupID));
                        if (groupTimers != null && !groupTimers.isEmpty()) {
                            for (Pair<String, Integer> timer : groupTimers) {
                                if (timer.component1().equals(source)) {
                                    Grasscutter.getGameServer().getScheduler().cancelTask(timer.component2().intValue());
                                    return 0;
                                }
                            }
                        }
                        Grasscutter.getLogger().debug("trying to cancel a timer that's not active {} {}", Integer.valueOf(groupID), source);
                        return 1;
                    } catch (Exception e) {
                        return -1;
                    }
                }
            }
