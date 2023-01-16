package org.eclipse.jetty.server.handler;

import dev.morphia.mapping.Mapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;
import net.bytebuddy.utility.JavaConstant;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.server.ClassLoaderDump;
import org.eclipse.jetty.server.Dispatcher;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HandlerContainer;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.SymlinkAllowedResourceAliasChecker;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.AttributesMap;
import org.eclipse.jetty.util.FutureCallback;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.component.Graceful;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;

@ManagedObject("URI Context")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandler.class */
public class ContextHandler extends ScopedHandler implements Attributes, Graceful {
    public static final int SERVLET_MAJOR_VERSION = 3;
    public static final int SERVLET_MINOR_VERSION = 1;
    public static final int DEFAULT_LISTENER_TYPE_INDEX = 1;
    public static final int EXTENDED_LISTENER_TYPE_INDEX = 0;
    private static final String UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER = "Unimplemented {} - use org.eclipse.jetty.servlet.ServletContextHandler";
    public static final String MANAGED_ATTRIBUTES = "org.eclipse.jetty.server.context.ManagedAttributes";
    public static final String MAX_FORM_KEYS_KEY = "org.eclipse.jetty.server.Request.maxFormKeys";
    public static final String MAX_FORM_CONTENT_SIZE_KEY = "org.eclipse.jetty.server.Request.maxFormContentSize";
    public static final int DEFAULT_MAX_FORM_KEYS = 1000;
    public static final int DEFAULT_MAX_FORM_CONTENT_SIZE = 200000;
    protected ContextStatus _contextStatus;
    protected Context _scontext;
    private final AttributesMap _attributes;
    private final Map<String, String> _initParams;
    private ClassLoader _classLoader;
    private String _contextPath;
    private String _contextPathEncoded;
    private String _displayName;
    private Resource _baseResource;
    private MimeTypes _mimeTypes;
    private Map<String, String> _localeEncodingMap;
    private String[] _welcomeFiles;
    private ErrorHandler _errorHandler;
    private String[] _vhosts;
    private boolean[] _vhostswildcard;
    private String[] _vconnectors;
    private Logger _logger;
    private boolean _allowNullPathInfo;
    private int _maxFormKeys;
    private int _maxFormContentSize;
    private boolean _compactPath;
    private boolean _usingSecurityManager;
    private final List<EventListener> _eventListeners;
    private final List<EventListener> _programmaticListeners;
    private final List<ServletContextListener> _servletContextListeners;
    private final List<ServletContextListener> _destroyServletContextListeners;
    private final List<ServletContextAttributeListener> _servletContextAttributeListeners;
    private final List<ServletRequestListener> _servletRequestListeners;
    private final List<ServletRequestAttributeListener> _servletRequestAttributeListeners;
    private final List<ContextScopeListener> _contextListeners;
    private final List<EventListener> _durableListeners;
    private String[] _protectedTargets;
    private final List<AliasCheck> _aliasChecks;
    private final AtomicReference<Availability> _availability;
    public static final Class<?>[] SERVLET_LISTENER_TYPES = {ServletContextListener.class, ServletContextAttributeListener.class, ServletRequestListener.class, ServletRequestAttributeListener.class, HttpSessionIdListener.class, HttpSessionListener.class, HttpSessionAttributeListener.class};
    private static final Logger LOG = Log.getLogger(ContextHandler.class);
    private static final ThreadLocal<Context> __context = new ThreadLocal<>();
    private static String __serverInfo = "jetty/" + Server.getVersion();

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandler$AliasCheck.class */
    public interface AliasCheck {
        boolean check(String str, Resource resource);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandler$Availability.class */
    public enum Availability {
        STOPPED,
        STARTING,
        AVAILABLE,
        UNAVAILABLE,
        SHUTDOWN
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandler$ContextScopeListener.class */
    public interface ContextScopeListener extends EventListener {
        void enterScope(Context context, Request request, Object obj);

        void exitScope(Context context, Request request);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandler$ContextStatus.class */
    public enum ContextStatus {
        NOTSET,
        INITIALIZED,
        DESTROYED
    }

    public static Context getCurrentContext() {
        return __context.get();
    }

    public static ContextHandler getContextHandler(ServletContext context) {
        if (context instanceof Context) {
            return ((Context) context).getContextHandler();
        }
        Context c = getCurrentContext();
        if (c != null) {
            return c.getContextHandler();
        }
        return null;
    }

    public static String getServerInfo() {
        return __serverInfo;
    }

    public static void setServerInfo(String serverInfo) {
        __serverInfo = serverInfo;
    }

    public ContextHandler() {
        this(null, null, null);
    }

    protected ContextHandler(Context context) {
        this(context, null, null);
    }

    public ContextHandler(String contextPath) {
        this(null, null, contextPath);
    }

    public ContextHandler(HandlerContainer parent, String contextPath) {
        this(null, parent, contextPath);
    }

    private ContextHandler(Context context, HandlerContainer parent, String contextPath) {
        this._contextStatus = ContextStatus.NOTSET;
        this._contextPath = "/";
        this._contextPathEncoded = "/";
        this._maxFormKeys = Integer.getInteger(MAX_FORM_KEYS_KEY, 1000).intValue();
        this._maxFormContentSize = Integer.getInteger(MAX_FORM_CONTENT_SIZE_KEY, (int) DEFAULT_MAX_FORM_CONTENT_SIZE).intValue();
        this._compactPath = false;
        this._usingSecurityManager = System.getSecurityManager() != null;
        this._eventListeners = new CopyOnWriteArrayList();
        this._programmaticListeners = new CopyOnWriteArrayList();
        this._servletContextListeners = new CopyOnWriteArrayList();
        this._destroyServletContextListeners = new ArrayList();
        this._servletContextAttributeListeners = new CopyOnWriteArrayList();
        this._servletRequestListeners = new CopyOnWriteArrayList();
        this._servletRequestAttributeListeners = new CopyOnWriteArrayList();
        this._contextListeners = new CopyOnWriteArrayList();
        this._durableListeners = new CopyOnWriteArrayList();
        this._aliasChecks = new CopyOnWriteArrayList();
        this._availability = new AtomicReference<>(Availability.STOPPED);
        this._scontext = context == null ? new Context() : context;
        this._attributes = new AttributesMap();
        this._initParams = new HashMap();
        if (File.separatorChar == '/') {
            addAliasCheck(new SymlinkAllowedResourceAliasChecker(this));
        }
        if (contextPath != null) {
            setContextPath(contextPath);
        }
        if (parent instanceof HandlerWrapper) {
            ((HandlerWrapper) parent).setHandler(this);
        } else if (parent instanceof HandlerCollection) {
            ((HandlerCollection) parent).addHandler(this);
        }
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        dumpObjects(out, indent, new ClassLoaderDump(getClassLoader()), new DumpableCollection("eventListeners " + this, this._eventListeners), new DumpableCollection("handler attributes " + this, ((AttributesMap) getAttributes()).getAttributeEntrySet()), new DumpableCollection("context attributes " + this, getServletContext().getAttributeEntrySet()), new DumpableCollection("initparams " + this, getInitParams().entrySet()));
    }

    public Context getServletContext() {
        return this._scontext;
    }

    @ManagedAttribute("Checks if the /context is not redirected to /context/")
    public boolean getAllowNullPathInfo() {
        return this._allowNullPathInfo;
    }

