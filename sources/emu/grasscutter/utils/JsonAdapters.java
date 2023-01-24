package emu.grasscutter.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import emu.grasscutter.data.common.DynamicFloat;
import p014it.unimi.dsi.fastutil.ints.IntList;

/* loaded from: grasscutter.jar:emu/grasscutter/utils/JsonAdapters.class */
public class JsonAdapters {

    /* access modifiers changed from: package-private */
    /* renamed from: emu.grasscutter.utils.JsonAdapters$1 */
    /* loaded from: grasscutter.jar:emu/grasscutter/utils/JsonAdapters$1.class */
    public static /* synthetic */ class C27091 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = new int[JsonToken.values().length];

        static {
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/utils/JsonAdapters$DynamicFloatAdapter.class */
    static class DynamicFloatAdapter extends TypeAdapter<DynamicFloat> {
        /*  JADX ERROR: Dependency scan failed at insn: 0x00A4: INVOKE_CUSTOM r-3
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
        /*  JADX ERROR: Dependency scan failed at insn: 0x00CE: INVOKE_CUSTOM r-7
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
        /*  JADX ERROR: Failed to decode insn: 0x00A4: INVOKE_CUSTOM r3, method: emu.grasscutter.utils.JsonAdapters.DynamicFloatAdapter.read(com.google.gson.stream.JsonReader):emu.grasscutter.data.common.DynamicFloat
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Invalid DynamicFloat definition - ]}
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
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Invalid DynamicFloat definition - ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        /*  JADX ERROR: Failed to decode insn: 0x00CE: INVOKE_CUSTOM r2, method: emu.grasscutter.utils.JsonAdapters.DynamicFloatAdapter.read(com.google.gson.stream.JsonReader):emu.grasscutter.data.common.DynamicFloat
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Invalid DynamicFloat definition - ]}
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
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Invalid DynamicFloat definition - ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        @Override // com.google.gson.TypeAdapter
        public emu.grasscutter.data.common.DynamicFloat read(com.google.gson.stream.JsonReader r7) throws java.io.IOException {
            /*
                r6 = this;
                int[] r0 = emu.grasscutter.utils.JsonAdapters.C27091.$SwitchMap$com$google$gson$stream$JsonToken
                r1 = r7
                com.google.gson.stream.JsonToken r1 = r1.peek()
                int r1 = r1.ordinal()
                r0 = r0[r1]
                switch(r0) {
                    case 1: goto L_0x0028;
                    case 2: goto L_0x0034;
                    case 3: goto L_0x0041;
                    case 4: goto L_0x00c1;
                    default: goto L_0x00c3;
                }
                emu.grasscutter.data.common.DynamicFloat r0 = new emu.grasscutter.data.common.DynamicFloat
                r1 = r0
                r2 = r7
                java.lang.String r2 = r2.nextString()
                r1.<init>(r2)
                return r0
                emu.grasscutter.data.common.DynamicFloat r0 = new emu.grasscutter.data.common.DynamicFloat
                r1 = r0
                r2 = r7
                double r2 = r2.nextDouble()
                float r2 = (float) r2
                r1.<init>(r2)
                return r0
                r0 = r7
                r0.beginArray()
                java.util.ArrayList r0 = new java.util.ArrayList
                r1 = r0
                r1.<init>()
                r8 = r0
                r0 = r7
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L_0x00b4
                r0 = r8
                int[] r1 = emu.grasscutter.utils.JsonAdapters.C27091.$SwitchMap$com$google$gson$stream$JsonToken
                r2 = r7
                com.google.gson.stream.JsonToken r2 = r2.peek()
                int r2 = r2.ordinal()
                r1 = r1[r2]
                switch(r1) {
                    case 1: goto L_0x007c;
                    case 2: goto L_0x008a;
                    default: goto L_0x0099;
                }
                emu.grasscutter.data.common.DynamicFloat$StackOp r1 = new emu.grasscutter.data.common.DynamicFloat$StackOp
                r2 = r1
                r3 = r7
                java.lang.String r3 = r3.nextString()
                r2.<init>(r3)
                goto L_0x00ad
                emu.grasscutter.data.common.DynamicFloat$StackOp r1 = new emu.grasscutter.data.common.DynamicFloat$StackOp
                r2 = r1
                r3 = r7
                double r3 = r3.nextDouble()
                float r3 = (float) r3
                r2.<init>(r3)
                goto L_0x00ad
                java.io.IOException r1 = new java.io.IOException
                r2 = r1
                r3 = r7
                com.google.gson.stream.JsonToken r3 = r3.peek()
                java.lang.String r3 = r3.name()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Invalid DynamicFloat definition - ]}
                r2.<init>(r3)
                throw r1
                boolean r0 = r0.add(r1)
                goto L_0x004d
                r0 = r7
                r0.endArray()
                emu.grasscutter.data.common.DynamicFloat r0 = new emu.grasscutter.data.common.DynamicFloat
                r1 = r0
                r2 = r8
                r1.<init>(r2)
                return r0
                r0 = 0
                return r0
                java.io.IOException r0 = new java.io.IOException
                r1 = r0
                r2 = r7
                com.google.gson.stream.JsonToken r2 = r2.peek()
                java.lang.String r2 = r2.name()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Invalid DynamicFloat definition - ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.JsonAdapters.DynamicFloatAdapter.read(com.google.gson.stream.JsonReader):emu.grasscutter.data.common.DynamicFloat");
        }

        public void write(JsonWriter writer, DynamicFloat f) {
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/utils/JsonAdapters$IntListAdapter.class */
    static class IntListAdapter extends TypeAdapter<IntList> {
        /*  JADX ERROR: Dependency scan failed at insn: 0x0050: INVOKE_CUSTOM r-3
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
        /*  JADX ERROR: Failed to decode insn: 0x0050: INVOKE_CUSTOM r2, method: emu.grasscutter.utils.JsonAdapters.IntListAdapter.read(com.google.gson.stream.JsonReader):it.unimi.dsi.fastutil.ints.IntList
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Invalid IntList definition - ]}
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
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Invalid IntList definition - ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        @Override // com.google.gson.TypeAdapter
        public p014it.unimi.dsi.fastutil.ints.IntList read(com.google.gson.stream.JsonReader r5) throws java.io.IOException {
            /*
                r4 = this;
                int[] r0 = emu.grasscutter.utils.JsonAdapters.C27091.$SwitchMap$com$google$gson$stream$JsonToken
                r1 = r5
                com.google.gson.stream.JsonToken r1 = r1.peek()
                int r1 = r1.ordinal()
                r0 = r0[r1]
                switch(r0) {
                    case 3: goto L_0x001c;
                    default: goto L_0x0045;
                }
                r0 = r5
                r0.beginArray()
                it.unimi.dsi.fastutil.ints.IntArrayList r0 = new it.unimi.dsi.fastutil.ints.IntArrayList
                r1 = r0
                r1.<init>()
                r6 = r0
                r0 = r5
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L_0x003b
                r0 = r6
                r1 = r5
                int r1 = r1.nextInt()
                boolean r0 = r0.add(r1)
                goto L_0x0028
                r0 = r5
                r0.endArray()
                r0 = r6
                r0.trim()
                r0 = r6
                return r0
                java.io.IOException r0 = new java.io.IOException
                r1 = r0
                r2 = r5
                com.google.gson.stream.JsonToken r2 = r2.peek()
                java.lang.String r2 = r2.name()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Invalid IntList definition - ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.JsonAdapters.IntListAdapter.read(com.google.gson.stream.JsonReader):it.unimi.dsi.fastutil.ints.IntList");
        }

        public void write(JsonWriter writer, IntList i) {
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/utils/JsonAdapters$EnumTypeAdapterFactory.class */
    static class EnumTypeAdapterFactory implements TypeAdapterFactory {
        /* JADX DEBUG: Multi-variable search result rejected for r0v26, resolved type: java.lang.Object[] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00ab A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00ad  */
        @Override // com.google.gson.TypeAdapterFactory
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson r6, com.google.gson.reflect.TypeToken<T> r7) {
            /*
            // Method dump skipped, instructions count: 285
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.JsonAdapters.EnumTypeAdapterFactory.create(com.google.gson.Gson, com.google.gson.reflect.TypeToken):com.google.gson.TypeAdapter");
        }
    }
}
