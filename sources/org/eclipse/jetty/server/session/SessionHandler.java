package org.eclipse.jetty.server.session;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.http.Syntax;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.SessionIdManager;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ScopedHandler;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.statistic.CounterStatistic;
import org.eclipse.jetty.util.statistic.SampleStatistic;
import org.eclipse.jetty.util.thread.Locker;
import org.eclipse.jetty.util.thread.ScheduledExecutorScheduler;
import org.eclipse.jetty.util.thread.Scheduler;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/SessionHandler.class */
public class SessionHandler extends ScopedHandler {
    public static final String __SessionCookieProperty = "org.eclipse.jetty.servlet.SessionCookie";
    public static final String __DefaultSessionCookie = "JSESSIONID";
    public static final String __SessionIdPathParameterNameProperty = "org.eclipse.jetty.servlet.SessionIdPathParameterName";
    public static final String __DefaultSessionIdPathParameterName = "jsessionid";
    public static final String __CheckRemoteSessionEncoding = "org.eclipse.jetty.servlet.CheckingRemoteSessionIdEncoding";
    public static final String __SessionDomainProperty = "org.eclipse.jetty.servlet.SessionDomain";
    public static final String __SessionPathProperty = "org.eclipse.jetty.servlet.SessionPath";
    public static final String __MaxAgeProperty = "org.eclipse.jetty.servlet.MaxAge";
    protected SessionIdManager _sessionIdManager;
    protected ClassLoader _loader;
    protected ContextHandler.Context _context;
    protected SessionContext _sessionContext;
    protected String _sessionDomain;
    protected String _sessionPath;
    protected int _refreshCookieAge;
    protected boolean _nodeIdInSessionId;
    protected boolean _checkingRemoteSessionIdEncoding;
    protected String _sessionComment;
    protected SessionCache _sessionCache;
    public Set<SessionTrackingMode> _sessionTrackingModes;
    protected boolean _usingURLs;
    protected Scheduler _scheduler;
    static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    public static final EnumSet<SessionTrackingMode> DEFAULT_TRACKING = EnumSet.of(SessionTrackingMode.COOKIE, SessionTrackingMode.URL);
    public static final String __DefaultSessionDomain = null;
    public static final Set<SessionTrackingMode> DEFAULT_SESSION_TRACKING_MODES = Collections.unmodifiableSet(new HashSet(Arrays.asList(SessionTrackingMode.COOKIE, SessionTrackingMode.URL)));
    public static final Class<? extends EventListener>[] SESSION_LISTENER_TYPES = {HttpSessionAttributeListener.class, HttpSessionIdListener.class, HttpSessionListener.class};
    public static final BigDecimal MAX_INACTIVE_MINUTES = new BigDecimal(35791394);
    static final HttpSessionContext __nullSessionContext = new HttpSessionContext() { // from class: org.eclipse.jetty.server.session.SessionHandler.1
        @Override // javax.servlet.http.HttpSessionContext
        public HttpSession getSession(String sessionId) {
            return null;
        }

        @Override // javax.servlet.http.HttpSessionContext
        public Enumeration getIds() {
            return Collections.enumeration(Collections.EMPTY_LIST);
        }
    };
    protected int _dftMaxIdleSecs = -1;
    protected boolean _httpOnly = false;
    protected boolean _secureCookies = false;
    protected boolean _secureRequestOnly = true;
    protected final List<HttpSessionAttributeListener> _sessionAttributeListeners = new CopyOnWriteArrayList();
    protected final List<HttpSessionListener> _sessionListeners = new CopyOnWriteArrayList();
    protected final List<HttpSessionIdListener> _sessionIdListeners = new CopyOnWriteArrayList();
    protected String _sessionCookie = __DefaultSessionCookie;
    protected String _sessionIdPathParameterName = __DefaultSessionIdPathParameterName;
    protected String _sessionIdPathParameterNamePrefix = ";" + this._sessionIdPathParameterName + "=";
    protected int _maxCookieAge = -1;
    protected final SampleStatistic _sessionTimeStats = new SampleStatistic();
    protected final CounterStatistic _sessionsCreatedStats = new CounterStatistic();
    protected boolean _usingCookies = true;
    protected Set<String> _candidateSessionIdsForExpiry = ConcurrentHashMap.newKeySet();
    protected boolean _ownScheduler = false;
    private SessionCookieConfig _cookieConfig = new CookieConfig();

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/SessionHandler$SessionIf.class */
    public interface SessionIf extends HttpSession {
        Session getSession();
    }

    public SessionHandler() {
        setSessionTrackingModes(DEFAULT_SESSION_TRACKING_MODES);
    }

    @ManagedAttribute("path of the session cookie, or null for default")
    public String getSessionPath() {
        return this._sessionPath;
    }

    @ManagedAttribute("if greater the zero, the time in seconds a session cookie will last for")
    public int getMaxCookieAge() {
        return this._maxCookieAge;
    }

