package p013io.netty.handler.timeout;

import java.util.concurrent.TimeUnit;
import p013io.netty.channel.ChannelHandlerContext;

/* renamed from: io.netty.handler.timeout.ReadTimeoutHandler */
/* loaded from: grasscutter.jar:io/netty/handler/timeout/ReadTimeoutHandler.class */
public class ReadTimeoutHandler extends IdleStateHandler {
    private boolean closed;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ReadTimeoutHandler.class.desiredAssertionStatus();
    }

    public ReadTimeoutHandler(int timeoutSeconds) {
        this((long) timeoutSeconds, TimeUnit.SECONDS);
    }

    public ReadTimeoutHandler(long timeout, TimeUnit unit) {
        super(timeout, 0, 0, unit);
    }

    @Override // p013io.netty.handler.timeout.IdleStateHandler
    protected final void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        if ($assertionsDisabled || evt.state() == IdleState.READER_IDLE) {
            readTimedOut(ctx);
            return;
        }
        throw new AssertionError();
    }

    protected void readTimedOut(ChannelHandlerContext ctx) throws Exception {
        if (!this.closed) {
            ctx.fireExceptionCaught((Throwable) ReadTimeoutException.INSTANCE);
            ctx.close();
            this.closed = true;
        }
    }
}
