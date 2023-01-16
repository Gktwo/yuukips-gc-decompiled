package kcp.highway.internal;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:894)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:367)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:119)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:49)
    */
/* loaded from: grasscutter.jar:kcp/highway/internal/ReItrHashMap.class */
public class ReItrHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final Entry<?, ?>[] EMPTY_TABLE = new Entry[0];
    transient Entry<K, V>[] table;
    transient int size;
    int threshold;
    final float loadFactor;
    transient int modCount;
    volatile transient Set<K> keySet;
    volatile transient Collection<V> values;
    private transient ReItrSet<Map.Entry<K, V>> entrySet;
    private static final long serialVersionUID = -6903817172093654652L;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0023: INVOKE_CUSTOM r-8
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0047: INVOKE_CUSTOM r-9
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
    /*  JADX ERROR: Failed to decode insn: 0x0023: INVOKE_CUSTOM r2, method: kcp.highway.internal.ReItrHashMap.<init>(int, float):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Illegal initial capacity: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Illegal initial capacity: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0047: INVOKE_CUSTOM r2, method: kcp.highway.internal.ReItrHashMap.<init>(int, float):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F)Ljava/lang/String;}, Illegal load factor: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F)Ljava/lang/String;}, Illegal load factor: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public ReItrHashMap(int r5, float r6) {
        /*
            r4 = this;
            r0 = r4
            r0.<init>()
            r0 = r4
            kcp.highway.internal.ReItrHashMap$Entry<?, ?>[] r1 = kcp.highway.internal.ReItrHashMap.EMPTY_TABLE
            r0.table = r1
            r0 = r4
            r1 = 0
            r0.keySet = r1
            r0 = r4
            r1 = 0
            r0.values = r1
            r0 = r4
            r1 = 0
            r0.entrySet = r1
            r0 = r5
            if (r0 >= 0) goto L_0x002c
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Illegal initial capacity: ]}
            r1.<init>(r2)
            throw r0
            r0 = r5
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 <= r1) goto L_0x0035
            r0 = 1073741824(0x40000000, float:2.0)
            r5 = r0
            r0 = r6
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0042
            r0 = r6
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x0050
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F)Ljava/lang/String;}, Illegal load factor: ]}
            r1.<init>(r2)
            throw r0
            r0 = r4
            r1 = r6
            r0.loadFactor = r1
            r0 = r4
            r1 = r5
            r0.threshold = r1
            r0 = r4
            r0.init()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.internal.ReItrHashMap.<init>(int, float):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x001F: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0042: INVOKE_CUSTOM r-3
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
    /*  JADX ERROR: Failed to decode insn: 0x001F: INVOKE_CUSTOM r2, method: kcp.highway.internal.ReItrHashMap.readObject(java.io.ObjectInputStream):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F)Ljava/lang/String;}, Illegal load factor: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F)Ljava/lang/String;}, Illegal load factor: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0042: INVOKE_CUSTOM r2, method: kcp.highway.internal.ReItrHashMap.readObject(java.io.ObjectInputStream):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Illegal mappings count: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Illegal mappings count: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private void readObject(java.io.ObjectInputStream r5) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
            r4 = this;
            r0 = r5
            r0.defaultReadObject()
            r0 = r4
            float r0 = r0.loadFactor
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0017
            r0 = r4
            float r0 = r0.loadFactor
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x0028
            java.io.InvalidObjectException r0 = new java.io.InvalidObjectException
            r1 = r0
            r2 = r4
            float r2 = r2.loadFactor
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F)Ljava/lang/String;}, Illegal load factor: ]}
            r1.<init>(r2)
            throw r0
            r0 = r4
            kcp.highway.internal.ReItrHashMap$Entry<?, ?>[] r1 = kcp.highway.internal.ReItrHashMap.EMPTY_TABLE
            r0.table = r1
            r0 = r5
            int r0 = r0.readInt()
            r0 = r5
            int r0 = r0.readInt()
            r6 = r0
            r0 = r6
            if (r0 >= 0) goto L_0x004b
            java.io.InvalidObjectException r0 = new java.io.InvalidObjectException
            r1 = r0
            r2 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Illegal mappings count: ]}
            r1.<init>(r2)
            throw r0
            r0 = r6
            float r0 = (float) r0
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = r4
            float r2 = r2.loadFactor
            float r1 = r1 / r2
            r2 = 1082130432(0x40800000, float:4.0)
            float r1 = java.lang.Math.min(r1, r2)
            float r0 = r0 * r1
            r1 = 1317011456(0x4e800000, float:1.07374182E9)
            float r0 = java.lang.Math.min(r0, r1)
            int r0 = (int) r0
            r7 = r0
            r0 = r6
            if (r0 <= 0) goto L_0x006c
            r0 = r4
            r1 = r7
            r0.inflateTable(r1)
            goto L_0x0071
            r0 = r4
            r1 = r7
            r0.threshold = r1
            r0 = r4
            r0.init()
            r0 = 0
            r8 = r0
            r0 = r8
            r1 = r6
            if (r0 >= r1) goto L_0x0098
            r0 = r5
            java.lang.Object r0 = r0.readObject()
            r9 = r0
            r0 = r5
            java.lang.Object r0 = r0.readObject()
            r10 = r0
            r0 = r4
            r1 = r9
            r2 = r10
            r0.putForCreate(r1, r2)
            int r8 = r8 + 1
            goto L_0x0078
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.internal.ReItrHashMap.readObject(java.io.ObjectInputStream):void");
    }

    public ReItrHashMap(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public ReItrHashMap() {
        this(16, 0.75f);
    }

    public ReItrHashMap(Map<? extends K, ? extends V> m) {
        this(Math.max(((int) (((float) m.size()) / 0.75f)) + 1, 16), 0.75f);
        inflateTable(this.threshold);
        putAllForCreate(m);
    }

    private static int roundUpToPowerOf2(int number) {
        if (number >= 1073741824) {
            return 1073741824;
        }
        if (number > 1) {
            return Integer.highestOneBit((number - 1) << 1);
        }
        return 1;
    }

    private void inflateTable(int toSize) {
        int capacity = roundUpToPowerOf2(toSize);
        this.threshold = (int) Math.min(((float) capacity) * this.loadFactor, 1.07374182E9f);
        this.table = new Entry[capacity];
    }

    void init() {
    }

    final int hash(Object k) {
        int h = k.hashCode();
        int h2 = h ^ ((h >>> 20) ^ (h >>> 12));
        return (h2 ^ (h2 >>> 7)) ^ (h2 >>> 4);
    }

    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        if (key == null) {
            return getForNullKey();
        }
        Entry<K, V> entry = getEntry(key);
        if (null == entry) {
            return null;
        }
        return entry.getValue();
    }

    private V getForNullKey() {
        if (this.size == 0) {
            return null;
        }
        for (Entry<K, V> e = this.table[0]; e != null; e = e.next) {
            if (e.key == null) {
                return e.value;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    final Entry<K, V> getEntry(Object key) {
        Object k;
        if (this.size == 0) {
            return null;
        }
        int hash = key == null ? 0 : hash(key);
        for (Entry<K, V> e = this.table[indexFor(hash, this.table.length)]; e != null; e = e.next) {
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                return e;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        Object k;
        if (this.table == EMPTY_TABLE) {
            inflateTable(this.threshold);
        }
        if (key == null) {
            return putForNullKey(value);
        }
        int hash = hash(key);
        int i = indexFor(hash, this.table.length);
        for (Entry<K, V> e = this.table[i]; e != null; e = e.next) {
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        this.modCount++;
        addEntry(hash, key, value, i);
        return null;
    }

    private V putForNullKey(V value) {
        for (Entry<K, V> e = this.table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        this.modCount++;
        addEntry(0, null, value, 0);
        return null;
    }

    private void putForCreate(K key, V value) {
        Object k;
        int hash = null == key ? 0 : hash(key);
        int i = indexFor(hash, this.table.length);
        for (Entry<K, V> e = this.table[i]; e != null; e = e.next) {
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                e.value = value;
                return;
            }
        }
        createEntry(hash, key, value, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kcp.highway.internal.ReItrHashMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void putAllForCreate(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            putForCreate(e.getKey(), e.getValue());
        }
    }

    void resize(int newCapacity) {
        if (this.table.length == 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        this.table = newTable;
        this.threshold = (int) Math.min(((float) newCapacity) * this.loadFactor, 1.07374182E9f);
    }

    void transfer(Entry[] newTable) {
        int newCapacity = newTable.length;
        Entry<K, V>[] entryArr = this.table;
        int length = entryArr.length;
        for (int i = 0; i < length; i++) {
            Entry<K, V> e = entryArr[i];
            while (null != e) {
                Entry<K, V> next = e.next;
                int i2 = indexFor(e.hash, newCapacity);
                e.next = newTable[i2];
                newTable[i2] = e;
                e = next;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kcp.highway.internal.ReItrHashMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m) {
        int numKeysToBeAdded = m.size();
        if (numKeysToBeAdded != 0) {
            if (this.table == EMPTY_TABLE) {
                inflateTable((int) Math.max(((float) numKeysToBeAdded) * this.loadFactor, (float) this.threshold));
            }
            if (numKeysToBeAdded > this.threshold) {
                int targetCapacity = (int) ((((float) numKeysToBeAdded) / this.loadFactor) + 1.0f);
                if (targetCapacity > 1073741824) {
                    targetCapacity = 1073741824;
                }
                int newCapacity = this.table.length;
                while (newCapacity < targetCapacity) {
                    newCapacity <<= 1;
                }
                if (newCapacity > this.table.length) {
                    resize(newCapacity);
                }
            }
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                put(e.getKey(), e.getValue());
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        Entry<K, V> e = removeEntryForKey(key);
        if (e == null) {
            return null;
        }
        return e.value;
    }

    final Entry<K, V> removeEntryForKey(Object key) {
        Object k;
        if (this.size == 0) {
            return null;
        }
        int hash = key == null ? 0 : hash(key);
        int i = indexFor(hash, this.table.length);
        Entry<K, V> prev = this.table[i];
        Entry<K, V> e = prev;
        while (e != null) {
            Entry<K, V> next = e.next;
            if (e.hash != hash || ((k = e.key) != key && (key == null || !key.equals(k)))) {
                prev = e;
                e = next;
            } else {
                this.modCount++;
                this.size--;
                if (prev == e) {
                    this.table[i] = next;
                } else {
                    prev.next = next;
                }
                e.recordRemoval(this);
                return e;
            }
        }
        return e;
    }

    final Entry<K, V> removeMapping(Object o) {
        if (this.size == 0 || !(o instanceof Map.Entry)) {
            return null;
        }
        Map.Entry<K, V> entry = (Map.Entry) o;
        Object key = entry.getKey();
        int hash = key == null ? 0 : hash(key);
        int i = indexFor(hash, this.table.length);
        Entry<K, V> prev = this.table[i];
        Entry<K, V> e = prev;
        while (e != null) {
            Entry<K, V> next = e.next;
            if (e.hash != hash || !e.equals(entry)) {
                prev = e;
                e = next;
            } else {
                this.modCount++;
                this.size--;
                if (prev == e) {
                    this.table[i] = next;
                } else {
                    prev.next = next;
                }
                e.recordRemoval(this);
                return e;
            }
        }
        return e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        if (value == null) {
            return containsNullValue();
        }
        Entry[] tab = this.table;
        for (int i = 0; i < tab.length; i++) {
            for (Entry e = tab[i]; e != null; e = e.next) {
                if (value.equals(e.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsNullValue() {
        Entry[] tab = this.table;
        for (int i = 0; i < tab.length; i++) {
            for (Entry e = tab[i]; e != null; e = e.next) {
                if (e.value == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.lang.Object
    public Object clone() {
        ReItrHashMap<K, V> result = null;
        try {
            result = (ReItrHashMap) clone();
        } catch (CloneNotSupportedException e) {
        }
        if (result.table != EMPTY_TABLE) {
            result.inflateTable(Math.min((int) Math.min(((float) this.size) * Math.min(1.0f / this.loadFactor, 4.0f), 1.07374182E9f), this.table.length));
        }
        result.entrySet = null;
        result.modCount = 0;
        result.size = 0;
        result.init();
        result.putAllForCreate(this);
        return result;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:kcp/highway/internal/ReItrHashMap$Entry.class */
    public static class Entry<K, V> implements Map.Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        int hash;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0008: INVOKE_CUSTOM r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r0, r1, method: kcp.highway.internal.ReItrHashMap.Entry.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Object;, Ljava/lang/Object;)Ljava/lang/String;}, =]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Object;, Ljava/lang/Object;)Ljava/lang/String;}, =]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        @Override // java.lang.Object
        public final java.lang.String toString() {
            /*
                r3 = this;
                r0 = r3
                java.lang.Object r0 = r0.getKey()
                r1 = r3
                java.lang.Object r1 = r1.getValue()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Object;, Ljava/lang/Object;)Ljava/lang/String;}, =]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kcp.highway.internal.ReItrHashMap.Entry.toString():java.lang.String");
        }

        Entry(int h, K k, V v, Entry<K, V> n) {
            this.value = v;
            this.next = n;
            this.key = k;
            this.hash = h;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V newValue) {
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public final boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry e = (Map.Entry) o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if (k1 != k2 && (k1 == null || !k1.equals(k2))) {
                return false;
            }
            Object v1 = getValue();
            Object v2 = e.getValue();
            if (v1 == v2) {
                return true;
            }
            if (v1 == null || !v1.equals(v2)) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public final int hashCode() {
            return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
        }

        void recordAccess(ReItrHashMap<K, V> m) {
        }

        void recordRemoval(ReItrHashMap<K, V> m) {
        }
    }

    void addEntry(int hash, K key, V value, int bucketIndex) {
        if (this.size >= this.threshold && null != this.table[bucketIndex]) {
            resize(2 * this.table.length);
            hash = null != key ? hash(key) : 0;
            bucketIndex = indexFor(hash, this.table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    void createEntry(int hash, K key, V value, int bucketIndex) {
        this.table[bucketIndex] = new Entry<>(hash, key, value, this.table[bucketIndex]);
        this.size++;
    }

    /* loaded from: grasscutter.jar:kcp/highway/internal/ReItrHashMap$HashIterator.class */
    private abstract class HashIterator<E> implements ReusableIterator<E> {
        Entry<K, V> next;
        int expectedModCount;
        int index;
        Entry<K, V> current;

        HashIterator() {
            this.expectedModCount = ReItrHashMap.this.modCount;
            if (ReItrHashMap.this.size > 0) {
                Entry[] t = ReItrHashMap.this.table;
                while (this.index < t.length) {
                    int i = this.index;
                    this.index = i + 1;
                    Entry entry = t[i];
                    this.next = entry;
                    if (entry != null) {
                        return;
                    }
                }
            }
        }

        void rewind0() {
            this.expectedModCount = ReItrHashMap.this.modCount;
            this.next = null;
            this.current = null;
            this.index = 0;
            if (ReItrHashMap.this.size > 0) {
                Entry[] t = ReItrHashMap.this.table;
                while (this.index < t.length) {
                    int i = this.index;
                    this.index = i + 1;
                    Entry entry = t[i];
                    this.next = entry;
                    if (entry != null) {
                        return;
                    }
                }
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != null;
        }

        final Entry<K, V> nextEntry() {
            if (ReItrHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            Entry<K, V> e = this.next;
            if (e == null) {
                throw new NoSuchElementException();
            }
            Entry<K, V> entry = e.next;
            this.next = entry;
            if (entry == null) {
                Entry[] t = ReItrHashMap.this.table;
                while (this.index < t.length) {
                    int i = this.index;
                    this.index = i + 1;
                    Entry entry2 = t[i];
                    this.next = entry2;
                    if (entry2 != null) {
                        break;
                    }
                }
            }
            this.current = e;
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current == null) {
                throw new IllegalStateException();
            } else if (ReItrHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                Object k = this.current.key;
                this.current = null;
                ReItrHashMap.this.removeEntryForKey(k);
                this.expectedModCount = ReItrHashMap.this.modCount;
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:kcp/highway/internal/ReItrHashMap$ValueIterator.class */
    public final class ValueIterator extends ReItrHashMap<K, V>.HashIterator {
        private ValueIterator() {
            super();
        }

        @Override // kcp.highway.internal.ReusableIterator
        public ReusableIterator<V> rewind() {
            rewind0();
            return this;
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().value;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:kcp/highway/internal/ReItrHashMap$KeyIterator.class */
    public final class KeyIterator extends ReItrHashMap<K, V>.HashIterator {
        private KeyIterator() {
            super();
        }

        @Override // kcp.highway.internal.ReusableIterator
        public ReusableIterator<K> rewind() {
            rewind0();
            return this;
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:kcp/highway/internal/ReItrHashMap$EntryIterator.class */
    public final class EntryIterator extends ReItrHashMap<K, V>.HashIterator {
        private EntryIterator() {
            super();
        }

        @Override // kcp.highway.internal.ReusableIterator
        public ReusableIterator<Map.Entry<K, V>> rewind() {
            rewind0();
            return this;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    Iterator<K> newKeyIterator() {
        return new KeyIterator();
    }

    Iterator<V> newValueIterator() {
        return new ValueIterator();
    }

    ReusableIterator<Map.Entry<K, V>> newEntryIterator() {
        return new EntryIterator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> ks = this.keySet;
        if (ks != null) {
            return ks;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    /* loaded from: grasscutter.jar:kcp/highway/internal/ReItrHashMap$KeySet.class */
    private final class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return ReItrHashMap.this.newKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ReItrHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return ReItrHashMap.this.containsKey(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            return ReItrHashMap.this.removeEntryForKey(o) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ReItrHashMap.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> vs = this.values;
        if (vs != null) {
            return vs;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    /* loaded from: grasscutter.jar:kcp/highway/internal/ReItrHashMap$Values.class */
    private final class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return ReItrHashMap.this.newValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ReItrHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object o) {
            return ReItrHashMap.this.containsValue(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReItrHashMap.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public ReItrSet<Map.Entry<K, V>> entrySet() {
        return entrySet0();
    }

    private ReItrSet<Map.Entry<K, V>> entrySet0() {
        ReItrSet<Map.Entry<K, V>> es = this.entrySet;
        if (es != null) {
            return es;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:kcp/highway/internal/ReItrHashMap$EntrySet.class */
    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> implements ReItrSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable, kcp.highway.internal.ReItrCollection
        public ReusableIterator<Map.Entry<K, V>> iterator() {
            return ReItrHashMap.this.newEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, V> e = (Map.Entry) o;
            Entry<K, V> candidate = ReItrHashMap.this.getEntry(e.getKey());
            return candidate != null && candidate.equals(e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            return ReItrHashMap.this.removeMapping(o) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ReItrHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ReItrHashMap.this.clear();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        if (this.table == EMPTY_TABLE) {
            s.writeInt(roundUpToPowerOf2(this.threshold));
        } else {
            s.writeInt(this.table.length);
        }
        s.writeInt(this.size);
        if (this.size > 0) {
            ReusableIterator<Map.Entry<K, V>> it = entrySet0().iterator();
            while (it.hasNext()) {
                Map.Entry<K, V> e = it.next();
                s.writeObject(e.getKey());
                s.writeObject(e.getValue());
            }
        }
    }

    int capacity() {
        return this.table.length;
    }

    float loadFactor() {
        return this.loadFactor;
    }
}
