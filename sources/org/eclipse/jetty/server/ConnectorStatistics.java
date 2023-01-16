package org.eclipse.jetty.server;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.Container;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.statistic.CounterStatistic;
import org.eclipse.jetty.util.statistic.SampleStatistic;

@ManagedObject("Connector Statistics")
@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ConnectorStatistics.class */
public class ConnectorStatistics extends AbstractLifeCycle implements Dumpable, Connection.Listener {
    private final AtomicLong _startMillis = new AtomicLong(-1);
    private final CounterStatistic _connectionStats = new CounterStatistic();
    private final SampleStatistic _messagesIn = new SampleStatistic();
    private final SampleStatistic _messagesOut = new SampleStatistic();
    private final SampleStatistic _connectionDurationStats = new SampleStatistic();
    private final ConcurrentMap<Connection, Sample> _samples = new ConcurrentHashMap();
    private final LongAdder _closedIn = new LongAdder();
    private final LongAdder _closedOut = new LongAdder();
    private AtomicLong _nanoStamp = new AtomicLong();
    private volatile int _messagesInPerSecond;
    private volatile int _messagesOutPerSecond;
    private static final Sample ZERO = new Sample();
    private static final long SECOND_NANOS = TimeUnit.SECONDS.toNanos(1);

    @Override // org.eclipse.jetty.p023io.Connection.Listener
    public void onOpened(Connection connection) {
        if (isStarted()) {
            this._connectionStats.increment();
            this._samples.put(connection, ZERO);
        }
    }

    @Override // org.eclipse.jetty.p023io.Connection.Listener
    public void onClosed(Connection connection) {
        if (isStarted()) {
            long msgsIn = connection.getMessagesIn();
            long msgsOut = connection.getMessagesOut();
            this._messagesIn.record(msgsIn);
            this._messagesOut.record(msgsOut);
            this._connectionStats.decrement();
            this._connectionDurationStats.record(System.currentTimeMillis() - connection.getCreatedTimeStamp());
            Sample sample = this._samples.remove(connection);
            if (sample != null) {
                this._closedIn.add(msgsIn - sample._messagesIn);
                this._closedOut.add(msgsOut - sample._messagesOut);
            }
        }
    }

    @ManagedAttribute("Total number of bytes received by this connector")
    public int getBytesIn() {
        return -1;
    }

    @ManagedAttribute("Total number of bytes sent by this connector")
    public int getBytesOut() {
        return -1;
    }

    @ManagedAttribute("Total number of connections seen by this connector")
    public int getConnections() {
        return (int) this._connectionStats.getTotal();
    }

    @ManagedAttribute("Connection duration maximum in ms")
    public long getConnectionDurationMax() {
        return this._connectionDurationStats.getMax();
    }

    @ManagedAttribute("Connection duration mean in ms")
    public double getConnectionDurationMean() {
        return this._connectionDurationStats.getMean();
    }

    @ManagedAttribute("Connection duration standard deviation")
    public double getConnectionDurationStdDev() {
        return this._connectionDurationStats.getStdDev();
    }

    @ManagedAttribute("Messages In for all connections")
    public int getMessagesIn() {
        return (int) this._messagesIn.getTotal();
    }

    @ManagedAttribute("Messages In per connection maximum")
    public int getMessagesInPerConnectionMax() {
        return (int) this._messagesIn.getMax();
    }

    @ManagedAttribute("Messages In per connection mean")
    public double getMessagesInPerConnectionMean() {
        return this._messagesIn.getMean();
    }

    @ManagedAttribute("Messages In per connection standard deviation")
    public double getMessagesInPerConnectionStdDev() {
        return this._messagesIn.getStdDev();
    }

    @ManagedAttribute("Connections open")
    public int getConnectionsOpen() {
        return (int) this._connectionStats.getCurrent();
    }

    @ManagedAttribute("Connections open maximum")
    public int getConnectionsOpenMax() {
        return (int) this._connectionStats.getMax();
    }

    @ManagedAttribute("Messages Out for all connections")
    public int getMessagesOut() {
        return (int) this._messagesIn.getTotal();
    }

    @ManagedAttribute("Messages In per connection maximum")
    public int getMessagesOutPerConnectionMax() {
        return (int) this._messagesIn.getMax();
    }

    @ManagedAttribute("Messages In per connection mean")
    public double getMessagesOutPerConnectionMean() {
        return this._messagesIn.getMean();
    }

    @ManagedAttribute("Messages In per connection standard deviation")
    public double getMessagesOutPerConnectionStdDev() {
        return this._messagesIn.getStdDev();
    }

    @ManagedAttribute("Connection statistics started ms since epoch")
    public long getStartedMillis() {
        long start = this._startMillis.get();
        if (start < 0) {
            return 0;
        }
        return System.currentTimeMillis() - start;
    }

    @ManagedAttribute("Messages in per second calculated over period since last called")
    public int getMessagesInPerSecond() {
        update();
        return this._messagesInPerSecond;
    }

    @ManagedAttribute("Messages out per second calculated over period since last called")
    public int getMessagesOutPerSecond() {
        update();
        return this._messagesOutPerSecond;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() {
        reset();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() {
        this._samples.clear();
    }

    @ManagedOperation("Reset the statistics")
    public void reset() {
        this._startMillis.set(System.currentTimeMillis());
        this._messagesIn.reset();
        this._messagesOut.reset();
        this._connectionStats.reset();
        this._connectionDurationStats.reset();
        this._samples.clear();
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    @ManagedOperation("dump thread state")
    public String dump() {
        return Dumpable.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObjects(out, indent, this, "connections=" + this._connectionStats, "duration=" + this._connectionDurationStats, "in=" + this._messagesIn, "out=" + this._messagesOut);
    }

    public static void addToAllConnectors(Server server) {
        Connector[] connectors = server.getConnectors();
        for (Connector connector : connectors) {
            if (connector instanceof Container) {
                connector.addBean(new ConnectorStatistics());
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x004c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x004c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v1, types: [long] */
    /* JADX WARN: Type inference failed for: r14v1, types: [long] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r0v39, types: [long] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r0v41, types: [long] */
    /* JADX WARN: Type inference failed for: r16v3 */
    private synchronized void update() {
        long now = System.nanoTime();
        long then = this._nanoStamp.get();
        long duration = now - then;
        if (duration > SECOND_NANOS / 2 && this._nanoStamp.compareAndSet(then, now)) {
            long msgsIn = this._closedIn.sumThenReset();
            long msgsOut = this._closedOut.sumThenReset();
            for (Map.Entry<Connection, Sample> entry : this._samples.entrySet()) {
                Connection connection = entry.getKey();
                Sample sample = entry.getValue();
                Sample next = new Sample(connection);
                if (this._samples.replace(connection, sample, next)) {
                    msgsIn = (msgsIn == true ? 1 : 0) + (next._messagesIn - sample._messagesIn);
                    msgsOut = (msgsOut == true ? 1 : 0) + (next._messagesOut - sample._messagesOut);
                }
            }
            this._messagesInPerSecond = (int) ((msgsIn * SECOND_NANOS) / duration);
            this._messagesOutPerSecond = (int) ((msgsOut * SECOND_NANOS) / duration);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ConnectorStatistics$Sample.class */
    public static class Sample {
        final long _messagesIn;
        final long _messagesOut;

        Sample() {
            this._messagesIn = 0;
            this._messagesOut = 0;
        }

        Sample(Connection connection) {
            this._messagesIn = connection.getMessagesIn();
            this._messagesOut = connection.getMessagesOut();
        }
    }
}
