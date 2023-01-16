package org.eclipse.jetty.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;
import java.util.stream.Stream;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletSecurityElement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.pathmap.MappedResource;
import org.eclipse.jetty.http.pathmap.MatchedPath;
import org.eclipse.jetty.http.pathmap.MatchedResource;
import org.eclipse.jetty.http.pathmap.PathMappings;
import org.eclipse.jetty.http.pathmap.PathSpec;
import org.eclipse.jetty.http.pathmap.ServletPathSpec;
import org.eclipse.jetty.security.IdentityService;
import org.eclipse.jetty.security.SecurityHandler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.ServletRequestHttpWrapper;
import org.eclipse.jetty.server.ServletResponseHttpWrapper;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ScopedHandler;
import org.eclipse.jetty.util.ArrayUtil;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject("Servlet Handler")
/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHandler.class */
public class ServletHandler extends ScopedHandler {
    private static final Logger LOG = Log.getLogger(ServletHandler.class);
    public static final String __DEFAULT_SERVLET = "default";
    private ServletContextHandler _contextHandler;
    private ServletContext _servletContext;
    private FilterMapping[] _filterMappings;
    private IdentityService _identityService;
    private ServletMapping[] _servletMappings;
    private List<FilterMapping> _filterPathMappings;
    private MultiMap<FilterMapping> _filterNameMappings;
    private List<FilterMapping> _wildFilterNameMappings;
    private PathMappings<ServletHolder> _servletPathMap;
    private FilterHolder[] _filters = new FilterHolder[0];
    private int _matchBeforeIndex = -1;
    private int _matchAfterIndex = -1;
    private boolean _filterChainsCached = true;
    private int _maxFilterChainsCacheSize = 1024;
    private boolean _startWithUnavailable = false;
    private boolean _ensureDefaultServlet = true;
    private boolean _allowDuplicateMappings = false;
    private ServletHolder[] _servlets = new ServletHolder[0];
    private final Map<String, FilterHolder> _filterNameMap = new HashMap();
    private final Map<String, ServletHolder> _servletNameMap = new HashMap();
    private ListenerHolder[] _listeners = new ListenerHolder[0];
    private boolean _initialized = false;
    protected final ConcurrentMap<String, FilterChain>[] _chainCache = new ConcurrentMap[31];

    @Override // org.eclipse.jetty.util.component.Dumpable.DumpableContainer
    public boolean isDumpable(Object o) {
        return !(o instanceof BaseHolder) && !(o instanceof FilterMapping) && !(o instanceof ServletMapping);
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        dumpObjects(out, indent, DumpableCollection.fromArray("listeners " + this, this._listeners), DumpableCollection.fromArray("filters " + this, this._filters), DumpableCollection.fromArray("filterMappings " + this, this._filterMappings), DumpableCollection.fromArray("servlets " + this, this._servlets), DumpableCollection.fromArray("servletMappings " + this, this._servletMappings));
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.ScopedHandler, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStart() throws Exception {
        SecurityHandler securityHandler;
        ContextHandler.Context context = ContextHandler.getCurrentContext();
        this._servletContext = context == null ? new ContextHandler.StaticContext() : context;
        this._contextHandler = (ServletContextHandler) (context == null ? null : context.getContextHandler());
        if (!(this._contextHandler == null || (securityHandler = (SecurityHandler) this._contextHandler.getChildHandlerByClass(SecurityHandler.class)) == null)) {
            this._identityService = securityHandler.getIdentityService();
        }
        updateNameMappings();
        updateMappings();
        if (getServletMapping("/") == null && isEnsureDefaultServlet()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Adding Default404Servlet to {}", this);
            }
            addServletWithMapping(Default404Servlet.class, "/");
            updateMappings();
            getServletMapping("/").setDefault(true);
        }
        if (isFilterChainsCached()) {
            this._chainCache[1] = new ConcurrentHashMap();
            this._chainCache[2] = new ConcurrentHashMap();
            this._chainCache[4] = new ConcurrentHashMap();
            this._chainCache[8] = new ConcurrentHashMap();
            this._chainCache[16] = new ConcurrentHashMap();
        }
        if (this._contextHandler == null) {
            initialize();
        }
        doStart();
    }

    public boolean isEnsureDefaultServlet() {
        return this._ensureDefaultServlet;
    }

