package p013io.netty.bootstrap;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.netty.bootstrap.AbstractBootstrap;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelFactory;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.DefaultChannelPromise;
import p013io.netty.channel.EventLoopGroup;
import p013io.netty.channel.ReflectiveChannelFactory;
import p013io.netty.util.AttributeKey;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.GlobalEventExecutor;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.SocketUtils;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.logging.InternalLogger;

/* renamed from: io.netty.bootstrap.AbstractBootstrap */
/* loaded from: grasscutter.jar:io/netty/bootstrap/AbstractBootstrap.class */
public abstract class AbstractBootstrap<B extends AbstractBootstrap<B, C>, C extends Channel> implements Cloneable {
    private static final Map.Entry<ChannelOption<?>, Object>[] EMPTY_OPTION_ARRAY = new Map.Entry[0];
    private static final Map.Entry<AttributeKey<?>, Object>[] EMPTY_ATTRIBUTE_ARRAY = new Map.Entry[0];
    volatile EventLoopGroup group;
    private volatile ChannelFactory<? extends C> channelFactory;
    private volatile SocketAddress localAddress;
    private final Map<ChannelOption<?>, Object> options = new LinkedHashMap();
    private final Map<AttributeKey<?>, Object> attrs = new ConcurrentHashMap();
    private volatile ChannelHandler handler;

    @Override // java.lang.Object
    public abstract B clone();

    abstract void init(Channel channel) throws Exception;

    public abstract AbstractBootstrapConfig<B, C> config();

    /* access modifiers changed from: package-private */
    public AbstractBootstrap() {
    }

    /* access modifiers changed from: package-private */
    public AbstractBootstrap(AbstractBootstrap<B, C> bootstrap) {
        this.group = bootstrap.group;
        this.channelFactory = bootstrap.channelFactory;
        this.handler = bootstrap.handler;
        this.localAddress = bootstrap.localAddress;
        synchronized (bootstrap.options) {
            this.options.putAll(bootstrap.options);
        }
        this.attrs.putAll(bootstrap.attrs);
    }

    public B group(EventLoopGroup group) {
        ObjectUtil.checkNotNull(group, "group");
        if (this.group != null) {
            throw new IllegalStateException("group set already");
        }
        this.group = group;
        return self();
    }

    private B self() {
        return this;
    }

    public B channel(Class<? extends C> channelClass) {
        return channelFactory((ChannelFactory) new ReflectiveChannelFactory((Class) ObjectUtil.checkNotNull(channelClass, "channelClass")));
    }

    @Deprecated
    public B channelFactory(ChannelFactory<? extends C> channelFactory) {
        ObjectUtil.checkNotNull(channelFactory, "channelFactory");
        if (this.channelFactory != null) {
            throw new IllegalStateException("channelFactory set already");
        }
        this.channelFactory = channelFactory;
        return self();
    }

    public B channelFactory(ChannelFactory<? extends C> channelFactory) {
        return channelFactory((ChannelFactory) channelFactory);
    }

    public B localAddress(SocketAddress localAddress) {
        this.localAddress = localAddress;
        return self();
    }

    public B localAddress(int inetPort) {
        return localAddress(new InetSocketAddress(inetPort));
    }

    public B localAddress(String inetHost, int inetPort) {
        return localAddress(SocketUtils.socketAddress(inetHost, inetPort));
    }

    public B localAddress(InetAddress inetHost, int inetPort) {
        return localAddress(new InetSocketAddress(inetHost, inetPort));
    }

    public <T> B option(ChannelOption<T> option, T value) {
        ObjectUtil.checkNotNull(option, "option");
        synchronized (this.options) {
            if (value == null) {
                this.options.remove(option);
            } else {
                this.options.put(option, value);
            }
        }
        return self();
    }

    public <T> B attr(AttributeKey<T> key, T value) {
        ObjectUtil.checkNotNull(key, Action.KEY_ATTRIBUTE);
        if (value == null) {
            this.attrs.remove(key);
        } else {
            this.attrs.put(key, value);
        }
        return self();
    }

    public B validate() {
        if (this.group == null) {
            throw new IllegalStateException("group not set");
        } else if (this.channelFactory != null) {
            return self();
        } else {
            throw new IllegalStateException("channel or channelFactory not set");
        }
    }

    public ChannelFuture register() {
        validate();
        return initAndRegister();
    }

    public ChannelFuture bind() {
        validate();
        SocketAddress localAddress = this.localAddress;
        if (localAddress != null) {
            return doBind(localAddress);
        }
        throw new IllegalStateException("localAddress not set");
    }

    public ChannelFuture bind(int inetPort) {
        return bind(new InetSocketAddress(inetPort));
    }

    public ChannelFuture bind(String inetHost, int inetPort) {
        return bind(SocketUtils.socketAddress(inetHost, inetPort));
    }

    public ChannelFuture bind(InetAddress inetHost, int inetPort) {
        return bind(new InetSocketAddress(inetHost, inetPort));
    }

    public ChannelFuture bind(SocketAddress localAddress) {
        validate();
        return doBind((SocketAddress) ObjectUtil.checkNotNull(localAddress, "localAddress"));
    }

