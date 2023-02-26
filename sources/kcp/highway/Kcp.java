package kcp.highway;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kcp.highway.erasure.fec.Snmp;
import kcp.highway.internal.ReItrLinkedList;
import kcp.highway.internal.ReusableListIterator;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.util.Recycler;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: grasscutter.jar:kcp/highway/Kcp.class */
public class Kcp implements IKcp {
    private static final InternalLogger log;
    public static final int IKCP_RTO_NDL = 30;
    public static final int IKCP_RTO_MIN = 100;
    public static final int IKCP_RTO_DEF = 200;
    public static final int IKCP_RTO_MAX = 60000;
    public static final byte IKCP_CMD_PUSH = 81;
    public static final byte IKCP_CMD_ACK = 82;
    public static final byte IKCP_CMD_WASK = 83;
    public static final byte IKCP_CMD_WINS = 84;
    public static final int IKCP_ASK_SEND = 1;
    public static final int IKCP_ASK_TELL = 2;
    public static final int IKCP_WND_SND = 256;
    public static final int IKCP_WND_RCV = 256;
    public static final int IKCP_MTU_DEF = 1400;
    public static final int IKCP_INTERVAL = 100;
    public static final int IKCP_DEADLINK = 20;
    public static final int IKCP_THRESH_INIT = 2;
    public static final int IKCP_THRESH_MIN = 2;
    public static final int IKCP_PROBE_INIT = 7000;
    public static final int IKCP_PROBE_LIMIT = 120000;
    public static final int IKCP_SN_OFFSET = 16;
    private long conv;
    private int state;
    private long sndUna;
    private long sndNxt;
    private long rcvNxt;
    private long tsLastack;
    private int rxRttval;
    private int rxSrtt;
    private int cwnd;
    private int probe;
    private boolean nodelay;
    private boolean updated;
    private long tsProbe;
    private int probeWait;
    private int incr;
    private boolean ackNoDelay;
    private int ackcount;
    private Object user;
    private int fastresend;
    private boolean nocwnd;
    private boolean stream;
    private int reserved;
    private KcpOutput output;
    private long ackMask;
    private long lastRcvNxt;
    static final /* synthetic */ boolean $assertionsDisabled;
    public int IKCP_OVERHEAD = 28;
    private int ackMaskSize = 0;
    private int mtu = IKCP_MTU_DEF;
    private int mss = this.mtu - this.IKCP_OVERHEAD;
    private int ssthresh = 2;
    private int rxRto = 200;
    private int rxMinrto = 100;
    private int sndWnd = 256;
    private int rcvWnd = 256;
    private int rmtWnd = 256;
    private int interval = 100;
    private long tsFlush = 100;
    private int deadLink = 20;
    private LinkedList<Segment> sndQueue = new LinkedList<>();
    private ReItrLinkedList<Segment> sndBuf = new ReItrLinkedList<>();
    private ReItrLinkedList<Segment> rcvQueue = new ReItrLinkedList<>();
    private ReItrLinkedList<Segment> rcvBuf = new ReItrLinkedList<>();
    private ReusableListIterator<Segment> rcvQueueItr = this.rcvQueue.listIterator();
    public ReusableListIterator<Segment> sndBufItr = this.sndBuf.listIterator();
    private ReusableListIterator<Segment> rcvBufItr = this.rcvBuf.listIterator();
    private long[] acklist = new long[8];
    private ByteBufAllocator byteBufAllocator = ByteBufAllocator.DEFAULT;
    private long startTicks = System.currentTimeMillis();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0004: INVOKE_CUSTOM r-1, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0004: INVOKE_CUSTOM r0, r0, method: kcp.highway.Kcp.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, Kcp(conv=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, Kcp(conv=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r3 = this;
            r0 = r3
            long r0 = r0.conv
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, Kcp(conv=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.Kcp.toString():java.lang.String");
    }

    static {
        $assertionsDisabled = !Kcp.class.desiredAssertionStatus();
        log = InternalLoggerFactory.getInstance(Kcp.class);
    }

    private static long long2Uint(long n) {
        return n & 4294967295L;
    }

    private static int ibound(int lower, int middle, int upper) {
        return Math.min(Math.max(lower, middle), upper);
    }

    private static int itimediff(long later, long earlier) {
        return (int) (later - earlier);
    }

    private static void output(ByteBuf data, Kcp kcp2) {
        if (log.isDebugEnabled()) {
            log.debug("{} [RO] {} bytes", kcp2, Integer.valueOf(data.readableBytes()));
        }
        if (data.readableBytes() != 0) {
            kcp2.output.out(data, kcp2);
        }
    }

    private static int encodeSeg(ByteBuf buf, Segment seg) {
        int offset = buf.writerIndex();
        buf.writeLong(seg.conv);
        buf.writeByte(seg.cmd);
        buf.writeByte(seg.frg);
        buf.writeShortLE(seg.wnd);
        buf.writeIntLE((int) seg.f3046ts);
        buf.writeIntLE((int) seg.f3047sn);
        buf.writeIntLE((int) seg.una);
        buf.writeIntLE(seg.data == null ? 0 : seg.data.readableBytes());
        switch (seg.ackMaskSize) {
            case 8:
                buf.writeByte((int) seg.ackMask);
                break;
            case 16:
                buf.writeShortLE((int) seg.ackMask);
                break;
            case 32:
                buf.writeIntLE((int) seg.ackMask);
                break;
            case 64:
                buf.writeLongLE(seg.ackMask);
                break;
        }
        Snmp.snmp.OutSegs.increment();
        return buf.writerIndex() - offset;
    }

    public Kcp(long conv, KcpOutput output) {
        this.conv = conv;
        this.output = output;
    }

    @Override // kcp.highway.IKcp
    public void release() {
        release(this.sndBuf);
        release(this.rcvBuf);
        release(this.sndQueue);
        release(this.rcvQueue);
    }

    private void release(List<Segment> segQueue) {
        for (Segment seg : segQueue) {
            seg.recycle(true);
        }
    }

    private ByteBuf createFlushByteBuf() {
        return this.byteBufAllocator.ioBuffer(this.mtu);
    }

    @Override // kcp.highway.IKcp
    public ByteBuf mergeRecv() {
        int peekSize;
        if (this.rcvQueue.isEmpty() || (peekSize = peekSize()) < 0) {
            return null;
        }
        boolean recover = false;
        if (this.rcvQueue.size() >= this.rcvWnd) {
            recover = true;
        }
        ByteBuf byteBuf = null;
        int len = 0;
        Iterator<Segment> itr = this.rcvQueueItr.rewind();
        while (true) {
            if (!itr.hasNext()) {
                break;
            }
            Segment seg = itr.next();
            len += seg.data.readableBytes();
            int fragment = seg.frg;
            itr.remove();
            if (log.isDebugEnabled()) {
                log.debug("{} recv sn={}", this, Long.valueOf(seg.f3047sn));
            }
            if (byteBuf == null) {
                if (fragment == 0) {
                    byteBuf = seg.data;
                    seg.recycle(false);
                    break;
                }
                byteBuf = this.byteBufAllocator.ioBuffer(len);
            }
            byteBuf.writeBytes(seg.data);
            seg.recycle(true);
            if (fragment == 0) {
                break;
            }
        }
        if ($assertionsDisabled || len == peekSize) {
            moveRcvData();
            if (this.rcvQueue.size() < this.rcvWnd && recover) {
                this.probe |= 2;
            }
            return byteBuf;
        }
        throw new AssertionError();
    }

    @Override // kcp.highway.IKcp
    public int recv(List<ByteBuf> bufList) {
        if (this.rcvQueue.isEmpty()) {
            return -1;
        }
        int peekSize = peekSize();
        if (peekSize < 0) {
            return -2;
        }
        boolean recover = false;
        if (this.rcvQueue.size() >= this.rcvWnd) {
            recover = true;
        }
        int len = 0;
        Iterator<Segment> itr = this.rcvQueueItr.rewind();
        while (itr.hasNext()) {
            Segment seg = itr.next();
            len += seg.data.readableBytes();
            bufList.add(seg.data);
            int fragment = seg.frg;
            if (log.isDebugEnabled()) {
                log.debug("{} recv sn={}", this, Long.valueOf(seg.f3047sn));
            }
            itr.remove();
            seg.recycle(false);
            if (fragment == 0) {
                break;
            }
        }
        if ($assertionsDisabled || len == peekSize) {
            moveRcvData();
            if (this.rcvQueue.size() < this.rcvWnd && recover) {
                this.probe |= 2;
            }
            return len;
        }
        throw new AssertionError();
    }

    @Override // kcp.highway.IKcp
    public int peekSize() {
        if (this.rcvQueue.isEmpty()) {
            return -1;
        }
        Segment seg = this.rcvQueue.peek();
        if (seg.frg == 0) {
            return seg.data.readableBytes();
        }
        if (this.rcvQueue.size() < seg.frg + 1) {
            return -1;
        }
        int len = 0;
        Iterator<Segment> itr = this.rcvQueueItr.rewind();
        while (itr.hasNext()) {
            Segment s = itr.next();
            len += s.data.readableBytes();
            if (s.frg == 0) {
                break;
            }
        }
        return len;
    }

    @Override // kcp.highway.IKcp
    public boolean canRecv() {
        if (this.rcvQueue.isEmpty()) {
            return false;
        }
        Segment seg = this.rcvQueue.peek();
        if (seg.frg != 0 && this.rcvQueue.size() < seg.frg + 1) {
            return false;
        }
        return true;
    }

    @Override // kcp.highway.IKcp
    public int send(ByteBuf buf) {
        int count;
        if ($assertionsDisabled || this.mss > 0) {
            int len = buf.readableBytes();
            if (len == 0) {
                return -1;
            }
            if (this.stream && !this.sndQueue.isEmpty()) {
                Segment last = this.sndQueue.peekLast();
                ByteBuf lastData = last.data;
                int lastLen = lastData.readableBytes();
                if (lastLen < this.mss) {
                    int capacity = this.mss - lastLen;
                    int extend = len < capacity ? len : capacity;
                    if (lastData.maxWritableBytes() < extend) {
                        ByteBuf newBuf = this.byteBufAllocator.ioBuffer(lastLen + extend);
                        newBuf.writeBytes(lastData);
                        lastData.release();
                        last.data = newBuf;
                        lastData = newBuf;
                    }
                    lastData.writeBytes(buf, extend);
                    len = buf.readableBytes();
                    if (len == 0) {
                        return 0;
                    }
                }
            }
            if (len <= this.mss) {
                count = 1;
            } else {
                count = ((len + this.mss) - 1) / this.mss;
            }
            if (count > 255) {
                return -2;
            }
            if (count == 0) {
                count = 1;
            }
            for (int i = 0; i < count; i++) {
                Segment seg = Segment.createSegment(buf.readRetainedSlice(len > this.mss ? this.mss : len));
                seg.frg = (short) (this.stream ? 0 : (count - i) - 1);
                this.sndQueue.add(seg);
                len = buf.readableBytes();
            }
            return 0;
        }
        throw new AssertionError();
    }

    private void updateAck(int rtt) {
        if (this.rxSrtt == 0) {
            this.rxSrtt = rtt;
            this.rxRttval = rtt >> 2;
        } else {
            int delta = rtt - this.rxSrtt;
            this.rxSrtt += delta >> 3;
            int delta2 = Math.abs(delta);
            if (rtt < this.rxSrtt - this.rxRttval) {
                this.rxRttval += (delta2 - this.rxRttval) >> 5;
            } else {
                this.rxRttval += (delta2 - this.rxRttval) >> 2;
            }
        }
        this.rxRto = ibound(this.rxMinrto, this.rxSrtt + Math.max(this.interval, this.rxRttval << 2), IKCP_RTO_MAX);
    }

    private void shrinkBuf() {
        if (this.sndBuf.size() > 0) {
            this.sndUna = this.sndBuf.peek().f3047sn;
        } else {
            this.sndUna = this.sndNxt;
        }
    }

    private void parseAck(long sn) {
        if (itimediff(sn, this.sndUna) >= 0 && itimediff(sn, this.sndNxt) < 0) {
            Iterator<Segment> itr = this.sndBufItr.rewind();
            while (itr.hasNext()) {
                Segment seg = itr.next();
                if (sn == seg.f3047sn) {
                    itr.remove();
                    seg.recycle(true);
                    return;
                } else if (itimediff(sn, seg.f3047sn) < 0) {
                    return;
                }
            }
        }
    }

    private int parseUna(long una) {
        int count = 0;
        Iterator<Segment> itr = this.sndBufItr.rewind();
        while (itr.hasNext()) {
            Segment seg = itr.next();
            if (itimediff(una, seg.f3047sn) <= 0) {
                break;
            }
            count++;
            itr.remove();
            seg.recycle(true);
        }
        return count;
    }

    private void parseAckMask(long una, long ackMask) {
        if (ackMask != 0) {
            Iterator<Segment> itr = this.sndBufItr.rewind();
            while (itr.hasNext()) {
                Segment seg = itr.next();
                long index = (seg.f3047sn - una) - 1;
                if (index >= 0) {
                    if (index < ((long) this.ackMaskSize)) {
                        if ((ackMask & ((long) (1 << ((int) index)))) != 0) {
                            itr.remove();
                            seg.recycle(true);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void parseFastack(long sn, long ts) {
        if (itimediff(sn, this.sndUna) >= 0 && itimediff(sn, this.sndNxt) < 0) {
            Iterator<Segment> itr = this.sndBufItr.rewind();
            while (itr.hasNext()) {
                Segment seg = itr.next();
                if (itimediff(sn, seg.f3047sn) >= 0) {
                    if (sn != seg.f3047sn && itimediff(seg.f3046ts, ts) <= 0) {
                        seg.fastack++;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void ackPush(long sn, long ts) {
        if (2 * (this.ackcount + 1) > this.acklist.length) {
            int newCapacity = this.acklist.length << 1;
            if (newCapacity < 0) {
                throw new OutOfMemoryError();
            }
            long[] newArray = new long[newCapacity];
            System.arraycopy(this.acklist, 0, newArray, 0, this.acklist.length);
            this.acklist = newArray;
        }
        this.acklist[2 * this.ackcount] = sn;
        this.acklist[(2 * this.ackcount) + 1] = ts;
        this.ackcount++;
    }

    private boolean parseData(Segment newSeg) {
        long sn = newSeg.f3047sn;
        if (itimediff(sn, this.rcvNxt + ((long) this.rcvWnd)) >= 0 || itimediff(sn, this.rcvNxt) < 0) {
            newSeg.recycle(true);
            return true;
        }
        boolean repeat = false;
        boolean findPos = false;
        ListIterator<Segment> listItr = null;
        if (this.rcvBuf.size() > 0) {
            listItr = this.rcvBufItr.rewind(this.rcvBuf.size());
            while (true) {
                if (!listItr.hasPrevious()) {
                    break;
                }
                Segment seg = listItr.previous();
                if (seg.f3047sn != sn) {
                    if (itimediff(sn, seg.f3047sn) > 0) {
                        findPos = true;
                        break;
                    }
                } else {
                    repeat = true;
                    break;
                }
            }
        }
        if (repeat) {
            newSeg.recycle(true);
        } else if (listItr == null) {
            this.rcvBuf.add(newSeg);
        } else {
            if (findPos) {
                listItr.next();
            }
            listItr.add(newSeg);
        }
        moveRcvData();
        return repeat;
    }

    private void moveRcvData() {
        Iterator<Segment> itr = this.rcvBufItr.rewind();
        while (itr.hasNext()) {
            Segment seg = itr.next();
            if (seg.f3047sn == this.rcvNxt && this.rcvQueue.size() < this.rcvWnd) {
                itr.remove();
                this.rcvQueue.add(seg);
                this.rcvNxt++;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: kcp.highway.Kcp */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v72, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kcp.highway.IKcp
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int input(p013io.netty.buffer.ByteBuf r9, boolean r10, long r11) {
        /*
        // Method dump skipped, instructions count: 990
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.Kcp.input(io.netty.buffer.ByteBuf, boolean, long):int");
    }

    private int wndUnused() {
        if (this.rcvQueue.size() < this.rcvWnd) {
            return this.rcvWnd - this.rcvQueue.size();
        }
        return 0;
    }

    private ByteBuf makeSpace(ByteBuf buffer, int space) {
        if (buffer == null) {
            buffer = createFlushByteBuf();
            buffer.writerIndex(this.reserved);
        } else if (buffer.readableBytes() + space > this.mtu) {
            output(buffer, this);
            buffer = createFlushByteBuf();
            buffer.writerIndex(this.reserved);
        }
        return buffer;
    }

    private void flushBuffer(ByteBuf buffer) {
        if (buffer != null) {
            if (buffer.readableBytes() > this.reserved) {
                output(buffer, this);
            } else {
                buffer.release();
            }
        }
    }

    @Override // kcp.highway.IKcp
    public long currentMs(long now) {
        return now - this.startTicks;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:152:0x0322 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:153:0x0322 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v0, types: [long] */
    /* JADX WARN: Type inference failed for: r25v1, types: [long] */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r0v129, types: [long] */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // kcp.highway.IKcp
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long flush(boolean r11, long r12) {
        /*
        // Method dump skipped, instructions count: 1617
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.Kcp.flush(boolean, long):long");
    }

    @Override // kcp.highway.IKcp
    public void update(long current) {
        if (!this.updated) {
            this.updated = true;
            this.tsFlush = current;
        }
        int slap = itimediff(current, this.tsFlush);
        if (slap >= 10000 || slap < -10000) {
            this.tsFlush = current;
            slap = 0;
        }
        if (slap >= 0) {
            this.tsFlush += (long) this.interval;
            if (itimediff(current, this.tsFlush) >= 0) {
                this.tsFlush = current + ((long) this.interval);
            }
        } else {
            this.tsFlush = current + ((long) this.interval);
        }
        flush(false, current);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    @Override // kcp.highway.IKcp
    public long check(long current) {
        if (!this.updated) {
            return current;
        }
        char c = this.tsFlush;
        int slap = itimediff(current, c);
        if (slap >= 10000 || slap < -10000) {
            c = current;
            slap = 0;
        }
        if (slap >= 0) {
            return current;
        }
        int tmFlush = itimediff(c, current);
        int tmPacket = Integer.MAX_VALUE;
        Iterator<Segment> itr = this.sndBufItr.rewind();
        while (itr.hasNext()) {
            int diff = itimediff(itr.next().resendts, current);
            if (diff <= 0) {
                return current;
            }
            if (diff < tmPacket) {
                tmPacket = diff;
            }
        }
        int minimal = tmPacket < tmFlush ? tmPacket : tmFlush;
        if (minimal >= this.interval) {
            minimal = this.interval;
        }
        return current + ((long) minimal);
    }

    @Override // kcp.highway.IKcp
    public boolean checkFlush() {
        if (this.ackcount <= 0 && this.probe == 0 && this.sndBuf.size() <= 0 && this.sndQueue.size() <= 0) {
            return false;
        }
        return true;
    }

    @Override // kcp.highway.IKcp
    public int setMtu(int mtu) {
        if (mtu < this.IKCP_OVERHEAD || mtu < 50 || this.reserved >= mtu - this.IKCP_OVERHEAD || this.reserved < 0) {
            return -1;
        }
        this.mtu = mtu;
        this.mss = (mtu - this.IKCP_OVERHEAD) - this.reserved;
        return 0;
    }

    @Override // kcp.highway.IKcp
    public int getInterval() {
        return this.interval;
    }

    @Override // kcp.highway.IKcp
    public int nodelay(boolean nodelay, int interval, int resend, boolean nc) {
        this.nodelay = nodelay;
        if (nodelay) {
            this.rxMinrto = 30;
        } else {
            this.rxMinrto = 100;
        }
        if (interval >= 0) {
            if (interval > 5000) {
                interval = 5000;
            } else if (interval < 10) {
                interval = 10;
            }
            this.interval = interval;
        }
        if (resend >= 0) {
            this.fastresend = resend;
        }
        this.nocwnd = nc;
        return 0;
    }

    @Override // kcp.highway.IKcp
    public int waitSnd() {
        return this.sndBuf.size() + this.sndQueue.size();
    }

    @Override // kcp.highway.IKcp
    public long getConv() {
        return this.conv;
    }

    @Override // kcp.highway.IKcp
    public void setConv(long conv) {
        this.conv = conv;
    }

    @Override // kcp.highway.IKcp
    public Object getUser() {
        return this.user;
    }

    @Override // kcp.highway.IKcp
    public void setUser(Object user) {
        this.user = user;
    }

    @Override // kcp.highway.IKcp
    public int getState() {
        return this.state;
    }

    @Override // kcp.highway.IKcp
    public void setState(int state) {
        this.state = state;
    }

    @Override // kcp.highway.IKcp
    public boolean isNodelay() {
        return this.nodelay;
    }

    @Override // kcp.highway.IKcp
    public void setNodelay(boolean nodelay) {
        this.nodelay = nodelay;
        if (nodelay) {
            this.rxMinrto = 30;
        } else {
            this.rxMinrto = 100;
        }
    }

    @Override // kcp.highway.IKcp
    public void setFastresend(int fastresend) {
        this.fastresend = fastresend;
    }

    @Override // kcp.highway.IKcp
    public void setRxMinrto(int rxMinrto) {
        this.rxMinrto = rxMinrto;
    }

    @Override // kcp.highway.IKcp
    public void setRcvWnd(int rcvWnd) {
        this.rcvWnd = rcvWnd;
    }

    @Override // kcp.highway.IKcp
    public void setAckMaskSize(int ackMaskSize) {
        this.ackMaskSize = ackMaskSize;
        this.IKCP_OVERHEAD += ackMaskSize / 8;
        this.mss = (this.mtu - this.IKCP_OVERHEAD) - this.reserved;
    }

    @Override // kcp.highway.IKcp
    public void setReserved(int reserved) {
        this.reserved = reserved;
        this.mss = (this.mtu - this.IKCP_OVERHEAD) - reserved;
    }

    @Override // kcp.highway.IKcp
    public int getSndWnd() {
        return this.sndWnd;
    }

    @Override // kcp.highway.IKcp
    public void setSndWnd(int sndWnd) {
        this.sndWnd = sndWnd;
    }

    @Override // kcp.highway.IKcp
    public boolean isStream() {
        return this.stream;
    }

    @Override // kcp.highway.IKcp
    public void setStream(boolean stream) {
        this.stream = stream;
    }

    @Override // kcp.highway.IKcp
    public void setByteBufAllocator(ByteBufAllocator byteBufAllocator) {
        this.byteBufAllocator = byteBufAllocator;
    }

    @Override // kcp.highway.IKcp
    public KcpOutput getOutput() {
        return this.output;
    }

    @Override // kcp.highway.IKcp
    public void setOutput(KcpOutput output) {
        this.output = output;
    }

    @Override // kcp.highway.IKcp
    public void setAckNoDelay(boolean ackNoDelay) {
        this.ackNoDelay = ackNoDelay;
    }

    @Override // kcp.highway.IKcp
    public int getSrtt() {
        return this.rxSrtt;
    }

    /* loaded from: grasscutter.jar:kcp/highway/Kcp$Segment.class */
    public static class Segment {
        private final Recycler.Handle<Segment> recyclerHandle;
        private long conv;
        private byte cmd;
        private short frg;
        private int wnd;

        /* renamed from: ts */
        private long f3046ts;

        /* renamed from: sn */
        private long f3047sn;
        private long una;
        private long resendts;
        private int rto;
        private int fastack;
        private int xmit;
        private long ackMask;
        private ByteBuf data;
        private int ackMaskSize;
        private static final Recycler<Segment> RECYCLER = new Recycler<Segment>() { // from class: kcp.highway.Kcp.Segment.1
            /* access modifiers changed from: protected */
            @Override // p013io.netty.util.Recycler
            public Segment newObject(Recycler.Handle<Segment> handle) {
                return new Segment(handle);
            }
        };

        private Segment(Recycler.Handle<Segment> recyclerHandle) {
            this.recyclerHandle = recyclerHandle;
        }

        void recycle(boolean releaseBuf) {
            this.conv = 0;
            this.cmd = 0;
            this.frg = 0;
            this.wnd = 0;
            this.f3046ts = 0;
            this.f3047sn = 0;
            this.una = 0;
            this.resendts = 0;
            this.rto = 0;
            this.fastack = 0;
            this.xmit = 0;
            this.ackMask = 0;
            if (releaseBuf && this.data != null) {
                this.data.release();
            }
            this.data = null;
            this.recyclerHandle.recycle(this);
        }

        static Segment createSegment(ByteBufAllocator byteBufAllocator, int size) {
            Segment seg = RECYCLER.get();
            if (size == 0) {
                seg.data = null;
            } else {
                seg.data = byteBufAllocator.ioBuffer(size);
            }
            return seg;
        }

        public static Segment createSegment(ByteBuf buf) {
            Segment seg = RECYCLER.get();
            seg.data = buf;
            return seg;
        }

        public long getResendts() {
            return this.resendts;
        }

        public void setResendts(long resendts) {
            this.resendts = resendts;
        }

        public int getXmit() {
            return this.xmit;
        }

        public void setXmit(int xmit) {
            this.xmit = xmit;
        }
    }
}
