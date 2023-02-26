package emu.grasscutter.data;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.binout.AbilityData;
import emu.grasscutter.data.binout.AbilityEmbryoEntry;
import emu.grasscutter.data.binout.AbilityModifier;
import emu.grasscutter.data.binout.AbilityModifierEntry;
import emu.grasscutter.data.binout.ConfigLevelEntity;
import emu.grasscutter.data.binout.ScenePointEntry;
import emu.grasscutter.data.common.PointData;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.managers.blossom.BlossomConfig;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.scripts.ScriptLoader;
import emu.grasscutter.utils.FileUtils;
import emu.grasscutter.utils.JsonUtils;
import emu.grasscutter.utils.Language;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.script.Bindings;
import org.reflections.Reflections;
import org.reflections.scanners.Scanner;
import p014it.unimi.dsi.fastutil.ints.IntArrayList;
import p014it.unimi.dsi.fastutil.ints.IntArraySet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/data/ResourceLoader.class */
public class ResourceLoader {
    private static final List<String> loadedResources = new ArrayList();
    private static boolean loadedAll = false;

    /* loaded from: grasscutter.jar:emu/grasscutter/data/ResourceLoader$AbilityConfigData.class */
    public static class AbilityConfigData {
        public AbilityData Default;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/ResourceLoader$AvatarConfig.class */
    public static class AvatarConfig {
        @SerializedName(value = "abilities", alternate = {"targetAbilities"})
        public ArrayList<AvatarConfigAbility> abilities;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/ResourceLoader$OpenConfigData.class */
    public static class OpenConfigData {
        public String $type;
        public String abilityName;
        @SerializedName(value = "talentIndex", alternate = {"OJOFFKLNAHN"})
        public int talentIndex;
        @SerializedName(value = "skillID", alternate = {"overtime"})
        public int skillID;
        @SerializedName(value = "pointDelta", alternate = {"IGEBKIHPOIF"})
        public int pointDelta;
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0054: INVOKE_CUSTOM r-3
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
    /*  JADX ERROR: Failed to decode insn: 0x0054: INVOKE_CUSTOM r1, method: emu.grasscutter.data.ResourceLoader.loadResources(boolean):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error loading resource file: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error loading resource file: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static void loadResources(boolean r5) {
        /*
            java.util.List r0 = getResourceDefClasses()
            java.util.Iterator r0 = r0.iterator()
            r6 = r0
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0061
            r0 = r6
            java.lang.Object r0 = r0.next()
            java.lang.Class r0 = (java.lang.Class) r0
            r7 = r0
            r0 = r7
            java.lang.Class<emu.grasscutter.data.ResourceType> r1 = emu.grasscutter.data.ResourceType.class
            java.lang.annotation.Annotation r0 = r0.getAnnotation(r1)
            emu.grasscutter.data.ResourceType r0 = (emu.grasscutter.data.ResourceType) r0
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L_0x002d
            goto L_0x0009
            r0 = r7
            it.unimi.dsi.fastutil.ints.Int2ObjectMap r0 = emu.grasscutter.data.GameData.getMapByResourceDef(r0)
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L_0x003b
            goto L_0x0009
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r5
            loadFromResource(r0, r1, r2, r3)
            goto L_0x005e
            r10 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r8
            java.lang.String[] r1 = r1.name()
            java.lang.String r1 = java.util.Arrays.toString(r1)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error loading resource file: ]}
            r2 = r10
            r0.error(r1, r2)
            goto L_0x0009
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadResources(boolean):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0058: INVOKE_CUSTOM r-4, r-3
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0070: INVOKE_CUSTOM r-6, r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x0058: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.data.ResourceLoader.loadFromResource(java.lang.Class<?>, emu.grasscutter.data.ResourceType, it.unimi.dsi.fastutil.ints.Int2ObjectMap, boolean):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Loaded  s.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Loaded  s.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0070: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.data.ResourceLoader.loadFromResource(java.lang.Class<?>, emu.grasscutter.data.ResourceType, it.unimi.dsi.fastutil.ints.Int2ObjectMap, boolean):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Not load  s.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Not load  s.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    protected static void loadFromResource(java.lang.Class<?> r4, emu.grasscutter.data.ResourceType r5, p014it.unimi.dsi.fastutil.ints.Int2ObjectMap r6, boolean r7) throws java.lang.Exception {
        /*
            java.util.List<java.lang.String> r0 = emu.grasscutter.data.ResourceLoader.loadedResources
            r1 = r4
            java.lang.String r1 = r1.getSimpleName()
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0013
            r0 = r7
            if (r0 == 0) goto L_0x0063
            r0 = r5
            java.lang.String[] r0 = r0.name()
            r8 = r0
            r0 = r8
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = r10
            r1 = r9
            if (r0 >= r1) goto L_0x003e
            r0 = r8
            r1 = r10
            r0 = r0[r1]
            r11 = r0
            r0 = r4
            r1 = r11
            r2 = r6
            loadFromResource(r0, r1, r2)
            int r10 = r10 + 1
            goto L_0x0023
            java.util.List<java.lang.String> r0 = emu.grasscutter.data.ResourceLoader.loadedResources
            r1 = r4
            java.lang.String r1 = r1.getSimpleName()
            boolean r0 = r0.add(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            int r1 = r1.size()
            r2 = r4
            java.lang.String r2 = r2.getSimpleName()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Loaded  s.]}
            r0.info(r1)
            goto L_0x0078
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            int r1 = r1.size()
            r2 = r4
            java.lang.String r2 = r2.getSimpleName()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Not load  s.]}
            r0.error(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadFromResource(java.lang.Class, emu.grasscutter.data.ResourceType, it.unimi.dsi.fastutil.ints.Int2ObjectMap, boolean):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0001: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0001: INVOKE_CUSTOM r0, method: emu.grasscutter.data.ResourceLoader.loadFromResource(java.lang.Class<T>, java.lang.String, it.unimi.dsi.fastutil.ints.Int2ObjectMap):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ExcelBinOutput/]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ExcelBinOutput/]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    protected static <T> void loadFromResource(java.lang.Class<T> r4, java.lang.String r5, p014it.unimi.dsi.fastutil.ints.Int2ObjectMap r6) throws java.lang.Exception {
        /*
            r0 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ExcelBinOutput/]}
            java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)
            r1 = r4
            java.util.List r0 = emu.grasscutter.utils.JsonUtils.loadToList(r0, r1)
            r7 = r0
            r0 = r7
            java.util.Iterator r0 = r0.iterator()
            r8 = r0
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0046
            r0 = r8
            java.lang.Object r0 = r0.next()
            r9 = r0
            r0 = r9
            emu.grasscutter.data.GameResource r0 = (emu.grasscutter.data.GameResource) r0
            r10 = r0
            r0 = r10
            r0.onLoad()
            r0 = r6
            r1 = r10
            int r1 = r1.getId()
            r2 = r10
            java.lang.Object r0 = r0.put(r1, r2)
            goto L_0x0016
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadFromResource(java.lang.Class, java.lang.String, it.unimi.dsi.fastutil.ints.Int2ObjectMap):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x006A: INVOKE_CUSTOM r-4
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
    /*  JADX ERROR: Failed to decode insn: 0x006A: INVOKE_CUSTOM r1, method: emu.grasscutter.data.ResourceLoader.loadAbilityModifiers():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded Ability ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded Ability ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void loadAbilityModifiers() {
        /*
            java.lang.String r0 = "BinOutput/Ability/Temp/"
            java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)
            r1 = 0
            java.nio.file.FileVisitOption[] r1 = new java.nio.file.FileVisitOption[r1]
            java.util.stream.Stream r0 = java.nio.file.Files.walk(r0, r1)
            r4 = r0
            r0 = r4
            void r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$loadAbilityModifiers$10(v0);
            }
            java.util.stream.Stream r0 = r0.filter(r1)
            void r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$loadAbilityModifiers$11(v0);
            }
            java.util.stream.Stream r0 = r0.filter(r1)
            void r1 = emu.grasscutter.data.ResourceLoader::loadAbilityModifiers
            r0.forEach(r1)
            r0 = r4
            if (r0 == 0) goto L_0x0050
            r0 = r4
            r0.close()
            goto L_0x0050
            r5 = move-exception
            r0 = r4
            if (r0 == 0) goto L_0x004e
            r0 = r4
            r0.close()
            goto L_0x004e
            r6 = move-exception
            r0 = r5
            r1 = r6
            r0.addSuppressed(r1)
            r0 = r5
            throw r0
            goto L_0x005f
            r4 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Error loading ability modifiers: "
            r2 = r4
            r0.error(r1, r2)
            return
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.util.Map<java.lang.String, emu.grasscutter.data.binout.AbilityData> r1 = emu.grasscutter.data.GameData.abilityDataMap
            int r1 = r1.size()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded Ability ]}
            r0.info(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadAbilityModifiers():void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r1, method: emu.grasscutter.data.ResourceLoader.loadAbilityModifiers(java.nio.file.Path):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error loading ability modifiers from path : ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error loading ability modifiers from path : ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void loadAbilityModifiers(java.nio.file.Path r4) {
        /*
            r0 = r4
            java.lang.Class<emu.grasscutter.data.ResourceLoader$AbilityConfigData> r1 = emu.grasscutter.data.ResourceLoader.AbilityConfigData.class
            java.util.List r0 = emu.grasscutter.utils.JsonUtils.loadToList(r0, r1)
            void r1 = (v0) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$loadAbilityModifiers$12(v0);
            }
            r0.forEach(r1)
            goto L_0x0028
            r5 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r4
            java.lang.String r1 = r1.toString()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error loading ability modifiers from path : ]}
            r2 = r5
            r0.error(r1, r2)
            return
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadAbilityModifiers(java.nio.file.Path):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0066: INVOKE_CUSTOM r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x0066: INVOKE_CUSTOM r1, method: emu.grasscutter.data.ResourceLoader.loadOpenConfig():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error loading open config: no files found in ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error loading open config: no files found in ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void loadOpenConfig() {
        /*
            r0 = 0
            r5 = r0
            java.lang.String r0 = "OpenConfig.json"
            java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getDataPath(r0)
            java.lang.Class<emu.grasscutter.data.binout.OpenConfigEntry> r1 = emu.grasscutter.data.binout.OpenConfigEntry.class
            java.util.List r0 = emu.grasscutter.utils.JsonUtils.loadToList(r0, r1)
            r5 = r0
            goto L_0x0013
            r6 = move-exception
            r0 = r5
            if (r0 != 0) goto L_0x0083
            java.util.TreeMap r0 = new java.util.TreeMap
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = 2
            java.lang.String[] r0 = new java.lang.String[r0]
            r1 = r0
            r2 = 0
            java.lang.String r3 = "BinOutput/Talent/EquipTalents/"
            r1[r2] = r3
            r1 = r0
            r2 = 1
            java.lang.String r3 = "BinOutput/Talent/AvatarTalents/"
            r1[r2] = r3
            r7 = r0
            r0 = r7
            r8 = r0
            r0 = r8
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = r10
            r1 = r9
            if (r0 >= r1) goto L_0x0075
            r0 = r8
            r1 = r10
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)
            java.lang.String r1 = "*.json"
            java.nio.file.DirectoryStream r0 = java.nio.file.Files.newDirectoryStream(r0, r1)
            r1 = r6
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$loadOpenConfig$22(r1, v1);
            }
            r0.forEach(r1)
            goto L_0x006f
            r12 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r11
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error loading open config: no files found in ]}
            r0.error(r1)
            return
            int r10 = r10 + 1
            goto L_0x0039
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r2 = r6
            java.util.Collection r2 = r2.values()
            r1.<init>(r2)
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L_0x0090
            r0 = r5
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x009a
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "No openconfig entries loaded!"
            r0.error(r1)
            return
            r0 = r5
            java.util.Iterator r0 = r0.iterator()
            r6 = r0
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00c5
            r0 = r6
            java.lang.Object r0 = r0.next()
            emu.grasscutter.data.binout.OpenConfigEntry r0 = (emu.grasscutter.data.binout.OpenConfigEntry) r0
            r7 = r0
            java.util.Map r0 = emu.grasscutter.data.GameData.getOpenConfigEntries()
            r1 = r7
            java.lang.String r1 = r1.getName()
            r2 = r7
            java.lang.Object r0 = r0.put(r1, r2)
            goto L_0x00a1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadOpenConfig():void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0083: INVOKE_CUSTOM r-6
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
    /*  JADX ERROR: Failed to decode insn: 0x0083: INVOKE_CUSTOM r1, method: emu.grasscutter.data.ResourceLoader.loadQuests():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  MainQuestDatas.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  MainQuestDatas.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void loadQuests() {
        /*
            java.lang.String r0 = "BinOutput/Quest/"
            java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)
            java.util.stream.Stream r0 = java.nio.file.Files.list(r0)
            void r1 = (v0) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$loadQuests$23(v0);
            }
            r0.forEach(r1)
            goto L_0x0021
            r4 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Quest data missing"
            r0.error(r1)
            return
            it.unimi.dsi.fastutil.ints.Int2ObjectMap r0 = emu.grasscutter.data.GameData.getMainQuestEncryptionMap()
            r4 = r0
            java.lang.String r0 = "QuestEncryptionKeys.json"
            r5 = r0
            r0 = r5
            java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)
            java.lang.Class<emu.grasscutter.game.quest.QuestEncryptionKey> r1 = emu.grasscutter.game.quest.QuestEncryptionKey.class
            java.util.List r0 = emu.grasscutter.utils.JsonUtils.loadToList(r0, r1)
            r1 = r4
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$loadQuests$24(r1, v1);
            }
            r0.forEach(r1)
            goto L_0x0042
            r6 = move-exception
            r0 = r5
            java.lang.Class<emu.grasscutter.game.quest.QuestEncryptionKey> r1 = emu.grasscutter.game.quest.QuestEncryptionKey.class
            java.util.List r0 = emu.grasscutter.data.DataLoader.loadList(r0, r1)
            r1 = r4
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$loadQuests$25(r1, v1);
            }
            r0.forEach(r1)
            goto L_0x0058
            r6 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Loaded {} quest keys."
            r2 = r4
            int r2 = r2.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.info(r1, r2)
            goto L_0x0078
            r4 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Unable to load quest keys."
            r2 = r4
            r0.error(r1, r2)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            it.unimi.dsi.fastutil.ints.Int2ObjectMap r1 = emu.grasscutter.data.GameData.getMainQuestDataMap()
            int r1 = r1.size()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  MainQuestDatas.]}
            r0.info(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadQuests():void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r1, method: emu.grasscutter.data.ResourceLoader.loadScriptSceneData():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  ScriptSceneDatas.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  ScriptSceneDatas.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static void loadScriptSceneData() {
        /*
            java.lang.String r0 = "ScriptSceneData/"
            java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)
            java.util.stream.Stream r0 = java.nio.file.Files.list(r0)
            void r1 = (v0) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$loadScriptSceneData$26(v0);
            }
            r0.forEach(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.util.Map r1 = emu.grasscutter.data.GameData.getScriptSceneDataMap()
            int r1 = r1.size()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  ScriptSceneDatas.]}
            r0.warn(r1)
            goto L_0x0034
            r3 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "ScriptSceneData folder missing or empty."
            r0.warn(r1)
            return
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadScriptSceneData():void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0029: INVOKE_CUSTOM r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x0029: INVOKE_CUSTOM r1, method: emu.grasscutter.data.ResourceLoader.loadHomeworldDefaultSaveData():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  HomeworldDefaultSaveDatas.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  HomeworldDefaultSaveDatas.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void loadHomeworldDefaultSaveData() {
        /*
            java.lang.String r0 = "scene([0-9]+)_home_config\\.json"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r3 = r0
            java.lang.String r0 = "BinOutput/HomeworldDefaultSave"
            java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)
            java.lang.String r1 = "scene*_home_config.json"
            java.nio.file.DirectoryStream r0 = java.nio.file.Files.newDirectoryStream(r0, r1)
            r1 = r3
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$loadHomeworldDefaultSaveData$27(r1, v1);
            }
            r0.forEach(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            it.unimi.dsi.fastutil.ints.Int2ObjectMap r1 = emu.grasscutter.data.GameData.getHomeworldDefaultSaveData()
            int r1 = r1.size()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  HomeworldDefaultSaveDatas.]}
            r0.info(r1)
            goto L_0x003e
            r4 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Failed to load HomeworldDefaultSave folder."
            r0.error(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadHomeworldDefaultSaveData():void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0021: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0021: INVOKE_CUSTOM r1, method: emu.grasscutter.data.ResourceLoader.loadNpcBornData():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  SceneNpcBornDatas.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  SceneNpcBornDatas.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void loadNpcBornData() {
        /*
            java.lang.String r0 = "BinOutput/Scene/SceneNpcBorn/"
            java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)
            java.lang.String r1 = "*.json"
            java.nio.file.DirectoryStream r0 = java.nio.file.Files.newDirectoryStream(r0, r1)
            void r1 = (v0) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$loadNpcBornData$29(v0);
            }
            r0.forEach(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            it.unimi.dsi.fastutil.ints.Int2ObjectMap r1 = emu.grasscutter.data.GameData.getSceneNpcBornData()
            int r1 = r1.size()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  SceneNpcBornDatas.]}
            r0.info(r1)
            goto L_0x0036
            r3 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Failed to load SceneNpcBorn folder."
            r0.error(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadNpcBornData():void");
    }

    public static List<Class<?>> getResourceDefClasses() {
        Set<?> classes = new Reflections(ResourceLoader.class.getPackage().getName(), new Scanner[0]).getSubTypesOf(GameResource.class);
        List<Class<?>> classList = new ArrayList<>(classes.size());
        classes.forEach(o -> {
            Class<?> c = (Class) o;
            if (c.getAnnotation(ResourceType.class) != null) {
                classList.add(c);
            }
        });
        classList.sort(a, b -> {
            return ((ResourceType) b.getAnnotation(ResourceType.class)).loadPriority().value() - ((ResourceType) a.getAnnotation(ResourceType.class)).loadPriority().value();
        });
        return classList;
    }

    public static void loadAll() {
        if (!loadedAll) {
            Grasscutter.getLogger().info(Language.translate("messages.status.resources.loading", new Object[0]));
            loadAbilityEmbryos();
            loadOpenConfig();
            loadAbilityModifiers();
            loadResources(true);
            GameDepot.load();
            loadGadgetConfigData();
            loadSceneRoutes();
            loadSpawnData();
            loadQuests();
            handleSpecialQuest();
            loadScriptSceneData();
            loadScenePoints();
            loadHomeworldDefaultSaveData();
            loadNpcBornData();
            loadBlossomResources();
            loadQuestGiveAvatar();
            cacheTalentLevelSets();
            loadConfigLevelEntityData();
            loadQuestShareConfig();
            Grasscutter.getLogger().info(Language.translate("messages.status.resources.finish", new Object[0]));
            loadedAll = true;
        }
    }

    public static void loadQuestGiveAvatar() {
        GameData.getQuestGiveAvatar().put(35402, 1021);
    }

    public static void loadResources() {
        loadResources(false);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/ResourceLoader$ScenePointConfig.class */
    public class ScenePointConfig {
        public Map<Integer, PointData> points;

