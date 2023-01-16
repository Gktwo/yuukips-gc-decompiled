package org.eclipse.jetty.server;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.ScheduledExecutorScheduler;
import org.eclipse.jetty.util.thread.Scheduler;
import org.eclipse.jetty.util.thread.ThreadPool;

@ManagedObject("Monitor for low resource conditions and activate a low resource mode if detected")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/LowResourceMonitor.class */
public class LowResourceMonitor extends ContainerLifeCycle {
    private static final Logger LOG = Log.getLogger(LowResourceMonitor.class);
    protected final Server _server;
    private Scheduler _scheduler;
    private Connector[] _monitoredConnectors;
    private String _reasons;
    private long _lowStarted;
    private Set<AbstractConnector> _acceptingConnectors = new HashSet();
    private int _period = 1000;
    private int _lowResourcesIdleTimeout = 1000;
    private int _maxLowResourcesTime = 0;
    private final AtomicBoolean _low = new AtomicBoolean();
    private boolean _acceptingInLowResources = true;
    private Set<LowResourceCheck> _lowResourceChecks = new HashSet();
    private final Runnable _monitor = new Runnable() { // from class: org.eclipse.jetty.server.LowResourceMonitor.1
        @Override // java.lang.Runnable
        public void run() {
            if (LowResourceMonitor.this.isRunning()) {
                LowResourceMonitor.this.monitor();
                LowResourceMonitor.this._scheduler.schedule(LowResourceMonitor.this._monitor, (long) LowResourceMonitor.this._period, TimeUnit.MILLISECONDS);
            }
        }
    };

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/LowResourceMonitor$LowResourceCheck.class */
    public interface LowResourceCheck {
        boolean isLowOnResources();

        String getReason();
    }

    public LowResourceMonitor(@Name("server") Server server) {
        this._server = server;
    }

    @ManagedAttribute("True if low available threads status is monitored")
    public boolean getMonitorThreads() {
        return !getBeans(ConnectorsThreadPoolLowResourceCheck.class).isEmpty();
    }

    public void setMonitorThreads(boolean monitorThreads) {
        if (!monitorThreads) {
            return;
        }
        if (!getMonitorThreads()) {
            addLowResourceCheck(new ConnectorsThreadPoolLowResourceCheck());
        } else {
            getBeans(ConnectorsThreadPoolLowResourceCheck.class).forEach((v1) -> {
                removeBean(v1);
            });
        }
    }

    @ManagedAttribute("The maximum connections allowed for the monitored connectors before low resource handling is activated")
    @Deprecated
    public int getMaxConnections() {
        for (MaxConnectionsLowResourceCheck lowResourceCheck : getBeans(MaxConnectionsLowResourceCheck.class)) {
            if (lowResourceCheck.getMaxConnections() > 0) {
                return lowResourceCheck.getMaxConnections();
            }
        }
        return -1;
    }

    @Deprecated
    public void setMaxConnections(int maxConnections) {
        if (maxConnections <= 0) {
            getBeans(ConnectorsThreadPoolLowResourceCheck.class).forEach((v1) -> {
                removeBean(v1);
            });
        } else if (getBeans(MaxConnectionsLowResourceCheck.class).isEmpty()) {
            addLowResourceCheck(new MaxConnectionsLowResourceCheck(maxConnections));
        } else {
            getBeans(MaxConnectionsLowResourceCheck.class).forEach(c -> {
                c.setMaxConnections(maxConnections);
            });
        }
    }

    @ManagedAttribute("The reasons the monitored connectors are low on resources")
    public String getReasons() {
        return this._reasons;
    }

    protected void setReasons(String reasons) {
        this._reasons = reasons;
    }

    @ManagedAttribute("Are the monitored connectors low on resources?")
    public boolean isLowOnResources() {
        return this._low.get();
    }

    protected boolean enableLowOnResources(boolean expectedValue, boolean newValue) {
        return this._low.compareAndSet(expectedValue, newValue);
    }

