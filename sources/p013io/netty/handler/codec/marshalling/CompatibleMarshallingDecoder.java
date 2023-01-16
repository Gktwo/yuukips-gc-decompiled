package p013io.netty.handler.codec.marshalling;

import java.util.List;
import org.jboss.marshalling.ByteInput;
import org.jboss.marshalling.Unmarshaller;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.ReplayingDecoder;
import p013io.netty.handler.codec.TooLongFrameException;
import p013io.netty.handler.codec.marshalling.LimitingByteInput;

/* renamed from: io.netty.handler.codec.marshalling.CompatibleMarshallingDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/CompatibleMarshallingDecoder.class */
public class CompatibleMarshallingDecoder extends ReplayingDecoder<Void> {
    protected final UnmarshallerProvider provider;
    protected final int maxObjectSize;
    private boolean discardingTooLongFrame;

    public CompatibleMarshallingDecoder(UnmarshallerProvider provider, int maxObjectSize) {
        this.provider = provider;
        this.maxObjectSize = maxObjectSize;
    }

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {
        if (this.discardingTooLongFrame) {
            buffer.skipBytes(actualReadableBytes());
            checkpoint();
            return;
        }
        Unmarshaller unmarshaller = this.provider.getUnmarshaller(ctx);
        ByteInput input = new ChannelBufferByteInput(buffer);
        if (this.maxObjectSize != Integer.MAX_VALUE) {
            input = new LimitingByteInput(input, (long) this.maxObjectSize);
        }
        try {
            try {
                unmarshaller.start(input);
                Object obj = unmarshaller.readObject();
                unmarshaller.finish();
                out.add(obj);
                unmarshaller.close();
            } catch (LimitingByteInput.TooBigObjectException e) {
                this.discardingTooLongFrame = true;
                throw new TooLongFrameException();
            }
        } catch (Throwable th) {
            unmarshaller.close();
            throw th;
        }
    }

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    protected void decodeLast(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {
        switch (buffer.readableBytes()) {
            case 0:
                return;
            case 1:
                if (buffer.getByte(buffer.readerIndex()) == 121) {
                    buffer.skipBytes(1);
                    return;
                }
                break;
        }
        decode(ctx, buffer, out);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (cause instanceof TooLongFrameException) {
            ctx.close();
        } else {
            exceptionCaught(ctx, cause);
        }
    }
}
