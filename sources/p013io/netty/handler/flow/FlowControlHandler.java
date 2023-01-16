package p013io.netty.handler.flow;

import java.util.ArrayDeque;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelDuplexHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.internal.ObjectPool;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.flow.FlowControlHandler */
/* loaded from: grasscutter.jar:io/netty/handler/flow/FlowControlHandler.class */
public class FlowControlHandler extends ChannelDuplexHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(FlowControlHandler.class);
    private final boolean releaseMessages;
    private RecyclableArrayDeque queue;
    private ChannelConfig config;
    private boolean shouldConsume;

    public FlowControlHandler() {
        this(true);
    }

    public FlowControlHandler(boolean releaseMessages) {
        this.releaseMessages = releaseMessages;
    }

    boolean isQueueEmpty() {
        return this.queue == null || this.queue.isEmpty();
    }

    private void destroy() {
        if (this.queue != null) {
            if (!this.queue.isEmpty()) {
                logger.trace("Non-empty queue: {}", this.queue);
                if (this.releaseMessages) {
                    while (true) {
                        Object msg = this.queue.poll();
                        if (msg == null) {
                            break;
                        }
                        ReferenceCountUtil.safeRelease(msg);
                    }
                }
            }
            this.queue.recycle();
            this.queue = null;
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.config = ctx.channel().config();
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        handlerRemoved(ctx);
        if (!isQueueEmpty()) {
            dequeue(ctx, this.queue.size());
        }
        destroy();
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        destroy();
        ctx.fireChannelInactive();
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext ctx) throws Exception {
        if (dequeue(ctx, 1) == 0) {
            this.shouldConsume = true;
            ctx.read();
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (this.queue == null) {
            this.queue = RecyclableArrayDeque.newInstance();
        }
        this.queue.offer(msg);
        int minConsume = this.shouldConsume ? 1 : 0;
        this.shouldConsume = false;
        dequeue(ctx, minConsume);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        if (isQueueEmpty()) {
            ctx.fireChannelReadComplete();
        }
    }

    private int dequeue(ChannelHandlerContext ctx, int minConsume) {
        Object msg;
        int consumed = 0;
        while (this.queue != null && ((consumed < minConsume || this.config.isAutoRead()) && (msg = this.queue.poll()) != null)) {
            consumed++;
            ctx.fireChannelRead(msg);
        }
        if (this.queue != null && this.queue.isEmpty()) {
            this.queue.recycle();
            this.queue = null;
            if (consumed > 0) {
                ctx.fireChannelReadComplete();
            }
        }
        return consumed;
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.flow.FlowControlHandler$RecyclableArrayDeque */
    /* loaded from: grasscutter.jar:io/netty/handler/flow/FlowControlHandler$RecyclableArrayDeque.class */
    public static final class RecyclableArrayDeque extends ArrayDeque<Object> {
        private static final long serialVersionUID = 0;
        private static final int DEFAULT_NUM_ELEMENTS = 2;
        private static final ObjectPool<RecyclableArrayDeque> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<RecyclableArrayDeque>() { // from class: io.netty.handler.flow.FlowControlHandler.RecyclableArrayDeque.1
            @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
            public RecyclableArrayDeque newObject(ObjectPool.Handle<RecyclableArrayDeque> handle) {
                return new RecyclableArrayDeque(2, handle);
            }
        });
        private final ObjectPool.Handle<RecyclableArrayDeque> handle;

        public static RecyclableArrayDeque newInstance() {
            return RECYCLER.get();
        }

        private RecyclableArrayDeque(int numElements, ObjectPool.Handle<RecyclableArrayDeque> handle) {
            super(numElements);
            this.handle = handle;
        }

        public void recycle() {
            clear();
            this.handle.recycle(this);
        }
    }
}
