package emu.grasscutter.game.dungeons.challenge.factory;

import emu.grasscutter.game.props.SceneType;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.data.SceneGroup;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/challenge/factory/DungeonGuardChallengeFactoryHandler.class */
public class DungeonGuardChallengeFactoryHandler implements ChallengeFactoryHandler {
    /*  JADX ERROR: Dependency scan failed at insn: 0x0013: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0013: INVOKE_CUSTOM r1, method: emu.grasscutter.game.dungeons.challenge.factory.DungeonGuardChallengeFactoryHandler.build(int, int, int, int, int, int, emu.grasscutter.game.world.Scene, emu.grasscutter.scripts.data.SceneGroup):emu.grasscutter.game.dungeons.challenge.WorldChallenge
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Start DungeonGuardChallengeFactoryHandler: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Start DungeonGuardChallengeFactoryHandler: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.game.dungeons.challenge.factory.ChallengeFactoryHandler
    public emu.grasscutter.game.dungeons.challenge.WorldChallenge build(int r13, int r14, int r15, int r16, int r17, int r18, emu.grasscutter.game.world.Scene r19, emu.grasscutter.scripts.data.SceneGroup r20) {
        /*
            r12 = this;
            r0 = r19
            emu.grasscutter.scripts.SceneScriptManager r0 = r0.getScriptManager()
            r1 = r15
            emu.grasscutter.scripts.data.SceneGroup r0 = r0.getGroupById(r1)
            r21 = r0
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r21
            int r1 = r1.f957id
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Start DungeonGuardChallengeFactoryHandler: ]}
            r0.info(r1)
            emu.grasscutter.game.dungeons.challenge.DungeonChallenge r0 = new emu.grasscutter.game.dungeons.challenge.DungeonChallenge
            r1 = r0
            r2 = r19
            r3 = r21
            r4 = r14
            r5 = r13
            r6 = r16
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.util.List r6 = java.util.List.of(r6, r7)
            r7 = 0
            r8 = r17
            emu.grasscutter.game.dungeons.challenge.trigger.GuardTrigger r9 = new emu.grasscutter.game.dungeons.challenge.trigger.GuardTrigger
            r10 = r9
            r10.<init>()
            java.util.List r9 = java.util.List.of(r9)
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.dungeons.challenge.factory.DungeonGuardChallengeFactoryHandler.build(int, int, int, int, int, int, emu.grasscutter.game.world.Scene, emu.grasscutter.scripts.data.SceneGroup):emu.grasscutter.game.dungeons.challenge.WorldChallenge");
    }

    @Override // emu.grasscutter.game.dungeons.challenge.factory.ChallengeFactoryHandler
    public boolean isThisType(int challengeIndex, int challengeId, int param3, int param4, int param5, int param6, Scene scene, SceneGroup group) {
        return scene.getSceneType() == SceneType.SCENE_DUNGEON && param3 == group.f957id;
    }
}