        public ScenePointConfig() {
        }
    }

    private static void loadScenePoints() {
        Pattern pattern = Pattern.compile("scene([0-9]+)_point\\.json");
        AtomicInteger goodpoint = new AtomicInteger(0);
        AtomicInteger badpoint = new AtomicInteger(0);
        try {
            Files.newDirectoryStream(FileUtils.getResourcePath("BinOutput/Scene/Point"), "scene*_point.json").forEach(path -> {
                Matcher matcher = pattern.matcher(path.getFileName().toString());
                if (matcher.find()) {
                    int sceneId = Integer.parseInt(matcher.group(1));
                    try {
                        ScenePointConfig config = (ScenePointConfig) JsonUtils.loadToClass(path, ScenePointConfig.class);
                        if (config.points == null) {
                            badpoint.incrementAndGet();
                            return;
                        }
                        IntArrayList scenePoints = new IntArrayList();
                        config.points.forEach(pointId, pointData -> {
                            ScenePointEntry scenePoint = new ScenePointEntry(sceneId, pointData);
                            if (pointData.getTranPos() != null) {
                                goodpoint.incrementAndGet();
                            } else {
                                badpoint.incrementAndGet();
                            }
                            scenePoints.add(pointId.intValue());
                            pointData.setId(pointId.intValue());
                            GameData.getScenePointIdList().add(pointId.intValue());
                            GameData.scenePointEntryMap.put((sceneId << 16) + pointId.intValue(), (int) scenePoint);
                            pointData.updateDailyDungeon();
                        });
                        GameData.getScenePointsPerScene().put(Integer.valueOf(sceneId), scenePoints);
                    } catch (Exception e) {
                        Grasscutter.getLogger().error("Scene point files {} error", path, e);
                        goodpoint.incrementAndGet();
                    }
                }
            });
            Grasscutter.getLogger().info("Scene Point: Good {} And Bad {}", goodpoint, badpoint);
        } catch (IOException e) {
            Grasscutter.getLogger().error("Scene point files cannot be found, you cannot use teleport waypoints!");
        }
    }

