package org.eclipse.jetty.p023io;

import java.io.Closeable;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.jetty.util.C5747IO;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.statistic.SampleStatistic;
import org.eclipse.jetty.util.thread.ExecutionStrategy;
import org.eclipse.jetty.util.thread.Scheduler;
import org.eclipse.jetty.util.thread.strategy.EatWhatYouKill;

/* renamed from: org.eclipse.jetty.io.ManagedSelector */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector.class */
public class ManagedSelector extends ContainerLifeCycle implements Dumpable {
    private static final Logger LOG = Log.getLogger(ManagedSelector.class);
    private static final boolean FORCE_SELECT_NOW;
    private boolean _selecting;
    private final SelectorManager _selectorManager;
    private final int _id;
    private final ExecutionStrategy _strategy;
    private Selector _selector;
    private final AtomicBoolean _started = new AtomicBoolean(false);
    private Deque<SelectorUpdate> _updates = new ArrayDeque();
    private Deque<SelectorUpdate> _updateable = new ArrayDeque();
    private final SampleStatistic _keyStats = new SampleStatistic();

    /* renamed from: org.eclipse.jetty.io.ManagedSelector$Selectable */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector$Selectable.class */
    public interface Selectable {
        Runnable onSelected();

        void updateKey();

        void replaceKey(SelectionKey selectionKey);
    }

    /* renamed from: org.eclipse.jetty.io.ManagedSelector$SelectorUpdate */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector$SelectorUpdate.class */
    public interface SelectorUpdate {
        void update(Selector selector);
    }

    static {
        String property = System.getProperty("org.eclipse.jetty.io.forceSelectNow");
        if (property != null) {
            FORCE_SELECT_NOW = Boolean.parseBoolean(property);
            return;
        }
        String property2 = System.getProperty("os.name");
        FORCE_SELECT_NOW = property2 != null && property2.toLowerCase(Locale.ENGLISH).contains("windows");
    }

    public ManagedSelector(SelectorManager selectorManager, int id) {
        this._selectorManager = selectorManager;
        this._id = id;
        this._strategy = new EatWhatYouKill(new SelectorProducer(), selectorManager.getExecutor());
        addBean((Object) this._strategy, true);
        setStopTimeout(5000);
    }

    public Selector getSelector() {
        return this._selector;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        doStart();
        this._selector = this._selectorManager.newSelector();
        SelectorManager selectorManager = this._selectorManager;
        ExecutionStrategy executionStrategy = this._strategy;
        Objects.requireNonNull(executionStrategy);
        selectorManager.execute(this::produce);
        Start start = new Start();
        submit(start);
        start._started.await();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        if (this._started.compareAndSet(true, false) && this._selector != null) {
            CloseConnections closeConnections = new CloseConnections();
            submit(closeConnections);
            closeConnections._complete.await();
            StopSelector stopSelector = new StopSelector();
            submit(stopSelector);
            stopSelector._stopped.await();
        }
        doStop();
    }

    @ManagedAttribute(value = "Total number of keys", readonly = true)
    public int getTotalKeys() {
        return this._selector.keys().size();
    }

    @ManagedAttribute(value = "Average number of selected keys", readonly = true)
    public double getAverageSelectedKeys() {
        return this._keyStats.getMean();
    }

    @ManagedAttribute(value = "Maximum number of selected keys", readonly = true)
    public double getMaxSelectedKeys() {
        return (double) this._keyStats.getMax();
    }

    @ManagedAttribute(value = "Total number of select() calls", readonly = true)
    public long getSelectCount() {
        return this._keyStats.getCount();
    }

    @ManagedOperation(value = "Resets the statistics", impact = "ACTION")
    public void resetStats() {
        this._keyStats.reset();
    }

    protected int nioSelect(Selector selector, boolean now) throws IOException {
        return now ? selector.selectNow() : selector.select();
    }

