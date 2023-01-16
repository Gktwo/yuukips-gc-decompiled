package p013io.netty.channel;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufHolder;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.DefaultMessageSizeEstimator */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultMessageSizeEstimator.class */
public final class DefaultMessageSizeEstimator implements MessageSizeEstimator {
    public static final MessageSizeEstimator DEFAULT = new DefaultMessageSizeEstimator(8);
    private final MessageSizeEstimator.Handle handle;

    /* renamed from: io.netty.channel.DefaultMessageSizeEstimator$HandleImpl */
    /* loaded from: grasscutter.jar:io/netty/channel/DefaultMessageSizeEstimator$HandleImpl.class */
    private static final class HandleImpl implements MessageSizeEstimator.Handle {
        private final int unknownSize;

        private HandleImpl(int unknownSize) {
            this.unknownSize = unknownSize;
        }

        @Override // p013io.netty.channel.MessageSizeEstimator.Handle
        public int size(Object msg) {
            if (msg instanceof ByteBuf) {
                return ((ByteBuf) msg).readableBytes();
            }
            if (msg instanceof ByteBufHolder) {
                return ((ByteBufHolder) msg).content().readableBytes();
            }
            if (msg instanceof FileRegion) {
                return 0;
            }
            return this.unknownSize;
        }
    }

    public DefaultMessageSizeEstimator(int unknownSize) {
        ObjectUtil.checkPositiveOrZero(unknownSize, "unknownSize");
        this.handle = new HandleImpl(unknownSize);
    }

    @Override // p013io.netty.channel.MessageSizeEstimator
    public MessageSizeEstimator.Handle newHandle() {
        return this.handle;
    }
}
