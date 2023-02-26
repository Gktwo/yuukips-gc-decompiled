package kcp.highway.erasure.fecNative;

import java.util.Iterator;
import java.util.Random;
import kcp.highway.erasure.IFecDecode;
import kcp.highway.erasure.fec.FecException;
import kcp.highway.erasure.fec.FecPacket;
import kcp.highway.erasure.fec.MyArrayList;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;

/* loaded from: grasscutter.jar:kcp/highway/erasure/fecNative/FecDecode.class */
public class FecDecode implements IFecDecode {
    private int rxlimit;
    private int dataShards;
    private int parityShards;
    private int shardSize;

    /* renamed from: rx */
    private MyArrayList<FecPacket> f3049rx;
    private ByteBuf[] decodeCache;
    private boolean[] flagCache;
    private ByteBuf zeros;
    private ReedSolomonNative codec;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0298: INVOKE_CUSTOM r-20, r-19
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x02D1: INVOKE_CUSTOM r-23
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
    /*  JADX ERROR: Failed to decode insn: 0x0298: INVOKE_CUSTOM r1, r2, method: kcp.highway.erasure.fecNative.FecDecode.decode(kcp.highway.erasure.fec.FecPacket):java.util.List<io.netty.buffer.ByteBuf>
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, bytebufﾳﾤﾶ￈:  ﾶ￁ﾳ￶ﾳﾤﾶ￈]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, bytebufﾳﾤﾶ￈:  ﾶ￁ﾳ￶ﾳﾤﾶ￈]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x02D1: INVOKE_CUSTOM r1, method: kcp.highway.erasure.fecNative.FecDecode.decode(kcp.highway.erasure.fec.FecPacket):java.util.List<io.netty.buffer.ByteBuf>
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (B)Ljava/lang/String;}, [] ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (B)Ljava/lang/String;}, [] ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // kcp.highway.erasure.IFecDecode
    public java.util.List<p013io.netty.buffer.ByteBuf> decode(kcp.highway.erasure.fec.FecPacket r8) {
        /*
        // Method dump skipped, instructions count: 847
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.erasure.fecNative.FecDecode.decode(kcp.highway.erasure.fec.FecPacket):java.util.List");
    }

    public FecDecode(int rxlimit, ReedSolomonNative codec, int mtu) {
        this.rxlimit = rxlimit;
        this.dataShards = codec.getDataShards();
        this.parityShards = codec.getParityShards();
        this.shardSize = this.dataShards + this.parityShards;
        if (this.dataShards <= 0 || this.parityShards <= 0) {
            throw new FecException("dataShards and parityShards can not less than 0");
        } else if (rxlimit < this.dataShards + this.parityShards) {
            throw new FecException("");
        } else {
            this.codec = codec;
            this.decodeCache = new ByteBuf[this.shardSize];
            this.flagCache = new boolean[this.shardSize];
            this.f3049rx = new MyArrayList<>(rxlimit);
            this.zeros = ByteBufAllocator.DEFAULT.buffer(mtu);
            this.zeros.writeBytes(new byte[mtu]);
        }
    }

    @Override // kcp.highway.erasure.IFecDecode
    public void release() {
        this.rxlimit = 0;
        this.dataShards = 0;
        this.parityShards = 0;
        this.shardSize = 0;
        Iterator<FecPacket> it = this.f3049rx.iterator();
        while (it.hasNext()) {
            FecPacket fecPacket = it.next();
            if (fecPacket != null) {
                fecPacket.release();
            }
        }
        this.zeros.release();
        this.codec = null;
    }

    private static void freeRange(int first, int n, MyArrayList<FecPacket> q) {
        int toIndex = first + n;
        for (int i = first; i < toIndex; i++) {
            q.get(i).release();
        }
        q.removeRange(first, toIndex);
    }

    public static void main(String[] args) {
        while (true) {
            int size = new Random().nextInt(99) + 1;
            int first = new Random().nextInt(100);
            if (size > first) {
                int n = new Random().nextInt(size - first);
                MyArrayList<Integer> q = build(size);
                remove(first, n, q);
                MyArrayList<Integer> newQ = build(size);
                newQ.removeRange(first, first + n);
                if (newQ.size() != q.size()) {
                    System.out.println();
                }
                for (int i = 0; i < newQ.size(); i++) {
                    if (newQ.get(i) != q.get(i)) {
                        System.out.println();
                    }
                }
            }
        }
    }

    public static MyArrayList<Integer> build(int size) {
        MyArrayList<Integer> q = new MyArrayList<>(size);
        for (int i = 0; i < size; i++) {
            q.add(Integer.valueOf(i));
        }
        return q;
    }

    private static void remove(int first, int n, MyArrayList<Integer> q) {
        int index;
        int i = first;
        while (i < q.size() && (index = i + n) != q.size()) {
            q.set(i, q.get(index));
            i++;
        }
        for (int i2 = 0; i2 < n; i2++) {
            q.remove(q.size() - 1);
        }
    }
}
