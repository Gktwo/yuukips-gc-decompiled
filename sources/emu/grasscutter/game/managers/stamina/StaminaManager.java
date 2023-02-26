package emu.grasscutter.game.managers.stamina;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.props.LifeState;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.props.WeaponType;
import emu.grasscutter.net.proto.EntityMoveInfoOuterClass;
import emu.grasscutter.net.proto.MotionInfoOuterClass;
import emu.grasscutter.net.proto.MotionStateOuterClass;
import emu.grasscutter.net.proto.PlayerDieTypeOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import emu.grasscutter.net.proto.VehicleInteractTypeOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketAvatarLifeStateChangeNotify;
import emu.grasscutter.server.packet.send.PacketEntityFightPropUpdateNotify;
import emu.grasscutter.server.packet.send.PacketLifeStateChangeNotify;
import emu.grasscutter.server.packet.send.PacketVehicleStaminaNotify;
import emu.grasscutter.utils.Position;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.classic.Logger;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/stamina/StaminaManager.class */
public class StaminaManager extends BasePlayerManager {
    private Timer sustainedStaminaHandlerTimer;
    private static final Map<String, Set<MotionStateOuterClass.MotionState>> MotionStatesCategorized = new HashMap<String, Set<MotionStateOuterClass.MotionState>>() { // from class: emu.grasscutter.game.managers.stamina.StaminaManager.1
        {
            put("CLIMB", Set.of(MotionStateOuterClass.MotionState.MOTION_STATE_CLIMB, MotionStateOuterClass.MotionState.MOTION_STATE_STANDBY_TO_CLIMB));
            put("DASH", Set.of(MotionStateOuterClass.MotionState.MOTION_STATE_DANGER_DASH, MotionStateOuterClass.MotionState.MOTION_STATE_DASH));
            put("FLY", Set.of(MotionStateOuterClass.MotionState.MOTION_STATE_FLY, MotionStateOuterClass.MotionState.MOTION_STATE_FLY_FAST, MotionStateOuterClass.MotionState.MOTION_STATE_FLY_SLOW, MotionStateOuterClass.MotionState.MOTION_STATE_POWERED_FLY));
            put("RUN", Set.of(MotionStateOuterClass.MotionState.MOTION_STATE_DANGER_RUN, MotionStateOuterClass.MotionState.MOTION_STATE_RUN));
            put("SKIFF", Set.of(MotionStateOuterClass.MotionState.MOTION_STATE_SKIFF_BOARDING, MotionStateOuterClass.MotionState.MOTION_STATE_SKIFF_DASH, MotionStateOuterClass.MotionState.MOTION_STATE_SKIFF_NORMAL, MotionStateOuterClass.MotionState.MOTION_STATE_SKIFF_POWERED_DASH));
            put("STANDBY", Set.of(MotionStateOuterClass.MotionState.MOTION_STATE_DANGER_STANDBY_MOVE, MotionStateOuterClass.MotionState.MOTION_STATE_DANGER_STANDBY, MotionStateOuterClass.MotionState.MOTION_STATE_LADDER_TO_STANDBY, MotionStateOuterClass.MotionState.MOTION_STATE_STANDBY_MOVE, MotionStateOuterClass.MotionState.MOTION_STATE_STANDBY));
            put("SWIM", Set.of(MotionStateOuterClass.MotionState.MOTION_STATE_SWIM_IDLE, MotionStateOuterClass.MotionState.MOTION_STATE_SWIM_DASH, MotionStateOuterClass.MotionState.MOTION_STATE_SWIM_JUMP, MotionStateOuterClass.MotionState.MOTION_STATE_SWIM_MOVE));
            put("WALK", Set.of(MotionStateOuterClass.MotionState.MOTION_STATE_DANGER_WALK, MotionStateOuterClass.MotionState.MOTION_STATE_WALK));
            put("OTHER", Set.of(MotionStateOuterClass.MotionState.MOTION_STATE_CLIMB_JUMP, MotionStateOuterClass.MotionState.MOTION_STATE_DASH_BEFORE_SHAKE, MotionStateOuterClass.MotionState.MOTION_STATE_FIGHT, MotionStateOuterClass.MotionState.MOTION_STATE_JUMP_UP_WALL_FOR_STANDBY, MotionStateOuterClass.MotionState.MOTION_STATE_NOTIFY, MotionStateOuterClass.MotionState.MOTION_STATE_SIT_IDLE, MotionStateOuterClass.MotionState.MOTION_STATE_JUMP));
            put("NOCOST_NORECOVER", Set.of(MotionStateOuterClass.MotionState.MOTION_STATE_LADDER_SLIP, MotionStateOuterClass.MotionState.MOTION_STATE_SLIP, MotionStateOuterClass.MotionState.MOTION_STATE_FLY_IDLE));
            put("IGNORE", Set.of((Object[]) new MotionStateOuterClass.MotionState[]{MotionStateOuterClass.MotionState.MOTION_STATE_CROUCH_IDLE, MotionStateOuterClass.MotionState.MOTION_STATE_CROUCH_MOVE, MotionStateOuterClass.MotionState.MOTION_STATE_CROUCH_ROLL, MotionStateOuterClass.MotionState.MOTION_STATE_DESTROY_VEHICLE, MotionStateOuterClass.MotionState.MOTION_STATE_FALL_ON_GROUND, MotionStateOuterClass.MotionState.MOTION_STATE_FOLLOW_ROUTE, MotionStateOuterClass.MotionState.MOTION_STATE_FORCE_SET_POS, MotionStateOuterClass.MotionState.MOTION_STATE_GO_UPSTAIRS, MotionStateOuterClass.MotionState.MOTION_STATE_JUMP_OFF_WALL, MotionStateOuterClass.MotionState.MOTION_STATE_LADDER_IDLE, MotionStateOuterClass.MotionState.MOTION_STATE_LADDER_MOVE, MotionStateOuterClass.MotionState.MOTION_STATE_LAND_SPEED, MotionStateOuterClass.MotionState.MOTION_STATE_MOVE_FAIL_ACK, MotionStateOuterClass.MotionState.MOTION_STATE_NONE, MotionStateOuterClass.MotionState.MOTION_STATE_NUM, MotionStateOuterClass.MotionState.MOTION_STATE_QUEST_FORCE_DRAG, MotionStateOuterClass.MotionState.MOTION_STATE_RESET, MotionStateOuterClass.MotionState.MOTION_STATE_STANDBY_TO_LADDER, MotionStateOuterClass.MotionState.MOTION_STATE_WATERFALL}));
        }
    };
    public static final int GlobalCharacterMaximumStamina = PlayerProperty.PROP_MAX_STAMINA.getMax();
    public static final int GlobalVehicleMaxStamina = PlayerProperty.PROP_MAX_STAMINA.getMax();
    private static final Set<Integer> TalentMovements = Set.of(10013, Integer.valueOf((int) RetcodeOuterClass.Retcode.RET_FUNGUS_FIGHTER_FUNGUS_NOT_CULTIVATED_VALUE));
    private static final HashMap<Integer, Float> ClimbFoodReductionMap = new HashMap<Integer, Float>() { // from class: emu.grasscutter.game.managers.stamina.StaminaManager.2
        {
            put(0, Float.valueOf(0.8f));
        }
    };
    private static final HashMap<Integer, Float> DashFoodReductionMap = new HashMap<Integer, Float>() { // from class: emu.grasscutter.game.managers.stamina.StaminaManager.3
        {
            put(0, Float.valueOf(0.8f));
        }
    };
    private static final HashMap<Integer, Float> FlyFoodReductionMap = new HashMap<Integer, Float>() { // from class: emu.grasscutter.game.managers.stamina.StaminaManager.4
        {
            put(0, Float.valueOf(0.8f));
        }
    };
    private static final HashMap<Integer, Float> SwimFoodReductionMap = new HashMap<Integer, Float>() { // from class: emu.grasscutter.game.managers.stamina.StaminaManager.5
        {
            put(0, Float.valueOf(0.8f));
        }
    };
    private static final HashMap<Integer, Float> ClimbTalentReductionMap = new HashMap<Integer, Float>() { // from class: emu.grasscutter.game.managers.stamina.StaminaManager.6
        {
            put(262301, Float.valueOf(0.8f));
        }
    };
    private static final HashMap<Integer, Float> FlyTalentReductionMap = new HashMap<Integer, Float>() { // from class: emu.grasscutter.game.managers.stamina.StaminaManager.7
        {
            put(212301, Float.valueOf(0.8f));
            put(222301, Float.valueOf(0.8f));
        }
    };
    private static final HashMap<Integer, Float> SwimTalentReductionMap = new HashMap<Integer, Float>() { // from class: emu.grasscutter.game.managers.stamina.StaminaManager.8
        {
            put(242301, Float.valueOf(0.8f));
            put(542301, Float.valueOf(0.8f));
        }
    };
    private final Logger logger = Grasscutter.getLogger();
    private Position currentCoordinates = new Position(0.0f, 0.0f, 0.0f);
    private Position previousCoordinates = new Position(0.0f, 0.0f, 0.0f);
    private MotionStateOuterClass.MotionState currentState = MotionStateOuterClass.MotionState.MOTION_STATE_STANDBY;
    private MotionStateOuterClass.MotionState previousState = MotionStateOuterClass.MotionState.MOTION_STATE_STANDBY;
    private GameSession cachedSession = null;
    private GameEntity cachedEntity = null;
    private int staminaRecoverDelay = 0;
    private final HashMap<String, BeforeUpdateStaminaListener> beforeUpdateStaminaListeners = new HashMap<>();
    private final HashMap<String, AfterUpdateStaminaListener> afterUpdateStaminaListeners = new HashMap<>();
    private int lastSkillId = 0;
    private int lastSkillCasterId = 0;
    private boolean lastSkillFirstTick = true;
    private int vehicleId = -1;
    private int vehicleStamina = GlobalVehicleMaxStamina;

