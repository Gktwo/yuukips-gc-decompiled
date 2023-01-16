package p001ch.qos.logback.classic.jmx;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.joran.JoranConfigurator;
import p001ch.qos.logback.classic.spi.LoggerContextListener;
import p001ch.qos.logback.classic.util.ContextInitializer;
import p001ch.qos.logback.core.joran.spi.JoranException;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.status.Status;
import p001ch.qos.logback.core.status.StatusListener;
import p001ch.qos.logback.core.status.StatusListenerAsList;
import p001ch.qos.logback.core.util.StatusPrinter;

/* renamed from: ch.qos.logback.classic.jmx.JMXConfigurator */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/jmx/JMXConfigurator.class */
public class JMXConfigurator extends ContextAwareBase implements JMXConfiguratorMBean, LoggerContextListener {
    private static String EMPTY = "";
    LoggerContext loggerContext;
    MBeanServer mbs;
    ObjectName objectName;
    String objectNameAsString;
    boolean debug = true;
    boolean started = true;

    public JMXConfigurator(LoggerContext loggerContext, MBeanServer mbs, ObjectName objectName) {
        this.context = loggerContext;
        this.loggerContext = loggerContext;
        this.mbs = mbs;
        this.objectName = objectName;
        this.objectNameAsString = objectName.toString();
        if (previouslyRegisteredListenerWithSameObjectName()) {
            addError("Previously registered JMXConfigurator named [" + this.objectNameAsString + "] in the logger context named [" + loggerContext.getName() + "]");
        } else {
            loggerContext.addListener(this);
        }
    }

    private boolean previouslyRegisteredListenerWithSameObjectName() {
        for (LoggerContextListener lcl : this.loggerContext.getCopyOfListenerList()) {
            if (lcl instanceof JMXConfigurator) {
                if (this.objectName.equals(((JMXConfigurator) lcl).objectName)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p001ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public void reloadDefaultConfiguration() throws JoranException {
        reloadByURL(new ContextInitializer(this.loggerContext).findURLOfDefaultConfigurationFile(true));
    }

    @Override // p001ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public void reloadByFileName(String fileName) throws JoranException, FileNotFoundException {
        File f = new File(fileName);
        if (!f.exists() || !f.isFile()) {
            String errMsg = "Could not find [" + fileName + "]";
            addInfo(errMsg);
            throw new FileNotFoundException(errMsg);
        }
        try {
            reloadByURL(f.toURI().toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unexpected MalformedURLException occured. See nexted cause.", e);
        }
    }

    void addStatusListener(StatusListener statusListener) {
        this.loggerContext.getStatusManager().add(statusListener);
    }

    void removeStatusListener(StatusListener statusListener) {
        this.loggerContext.getStatusManager().remove(statusListener);
    }

    @Override // p001ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public void reloadByURL(URL url) throws JoranException {
        StatusListenerAsList statusListenerAsList = new StatusListenerAsList();
        addStatusListener(statusListenerAsList);
        addInfo("Resetting context: " + this.loggerContext.getName());
        this.loggerContext.reset();
        addStatusListener(statusListenerAsList);
        if (url != null) {
            try {
                JoranConfigurator configurator = new JoranConfigurator();
                configurator.setContext(this.loggerContext);
                configurator.doConfigure(url);
                addInfo("Context: " + this.loggerContext.getName() + " reloaded.");
            } catch (Throwable th) {
                removeStatusListener(statusListenerAsList);
                if (this.debug) {
                    StatusPrinter.print(statusListenerAsList.getStatusList());
                }
                throw th;
            }
        }
        removeStatusListener(statusListenerAsList);
        if (this.debug) {
            StatusPrinter.print(statusListenerAsList.getStatusList());
        }
    }

    @Override // p001ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public void setLoggerLevel(String loggerName, String levelStr) {
        if (loggerName != null && levelStr != null) {
            String loggerName2 = loggerName.trim();
            String levelStr2 = levelStr.trim();
            addInfo("Trying to set level " + levelStr2 + " to logger " + loggerName2);
            Logger logger = ((LoggerContext) this.context).getLogger(loggerName2);
            if ("null".equalsIgnoreCase(levelStr2)) {
                logger.setLevel(null);
                return;
            }
            Level level = Level.toLevel(levelStr2, (Level) null);
            if (level != null) {
                logger.setLevel(level);
            }
        }
    }

    @Override // p001ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public String getLoggerLevel(String loggerName) {
        if (loggerName == null) {
            return EMPTY;
        }
        Logger logger = ((LoggerContext) this.context).exists(loggerName.trim());
        if (logger == null || logger.getLevel() == null) {
            return EMPTY;
        }
        return logger.getLevel().toString();
    }

    @Override // p001ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public String getLoggerEffectiveLevel(String loggerName) {
        if (loggerName == null) {
            return EMPTY;
        }
        Logger logger = ((LoggerContext) this.context).exists(loggerName.trim());
        if (logger != null) {
            return logger.getEffectiveLevel().toString();
        }
        return EMPTY;
    }

    @Override // p001ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public List<String> getLoggerList() {
        LoggerContext lc = (LoggerContext) this.context;
        List<String> strList = new ArrayList<>();
        for (Logger log : lc.getLoggerList()) {
            strList.add(log.getName());
        }
        return strList;
    }

    @Override // p001ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public List<String> getStatuses() {
        List<String> list = new ArrayList<>();
        for (Status status : this.context.getStatusManager().getCopyOfStatusList()) {
            list.add(status.toString());
        }
        return list;
    }

    @Override // p001ch.qos.logback.classic.spi.LoggerContextListener
    public void onStop(LoggerContext context) {
        if (!this.started) {
            addInfo("onStop() method called on a stopped JMXActivator [" + this.objectNameAsString + "]");
            return;
        }
        if (this.mbs.isRegistered(this.objectName)) {
            try {
                addInfo("Unregistering mbean [" + this.objectNameAsString + "]");
                this.mbs.unregisterMBean(this.objectName);
            } catch (MBeanRegistrationException e) {
                addError("Failed to unregister [" + this.objectNameAsString + "]", e);
            } catch (InstanceNotFoundException e2) {
                addError("Unable to find a verifiably registered mbean [" + this.objectNameAsString + "]", e2);
            }
        } else {
            addInfo("mbean [" + this.objectNameAsString + "] was not in the mbean registry. This is OK.");
        }
        stop();
    }

    @Override // p001ch.qos.logback.classic.spi.LoggerContextListener
    public void onLevelChange(Logger logger, Level level) {
    }

    @Override // p001ch.qos.logback.classic.spi.LoggerContextListener
    public void onReset(LoggerContext context) {
        addInfo("onReset() method called JMXActivator [" + this.objectNameAsString + "]");
    }

    @Override // p001ch.qos.logback.classic.spi.LoggerContextListener
    public boolean isResetResistant() {
        return true;
    }

    private void clearFields() {
        this.mbs = null;
        this.objectName = null;
        this.loggerContext = null;
    }

    private void stop() {
        this.started = false;
        clearFields();
    }

    @Override // p001ch.qos.logback.classic.spi.LoggerContextListener
    public void onStart(LoggerContext context) {
    }

    public String toString() {
        return getClass().getName() + "(" + this.context.getName() + ")";
    }
}
