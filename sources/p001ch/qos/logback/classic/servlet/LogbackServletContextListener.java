package p001ch.qos.logback.classic.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.util.StatusViaSLF4JLoggerFactory;
import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.classic.servlet.LogbackServletContextListener */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/servlet/LogbackServletContextListener.class */
public class LogbackServletContextListener implements ServletContextListener {
    ContextAwareBase contextAwareBase = new ContextAwareBase();

    @Override // javax.servlet.ServletContextListener
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override // javax.servlet.ServletContextListener
    public void contextDestroyed(ServletContextEvent sce) {
        ILoggerFactory iLoggerFactory = LoggerFactory.getILoggerFactory();
        if (iLoggerFactory instanceof LoggerContext) {
            LoggerContext loggerContext = (LoggerContext) iLoggerFactory;
            this.contextAwareBase.setContext(loggerContext);
            StatusViaSLF4JLoggerFactory.addInfo("About to stop " + loggerContext.getClass().getCanonicalName() + " [" + loggerContext.getName() + "]", this);
            loggerContext.stop();
        }
    }
}
