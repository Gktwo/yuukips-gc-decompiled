package p001ch.qos.logback.classic.selector.servlet;

import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.Logger;
import p001ch.qos.logback.classic.ClassicConstants;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.selector.ContextSelector;
import p001ch.qos.logback.classic.util.ContextSelectorStaticBinder;
import p001ch.qos.logback.core.util.JNDIUtil;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.classic.selector.servlet.ContextDetachingSCL */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/selector/servlet/ContextDetachingSCL.class */
public class ContextDetachingSCL implements ServletContextListener {
    @Override // javax.servlet.ServletContextListener
    public void contextInitialized(ServletContextEvent arg0) {
    }

    @Override // javax.servlet.ServletContextListener
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        String loggerContextName = null;
        try {
            loggerContextName = JNDIUtil.lookupString(JNDIUtil.getInitialContext(), ClassicConstants.JNDI_CONTEXT_NAME);
        } catch (NamingException e) {
        }
        if (!OptionHelper.isEmpty(loggerContextName)) {
            System.out.println("About to detach context named " + loggerContextName);
            ContextSelector selector = ContextSelectorStaticBinder.getSingleton().getContextSelector();
            if (selector == null) {
                System.out.println("Selector is null, cannot detach context. Skipping.");
                return;
            }
            LoggerContext context = selector.getLoggerContext(loggerContextName);
            if (context != null) {
                context.getLogger(Logger.ROOT_LOGGER_NAME).warn("Stopping logger context " + loggerContextName);
                selector.detachLoggerContext(loggerContextName);
                context.stop();
                return;
            }
            System.out.println("No context named " + loggerContextName + " was found.");
        }
    }
}
