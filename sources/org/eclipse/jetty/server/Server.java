package org.eclipse.jetty.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.bytebuddy.ClassFileVersion;
import org.eclipse.jetty.http.DateGenerator;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpGenerator;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.http.PreEncodedHttpField;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.Jetty;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.Uptime;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.component.AttributeContainerMap;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Locker;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ShutdownThread;
import org.eclipse.jetty.util.thread.ThreadPool;
import p001ch.qos.logback.core.net.ssl.SSL;

@ManagedObject("Jetty HTTP Servlet server")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/Server.class */
public class Server extends HandlerWrapper implements Attributes {
    private static final Logger LOG = Log.getLogger(Server.class);
    private final AttributeContainerMap _attributes;
    private final ThreadPool _threadPool;
    private final List<Connector> _connectors;
    private SessionIdManager _sessionIdManager;
    private boolean _stopAtShutdown;
    private boolean _dumpAfterStart;
    private boolean _dumpBeforeStop;
    private ErrorHandler _errorHandler;
    private RequestLog _requestLog;
    private final Locker _dateLocker;
    private volatile DateField _dateField;

    public Server() {
        this((ThreadPool) null);
    }

    public Server(@Name("port") int port) {
        this((ThreadPool) null);
        ServerConnector connector = new ServerConnector(this);
        connector.setPort(port);
        setConnectors(new Connector[]{connector});
        addBean(this._attributes);
    }

    public Server(@Name("address") InetSocketAddress addr) {
        this((ThreadPool) null);
        ServerConnector connector = new ServerConnector(this);
        connector.setHost(addr.getHostName());
        connector.setPort(addr.getPort());
        setConnectors(new Connector[]{connector});
    }

    public Server(@Name("threadpool") ThreadPool pool) {
        this._attributes = new AttributeContainerMap();
        this._connectors = new CopyOnWriteArrayList();
        this._dumpAfterStart = false;
        this._dumpBeforeStop = false;
        this._dateLocker = new Locker();
        this._threadPool = pool != null ? pool : new QueuedThreadPool();
        addBean(this._threadPool);
        setServer(this);
    }

    public RequestLog getRequestLog() {
        return this._requestLog;
    }

    public ErrorHandler getErrorHandler() {
        return this._errorHandler;
    }

    public void setRequestLog(RequestLog requestLog) {
        updateBean(this._requestLog, requestLog);
        this._requestLog = requestLog;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        if (errorHandler instanceof ErrorHandler.ErrorPageMapper) {
            throw new IllegalArgumentException("ErrorPageMapper is applicable only to ContextHandler");
        }
        updateBean(this._errorHandler, errorHandler);
        this._errorHandler = errorHandler;
        if (errorHandler != null) {
            errorHandler.setServer(this);
        }
    }

    @ManagedAttribute("version of this server")
    public static String getVersion() {
        return Jetty.VERSION;
    }

