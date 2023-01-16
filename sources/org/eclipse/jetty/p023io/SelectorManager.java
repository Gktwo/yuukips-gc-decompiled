package org.eclipse.jetty.p023io;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import org.eclipse.jetty.p023io.ManagedSelector;
import org.eclipse.jetty.util.ProcessorUtils;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.util.thread.ThreadPoolBudget;
import p013io.netty.handler.traffic.AbstractTrafficShapingHandler;

@ManagedObject("Manager of the NIO Selectors")
/* renamed from: org.eclipse.jetty.io.SelectorManager */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/SelectorManager.class */
public abstract class SelectorManager extends ContainerLifeCycle implements Dumpable {
    public static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    protected static final Logger LOG = Log.getLogger(SelectorManager.class);
    private final Executor executor;
    private final Scheduler scheduler;
    private final ManagedSelector[] _selectors;
    private final AtomicInteger _selectorIndex;
    private final IntUnaryOperator _selectorIndexUpdate;
    private final List<AcceptListener> _acceptListeners;
    private long _connectTimeout;
    private ThreadPoolBudget.Lease _lease;

    /* access modifiers changed from: protected */
    public abstract EndPoint newEndPoint(SelectableChannel selectableChannel, ManagedSelector managedSelector, SelectionKey selectionKey) throws IOException;

    public abstract Connection newConnection(SelectableChannel selectableChannel, EndPoint endPoint, Object obj) throws IOException;

    private static int defaultSelectors(Executor executor) {
        if (!(executor instanceof ThreadPool.SizedThreadPool)) {
            return Math.max(1, ProcessorUtils.availableProcessors() / 2);
        }
        return Math.max(1, Math.min(ProcessorUtils.availableProcessors() / 2, ((ThreadPool.SizedThreadPool) executor).getMaxThreads() / 16));
    }

    protected SelectorManager(Executor executor, Scheduler scheduler) {
        this(executor, scheduler, -1);
    }

    /* access modifiers changed from: protected */
    public SelectorManager(Executor executor, Scheduler scheduler, int selectors) {
        this._selectorIndex = new AtomicInteger();
        this._acceptListeners = new ArrayList();
        this._connectTimeout = AbstractTrafficShapingHandler.DEFAULT_MAX_TIME;
        selectors = selectors <= 0 ? defaultSelectors(executor) : selectors;
        this.executor = executor;
        this.scheduler = scheduler;
        this._selectors = new ManagedSelector[selectors];
        this._selectorIndexUpdate = index -> {
            return (index + 1) % this._selectors.length;
        };
    }

    @ManagedAttribute("The Executor")
    public Executor getExecutor() {
        return this.executor;
    }

    @ManagedAttribute("The Scheduler")
    public Scheduler getScheduler() {
        return this.scheduler;
    }

    @ManagedAttribute("The Connection timeout (ms)")
    public long getConnectTimeout() {
        return this._connectTimeout;
    }

    public void setConnectTimeout(long milliseconds) {
        this._connectTimeout = milliseconds;
    }

    @Deprecated
    public int getReservedThreads() {
        return -1;
    }

    @Deprecated
    public void setReservedThreads(int threads) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public void execute(Runnable task) {
        this.executor.execute(task);
    }

    @ManagedAttribute("The number of NIO Selectors")
    public int getSelectorCount() {
        return this._selectors.length;
    }

    private ManagedSelector chooseSelector() {
        return this._selectors[this._selectorIndex.updateAndGet(this._selectorIndexUpdate)];
    }

    public void connect(SelectableChannel channel, Object attachment) {
        ManagedSelector set = chooseSelector();
        Objects.requireNonNull(set);
        set.submit(new ManagedSelector.Connect(channel, attachment));
    }

    public void accept(SelectableChannel channel) {
        accept(channel, null);
    }

    public void accept(SelectableChannel channel, Object attachment) {
        ManagedSelector selector = chooseSelector();
        Objects.requireNonNull(selector);
        selector.submit(new ManagedSelector.Accept(channel, attachment));
    }

    public Closeable acceptor(SelectableChannel server) {
        ManagedSelector selector = chooseSelector();
        Objects.requireNonNull(selector);
        ManagedSelector.Acceptor acceptor = new ManagedSelector.Acceptor(server);
        selector.submit(acceptor);
        return acceptor;
    }

