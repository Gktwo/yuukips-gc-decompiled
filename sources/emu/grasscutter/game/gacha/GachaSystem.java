package emu.grasscutter.game.gacha;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.gacha.GachaBanner;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.inventory.Inventory;
import emu.grasscutter.game.inventory.ItemType;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.game.systems.InventorySystem;
import emu.grasscutter.net.proto.GachaItemOuterClass;
import emu.grasscutter.net.proto.GachaTransferItemOuterClass;
import emu.grasscutter.net.proto.GetGachaInfoRspOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.packet.send.PacketDoGachaRsp;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import p014it.unimi.dsi.fastutil.ints.IntArrayList;
import p014it.unimi.dsi.fastutil.ints.IntList;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/game/gacha/GachaSystem.class */
public class GachaSystem extends BaseGameSystem {
    private static final int starglitterId = 221;
    private static final int stardustId = 222;
    private final List<GachaBanner> event_random_char = new ArrayList();
    private final List<GachaBanner> event_random_wp = new ArrayList();
    private final List<Integer> dupcheck = new ArrayList();
    private int even_id_last_char = 0;
    private int even_id_last_wp = 0;
    private int[] fallbackItems4Pool2Default = {11401, 11402, 11403, 11405, 12401, 12402, 12403, 12405, 13401, 13407, 14401, 14402, 14403, 14409, 15401, 15402, 15403, 15405};
    private int[] fallbackItems5Pool2Default = {11501, 11502, 12501, 12502, 13502, 13505, 14501, 14502, 15501, 15502};
    private final Int2ObjectMap<GachaBanner> gachaBanners = new Int2ObjectOpenHashMap();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0047: INVOKE_CUSTOM r-7
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x009C: INVOKE_CUSTOM r-10
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x00EA: INVOKE_CUSTOM r-14, r-13
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0156: INVOKE_CUSTOM r-18, r-17
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
    /*  JADX ERROR: Failed to decode insn: 0x0047: INVOKE_CUSTOM r0, method: emu.grasscutter.game.gacha.GachaSystem.load(java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, api/genshin/banner]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, api/genshin/banner]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x009C: INVOKE_CUSTOM r1, method: emu.grasscutter.game.gacha.GachaSystem.load(java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Banners  successfully loaded.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Banners  successfully loaded.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x00EA: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.gacha.GachaSystem.load(java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Error Banners Duplicate ID  | ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Error Banners Duplicate ID  | ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0156: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.gacha.GachaSystem.load(java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Banners  | ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Banners  | ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public synchronized void load(java.lang.String r5) {
        /*
        // Method dump skipped, instructions count: 415
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.gacha.GachaSystem.load(java.lang.String):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x00BD: INVOKE_CUSTOM r-16, r-15, r-14, r0
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x00D2: INVOKE_CUSTOM r-19, r-18, r-17, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x00BD: INVOKE_CUSTOM r1, r2, r3, r0, method: emu.grasscutter.game.gacha.GachaSystem.update(long):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;, J)Ljava/lang/String;}, Banners Event Now ()  successfully loaded. Next ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;, J)Ljava/lang/String;}, Banners Event Now ()  successfully loaded. Next ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x00D2: INVOKE_CUSTOM r1, r2, r3, r0, method: emu.grasscutter.game.gacha.GachaSystem.update(long):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;, J)Ljava/lang/String;}, Banners Weapons Now ()  successfully loaded. Next ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;, J)Ljava/lang/String;}, Banners Weapons Now ()  successfully loaded. Next ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public synchronized void update(long r7) {
        /*
        // Method dump skipped, instructions count: 287
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.gacha.GachaSystem.update(long):void");
    }

    public GachaSystem(GameServer server) {
        super(server);
        Grasscutter.ServerRunMode runMode = Grasscutter.getRunMode();
        if (runMode == Grasscutter.ServerRunMode.GAME_ONLY || runMode == Grasscutter.ServerRunMode.HYBRID) {
            load();
        }
    }

    public Int2ObjectMap<GachaBanner> getGachaBanners() {
        return this.gachaBanners;
    }

    public int randomRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt((max - min) + 1) + min;
    }

    public int getRandom(int[] array) {
        return array[randomRange(0, array.length - 1)];
    }

    public synchronized void load() {
        load("");
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:emu/grasscutter/game/gacha/GachaSystem$BannerPools.class */
    public class BannerPools {
        public int[] rateUpItems4;
        public int[] rateUpItems5;
        public int[] fallbackItems4Pool1;
        public int[] fallbackItems4Pool2;
        public int[] fallbackItems5Pool1;
        public int[] fallbackItems5Pool2;

