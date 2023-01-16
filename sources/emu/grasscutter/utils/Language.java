package emu.grasscutter.utils;

import com.google.gson.JsonElement;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.ResourceLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import p014it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import p014it.unimi.dsi.fastutil.ints.IntSet;
import p014it.unimi.dsi.fastutil.objects.Object2IntMap;
import p014it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:894)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:367)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:119)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:49)
    */
/* loaded from: grasscutter.jar:emu/grasscutter/utils/Language.class */
public final class Language {
    private final String languageCode;
    private final Map<String, String> translations;
    private static final int TEXTMAP_CACHE_VERSION = -1664430588;
    private static Int2ObjectMap<TextStrings> textMapStrings;
    private static final Map<String, Language> cachedLanguages = new ConcurrentHashMap();
    private static boolean scannedTextmaps = false;
    private static final Pattern textMapKeyValueRegex = Pattern.compile("\"(\\d+)\": \"(.+)\"");
    private static final Path TEXTMAP_CACHE_PATH = Path.of(Utils.toFilePath("cache/TextMapCache.bin"), new String[0]);

    /*  JADX ERROR: Dependency scan failed at insn: 0x00AA: INVOKE_CUSTOM r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x00AA: INVOKE_CUSTOM r1, method: emu.grasscutter.utils.Language.translate(java.lang.String, java.lang.Object[]):java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Failed to format string: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Failed to format string: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static java.lang.String translate(java.lang.String r6, java.lang.Object... r7) {
        /*
            emu.grasscutter.utils.Language r0 = emu.grasscutter.Grasscutter.getLanguage()
            r1 = r6
            java.lang.String r0 = r0.get(r1)
            r8 = r0
            r0 = 0
            r9 = r0
            r0 = r9
            r1 = r7
            int r1 = r1.length
            if (r0 >= r1) goto L_0x009f
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r9
            r2 = r2[r3]
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r10 = r2
            r2 = -1
            r11 = r2
            r2 = r10
            int r2 = r2.hashCode()
            switch(r2) {
                case -1808118735: goto L_0x0040;
                case -1053826955: goto L_0x0050;
                default: goto L_0x005d;
            }
            r2 = r10
            java.lang.String r3 = "String"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x005d
            r2 = 0
            r11 = r2
            goto L_0x005d
            r2 = r10
            java.lang.String r3 = "TextStrings"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x005d
            r2 = 1
            r11 = r2
            r2 = r11
            switch(r2) {
                case 0: goto L_0x0078;
                case 1: goto L_0x007e;
                default: goto L_0x0092;
            }
            r2 = r7
            r3 = r9
            r2 = r2[r3]
            goto L_0x0098
            r2 = r7
            r3 = r9
            r2 = r2[r3]
            emu.grasscutter.utils.Language$TextStrings r2 = (emu.grasscutter.utils.Language.TextStrings) r2
            r3 = 0
            java.lang.String r2 = r2.get(r3)
            java.lang.String r3 = "\\\\n"
            java.lang.String r4 = "\\n"
            java.lang.String r2 = r2.replace(r3, r4)
            goto L_0x0098
            r2 = r7
            r3 = r9
            r2 = r2[r3]
            java.lang.String r2 = r2.toString()
            r0[r1] = r2
            int r9 = r9 + 1
            goto L_0x000a
            r0 = r8
            r1 = r7
            java.lang.String r0 = r0.formatted(r1)
            return r0
            r9 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Failed to format string: ]}
            r2 = r9
            r0.error(r1, r2)
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.Language.translate(java.lang.String, java.lang.Object[]):java.lang.String");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x00CB: INVOKE_CUSTOM r-7
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
    /*  JADX ERROR: Failed to decode insn: 0x00CB: INVOKE_CUSTOM r1, method: emu.grasscutter.utils.Language.translate(emu.grasscutter.game.player.Player, java.lang.String, java.lang.Object[]):java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Failed to format string: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Failed to format string: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static java.lang.String translate(emu.grasscutter.game.player.Player r6, java.lang.String r7, java.lang.Object... r8) {
        /*
            r0 = r6
            if (r0 != 0) goto L_0x000a
            r0 = r7
            r1 = r8
            java.lang.String r0 = translate(r0, r1)
            return r0
            r0 = r6
            emu.grasscutter.game.Account r0 = r0.getAccount()
            java.util.Locale r0 = r0.getLocale()
            java.lang.String r0 = emu.grasscutter.utils.Utils.getLanguageCode(r0)
            r9 = r0
            r0 = r9
            emu.grasscutter.utils.Language r0 = getLanguage(r0)
            r1 = r7
            java.lang.String r0 = r0.get(r1)
            r10 = r0
            r0 = 0
            r11 = r0
            r0 = r11
            r1 = r8
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00be
            r0 = r8
            r1 = r11
            r2 = r8
            r3 = r11
            r2 = r2[r3]
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r12 = r2
            r2 = -1
            r13 = r2
            r2 = r12
            int r2 = r2.hashCode()
            switch(r2) {
                case -1808118735: goto L_0x005c;
                case -1053826955: goto L_0x006c;
                default: goto L_0x0079;
            }
            r2 = r12
            java.lang.String r3 = "String"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0079
            r2 = 0
            r13 = r2
            goto L_0x0079
            r2 = r12
            java.lang.String r3 = "TextStrings"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0079
            r2 = 1
            r13 = r2
            r2 = r13
            switch(r2) {
                case 0: goto L_0x0094;
                case 1: goto L_0x009b;
                default: goto L_0x00b0;
            }
            r2 = r8
            r3 = r11
            r2 = r2[r3]
            goto L_0x00b7
            r2 = r8
            r3 = r11
            r2 = r2[r3]
            emu.grasscutter.utils.Language$TextStrings r2 = (emu.grasscutter.utils.Language.TextStrings) r2
            r3 = r9
            java.lang.String r2 = r2.getGC(r3)
            java.lang.String r3 = "\\\\n"
            java.lang.String r4 = "\n"
            java.lang.String r2 = r2.replace(r3, r4)
            goto L_0x00b7
            r2 = r8
            r3 = r11
            r2 = r2[r3]
            java.lang.String r2 = r2.toString()
            r0[r1] = r2
            int r11 = r11 + 1
            goto L_0x0022
            r0 = r10
            r1 = r8
            java.lang.String r0 = r0.formatted(r1)
            return r0
            r11 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Failed to format string: ]}
            r2 = r11
            r0.error(r1, r2)
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.Language.translate(emu.grasscutter.game.player.Player, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0041: INVOKE_CUSTOM r-7
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
    /*  JADX ERROR: Failed to decode insn: 0x0041: INVOKE_CUSTOM r1, method: emu.grasscutter.utils.Language.<init>(emu.grasscutter.utils.Language$LanguageStreamDescription):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Failed to load language file: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Failed to load language file: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private Language(emu.grasscutter.utils.Language.LanguageStreamDescription r5) {
        /*
            r4 = this;
            r0 = r4
            r0.<init>()
            r0 = r4
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap
            r2 = r1
            r2.<init>()
            r0.translations = r1
            r0 = r4
            r1 = r5
            java.lang.String r1 = r1.getLanguageCode()
            r0.languageCode = r1
            r0 = r5
            java.io.InputStream r0 = r0.getLanguageFile()
            java.lang.String r0 = emu.grasscutter.utils.Utils.readFromInputStream(r0)
            java.lang.Class<com.google.gson.JsonObject> r1 = com.google.gson.JsonObject.class
            java.lang.Object r0 = emu.grasscutter.utils.JsonUtils.decode(r0, r1)
            com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0
            r6 = r0
            r0 = r6
            java.util.Set r0 = r0.entrySet()
            r1 = r4
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$new$1(v1);
            }
            r0.forEach(r1)
            goto L_0x004a
            r6 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r5
            java.lang.String r1 = r1.getLanguageCode()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Failed to load language file: ]}
            r2 = r6
            r0.warn(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.Language.<init>(emu.grasscutter.utils.Language$LanguageStreamDescription):void");
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0008: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0014: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0028: INVOKE_CUSTOM r-2, r-1
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x004E: INVOKE_CUSTOM r-6
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0061: INVOKE_CUSTOM r-6
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
    /*  JADX ERROR: Failed to decode insn: 0x0001: INVOKE_CUSTOM r0, method: emu.grasscutter.utils.Language.getLanguageFileDescription(java.lang.String, java.lang.String):emu.grasscutter.utils.Language$LanguageStreamDescription
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .json]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .json]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r0, method: emu.grasscutter.utils.Language.getLanguageFileDescription(java.lang.String, java.lang.String):emu.grasscutter.utils.Language$LanguageStreamDescription
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .json]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .json]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0014: INVOKE_CUSTOM r1, method: emu.grasscutter.utils.Language.getLanguageFileDescription(java.lang.String, java.lang.String):emu.grasscutter.utils.Language$LanguageStreamDescription
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, /languages/]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, /languages/]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0028: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.utils.Language.getLanguageFileDescription(java.lang.String, java.lang.String):emu.grasscutter.utils.Language$LanguageStreamDescription
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Failed to load language file: , falling back to: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Failed to load language file: , falling back to: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x004E: INVOKE_CUSTOM r1, method: emu.grasscutter.utils.Language.getLanguageFileDescription(java.lang.String, java.lang.String):emu.grasscutter.utils.Language$LanguageStreamDescription
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, /languages/]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, /languages/]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0061: INVOKE_CUSTOM r1, method: emu.grasscutter.utils.Language.getLanguageFileDescription(java.lang.String, java.lang.String):emu.grasscutter.utils.Language$LanguageStreamDescription
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Failed to load language file: , falling back to: en-US.json]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Failed to load language file: , falling back to: en-US.json]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static emu.grasscutter.utils.Language.LanguageStreamDescription getLanguageFileDescription(java.lang.String r5, java.lang.String r6) {
        /*
            r0 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .json]}
            r7 = r0
            r0 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .json]}
            r8 = r0
            r0 = r5
            r9 = r0
            java.lang.Class<emu.grasscutter.Grasscutter> r0 = emu.grasscutter.Grasscutter.class
            r1 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, /languages/]}
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L_0x0058
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r7
            r2 = r8
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Failed to load language file: , falling back to: ]}
            r0.warn(r1)
            r0 = r6
            r9 = r0
            java.util.Map<java.lang.String, emu.grasscutter.utils.Language> r0 = emu.grasscutter.utils.Language.cachedLanguages
            r1 = r9
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x004b
            emu.grasscutter.utils.Language$LanguageStreamDescription r0 = new emu.grasscutter.utils.Language$LanguageStreamDescription
            r1 = r0
            r2 = r9
            r3 = 0
            r1.<init>(r2, r3)
            return r0
            java.lang.Class<emu.grasscutter.Grasscutter> r0 = emu.grasscutter.Grasscutter.class
            r1 = r8
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, /languages/]}
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L_0x008e
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r8
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Failed to load language file: , falling back to: en-US.json]}
            r0.warn(r1)
            java.lang.String r0 = "en-US"
            r9 = r0
            java.util.Map<java.lang.String, emu.grasscutter.utils.Language> r0 = emu.grasscutter.utils.Language.cachedLanguages
            r1 = r9
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0085
            emu.grasscutter.utils.Language$LanguageStreamDescription r0 = new emu.grasscutter.utils.Language$LanguageStreamDescription
            r1 = r0
            r2 = r9
            r3 = 0
            r1.<init>(r2, r3)
            return r0
            java.lang.Class<emu.grasscutter.Grasscutter> r0 = emu.grasscutter.Grasscutter.class
            java.lang.String r1 = "/languages/en-US.json"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L_0x009d
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            java.lang.String r2 = "Unable to load the primary, fallback, and 'en-US' language files."
            r1.<init>(r2)
            throw r0
            emu.grasscutter.utils.Language$LanguageStreamDescription r0 = new emu.grasscutter.utils.Language$LanguageStreamDescription
            r1 = r0
            r2 = r9
            r3 = r10
            r1.<init>(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.Language.getLanguageFileDescription(java.lang.String, java.lang.String):emu.grasscutter.utils.Language$LanguageStreamDescription");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0020: INVOKE_CUSTOM r-4, r-3
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0049: INVOKE_CUSTOM r-8, r-7
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
    /*  JADX ERROR: Failed to decode insn: 0x0020: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.utils.Language.get(java.lang.String):java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0049: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.utils.Language.get(java.lang.String):java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, 
        here is english version:
        ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, 
        here is english version:
        ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String get(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r3
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.translations
            r1 = r4
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x001b
            r0 = r3
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.translations
            r1 = r4
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            return r0
            java.lang.String r0 = "This value does not exist. Please report this to the Discord: "
            r5 = r0
            r0 = r5
            r1 = r4
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, ]}
            r6 = r0
            r0 = r3
            java.lang.String r0 = r0.languageCode
            java.lang.String r1 = "en-US"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004f
            java.lang.String r0 = "en-US"
            emu.grasscutter.utils.Language r0 = getLanguage(r0)
            r1 = r4
            java.lang.String r0 = r0.get(r1)
            r7 = r0
            r0 = r7
            r1 = r5
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x004f
            r0 = r6
            r1 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, 
here is english version:
]}
            r6 = r0
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.Language.get(java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x000D: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x009B: INVOKE_CUSTOM r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x000D: INVOKE_CUSTOM r2, method: emu.grasscutter.utils.Language.loadTextMapFile(java.lang.String, it.unimi.dsi.fastutil.ints.IntSet):it.unimi.dsi.fastutil.ints.Int2ObjectMap<java.lang.String>
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, TextMap/TextMap.json]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, TextMap/TextMap.json]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x009B: INVOKE_CUSTOM r1, method: emu.grasscutter.utils.Language.loadTextMapFile(java.lang.String, it.unimi.dsi.fastutil.ints.IntSet):it.unimi.dsi.fastutil.ints.Int2ObjectMap<java.lang.String>
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error loading textmap: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error loading textmap: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static p014it.unimi.dsi.fastutil.ints.Int2ObjectMap<java.lang.String> loadTextMapFile(java.lang.String r6, p014it.unimi.dsi.fastutil.ints.IntSet r7) {
        /*
            it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap r0 = new it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
            r1 = r0
            r1.<init>()
            r8 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r1 = r0
            r2 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, TextMap/TextMap.json]}
            java.nio.file.Path r2 = emu.grasscutter.utils.FileUtils.getResourcePath(r2)
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
            java.io.BufferedReader r2 = java.nio.file.Files.newBufferedReader(r2, r3)
            r1.<init>(r2)
            r9 = r0
            java.util.regex.Pattern r0 = emu.grasscutter.utils.Language.textMapKeyValueRegex
            java.lang.String r1 = ""
            java.util.regex.Matcher r0 = r0.matcher(r1)
            r10 = r0
            it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap r0 = new it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
            r1 = r0
            r2 = r9
            java.util.stream.Stream r2 = r2.lines()
            java.util.stream.BaseStream r2 = r2.sequential()
            java.util.stream.Stream r2 = (java.util.stream.Stream) r2
            r3 = r10
            r4 = r3
            java.lang.Object r4 = java.util.Objects.requireNonNull(r4)
            it.unimi.dsi.fastutil.ints.Int2ObjectMap<java.lang.String> r3 = (v1) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return r3.reset(v1);
            }
            java.util.stream.Stream r2 = r2.map(r3)
            it.unimi.dsi.fastutil.ints.Int2ObjectMap<java.lang.String> r3 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return v0.find();
            }
            java.util.stream.Stream r2 = r2.filter(r3)
            r3 = r7
            it.unimi.dsi.fastutil.ints.Int2ObjectMap<java.lang.String> r3 = (v1) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$loadTextMapFile$2(r3, v1);
            }
            java.util.stream.Stream r2 = r2.filter(r3)
            it.unimi.dsi.fastutil.ints.Int2ObjectMap<java.lang.String> r3 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$loadTextMapFile$3(v0);
            }
            it.unimi.dsi.fastutil.ints.Int2ObjectMap<java.lang.String> r4 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$loadTextMapFile$4(v0);
            }
            java.util.stream.Collector r3 = java.util.stream.Collectors.toMap(r3, r4)
            java.lang.Object r2 = r2.collect(r3)
            java.util.Map r2 = (java.util.Map) r2
            r1.<init>(r2)
            r11 = r0
            r0 = r9
            r0.close()
            r0 = r11
            return r0
            r10 = move-exception
            r0 = r9
            r0.close()
            goto L_0x0093
            r11 = move-exception
            r0 = r10
            r1 = r11
            r0.addSuppressed(r1)
            r0 = r10
            throw r0
            r9 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error loading textmap: ]}
            r0.error(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r9
            java.lang.String r1 = r1.toString()
            r0.error(r1)
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.Language.loadTextMapFile(java.lang.String, it.unimi.dsi.fastutil.ints.IntSet):it.unimi.dsi.fastutil.ints.Int2ObjectMap");
    }

    public static Language getLanguage(String langCode) {
        Language languageInst;
        if (cachedLanguages.containsKey(langCode)) {
            return cachedLanguages.get(langCode);
        }
        LanguageStreamDescription description = getLanguageFileDescription(langCode, Utils.getLanguageCode(Configuration.FALLBACK_LANGUAGE));
        String actualLanguageCode = description.getLanguageCode();
        if (description.getLanguageFile() != null) {
            languageInst = new Language(description);
            cachedLanguages.put(actualLanguageCode, languageInst);
        } else {
            languageInst = cachedLanguages.get(actualLanguageCode);
            cachedLanguages.put(langCode, languageInst);
        }
        return languageInst;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    private static void putFlattenedKey(Map<String, String> map, String key, JsonElement element) {
        if (element.isJsonObject()) {
            element.getAsJsonObject().entrySet().forEach(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                  (wrap: java.util.Set<java.util.Map$Entry<java.lang.String, com.google.gson.JsonElement>> : 0x000b: INVOKE  (r0v6 java.util.Set<java.util.Map$Entry<java.lang.String, com.google.gson.JsonElement>> A[REMOVE]) = 
                  (wrap: com.google.gson.JsonObject : 0x0008: INVOKE  (r0v5 com.google.gson.JsonObject A[REMOVE]) = (r6v0 'element' com.google.gson.JsonElement A[D('element' com.google.gson.JsonElement)]) type: VIRTUAL call: com.google.gson.JsonElement.getAsJsonObject():com.google.gson.JsonObject)
                 type: VIRTUAL call: com.google.gson.JsonObject.entrySet():java.util.Set)
                  (wrap: java.util.function.Consumer : 0x0010: INVOKE_CUSTOM (r1v2 java.util.function.Consumer A[REMOVE]) = 
                  (r5v0 'key' java.lang.String A[D('key' java.lang.String), DONT_INLINE])
                  (r4v0 'map' java.util.Map<java.lang.String, java.lang.String> A[D('map' java.util.Map<java.lang.String, java.lang.String>), DONT_INLINE])
                
                 handle type: INVOKE_STATIC
                 lambda: java.util.function.Consumer.accept(java.lang.Object):void
                 call insn: ?: INVOKE  (r1 I:java.lang.String), (r2 I:java.util.Map), (v2 java.util.Map$Entry) type: STATIC call: emu.grasscutter.utils.Language.lambda$putFlattenedKey$0(java.lang.String, java.util.Map, java.util.Map$Entry):void)
                 type: INTERFACE call: java.util.Set.forEach(java.util.function.Consumer):void in method: emu.grasscutter.utils.Language.putFlattenedKey(java.util.Map<java.lang.String, java.lang.String>, java.lang.String, com.google.gson.JsonElement):void, file: grasscutter.jar:emu/grasscutter/utils/Language.class
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
                r0 = r6
                boolean r0 = r0.isJsonObject()
                if (r0 == 0) goto L_0x001d
                r0 = r6
                com.google.gson.JsonObject r0 = r0.getAsJsonObject()
                java.util.Set r0 = r0.entrySet()
                r1 = r5
                r2 = r4
                void r1 = (v2) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                    lambda$putFlattenedKey$0(r1, r2, v2);
                }
                r0.forEach(r1)
                goto L_0x0029
            L_0x001d:
                r0 = r4
                r1 = r5
                r2 = r6
                java.lang.String r2 = r2.getAsString()
                java.lang.Object r0 = r0.put(r1, r2)
            L_0x0029:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.Language.putFlattenedKey(java.util.Map, java.lang.String, com.google.gson.JsonElement):void");
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/utils/Language$LanguageStreamDescription.class */
        public static class LanguageStreamDescription {
            private final String languageCode;
            private final InputStream languageFile;

