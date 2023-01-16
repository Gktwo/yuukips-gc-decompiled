package p013io.netty.channel;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.CompositeByteBuf;
import p013io.netty.buffer.Unpooled;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.CoalescingBufferQueue */
/* loaded from: grasscutter.jar:io/netty/channel/CoalescingBufferQueue.class */
public final class CoalescingBufferQueue extends AbstractCoalescingBufferQueue {
    private final Channel channel;

    public CoalescingBufferQueue(Channel channel) {
        this(channel, 4);
    }

    public CoalescingBufferQueue(Channel channel, int initSize) {
        this(channel, initSize, false);
    }

    public CoalescingBufferQueue(Channel channel, int initSize, boolean updateWritability) {
        super(updateWritability ? channel : null, initSize);
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
    }

    public ByteBuf remove(int bytes, ChannelPromise aggregatePromise) {
        return remove(this.channel.alloc(), bytes, aggregatePromise);
    }

    public void releaseAndFailAll(Throwable cause) {
        releaseAndFailAll(this.channel, cause);
    }

    @Override // p013io.netty.channel.AbstractCoalescingBufferQueue
    protected ByteBuf compose(ByteBufAllocator alloc, ByteBuf cumulation, ByteBuf next) {
        if (!(cumulation instanceof CompositeByteBuf)) {
            return composeIntoComposite(alloc, cumulation, next);
        }
        CompositeByteBuf composite = (CompositeByteBuf) cumulation;
        composite.addComponent(true, next);
        return composite;
    }

    @Override // p013io.netty.channel.AbstractCoalescingBufferQueue
    protected ByteBuf removeEmptyValue() {
        return Unpooled.EMPTY_BUFFER;
    }
}
