package kcp.highway.erasure.fec;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.util.Recycler;

/* loaded from: grasscutter.jar:kcp/highway/erasure/fec/FecPacket.class */
public class FecPacket {
    private long seqid;
    private int flag;
    private ByteBuf data;
    private Recycler.Handle<FecPacket> recyclerHandle;
    private static final Recycler<FecPacket> FEC_PACKET_RECYCLER = new Recycler<FecPacket>() { // from class: kcp.highway.erasure.fec.FecPacket.1
        /* access modifiers changed from: protected */
        @Override // p013io.netty.util.Recycler
        public FecPacket newObject(Recycler.Handle<FecPacket> handle) {
            return new FecPacket(handle);
        }
    };

    /*  JADX ERROR: Dependency scan failed at insn: 0x0008: INVOKE_CUSTOM r-2, r0, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r0, r0, r1, method: kcp.highway.erasure.fec.FecPacket.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I)Ljava/lang/String;}, FecPacket{seqid=, flag=}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I)Ljava/lang/String;}, FecPacket{seqid=, flag=}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r4 = this;
            r0 = r4
            long r0 = r0.seqid
            r1 = r4
            int r1 = r1.flag
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I)Ljava/lang/String;}, FecPacket{seqid=, flag=}]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.erasure.fec.FecPacket.toString():java.lang.String");
    }

    public static FecPacket newFecPacket(ByteBuf byteBuf) {
        FecPacket pkt = FEC_PACKET_RECYCLER.get();
        pkt.seqid = byteBuf.readUnsignedIntLE();
        pkt.flag = byteBuf.readUnsignedShortLE();
        pkt.data = byteBuf.retainedSlice(byteBuf.readerIndex(), byteBuf.capacity() - byteBuf.readerIndex());
        pkt.data.writerIndex(byteBuf.readableBytes());
        return pkt;
    }

    private FecPacket(Recycler.Handle<FecPacket> recyclerHandle) {
        this.recyclerHandle = recyclerHandle;
    }

    public void release() {
        this.seqid = 0;
        this.flag = 0;
        this.data.release();
        this.data = null;
        this.recyclerHandle.recycle(this);
    }

    public long getSeqid() {
        return this.seqid;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public ByteBuf getData() {
        return this.data;
    }

    public void setData(ByteBuf data) {
        this.data = data;
    }
}
