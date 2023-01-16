package org.eclipse.jetty.server;

import java.io.IOException;
import java.nio.channels.ClosedByInterruptException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;
import org.eclipse.jetty.p023io.ArrayByteBufferPool;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.util.ProcessorUtils;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.Container;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.Graceful;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Locker;
import org.eclipse.jetty.util.thread.ScheduledExecutorScheduler;
import org.eclipse.jetty.util.thread.Scheduler;
import org.eclipse.jetty.util.thread.ThreadPoolBudget;

@ManagedObject("Abstract implementation of the Connector Interface")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/AbstractConnector.class */
public abstract class AbstractConnector extends ContainerLifeCycle implements Connector, Dumpable {
    protected static final Logger LOG = Log.getLogger(AbstractConnector.class);
    private final Server _server;
    private final Executor _executor;
    private final Scheduler _scheduler;
    private final ByteBufferPool _byteBufferPool;
    private final Thread[] _acceptors;
    private CountDownLatch _stopping;
    private String _defaultProtocol;
    private ConnectionFactory _defaultConnectionFactory;
    private String _name;
    private ThreadPoolBudget.Lease _lease;
    private final Locker _locker = new Locker();
    private final Condition _setAccepting = this._locker.newCondition();
    private final Map<String, ConnectionFactory> _factories = new LinkedHashMap();
    private final Set<EndPoint> _endpoints = Collections.newSetFromMap(new ConcurrentHashMap());
    private final Set<EndPoint> _immutableEndPoints = Collections.unmodifiableSet(this._endpoints);
    private final Graceful.Shutdown _shutdown = new Graceful.Shutdown();
    private HttpChannel.Listener _httpChannelListeners = HttpChannel.NOOP_LISTENER;
    private long _idleTimeout = 30000;
    private int _acceptorPriorityDelta = -2;
    private boolean _accepting = true;

    protected abstract void accept(int i) throws IOException, InterruptedException;

    public AbstractConnector(Server server, Executor executor, Scheduler scheduler, ByteBufferPool pool, int acceptors, ConnectionFactory... factories) {
        this._server = server;
        this._executor = executor != null ? executor : this._server.getThreadPool();
        scheduler = scheduler == null ? (Scheduler) this._server.getBean((Class<Object>) Scheduler.class) : scheduler;
        this._scheduler = scheduler != null ? scheduler : new ScheduledExecutorScheduler(String.format("Connector-Scheduler-%x", Integer.valueOf(hashCode())), false);
        pool = pool == null ? (ByteBufferPool) this._server.getBean((Class<Object>) ByteBufferPool.class) : pool;
        this._byteBufferPool = pool != null ? pool : new ArrayByteBufferPool();
        addEventListener(new Container.Listener() { // from class: org.eclipse.jetty.server.AbstractConnector.1
            @Override // org.eclipse.jetty.util.component.Container.Listener
            public void beanAdded(Container parent, Object bean) {
                if (bean instanceof HttpChannel.Listener) {
                    AbstractConnector.this._httpChannelListeners = new HttpChannelListeners(AbstractConnector.this.getBeans(HttpChannel.Listener.class));
                }
            }

            @Override // org.eclipse.jetty.util.component.Container.Listener
            public void beanRemoved(Container parent, Object bean) {
                if (bean instanceof HttpChannel.Listener) {
                    AbstractConnector.this._httpChannelListeners = new HttpChannelListeners(AbstractConnector.this.getBeans(HttpChannel.Listener.class));
                }
            }
        });
        addBean((Object) this._server, false);
        addBean(this._executor);
        if (executor == null) {
            unmanage(this._executor);
        }
        addBean(this._scheduler);
        addBean(this._byteBufferPool);
        for (ConnectionFactory factory : factories) {
            addConnectionFactory(factory);
        }
        int cores = ProcessorUtils.availableProcessors();
        acceptors = acceptors < 0 ? Math.max(1, Math.min(4, cores / 8)) : acceptors;
        if (acceptors > cores) {
            LOG.warn("Acceptors should be <= availableProcessors: " + this, new Object[0]);
        }
        this._acceptors = new Thread[acceptors];
    }

    public HttpChannel.Listener getHttpChannelListeners() {
        return this._httpChannelListeners;
    }

    @Override // org.eclipse.jetty.server.Connector
    public Server getServer() {
        return this._server;
    }

    @Override // org.eclipse.jetty.server.Connector
    public Executor getExecutor() {
        return this._executor;
    }

    @Override // org.eclipse.jetty.server.Connector
    public ByteBufferPool getByteBufferPool() {
        return this._byteBufferPool;
    }

    @Override // org.eclipse.jetty.server.Connector
    @ManagedAttribute("The connection idle timeout in milliseconds")
    public long getIdleTimeout() {
        return this._idleTimeout;
    }

    public void setIdleTimeout(long idleTimeout) {
        this._idleTimeout = idleTimeout;
    }

