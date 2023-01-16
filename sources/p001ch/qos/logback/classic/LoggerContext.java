package p001ch.qos.logback.classic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.Marker;
import p001ch.qos.logback.classic.spi.LoggerComparator;
import p001ch.qos.logback.classic.spi.LoggerContextListener;
import p001ch.qos.logback.classic.spi.LoggerContextVO;
import p001ch.qos.logback.classic.spi.TurboFilterList;
import p001ch.qos.logback.classic.turbo.TurboFilter;
import p001ch.qos.logback.classic.util.LoggerNameUtil;
import p001ch.qos.logback.core.ContextBase;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.spi.FilterReply;
import p001ch.qos.logback.core.spi.LifeCycle;
import p001ch.qos.logback.core.status.StatusListener;
import p001ch.qos.logback.core.status.StatusManager;
import p001ch.qos.logback.core.status.WarnStatus;

/* renamed from: ch.qos.logback.classic.LoggerContext */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/LoggerContext.class */
public class LoggerContext extends ContextBase implements ILoggerFactory, LifeCycle {
    public static final boolean DEFAULT_PACKAGING_DATA = false;
    private int noAppenderWarning = 0;
    private final List<LoggerContextListener> loggerContextListenerList = new ArrayList();
    private final TurboFilterList turboFilterList = new TurboFilterList();
    private boolean packagingDataEnabled = false;
    private int maxCallerDataDepth = 8;
    int resetCount = 0;
    private Map<String, Logger> loggerCache = new ConcurrentHashMap();
    private LoggerContextVO loggerContextRemoteView = new LoggerContextVO(this);
    final Logger root = new Logger(Logger.ROOT_LOGGER_NAME, null, this);
    private int size = 1;
    private List<String> frameworkPackages = new ArrayList();

    public LoggerContext() {
        this.root.setLevel(Level.DEBUG);
        this.loggerCache.put(Logger.ROOT_LOGGER_NAME, this.root);
        initEvaluatorMap();
    }

    void initEvaluatorMap() {
        putObject(CoreConstants.EVALUATOR_MAP, new HashMap());
    }

    private void updateLoggerContextVO() {
        this.loggerContextRemoteView = new LoggerContextVO(this);
    }

    @Override // p001ch.qos.logback.core.ContextBase, p001ch.qos.logback.core.Context
    public void putProperty(String key, String val) {
        putProperty(key, val);
        updateLoggerContextVO();
    }

    @Override // p001ch.qos.logback.core.ContextBase, p001ch.qos.logback.core.Context
    public void setName(String name) {
        setName(name);
        updateLoggerContextVO();
    }

