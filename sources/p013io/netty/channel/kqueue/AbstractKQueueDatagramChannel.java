package p013io.netty.channel.kqueue;

import java.io.IOException;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;

/* renamed from: io.netty.channel.kqueue.AbstractKQueueDatagramChannel */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/AbstractKQueueDatagramChannel.class */
abstract class AbstractKQueueDatagramChannel extends AbstractKQueueChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);

    protected abstract boolean doWriteMessage(Object obj) throws Exception;

    /* access modifiers changed from: package-private */
    public AbstractKQueueDatagramChannel(Channel parent, BsdSocket fd, boolean active) {
        super(parent, fd, active);
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        Object msg;
        boolean done;
        int maxMessagesPerWrite = maxMessagesPerWrite();
        while (maxMessagesPerWrite > 0 && (msg = in.current()) != null) {
            try {
                done = false;
                int i = config().getWriteSpinCount();
                while (true) {
                    if (i <= 0) {
                        break;
                    } else if (doWriteMessage(msg)) {
                        done = true;
                        break;
                    } else {
                        i--;
                    }
                }
            } catch (IOException e) {
                maxMessagesPerWrite--;
                in.remove(e);
            }
            if (!done) {
                break;
            }
            in.remove();
            maxMessagesPerWrite--;
        }
        writeFilter(!in.isEmpty());
    }
}