    public void setEnsureDefaultServlet(boolean ensureDefaultServlet) {
        this._ensureDefaultServlet = ensureDefaultServlet;
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle
    protected void start(LifeCycle l) throws Exception {
        if (!(l instanceof Holder)) {
            start(l);
        }
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle
    protected void stop(LifeCycle l) throws Exception {
        if (!(l instanceof Holder)) {
            stop(l);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStop() throws Exception {
        doStop();
        List<FilterHolder> filterHolders = new ArrayList<>();
        List<FilterMapping> filterMappings = ArrayUtil.asMutableList(this._filterMappings);
        if (this._filters != null) {
            int i = this._filters.length;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                try {
                    this._filters[i].stop();
                } catch (Exception e) {
                    LOG.warn(Log.EXCEPTION, e);
                }
                if (this._filters[i].getSource() != Source.EMBEDDED) {
                    this._filterNameMap.remove(this._filters[i].getName());
                    ListIterator<FilterMapping> fmitor = filterMappings.listIterator();
                    while (fmitor.hasNext()) {
                        if (fmitor.next().getFilterName().equals(this._filters[i].getName())) {
                            fmitor.remove();
                        }
                    }
                } else {
                    filterHolders.add(this._filters[i]);
                }
            }
        }
        FilterHolder[] fhs = (FilterHolder[]) filterHolders.toArray(new FilterHolder[0]);
        updateBeans(this._filters, fhs);
        this._filters = fhs;
        FilterMapping[] fms = (FilterMapping[]) filterMappings.toArray(new FilterMapping[0]);
        updateBeans(this._filterMappings, fms);
        this._filterMappings = fms;
        this._matchAfterIndex = this._filterMappings.length == 0 ? -1 : this._filterMappings.length - 1;
        this._matchBeforeIndex = -1;
        List<ServletHolder> servletHolders = new ArrayList<>();
        List<ServletMapping> servletMappings = ArrayUtil.asMutableList(this._servletMappings);
        if (this._servlets != null) {
            int i2 = this._servlets.length;
            while (true) {
                i2--;
                if (i2 <= 0) {
                    break;
                }
                try {
                    this._servlets[i2].stop();
                } catch (Exception e2) {
                    LOG.warn(Log.EXCEPTION, e2);
                }
                if (this._servlets[i2].getSource() != Source.EMBEDDED) {
                    this._servletNameMap.remove(this._servlets[i2].getName());
                    ListIterator<ServletMapping> smitor = servletMappings.listIterator();
                    while (smitor.hasNext()) {
                        if (smitor.next().getServletName().equals(this._servlets[i2].getName())) {
                            smitor.remove();
                        }
                    }
                } else {
                    servletHolders.add(this._servlets[i2]);
                }
            }
        }
        ServletHolder[] shs = (ServletHolder[]) servletHolders.toArray(new ServletHolder[0]);
        updateBeans(this._servlets, shs);
        this._servlets = shs;
        ServletMapping[] sms = (ServletMapping[]) servletMappings.toArray(new ServletMapping[0]);
        updateBeans(this._servletMappings, sms);
        this._servletMappings = sms;
        if (this._contextHandler != null) {
            this._contextHandler.contextDestroyed();
        }
        List<ListenerHolder> listenerHolders = new ArrayList<>();
        if (this._listeners != null) {
            int i3 = this._listeners.length;
            while (true) {
                i3--;
                if (i3 <= 0) {
                    break;
                }
                try {
                    this._listeners[i3].stop();
                } catch (Exception e3) {
                    LOG.warn(Log.EXCEPTION, e3);
                }
                if (this._listeners[i3].getSource() == Source.EMBEDDED) {
                    listenerHolders.add(this._listeners[i3]);
                }
            }
        }
        ListenerHolder[] listeners = (ListenerHolder[]) listenerHolders.toArray(new ListenerHolder[0]);
        updateBeans(this._listeners, listeners);
        this._listeners = listeners;
        this._filterPathMappings = null;
        this._filterNameMappings = null;
        this._servletPathMap = null;
        this._initialized = false;
    }

    /* access modifiers changed from: protected */
    public IdentityService getIdentityService() {
        return this._identityService;
    }

    @ManagedAttribute(value = "filters", readonly = true)
    public FilterMapping[] getFilterMappings() {
        return this._filterMappings;
    }

    @ManagedAttribute(value = "filters", readonly = true)
    public FilterHolder[] getFilters() {
        return this._filters;
    }

    @Deprecated
    public MappedResource<ServletHolder> getHolderEntry(String target) {
        if (!target.startsWith("/")) {
            return null;
        }
        MatchedResource<ServletHolder> matchedResource = getMatchedServlet(target);
        return new MappedResource<>(matchedResource.getPathSpec(), matchedResource.getResource());
    }

    public ServletContext getServletContext() {
        return this._servletContext;
    }

    public ServletContextHandler getServletContextHandler() {
        return this._contextHandler;
    }

    @ManagedAttribute(value = "mappings of servlets", readonly = true)
    public ServletMapping[] getServletMappings() {
        return this._servletMappings;
    }

    public ServletMapping getServletMapping(String pathSpec) {
        if (pathSpec == null || this._servletMappings == null) {
            return null;
        }
        ServletMapping mapping = null;
        for (int i = 0; i < this._servletMappings.length && mapping == null; i++) {
            ServletMapping m = this._servletMappings[i];
            if (m.getPathSpecs() != null) {
                String[] pathSpecs = m.getPathSpecs();
                int length = pathSpecs.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (pathSpec.equals(pathSpecs[i2])) {
                        mapping = m;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        return mapping;
    }

    @ManagedAttribute(value = "servlets", readonly = true)
    public ServletHolder[] getServlets() {
        return this._servlets;
    }

    public List<ServletHolder> getServlets(Class<?> clazz) {
        List<ServletHolder> holders = null;
        ServletHolder[] servletHolderArr = this._servlets;
        for (ServletHolder holder : servletHolderArr) {
            Class<? extends Servlet> held = holder.getHeldClass();
            if ((held == null && holder.getClassName() != null && holder.getClassName().equals(clazz.getName())) || (held != null && clazz.isAssignableFrom(holder.getHeldClass()))) {
                if (holders == null) {
                    holders = new ArrayList<>();
                }
                holders.add(holder);
            }
        }
        return holders == null ? Collections.emptyList() : holders;
    }

    public ServletHolder getServlet(String name) {
        return this._servletNameMap.get(name);
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler
    public void doScope(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String old_servlet_path = baseRequest.getServletPath();
        String old_path_info = baseRequest.getPathInfo();
        DispatcherType type = baseRequest.getDispatcherType();
        ServletHolder servletHolder = null;
        UserIdentity.Scope oldScope = null;
        MatchedResource<ServletHolder> matched = getMatchedServlet(target);
        if (matched != null) {
            servletHolder = matched.getResource();
            if (matched.getPathSpec() != null) {
                String servletPath = matched.getPathMatch();
                String pathInfo = matched.getPathInfo();
                if (DispatcherType.INCLUDE.equals(type)) {
                    baseRequest.setAttribute(RequestDispatcher.INCLUDE_SERVLET_PATH, servletPath);
                    baseRequest.setAttribute(RequestDispatcher.INCLUDE_PATH_INFO, pathInfo);
                } else {
                    baseRequest.setServletPath(servletPath);
                    baseRequest.setPathInfo(pathInfo);
                }
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("servlet {}|{}|{} -> {}", baseRequest.getContextPath(), baseRequest.getServletPath(), baseRequest.getPathInfo(), servletHolder);
        }
        try {
            oldScope = baseRequest.getUserIdentityScope();
            baseRequest.setUserIdentityScope(servletHolder);
            nextScope(target, baseRequest, request, response);
            if (oldScope != null) {
                baseRequest.setUserIdentityScope(oldScope);
            }
            if (!DispatcherType.INCLUDE.equals(type)) {
                baseRequest.setServletPath(old_servlet_path);
                baseRequest.setPathInfo(old_path_info);
            }
        } catch (Throwable th) {
            if (oldScope != null) {
                baseRequest.setUserIdentityScope(oldScope);
            }
            if (!DispatcherType.INCLUDE.equals(type)) {
                baseRequest.setServletPath(old_servlet_path);
                baseRequest.setPathInfo(old_path_info);
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler
    public void doHandle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletHolder servletHolder = (ServletHolder) baseRequest.getUserIdentityScope();
        FilterChain chain = null;
        if (!(servletHolder == null || this._filterMappings == null || this._filterMappings.length <= 0)) {
            chain = getFilterChain(baseRequest, target.startsWith("/") ? target : null, servletHolder);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("chain={}", chain);
        }
        try {
            if (servletHolder == null) {
                notFound(baseRequest, request, response);
            } else {
                ServletRequest req = request;
                if (req instanceof ServletRequestHttpWrapper) {
                    req = ((ServletRequestHttpWrapper) req).getRequest();
                }
                ServletResponse res = response;
                if (res instanceof ServletResponseHttpWrapper) {
                    res = ((ServletResponseHttpWrapper) res).getResponse();
                }
                servletHolder.prepare(baseRequest, req, res);
                if (chain != null) {
                    chain.doFilter(req, res);
                } else {
                    servletHolder.handle(baseRequest, req, res);
                }
            }
            if (servletHolder != null) {
                baseRequest.setHandled(true);
            }
        } catch (Throwable th) {
            if (servletHolder != null) {
                baseRequest.setHandled(true);
            }
            throw th;
        }
    }

    public MatchedResource<ServletHolder> getMatchedServlet(String target) {
        if (!target.startsWith("/")) {
            ServletHolder holder = this._servletNameMap.get(target);
            if (holder == null) {
                return null;
            }
            return new MatchedResource<>(holder, null, MatchedPath.EMPTY);
        } else if (this._servletPathMap == null) {
            return null;
        } else {
            return this._servletPathMap.getMatched(target);
        }
    }

    @Deprecated
    public MappedResource<ServletHolder> getMappedServlet(String target) {
        MatchedResource<ServletHolder> matchedResource = getMatchedServlet(target);
        return new MappedResource<>(matchedResource.getPathSpec(), matchedResource.getResource());
    }

    protected FilterChain getFilterChain(Request baseRequest, String pathInContext, ServletHolder servletHolder) {
        FilterChain chain;
        Objects.requireNonNull(servletHolder);
        String key = pathInContext == null ? servletHolder.getName() : pathInContext;
        int dispatch = FilterMapping.dispatch(baseRequest.getDispatcherType());
        if (this._filterChainsCached && (chain = this._chainCache[dispatch].get(key)) != null) {
            return chain;
        }
        FilterChain chain2 = null;
        if (this._filterNameMappings != null && !this._filterNameMappings.isEmpty()) {
            if (this._wildFilterNameMappings != null) {
                for (FilterMapping mapping : this._wildFilterNameMappings) {
                    chain2 = newFilterChain(mapping.getFilterHolder(), chain2 == null ? new ChainEnd(servletHolder) : chain2);
                }
            }
            List<FilterMapping> nameMappings = (List) this._filterNameMappings.get(servletHolder.getName());
            if (nameMappings != null) {
                for (FilterMapping mapping2 : nameMappings) {
                    if (mapping2.appliesTo(dispatch)) {
                        chain2 = newFilterChain(mapping2.getFilterHolder(), chain2 == null ? new ChainEnd(servletHolder) : chain2);
                    }
                }
            }
        }
        if (!(pathInContext == null || this._filterPathMappings == null)) {
            for (FilterMapping mapping3 : this._filterPathMappings) {
                if (mapping3.appliesTo(pathInContext, dispatch)) {
                    chain2 = newFilterChain(mapping3.getFilterHolder(), chain2 == null ? new ChainEnd(servletHolder) : chain2);
                }
            }
        }
        if (this._filterChainsCached) {
            Map<String, FilterChain> cache = this._chainCache[dispatch];
            if (this._maxFilterChainsCacheSize > 0 && cache.size() >= this._maxFilterChainsCacheSize) {
                LOG.debug("{} flushed filter chain cache for {}", this, baseRequest.getDispatcherType());
                cache.clear();
            }
            chain2 = chain2 == null ? new ChainEnd(servletHolder) : chain2;
            LOG.debug("{} cached filter chain for {}: {}", this, baseRequest.getDispatcherType(), chain2);
            cache.put(key, chain2);
        }
        return chain2;
    }

    protected FilterChain newFilterChain(FilterHolder filterHolder, FilterChain chain) {
        return new Chain(filterHolder, chain);
    }

    protected void invalidateChainsCache() {
        if (this._chainCache[1] != null) {
            this._chainCache[1].clear();
            this._chainCache[2].clear();
            this._chainCache[4].clear();
            this._chainCache[8].clear();
            this._chainCache[16].clear();
        }
    }

    public boolean isAvailable() {
        if (!isStarted()) {
            return false;
        }
        ServletHolder[] holders = getServlets();
        for (ServletHolder holder : holders) {
            if (!(holder == null || holder.isAvailable())) {
                return false;
            }
        }
        return true;
    }

    public void setStartWithUnavailable(boolean start) {
        this._startWithUnavailable = start;
    }

    public boolean isAllowDuplicateMappings() {
        return this._allowDuplicateMappings;
    }

    public void setAllowDuplicateMappings(boolean allowDuplicateMappings) {
        this._allowDuplicateMappings = allowDuplicateMappings;
    }

    public boolean isStartWithUnavailable() {
        return this._startWithUnavailable;
    }

    public void initialize() throws Exception {
        MultiException mx = new MultiException();
        Consumer<BaseHolder<?>> c = h -> {
            try {
                if (!h.isStarted()) {
                    h.start();
                    h.initialize();
                }
            } catch (Throwable e) {
                LOG.debug(Log.EXCEPTION, e);
                mx.add(e);
            }
        };
        Arrays.stream(this._listeners).forEach(c);
        if (this._contextHandler != null) {
            this._contextHandler.contextInitialized();
        }
        this._initialized = true;
        Stream.concat(Arrays.stream(this._filters), Arrays.stream(this._servlets).sorted()).forEach(c);
        mx.ifExceptionThrow();
    }

    public boolean isInitialized() {
        return this._initialized;
    }

    protected void initializeHolders(BaseHolder<?>[] holders) {
        for (BaseHolder<?> holder : holders) {
            holder.setServletHandler(this);
            if (isInitialized()) {
                try {
                    if (!holder.isStarted()) {
                        holder.start();
                        holder.initialize();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public boolean isFilterChainsCached() {
        return this._filterChainsCached;
    }

    public void addListener(ListenerHolder listener) {
        if (listener != null) {
            setListeners((ListenerHolder[]) ArrayUtil.addToArray(getListeners(), listener, ListenerHolder.class));
        }
    }

    public ListenerHolder[] getListeners() {
        return this._listeners;
    }

    public void setListeners(ListenerHolder[] listeners) {
        if (listeners != null) {
            initializeHolders(listeners);
        }
        updateBeans(this._listeners, listeners);
        this._listeners = listeners;
    }

    public ListenerHolder newListenerHolder(Source source) {
        return new ListenerHolder(source);
    }

    public ServletHolder newServletHolder(Source source) {
        return new ServletHolder(source);
    }

    public ServletHolder addServletWithMapping(String className, String pathSpec) {
        ServletHolder holder = newServletHolder(Source.EMBEDDED);
        holder.setClassName(className);
        addServletWithMapping(holder, pathSpec);
        return holder;
    }

    public ServletHolder addServletWithMapping(Class<? extends Servlet> servlet, String pathSpec) {
        ServletHolder holder = newServletHolder(Source.EMBEDDED);
        holder.setHeldClass(servlet);
        addServletWithMapping(holder, pathSpec);
        return holder;
    }

    public void addServletWithMapping(ServletHolder servlet, String pathSpec) {
        Objects.requireNonNull(servlet);
        ServletHolder[] holders = getServlets();
        try {
            synchronized (this) {
                if (!containsServletHolder(servlet)) {
                    setServlets((ServletHolder[]) ArrayUtil.addToArray(holders, servlet, ServletHolder.class));
                }
            }
            ServletMapping mapping = new ServletMapping();
            mapping.setServletName(servlet.getName());
            mapping.setPathSpec(pathSpec);
            setServletMappings((ServletMapping[]) ArrayUtil.addToArray(getServletMappings(), mapping, ServletMapping.class));
        } catch (RuntimeException e) {
            setServlets(holders);
            throw e;
        }
    }

    public void addServlet(ServletHolder holder) {
        if (holder != null) {
            synchronized (this) {
                if (!containsServletHolder(holder)) {
                    setServlets((ServletHolder[]) ArrayUtil.addToArray(getServlets(), holder, ServletHolder.class));
                }
            }
        }
    }

    public void addServletMapping(ServletMapping mapping) {
        setServletMappings((ServletMapping[]) ArrayUtil.addToArray(getServletMappings(), mapping, ServletMapping.class));
    }

    public Set<String> setServletSecurity(ServletRegistration.Dynamic registration, ServletSecurityElement servletSecurityElement) {
        if (this._contextHandler != null) {
            return this._contextHandler.setServletSecurity(registration, servletSecurityElement);
        }
        return Collections.emptySet();
    }

    public FilterHolder newFilterHolder(Source source) {
        return new FilterHolder(source);
    }

    public FilterHolder getFilter(String name) {
        return this._filterNameMap.get(name);
    }

    public FilterHolder addFilterWithMapping(Class<? extends Filter> filter, String pathSpec, EnumSet<DispatcherType> dispatches) {
        FilterHolder holder = newFilterHolder(Source.EMBEDDED);
        holder.setHeldClass(filter);
        addFilterWithMapping(holder, pathSpec, dispatches);
        return holder;
    }

    public FilterHolder addFilterWithMapping(String className, String pathSpec, EnumSet<DispatcherType> dispatches) {
        FilterHolder holder = newFilterHolder(Source.EMBEDDED);
        holder.setClassName(className);
        addFilterWithMapping(holder, pathSpec, dispatches);
        return holder;
    }

    public void addFilterWithMapping(FilterHolder holder, String pathSpec, EnumSet<DispatcherType> dispatches) {
        Objects.requireNonNull(holder);
        FilterHolder[] holders = getFilters();
        try {
            synchronized (this) {
                if (!containsFilterHolder(holder)) {
                    setFilters((FilterHolder[]) ArrayUtil.addToArray(holders, holder, FilterHolder.class));
                }
            }
            FilterMapping mapping = new FilterMapping();
            mapping.setFilterName(holder.getName());
            mapping.setPathSpec(pathSpec);
            mapping.setDispatcherTypes(dispatches);
            addFilterMapping(mapping);
        } catch (Throwable e) {
            setFilters(holders);
            throw e;
        }
    }

    public FilterHolder addFilterWithMapping(Class<? extends Filter> filter, String pathSpec, int dispatches) {
        FilterHolder holder = newFilterHolder(Source.EMBEDDED);
        holder.setHeldClass(filter);
        addFilterWithMapping(holder, pathSpec, dispatches);
        return holder;
    }

    public FilterHolder addFilterWithMapping(String className, String pathSpec, int dispatches) {
        FilterHolder holder = newFilterHolder(Source.EMBEDDED);
        holder.setClassName(className);
        addFilterWithMapping(holder, pathSpec, dispatches);
        return holder;
    }

    public void addFilterWithMapping(FilterHolder holder, String pathSpec, int dispatches) {
        Objects.requireNonNull(holder);
        FilterHolder[] holders = getFilters();
        if (holders != null) {
            holders = (FilterHolder[]) holders.clone();
        }
        try {
            synchronized (this) {
                if (!containsFilterHolder(holder)) {
                    setFilters((FilterHolder[]) ArrayUtil.addToArray(holders, holder, FilterHolder.class));
                }
            }
            FilterMapping mapping = new FilterMapping();
            mapping.setFilterName(holder.getName());
            mapping.setPathSpec(pathSpec);
            mapping.setDispatches(dispatches);
            addFilterMapping(mapping);
        } catch (Throwable e) {
            setFilters(holders);
            throw e;
        }
    }

    @Deprecated
    public FilterHolder addFilter(String className, String pathSpec, EnumSet<DispatcherType> dispatches) {
        return addFilterWithMapping(className, pathSpec, dispatches);
    }

    public void addFilter(FilterHolder filter, FilterMapping filterMapping) {
        if (filter != null) {
            synchronized (this) {
                if (!containsFilterHolder(filter)) {
                    setFilters((FilterHolder[]) ArrayUtil.addToArray(getFilters(), filter, FilterHolder.class));
                }
            }
        }
        if (filterMapping != null) {
            addFilterMapping(filterMapping);
        }
    }

    public void addFilter(FilterHolder filter) {
        if (filter != null) {
            synchronized (this) {
                if (!containsFilterHolder(filter)) {
                    setFilters((FilterHolder[]) ArrayUtil.addToArray(getFilters(), filter, FilterHolder.class));
                }
            }
        }
    }

    public void addFilterMapping(FilterMapping mapping) {
        if (mapping != null) {
            Source source = mapping.getFilterHolder() == null ? null : mapping.getFilterHolder().getSource();
            FilterMapping[] mappings = getFilterMappings();
            if (mappings == null || mappings.length == 0) {
                setFilterMappings(insertFilterMapping(mapping, 0, false));
                if (source == Source.JAVAX_API) {
                    this._matchAfterIndex = 0;
                }
            } else if (source == Source.JAVAX_API) {
                setFilterMappings(insertFilterMapping(mapping, mappings.length - 1, false));
                if (this._matchAfterIndex < 0) {
                    this._matchAfterIndex = getFilterMappings().length - 1;
                }
            } else if (this._matchAfterIndex < 0) {
                setFilterMappings(insertFilterMapping(mapping, mappings.length - 1, false));
            } else {
                FilterMapping[] newMappings = insertFilterMapping(mapping, this._matchAfterIndex, true);
                this._matchAfterIndex++;
                setFilterMappings(newMappings);
            }
        }
    }

    public void prependFilterMapping(FilterMapping mapping) {
        if (mapping != null) {
            Source source = mapping.getFilterHolder() == null ? null : mapping.getFilterHolder().getSource();
            FilterMapping[] mappings = getFilterMappings();
            if (mappings == null || mappings.length == 0) {
                setFilterMappings(insertFilterMapping(mapping, 0, false));
                if (source == Source.JAVAX_API) {
                    this._matchBeforeIndex = 0;
                    return;
                }
                return;
            }
            if (source != Source.JAVAX_API) {
                setFilterMappings(insertFilterMapping(mapping, 0, true));
            } else if (this._matchBeforeIndex < 0) {
                this._matchBeforeIndex = 0;
                setFilterMappings(insertFilterMapping(mapping, 0, true));
            } else {
                FilterMapping[] newMappings = insertFilterMapping(mapping, this._matchBeforeIndex, false);
                this._matchBeforeIndex++;
                setFilterMappings(newMappings);
            }
            if (this._matchAfterIndex >= 0) {
                this._matchAfterIndex++;
            }
        }
    }

    protected FilterMapping[] insertFilterMapping(FilterMapping mapping, int pos, boolean before) {
        if (pos < 0) {
            throw new IllegalArgumentException("FilterMapping insertion pos < 0");
        }
        FilterMapping[] mappings = getFilterMappings();
        if (mappings == null || mappings.length == 0) {
            return new FilterMapping[]{mapping};
        }
        FilterMapping[] newMappings = new FilterMapping[mappings.length + 1];
        if (before) {
            System.arraycopy(mappings, 0, newMappings, 0, pos);
            newMappings[pos] = mapping;
            System.arraycopy(mappings, pos, newMappings, pos + 1, mappings.length - pos);
        } else {
            System.arraycopy(mappings, 0, newMappings, 0, pos + 1);
            newMappings[pos + 1] = mapping;
            if (mappings.length > pos + 1) {
                System.arraycopy(mappings, pos + 1, newMappings, pos + 2, mappings.length - (pos + 1));
            }
        }
        return newMappings;
    }

    protected synchronized void updateNameMappings() {
        this._filterNameMap.clear();
        if (this._filters != null) {
            FilterHolder[] filterHolderArr = this._filters;
            for (FilterHolder filter : filterHolderArr) {
                this._filterNameMap.put(filter.getName(), filter);
                filter.setServletHandler(this);
            }
        }
        this._servletNameMap.clear();
        if (this._servlets != null) {
            ServletHolder[] servletHolderArr = this._servlets;
            for (ServletHolder servlet : servletHolderArr) {
                this._servletNameMap.put(servlet.getName(), servlet);
                servlet.setServletHandler(this);
            }
        }
    }

    protected PathSpec asPathSpec(String pathSpec) {
        return new ServletPathSpec(pathSpec);
    }

    protected void updateMappings() {
        if (this._filterMappings == null) {
            this._filterPathMappings = null;
            this._filterNameMappings = null;
            this._wildFilterNameMappings = Collections.emptyList();
        } else {
            this._filterPathMappings = new ArrayList();
            this._filterNameMappings = new MultiMap<>();
            FilterMapping[] filterMappingArr = this._filterMappings;
            for (FilterMapping filtermapping : filterMappingArr) {
                FilterHolder filterHolder = this._filterNameMap.get(filtermapping.getFilterName());
                if (filterHolder == null) {
                    throw new IllegalStateException("No filter named " + filtermapping.getFilterName());
                }
                filtermapping.setFilterHolder(filterHolder);
                if (filtermapping.getPathSpecs() != null) {
                    this._filterPathMappings.add(filtermapping);
                }
                if (filtermapping.getServletNames() != null) {
                    String[] names = filtermapping.getServletNames();
                    for (String name : names) {
                        if (name != null) {
                            this._filterNameMappings.add(name, filtermapping);
                        }
                    }
                }
            }
            for (Map.Entry<String, FilterMapping> entry : this._filterNameMappings.entrySet()) {
                Collections.reverse((List) entry.getValue());
            }
            Collections.reverse(this._filterPathMappings);
            this._wildFilterNameMappings = (List) this._filterNameMappings.get("*");
            if (this._wildFilterNameMappings != null) {
                Collections.reverse(this._wildFilterNameMappings);
            }
        }
        if (this._servletMappings == null) {
            this._servletPathMap = null;
        } else {
            PathMappings<ServletHolder> pm = new PathMappings<>();
            HashMap<String, List<ServletMapping>> sms = new HashMap<>();
            ServletMapping[] servletMappingArr = this._servletMappings;
            for (ServletMapping servletMapping : servletMappingArr) {
                String[] pathSpecs = servletMapping.getPathSpecs();
                if (pathSpecs != null) {
                    for (String pathSpec : pathSpecs) {
                        sms.computeIfAbsent(pathSpec, k -> {
                            return new ArrayList();
                        }).add(servletMapping);
                    }
                }
            }
            for (String pathSpec2 : sms.keySet()) {
                ServletMapping finalMapping = null;
                for (ServletMapping mapping : sms.get(pathSpec2)) {
                    ServletHolder servletHolder = this._servletNameMap.get(mapping.getServletName());
                    if (servletHolder == null) {
                        throw new IllegalStateException("No such servlet: " + mapping.getServletName());
                    } else if (servletHolder.isEnabled()) {
                        if (finalMapping == null) {
                            finalMapping = mapping;
                        } else if (finalMapping.isDefault()) {
                            finalMapping = mapping;
                        } else if (isAllowDuplicateMappings()) {
                            LOG.warn("Multiple servlets map to path {}: {} and {}, choosing {}", pathSpec2, finalMapping.getServletName(), mapping.getServletName(), mapping);
                            finalMapping = mapping;
                        } else if (!mapping.isDefault()) {
                            throw new IllegalStateException("Multiple servlets map to path " + pathSpec2 + ": " + this._servletNameMap.get(finalMapping.getServletName()).getName() + "[mapped:" + finalMapping.getSource() + "]," + mapping.getServletName() + "[mapped:" + mapping.getSource() + "]");
                        }
                    }
                }
                if (finalMapping == null) {
                    throw new IllegalStateException("No acceptable servlet mappings for " + pathSpec2);
                }
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Path={}[{}] mapped to servlet={}[{}]", pathSpec2, finalMapping.getSource(), finalMapping.getServletName(), this._servletNameMap.get(finalMapping.getServletName()).getSource());
                }
                pm.put(asPathSpec(pathSpec2), (PathSpec) this._servletNameMap.get(finalMapping.getServletName()));
            }
            this._servletPathMap = pm;
        }
        int i = this._chainCache.length;
        while (true) {
            i--;
            if (i <= 0) {
                break;
            } else if (this._chainCache[i] != null) {
                this._chainCache[i].clear();
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("filterNameMap=" + this._filterNameMap, new Object[0]);
            LOG.debug("pathFilters=" + this._filterPathMappings, new Object[0]);
            LOG.debug("servletFilterMap=" + this._filterNameMappings, new Object[0]);
            LOG.debug("servletPathMap=" + this._servletPathMap, new Object[0]);
            LOG.debug("servletNameMap=" + this._servletNameMap, new Object[0]);
        }
    }

    protected void notFound(Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Not Found {}", request.getRequestURI());
        }
        if (getHandler() != null) {
            nextHandle(URIUtil.addPaths(request.getServletPath(), request.getPathInfo()), baseRequest, request, response);
        }
    }

    protected synchronized boolean containsFilterHolder(FilterHolder holder) {
        if (this._filters == null) {
            return false;
        }
        for (FilterHolder f : this._filters) {
            if (f == holder) {
                return true;
            }
        }
        return false;
    }

    protected synchronized boolean containsServletHolder(ServletHolder holder) {
        if (this._servlets == null) {
            return false;
        }
        for (ServletHolder s : this._servlets) {
            if (s == holder) {
                return true;
            }
        }
        return false;
    }

    public void setFilterChainsCached(boolean filterChainsCached) {
        this._filterChainsCached = filterChainsCached;
    }

    public void setFilterMappings(FilterMapping[] filterMappings) {
        updateBeans(this._filterMappings, filterMappings);
        this._filterMappings = filterMappings;
        if (isRunning()) {
            updateMappings();
        }
        invalidateChainsCache();
    }

    public synchronized void setFilters(FilterHolder[] holders) {
        if (holders != null) {
            initializeHolders(holders);
        }
        updateBeans(this._filters, holders);
        this._filters = holders;
        updateNameMappings();
        invalidateChainsCache();
    }

    public void setServletMappings(ServletMapping[] servletMappings) {
        updateBeans(this._servletMappings, servletMappings);
        this._servletMappings = servletMappings;
        if (isRunning()) {
            updateMappings();
        }
        invalidateChainsCache();
    }

    public synchronized void setServlets(ServletHolder[] holders) {
        if (holders != null) {
            initializeHolders(holders);
        }
        updateBeans(this._servlets, holders);
        this._servlets = holders;
        updateNameMappings();
        invalidateChainsCache();
    }

    public int getMaxFilterChainsCacheSize() {
        return this._maxFilterChainsCacheSize;
    }

    public void setMaxFilterChainsCacheSize(int maxFilterChainsCacheSize) {
        this._maxFilterChainsCacheSize = maxFilterChainsCacheSize;
    }

    /* access modifiers changed from: package-private */
    public void destroyServlet(Servlet servlet) {
        if (this._contextHandler != null) {
            this._contextHandler.destroyServlet(servlet);
        }
    }

    /* access modifiers changed from: package-private */
    public void destroyFilter(Filter filter) {
        if (this._contextHandler != null) {
            this._contextHandler.destroyFilter(filter);
        }
    }

    /* access modifiers changed from: package-private */
    public void destroyListener(EventListener listener) {
        if (this._contextHandler != null) {
            this._contextHandler.destroyListener(listener);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHandler$Default404Servlet.class */
    public static class Default404Servlet extends HttpServlet {
        @Override // javax.servlet.http.HttpServlet
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.sendError(404);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHandler$Chain.class */
    public static class Chain implements FilterChain {
        private final FilterHolder _filterHolder;
        private final FilterChain _filterChain;

        Chain(FilterHolder filter, FilterChain chain) {
            this._filterHolder = filter;
            this._filterChain = chain;
        }

        @Override // javax.servlet.FilterChain
        public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
            this._filterHolder.doFilter(request, response, this._filterChain);
        }

        public String toString() {
            return String.format("Chain@%x(%s)->%s", Integer.valueOf(hashCode()), this._filterHolder, this._filterChain);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHandler$ChainEnd.class */
    public static class ChainEnd implements FilterChain {
        private final ServletHolder _servletHolder;

        ChainEnd(ServletHolder holder) {
            Objects.requireNonNull(holder);
            this._servletHolder = holder;
        }

        public ServletHolder getServletHolder() {
            return this._servletHolder;
        }

        @Override // javax.servlet.FilterChain
        public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
            Request baseRequest = Request.getBaseRequest(request);
            Objects.requireNonNull(baseRequest);
            this._servletHolder.handle(baseRequest, request, response);
        }

        public String toString() {
            return String.format("ChainEnd@%x(%s)", Integer.valueOf(hashCode()), this._servletHolder);
        }
    }
}
