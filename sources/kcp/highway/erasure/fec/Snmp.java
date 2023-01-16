package kcp.highway.erasure.fec;

import java.util.concurrent.atomic.LongAdder;

/* loaded from: grasscutter.jar:kcp/highway/erasure/fec/Snmp.class */
public class Snmp {
    public LongAdder BytesSent = new LongAdder();
    public LongAdder BytesReceived = new LongAdder();
    public LongAdder MaxConn = new LongAdder();
    public LongAdder ActiveOpens = new LongAdder();
    public LongAdder PassiveOpens = new LongAdder();
    public LongAdder CurrEstab = new LongAdder();
    public LongAdder InErrs = new LongAdder();
    public LongAdder InCsumErrors = new LongAdder();
    public LongAdder KCPInErrors = new LongAdder();
    public LongAdder InPkts = new LongAdder();
    public LongAdder OutPkts = new LongAdder();
    public LongAdder InSegs = new LongAdder();
    public LongAdder OutSegs = new LongAdder();
    public LongAdder InBytes = new LongAdder();
    public LongAdder OutBytes = new LongAdder();
    public LongAdder RetransSegs = new LongAdder();
    public LongAdder FastRetransSegs = new LongAdder();
    public LongAdder EarlyRetransSegs = new LongAdder();
    public LongAdder LostSegs = new LongAdder();
    public LongAdder RepeatSegs = new LongAdder();
    public LongAdder FECRecovered = new LongAdder();
    public LongAdder FECErrs = new LongAdder();
    public LongAdder FECDataShards = new LongAdder();
    public LongAdder FECParityShards = new LongAdder();
    public LongAdder FECShortShards = new LongAdder();
    public LongAdder FECRepeatDataShards = new LongAdder();
    public static volatile Snmp snmp = new Snmp();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0068: INVOKE_CUSTOM r-26, r-25, r-24, r-23, r-22, r-21, r-20, r-19, r-18, r-17, r-16, r-15, r-14, r-13, r-12, r-11, r-10, r-9, r-8, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0068: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, method: kcp.highway.erasure.fec.Snmp.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;)Ljava/lang/String;}, Snmp{BytesSent=, BytesReceived=, MaxConn=, ActiveOpens=, PassiveOpens=, CurrEstab=, InErrs=, InCsumErrors=, KCPInErrors=, ￊￕﾵﾽﾰ￼=, ﾷﾢￋￍﾰ￼=, InSegs=, OutSegs=, ￊￕﾵﾽￗￖﾽￚ=, ﾷﾢￋￍￗￖﾽￚ=, ￗￜﾹﾲￖ￘ﾷﾢￊ�=, ﾿￬ￋ￙ￖ￘ﾷﾢￊ�=, ﾿ￕￏ￐﾿￬ￋ￙ￖ￘ﾷﾢￊ�=, ﾳﾬￊﾱￖ￘ﾷﾢￊ�=, ￊￕﾵﾽￖ￘ﾸﾴﾰ￼ￊ�￁﾿=, fecﾻￖﾸﾴￊ�=, fecﾻￖﾸﾴﾴ￭ￎ￳ￊ�=, ￊￕﾵﾽfecDataￊ�=, ￊￕﾵﾽfecParityￊ�=, fecﾻﾺﾴ￦￈￟ￓ￠ￌￔￌﾭdataﾰ￼ￊ�=, fecￊￕﾵﾽￖ￘ﾸﾴﾵￄￊ�ﾾ￝ﾰ￼=}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;)Ljava/lang/String;}, Snmp{BytesSent=, BytesReceived=, MaxConn=, ActiveOpens=, PassiveOpens=, CurrEstab=, InErrs=, InCsumErrors=, KCPInErrors=, ￊￕﾵﾽﾰ￼=, ﾷﾢￋￍﾰ￼=, InSegs=, OutSegs=, ￊￕﾵﾽￗￖﾽￚ=, ﾷﾢￋￍￗￖﾽￚ=, ￗￜﾹﾲￖ￘ﾷﾢￊ�=, ﾿￬ￋ￙ￖ￘ﾷﾢￊ�=, ﾿ￕￏ￐﾿￬ￋ￙ￖ￘ﾷﾢￊ�=, ﾳﾬￊﾱￖ￘ﾷﾢￊ�=, ￊￕﾵﾽￖ￘ﾸﾴﾰ￼ￊ�￁﾿=, fecﾻￖﾸﾴￊ�=, fecﾻￖﾸﾴﾴ￭ￎ￳ￊ�=, ￊￕﾵﾽfecDataￊ�=, ￊￕﾵﾽfecParityￊ�=, fecﾻﾺﾴ￦￈￟ￓ￠ￌￔￌﾭdataﾰ￼ￊ�=, fecￊￕﾵﾽￖ￘ﾸﾴﾵￄￊ�ﾾ￝ﾰ￼=}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r27 = this;
            r0 = r27
            java.util.concurrent.atomic.LongAdder r0 = r0.BytesSent
            r1 = r27
            java.util.concurrent.atomic.LongAdder r1 = r1.BytesReceived
            r2 = r27
            java.util.concurrent.atomic.LongAdder r2 = r2.MaxConn
            r3 = r27
            java.util.concurrent.atomic.LongAdder r3 = r3.ActiveOpens
            r4 = r27
            java.util.concurrent.atomic.LongAdder r4 = r4.PassiveOpens
            r5 = r27
            java.util.concurrent.atomic.LongAdder r5 = r5.CurrEstab
            r6 = r27
            java.util.concurrent.atomic.LongAdder r6 = r6.InErrs
            r7 = r27
            java.util.concurrent.atomic.LongAdder r7 = r7.InCsumErrors
            r8 = r27
            java.util.concurrent.atomic.LongAdder r8 = r8.KCPInErrors
            r9 = r27
            java.util.concurrent.atomic.LongAdder r9 = r9.InPkts
            r10 = r27
            java.util.concurrent.atomic.LongAdder r10 = r10.OutPkts
            r11 = r27
            java.util.concurrent.atomic.LongAdder r11 = r11.InSegs
            r12 = r27
            java.util.concurrent.atomic.LongAdder r12 = r12.OutSegs
            r13 = r27
            java.util.concurrent.atomic.LongAdder r13 = r13.InBytes
            r14 = r27
            java.util.concurrent.atomic.LongAdder r14 = r14.OutBytes
            r15 = r27
            java.util.concurrent.atomic.LongAdder r15 = r15.RetransSegs
            r16 = r27
            java.util.concurrent.atomic.LongAdder r16 = r16.FastRetransSegs
            r17 = r27
            java.util.concurrent.atomic.LongAdder r17 = r17.EarlyRetransSegs
            r18 = r27
            java.util.concurrent.atomic.LongAdder r18 = r18.LostSegs
            r19 = r27
            java.util.concurrent.atomic.LongAdder r19 = r19.RepeatSegs
            r20 = r27
            java.util.concurrent.atomic.LongAdder r20 = r20.FECRecovered
            r21 = r27
            java.util.concurrent.atomic.LongAdder r21 = r21.FECErrs
            r22 = r27
            java.util.concurrent.atomic.LongAdder r22 = r22.FECDataShards
            r23 = r27
            java.util.concurrent.atomic.LongAdder r23 = r23.FECParityShards
            r24 = r27
            java.util.concurrent.atomic.LongAdder r24 = r24.FECShortShards
            r25 = r27
            java.util.concurrent.atomic.LongAdder r25 = r25.FECRepeatDataShards
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;, Ljava/util/concurrent/atomic/LongAdder;)Ljava/lang/String;}, Snmp{BytesSent=, BytesReceived=, MaxConn=, ActiveOpens=, PassiveOpens=, CurrEstab=, InErrs=, InCsumErrors=, KCPInErrors=, 收到包=, 发送包=, InSegs=, OutSegs=, 收到字节=, 发送字节=, 总共重发数=, 快速重发数=, 空闲快速重发数=, 超时重发数=, 收到重复包数量=, fec恢复数=, fec恢复错误数=, 收到fecData数=, 收到fecParity数=, fec缓存冗余淘汰data包数=, fec收到重复的数据包=}]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.erasure.fec.Snmp.toString():java.lang.String");
    }

    public LongAdder getBytesSent() {
        return this.BytesSent;
    }

    public void setBytesSent(LongAdder bytesSent) {
        this.BytesSent = bytesSent;
    }

    public LongAdder getBytesReceived() {
        return this.BytesReceived;
    }

    public void setBytesReceived(LongAdder bytesReceived) {
        this.BytesReceived = bytesReceived;
    }

    public LongAdder getMaxConn() {
        return this.MaxConn;
    }

    public void setMaxConn(LongAdder maxConn) {
        this.MaxConn = maxConn;
    }

    public LongAdder getActiveOpens() {
        return this.ActiveOpens;
    }

    public void setActiveOpens(LongAdder activeOpens) {
        this.ActiveOpens = activeOpens;
    }

    public LongAdder getPassiveOpens() {
        return this.PassiveOpens;
    }

    public void setPassiveOpens(LongAdder passiveOpens) {
        this.PassiveOpens = passiveOpens;
    }

    public LongAdder getCurrEstab() {
        return this.CurrEstab;
    }

    public void setCurrEstab(LongAdder currEstab) {
        this.CurrEstab = currEstab;
    }

    public LongAdder getInErrs() {
        return this.InErrs;
    }

    public void setInErrs(LongAdder inErrs) {
        this.InErrs = inErrs;
    }

    public LongAdder getInCsumErrors() {
        return this.InCsumErrors;
    }

    public void setInCsumErrors(LongAdder inCsumErrors) {
        this.InCsumErrors = inCsumErrors;
    }

    public LongAdder getKCPInErrors() {
        return this.KCPInErrors;
    }

    public void setKCPInErrors(LongAdder KCPInErrors) {
        this.KCPInErrors = KCPInErrors;
    }

    public LongAdder getInPkts() {
        return this.InPkts;
    }

    public void setInPkts(LongAdder inPkts) {
        this.InPkts = inPkts;
    }

    public LongAdder getOutPkts() {
        return this.OutPkts;
    }

    public void setOutPkts(LongAdder outPkts) {
        this.OutPkts = outPkts;
    }

    public LongAdder getInSegs() {
        return this.InSegs;
    }

    public void setInSegs(LongAdder inSegs) {
        this.InSegs = inSegs;
    }

    public LongAdder getOutSegs() {
        return this.OutSegs;
    }

    public void setOutSegs(LongAdder outSegs) {
        this.OutSegs = outSegs;
    }

    public LongAdder getInBytes() {
        return this.InBytes;
    }

    public void setInBytes(LongAdder inBytes) {
        this.InBytes = inBytes;
    }

    public LongAdder getOutBytes() {
        return this.OutBytes;
    }

    public void setOutBytes(LongAdder outBytes) {
        this.OutBytes = outBytes;
    }

    public LongAdder getRetransSegs() {
        return this.RetransSegs;
    }

    public void setRetransSegs(LongAdder retransSegs) {
        this.RetransSegs = retransSegs;
    }

    public LongAdder getFastRetransSegs() {
        return this.FastRetransSegs;
    }

    public void setFastRetransSegs(LongAdder fastRetransSegs) {
        this.FastRetransSegs = fastRetransSegs;
    }

    public LongAdder getEarlyRetransSegs() {
        return this.EarlyRetransSegs;
    }

    public void setEarlyRetransSegs(LongAdder earlyRetransSegs) {
        this.EarlyRetransSegs = earlyRetransSegs;
    }

    public LongAdder getLostSegs() {
        return this.LostSegs;
    }

    public void setLostSegs(LongAdder lostSegs) {
        this.LostSegs = lostSegs;
    }

    public LongAdder getRepeatSegs() {
        return this.RepeatSegs;
    }

    public void setRepeatSegs(LongAdder repeatSegs) {
        this.RepeatSegs = repeatSegs;
    }

    public LongAdder getFECRecovered() {
        return this.FECRecovered;
    }

    public void setFECRecovered(LongAdder FECRecovered) {
        this.FECRecovered = FECRecovered;
    }

    public LongAdder getFECErrs() {
        return this.FECErrs;
    }

    public void setFECErrs(LongAdder FECErrs) {
        this.FECErrs = FECErrs;
    }

    public LongAdder getFECDataShards() {
        return this.FECDataShards;
    }

    public void setFECDataShards(LongAdder FECDataShards) {
        this.FECDataShards = FECDataShards;
    }

    public LongAdder getFECParityShards() {
        return this.FECParityShards;
    }

    public void setFECParityShards(LongAdder FECParityShards) {
        this.FECParityShards = FECParityShards;
    }

    public LongAdder getFECShortShards() {
        return this.FECShortShards;
    }

    public void setFECShortShards(LongAdder FECShortShards) {
        this.FECShortShards = FECShortShards;
    }

    public LongAdder getFECRepeatDataShards() {
        return this.FECRepeatDataShards;
    }

    public void setFECRepeatDataShards(LongAdder FECRepeatDataShards) {
        this.FECRepeatDataShards = FECRepeatDataShards;
    }

    public static Snmp getSnmp() {
        return snmp;
    }

    public static void setSnmp(Snmp snmp2) {
        snmp = snmp2;
    }
}