    private static void cacheTalentLevelSets() {
        GameData.getProudSkillDataMap().forEach(id, data -> {
            GameData.proudSkillGroupLevels.computeIfAbsent(data.getProudSkillGroupId(), i -> {
                return new IntArraySet();
            }).add(data.getLevel());
        });
        GameData.getAvatarSkillDataMap().forEach(id, data -> {
            GameData.avatarSkillLevels.put(id.intValue(), (int) GameData.proudSkillGroupLevels.get(data.getProudSkillGroupId()));
        });
        GameData.proudSkillGroupLevels.forEach(id, set -> {
            GameData.proudSkillGroupMaxLevels.put(id.intValue(), set.intStream().max().getAsInt());
        });
    }

    private static void loadAbilityEmbryos() {
        List<AbilityEmbryoEntry> embryoList = null;
        try {
            embryoList = JsonUtils.loadToList(FileUtils.getDataPath("AbilityEmbryos.json"), AbilityEmbryoEntry.class);
        } catch (Exception e) {
        }
        if (embryoList == null) {
            Pattern pattern = Pattern.compile("ConfigAvatar_(.+?)\\.json");
            ArrayList<AbilityEmbryoEntry> l = new ArrayList<>();
            try {
                Files.newDirectoryStream(FileUtils.getResourcePath("BinOutput/Avatar/"), "ConfigAvatar_*.json").forEach(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0039: INVOKE  
                      (wrap: java.nio.file.DirectoryStream<java.nio.file.Path> : 0x002f: INVOKE  (r0v21 java.nio.file.DirectoryStream<java.nio.file.Path> A[REMOVE]) = 
                      (wrap: java.nio.file.Path : 0x0029: INVOKE  (r0v20 java.nio.file.Path A[REMOVE]) = ("BinOutput/Avatar/") type: STATIC call: emu.grasscutter.utils.FileUtils.getResourcePath(java.lang.String):java.nio.file.Path)
                      ("ConfigAvatar_*.json")
                     type: STATIC call: java.nio.file.Files.newDirectoryStream(java.nio.file.Path, java.lang.String):java.nio.file.DirectoryStream)
                      (wrap: java.util.function.Consumer<? super java.nio.file.Path> : 0x0034: INVOKE_CUSTOM (r1v7 java.util.function.Consumer<? super java.nio.file.Path> A[REMOVE]) = 
                      (r0v16 'pattern' java.util.regex.Pattern A[D('pattern' java.util.regex.Pattern), DONT_INLINE])
                      (r0v17 'l' java.util.ArrayList<emu.grasscutter.data.binout.AbilityEmbryoEntry> A[D('l' java.util.ArrayList<emu.grasscutter.data.binout.AbilityEmbryoEntry>), DONT_INLINE])
                    
                     handle type: INVOKE_STATIC
                     lambda: java.util.function.Consumer.accept(java.lang.Object):void
                     call insn: ?: INVOKE  (r1 I:java.util.regex.Pattern), (r2 I:java.util.ArrayList), (v2 java.nio.file.Path) type: STATIC call: emu.grasscutter.data.ResourceLoader.lambda$loadAbilityEmbryos$9(java.util.regex.Pattern, java.util.ArrayList, java.nio.file.Path):void)
                     type: INTERFACE call: java.nio.file.DirectoryStream.forEach(java.util.function.Consumer):void in method: emu.grasscutter.data.ResourceLoader.loadAbilityEmbryos():void, file: grasscutter.jar:emu/grasscutter/data/ResourceLoader.class
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
                    	... 27 more
                    */
                /*
                    r0 = 0
                    r4 = r0
                    java.lang.String r0 = "AbilityEmbryos.json"
                    java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getDataPath(r0)     // Catch: Exception -> 0x0012
                    java.lang.Class<emu.grasscutter.data.binout.AbilityEmbryoEntry> r1 = emu.grasscutter.data.binout.AbilityEmbryoEntry.class
                    java.util.List r0 = emu.grasscutter.utils.JsonUtils.loadToList(r0, r1)     // Catch: Exception -> 0x0012
                    r4 = r0
                    goto L_0x0013
                L_0x0012:
                    r5 = move-exception
                L_0x0013:
                    r0 = r4
                    if (r0 != 0) goto L_0x006e
                    java.lang.String r0 = "ConfigAvatar_(.+?)\\.json"
                    java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
                    r5 = r0
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r1 = r0
                    r1.<init>()
                    r6 = r0
                    java.lang.String r0 = "BinOutput/Avatar/"
                    java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)     // Catch: IOException -> 0x0041
                    java.lang.String r1 = "ConfigAvatar_*.json"
                    java.nio.file.DirectoryStream r0 = java.nio.file.Files.newDirectoryStream(r0, r1)     // Catch: IOException -> 0x0041
                    r1 = r5
                    r2 = r6
                    void r1 = (v2) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                        lambda$loadAbilityEmbryos$9(r1, r2, v2);
                    }     // Catch: IOException -> 0x0041
                    r0.forEach(r1)     // Catch: IOException -> 0x0041
                    goto L_0x004c
                L_0x0041:
                    r7 = move-exception
                    ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
                    java.lang.String r1 = "Error loading ability embryos: no files found"
                    r0.error(r1)
                    return
                L_0x004c:
                    r0 = r6
                    r4 = r0
                    java.lang.String r0 = "BinOutput/AbilityGroup/AbilityGroup_Other_PlayerElementAbility.json"
                    java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)     // Catch: IOException -> 0x0063
                    java.lang.Class<java.lang.String> r1 = java.lang.String.class
                    java.lang.Class<emu.grasscutter.data.ResourceLoader$AvatarConfig> r2 = emu.grasscutter.data.ResourceLoader.AvatarConfig.class
                    java.util.Map r0 = emu.grasscutter.utils.JsonUtils.loadToMap(r0, r1, r2)     // Catch: IOException -> 0x0063
                    emu.grasscutter.data.GameDepot.setPlayerAbilities(r0)     // Catch: IOException -> 0x0063
                    goto L_0x006e
                L_0x0063:
                    r7 = move-exception
                    ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
                    java.lang.String r1 = "Error loading player abilities:"
                    r2 = r7
                    r0.error(r1, r2)
                L_0x006e:
                    r0 = r4
                    if (r0 == 0) goto L_0x007b
                    r0 = r4
                    boolean r0 = r0.isEmpty()
                    if (r0 == 0) goto L_0x0085
                L_0x007b:
                    ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
                    java.lang.String r1 = "No embryos loaded!"
                    r0.error(r1)
                    return
                L_0x0085:
                    r0 = r4
                    java.util.Iterator r0 = r0.iterator()
                    r5 = r0
                L_0x008c:
                    r0 = r5
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L_0x00b0
                    r0 = r5
                    java.lang.Object r0 = r0.next()
                    emu.grasscutter.data.binout.AbilityEmbryoEntry r0 = (emu.grasscutter.data.binout.AbilityEmbryoEntry) r0
                    r6 = r0
                    java.util.Map r0 = emu.grasscutter.data.GameData.getAbilityEmbryoInfo()
                    r1 = r6
                    java.lang.String r1 = r1.getName()
                    r2 = r6
                    java.lang.Object r0 = r0.put(r1, r2)
                    goto L_0x008c
                L_0x00b0:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadAbilityEmbryos():void");
            }

            private static void loadAbilityData(AbilityData data) {
                GameData.abilityDataMap.put(data.abilityName, data);
                Map<String, AbilityModifier> modifiers = data.modifiers;
                if (modifiers != null && modifiers.size() != 0) {
                    AbilityModifierEntry modifierEntry = new AbilityModifierEntry(data.abilityName);
                    modifiers.forEach(key, modifier -> {
                        Stream.ofNullable(modifier.onAdded).flatMap((v0) -> {
                            return Stream.of(v0);
                        }).filter(action -> {
                            return action.type == AbilityModifier.AbilityModifierAction.Type.HealHP;
                        }).forEach(action -> {
                            modifierEntry.getOnAdded().add(action);
                        });
                        Stream.ofNullable(modifier.onThinkInterval).flatMap((v0) -> {
                            return Stream.of(v0);
                        }).filter(action -> {
                            return action.type == AbilityModifier.AbilityModifierAction.Type.HealHP;
                        }).forEach(action -> {
                            modifierEntry.getOnThinkInterval().add(action);
                        });
                        Stream.ofNullable(modifier.onRemoved).flatMap((v0) -> {
                            return Stream.of(v0);
                        }).filter(action -> {
                            return action.type == AbilityModifier.AbilityModifierAction.Type.HealHP;
                        }).forEach(action -> {
                            modifierEntry.getOnRemoved().add(action);
                        });
                    });
                }
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x004e
                	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                */
            private static void loadSpawnData() {
                /*
                    r0 = 2
                    java.lang.String[] r0 = new java.lang.String[r0]
                    r1 = r0
                    r2 = 0
                    java.lang.String r3 = "Spawns.json"
                    r1[r2] = r3
                    r1 = r0
                    r2 = 1
                    java.lang.String r3 = "GadgetSpawns.json"
                    r1[r2] = r3
                    r5 = r0
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r1 = r0
                    r1.<init>()
                    r6 = r0
                    r0 = r5
                    r7 = r0
                    r0 = r7
                    int r0 = r0.length
                    r8 = r0
                    r0 = 0
                    r9 = r0
                L_0x0021:
                    r0 = r9
                    r1 = r8
                    if (r0 >= r1) goto L_0x0074
                    r0 = r7
                    r1 = r9
                    r0 = r0[r1]
                    r10 = r0
                    r0 = r10
                    java.io.InputStreamReader r0 = emu.grasscutter.data.DataLoader.loadReader(r0)     // Catch: Exception -> 0x006c
                    r11 = r0
                    r0 = r6
                    r1 = r11
                    java.lang.Class<emu.grasscutter.game.world.SpawnDataEntry$SpawnGroupEntry> r2 = emu.grasscutter.game.world.SpawnDataEntry.SpawnGroupEntry.class
                    java.util.List r1 = emu.grasscutter.utils.JsonUtils.loadToList(r1, r2)     // Catch: Exception -> 0x006c, Throwable -> 0x004e
                    boolean r0 = r0.addAll(r1)     // Catch: Exception -> 0x006c, Throwable -> 0x004e
                    r0 = r11
                    if (r0 == 0) goto L_0x0069
                    r0 = r11
                    r0.close()     // Catch: Exception -> 0x006c
                    goto L_0x0069
                L_0x004e:
                    r12 = move-exception
                    r0 = r11
                    if (r0 == 0) goto L_0x0066
                    r0 = r11
                    r0.close()     // Catch: Exception -> 0x006c, Throwable -> 0x005d
                    goto L_0x0066
                L_0x005d:
                    r13 = move-exception
                    r0 = r12
                    r1 = r13
                    r0.addSuppressed(r1)     // Catch: Exception -> 0x006c
                L_0x0066:
                    r0 = r12
                    throw r0     // Catch: Exception -> 0x006c
                L_0x0069:
                    goto L_0x006e
                L_0x006c:
                    r11 = move-exception
                L_0x006e:
                    int r9 = r9 + 1
                    goto L_0x0021
                L_0x0074:
                    r0 = r6
                    boolean r0 = r0.isEmpty()
                    if (r0 == 0) goto L_0x0085
                    ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
                    java.lang.String r1 = "No spawn data loaded!"
                    r0.error(r1)
                    return
                L_0x0085:
                    ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
                    java.lang.String r1 = "Loaded {} Spawn data!"
                    r2 = r6
                    int r2 = r2.size()
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r0.info(r1, r2)
                    java.util.HashMap r0 = new java.util.HashMap
                    r1 = r0
                    r1.<init>()
                    r7 = r0
                    r0 = r6
                    java.util.Iterator r0 = r0.iterator()
                    r8 = r0
                L_0x00a2:
                    r0 = r8
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L_0x00cb
                    r0 = r8
                    java.lang.Object r0 = r0.next()
                    emu.grasscutter.game.world.SpawnDataEntry$SpawnGroupEntry r0 = (emu.grasscutter.game.world.SpawnDataEntry.SpawnGroupEntry) r0
                    r9 = r0
                    r0 = r9
                    java.util.List r0 = r0.getSpawns()
                    r1 = r9
                    r2 = r7
                    void r1 = (v2) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                        lambda$loadSpawnData$20(r1, r2, v2);
                    }
                    r0.forEach(r1)
                    goto L_0x00a2
                L_0x00cb:
                    r0 = r7
                    emu.grasscutter.data.GameDepot.addSpawnListById(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadSpawnData():void");
            }

            private static void handleSpecialQuest() {
                ObjectIterator<QuestData> it = GameData.getQuestDataMap().values().iterator();
                while (it.hasNext()) {
                    QuestData subQuest = it.next();
                    if (!subQuest.getAcceptCond().isEmpty() || subQuest.getAcceptCond().size() == 1) {
                        if (subQuest.getAcceptCond().get(0).getType() == QuestTrigger.QUEST_COND_STATE_EQUAL && GameData.getQuestDataMap().get(subQuest.getAcceptCond().get(0).getParam()[0]).getMainId() != subQuest.getMainId()) {
                            GameData.getSpecialQuest().add(Integer.valueOf(subQuest.getSubId()));
                        }
                    }
                }
            }

            private static void loadGadgetConfigData() {
                try {
                    Files.newDirectoryStream(FileUtils.getResourcePath("BinOutput/Gadget/"), "*.json").forEach(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE  
                          (wrap: java.nio.file.DirectoryStream<java.nio.file.Path> : 0x0009: INVOKE  (r0v3 java.nio.file.DirectoryStream<java.nio.file.Path> A[REMOVE]) = 
                          (wrap: java.nio.file.Path : 0x0003: INVOKE  (r0v2 java.nio.file.Path A[REMOVE]) = ("BinOutput/Gadget/") type: STATIC call: emu.grasscutter.utils.FileUtils.getResourcePath(java.lang.String):java.nio.file.Path)
                          ("*.json")
                         type: STATIC call: java.nio.file.Files.newDirectoryStream(java.nio.file.Path, java.lang.String):java.nio.file.DirectoryStream)
                          (wrap: java.util.function.Consumer<? super java.nio.file.Path> : 0x000c: INVOKE_CUSTOM (r1v2 java.util.function.Consumer<? super java.nio.file.Path> A[REMOVE]) = 
                         handle type: INVOKE_STATIC
                         lambda: java.util.function.Consumer.accept(java.lang.Object):void
                         call insn: ?: INVOKE  (v0 java.nio.file.Path) type: STATIC call: emu.grasscutter.data.ResourceLoader.lambda$loadGadgetConfigData$30(java.nio.file.Path):void)
                         type: INTERFACE call: java.nio.file.DirectoryStream.forEach(java.util.function.Consumer):void in method: emu.grasscutter.data.ResourceLoader.loadGadgetConfigData():void, file: grasscutter.jar:emu/grasscutter/data/ResourceLoader.class
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
                        	... 21 more
                        */
                    /*
                        java.lang.String r0 = "BinOutput/Gadget/"
                        java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)     // Catch: IOException -> 0x002d
                        java.lang.String r1 = "*.json"
                        java.nio.file.DirectoryStream r0 = java.nio.file.Files.newDirectoryStream(r0, r1)     // Catch: IOException -> 0x002d
                        void r1 = (v0) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                            lambda$loadGadgetConfigData$30(v0);
                        }     // Catch: IOException -> 0x002d
                        r0.forEach(r1)     // Catch: IOException -> 0x002d
                        ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()     // Catch: IOException -> 0x002d
                        java.lang.String r1 = "Loaded {} ConfigGadget entries."
                        java.util.Map r2 = emu.grasscutter.data.GameData.getGadgetConfigData()     // Catch: IOException -> 0x002d
                        int r2 = r2.size()     // Catch: IOException -> 0x002d
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: IOException -> 0x002d
                        r0.info(r1, r2)     // Catch: IOException -> 0x002d
                        goto L_0x0037
                    L_0x002d:
                        r4 = move-exception
                        ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
                        java.lang.String r1 = "Failed to load ConfigGadget folder."
                        r0.error(r1)
                    L_0x0037:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadGadgetConfigData():void");
                }

                private static void loadSceneRoutes() {
                    try {
                        Files.newDirectoryStream(FileUtils.getResourcePath("BinOutput/LevelDesign/Routes/"), "*.json").forEach(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE  
                              (wrap: java.nio.file.DirectoryStream<java.nio.file.Path> : 0x0009: INVOKE  (r0v3 java.nio.file.DirectoryStream<java.nio.file.Path> A[REMOVE]) = 
                              (wrap: java.nio.file.Path : 0x0003: INVOKE  (r0v2 java.nio.file.Path A[REMOVE]) = ("BinOutput/LevelDesign/Routes/") type: STATIC call: emu.grasscutter.utils.FileUtils.getResourcePath(java.lang.String):java.nio.file.Path)
                              ("*.json")
                             type: STATIC call: java.nio.file.Files.newDirectoryStream(java.nio.file.Path, java.lang.String):java.nio.file.DirectoryStream)
                              (wrap: java.util.function.Consumer<? super java.nio.file.Path> : 0x000c: INVOKE_CUSTOM (r1v2 java.util.function.Consumer<? super java.nio.file.Path> A[REMOVE]) = 
                             handle type: INVOKE_STATIC
                             lambda: java.util.function.Consumer.accept(java.lang.Object):void
                             call insn: ?: INVOKE  (v0 java.nio.file.Path) type: STATIC call: emu.grasscutter.data.ResourceLoader.lambda$loadSceneRoutes$32(java.nio.file.Path):void)
                             type: INTERFACE call: java.nio.file.DirectoryStream.forEach(java.util.function.Consumer):void in method: emu.grasscutter.data.ResourceLoader.loadSceneRoutes():void, file: grasscutter.jar:emu/grasscutter/data/ResourceLoader.class
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
                            	... 21 more
                            */
                        /*
                            java.lang.String r0 = "BinOutput/LevelDesign/Routes/"
                            java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)     // Catch: IOException -> 0x002d
                            java.lang.String r1 = "*.json"
                            java.nio.file.DirectoryStream r0 = java.nio.file.Files.newDirectoryStream(r0, r1)     // Catch: IOException -> 0x002d
                            void r1 = (v0) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                                lambda$loadSceneRoutes$32(v0);
                            }     // Catch: IOException -> 0x002d
                            r0.forEach(r1)     // Catch: IOException -> 0x002d
                            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()     // Catch: IOException -> 0x002d
                            java.lang.String r1 = "Loaded {} Scene Routes."
                            java.util.Map r2 = emu.grasscutter.data.GameData.getGadgetConfigData()     // Catch: IOException -> 0x002d
                            int r2 = r2.size()     // Catch: IOException -> 0x002d
                            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: IOException -> 0x002d
                            r0.info(r1, r2)     // Catch: IOException -> 0x002d
                            goto L_0x0037
                        L_0x002d:
                            r4 = move-exception
                            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
                            java.lang.String r1 = "Failed to load SceneRoutes folder."
                            r0.error(r1)
                        L_0x0037:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadSceneRoutes():void");
                    }

                    private static void loadBlossomResources() {
                        try {
                            GameDepot.setBlossomConfig((BlossomConfig) DataLoader.loadClass("BlossomConfig.json", BlossomConfig.class));
                            Grasscutter.getLogger().info("Loaded BlossomConfig.");
                        } catch (IOException e) {
                            Grasscutter.getLogger().error("Failed to load BlossomConfig.");
                        }
                    }

                    private static void loadConfigLevelEntityData() {
                        Pattern pattern = Pattern.compile("ConfigLevelEntity_(.+?)\\.json");
                        try {
                            Files.newDirectoryStream(FileUtils.getResourcePath("BinOutput/LevelEntity/"), "ConfigLevelEntity_*.json").forEach(path -> {
                                if (pattern.matcher(path.getFileName().toString()).find()) {
                                    try {
                                        GameData.getConfigLevelEntityDataMap().putAll(JsonUtils.loadToMap(path, String.class, ConfigLevelEntity.class));
                                    } catch (Exception e) {
                                        Grasscutter.getLogger().error("Error loading player ability embryos:", (Throwable) e);
                                    }
                                }
                            });
                            if (GameData.getConfigLevelEntityDataMap() == null || GameData.getConfigLevelEntityDataMap().isEmpty()) {
                                Grasscutter.getLogger().error("No config level entity loaded!");
                            }
                        } catch (IOException e) {
                            Grasscutter.getLogger().error("Error loading config level entity: no files found");
                        }
                    }

                    private static void loadQuestShareConfig() {
                        Pattern pattern = Pattern.compile("Q(.+?)\\ShareConfig.lua");
                        try {
                            Bindings bindings = ScriptLoader.getEngine().createBindings();
                            Files.newDirectoryStream(FileUtils.getResourcePath("Scripts/Quest/Share/"), "Q*ShareConfig.lua").forEach(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0023: INVOKE  
                                  (wrap: java.nio.file.DirectoryStream<java.nio.file.Path> : 0x0019: INVOKE  (r0v7 java.nio.file.DirectoryStream<java.nio.file.Path> A[REMOVE]) = 
                                  (wrap: java.nio.file.Path : 0x0013: INVOKE  (r0v6 java.nio.file.Path A[REMOVE]) = ("Scripts/Quest/Share/") type: STATIC call: emu.grasscutter.utils.FileUtils.getResourcePath(java.lang.String):java.nio.file.Path)
                                  ("Q*ShareConfig.lua")
                                 type: STATIC call: java.nio.file.Files.newDirectoryStream(java.nio.file.Path, java.lang.String):java.nio.file.DirectoryStream)
                                  (wrap: java.util.function.Consumer<? super java.nio.file.Path> : 0x001e: INVOKE_CUSTOM (r1v3 java.util.function.Consumer<? super java.nio.file.Path> A[REMOVE]) = 
                                  (r0v1 'pattern' java.util.regex.Pattern A[D('pattern' java.util.regex.Pattern), DONT_INLINE])
                                  (r0v4 'bindings' javax.script.Bindings A[D('bindings' javax.script.Bindings), DONT_INLINE])
                                
                                 handle type: INVOKE_STATIC
                                 lambda: java.util.function.Consumer.accept(java.lang.Object):void
                                 call insn: ?: INVOKE  (r1 I:java.util.regex.Pattern), (r2 I:javax.script.Bindings), (v2 java.nio.file.Path) type: STATIC call: emu.grasscutter.data.ResourceLoader.lambda$loadQuestShareConfig$36(java.util.regex.Pattern, javax.script.Bindings, java.nio.file.Path):void)
                                 type: INTERFACE call: java.nio.file.DirectoryStream.forEach(java.util.function.Consumer):void in method: emu.grasscutter.data.ResourceLoader.loadQuestShareConfig():void, file: grasscutter.jar:emu/grasscutter/data/ResourceLoader.class
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
                                	... 21 more
                                */
                            /*
                                java.lang.String r0 = "Q(.+?)\\ShareConfig.lua"
                                java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
                                r4 = r0
                                javax.script.ScriptEngine r0 = emu.grasscutter.scripts.ScriptLoader.getEngine()     // Catch: IOException -> 0x002b
                                javax.script.Bindings r0 = r0.createBindings()     // Catch: IOException -> 0x002b
                                r5 = r0
                                java.lang.String r0 = "Scripts/Quest/Share/"
                                java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getResourcePath(r0)     // Catch: IOException -> 0x002b
                                java.lang.String r1 = "Q*ShareConfig.lua"
                                java.nio.file.DirectoryStream r0 = java.nio.file.Files.newDirectoryStream(r0, r1)     // Catch: IOException -> 0x002b
                                r1 = r4
                                r2 = r5
                                void r1 = (v2) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                                    lambda$loadQuestShareConfig$36(r1, r2, v2);
                                }     // Catch: IOException -> 0x002b
                                r0.forEach(r1)     // Catch: IOException -> 0x002b
                                goto L_0x0036
                            L_0x002b:
                                r5 = move-exception
                                ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
                                java.lang.String r1 = "Error loading Quest Share Config: no files found"
                                r0.error(r1)
                                return
                            L_0x0036:
                                it.unimi.dsi.fastutil.ints.Int2ObjectMap r0 = emu.grasscutter.data.GameData.getTeleportDataMap()
                                if (r0 == 0) goto L_0x0058
                                it.unimi.dsi.fastutil.ints.Int2ObjectMap r0 = emu.grasscutter.data.GameData.getTeleportDataMap()
                                boolean r0 = r0.isEmpty()
                                if (r0 != 0) goto L_0x0058
                                it.unimi.dsi.fastutil.ints.Int2ObjectMap r0 = emu.grasscutter.data.GameData.getRewindDataMap()
                                if (r0 == 0) goto L_0x0058
                                it.unimi.dsi.fastutil.ints.Int2ObjectMap r0 = emu.grasscutter.data.GameData.getRewindDataMap()
                                boolean r0 = r0.isEmpty()
                                if (r0 == 0) goto L_0x0062
                            L_0x0058:
                                ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
                                java.lang.String r1 = "No Quest Share Config loaded!"
                                r0.error(r1)
                                return
                            L_0x0062:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.ResourceLoader.loadQuestShareConfig():void");
                        }

                        /* loaded from: grasscutter.jar:emu/grasscutter/data/ResourceLoader$AvatarConfigAbility.class */
                        public static class AvatarConfigAbility {
                            public String abilityName;

                            public String toString() {
                                return this.abilityName;
                            }
                        }
                    }