    public HttpCookie access(HttpSession session, boolean secure) {
        long now = System.currentTimeMillis();
        Session s = ((SessionIf) session).getSession();
        if (!s.access(now) || !isUsingCookies()) {
            return null;
        }
        if (!s.isIdChanged() && (getSessionCookieConfig().getMaxAge() <= 0 || getRefreshCookieAge() <= 0 || (now - s.getCookieSetTime()) / 1000 <= ((long) getRefreshCookieAge()))) {
            return null;
        }
        HttpCookie cookie = getSessionCookie(session, this._context == null ? "/" : this._context.getContextPath(), secure);
        s.cookieSet();
        s.setIdChanged(false);
        return cookie;
    }

    public void addEventListener(EventListener listener) {
        if (listener instanceof HttpSessionAttributeListener) {
            this._sessionAttributeListeners.add((HttpSessionAttributeListener) listener);
        }
        if (listener instanceof HttpSessionListener) {
            this._sessionListeners.add((HttpSessionListener) listener);
        }
        if (listener instanceof HttpSessionIdListener) {
            this._sessionIdListeners.add((HttpSessionIdListener) listener);
        }
        addBean((Object) listener, false);
    }

    public void clearEventListeners() {
        for (EventListener e : getBeans(EventListener.class)) {
            removeBean(e);
        }
        this._sessionAttributeListeners.clear();
        this._sessionListeners.clear();
        this._sessionIdListeners.clear();
    }