    public boolean getStopAtShutdown() {
        return this._stopAtShutdown;
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void setStopTimeout(long stopTimeout) {
        setStopTimeout(stopTimeout);
    }

    public void setStopAtShutdown(boolean stop) {
        if (!stop) {
            ShutdownThread.deregister(this);
        } else if (!this._stopAtShutdown && isStarted()) {
            ShutdownThread.register(this);
        }
        this._stopAtShutdown = stop;
    }

    @ManagedAttribute(value = "connectors for this server", readonly = true)
    public Connector[] getConnectors() {
        List<Connector> connectors = new ArrayList<>(this._connectors);
        return (Connector[]) connectors.toArray(new Connector[connectors.size()]);
    }

    public void addConnector(Connector connector) {
        if (connector.getServer() != this) {
            throw new IllegalArgumentException("Connector " + connector + " cannot be shared among server " + connector.getServer() + " and server " + this);
        }
        this._connectors.add(connector);
        addBean(connector);
    }

    public void removeConnector(Connector connector) {
        if (this._connectors.remove(connector)) {
            removeBean(connector);
        }
    }

    public void setConnectors(Connector[] connectors) {
        if (connectors != null) {
            for (Connector connector : connectors) {
                if (connector.getServer() != this) {
                    throw new IllegalArgumentException("Connector " + connector + " cannot be shared among server " + connector.getServer() + " and server " + this);
                }
            }
        }
        Connector[] oldConnectors = getConnectors();
        updateBeans(oldConnectors, connectors);
        this._connectors.removeAll(Arrays.asList(oldConnectors));
        if (connectors != null) {
            this._connectors.addAll(Arrays.asList(connectors));
        }
    }

    public void addBeanToAllConnectors(Object bean) {
        for (Connector connector : getConnectors()) {
            connector.addBean(bean);
        }
    }

    @ManagedAttribute("the server thread pool")
    public ThreadPool getThreadPool() {
        return this._threadPool;
    }

    @ManagedAttribute("dump state to stderr after start")
    public boolean isDumpAfterStart() {
        return this._dumpAfterStart;
    }

    public void setDumpAfterStart(boolean dumpAfterStart) {
        this._dumpAfterStart = dumpAfterStart;
    }

    @ManagedAttribute("dump state to stderr before stop")
    public boolean isDumpBeforeStop() {
        return this._dumpBeforeStop;
    }

    public void setDumpBeforeStop(boolean dumpBeforeStop) {
        this._dumpBeforeStop = dumpBeforeStop;
    }

    public HttpField getDateField() {
        long now = System.currentTimeMillis();
        long seconds = now / 1000;
        DateField df = this._dateField;
        if (df == null || df._seconds != seconds) {
            Locker.Lock lock = this._dateLocker.lock();
            try {
                df = this._dateField;
                if (df == null || df._seconds != seconds) {
                    HttpField field = new PreEncodedHttpField(HttpHeader.DATE, DateGenerator.formatDate(now));
                    this._dateField = new DateField(seconds, field);
                    if (lock != null) {
                        lock.close();
                    }
                    return field;
                } else if (lock != null) {
                    lock.close();
                }
            } catch (Throwable th) {
                if (lock != null) {
                    try {
                        lock.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return df._dateField;
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStart() throws Exception {
        if (this._errorHandler == null) {
            this._errorHandler = (ErrorHandler) getBean((Class<Object>) ErrorHandler.class);
        }
        if (this._errorHandler == null) {
            setErrorHandler(new ErrorHandler());
        }
        if (this._errorHandler instanceof ErrorHandler.ErrorPageMapper) {
            LOG.warn("ErrorPageMapper not supported for Server level Error Handling", new Object[0]);
        }
        this._errorHandler.setServer(this);
        if (getStopAtShutdown()) {
            ShutdownThread.register(this);
        }
        ShutdownMonitor.register(this);
        ShutdownMonitor.getInstance().start();
        String gitHash = Jetty.GIT_HASH;
        LOG.info("jetty-{}; built: {}; git: {}; jvm {}", getVersion(), Jetty.BUILD_TIMESTAMP, gitHash, System.getProperty("java.runtime.version", System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION)));
        if (!Jetty.STABLE) {
            LOG.warn("THIS IS NOT A STABLE RELEASE! DO NOT USE IN PRODUCTION!", new Object[0]);
            LOG.warn("Download a stable release from https://download.eclipse.org/jetty/", new Object[0]);
        }
        HttpGenerator.setJettyVersion(HttpConfiguration.SERVER_VERSION);
        MultiException mex = new MultiException();
        try {
            doStart();
        } catch (Throwable e) {
            mex.add(e);
        }
        if (mex.size() == 0) {
            for (Connector connector : this._connectors) {
                try {
                    connector.start();
                } catch (Throwable e2) {
                    mex.add(e2);
                }
            }
        }
        if (isDumpAfterStart()) {
            dumpStdErr();
        }
        mex.ifExceptionThrow();
        LOG.info(String.format("Started @%dms", Long.valueOf(Uptime.getUptime())), new Object[0]);
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle
    protected void start(LifeCycle l) throws Exception {
        if (!(l instanceof Connector)) {
            start(l);
        }
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        if (isDumpBeforeStop()) {
            dumpStdErr();
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("doStop {}", this);
        }
        MultiException mex = new MultiException();
        try {
            List<Future<Void>> futures = new ArrayList<>();
            for (Connector connector : this._connectors) {
                futures.add(connector.shutdown());
            }
            doShutdown(futures);
        } catch (Throwable e) {
            mex.add(e);
        }
        for (Connector connector2 : this._connectors) {
            try {
                connector2.stop();
            } catch (Throwable e2) {
                mex.add(e2);
            }
        }
        try {
            doStop();
        } catch (Throwable e3) {
            mex.add(e3);
        }
        if (getStopAtShutdown()) {
            ShutdownThread.deregister(this);
        }
        ShutdownMonitor.deregister(this);
        mex.ifExceptionThrow();
    }

    public void handle(HttpChannel channel) throws IOException, ServletException {
        String target = channel.getRequest().getPathInfo();
        Request request = channel.getRequest();
        Response response = channel.getResponse();
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} {} {} on {}", request.getDispatcherType(), request.getMethod(), target, channel);
        }
        if (!HttpMethod.OPTIONS.m40is(request.getMethod()) && !"*".equals(target)) {
            handle(target, request, request, response);
        } else if (!HttpMethod.OPTIONS.m40is(request.getMethod())) {
            request.setHandled(true);
            response.sendError(400);
        } else {
            handleOptions(request, response);
            if (!request.isHandled()) {
                handle(target, request, request, response);
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("handled={} async={} committed={} on {}", Boolean.valueOf(request.isHandled()), Boolean.valueOf(request.isAsyncStarted()), Boolean.valueOf(response.isCommitted()), channel);
        }
    }

    protected void handleOptions(Request request, Response response) throws IOException {
    }

    public void handleAsync(HttpChannel channel) throws IOException, ServletException {
        AsyncContextEvent event = channel.getRequest().getHttpChannelState().getAsyncContextEvent();
        Request baseRequest = channel.getRequest();
        String path = event.getPath();
        if (path != null) {
            ServletContext context = event.getServletContext();
            String query = baseRequest.getQueryString();
            baseRequest.setURIPathQuery(URIUtil.addEncodedPaths(context == null ? null : context.getContextPath(), path));
            HttpURI uri = baseRequest.getHttpURI();
            baseRequest.setPathInfo(uri.getDecodedPath());
            if (uri.getQuery() != null) {
                baseRequest.mergeQueryParameters(query, uri.getQuery(), true);
            }
        }
        String target = baseRequest.getPathInfo();
        HttpServletRequest request = Request.unwrap(event.getSuppliedRequest());
        HttpServletResponse response = Response.unwrap(event.getSuppliedResponse());
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} {} {} on {}", request.getDispatcherType(), request.getMethod(), target, channel);
        }
        handle(target, baseRequest, request, response);
        if (LOG.isDebugEnabled()) {
            LOG.debug("handledAsync={} async={} committed={} on {}", Boolean.valueOf(channel.getRequest().isHandled()), Boolean.valueOf(request.isAsyncStarted()), Boolean.valueOf(response.isCommitted()), channel);
        }
    }

    public void join() throws InterruptedException {
        getThreadPool().join();
    }

    public SessionIdManager getSessionIdManager() {
        return this._sessionIdManager;
    }

    public void setSessionIdManager(SessionIdManager sessionIdManager) {
        updateBean(this._sessionIdManager, sessionIdManager);
        this._sessionIdManager = sessionIdManager;
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void clearAttributes() {
        this._attributes.clearAttributes();
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Object getAttribute(String name) {
        return this._attributes.getAttribute(name);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Enumeration<String> getAttributeNames() {
        return this._attributes.getAttributeNames();
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Set<String> getAttributeNameSet() {
        return this._attributes.getAttributeNameSet();
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void removeAttribute(String name) {
        this._attributes.removeAttribute(name);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void setAttribute(String name, Object attribute) {
        this._attributes.setAttribute(name, attribute);
    }

    public URI getURI() {
        NetworkConnector connector = null;
        Iterator<Connector> it = this._connectors.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Connector c = it.next();
            if (c instanceof NetworkConnector) {
                connector = (NetworkConnector) c;
                break;
            }
        }
        if (connector == null) {
            return null;
        }
        ContextHandler context = (ContextHandler) getChildHandlerByClass(ContextHandler.class);
        try {
            String protocol = connector.getDefaultConnectionFactory().getProtocol();
            String scheme = URIUtil.HTTP;
            if (protocol.startsWith("SSL-") || protocol.equals(SSL.DEFAULT_PROTOCOL)) {
                scheme = URIUtil.HTTPS;
            }
            String host = connector.getHost();
            if (!(context == null || context.getVirtualHosts() == null || context.getVirtualHosts().length <= 0)) {
                host = context.getVirtualHosts()[0];
            }
            if (host == null) {
                host = InetAddress.getLocalHost().getHostAddress();
            }
            String path = context == null ? null : context.getContextPath();
            if (path == null) {
                path = "/";
            }
            return new URI(scheme, null, host, connector.getLocalPort(), path, null, null);
        } catch (Exception e) {
            LOG.warn(e);
            return null;
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s[%s]", toString(), getVersion());
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        dumpObjects(out, indent, new ClassLoaderDump(getClass().getClassLoader()));
    }

    public static void main(String... args) throws Exception {
        System.err.println(getVersion());
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Server$DateField.class */
    private static class DateField {
        final long _seconds;
        final HttpField _dateField;

        public DateField(long seconds, HttpField dateField) {
            this._seconds = seconds;
            this._dateField = dateField;
        }
    }
}