            public LanguageStreamDescription(String languageCode, InputStream languageFile) {
                this.languageCode = languageCode;
                this.languageFile = languageFile;
            }

            public String getLanguageCode() {
                return this.languageCode;
            }

            public InputStream getLanguageFile() {
                return this.languageFile;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/utils/Language$TextStrings.class */
        public static class TextStrings implements Serializable {
            public static final String[] ARR_LANGUAGES = {"EN", "CHS", "CHT", "JP", "KR", "DE", "ES", "FR", "ID", "PT", "RU", "TH", "VI"};
            public static final String[] ARR_GC_LANGUAGES = {"en-US", "zh-CN", "zh-TW", "ja-JP", "ko-KR", "en-US", "es-ES", "fr-FR", "id-ID", "en-US", "ru-RU", "en-US", "en-US"};
            public static final int NUM_LANGUAGES = ARR_LANGUAGES.length;
            public static final List<String> LIST_LANGUAGES = Arrays.asList(ARR_LANGUAGES);
            public static final Object2IntMap<String> MAP_LANGUAGES = new Object2IntOpenHashMap((Map) IntStream.range(0, ARR_LANGUAGES.length).boxed().collect(Collectors.toMap(i -> {
                return ARR_LANGUAGES[i.intValue()];
            }, i -> {
                return i;
            })));
            public static final Object2IntMap<String> MAP_GC_LANGUAGES = new Object2IntOpenHashMap((Map) IntStream.range(0, ARR_GC_LANGUAGES.length).boxed().collect(Collectors.toMap(i -> {
                return ARR_GC_LANGUAGES[i.intValue()];
            }, i -> {
                return i;
            }, i1, i2 -> {
                return i1;
            })));
            public String[] strings;

            @Override // java.lang.Object
            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof TextStrings)) {
                    return false;
                }
                TextStrings other = (TextStrings) o;
                return other.canEqual(this) && Arrays.deepEquals(this.strings, other.strings);
            }

