package org.eclipse.jetty.client;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.jetty.client.api.Connection;
import org.eclipse.jetty.client.api.Destination;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/ValidatingConnectionPool.class */
public class ValidatingConnectionPool extends DuplexConnectionPool {
    private static final Logger LOG = Log.getLogger(ValidatingConnectionPool.class);
    private final Scheduler scheduler;
    private final long timeout;
    private final Map<Connection, Holder> quarantine;

    public ValidatingConnectionPool(Destination destination, int maxConnections, Callback requester, Scheduler scheduler, long timeout) {
        super((HttpDestination) destination, maxConnections, requester);
        this.scheduler = scheduler;
        this.timeout = timeout;
        this.quarantine = new ConcurrentHashMap(maxConnections);
    }

    @ManagedAttribute(value = "The number of validating connections", readonly = true)
    public int getValidatingConnectionCount() {
        return this.quarantine.size();
    }

    @Override // org.eclipse.jetty.client.AbstractConnectionPool, org.eclipse.jetty.client.ConnectionPool
    public boolean release(Connection connection) {
        Holder holder = new Holder(connection);
        holder.task = this.scheduler.schedule(holder, this.timeout, TimeUnit.MILLISECONDS);
        this.quarantine.put(connection, holder);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Validating for {}ms {}", Long.valueOf(this.timeout), connection);
        }
        released(connection);
        return true;
    }

    @Override // org.eclipse.jetty.client.AbstractConnectionPool, org.eclipse.jetty.client.ConnectionPool
    public boolean remove(Connection connection) {
        Holder holder = this.quarantine.remove(connection);
        if (holder == null) {
            return remove(connection);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Removed while validating {}", connection);
        }
        if (holder.cancel()) {
            return remove(connection, true);
        }
        return remove(connection);
    }

    @Override // org.eclipse.jetty.client.AbstractConnectionPool, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObjects(out, indent, this, new DumpableCollection("quarantine", this.quarantine.values()));
    }

    @Override // org.eclipse.jetty.client.AbstractConnectionPool, org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s[v=%d]", toString(), Integer.valueOf(this.quarantine.size()));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ValidatingConnectionPool$Holder.class */
    public class Holder implements Runnable {
        private final long timestamp = System.nanoTime();
        private final AtomicBoolean done = new AtomicBoolean();
        private final Connection connection;
        public Scheduler.Task task;

        public Holder(Connection connection) {
            this.connection = connection;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.done.compareAndSet(false, true)) {
                boolean closed = ValidatingConnectionPool.this.isClosed();
                if (ValidatingConnectionPool.LOG.isDebugEnabled()) {
                    ValidatingConnectionPool.LOG.debug("Validated {}", this.connection);
                }
                ValidatingConnectionPool.this.quarantine.remove(this.connection);
                if (!closed) {
                    ValidatingConnectionPool.this.deactivate(this.connection);
                }
                ValidatingConnectionPool.this.idle(this.connection, closed);
                ValidatingConnectionPool.this.proceed();
            }
        }

        public boolean cancel() {
            if (!this.done.compareAndSet(false, true)) {
                return false;
            }
            this.task.cancel();
            return true;
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("%s[validationLeft=%dms]", this.connection, Long.valueOf(ValidatingConnectionPool.this.timeout - TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.timestamp)));
        }
    }
}