    @ManagedAttribute("number of acceptor threads")
    public int getAcceptors() {
        return this._acceptors.length;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this._shutdown.cancel();
        if (this._defaultProtocol == null) {
            throw new IllegalStateException("No default protocol for " + this);
        }
        this._defaultConnectionFactory = getConnectionFactory(this._defaultProtocol);
        if (this._defaultConnectionFactory == null) {
            throw new IllegalStateException("No protocol factory for default protocol '" + this._defaultProtocol + "' in " + this);
        }
        SslConnectionFactory ssl = (SslConnectionFactory) getConnectionFactory(SslConnectionFactory.class);
        if (ssl != null) {
            String next = ssl.getNextProtocol();
            if (getConnectionFactory(next) == null) {
                throw new IllegalStateException("No protocol factory for SSL next protocol: '" + next + "' in " + this);
            }
        }
        this._lease = ThreadPoolBudget.leaseFrom(getExecutor(), this, this._acceptors.length);
        doStart();
        this._stopping = new CountDownLatch(this._acceptors.length);
        for (int i = 0; i < this._acceptors.length; i++) {
            Acceptor a = new Acceptor(i);
            addBean(a);
            getExecutor().execute(a);
        }
        LOG.info("Started {}", this);
    }

    protected void interruptAcceptors() {
        Locker.Lock lock = this._locker.lock();
        try {
            Thread[] threadArr = this._acceptors;
            for (Thread thread : threadArr) {
                if (thread != null) {
                    thread.interrupt();
                }
            }
            if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.util.component.Graceful
    public Future<Void> shutdown() {
        return this._shutdown.shutdown();
    }

    @Override // org.eclipse.jetty.util.component.Graceful
    public boolean isShutdown() {
        return this._shutdown.isShutdown();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        if (this._lease != null) {
            this._lease.close();
        }
        interruptAcceptors();
        long stopTimeout = getStopTimeout();
        CountDownLatch stopping = this._stopping;
        if (stopTimeout > 0 && stopping != null && getAcceptors() > 0) {
            stopping.await(stopTimeout, TimeUnit.MILLISECONDS);
        }
        this._stopping = null;
        doStop();
        for (Acceptor a : getBeans(Acceptor.class)) {
            removeBean(a);
        }
        LOG.info("Stopped {}", this);
    }

    public void join() throws InterruptedException {
        join(0);
    }

    public void join(long timeout) throws InterruptedException {
        Locker.Lock lock = this._locker.lock();
        try {
            Thread[] threadArr = this._acceptors;
            for (Thread thread : threadArr) {
                if (thread != null) {
                    thread.join(timeout);
                }
            }
            if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean isAccepting() {
        Locker.Lock lock = this._locker.lock();
        try {
            boolean z = this._accepting;
            if (lock != null) {
                lock.close();
            }
            return z;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void setAccepting(boolean accepting) {
        Locker.Lock lock = this._locker.lock();
        try {
            this._accepting = accepting;
            this._setAccepting.signalAll();
            if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.server.Connector
    public ConnectionFactory getConnectionFactory(String protocol) {
        Locker.Lock lock = this._locker.lock();
        try {
            ConnectionFactory connectionFactory = this._factories.get(StringUtil.asciiToLowerCase(protocol));
            if (lock != null) {
                lock.close();
            }
            return connectionFactory;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.server.Connector
    public <T> T getConnectionFactory(Class<T> factoryType) {
        Locker.Lock lock = this._locker.lock();
        try {
            Iterator<ConnectionFactory> it = this._factories.values().iterator();
            while (it.hasNext()) {
                T t = (T) it.next();
                if (factoryType.isAssignableFrom(t.getClass())) {
                    if (lock != null) {
                        lock.close();
                    }
                    return t;
                }
            }
            if (lock != null) {
                lock.close();
            }
            return null;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void addConnectionFactory(ConnectionFactory factory) {
        if (isRunning()) {
            throw new IllegalStateException(getState());
        }
        Set<ConnectionFactory> toRemove = new HashSet<>();
        for (String key : factory.getProtocols()) {
            String key2 = StringUtil.asciiToLowerCase(key);
            ConnectionFactory old = this._factories.remove(key2);
            if (old != null) {
                if (old.getProtocol().equals(this._defaultProtocol)) {
                    this._defaultProtocol = null;
                }
                toRemove.add(old);
            }
            this._factories.put(key2, factory);
        }
        for (ConnectionFactory f : this._factories.values()) {
            toRemove.remove(f);
        }
        for (ConnectionFactory old2 : toRemove) {
            removeBean(old2);
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} removed {}", this, old2);
            }
        }
        addBean(factory);
        if (this._defaultProtocol == null) {
            this._defaultProtocol = factory.getProtocol();
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} added {}", this, factory);
        }
    }

    public void addFirstConnectionFactory(ConnectionFactory factory) {
        if (isRunning()) {
            throw new IllegalStateException(getState());
        }
        List<ConnectionFactory> existings = new ArrayList<>(this._factories.values());
        this._factories.clear();
        addConnectionFactory(factory);
        for (ConnectionFactory existing : existings) {
            addConnectionFactory(existing);
        }
        this._defaultProtocol = factory.getProtocol();
    }

    public void addIfAbsentConnectionFactory(ConnectionFactory factory) {
        if (isRunning()) {
            throw new IllegalStateException(getState());
        }
        String key = StringUtil.asciiToLowerCase(factory.getProtocol());
        if (!this._factories.containsKey(key)) {
            this._factories.put(key, factory);
            addBean(factory);
            if (this._defaultProtocol == null) {
                this._defaultProtocol = factory.getProtocol();
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} addIfAbsent added {}", this, factory);
            }
        } else if (LOG.isDebugEnabled()) {
            LOG.debug("{} addIfAbsent ignored {}", this, factory);
        }
    }

    public ConnectionFactory removeConnectionFactory(String protocol) {
        if (isRunning()) {
            throw new IllegalStateException(getState());
        }
        ConnectionFactory factory = this._factories.remove(StringUtil.asciiToLowerCase(protocol));
        removeBean(factory);
        return factory;
    }

    @Override // org.eclipse.jetty.server.Connector
    public Collection<ConnectionFactory> getConnectionFactories() {
        return this._factories.values();
    }

    public void setConnectionFactories(Collection<ConnectionFactory> factories) {
        if (isRunning()) {
            throw new IllegalStateException(getState());
        }
        for (ConnectionFactory factory : new ArrayList<>(this._factories.values())) {
            removeConnectionFactory(factory.getProtocol());
        }
        for (ConnectionFactory factory2 : factories) {
            if (factory2 != null) {
                addConnectionFactory(factory2);
            }
        }
    }

    @ManagedAttribute("The priority delta to apply to acceptor threads")
    public int getAcceptorPriorityDelta() {
        return this._acceptorPriorityDelta;
    }

    public void setAcceptorPriorityDelta(int acceptorPriorityDelta) {
        int old = this._acceptorPriorityDelta;
        this._acceptorPriorityDelta = acceptorPriorityDelta;
        if (old != acceptorPriorityDelta && isStarted()) {
            Thread[] threadArr = this._acceptors;
            for (Thread thread : threadArr) {
                thread.setPriority(Math.max(1, Math.min(10, (thread.getPriority() - old) + acceptorPriorityDelta)));
            }
        }
    }

    @Override // org.eclipse.jetty.server.Connector
    @ManagedAttribute("Protocols supported by this connector")
    public List<String> getProtocols() {
        return new ArrayList(this._factories.keySet());
    }

    public void clearConnectionFactories() {
        if (isRunning()) {
            throw new IllegalStateException(getState());
        }
        this._factories.clear();
    }

    @ManagedAttribute("This connector's default protocol")
    public String getDefaultProtocol() {
        return this._defaultProtocol;
    }

    public void setDefaultProtocol(String defaultProtocol) {
        this._defaultProtocol = StringUtil.asciiToLowerCase(defaultProtocol);
        if (isRunning()) {
            this._defaultConnectionFactory = getConnectionFactory(this._defaultProtocol);
        }
    }

    @Override // org.eclipse.jetty.server.Connector
    public ConnectionFactory getDefaultConnectionFactory() {
        if (isStarted()) {
            return this._defaultConnectionFactory;
        }
        return getConnectionFactory(this._defaultProtocol);
    }

    /* access modifiers changed from: protected */
    public boolean handleAcceptFailure(Throwable ex) {
        if (!isRunning()) {
            LOG.ignore(ex);
            return false;
        } else if (ex instanceof InterruptedException) {
            LOG.debug(ex);
            return true;
        } else if (ex instanceof ClosedByInterruptException) {
            LOG.debug(ex);
            return false;
        } else {
            LOG.warn(ex);
            try {
                Thread.sleep(1000);
                return true;
            } catch (Throwable x) {
                LOG.ignore(x);
                return false;
            }
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/AbstractConnector$Acceptor.class */
    private class Acceptor implements Runnable {
        private final int _id;
        private String _name;

        private Acceptor(int id) {
            this._id = id;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:20:0x00c2
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
            // Method dump skipped, instructions count: 420
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.AbstractConnector.Acceptor.run():void");
        }

        @Override // java.lang.Object
        public String toString() {
            String name = this._name;
            if (name == null) {
                return String.format("acceptor-%d@%x", Integer.valueOf(this._id), Integer.valueOf(hashCode()));
            }
            return name;
        }
    }

    @Override // org.eclipse.jetty.server.Connector
    public Collection<EndPoint> getConnectedEndPoints() {
        return this._immutableEndPoints;
    }

    protected void onEndPointOpened(EndPoint endp) {
        this._endpoints.add(endp);
    }

    protected void onEndPointClosed(EndPoint endp) {
        this._endpoints.remove(endp);
    }

    @Override // org.eclipse.jetty.server.Connector
    public Scheduler getScheduler() {
        return this._scheduler;
    }

    @Override // org.eclipse.jetty.server.Connector
    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = this._name == null ? getClass().getSimpleName() : this._name;
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = getDefaultProtocol();
        objArr[3] = getProtocols().stream().collect(Collectors.joining(", ", "(", ")"));
        return String.format("%s@%x{%s, %s}", objArr);
    }
}
