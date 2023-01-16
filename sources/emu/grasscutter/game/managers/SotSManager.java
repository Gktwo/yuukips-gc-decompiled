package emu.grasscutter.game.managers;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.PlayerProperty;
import java.util.Timer;
import java.util.TimerTask;
import p001ch.qos.logback.classic.Logger;
import p013io.netty.handler.traffic.AbstractTrafficShapingHandler;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/SotSManager.class */
public class SotSManager extends BasePlayerManager {
    private Timer autoRecoverTimer;
    public static final int GlobalMaximumSpringVolume = PlayerProperty.PROP_MAX_SPRING_VOLUME.getMax();
    private final Logger logger = Grasscutter.getLogger();
    private final boolean enablePriorityHealing = false;

    /*  JADX ERROR: Dependency scan failed at insn: 0x006C: INVOKE_CUSTOM r-6, r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x006C: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.managers.SotSManager.checkAndHealAvatar(emu.grasscutter.game.entity.EntityAvatar):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I)Ljava/lang/String;}, Healing avatar  +]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I)Ljava/lang/String;}, Healing avatar  +]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void checkAndHealAvatar(emu.grasscutter.game.entity.EntityAvatar r11) {
        /*
            r10 = this;
            r0 = r11
            emu.grasscutter.game.props.FightProperty r1 = emu.grasscutter.game.props.FightProperty.FIGHT_PROP_MAX_HP
            float r0 = r0.getFightProperty(r1)
            r1 = 1120403456(0x42c80000, float:100.0)
            float r0 = r0 * r1
            int r0 = (int) r0
            r12 = r0
            r0 = r11
            emu.grasscutter.game.props.FightProperty r1 = emu.grasscutter.game.props.FightProperty.FIGHT_PROP_CUR_HP
            float r0 = r0.getFightProperty(r1)
            r1 = 1120403456(0x42c80000, float:100.0)
            float r0 = r0 * r1
            int r0 = (int) r0
            r13 = r0
            r0 = r13
            r1 = r12
            if (r0 != r1) goto L_0x001e
            return
            r0 = r12
            r1 = r10
            int r1 = r1.getAutoRecoveryPercentage()
            int r0 = r0 * r1
            r1 = 100
            int r0 = r0 / r1
            r14 = r0
            r0 = r14
            r1 = r13
            if (r0 <= r1) goto L_0x00c6
            r0 = r14
            r1 = r13
            int r0 = r0 - r1
            r15 = r0
            r0 = r10
            int r0 = r0.getCurrentVolume()
            r16 = r0
            r0 = r16
            r1 = r15
            if (r0 < r1) goto L_0x004e
            r0 = r10
            r1 = r16
            r2 = r15
            int r1 = r1 - r2
            r0.setCurrentVolume(r1)
            goto L_0x0057
            r0 = r16
            r15 = r0
            r0 = r10
            r1 = 0
            r0.setCurrentVolume(r1)
            r0 = r15
            if (r0 <= 0) goto L_0x00c6
            r0 = r10
            ch.qos.logback.classic.Logger r0 = r0.logger
            r1 = r11
            emu.grasscutter.game.avatar.Avatar r1 = r1.getAvatar()
            emu.grasscutter.data.excels.AvatarData r1 = r1.getAvatarData()
            java.lang.String r1 = r1.getName()
            r2 = r15
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I)Ljava/lang/String;}, Healing avatar  +]}
            r0.trace(r1)
            r0 = r10
            emu.grasscutter.game.player.Player r0 = r0.player
            emu.grasscutter.game.player.TeamManager r0 = r0.getTeamManager()
            r1 = r11
            emu.grasscutter.game.avatar.Avatar r1 = r1.getAvatar()
            r2 = 0
            r3 = r15
            boolean r0 = r0.healAvatar(r1, r2, r3)
            r0 = r10
            emu.grasscutter.game.player.Player r0 = r0.player
            emu.grasscutter.server.game.GameSession r0 = r0.getSession()
            emu.grasscutter.server.packet.send.PacketEntityFightPropChangeReasonNotify r1 = new emu.grasscutter.server.packet.send.PacketEntityFightPropChangeReasonNotify
            r2 = r1
            r3 = r11
            emu.grasscutter.game.props.FightProperty r4 = emu.grasscutter.game.props.FightProperty.FIGHT_PROP_CUR_HP
            r5 = r15
            float r5 = (float) r5
            r6 = 1120403456(0x42c80000, float:100.0)
            float r5 = r5 / r6
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r6 = 3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.util.List r6 = java.util.List.of(r6)
            emu.grasscutter.net.proto.PropChangeReasonOuterClass$PropChangeReason r7 = emu.grasscutter.net.proto.PropChangeReasonOuterClass.PropChangeReason.PROP_CHANGE_REASON_STATUE_RECOVER
            emu.grasscutter.net.proto.ChangeHpReasonOuterClass$ChangeHpReason r8 = emu.grasscutter.net.proto.ChangeHpReasonOuterClass.ChangeHpReason.CHANGE_HP_REASON_ADD_STATUE
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0.send(r1)
            r0 = r10
            emu.grasscutter.game.player.Player r0 = r0.player
            emu.grasscutter.server.game.GameSession r0 = r0.getSession()
            emu.grasscutter.server.packet.send.PacketEntityFightPropUpdateNotify r1 = new emu.grasscutter.server.packet.send.PacketEntityFightPropUpdateNotify
            r2 = r1
            r3 = r11
            emu.grasscutter.game.props.FightProperty r4 = emu.grasscutter.game.props.FightProperty.FIGHT_PROP_CUR_HP
            r2.<init>(r3, r4)
            r0.send(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.SotSManager.checkAndHealAvatar(emu.grasscutter.game.entity.EntityAvatar):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0043: INVOKE_CUSTOM r-6
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0059: INVOKE_CUSTOM r-9
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
    /*  JADX ERROR: Failed to decode insn: 0x0043: INVOKE_CUSTOM r1, method: emu.grasscutter.game.managers.SotSManager.refillSpringVolume():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Statue has refilled HP volume: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Statue has refilled HP volume: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0059: INVOKE_CUSTOM r1, method: emu.grasscutter.game.managers.SotSManager.refillSpringVolume():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Statue remaining HP volume: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Statue remaining HP volume: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void refillSpringVolume() {
        /*
            r5 = this;
            r0 = r5
            r1 = 8500000(0x81b320, float:1.1911037E-38)
            r0.setMaxVolume(r1)
            r0 = r5
            r1 = 100
            r0.setAutoRecoveryPercentage(r1)
            r0 = r5
            r1 = 1
            r0.setIsAutoRecoveryEnabled(r1)
            r0 = r5
            int r0 = r0.getMaxVolume()
            r6 = r0
            r0 = r5
            int r0 = r0.getCurrentVolume()
            r7 = r0
            r0 = r7
            r1 = r6
            if (r0 >= r1) goto L_0x0066
            long r0 = java.lang.System.currentTimeMillis()
            r1 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r1
            r8 = r0
            r0 = r8
            r1 = r5
            long r1 = r1.getLastUsed()
            long r0 = r0 - r1
            int r0 = (int) r0
            r10 = r0
            r0 = r10
            r1 = r6
            int r0 = r0 * r1
            r1 = 15
            int r0 = r0 / r1
            r1 = 100
            int r0 = r0 / r1
            r11 = r0
            r0 = r5
            ch.qos.logback.classic.Logger r0 = r0.logger
            r1 = r11
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Statue has refilled HP volume: ]}
            r0.trace(r1)
            r0 = r7
            r1 = r11
            int r0 = r0 + r1
            r1 = r6
            int r0 = java.lang.Math.min(r0, r1)
            r7 = r0
            r0 = r5
            ch.qos.logback.classic.Logger r0 = r0.logger
            r1 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Statue remaining HP volume: ]}
            r0.trace(r1)
            r0 = r5
            r1 = r7
            r0.setCurrentVolume(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.SotSManager.refillSpringVolume():void");
    }

    public SotSManager(Player player) {
        super(player);
    }

    public boolean getIsAutoRecoveryEnabled() {
        return this.player.getProperty(PlayerProperty.PROP_IS_SPRING_AUTO_USE) == 1;
    }

    public void setIsAutoRecoveryEnabled(boolean enabled) {
        this.player.setProperty(PlayerProperty.PROP_IS_SPRING_AUTO_USE, enabled ? 1 : 0);
        this.player.save();
    }

    public int getAutoRecoveryPercentage() {
        return this.player.getProperty(PlayerProperty.PROP_SPRING_AUTO_USE_PERCENT);
    }

    public void setAutoRecoveryPercentage(int percentage) {
        this.player.setProperty(PlayerProperty.PROP_SPRING_AUTO_USE_PERCENT, percentage);
        this.player.save();
    }

    public long getLastUsed() {
        return this.player.getSpringLastUsed();
    }

    public void setLastUsed() {
        this.player.setSpringLastUsed(System.currentTimeMillis() / 1000);
        this.player.save();
    }

    public int getMaxVolume() {
        return this.player.getProperty(PlayerProperty.PROP_MAX_SPRING_VOLUME);
    }

    public void setMaxVolume(int volume) {
        this.player.setProperty(PlayerProperty.PROP_MAX_SPRING_VOLUME, volume);
        this.player.save();
    }

    public int getCurrentVolume() {
        return this.player.getProperty(PlayerProperty.PROP_CUR_SPRING_VOLUME);
    }

    public void setCurrentVolume(int volume) {
        this.player.setProperty(PlayerProperty.PROP_CUR_SPRING_VOLUME, volume);
        setLastUsed();
        this.player.save();
    }

    public void handleEnterTransPointRegionNotify() {
        this.logger.trace("Player entered statue region");
        autoRevive();
        if (this.autoRecoverTimer == null) {
            this.autoRecoverTimer = new Timer();
            this.autoRecoverTimer.schedule(new AutoRecoverTimerTick(), 2500, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME);
        }
    }

    public void handleExitTransPointRegionNotify() {
        this.logger.trace("Player left statue region");
        if (this.autoRecoverTimer != null) {
            this.autoRecoverTimer.cancel();
            this.autoRecoverTimer = null;
        }
    }

    public void autoRevive() {
        this.player.getTeamManager().getActiveTeam().forEach(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: INVOKE  
              (wrap: java.util.List<emu.grasscutter.game.entity.EntityAvatar> : 0x0007: INVOKE  (r0v3 java.util.List<emu.grasscutter.game.entity.EntityAvatar> A[REMOVE]) = 
              (wrap: emu.grasscutter.game.player.TeamManager : 0x0004: INVOKE  (r0v2 emu.grasscutter.game.player.TeamManager A[REMOVE]) = 
              (wrap: emu.grasscutter.game.player.Player : 0x0001: IGET  (r0v1 emu.grasscutter.game.player.Player A[REMOVE]) = 
              (r3v0 'this' emu.grasscutter.game.managers.SotSManager A[D('this' emu.grasscutter.game.managers.SotSManager), IMMUTABLE_TYPE, THIS])
             emu.grasscutter.game.managers.SotSManager.player emu.grasscutter.game.player.Player)
             type: VIRTUAL call: emu.grasscutter.game.player.Player.getTeamManager():emu.grasscutter.game.player.TeamManager)
             type: VIRTUAL call: emu.grasscutter.game.player.TeamManager.getActiveTeam():java.util.List)
              (wrap: java.util.function.Consumer : 0x000b: INVOKE_CUSTOM (r1v1 java.util.function.Consumer A[REMOVE]) = 
              (r3v0 'this' emu.grasscutter.game.managers.SotSManager A[D('this' emu.grasscutter.game.managers.SotSManager), DONT_INLINE, IMMUTABLE_TYPE, THIS])
            
             handle type: INVOKE_INSTANCE
             lambda: java.util.function.Consumer.accept(java.lang.Object):void
             call insn: ?: INVOKE  (r1 I:emu.grasscutter.game.managers.SotSManager), (v1 emu.grasscutter.game.entity.EntityAvatar) type: VIRTUAL call: emu.grasscutter.game.managers.SotSManager.lambda$autoRevive$0(emu.grasscutter.game.entity.EntityAvatar):void)
             type: INTERFACE call: java.util.List.forEach(java.util.function.Consumer):void in method: emu.grasscutter.game.managers.SotSManager.autoRevive():void, file: grasscutter.jar:emu/grasscutter/game/managers/SotSManager.class
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
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
            r0 = r3
            emu.grasscutter.game.player.Player r0 = r0.player
            emu.grasscutter.game.player.TeamManager r0 = r0.getTeamManager()
            java.util.List r0 = r0.getActiveTeam()
            r1 = r3
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$autoRevive$0(v1);
            }
            r0.forEach(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.SotSManager.autoRevive():void");
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/managers/SotSManager$AutoRecoverTimerTick.class */
    private class AutoRecoverTimerTick extends TimerTask {
        /*  JADX ERROR: Dependency scan failed at insn: 0x001C: INVOKE_CUSTOM r-3, r-2
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
        /*  JADX ERROR: Failed to decode insn: 0x001C: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.managers.SotSManager.AutoRecoverTimerTick.run():void
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Z, I)Ljava/lang/String;}, isAutoRecoveryEnabled: 	autoRecoverPercentage: ]}
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
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Z, I)Ljava/lang/String;}, isAutoRecoveryEnabled: 	autoRecoverPercentage: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            /*
                r4 = this;
                r0 = r4
                emu.grasscutter.game.managers.SotSManager r0 = emu.grasscutter.game.managers.SotSManager.this
                r0.refillSpringVolume()
                r0 = r4
                emu.grasscutter.game.managers.SotSManager r0 = emu.grasscutter.game.managers.SotSManager.this
                ch.qos.logback.classic.Logger r0 = r0.logger
                r1 = r4
                emu.grasscutter.game.managers.SotSManager r1 = emu.grasscutter.game.managers.SotSManager.this
                boolean r1 = r1.getIsAutoRecoveryEnabled()
                r2 = r4
                emu.grasscutter.game.managers.SotSManager r2 = emu.grasscutter.game.managers.SotSManager.this
                int r2 = r2.getAutoRecoveryPercentage()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Z, I)Ljava/lang/String;}, isAutoRecoveryEnabled: 	autoRecoverPercentage: ]}
                r0.trace(r1)
                r0 = r4
                emu.grasscutter.game.managers.SotSManager r0 = emu.grasscutter.game.managers.SotSManager.this
                boolean r0 = r0.getIsAutoRecoveryEnabled()
                if (r0 == 0) goto L_0x007b
                r0 = r4
                emu.grasscutter.game.managers.SotSManager r0 = emu.grasscutter.game.managers.SotSManager.this
                emu.grasscutter.game.player.Player r0 = emu.grasscutter.game.managers.SotSManager.access$000(r0)
                emu.grasscutter.game.player.TeamManager r0 = r0.getTeamManager()
                java.util.List r0 = r0.getActiveTeam()
                r5 = r0
                r0 = -1
                r6 = r0
                r0 = r6
                if (r0 < 0) goto L_0x0053
                r0 = r4
                emu.grasscutter.game.managers.SotSManager r0 = emu.grasscutter.game.managers.SotSManager.this
                r1 = r5
                r2 = r6
                java.lang.Object r1 = r1.get(r2)
                emu.grasscutter.game.entity.EntityAvatar r1 = (emu.grasscutter.game.entity.EntityAvatar) r1
                r0.checkAndHealAvatar(r1)
                r0 = 0
                r7 = r0
                r0 = r7
                r1 = r5
                int r1 = r1.size()
                if (r0 >= r1) goto L_0x007b
                r0 = r7
                r1 = r6
                if (r0 == r1) goto L_0x0075
                r0 = r4
                emu.grasscutter.game.managers.SotSManager r0 = emu.grasscutter.game.managers.SotSManager.this
                r1 = r5
                r2 = r7
                java.lang.Object r1 = r1.get(r2)
                emu.grasscutter.game.entity.EntityAvatar r1 = (emu.grasscutter.game.entity.EntityAvatar) r1
                r0.checkAndHealAvatar(r1)
                int r7 = r7 + 1
                goto L_0x0055
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.SotSManager.AutoRecoverTimerTick.run():void");
        }

        private AutoRecoverTimerTick() {
        }
    }
}