            protected boolean canEqual(Object other) {
                return other instanceof TextStrings;
            }

            @Override // java.lang.Object
            public int hashCode() {
                return (1 * 59) + Arrays.deepHashCode(this.strings);
            }

            public TextStrings() {
                this.strings = new String[ARR_LANGUAGES.length];
            }

            public TextStrings(String init) {
                this.strings = new String[ARR_LANGUAGES.length];
                for (int i = 0; i < NUM_LANGUAGES; i++) {
                    this.strings[i] = init;
                }
            }

            public TextStrings(List<String> strings, int key) {
                this.strings = new String[ARR_LANGUAGES.length];
                String nullReplacement = "[N/A] %d".formatted(new Object[]{Long.valueOf(((long) key) & 4294967295L)});
                int i = 0;
                while (true) {
                    if (i >= NUM_LANGUAGES) {
                        break;
                    }
                    String s = strings.get(i);
                    if (s != null) {
                        nullReplacement = "[%s] - %s".formatted(new Object[]{ARR_LANGUAGES[i], s});
                        break;
                    }
                    i++;
                }
                for (int i2 = 0; i2 < NUM_LANGUAGES; i2++) {
                    String s2 = strings.get(i2);
                    if (s2 != null) {
                        this.strings[i2] = s2;
                    } else {
                        this.strings[i2] = nullReplacement;
                    }
                }
            }

