package p013io.netty.channel.group;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufHolder;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelId;
import p013io.netty.channel.ServerChannel;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.channel.group.DefaultChannelGroup */
/* loaded from: grasscutter.jar:io/netty/channel/group/DefaultChannelGroup.class */
public class DefaultChannelGroup extends AbstractSet<Channel> implements ChannelGroup {
    private static final AtomicInteger nextId = new AtomicInteger();
    private final String name;
    private final EventExecutor executor;
    private final ConcurrentMap<ChannelId, Channel> serverChannels;
    private final ConcurrentMap<ChannelId, Channel> nonServerChannels;
    private final ChannelFutureListener remover;
    private final VoidChannelGroupFuture voidFuture;
    private final boolean stayClosed;
    private volatile boolean closed;

    public DefaultChannelGroup(EventExecutor executor) {
        this(executor, false);
    }

    public DefaultChannelGroup(String name, EventExecutor executor) {
        this(name, executor, false);
    }

    public DefaultChannelGroup(EventExecutor executor, boolean stayClosed) {
        this("group-0x" + Integer.toHexString(nextId.incrementAndGet()), executor, stayClosed);
    }

    public DefaultChannelGroup(String name, EventExecutor executor, boolean stayClosed) {
        this.serverChannels = PlatformDependent.newConcurrentHashMap();
        this.nonServerChannels = PlatformDependent.newConcurrentHashMap();
        this.remover = new ChannelFutureListener() { // from class: io.netty.channel.group.DefaultChannelGroup.1
            public void operationComplete(ChannelFuture future) throws Exception {
                DefaultChannelGroup.this.remove(future.channel());
            }
        };
        this.voidFuture = new VoidChannelGroupFuture(this);
        ObjectUtil.checkNotNull(name, "name");
        this.name = name;
        this.executor = executor;
        this.stayClosed = stayClosed;
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public String name() {
        return this.name;
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public Channel find(ChannelId id) {
        Channel c = this.nonServerChannels.get(id);
        if (c != null) {
            return c;
        }
        return this.serverChannels.get(id);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.nonServerChannels.isEmpty() && this.serverChannels.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.nonServerChannels.size() + this.serverChannels.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o) {
        if (o instanceof ServerChannel) {
            return this.serverChannels.containsValue(o);
        }
        if (o instanceof Channel) {
            return this.nonServerChannels.containsValue(o);
        }
        return false;
    }

    public boolean add(Channel channel) {
        boolean added = (channel instanceof ServerChannel ? this.serverChannels : this.nonServerChannels).putIfAbsent(channel.mo1183id(), channel) == null;
        if (added) {
            channel.closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) this.remover);
        }
        if (this.stayClosed && this.closed) {
            channel.close();
        }
        return added;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o) {
        Channel c = null;
        if (o instanceof ChannelId) {
            c = this.nonServerChannels.remove(o);
            if (c == null) {
                c = this.serverChannels.remove(o);
            }
        } else if (o instanceof Channel) {
            Channel c2 = (Channel) o;
            if (c2 instanceof ServerChannel) {
                c = this.serverChannels.remove(c2.mo1183id());
            } else {
                c = this.nonServerChannels.remove(c2.mo1183id());
            }
        }
        if (c == null) {
            return false;
        }
        c.closeFuture().removeListener((GenericFutureListener<? extends Future<? super Void>>) this.remover);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.nonServerChannels.clear();
        this.serverChannels.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<Channel> iterator() {
        return new CombinedIterator(this.serverChannels.values().iterator(), this.nonServerChannels.values().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        Collection<Channel> channels = new ArrayList<>(size());
        channels.addAll(this.serverChannels.values());
        channels.addAll(this.nonServerChannels.values());
        return channels.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] a) {
        Collection<Channel> channels = new ArrayList<>(size());
        channels.addAll(this.serverChannels.values());
        channels.addAll(this.nonServerChannels.values());
        return (T[]) channels.toArray(a);
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture close() {
        return close(ChannelMatchers.all());
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture disconnect() {
        return disconnect(ChannelMatchers.all());
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture deregister() {
        return deregister(ChannelMatchers.all());
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture write(Object message) {
        return write(message, ChannelMatchers.all());
    }

    private static Object safeDuplicate(Object message) {
        if (message instanceof ByteBuf) {
            return ((ByteBuf) message).retainedDuplicate();
        }
        if (message instanceof ByteBufHolder) {
            return ((ByteBufHolder) message).retainedDuplicate();
        }
        return ReferenceCountUtil.retain(message);
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture write(Object message, ChannelMatcher matcher) {
        return write(message, matcher, false);
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture write(Object message, ChannelMatcher matcher, boolean voidPromise) {
        ChannelGroupFuture future;
        ObjectUtil.checkNotNull(message, SendMailJob.PROP_MESSAGE);
        ObjectUtil.checkNotNull(matcher, "matcher");
        if (voidPromise) {
            for (Channel c : this.nonServerChannels.values()) {
                if (matcher.matches(c)) {
                    c.write(safeDuplicate(message), c.voidPromise());
                }
            }
            future = this.voidFuture;
        } else {
            Map<Channel, ChannelFuture> futures = new LinkedHashMap<>(this.nonServerChannels.size());
            for (Channel c2 : this.nonServerChannels.values()) {
                if (matcher.matches(c2)) {
                    futures.put(c2, c2.write(safeDuplicate(message)));
                }
            }
            future = new DefaultChannelGroupFuture(this, futures, this.executor);
        }
        ReferenceCountUtil.release(message);
        return future;
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroup flush() {
        return flush(ChannelMatchers.all());
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture flushAndWrite(Object message) {
        return writeAndFlush(message);
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture writeAndFlush(Object message) {
        return writeAndFlush(message, ChannelMatchers.all());
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture disconnect(ChannelMatcher matcher) {
        ObjectUtil.checkNotNull(matcher, "matcher");
        Map<Channel, ChannelFuture> futures = new LinkedHashMap<>(size());
        for (Channel c : this.serverChannels.values()) {
            if (matcher.matches(c)) {
                futures.put(c, c.disconnect());
            }
        }
        for (Channel c2 : this.nonServerChannels.values()) {
            if (matcher.matches(c2)) {
                futures.put(c2, c2.disconnect());
            }
        }
        return new DefaultChannelGroupFuture(this, futures, this.executor);
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture close(ChannelMatcher matcher) {
        ObjectUtil.checkNotNull(matcher, "matcher");
        Map<Channel, ChannelFuture> futures = new LinkedHashMap<>(size());
        if (this.stayClosed) {
            this.closed = true;
        }
        for (Channel c : this.serverChannels.values()) {
            if (matcher.matches(c)) {
                futures.put(c, c.close());
            }
        }
        for (Channel c2 : this.nonServerChannels.values()) {
            if (matcher.matches(c2)) {
                futures.put(c2, c2.close());
            }
        }
        return new DefaultChannelGroupFuture(this, futures, this.executor);
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture deregister(ChannelMatcher matcher) {
        ObjectUtil.checkNotNull(matcher, "matcher");
        Map<Channel, ChannelFuture> futures = new LinkedHashMap<>(size());
        for (Channel c : this.serverChannels.values()) {
            if (matcher.matches(c)) {
                futures.put(c, c.deregister());
            }
        }
        for (Channel c2 : this.nonServerChannels.values()) {
            if (matcher.matches(c2)) {
                futures.put(c2, c2.deregister());
            }
        }
        return new DefaultChannelGroupFuture(this, futures, this.executor);
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroup flush(ChannelMatcher matcher) {
        for (Channel c : this.nonServerChannels.values()) {
            if (matcher.matches(c)) {
                c.flush();
            }
        }
        return this;
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture flushAndWrite(Object message, ChannelMatcher matcher) {
        return writeAndFlush(message, matcher);
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture writeAndFlush(Object message, ChannelMatcher matcher) {
        return writeAndFlush(message, matcher, false);
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture writeAndFlush(Object message, ChannelMatcher matcher, boolean voidPromise) {
        ChannelGroupFuture future;
        ObjectUtil.checkNotNull(message, SendMailJob.PROP_MESSAGE);
        if (voidPromise) {
            for (Channel c : this.nonServerChannels.values()) {
                if (matcher.matches(c)) {
                    c.writeAndFlush(safeDuplicate(message), c.voidPromise());
                }
            }
            future = this.voidFuture;
        } else {
            Map<Channel, ChannelFuture> futures = new LinkedHashMap<>(this.nonServerChannels.size());
            for (Channel c2 : this.nonServerChannels.values()) {
                if (matcher.matches(c2)) {
                    futures.put(c2, c2.writeAndFlush(safeDuplicate(message)));
                }
            }
            future = new DefaultChannelGroupFuture(this, futures, this.executor);
        }
        ReferenceCountUtil.release(message);
        return future;
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture newCloseFuture() {
        return newCloseFuture(ChannelMatchers.all());
    }

    @Override // p013io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture newCloseFuture(ChannelMatcher matcher) {
        Map<Channel, ChannelFuture> futures = new LinkedHashMap<>(size());
        for (Channel c : this.serverChannels.values()) {
            if (matcher.matches(c)) {
                futures.put(c, c.closeFuture());
            }
        }
        for (Channel c2 : this.nonServerChannels.values()) {
            if (matcher.matches(c2)) {
                futures.put(c2, c2.closeFuture());
            }
        }
        return new DefaultChannelGroupFuture(this, futures, this.executor);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set, java.lang.Object
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set, java.lang.Object
    public boolean equals(Object o) {
        return this == o;
    }

    public int compareTo(ChannelGroup o) {
        int v = name().compareTo(o.name());
        if (v != 0) {
            return v;
        }
        return System.identityHashCode(this) - System.identityHashCode(o);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return StringUtil.simpleClassName(this) + "(name: " + name() + ", size: " + size() + ')';
    }
}