    /* access modifiers changed from: protected */
    public void callSessionDestroyedListeners(final Session session) {
        if (session != null && this._sessionListeners != null) {
            this._sessionContext.run(new Runnable() { // from class: org.eclipse.jetty.server.session.SessionHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    HttpSessionEvent event = new HttpSessionEvent(session);
                    for (int i = SessionHandler.this._sessionListeners.size() - 1; i >= 0; i--) {
                        SessionHandler.this._sessionListeners.get(i).sessionDestroyed(event);
                    }
                }
            });
        }
    }

    protected void callSessionCreatedListeners(Session session) {
        if (!(session == null || this._sessionListeners == null)) {
            HttpSessionEvent event = new HttpSessionEvent(session);
            for (int i = this._sessionListeners.size() - 1; i >= 0; i--) {
                this._sessionListeners.get(i).sessionCreated(event);
            }
        }
    }

    protected void callSessionIdListeners(Session session, String oldId) {
        if (!this._sessionIdListeners.isEmpty()) {
            HttpSessionEvent event = new HttpSessionEvent(session);
            for (HttpSessionIdListener l : this._sessionIdListeners) {
                l.sessionIdChanged(event, oldId);
            }
        }
    }

    public void complete(HttpSession session) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Complete called with session {}", session);
        }
        if (session != null) {
            Session s = ((SessionIf) session).getSession();
            try {
                this._sessionCache.release(s.getId(), s);
            } catch (Exception e) {
                LOG.warn(e);
            }
        }
    }

    public void commit(HttpSession session) {
        if (session != null) {
            try {
                this._sessionCache.commit(((SessionIf) session).getSession());
            } catch (Exception e) {
                LOG.warn(e);
            }
        }
    }

    @Deprecated
    public void complete(Session session, Request baseRequest) {
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStart() throws Exception {
        String tmp;
        SessionDataStore sds;
        Server server = getServer();
        this._context = ContextHandler.getCurrentContext();
        this._loader = Thread.currentThread().getContextClassLoader();
        synchronized (server) {
            if (this._sessionCache == null) {
                SessionCacheFactory ssFactory = (SessionCacheFactory) server.getBean((Class<Object>) SessionCacheFactory.class);
                setSessionCache(ssFactory != null ? ssFactory.getSessionCache(this) : new DefaultSessionCache(this));
                SessionDataStoreFactory sdsFactory = (SessionDataStoreFactory) server.getBean((Class<Object>) SessionDataStoreFactory.class);
                if (sdsFactory != null) {
                    sds = sdsFactory.getSessionDataStore(this);
                } else {
                    sds = new NullSessionDataStore();
                }
                this._sessionCache.setSessionDataStore(sds);
            }
            if (this._sessionIdManager == null) {
                this._sessionIdManager = server.getSessionIdManager();
                if (this._sessionIdManager == null) {
                    Thread.currentThread().setContextClassLoader(server.getClass().getClassLoader());
                    this._sessionIdManager = new DefaultSessionIdManager(server);
                    server.setSessionIdManager(this._sessionIdManager);
                    server.manage(this._sessionIdManager);
                    this._sessionIdManager.start();
                    Thread.currentThread().setContextClassLoader(this._loader);
                }
                addBean((Object) this._sessionIdManager, false);
            }
            this._scheduler = (Scheduler) server.getBean((Class<Object>) Scheduler.class);
            if (this._scheduler == null) {
                this._scheduler = new ScheduledExecutorScheduler(String.format("Session-Scheduler-%x", Integer.valueOf(hashCode())), false);
                this._ownScheduler = true;
                this._scheduler.start();
            }
        }
        if (this._context != null) {
            String tmp2 = this._context.getInitParameter(__SessionCookieProperty);
            if (tmp2 != null) {
                this._sessionCookie = tmp2;
            }
            String tmp3 = this._context.getInitParameter(__SessionIdPathParameterNameProperty);
            if (tmp3 != null) {
                setSessionIdPathParameterName(tmp3);
            }
            if (this._maxCookieAge == -1 && (tmp = this._context.getInitParameter(__MaxAgeProperty)) != null) {
                this._maxCookieAge = Integer.parseInt(tmp.trim());
            }
            if (this._sessionDomain == null) {
                this._sessionDomain = this._context.getInitParameter(__SessionDomainProperty);
            }
            if (this._sessionPath == null) {
                this._sessionPath = this._context.getInitParameter(__SessionPathProperty);
            }
            String tmp4 = this._context.getInitParameter(__CheckRemoteSessionEncoding);
            if (tmp4 != null) {
                this._checkingRemoteSessionIdEncoding = Boolean.parseBoolean(tmp4);
            }
        }
        this._sessionContext = new SessionContext(this._sessionIdManager.getWorkerName(), this._context);
        this._sessionCache.initialize(this._sessionContext);
        doStart();
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        shutdownSessions();
        this._sessionCache.stop();
        if (this._ownScheduler && this._scheduler != null) {
            this._scheduler.stop();
        }
        this._scheduler = null;
        doStop();
        this._loader = null;
    }

    @ManagedAttribute("true if cookies use the http only flag")
    public boolean getHttpOnly() {
        return this._httpOnly;
    }

    @ManagedAttribute("SameSite setting for session cookies")
    public HttpCookie.SameSite getSameSite() {
        return HttpCookie.getSameSiteFromComment(this._sessionComment);
    }

    protected HttpSession getHttpSession(String extendedId) {
        Session session = getSession(getSessionIdManager().getId(extendedId));
        if (session != null && !session.getExtendedId().equals(extendedId)) {
            session.setIdChanged(true);
        }
        return session;
    }

    @ManagedAttribute("Session ID Manager")
    public SessionIdManager getSessionIdManager() {
        return this._sessionIdManager;
    }

    @ManagedAttribute("default maximum time a session may be idle for (in s)")
    public int getMaxInactiveInterval() {
        return this._dftMaxIdleSecs;
    }

    @ManagedAttribute("time before a session cookie is re-set (in s)")
    public int getRefreshCookieAge() {
        return this._refreshCookieAge;
    }

    @ManagedAttribute("if true, secure cookie flag is set on session cookies")
    public boolean getSecureCookies() {
        return this._secureCookies;
    }

    public boolean isSecureRequestOnly() {
        return this._secureRequestOnly;
    }

    public void setSecureRequestOnly(boolean secureRequestOnly) {
        this._secureRequestOnly = secureRequestOnly;
    }

    @ManagedAttribute("the set session cookie")
    public String getSessionCookie() {
        return this._sessionCookie;
    }

    public HttpCookie getSessionCookie(HttpSession session, String contextPath, boolean requestIsSecure) {
        if (!isUsingCookies()) {
            return null;
        }
        String sessionPath = this._cookieConfig.getPath() == null ? contextPath : this._cookieConfig.getPath();
        String sessionPath2 = StringUtil.isEmpty(sessionPath) ? "/" : sessionPath;
        return new HttpCookie(getSessionCookieName(this._cookieConfig), getExtendedId(session), this._cookieConfig.getDomain(), sessionPath2, (long) this._cookieConfig.getMaxAge(), this._cookieConfig.isHttpOnly(), this._cookieConfig.isSecure() || (isSecureRequestOnly() && requestIsSecure), HttpCookie.getCommentWithoutAttributes(this._cookieConfig.getComment()), 0, HttpCookie.getSameSiteFromComment(this._cookieConfig.getComment()));
    }

    @ManagedAttribute("domain of the session cookie, or null for the default")
    public String getSessionDomain() {
        return this._sessionDomain;
    }

    @ManagedAttribute("number of sessions created by this node")
    public int getSessionsCreated() {
        return (int) this._sessionsCreatedStats.getCurrent();
    }

    @ManagedAttribute("name of use for URL session tracking")
    public String getSessionIdPathParameterName() {
        return this._sessionIdPathParameterName;
    }

    public String getSessionIdPathParameterNamePrefix() {
        return this._sessionIdPathParameterNamePrefix;
    }

    public boolean isUsingCookies() {
        return this._usingCookies;
    }

    public boolean isValid(HttpSession session) {
        return ((SessionIf) session).getSession().isValid();
    }

    public String getId(HttpSession session) {
        return ((SessionIf) session).getSession().getId();
    }

    public String getExtendedId(HttpSession session) {
        return ((SessionIf) session).getSession().getExtendedId();
    }

    public HttpSession newHttpSession(HttpServletRequest request) {
        long created = System.currentTimeMillis();
        String id = this._sessionIdManager.newSessionId(request, created);
        Session session = this._sessionCache.newSession(request, id, created, this._dftMaxIdleSecs > 0 ? ((long) this._dftMaxIdleSecs) * 1000 : -1);
        session.setExtendedId(this._sessionIdManager.getExtendedId(id, request));
        session.getSessionData().setLastNode(this._sessionIdManager.getWorkerName());
        try {
            this._sessionCache.add(id, session);
            Request baseRequest = Request.getBaseRequest(request);
            baseRequest.setSession(session);
            baseRequest.enterSession(session);
            this._sessionsCreatedStats.increment();
            if (request != null && request.isSecure()) {
                session.setAttribute(Session.SESSION_CREATED_SECURE, Boolean.TRUE);
            }
            callSessionCreatedListeners(session);
            return session;
        } catch (Exception e) {
            LOG.warn(e);
            return null;
        }
    }

    public void removeEventListener(EventListener listener) {
        if (listener instanceof HttpSessionAttributeListener) {
            this._sessionAttributeListeners.remove(listener);
        }
        if (listener instanceof HttpSessionListener) {
            this._sessionListeners.remove(listener);
        }
        if (listener instanceof HttpSessionIdListener) {
            this._sessionIdListeners.remove(listener);
        }
        removeBean(listener);
    }

    @ManagedOperation(value = "reset statistics", impact = "ACTION")
    public void statsReset() {
        this._sessionsCreatedStats.reset();
        this._sessionTimeStats.reset();
    }

    public void setHttpOnly(boolean httpOnly) {
        this._httpOnly = httpOnly;
    }

    public void setSameSite(HttpCookie.SameSite sameSite) {
        this._sessionComment = HttpCookie.getCommentWithAttributes(this._sessionComment, false, sameSite);
    }

    public void setSessionIdManager(SessionIdManager metaManager) {
        updateBean(this._sessionIdManager, metaManager);
        this._sessionIdManager = metaManager;
    }

    public void setMaxInactiveInterval(int seconds) {
        this._dftMaxIdleSecs = seconds;
        if (!LOG.isDebugEnabled()) {
            return;
        }
        if (this._dftMaxIdleSecs <= 0) {
            LOG.debug("Sessions created by this manager are immortal (default maxInactiveInterval={})", (long) this._dftMaxIdleSecs);
        } else {
            LOG.debug("SessionManager default maxInactiveInterval={}", (long) this._dftMaxIdleSecs);
        }
    }

    public void setRefreshCookieAge(int ageInSeconds) {
        this._refreshCookieAge = ageInSeconds;
    }

    public void setSessionCookie(String cookieName) {
        this._sessionCookie = cookieName;
    }

    public void setSessionIdPathParameterName(String param) {
        this._sessionIdPathParameterName = (param == null || "none".equals(param)) ? null : param;
        this._sessionIdPathParameterNamePrefix = (param == null || "none".equals(param)) ? null : ";" + this._sessionIdPathParameterName + "=";
    }

    public void setUsingCookies(boolean usingCookies) {
        this._usingCookies = usingCookies;
    }

    public Session getSession(String id) {
        try {
            Session session = this._sessionCache.get(id);
            if (session != null) {
                if (session.isExpiredAt(System.currentTimeMillis())) {
                    try {
                        session.invalidate();
                        return null;
                    } catch (Exception e) {
                        LOG.warn("Invalidating session {} found to be expired when requested", id);
                        LOG.warn(e);
                        return null;
                    }
                } else {
                    session.setExtendedId(this._sessionIdManager.getExtendedId(id, null));
                }
            }
            return session;
        } catch (UnreadableSessionDataException e2) {
            LOG.warn("Error loading session {}", id);
            LOG.warn(e2);
            try {
                getSessionIdManager().invalidateAll(id);
                return null;
            } catch (Exception x) {
                LOG.warn("Error cross-context invalidating unreadable session {}", id);
                LOG.warn(x);
                return null;
            }
        } catch (Exception other) {
            LOG.warn(other);
            return null;
        }
    }

    protected void shutdownSessions() throws Exception {
        this._sessionCache.shutdown();
    }

    public SessionCache getSessionCache() {
        return this._sessionCache;
    }

    public void setSessionCache(SessionCache cache) {
        updateBean(this._sessionCache, cache);
        this._sessionCache = cache;
    }

    public boolean isNodeIdInSessionId() {
        return this._nodeIdInSessionId;
    }

    public void setNodeIdInSessionId(boolean nodeIdInSessionId) {
        this._nodeIdInSessionId = nodeIdInSessionId;
    }

    public Session removeSession(String id, boolean invalidate) {
        try {
            Session session = this._sessionCache.delete(id);
            if (session != null && invalidate) {
                session.beginInvalidate();
                if (this._sessionListeners != null) {
                    HttpSessionEvent event = new HttpSessionEvent(session);
                    for (int i = this._sessionListeners.size() - 1; i >= 0; i--) {
                        this._sessionListeners.get(i).sessionDestroyed(event);
                    }
                }
            }
            return session;
        } catch (Exception e) {
            LOG.warn(e);
            return null;
        }
    }

    @ManagedAttribute("maximum amount of time sessions have remained active (in s)")
    public long getSessionTimeMax() {
        return this._sessionTimeStats.getMax();
    }

    public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
        return DEFAULT_SESSION_TRACKING_MODES;
    }

    public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
        return Collections.unmodifiableSet(this._sessionTrackingModes);
    }

    public void setSessionTrackingModes(Set<SessionTrackingMode> sessionTrackingModes) {
        if (sessionTrackingModes == null || sessionTrackingModes.size() <= 1 || !sessionTrackingModes.contains(SessionTrackingMode.SSL)) {
            this._sessionTrackingModes = new HashSet(sessionTrackingModes);
            this._usingCookies = this._sessionTrackingModes.contains(SessionTrackingMode.COOKIE);
            this._usingURLs = this._sessionTrackingModes.contains(SessionTrackingMode.URL);
            return;
        }
        throw new IllegalArgumentException("sessionTrackingModes specifies a combination of SessionTrackingMode.SSL with a session tracking mode other than SessionTrackingMode.SSL");
    }

    public boolean isUsingURLs() {
        return this._usingURLs;
    }

    public SessionCookieConfig getSessionCookieConfig() {
        return this._cookieConfig;
    }

    @ManagedAttribute("total time sessions have remained valid")
    public long getSessionTimeTotal() {
        return this._sessionTimeStats.getTotal();
    }

    @ManagedAttribute("mean time sessions remain valid (in s)")
    public double getSessionTimeMean() {
        return this._sessionTimeStats.getMean();
    }

    @ManagedAttribute("standard deviation a session remained valid (in s)")
    public double getSessionTimeStdDev() {
        return this._sessionTimeStats.getStdDev();
    }

    @ManagedAttribute("check remote session id encoding")
    public boolean isCheckingRemoteSessionIdEncoding() {
        return this._checkingRemoteSessionIdEncoding;
    }

    public void setCheckingRemoteSessionIdEncoding(boolean remote) {
        this._checkingRemoteSessionIdEncoding = remote;
    }

    public void renewSessionId(String oldId, String oldExtendedId, String newId, String newExtendedId) {
        Session session;
        try {
            session = null;
            try {
                session = this._sessionCache.renewSessionId(oldId, newId, oldExtendedId, newExtendedId);
                if (session != null) {
                    callSessionIdListeners(session, oldId);
                    if (session != null) {
                        try {
                            this._sessionCache.release(newId, session);
                        } catch (Exception e) {
                            LOG.warn(e);
                        }
                    }
                } else if (session != null) {
                    try {
                        this._sessionCache.release(newId, session);
                    } catch (Exception e2) {
                        LOG.warn(e2);
                    }
                }
            } catch (Exception e3) {
                LOG.warn(e3);
                if (session != null) {
                    try {
                        this._sessionCache.release(newId, session);
                    } catch (Exception e4) {
                        LOG.warn(e4);
                    }
                }
            }
        } catch (Throwable th) {
            if (session != null) {
                try {
                    this._sessionCache.release(newId, session);
                } catch (Exception e5) {
                    LOG.warn(e5);
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void recordSessionTime(Session session) {
        this._sessionTimeStats.record(Math.round(((double) (System.currentTimeMillis() - session.getSessionData().getCreated())) / 1000.0d));
    }

    public void invalidate(String id) {
        if (!StringUtil.isBlank(id)) {
            try {
                Session session = this._sessionCache.delete(id);
                if (session != null) {
                    try {
                        if (session.beginInvalidate()) {
                            try {
                                callSessionDestroyedListeners(session);
                            } catch (Exception e) {
                                LOG.warn(e);
                            }
                            session.finishInvalidate();
                        }
                    } catch (IllegalStateException e2) {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Session {} already invalid", session);
                        }
                        LOG.ignore(e2);
                    }
                }
            } catch (Exception e3) {
                LOG.warn(e3);
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x00a9
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public void scavenge() {
        /*
            r7 = this;
            r0 = r7
            boolean r0 = r0.isStopping()
            if (r0 != 0) goto L_0x000e
            r0 = r7
            boolean r0 = r0.isStopped()
            if (r0 == 0) goto L_0x000f
        L_0x000e:
            return
        L_0x000f:
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.SessionHandler.LOG
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x002c
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.SessionHandler.LOG
            java.lang.String r1 = "{} scavenging sessions"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r7
            r3[r4] = r5
            r0.debug(r1, r2)
        L_0x002c:
            r0 = r7
            java.util.Set<java.lang.String> r0 = r0._candidateSessionIdsForExpiry
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            java.lang.String[] r0 = (java.lang.String[]) r0
            r8 = r0
            java.util.HashSet r0 = new java.util.HashSet
            r1 = r0
            r2 = r8
            java.util.List r2 = java.util.Arrays.asList(r2)
            r1.<init>(r2)
            r9 = r0
            r0 = r7
            java.util.Set<java.lang.String> r0 = r0._candidateSessionIdsForExpiry
            r1 = r9
            boolean r0 = r0.removeAll(r1)
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.SessionHandler.LOG
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x0075
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.SessionHandler.LOG
            java.lang.String r1 = "{} scavenging session ids {}"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r7
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = r9
            r3[r4] = r5
            r0.debug(r1, r2)
        L_0x0075:
            r0 = r7
            org.eclipse.jetty.server.session.SessionCache r0 = r0._sessionCache     // Catch: Exception -> 0x00bb
            r1 = r9
            java.util.Set r0 = r0.checkExpiration(r1)     // Catch: Exception -> 0x00bb
            r9 = r0
            r0 = r9
            java.util.Iterator r0 = r0.iterator()     // Catch: Exception -> 0x00bb
            r10 = r0
        L_0x0087:
            r0 = r10
            boolean r0 = r0.hasNext()     // Catch: Exception -> 0x00bb
            if (r0 == 0) goto L_0x00b8
            r0 = r10
            java.lang.Object r0 = r0.next()     // Catch: Exception -> 0x00bb
            java.lang.String r0 = (java.lang.String) r0     // Catch: Exception -> 0x00bb
            r11 = r0
            r0 = r7
            org.eclipse.jetty.server.SessionIdManager r0 = r0.getSessionIdManager()     // Catch: Exception -> 0x00bb, Exception -> 0x00a9
            r1 = r11
            r0.expireAll(r1)     // Catch: Exception -> 0x00bb, Exception -> 0x00a9
            goto L_0x00b5
        L_0x00a9:
            r12 = move-exception
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.SessionHandler.LOG     // Catch: Exception -> 0x00bb
            r1 = r12
            r0.warn(r1)     // Catch: Exception -> 0x00bb
        L_0x00b5:
            goto L_0x0087
        L_0x00b8:
            goto L_0x00c5
        L_0x00bb:
            r10 = move-exception
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.SessionHandler.LOG
            r1 = r10
            r0.warn(r1)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.SessionHandler.scavenge():void");
    }

    @Deprecated
    public void sessionInactivityTimerExpired(Session session) {
        sessionInactivityTimerExpired(session, System.currentTimeMillis());
    }

    public void sessionInactivityTimerExpired(Session session, long now) {
        if (session != null) {
            Locker.Lock lock = session.lock();
            try {
                if (session.getRequests() <= 0) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Inspecting session {}, valid={}", session.getId(), Boolean.valueOf(session.isValid()));
                    }
                    if (session.isValid()) {
                        if (!session.isExpiredAt(now)) {
                            this._sessionCache.checkInactiveSession(session);
                        } else if (this._sessionIdManager.getSessionHouseKeeper() != null && this._sessionIdManager.getSessionHouseKeeper().getIntervalSec() > 0) {
                            this._candidateSessionIdsForExpiry.add(session.getId());
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Session {} is candidate for expiry", session.getId());
                            }
                        }
                        if (lock != null) {
                            lock.close();
                        }
                    } else if (lock != null) {
                        lock.close();
                    }
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
    }

    public boolean isIdInUse(String id) throws Exception {
        return this._sessionCache.exists(id);
    }

    public Scheduler getScheduler() {
        return this._scheduler;
    }

    public static String getSessionCookieName(SessionCookieConfig config) {
        if (config == null || config.getName() == null) {
            return __DefaultSessionCookie;
        }
        return config.getName();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/SessionHandler$CookieConfig.class */
    public final class CookieConfig implements SessionCookieConfig {
        public CookieConfig() {
        }

        @Override // javax.servlet.SessionCookieConfig
        public String getComment() {
            return SessionHandler.this._sessionComment;
        }

        @Override // javax.servlet.SessionCookieConfig
        public String getDomain() {
            return SessionHandler.this._sessionDomain;
        }

        @Override // javax.servlet.SessionCookieConfig
        public int getMaxAge() {
            return SessionHandler.this._maxCookieAge;
        }

        @Override // javax.servlet.SessionCookieConfig
        public String getName() {
            return SessionHandler.this._sessionCookie;
        }

        @Override // javax.servlet.SessionCookieConfig
        public String getPath() {
            return SessionHandler.this._sessionPath;
        }

        @Override // javax.servlet.SessionCookieConfig
        public boolean isHttpOnly() {
            return SessionHandler.this._httpOnly;
        }

        @Override // javax.servlet.SessionCookieConfig
        public boolean isSecure() {
            return SessionHandler.this._secureCookies;
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setComment(String comment) {
            if (SessionHandler.this._context == null || !SessionHandler.this._context.getContextHandler().isAvailable()) {
                SessionHandler.this._sessionComment = comment;
                return;
            }
            throw new IllegalStateException("CookieConfig cannot be set after ServletContext is started");
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setDomain(String domain) {
            if (SessionHandler.this._context == null || !SessionHandler.this._context.getContextHandler().isAvailable()) {
                SessionHandler.this._sessionDomain = domain;
                return;
            }
            throw new IllegalStateException("CookieConfig cannot be set after ServletContext is started");
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setHttpOnly(boolean httpOnly) {
            if (SessionHandler.this._context == null || !SessionHandler.this._context.getContextHandler().isAvailable()) {
                SessionHandler.this._httpOnly = httpOnly;
                return;
            }
            throw new IllegalStateException("CookieConfig cannot be set after ServletContext is started");
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setMaxAge(int maxAge) {
            if (SessionHandler.this._context == null || !SessionHandler.this._context.getContextHandler().isAvailable()) {
                SessionHandler.this._maxCookieAge = maxAge;
                return;
            }
            throw new IllegalStateException("CookieConfig cannot be set after ServletContext is started");
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setName(String name) {
            if (SessionHandler.this._context != null && SessionHandler.this._context.getContextHandler().isAvailable()) {
                throw new IllegalStateException("CookieConfig cannot be set after ServletContext is started");
            } else if ("".equals(name)) {
                throw new IllegalArgumentException("Blank cookie name");
            } else {
                if (name != null) {
                    Syntax.requireValidRFC2616Token(name, "Bad Session cookie name");
                }
                SessionHandler.this._sessionCookie = name;
            }
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setPath(String path) {
            if (SessionHandler.this._context == null || !SessionHandler.this._context.getContextHandler().isAvailable()) {
                SessionHandler.this._sessionPath = path;
                return;
            }
            throw new IllegalStateException("CookieConfig cannot be set after ServletContext is started");
        }

        @Override // javax.servlet.SessionCookieConfig
        public void setSecure(boolean secure) {
            if (SessionHandler.this._context == null || !SessionHandler.this._context.getContextHandler().isAvailable()) {
                SessionHandler.this._secureCookies = secure;
                return;
            }
            throw new IllegalStateException("CookieConfig cannot be set after ServletContext is started");
        }
    }

    public void doSessionAttributeListeners(Session session, String name, Object old, Object value) {
        if (!this._sessionAttributeListeners.isEmpty()) {
            HttpSessionBindingEvent event = new HttpSessionBindingEvent(session, name, old == null ? value : old);
            for (HttpSessionAttributeListener l : this._sessionAttributeListeners) {
                if (old == null) {
                    l.attributeAdded(event);
                } else if (value == null) {
                    l.attributeRemoved(event);
                } else {
                    l.attributeReplaced(event);
                }
            }
        }
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler
    public void doScope(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpCookie cookie;
        SessionHandler oldSessionHandler = null;
        HttpSession oldSession = null;
        HttpSession existingSession = null;
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Entering scope {}, dispatch={} asyncstarted={}", this, baseRequest.getDispatcherType(), Boolean.valueOf(baseRequest.isAsyncStarted()));
            }
            switch (baseRequest.getDispatcherType()) {
                case REQUEST:
                    baseRequest.setSession(null);
                    checkRequestedSessionId(baseRequest, request);
                    existingSession = baseRequest.getSession(false);
                    baseRequest.setSessionHandler(this);
                    baseRequest.setSession(existingSession);
                    break;
                case ASYNC:
                case ERROR:
                case FORWARD:
                case INCLUDE:
                    oldSessionHandler = baseRequest.getSessionHandler();
                    oldSession = baseRequest.getSession(false);
                    if (oldSessionHandler != this) {
                        existingSession = baseRequest.getSession(this);
                        if (existingSession == null) {
                            baseRequest.setSession(null);
                            checkRequestedSessionId(baseRequest, request);
                            existingSession = baseRequest.getSession(false);
                        }
                        baseRequest.setSession(existingSession);
                        baseRequest.setSessionHandler(this);
                        break;
                    }
                    break;
            }
            if (!(existingSession == null || oldSessionHandler == this || (cookie = access(existingSession, request.isSecure())) == null || (request.getDispatcherType() != DispatcherType.ASYNC && request.getDispatcherType() != DispatcherType.REQUEST))) {
                baseRequest.getResponse().replaceCookie(cookie);
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("sessionHandler={} session={}", this, existingSession);
            }
            if (this._nextScope != null) {
                this._nextScope.doScope(target, baseRequest, request, response);
            } else if (this._outerScope != null) {
                this._outerScope.doHandle(target, baseRequest, request, response);
            } else {
                doHandle(target, baseRequest, request, response);
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Leaving scope {} dispatch={}, async={}, session={}, oldsession={}, oldsessionhandler={}", this, baseRequest.getDispatcherType(), Boolean.valueOf(baseRequest.isAsyncStarted()), baseRequest.getSession(false), oldSession, oldSessionHandler);
            }
            if (oldSessionHandler != null && oldSessionHandler != this) {
                baseRequest.setSessionHandler(oldSessionHandler);
                baseRequest.setSession(oldSession);
            }
        } catch (Throwable th) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Leaving scope {} dispatch={}, async={}, session={}, oldsession={}, oldsessionhandler={}", this, baseRequest.getDispatcherType(), Boolean.valueOf(baseRequest.isAsyncStarted()), baseRequest.getSession(false), oldSession, oldSessionHandler);
            }
            if (!(oldSessionHandler == null || oldSessionHandler == this)) {
                baseRequest.setSessionHandler(oldSessionHandler);
                baseRequest.setSession(oldSession);
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.server.handler.ScopedHandler
    public void doHandle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        nextHandle(target, baseRequest, request, response);
    }

    protected void checkRequestedSessionId(Request baseRequest, HttpServletRequest request) {
        int s;
        Cookie[] cookies;
        String requestedSessionId = request.getRequestedSessionId();
        if (requestedSessionId != null) {
            HttpSession session = getHttpSession(requestedSessionId);
            if (session != null && isValid(session)) {
                baseRequest.enterSession(session);
                baseRequest.setSession(session);
            }
        } else if (DispatcherType.REQUEST.equals(baseRequest.getDispatcherType())) {
            boolean requestedSessionIdFromCookie = false;
            HttpSession session2 = null;
            if (isUsingCookies() && (cookies = request.getCookies()) != null && cookies.length > 0) {
                String sessionCookie = getSessionCookieName(getSessionCookieConfig());
                for (Cookie cookie : cookies) {
                    if (sessionCookie.equalsIgnoreCase(cookie.getName())) {
                        String id = cookie.getValue();
                        requestedSessionIdFromCookie = true;
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Got Session ID {} from cookie {}", id, sessionCookie);
                        }
                        if (session2 == null) {
                            HttpSession s2 = getHttpSession(id);
                            if (s2 == null || !isValid(s2)) {
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("No session found for session cookie id {}", id);
                                }
                                if (requestedSessionId == null) {
                                    requestedSessionId = id;
                                }
                            } else {
                                requestedSessionId = id;
                                session2 = s2;
                                baseRequest.enterSession(session2);
                                baseRequest.setSession(session2);
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("Selected session {}", session2);
                                }
                            }
                        } else if (!session2.getId().equals(getSessionIdManager().getId(id))) {
                            HttpSession s3 = getHttpSession(id);
                            if (s3 != null && isValid(s3)) {
                                baseRequest.enterSession(s3);
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("Multiple different valid session ids: {}, {}", requestedSessionId, id);
                                }
                                throw new BadMessageException("Duplicate valid session cookies: " + requestedSessionId + " ," + id);
                            }
                        } else if (LOG.isDebugEnabled()) {
                            LOG.debug("Duplicate valid session cookie id: {}", id);
                        }
                    }
                }
            }
            if (isUsingURLs() && requestedSessionId == null) {
                String uri = request.getRequestURI();
                String prefix = getSessionIdPathParameterNamePrefix();
                if (prefix != null && (s = uri.indexOf(prefix)) >= 0) {
                    int s4 = s + prefix.length();
                    int i = s4;
                    while (i < uri.length() && (c = uri.charAt(i)) != ';' && c != '#' && c != '?' && c != '/') {
                        i++;
                    }
                    requestedSessionId = uri.substring(s4, i);
                    requestedSessionIdFromCookie = false;
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Got Session ID {} from URL", requestedSessionId);
                    }
                    HttpSession session3 = getHttpSession(requestedSessionId);
                    if (session3 != null && isValid(session3)) {
                        baseRequest.enterSession(session3);
                        baseRequest.setSession(session3);
                    }
                }
            }
            baseRequest.setRequestedSessionId(requestedSessionId);
            baseRequest.setRequestedSessionIdFromCookie(requestedSessionId != null && requestedSessionIdFromCookie);
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s%d==dftMaxIdleSec=%d", getClass().getName(), Integer.valueOf(hashCode()), Integer.valueOf(this._dftMaxIdleSecs));
    }
}
