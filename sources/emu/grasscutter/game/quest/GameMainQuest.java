package emu.grasscutter.game.quest;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.Transient;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.MainQuestData;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.data.excels.RewardData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.quest.enums.LogicType;
import emu.grasscutter.game.quest.enums.ParentQuestState;
import emu.grasscutter.game.quest.enums.QuestState;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.proto.ChildQuestOuterClass;
import emu.grasscutter.net.proto.ParentQuestOuterClass;
import emu.grasscutter.server.packet.send.PacketCodexDataUpdateNotify;
import emu.grasscutter.server.packet.send.PacketFinishedParentQuestUpdateNotify;
import emu.grasscutter.server.packet.send.PacketQuestProgressUpdateNotify;
import emu.grasscutter.utils.Position;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.bson.types.ObjectId;

@Entity(value = "quests", useDiscriminator = false)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/GameMainQuest.class */
public class GameMainQuest {
    @AbstractC1283Id

    /* renamed from: id */
    private ObjectId f591id;
    @Indexed
    private int ownerUid;
    @Transient
    private Player owner;
    @Transient
    private QuestManager questManager;
    private Map<Integer, GameQuest> childQuests;
    private int parentQuestId;
    private int[] questVars;
    private List<Integer> questVarsUpdate;
    private ParentQuestState state;
    private boolean isFinished;
    List<QuestGroupSuite> questGroupSuites;
    int[] suggestTrackMainQuestList;
    private Map<Integer, MainQuestData.TalkData> talks;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0066: INVOKE_CUSTOM r-2, r-1
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x008E: INVOKE_CUSTOM r-3
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x00A1: INVOKE_CUSTOM r-4
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
    /*  JADX ERROR: Failed to decode insn: 0x0066: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.quest.GameMainQuest.hasRewindPosition(int, java.util.List<emu.grasscutter.utils.Position>):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, /scene_dummy_points.lua]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, /scene_dummy_points.lua]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x008E: INVOKE_CUSTOM r1, method: emu.grasscutter.game.quest.GameMainQuest.hasRewindPosition(int, java.util.List<emu.grasscutter.utils.Position>):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .pos]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .pos]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x00A1: INVOKE_CUSTOM r1, method: emu.grasscutter.game.quest.GameMainQuest.hasRewindPosition(int, java.util.List<emu.grasscutter.utils.Position>):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .rot]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .rot]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public boolean hasRewindPosition(int r10, java.util.List<emu.grasscutter.utils.Position> r11) {
        /*
        // Method dump skipped, instructions count: 310
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.GameMainQuest.hasRewindPosition(int, java.util.List):boolean");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0067: INVOKE_CUSTOM r-3, r-2
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x008F: INVOKE_CUSTOM r-4
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x00A2: INVOKE_CUSTOM r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x0067: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.quest.GameMainQuest.hasTeleportPostion(int, java.util.List<emu.grasscutter.utils.Position>):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, /scene_dummy_points.lua]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, /scene_dummy_points.lua]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x008F: INVOKE_CUSTOM r1, method: emu.grasscutter.game.quest.GameMainQuest.hasTeleportPostion(int, java.util.List<emu.grasscutter.utils.Position>):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .pos]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .pos]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x00A2: INVOKE_CUSTOM r1, method: emu.grasscutter.game.quest.GameMainQuest.hasTeleportPostion(int, java.util.List<emu.grasscutter.utils.Position>):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .rot]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .rot]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public boolean hasTeleportPostion(int r10, java.util.List<emu.grasscutter.utils.Position> r11) {
        /*
        // Method dump skipped, instructions count: 311
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.GameMainQuest.hasTeleportPostion(int, java.util.List):boolean");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x00E6: INVOKE_CUSTOM r-10, r-9
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
    /*  JADX ERROR: Failed to decode insn: 0x00E6: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.quest.GameMainQuest.tryAcceptSubQuests(emu.grasscutter.game.quest.enums.QuestTrigger, java.lang.String, int[]):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Error tryAcceptSubQuests at index  () ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Error tryAcceptSubQuests at index  () ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void tryAcceptSubQuests(emu.grasscutter.game.quest.enums.QuestTrigger r7, java.lang.String r8, int... r9) {
        /*
        // Method dump skipped, instructions count: 293
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.GameMainQuest.tryAcceptSubQuests(emu.grasscutter.game.quest.enums.QuestTrigger, java.lang.String, int[]):void");
    }

    public int getOwnerUid() {
        return this.ownerUid;
    }

    public Player getOwner() {
        return this.owner;
    }

    public QuestManager getQuestManager() {
        return this.questManager;
    }

    public Map<Integer, GameQuest> getChildQuests() {
        return this.childQuests;
    }

    public int getParentQuestId() {
        return this.parentQuestId;
    }

    public int[] getQuestVars() {
        return this.questVars;
    }

    public List<Integer> getQuestVarsUpdate() {
        return this.questVarsUpdate;
    }

    public ParentQuestState getState() {
        return this.state;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public List<QuestGroupSuite> getQuestGroupSuites() {
        return this.questGroupSuites;
    }

    public int[] getSuggestTrackMainQuestList() {
        return this.suggestTrackMainQuestList;
    }

    public Map<Integer, MainQuestData.TalkData> getTalks() {
        return this.talks;
    }

    @Deprecated
    public GameMainQuest() {
    }

    public GameMainQuest(Player player, int parentQuestId) {
        if (player != null) {
            this.owner = player;
            this.ownerUid = player.getUid();
            this.questManager = player.getQuestManager();
            this.parentQuestId = parentQuestId;
            this.childQuests = new HashMap();
            this.talks = new HashMap();
            this.questVars = new int[]{0, 0, 0, 0, 0};
            this.state = ParentQuestState.PARENT_QUEST_STATE_NONE;
            this.questGroupSuites = new ArrayList();
            addAllChildQuests();
        }
    }

    private void addAllChildQuests() {
        MainQuestData data = GameData.getMainQuestDataMap().get(this.parentQuestId);
        if (data == null) {
            Grasscutter.getLogger().error("No found parentQuestId quest {}", Integer.valueOf(this.parentQuestId));
            return;
        }
        for (Integer subQuestId : Arrays.stream(data.getSubQuests()).map((v0) -> {
            return v0.getSubId();
        }).toList()) {
            QuestData questConfig = GameData.getQuestDataMap().get(subQuestId.intValue());
            if (questConfig != null) {
                this.childQuests.put(subQuestId, new GameQuest(this, questConfig));
            }
        }
    }

    public Collection<GameQuest> getActiveQuests() {
        return this.childQuests.values().stream().filter(q -> {
            return q.getState().getValue() == QuestState.UNFINISHED.getValue();
        }).toList();
    }

    public void setOwner(Player player) {
        if (player.getUid() == getOwnerUid()) {
            this.owner = player;
        }
    }

    public int getQuestVar(int i) {
        return this.questVars[i];
    }

    public void setQuestVar(int i, int value) {
        int previousValue = this.questVars[i];
        this.questVars[i] = value;
        Grasscutter.getLogger().warn("questVar {} value changed from {} to {}", Integer.valueOf(i), Integer.valueOf(previousValue), Integer.valueOf(value));
    }

    public void incQuestVar(int i, int inc) {
        int previousValue = this.questVars[i];
        int[] iArr = this.questVars;
        iArr[i] = iArr[i] + inc;
        Grasscutter.getLogger().warn("questVar {} value incremented from {} to {}", Integer.valueOf(i), Integer.valueOf(previousValue), Integer.valueOf(previousValue + inc));
    }

    public void decQuestVar(int i, int dec) {
        int previousValue = this.questVars[i];
        int[] iArr = this.questVars;
        iArr[i] = iArr[i] - dec;
        Grasscutter.getLogger().warn("questVar {} value decremented from {} to {}", Integer.valueOf(i), Integer.valueOf(previousValue), Integer.valueOf(previousValue - dec));
    }

    public GameQuest getChildQuestById(int id) {
        return getChildQuests().get(Integer.valueOf(id));
    }

    public GameQuest getChildQuestByOrder(int order) {
        return (GameQuest) getChildQuests().values().stream().filter(p -> {
            return p.getQuestData().getOrder() == order;
        }).toList().get(0);
    }

    public void finish() {
        if (this.isFinished) {
            Grasscutter.getLogger().warn("Skip main quest finishing because it's already finished");
            return;
        }
        this.isFinished = true;
        this.state = ParentQuestState.PARENT_QUEST_STATE_FINISHED;
        getChildQuests().values().stream().filter(p -> {
            return p.state != QuestState.QUEST_STATE_FINISHED;
        }).forEach((v0) -> {
            v0.finish();
        });
        getOwner().getSession().send(new PacketFinishedParentQuestUpdateNotify(this));
        getOwner().getSession().send(new PacketCodexDataUpdateNotify(this));
        save();
        MainQuestData mainQuestData = GameData.getMainQuestDataMap().get(getParentQuestId());
        if (mainQuestData != null) {
            if (mainQuestData.getRewardIdList() != null) {
                for (int rewardId : mainQuestData.getRewardIdList()) {
                    RewardData rewardData = GameData.getRewardDataMap().get(rewardId);
                    if (rewardData != null) {
                        getOwner().getInventory().addItemParamDatas(rewardData.getRewardItemList(), ActionReason.QuestReward);
                    }
                }
            }
            if (mainQuestData.getSuggestTrackMainQuestList() != null) {
                try {
                    Arrays.stream(mainQuestData.getSuggestTrackMainQuestList()).forEach(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00db: INVOKE  
                          (wrap: java.util.stream.IntStream : 0x00d2: INVOKE  (r0v28 java.util.stream.IntStream A[REMOVE]) = 
                          (wrap: int[] : 0x00cf: INVOKE  (r0v27 int[] A[REMOVE]) = 
                          (r0v18 'mainQuestData' emu.grasscutter.data.binout.MainQuestData A[D('mainQuestData' emu.grasscutter.data.binout.MainQuestData)])
                         type: VIRTUAL call: emu.grasscutter.data.binout.MainQuestData.getSuggestTrackMainQuestList():int[])
                         type: STATIC call: java.util.Arrays.stream(int[]):java.util.stream.IntStream)
                          (wrap: java.util.function.IntConsumer : 0x00d6: INVOKE_CUSTOM (r1v11 java.util.function.IntConsumer A[REMOVE]) = 
                          (r5v0 'this' emu.grasscutter.game.quest.GameMainQuest A[D('this' emu.grasscutter.game.quest.GameMainQuest), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                        
                         handle type: INVOKE_INSTANCE
                         lambda: java.util.function.IntConsumer.accept(int):void
                         call insn: ?: INVOKE  (r1 I:emu.grasscutter.game.quest.GameMainQuest), (v1 int) type: VIRTUAL call: emu.grasscutter.game.quest.GameMainQuest.lambda$finish$3(int):void)
                         type: INTERFACE call: java.util.stream.IntStream.forEach(java.util.function.IntConsumer):void in method: emu.grasscutter.game.quest.GameMainQuest.finish():void, file: grasscutter.jar:emu/grasscutter/game/quest/GameMainQuest.class
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
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
                        	... 37 more
                        */
                    /*
                    // Method dump skipped, instructions count: 258
                    */
                    throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.GameMainQuest.finish():void");
                }

                public void fail() {
                }

                public void cancel() {
                }

                public List<Position> rewindTo(GameQuest targetQuest, boolean notifyDelete) {
                    if (targetQuest == null || !targetQuest.rewind(notifyDelete)) {
                        return null;
                    }
                    Grasscutter.getLogger().warn("rewindTo: {}", Integer.valueOf(targetQuest.getSubQuestId()));
                    List<Position> posAndRot = new ArrayList<>();
                    if (hasRewindPosition(targetQuest.getSubQuestId(), posAndRot)) {
                        return posAndRot;
                    }
                    for (GameQuest quest : getChildQuests().values().stream().filter(p -> {
                        return (p.getState() == QuestState.QUEST_STATE_UNFINISHED || p.getState() == QuestState.QUEST_STATE_FINISHED) && p.getQuestData() != null && p.getQuestData().isRewind();
                    }).toList()) {
                        if (hasRewindPosition(quest.getSubQuestId(), posAndRot)) {
                            return posAndRot;
                        }
                    }
                    return null;
                }

                public List<Position> rewind() {
                    if (this.questManager == null) {
                        this.questManager = getOwner().getQuestManager();
                    }
                    GameQuest highestActiveQuest = getActiveQuests().stream().filter(q -> {
                        return q.getQuestData() != null;
                    }).max(Comparator.comparing(q -> {
                        return Integer.valueOf(q.getQuestData().getOrder());
                    })).orElse(null);
                    if (highestActiveQuest == null) {
                        Optional<GameQuest> firstUnstarted = getChildQuests().values().stream().filter(q -> {
                            return (q.getQuestData() == null || q.getState().getValue() == QuestState.FINISHED.getValue()) ? false : true;
                        }).min(Comparator.comparingInt(a -> {
                            return a.getQuestData().getOrder();
                        }));
                        if (firstUnstarted.isEmpty()) {
                            return null;
                        }
                        highestActiveQuest = firstUnstarted.get();
                    }
                    int highestOrder = highestActiveQuest.getQuestData().getOrder();
                    GameQuest rewindTarget = getChildQuests().values().stream().filter(q -> {
                        return q.getQuestData() != null;
                    }).filter(q -> {
                        return q.getQuestData().isRewind() && q.getQuestData().getOrder() <= highestOrder;
                    }).max(Comparator.comparingInt(a -> {
                        return a.getQuestData().getOrder();
                    })).orElse(null);
                    return rewindTo(rewindTarget != null ? rewindTarget : highestActiveQuest, false);
                }

                public void checkProgress() {
                    for (GameQuest quest : getChildQuests().values()) {
                        if (quest.getState() == QuestState.QUEST_STATE_UNFINISHED) {
                            this.questManager.checkQuestAlreadyFullfilled(quest);
                        }
                    }
                }

                public void tryFailSubQuests(QuestTrigger condType, String paramStr, int... params) {
                    try {
                        for (GameQuest subQuestWithCond : getChildQuests().values().stream().filter(p -> {
                            return p.getState() == QuestState.QUEST_STATE_UNFINISHED;
                        }).filter(p -> {
                            return p.getQuestData().getFailCond().stream().anyMatch(q -> {
                                return q.getType() == condType;
                            });
                        }).toList()) {
                            List<QuestData.QuestCondition> failCond = subQuestWithCond.getQuestData().getFailCond();
                            for (int i = 0; i < subQuestWithCond.getQuestData().getFailCond().size(); i++) {
                                QuestData.QuestCondition condition = failCond.get(i);
                                if (condition.getType() == condType) {
                                    boolean result = getOwner().getServer().getQuestSystem().triggerContent(subQuestWithCond, condition, paramStr, params);
                                    subQuestWithCond.getFailProgressList()[i] = result ? 1 : 0;
                                    if (result) {
                                        getOwner().getSession().send(new PacketQuestProgressUpdateNotify(subQuestWithCond));
                                    }
                                }
                            }
                            if (LogicType.calculate(subQuestWithCond.getQuestData().getFailCondComb(), subQuestWithCond.getFailProgressList())) {
                                subQuestWithCond.fail();
                            }
                        }
                    } catch (Exception e) {
                        Grasscutter.getLogger().error("An error occurred while trying to fail quest.", (Throwable) e);
                    }
                }

                public void tryFinishSubQuests(QuestTrigger condType, String paramStr, int... params) {
                    try {
                        for (GameQuest subQuestWithCond : getChildQuests().values().stream().filter(p -> {
                            return p.getState() == QuestState.QUEST_STATE_UNFINISHED && p.getQuestData().getAcceptCond() != null;
                        }).filter(p -> {
                            return p.getQuestData().getFinishCond().stream().anyMatch(q -> {
                                return q.getType() == condType;
                            });
                        }).toList()) {
                            List<QuestData.QuestCondition> finishCond = subQuestWithCond.getQuestData().getFinishCond();
                            int[] listdone = subQuestWithCond.getFinishProgressList();
                            if (listdone == null) {
                                Grasscutter.getLogger().warn("is done");
                            } else {
                                for (int i = 0; i < finishCond.size(); i++) {
                                    QuestData.QuestCondition condition = finishCond.get(i);
                                    if (condition.getType() == condType) {
                                        boolean result = getOwner().getServer().getQuestSystem().triggerContent(subQuestWithCond, condition, paramStr, params);
                                        listdone[i] = result ? 1 : 0;
                                        if (result) {
                                            getOwner().getSession().send(new PacketQuestProgressUpdateNotify(subQuestWithCond));
                                        }
                                    }
                                }
                                if (LogicType.calculate(subQuestWithCond.getQuestData().getFinishCondComb(), subQuestWithCond.getFinishProgressList())) {
                                    subQuestWithCond.finish();
                                }
                            }
                        }
                    } catch (Exception e) {
                        Grasscutter.getLogger().warn("An error occurred while trying to finish quest.", (Throwable) e);
                    }
                }

                public void save() {
                    try {
                        DatabaseHelper.saveQuest(this);
                    } catch (Exception e) {
                        delete();
                        DatabaseHelper.saveQuest(this);
                    }
                }

                public void delete() {
                    DatabaseHelper.deleteQuest(this);
                }

                public ParentQuestOuterClass.ParentQuest toProto(boolean withChildQuests) {
                    ParentQuestOuterClass.ParentQuest.Builder proto = ParentQuestOuterClass.ParentQuest.newBuilder().setParentQuestId(getParentQuestId()).setIsFinished(isFinished()).setParentQuestState(getState().getValue()).setVideoKey(QuestManager.getQuestKey(this.parentQuestId));
                    if (withChildQuests) {
                        for (GameQuest quest : getChildQuests().values()) {
                            if (quest.getState() != QuestState.QUEST_STATE_UNSTARTED) {
                                proto.addChildQuestList(ChildQuestOuterClass.ChildQuest.newBuilder().setQuestId(quest.getSubQuestId()).setState(quest.getState().getValue()).build());
                            }
                        }
                    }
                    for (int i : getQuestVars()) {
                        proto.addQuestVar(i);
                    }
                    return proto.build();
                }
            }