        public BannerPools(GachaBanner banner) {
            this.rateUpItems4 = banner.getRateUpItems4();
            this.rateUpItems5 = banner.getRateUpItems5();
            this.fallbackItems4Pool1 = banner.getFallbackItems4Pool1();
            this.fallbackItems4Pool2 = banner.getFallbackItems4Pool2();
            this.fallbackItems5Pool1 = banner.getFallbackItems5Pool1();
            this.fallbackItems5Pool2 = banner.getFallbackItems5Pool2();
            if (banner.isAutoStripRateUpFromFallback()) {
                this.fallbackItems4Pool1 = Utils.setSubtract(this.fallbackItems4Pool1, this.rateUpItems4);
                this.fallbackItems4Pool2 = Utils.setSubtract(this.fallbackItems4Pool2, this.rateUpItems4);
                this.fallbackItems5Pool1 = Utils.setSubtract(this.fallbackItems5Pool1, this.rateUpItems5);
                this.fallbackItems5Pool2 = Utils.setSubtract(this.fallbackItems5Pool2, this.rateUpItems5);
            }
        }

        public void removeFromAllPools(int[] itemIds) {
            this.rateUpItems4 = Utils.setSubtract(this.rateUpItems4, itemIds);
            this.rateUpItems5 = Utils.setSubtract(this.rateUpItems5, itemIds);
            this.fallbackItems4Pool1 = Utils.setSubtract(this.fallbackItems4Pool1, itemIds);
            this.fallbackItems4Pool2 = Utils.setSubtract(this.fallbackItems4Pool2, itemIds);
            this.fallbackItems5Pool1 = Utils.setSubtract(this.fallbackItems5Pool1, itemIds);
            this.fallbackItems5Pool2 = Utils.setSubtract(this.fallbackItems5Pool2, itemIds);
        }
    }

    private synchronized int[] removeC6FromPool(int[] itemPool, Player player) {
        IntList temp = new IntArrayList();
        for (int itemId : itemPool) {
            if (InventorySystem.checkPlayerAvatarConstellationLevel(player, itemId) < 6) {
                temp.add(itemId);
            }
        }
        return temp.toIntArray();
    }

    private synchronized int drawRoulette(int[] weights, int cutoff) {
        int total = 0;
        for (int weight : weights) {
            if (weight < 0) {
                throw new IllegalArgumentException("Weights must be non-negative!");
            }
            total += weight;
        }
        int roll = ThreadLocalRandom.current().nextInt(total < cutoff ? total : cutoff);
        int subTotal = 0;
        for (int i = 0; i < weights.length; i++) {
            subTotal += weights[i];
            if (roll < subTotal) {
                return i;
            }
        }
        return 0;
    }

    private synchronized int doFallbackRarePull(int[] fallback1, int[] fallback2, int rarity, GachaBanner banner, PlayerGachaBannerInfo gachaInfo) {
        int chosenPool;
        if (fallback1.length < 1) {
            if (fallback2.length >= 1) {
                return getRandom(fallback2);
            }
            return getRandom(rarity == 5 ? this.fallbackItems5Pool2Default : this.fallbackItems4Pool2Default);
        } else if (fallback2.length < 1) {
            return getRandom(fallback1);
        } else {
            int pityPool1 = banner.getPoolBalanceWeight(rarity, gachaInfo.getPityPool(rarity, 1));
            int pityPool2 = banner.getPoolBalanceWeight(rarity, gachaInfo.getPityPool(rarity, 2));
            switch (pityPool1 >= pityPool2) {
                case true:
                    chosenPool = 1 + drawRoulette(new int[]{pityPool1, pityPool2}, 10000);
                    break;
                default:
                    chosenPool = 2 - drawRoulette(new int[]{pityPool2, pityPool1}, 10000);
                    break;
            }
            switch (chosenPool) {
                case 1:
                    gachaInfo.setPityPool(rarity, 1, 0);
                    return getRandom(fallback1);
                default:
                    gachaInfo.setPityPool(rarity, 2, 0);
                    return getRandom(fallback2);
            }
        }
    }