    protected int select(Selector selector) throws IOException {
        try {
            int selected = nioSelect(selector, false);
            if (selected == 0) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Selector {} woken with none selected", selector);
                }
                if (Thread.interrupted() && !isRunning()) {
                    throw new ClosedSelectorException();
                } else if (FORCE_SELECT_NOW) {
                    selected = nioSelect(selector, true);
                }
            }
            return selected;
        } catch (ClosedSelectorException x) {
            throw x;
        } catch (Throwable x2) {
            handleSelectFailure(selector, x2);
            return 0;
        }
    }

    protected void handleSelectFailure(Selector selector, Throwable failure) throws IOException {
        LOG.info("Caught select() failure, trying to recover: {}", failure.toString());
        if (LOG.isDebugEnabled()) {
            LOG.debug(failure);
        }
        Selector newSelector = this._selectorManager.newSelector();
        for (SelectionKey oldKey : selector.keys()) {
            SelectableChannel channel = oldKey.channel();
            int interestOps = safeInterestOps(oldKey);
            if (interestOps >= 0) {
                try {
                    Object attachment = oldKey.attachment();
                    SelectionKey newKey = channel.register(newSelector, interestOps, attachment);
                    if (attachment instanceof Selectable) {
                        ((Selectable) attachment).replaceKey(newKey);
                    }
                    oldKey.cancel();
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Transferred {} iOps={} att={}", channel, Integer.valueOf(interestOps), attachment);
                    }
                } catch (Throwable t) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Could not transfer {}", channel, t);
                    }
                    C5747IO.close(channel);
                }
            } else {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Invalid interestOps for {}", channel);
                }
                C5747IO.close(channel);
            }
        }
        C5747IO.close(selector);
        this._selector = newSelector;
    }

    protected void onSelectFailed(Throwable cause) {
    }

    public int size() {
        Set<SelectionKey> keys;
        Selector s = this._selector;
        if (s == null || (keys = s.keys()) == null) {
            return 0;
        }
        return keys.size();
    }

    public void submit(SelectorUpdate update) {
        submit(update, false);
    }

    private void submit(SelectorUpdate update, boolean lazy) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Queued change lazy={} {} on {}", Boolean.valueOf(lazy), update, this);
        }
        Selector selector = null;
        synchronized (this) {
            this._updates.offer(update);
            if (this._selecting && !lazy) {
                selector = this._selector;
                this._selecting = false;
            }
        }
        if (selector != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Wakeup on submit {}", this);
            }
            selector.wakeup();
        }
    }

    private void wakeup() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Wakeup {}", this);
        }
        Selector selector = null;
        synchronized (this) {
            if (this._selecting) {
                selector = this._selector;
                this._selecting = false;
            }
        }
        if (selector != null) {
            selector.wakeup();
        }
    }

    /* access modifiers changed from: private */
    public void execute(Runnable task) {
        try {
            this._selectorManager.execute(task);
        } catch (RejectedExecutionException e) {
            if (task instanceof Closeable) {
                C5747IO.close((Closeable) task);
            }
        }
    }

    /* access modifiers changed from: private */
    public void processConnect(SelectionKey key, Connect connect) {
        SelectableChannel channel = key.channel();
        try {
            key.attach(connect.attachment);
            boolean connected = this._selectorManager.doFinishConnect(channel);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Connected {} {}", Boolean.valueOf(connected), channel);
            }
            if (!connected) {
                throw new ConnectException();
            } else if (connect.timeout.cancel()) {
                key.interestOps(0);
                execute(new CreateEndPoint(connect, key));
            } else {
                throw new SocketTimeoutException("Concurrent Connect Timeout");
            }
        } catch (Throwable x) {
            connect.failed(x);
        }
    }

    protected void endPointOpened(EndPoint endPoint) {
        this._selectorManager.endPointOpened(endPoint);
    }

    protected void endPointClosed(EndPoint endPoint) {
        this._selectorManager.endPointClosed(endPoint);
    }

    /* access modifiers changed from: private */
    public void createEndPoint(SelectableChannel channel, SelectionKey selectionKey) throws IOException {
        EndPoint endPoint = this._selectorManager.newEndPoint(channel, this, selectionKey);
        Connection connection = this._selectorManager.newConnection(channel, endPoint, selectionKey.attachment());
        endPoint.setConnection(connection);
        submit(selector -> {
            SelectionKey key = selectionKey;
            if (key.selector() != selector) {
                key = channel.keyFor(selector);
                if (key != null && (endPoint instanceof Selectable)) {
                    ((Selectable) endPoint).replaceKey(key);
                }
            }
            if (key != null) {
                key.attach(endPoint);
            }
        }, true);
        endPoint.onOpen();
        endPointOpened(endPoint);
        this._selectorManager.connectionOpened(connection);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Created {}", endPoint);
        }
    }

    /* access modifiers changed from: package-private */
    public void destroyEndPoint(EndPoint endPoint) {
        wakeup();
        execute(new DestroyEndPoint(endPoint));
    }

    private int getActionSize() {
        int size;
        synchronized (this) {
            size = this._updates.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public static int safeReadyOps(SelectionKey selectionKey) {
        try {
            return selectionKey.readyOps();
        } catch (Throwable x) {
            LOG.ignore(x);
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public static int safeInterestOps(SelectionKey selectionKey) {
        try {
            return selectionKey.interestOps();
        } catch (Throwable x) {
            LOG.ignore(x);
            return -1;
        }
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        List<SelectorUpdate> updates;
        Selector selector = this._selector;
        if (selector == null || !selector.isOpen()) {
            dumpObjects(out, indent, new Object[0]);
            return;
        }
        DumpKeys dump = new DumpKeys();
        String updatesAt = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now());
        synchronized (this) {
            updates = new ArrayList<>(this._updates);
            this._updates.addFirst(dump);
            this._selecting = false;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("wakeup on dump {}", this);
        }
        selector.wakeup();
        List<String> keys = dump.get(5, TimeUnit.SECONDS);
        String keysAt = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now());
        if (keys == null) {
            keys = Collections.singletonList("No dump keys retrieved");
        }
        dumpObjects(out, indent, new DumpableCollection("updates @ " + updatesAt, updates), new DumpableCollection("keys @ " + keysAt, keys));
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        Selector selector = this._selector;
        Object[] objArr = new Object[5];
        objArr[0] = toString();
        objArr[1] = Integer.valueOf(this._id);
        objArr[2] = Integer.valueOf((selector == null || !selector.isOpen()) ? -1 : selector.keys().size());
        objArr[3] = Integer.valueOf((selector == null || !selector.isOpen()) ? -1 : selector.selectedKeys().size());
        objArr[4] = Integer.valueOf(getActionSize());
        return String.format("%s id=%s keys=%d selected=%d updates=%d", objArr);
    }

    /* renamed from: org.eclipse.jetty.io.ManagedSelector$SelectorProducer */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector$SelectorProducer.class */
    private class SelectorProducer implements ExecutionStrategy.Producer {
        private Set<SelectionKey> _keys;
        private Iterator<SelectionKey> _cursor;

        private SelectorProducer() {
            this._keys = Collections.emptySet();
            this._cursor = Collections.emptyIterator();
        }

        @Override // org.eclipse.jetty.util.thread.ExecutionStrategy.Producer
        public Runnable produce() {
            do {
                Runnable task = processSelected();
                if (task != null) {
                    return task;
                }
                processUpdates();
                updateKeys();
            } while (select());
            return null;
        }

        private void processUpdates() {
            int updates;
            Selector selector;
            synchronized (ManagedSelector.this) {
                Deque<SelectorUpdate> updates2 = ManagedSelector.this._updates;
                ManagedSelector.this._updates = ManagedSelector.this._updateable;
                ManagedSelector.this._updateable = updates2;
            }
            if (ManagedSelector.LOG.isDebugEnabled()) {
                ManagedSelector.LOG.debug("updateable {}", (long) ManagedSelector.this._updateable.size());
            }
            for (SelectorUpdate update : ManagedSelector.this._updateable) {
                if (ManagedSelector.this._selector == null) {
                    break;
                }
                try {
                    if (ManagedSelector.LOG.isDebugEnabled()) {
                        ManagedSelector.LOG.debug("update {}", update);
                    }
                    update.update(ManagedSelector.this._selector);
                } catch (Throwable ex) {
                    ManagedSelector.LOG.warn(ex);
                }
            }
            ManagedSelector.this._updateable.clear();
            synchronized (ManagedSelector.this) {
                updates = ManagedSelector.this._updates.size();
                ManagedSelector.this._selecting = updates == 0;
                selector = ManagedSelector.this._selecting ? null : ManagedSelector.this._selector;
            }
            if (ManagedSelector.LOG.isDebugEnabled()) {
                ManagedSelector.LOG.debug("updates {}", (long) updates);
            }
            if (selector != null) {
                if (ManagedSelector.LOG.isDebugEnabled()) {
                    ManagedSelector.LOG.debug("wakeup on updates {}", this);
                }
                selector.wakeup();
            }
        }

        private boolean select() {
            int updates;
            try {
                Selector selector = ManagedSelector.this._selector;
                if (selector == null) {
                    return false;
                }
                if (ManagedSelector.LOG.isDebugEnabled()) {
                    ManagedSelector.LOG.debug("Selector {} waiting with {} keys", selector, Integer.valueOf(selector.keys().size()));
                }
                int selected = ManagedSelector.this.select(selector);
                Selector selector2 = ManagedSelector.this._selector;
                if (selector2 == null) {
                    return false;
                }
                if (ManagedSelector.LOG.isDebugEnabled()) {
                    ManagedSelector.LOG.debug("Selector {} woken up from select, {}/{}/{} selected", selector2, Integer.valueOf(selected), Integer.valueOf(selector2.selectedKeys().size()), Integer.valueOf(selector2.keys().size()));
                }
                synchronized (ManagedSelector.this) {
                    ManagedSelector.this._selecting = false;
                    updates = ManagedSelector.this._updates.size();
                }
                this._keys = selector2.selectedKeys();
                int selectedKeys = this._keys.size();
                if (selectedKeys > 0) {
                    ManagedSelector.this._keyStats.record((long) selectedKeys);
                }
                this._cursor = selectedKeys > 0 ? this._keys.iterator() : Collections.emptyIterator();
                if (!ManagedSelector.LOG.isDebugEnabled()) {
                    return true;
                }
                ManagedSelector.LOG.debug("Selector {} processing {} keys, {} updates", selector2, Integer.valueOf(selectedKeys), Integer.valueOf(updates));
                return true;
            } catch (Throwable x) {
                C5747IO.close(ManagedSelector.this._selector);
                ManagedSelector.this._selector = null;
                if (ManagedSelector.this.isRunning()) {
                    ManagedSelector.LOG.warn("Fatal select() failure", x);
                    ManagedSelector.this.onSelectFailed(x);
                    return false;
                }
                ManagedSelector.LOG.warn(x.toString(), new Object[0]);
                if (!ManagedSelector.LOG.isDebugEnabled()) {
                    return false;
                }
                ManagedSelector.LOG.debug(x);
                return false;
            }
        }

        private Runnable processSelected() {
            while (this._cursor.hasNext()) {
                SelectionKey key = this._cursor.next();
                Object attachment = key.attachment();
                SelectableChannel channel = key.channel();
                if (key.isValid()) {
                    if (ManagedSelector.LOG.isDebugEnabled()) {
                        ManagedSelector.LOG.debug("selected {} {} {} ", Integer.valueOf(ManagedSelector.safeReadyOps(key)), key, attachment);
                    }
                    try {
                        if (!(attachment instanceof Selectable)) {
                            if (!key.isConnectable()) {
                                throw new IllegalStateException("key=" + key + ", att=" + attachment + ", iOps=" + ManagedSelector.safeInterestOps(key) + ", rOps=" + ManagedSelector.safeReadyOps(key));
                                break;
                            }
                            ManagedSelector.this.processConnect(key, (Connect) attachment);
                        } else {
                            Runnable task = ((Selectable) attachment).onSelected();
                            if (task != null) {
                                return task;
                            }
                        }
                    } catch (CancelledKeyException e) {
                        if (ManagedSelector.LOG.isDebugEnabled()) {
                            ManagedSelector.LOG.debug("Ignoring cancelled key for channel {}", channel);
                        }
                        C5747IO.close(attachment instanceof EndPoint ? (EndPoint) attachment : channel);
                    } catch (Throwable x) {
                        ManagedSelector.LOG.warn("Could not process key for channel {}", channel, x);
                        C5747IO.close(attachment instanceof EndPoint ? (EndPoint) attachment : channel);
                    }
                } else {
                    if (ManagedSelector.LOG.isDebugEnabled()) {
                        ManagedSelector.LOG.debug("Selector loop ignoring invalid key for channel {}", channel);
                    }
                    C5747IO.close(attachment instanceof EndPoint ? (EndPoint) attachment : channel);
                }
            }
            return null;
        }

        private void updateKeys() {
            for (SelectionKey key : this._keys) {
                Object attachment = key.attachment();
                if (attachment instanceof Selectable) {
                    ((Selectable) attachment).updateKey();
                }
            }
            this._keys.clear();
        }

        public String toString() {
            return String.format("%s@%x", getClass().getSimpleName(), Integer.valueOf(hashCode()));
        }
    }

    /* renamed from: org.eclipse.jetty.io.ManagedSelector$Start */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector$Start.class */
    private class Start implements SelectorUpdate {
        private final CountDownLatch _started;

        private Start() {
            this._started = new CountDownLatch(1);
        }

        @Override // org.eclipse.jetty.p023io.ManagedSelector.SelectorUpdate
        public void update(Selector selector) {
            ManagedSelector.this._started.set(true);
            this._started.countDown();
        }
    }

    /* renamed from: org.eclipse.jetty.io.ManagedSelector$DumpKeys */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector$DumpKeys.class */
    private static class DumpKeys implements SelectorUpdate {
        private final CountDownLatch latch;
        private List<String> keys;

        private DumpKeys() {
            this.latch = new CountDownLatch(1);
        }

        @Override // org.eclipse.jetty.p023io.ManagedSelector.SelectorUpdate
        public void update(Selector selector) {
            Set<SelectionKey> selectionKeys = selector.keys();
            List<String> list = new ArrayList<>(selectionKeys.size());
            for (SelectionKey key : selectionKeys) {
                if (key != null) {
                    list.add(String.format("SelectionKey@%x{i=%d}->%s", Integer.valueOf(key.hashCode()), Integer.valueOf(ManagedSelector.safeInterestOps(key)), key.attachment()));
                }
            }
            this.keys = list;
            this.latch.countDown();
        }

        public List<String> get(long timeout, TimeUnit unit) {
            try {
                this.latch.await(timeout, unit);
            } catch (InterruptedException x) {
                ManagedSelector.LOG.ignore(x);
            }
            return this.keys;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.eclipse.jetty.io.ManagedSelector$Acceptor */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector$Acceptor.class */
    public class Acceptor implements SelectorUpdate, Selectable, Closeable {
        private final SelectableChannel _channel;
        private SelectionKey _key;

        /* access modifiers changed from: package-private */
        public Acceptor(SelectableChannel channel) {
            this._channel = channel;
        }

        @Override // org.eclipse.jetty.p023io.ManagedSelector.SelectorUpdate
        public void update(Selector selector) {
            try {
                this._key = this._channel.register(selector, 16, this);
                if (ManagedSelector.LOG.isDebugEnabled()) {
                    ManagedSelector.LOG.debug("{} acceptor={}", this, this._channel);
                }
            } catch (Throwable x) {
                C5747IO.close(this._channel);
                ManagedSelector.LOG.warn(x);
            }
        }

        @Override // org.eclipse.jetty.p023io.ManagedSelector.Selectable
        public Runnable onSelected() {
            SelectableChannel channel = null;
            while (true) {
                try {
                    channel = ManagedSelector.this._selectorManager.doAccept(this._channel);
                    if (channel == null) {
                        return null;
                    }
                    ManagedSelector.this._selectorManager.accepted(channel);
                } catch (Throwable x) {
                    ManagedSelector.LOG.warn("Accept failed for channel {}", channel, x);
                    C5747IO.close(channel);
                    return null;
                }
            }
        }

        @Override // org.eclipse.jetty.p023io.ManagedSelector.Selectable
        public void updateKey() {
        }

        @Override // org.eclipse.jetty.p023io.ManagedSelector.Selectable
        public void replaceKey(SelectionKey newKey) {
            this._key = newKey;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            ManagedSelector.this.submit(selector -> {
                this._key.cancel();
            });
        }
    }

    /* renamed from: org.eclipse.jetty.io.ManagedSelector$Accept */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector$Accept.class */
    class Accept implements SelectorUpdate, Runnable, Closeable {
        private final SelectableChannel channel;
        private final Object attachment;
        private SelectionKey key;

        /* access modifiers changed from: package-private */
        public Accept(SelectableChannel channel, Object attachment) {
            this.channel = channel;
            this.attachment = attachment;
            ManagedSelector.this._selectorManager.onAccepting(channel);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (ManagedSelector.LOG.isDebugEnabled()) {
                ManagedSelector.LOG.debug("closed accept of {}", this.channel);
            }
            C5747IO.close(this.channel);
        }

        @Override // org.eclipse.jetty.p023io.ManagedSelector.SelectorUpdate
        public void update(Selector selector) {
            try {
                this.key = this.channel.register(selector, 0, this.attachment);
                ManagedSelector.this.execute(this);
            } catch (Throwable x) {
                C5747IO.close(this.channel);
                ManagedSelector.this._selectorManager.onAcceptFailed(this.channel, x);
                if (ManagedSelector.LOG.isDebugEnabled()) {
                    ManagedSelector.LOG.debug(x);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ManagedSelector.this.createEndPoint(this.channel, this.key);
                ManagedSelector.this._selectorManager.onAccepted(this.channel);
            } catch (Throwable x) {
                if (ManagedSelector.LOG.isDebugEnabled()) {
                    ManagedSelector.LOG.debug(x);
                }
                failed(x);
            }
        }

        protected void failed(Throwable failure) {
            C5747IO.close(this.channel);
            ManagedSelector.LOG.warn(String.valueOf(failure), new Object[0]);
            if (ManagedSelector.LOG.isDebugEnabled()) {
                ManagedSelector.LOG.debug(failure);
            }
            ManagedSelector.this._selectorManager.onAcceptFailed(this.channel, failure);
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("%s@%x[%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this.channel);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.eclipse.jetty.io.ManagedSelector$Connect */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector$Connect.class */
    public class Connect implements SelectorUpdate, Runnable {
        private final AtomicBoolean failed = new AtomicBoolean();
        private final SelectableChannel channel;
        private final Object attachment;
        private final Scheduler.Task timeout;

        /* access modifiers changed from: package-private */
        public Connect(SelectableChannel channel, Object attachment) {
            this.channel = channel;
            this.attachment = attachment;
            long timeout = ManagedSelector.this._selectorManager.getConnectTimeout();
            if (timeout > 0) {
                this.timeout = ManagedSelector.this._selectorManager.getScheduler().schedule(this, timeout, TimeUnit.MILLISECONDS);
            } else {
                this.timeout = null;
            }
        }

        @Override // org.eclipse.jetty.p023io.ManagedSelector.SelectorUpdate
        public void update(Selector selector) {
            try {
                this.channel.register(selector, 8, this);
            } catch (Throwable x) {
                failed(x);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ManagedSelector.this._selectorManager.isConnectionPending(this.channel)) {
                if (ManagedSelector.LOG.isDebugEnabled()) {
                    ManagedSelector.LOG.debug("Channel {} timed out while connecting, closing it", this.channel);
                }
                failed(new SocketTimeoutException("Connect Timeout"));
            }
        }

        public void failed(Throwable failure) {
            if (this.failed.compareAndSet(false, true)) {
                if (this.timeout != null) {
                    this.timeout.cancel();
                }
                C5747IO.close(this.channel);
                ManagedSelector.this._selectorManager.connectionFailed(this.channel, failure, this.attachment);
            }
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("Connect@%x{%s,%s}", Integer.valueOf(hashCode()), this.channel, this.attachment);
        }
    }

    /* renamed from: org.eclipse.jetty.io.ManagedSelector$CloseConnections */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector$CloseConnections.class */
    private class CloseConnections implements SelectorUpdate {
        private final Set<Closeable> _closed;
        private final CountDownLatch _complete;

        private CloseConnections(ManagedSelector managedSelector) {
            this((Set<Closeable>) null);
        }

        private CloseConnections(Set<Closeable> closed) {
            this._complete = new CountDownLatch(1);
            this._closed = closed;
        }

        @Override // org.eclipse.jetty.p023io.ManagedSelector.SelectorUpdate
        public void update(Selector selector) {
            if (ManagedSelector.LOG.isDebugEnabled()) {
                ManagedSelector.LOG.debug("Closing {} connections on {}", Integer.valueOf(selector.keys().size()), ManagedSelector.this);
            }
            for (SelectionKey key : selector.keys()) {
                if (key != null && key.isValid()) {
                    Closeable closeable = null;
                    Object attachment = key.attachment();
                    if (attachment instanceof EndPoint) {
                        EndPoint endPoint = (EndPoint) attachment;
                        Closeable connection = endPoint.getConnection();
                        if (connection != null) {
                            closeable = connection;
                        } else {
                            closeable = endPoint;
                        }
                    }
                    if (closeable != null) {
                        if (this._closed == null) {
                            C5747IO.close(closeable);
                        } else if (!this._closed.contains(closeable)) {
                            this._closed.add(closeable);
                            C5747IO.close(closeable);
                        }
                    }
                }
            }
            this._complete.countDown();
        }
    }

    /* renamed from: org.eclipse.jetty.io.ManagedSelector$StopSelector */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector$StopSelector.class */
    private class StopSelector implements SelectorUpdate {
        private final CountDownLatch _stopped;

        private StopSelector() {
            this._stopped = new CountDownLatch(1);
        }

        @Override // org.eclipse.jetty.p023io.ManagedSelector.SelectorUpdate
        public void update(Selector selector) {
            for (SelectionKey key : selector.keys()) {
                if (key != null) {
                    Object attachment = key.attachment();
                    if (attachment instanceof Closeable) {
                        C5747IO.close((Closeable) attachment);
                    }
                }
            }
            ManagedSelector.this._selector = null;
            C5747IO.close(selector);
            this._stopped.countDown();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.io.ManagedSelector$CreateEndPoint */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector$CreateEndPoint.class */
    public final class CreateEndPoint implements Runnable {
        private final Connect _connect;
        private final SelectionKey _key;

        private CreateEndPoint(Connect connect, SelectionKey key) {
            this._connect = connect;
            this._key = key;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ManagedSelector.this.createEndPoint(this._connect.channel, this._key);
            } catch (Throwable failure) {
                C5747IO.close(this._connect.channel);
                ManagedSelector.LOG.warn(String.valueOf(failure), new Object[0]);
                if (ManagedSelector.LOG.isDebugEnabled()) {
                    ManagedSelector.LOG.debug(failure);
                }
                this._connect.failed(failure);
            }
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("CreateEndPoint@%x{%s}", Integer.valueOf(hashCode()), this._connect);
        }
    }

    /* renamed from: org.eclipse.jetty.io.ManagedSelector$DestroyEndPoint */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ManagedSelector$DestroyEndPoint.class */
    private class DestroyEndPoint implements Runnable, Closeable {
        private final EndPoint endPoint;

        public DestroyEndPoint(EndPoint endPoint) {
            this.endPoint = endPoint;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ManagedSelector.LOG.isDebugEnabled()) {
                ManagedSelector.LOG.debug("Destroyed {}", this.endPoint);
            }
            Connection connection = this.endPoint.getConnection();
            if (connection != null) {
                ManagedSelector.this._selectorManager.connectionClosed(connection);
            }
            ManagedSelector.this.endPointClosed(this.endPoint);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            run();
        }
    }
}