    /* access modifiers changed from: protected */
    public void accepted(SelectableChannel channel) throws IOException {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this._lease = ThreadPoolBudget.leaseFrom(getExecutor(), this, this._selectors.length);
        for (int i = 0; i < this._selectors.length; i++) {
            ManagedSelector selector = newSelector(i);
            this._selectors[i] = selector;
            addBean(selector);
        }
        doStart();
    }

    protected ManagedSelector newSelector(int id) {
        return new ManagedSelector(this, id);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        try {
            doStop();
            ManagedSelector[] managedSelectorArr = this._selectors;
            for (ManagedSelector selector : managedSelectorArr) {
                if (selector != null) {
                    removeBean(selector);
                }
            }
            Arrays.fill(this._selectors, (Object) null);
            if (this._lease != null) {
                this._lease.close();
            }
        } catch (Throwable th) {
            ManagedSelector[] managedSelectorArr2 = this._selectors;
            for (ManagedSelector selector2 : managedSelectorArr2) {
                if (selector2 != null) {
                    removeBean(selector2);
                }
            }
            Arrays.fill(this._selectors, (Object) null);
            if (this._lease != null) {
                this._lease.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void endPointOpened(EndPoint endpoint) {
    }

    /* access modifiers changed from: protected */
    public void endPointClosed(EndPoint endpoint) {
    }

    public void connectionOpened(Connection connection) {
        try {
            connection.onOpen();
        } catch (Throwable x) {
            if (isRunning()) {
                LOG.warn("Exception while notifying connection " + connection, x);
            } else {
                LOG.debug("Exception while notifying connection " + connection, x);
            }
            throw x;
        }
    }

    public void connectionClosed(Connection connection) {
        try {
            connection.onClose();
        } catch (Throwable x) {
            LOG.debug("Exception while notifying connection " + connection, x);
        }
    }

    /* access modifiers changed from: protected */
    public boolean doFinishConnect(SelectableChannel channel) throws IOException {
        return ((SocketChannel) channel).finishConnect();
    }

    /* access modifiers changed from: protected */
    public boolean isConnectionPending(SelectableChannel channel) {
        return ((SocketChannel) channel).isConnectionPending();
    }

    /* access modifiers changed from: protected */
    public SelectableChannel doAccept(SelectableChannel server) throws IOException {
        return ((ServerSocketChannel) server).accept();
    }

    /* access modifiers changed from: protected */
    public void connectionFailed(SelectableChannel channel, Throwable ex, Object attachment) {
        LOG.warn(String.format("%s - %s", channel, attachment), ex);
    }

    /* access modifiers changed from: protected */
    public Selector newSelector() throws IOException {
        return Selector.open();
    }

    public void addEventListener(EventListener listener) {
        if (isRunning()) {
            throw new IllegalStateException(toString());
        } else if (listener instanceof AcceptListener) {
            addAcceptListener((AcceptListener) listener);
        }
    }

    public void removeEventListener(EventListener listener) {
        if (isRunning()) {
            throw new IllegalStateException(toString());
        } else if (listener instanceof AcceptListener) {
            removeAcceptListener((AcceptListener) listener);
        }
    }

    public void addAcceptListener(AcceptListener listener) {
        if (!this._acceptListeners.contains(listener)) {
            this._acceptListeners.add(listener);
        }
    }

    public void removeAcceptListener(AcceptListener listener) {
        this._acceptListeners.remove(listener);
    }

    /* access modifiers changed from: protected */
    public void onAccepting(SelectableChannel channel) {
        for (AcceptListener l : this._acceptListeners) {
            try {
                l.onAccepting(channel);
            } catch (Throwable x) {
                LOG.warn(x);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAcceptFailed(SelectableChannel channel, Throwable cause) {
        for (AcceptListener l : this._acceptListeners) {
            try {
                l.onAcceptFailed(channel, cause);
            } catch (Throwable x) {
                LOG.warn(x);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAccepted(SelectableChannel channel) {
        for (AcceptListener l : this._acceptListeners) {
            try {
                l.onAccepted(channel);
            } catch (Throwable x) {
                LOG.warn(x);
            }
        }
    }

    /* renamed from: org.eclipse.jetty.io.SelectorManager$AcceptListener */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/SelectorManager$AcceptListener.class */
    public interface AcceptListener extends EventListener {
        default void onAccepting(SelectableChannel channel) {
        }

        default void onAcceptFailed(SelectableChannel channel, Throwable cause) {
        }

        default void onAccepted(SelectableChannel channel) {
        }
    }
}
