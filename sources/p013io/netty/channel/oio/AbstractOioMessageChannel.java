package p013io.netty.channel.oio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.RecvByteBufAllocator;

@Deprecated
/* renamed from: io.netty.channel.oio.AbstractOioMessageChannel */
/* loaded from: grasscutter.jar:io/netty/channel/oio/AbstractOioMessageChannel.class */
public abstract class AbstractOioMessageChannel extends AbstractOioChannel {
    private final List<Object> readBuf = new ArrayList();

    protected abstract int doReadMessages(List<Object> list) throws Exception;

    /* access modifiers changed from: protected */
    public AbstractOioMessageChannel(Channel parent) {
        super(parent);
    }

    @Override // p013io.netty.channel.oio.AbstractOioChannel
    protected void doRead() {
        if (this.readPending) {
            this.readPending = false;
            ChannelConfig config = config();
            ChannelPipeline pipeline = pipeline();
            RecvByteBufAllocator.Handle allocHandle = unsafe().recvBufAllocHandle();
            allocHandle.reset(config);
            boolean closed = false;
            Throwable exception = null;
            while (true) {
                try {
                    int localRead = doReadMessages(this.readBuf);
                    if (localRead != 0) {
                        if (localRead < 0) {
                            closed = true;
                            break;
                        }
                        allocHandle.incMessagesRead(localRead);
                        if (!allocHandle.continueReading()) {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Throwable t) {
                    exception = t;
                }
            }
            boolean readData = false;
            int size = this.readBuf.size();
            if (size > 0) {
                readData = true;
                for (int i = 0; i < size; i++) {
                    this.readPending = false;
                    pipeline.fireChannelRead(this.readBuf.get(i));
                }
                this.readBuf.clear();
                allocHandle.readComplete();
                pipeline.fireChannelReadComplete();
            }
            if (exception != null) {
                if (exception instanceof IOException) {
                    closed = true;
                }
                pipeline.fireExceptionCaught(exception);
            }
            if (closed) {
                if (isOpen()) {
                    unsafe().close(unsafe().voidPromise());
                }
            } else if (this.readPending || config.isAutoRead() || (!readData && isActive())) {
                read();
            }
        }
    }
}
