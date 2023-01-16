package p013io.netty.bootstrap;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import p013io.netty.bootstrap.AbstractBootstrap;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.EventLoopGroup;
import p013io.netty.resolver.AddressResolverGroup;
import p013io.netty.resolver.DefaultAddressResolverGroup;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.bootstrap.Bootstrap */
/* loaded from: grasscutter.jar:io/netty/bootstrap/Bootstrap.class */
public class Bootstrap extends AbstractBootstrap<Bootstrap, Channel> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Bootstrap.class);
    private static final AddressResolverGroup<?> DEFAULT_RESOLVER = DefaultAddressResolverGroup.INSTANCE;
    private final BootstrapConfig config;
    private volatile AddressResolverGroup<SocketAddress> resolver;
    private volatile SocketAddress remoteAddress;

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.netty.resolver.AddressResolverGroup<?>, io.netty.resolver.AddressResolverGroup<java.net.SocketAddress> */
    public Bootstrap() {
        this.config = new BootstrapConfig(this);
        this.resolver = DEFAULT_RESOLVER;
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: io.netty.resolver.AddressResolverGroup<?>, io.netty.resolver.AddressResolverGroup<java.net.SocketAddress> */
    private Bootstrap(Bootstrap bootstrap) {
        super(bootstrap);
        this.config = new BootstrapConfig(this);
        this.resolver = DEFAULT_RESOLVER;
        this.resolver = bootstrap.resolver;
        this.remoteAddress = bootstrap.remoteAddress;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.netty.resolver.AddressResolverGroup<java.net.SocketAddress> */
    public Bootstrap resolver(AddressResolverGroup<?> resolver) {
        this.resolver = resolver == null ? DEFAULT_RESOLVER : resolver;
        return this;
    }

    public Bootstrap remoteAddress(SocketAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
        return this;
    }

    public Bootstrap remoteAddress(String inetHost, int inetPort) {
        this.remoteAddress = InetSocketAddress.createUnresolved(inetHost, inetPort);
        return this;
    }

    public Bootstrap remoteAddress(InetAddress inetHost, int inetPort) {
        this.remoteAddress = new InetSocketAddress(inetHost, inetPort);
        return this;
    }

    public ChannelFuture connect() {
        validate();
        SocketAddress remoteAddress = this.remoteAddress;
        if (remoteAddress != null) {
            return doResolveAndConnect(remoteAddress, this.config.localAddress());
        }
        throw new IllegalStateException("remoteAddress not set");
    }

    public ChannelFuture connect(String inetHost, int inetPort) {
        return connect(InetSocketAddress.createUnresolved(inetHost, inetPort));
    }

    public ChannelFuture connect(InetAddress inetHost, int inetPort) {
        return connect(new InetSocketAddress(inetHost, inetPort));
    }

    public ChannelFuture connect(SocketAddress remoteAddress) {
        ObjectUtil.checkNotNull(remoteAddress, "remoteAddress");
        validate();
        return doResolveAndConnect(remoteAddress, this.config.localAddress());
    }

    public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress) {
        ObjectUtil.checkNotNull(remoteAddress, "remoteAddress");
        validate();
        return doResolveAndConnect(remoteAddress, localAddress);
    }

    private ChannelFuture doResolveAndConnect(final SocketAddress remoteAddress, final SocketAddress localAddress) {
        ChannelFuture regFuture = initAndRegister();
        final Channel channel = regFuture.channel();
        if (!regFuture.isDone()) {
            final AbstractBootstrap.PendingRegistrationPromise promise = new AbstractBootstrap.PendingRegistrationPromise(channel);
            regFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.Bootstrap.1
                public void operationComplete(ChannelFuture future) throws Exception {
                    Throwable cause = future.cause();
                    if (cause != null) {
                        promise.setFailure(cause);
                        return;
                    }
                    promise.registered();
                    Bootstrap.this.doResolveAndConnect0(channel, remoteAddress, localAddress, promise);
                }
            });
            return promise;
        } else if (!regFuture.isSuccess()) {
            return regFuture;
        } else {
            return doResolveAndConnect0(channel, remoteAddress, localAddress, channel.newPromise());
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:4:0x0016
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public p013io.netty.channel.ChannelFuture doResolveAndConnect0(p013io.netty.channel.Channel r9, java.net.SocketAddress r10, java.net.SocketAddress r11, p013io.netty.channel.ChannelPromise r12) {
        /*
            r8 = this;
            r0 = r9
            io.netty.channel.EventLoop r0 = r0.eventLoop()     // Catch: Throwable -> 0x00a9
            r13 = r0
            r0 = r8
            io.netty.resolver.AddressResolverGroup<java.net.SocketAddress> r0 = r0.resolver     // Catch: Throwable -> 0x00a9, Throwable -> 0x0016
            r1 = r13
            io.netty.resolver.AddressResolver r0 = r0.getResolver(r1)     // Catch: Throwable -> 0x00a9, Throwable -> 0x0016
            r14 = r0
            goto L_0x0029
        L_0x0016:
            r15 = move-exception
            r0 = r9
            io.netty.channel.ChannelFuture r0 = r0.close()     // Catch: Throwable -> 0x00a9
            r0 = r12
            r1 = r15
            io.netty.channel.ChannelPromise r0 = r0.setFailure(r1)     // Catch: Throwable -> 0x00a9
            return r0
        L_0x0029:
            r0 = r14
            r1 = r10
            boolean r0 = r0.isSupported(r1)     // Catch: Throwable -> 0x00a9
            if (r0 == 0) goto L_0x003f
            r0 = r14
            r1 = r10
            boolean r0 = r0.isResolved(r1)     // Catch: Throwable -> 0x00a9
            if (r0 == 0) goto L_0x0049
        L_0x003f:
            r0 = r10
            r1 = r11
            r2 = r12
            doConnect(r0, r1, r2)     // Catch: Throwable -> 0x00a9
            r0 = r12
            return r0
        L_0x0049:
            r0 = r14
            r1 = r10
            io.netty.util.concurrent.Future r0 = r0.resolve(r1)     // Catch: Throwable -> 0x00a9
            r15 = r0
            r0 = r15
            boolean r0 = r0.isDone()     // Catch: Throwable -> 0x00a9
            if (r0 == 0) goto L_0x0092
            r0 = r15
            java.lang.Throwable r0 = r0.cause()     // Catch: Throwable -> 0x00a9
            r16 = r0
            r0 = r16
            if (r0 == 0) goto L_0x007f
            r0 = r9
            io.netty.channel.ChannelFuture r0 = r0.close()     // Catch: Throwable -> 0x00a9
            r0 = r12
            r1 = r16
            io.netty.channel.ChannelPromise r0 = r0.setFailure(r1)     // Catch: Throwable -> 0x00a9
            goto L_0x008f
        L_0x007f:
            r0 = r15
            java.lang.Object r0 = r0.getNow()     // Catch: Throwable -> 0x00a9
            java.net.SocketAddress r0 = (java.net.SocketAddress) r0     // Catch: Throwable -> 0x00a9
            r1 = r11
            r2 = r12
            doConnect(r0, r1, r2)     // Catch: Throwable -> 0x00a9
        L_0x008f:
            r0 = r12
            return r0
        L_0x0092:
            r0 = r15
            io.netty.bootstrap.Bootstrap$2 r1 = new io.netty.bootstrap.Bootstrap$2     // Catch: Throwable -> 0x00a9
            r2 = r1
            r3 = r8
            r4 = r9
            r5 = r12
            r6 = r11
            r2.<init>(r4, r5, r6)     // Catch: Throwable -> 0x00a9
            io.netty.util.concurrent.Future r0 = r0.addListener(r1)     // Catch: Throwable -> 0x00a9
            goto L_0x00b5
        L_0x00a9:
            r13 = move-exception
            r0 = r12
            r1 = r13
            boolean r0 = r0.tryFailure(r1)
        L_0x00b5:
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.bootstrap.Bootstrap.doResolveAndConnect0(io.netty.channel.Channel, java.net.SocketAddress, java.net.SocketAddress, io.netty.channel.ChannelPromise):io.netty.channel.ChannelFuture");
    }

    /* access modifiers changed from: private */
    public static void doConnect(final SocketAddress remoteAddress, final SocketAddress localAddress, final ChannelPromise connectPromise) {
        final Channel channel = connectPromise.channel();
        channel.eventLoop().execute(new Runnable() { // from class: io.netty.bootstrap.Bootstrap.3
            @Override // java.lang.Runnable
            public void run() {
                if (localAddress == null) {
                    channel.connect(remoteAddress, connectPromise);
                } else {
                    channel.connect(remoteAddress, localAddress, connectPromise);
                }
                connectPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
            }
        });
    }

    @Override // p013io.netty.bootstrap.AbstractBootstrap
    void init(Channel channel) {
        channel.pipeline().addLast(this.config.handler());
        setChannelOptions(channel, newOptionsArray(), logger);
        setAttributes(channel, newAttributesArray());
    }

    @Override // p013io.netty.bootstrap.AbstractBootstrap
    public Bootstrap validate() {
        validate();
        if (this.config.handler() != null) {
            return this;
        }
        throw new IllegalStateException("handler not set");
    }

    @Override // p013io.netty.bootstrap.AbstractBootstrap, java.lang.Object
    public Bootstrap clone() {
        return new Bootstrap(this);
    }

    public Bootstrap clone(EventLoopGroup group) {
        Bootstrap bs = new Bootstrap(this);
        bs.group = group;
        return bs;
    }

    /* Return type fixed from 'io.netty.bootstrap.BootstrapConfig' to match base method */
    @Override // p013io.netty.bootstrap.AbstractBootstrap
    public final AbstractBootstrapConfig<Bootstrap, Channel> config() {
        return this.config;
    }

    /* access modifiers changed from: package-private */
    public final SocketAddress remoteAddress() {
        return this.remoteAddress;
    }

    /* access modifiers changed from: package-private */
    public final AddressResolverGroup<?> resolver() {
        return this.resolver;
    }
}