    public void setAllowNullPathInfo(boolean allowNullPathInfo) {
        this._allowNullPathInfo = allowNullPathInfo;
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandlerContainer, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void setServer(Server server) {
        setServer(server);
        if (this._errorHandler != null) {
            this._errorHandler.setServer(server);
        }
    }

    public boolean isUsingSecurityManager() {
        return this._usingSecurityManager;
    }

    public void setUsingSecurityManager(boolean usingSecurityManager) {
        if (!usingSecurityManager || System.getSecurityManager() != null) {
            this._usingSecurityManager = usingSecurityManager;
            return;
        }
        throw new IllegalStateException("No security manager");
    }

    public void setVirtualHosts(String[] vhosts) {
        if (vhosts == null) {
            this._vhosts = vhosts;
            return;
        }
        boolean hostMatch = false;
        boolean connectorHostMatch = false;
        this._vhosts = new String[vhosts.length];
        this._vconnectors = new String[vhosts.length];
        this._vhostswildcard = new boolean[vhosts.length];
        ArrayList<Integer> connectorOnlyIndexes = null;
        for (int i = 0; i < vhosts.length; i++) {
            boolean connectorMatch = false;
            this._vhosts[i] = vhosts[i];
            if (vhosts[i] != null) {
                int connectorIndex = this._vhosts[i].indexOf(64);
                if (connectorIndex >= 0) {
                    connectorMatch = true;
                    this._vconnectors[i] = this._vhosts[i].substring(connectorIndex + 1);
                    this._vhosts[i] = this._vhosts[i].substring(0, connectorIndex);
                    if (connectorIndex == 0) {
                        if (connectorOnlyIndexes == null) {
                            connectorOnlyIndexes = new ArrayList<>();
                        }
                        connectorOnlyIndexes.add(Integer.valueOf(i));
                    }
                }
                if (this._vhosts[i].startsWith("*.")) {
                    this._vhosts[i] = this._vhosts[i].substring(1);
                    this._vhostswildcard[i] = true;
                }
                if (this._vhosts[i].isEmpty()) {
                    this._vhosts[i] = null;
                } else {
                    hostMatch = true;
                    connectorHostMatch = connectorHostMatch || connectorMatch;
                }
                this._vhosts[i] = normalizeHostname(this._vhosts[i]);
            }
        }
        if (!(connectorOnlyIndexes == null || !hostMatch || connectorHostMatch)) {
            LOG.warn("ContextHandler {} has a connector only entry e.g. \"@connector\" and one or more host only entries. \nThe host entries will be ignored to match legacy behavior.  To clear this warning remove the host entries or update to use at least one host@connector syntax entry that will match a host for an specific connector", Arrays.asList(vhosts));
            String[] filteredHosts = new String[connectorOnlyIndexes.size()];
            for (int i2 = 0; i2 < connectorOnlyIndexes.size(); i2++) {
                filteredHosts[i2] = vhosts[connectorOnlyIndexes.get(i2).intValue()];
            }
            setVirtualHosts(filteredHosts);
        }
    }

    public void addVirtualHosts(String[] virtualHosts) {
        if (!(virtualHosts == null || virtualHosts.length == 0)) {
            if (this._vhosts == null) {
                setVirtualHosts(virtualHosts);
                return;
            }
            Set<String> currentVirtualHosts = new HashSet<>(Arrays.asList(getVirtualHosts()));
            for (String vh : virtualHosts) {
                currentVirtualHosts.add(normalizeHostname(vh));
            }
            setVirtualHosts((String[]) currentVirtualHosts.toArray(new String[0]));
        }
    }

    public void removeVirtualHosts(String[] virtualHosts) {
        if (virtualHosts != null && virtualHosts.length != 0 && this._vhosts != null && this._vhosts.length != 0) {
            Set<String> existingVirtualHosts = new HashSet<>(Arrays.asList(getVirtualHosts()));
            for (String vh : virtualHosts) {
                existingVirtualHosts.remove(normalizeHostname(vh));
            }
            if (existingVirtualHosts.isEmpty()) {
                setVirtualHosts(null);
            } else {
                setVirtualHosts((String[]) existingVirtualHosts.toArray(new String[0]));
            }
        }
    }

    @ManagedAttribute(value = "Virtual hosts accepted by the context", readonly = true)
    public String[] getVirtualHosts() {
        if (this._vhosts == null) {
            return null;
        }
        String[] vhosts = new String[this._vhosts.length];
        for (int i = 0; i < this._vhosts.length; i++) {
            StringBuilder sb = new StringBuilder();
            if (this._vhostswildcard[i]) {
                sb.append("*");
            }
            if (this._vhosts[i] != null) {
                sb.append(this._vhosts[i]);
            }
            if (this._vconnectors[i] != null) {
                sb.append("@").append(this._vconnectors[i]);
            }
            vhosts[i] = sb.toString();
        }
        return vhosts;
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Object getAttribute(String name) {
        return this._attributes.getAttribute(name);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Enumeration<String> getAttributeNames() {
        return AttributesMap.getAttributeNamesCopy(this._attributes);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Set<String> getAttributeNameSet() {
        return this._attributes.getAttributeNameSet();
    }

    public Attributes getAttributes() {
        return this._attributes;
    }

    public ClassLoader getClassLoader() {
        return this._classLoader;
    }

    @ManagedAttribute("The file classpath")
    public String getClassPath() {
        if (this._classLoader == null || !(this._classLoader instanceof URLClassLoader)) {
            return null;
        }
        URL[] urls = ((URLClassLoader) this._classLoader).getURLs();
        StringBuilder classpath = new StringBuilder();
        for (URL url : urls) {
            try {
                File file = newResource(url).getFile();
                if (file != null && file.exists()) {
                    if (classpath.length() > 0) {
                        classpath.append(File.pathSeparatorChar);
                    }
                    classpath.append(file.getAbsolutePath());
                }
            } catch (IOException e) {
                LOG.debug(e);
            }
        }
        if (classpath.length() == 0) {
            return null;
        }
        return classpath.toString();
    }

    @ManagedAttribute("True if URLs are compacted to replace the multiple '/'s with a single '/'")
    public String getContextPath() {
        return this._contextPath;
    }

    public String getContextPathEncoded() {
        return this._contextPathEncoded;
    }

    public String getRequestContextPath() {
        String contextPathEncoded = getContextPathEncoded();
        return "/".equals(contextPathEncoded) ? "" : contextPathEncoded;
    }

    public String getInitParameter(String name) {
        return this._initParams.get(name);
    }

    public String setInitParameter(String name, String value) {
        return this._initParams.put(name, value);
    }

    public Enumeration<String> getInitParameterNames() {
        return Collections.enumeration(this._initParams.keySet());
    }

    @ManagedAttribute("Initial Parameter map for the context")
    public Map<String, String> getInitParams() {
        return this._initParams;
    }

    @ManagedAttribute(value = "Display name of the Context", readonly = true)
    public String getDisplayName() {
        return this._displayName;
    }

    public EventListener[] getEventListeners() {
        return (EventListener[]) this._eventListeners.toArray(new EventListener[0]);
    }

    public void setEventListeners(EventListener[] eventListeners) {
        this._contextListeners.clear();
        this._servletContextListeners.clear();
        this._servletContextAttributeListeners.clear();
        this._servletRequestListeners.clear();
        this._servletRequestAttributeListeners.clear();
        this._eventListeners.clear();
        if (eventListeners != null) {
            for (EventListener listener : eventListeners) {
                addEventListener(listener);
            }
        }
    }

    public void addEventListener(EventListener listener) {
        this._eventListeners.add(listener);
        if (!isStarted() && !isStarting()) {
            this._durableListeners.add(listener);
        }
        if (listener instanceof ContextScopeListener) {
            this._contextListeners.add((ContextScopeListener) listener);
            if (__context.get() != null) {
                ((ContextScopeListener) listener).enterScope(__context.get(), null, "Listener registered");
            }
        }
        if (listener instanceof ServletContextListener) {
            this._servletContextListeners.add((ServletContextListener) listener);
        }
        if (listener instanceof ServletContextAttributeListener) {
            this._servletContextAttributeListeners.add((ServletContextAttributeListener) listener);
        }
        if (listener instanceof ServletRequestListener) {
            this._servletRequestListeners.add((ServletRequestListener) listener);
        }
        if (listener instanceof ServletRequestAttributeListener) {
            this._servletRequestAttributeListeners.add((ServletRequestAttributeListener) listener);
        }
    }

    public void removeEventListener(EventListener listener) {
        this._eventListeners.remove(listener);
        if (listener instanceof ContextScopeListener) {
            this._contextListeners.remove(listener);
        }
        if (listener instanceof ServletContextListener) {
            this._servletContextListeners.remove(listener);
            this._destroyServletContextListeners.remove(listener);
        }
        if (listener instanceof ServletContextAttributeListener) {
            this._servletContextAttributeListeners.remove(listener);
        }
        if (listener instanceof ServletRequestListener) {
            this._servletRequestListeners.remove(listener);
        }
        if (listener instanceof ServletRequestAttributeListener) {
            this._servletRequestAttributeListeners.remove(listener);
        }
    }

    /* access modifiers changed from: protected */
    public void addProgrammaticListener(EventListener listener) {
        this._programmaticListeners.add(listener);
    }

    public boolean isProgrammaticListener(EventListener listener) {
        return this._programmaticListeners.contains(listener);
    }

    public boolean isDurableListener(EventListener listener) {
        return this._durableListeners.contains(listener);
    }

    @Override // org.eclipse.jetty.util.component.Graceful
    @ManagedAttribute("true for graceful shutdown, which allows existing requests to complete")
    public boolean isShutdown() {
        return this._availability.get() == Availability.SHUTDOWN;
    }

    @Override // org.eclipse.jetty.util.component.Graceful
    public Future<Void> shutdown() {
        Availability availability;
        do {
            availability = this._availability.get();
            switch (availability) {
                case STOPPED:
                    return new FutureCallback(new IllegalStateException(getState()));
                case STARTING:
                case AVAILABLE:
                case UNAVAILABLE:
                    break;
                default:
                    return new FutureCallback(true);
            }
        } while (!this._availability.compareAndSet(availability, Availability.SHUTDOWN));
        return new FutureCallback(true);
    }

    public boolean isAvailable() {
        return this._availability.get() == Availability.AVAILABLE;
    }

    public void setAvailable(boolean available) {
        Availability availability;
        Availability availability2;
        if (available) {
            do {
                availability2 = this._availability.get();
                switch (availability2) {
                    case AVAILABLE:
                        return;
                    case UNAVAILABLE:
                        break;
                    default:
                        throw new IllegalStateException(availability2.toString());
                }
            } while (!this._availability.compareAndSet(availability2, Availability.AVAILABLE));
            return;
        }
        do {
            availability = this._availability.get();
            switch (availability) {
                case STARTING:
                case AVAILABLE:
                    break;
                default:
                    return;
            }
        } while (!this._availability.compareAndSet(availability, Availability.UNAVAILABLE));
    }

    public Logger getLogger() {
        return this._logger;
    }

    public void setLogger(Logger logger) {
        this._logger = logger;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.ScopedHandler, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this._availability.set(Availability.STARTING);
        if (this._contextPath == null) {
            throw new IllegalStateException("Null contextPath");
        }
        if (this._logger == null) {
            this._logger = Log.getLogger(ContextHandler.class.getName() + getLogNameSuffix());
        }
        ClassLoader oldClassloader = null;
        Thread currentThread = null;
        Context oldContext = null;
        this._attributes.setAttribute("org.eclipse.jetty.server.Executor", getServer().getThreadPool());
        if (this._mimeTypes == null) {
            this._mimeTypes = new MimeTypes();
        }
        try {
            if (this._classLoader != null) {
                currentThread = Thread.currentThread();
                oldClassloader = currentThread.getContextClassLoader();
                currentThread.setContextClassLoader(this._classLoader);
            }
            oldContext = __context.get();
            __context.set(this._scontext);
            enterScope(null, getState());
            startContext();
            contextInitialized();
            this._availability.compareAndSet(Availability.STARTING, Availability.AVAILABLE);
            LOG.info("Started {}", this);
            this._availability.compareAndSet(Availability.STARTING, Availability.UNAVAILABLE);
            exitScope(null);
            __context.set(oldContext);
            if (this._classLoader != null && currentThread != null) {
                currentThread.setContextClassLoader(oldClassloader);
            }
        } catch (Throwable th) {
            this._availability.compareAndSet(Availability.STARTING, Availability.UNAVAILABLE);
            exitScope(null);
            __context.set(oldContext);
            if (!(this._classLoader == null || currentThread == null)) {
                currentThread.setContextClassLoader(oldClassloader);
            }
            throw th;
        }
    }

    private String getLogNameSuffix() {
        String logName = getDisplayName();
        if (StringUtil.isBlank(logName)) {
            logName = getContextPath();
            if (logName != null && logName.startsWith("/")) {
                logName = logName.substring(1);
            }
            if (StringUtil.isBlank(logName)) {
                logName = org.slf4j.Logger.ROOT_LOGGER_NAME;
            }
        }
        return '.' + logName.replaceAll("\\W", JavaConstant.Dynamic.DEFAULT_NAME);
    }

    /* access modifiers changed from: protected */
    public void startContext() throws Exception {
        String managedAttributes = this._initParams.get(MANAGED_ATTRIBUTES);
        if (managedAttributes != null) {
            addEventListener(new ManagedAttributeListener(this, StringUtil.csvSplit(managedAttributes)));
        }
        doStart();
    }

    public void contextInitialized() throws Exception {
        switch (this._contextStatus) {
            case NOTSET:
                try {
                    this._destroyServletContextListeners.clear();
                    if (!this._servletContextListeners.isEmpty()) {
                        ServletContextEvent event = new ServletContextEvent(this._scontext);
                        for (ServletContextListener listener : this._servletContextListeners) {
                            callContextInitialized(listener, event);
                            this._destroyServletContextListeners.add(listener);
                        }
                    }
                    return;
                } finally {
                    this._contextStatus = ContextStatus.INITIALIZED;
                }
            default:
                return;
        }
    }

    public void contextDestroyed() throws Exception {
        switch (this._contextStatus) {
            case INITIALIZED:
                try {
                    MultiException ex = new MultiException();
                    ServletContextEvent event = new ServletContextEvent(this._scontext);
                    Collections.reverse(this._destroyServletContextListeners);
                    for (ServletContextListener listener : this._destroyServletContextListeners) {
                        try {
                            callContextDestroyed(listener, event);
                        } catch (Exception x) {
                            ex.add(x);
                        }
                    }
                    ex.ifExceptionThrow();
                    this._contextStatus = ContextStatus.DESTROYED;
                    return;
                } catch (Throwable th) {
                    this._contextStatus = ContextStatus.DESTROYED;
                    throw th;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void stopContext() throws Exception {
        doStop();
    }

    /* access modifiers changed from: protected */
    public void callContextInitialized(ServletContextListener l, ServletContextEvent e) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("contextInitialized: {}->{}", e, l);
        }
        l.contextInitialized(e);
    }

    /* access modifiers changed from: protected */
    public void callContextDestroyed(ServletContextListener l, ServletContextEvent e) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("contextDestroyed: {}->{}", e, l);
        }
        l.contextDestroyed(e);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:20:0x00d7
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 474
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.handler.ContextHandler.doStop():void");
    }

    public boolean checkVirtualHost(Request baseRequest) {
        if (this._vhosts == null || this._vhosts.length == 0) {
            return true;
        }
        String vhost = normalizeHostname(baseRequest.getServerName());
        String connectorName = baseRequest.getHttpChannel().getConnector().getName();
        for (int i = 0; i < this._vhosts.length; i++) {
            String contextVhost = this._vhosts[i];
            String contextVConnector = this._vconnectors[i];
            if (contextVConnector != null) {
                if (!contextVConnector.equalsIgnoreCase(connectorName)) {
                    continue;
                } else if (contextVhost == null) {
                    return true;
                }
            }
            if (contextVhost == null) {
                continue;
            } else if (this._vhostswildcard[i]) {
                int index = vhost.indexOf(Mapper.IGNORED_FIELDNAME);
                if (index >= 0 && vhost.substring(index).equalsIgnoreCase(contextVhost)) {
                    return true;
                }
            } else if (vhost.equalsIgnoreCase(contextVhost)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkContextPath(String uri) {
        if (this._contextPath.length() <= 1) {
            return true;
        }
        if (!uri.startsWith(this._contextPath)) {
            return false;
        }
        return uri.length() <= this._contextPath.length() || uri.charAt(this._contextPath.length()) == '/';
    }

    public boolean checkContext(String target, Request baseRequest, HttpServletResponse response) throws IOException {
        DispatcherType dispatch = baseRequest.getDispatcherType();
        if (!checkVirtualHost(baseRequest) || !checkContextPath(target)) {
            return false;
        }
        if (this._allowNullPathInfo || this._contextPath.length() != target.length() || this._contextPath.length() <= 1) {
            switch (this._availability.get()) {
                case STOPPED:
                    return false;
                case STARTING:
                case AVAILABLE:
                default:
                    if (!DispatcherType.REQUEST.equals(dispatch) || !baseRequest.isHandled()) {
                        return true;
                    }
                    return false;
                case UNAVAILABLE:
                case SHUTDOWN:
                    baseRequest.setHandled(true);
                    response.sendError(503);
                    return false;
            }
        } else {
            baseRequest.setHandled(true);
            String queryString = baseRequest.getQueryString();
            baseRequest.getResponse().sendRedirect(302, baseRequest.getRequestURI() + (queryString == null ? "/" : "/?" + queryString), true);
            return false;
        }
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler
    public void doScope(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("scope {}|{}|{} @ {}", baseRequest.getContextPath(), baseRequest.getServletPath(), baseRequest.getPathInfo(), this);
        }
        String oldContextPath = null;
        String oldServletPath = null;
        String oldPathInfo = null;
        ClassLoader oldClassloader = null;
        Thread currentThread = null;
        String pathInfo = target;
        DispatcherType dispatch = baseRequest.getDispatcherType();
        Context oldContext = baseRequest.getContext();
        if (oldContext != this._scontext) {
            if (DispatcherType.REQUEST.equals(dispatch) || DispatcherType.ASYNC.equals(dispatch)) {
                if (isCompactPath()) {
                    target = URIUtil.compactPath(target);
                }
                if (checkContext(target, baseRequest, response)) {
                    if (target.length() > this._contextPath.length()) {
                        if (this._contextPath.length() > 1) {
                            target = target.substring(this._contextPath.length());
                        }
                        pathInfo = target;
                    } else if (this._contextPath.length() == 1) {
                        target = "/";
                        pathInfo = "/";
                    } else {
                        target = "/";
                        pathInfo = null;
                    }
                } else {
                    return;
                }
            }
            if (this._classLoader != null) {
                currentThread = Thread.currentThread();
                oldClassloader = currentThread.getContextClassLoader();
                currentThread.setContextClassLoader(this._classLoader);
            }
        }
        try {
            oldContextPath = baseRequest.getContextPath();
            oldServletPath = baseRequest.getServletPath();
            oldPathInfo = baseRequest.getPathInfo();
            baseRequest.setContext(this._scontext);
            __context.set(this._scontext);
            if (!DispatcherType.INCLUDE.equals(dispatch) && target.startsWith("/")) {
                baseRequest.setContextPath(getRequestContextPath());
                baseRequest.setServletPath(null);
                baseRequest.setPathInfo(pathInfo);
            }
            if (oldContext != this._scontext) {
                enterScope(baseRequest, dispatch);
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("context={}|{}|{} @ {}", baseRequest.getContextPath(), baseRequest.getServletPath(), baseRequest.getPathInfo(), this);
            }
            nextScope(target, baseRequest, request, response);
            if (oldContext != this._scontext) {
                exitScope(baseRequest);
                if (!(this._classLoader == null || currentThread == null)) {
                    currentThread.setContextClassLoader(oldClassloader);
                }
                baseRequest.setContext(oldContext);
                __context.set(oldContext);
                baseRequest.setContextPath(oldContextPath);
                baseRequest.setServletPath(oldServletPath);
                baseRequest.setPathInfo(oldPathInfo);
            }
        } catch (Throwable th) {
            if (oldContext != this._scontext) {
                exitScope(baseRequest);
                if (!(this._classLoader == null || currentThread == null)) {
                    currentThread.setContextClassLoader(oldClassloader);
                }
                baseRequest.setContext(oldContext);
                __context.set(oldContext);
                baseRequest.setContextPath(oldContextPath);
                baseRequest.setServletPath(oldServletPath);
                baseRequest.setPathInfo(oldPathInfo);
            }
            throw th;
        }
    }

    protected void requestInitialized(Request baseRequest, HttpServletRequest request) {
        if (!this._servletRequestAttributeListeners.isEmpty()) {
            for (ServletRequestAttributeListener l : this._servletRequestAttributeListeners) {
                baseRequest.addEventListener(l);
            }
        }
        if (!this._servletRequestListeners.isEmpty()) {
            ServletRequestEvent sre = new ServletRequestEvent(this._scontext, request);
            for (ServletRequestListener l2 : this._servletRequestListeners) {
                l2.requestInitialized(sre);
            }
        }
    }

    protected void requestDestroyed(Request baseRequest, HttpServletRequest request) {
        if (!this._servletRequestListeners.isEmpty()) {
            ServletRequestEvent sre = new ServletRequestEvent(this._scontext, request);
            int i = this._servletRequestListeners.size();
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                this._servletRequestListeners.get(i).requestDestroyed(sre);
            }
        }
        if (!this._servletRequestAttributeListeners.isEmpty()) {
            int i2 = this._servletRequestAttributeListeners.size();
            while (true) {
                i2--;
                if (i2 > 0) {
                    baseRequest.removeEventListener(this._servletRequestAttributeListeners.get(i2));
                } else {
                    return;
                }
            }
        }
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler
    public void doHandle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DispatcherType dispatch = baseRequest.getDispatcherType();
        boolean new_context = baseRequest.takeNewContext();
        if (new_context) {
            try {
                requestInitialized(baseRequest, request);
            } catch (Throwable th) {
                if (new_context) {
                    requestDestroyed(baseRequest, request);
                }
                throw th;
            }
        }
        if (dispatch != DispatcherType.REQUEST || !isProtectedTarget(target)) {
            nextHandle(target, baseRequest, request, response);
            if (new_context) {
                requestDestroyed(baseRequest, request);
                return;
            }
            return;
        }
        baseRequest.setHandled(true);
        response.sendError(404);
        if (new_context) {
            requestDestroyed(baseRequest, request);
        }
    }

    protected void enterScope(Request request, Object reason) {
        if (!this._contextListeners.isEmpty()) {
            for (ContextScopeListener listener : this._contextListeners) {
                try {
                    listener.enterScope(this._scontext, request, reason);
                } catch (Throwable e) {
                    LOG.warn(e);
                }
            }
        }
    }

    protected void exitScope(Request request) {
        if (!this._contextListeners.isEmpty()) {
            int i = this._contextListeners.size();
            while (true) {
                i--;
                if (i > 0) {
                    try {
                        this._contextListeners.get(i).exitScope(this._scontext, request);
                    } catch (Throwable e) {
                        LOG.warn(e);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void handle(Request request, Runnable runnable) {
        ClassLoader oldClassloader = null;
        Thread currentThread = null;
        Context oldContext = __context.get();
        if (oldContext == this._scontext) {
            runnable.run();
            return;
        }
        try {
            __context.set(this._scontext);
            if (this._classLoader != null) {
                currentThread = Thread.currentThread();
                oldClassloader = currentThread.getContextClassLoader();
                currentThread.setContextClassLoader(this._classLoader);
            }
            enterScope(request, runnable);
            runnable.run();
            exitScope(request);
            __context.set(oldContext);
            if (oldClassloader != null) {
                currentThread.setContextClassLoader(oldClassloader);
            }
        } catch (Throwable th) {
            exitScope(request);
            __context.set(oldContext);
            if (oldClassloader != null) {
                currentThread.setContextClassLoader(oldClassloader);
            }
            throw th;
        }
    }

    public void handle(Runnable runnable) {
        handle(null, runnable);
    }

    public boolean isProtectedTarget(String target) {
        char c;
        if (target == null || this._protectedTargets == null) {
            return false;
        }
        if (target.startsWith("//")) {
            target = URIUtil.compactPath(target);
        }
        String[] strArr = this._protectedTargets;
        for (String t : strArr) {
            if (StringUtil.startsWithIgnoreCase(target, t) && (target.length() == t.length() || (c = target.charAt(t.length())) == '/' || c == '?' || c == '#' || c == ';')) {
                return true;
            }
        }
        return false;
    }

    public void setProtectedTargets(String[] targets) {
        if (targets == null) {
            this._protectedTargets = null;
        } else {
            this._protectedTargets = (String[]) Arrays.copyOf(targets, targets.length);
        }
    }

    public String[] getProtectedTargets() {
        if (this._protectedTargets == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(this._protectedTargets, this._protectedTargets.length);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void removeAttribute(String name) {
        this._attributes.removeAttribute(name);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void setAttribute(String name, Object value) {
        this._attributes.setAttribute(name, value);
    }

    public void setAttributes(Attributes attributes) {
        this._attributes.clearAttributes();
        this._attributes.addAll(attributes);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void clearAttributes() {
        this._attributes.clearAttributes();
    }

    @Deprecated
    public void setManagedAttribute(String name, Object value) {
    }

    public void setClassLoader(ClassLoader classLoader) {
        if (isStarted()) {
            throw new IllegalStateException(getState());
        }
        this._classLoader = classLoader;
    }

    public void setContextPath(String contextPath) {
        Handler[] contextCollections;
        if (contextPath == null) {
            throw new IllegalArgumentException("null contextPath");
        }
        if (contextPath.endsWith("/*")) {
            LOG.warn(this + " contextPath ends with /*", new Object[0]);
            contextPath = contextPath.substring(0, contextPath.length() - 2);
        } else if (contextPath.length() > 1 && contextPath.endsWith("/")) {
            LOG.warn(this + " contextPath ends with /", new Object[0]);
            contextPath = contextPath.substring(0, contextPath.length() - 1);
        }
        if (contextPath.length() == 0) {
            LOG.warn("Empty contextPath", new Object[0]);
            contextPath = "/";
        }
        this._contextPath = contextPath;
        this._contextPathEncoded = URIUtil.encodePath(contextPath);
        if (getServer() == null) {
            return;
        }
        if ((getServer().isStarting() || getServer().isStarted()) && (contextCollections = getServer().getChildHandlersByClass(ContextHandlerCollection.class)) != null) {
            for (Handler contextCollection : contextCollections) {
                ((ContextHandlerCollection) ContextHandlerCollection.class.cast(contextCollection)).mapContexts();
            }
        }
    }

    public void setDisplayName(String servletContextName) {
        this._displayName = servletContextName;
    }

    public Resource getBaseResource() {
        if (this._baseResource == null) {
            return null;
        }
        return this._baseResource;
    }

    @ManagedAttribute("document root for context")
    public String getResourceBase() {
        if (this._baseResource == null) {
            return null;
        }
        return this._baseResource.toString();
    }

    public void setBaseResource(Resource base) {
        if (isStarted()) {
            throw new IllegalStateException("Cannot call setBaseResource after starting");
        }
        this._baseResource = base;
    }

    public void setResourceBase(String resourceBase) {
        try {
            setBaseResource(newResource(resourceBase));
        } catch (Exception e) {
            LOG.warn(e.toString(), new Object[0]);
            LOG.debug(e);
            throw new IllegalArgumentException(resourceBase);
        }
    }

    public MimeTypes getMimeTypes() {
        if (this._mimeTypes == null) {
            this._mimeTypes = new MimeTypes();
        }
        return this._mimeTypes;
    }

    public void setMimeTypes(MimeTypes mimeTypes) {
        this._mimeTypes = mimeTypes;
    }

    public void setWelcomeFiles(String[] files) {
        this._welcomeFiles = files;
    }

    @ManagedAttribute(value = "Partial URIs of directory welcome files", readonly = true)
    public String[] getWelcomeFiles() {
        return this._welcomeFiles;
    }

    @ManagedAttribute("The error handler to use for the context")
    public ErrorHandler getErrorHandler() {
        return this._errorHandler;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        if (errorHandler != null) {
            errorHandler.setServer(getServer());
        }
        updateBean(this._errorHandler, errorHandler, true);
        this._errorHandler = errorHandler;
    }

    @ManagedAttribute("The maximum content size")
    public int getMaxFormContentSize() {
        return this._maxFormContentSize;
    }

    public void setMaxFormContentSize(int maxSize) {
        this._maxFormContentSize = maxSize;
    }

    public int getMaxFormKeys() {
        return this._maxFormKeys;
    }

    public void setMaxFormKeys(int max) {
        this._maxFormKeys = max;
    }

    public boolean isCompactPath() {
        return this._compactPath;
    }

    public void setCompactPath(boolean compactPath) {
        this._compactPath = compactPath;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        String p;
        String[] vhosts = getVirtualHosts();
        StringBuilder b = new StringBuilder();
        Package pkg = getClass().getPackage();
        if (!(pkg == null || (p = pkg.getName()) == null || p.length() <= 0)) {
            for (String s : p.split("\\.")) {
                b.append(s.charAt(0)).append('.');
            }
        }
        b.append(getClass().getSimpleName()).append('@').append(Integer.toString(hashCode(), 16));
        b.append('{');
        if (getDisplayName() != null) {
            b.append(getDisplayName()).append(',');
        }
        b.append(getContextPath()).append(',').append(getBaseResource()).append(',').append(this._availability.get());
        if (vhosts != null && vhosts.length > 0) {
            b.append(',').append(vhosts[0]);
        }
        b.append('}');
        return b.toString();
    }

    public Class<?> loadClass(String className) throws ClassNotFoundException {
        if (className == null) {
            return null;
        }
        if (this._classLoader == null) {
            return Loader.loadClass(className);
        }
        return this._classLoader.loadClass(className);
    }

    public void addLocaleEncoding(String locale, String encoding) {
        if (this._localeEncodingMap == null) {
            this._localeEncodingMap = new HashMap();
        }
        this._localeEncodingMap.put(locale, encoding);
    }

    public String getLocaleEncoding(String locale) {
        if (this._localeEncodingMap == null) {
            return null;
        }
        return this._localeEncodingMap.get(locale);
    }

    public String getLocaleEncoding(Locale locale) {
        if (this._localeEncodingMap == null) {
            return null;
        }
        String encoding = this._localeEncodingMap.get(locale.toString());
        if (encoding == null) {
            encoding = this._localeEncodingMap.get(locale.getLanguage());
        }
        return encoding;
    }

    public Map<String, String> getLocaleEncodings() {
        if (this._localeEncodingMap == null) {
            return null;
        }
        return Collections.unmodifiableMap(this._localeEncodingMap);
    }

    public Resource getResource(String path) throws MalformedURLException {
        if (path == null || !path.startsWith("/")) {
            throw new MalformedURLException(path);
        } else if (this._baseResource == null) {
            return null;
        } else {
            try {
                Resource resource = this._baseResource.addPath(path);
                if (checkAlias(path, resource)) {
                    return resource;
                }
                return null;
            } catch (Exception e) {
                LOG.ignore(e);
                return null;
            }
        }
    }

    public boolean checkAlias(String path, Resource resource) {
        if (!resource.isAlias()) {
            return true;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Aliased resource: " + resource + "~=" + resource.getAlias(), new Object[0]);
        }
        for (AliasCheck check : getAliasChecks()) {
            if (check.check(path, resource)) {
                if (!LOG.isDebugEnabled()) {
                    return true;
                }
                LOG.debug("Aliased resource: " + resource + " approved by " + check, new Object[0]);
                return true;
            }
        }
        return false;
    }

    public Resource newResource(URL url) throws IOException {
        return Resource.newResource(url);
    }

    public Resource newResource(URI uri) throws IOException {
        return Resource.newResource(uri);
    }

    public Resource newResource(String urlOrPath) throws IOException {
        return Resource.newResource(urlOrPath);
    }

    public Set<String> getResourcePaths(String path) {
        try {
            Resource resource = getResource(path);
            if (resource != null && resource.exists()) {
                if (!path.endsWith("/")) {
                    path = path + "/";
                }
                String[] l = resource.list();
                if (l != null) {
                    HashSet<String> set = new HashSet<>();
                    for (int i = 0; i < l.length; i++) {
                        set.add(path + l[i]);
                    }
                    return set;
                }
            }
        } catch (Exception e) {
            LOG.ignore(e);
        }
        return Collections.emptySet();
    }

    private String normalizeHostname(String host) {
        if (host == null) {
            return null;
        }
        int connectorIndex = host.indexOf(64);
        String connector = null;
        if (connectorIndex > 0) {
            host = host.substring(0, connectorIndex);
            connector = host.substring(connectorIndex);
        }
        if (host.endsWith(Mapper.IGNORED_FIELDNAME)) {
            host = host.substring(0, host.length() - 1);
        }
        if (connector != null) {
            host = host + connector;
        }
        return host;
    }

    public void addAliasCheck(AliasCheck check) {
        this._aliasChecks.add(check);
        if (check instanceof LifeCycle) {
            addManaged((LifeCycle) check);
        } else {
            addBean(check);
        }
    }

    /* access modifiers changed from: private */
    public boolean removeAliasCheck(AliasCheck check) {
        boolean removed = this._aliasChecks.remove(check);
        if (removed) {
            removeBean(check);
        }
        return removed;
    }

    public List<AliasCheck> getAliasChecks() {
        return new AliasChecksList();
    }

    public void setAliasChecks(List<AliasCheck> checks) {
        clearAliasChecks();
        checks.forEach(this::addAliasCheck);
    }

    public void clearAliasChecks() {
        this._aliasChecks.forEach((v1) -> {
            removeBean(v1);
        });
        this._aliasChecks.clear();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandler$Context.class */
    public class Context extends StaticContext {
        protected boolean _enabled = true;
        protected boolean _extendedListenerTypes = false;

        /* access modifiers changed from: protected */
        public Context() {
        }

        public ContextHandler getContextHandler() {
            return ContextHandler.this;
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public ServletContext getContext(String uripath) {
            List<ContextHandler> contexts = new ArrayList<>();
            Handler[] handlers = ContextHandler.this.getServer().getChildHandlersByClass(ContextHandler.class);
            String matchedPath = null;
            for (Handler handler : handlers) {
                if (handler != null) {
                    ContextHandler ch = (ContextHandler) handler;
                    String contextPath = ch.getContextPath();
                    if (uripath.equals(contextPath) || ((uripath.startsWith(contextPath) && uripath.charAt(contextPath.length()) == '/') || "/".equals(contextPath))) {
                        if (ContextHandler.this.getVirtualHosts() == null || ContextHandler.this.getVirtualHosts().length <= 0) {
                            if (matchedPath == null || contextPath.length() > matchedPath.length()) {
                                contexts.clear();
                                matchedPath = contextPath;
                            }
                            if (matchedPath.equals(contextPath)) {
                                contexts.add(ch);
                            }
                        } else if (ch.getVirtualHosts() != null && ch.getVirtualHosts().length > 0) {
                            String[] virtualHosts = ContextHandler.this.getVirtualHosts();
                            for (String h1 : virtualHosts) {
                                for (String h2 : ch.getVirtualHosts()) {
                                    if (h1.equals(h2)) {
                                        if (matchedPath == null || contextPath.length() > matchedPath.length()) {
                                            contexts.clear();
                                            matchedPath = contextPath;
                                        }
                                        if (matchedPath.equals(contextPath)) {
                                            contexts.add(ch);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (contexts.size() > 0) {
                return contexts.get(0)._scontext;
            }
            String matchedPath2 = null;
            for (Handler handler2 : handlers) {
                if (handler2 != null) {
                    ContextHandler ch2 = (ContextHandler) handler2;
                    String contextPath2 = ch2.getContextPath();
                    if (uripath.equals(contextPath2) || ((uripath.startsWith(contextPath2) && uripath.charAt(contextPath2.length()) == '/') || "/".equals(contextPath2))) {
                        if (matchedPath2 == null || contextPath2.length() > matchedPath2.length()) {
                            contexts.clear();
                            matchedPath2 = contextPath2;
                        }
                        if (matchedPath2.equals(contextPath2)) {
                            contexts.add(ch2);
                        }
                    }
                }
            }
            if (contexts.size() > 0) {
                return contexts.get(0)._scontext;
            }
            return null;
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public String getMimeType(String file) {
            if (ContextHandler.this._mimeTypes == null) {
                return null;
            }
            return ContextHandler.this._mimeTypes.getMimeByExtension(file);
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public RequestDispatcher getRequestDispatcher(String uriInContext) {
            if (uriInContext == null || !uriInContext.startsWith("/")) {
                return null;
            }
            try {
                HttpURI uri = new HttpURI(null, null, 0, uriInContext);
                String pathInfo = uri.getDecodedPath();
                String contextPath = getContextPath();
                if (contextPath != null && contextPath.length() > 0) {
                    uri.setPath(URIUtil.addPaths(contextPath, uri.getPath()));
                }
                return new Dispatcher(ContextHandler.this, uri, pathInfo);
            } catch (Exception e) {
                ContextHandler.LOG.ignore(e);
                return null;
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public String getRealPath(String path) {
            File file;
            String path2 = URIUtil.canonicalPath(path);
            if (path2 == null) {
                return null;
            }
            if (path2.length() == 0) {
                path2 = "/";
            } else if (path2.charAt(0) != '/') {
                path2 = "/" + path2;
            }
            try {
                Resource resource = ContextHandler.this.getResource(path2);
                if (resource == null || (file = resource.getFile()) == null) {
                    return null;
                }
                return file.getCanonicalPath();
            } catch (Exception e) {
                ContextHandler.LOG.ignore(e);
                return null;
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public URL getResource(String path) throws MalformedURLException {
            Resource resource;
            String path2 = URIUtil.canonicalPath(path);
            if (path2 == null || (resource = ContextHandler.this.getResource(path2)) == null || !resource.exists()) {
                return null;
            }
            return resource.getURI().toURL();
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public InputStream getResourceAsStream(String path) {
            try {
                URL url = getResource(path);
                if (url == null) {
                    return null;
                }
                Resource r = Resource.newResource(url);
                if (r.isDirectory()) {
                    return null;
                }
                return r.getInputStream();
            } catch (Exception e) {
                ContextHandler.LOG.ignore(e);
                return null;
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public Set<String> getResourcePaths(String path) {
            String path2 = URIUtil.canonicalPath(path);
            if (path2 == null) {
                return null;
            }
            return ContextHandler.this.getResourcePaths(path2);
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public void log(Exception exception, String msg) {
            ContextHandler.this._logger.warn(msg, exception);
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public void log(String msg) {
            ContextHandler.this._logger.info(msg, new Object[0]);
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public void log(String message, Throwable throwable) {
            ContextHandler.this._logger.warn(message, throwable);
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public String getInitParameter(String name) {
            return ContextHandler.this.getInitParameter(name);
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public Enumeration<String> getInitParameterNames() {
            return ContextHandler.this.getInitParameterNames();
        }

        @Override // org.eclipse.jetty.util.AttributesMap, org.eclipse.jetty.util.Attributes
        public Object getAttribute(String name) {
            Object o = ContextHandler.this.getAttribute(name);
            if (o == null) {
                o = getAttribute(name);
            }
            return o;
        }

        @Override // org.eclipse.jetty.util.AttributesMap, org.eclipse.jetty.util.Attributes
        public Enumeration<String> getAttributeNames() {
            HashSet<String> set = new HashSet<>();
            Enumeration<String> e = getAttributeNames();
            while (e.hasMoreElements()) {
                set.add(e.nextElement());
            }
            Enumeration<String> e2 = ContextHandler.this._attributes.getAttributeNames();
            while (e2.hasMoreElements()) {
                set.add(e2.nextElement());
            }
            return Collections.enumeration(set);
        }

        @Override // org.eclipse.jetty.util.AttributesMap, org.eclipse.jetty.util.Attributes
        public void setAttribute(String name, Object value) {
            Object oldValue = getAttribute(name);
            if (value == null) {
                removeAttribute(name);
            } else {
                setAttribute(name, value);
            }
            if (!ContextHandler.this._servletContextAttributeListeners.isEmpty()) {
                ServletContextAttributeEvent event = new ServletContextAttributeEvent(ContextHandler.this._scontext, name, oldValue == null ? value : oldValue);
                for (ServletContextAttributeListener l : ContextHandler.this._servletContextAttributeListeners) {
                    if (oldValue == null) {
                        l.attributeAdded(event);
                    } else if (value == null) {
                        l.attributeRemoved(event);
                    } else {
                        l.attributeReplaced(event);
                    }
                }
            }
        }

        @Override // org.eclipse.jetty.util.AttributesMap, org.eclipse.jetty.util.Attributes
        public void removeAttribute(String name) {
            Object oldValue = getAttribute(name);
            removeAttribute(name);
            if (!(oldValue == null || ContextHandler.this._servletContextAttributeListeners.isEmpty())) {
                ServletContextAttributeEvent event = new ServletContextAttributeEvent(ContextHandler.this._scontext, name, oldValue);
                for (ServletContextAttributeListener l : ContextHandler.this._servletContextAttributeListeners) {
                    l.attributeRemoved(event);
                }
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public String getServletContextName() {
            String name = ContextHandler.this.getDisplayName();
            if (name == null) {
                name = ContextHandler.this.getContextPath();
            }
            return name;
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public String getContextPath() {
            return ContextHandler.this.getRequestContextPath();
        }

        @Override // org.eclipse.jetty.util.AttributesMap
        public String toString() {
            return "ServletContext@" + ContextHandler.this.toString();
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public boolean setInitParameter(String name, String value) {
            if (ContextHandler.this.getInitParameter(name) != null) {
                return false;
            }
            ContextHandler.this.getInitParams().put(name, value);
            return true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: org.eclipse.jetty.server.handler.ContextHandler$Context */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public void addListener(String className) {
            if (!this._enabled) {
                throw new UnsupportedOperationException();
            }
            try {
                addListener((Class<? extends EventListener>) (ContextHandler.this._classLoader == null ? Loader.loadClass(className) : ContextHandler.this._classLoader.loadClass(className)));
            } catch (ClassNotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: org.eclipse.jetty.server.handler.ContextHandler$Context */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public <T extends EventListener> void addListener(T t) {
            if (!this._enabled) {
                throw new UnsupportedOperationException();
            }
            checkListener(t.getClass());
            ContextHandler.this.addEventListener(t);
            ContextHandler.this.addProgrammaticListener(t);
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public void addListener(Class<? extends EventListener> listenerClass) {
            if (!this._enabled) {
                throw new UnsupportedOperationException();
            }
            try {
                addListener((Context) createListener(listenerClass));
            } catch (ServletException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public void checkListener(Class<? extends EventListener> listener) throws IllegalStateException {
            boolean ok = false;
            int i = isExtendedListenerTypes() ? 0 : 1;
            while (true) {
                if (i >= ContextHandler.SERVLET_LISTENER_TYPES.length) {
                    break;
                } else if (ContextHandler.SERVLET_LISTENER_TYPES[i].isAssignableFrom(listener)) {
                    ok = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!ok) {
                throw new IllegalArgumentException("Inappropriate listener class " + listener.getName());
            }
        }

        public void setExtendedListenerTypes(boolean extended) {
            this._extendedListenerTypes = extended;
        }

        public boolean isExtendedListenerTypes() {
            return this._extendedListenerTypes;
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public ClassLoader getClassLoader() {
            if (!this._enabled) {
                throw new UnsupportedOperationException();
            } else if (!ContextHandler.this.isUsingSecurityManager()) {
                return ContextHandler.this._classLoader;
            } else {
                for (ClassLoader callerLoader = ((Caller) AccessController.doPrivileged(() -> {
                    return new Caller();
                })).getCallerClassLoader(2); callerLoader != null; callerLoader = callerLoader.getParent()) {
                    if (callerLoader == ContextHandler.this._classLoader) {
                        return ContextHandler.this._classLoader;
                    }
                }
                System.getSecurityManager().checkPermission(new RuntimePermission("getClassLoader"));
                return ContextHandler.this._classLoader;
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public JspConfigDescriptor getJspConfigDescriptor() {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "getJspConfigDescriptor()");
            return null;
        }

        public void setJspConfigDescriptor(JspConfigDescriptor d) {
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public void declareRoles(String... roleNames) {
            if (!ContextHandler.this.isStarting()) {
                throw new IllegalStateException();
            } else if (!this._enabled) {
                throw new UnsupportedOperationException();
            }
        }

        public void setEnabled(boolean enabled) {
            this._enabled = enabled;
        }

        public boolean isEnabled() {
            return this._enabled;
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public String getVirtualServerName() {
            String[] hosts = ContextHandler.this.getVirtualHosts();
            if (hosts == null || hosts.length <= 0) {
                return null;
            }
            return hosts[0];
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandler$StaticContext.class */
    public static class StaticContext extends AttributesMap implements ServletContext {
        private int _effectiveMajorVersion = 3;
        private int _effectiveMinorVersion = 1;

        @Override // javax.servlet.ServletContext
        public ServletContext getContext(String uripath) {
            return null;
        }

        @Override // javax.servlet.ServletContext
        public int getMajorVersion() {
            return 3;
        }

        @Override // javax.servlet.ServletContext
        public String getMimeType(String file) {
            return null;
        }

        @Override // javax.servlet.ServletContext
        public int getMinorVersion() {
            return 1;
        }

        @Override // javax.servlet.ServletContext
        public RequestDispatcher getNamedDispatcher(String name) {
            return null;
        }

        @Override // javax.servlet.ServletContext
        public RequestDispatcher getRequestDispatcher(String uriInContext) {
            return null;
        }

        @Override // javax.servlet.ServletContext
        public String getRealPath(String path) {
            return null;
        }

        @Override // javax.servlet.ServletContext
        public URL getResource(String path) throws MalformedURLException {
            return null;
        }

        @Override // javax.servlet.ServletContext
        public InputStream getResourceAsStream(String path) {
            return null;
        }

        @Override // javax.servlet.ServletContext
        public Set<String> getResourcePaths(String path) {
            return null;
        }

        @Override // javax.servlet.ServletContext
        public String getServerInfo() {
            return ContextHandler.getServerInfo();
        }

        @Override // javax.servlet.ServletContext
        @Deprecated
        public Servlet getServlet(String name) throws ServletException {
            return null;
        }

        @Override // javax.servlet.ServletContext
        @Deprecated
        public Enumeration<String> getServletNames() {
            return Collections.enumeration(Collections.EMPTY_LIST);
        }

        @Override // javax.servlet.ServletContext
        @Deprecated
        public Enumeration<Servlet> getServlets() {
            return Collections.enumeration(Collections.EMPTY_LIST);
        }

        @Override // javax.servlet.ServletContext
        public void log(Exception exception, String msg) {
            ContextHandler.LOG.warn(msg, exception);
        }

        @Override // javax.servlet.ServletContext
        public void log(String msg) {
            ContextHandler.LOG.info(msg, new Object[0]);
        }

        @Override // javax.servlet.ServletContext
        public void log(String message, Throwable throwable) {
            ContextHandler.LOG.warn(message, throwable);
        }

        @Override // javax.servlet.ServletContext
        public String getInitParameter(String name) {
            return null;
        }

        @Override // javax.servlet.ServletContext
        public Enumeration<String> getInitParameterNames() {
            return Collections.enumeration(Collections.EMPTY_LIST);
        }

        @Override // javax.servlet.ServletContext
        public String getServletContextName() {
            return "No Context";
        }

        @Override // javax.servlet.ServletContext
        public String getContextPath() {
            return null;
        }

        @Override // javax.servlet.ServletContext
        public boolean setInitParameter(String name, String value) {
            return false;
        }

        @Override // javax.servlet.ServletContext
        public FilterRegistration.Dynamic addFilter(String filterName, Class<? extends Filter> filterClass) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "addFilter(String, Class)");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public FilterRegistration.Dynamic addFilter(String filterName, Filter filter) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "addFilter(String, Filter)");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public FilterRegistration.Dynamic addFilter(String filterName, String className) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "addFilter(String, String)");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public ServletRegistration.Dynamic addServlet(String servletName, Class<? extends Servlet> servletClass) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "addServlet(String, Class)");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public ServletRegistration.Dynamic addServlet(String servletName, Servlet servlet) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "addServlet(String, Servlet)");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public ServletRegistration.Dynamic addServlet(String servletName, String className) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "addServlet(String, String)");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "getDefaultSessionTrackingModes()");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "getEffectiveSessionTrackingModes()");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public FilterRegistration getFilterRegistration(String filterName) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "getFilterRegistration(String)");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public Map<String, ? extends FilterRegistration> getFilterRegistrations() {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "getFilterRegistrations()");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public ServletRegistration getServletRegistration(String servletName) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "getServletRegistration(String)");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public Map<String, ? extends ServletRegistration> getServletRegistrations() {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "getServletRegistrations()");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public SessionCookieConfig getSessionCookieConfig() {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "getSessionCookieConfig()");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public void setSessionTrackingModes(Set<SessionTrackingMode> sessionTrackingModes) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "setSessionTrackingModes(Set<SessionTrackingMode>)");
        }

        @Override // javax.servlet.ServletContext
        public void addListener(String className) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "addListener(String)");
        }

        @Override // javax.servlet.ServletContext
        public <T extends EventListener> void addListener(T t) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "addListener(T)");
        }

        @Override // javax.servlet.ServletContext
        public void addListener(Class<? extends EventListener> listenerClass) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "addListener(Class)");
        }

        protected <T> T createInstance(Class<T> clazz) throws ServletException {
            try {
                return clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }

        @Override // javax.servlet.ServletContext
        public <T extends EventListener> T createListener(Class<T> clazz) throws ServletException {
            return (T) ((EventListener) createInstance(clazz));
        }

        @Override // javax.servlet.ServletContext
        public <T extends Servlet> T createServlet(Class<T> clazz) throws ServletException {
            return (T) ((Servlet) createInstance(clazz));
        }

        @Override // javax.servlet.ServletContext
        public <T extends Filter> T createFilter(Class<T> clazz) throws ServletException {
            return (T) ((Filter) createInstance(clazz));
        }

        @Override // javax.servlet.ServletContext
        public ClassLoader getClassLoader() {
            return ContextHandler.class.getClassLoader();
        }

        @Override // javax.servlet.ServletContext
        public int getEffectiveMajorVersion() {
            return this._effectiveMajorVersion;
        }

        @Override // javax.servlet.ServletContext
        public int getEffectiveMinorVersion() {
            return this._effectiveMinorVersion;
        }

        public void setEffectiveMajorVersion(int v) {
            this._effectiveMajorVersion = v;
        }

        public void setEffectiveMinorVersion(int v) {
            this._effectiveMinorVersion = v;
        }

        @Override // javax.servlet.ServletContext
        public JspConfigDescriptor getJspConfigDescriptor() {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "getJspConfigDescriptor()");
            return null;
        }

        @Override // javax.servlet.ServletContext
        public void declareRoles(String... roleNames) {
            ContextHandler.LOG.warn(ContextHandler.UNIMPLEMENTED_USE_SERVLET_CONTEXT_HANDLER, "declareRoles(String...)");
        }

        @Override // javax.servlet.ServletContext
        public String getVirtualServerName() {
            return null;
        }
    }

    @Deprecated
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandler$ApproveAliases.class */
    public static class ApproveAliases implements AliasCheck {
        @Override // org.eclipse.jetty.server.handler.ContextHandler.AliasCheck
        public boolean check(String path, Resource resource) {
            return true;
        }
    }

    @Deprecated
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandler$ApproveNonExistentDirectoryAliases.class */
    public static class ApproveNonExistentDirectoryAliases implements AliasCheck {
        @Override // org.eclipse.jetty.server.handler.ContextHandler.AliasCheck
        public boolean check(String path, Resource resource) {
            if (resource.exists()) {
                return false;
            }
            String a = resource.getAlias().toString();
            String r = resource.getURI().toString();
            if (a.length() > r.length()) {
                return a.startsWith(r) && a.length() == r.length() + 1 && a.endsWith("/");
            }
            if (a.length() < r.length()) {
                return r.startsWith(a) && r.length() == a.length() + 1 && r.endsWith("/");
            }
            return a.equals(r);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandler$Caller.class */
    private static class Caller extends SecurityManager {
        private Caller() {
        }

        public ClassLoader getCallerClassLoader(int depth) {
            if (depth < 0) {
                return null;
            }
            Class<?>[] classContext = getClassContext();
            if (classContext.length <= depth) {
                return null;
            }
            return classContext[depth].getClassLoader();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandler$AliasChecksList.class */
    public class AliasChecksList implements List<AliasCheck> {
        private AliasChecksList() {
        }

        @Override // java.util.List, java.util.Collection
        public int size() {
            return ContextHandler.this._aliasChecks.size();
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return ContextHandler.this._aliasChecks.isEmpty();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object o) {
            return ContextHandler.this._aliasChecks.contains(o);
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<AliasCheck> iterator() {
            return new Iterator<AliasCheck>() { // from class: org.eclipse.jetty.server.handler.ContextHandler.AliasChecksList.1
                private final Iterator<AliasCheck> _iterator;

                {
                    this._iterator = ContextHandler.this._aliasChecks.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this._iterator.hasNext();
                }

                @Override // java.util.Iterator
                public AliasCheck next() {
                    return this._iterator.next();
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super AliasCheck> action) {
                    this._iterator.forEachRemaining(action);
                }
            };
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return ContextHandler.this._aliasChecks.toArray();
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] a) {
            return (T[]) ContextHandler.this._aliasChecks.toArray(a);
        }

        public boolean add(AliasCheck aliasCheck) {
            ContextHandler.this.addAliasCheck(aliasCheck);
            return true;
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object o) {
            return ContextHandler.this.removeAliasCheck((AliasCheck) o);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return ContextHandler.this._aliasChecks.containsAll(c);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends AliasCheck> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends AliasCheck> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            ContextHandler.this.clearAliasChecks();
        }

        @Override // java.util.List
        public AliasCheck get(int index) {
            return (AliasCheck) ContextHandler.this._aliasChecks.get(index);
        }

        public AliasCheck set(int index, AliasCheck element) {
            throw new UnsupportedOperationException();
        }

        public void add(int index, AliasCheck element) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public AliasCheck remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public int indexOf(Object o) {
            return ContextHandler.this._aliasChecks.indexOf(o);
        }

        @Override // java.util.List
        public int lastIndexOf(Object o) {
            return ContextHandler.this._aliasChecks.lastIndexOf(o);
        }

        @Override // java.util.List
        public ListIterator<AliasCheck> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.List
        public ListIterator<AliasCheck> listIterator(final int index) {
            return new ListIterator<AliasCheck>() { // from class: org.eclipse.jetty.server.handler.ContextHandler.AliasChecksList.2
                private final ListIterator<AliasCheck> _iterator;

                {
                    this._iterator = ContextHandler.this._aliasChecks.listIterator(index);
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return this._iterator.hasNext();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public AliasCheck next() {
                    return this._iterator.next();
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return this._iterator.hasPrevious();
                }

                @Override // java.util.ListIterator
                public AliasCheck previous() {
                    return this._iterator.previous();
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this._iterator.nextIndex();
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this._iterator.previousIndex();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                public void set(AliasCheck check) {
                    throw new UnsupportedOperationException();
                }

                public void add(AliasCheck check) {
                    throw new UnsupportedOperationException();
                }
            };
        }

        @Override // java.util.List
        public List<AliasCheck> subList(int fromIndex, int toIndex) {
            throw new UnsupportedOperationException();
        }
    }
}
