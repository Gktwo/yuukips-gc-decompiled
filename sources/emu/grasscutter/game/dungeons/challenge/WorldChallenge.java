package emu.grasscutter.game.dungeons.challenge;

import emu.grasscutter.game.dungeons.challenge.trigger.ChallengeTrigger;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.EntityMonster;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.data.SceneGroup;
import emu.grasscutter.server.packet.send.PacketDungeonChallengeFinishNotify;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/challenge/WorldChallenge.class */
public class WorldChallenge {
    private final Scene scene;
    private final SceneGroup group;
    private final int challengeId;
    private final int challengeIndex;
    private final List<Integer> paramList;
    private final List<ChallengeTrigger> challengeTriggers;
    private boolean progress;
    private boolean success;
    private long startedAt;
    private final int timeLimit;
    private int finishedTime;
    private final int goal;
    private final AtomicInteger score = new AtomicInteger(0);

    /*  JADX ERROR: Dependency scan failed at insn: 0x0017: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0017: INVOKE_CUSTOM r1, method: emu.grasscutter.game.dungeons.challenge.WorldChallenge.start():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, start WorldChallenge: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, start WorldChallenge: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void start() {
        /*
            r5 = this;
            r0 = r5
            boolean r0 = r0.inProgress()
            if (r0 == 0) goto L_0x0010
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Could not start a in progress challenge."
            r0.info(r1)
            return
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r5
            int r1 = r1.challengeId
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, start WorldChallenge: ]}
            r0.info(r1)
            r0 = r5
            r1 = 1
            r0.progress = r1
            r0 = r5
            long r1 = java.lang.System.currentTimeMillis()
            r0.startedAt = r1
            r0 = r5
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            emu.grasscutter.server.packet.send.PacketDungeonChallengeBeginNotify r1 = new emu.grasscutter.server.packet.send.PacketDungeonChallengeBeginNotify
            r2 = r1
            r3 = r5
            r2.<init>(r3)
            r0.broadcastPacket(r1)
            r0 = r5
            java.util.List<emu.grasscutter.game.dungeons.challenge.trigger.ChallengeTrigger> r0 = r0.challengeTriggers
            r1 = r5
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$start$1(v1);
            }
            r0.forEach(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.dungeons.challenge.WorldChallenge.start():void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0017: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0042: INVOKE_CUSTOM r-9, r-8, r-7, r-6, r-5, r-4
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
    /*  JADX ERROR: Failed to decode insn: 0x0017: INVOKE_CUSTOM r1, method: emu.grasscutter.game.dungeons.challenge.WorldChallenge.done():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Complete challenge (ID/Index):]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Complete challenge (ID/Index):]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0042: INVOKE_CUSTOM r1, r2, r3, r4, r5, r6, method: emu.grasscutter.game.dungeons.challenge.WorldChallenge.done():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, I, I)Ljava/lang/String;}, Done -> ( Index ) Time: / | Goal / ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, I, I)Ljava/lang/String;}, Done -> ( Index ) Time: / | Goal / ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void done() {
        /*
            r8 = this;
            r0 = r8
            boolean r0 = r0.inProgress()
            if (r0 != 0) goto L_0x0010
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Could not done a in progress challenge."
            r0.info(r1)
            return
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r8
            int r1 = r1.challengeId
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Complete challenge (ID/Index):]}
            r0.info(r1)
            r0 = r8
            r1 = 1
            r0.finish(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r8
            int r1 = r1.challengeId
            r2 = r8
            int r2 = r2.challengeIndex
            r3 = r8
            int r3 = r3.finishedTime
            r4 = r8
            int r4 = r4.timeLimit
            r5 = r8
            int r5 = r5.goal
            r6 = r8
            java.util.concurrent.atomic.AtomicInteger r6 = r6.score
            int r6 = r6.intValue()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, I, I)Ljava/lang/String;}, Done -> ( Index ) Time: / | Goal / ]}
            r0.info(r1)
            goto L_0x004e
            r9 = move-exception
            r0 = r8
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            emu.grasscutter.scripts.SceneScriptManager r0 = r0.getScriptManager()
            emu.grasscutter.scripts.data.ScriptArgs r1 = new emu.grasscutter.scripts.data.ScriptArgs
            r2 = r1
            r3 = 16
            r2.<init>(r3)
            r2 = r8
            int r2 = r2.finishedTime
            emu.grasscutter.scripts.data.ScriptArgs r1 = r1.setParam2(r2)
            r0.callEvent(r1)
            r0 = r8
            java.util.List<emu.grasscutter.game.dungeons.challenge.trigger.ChallengeTrigger> r0 = r0.challengeTriggers
            r1 = r8
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$done$2(v1);
            }
            r0.forEach(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.dungeons.challenge.WorldChallenge.done():void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x000F: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x000F: INVOKE_CUSTOM r1, method: emu.grasscutter.game.dungeons.challenge.WorldChallenge.fail():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Challenge failed: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Challenge failed: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void fail() {
        /*
            r5 = this;
            r0 = r5
            boolean r0 = r0.inProgress()
            if (r0 != 0) goto L_0x0008
            return
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r5
            int r1 = r1.challengeId
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Challenge failed: ]}
            r0.error(r1)
            r0 = r5
            r1 = 0
            r0.finish(r1)
            r0 = r5
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            emu.grasscutter.scripts.SceneScriptManager r0 = r0.getScriptManager()
            emu.grasscutter.scripts.data.ScriptArgs r1 = new emu.grasscutter.scripts.data.ScriptArgs
            r2 = r1
            r3 = 17
            r2.<init>(r3)
            r0.callEvent(r1)
            r0 = r5
            java.util.List<emu.grasscutter.game.dungeons.challenge.trigger.ChallengeTrigger> r0 = r0.challengeTriggers
            r1 = r5
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$fail$3(v1);
            }
            r0.forEach(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.dungeons.challenge.WorldChallenge.fail():void");
    }

    public void setProgress(boolean progress) {
        this.progress = progress;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setStartedAt(long startedAt) {
        this.startedAt = startedAt;
    }

    public void setFinishedTime(int finishedTime) {
        this.finishedTime = finishedTime;
    }

    public Scene getScene() {
        return this.scene;
    }

    public SceneGroup getGroup() {
        return this.group;
    }

    public int getChallengeId() {
        return this.challengeId;
    }

    public int getChallengeIndex() {
        return this.challengeIndex;
    }

    public List<Integer> getParamList() {
        return this.paramList;
    }

    public List<ChallengeTrigger> getChallengeTriggers() {
        return this.challengeTriggers;
    }

    public boolean isProgress() {
        return this.progress;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public long getStartedAt() {
        return this.startedAt;
    }

    public int getTimeLimit() {
        return this.timeLimit;
    }

    public int getFinishedTime() {
        return this.finishedTime;
    }

    public int getGoal() {
        return this.goal;
    }

    public AtomicInteger getScore() {
        return this.score;
    }

    public WorldChallenge(Scene scene, SceneGroup group, int challengeId, int challengeIndex, List<Integer> paramList, int timeLimit, int goal, List<ChallengeTrigger> challengeTriggers) {
        this.scene = scene;
        this.group = group;
        this.challengeId = challengeId;
        this.challengeIndex = challengeIndex;
        this.paramList = paramList;
        this.challengeTriggers = challengeTriggers;
        this.timeLimit = timeLimit;
        this.goal = goal;
    }

    public boolean inProgress() {
        return this.progress;
    }

    public void onCheckTimeOut() {
        if (inProgress() && this.timeLimit > 0) {
            this.challengeTriggers.forEach(t -> {
                t.onCheckTimeout(this);
            });
        }
    }

    private void finish(boolean success) {
        this.progress = false;
        this.success = success;
        this.finishedTime = (int) ((System.currentTimeMillis() - this.startedAt) / 1000);
        getScene().broadcastPacket(new PacketDungeonChallengeFinishNotify(this));
    }

    public int increaseScore() {
        return this.score.incrementAndGet();
    }

    public void onMonsterDeath(EntityMonster monster) {
        if (inProgress() && monster.getGroupId() == getGroup().f957id) {
            this.challengeTriggers.forEach(t -> {
                monster.onMonsterDeath(this, monster);
            });
        }
    }

    public void onGadgetDeath(EntityGadget gadget) {
        if (inProgress() && gadget.getGroupId() == getGroup().f957id) {
            this.challengeTriggers.forEach(t -> {
                gadget.onGadgetDeath(this, gadget);
            });
        }
    }

    public void onGadgetDamage(EntityGadget gadget) {
        if (inProgress() && gadget.getGroupId() == getGroup().f957id) {
            this.challengeTriggers.forEach(t -> {
                gadget.onGadgetDamage(this, gadget);
            });
        }
    }
}