    private synchronized int doRarePull(int[] featured, int[] fallback1, int[] fallback2, int rarity, GachaBanner banner, PlayerGachaBannerInfo gachaInfo) {
        int itemId;
        boolean epitomized = banner.hasEpitomized() && rarity == 5 && gachaInfo.getWishItemId() != 0;
        boolean pityEpitomized = gachaInfo.getFailedChosenItemPulls() >= banner.getWishMaxProgress();
        boolean pullFeatured = (gachaInfo.getFailedFeaturedItemPulls(rarity) >= 1) || (randomRange(1, 100) <= banner.getEventChance(rarity));
        if (epitomized && pityEpitomized) {
            gachaInfo.setFailedFeaturedItemPulls(rarity, 0);
            itemId = gachaInfo.getWishItemId();
        } else if (!pullFeatured || featured.length <= 0) {
            gachaInfo.addFailedFeaturedItemPulls(rarity, 1);
            itemId = doFallbackRarePull(fallback1, fallback2, rarity, banner, gachaInfo);
        } else {
            gachaInfo.setFailedFeaturedItemPulls(rarity, 0);
            itemId = getRandom(featured);
        }
        if (epitomized) {
            if (itemId == gachaInfo.getWishItemId()) {
                gachaInfo.setFailedChosenItemPulls(0);
            } else {
                gachaInfo.addFailedChosenItemPulls(1);
            }
        }
        return itemId;
    }

    private synchronized int doPull(GachaBanner banner, PlayerGachaBannerInfo gachaInfo, BannerPools pools) {
        gachaInfo.incPityAll();
        switch (5 - drawRoulette(new int[]{banner.getWeight(5, gachaInfo.getPity5()), banner.getWeight(4, gachaInfo.getPity4()), 10000}, 10000)) {
            case 4:
                gachaInfo.setPity4(0);
                return doRarePull(pools.rateUpItems4, pools.fallbackItems4Pool1, pools.fallbackItems4Pool2, 4, banner, gachaInfo);
            case 5:
                gachaInfo.setPity5(0);
                return doRarePull(pools.rateUpItems5, pools.fallbackItems5Pool1, pools.fallbackItems5Pool2, 5, banner, gachaInfo);
            default:
                return getRandom(banner.getFallbackItems3());
        }
    }

