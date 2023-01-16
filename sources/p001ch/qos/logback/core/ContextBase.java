package p001ch.qos.logback.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import p001ch.qos.logback.core.spi.LifeCycle;
import p001ch.qos.logback.core.spi.LogbackLock;
import p001ch.qos.logback.core.status.StatusManager;
import p001ch.qos.logback.core.util.ContextUtil;
import p001ch.qos.logback.core.util.ExecutorServiceUtil;

/* renamed from: ch.qos.logback.core.ContextBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/ContextBase.class */
public class ContextBase implements Context, LifeCycle {
    private String name;
    private ScheduledExecutorService scheduledExecutorService;
    private LifeCycleManager lifeCycleManager;
    private boolean started;
    private long birthTime = System.currentTimeMillis();

    /* renamed from: sm */
    private StatusManager f9sm = new BasicStatusManager();
    Map<String, String> propertyMap = new HashMap();
    Map<String, Object> objectMap = new HashMap();
    LogbackLock configurationLock = new LogbackLock();
    protected List<ScheduledFuture<?>> scheduledFutures = new ArrayList(1);

    public ContextBase() {
        initCollisionMaps();
    }

    @Override // p001ch.qos.logback.core.Context
    public StatusManager getStatusManager() {
        return this.f9sm;
    }

    public void setStatusManager(StatusManager statusManager) {
        if (statusManager == null) {
            throw new IllegalArgumentException("null StatusManager not allowed");
        }
        this.f9sm = statusManager;
    }

    @Override // p001ch.qos.logback.core.Context, p001ch.qos.logback.core.spi.PropertyContainer
    public Map<String, String> getCopyOfPropertyMap() {
        return new HashMap(this.propertyMap);
    }

    @Override // p001ch.qos.logback.core.Context
    public void putProperty(String key, String val) {
        if (CoreConstants.HOSTNAME_KEY.equalsIgnoreCase(key)) {
            putHostnameProperty(val);
        } else {
            this.propertyMap.put(key, val);
        }
    }

    protected void initCollisionMaps() {
        putObject(CoreConstants.FA_FILENAME_COLLISION_MAP, new HashMap());
        putObject(CoreConstants.RFA_FILENAME_PATTERN_COLLISION_MAP, new HashMap());
    }

    @Override // p001ch.qos.logback.core.Context, p001ch.qos.logback.core.spi.PropertyContainer
    public String getProperty(String key) {
        if (CoreConstants.CONTEXT_NAME_KEY.equals(key)) {
            return getName();
        }
        if (CoreConstants.HOSTNAME_KEY.equalsIgnoreCase(key)) {
            return lazyGetHostname();
        }
        return this.propertyMap.get(key);
    }

    private String lazyGetHostname() {
        String hostname = this.propertyMap.get(CoreConstants.HOSTNAME_KEY);
        if (hostname == null) {
            hostname = new ContextUtil(this).safelyGetLocalHostName();
            putHostnameProperty(hostname);
        }
        return hostname;
    }

    private void putHostnameProperty(String hostname) {
        if (this.propertyMap.get(CoreConstants.HOSTNAME_KEY) == null) {
            this.propertyMap.put(CoreConstants.HOSTNAME_KEY, hostname);
        }
    }

    @Override // p001ch.qos.logback.core.Context
    public Object getObject(String key) {
        return this.objectMap.get(key);
    }

    @Override // p001ch.qos.logback.core.Context
    public void putObject(String key, Object value) {
        this.objectMap.put(key, value);
    }

    public void removeObject(String key) {
        this.objectMap.remove(key);
    }

    @Override // p001ch.qos.logback.core.Context
    public String getName() {
        return this.name;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.started = true;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        stopExecutorService();
        this.started = false;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }

    public void reset() {
        removeShutdownHook();
        getLifeCycleManager().reset();
        this.propertyMap.clear();
        this.objectMap.clear();
    }

    @Override // p001ch.qos.logback.core.Context
    public void setName(String name) throws IllegalStateException {
        if (name != null && name.equals(this.name)) {
            return;
        }
        if (this.name == null || "default".equals(this.name)) {
            this.name = name;
            return;
        }
        throw new IllegalStateException("Context has been already given a name");
    }

    @Override // p001ch.qos.logback.core.Context
    public long getBirthTime() {
        return this.birthTime;
    }

    @Override // p001ch.qos.logback.core.Context
    public Object getConfigurationLock() {
        return this.configurationLock;
    }

    @Override // p001ch.qos.logback.core.Context
    public synchronized ExecutorService getExecutorService() {
        return getScheduledExecutorService();
    }

    @Override // p001ch.qos.logback.core.Context
    public synchronized ScheduledExecutorService getScheduledExecutorService() {
        if (this.scheduledExecutorService == null) {
            this.scheduledExecutorService = ExecutorServiceUtil.newScheduledExecutorService();
        }
        return this.scheduledExecutorService;
    }

    private synchronized void stopExecutorService() {
        if (this.scheduledExecutorService != null) {
            ExecutorServiceUtil.shutdown(this.scheduledExecutorService);
            this.scheduledExecutorService = null;
        }
    }

    private void removeShutdownHook() {
        Thread hook = (Thread) getObject(CoreConstants.SHUTDOWN_HOOK_THREAD);
        if (hook != null) {
            removeObject(CoreConstants.SHUTDOWN_HOOK_THREAD);
            try {
                Runtime.getRuntime().removeShutdownHook(hook);
            } catch (IllegalStateException e) {
            }
        }
    }

    @Override // p001ch.qos.logback.core.Context
    public void register(LifeCycle component) {
        getLifeCycleManager().register(component);
    }

    synchronized LifeCycleManager getLifeCycleManager() {
        if (this.lifeCycleManager == null) {
            this.lifeCycleManager = new LifeCycleManager();
        }
        return this.lifeCycleManager;
    }

    public String toString() {
        return this.name;
    }

    @Override // p001ch.qos.logback.core.Context
    public void addScheduledFuture(ScheduledFuture<?> scheduledFuture) {
        this.scheduledFutures.add(scheduledFuture);
    }

    public List<ScheduledFuture<?>> getScheduledFutures() {
        return new ArrayList(this.scheduledFutures);
    }
}
