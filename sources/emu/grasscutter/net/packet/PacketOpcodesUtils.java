package emu.grasscutter.net.packet;

import emu.grasscutter.Grasscutter;
import java.lang.reflect.Field;
import java.util.Set;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/net/packet/PacketOpcodesUtils.class */
public class PacketOpcodesUtils {
    public static final Set<Integer> BANNED_PACKETS = Set.of(1114, 191);
    public static final Set<Integer> LOOP_PACKETS = Set.of(20, 74, 92, 69, Integer.valueOf((int) PacketOpcodes.QueryPathReq));
    private static Int2ObjectMap<String> opcodeMap = new Int2ObjectOpenHashMap();

    /*  JADX ERROR: Dependency scan failed at insn: 0x000A: INVOKE_CUSTOM r1
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
    /*  JADX ERROR: Failed to decode insn: 0x000A: INVOKE_CUSTOM r2, method: emu.grasscutter.net.packet.PacketOpcodesUtils.dumpPacketIds():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ./PacketIds_.json]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ./PacketIds_.json]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static void dumpPacketIds() {
        /*
            java.io.FileWriter r0 = new java.io.FileWriter
            r1 = r0
            java.lang.String[] r2 = emu.grasscutter.GameConstants.VERSION
            java.lang.String r2 = emu.grasscutter.utils.Utils.GetLast(r2)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ./PacketIds_.json]}
            r1.<init>(r2)
            r6 = r0
            it.unimi.dsi.fastutil.ints.Int2ObjectMap<java.lang.String> r0 = emu.grasscutter.net.packet.PacketOpcodesUtils.opcodeMap
            it.unimi.dsi.fastutil.objects.ObjectSet r0 = r0.int2ObjectEntrySet()
            java.util.stream.Stream r0 = r0.stream()
            void r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$dumpPacketIds$0(v0);
            }
            java.util.stream.Stream r0 = r0.filter(r1)
            void r1 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.getIntKey();
            }
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.getValue();
            }
            void r3 = (v0, v1) -> { // java.util.function.BinaryOperator.apply(java.lang.Object, java.lang.Object):java.lang.Object
                return lambda$dumpPacketIds$1(v0, v1);
            }
            void r4 = java.util.TreeMap::new
            java.util.stream.Collector r1 = java.util.stream.Collectors.toMap(r1, r2, r3, r4)
            java.lang.Object r0 = r0.collect(r1)
            java.util.Map r0 = (java.util.Map) r0
            r7 = r0
            r0 = r6
            r1 = r7
            java.lang.String r1 = emu.grasscutter.utils.JsonUtils.encode(r1)
            r0.write(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Dumped packet ids."
            r0.info(r1)
            r0 = r6
            r0.close()
            goto L_0x0071
            r7 = move-exception
            r0 = r6
            r0.close()
            goto L_0x006f
            r8 = move-exception
            r0 = r7
            r1 = r8
            r0.addSuppressed(r1)
            r0 = r7
            throw r0
            goto L_0x007e
            r6 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Error: dumpPacketIds"
            r2 = r6
            r0.error(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.packet.PacketOpcodesUtils.dumpPacketIds():void");
    }

    static {
        Field[] fields = PacketOpcodes.class.getFields();
        for (Field f : fields) {
            if (f.getType().equals(Integer.TYPE)) {
                try {
                    opcodeMap.put(f.getInt(null), (int) f.getName());
                } catch (Exception e) {
                    Grasscutter.getLogger().error("Error: opcodeMap", (Throwable) e);
                }
            }
        }
    }

    public static String getOpcodeName(int opcode) {
        return opcode <= 0 ? "UNKNOWN" : opcodeMap.getOrDefault(opcode, (int) "UNKNOWN");
    }
}
