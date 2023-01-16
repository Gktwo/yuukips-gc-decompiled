package p001ch.qos.logback.classic.jul;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.spi.LoggerContextListener;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.classic.jul.LevelChangePropagator */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/jul/LevelChangePropagator.class */
public class LevelChangePropagator extends ContextAwareBase implements LoggerContextListener, LifeCycle {
    private Set<Logger> julLoggerSet = new HashSet();
    boolean isStarted = false;
    boolean resetJUL = false;

    public void setResetJUL(boolean resetJUL) {
        this.resetJUL = resetJUL;
    }

    @Override // p001ch.qos.logback.classic.spi.LoggerContextListener
    public boolean isResetResistant() {
        return false;
    }

    @Override // p001ch.qos.logback.classic.spi.LoggerContextListener
    public void onStart(LoggerContext context) {
    }

    @Override // p001ch.qos.logback.classic.spi.LoggerContextListener
    public void onReset(LoggerContext context) {
    }

    @Override // p001ch.qos.logback.classic.spi.LoggerContextListener
    public void onStop(LoggerContext context) {
    }

    @Override // p001ch.qos.logback.classic.spi.LoggerContextListener
    public void onLevelChange(p001ch.qos.logback.classic.Logger logger, Level level) {
        propagate(logger, level);
    }

    private void propagate(p001ch.qos.logback.classic.Logger logger, Level level) {
        addInfo("Propagating " + level + " level on " + logger + " onto the JUL framework");
        Logger julLogger = JULHelper.asJULLogger(logger);
        this.julLoggerSet.add(julLogger);
        julLogger.setLevel(JULHelper.asJULLevel(level));
    }

    public void resetJULLevels() {
        LogManager lm = LogManager.getLogManager();
        Enumeration<String> e = lm.getLoggerNames();
        while (e.hasMoreElements()) {
            String loggerName = e.nextElement();
            Logger julLogger = lm.getLogger(loggerName);
            if (JULHelper.isRegularNonRootLogger(julLogger) && julLogger.getLevel() != null) {
                addInfo("Setting level of jul logger [" + loggerName + "] to null");
                julLogger.setLevel(null);
            }
        }
    }

    private void propagateExistingLoggerLevels() {
        for (p001ch.qos.logback.classic.Logger l : ((LoggerContext) this.context).getLoggerList()) {
            if (l.getLevel() != null) {
                propagate(l, l.getLevel());
            }
        }
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.resetJUL) {
            resetJULLevels();
        }
        propagateExistingLoggerLevels();
        this.isStarted = true;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.isStarted = false;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.isStarted;
    }
}
