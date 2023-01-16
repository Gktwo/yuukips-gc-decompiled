package p001ch.qos.logback.classic.joran.action;

import java.net.URL;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.joran.ReconfigureOnChangeTask;
import p001ch.qos.logback.classic.util.EnvUtil;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import p001ch.qos.logback.core.status.OnConsoleStatusListener;
import p001ch.qos.logback.core.util.ContextUtil;
import p001ch.qos.logback.core.util.Duration;
import p001ch.qos.logback.core.util.OptionHelper;
import p001ch.qos.logback.core.util.StatusListenerConfigHelper;

/* renamed from: ch.qos.logback.classic.joran.action.ConfigurationAction */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/joran/action/ConfigurationAction.class */
public class ConfigurationAction extends Action {
    static final String INTERNAL_DEBUG_ATTR = "debug";
    static final String PACKAGING_DATA_ATTR = "packagingData";
    static final String SCAN_ATTR = "scan";
    static final String SCAN_PERIOD_ATTR = "scanPeriod";
    static final String DEBUG_SYSTEM_PROPERTY_KEY = "logback.debug";
    long threshold = 0;

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ic, String name, Attributes attributes) {
        this.threshold = System.currentTimeMillis();
        String debugAttrib = getSystemProperty(DEBUG_SYSTEM_PROPERTY_KEY);
        if (debugAttrib == null) {
            debugAttrib = ic.subst(attributes.getValue(INTERNAL_DEBUG_ATTR));
        }
        if (OptionHelper.isEmpty(debugAttrib) || debugAttrib.equalsIgnoreCase("false") || debugAttrib.equalsIgnoreCase("null")) {
            addInfo("debug attribute not set");
        } else {
            StatusListenerConfigHelper.addOnConsoleListenerInstance(this.context, new OnConsoleStatusListener());
        }
        processScanAttrib(ic, attributes);
        LoggerContext lc = (LoggerContext) this.context;
        lc.setPackagingDataEnabled(OptionHelper.toBoolean(ic.subst(attributes.getValue(PACKAGING_DATA_ATTR)), false));
        if (EnvUtil.isGroovyAvailable()) {
            new ContextUtil(this.context).addGroovyPackages(lc.getFrameworkPackages());
        }
        ic.pushObject(getContext());
    }

    String getSystemProperty(String name) {
        try {
            return System.getProperty(name);
        } catch (SecurityException e) {
            return null;
        }
    }

    void processScanAttrib(InterpretationContext ic, Attributes attributes) {
        String scanAttrib = ic.subst(attributes.getValue(SCAN_ATTR));
        if (!OptionHelper.isEmpty(scanAttrib) && !"false".equalsIgnoreCase(scanAttrib)) {
            ScheduledExecutorService scheduledExecutorService = this.context.getScheduledExecutorService();
            URL mainURL = ConfigurationWatchListUtil.getMainWatchURL(this.context);
            if (mainURL == null) {
                addWarn("Due to missing top level configuration file, reconfiguration on change (configuration file scanning) cannot be done.");
                return;
            }
            ReconfigureOnChangeTask rocTask = new ReconfigureOnChangeTask();
            rocTask.setContext(this.context);
            this.context.putObject(CoreConstants.RECONFIGURE_ON_CHANGE_TASK, rocTask);
            Duration duration = getDuration(scanAttrib, ic.subst(attributes.getValue(SCAN_PERIOD_ATTR)));
            if (duration != null) {
                addInfo("Will scan for changes in [" + mainURL + "] ");
                addInfo("Setting ReconfigureOnChangeTask scanning period to " + duration);
                this.context.addScheduledFuture(scheduledExecutorService.scheduleAtFixedRate(rocTask, duration.getMilliseconds(), duration.getMilliseconds(), TimeUnit.MILLISECONDS));
            }
        }
    }

    private Duration getDuration(String scanAttrib, String scanPeriodAttrib) {
        Duration duration = null;
        if (!OptionHelper.isEmpty(scanPeriodAttrib)) {
            try {
                duration = Duration.valueOf(scanPeriodAttrib);
            } catch (NumberFormatException nfe) {
                addError("Error while converting [" + scanAttrib + "] to long", nfe);
            }
        }
        return duration;
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String name) {
        addInfo("End of configuration.");
        ec.popObject();
    }
}
