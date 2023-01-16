package p013io.netty.handler.codec;

import java.nio.ByteOrder;
import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.LengthFieldBasedFrameDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/LengthFieldBasedFrameDecoder.class */
public class LengthFieldBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteOrder byteOrder;
    private final int maxFrameLength;
    private final int lengthFieldOffset;
    private final int lengthFieldLength;
    private final int lengthFieldEndOffset;
    private final int lengthAdjustment;
    private final int initialBytesToStrip;
    private final boolean failFast;
    private boolean discardingTooLongFrame;
    private long tooLongFrameLength;
    private long bytesToDiscard;
    private int frameLengthInt;

    public LengthFieldBasedFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        this(maxFrameLength, lengthFieldOffset, lengthFieldLength, 0, 0);
    }

    public LengthFieldBasedFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        this(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, true);
    }

    public LengthFieldBasedFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        this(ByteOrder.BIG_ENDIAN, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
    }

    public LengthFieldBasedFrameDecoder(ByteOrder byteOrder, int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        this.frameLengthInt = -1;
        this.byteOrder = (ByteOrder) ObjectUtil.checkNotNull(byteOrder, "byteOrder");
        ObjectUtil.checkPositive(maxFrameLength, "maxFrameLength");
        ObjectUtil.checkPositiveOrZero(lengthFieldOffset, "lengthFieldOffset");
        ObjectUtil.checkPositiveOrZero(initialBytesToStrip, "initialBytesToStrip");
        if (lengthFieldOffset > maxFrameLength - lengthFieldLength) {
            throw new IllegalArgumentException("maxFrameLength (" + maxFrameLength + ") must be equal to or greater than lengthFieldOffset (" + lengthFieldOffset + ") + lengthFieldLength (" + lengthFieldLength + ").");
        }
        this.maxFrameLength = maxFrameLength;
        this.lengthFieldOffset = lengthFieldOffset;
        this.lengthFieldLength = lengthFieldLength;
        this.lengthAdjustment = lengthAdjustment;
        this.lengthFieldEndOffset = lengthFieldOffset + lengthFieldLength;
        this.initialBytesToStrip = initialBytesToStrip;
        this.failFast = failFast;
    }

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    protected final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        Object decoded = decode(ctx, in);
        if (decoded != null) {
            out.add(decoded);
        }
    }

    private void discardingTooLongFrame(ByteBuf in) {
        long bytesToDiscard = this.bytesToDiscard;
        int localBytesToDiscard = (int) Math.min(bytesToDiscard, (long) in.readableBytes());
        in.skipBytes(localBytesToDiscard);
        this.bytesToDiscard = bytesToDiscard - ((long) localBytesToDiscard);
        failIfNecessary(false);
    }

    private static void failOnNegativeLengthField(ByteBuf in, long frameLength, int lengthFieldEndOffset) {
        in.skipBytes(lengthFieldEndOffset);
        throw new CorruptedFrameException("negative pre-adjustment length field: " + frameLength);
    }

    private static void failOnFrameLengthLessThanLengthFieldEndOffset(ByteBuf in, long frameLength, int lengthFieldEndOffset) {
        in.skipBytes(lengthFieldEndOffset);
        throw new CorruptedFrameException("Adjusted frame length (" + frameLength + ") is less than lengthFieldEndOffset: " + lengthFieldEndOffset);
    }

    private void exceededFrameLength(ByteBuf in, long frameLength) {
        long discard = frameLength - ((long) in.readableBytes());
        this.tooLongFrameLength = frameLength;
        if (discard < 0) {
            in.skipBytes((int) frameLength);
        } else {
            this.discardingTooLongFrame = true;
            this.bytesToDiscard = discard;
            in.skipBytes(in.readableBytes());
        }
        failIfNecessary(true);
    }

    private static void failOnFrameLengthLessThanInitialBytesToStrip(ByteBuf in, long frameLength, int initialBytesToStrip) {
        in.skipBytes((int) frameLength);
        throw new CorruptedFrameException("Adjusted frame length (" + frameLength + ") is less than initialBytesToStrip: " + initialBytesToStrip);
    }

    /* JADX WARN: Type inference failed for: r0v34, types: [long] */
    /* access modifiers changed from: protected */
    public Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        char c = 0;
        if (this.frameLengthInt == -1) {
            if (this.discardingTooLongFrame) {
                discardingTooLongFrame(in);
            }
            if (in.readableBytes() < this.lengthFieldEndOffset) {
                return null;
            }
            long frameLength = getUnadjustedFrameLength(in, in.readerIndex() + this.lengthFieldOffset, this.lengthFieldLength, this.byteOrder);
            if (frameLength < 0) {
                failOnNegativeLengthField(in, frameLength, this.lengthFieldEndOffset);
            }
            c = frameLength + ((long) (this.lengthAdjustment + this.lengthFieldEndOffset));
            if (c < ((long) this.lengthFieldEndOffset)) {
                failOnFrameLengthLessThanLengthFieldEndOffset(in, c, this.lengthFieldEndOffset);
            }
            if (c > ((long) this.maxFrameLength)) {
                exceededFrameLength(in, c);
                return null;
            }
            this.frameLengthInt = (int) c;
        }
        if (in.readableBytes() < this.frameLengthInt) {
            return null;
        }
        if (this.initialBytesToStrip > this.frameLengthInt) {
            failOnFrameLengthLessThanInitialBytesToStrip(in, c, this.initialBytesToStrip);
        }
        in.skipBytes(this.initialBytesToStrip);
        int readerIndex = in.readerIndex();
        int actualFrameLength = this.frameLengthInt - this.initialBytesToStrip;
        ByteBuf frame = extractFrame(ctx, in, readerIndex, actualFrameLength);
        in.readerIndex(readerIndex + actualFrameLength);
        this.frameLengthInt = -1;
        return frame;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected long getUnadjustedFrameLength(p013io.netty.buffer.ByteBuf r6, int r7, int r8, java.nio.ByteOrder r9) {
        /*
            r5 = this;
            r0 = r6
            r1 = r9
            io.netty.buffer.ByteBuf r0 = r0.order(r1)
            r6 = r0
            r0 = r8
            switch(r0) {
                case 1: goto L_0x0038;
                case 2: goto L_0x0043;
                case 3: goto L_0x004e;
                case 4: goto L_0x0059;
                case 5: goto L_0x006d;
                case 6: goto L_0x006d;
                case 7: goto L_0x006d;
                case 8: goto L_0x0063;
                default: goto L_0x006d;
            }
        L_0x0038:
            r0 = r6
            r1 = r7
            short r0 = r0.getUnsignedByte(r1)
            long r0 = (long) r0
            r10 = r0
            goto L_0x0090
        L_0x0043:
            r0 = r6
            r1 = r7
            int r0 = r0.getUnsignedShort(r1)
            long r0 = (long) r0
            r10 = r0
            goto L_0x0090
        L_0x004e:
            r0 = r6
            r1 = r7
            int r0 = r0.getUnsignedMedium(r1)
            long r0 = (long) r0
            r10 = r0
            goto L_0x0090
        L_0x0059:
            r0 = r6
            r1 = r7
            long r0 = r0.getUnsignedInt(r1)
            r10 = r0
            goto L_0x0090
        L_0x0063:
            r0 = r6
            r1 = r7
            long r0 = r0.getLong(r1)
            r10 = r0
            goto L_0x0090
        L_0x006d:
            io.netty.handler.codec.DecoderException r0 = new io.netty.handler.codec.DecoderException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "unsupported lengthFieldLength: "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r5
            int r3 = r3.lengthFieldLength
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " (expected: 1, 2, 3, 4, or 8)"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0090:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.LengthFieldBasedFrameDecoder.getUnadjustedFrameLength(io.netty.buffer.ByteBuf, int, int, java.nio.ByteOrder):long");
    }

    private void failIfNecessary(boolean firstDetectionOfTooLongFrame) {
        if (this.bytesToDiscard == 0) {
            long tooLongFrameLength = this.tooLongFrameLength;
            this.tooLongFrameLength = 0;
            this.discardingTooLongFrame = false;
            if (!this.failFast || firstDetectionOfTooLongFrame) {
                fail(tooLongFrameLength);
            }
        } else if (this.failFast && firstDetectionOfTooLongFrame) {
            fail(this.tooLongFrameLength);
        }
    }

    protected ByteBuf extractFrame(ChannelHandlerContext ctx, ByteBuf buffer, int index, int length) {
        return buffer.retainedSlice(index, length);
    }

    private void fail(long frameLength) {
        if (frameLength > 0) {
            throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + ": " + frameLength + " - discarded");
        }
        throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + " - discarding");
    }
}
