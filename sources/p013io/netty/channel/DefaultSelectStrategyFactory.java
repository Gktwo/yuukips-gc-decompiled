package p013io.netty.channel;

/* renamed from: io.netty.channel.DefaultSelectStrategyFactory */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultSelectStrategyFactory.class */
public final class DefaultSelectStrategyFactory implements SelectStrategyFactory {
    public static final SelectStrategyFactory INSTANCE = new DefaultSelectStrategyFactory();

    private DefaultSelectStrategyFactory() {
    }

    @Override // p013io.netty.channel.SelectStrategyFactory
    public SelectStrategy newSelectStrategy() {
        return DefaultSelectStrategy.INSTANCE;
    }
}
