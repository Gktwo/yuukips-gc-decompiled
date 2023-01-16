package org.eclipse.jetty.websocket.server;

import java.io.IOException;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.pathmap.MatchedResource;
import org.eclipse.jetty.http.pathmap.PathSpec;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.quartz.utils.C3p0PoolingConnectionProvider;

@ManagedObject("WebSocket Upgrade Filter")
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/WebSocketUpgradeFilter.class */
public class WebSocketUpgradeFilter implements Filter, MappedWebSocketCreator, Dumpable {
    public static final String CONTEXT_ATTRIBUTE_KEY = "contextAttributeKey";
    public static final String CONFIG_ATTRIBUTE_KEY = "configAttributeKey";
    private NativeWebSocketConfiguration configuration;
    private boolean localConfiguration;
    private boolean alreadySetToAttribute;
    private static final Logger LOG = Log.getLogger(WebSocketUpgradeFilter.class);
    public static final String ATTR_KEY = WebSocketUpgradeFilter.class.getName();

    public static WebSocketUpgradeFilter configure(ServletContextHandler context) throws ServletException {
        WebSocketUpgradeFilter filter = (WebSocketUpgradeFilter) context.getAttribute(ATTR_KEY);
        if (filter == null) {
            filter = new WebSocketUpgradeFilter();
            filter.setToAttribute(context, ATTR_KEY);
            EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST);
            FilterHolder fholder = new FilterHolder(filter);
            fholder.setName("Jetty_WebSocketUpgradeFilter");
            fholder.setAsyncSupported(true);
            fholder.setInitParameter(CONTEXT_ATTRIBUTE_KEY, WebSocketUpgradeFilter.class.getName());
            context.addFilter(fholder, "/*", dispatcherTypes);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Adding [{}] {} mapped to {} to {}", "Jetty_WebSocketUpgradeFilter", filter, "/*", context);
            }
        }
        return filter;
    }

    @Deprecated
    public static WebSocketUpgradeFilter configureContext(ServletContextHandler context) throws ServletException {
        WebSocketUpgradeFilter upgradeFilter = configure(context);
        upgradeFilter.configuration = NativeWebSocketServletContainerInitializer.initialize(context);
        return upgradeFilter;
    }

    @Deprecated
    public static WebSocketUpgradeFilter configureContext(ServletContext context) throws ServletException {
        ServletContextHandler handler = ServletContextHandler.getServletContextHandler(context);
        if (handler != null) {
            return configureContext(handler);
        }
        throw new ServletException("Not running on Jetty, WebSocket support unavailable");
    }

    public WebSocketUpgradeFilter() {
        this.localConfiguration = false;
        this.alreadySetToAttribute = false;
    }

    @Deprecated
    public WebSocketUpgradeFilter(WebSocketServerFactory factory) {
        this(new NativeWebSocketConfiguration(factory));
    }

    @Deprecated
    public WebSocketUpgradeFilter(NativeWebSocketConfiguration configuration) {
        this.localConfiguration = false;
        this.alreadySetToAttribute = false;
        this.configuration = configuration;
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    public void addMapping(PathSpec spec, WebSocketCreator creator) {
        this.configuration.addMapping(spec, creator);
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    @Deprecated
    public void addMapping(org.eclipse.jetty.websocket.server.pathmap.PathSpec spec, WebSocketCreator creator) {
        this.configuration.addMapping(spec, creator);
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    public void addMapping(String spec, WebSocketCreator creator) {
        this.configuration.addMapping(spec, creator);
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    public boolean removeMapping(String spec) {
        return this.configuration.removeMapping(spec);
    }

    @Override // javax.servlet.Filter
    public void destroy() {
        try {
            this.alreadySetToAttribute = false;
            if (this.localConfiguration) {
                this.configuration.stop();
            }
        } catch (Exception e) {
            LOG.ignore(e);
        }
    }

    @Override // javax.servlet.Filter
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpreq;
        HttpServletResponse httpresp;
        if (this.configuration == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("WebSocketUpgradeFilter is not operational - missing " + NativeWebSocketConfiguration.class.getName(), new Object[0]);
            }
            chain.doFilter(request, response);
            return;
        }
        WebSocketServletFactory factory = this.configuration.getFactory();
        if (factory == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("WebSocketUpgradeFilter is not operational - no WebSocketServletFactory configured", new Object[0]);
            }
            chain.doFilter(request, response);
            return;
        }
        try {
            httpreq = (HttpServletRequest) request;
            httpresp = (HttpServletResponse) response;
        } catch (ClassCastException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Not an HttpServletRequest, skipping WebSocketUpgradeFilter", new Object[0]);
            }
        }
        if (!factory.isUpgradeRequest(httpreq, httpresp)) {
            chain.doFilter(request, response);
            return;
        }
        String target = httpreq.getServletPath();
        if (httpreq.getPathInfo() != null) {
            target = target + httpreq.getPathInfo();
        }
        MatchedResource<WebSocketCreator> resource = this.configuration.getMatched(target);
        if (resource == null) {
            chain.doFilter(request, response);
            return;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("WebSocket Upgrade detected on {} for endpoint {}", target, resource);
        }
        httpreq.setAttribute(PathSpec.class.getName(), resource.getPathSpec());
        if (factory.acceptWebSocket(resource.getResource(), httpreq, httpresp) || response.isCommitted()) {
            return;
        }
        chain.doFilter(request, response);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return Dumpable.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObjects(out, indent, this, this.configuration);
    }

    public WebSocketServletFactory getFactory() {
        return this.configuration.getFactory();
    }

    @ManagedAttribute(value = "configuration", readonly = true)
    public NativeWebSocketConfiguration getConfiguration() {
        if (this.configuration != null) {
            return this.configuration;
        }
        throw new IllegalStateException(getClass().getName() + " not initialized yet");
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    public WebSocketCreator getMapping(String target) {
        return getConfiguration().getMapping(target);
    }

    @Override // javax.servlet.Filter
    public void init(FilterConfig config) throws ServletException {
        try {
            String configurationKey = config.getInitParameter(CONFIG_ATTRIBUTE_KEY);
            if (configurationKey == null) {
                configurationKey = NativeWebSocketConfiguration.class.getName();
            }
            if (this.configuration == null) {
                this.configuration = (NativeWebSocketConfiguration) config.getServletContext().getAttribute(configurationKey);
                if (this.configuration == null) {
                    throw new ServletException("Unable to find required instance of " + NativeWebSocketConfiguration.class.getName() + " at ServletContext attribute '" + configurationKey + "'");
                }
            } else if (config.getServletContext().getAttribute(configurationKey) == null) {
                config.getServletContext().setAttribute(configurationKey, this.configuration);
            }
            if (!this.configuration.isRunning()) {
                this.localConfiguration = true;
                this.configuration.start();
            }
            String max = config.getInitParameter(C3p0PoolingConnectionProvider.DB_DISCARD_IDLE_CONNECTIONS_SECONDS);
            if (max != null) {
                getFactory().getPolicy().setIdleTimeout(Long.parseLong(max));
            }
            String max2 = config.getInitParameter("maxTextMessageSize");
            if (max2 != null) {
                getFactory().getPolicy().setMaxTextMessageSize(Integer.parseInt(max2));
            }
            String max3 = config.getInitParameter("maxBinaryMessageSize");
            if (max3 != null) {
                getFactory().getPolicy().setMaxBinaryMessageSize(Integer.parseInt(max3));
            }
            String max4 = config.getInitParameter("inputBufferSize");
            if (max4 != null) {
                getFactory().getPolicy().setInputBufferSize(Integer.parseInt(max4));
            }
            String instanceKey = config.getInitParameter(CONTEXT_ATTRIBUTE_KEY);
            if (instanceKey == null) {
                instanceKey = WebSocketUpgradeFilter.class.getName();
            }
            setToAttribute(config.getServletContext(), instanceKey);
        } catch (ServletException e) {
            throw e;
        } catch (Throwable t) {
            throw new ServletException(t);
        }
    }

    private void setToAttribute(ServletContextHandler context, String key) throws ServletException {
        setToAttribute(context.getServletContext(), key);
    }

    public void setToAttribute(ServletContext context, String key) throws ServletException {
        if (!this.alreadySetToAttribute) {
            if (context.getAttribute(key) != null) {
                throw new ServletException(WebSocketUpgradeFilter.class.getName() + " is defined twice for the same context attribute key '" + key + "'.  Make sure you have different init-param '" + CONTEXT_ATTRIBUTE_KEY + "' values set");
            }
            context.setAttribute(key, this);
            this.alreadySetToAttribute = true;
        }
    }

    public String toString() {
        return String.format("%s[configuration=%s]", getClass().getSimpleName(), this.configuration);
    }
}