    public synchronized void doPulls(Player player, int scheduleId, int times) {
        if (times == 10 || times == 1) {
            Inventory inventory = player.getInventory();
            if (inventory.getInventoryTab(ItemType.ITEM_WEAPON).getSize() + times > inventory.getInventoryTab(ItemType.ITEM_WEAPON).getMaxCapacity()) {
                player.sendPacket(new PacketDoGachaRsp(RetcodeOuterClass.Retcode.RET_ITEM_EXCEED_LIMIT));
                return;
            }
            GachaBanner banner = getGachaBanners().get(scheduleId);
            if (banner == null) {
                player.sendPacket(new PacketDoGachaRsp());
                return;
            }
            PlayerGachaBannerInfo gachaInfo = player.getGachaInfo().getBannerInfo(banner);
            int gachaTimesLimit = banner.getGachaTimesLimit();
            if (gachaTimesLimit == Integer.MAX_VALUE || gachaInfo.getTotalPulls() + times <= gachaTimesLimit) {
                ItemParamData cost = banner.getCost(times);
                if (cost.getCount() <= 0 || inventory.payItem(cost)) {
                    gachaInfo.addTotalPulls(times);
                    BannerPools pools = new BannerPools(banner);
                    List<GachaItemOuterClass.GachaItem> list = new ArrayList<>();
                    int stardust = 0;
                    int starglitter = 0;
                    if (banner.isRemoveC6FromPool()) {
                        pools.rateUpItems4 = removeC6FromPool(pools.rateUpItems4, player);
                        pools.rateUpItems5 = removeC6FromPool(pools.rateUpItems5, player);
                        pools.fallbackItems4Pool1 = removeC6FromPool(pools.fallbackItems4Pool1, player);
                        pools.fallbackItems4Pool2 = removeC6FromPool(pools.fallbackItems4Pool2, player);
                        pools.fallbackItems5Pool1 = removeC6FromPool(pools.fallbackItems5Pool1, player);
                        pools.fallbackItems5Pool2 = removeC6FromPool(pools.fallbackItems5Pool2, player);
                    }
                    for (int i = 0; i < times; i++) {
                        int itemId = doPull(banner, gachaInfo, pools);
                        ItemData itemData = GameData.getItemDataMap().get(itemId);
                        if (itemData != null) {
                            DatabaseHelper.saveGachaRecord(new GachaRecord(itemId, player.getUid(), banner.getGachaType()));
                            GachaItemOuterClass.GachaItem.Builder gachaItem = GachaItemOuterClass.GachaItem.newBuilder();
                            int addStardust = 0;
                            int addStarglitter = 0;
                            boolean isTransferItem = false;
                            int constellation = InventorySystem.checkPlayerAvatarConstellationLevel(player, itemId);
                            switch (constellation) {
                                case -2:
                                    switch (itemData.getRankLevel()) {
                                        case 4:
                                            addStarglitter = 2;
                                            break;
                                        case 5:
                                            addStarglitter = 10;
                                            break;
                                        default:
                                            addStardust = 15;
                                            break;
                                    }
                                case -1:
                                    gachaItem.setIsGachaItemNew(true);
                                    break;
                                default:
                                    if (constellation >= 6) {
                                        addStarglitter = itemData.getRankLevel() == 5 ? 25 : 5;
                                    } else {
                                        if (banner.isRemoveC6FromPool() && constellation == 5) {
                                            pools.removeFromAllPools(new int[]{itemId});
                                        }
                                        addStarglitter = itemData.getRankLevel() == 5 ? 10 : 2;
                                        int constItemId = itemId + 100;
                                        gachaItem.addTransferItems(GachaTransferItemOuterClass.GachaTransferItem.newBuilder().setItem(ItemParamOuterClass.ItemParam.newBuilder().setItemId(constItemId).setCount(1)).setIsTransferItemNew(inventory.getInventoryTab(ItemType.ITEM_MATERIAL).getItemById(constItemId) == null));
                                    }
                                    isTransferItem = true;
                                    break;
                            }
                            GameItem item = new GameItem(itemData);
                            gachaItem.setGachaItem(item.toItemParam());
                            inventory.addItem(item);
                            stardust += addStardust;
                            starglitter += addStarglitter;
                            if (addStardust > 0) {
                                gachaItem.addTokenItemList(ItemParamOuterClass.ItemParam.newBuilder().setItemId(222).setCount(addStardust));
                            }
                            if (addStarglitter > 0) {
                                ItemParamOuterClass.ItemParam starglitterParam = ItemParamOuterClass.ItemParam.newBuilder().setItemId(221).setCount(addStarglitter).build();
                                if (isTransferItem) {
                                    gachaItem.addTransferItems(GachaTransferItemOuterClass.GachaTransferItem.newBuilder().setItem(starglitterParam));
                                }
                                gachaItem.addTokenItemList(starglitterParam);
                            }
                            list.add(gachaItem.build());
                        }
                    }
                    if (stardust > 0) {
                        inventory.addItem(222, stardust);
                    }
                    if (starglitter > 0) {
                        inventory.addItem(221, starglitter);
                    }
                    player.sendPacket(new PacketDoGachaRsp(banner, list, gachaInfo));
                    player.getBattlePassManager().triggerMission(WatcherTriggerType.TRIGGER_GACHA_NUM, 0, times);
                    return;
                }
                player.sendPacket(new PacketDoGachaRsp(RetcodeOuterClass.Retcode.RET_GACHA_COST_ITEM_NOT_ENOUGH));
                return;
            }
            player.sendPacket(new PacketDoGachaRsp(RetcodeOuterClass.Retcode.RET_GACHA_TIMES_LIMIT));
            return;
        }
        player.sendPacket(new PacketDoGachaRsp(RetcodeOuterClass.Retcode.RET_GACHA_INVALID_TIMES));
    }

    private synchronized GetGachaInfoRspOuterClass.GetGachaInfoRsp createProto(Player player) {
        GetGachaInfoRspOuterClass.GetGachaInfoRsp.Builder proto = GetGachaInfoRspOuterClass.GetGachaInfoRsp.newBuilder().setGachaRandom(12345);
        long currentTime = System.currentTimeMillis() / 1000;
        ObjectIterator<GachaBanner> it = getGachaBanners().values().iterator();
        while (it.hasNext()) {
            GachaBanner banner = it.next();
            if ((((long) banner.getEndTime()) >= currentTime && ((long) banner.getBeginTime()) <= currentTime) || banner.getBannerType() == GachaBanner.BannerType.STANDARD) {
                proto.addGachaInfoList(banner.toProto(player));
            }
        }
        return proto.build();
    }

    public GetGachaInfoRspOuterClass.GetGachaInfoRsp toProto(Player player) {
        return createProto(player);
    }
}
