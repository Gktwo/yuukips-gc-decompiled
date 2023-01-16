package p013io.netty.channel;

/* renamed from: io.netty.channel.MessageSizeEstimator */
/* loaded from: grasscutter.jar:io/netty/channel/MessageSizeEstimator.class */
public interface MessageSizeEstimator {

    /* renamed from: io.netty.channel.MessageSizeEstimator$Handle */
    /* loaded from: grasscutter.jar:io/netty/channel/MessageSizeEstimator$Handle.class */
    public interface Handle {
        int size(Object obj);
    }

    Handle newHandle();
}