    /*  JADX ERROR: Dependency scan failed at insn: 0x003F: INVOKE_CUSTOM r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x003F: INVOKE_CUSTOM r1, r2, r3, r4, r5, method: emu.grasscutter.game.managers.stamina.StaminaManager.isPlayerMoving():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, F, F, F)Ljava/lang/String;}, isPlayerMoving: , , , , ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, F, F, F)Ljava/lang/String;}, isPlayerMoving: , , , , ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private boolean isPlayerMoving() {
        /*
            r7 = this;
            r0 = r7
            emu.grasscutter.utils.Position r0 = r0.currentCoordinates
            float r0 = r0.getX()
            r1 = r7
            emu.grasscutter.utils.Position r1 = r1.previousCoordinates
            float r1 = r1.getX()
            float r0 = r0 - r1
            r8 = r0
            r0 = r7
            emu.grasscutter.utils.Position r0 = r0.currentCoordinates
            float r0 = r0.getY()
            r1 = r7
            emu.grasscutter.utils.Position r1 = r1.previousCoordinates
            float r1 = r1.getY()
            float r0 = r0 - r1
            r9 = r0
            r0 = r7
            emu.grasscutter.utils.Position r0 = r0.currentCoordinates
            float r0 = r0.getZ()
            r1 = r7
            emu.grasscutter.utils.Position r1 = r1.previousCoordinates
            float r1 = r1.getZ()
            float r0 = r0 - r1
            r10 = r0
            r0 = r7
            ch.qos.logback.classic.Logger r0 = r0.logger
            r1 = r7
            emu.grasscutter.utils.Position r1 = r1.previousCoordinates
            r2 = r7
            emu.grasscutter.utils.Position r2 = r2.currentCoordinates
            r3 = r8
            r4 = r9
            r5 = r10
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, F, F, F)Ljava/lang/String;}, isPlayerMoving: , , , , ]}
            r0.trace(r1)
            r0 = r8
            float r0 = java.lang.Math.abs(r0)
            double r0 = (double) r0
            r1 = 4599075939470750515(0x3fd3333333333333, double:0.3)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x006b
            r0 = r9
            float r0 = java.lang.Math.abs(r0)
            double r0 = (double) r0
            r1 = 4596373779694328218(0x3fc999999999999a, double:0.2)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x006b
            r0 = r10
            float r0 = java.lang.Math.abs(r0)
            double r0 = (double) r0
            r1 = 4599075939470750515(0x3fd3333333333333, double:0.3)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x006f
            r0 = 1
            goto L_0x0070
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.stamina.StaminaManager.isPlayerMoving():boolean");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0095: INVOKE_CUSTOM r-8, r-7, r-6, r-5, r-4
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x00E1: INVOKE_CUSTOM r-16, r-15, r-14, r-13, r-12, r-11, r-10
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
    /*  JADX ERROR: Failed to decode insn: 0x0095: INVOKE_CUSTOM r1, r2, r3, r4, r5, method: emu.grasscutter.game.managers.stamina.StaminaManager.updateStaminaRelative(emu.grasscutter.server.game.GameSession, emu.grasscutter.game.managers.stamina.Consumption, boolean):int
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, Ljava/lang/String;, I, Ljava/lang/String;)Ljava/lang/String;}, Stamina update relative(, ) overridden to relative(, ) by: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, Ljava/lang/String;, I, Ljava/lang/String;)Ljava/lang/String;}, Stamina update relative(, ) overridden to relative(, ) by: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x00E1: INVOKE_CUSTOM r1, r2, r3, r4, r5, r6, r7, method: emu.grasscutter.game.managers.stamina.StaminaManager.updateStaminaRelative(emu.grasscutter.server.game.GameSession, emu.grasscutter.game.managers.stamina.Consumption, boolean):int
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, Lemu/grasscutter/net/proto/MotionStateOuterClass$MotionState;, Ljava/lang/String;, Lemu/grasscutter/game/managers/stamina/ConsumptionType;, I)Ljava/lang/String;}, /			(,)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, Lemu/grasscutter/net/proto/MotionStateOuterClass$MotionState;, Ljava/lang/String;, Lemu/grasscutter/game/managers/stamina/ConsumptionType;, I)Ljava/lang/String;}, /			(,)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public int updateStaminaRelative(emu.grasscutter.server.game.GameSession r10, emu.grasscutter.game.managers.stamina.Consumption r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 280
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.stamina.StaminaManager.updateStaminaRelative(emu.grasscutter.server.game.GameSession, emu.grasscutter.game.managers.stamina.Consumption, boolean):int");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0063: INVOKE_CUSTOM r-8, r-7, r-6, r-5, r-4
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
    /*  JADX ERROR: Failed to decode insn: 0x0063: INVOKE_CUSTOM r1, r2, r3, r4, r5, method: emu.grasscutter.game.managers.stamina.StaminaManager.updateStaminaAbsolute(emu.grasscutter.server.game.GameSession, java.lang.String, int, boolean):int
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, Ljava/lang/String;, I, Ljava/lang/String;)Ljava/lang/String;}, Stamina update absolute(, ) overridden to absolute(, ) by: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, Ljava/lang/String;, I, Ljava/lang/String;)Ljava/lang/String;}, Stamina update absolute(, ) overridden to absolute(, ) by: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public int updateStaminaAbsolute(emu.grasscutter.server.game.GameSession r8, java.lang.String r9, int r10, boolean r11) {
        /*
            r7 = this;
            r0 = r11
            if (r0 == 0) goto L_0x000c
            r0 = r7
            int r0 = r0.getCurrentCharacterStamina()
            goto L_0x0010
            r0 = r7
            int r0 = r0.getCurrentVehicleStamina()
            r12 = r0
            r0 = r7
            java.util.HashMap<java.lang.String, emu.grasscutter.game.managers.stamina.BeforeUpdateStaminaListener> r0 = r0.beforeUpdateStaminaListeners
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r13 = r0
            r0 = r13
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0071
            r0 = r13
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r14 = r0
            r0 = r14
            java.lang.Object r0 = r0.getValue()
            emu.grasscutter.game.managers.stamina.BeforeUpdateStaminaListener r0 = (emu.grasscutter.game.managers.stamina.BeforeUpdateStaminaListener) r0
            r1 = r9
            r2 = r10
            r3 = r11
            int r0 = r0.onBeforeUpdateStamina(r1, r2, r3)
            r15 = r0
            r0 = r15
            r1 = r10
            if (r0 == r1) goto L_0x006e
            r0 = r7
            ch.qos.logback.classic.Logger r0 = r0.logger
            r1 = r9
            r2 = r10
            r3 = r9
            r4 = r10
            r5 = r14
            java.lang.Object r5 = r5.getKey()
            java.lang.String r5 = (java.lang.String) r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, Ljava/lang/String;, I, Ljava/lang/String;)Ljava/lang/String;}, Stamina update absolute(, ) overridden to absolute(, ) by: ]}
            r0.debug(r1)
            r0 = r12
            return r0
            goto L_0x0020
            r0 = r11
            if (r0 == 0) goto L_0x007d
            r0 = r7
            int r0 = r0.getMaxCharacterStamina()
            goto L_0x0081
            r0 = r7
            int r0 = r0.getMaxVehicleStamina()
            r13 = r0
            r0 = r10
            if (r0 >= 0) goto L_0x008c
            r0 = 0
            r10 = r0
            goto L_0x0095
            r0 = r10
            r1 = r13
            if (r0 <= r1) goto L_0x0095
            r0 = r13
            r10 = r0
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            int r0 = r0.setStamina(r1, r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.stamina.StaminaManager.updateStaminaAbsolute(emu.grasscutter.server.game.GameSession, java.lang.String, int, boolean):int");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x001B: INVOKE_CUSTOM r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x001B: INVOKE_CUSTOM r1, r2, r3, method: emu.grasscutter.game.managers.stamina.StaminaManager.handleDrowning():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, Lemu/grasscutter/net/proto/MotionStateOuterClass$MotionState;)Ljava/lang/String;}, /	]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, Lemu/grasscutter/net/proto/MotionStateOuterClass$MotionState;)Ljava/lang/String;}, /	]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private void handleDrowning() {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.getCurrentCharacterStamina()
            r6 = r0
            r0 = r6
            r1 = 10
            if (r0 >= r1) goto L_0x003c
            r0 = r5
            ch.qos.logback.classic.Logger r0 = r0.logger
            r1 = r5
            int r1 = r1.getCurrentCharacterStamina()
            r2 = r5
            int r2 = r2.getMaxCharacterStamina()
            r3 = r5
            emu.grasscutter.net.proto.MotionStateOuterClass$MotionState r3 = r3.currentState
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, Lemu/grasscutter/net/proto/MotionStateOuterClass$MotionState;)Ljava/lang/String;}, /	]}
            r0.trace(r1)
            r0 = r5
            emu.grasscutter.net.proto.MotionStateOuterClass$MotionState r0 = r0.currentState
            emu.grasscutter.net.proto.MotionStateOuterClass$MotionState r1 = emu.grasscutter.net.proto.MotionStateOuterClass.MotionState.MOTION_STATE_SWIM_IDLE
            if (r0 == r1) goto L_0x003c
            r0 = r5
            r1 = r5
            emu.grasscutter.server.game.GameSession r1 = r1.cachedSession
            r2 = r5
            emu.grasscutter.game.entity.GameEntity r2 = r2.cachedEntity
            emu.grasscutter.net.proto.PlayerDieTypeOuterClass$PlayerDieType r3 = emu.grasscutter.net.proto.PlayerDieTypeOuterClass.PlayerDieType.PLAYER_DIE_TYPE_DRAWN
            r0.killAvatar(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.stamina.StaminaManager.handleDrowning():void");
    }

    public static void initialize() {
    }

    public StaminaManager(Player player) {
        super(player);
    }

    public void setSkillCast(int skillId, int skillCasterId) {
        this.lastSkillFirstTick = true;
        this.lastSkillId = skillId;
        this.lastSkillCasterId = skillCasterId;
    }

    public int getMaxCharacterStamina() {
        return this.player.getProperty(PlayerProperty.PROP_MAX_STAMINA);
    }

    public int getCurrentCharacterStamina() {
        return this.player.getProperty(PlayerProperty.PROP_CUR_PERSIST_STAMINA);
    }

    public int getMaxVehicleStamina() {
        return GlobalVehicleMaxStamina;
    }

    public int getCurrentVehicleStamina() {
        return this.vehicleStamina;
    }

    public boolean addCurrentStamina(int amount) {
        int cur = getCurrentCharacterStamina();
        int max = getMaxCharacterStamina();
        if (cur >= max) {
            return false;
        }
        int value = cur + amount;
        if (value > max) {
            value = max;
        }
        this.player.setProperty(PlayerProperty.PROP_CUR_PERSIST_STAMINA, value);
        return true;
    }

    public boolean registerBeforeUpdateStaminaListener(String listenerName, BeforeUpdateStaminaListener listener) {
        if (this.beforeUpdateStaminaListeners.containsKey(listenerName)) {
            return false;
        }
        this.beforeUpdateStaminaListeners.put(listenerName, listener);
        return true;
    }

    public boolean unregisterBeforeUpdateStaminaListener(String listenerName) {
        if (!this.beforeUpdateStaminaListeners.containsKey(listenerName)) {
            return false;
        }
        this.beforeUpdateStaminaListeners.remove(listenerName);
        return true;
    }

    public boolean registerAfterUpdateStaminaListener(String listenerName, AfterUpdateStaminaListener listener) {
        if (this.afterUpdateStaminaListeners.containsKey(listenerName)) {
            return false;
        }
        this.afterUpdateStaminaListeners.put(listenerName, listener);
        return true;
    }

    public boolean unregisterAfterUpdateStaminaListener(String listenerName) {
        if (!this.afterUpdateStaminaListeners.containsKey(listenerName)) {
            return false;
        }
        this.afterUpdateStaminaListeners.remove(listenerName);
        return true;
    }

    public int setStamina(GameSession session, String reason, int newStamina, boolean isCharacterStamina) {
        if (!Configuration.GAME_OPTIONS.staminaUsage || session.getPlayer().getUnlimitedStamina()) {
            newStamina = getMaxCharacterStamina();
        }
        if (isCharacterStamina) {
            this.player.setProperty(PlayerProperty.PROP_CUR_PERSIST_STAMINA, newStamina);
        } else {
            this.vehicleStamina = newStamina;
            session.send(new PacketVehicleStaminaNotify(this.vehicleId, ((float) newStamina) / 100.0f));
        }
        this.afterUpdateStaminaListeners.forEach(k, v -> {
            v.onAfterUpdateStamina(reason, newStamina, isCharacterStamina);
        });
        return newStamina;
    }

    public void killAvatar(GameSession session, GameEntity entity, PlayerDieTypeOuterClass.PlayerDieType dieType) {
        session.send(new PacketAvatarLifeStateChangeNotify(this.player.getTeamManager().getCurrentAvatarEntity().getAvatar(), LifeState.LIFE_DEAD, dieType));
        session.send(new PacketLifeStateChangeNotify(entity, LifeState.LIFE_DEAD, dieType));
        entity.setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, 0.0f);
        entity.getWorld().broadcastPacket(new PacketEntityFightPropUpdateNotify(entity, FightProperty.FIGHT_PROP_CUR_HP));
        entity.getWorld().broadcastPacket(new PacketLifeStateChangeNotify(0, entity, LifeState.LIFE_DEAD));
        this.player.getScene().removeEntity(entity);
        if (entity instanceof EntityAvatar) {
            ((EntityAvatar) entity).onDeath(dieType, 0);
        } else {
            entity.onDeath(0);
        }
    }

    public void startSustainedStaminaHandler() {
        if (!this.player.isPaused() && this.sustainedStaminaHandlerTimer == null) {
            this.sustainedStaminaHandlerTimer = new Timer();
            this.sustainedStaminaHandlerTimer.scheduleAtFixedRate(new SustainedStaminaHandler(), 0, 200);
            this.logger.debug("[MovementManager] SustainedStaminaHandlerTimer started");
        }
    }

    public void stopSustainedStaminaHandler() {
        if (this.sustainedStaminaHandlerTimer != null) {
            this.sustainedStaminaHandlerTimer.cancel();
            this.sustainedStaminaHandlerTimer = null;
            this.logger.debug("[MovementManager] SustainedStaminaHandlerTimer stopped");
        }
    }

    public void handleEvtDoSkillSuccNotify(GameSession session, int skillId, int casterId) {
        if (casterId == this.player.getTeamManager().getCurrentAvatarEntity().getId()) {
            setSkillCast(skillId, casterId);
            if (this.player.getTeamManager().getCurrentAvatarEntity().getAvatar().getAvatarData().getWeaponType() != WeaponType.WEAPON_CLAYMORE) {
            }
        }
    }

    public void handleMixinCostStamina(boolean isSwim) {
        if (this.lastSkillCasterId == this.player.getTeamManager().getCurrentAvatarEntity().getId()) {
            handleImmediateStamina(this.cachedSession, this.lastSkillId);
        }
    }

    public void handleCombatInvocationsNotify(@NotNull GameSession session, @NotNull EntityMoveInfoOuterClass.EntityMoveInfo moveInfo, @NotNull GameEntity entity) {
        this.cachedSession = session;
        this.cachedEntity = entity;
        MotionInfoOuterClass.MotionInfo motionInfo = moveInfo.getMotionInfo();
        MotionStateOuterClass.MotionState motionState = motionInfo.getState();
        int notifyEntityId = entity.getId();
        int currentAvatarEntityId = 0;
        try {
            currentAvatarEntityId = session.getPlayer().getTeamManager().getCurrentAvatarEntity().getId();
        } catch (Exception e) {
        }
        if (currentAvatarEntityId != 0) {
            if (notifyEntityId == currentAvatarEntityId || notifyEntityId == this.vehicleId) {
                this.currentState = motionState;
                VectorOuterClass.Vector posVector = motionInfo.getPos();
                Position newPos = new Position(posVector.getX(), posVector.getY(), posVector.getZ());
                if (!(newPos.getX() == 0.0f || newPos.getY() == 0.0f || newPos.getZ() == 0.0f)) {
                    this.currentCoordinates = newPos;
                }
                startSustainedStaminaHandler();
                handleImmediateStamina(session, motionState);
            }
        }
    }

    public void handleVehicleInteractReq(GameSession session, int vehicleId, VehicleInteractTypeOuterClass.VehicleInteractType vehicleInteractType) {
        if (vehicleInteractType == VehicleInteractTypeOuterClass.VehicleInteractType.VEHICLE_INTERACT_TYPE_IN) {
            this.vehicleId = vehicleId;
            updateStaminaAbsolute(session, "board vehicle", getMaxCharacterStamina(), true);
            updateStaminaAbsolute(session, "board vehicle", getMaxVehicleStamina(), false);
            return;
        }
        this.vehicleId = -1;
    }

    private void handleImmediateStamina(GameSession session, @NotNull MotionStateOuterClass.MotionState motionState) {
        if (this.currentState != motionState) {
            switch (motionState) {
                case MOTION_STATE_CLIMB:
                    updateStaminaRelative(session, new Consumption(ConsumptionType.CLIMB_START), true);
                    return;
                case MOTION_STATE_DASH_BEFORE_SHAKE:
                    updateStaminaRelative(session, new Consumption(ConsumptionType.SPRINT), true);
                    return;
                case MOTION_STATE_CLIMB_JUMP:
                    updateStaminaRelative(session, new Consumption(ConsumptionType.CLIMB_JUMP), true);
                    return;
                case MOTION_STATE_SWIM_DASH:
                    updateStaminaRelative(session, new Consumption(ConsumptionType.SWIM_DASH_START), true);
                    return;
                default:
                    return;
            }
        } else if (motionState.equals(MotionStateOuterClass.MotionState.MOTION_STATE_CLIMB_JUMP)) {
            updateStaminaRelative(session, new Consumption(ConsumptionType.CLIMB_JUMP), true);
        }
    }

    private void handleImmediateStamina(GameSession session, int skillId) {
        updateStaminaRelative(session, getFightConsumption(skillId), true);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:emu/grasscutter/game/managers/stamina/StaminaManager$SustainedStaminaHandler.class */
    public class SustainedStaminaHandler extends TimerTask {
        /*  JADX ERROR: Dependency scan failed at insn: 0x004C: INVOKE_CUSTOM r-2, r-1
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
        /*  JADX ERROR: Dependency scan failed at insn: 0x0293: INVOKE_CUSTOM r-21
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
        /*  JADX ERROR: Failed to decode insn: 0x004C: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.managers.stamina.StaminaManager.SustainedStaminaHandler.run():void
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Z, Z)Ljava/lang/String;}, Player moving: , stamina full: , recalculate stamina]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Z, Z)Ljava/lang/String;}, Player moving: , stamina full: , recalculate stamina]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        /*  JADX ERROR: Failed to decode insn: 0x0293: INVOKE_CUSTOM r1, method: emu.grasscutter.game.managers.stamina.StaminaManager.SustainedStaminaHandler.run():void
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Delaying recovery: ]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Delaying recovery: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            /*
            // Method dump skipped, instructions count: 718
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.stamina.StaminaManager.SustainedStaminaHandler.run():void");
        }

        private SustainedStaminaHandler() {
        }
    }

    private Consumption getFightConsumption(int skillCasting) {
        if (TalentMovements.contains(Integer.valueOf(skillCasting))) {
            return getTalentMovingSustainedCost(skillCasting);
        }
        this.player.getTeamManager().getCurrentAvatarEntity().getAvatar();
        switch (currentAvatar.getAvatarData().getWeaponType()) {
            case WEAPON_BOW:
                return getBowSustainedCost(skillCasting);
            case WEAPON_CLAYMORE:
                return getClaymoreSustainedCost(skillCasting);
            case WEAPON_CATALYST:
                return getCatalystCost(skillCasting);
            case WEAPON_POLE:
                return getPolearmCost(skillCasting);
            case WEAPON_SWORD_ONE_HAND:
                return getSwordCost(skillCasting);
            default:
                return new Consumption();
        }
    }

    private Consumption getClimbConsumption() {
        Consumption consumption = new Consumption();
        if (this.currentState == MotionStateOuterClass.MotionState.MOTION_STATE_CLIMB && isPlayerMoving()) {
            consumption.type = ConsumptionType.CLIMBING;
            consumption.amount = ConsumptionType.CLIMBING.amount;
        }
        consumption.amount = (int) (((float) consumption.amount) * getFoodCostReductionFactor(ClimbFoodReductionMap));
        consumption.amount = (int) (((float) consumption.amount) * getTalentCostReductionFactor(ClimbTalentReductionMap));
        return consumption;
    }

    private Consumption getSwimConsumptions() {
        handleDrowning();
        Consumption consumption = new Consumption();
        if (this.currentState == MotionStateOuterClass.MotionState.MOTION_STATE_SWIM_MOVE) {
            consumption.type = ConsumptionType.SWIMMING;
            consumption.amount = ConsumptionType.SWIMMING.amount;
        }
        if (this.currentState == MotionStateOuterClass.MotionState.MOTION_STATE_SWIM_DASH) {
            consumption.type = ConsumptionType.SWIM_DASH;
            consumption.amount = ConsumptionType.SWIM_DASH.amount;
        }
        consumption.amount = (int) (((float) consumption.amount) * getFoodCostReductionFactor(SwimFoodReductionMap));
        consumption.amount = (int) (((float) consumption.amount) * getTalentCostReductionFactor(SwimTalentReductionMap));
        return consumption;
    }

    private Consumption getDashConsumption() {
        Consumption consumption = new Consumption();
        if (this.currentState == MotionStateOuterClass.MotionState.MOTION_STATE_DASH) {
            consumption.type = ConsumptionType.DASH;
            consumption.amount = ConsumptionType.DASH.amount;
            consumption.amount = (int) (((float) consumption.amount) * getFoodCostReductionFactor(DashFoodReductionMap));
        }
        return consumption;
    }

    private Consumption getFlyConsumption() {
        if (this.currentState == MotionStateOuterClass.MotionState.MOTION_STATE_POWERED_FLY) {
            return new Consumption(ConsumptionType.POWERED_FLY);
        }
        Consumption consumption = new Consumption(ConsumptionType.FLY);
        consumption.amount = (int) (((float) consumption.amount) * getFoodCostReductionFactor(FlyFoodReductionMap));
        consumption.amount = (int) (((float) consumption.amount) * getTalentCostReductionFactor(FlyTalentReductionMap));
        return consumption;
    }

    private Consumption getSkiffConsumption() {
        switch (this.currentState) {
            case MOTION_STATE_SKIFF_DASH:
                return new Consumption(ConsumptionType.SKIFF_DASH);
            case MOTION_STATE_SKIFF_POWERED_DASH:
                return new Consumption(ConsumptionType.POWERED_SKIFF);
            case MOTION_STATE_SKIFF_NORMAL:
                return new Consumption(ConsumptionType.SKIFF);
            default:
                return new Consumption();
        }
    }

    private Consumption getOtherConsumptions() {
        switch (this.currentState) {
            case MOTION_STATE_FIGHT:
                return new Consumption(ConsumptionType.FIGHT, 500);
            default:
                return new Consumption();
        }
    }

    private float getTalentCostReductionFactor(HashMap<Integer, Float> talentReductionMap) {
        float reduction = 1.0f;
        for (EntityAvatar entity : this.cachedSession.getPlayer().getTeamManager().getActiveTeam()) {
            for (Integer num : entity.getAvatar().getProudSkillList()) {
                int skillId = num.intValue();
                if (talentReductionMap.containsKey(Integer.valueOf(skillId))) {
                    float potentialLowerReduction = talentReductionMap.get(Integer.valueOf(skillId)).floatValue();
                    if (potentialLowerReduction < reduction) {
                        reduction = potentialLowerReduction;
                    }
                }
            }
        }
        return reduction;
    }

    private float getFoodCostReductionFactor(HashMap<Integer, Float> foodReductionMap) {
        return 1.0f;
    }

    private Consumption getTalentMovingSustainedCost(int skillId) {
        if (!this.lastSkillFirstTick) {
            return new Consumption(ConsumptionType.TALENT_DASH, -500);
        }
        this.lastSkillFirstTick = false;
        return new Consumption(ConsumptionType.TALENT_DASH, -1000);
    }

    private Consumption getBowSustainedCost(int skillId) {
        return new Consumption(ConsumptionType.FIGHT, 500);
    }

    private Consumption getCatalystCost(int skillId) {
        return new Consumption(ConsumptionType.FIGHT, -5000);
    }

    private Consumption getClaymoreSustainedCost(int skillId) {
        Consumption consumption = new Consumption(ConsumptionType.FIGHT, -1333);
        switch (skillId) {
            case 10160:
                if (this.player.getTeamManager().getCurrentAvatarEntity().getAvatar().getProudSkillList().contains(162101)) {
                    consumption.amount /= 2;
                    break;
                }
                break;
            case 10532:
            case 10571:
                consumption.amount = 0;
                break;
        }
        return consumption;
    }

    private Consumption getPolearmCost(int skillId) {
        return new Consumption(ConsumptionType.FIGHT, -2500);
    }

    private Consumption getSwordCost(int skillId) {
        Consumption consumption = new Consumption(ConsumptionType.FIGHT, -2000);
        switch (skillId) {
            case 10421:
                consumption.amount = -2500;
                break;
        }
        return consumption;
    }
}
