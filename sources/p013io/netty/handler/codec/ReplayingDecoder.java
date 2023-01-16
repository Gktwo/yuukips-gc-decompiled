package p013io.netty.handler.codec;

import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.Signal;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.handler.codec.ReplayingDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/ReplayingDecoder.class */
public abstract class ReplayingDecoder<S> extends ByteToMessageDecoder {
    static final Signal REPLAY = Signal.valueOf(ReplayingDecoder.class, "REPLAY");
    private final ReplayingDecoderByteBuf replayable;
    private S state;
    private int checkpoint;

    /* access modifiers changed from: protected */
    public ReplayingDecoder() {
        this(null);
    }

    protected ReplayingDecoder(S initialState) {
        this.replayable = new ReplayingDecoderByteBuf();
        this.checkpoint = -1;
        this.state = initialState;
    }

    protected void checkpoint() {
        this.checkpoint = internalBuffer().readerIndex();
    }

    protected void checkpoint(S state) {
        checkpoint();
        state(state);
    }

    protected S state() {
        return this.state;
    }

    protected S state(S newState) {
        S oldState = this.state;
        this.state = newState;
        return oldState;
    }

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    final void channelInputClosed(ChannelHandlerContext ctx, List<Object> out) throws Exception {
        try {
            this.replayable.terminate();
            if (this.cumulation != null) {
                callDecode(ctx, internalBuffer(), out);
            } else {
                this.replayable.setCumulation(Unpooled.EMPTY_BUFFER);
            }
            decodeLast(ctx, this.replayable, out);
        } catch (Signal replay) {
            replay.expect(REPLAY);
        }
    }

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    protected void callDecode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        this.replayable.setCumulation(in);
        while (in.isReadable()) {
            try {
                int oldReaderIndex = in.readerIndex();
                this.checkpoint = oldReaderIndex;
                int outSize = out.size();
                if (outSize > 0) {
                    fireChannelRead(ctx, out, outSize);
                    out.clear();
                    if (ctx.isRemoved()) {
                        break;
                    }
                    outSize = 0;
                }
                S oldState = this.state;
                int oldInputLength = in.readableBytes();
                decodeRemovalReentryProtection(ctx, this.replayable, out);
                if (ctx.isRemoved()) {
                    break;
                }
                try {
                    if (outSize == out.size()) {
                        if (oldInputLength == in.readableBytes() && oldState == this.state) {
                            throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() must consume the inbound data or change its state if it did not decode anything.");
                        }
                    } else if (oldReaderIndex == in.readerIndex() && oldState == this.state) {
                        throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() method must consume the inbound data or change its state if it decoded something.");
                    } else if (isSingleDecode()) {
                        break;
                    }
                } catch (Signal replay) {
                    replay.expect(REPLAY);
                    if (!ctx.isRemoved()) {
                        int checkpoint = this.checkpoint;
                        if (checkpoint >= 0) {
                            in.readerIndex(checkpoint);
                        }
                    }
                }
            } catch (DecoderException e) {
                throw e;
            } catch (Exception cause) {
                throw new DecoderException(cause);
            }
        }
    }
}
