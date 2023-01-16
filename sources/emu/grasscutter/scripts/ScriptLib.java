package emu.grasscutter.scripts;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.activity.ActivityConfigItem;
import emu.grasscutter.game.activity.ActivityManager;
import emu.grasscutter.game.dungeons.DungeonManager;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.entity.EntityBaseGadget;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.EntityMonster;
import emu.grasscutter.game.entity.EntityRegion;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.entity.gadget.GadgetContent;
import emu.grasscutter.game.entity.gadget.GadgetWorktop;
import emu.grasscutter.game.entity.platform.EntityPlatform;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ClimateType;
import emu.grasscutter.game.props.EnterReason;
import emu.grasscutter.game.props.EntityType;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.enums.QuestState;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.EnterTypeOuterClass;
import emu.grasscutter.scripts.constants.GroupKillPolicy;
import emu.grasscutter.scripts.data.SceneGroup;
import emu.grasscutter.scripts.data.SceneObject;
import emu.grasscutter.scripts.data.SceneSuite;
import emu.grasscutter.scripts.data.ScriptArgs;
import emu.grasscutter.server.event.player.PlayerTeleportEvent;
import emu.grasscutter.server.packet.send.PacketBeginCameraSceneLookNotify;
import emu.grasscutter.server.packet.send.PacketCanUseSkillNotify;
import emu.grasscutter.server.packet.send.PacketDungeonShowReminderNotify;
import emu.grasscutter.server.packet.send.PacketPlatformStartRouteNotify;
import emu.grasscutter.server.packet.send.PacketPlayerEnterSceneNotify;
import emu.grasscutter.server.packet.send.PacketScenePointUnlockNotify;
import emu.grasscutter.server.packet.send.PacketWorktopOptionNotify;
import emu.grasscutter.utils.Position;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.jline.builtins.TTop;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p013io.javalin.http.sse.EmitterKt;
import p013io.netty.util.concurrent.FastThreadLocal;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/ScriptLib.class */
public class ScriptLib {
    public static final Logger logger = LoggerFactory.getLogger(ScriptLib.class);
    private final FastThreadLocal<SceneScriptManager> sceneScriptManager = new FastThreadLocal<>();
    private final FastThreadLocal<SceneGroup> currentGroup = new FastThreadLocal<>();
    private final FastThreadLocal<ScriptArgs> callParams = new FastThreadLocal<>();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0065: INVOKE_CUSTOM r-12
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
    /*  JADX ERROR: Failed to decode insn: 0x0065: INVOKE_CUSTOM r1, method: emu.grasscutter.scripts.ScriptLib.ActiveChallenge(int, int, int, int, int, int):int
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Integer;)Ljava/lang/String;}, [LUA] Call ActiveChallenge with Stage ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Integer;)Ljava/lang/String;}, [LUA] Call ActiveChallenge with Stage ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public int ActiveChallenge(int r10, int r11, int r12, int r13, int r14, int r15) {
        /*
            r9 = this;
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r9
            emu.grasscutter.scripts.SceneScriptManager r6 = r6.getSceneScriptManager()
            emu.grasscutter.game.world.Scene r6 = r6.getScene()
            r7 = r9
            java.util.Optional r7 = r7.getCurrentGroup()
            java.lang.Object r7 = r7.get()
            emu.grasscutter.scripts.data.SceneGroup r7 = (emu.grasscutter.scripts.data.SceneGroup) r7
            emu.grasscutter.game.dungeons.challenge.WorldChallenge r0 = emu.grasscutter.game.dungeons.challenge.factory.ChallengeFactory.getChallenge(r0, r1, r2, r3, r4, r5, r6, r7)
            r16 = r0
            r0 = r16
            if (r0 != 0) goto L_0x0039
            org.slf4j.Logger r0 = emu.grasscutter.scripts.ScriptLib.logger
            java.lang.String r1 = "[LUA] Call ActiveChallenge fail {},{}"
            r2 = r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = r11
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.error(r1, r2, r3)
            r0 = 1
            return r0
            r0 = r16
            boolean r0 = r0 instanceof emu.grasscutter.game.dungeons.challenge.DungeonChallenge
            if (r0 == 0) goto L_0x0081
            r0 = r16
            emu.grasscutter.game.dungeons.challenge.DungeonChallenge r0 = (emu.grasscutter.game.dungeons.challenge.DungeonChallenge) r0
            r17 = r0
            r0 = r9
            emu.grasscutter.scripts.SceneScriptManager r0 = r0.getSceneScriptManager()
            java.util.Map r0 = r0.getVariables()
            java.lang.String r1 = "stage"
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r0.getOrDefault(r1, r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r18 = r0
            org.slf4j.Logger r0 = emu.grasscutter.scripts.ScriptLib.logger
            r1 = r18
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Integer;)Ljava/lang/String;}, [LUA] Call ActiveChallenge with Stage ]}
            r0.warn(r1)
            r0 = r17
            r1 = r18
            int r1 = r1.intValue()
            if (r1 != 0) goto L_0x007d
            r1 = 1
            goto L_0x007e
            r1 = 0
            r0.setStage(r1)
            r0 = r9
            emu.grasscutter.scripts.SceneScriptManager r0 = r0.getSceneScriptManager()
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            r1 = r16
            r0.setChallenge(r1)
            r0 = r16
            r0.start()
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.ScriptLib.ActiveChallenge(int, int, int, int, int, int):int");
    }

    public void setSceneScriptManager(SceneScriptManager sceneScriptManager) {
        this.sceneScriptManager.set(sceneScriptManager);
    }

    public void removeSceneScriptManager() {
        this.sceneScriptManager.remove();
    }

    public SceneScriptManager getSceneScriptManager() {
        return (SceneScriptManager) Optional.of(this.sceneScriptManager.get()).get();
    }

    private String printTable(LuaTable table) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        LuaValue[] keys = table.keys();
        for (LuaValue meta : keys) {
            sb.append(meta).append(EmitterKt.COMMENT_PREFIX).append(table.get(meta)).append(",");
        }
        sb.append("}");
        return sb.toString();
    }

    public void setCurrentGroup(SceneGroup currentGroup) {
        this.currentGroup.set(currentGroup);
    }

    public void setCurrentCallParams(ScriptArgs callArgs) {
        this.callParams.set(callArgs);
    }

    public Optional<SceneGroup> getCurrentGroup() {
        return Optional.of(this.currentGroup.get());
    }

    public void removeCurrentGroup() {
        this.currentGroup.remove();
    }

    public int SetGadgetStateByConfigId(int configId, int gadgetState) {
        logger.debug("[LUA] Call SetGadgetStateByConfigId with {},{}", Integer.valueOf(configId), Integer.valueOf(gadgetState));
        Optional<GameEntity> entity = getSceneScriptManager().getScene().getEntities().values().stream().filter(e -> {
            return e.getConfigId() == configId;
        }).findFirst();
        if (entity.isEmpty()) {
            return 1;
        }
        GameEntity gameEntity = entity.get();
        if (!(gameEntity instanceof EntityGadget)) {
            return 1;
        }
        ((EntityGadget) gameEntity).updateState(gadgetState);
        return 0;
    }

    public int SetGroupGadgetStateByConfigId(int groupId, int configId, int gadgetState) {
        logger.debug("[LUA] Call SetGroupGadgetStateByConfigId with {},{},{}", Integer.valueOf(groupId), Integer.valueOf(configId), Integer.valueOf(gadgetState));
        getSceneScriptManager().getScene().getEntities().values().stream().filter(e -> {
            return e.getGroupId() == groupId;
        }).filter(e -> {
            return e.getConfigId() == configId;
        }).filter(e -> {
            return e instanceof EntityGadget;
        }).map(e -> {
            return (EntityGadget) e;
        }).forEach(e -> {
            e.updateState(gadgetState);
        });
        return 0;
    }

    public int SetWorktopOptionsByGroupId(int groupId, int configId, int[] options) {
        logger.debug("[LUA] Call SetWorktopOptionsByGroupId with {},{},{}", Integer.valueOf(groupId), Integer.valueOf(configId), options);
        Optional<GameEntity> entity = getSceneScriptManager().getScene().getEntities().values().stream().filter(e -> {
            return e.getGroupId() == groupId;
        }).filter(e -> {
            return e.getConfigId() == configId;
        }).filter(e -> {
            return e instanceof EntityGadget;
        }).findFirst();
        if (!entity.isEmpty()) {
            GameEntity gameEntity = entity.get();
            if (gameEntity instanceof EntityGadget) {
                EntityGadget gadget = (EntityGadget) gameEntity;
                GadgetContent content = gadget.getContent();
                if (content instanceof GadgetWorktop) {
                    try {
                        ((GadgetWorktop) content).addWorktopOptions(options);
                        getSceneScriptManager().getScene().broadcastPacket(new PacketWorktopOptionNotify(gadget));
                        return 0;
                    } catch (Exception e) {
                        logger.error("[LUA] Call SetWorktopOptionsByGroupId Error", (Throwable) e);
                        return -1;
                    }
                } else {
                    logger.error("[LUA] Call SetWorktopOptionsByGroupId {} and config {} failed because not found getContent", Integer.valueOf(groupId), Integer.valueOf(configId));
                    return -1;
                }
            }
        }
        logger.error("[LUA] Call SetWorktopOptionsByGroupId {} and config {} failed because not found this entities", Integer.valueOf(groupId), Integer.valueOf(configId));
        return -1;
    }

    public int SetWorktopOptions(LuaTable table) {
        logger.debug("[LUA] Call SetWorktopOptions with {}", printTable(table));
        ScriptArgs callParams = this.callParams.getIfExists();
        SceneGroup group = this.currentGroup.getIfExists();
        if (callParams == null || group == null) {
            return 1;
        }
        GameEntity entity = getSceneScriptManager().getScene().getEntityByConfigId(callParams.param1);
        int[] worktopOptions = new int[table.length()];
        for (int i = 1; i <= table.length(); i++) {
            worktopOptions[i - 1] = table.get(i).optint(-1);
        }
        if (!(entity instanceof EntityGadget)) {
            return 2;
        }
        EntityGadget gadget = (EntityGadget) entity;
        if (worktopOptions.length == 0) {
            return 2;
        }
        GadgetContent content = gadget.getContent();
        if (!(content instanceof GadgetWorktop)) {
            return 3;
        }
        ((GadgetWorktop) content).addWorktopOptions(worktopOptions);
        Scene scene = getSceneScriptManager().getScene();
        Grasscutter.getGameServer().getScheduler().scheduleDelayedTask(() -> {
            scene.broadcastPacket(new PacketWorktopOptionNotify(gadget));
        }, 1);
        return 0;
    }

    public int DelWorktopOptionByGroupId(int groupId, int configId, int option) {
        logger.debug("[LUA] Call DelWorktopOptionByGroupId with {},{},{}", Integer.valueOf(groupId), Integer.valueOf(configId), Integer.valueOf(option));
        Optional<GameEntity> entity = getSceneScriptManager().getScene().getEntities().values().stream().filter(e -> {
            return e.getConfigId() == configId && e.getGroupId() == groupId;
        }).findFirst();
        if (entity.isEmpty()) {
            return 1;
        }
        GameEntity gameEntity = entity.get();
        if (!(gameEntity instanceof EntityGadget)) {
            return 1;
        }
        EntityGadget gadget = (EntityGadget) gameEntity;
        GadgetContent content = gadget.getContent();
        if (!(content instanceof GadgetWorktop)) {
            return 1;
        }
        ((GadgetWorktop) content).removeWorktopOption(option);
        getSceneScriptManager().getScene().broadcastPacket(new PacketWorktopOptionNotify(gadget));
        return 0;
    }

    public int DelWorktopOption(int var1) {
        logger.debug("[LUA] Call unimplemented DelWorktopOption with {}", Integer.valueOf(var1));
        ScriptArgs callParams = this.callParams.getIfExists();
        SceneGroup group = this.currentGroup.getIfExists();
        if (callParams == null || group == null) {
            return 1;
        }
        GameEntity entity = getSceneScriptManager().getScene().getEntityByConfigId(callParams.param1);
        if (!(entity instanceof EntityGadget)) {
            return 1;
        }
        EntityGadget gadget = (EntityGadget) entity;
        GadgetContent content = gadget.getContent();
        if (!(content instanceof GadgetWorktop)) {
            return 2;
        }
        ((GadgetWorktop) content).removeWorktopOption(callParams.param2);
        Scene scene = getSceneScriptManager().getScene();
        Grasscutter.getGameServer().getScheduler().scheduleDelayedTask(() -> {
            scene.broadcastPacket(new PacketWorktopOptionNotify(gadget));
        }, 1);
        return 0;
    }

    public int AutoMonsterTide(int challengeIndex, int groupId, Integer[] ordersConfigId, int tideCount, int sceneLimit, int param6) {
        logger.debug("[LUA] Call AutoMonsterTide with {},{},{},{},{},{}", Integer.valueOf(challengeIndex), Integer.valueOf(groupId), ordersConfigId, Integer.valueOf(tideCount), Integer.valueOf(sceneLimit), Integer.valueOf(param6));
        SceneGroup group = getSceneScriptManager().getGroupById(groupId);
        if (group == null || group.monsters == null) {
            return 1;
        }
        getSceneScriptManager().startMonsterTideInGroup(group, ordersConfigId, tideCount, sceneLimit);
        return 0;
    }

    public int AddExtraGroupSuite(int groupId, int suite) {
        int id_saat_ini;
        logger.debug("[LUA] Call AddExtraGroupSuite with {},{}", Integer.valueOf(groupId), Integer.valueOf(suite));
        SceneGroup group = getSceneScriptManager().getGroupById(groupId);
        if (group == null || group.monsters == null) {
            logger.error("[LUA] Call AddExtraGroupSuite failed because group {} not found", Integer.valueOf(groupId));
            return -1;
        }
        SceneSuite suiteData = group.getSuiteByIndex(suite);
        if (suiteData == null) {
            logger.error("[LUA] Call AddExtraGroupSuite failed because group {} did not find data suiteData", Integer.valueOf(groupId));
            return -1;
        } else if (getSceneScriptManager().getScene().getChallenge() == null || !getSceneScriptManager().getScene().getChallenge().inProgress() || (id_saat_ini = getSceneScriptManager().getScene().getChallenge().getGroup().f957id) == groupId) {
            getSceneScriptManager().addGroupSuite(group, suiteData);
            return 0;
        } else {
            logger.error("[LUA] Call AddExtraGroupSuite failed because group {} did not match {} while it's still ongoing", Integer.valueOf(groupId), Integer.valueOf(id_saat_ini));
            return -1;
        }
    }

    public int GoToGroupSuite(int groupId, int suite) {
        logger.debug("[LUA] Call GoToGroupSuite with {},{}", Integer.valueOf(groupId), Integer.valueOf(suite));
        SceneGroup group = getSceneScriptManager().getGroupById(groupId);
        if (group == null || group.monsters == null) {
            return 1;
        }
        SceneSuite suiteData = group.getSuiteByIndex(suite);
        if (suiteData == null) {
            Grasscutter.getLogger().warn("trying to get suite that doesn't exist: {} {}", Integer.valueOf(groupId), Integer.valueOf(suite));
            return 1;
        }
        for (SceneSuite suiteItem : group.suites) {
            if (suiteData != suiteItem) {
                getSceneScriptManager().removeGroupSuite(group, suiteItem);
            }
        }
        getSceneScriptManager().addGroupSuite(group, suiteData);
        return 0;
    }

    public int RemoveExtraGroupSuite(int groupId, int suite) {
        SceneSuite suiteData;
        logger.debug("[LUA] Call RemoveExtraGroupSuite with {},{}", Integer.valueOf(groupId), Integer.valueOf(suite));
        SceneGroup group = getSceneScriptManager().getGroupById(groupId);
        if (group == null || group.monsters == null || (suiteData = group.getSuiteByIndex(suite)) == null) {
            return 1;
        }
        getSceneScriptManager().removeGroupSuite(group, suiteData);
        return 0;
    }

    public int KillExtraGroupSuite(int groupId, int suite) {
        SceneSuite suiteData;
        logger.debug("[LUA] Call KillExtraGroupSuite with {},{}", Integer.valueOf(groupId), Integer.valueOf(suite));
        SceneGroup group = getSceneScriptManager().getGroupById(groupId);
        if (group == null || group.monsters == null || (suiteData = group.getSuiteByIndex(suite)) == null) {
            return 1;
        }
        getSceneScriptManager().removeGroupSuite(group, suiteData);
        return 0;
    }

    public int GetGroupMonsterCountByGroupId(int groupId) {
        logger.debug("[LUA] Call GetGroupMonsterCountByGroupId with {}", Integer.valueOf(groupId));
        return (int) getSceneScriptManager().getScene().getEntities().values().stream().filter(e -> {
            return (e instanceof EntityMonster) && e.getGroupId() == groupId;
        }).count();
    }

    public int CreateVariable(String type, Object value) {
        logger.debug("[LUA] Call unimplemented CreateVariable with {} {}", type, value);
        char c = 65535;
        switch (type.hashCode()) {
            case 104431:
                if (type.equals("int")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            default:
                logger.debug("[LUA] Call CreateVariable with unsupported type {} and value {}", type, value);
                return 0;
        }
    }

    public int SetVariableValue(int var1) {
        logger.debug("[LUA] Call unimplemented SetVariableValue with {}", Integer.valueOf(var1));
        return 0;
    }

    public int GetVariableValue(int var1) {
        logger.debug("[LUA] Call unimplemented GetVariableValue with {}", Integer.valueOf(var1));
        return 0;
    }

    public int GetGroupVariableValue(String var) {
        Integer bb = getSceneScriptManager().getVariables().getOrDefault(var, 0);
        logger.debug("[LUA] Call GetGroupVariableValue with {}={}", var, bb);
        if (!var.contains("challenge") || bb.intValue() != 0) {
            return bb.intValue();
        }
        return 1;
    }

    public int SetGroupVariableValue(String var, int value) {
        logger.debug("[LUA] Call SetGroupVariableValue with {},{}", var, Integer.valueOf(value));
        getSceneScriptManager().getVariables().put(var, Integer.valueOf(value));
        return 0;
    }

    public LuaValue ChangeGroupVariableValue(String var, int value) {
        logger.debug("[LUA] Call ChangeGroupVariableValue with {},{}", var, Integer.valueOf(value));
        getSceneScriptManager().getVariables().put(var, Integer.valueOf(getSceneScriptManager().getVariables().get(var).intValue() + value));
        return LuaValue.ZERO;
    }

    public int RefreshGroup(LuaTable table) {
        logger.debug("[LUA] Call RefreshGroup with {}", printTable(table));
        int groupId = table.get("group_id").toint();
        int suite = table.get("suite").toint();
        SceneGroup group = getSceneScriptManager().getGroupById(groupId);
        if (group == null) {
            logger.error("[LUA] error refresh group {}", Integer.valueOf(groupId));
            return 1;
        }
        getSceneScriptManager().refreshGroup(group, suite);
        return 0;
    }

    public int GetRegionEntityCount(LuaTable table) {
        logger.debug("[LUA] Call GetRegionEntityCount with {}", printTable(table));
        int regionId = table.get("region_eid").toint();
        int entityType = table.get("entity_type").toint();
        EntityRegion region = getSceneScriptManager().getRegionById(regionId);
        if (region == null) {
            return 0;
        }
        return (int) region.getEntities().stream().filter(e -> {
            return (e.intValue() >> 24) == entityType;
        }).count();
    }

    private void printLog(String source, String msg) {
        SceneGroup currentGroup = getCurrentGroup().orElseGet(null);
        if (currentGroup != null) {
            logger.debug("[LUA] {} {} {}", source, Integer.valueOf(currentGroup.f957id), msg);
        } else {
            logger.debug("[LUA] {} {}", source, msg);
        }
    }

    public void PrintContextLog(String msg) {
        printLog("PrintContextLog", msg);
    }

    public void PrintLog(String msg) {
        printLog("PrintLog", msg);
    }

    public int TowerCountTimeStatus(int isDone, int var2) {
        logger.debug("[LUA] Call TowerCountTimeStatus with {},{}", Integer.valueOf(isDone), Integer.valueOf(var2));
        return 0;
    }

    public int GetGroupMonsterCount() {
        logger.debug("[LUA] Call GetGroupMonsterCount ");
        return (int) getSceneScriptManager().getScene().getEntities().values().stream().filter(e -> {
            return (e instanceof EntityMonster) && e.getGroupId() == ((Integer) getCurrentGroup().map(sceneGroup -> {
                return Integer.valueOf(sceneGroup.f957id);
            }).orElse(-1)).intValue();
        }).count();
    }

    public int SetMonsterBattleByGroup(int configId, int groupId) {
        logger.debug("[LUA] Call SetMonsterBattleByGroup with {} {}", Integer.valueOf(configId), Integer.valueOf(groupId));
        return 0;
    }

    public int CauseDungeonFail() {
        DungeonManager dungeonManager;
        logger.debug("[LUA] Call CauseDungeonFail with");
        SceneScriptManager scriptManager = this.sceneScriptManager.getIfExists();
        if (scriptManager == null || (dungeonManager = scriptManager.getScene().getDungeonManager()) == null || dungeonManager.isFinishedSuccessfully()) {
            return -1;
        }
        dungeonManager.failDungeon();
        return 0;
    }

    public int GetGroupVariableValueByGroup(String name, int groupId) {
        logger.debug("[LUA] Call GetGroupVariableValueByGroup with {},{}", name, Integer.valueOf(groupId));
        return getSceneScriptManager().getVariables().getOrDefault(name, 0).intValue();
    }

    public int ChangeGroupVariableValueByGroup(String name, int value, int groupId) {
        logger.debug("[LUA] Call ChangeGroupVariableValueByGroup with {},{}", name, Integer.valueOf(groupId));
        getSceneScriptManager().getVariables().put(name, Integer.valueOf(value));
        return 0;
    }

    public int SetIsAllowUseSkill(int canUse) {
        logger.debug("[LUA] Call SetIsAllowUseSkill with {}", Integer.valueOf(canUse));
        getSceneScriptManager().getScene().broadcastPacket(new PacketCanUseSkillNotify(canUse == 1));
        return 0;
    }

    public int KillEntityByConfigId(LuaTable table) {
        GameEntity entity;
        logger.debug("[LUA] Call KillEntityByConfigId with {}", printTable(table));
        LuaValue configId = table.get("config_id");
        if (configId == LuaValue.NIL || (entity = getSceneScriptManager().getScene().getEntityByConfigId(configId.toint())) == null) {
            return 1;
        }
        getSceneScriptManager().getScene().killEntity(entity, 0);
        return 0;
    }

    public int SetGroupVariableValueByGroup(String key, int value, int groupId) {
        logger.debug("[LUA] Call SetGroupVariableValueByGroup with {},{},{}", key, Integer.valueOf(value), Integer.valueOf(groupId));
        getSceneScriptManager().getVariables().put(key, Integer.valueOf(value));
        return 0;
    }

    public int CreateMonster(LuaTable table) {
        logger.debug("[LUA] Call CreateMonster with {}", printTable(table));
        int configId = table.get("config_id").toint();
        int delayTime = table.get("delay_time").toint();
        if (getCurrentGroup().isEmpty()) {
            return 1;
        }
        getSceneScriptManager().spawnMonstersByConfigId(getCurrentGroup().get(), configId, delayTime);
        return 0;
    }

    public int TowerMirrorTeamSetUp(int team, int var1) {
        logger.debug("[LUA] Call TowerMirrorTeamSetUp with {},{}", Integer.valueOf(team), Integer.valueOf(var1));
        getSceneScriptManager().unloadCurrentMonsterTide();
        getSceneScriptManager().getScene().getPlayers().get(0).getTowerManager().mirrorTeamSetUp(team - 1);
        return 0;
    }

    public int CreateGadget(LuaTable table) {
        logger.debug("[LUA] Call CreateGadget with {}", printTable(table));
        int configId = table.get("config_id").toint();
        Optional<SceneGroup> group = getCurrentGroup();
        if (group.isEmpty()) {
            return 1;
        }
        createGadget(configId, group.get());
        return 0;
    }

    private GameEntity createGadget(int configId, SceneGroup group) {
        EntityGadget entity = getSceneScriptManager().createGadget(group.f957id, group.block_id, group.gadgets.get(Integer.valueOf(configId)));
        getSceneScriptManager().addEntity(entity);
        return entity;
    }

    public int CheckRemainGadgetCountByGroupId(LuaTable table) {
        logger.debug("[LUA] Call CheckRemainGadgetCountByGroupId with {}", printTable(table));
        int groupId = table.get("group_id").toint();
        return (int) getSceneScriptManager().getScene().getEntities().values().stream().filter(g -> {
            return (g instanceof EntityGadget) && ((EntityGadget) g).getGroupId() == groupId;
        }).count();
    }

    public int GetGadgetStateByConfigId(int groupId, int configId) {
        logger.debug("[LUA] Call GetGadgetStateByConfigId with {},{}", Integer.valueOf(groupId), Integer.valueOf(configId));
        if (groupId == 0) {
            groupId = getCurrentGroup().get().f957id;
        }
        Optional<GameEntity> gadget = getSceneScriptManager().getScene().getEntities().values().stream().filter(g -> {
            return (g instanceof EntityGadget) && ((EntityGadget) g).getGroupId() == groupId;
        }).filter(g -> {
            return g.getConfigId() == configId;
        }).findFirst();
        if (gadget.isEmpty()) {
            return 1;
        }
        return ((EntityGadget) gadget.get()).getState();
    }

    public int GetGadgetStateByConfigId(int groupId, LuaTable objnull) {
        logger.warn("[LUA] Call Null GetGadgetStateByConfigId with {},{}", Integer.valueOf(groupId), printTable(objnull));
        return 1;
    }

    public int MarkPlayerAction(int var1, int var2, int var3) {
        logger.debug("[LUA] Call MarkPlayerAction with {},{},{}", Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3));
        return 0;
    }

    public int AddQuestProgress(String var1) {
        logger.debug("[LUA] Call AddQuestProgress with {}", var1);
        for (Player player : getSceneScriptManager().getScene().getPlayers()) {
            player.getQuestManager().queueEvent(QuestTrigger.QUEST_COND_LUA_NOTIFY, var1, new int[0]);
            player.getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_LUA_NOTIFY, var1, new int[0]);
        }
        return 0;
    }

    public int ChangeGroupGadget(LuaTable table) {
        logger.debug("[LUA] Call ChangeGroupGadget with {}", printTable(table));
        int configId = table.get("config_id").toint();
        int state = table.get(TTop.STAT_STATE).toint();
        GameEntity entity = getSceneScriptManager().getScene().getEntityByConfigId(configId);
        if (entity == null || !(entity instanceof EntityGadget)) {
            return 1;
        }
        ((EntityGadget) entity).updateState(state);
        return 0;
    }

    public int GetEntityType(int entityId) {
        GameEntity entity = getSceneScriptManager().getScene().getEntityById(entityId);
        if (entity == null) {
            return EntityType.None.getValue();
        }
        return entity.getEntityType();
    }

    public int GetQuestState(int entityId, int questId) {
        logger.debug("[LUA] Call GetQuestState with {},{}", Integer.valueOf(entityId), Integer.valueOf(questId));
        GameQuest quest = getSceneScriptManager().getScene().getWorld().getHost().getQuestManager().getQuestById(questId);
        if (quest == null) {
            return QuestState.QUEST_STATE_NONE.getValue();
        }
        return quest.getState().getValue();
    }

    public int ShowReminder(int reminderId) {
        getSceneScriptManager().getScene().broadcastPacket(new PacketDungeonShowReminderNotify(reminderId));
        return 0;
    }

    public int RemoveEntityByConfigId(int groupId, int entityType, int configId) {
        logger.debug("[LUA] Call RemoveEntityByConfigId: {},{},{}", Integer.valueOf(groupId), Integer.valueOf(entityType), Integer.valueOf(configId));
        Optional<GameEntity> entity = getSceneScriptManager().getScene().getEntities().values().stream().filter(e -> {
            return e.getGroupId() == groupId;
        }).filter(e -> {
            return e.getEntityType() == entityType;
        }).filter(e -> {
            return e.getConfigId() == configId;
        }).findFirst();
        if (!entity.isPresent()) {
            logger.debug("[LUA] Call RemoveEntityByConfigId failed to find Entities");
            return -1;
        }
        getSceneScriptManager().getScene().removeEntity(entity.get());
        return 0;
    }

    public int CreateGroupTimerEvent(int groupID, String source, double time) {
        return this.sceneScriptManager.get().createGroupTimerEvent(groupID, source, time);
    }

    public int CancelGroupTimerEvent(int groupID, String source) {
        return this.sceneScriptManager.get().cancelGroupTimerEvent(groupID, source);
    }

    public int GetGroupSuite(int var1) {
        logger.debug("[LUA] Call unimplemented GetGroupSuite with {}", Integer.valueOf(var1));
        return 0;
    }

    public int SetGroupReplaceable(int groupId, boolean var2) {
        logger.debug("[LUA] Call unimplemented SetGroupReplaceable with {} {}", Integer.valueOf(groupId), Boolean.valueOf(var2));
        return 0;
    }

    public int[] GetSceneUidList() {
        logger.debug("[LUA] Call unchecked GetSceneUidList");
        SceneScriptManager scriptManager = this.sceneScriptManager.getIfExists();
        if (scriptManager == null) {
            return new int[0];
        }
        List<Player> players = scriptManager.getScene().getPlayers();
        int[] result = new int[players.size()];
        for (int i = 0; i < players.size(); i++) {
            result[i] = players.get(i).getUid();
        }
        return result;
    }

    public int GetSeaLampActivityPhase() {
        logger.debug("[LUA] Call unimplemented GetSeaLampActivityPhase");
        return 0;
    }

    public int GadgetPlayUidOp(int groupId, int gadget_crucible, int var3, int var4, String var5, int var6) {
        logger.debug("[LUA] Call unimplemented GadgetPlayUidOp with {}, {}, {}, {}, {}, {}", Integer.valueOf(groupId), Integer.valueOf(gadget_crucible), Integer.valueOf(var3), Integer.valueOf(var4), var5, Integer.valueOf(var6));
        return 0;
    }

    public long GetServerTime() {
        logger.debug("[LUA] Call GetServerTime");
        return new Date().getTime();
    }

    public long GetServerTimeByWeek() {
        logger.debug("[LUA] Call GetServerTimeByWeek");
        return (long) Calendar.getInstance().get(7);
    }

    public int GetCurTriggerCount() {
        logger.debug("[LUA] Call GetCurTriggerCount");
        return getSceneScriptManager().getTriggerCount();
    }

    public int GetChannellerSlabLoopDungeonLimitTime() {
        logger.debug("[LUA] Call unimplemented GetChannellerSlabLoopDungeonLimitTime");
        return 0;
    }

    public int IsPlayerAllAvatarDie(int sceneUid) {
        logger.debug("[LUA] Call unimplemented IsPlayerAllAvatarDie {}", Integer.valueOf(sceneUid));
        Iterator<GameEntity> it = getSceneScriptManager().getScene().getEntities().values().stream().filter(e -> {
            return e.getEntityType() == EntityType.Avatar.getValue();
        }).toList().iterator();
        while (it.hasNext()) {
            if (((EntityAvatar) it.next()).isAlive()) {
                return 0;
            }
        }
        return 1;
    }

    public int sendCloseCommonTipsToClient() {
        logger.debug("[LUA] Call unimplemented sendCloseCommonTipsToClient");
        return 0;
    }

    public int CreateFatherChallenge(int var1, int var2, int var3, LuaTable var4) {
        logger.debug("[LUA] Call unimplemented CreateFatherChallenge with {} {} {} {}", Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3), var4);
        return 0;
    }

    public int StartFatherChallenge(int var1) {
        logger.debug("[LUA] Call unimplemented StartFatherChallenge with {}", Integer.valueOf(var1));
        return 0;
    }

    public int AttachChildChallenge(int var1, int var2, int var3, int[] var4, LuaTable var5, LuaTable var6) {
        logger.debug("[LUA] Call unimplemented AttachChildChallenge with {} {} {} {} {} {}", Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3), var4, var5, var6);
        return 0;
    }

    public int CreateEffigyChallengeMonster(int var1, int[] var2) {
        logger.debug("[LUA] Call unimplemented CreateEffigyChallengeMonster with {} {}", Integer.valueOf(var1), var2);
        return 0;
    }

    public int GetEffigyChallengeMonsterLevel() {
        logger.debug("[LUA] Call unimplemented CreateEffigyChallengeMonster");
        return 0;
    }

    public int AddTeamEntityGlobalFloatValue(int[] sceneUidList, String var2, int var3) {
        logger.debug("[LUA] Call unimplemented AddTeamEntityGlobalFloatValue with {} {} {}", sceneUidList, var2, Integer.valueOf(var3));
        return 0;
    }

    public int CreateBlossomChestByGroupId(int groupId, int var2) {
        logger.debug("[LUA] Call unimplemented SetBlossomScheduleStateByGroupId with {} {}", Integer.valueOf(groupId), Integer.valueOf(var2));
        return 0;
    }

    public int SetBlossomScheduleStateByGroupId(int groupId, int scene) {
        logger.debug("[LUA] Call unimplemented SetBlossomScheduleStateByGroupId with {} {}", Integer.valueOf(groupId), Integer.valueOf(scene));
        return 0;
    }

    public int RefreshBlossomGroup(LuaTable var1) {
        logger.debug("[LUA] Call unimplemented RefreshBlossomGroup with {}", printTable(var1));
        return 0;
    }

    public int RefreshBlossomDropRewardByGroupId(int groupId) {
        logger.debug("[LUA] Call unimplemented RefreshBlossomDropRewardByGroupId with {}", Integer.valueOf(groupId));
        return 0;
    }

    public int AddBlossomScheduleProgressByGroupId(int groupId) {
        logger.debug("[LUA] Call unimplemented AddBlossomScheduleProgressByGroupId with {}", Integer.valueOf(groupId));
        return 0;
    }

    public int RefreshHuntingClueGroup() {
        logger.debug("[LUA] Call unimplemented RefreshHuntingClueGroup");
        return 0;
    }

    public int GetHuntingMonsterExtraSuiteIndexVec() {
        logger.debug("[LUA] Call unimplemented GetHuntingMonsterExtraSuiteIndexVec");
        return 0;
    }

    public int SetGroupTempValue(String name, int value, LuaTable var3) {
        logger.debug("[LUA] Call unimplemented SetGroupTempValue with {} {} {}", name, Integer.valueOf(value), printTable(var3));
        return 0;
    }

    public int GetGroupTempValue(String name, LuaTable var2) {
        logger.debug("[LUA] Call unimplemented GetGroupTempValue with {} {}", name, printTable(var2));
        return 0;
    }

    public int SetPlatformPointArray(int var1, int var2, int[] var3, LuaTable var4) {
        logger.debug("[LUA] Call unimplemented SetPlatformPointArray with {} {} {} {}", Integer.valueOf(var1), Integer.valueOf(var2), var3, printTable(var4));
        return 0;
    }

    public int FinishExpeditionChallenge() {
        logger.debug("[LUA] unimplemented Call FinishExpeditionChallenge");
        return 0;
    }

    public int ExpeditionChallengeEnterRegion(boolean var1) {
        logger.debug("[LUA] unimplemented Call ExpeditionChallengeEnterRegion with {}", Boolean.valueOf(var1));
        return 0;
    }

    public int StartSealBattle(int gadgetId, LuaTable var2) {
        logger.debug("[LUA] unimplemented Call StartSealBattle with {} {}", Integer.valueOf(gadgetId), printTable(var2));
        return 0;
    }

    public int InitTimeAxis(String var1, int[] var2, boolean var3) {
        logger.debug("[LUA] Call unimplemented InitTimeAxis with {} {} {}", var1, var2, Boolean.valueOf(var3));
        return 0;
    }

    public int SetTeamEntityGlobalFloatValue(int[] sceneUidList, String var2, int var3) {
        logger.debug("[LUA] Call unimplemented SetTeamEntityGlobalFloatValue with {} {} {}", sceneUidList, var2, Integer.valueOf(var3));
        return 0;
    }

    public int SetTeamServerGlobalValue(int sceneUid, String var2, int var3) {
        logger.debug("[LUA] Call unimplemented SetTeamServerGlobalValue with {} {} {}", Integer.valueOf(sceneUid), var2, Integer.valueOf(var3));
        return 0;
    }

    public int GetLanternRiteValue() {
        logger.debug("[LUA] Call unimplemented GetLanternRiteValue");
        return 0;
    }

    public int CreateMonsterFaceAvatar(LuaTable var1) {
        logger.debug("[LUA] Call unimplemented CreateMonsterFaceAvatar with {}", printTable(var1));
        return 0;
    }

    public int ChangeToTargetLevelTag(int var1) {
        logger.debug("[LUA] Call unimplemented ChangeToTargetLevelTag with {}", Integer.valueOf(var1));
        return 0;
    }

    public int StartHomeGallery(int galleryId, int uid) {
        logger.debug("[LUA] Call unimplemented StartHomeGallery with {} {}", Integer.valueOf(galleryId), Integer.valueOf(uid));
        return 0;
    }

    public int StopGallery(int galleryId, boolean var2) {
        logger.debug("[LUA] Call unimplemented StopGallery with {} {}", Integer.valueOf(galleryId), Boolean.valueOf(var2));
        return 0;
    }

    public int StartGallery(int galleryId) {
        logger.debug("[LUA] Call unimplemented StartGallery with {}", Integer.valueOf(galleryId));
        return 0;
    }

    public int UpdatePlayerGalleryScore(int galleryId, LuaTable var2) {
        logger.debug("[LUA] Call unimplemented UpdatePlayerGalleryScore with {} {}", Integer.valueOf(galleryId), printTable(var2));
        return 0;
    }

    public int SetHandballGalleryBallPosAndRot(int galleryId, LuaTable position, LuaTable rotation) {
        logger.debug("[LUA] Call unimplemented SetHandballGalleryBallPosAndRot with {} {} {}", Integer.valueOf(galleryId), printTable(position), printTable(rotation));
        return 0;
    }

    public int UnlockFloatSignal(int groupId, int gadgetSignalId) {
        logger.debug("[LUA] Call unimplemented UnlockFloatSignal with {} {}", Integer.valueOf(groupId), Integer.valueOf(gadgetSignalId));
        return 0;
    }

    public int SendServerMessageByLuaKey(String var1, int[] var2) {
        logger.debug("[LUA] Call unimplemented SendServerMessageByLuaKey with {} {}", var1, var2);
        return 0;
    }

    public int TryReallocateEntityAuthority(int uid, int endConfig, int var3) {
        logger.debug("[LUA] Call unimplemented TryReallocateEntityAuthority with {} {} {}", Integer.valueOf(uid), Integer.valueOf(endConfig), Integer.valueOf(var3));
        return 0;
    }

    public int ForceRefreshAuthorityByConfigId(int var1, int uid) {
        logger.debug("[LUA] Call unimplemented ForceRefreshAuthorityByConfigId with {} {}", Integer.valueOf(var1), Integer.valueOf(uid));
        return 0;
    }

    public int AddPlayerGroupVisionType(int[] uids, int[] var2) {
        logger.debug("[LUA] Call unimplemented AddPlayerGroupVisionType with {} {}", uids, var2);
        return 0;
    }

    public int DelPlayerGroupVisionType(int[] uids, int[] var2) {
        logger.debug("[LUA] Call unimplemented DelPlayerGroupVisionType with {} {}", uids, var2);
        return 0;
    }

    public int MoveAvatarByPointArray(int uid, int targetId, LuaTable var3, String var4) {
        logger.debug("[LUA] Call unimplemented MoveAvatarByPointArray with {} {} {} {}", Integer.valueOf(uid), Integer.valueOf(targetId), printTable(var3), var4);
        return 0;
    }

    public int MovePlayerToPos(LuaTable var1) {
        logger.debug("[LUA] Call unimplemented MovePlayerToPos with {}", printTable(var1));
        return TransPlayerToPos(var1);
    }

    public int TransPlayerToPos(LuaTable var1) {
        logger.debug("[LUA] Call unimplemented TransPlayerToPos with {}", printTable(var1));
        LuaValue targetsTable = var1.get("uid_list");
        LuaValue pos = var1.get("pos");
        var1.get("rot");
        var1.get("radius");
        if (targetsTable.isnil() || !targetsTable.istable() || targetsTable.length() == 0 || pos.isnil()) {
            return 1;
        }
        ArrayList<Integer> targets = new ArrayList<>(targetsTable.length());
        for (int i = 1; i <= targetsTable.length(); i++) {
            targets.add(Integer.valueOf(targetsTable.get(i).optint(-1)));
        }
        LuaValue x = pos.get("x");
        LuaValue y = pos.get("y");
        LuaValue z = pos.get("z");
        SceneScriptManager scriptManager = this.sceneScriptManager.getIfExists();
        if (scriptManager == null || !x.isnumber() || !y.isnumber() || !z.isnumber()) {
            return 2;
        }
        Position targetPos = new Position((float) x.toint(), (float) y.toint(), (float) z.toint());
        Scene scene = scriptManager.getScene();
        scene.getPlayers().stream().filter(p -> {
            return targets.contains(Integer.valueOf(p.getUid()));
        }).forEach(p -> {
            if (scene.getEntityById(GetAvatarEntityIdByUid(targetPos.getUid())) != null) {
                scene.removePlayer(targetPos);
                scene.addPlayer(targetPos);
                targetPos.getPosition().set(scene);
                targetPos.sendPacket(new PacketPlayerEnterSceneNotify(targetPos, EnterTypeOuterClass.EnterType.ENTER_TYPE_GOTO, EnterReason.Lua, scene.getId(), scene));
            } else if (scene.computeDistance(targetPos.getPosition()) > 0.0d) {
                scene.getWorld().transferPlayerToScene(targetPos, scene.getId(), PlayerTeleportEvent.TeleportType.SCRIPT, scene);
            }
        });
        return 0;
    }

    public int PlayCutScene(int var1, int var2) {
        logger.debug("[LUA] Call unimplemented PlayCutScene with {} {}", Integer.valueOf(var1), Integer.valueOf(var2));
        return 0;
    }

    public int ScenePlaySound(LuaTable var1) {
        logger.debug("[LUA] Call unimplemented ScenePlaySound with {}", printTable(var1));
        return 0;
    }

    public int BeginCameraSceneLook(LuaTable sceneLookParams) {
        logger.debug("[LUA] Call BeginCameraSceneLook with {}", printTable(sceneLookParams));
        LuaValue luaLookPos = sceneLookParams.get("look_pos");
        LuaValue luaFollowPos = sceneLookParams.get("follow_pos");
        LuaValue luaDuration = sceneLookParams.get("duration");
        LuaValue luaIsForce = sceneLookParams.get("is_force");
        LuaValue luaIsBroadcast = sceneLookParams.get("is_broadcast");
        LuaValue luaAllowInput = sceneLookParams.get("is_allow_input");
        LuaValue luaSetFollowPos = sceneLookParams.get("is_set_follow_pos");
        LuaValue luaIsForceWalk = sceneLookParams.get("is_force_walk");
        LuaValue luaIsChangePlayMode = sceneLookParams.get("is_change_play_mode");
        LuaValue luaScreenX = sceneLookParams.get("screen_x");
        LuaValue luaScreenY = sceneLookParams.get("screen_y");
        PacketBeginCameraSceneLookNotify.CameraSceneLookNotify cameraParams = new PacketBeginCameraSceneLookNotify.CameraSceneLookNotify();
        cameraParams.setLookPos(luaToPos(luaLookPos));
        cameraParams.setFollowPos(luaToPos(luaFollowPos));
        if (luaDuration.isnumber()) {
            cameraParams.setDuration(luaDuration.tofloat());
        }
        if (luaScreenX.isnumber()) {
            cameraParams.setScreenX(luaScreenX.tofloat());
        }
        if (luaScreenY.isnumber()) {
            cameraParams.setScreenY(luaScreenY.tofloat());
        }
        if (luaIsForce.isboolean()) {
            cameraParams.setForce(luaIsForce.toboolean());
        }
        if (luaAllowInput.isboolean()) {
            cameraParams.setAllowInput(luaAllowInput.toboolean());
        }
        if (luaSetFollowPos.isboolean()) {
            cameraParams.setSetFollowPos(luaSetFollowPos.toboolean());
        }
        if (luaIsForceWalk.isboolean()) {
            cameraParams.setForceWalk(luaIsForceWalk.toboolean());
        }
        if (luaIsChangePlayMode.isboolean()) {
            cameraParams.setChangePlayMode(luaIsChangePlayMode.toboolean());
        }
        if (luaIsBroadcast.isboolean()) {
        }
        return 0;
    }

    public int ShowReminderRadius(int var1, LuaTable var2, int var3) {
        logger.debug("[LUA] Call unimplemented ShowReminderRadius with {} {} {}", Integer.valueOf(var1), printTable(var2), Integer.valueOf(var3));
        return 0;
    }

    public int ShowClientGuide(String var1) {
        logger.debug("[LUA] Call unimplemented ShowClientGuide with {}", var1);
        return 0;
    }

    public int ActivateDungeonCheckPoint(int var1) {
        logger.warn("[LUA] Call ActivateDungeonCheckPoint with {}", Integer.valueOf(var1));
        DungeonManager dungeonManager = getSceneScriptManager().getScene().getDungeonManager();
        if (dungeonManager == null) {
            return 1;
        }
        return dungeonManager.activateRespawnPoint(var1) ? 0 : 2;
    }

    public int SetWeatherAreaState(int var1, int var2) {
        logger.debug("[LUA] Call unimplemented SetWeatherAreaState with {} {}", Integer.valueOf(var1), Integer.valueOf(var2));
        getSceneScriptManager().getScene().getPlayers().forEach(p -> {
            p.setWeather(var1, ClimateType.getTypeByValue(var2));
        });
        return 0;
    }

    public boolean CheckIsInMpMode() {
        logger.debug("[LUA] Call CheckIsInMpMode");
        return getSceneScriptManager().getScene().getWorld().isMultiplayer();
    }

    public int SetPlatformRouteId(int entityConfigId, int routeId) {
        logger.debug("[LUA] Call unimplemented SetPlatformRouteId {} {}", Integer.valueOf(entityConfigId), Integer.valueOf(routeId));
        return 0;
    }

    public int StopPlatform(int configId) {
        logger.debug("[LUA] Call unimplemented StopPlatform {} ", Integer.valueOf(configId));
        return 1;
    }

    public int CreateChannellerSlabCampRewardGadget(int configId) {
        logger.warn("[LUA] Call unimplemented CreateChannellerSlabCampRewardGadget {}", Integer.valueOf(configId));
        SceneGroup group = this.currentGroup.getIfExists();
        if (group == null) {
            return 1;
        }
        createGadget(configId, group);
        return 0;
    }

    public int AssignPlayerShowTemplateReminder(int var1, LuaTable var2) {
        logger.debug("[LUA] Call unimplemented AssignPlayerShowTemplateReminder {} {}", Integer.valueOf(var1), var2);
        return 0;
    }

    public int KillGroupEntity(LuaTable var1) {
        logger.debug("[LUA] Call KillGroupEntity with {}", printTable(var1));
        SceneScriptManager sceneManager = this.sceneScriptManager.getIfExists();
        int groupId = var1.get("group_id").optint(-1);
        int killPolicyId = var1.get("kill_policy").optint(-1);
        var1.get("gadgets");
        if (groupId == -1 || sceneManager == null) {
            return 1;
        }
        SceneGroup group = sceneManager.getGroupById(groupId);
        if (group == null) {
            return 2;
        }
        if (killPolicyId != -1) {
            return killGroupEntityWithPolicy(sceneManager, group, GroupKillPolicy.values()[killPolicyId]);
        }
        return killGroupEntityWithTable(sceneManager, group, var1);
    }

    private int killGroupEntityWithTable(SceneScriptManager sceneScriptManager, SceneGroup group, LuaTable lists) {
        LuaValue monsterList = lists.get("monsters");
        LuaValue gadgetList = lists.get("gadgets");
        int[] targets = new int[monsterList.length() + gadgetList.length()];
        int targetsIndex = 0;
        int i = 1;
        while (i <= monsterList.length()) {
            targets[targetsIndex] = monsterList.get(i).optint(-1);
            i++;
            targetsIndex++;
        }
        int i2 = 1;
        while (i2 <= gadgetList.length()) {
            targets[targetsIndex] = gadgetList.get(i2).optint(-1);
            i2++;
            targetsIndex++;
        }
        for (int cfgId : targets) {
            GameEntity entity = getSceneScriptManager().getScene().getEntityByConfigId(cfgId);
            if (!(entity == null || cfgId == 0)) {
                getSceneScriptManager().getScene().killEntity(entity, 0);
            }
        }
        return 0;
    }

    private int killGroupEntityWithPolicy(SceneScriptManager sceneScriptManager, SceneGroup group, GroupKillPolicy killPolicy) {
        ArrayList<SceneObject> targets = new ArrayList<>();
        if (killPolicy == GroupKillPolicy.GROUP_KILL_MONSTER || killPolicy == GroupKillPolicy.GROUP_KILL_ALL) {
            targets.addAll(group.monsters.values());
        }
        if (killPolicy == GroupKillPolicy.GROUP_KILL_GADGET || killPolicy == GroupKillPolicy.GROUP_KILL_ALL) {
            targets.addAll(group.gadgets.values());
        }
        targets.forEach(o -> {
            GameEntity entity = getSceneScriptManager().getScene().getEntityByConfigId(o.config_id);
            if (entity != null) {
                getSceneScriptManager().getScene().killEntity(entity, 0);
            }
        });
        return 0;
    }

    public int GetGadgetIdByEntityId(int entityId) {
        GameEntity entity = getSceneScriptManager().getScene().getEntityById(entityId);
        if (!(entity instanceof EntityBaseGadget)) {
            return 0;
        }
        return ((EntityBaseGadget) entity).getGadgetId();
    }

    public int GetMonsterIdByEntityId(int entityId) {
        GameEntity entity = getSceneScriptManager().getScene().getEntityById(entityId);
        if (!(entity instanceof EntityMonster)) {
            return 0;
        }
        return ((EntityMonster) entity).getMonsterData().getId();
    }

    public int GetMonsterID(int var1) {
        return 0;
    }

    public int GetEntityIdByConfigId(int configId) {
        logger.debug("[LUA] Call GetEntityIdByConfigId with {}", Integer.valueOf(configId));
        GameEntity entity = getSceneScriptManager().getScene().getEntityByConfigId(configId);
        if (entity != null) {
            return entity.getId();
        }
        return 0;
    }

    public int GetAvatarEntityIdByUid(int uid) {
        logger.debug("[LUA] Call unchecked GetAvatarEntityIdByUid with {}", Integer.valueOf(uid));
        return ((Integer) getSceneScriptManager().getScene().getEntities().values().stream().filter(e -> {
            return (e instanceof EntityAvatar) && ((EntityAvatar) e).getPlayer().getUid() == uid;
        }).findFirst().map((v0) -> {
            return v0.getId();
        }).orElse(0)).intValue();
    }

    private LuaTable posToLua(Position position) {
        LuaTable result = new LuaTable();
        if (position != null) {
            result.set("x", (double) position.getX());
            result.set("y", (double) position.getY());
            result.set("z", (double) position.getZ());
        } else {
            result.set("x", 0);
            result.set("y", 0);
            result.set("z", 0);
        }
        return result;
    }

    private Position luaToPos(LuaValue position) {
        Position result = new Position();
        if (position != null && !position.isnil()) {
            result.setX((float) position.get("x").optint(0));
            result.setY((float) position.get("y").optint(0));
            result.setZ((float) position.get("z").optint(0));
        }
        return result;
    }

    public LuaTable GetPosByEntityId(int entityId) {
        logger.debug("[LUA] Call unchecked GetPosByEntityId with {}", Integer.valueOf(entityId));
        GameEntity entity = getSceneScriptManager().getScene().getEntityById(entityId);
        return posToLua(entity != null ? entity.getPosition() : null);
    }

    public LuaTable GetRotationByEntityId(int entityId) {
        logger.debug("[LUA] Call unchecked GetRotationByEntityId with {}", Integer.valueOf(entityId));
        GameEntity entity = getSceneScriptManager().getScene().getEntityById(entityId);
        return posToLua(entity != null ? entity.getRotation() : null);
    }

    public LuaTable GetActivityOpenAndCloseTimeByScheduleId(int scheduleId) {
        logger.debug("[LUA] Call GetActivityOpenAndCloseTimeByScheduleId with {}", Integer.valueOf(scheduleId));
        LuaTable result = new LuaTable();
        ActivityConfigItem activityConfig = ActivityManager.getScheduleActivityConfigMap().get(Integer.valueOf(scheduleId));
        if (activityConfig != null) {
            result.set(1, LuaValue.valueOf(activityConfig.getBeginTime()));
            result.set(2, LuaValue.valueOf(activityConfig.getEndTime()));
        } else {
            result.set(1, LuaValue.valueOf(0));
            result.set(2, LuaValue.valueOf(0));
        }
        return result;
    }

    public int ChangeDeathZone(int is_open, LuaTable var2) {
        logger.debug("[LUA] unimplemented Call ChangeDeathZone with {} {}", Integer.valueOf(is_open), printTable(var2));
        return 0;
    }

    public int GetDeathZoneStatus(int status) {
        logger.debug("[LUA] unimplemented Call GetDeathZoneStatus with {}", Integer.valueOf(status));
        return 0;
    }

    public int GetHostQuestState(int id) {
        logger.debug("[LUA] unimplemented Call GetHostQuestState with {}", Integer.valueOf(id));
        return 0;
    }

    public int ClearPlayerEyePoint(int id) {
        logger.debug("[LUA] unimplemented Call ClearPlayerEyePoint with {}", Integer.valueOf(id));
        return 0;
    }

    public int CheckIsInGroup(int group_id, int gadget_iris) {
        logger.debug("[LUA] unimplemented Call CheckIsInGroup with {},{}", Integer.valueOf(group_id), Integer.valueOf(gadget_iris));
        return 0;
    }

    public int SetGadgetEnableInteract(int group_id, int gadget_aster) {
        logger.warn("[LUA] unimplemented Call SetGadgetEnableInteract with {},{}", Integer.valueOf(group_id), Integer.valueOf(gadget_aster));
        return 0;
    }

    public int EnterWeatherArea(int id_weather) {
        logger.warn("[LUA] unimplemented Call EnterWeatherArea with {}", Integer.valueOf(id_weather));
        for (Player player : getSceneScriptManager().getScene().getPlayers()) {
            player.setWeather(id_weather, player.getClimate());
        }
        return 0;
    }

    public int ModifyFatherChallengeProperty(int id, int type, int value) {
        logger.warn("[LUA] unimplemented Call ModifyFatherChallengeProperty with {},{},{}", Integer.valueOf(id), Integer.valueOf(type), Integer.valueOf(value));
        return 0;
    }

    public int AddSceneTag(int id_scene, int id_tag) {
        logger.warn("[LUA] unimplemented Call AddSceneTag with {},{}", Integer.valueOf(id_scene), Integer.valueOf(id_tag));
        return 0;
    }

    public int GetRegionConfigId(LuaTable config) {
        logger.debug("[LUA] unimplemented Call GetRegionConfigId with {}", config);
        return 0;
    }

    public LuaTable GetCurrentLevelTagVec(int id_tag) {
        logger.warn("[LUA] unimplemented Call GetCurrentLevelTagVec with {}.", Integer.valueOf(id_tag));
        LuaTable result = new LuaTable();
        result.set(1, LuaValue.valueOf(0));
        return result;
    }

    public String GetLevelTagNameById(int current_env_state_id) {
        logger.warn("[LUA] unimplemented Call GetLevelTagNameById with {}", Integer.valueOf(current_env_state_id));
        return "2_4_Day";
    }

    public int UnlockScenePoint(int id_point) {
        logger.warn("[LUA] unimplemented Call UnlockScenePoint with {}", Integer.valueOf(id_point));
        for (Player player : getSceneScriptManager().getScene().getPlayers()) {
            player.sendPacket(new PacketScenePointUnlockNotify(player.getSceneId(), id_point));
        }
        return 0;
    }

    public int StartPlatform(int id_platform) {
        logger.warn("[LUA] unimplemented Call StartPlatform with {}", Integer.valueOf(id_platform));
        for (Player player : getSceneScriptManager().getScene().getPlayers()) {
            Scene scene = player.getScene();
            List<GameEntity> tostart = scene.getEntities().values().stream().filter(gameEntity -> {
                return gameEntity instanceof EntityPlatform;
            }).toList();
            if (tostart.size() == 0) {
                return 1;
            }
            for (GameEntity toadd : tostart) {
                logger.warn("[LUA] start {},{}", Integer.valueOf(toadd.getConfigId()), Integer.valueOf(toadd.getId()));
                scene.broadcastPacket(new PacketPlatformStartRouteNotify((EntityPlatform) toadd, scene));
            }
        }
        return 0;
    }

    public int StopChallenge(int id_regional_challenge, int stage) {
        logger.warn("[LUA] unimplemented Call StopChallenge with {},{}", Integer.valueOf(id_regional_challenge), Integer.valueOf(stage));
        return 0;
    }

    public int SetEntityServerGlobalValueByConfigId(int id, String name, int stats) {
        logger.warn("[LUA] unimplemented Call SetEntityServerGlobalValueByConfigId with {},{},{}", Integer.valueOf(id), name, Integer.valueOf(stats));
        return 0;
    }

    public int SetGroupLogicStateValue(String name, int stats) {
        logger.warn("[LUA] unimplemented Call SetGroupLogicStateValue with {},{}", name, Integer.valueOf(stats));
        return 0;
    }

    public int ModifyClimatePolygonParamTable(int stats, LuaTable var2) {
        logger.warn("[LUA] unimplemented Call ModifyClimatePolygonParamTable with {} {}", Integer.valueOf(stats), printTable(var2));
        return 0;
    }

    public int EndTimeAxis(String var1) {
        logger.warn("[LUA] unimplemented Call EndTimeAxis with {}", var1);
        return 0;
    }

    public int UnlockForce(int force) {
        logger.info("[LUA] Call UnlockForce {}", Integer.valueOf(force));
        getSceneScriptManager().getScene().unlockForce(force);
        return 0;
    }

    public int LockForce(int force) {
        logger.info("[LUA] Call LockForce {}", Integer.valueOf(force));
        getSceneScriptManager().getScene().lockForce(force);
        return 0;
    }
}
