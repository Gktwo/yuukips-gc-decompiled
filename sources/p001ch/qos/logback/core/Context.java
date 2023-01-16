package p001ch.qos.logback.core;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import p001ch.qos.logback.core.spi.LifeCycle;
import p001ch.qos.logback.core.spi.PropertyContainer;
import p001ch.qos.logback.core.status.StatusManager;

/* renamed from: ch.qos.logback.core.Context */
/* loaded from: grasscutter.jar:ch/qos/logback/core/Context.class */
public interface Context extends PropertyContainer {
    StatusManager getStatusManager();

    Object getObject(String str);

    void putObject(String str, Object obj);

    @Override // p001ch.qos.logback.core.spi.PropertyContainer
    String getProperty(String str);

    void putProperty(String str, String str2);

    @Override // p001ch.qos.logback.core.spi.PropertyContainer
    Map<String, String> getCopyOfPropertyMap();

    String getName();

    void setName(String str);

    long getBirthTime();

    Object getConfigurationLock();

    ScheduledExecutorService getScheduledExecutorService();

    ExecutorService getExecutorService();

    void register(LifeCycle lifeCycle);

    void addScheduledFuture(ScheduledFuture<?> scheduledFuture);
}
