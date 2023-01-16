package emu.grasscutter.scripts;

import emu.grasscutter.game.props.EntityType;
import emu.grasscutter.game.quest.enums.QuestState;
import emu.grasscutter.scripts.constants.EventType;
import emu.grasscutter.scripts.constants.GroupKillPolicy;
import emu.grasscutter.scripts.constants.IntValueEnum;
import emu.grasscutter.scripts.constants.ScriptGadgetState;
import emu.grasscutter.scripts.constants.ScriptRegionShape;
import emu.grasscutter.scripts.constants.SealBattleType;
import emu.grasscutter.scripts.constants.VisionLevelType;
import emu.grasscutter.scripts.data.SceneMeta;
import emu.grasscutter.scripts.serializer.LuaSerializer;
import emu.grasscutter.scripts.serializer.Serializer;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.script.LuajContext;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/ScriptLoader.class */
public class ScriptLoader {

    /* renamed from: sm */
    private static ScriptEngineManager f955sm;
    private static ScriptEngine engine;
    private static Serializer serializer;
    private static ScriptLib scriptLib;
    private static LuaValue scriptLibLua;
    private static Map<String, SoftReference<CompiledScript>> scriptsCache = new ConcurrentHashMap();
    private static Map<Integer, SoftReference<SceneMeta>> sceneMetaCache = new ConcurrentHashMap();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0033: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0033: INVOKE_CUSTOM r1, method: emu.grasscutter.scripts.ScriptLoader.getScript(java.lang.String):javax.script.CompiledScript
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, No Found Script: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, No Found Script: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static javax.script.CompiledScript getScript(java.lang.String r6) {
        /*
            java.util.Map<java.lang.String, java.lang.ref.SoftReference<javax.script.CompiledScript>> r0 = emu.grasscutter.scripts.ScriptLoader.scriptsCache
            r1 = r6
            java.lang.Object r0 = r0.get(r1)
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0
            java.util.Optional r0 = tryGet(r0)
            r7 = r0
            r0 = r7
            boolean r0 = r0.isPresent()
            if (r0 == 0) goto L_0x001f
            r0 = r7
            java.lang.Object r0 = r0.get()
            javax.script.CompiledScript r0 = (javax.script.CompiledScript) r0
            return r0
            r0 = r6
            java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getScriptPath(r0)
            r8 = r0
            r0 = r8
            r1 = 0
            java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r1]
            boolean r0 = java.nio.file.Files.exists(r0, r1)
            if (r0 != 0) goto L_0x003d
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, No Found Script: ]}
            r0.error(r1)
            r0 = 0
            return r0
            javax.script.ScriptEngine r0 = getEngine()
            javax.script.Compilable r0 = (javax.script.Compilable) r0
            r1 = r8
            java.io.BufferedReader r1 = java.nio.file.Files.newBufferedReader(r1)
            javax.script.CompiledScript r0 = r0.compile(r1)
            r9 = r0
            java.util.Map<java.lang.String, java.lang.ref.SoftReference<javax.script.CompiledScript>> r0 = emu.grasscutter.scripts.ScriptLoader.scriptsCache
            r1 = r6
            java.lang.ref.SoftReference r2 = new java.lang.ref.SoftReference
            r3 = r2
            r4 = r9
            r3.<init>(r4)
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r9
            return r0
            r9 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Loading Script {} Failed!"
            r2 = r6
            r3 = r9
            r0.error(r1, r2, r3)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.ScriptLoader.getScript(java.lang.String):javax.script.CompiledScript");
    }

    public static ScriptEngine getEngine() {
        return engine;
    }

    public static Serializer getSerializer() {
        return serializer;
    }

    public static ScriptLib getScriptLib() {
        return scriptLib;
    }

    public static LuaValue getScriptLibLua() {
        return scriptLibLua;
    }

    public static synchronized void init() throws Exception {
        if (f955sm != null) {
            throw new Exception("Script loader already initialized");
        }
        f955sm = new ScriptEngineManager();
        engine = f955sm.getEngineByName("luaj");
        serializer = new LuaSerializer();
        LuajContext ctx = engine.getContext();
        ctx.globals.set("require", new OneArgFunction() { // from class: emu.grasscutter.scripts.ScriptLoader.1
            /*  JADX ERROR: Dependency scan failed at insn: 0x0004: INVOKE_CUSTOM r-1
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
            /*  JADX ERROR: Failed to decode insn: 0x0004: INVOKE_CUSTOM r0, method: emu.grasscutter.scripts.ScriptLoader.1.call(org.luaj.vm2.LuaValue):org.luaj.vm2.LuaValue
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Common/.lua]}
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Common/.lua]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 12 more
                */
            @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
            public org.luaj.vm2.LuaValue call(org.luaj.vm2.LuaValue r5) {
                /*
                    r4 = this;
                    r0 = r5
                    java.lang.String r0 = r0.toString()
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Common/.lua]}
                    r6 = r0
                    ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
                    java.lang.String r1 = "[LUA GLOBAL] Script {} load..."
                    r2 = r6
                    r0.debug(r1, r2)
                    org.luaj.vm2.LuaNumber r0 = org.luaj.vm2.LuaValue.ZERO
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.ScriptLoader.C26941.call(org.luaj.vm2.LuaValue):org.luaj.vm2.LuaValue");
            }
        });
        ctx.globals.set("Initial", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("InitialRotY", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("GadgetStateSwitcher", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("PlayCutScene", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("UpdateGamePlayState", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Log", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Init_Array", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Calculate_Monster", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Calculate_Platform", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Get_Legal_Platform", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Summon_Monster", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Summon_Monster_By_Platform", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Create_Monster_By_Platform", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Notify_Platform_Sink", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Create_Boss", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Reset_Platform_State", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Recover_Platform", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Reset_Platform", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Platform_Arrival", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Initialize_Variable", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Remove_Extra_Suite", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Set_Secure_Timer", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("LF_Manage_OceanId_Replacement", CoerceJavaToLua.coerce(new Object()));
        ctx.globals.set("SLC_OCEANID_ESCAPE", CoerceJavaToLua.coerce(new Object()));
        addEnumByIntValue(ctx, EntityType.values(), "EntityType");
        addEnumByIntValue(ctx, QuestState.values(), "QuestState");
        addEnumByOrdinal(ctx, GroupKillPolicy.values(), "GroupKillPolicy");
        addEnumByOrdinal(ctx, SealBattleType.values(), "SealBattleType");
        addEnumByOrdinal(ctx, VisionLevelType.values(), "VisionLevelType");
        ctx.globals.set("EventType", CoerceJavaToLua.coerce(new EventType()));
        ctx.globals.set("GadgetState", CoerceJavaToLua.coerce(new ScriptGadgetState()));
        ctx.globals.set("RegionShape", CoerceJavaToLua.coerce(new ScriptRegionShape()));
        scriptLib = new ScriptLib();
        scriptLibLua = CoerceJavaToLua.coerce(scriptLib);
        ctx.globals.set("ScriptLib", scriptLibLua);
    }

    private static <T extends Enum<T>> void addEnumByOrdinal(LuajContext ctx, T[] enumArray, String name) {
        LuaTable table = new LuaTable();
        Arrays.stream(enumArray).forEach(e -> {
            table.set(e.name().toUpperCase(), e.ordinal());
        });
        ctx.globals.set(name, table);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lemu/grasscutter/scripts/constants/IntValueEnum;>(Lorg/luaj/vm2/script/LuajContext;[TT;Ljava/lang/String;)V */
    private static void addEnumByIntValue(LuajContext ctx, Enum[] enumArr, String name) {
        LuaTable table = new LuaTable();
        Arrays.stream(enumArr).forEach(e -> {
            table.set(e.name().toUpperCase(), ((IntValueEnum) e).getValue());
        });
        ctx.globals.set(name, table);
    }

    public static <T> Optional<T> tryGet(SoftReference<T> softReference) {
        try {
            return Optional.ofNullable(softReference.get());
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    public static SceneMeta getSceneMeta(int sceneId) {
        return (SceneMeta) tryGet(sceneMetaCache.get(Integer.valueOf(sceneId))).orElseGet(() -> {
            SceneMeta instance = SceneMeta.m1193of(sceneId);
            sceneMetaCache.put(Integer.valueOf(sceneId), new SoftReference<>(instance));
            return instance;
        });
    }
}
