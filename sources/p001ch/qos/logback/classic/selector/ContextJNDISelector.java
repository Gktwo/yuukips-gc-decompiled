package p001ch.qos.logback.classic.selector;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.Context;
import javax.naming.NamingException;
import p001ch.qos.logback.classic.ClassicConstants;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.joran.JoranConfigurator;
import p001ch.qos.logback.classic.util.ContextInitializer;
import p001ch.qos.logback.core.joran.spi.JoranException;
import p001ch.qos.logback.core.status.InfoStatus;
import p001ch.qos.logback.core.status.StatusManager;
import p001ch.qos.logback.core.status.StatusUtil;
import p001ch.qos.logback.core.status.WarnStatus;
import p001ch.qos.logback.core.util.JNDIUtil;
import p001ch.qos.logback.core.util.Loader;
import p001ch.qos.logback.core.util.OptionHelper;
import p001ch.qos.logback.core.util.StatusPrinter;

/* renamed from: ch.qos.logback.classic.selector.ContextJNDISelector */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/selector/ContextJNDISelector.class */
public class ContextJNDISelector implements ContextSelector {
    private final Map<String, LoggerContext> synchronizedContextMap = Collections.synchronizedMap(new HashMap());
    private final LoggerContext defaultContext;
    private static final ThreadLocal<LoggerContext> threadLocal = new ThreadLocal<>();

    public ContextJNDISelector(LoggerContext context) {
        this.defaultContext = context;
    }

    @Override // p001ch.qos.logback.classic.selector.ContextSelector
    public LoggerContext getDefaultLoggerContext() {
        return this.defaultContext;
    }

    @Override // p001ch.qos.logback.classic.selector.ContextSelector
    public LoggerContext detachLoggerContext(String loggerContextName) {
        return this.synchronizedContextMap.remove(loggerContextName);
    }

    @Override // p001ch.qos.logback.classic.selector.ContextSelector
    public LoggerContext getLoggerContext() {
        String contextName = null;
        Context ctx = null;
        LoggerContext lc = threadLocal.get();
        if (lc != null) {
            return lc;
        }
        try {
            ctx = JNDIUtil.getInitialContext();
            contextName = JNDIUtil.lookupString(ctx, ClassicConstants.JNDI_CONTEXT_NAME);
        } catch (NamingException e) {
        }
        if (OptionHelper.isEmpty(contextName)) {
            return this.defaultContext;
        }
        LoggerContext loggerContext = this.synchronizedContextMap.get(contextName);
        if (loggerContext == null) {
            loggerContext = new LoggerContext();
            loggerContext.setName(contextName);
            this.synchronizedContextMap.put(contextName, loggerContext);
            URL url = findConfigFileURL(ctx, loggerContext);
            if (url != null) {
                configureLoggerContextByURL(loggerContext, url);
            } else {
                try {
                    new ContextInitializer(loggerContext).autoConfig();
                } catch (JoranException e2) {
                }
            }
            if (!StatusUtil.contextHasStatusListener(loggerContext)) {
                StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
            }
        }
        return loggerContext;
    }

    private String conventionalConfigFileName(String contextName) {
        return "logback-" + contextName + ".xml";
    }

    private URL findConfigFileURL(Context ctx, LoggerContext loggerContext) {
        StatusManager sm = loggerContext.getStatusManager();
        String jndiEntryForConfigResource = null;
        try {
            jndiEntryForConfigResource = JNDIUtil.lookupString(ctx, ClassicConstants.JNDI_CONFIGURATION_RESOURCE);
        } catch (NamingException e) {
        }
        if (jndiEntryForConfigResource == null) {
            return urlByResourceName(sm, conventionalConfigFileName(loggerContext.getName()));
        }
        sm.add(new InfoStatus("Searching for [" + jndiEntryForConfigResource + "]", this));
        URL url = urlByResourceName(sm, jndiEntryForConfigResource);
        if (url == null) {
            sm.add(new WarnStatus("The jndi resource [" + jndiEntryForConfigResource + "] for context [" + loggerContext.getName() + "] does not lead to a valid file", this));
        }
        return url;
    }

    private URL urlByResourceName(StatusManager sm, String resourceName) {
        sm.add(new InfoStatus("Searching for [" + resourceName + "]", this));
        URL url = Loader.getResource(resourceName, Loader.getTCL());
        if (url != null) {
            return url;
        }
        return Loader.getResourceBySelfClassLoader(resourceName);
    }

    private void configureLoggerContextByURL(LoggerContext context, URL url) {
        try {
            JoranConfigurator configurator = new JoranConfigurator();
            context.reset();
            configurator.setContext(context);
            configurator.doConfigure(url);
        } catch (JoranException e) {
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(context);
    }

    @Override // p001ch.qos.logback.classic.selector.ContextSelector
    public List<String> getContextNames() {
        List<String> list = new ArrayList<>();
        list.addAll(this.synchronizedContextMap.keySet());
        return list;
    }

    @Override // p001ch.qos.logback.classic.selector.ContextSelector
    public LoggerContext getLoggerContext(String name) {
        return this.synchronizedContextMap.get(name);
    }

    public int getCount() {
        return this.synchronizedContextMap.size();
    }

    public void setLocalContext(LoggerContext context) {
        threadLocal.set(context);
    }

    public void removeLocalContext() {
        threadLocal.remove();
    }
}