    private ChannelFuture doBind(final SocketAddress localAddress) {
        final ChannelFuture regFuture = initAndRegister();
        final Channel channel = regFuture.channel();
        if (regFuture.cause() != null) {
            return regFuture;
        }
        if (regFuture.isDone()) {
            ChannelPromise promise = channel.newPromise();
            doBind0(regFuture, channel, localAddress, promise);
            return promise;
        }
        final PendingRegistrationPromise promise2 = new PendingRegistrationPromise(channel);
        regFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.AbstractBootstrap.1
            public void operationComplete(ChannelFuture future) throws Exception {
                Throwable cause = future.cause();
                if (cause != null) {
                    promise2.setFailure(cause);
                    return;
                }
                promise2.registered();
                AbstractBootstrap.doBind0(regFuture, channel, localAddress, promise2);
            }
        });
        return promise2;
    }

    final ChannelFuture initAndRegister() {
        Channel channel = null;
        try {
            channel = this.channelFactory.newChannel();
            init(channel);
            ChannelFuture regFuture = config().group().register(channel);
            if (regFuture.cause() != null) {
                if (channel.isRegistered()) {
                    channel.close();
                } else {
                    channel.unsafe().closeForcibly();
                }
            }
            return regFuture;
        } catch (Throwable t) {
            if (channel == null) {
                return new DefaultChannelPromise(new FailedChannel(), GlobalEventExecutor.INSTANCE).setFailure(t);
            }
            channel.unsafe().closeForcibly();
            return new DefaultChannelPromise(channel, GlobalEventExecutor.INSTANCE).setFailure(t);
        }
    }

    /* access modifiers changed from: private */
    public static void doBind0(final ChannelFuture regFuture, final Channel channel, final SocketAddress localAddress, final ChannelPromise promise) {
        channel.eventLoop().execute(new Runnable() { // from class: io.netty.bootstrap.AbstractBootstrap.2
            @Override // java.lang.Runnable
            public void run() {
                if (regFuture.isSuccess()) {
                    channel.bind(localAddress, promise).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
                } else {
                    promise.setFailure(regFuture.cause());
                }
            }
        });
    }

    public B handler(ChannelHandler handler) {
        this.handler = (ChannelHandler) ObjectUtil.checkNotNull(handler, "handler");
        return self();
    }

    @Deprecated
    public final EventLoopGroup group() {
        return this.group;
    }

    final Map.Entry<ChannelOption<?>, Object>[] newOptionsArray() {
        return newOptionsArray(this.options);
    }

    static Map.Entry<ChannelOption<?>, Object>[] newOptionsArray(Map<ChannelOption<?>, Object> options) {
        Map.Entry<ChannelOption<?>, Object>[] entryArr;
        synchronized (options) {
            entryArr = (Map.Entry[]) new LinkedHashMap(options).entrySet().toArray(EMPTY_OPTION_ARRAY);
        }
        return entryArr;
    }

    final Map.Entry<AttributeKey<?>, Object>[] newAttributesArray() {
        return newAttributesArray(attrs0());
    }

    static Map.Entry<AttributeKey<?>, Object>[] newAttributesArray(Map<AttributeKey<?>, Object> attributes) {
        return (Map.Entry[]) attributes.entrySet().toArray(EMPTY_ATTRIBUTE_ARRAY);
    }

    final Map<ChannelOption<?>, Object> options0() {
        return this.options;
    }

    final Map<AttributeKey<?>, Object> attrs0() {
        return this.attrs;
    }

    /* access modifiers changed from: package-private */
    public final SocketAddress localAddress() {
        return this.localAddress;
    }

    /* access modifiers changed from: package-private */
    public final ChannelFactory<? extends C> channelFactory() {
        return this.channelFactory;
    }

    /* access modifiers changed from: package-private */
    public final ChannelHandler handler() {
        return this.handler;
    }

    /* access modifiers changed from: package-private */
    public final Map<ChannelOption<?>, Object> options() {
        Map<ChannelOption<?>, Object> copiedMap;
        synchronized (this.options) {
            copiedMap = copiedMap(this.options);
        }
        return copiedMap;
    }

    /* access modifiers changed from: package-private */
    public final Map<AttributeKey<?>, Object> attrs() {
        return copiedMap(this.attrs);
    }

    static <K, V> Map<K, V> copiedMap(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new HashMap(map));
    }

    /* access modifiers changed from: package-private */
    public static void setAttributes(Channel channel, Map.Entry<AttributeKey<?>, Object>[] attrs) {
        for (Map.Entry<AttributeKey<?>, Object> e : attrs) {
            channel.attr(e.getKey()).set(e.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    public static void setChannelOptions(Channel channel, Map.Entry<ChannelOption<?>, Object>[] options, InternalLogger logger) {
        for (Map.Entry<ChannelOption<?>, Object> e : options) {
            setChannelOption(channel, e.getKey(), e.getValue(), logger);
        }
    }

    private static void setChannelOption(Channel channel, ChannelOption<?> option, Object value, InternalLogger logger) {
        try {
            if (!channel.config().setOption(option, value)) {
                logger.warn("Unknown channel option '{}' for channel '{}'", option, channel);
            }
        } catch (Throwable t) {
            logger.warn("Failed to set channel option '{}' with value '{}' for channel '{}'", option, value, channel, t);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + config() + ')';
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.bootstrap.AbstractBootstrap$PendingRegistrationPromise */
    /* loaded from: grasscutter.jar:io/netty/bootstrap/AbstractBootstrap$PendingRegistrationPromise.class */
    public static final class PendingRegistrationPromise extends DefaultChannelPromise {
        private volatile boolean registered;

        /* access modifiers changed from: package-private */
        public PendingRegistrationPromise(Channel channel) {
            super(channel);
        }

        /* access modifiers changed from: package-private */
        public void registered() {
            this.registered = true;
        }

        /* access modifiers changed from: protected */
        @Override // p013io.netty.channel.DefaultChannelPromise, p013io.netty.util.concurrent.DefaultPromise
        public EventExecutor executor() {
            if (this.registered) {
                return executor();
            }
            return GlobalEventExecutor.INSTANCE;
        }
    }
}
