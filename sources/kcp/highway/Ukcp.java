package kcp.highway;

import java.io.IOException;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kcp.highway.erasure.FecAdapt;
import kcp.highway.erasure.IFecDecode;
import kcp.highway.erasure.IFecEncode;
import kcp.highway.erasure.fec.Fec;
import kcp.highway.erasure.fec.FecPacket;
import kcp.highway.erasure.fec.Snmp;
import kcp.highway.threadPool.IMessageExecutor;
import org.jctools.queues.MpscLinkedQueue;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.SelectStrategy;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: grasscutter.jar:kcp/highway/Ukcp.class */
public class Ukcp {
    private static final InternalLogger log = InternalLoggerFactory.getInstance(Ukcp.class);

    /* renamed from: kcp  reason: collision with root package name */
    private final IKcp f3387kcp;
    private IFecEncode fecEncode;
    private IFecDecode fecDecode;
    private final IMessageExecutor iMessageExecutor;
    private final KcpListener kcpListener;
    private final long timeoutMillis;
    private final IChannelManager channelManager;
    private boolean controlReadBufferSize;
    private boolean controlWriteBufferSize;
    private boolean fastFlush = true;
    private long tsUpdate = -1;
    private final AtomicBoolean writeProcessing = new AtomicBoolean(false);
    private final AtomicBoolean readProcessing = new AtomicBoolean(false);
    private final AtomicInteger readBufferIncr = new AtomicInteger(-1);
    private final AtomicInteger writeBufferIncr = new AtomicInteger(-1);
    private final WriteTask writeTask = new WriteTask(this);
    private final ReadTask readTask = new ReadTask(this);
    private long lastRecieveTime = System.currentTimeMillis();
    private boolean active = true;
    private final Queue<ByteBuf> writeBuffer = new MpscLinkedQueue();
    private final Queue<ByteBuf> readBuffer = new MpscLinkedQueue();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0016: INVOKE_CUSTOM r-3, r0, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0016: INVOKE_CUSTOM r0, r0, r1, r2, method: kcp.highway.Ukcp.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, Z)Ljava/lang/String;}, Ukcp(getConv=, state=, active=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, Z)Ljava/lang/String;}, Ukcp(getConv=, state=, active=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r5 = this;
            r0 = r5
            kcp.highway.IKcp r0 = r0.f3387kcp
            long r0 = r0.getConv()
            r1 = r5
            kcp.highway.IKcp r1 = r1.f3387kcp
            int r1 = r1.getState()
            r2 = r5
            boolean r2 = r2.active
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, Z)Ljava/lang/String;}, Ukcp(getConv=, state=, active=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.Ukcp.toString():java.lang.String");
    }

    public Ukcp(KcpOutput output, KcpListener kcpListener, IMessageExecutor iMessageExecutor, ChannelConfig channelConfig, IChannelManager channelManager) {
        this.fecEncode = null;
        this.fecDecode = null;
        this.controlReadBufferSize = false;
        this.controlWriteBufferSize = false;
        this.timeoutMillis = channelConfig.getTimeoutMillis();
        this.f3387kcp = new Kcp(channelConfig.getConv(), output);
        this.kcpListener = kcpListener;
        this.iMessageExecutor = iMessageExecutor;
        this.channelManager = channelManager;
        if (channelConfig.getReadBufferSize() != -1) {
            this.controlReadBufferSize = true;
            this.readBufferIncr.set(channelConfig.getReadBufferSize() / channelConfig.getMtu());
        }
        if (channelConfig.getWriteBufferSize() != -1) {
            this.controlWriteBufferSize = true;
            this.writeBufferIncr.set(channelConfig.getWriteBufferSize() / channelConfig.getMtu());
        }
        int headerSize = 0;
        FecAdapt fecAdapt = channelConfig.getFecAdapt();
        headerSize = channelConfig.isCrc32Check() ? 0 + 4 : headerSize;
        if (fecAdapt != null) {
            KcpOutput kcpOutput = this.f3387kcp.getOutput();
            this.fecEncode = fecAdapt.fecEncode(headerSize, channelConfig.getMtu());
            this.fecDecode = fecAdapt.fecDecode(channelConfig.getMtu());
            this.f3387kcp.setOutput(new FecOutPut(kcpOutput, this.fecEncode));
            headerSize += Fec.fecHeaderSizePlus2;
        }
        this.f3387kcp.setReserved(headerSize);
        initKcpConfig(channelConfig);
    }

    private void initKcpConfig(ChannelConfig channelConfig) {
        this.f3387kcp.nodelay(channelConfig.isNodelay(), channelConfig.getInterval(), channelConfig.getFastresend(), channelConfig.isNocwnd());
        this.f3387kcp.setSndWnd(channelConfig.getSndwnd());
        this.f3387kcp.setRcvWnd(channelConfig.getRcvwnd());
        this.f3387kcp.setMtu(channelConfig.getMtu());
        this.f3387kcp.setStream(channelConfig.isStream());
        this.f3387kcp.setAckNoDelay(channelConfig.isAckNoDelay());
        this.f3387kcp.setAckMaskSize(channelConfig.getAckMaskSize());
        this.fastFlush = channelConfig.isFastFlush();
    }

    /* access modifiers changed from: protected */
    public void receive(List<ByteBuf> bufList) {
        this.f3387kcp.recv(bufList);
    }

    /* access modifiers changed from: protected */
    public ByteBuf mergeReceive() {
        return this.f3387kcp.mergeRecv();
    }

    /* access modifiers changed from: protected */
    public void input(ByteBuf data, long current) throws IOException {
        List<ByteBuf> byteBufs;
        Snmp.snmp.InPkts.increment();
        Snmp.snmp.InBytes.add((long) data.readableBytes());
        if (this.fecDecode != null) {
            FecPacket fecPacket = FecPacket.newFecPacket(data);
            if (fecPacket.getFlag() == Fec.typeData) {
                data.skipBytes(2);
                input(data, true, current);
            }
            if ((fecPacket.getFlag() == Fec.typeData || fecPacket.getFlag() == Fec.typeParity) && (byteBufs = this.fecDecode.decode(fecPacket)) != null) {
                for (int i = 0; i < byteBufs.size(); i++) {
                    ByteBuf byteBuf = byteBufs.get(i);
                    input(byteBuf, false, current);
                    byteBuf.release();
                }
                return;
            }
            return;
        }
        input(data, true, current);
    }

    private void input(ByteBuf data, boolean regular, long current) throws IOException {
        switch (this.f3387kcp.input(data, regular, current)) {
            case -4:
                throw new IOException("Conv inconsistency");
            case SelectStrategy.BUSY_WAIT:
                throw new IOException("Mismatch cmd");
            case -2:
                throw new IOException("No enough bytes of data");
            case -1:
                throw new IOException("No enough bytes of head");
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public void send(ByteBuf buf) throws IOException {
        if (this.f3387kcp.send(buf) == -2) {
            throw new IOException("Too many fragments");
        }
    }

    /* access modifiers changed from: protected */
    public boolean canRecv() {
        return this.f3387kcp.canRecv();
    }

    /* access modifiers changed from: protected */
    public long getLastRecieveTime() {
        return this.lastRecieveTime;
    }

    /* access modifiers changed from: protected */
    public void setLastRecieveTime(long lastRecieveTime) {
        this.lastRecieveTime = lastRecieveTime;
    }

    /* access modifiers changed from: protected */
    public boolean canSend(boolean curCanSend) {
        int max = this.f3387kcp.getSndWnd() * 2;
        int waitSnd = this.f3387kcp.waitSnd();
        return curCanSend ? waitSnd < max : waitSnd < Math.max(1, max / 2);
    }

    protected long update(long current) {
        this.f3387kcp.update(current);
        long nextTsUp = check(current);
        setTsUpdate(nextTsUp);
        return nextTsUp;
    }

    /* access modifiers changed from: protected */
    public long flush(long current) {
        return this.f3387kcp.flush(false, current);
    }

    protected long check(long current) {
        return this.f3387kcp.check(current);
    }

    /* access modifiers changed from: protected */
    public boolean checkFlush() {
        return this.f3387kcp.checkFlush();
    }

    public long getConv() {
        return this.f3387kcp.getConv();
    }

    public void setConv(long conv) {
        this.f3387kcp.setConv(conv);
    }

    /* access modifiers changed from: protected */
    public int getInterval() {
        return this.f3387kcp.getInterval();
    }

    /* access modifiers changed from: protected */
    public boolean isStream() {
        return this.f3387kcp.isStream();
    }

    public Ukcp setByteBufAllocator(ByteBufAllocator allocator) {
        this.f3387kcp.setByteBufAllocator(allocator);
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean isFastFlush() {
        return this.fastFlush;
    }

    /* access modifiers changed from: protected */
    public void read(ByteBuf byteBuf) {
        if (!this.controlReadBufferSize || this.readBufferIncr.getAndUpdate(operand -> {
            if (operand == 0) {
                return operand;
            }
            return operand - 1;
        }) != 0) {
            this.readBuffer.offer(byteBuf);
            notifyReadEvent();
            return;
        }
        ByteBuf pack = this.readBuffer.poll();
        if (pack != null) {
            pack.release();
        }
    }

    public boolean write(ByteBuf byteBuf) {
        if (this.controlWriteBufferSize && this.writeBufferIncr.getAndUpdate(operand -> {
            if (operand == 0) {
                return operand;
            }
            return operand - 1;
        }) == 0) {
            return false;
        }
        this.writeBuffer.offer(byteBuf.retainedDuplicate());
        notifyWriteEvent();
        return true;
    }

    /* access modifiers changed from: protected */
    public AtomicInteger getReadBufferIncr() {
        return this.readBufferIncr;
    }

    public void close() {
        this.iMessageExecutor.execute(() -> {
            internalClose();
        });
    }

    private void notifyReadEvent() {
        if (this.readProcessing.compareAndSet(false, true)) {
            this.iMessageExecutor.execute(this.readTask);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyWriteEvent() {
        if (this.writeProcessing.compareAndSet(false, true)) {
            this.iMessageExecutor.execute(this.writeTask);
        }
    }

    /* access modifiers changed from: protected */
    public long getTsUpdate() {
        return this.tsUpdate;
    }

    /* access modifiers changed from: protected */
    public Queue<ByteBuf> getReadBuffer() {
        return this.readBuffer;
    }

    /* access modifiers changed from: protected */
    public Ukcp setTsUpdate(long tsUpdate) {
        this.tsUpdate = tsUpdate;
        return this;
    }

    /* access modifiers changed from: protected */
    public Queue<ByteBuf> getWriteBuffer() {
        return this.writeBuffer;
    }

    /* access modifiers changed from: protected */
    public KcpListener getKcpListener() {
        return this.kcpListener;
    }

    public boolean isActive() {
        return this.active;
    }

    /* access modifiers changed from: package-private */
    public void internalClose() {
        if (this.active) {
            this.active = false;
            notifyReadEvent();
            this.kcpListener.handleClose(this);
            notifyWriteEvent();
            this.f3387kcp.flush(false, System.currentTimeMillis());
            this.channelManager.del(this);
            release();
        }
    }

    void release() {
        this.f3387kcp.setState(-1);
        this.f3387kcp.release();
        while (true) {
            ByteBuf byteBuf = this.writeBuffer.poll();
            if (byteBuf == null) {
                break;
            }
            byteBuf.release();
        }
        while (true) {
            ByteBuf byteBuf2 = this.readBuffer.poll();
            if (byteBuf2 == null) {
                break;
            }
            byteBuf2.release();
        }
        if (this.fecEncode != null) {
            this.fecEncode.release();
        }
        if (this.fecDecode != null) {
            this.fecDecode.release();
        }
    }

    /* access modifiers changed from: protected */
    public AtomicBoolean getWriteProcessing() {
        return this.writeProcessing;
    }

    /* access modifiers changed from: protected */
    public AtomicBoolean getReadProcessing() {
        return this.readProcessing;
    }

    /* access modifiers changed from: protected */
    public IMessageExecutor getiMessageExecutor() {
        return this.iMessageExecutor;
    }

    /* access modifiers changed from: protected */
    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    /* access modifiers changed from: protected */
    public AtomicInteger getWriteBufferIncr() {
        return this.writeBufferIncr;
    }

    /* access modifiers changed from: protected */
    public boolean isControlReadBufferSize() {
        return this.controlReadBufferSize;
    }

    /* access modifiers changed from: protected */
    public boolean isControlWriteBufferSize() {
        return this.controlWriteBufferSize;
    }

    public User user() {
        return (User) this.f3387kcp.getUser();
    }

    public int srtt() {
        return this.f3387kcp.getSrtt();
    }

    /* access modifiers changed from: protected */
    public Ukcp user(User user) {
        this.f3387kcp.setUser(user);
        return this;
    }
}
