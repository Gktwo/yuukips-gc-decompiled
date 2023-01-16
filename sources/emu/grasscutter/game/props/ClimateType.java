package emu.grasscutter.game.props;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/*  JADX ERROR: NullPointerException in pass: EnumVisitor
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.nodes.MethodNode.getBasicBlocks()" is null
    	at jadx.core.utils.InsnUtils.searchInsn(InsnUtils.java:132)
    	at jadx.core.dex.visitors.EnumVisitor.usesValuesField(EnumVisitor.java:467)
    	at jadx.core.dex.visitors.EnumVisitor.removeEnumMethods(EnumVisitor.java:426)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:172)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:75)
    */
/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ClimateType.class */
public enum ClimateType {
    CLIMATE_NONE(0),
    CLIMATE_SUNNY(1),
    CLIMATE_CLOUDY(2),
    CLIMATE_RAIN(3),
    CLIMATE_THUNDERSTORM(4),
    CLIMATE_SNOW(5),
    CLIMATE_MIST(6);
    
    private final int value;
    private static final Int2ObjectMap<ClimateType> map = new Int2ObjectOpenHashMap();
    private static final Map<String, ClimateType> stringMap = new HashMap();

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
    /*  JADX ERROR: Failed to decode insn: 0x0004: INVOKE_CUSTOM r0, method: emu.grasscutter.game.props.ClimateType.getTypeByShortName(java.lang.String):emu.grasscutter.game.props.ClimateType
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, CLIMATE_]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, CLIMATE_]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static emu.grasscutter.game.props.ClimateType getTypeByShortName(java.lang.String r4) {
        /*
            r0 = r4
            java.lang.String r0 = r0.toUpperCase()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, CLIMATE_]}
            r5 = r0
            java.util.Map<java.lang.String, emu.grasscutter.game.props.ClimateType> r0 = emu.grasscutter.game.props.ClimateType.stringMap
            r1 = r5
            emu.grasscutter.game.props.ClimateType r2 = emu.grasscutter.game.props.ClimateType.CLIMATE_NONE
            java.lang.Object r0 = r0.getOrDefault(r1, r2)
            emu.grasscutter.game.props.ClimateType r0 = (emu.grasscutter.game.props.ClimateType) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.props.ClimateType.getTypeByShortName(java.lang.String):emu.grasscutter.game.props.ClimateType");
    }

    static {
        Stream.of((Object[]) values()).forEach(e -> {
            map.put(e.getValue(), (int) e);
            stringMap.put(e.name(), e);
        });
    }

    ClimateType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String getShortName() {
        return name().substring(8).toLowerCase();
    }

    public static ClimateType getTypeByValue(int value) {
        return map.getOrDefault(value, (int) CLIMATE_NONE);
    }

    public static ClimateType getTypeByName(String name) {
        return stringMap.getOrDefault(name, CLIMATE_NONE);
    }
}
