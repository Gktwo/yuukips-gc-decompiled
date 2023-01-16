package p013io.netty.channel;

import p013io.netty.util.IntSupplier;

/* renamed from: io.netty.channel.DefaultSelectStrategy */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultSelectStrategy.class */
final class DefaultSelectStrategy implements SelectStrategy {
    static final SelectStrategy INSTANCE = new DefaultSelectStrategy();

    private DefaultSelectStrategy() {
    }

    @Override // p013io.netty.channel.SelectStrategy
    public int calculateStrategy(IntSupplier selectSupplier, boolean hasTasks) throws Exception {
        if (hasTasks) {
            return selectSupplier.get();
        }
        return -1;
    }
}