    @ManagedAttribute("The reason(s) the monitored connectors are low on resources")
    public String getLowResourcesReasons() {
        return this._reasons;
    }

    protected void setLowResourcesReasons(String reasons) {
        this._reasons = reasons;
    }

    @ManagedAttribute("Get the timestamp in ms since epoch that low resources state started")
    public long getLowResourcesStarted() {
        return this._lowStarted;
    }

    public void setLowResourcesStarted(long lowStarted) {
        this._lowStarted = lowStarted;
    }

    @ManagedAttribute("The monitored connectors. If null then all server connectors are monitored")
    public Collection<Connector> getMonitoredConnectors() {
        if (this._monitoredConnectors == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(this._monitoredConnectors);
    }

    public void setMonitoredConnectors(Collection<Connector> monitoredConnectors) {
        if (monitoredConnectors == null || monitoredConnectors.size() == 0) {
            this._monitoredConnectors = null;
        } else {
            this._monitoredConnectors = (Connector[]) monitoredConnectors.toArray(new Connector[monitoredConnectors.size()]);
        }
    }

    protected Connector[] getMonitoredOrServerConnectors() {
        if (this._monitoredConnectors == null || this._monitoredConnectors.length <= 0) {
            return this._server.getConnectors();
        }
        return this._monitoredConnectors;
    }

    @ManagedAttribute("If false, new connections are not accepted while in low resources")
    public boolean isAcceptingInLowResources() {
        return this._acceptingInLowResources;
    }

    public void setAcceptingInLowResources(boolean acceptingInLowResources) {
        this._acceptingInLowResources = acceptingInLowResources;
    }

    @ManagedAttribute("The monitor period in ms")
    public int getPeriod() {
        return this._period;
    }

    public void setPeriod(int periodMS) {
        this._period = periodMS;
    }

    @ManagedAttribute("The idletimeout in ms to apply to all existing connections when low resources is detected")
    public int getLowResourcesIdleTimeout() {
        return this._lowResourcesIdleTimeout;
    }

    public void setLowResourcesIdleTimeout(int lowResourcesIdleTimeoutMS) {
        this._lowResourcesIdleTimeout = lowResourcesIdleTimeoutMS;
    }

    @ManagedAttribute("The maximum time in ms that low resources condition can persist before lowResourcesIdleTimeout is applied to new connections as well as existing connections")
    public int getMaxLowResourcesTime() {
        return this._maxLowResourcesTime;
    }

    public void setMaxLowResourcesTime(int maxLowResourcesTimeMS) {
        this._maxLowResourcesTime = maxLowResourcesTimeMS;
    }

    @ManagedAttribute("The maximum memory (in bytes) that can be used before low resources is triggered.  Memory used is calculated as (totalMemory-freeMemory).")
    public long getMaxMemory() {
        Collection<MemoryLowResourceCheck> beans = getBeans(MemoryLowResourceCheck.class);
        if (beans.isEmpty()) {
            return 0;
        }
        return beans.stream().findFirst().get().getMaxMemory();
    }

    public void setMaxMemory(long maxMemoryBytes) {
        if (maxMemoryBytes > 0) {
            Collection<MemoryLowResourceCheck> beans = getBeans(MemoryLowResourceCheck.class);
            if (beans.isEmpty()) {
                addLowResourceCheck(new MemoryLowResourceCheck(maxMemoryBytes));
            } else {
                beans.forEach(lowResourceCheck -> {
                    lowResourceCheck.setMaxMemory(maxMemoryBytes);
                });
            }
        }
    }

    public Set<LowResourceCheck> getLowResourceChecks() {
        return this._lowResourceChecks;
    }

    public void setLowResourceChecks(Set<LowResourceCheck> lowResourceChecks) {
        updateBeans(this._lowResourceChecks.toArray(), lowResourceChecks.toArray());
        this._lowResourceChecks = lowResourceChecks;
    }

    public void addLowResourceCheck(LowResourceCheck lowResourceCheck) {
        addBean(lowResourceCheck);
        this._lowResourceChecks.add(lowResourceCheck);
    }

    protected void monitor() {
        String reasons = null;
        Iterator<LowResourceCheck> it = this._lowResourceChecks.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            LowResourceCheck lowResourceCheck = it.next();
            if (lowResourceCheck.isLowOnResources()) {
                reasons = lowResourceCheck.toString();
                break;
            }
        }
        if (reasons != null) {
            if (!reasons.equals(getReasons())) {
                LOG.warn("Low Resources: {}", reasons);
                setReasons(reasons);
            }
            if (enableLowOnResources(false, true)) {
                setLowResourcesReasons(reasons);
                setLowResourcesStarted(System.currentTimeMillis());
                setLowResources();
            }
            if (getMaxLowResourcesTime() > 0 && System.currentTimeMillis() - getLowResourcesStarted() > ((long) getMaxLowResourcesTime())) {
                setLowResources();
            }
        } else if (enableLowOnResources(true, false)) {
            LOG.info("Low Resources cleared", new Object[0]);
            setLowResourcesReasons(null);
            setLowResourcesStarted(0);
            setReasons(null);
            clearLowResources();
        }
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStart() throws Exception {
        this._scheduler = (Scheduler) this._server.getBean((Class<Object>) Scheduler.class);
        if (this._scheduler == null) {
            this._scheduler = new LRMScheduler();
            this._scheduler.start();
        }
        doStart();
        this._scheduler.schedule(this._monitor, (long) this._period, TimeUnit.MILLISECONDS);
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        if (this._scheduler instanceof LRMScheduler) {
            this._scheduler.stop();
        }
        doStop();
    }

    protected void setLowResources() {
        Connector[] monitoredOrServerConnectors = getMonitoredOrServerConnectors();
        for (Connector connector : monitoredOrServerConnectors) {
            if (connector instanceof AbstractConnector) {
                AbstractConnector c = (AbstractConnector) connector;
                if (!isAcceptingInLowResources() && c.isAccepting()) {
                    this._acceptingConnectors.add(c);
                    c.setAccepting(false);
                }
            }
            for (EndPoint endPoint : connector.getConnectedEndPoints()) {
                endPoint.setIdleTimeout((long) this._lowResourcesIdleTimeout);
            }
        }
    }

    protected void clearLowResources() {
        Connector[] monitoredOrServerConnectors = getMonitoredOrServerConnectors();
        for (Connector connector : monitoredOrServerConnectors) {
            for (EndPoint endPoint : connector.getConnectedEndPoints()) {
                endPoint.setIdleTimeout(connector.getIdleTimeout());
            }
        }
        for (AbstractConnector connector2 : this._acceptingConnectors) {
            connector2.setAccepting(true);
        }
        this._acceptingConnectors.clear();
    }

    protected String low(String reasons, String newReason) {
        if (reasons == null) {
            return newReason;
        }
        return reasons + ", " + newReason;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/LowResourceMonitor$LRMScheduler.class */
    private static class LRMScheduler extends ScheduledExecutorScheduler {
        private LRMScheduler() {
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/LowResourceMonitor$MainThreadPoolLowResourceCheck.class */
    public class MainThreadPoolLowResourceCheck implements LowResourceCheck {
        private String reason;

        public MainThreadPoolLowResourceCheck() {
        }

        @Override // org.eclipse.jetty.server.LowResourceMonitor.LowResourceCheck
        public boolean isLowOnResources() {
            ThreadPool serverThreads = LowResourceMonitor.this._server.getThreadPool();
            if (!serverThreads.isLowOnThreads()) {
                return false;
            }
            this.reason = "Server low on threads: " + serverThreads;
            return true;
        }

        @Override // org.eclipse.jetty.server.LowResourceMonitor.LowResourceCheck
        public String getReason() {
            return this.reason;
        }

        public String toString() {
            return "Check if the server ThreadPool is lowOnThreads";
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/LowResourceMonitor$ConnectorsThreadPoolLowResourceCheck.class */
    public class ConnectorsThreadPoolLowResourceCheck implements LowResourceCheck {
        private String reason;

        public ConnectorsThreadPoolLowResourceCheck() {
        }

        @Override // org.eclipse.jetty.server.LowResourceMonitor.LowResourceCheck
        public boolean isLowOnResources() {
            ThreadPool serverThreads = LowResourceMonitor.this._server.getThreadPool();
            if (serverThreads.isLowOnThreads()) {
                this.reason = "Server low on threads: " + serverThreads.getThreads() + ", idleThreads:" + serverThreads.getIdleThreads();
                return true;
            }
            for (Connector connector : LowResourceMonitor.this.getMonitoredConnectors()) {
                Executor executor = connector.getExecutor();
                if ((executor instanceof ThreadPool) && executor != serverThreads) {
                    ThreadPool connectorThreads = (ThreadPool) executor;
                    if (connectorThreads.isLowOnThreads()) {
                        this.reason = "Connector low on threads: " + connectorThreads;
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // org.eclipse.jetty.server.LowResourceMonitor.LowResourceCheck
        public String getReason() {
            return this.reason;
        }

        public String toString() {
            return "Check if the ThreadPool from monitored connectors are lowOnThreads and if all connections number is higher than the allowed maxConnection";
        }
    }

    @ManagedObject("Check max allowed connections on connectors")
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/LowResourceMonitor$MaxConnectionsLowResourceCheck.class */
    public class MaxConnectionsLowResourceCheck implements LowResourceCheck {
        private String reason;
        private int maxConnections;

        public MaxConnectionsLowResourceCheck(int maxConnections) {
            this.maxConnections = maxConnections;
        }

        @ManagedAttribute("The maximum connections allowed for the monitored connectors before low resource handling is activated")
        @Deprecated
        public int getMaxConnections() {
            return this.maxConnections;
        }

        @Deprecated
        public void setMaxConnections(int maxConnections) {
            if (maxConnections > 0) {
                LowResourceMonitor.LOG.warn("LowResourceMonitor.setMaxConnections is deprecated. Use ConnectionLimit.", new Object[0]);
            }
            this.maxConnections = maxConnections;
        }

        @Override // org.eclipse.jetty.server.LowResourceMonitor.LowResourceCheck
        public boolean isLowOnResources() {
            int connections = 0;
            for (Connector connector : LowResourceMonitor.this.getMonitoredConnectors()) {
                connections += connector.getConnectedEndPoints().size();
            }
            if (this.maxConnections <= 0 || connections <= this.maxConnections) {
                return false;
            }
            this.reason = "Max Connections exceeded: " + connections + ">" + this.maxConnections;
            return true;
        }

        @Override // org.eclipse.jetty.server.LowResourceMonitor.LowResourceCheck
        public String getReason() {
            return this.reason;
        }

        public String toString() {
            return "All connections number is higher than the allowed maxConnection";
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/LowResourceMonitor$MemoryLowResourceCheck.class */
    public class MemoryLowResourceCheck implements LowResourceCheck {
        private String reason;
        private long maxMemory;

        public MemoryLowResourceCheck(long maxMemory) {
            this.maxMemory = maxMemory;
        }

        @Override // org.eclipse.jetty.server.LowResourceMonitor.LowResourceCheck
        public boolean isLowOnResources() {
            long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            if (this.maxMemory <= 0 || memory <= this.maxMemory) {
                return false;
            }
            this.reason = "Max memory exceeded: " + memory + ">" + this.maxMemory;
            return true;
        }

        public long getMaxMemory() {
            return this.maxMemory;
        }

        public void setMaxMemory(long maxMemoryBytes) {
            this.maxMemory = maxMemoryBytes;
        }

        @Override // org.eclipse.jetty.server.LowResourceMonitor.LowResourceCheck
        public String getReason() {
            return this.reason;
        }

        public String toString() {
            return "Check if used memory is higher than the allowed max memory";
        }
    }
}
