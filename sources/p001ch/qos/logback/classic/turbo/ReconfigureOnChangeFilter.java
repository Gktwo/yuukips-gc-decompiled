package p001ch.qos.logback.classic.turbo;

import java.net.URL;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import okhttp3.internal.p021ws.WebSocketProtocol;
import org.slf4j.Marker;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.joran.JoranConfigurator;
import p001ch.qos.logback.core.joran.event.SaxEvent;
import p001ch.qos.logback.core.joran.spi.ConfigurationWatchList;
import p001ch.qos.logback.core.joran.spi.JoranException;
import p001ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import p001ch.qos.logback.core.spi.FilterReply;
import p001ch.qos.logback.core.status.StatusUtil;

/* renamed from: ch.qos.logback.classic.turbo.ReconfigureOnChangeFilter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/turbo/ReconfigureOnChangeFilter.class */
public class ReconfigureOnChangeFilter extends TurboFilter {
    public static final long DEFAULT_REFRESH_PERIOD = 60000;
    URL mainConfigurationURL;
    protected volatile long nextCheck;
    ConfigurationWatchList configurationWatchList;
    private static final int MAX_MASK = 65535;
    private static final long MASK_INCREASE_THRESHOLD = 100;
    private static final long MASK_DECREASE_THRESHOLD = 800;
    long refreshPeriod = 60000;
    private long invocationCounter = 0;
    private volatile long mask = 15;
    private volatile long lastMaskCheck = System.currentTimeMillis();

    @Override // p001ch.qos.logback.classic.turbo.TurboFilter, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.configurationWatchList = ConfigurationWatchListUtil.getConfigurationWatchList(this.context);
        if (this.configurationWatchList != null) {
            this.mainConfigurationURL = this.configurationWatchList.getMainURL();
            if (this.mainConfigurationURL == null) {
                addWarn("Due to missing top level configuration file, automatic reconfiguration is impossible.");
                return;
            }
            addInfo("Will scan for changes in [" + this.configurationWatchList.getCopyOfFileWatchList() + "] every " + (this.refreshPeriod / 1000) + " seconds. ");
            synchronized (this.configurationWatchList) {
                updateNextCheck(System.currentTimeMillis());
            }
            start();
            return;
        }
        addWarn("Empty ConfigurationWatchList in context");
    }

    public String toString() {
        return "ReconfigureOnChangeFilter{invocationCounter=" + this.invocationCounter + '}';
    }

    @Override // p001ch.qos.logback.classic.turbo.TurboFilter
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        long j = this.invocationCounter;
        this.invocationCounter = j + 1;
        if ((j & this.mask) != this.mask) {
            return FilterReply.NEUTRAL;
        }
        long now = System.currentTimeMillis();
        synchronized (this.configurationWatchList) {
            updateMaskIfNecessary(now);
            if (changeDetected(now)) {
                disableSubsequentReconfiguration();
                detachReconfigurationToNewThread();
            }
        }
        return FilterReply.NEUTRAL;
    }

    private void updateMaskIfNecessary(long now) {
        long timeElapsedSinceLastMaskUpdateCheck = now - this.lastMaskCheck;
        this.lastMaskCheck = now;
        if (timeElapsedSinceLastMaskUpdateCheck < MASK_INCREASE_THRESHOLD && this.mask < WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.mask = (this.mask << 1) | 1;
        } else if (timeElapsedSinceLastMaskUpdateCheck > MASK_DECREASE_THRESHOLD) {
            this.mask >>>= 2;
        }
    }

    void detachReconfigurationToNewThread() {
        addInfo("Detected change in [" + this.configurationWatchList.getCopyOfFileWatchList() + "]");
        this.context.getExecutorService().submit(new ReconfiguringThread());
    }

    void updateNextCheck(long now) {
        this.nextCheck = now + this.refreshPeriod;
    }

    protected boolean changeDetected(long now) {
        if (now < this.nextCheck) {
            return false;
        }
        updateNextCheck(now);
        return this.configurationWatchList.changeDetected();
    }

    void disableSubsequentReconfiguration() {
        this.nextCheck = LongCompanionObject.MAX_VALUE;
    }

    public long getRefreshPeriod() {
        return this.refreshPeriod;
    }

    public void setRefreshPeriod(long refreshPeriod) {
        this.refreshPeriod = refreshPeriod;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ch.qos.logback.classic.turbo.ReconfigureOnChangeFilter$ReconfiguringThread */
    /* loaded from: grasscutter.jar:ch/qos/logback/classic/turbo/ReconfigureOnChangeFilter$ReconfiguringThread.class */
    public class ReconfiguringThread implements Runnable {
        ReconfiguringThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ReconfigureOnChangeFilter.this.mainConfigurationURL == null) {
                ReconfigureOnChangeFilter.this.addInfo("Due to missing top level configuration file, skipping reconfiguration");
                return;
            }
            LoggerContext lc = (LoggerContext) ReconfigureOnChangeFilter.this.context;
            ReconfigureOnChangeFilter.this.addInfo("Will reset and reconfigure context named [" + ReconfigureOnChangeFilter.this.context.getName() + "]");
            if (ReconfigureOnChangeFilter.this.mainConfigurationURL.toString().endsWith("xml")) {
                performXMLConfiguration(lc);
            }
        }

        private void performXMLConfiguration(LoggerContext lc) {
            JoranConfigurator jc = new JoranConfigurator();
            jc.setContext(ReconfigureOnChangeFilter.this.context);
            StatusUtil statusUtil = new StatusUtil(ReconfigureOnChangeFilter.this.context);
            List<SaxEvent> eventList = jc.recallSafeConfiguration();
            URL mainURL = ConfigurationWatchListUtil.getMainWatchURL(ReconfigureOnChangeFilter.this.context);
            lc.reset();
            long threshold = System.currentTimeMillis();
            try {
                jc.doConfigure(ReconfigureOnChangeFilter.this.mainConfigurationURL);
                if (statusUtil.hasXMLParsingErrors(threshold)) {
                    fallbackConfiguration(lc, eventList, mainURL);
                }
            } catch (JoranException e) {
                fallbackConfiguration(lc, eventList, mainURL);
            }
        }

        private void fallbackConfiguration(LoggerContext lc, List<SaxEvent> eventList, URL mainURL) {
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            joranConfigurator.setContext(ReconfigureOnChangeFilter.this.context);
            if (eventList != null) {
                ReconfigureOnChangeFilter.this.addWarn("Falling back to previously registered safe configuration.");
                try {
                    lc.reset();
                    JoranConfigurator.informContextOfURLUsedForConfiguration(ReconfigureOnChangeFilter.this.context, mainURL);
                    joranConfigurator.doConfigure(eventList);
                    ReconfigureOnChangeFilter.this.addInfo("Re-registering previous fallback configuration once more as a fallback configuration point");
                    joranConfigurator.registerSafeConfiguration(eventList);
                } catch (JoranException e) {
                    ReconfigureOnChangeFilter.this.addError("Unexpected exception thrown by a configuration considered safe.", e);
                }
            } else {
                ReconfigureOnChangeFilter.this.addWarn("No previous configuration to fall back on.");
            }
        }
    }
}