            public static List<Language> getLanguages() {
                return Arrays.stream(ARR_GC_LANGUAGES).map(Language::getLanguage).toList();
            }

            public String get(int languageIndex) {
                return this.strings[languageIndex];
            }

            public String get(String languageCode) {
                return this.strings[MAP_LANGUAGES.getOrDefault(languageCode, 0)];
            }

            public String getGC(String languageCode) {
                return this.strings[MAP_GC_LANGUAGES.getOrDefault(languageCode, 0)];
            }

            public boolean set(String languageCode, String string) {
                int index = MAP_LANGUAGES.getOrDefault(languageCode, -1);
                if (index < 0) {
                    return false;
                }
                this.strings[index] = string;
                return true;
            }
        }

        private static Int2ObjectMap<TextStrings> loadTextMapFiles(IntSet nameHashes) {
            Map<Integer, Int2ObjectMap<String>> mapLanguageMaps = (Map) TextStrings.LIST_LANGUAGES.parallelStream().collect(Collectors.toConcurrentMap(s -> {
                return Integer.valueOf(TextStrings.MAP_LANGUAGES.getInt(s));
            }, s -> {
                return loadTextMapFile(s, nameHashes);
            }));
            List<Int2ObjectMap<String>> languageMaps = (List) IntStream.range(0, TextStrings.NUM_LANGUAGES).mapToObj(i -> {
                return (Int2ObjectMap) mapLanguageMaps.get(Integer.valueOf(i));
            }).collect(Collectors.toList());
            Map<TextStrings, TextStrings> canonicalTextStrings = new HashMap<>();
            return new Int2ObjectOpenHashMap((Map) nameHashes.intStream().boxed().collect(Collectors.toMap(key -> {
                return key;
            }, key -> {
                TextStrings t = new TextStrings((List) IntStream.range(0, TextStrings.NUM_LANGUAGES).mapToObj(i -> {
                    return (String) ((Int2ObjectMap) languageMaps.get(i)).get(key.intValue());
                }).collect(Collectors.toList()), key.intValue());
                return (TextStrings) canonicalTextStrings.computeIfAbsent(t, x -> {
                    return t;
                });
            })));
        }

        private static Int2ObjectMap<TextStrings> loadTextMapsCache() throws Exception {
            ObjectInputStream file = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(TEXTMAP_CACHE_PATH, new OpenOption[0]), 1048576));
            try {
                if (file.readInt() != TEXTMAP_CACHE_VERSION) {
                    throw new Exception("Invalid cache version");
                }
                Int2ObjectMap<TextStrings> int2ObjectMap = (Int2ObjectMap) file.readObject();
                file.close();
                return int2ObjectMap;
            } catch (Throwable th) {
                try {
                    file.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        private static void saveTextMapsCache(Int2ObjectMap<TextStrings> input) throws IOException {
            try {
                Files.createDirectory(Path.of("cache", new String[0]), new FileAttribute[0]);
            } catch (FileAlreadyExistsException e) {
            }
            ObjectOutputStream file = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(TEXTMAP_CACHE_PATH, StandardOpenOption.CREATE), 1048576));
            try {
                file.writeInt(TEXTMAP_CACHE_VERSION);
                file.writeObject(input);
                file.close();
            } catch (Throwable th) {
                try {
                    file.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public static Int2ObjectMap<TextStrings> getTextMapStrings() {
            if (textMapStrings == null) {
                loadTextMaps();
            }
            return textMapStrings;
        }

        public static TextStrings getTextMapKey(int key) {
            if (textMapStrings == null || (!scannedTextmaps && !textMapStrings.containsKey(key))) {
                loadTextMaps();
            }
            return textMapStrings.get(key);
        }

        public static TextStrings getTextMapKey(long hash) {
            return getTextMapKey((int) hash);
        }

        public static void loadTextMaps() {
            long cacheModified;
            long textmapsModified;
            try {
                cacheModified = Files.getLastModifiedTime(TEXTMAP_CACHE_PATH, new LinkOption[0]).toMillis();
                textmapsModified = ((Long) Files.list(FileUtils.getResourcePath("TextMap")).filter(path -> {
                    return path.toString().endsWith(".json");
                }).map(path -> {
                    try {
                        return Long.valueOf(Files.getLastModifiedTime(path, new LinkOption[0]).toMillis());
                    } catch (Exception e) {
                        Grasscutter.getLogger().error("Exception while checking modified time: ", path);
                        return Long.valueOf((long) LongCompanionObject.MAX_VALUE);
                    }
                }).max((v0, v1) -> {
                    return Long.compare(v0, v1);
                }).get()).longValue();
                Grasscutter.getLogger().info("Cache modified %d, textmap modified %d".formatted(new Object[]{Long.valueOf(cacheModified), Long.valueOf(textmapsModified)}));
            } catch (NoSuchFileException e) {
                Grasscutter.getLogger().warn("Cache not found");
            } catch (Exception e2) {
                Grasscutter.getLogger().error("Exception while checking cache: ", (Throwable) e2);
            }
            if (textmapsModified < cacheModified) {
                Grasscutter.getLogger().debug("Loading cached TextMaps");
                textMapStrings = loadTextMapsCache();
                return;
            }
            Grasscutter.getLogger().info("Generating TextMaps cache");
            ResourceLoader.loadAll();
            IntSet usedHashes = new IntOpenHashSet();
            GameData.getAvatarDataMap().forEach(k, v -> {
                usedHashes.add((int) v.getNameTextMapHash());
            });
            GameData.getAvatarSkillDataMap().forEach(k, v -> {
                usedHashes.add((int) v.getNameTextMapHash());
                usedHashes.add((int) v.getDescTextMapHash());
            });
            GameData.getItemDataMap().forEach(k, v -> {
                usedHashes.add((int) v.getNameTextMapHash());
            });
            GameData.getGadgetDataMap().forEach(k, v -> {
                usedHashes.add((int) v.getNameTextMapHash());
            });
            GameData.getHomeWorldBgmDataMap().forEach(k, v -> {
                usedHashes.add((int) v.getBgmNameTextMapHash());
            });
            GameData.getMonsterDataMap().forEach(k, v -> {
                usedHashes.add((int) v.getNameTextMapHash());
            });
            GameData.getMainQuestDataMap().forEach(k, v -> {
                usedHashes.add((int) v.getTitleTextMapHash());
            });
            GameData.getQuestDataMap().forEach(k, v -> {
                usedHashes.add((int) v.getDescTextMapHash());
            });
            usedHashes.add(-61820601);
            usedHashes.add(-63623393);
            usedHashes.add(332935371);
            usedHashes.add(-2022796669);
            usedHashes.add(-942454149);
            usedHashes.add(-1430698773);
            textMapStrings = loadTextMapFiles(usedHashes);
            scannedTextmaps = true;
            try {
                saveTextMapsCache(textMapStrings);
            } catch (IOException e3) {
                Grasscutter.getLogger().debug("Failed to save TextMap cache: ", (Throwable) e3);
            }
        }
    }
