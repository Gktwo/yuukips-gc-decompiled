package emu.grasscutter.game.dungeons.challenge.factory;

import emu.grasscutter.game.props.SceneType;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.data.SceneGroup;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/challenge/factory/TimeChallengeKeepingGadgetFactoryHandler.class */
public class TimeChallengeKeepingGadgetFactoryHandler implements ChallengeFactoryHandler {
    /*  JADX ERROR: Dependency scan failed at insn: 0x0004: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0004: INVOKE_CUSTOM r1, method: emu.grasscutter.game.dungeons.challenge.factory.TimeChallengeKeepingGadgetFactoryHandler.build(int, int, int, int, int, int, emu.grasscutter.game.world.Scene, emu.grasscutter.scripts.data.SceneGroup):emu.grasscutter.game.dungeons.challenge.WorldChallenge
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Start TimeChallengeKeepingGadgetFactoryHandler: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Start TimeChallengeKeepingGadgetFactoryHandler: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.game.dungeons.challenge.factory.ChallengeFactoryHandler
    public emu.grasscutter.game.dungeons.challenge.WorldChallenge build(int r15, int r16, int r17, int r18, int r19, int r20, emu.grasscutter.game.world.Scene r21, emu.grasscutter.scripts.data.SceneGroup r22) {
        /*
            r14 = this;
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r15
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Start TimeChallengeKeepingGadgetFactoryHandler: ]}
            r0.warn(r1)
            emu.grasscutter.game.dungeons.challenge.DungeonChallenge r0 = new emu.grasscutter.game.dungeons.challenge.DungeonChallenge
            r1 = r0
            r2 = r21
            r3 = r22
            r4 = r15
            r5 = r16
            r6 = r19
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7 = r18
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.util.List r6 = java.util.List.of(r6, r7, r8)
            r7 = r19
            r8 = r18
            emu.grasscutter.game.dungeons.challenge.trigger.InTimeTrigger r9 = new emu.grasscutter.game.dungeons.challenge.trigger.InTimeTrigger
            r10 = r9
            r10.<init>()
            emu.grasscutter.game.dungeons.challenge.trigger.KillMonsterTrigger r10 = new emu.grasscutter.game.dungeons.challenge.trigger.KillMonsterTrigger
            r11 = r10
            r11.<init>()
            emu.grasscutter.game.dungeons.challenge.trigger.GuardTrigger r11 = new emu.grasscutter.game.dungeons.challenge.trigger.GuardTrigger
            r12 = r11
            r12.<init>()
            java.util.List r9 = java.util.List.of(r9, r10, r11)
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.dungeons.challenge.factory.TimeChallengeKeepingGadgetFactoryHandler.build(int, int, int, int, int, int, emu.grasscutter.game.world.Scene, emu.grasscutter.scripts.data.SceneGroup):emu.grasscutter.game.dungeons.challenge.WorldChallenge");
    }

    @Override // emu.grasscutter.game.dungeons.challenge.factory.ChallengeFactoryHandler
    public boolean isThisType(int id_challenge, int type_challenge, int id_grup, int goal_kill, int timer, int step, Scene scene, SceneGroup group) {
        return scene.getSceneType() == SceneType.SCENE_DUNGEON && id_grup == group.f922id && type_challenge == 188;
    }
}
