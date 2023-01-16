package p013io.netty.channel;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p013io.netty.channel.Channel;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.ResourceLeakDetector;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.EventExecutorGroup;
import p013io.netty.util.concurrent.FastThreadLocal;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.DefaultChannelPipeline */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultChannelPipeline.class */
public class DefaultChannelPipeline implements ChannelPipeline {
    static final InternalLogger logger;
    private static final String HEAD_NAME;
    private static final String TAIL_NAME;
    private static final FastThreadLocal<Map<Class<?>, String>> nameCaches;
    private static final AtomicReferenceFieldUpdater<DefaultChannelPipeline, MessageSizeEstimator.Handle> ESTIMATOR;
    private final Channel channel;
    private final ChannelFuture succeededFuture;
    private final VoidChannelPromise voidPromise;
    private Map<EventExecutorGroup, EventExecutor> childExecutors;
    private volatile MessageSizeEstimator.Handle estimatorHandle;
    private PendingHandlerCallback pendingHandlerCallbackHead;
    private boolean registered;
    static final /* synthetic */ boolean $assertionsDisabled;
    private final boolean touch = ResourceLeakDetector.isEnabled();
    private boolean firstRegistration = true;
    final AbstractChannelHandlerContext tail = new TailContext(this);
    final AbstractChannelHandlerContext head = new HeadContext(this);

    static {
        $assertionsDisabled = !DefaultChannelPipeline.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(DefaultChannelPipeline.class);
        HEAD_NAME = generateName0(HeadContext.class);
        TAIL_NAME = generateName0(TailContext.class);
        nameCaches = new FastThreadLocal<Map<Class<?>, String>>() { // from class: io.netty.channel.DefaultChannelPipeline.1
            /* access modifiers changed from: protected */
            @Override // p013io.netty.util.concurrent.FastThreadLocal
            public Map<Class<?>, String> initialValue() {
                return new WeakHashMap();
            }
        };
        ESTIMATOR = AtomicReferenceFieldUpdater.newUpdater(DefaultChannelPipeline.class, MessageSizeEstimator.Handle.class, "estimatorHandle");
    }

