package p013io.netty.channel;

import p013io.netty.util.IntSupplier;

/* renamed from: io.netty.channel.SelectStrategy */
/* loaded from: grasscutter.jar:io/netty/channel/SelectStrategy.class */
public interface SelectStrategy {
    public static final int SELECT = -1;
    public static final int CONTINUE = -2;
    public static final int BUSY_WAIT = -3;

    int calculateStrategy(IntSupplier intSupplier, boolean z) throws Exception;
}