    public final Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }

    @Override // org.slf4j.ILoggerFactory
    public final Logger getLogger(String name) {
        int h;
        String childName;
        Logger childLogger;
        if (name == null) {
            throw new IllegalArgumentException("name argument cannot be null");
        } else if (Logger.ROOT_LOGGER_NAME.equalsIgnoreCase(name)) {
            return this.root;
        } else {
            int i = 0;
            Logger logger = this.root;
            Logger childLogger2 = this.loggerCache.get(name);
            if (childLogger2 != null) {
                return childLogger2;
            }
            do {
                h = LoggerNameUtil.getSeparatorIndexOf(name, i);
                if (h == -1) {
                    childName = name;
                } else {
                    childName = name.substring(0, h);
                }
                i = h + 1;
                synchronized (logger) {
                    childLogger = logger.getChildByName(childName);
                    if (childLogger == null) {
                        childLogger = logger.createChildByName(childName);
                        this.loggerCache.put(childName, childLogger);
                        incSize();
                    }
                }
                logger = childLogger;
            } while (h != -1);
            return childLogger;
        }
    }

    private void incSize() {
        this.size++;
    }

    int size() {
        return this.size;
    }

    public Logger exists(String name) {
        return this.loggerCache.get(name);
    }

    /* access modifiers changed from: package-private */
    public final void noAppenderDefinedWarning(Logger logger) {
        int i = this.noAppenderWarning;
        this.noAppenderWarning = i + 1;
        if (i == 0) {
            getStatusManager().add(new WarnStatus("No appenders present in context [" + getName() + "] for logger [" + logger.getName() + "].", logger));
        }
    }

    public List<Logger> getLoggerList() {
        List<Logger> loggerList = new ArrayList<>(this.loggerCache.values());
        Collections.sort(loggerList, new LoggerComparator());
        return loggerList;
    }

    public LoggerContextVO getLoggerContextRemoteView() {
        return this.loggerContextRemoteView;
    }

    public void setPackagingDataEnabled(boolean packagingDataEnabled) {
        this.packagingDataEnabled = packagingDataEnabled;
    }

    public boolean isPackagingDataEnabled() {
        return this.packagingDataEnabled;
    }

    @Override // p001ch.qos.logback.core.ContextBase
    public void reset() {
        this.resetCount++;
        reset();
        initEvaluatorMap();
        initCollisionMaps();
        this.root.recursiveReset();
        resetTurboFilterList();
        cancelScheduledTasks();
        fireOnReset();
        resetListenersExceptResetResistant();
        resetStatusListeners();
    }

    private void cancelScheduledTasks() {
        for (ScheduledFuture<?> sf : this.scheduledFutures) {
            sf.cancel(false);
        }
        this.scheduledFutures.clear();
    }

    private void resetStatusListeners() {
        StatusManager sm = getStatusManager();
        for (StatusListener sl : sm.getCopyOfStatusListenerList()) {
            sm.remove(sl);
        }
    }

    public TurboFilterList getTurboFilterList() {
        return this.turboFilterList;
    }

    public void addTurboFilter(TurboFilter newFilter) {
        this.turboFilterList.add(newFilter);
    }

    public void resetTurboFilterList() {
        Iterator<TurboFilter> it = this.turboFilterList.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        this.turboFilterList.clear();
    }

    /* access modifiers changed from: package-private */
    public final FilterReply getTurboFilterChainDecision_0_3OrMore(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        if (this.turboFilterList.size() == 0) {
            return FilterReply.NEUTRAL;
        }
        return this.turboFilterList.getTurboFilterChainDecision(marker, logger, level, format, params, t);
    }

    /* access modifiers changed from: package-private */
    public final FilterReply getTurboFilterChainDecision_1(Marker marker, Logger logger, Level level, String format, Object param, Throwable t) {
        return this.turboFilterList.size() == 0 ? FilterReply.NEUTRAL : this.turboFilterList.getTurboFilterChainDecision(marker, logger, level, format, new Object[]{param}, t);
    }

    /* access modifiers changed from: package-private */
    public final FilterReply getTurboFilterChainDecision_2(Marker marker, Logger logger, Level level, String format, Object param1, Object param2, Throwable t) {
        return this.turboFilterList.size() == 0 ? FilterReply.NEUTRAL : this.turboFilterList.getTurboFilterChainDecision(marker, logger, level, format, new Object[]{param1, param2}, t);
    }

    public void addListener(LoggerContextListener listener) {
        this.loggerContextListenerList.add(listener);
    }

    public void removeListener(LoggerContextListener listener) {
        this.loggerContextListenerList.remove(listener);
    }

    private void resetListenersExceptResetResistant() {
        List<LoggerContextListener> toRetain = new ArrayList<>();
        for (LoggerContextListener lcl : this.loggerContextListenerList) {
            if (lcl.isResetResistant()) {
                toRetain.add(lcl);
            }
        }
        this.loggerContextListenerList.retainAll(toRetain);
    }

    private void resetAllListeners() {
        this.loggerContextListenerList.clear();
    }

    public List<LoggerContextListener> getCopyOfListenerList() {
        return new ArrayList(this.loggerContextListenerList);
    }

    /* access modifiers changed from: package-private */
    public void fireOnLevelChange(Logger logger, Level level) {
        for (LoggerContextListener listener : this.loggerContextListenerList) {
            listener.onLevelChange(logger, level);
        }
    }

    private void fireOnReset() {
        for (LoggerContextListener listener : this.loggerContextListenerList) {
            listener.onReset(this);
        }
    }

    private void fireOnStart() {
        for (LoggerContextListener listener : this.loggerContextListenerList) {
            listener.onStart(this);
        }
    }

    private void fireOnStop() {
        for (LoggerContextListener listener : this.loggerContextListenerList) {
            listener.onStop(this);
        }
    }

    @Override // p001ch.qos.logback.core.ContextBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        start();
        fireOnStart();
    }

    @Override // p001ch.qos.logback.core.ContextBase, p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        reset();
        fireOnStop();
        resetAllListeners();
        stop();
    }

    @Override // p001ch.qos.logback.core.ContextBase
    public String toString() {
        return getClass().getName() + "[" + getName() + "]";
    }

    public int getMaxCallerDataDepth() {
        return this.maxCallerDataDepth;
    }

    public void setMaxCallerDataDepth(int maxCallerDataDepth) {
        this.maxCallerDataDepth = maxCallerDataDepth;
    }

    public List<String> getFrameworkPackages() {
        return this.frameworkPackages;
    }
}