    /* access modifiers changed from: protected */
    public DefaultChannelPipeline(Channel channel) {
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
        this.succeededFuture = new SucceededChannelFuture(channel, null);
        this.voidPromise = new VoidChannelPromise(channel, true);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    /* access modifiers changed from: package-private */
    public final MessageSizeEstimator.Handle estimatorHandle() {
        MessageSizeEstimator.Handle handle = this.estimatorHandle;
        if (handle == null) {
            handle = this.channel.config().getMessageSizeEstimator().newHandle();
            if (!ESTIMATOR.compareAndSet(this, null, handle)) {
                handle = this.estimatorHandle;
            }
        }
        return handle;
    }

    /* access modifiers changed from: package-private */
    public final Object touch(Object msg, AbstractChannelHandlerContext next) {
        return this.touch ? ReferenceCountUtil.touch(msg, next) : msg;
    }

    private AbstractChannelHandlerContext newContext(EventExecutorGroup group, String name, ChannelHandler handler) {
        return new DefaultChannelHandlerContext(this, childExecutor(group), name, handler);
    }

    private EventExecutor childExecutor(EventExecutorGroup group) {
        if (group == null) {
            return null;
        }
        Boolean pinEventExecutor = (Boolean) this.channel.config().getOption(ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP);
        if (pinEventExecutor != null && !pinEventExecutor.booleanValue()) {
            return group.next();
        }
        Map<EventExecutorGroup, EventExecutor> childExecutors = this.childExecutors;
        if (childExecutors == null) {
            Map<EventExecutorGroup, EventExecutor> identityHashMap = new IdentityHashMap<>(4);
            this.childExecutors = identityHashMap;
            childExecutors = identityHashMap;
        }
        EventExecutor childExecutor = childExecutors.get(group);
        if (childExecutor == null) {
            childExecutor = group.next();
            childExecutors.put(group, childExecutor);
        }
        return childExecutor;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final Channel channel() {
        return this.channel;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(String name, ChannelHandler handler) {
        return addFirst(null, name, handler);
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(EventExecutorGroup group, String name, ChannelHandler handler) {
        synchronized (this) {
            checkMultiplicity(handler);
            AbstractChannelHandlerContext newCtx = newContext(group, filterName(name, handler), handler);
            addFirst0(newCtx);
            if (!this.registered) {
                newCtx.setAddPending();
                callHandlerCallbackLater(newCtx, true);
                return this;
            }
            EventExecutor executor = newCtx.executor();
            if (!executor.inEventLoop()) {
                callHandlerAddedInEventLoop(newCtx, executor);
                return this;
            }
            callHandlerAdded0(newCtx);
            return this;
        }
    }

    private void addFirst0(AbstractChannelHandlerContext newCtx) {
        AbstractChannelHandlerContext nextCtx = this.head.next;
        newCtx.prev = this.head;
        newCtx.next = nextCtx;
        this.head.next = newCtx;
        nextCtx.prev = newCtx;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(String name, ChannelHandler handler) {
        return addLast(null, name, handler);
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(EventExecutorGroup group, String name, ChannelHandler handler) {
        synchronized (this) {
            checkMultiplicity(handler);
            AbstractChannelHandlerContext newCtx = newContext(group, filterName(name, handler), handler);
            addLast0(newCtx);
            if (!this.registered) {
                newCtx.setAddPending();
                callHandlerCallbackLater(newCtx, true);
                return this;
            }
            EventExecutor executor = newCtx.executor();
            if (!executor.inEventLoop()) {
                callHandlerAddedInEventLoop(newCtx, executor);
                return this;
            }
            callHandlerAdded0(newCtx);
            return this;
        }
    }

    private void addLast0(AbstractChannelHandlerContext newCtx) {
        AbstractChannelHandlerContext prev = this.tail.prev;
        newCtx.prev = prev;
        newCtx.next = this.tail;
        prev.next = newCtx;
        this.tail.prev = newCtx;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline addBefore(String baseName, String name, ChannelHandler handler) {
        return addBefore(null, baseName, name, handler);
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline addBefore(EventExecutorGroup group, String baseName, String name, ChannelHandler handler) {
        synchronized (this) {
            checkMultiplicity(handler);
            String name2 = filterName(name, handler);
            AbstractChannelHandlerContext ctx = getContextOrDie(baseName);
            AbstractChannelHandlerContext newCtx = newContext(group, name2, handler);
            addBefore0(ctx, newCtx);
            if (!this.registered) {
                newCtx.setAddPending();
                callHandlerCallbackLater(newCtx, true);
                return this;
            }
            EventExecutor executor = newCtx.executor();
            if (!executor.inEventLoop()) {
                callHandlerAddedInEventLoop(newCtx, executor);
                return this;
            }
            callHandlerAdded0(newCtx);
            return this;
        }
    }

    private static void addBefore0(AbstractChannelHandlerContext ctx, AbstractChannelHandlerContext newCtx) {
        newCtx.prev = ctx.prev;
        newCtx.next = ctx;
        ctx.prev.next = newCtx;
        ctx.prev = newCtx;
    }

    private String filterName(String name, ChannelHandler handler) {
        if (name == null) {
            return generateName(handler);
        }
        checkDuplicateName(name);
        return name;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline addAfter(String baseName, String name, ChannelHandler handler) {
        return addAfter(null, baseName, name, handler);
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline addAfter(EventExecutorGroup group, String baseName, String name, ChannelHandler handler) {
        synchronized (this) {
            checkMultiplicity(handler);
            String name2 = filterName(name, handler);
            AbstractChannelHandlerContext ctx = getContextOrDie(baseName);
            AbstractChannelHandlerContext newCtx = newContext(group, name2, handler);
            addAfter0(ctx, newCtx);
            if (!this.registered) {
                newCtx.setAddPending();
                callHandlerCallbackLater(newCtx, true);
                return this;
            }
            EventExecutor executor = newCtx.executor();
            if (!executor.inEventLoop()) {
                callHandlerAddedInEventLoop(newCtx, executor);
                return this;
            }
            callHandlerAdded0(newCtx);
            return this;
        }
    }

    private static void addAfter0(AbstractChannelHandlerContext ctx, AbstractChannelHandlerContext newCtx) {
        newCtx.prev = ctx;
        newCtx.next = ctx.next;
        ctx.next.prev = newCtx;
        ctx.next = newCtx;
    }

    public final ChannelPipeline addFirst(ChannelHandler handler) {
        return addFirst((String) null, handler);
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(ChannelHandler... handlers) {
        return addFirst((EventExecutorGroup) null, handlers);
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(EventExecutorGroup executor, ChannelHandler... handlers) {
        ObjectUtil.checkNotNull(handlers, "handlers");
        if (handlers.length == 0 || handlers[0] == null) {
            return this;
        }
        int size = 1;
        while (size < handlers.length && handlers[size] != null) {
            size++;
        }
        for (int i = size - 1; i >= 0; i--) {
            addFirst(executor, null, handlers[i]);
        }
        return this;
    }

    public final ChannelPipeline addLast(ChannelHandler handler) {
        return addLast((String) null, handler);
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(ChannelHandler... handlers) {
        return addLast((EventExecutorGroup) null, handlers);
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(EventExecutorGroup executor, ChannelHandler... handlers) {
        ChannelHandler h;
        ObjectUtil.checkNotNull(handlers, "handlers");
        int length = handlers.length;
        int i = 0;
        while (i < length && (h = handlers[i]) != null) {
            addLast(executor, null, h);
            i++;
        }
        return this;
    }

    private String generateName(ChannelHandler handler) {
        String newName;
        Map<Class<?>, String> cache = nameCaches.get();
        Class<?> handlerType = handler.getClass();
        String name = cache.get(handlerType);
        if (name == null) {
            name = generateName0(handlerType);
            cache.put(handlerType, name);
        }
        if (context0(name) != null) {
            String baseName = name.substring(0, name.length() - 1);
            int i = 1;
            while (true) {
                newName = baseName + i;
                if (context0(newName) == null) {
                    break;
                }
                i++;
            }
            name = newName;
        }
        return name;
    }

    private static String generateName0(Class<?> handlerType) {
        return StringUtil.simpleClassName(handlerType) + "#0";
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline remove(ChannelHandler handler) {
        remove(getContextOrDie(handler));
        return this;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelHandler remove(String name) {
        return remove(getContextOrDie(name)).handler();
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final <T extends ChannelHandler> T remove(Class<T> handlerType) {
        return (T) remove(getContextOrDie(handlerType)).handler();
    }

    public final <T extends ChannelHandler> T removeIfExists(String name) {
        return (T) removeIfExists(context(name));
    }

    public final <T extends ChannelHandler> T removeIfExists(Class<T> handlerType) {
        return (T) removeIfExists(context(handlerType));
    }

    public final <T extends ChannelHandler> T removeIfExists(ChannelHandler handler) {
        return (T) removeIfExists(context(handler));
    }

    private <T extends ChannelHandler> T removeIfExists(ChannelHandlerContext ctx) {
        if (ctx == null) {
            return null;
        }
        return (T) remove((AbstractChannelHandlerContext) ctx).handler();
    }

    private AbstractChannelHandlerContext remove(final AbstractChannelHandlerContext ctx) {
        if ($assertionsDisabled || !(ctx == this.head || ctx == this.tail)) {
            synchronized (this) {
                atomicRemoveFromHandlerList(ctx);
                if (!this.registered) {
                    callHandlerCallbackLater(ctx, false);
                    return ctx;
                }
                EventExecutor executor = ctx.executor();
                if (!executor.inEventLoop()) {
                    executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DefaultChannelPipeline.this.callHandlerRemoved0(ctx);
                        }
                    });
                    return ctx;
                }
                callHandlerRemoved0(ctx);
                return ctx;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public synchronized void atomicRemoveFromHandlerList(AbstractChannelHandlerContext ctx) {
        AbstractChannelHandlerContext prev = ctx.prev;
        AbstractChannelHandlerContext next = ctx.next;
        prev.next = next;
        next.prev = prev;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelHandler removeFirst() {
        if (this.head.next != this.tail) {
            return remove(this.head.next).handler();
        }
        throw new NoSuchElementException();
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelHandler removeLast() {
        if (this.head.next != this.tail) {
            return remove(this.tail.prev).handler();
        }
        throw new NoSuchElementException();
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelPipeline replace(ChannelHandler oldHandler, String newName, ChannelHandler newHandler) {
        replace(getContextOrDie(oldHandler), newName, newHandler);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelHandler replace(String oldName, String newName, ChannelHandler newHandler) {
        return replace(getContextOrDie(oldName), newName, newHandler);
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final <T extends ChannelHandler> T replace(Class<T> oldHandlerType, String newName, ChannelHandler newHandler) {
        return (T) replace(getContextOrDie(oldHandlerType), newName, newHandler);
    }

    private ChannelHandler replace(final AbstractChannelHandlerContext ctx, String newName, ChannelHandler newHandler) {
        if ($assertionsDisabled || !(ctx == this.head || ctx == this.tail)) {
            synchronized (this) {
                checkMultiplicity(newHandler);
                if (newName == null) {
                    newName = generateName(newHandler);
                } else if (!ctx.name().equals(newName)) {
                    checkDuplicateName(newName);
                }
                final AbstractChannelHandlerContext newCtx = newContext(ctx.executor, newName, newHandler);
                replace0(ctx, newCtx);
                if (!this.registered) {
                    callHandlerCallbackLater(newCtx, true);
                    callHandlerCallbackLater(ctx, false);
                    return ctx.handler();
                }
                EventExecutor executor = ctx.executor();
                if (!executor.inEventLoop()) {
                    executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.3
                        @Override // java.lang.Runnable
                        public void run() {
                            DefaultChannelPipeline.this.callHandlerAdded0(newCtx);
                            DefaultChannelPipeline.this.callHandlerRemoved0(ctx);
                        }
                    });
                    return ctx.handler();
                }
                callHandlerAdded0(newCtx);
                callHandlerRemoved0(ctx);
                return ctx.handler();
            }
        }
        throw new AssertionError();
    }

    private static void replace0(AbstractChannelHandlerContext oldCtx, AbstractChannelHandlerContext newCtx) {
        AbstractChannelHandlerContext prev = oldCtx.prev;
        AbstractChannelHandlerContext next = oldCtx.next;
        newCtx.prev = prev;
        newCtx.next = next;
        prev.next = newCtx;
        next.prev = newCtx;
        oldCtx.prev = newCtx;
        oldCtx.next = newCtx;
    }

    private static void checkMultiplicity(ChannelHandler handler) {
        if (handler instanceof ChannelHandlerAdapter) {
            ChannelHandlerAdapter h = (ChannelHandlerAdapter) handler;
            if (h.isSharable() || !h.added) {
                h.added = true;
                return;
            }
            throw new ChannelPipelineException(h.getClass().getName() + " is not a @Sharable handler, so can't be added or removed multiple times.");
        }
    }

    /* access modifiers changed from: private */
    public void callHandlerAdded0(AbstractChannelHandlerContext ctx) {
        try {
            ctx.callHandlerAdded();
        } catch (Throwable t) {
            boolean removed = false;
            try {
                atomicRemoveFromHandlerList(ctx);
                ctx.callHandlerRemoved();
                removed = true;
            } catch (Throwable t2) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Failed to remove a handler: " + ctx.name(), t2);
                }
            }
            if (removed) {
                fireExceptionCaught((Throwable) new ChannelPipelineException(ctx.handler().getClass().getName() + ".handlerAdded() has thrown an exception; removed.", t));
            } else {
                fireExceptionCaught((Throwable) new ChannelPipelineException(ctx.handler().getClass().getName() + ".handlerAdded() has thrown an exception; also failed to remove.", t));
            }
        }
    }

    /* access modifiers changed from: private */
    public void callHandlerRemoved0(AbstractChannelHandlerContext ctx) {
        try {
            ctx.callHandlerRemoved();
        } catch (Throwable t) {
            fireExceptionCaught((Throwable) new ChannelPipelineException(ctx.handler().getClass().getName() + ".handlerRemoved() has thrown an exception.", t));
        }
    }

    /* access modifiers changed from: package-private */
    public final void invokeHandlerAddedIfNeeded() {
        if (!$assertionsDisabled && !this.channel.eventLoop().inEventLoop()) {
            throw new AssertionError();
        } else if (this.firstRegistration) {
            this.firstRegistration = false;
            callHandlerAddedForAllHandlers();
        }
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelHandler first() {
        ChannelHandlerContext first = firstContext();
        if (first == null) {
            return null;
        }
        return first.handler();
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext firstContext() {
        if (this.head.next == this.tail) {
            return null;
        }
        return this.head.next;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelHandler last() {
        AbstractChannelHandlerContext last = this.tail.prev;
        if (last == this.head) {
            return null;
        }
        return last.handler();
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext lastContext() {
        AbstractChannelHandlerContext last = this.tail.prev;
        if (last == this.head) {
            return null;
        }
        return last;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelHandler get(String name) {
        ChannelHandlerContext ctx = context(name);
        if (ctx == null) {
            return null;
        }
        return ctx.handler();
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final <T extends ChannelHandler> T get(Class<T> handlerType) {
        ChannelHandlerContext ctx = context(handlerType);
        if (ctx == null) {
            return null;
        }
        return (T) ctx.handler();
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext context(String name) {
        return context0((String) ObjectUtil.checkNotNull(name, "name"));
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext context(ChannelHandler handler) {
        ObjectUtil.checkNotNull(handler, "handler");
        for (AbstractChannelHandlerContext ctx = this.head.next; ctx != null; ctx = ctx.next) {
            if (ctx.handler() == handler) {
                return ctx;
            }
        }
        return null;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext context(Class<? extends ChannelHandler> handlerType) {
        ObjectUtil.checkNotNull(handlerType, "handlerType");
        for (AbstractChannelHandlerContext ctx = this.head.next; ctx != null; ctx = ctx.next) {
            if (handlerType.isAssignableFrom(ctx.handler().getClass())) {
                return ctx;
            }
        }
        return null;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final List<String> names() {
        List<String> list = new ArrayList<>();
        for (AbstractChannelHandlerContext ctx = this.head.next; ctx != null; ctx = ctx.next) {
            list.add(ctx.name());
        }
        return list;
    }

    @Override // p013io.netty.channel.ChannelPipeline
    public final Map<String, ChannelHandler> toMap() {
        Map<String, ChannelHandler> map = new LinkedHashMap<>();
        for (AbstractChannelHandlerContext ctx = this.head.next; ctx != this.tail; ctx = ctx.next) {
            map.put(ctx.name(), ctx.handler());
        }
        return map;
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<String, ChannelHandler>> iterator() {
        return toMap().entrySet().iterator();
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder buf = new StringBuilder().append(StringUtil.simpleClassName(this)).append('{');
        AbstractChannelHandlerContext ctx = this.head.next;
        while (ctx != this.tail) {
            buf.append('(').append(ctx.name()).append(" = ").append(ctx.handler().getClass().getName()).append(')');
            ctx = ctx.next;
            if (ctx == this.tail) {
                break;
            }
            buf.append(", ");
        }
        buf.append('}');
        return buf.toString();
    }

    @Override // p013io.netty.channel.ChannelPipeline, p013io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelRegistered() {
        AbstractChannelHandlerContext.invokeChannelRegistered(this.head);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPipeline, p013io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelUnregistered() {
        AbstractChannelHandlerContext.invokeChannelUnregistered(this.head);
        return this;
    }

    /* access modifiers changed from: private */
    public synchronized void destroy() {
        destroyUp(this.head.next, false);
    }

    /* access modifiers changed from: private */
    public void destroyUp(final AbstractChannelHandlerContext ctx, boolean inEventLoop) {
        Thread currentThread = Thread.currentThread();
        AbstractChannelHandlerContext tail = this.tail;
        while (ctx != tail) {
            EventExecutor executor = ctx.executor();
            if (inEventLoop || executor.inEventLoop(currentThread)) {
                ctx = ctx.next;
                inEventLoop = false;
            } else {
                executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.destroyUp(ctx, true);
                    }
                });
                return;
            }
        }
        destroyDown(currentThread, tail.prev, inEventLoop);
    }

    /* access modifiers changed from: private */
    public void destroyDown(Thread currentThread, final AbstractChannelHandlerContext ctx, boolean inEventLoop) {
        AbstractChannelHandlerContext head = this.head;
        while (ctx != head) {
            EventExecutor executor = ctx.executor();
            if (inEventLoop || executor.inEventLoop(currentThread)) {
                atomicRemoveFromHandlerList(ctx);
                callHandlerRemoved0(ctx);
                ctx = ctx.prev;
                inEventLoop = false;
            } else {
                executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.5
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.destroyDown(Thread.currentThread(), ctx, true);
                    }
                });
                return;
            }
        }
    }

    @Override // p013io.netty.channel.ChannelPipeline, p013io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelActive() {
        AbstractChannelHandlerContext.invokeChannelActive(this.head);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPipeline, p013io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelInactive() {
        AbstractChannelHandlerContext.invokeChannelInactive(this.head);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPipeline, p013io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireExceptionCaught(Throwable cause) {
        AbstractChannelHandlerContext.invokeExceptionCaught(this.head, cause);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPipeline, p013io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireUserEventTriggered(Object event) {
        AbstractChannelHandlerContext.invokeUserEventTriggered(this.head, event);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPipeline, p013io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelRead(Object msg) {
        AbstractChannelHandlerContext.invokeChannelRead(this.head, msg);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPipeline, p013io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelReadComplete() {
        AbstractChannelHandlerContext.invokeChannelReadComplete(this.head);
        return this;
    }

    @Override // p013io.netty.channel.ChannelPipeline, p013io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelWritabilityChanged() {
        AbstractChannelHandlerContext.invokeChannelWritabilityChanged(this.head);
        return this;
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture bind(SocketAddress localAddress) {
        return this.tail.bind(localAddress);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress remoteAddress) {
        return this.tail.connect(remoteAddress);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress) {
        return this.tail.connect(remoteAddress, localAddress);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture disconnect() {
        return this.tail.disconnect();
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture close() {
        return this.tail.close();
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture deregister() {
        return this.tail.deregister();
    }

    @Override // p013io.netty.channel.ChannelPipeline, p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelPipeline flush() {
        this.tail.flush();
        return this;
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture bind(SocketAddress localAddress, ChannelPromise promise) {
        return this.tail.bind(localAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress remoteAddress, ChannelPromise promise) {
        return this.tail.connect(remoteAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
        return this.tail.connect(remoteAddress, localAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture disconnect(ChannelPromise promise) {
        return this.tail.disconnect(promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture close(ChannelPromise promise) {
        return this.tail.close(promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture deregister(ChannelPromise promise) {
        return this.tail.deregister(promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelPipeline read() {
        this.tail.read();
        return this;
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture write(Object msg) {
        return this.tail.write(msg);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture write(Object msg, ChannelPromise promise) {
        return this.tail.write(msg, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture writeAndFlush(Object msg, ChannelPromise promise) {
        return this.tail.writeAndFlush(msg, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture writeAndFlush(Object msg) {
        return this.tail.writeAndFlush(msg);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise newPromise() {
        return new DefaultChannelPromise(this.channel);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelProgressivePromise newProgressivePromise() {
        return new DefaultChannelProgressivePromise(this.channel);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture newSucceededFuture() {
        return this.succeededFuture;
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture newFailedFuture(Throwable cause) {
        return new FailedChannelFuture(this.channel, null, cause);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise voidPromise() {
        return this.voidPromise;
    }

    private void checkDuplicateName(String name) {
        if (context0(name) != null) {
            throw new IllegalArgumentException("Duplicate handler name: " + name);
        }
    }

    private AbstractChannelHandlerContext context0(String name) {
        for (AbstractChannelHandlerContext context = this.head.next; context != this.tail; context = context.next) {
            if (context.name().equals(name)) {
                return context;
            }
        }
        return null;
    }

    private AbstractChannelHandlerContext getContextOrDie(String name) {
        AbstractChannelHandlerContext ctx = (AbstractChannelHandlerContext) context(name);
        if (ctx != null) {
            return ctx;
        }
        throw new NoSuchElementException(name);
    }

    private AbstractChannelHandlerContext getContextOrDie(ChannelHandler handler) {
        AbstractChannelHandlerContext ctx = (AbstractChannelHandlerContext) context(handler);
        if (ctx != null) {
            return ctx;
        }
        throw new NoSuchElementException(handler.getClass().getName());
    }

    private AbstractChannelHandlerContext getContextOrDie(Class<? extends ChannelHandler> handlerType) {
        AbstractChannelHandlerContext ctx = (AbstractChannelHandlerContext) context(handlerType);
        if (ctx != null) {
            return ctx;
        }
        throw new NoSuchElementException(handlerType.getName());
    }

    private void callHandlerAddedForAllHandlers() {
        PendingHandlerCallback pendingHandlerCallbackHead;
        synchronized (this) {
            if ($assertionsDisabled || !this.registered) {
                this.registered = true;
                pendingHandlerCallbackHead = this.pendingHandlerCallbackHead;
                this.pendingHandlerCallbackHead = null;
            } else {
                throw new AssertionError();
            }
        }
        for (PendingHandlerCallback task = pendingHandlerCallbackHead; task != null; task = task.next) {
            task.execute();
        }
    }

    private void callHandlerCallbackLater(AbstractChannelHandlerContext ctx, boolean added) {
        if ($assertionsDisabled || !this.registered) {
            PendingHandlerCallback task = added ? new PendingHandlerAddedTask(ctx) : new PendingHandlerRemovedTask(ctx);
            PendingHandlerCallback pending = this.pendingHandlerCallbackHead;
            if (pending == null) {
                this.pendingHandlerCallbackHead = task;
                return;
            }
            while (pending.next != null) {
                pending = pending.next;
            }
            pending.next = task;
            return;
        }
        throw new AssertionError();
    }

    private void callHandlerAddedInEventLoop(final AbstractChannelHandlerContext newCtx, EventExecutor executor) {
        newCtx.setAddPending();
        executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.6
            @Override // java.lang.Runnable
            public void run() {
                DefaultChannelPipeline.this.callHandlerAdded0(newCtx);
            }
        });
    }

    protected void onUnhandledInboundException(Throwable cause) {
        try {
            logger.warn("An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.", cause);
        } finally {
            ReferenceCountUtil.release(cause);
        }
    }

    protected void onUnhandledInboundChannelActive() {
    }

    protected void onUnhandledInboundChannelInactive() {
    }

    protected void onUnhandledInboundMessage(Object msg) {
        try {
            logger.debug("Discarded inbound message {} that reached at the tail of the pipeline. Please check your pipeline configuration.", msg);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    protected void onUnhandledInboundMessage(ChannelHandlerContext ctx, Object msg) {
        onUnhandledInboundMessage(msg);
        if (logger.isDebugEnabled()) {
            logger.debug("Discarded message pipeline : {}. Channel : {}.", ctx.pipeline().names(), ctx.channel());
        }
    }

    protected void onUnhandledInboundChannelReadComplete() {
    }

    protected void onUnhandledInboundUserEventTriggered(Object evt) {
        ReferenceCountUtil.release(evt);
    }

    protected void onUnhandledChannelWritabilityChanged() {
    }

    /* access modifiers changed from: protected */
    public void incrementPendingOutboundBytes(long size) {
        ChannelOutboundBuffer buffer = this.channel.unsafe().outboundBuffer();
        if (buffer != null) {
            buffer.incrementPendingOutboundBytes(size);
        }
    }

    /* access modifiers changed from: protected */
    public void decrementPendingOutboundBytes(long size) {
        ChannelOutboundBuffer buffer = this.channel.unsafe().outboundBuffer();
        if (buffer != null) {
            buffer.decrementPendingOutboundBytes(size);
        }
    }

    /* renamed from: io.netty.channel.DefaultChannelPipeline$TailContext */
    /* loaded from: grasscutter.jar:io/netty/channel/DefaultChannelPipeline$TailContext.class */
    final class TailContext extends AbstractChannelHandlerContext implements ChannelInboundHandler {
        TailContext(DefaultChannelPipeline pipeline) {
            super(pipeline, null, DefaultChannelPipeline.TAIL_NAME, TailContext.class);
            setAddComplete();
        }

        @Override // p013io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this;
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelRegistered(ChannelHandlerContext ctx) {
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelUnregistered(ChannelHandlerContext ctx) {
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext ctx) {
            DefaultChannelPipeline.this.onUnhandledInboundChannelActive();
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext ctx) {
            DefaultChannelPipeline.this.onUnhandledInboundChannelInactive();
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelWritabilityChanged(ChannelHandlerContext ctx) {
            DefaultChannelPipeline.this.onUnhandledChannelWritabilityChanged();
        }

        @Override // p013io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext ctx) {
        }

        @Override // p013io.netty.channel.ChannelHandler
        public void handlerRemoved(ChannelHandlerContext ctx) {
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
            DefaultChannelPipeline.this.onUnhandledInboundUserEventTriggered(evt);
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            DefaultChannelPipeline.this.onUnhandledInboundException(cause);
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            DefaultChannelPipeline.this.onUnhandledInboundMessage(ctx, msg);
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelReadComplete(ChannelHandlerContext ctx) {
            DefaultChannelPipeline.this.onUnhandledInboundChannelReadComplete();
        }
    }

    /* renamed from: io.netty.channel.DefaultChannelPipeline$HeadContext */
    /* loaded from: grasscutter.jar:io/netty/channel/DefaultChannelPipeline$HeadContext.class */
    final class HeadContext extends AbstractChannelHandlerContext implements ChannelOutboundHandler, ChannelInboundHandler {
        private final Channel.Unsafe unsafe;

        HeadContext(DefaultChannelPipeline pipeline) {
            super(pipeline, null, DefaultChannelPipeline.HEAD_NAME, HeadContext.class);
            this.unsafe = pipeline.channel().unsafe();
            setAddComplete();
        }

        @Override // p013io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this;
        }

        @Override // p013io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext ctx) {
        }

        @Override // p013io.netty.channel.ChannelHandler
        public void handlerRemoved(ChannelHandlerContext ctx) {
        }

        @Override // p013io.netty.channel.ChannelOutboundHandler
        public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) {
            this.unsafe.bind(localAddress, promise);
        }

        @Override // p013io.netty.channel.ChannelOutboundHandler
        public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
            this.unsafe.connect(remoteAddress, localAddress, promise);
        }

        @Override // p013io.netty.channel.ChannelOutboundHandler
        public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) {
            this.unsafe.disconnect(promise);
        }

        @Override // p013io.netty.channel.ChannelOutboundHandler
        public void close(ChannelHandlerContext ctx, ChannelPromise promise) {
            this.unsafe.close(promise);
        }

        @Override // p013io.netty.channel.ChannelOutboundHandler
        public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) {
            this.unsafe.deregister(promise);
        }

        @Override // p013io.netty.channel.ChannelOutboundHandler
        public void read(ChannelHandlerContext ctx) {
            this.unsafe.beginRead();
        }

        @Override // p013io.netty.channel.ChannelOutboundHandler
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
            this.unsafe.write(msg, promise);
        }

        @Override // p013io.netty.channel.ChannelOutboundHandler
        public void flush(ChannelHandlerContext ctx) {
            this.unsafe.flush();
        }

        @Override // p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            ctx.fireExceptionCaught(cause);
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelRegistered(ChannelHandlerContext ctx) {
            DefaultChannelPipeline.this.invokeHandlerAddedIfNeeded();
            ctx.fireChannelRegistered();
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelUnregistered(ChannelHandlerContext ctx) {
            ctx.fireChannelUnregistered();
            if (!DefaultChannelPipeline.this.channel.isOpen()) {
                DefaultChannelPipeline.this.destroy();
            }
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext ctx) {
            ctx.fireChannelActive();
            readIfIsAutoRead();
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext ctx) {
            ctx.fireChannelInactive();
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            ctx.fireChannelRead(msg);
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelReadComplete(ChannelHandlerContext ctx) {
            ctx.fireChannelReadComplete();
            readIfIsAutoRead();
        }

        private void readIfIsAutoRead() {
            if (DefaultChannelPipeline.this.channel.config().isAutoRead()) {
                DefaultChannelPipeline.this.channel.read();
            }
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
            ctx.fireUserEventTriggered(evt);
        }

        @Override // p013io.netty.channel.ChannelInboundHandler
        public void channelWritabilityChanged(ChannelHandlerContext ctx) {
            ctx.fireChannelWritabilityChanged();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.DefaultChannelPipeline$PendingHandlerCallback */
    /* loaded from: grasscutter.jar:io/netty/channel/DefaultChannelPipeline$PendingHandlerCallback.class */
    public static abstract class PendingHandlerCallback implements Runnable {
        final AbstractChannelHandlerContext ctx;
        PendingHandlerCallback next;

        abstract void execute();

        PendingHandlerCallback(AbstractChannelHandlerContext ctx) {
            this.ctx = ctx;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.DefaultChannelPipeline$PendingHandlerAddedTask */
    /* loaded from: grasscutter.jar:io/netty/channel/DefaultChannelPipeline$PendingHandlerAddedTask.class */
    public final class PendingHandlerAddedTask extends PendingHandlerCallback {
        PendingHandlerAddedTask(AbstractChannelHandlerContext ctx) {
            super(ctx);
        }

        @Override // java.lang.Runnable
        public void run() {
            DefaultChannelPipeline.this.callHandlerAdded0(this.ctx);
        }

        @Override // p013io.netty.channel.DefaultChannelPipeline.PendingHandlerCallback
        void execute() {
            EventExecutor executor = this.ctx.executor();
            if (executor.inEventLoop()) {
                DefaultChannelPipeline.this.callHandlerAdded0(this.ctx);
                return;
            }
            try {
                executor.execute(this);
            } catch (RejectedExecutionException e) {
                if (DefaultChannelPipeline.logger.isWarnEnabled()) {
                    DefaultChannelPipeline.logger.warn("Can't invoke handlerAdded() as the EventExecutor {} rejected it, removing handler {}.", executor, this.ctx.name(), e);
                }
                DefaultChannelPipeline.this.atomicRemoveFromHandlerList(this.ctx);
                this.ctx.setRemoved();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.DefaultChannelPipeline$PendingHandlerRemovedTask */
    /* loaded from: grasscutter.jar:io/netty/channel/DefaultChannelPipeline$PendingHandlerRemovedTask.class */
    public final class PendingHandlerRemovedTask extends PendingHandlerCallback {
        PendingHandlerRemovedTask(AbstractChannelHandlerContext ctx) {
            super(ctx);
        }

        @Override // java.lang.Runnable
        public void run() {
            DefaultChannelPipeline.this.callHandlerRemoved0(this.ctx);
        }

        @Override // p013io.netty.channel.DefaultChannelPipeline.PendingHandlerCallback
        void execute() {
            EventExecutor executor = this.ctx.executor();
            if (executor.inEventLoop()) {
                DefaultChannelPipeline.this.callHandlerRemoved0(this.ctx);
                return;
            }
            try {
                executor.execute(this);
            } catch (RejectedExecutionException e) {
                if (DefaultChannelPipeline.logger.isWarnEnabled()) {
                    DefaultChannelPipeline.logger.warn("Can't invoke handlerRemoved() as the EventExecutor {} rejected it, removing handler {}.", executor, this.ctx.name(), e);
                }
                this.ctx.setRemoved();
            }
        }
    }
}
