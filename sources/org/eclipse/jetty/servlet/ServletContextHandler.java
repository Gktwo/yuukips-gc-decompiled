package org.eclipse.jetty.servlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletSecurityElement;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.descriptor.JspPropertyGroupDescriptor;
import javax.servlet.descriptor.TaglibDescriptor;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;
import org.eclipse.jetty.security.ConstraintAware;
import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.SecurityHandler;
import org.eclipse.jetty.server.Dispatcher;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HandlerContainer;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.util.DecoratedObjectFactory;
import org.eclipse.jetty.util.DeprecationWarning;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject("Servlet Context Handler")
/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletContextHandler.class */
public class ServletContextHandler extends ContextHandler {
    private static final Logger LOG = Log.getLogger(ServletContextHandler.class);
    public static final int SESSIONS = 1;
    public static final int SECURITY = 2;
    public static final int GZIP = 4;
    public static final int NO_SESSIONS = 0;
    public static final int NO_SECURITY = 0;
    protected final DecoratedObjectFactory _objFactory;
    protected Class<? extends SecurityHandler> _defaultSecurityHandlerClass;
    protected SessionHandler _sessionHandler;
    protected SecurityHandler _securityHandler;
    protected ServletHandler _servletHandler;
    protected GzipHandler _gzipHandler;
    protected int _options;
    protected JspConfigDescriptor _jspConfig;
    private boolean _startListeners;

    @Deprecated
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletContextHandler$Decorator.class */
    public interface Decorator extends org.eclipse.jetty.util.Decorator {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletContextHandler$ServletContainerInitializerCaller.class */
    public interface ServletContainerInitializerCaller extends LifeCycle {
    }

    public ServletContextHandler() {
        this(null, null, null, null, null);
    }

    public ServletContextHandler(int options) {
        this(null, null, options);
    }

    public ServletContextHandler(HandlerContainer parent, String contextPath) {
        this(parent, contextPath, null, null, null, null);
    }

    public ServletContextHandler(HandlerContainer parent, String contextPath, int options) {
        this(parent, contextPath, null, null, null, null, options);
    }

    public ServletContextHandler(HandlerContainer parent, String contextPath, boolean sessions, boolean security) {
        this(parent, contextPath, (sessions ? 1 : 0) | (security ? 2 : 0));
    }

    public ServletContextHandler(HandlerContainer parent, SessionHandler sessionHandler, SecurityHandler securityHandler, ServletHandler servletHandler, ErrorHandler errorHandler) {
        this(parent, null, sessionHandler, securityHandler, servletHandler, errorHandler);
    }

    public ServletContextHandler(HandlerContainer parent, String contextPath, SessionHandler sessionHandler, SecurityHandler securityHandler, ServletHandler servletHandler, ErrorHandler errorHandler) {
        this(parent, contextPath, sessionHandler, securityHandler, servletHandler, errorHandler, 0);
    }

    public ServletContextHandler(HandlerContainer parent, String contextPath, SessionHandler sessionHandler, SecurityHandler securityHandler, ServletHandler servletHandler, ErrorHandler errorHandler, int options) {
        super(parent, contextPath);
        this._defaultSecurityHandlerClass = ConstraintSecurityHandler.class;
        this._options = options;
        this._scontext = new Context();
        this._sessionHandler = sessionHandler;
        this._securityHandler = securityHandler;
        this._servletHandler = servletHandler;
        this._objFactory = new DecoratedObjectFactory();
        this._objFactory.addDecorator(new DeprecationWarning());
        relinkHandlers();
        if (errorHandler != null) {
            setErrorHandler(errorHandler);
        }
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler
    public void addEventListener(EventListener listener) {
        addEventListener(listener);
        if (((listener instanceof HttpSessionActivationListener) || (listener instanceof HttpSessionAttributeListener) || (listener instanceof HttpSessionBindingListener) || (listener instanceof HttpSessionListener) || (listener instanceof HttpSessionIdListener)) && this._sessionHandler != null) {
            this._sessionHandler.addEventListener(listener);
        }
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper
    public void setHandler(Handler handler) {
        if (handler instanceof SessionHandler) {
            setSessionHandler((SessionHandler) handler);
        } else if (handler instanceof SecurityHandler) {
            setSecurityHandler((SecurityHandler) handler);
        } else if (handler instanceof ServletHandler) {
            setServletHandler((ServletHandler) handler);
        } else if (handler instanceof GzipHandler) {
            setGzipHandler((GzipHandler) handler);
        } else {
            if (handler != null) {
                LOG.warn("ServletContextHandler.setHandler should not be called directly. Use insertHandler or setSessionHandler etc.", new Object[0]);
            }
            setHandler(handler);
        }
    }

    private void doSetHandler(HandlerWrapper wrapper, Handler handler) {
        if (wrapper == this) {
            setHandler(handler);
        } else {
            wrapper.setHandler(handler);
        }
    }

    private void relinkHandlers() {
        HandlerWrapper handler = this;
        if (getSessionHandler() != null) {
            while (!(handler.getHandler() instanceof SessionHandler) && !(handler.getHandler() instanceof SecurityHandler) && !(handler.getHandler() instanceof GzipHandler) && !(handler.getHandler() instanceof ServletHandler) && (handler.getHandler() instanceof HandlerWrapper)) {
                handler = (HandlerWrapper) handler.getHandler();
            }
            if (handler.getHandler() != this._sessionHandler) {
                doSetHandler(handler, this._sessionHandler);
            }
            handler = this._sessionHandler;
        }
        if (getSecurityHandler() != null) {
            while (!(handler.getHandler() instanceof SecurityHandler) && !(handler.getHandler() instanceof GzipHandler) && !(handler.getHandler() instanceof ServletHandler) && (handler.getHandler() instanceof HandlerWrapper)) {
                handler = (HandlerWrapper) handler.getHandler();
            }
            if (handler.getHandler() != this._securityHandler) {
                doSetHandler(handler, this._securityHandler);
            }
            handler = this._securityHandler;
        }
        if (getGzipHandler() != null) {
            while (!(handler.getHandler() instanceof GzipHandler) && !(handler.getHandler() instanceof ServletHandler) && (handler.getHandler() instanceof HandlerWrapper)) {
                handler = (HandlerWrapper) handler.getHandler();
            }
            if (handler.getHandler() != this._gzipHandler) {
                doSetHandler(handler, this._gzipHandler);
            }
            handler = this._gzipHandler;
        }
        if (getServletHandler() != null) {
            while (!(handler.getHandler() instanceof ServletHandler) && (handler.getHandler() instanceof HandlerWrapper)) {
                handler = (HandlerWrapper) handler.getHandler();
            }
            if (handler.getHandler() != this._servletHandler) {
                doSetHandler(handler, this._servletHandler);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.ContextHandler, org.eclipse.jetty.server.handler.ScopedHandler, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        getServletContext().setAttribute(DecoratedObjectFactory.ATTR, this._objFactory);
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.ContextHandler, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
        this._objFactory.clear();
        getServletContext().removeAttribute(DecoratedObjectFactory.ATTR);
    }

    public Class<? extends SecurityHandler> getDefaultSecurityHandlerClass() {
        return this._defaultSecurityHandlerClass;
    }

    public void setDefaultSecurityHandlerClass(Class<? extends SecurityHandler> defaultSecurityHandlerClass) {
        this._defaultSecurityHandlerClass = defaultSecurityHandlerClass;
    }

    protected SessionHandler newSessionHandler() {
        return new SessionHandler();
    }

    protected SecurityHandler newSecurityHandler() {
        try {
            return (SecurityHandler) getDefaultSecurityHandlerClass().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    protected ServletHandler newServletHandler() {
        return new ServletHandler();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.ContextHandler
    public void startContext() throws Exception {
        for (ServletContainerInitializerCaller sci : getBeans(ServletContainerInitializerCaller.class)) {
            if (sci.isStopped()) {
                sci.start();
                if (isAuto(sci)) {
                    manage(sci);
                }
            }
        }
        if (!(this._servletHandler == null || this._servletHandler.getListeners() == null)) {
            for (ListenerHolder holder : this._servletHandler.getListeners()) {
                holder.start();
            }
        }
        this._startListeners = true;
        startContext();
        if (this._servletHandler != null) {
            this._servletHandler.initialize();
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.ContextHandler
    public void stopContext() throws Exception {
        this._startListeners = false;
        stopContext();
    }

    @ManagedAttribute(value = "context security handler", readonly = true)
    public SecurityHandler getSecurityHandler() {
        if (this._securityHandler == null && (this._options & 2) != 0 && !isStarted()) {
            this._securityHandler = newSecurityHandler();
        }
        return this._securityHandler;
    }

    @ManagedAttribute(value = "context servlet handler", readonly = true)
    public ServletHandler getServletHandler() {
        if (this._servletHandler == null && !isStarted()) {
            this._servletHandler = newServletHandler();
        }
        return this._servletHandler;
    }

    @ManagedAttribute(value = "context session handler", readonly = true)
    public SessionHandler getSessionHandler() {
        if (this._sessionHandler == null && (this._options & 1) != 0 && !isStarted()) {
            this._sessionHandler = newSessionHandler();
        }
        return this._sessionHandler;
    }

    @ManagedAttribute(value = "context gzip handler", readonly = true)
    public GzipHandler getGzipHandler() {
        if (this._gzipHandler == null && (this._options & 4) != 0 && !isStarted()) {
            this._gzipHandler = new GzipHandler();
        }
        return this._gzipHandler;
    }

    public ServletHolder addServlet(String className, String pathSpec) {
        return getServletHandler().addServletWithMapping(className, pathSpec);
    }

    public ServletHolder addServlet(Class<? extends Servlet> servlet, String pathSpec) {
        return getServletHandler().addServletWithMapping(servlet, pathSpec);
    }

    public void addServlet(ServletHolder servlet, String pathSpec) {
        getServletHandler().addServletWithMapping(servlet, pathSpec);
    }

    public void addFilter(FilterHolder holder, String pathSpec, EnumSet<DispatcherType> dispatches) {
        getServletHandler().addFilterWithMapping(holder, pathSpec, dispatches);
    }

    public FilterHolder addFilter(Class<? extends Filter> filterClass, String pathSpec, EnumSet<DispatcherType> dispatches) {
        return getServletHandler().addFilterWithMapping(filterClass, pathSpec, dispatches);
    }

    public FilterHolder addFilter(String filterClass, String pathSpec, EnumSet<DispatcherType> dispatches) {
        return getServletHandler().addFilterWithMapping(filterClass, pathSpec, dispatches);
    }

    protected ServletRegistration.Dynamic dynamicHolderAdded(ServletHolder holder) {
        return holder.getRegistration();
    }

    protected void addRoles(String... roleNames) {
        if (this._securityHandler != null && (this._securityHandler instanceof ConstraintAware)) {
            HashSet<String> union = new HashSet<>();
            Set<String> existing = ((ConstraintAware) this._securityHandler).getRoles();
            if (existing != null) {
                union.addAll(existing);
            }
            union.addAll(Arrays.asList(roleNames));
            ((ConstraintSecurityHandler) this._securityHandler).setRoles(union);
        }
    }

    public Set<String> setServletSecurity(ServletRegistration.Dynamic registration, ServletSecurityElement servletSecurityElement) {
        Collection<String> pathSpecs = registration.getMappings();
        if (pathSpecs != null) {
            for (String pathSpec : pathSpecs) {
                for (ConstraintMapping m : ConstraintSecurityHandler.createConstraintsWithMappingsForPath(registration.getName(), pathSpec, servletSecurityElement)) {
                    ((ConstraintAware) getSecurityHandler()).addConstraintMapping(m);
                }
            }
        }
        return Collections.emptySet();
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler
    public void callContextInitialized(ServletContextListener l, ServletContextEvent e) {
        try {
            if (isProgrammaticListener(l)) {
                getServletContext().setEnabled(false);
            }
            callContextInitialized(l, e);
        } finally {
            getServletContext().setEnabled(true);
        }
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler
    public void callContextDestroyed(ServletContextListener l, ServletContextEvent e) {
        callContextDestroyed(l, e);
    }

    private void replaceHandler(HandlerWrapper handler, HandlerWrapper replacement) {
        if (isStarted()) {
            throw new IllegalStateException(AbstractLifeCycle.STARTED);
        }
        Handler next = null;
        if (handler != null) {
            next = handler.getHandler();
            handler.setHandler(null);
            HandlerWrapper wrapper = this;
            while (true) {
                if (wrapper == null) {
                    break;
                } else if (wrapper.getHandler() == handler) {
                    doSetHandler(wrapper, replacement);
                    break;
                } else {
                    wrapper = wrapper.getHandler() instanceof HandlerWrapper ? (HandlerWrapper) wrapper.getHandler() : null;
                }
            }
        }
        if (next != null && replacement.getHandler() == null) {
            replacement.setHandler(next);
        }
    }

    public void setSessionHandler(SessionHandler sessionHandler) {
        replaceHandler(this._sessionHandler, sessionHandler);
        this._sessionHandler = sessionHandler;
        relinkHandlers();
    }

    public void setSecurityHandler(SecurityHandler securityHandler) {
        replaceHandler(this._securityHandler, securityHandler);
        this._securityHandler = securityHandler;
        relinkHandlers();
    }

    public void setGzipHandler(GzipHandler gzipHandler) {
        replaceHandler(this._gzipHandler, gzipHandler);
        this._gzipHandler = gzipHandler;
        relinkHandlers();
    }

    public void setServletHandler(ServletHandler servletHandler) {
        replaceHandler(this._servletHandler, servletHandler);
        this._servletHandler = servletHandler;
        relinkHandlers();
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper
    public void insertHandler(HandlerWrapper handler) {
        if (handler instanceof SessionHandler) {
            setSessionHandler((SessionHandler) handler);
        } else if (handler instanceof SecurityHandler) {
            setSecurityHandler((SecurityHandler) handler);
        } else if (handler instanceof GzipHandler) {
            setGzipHandler((GzipHandler) handler);
        } else if (handler instanceof ServletHandler) {
            setServletHandler((ServletHandler) handler);
        } else {
            HandlerWrapper tail = handler;
            while (tail.getHandler() instanceof HandlerWrapper) {
                tail = (HandlerWrapper) tail.getHandler();
            }
            if (tail.getHandler() != null) {
                throw new IllegalArgumentException("bad tail of inserted wrapper chain");
            }
            HandlerWrapper h = this;
            while (h.getHandler() instanceof HandlerWrapper) {
                HandlerWrapper wrapper = (HandlerWrapper) h.getHandler();
                if ((wrapper instanceof SessionHandler) || (wrapper instanceof SecurityHandler) || (wrapper instanceof ServletHandler)) {
                    break;
                }
                h = wrapper;
            }
            Handler next = h.getHandler();
            doSetHandler(h, handler);
            doSetHandler(tail, next);
        }
        relinkHandlers();
    }

    public DecoratedObjectFactory getObjectFactory() {
        return this._objFactory;
    }

    @Deprecated
    public List<Decorator> getDecorators() {
        List<Decorator> ret = new ArrayList<>();
        Iterator<org.eclipse.jetty.util.Decorator> it = this._objFactory.iterator();
        while (it.hasNext()) {
            ret.add(new LegacyDecorator(it.next()));
        }
        return Collections.unmodifiableList(ret);
    }

    @Deprecated
    public void setDecorators(List<Decorator> decorators) {
        this._objFactory.setDecorators(decorators);
    }

    @Deprecated
    public void addDecorator(Decorator decorator) {
        this._objFactory.addDecorator(decorator);
    }

    /* access modifiers changed from: package-private */
    public void destroyServlet(Servlet servlet) {
        this._objFactory.destroy(servlet);
    }

    /* access modifiers changed from: package-private */
    public void destroyFilter(Filter filter) {
        this._objFactory.destroy(filter);
    }

    /* access modifiers changed from: package-private */
    public void destroyListener(EventListener listener) {
        this._objFactory.destroy(listener);
    }

    public static ServletContextHandler getServletContextHandler(ServletContext context) {
        ContextHandler handler = getContextHandler(context);
        if (handler != null && (handler instanceof ServletContextHandler)) {
            return (ServletContextHandler) handler;
        }
        return null;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletContextHandler$JspPropertyGroup.class */
    public static class JspPropertyGroup implements JspPropertyGroupDescriptor {
        private String _elIgnored;
        private String _pageEncoding;
        private String _scriptingInvalid;
        private String _isXml;
        private String _deferredSyntaxAllowedAsLiteral;
        private String _trimDirectiveWhitespaces;
        private String _defaultContentType;
        private String _buffer;
        private String _errorOnUndeclaredNamespace;
        private final List<String> _urlPatterns = new ArrayList();
        private final List<String> _includePreludes = new ArrayList();
        private final List<String> _includeCodas = new ArrayList();

        @Override // javax.servlet.descriptor.JspPropertyGroupDescriptor
        public Collection<String> getUrlPatterns() {
            return new ArrayList(this._urlPatterns);
        }

        public void addUrlPattern(String s) {
            if (!this._urlPatterns.contains(s)) {
                this._urlPatterns.add(s);
            }
        }

        @Override // javax.servlet.descriptor.JspPropertyGroupDescriptor
        public String getElIgnored() {
            return this._elIgnored;
        }

        public void setElIgnored(String s) {
            this._elIgnored = s;
        }

        @Override // javax.servlet.descriptor.JspPropertyGroupDescriptor
        public String getPageEncoding() {
            return this._pageEncoding;
        }

        public void setPageEncoding(String pageEncoding) {
            this._pageEncoding = pageEncoding;
        }

        public void setScriptingInvalid(String scriptingInvalid) {
            this._scriptingInvalid = scriptingInvalid;
        }

        public void setIsXml(String isXml) {
            this._isXml = isXml;
        }

        public void setDeferredSyntaxAllowedAsLiteral(String deferredSyntaxAllowedAsLiteral) {
            this._deferredSyntaxAllowedAsLiteral = deferredSyntaxAllowedAsLiteral;
        }

        public void setTrimDirectiveWhitespaces(String trimDirectiveWhitespaces) {
            this._trimDirectiveWhitespaces = trimDirectiveWhitespaces;
        }

        public void setDefaultContentType(String defaultContentType) {
            this._defaultContentType = defaultContentType;
        }

        public void setBuffer(String buffer) {
            this._buffer = buffer;
        }

        public void setErrorOnUndeclaredNamespace(String errorOnUndeclaredNamespace) {
            this._errorOnUndeclaredNamespace = errorOnUndeclaredNamespace;
        }

        @Override // javax.servlet.descriptor.JspPropertyGroupDescriptor
        public String getScriptingInvalid() {
            return this._scriptingInvalid;
        }

        @Override // javax.servlet.descriptor.JspPropertyGroupDescriptor
        public String getIsXml() {
            return this._isXml;
        }

        @Override // javax.servlet.descriptor.JspPropertyGroupDescriptor
        public Collection<String> getIncludePreludes() {
            return new ArrayList(this._includePreludes);
        }

        public void addIncludePrelude(String prelude) {
            if (!this._includePreludes.contains(prelude)) {
                this._includePreludes.add(prelude);
            }
        }

        @Override // javax.servlet.descriptor.JspPropertyGroupDescriptor
        public Collection<String> getIncludeCodas() {
            return new ArrayList(this._includeCodas);
        }

        public void addIncludeCoda(String coda) {
            if (!this._includeCodas.contains(coda)) {
                this._includeCodas.add(coda);
            }
        }

        @Override // javax.servlet.descriptor.JspPropertyGroupDescriptor
        public String getDeferredSyntaxAllowedAsLiteral() {
            return this._deferredSyntaxAllowedAsLiteral;
        }

        @Override // javax.servlet.descriptor.JspPropertyGroupDescriptor
        public String getTrimDirectiveWhitespaces() {
            return this._trimDirectiveWhitespaces;
        }

        @Override // javax.servlet.descriptor.JspPropertyGroupDescriptor
        public String getDefaultContentType() {
            return this._defaultContentType;
        }

        @Override // javax.servlet.descriptor.JspPropertyGroupDescriptor
        public String getBuffer() {
            return this._buffer;
        }

        @Override // javax.servlet.descriptor.JspPropertyGroupDescriptor
        public String getErrorOnUndeclaredNamespace() {
            return this._errorOnUndeclaredNamespace;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("JspPropertyGroupDescriptor:");
            sb.append(" el-ignored=").append(this._elIgnored);
            sb.append(" is-xml=").append(this._isXml);
            sb.append(" page-encoding=").append(this._pageEncoding);
            sb.append(" scripting-invalid=").append(this._scriptingInvalid);
            sb.append(" deferred-syntax-allowed-as-literal=").append(this._deferredSyntaxAllowedAsLiteral);
            sb.append(" trim-directive-whitespaces").append(this._trimDirectiveWhitespaces);
            sb.append(" default-content-type=").append(this._defaultContentType);
            sb.append(" buffer=").append(this._buffer);
            sb.append(" error-on-undeclared-namespace=").append(this._errorOnUndeclaredNamespace);
            for (String prelude : this._includePreludes) {
                sb.append(" include-prelude=").append(prelude);
            }
            for (String coda : this._includeCodas) {
                sb.append(" include-coda=").append(coda);
            }
            return sb.toString();
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletContextHandler$TagLib.class */
    public static class TagLib implements TaglibDescriptor {
        private String _uri;
        private String _location;

        @Override // javax.servlet.descriptor.TaglibDescriptor
        public String getTaglibURI() {
            return this._uri;
        }

        public void setTaglibURI(String uri) {
            this._uri = uri;
        }

        @Override // javax.servlet.descriptor.TaglibDescriptor
        public String getTaglibLocation() {
            return this._location;
        }

        public void setTaglibLocation(String location) {
            this._location = location;
        }

        public String toString() {
            return "TagLibDescriptor: taglib-uri=" + this._uri + " location=" + this._location;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletContextHandler$JspConfig.class */
    public static class JspConfig implements JspConfigDescriptor {
        private final List<TaglibDescriptor> _taglibs = new ArrayList();
        private final List<JspPropertyGroupDescriptor> _jspPropertyGroups = new ArrayList();

        @Override // javax.servlet.descriptor.JspConfigDescriptor
        public Collection<TaglibDescriptor> getTaglibs() {
            return new ArrayList(this._taglibs);
        }

        public void addTaglibDescriptor(TaglibDescriptor d) {
            this._taglibs.add(d);
        }

        @Override // javax.servlet.descriptor.JspConfigDescriptor
        public Collection<JspPropertyGroupDescriptor> getJspPropertyGroups() {
            return new ArrayList(this._jspPropertyGroups);
        }

        public void addJspPropertyGroup(JspPropertyGroupDescriptor g) {
            this._jspPropertyGroups.add(g);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("JspConfigDescriptor: \n");
            for (TaglibDescriptor taglib : this._taglibs) {
                sb.append(taglib).append("\n");
            }
            for (JspPropertyGroupDescriptor jpg : this._jspPropertyGroups) {
                sb.append(jpg).append("\n");
            }
            return sb.toString();
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletContextHandler$Context.class */
    public class Context extends ContextHandler.Context {
        public Context() {
            super();
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public RequestDispatcher getNamedDispatcher(String name) {
            ServletHolder holder;
            ContextHandler context = ServletContextHandler.this;
            if (ServletContextHandler.this._servletHandler == null || (holder = ServletContextHandler.this._servletHandler.getServlet(name)) == null || !holder.isEnabled()) {
                return null;
            }
            return new Dispatcher(context, name);
        }

        private void checkDynamic(String name) {
            if (ServletContextHandler.this.isStarted()) {
                throw new IllegalStateException();
            } else if (ServletContextHandler.this.getServletHandler().isInitialized()) {
                throw new IllegalStateException();
            } else if (StringUtil.isBlank(name)) {
                throw new IllegalStateException("Missing name");
            } else if (!this._enabled) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public FilterRegistration.Dynamic addFilter(String filterName, Class<? extends Filter> filterClass) {
            checkDynamic(filterName);
            ServletHandler handler = ServletContextHandler.this.getServletHandler();
            FilterHolder holder = handler.getFilter(filterName);
            if (holder == null) {
                FilterHolder holder2 = handler.newFilterHolder(Source.JAVAX_API);
                holder2.setName(filterName);
                holder2.setHeldClass(filterClass);
                handler.addFilter(holder2);
                return holder2.getRegistration();
            } else if (holder.getClassName() != null || holder.getHeldClass() != null) {
                return null;
            } else {
                holder.setHeldClass(filterClass);
                return holder.getRegistration();
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public FilterRegistration.Dynamic addFilter(String filterName, String className) {
            checkDynamic(filterName);
            ServletHandler handler = ServletContextHandler.this.getServletHandler();
            FilterHolder holder = handler.getFilter(filterName);
            if (holder == null) {
                FilterHolder holder2 = handler.newFilterHolder(Source.JAVAX_API);
                holder2.setName(filterName);
                holder2.setClassName(className);
                handler.addFilter(holder2);
                return holder2.getRegistration();
            } else if (holder.getClassName() != null || holder.getHeldClass() != null) {
                return null;
            } else {
                holder.setClassName(className);
                return holder.getRegistration();
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public FilterRegistration.Dynamic addFilter(String filterName, Filter filter) {
            checkDynamic(filterName);
            ServletHandler handler = ServletContextHandler.this.getServletHandler();
            FilterHolder holder = handler.getFilter(filterName);
            if (holder == null) {
                FilterHolder holder2 = handler.newFilterHolder(Source.JAVAX_API);
                holder2.setName(filterName);
                holder2.setFilter(filter);
                handler.addFilter(holder2);
                return holder2.getRegistration();
            } else if (holder.getClassName() != null || holder.getHeldClass() != null) {
                return null;
            } else {
                holder.setFilter(filter);
                return holder.getRegistration();
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public ServletRegistration.Dynamic addServlet(String servletName, Class<? extends Servlet> servletClass) {
            checkDynamic(servletName);
            ServletHandler handler = ServletContextHandler.this.getServletHandler();
            ServletHolder holder = handler.getServlet(servletName);
            if (holder == null) {
                ServletHolder holder2 = handler.newServletHolder(Source.JAVAX_API);
                holder2.setName(servletName);
                holder2.setHeldClass(servletClass);
                handler.addServlet(holder2);
                return ServletContextHandler.this.dynamicHolderAdded(holder2);
            } else if (holder.getClassName() != null || holder.getHeldClass() != null) {
                return null;
            } else {
                holder.setHeldClass(servletClass);
                return holder.getRegistration();
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public ServletRegistration.Dynamic addServlet(String servletName, String className) {
            checkDynamic(servletName);
            ServletHandler handler = ServletContextHandler.this.getServletHandler();
            ServletHolder holder = handler.getServlet(servletName);
            if (holder == null) {
                ServletHolder holder2 = handler.newServletHolder(Source.JAVAX_API);
                holder2.setName(servletName);
                holder2.setClassName(className);
                handler.addServlet(holder2);
                return ServletContextHandler.this.dynamicHolderAdded(holder2);
            } else if (holder.getClassName() != null || holder.getHeldClass() != null) {
                return null;
            } else {
                holder.setClassName(className);
                return holder.getRegistration();
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public ServletRegistration.Dynamic addServlet(String servletName, Servlet servlet) {
            checkDynamic(servletName);
            ServletHandler handler = ServletContextHandler.this.getServletHandler();
            ServletHolder holder = handler.getServlet(servletName);
            if (holder == null) {
                ServletHolder holder2 = handler.newServletHolder(Source.JAVAX_API);
                holder2.setName(servletName);
                holder2.setServlet(servlet);
                handler.addServlet(holder2);
                return ServletContextHandler.this.dynamicHolderAdded(holder2);
            } else if (holder.getClassName() != null || holder.getHeldClass() != null) {
                return null;
            } else {
                holder.setServlet(servlet);
                return holder.getRegistration();
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.Context, org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public boolean setInitParameter(String name, String value) {
            if (!ServletContextHandler.this.isStarting()) {
                throw new IllegalStateException();
            } else if (this._enabled) {
                return setInitParameter(name, value);
            } else {
                throw new UnsupportedOperationException();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: org.eclipse.jetty.util.DecoratedObjectFactory */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext
        protected <T> T createInstance(Class<T> clazz) throws ServletException {
            return (T) ServletContextHandler.this._objFactory.decorate(createInstance(clazz));
        }

        public <T extends Filter> void destroyFilter(T f) {
            ServletContextHandler.this._objFactory.destroy(f);
        }

        public <T extends Servlet> void destroyServlet(T s) {
            ServletContextHandler.this._objFactory.destroy(s);
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
            if (ServletContextHandler.this._sessionHandler != null) {
                return ServletContextHandler.this._sessionHandler.getDefaultSessionTrackingModes();
            }
            return null;
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
            if (ServletContextHandler.this._sessionHandler != null) {
                return ServletContextHandler.this._sessionHandler.getEffectiveSessionTrackingModes();
            }
            return null;
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public FilterRegistration getFilterRegistration(String filterName) {
            if (!this._enabled) {
                throw new UnsupportedOperationException();
            }
            FilterHolder holder = ServletContextHandler.this.getServletHandler().getFilter(filterName);
            if (holder == null) {
                return null;
            }
            return holder.getRegistration();
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public Map<String, ? extends FilterRegistration> getFilterRegistrations() {
            if (!this._enabled) {
                throw new UnsupportedOperationException();
            }
            HashMap<String, FilterRegistration> registrations = new HashMap<>();
            FilterHolder[] holders = ServletContextHandler.this.getServletHandler().getFilters();
            if (holders != null) {
                for (FilterHolder holder : holders) {
                    registrations.put(holder.getName(), holder.getRegistration());
                }
            }
            return registrations;
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public ServletRegistration getServletRegistration(String servletName) {
            if (!this._enabled) {
                throw new UnsupportedOperationException();
            }
            ServletHolder holder = ServletContextHandler.this.getServletHandler().getServlet(servletName);
            if (holder == null) {
                return null;
            }
            return holder.getRegistration();
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public Map<String, ? extends ServletRegistration> getServletRegistrations() {
            if (!this._enabled) {
                throw new UnsupportedOperationException();
            }
            HashMap<String, ServletRegistration> registrations = new HashMap<>();
            ServletHolder[] holders = ServletContextHandler.this.getServletHandler().getServlets();
            if (holders != null) {
                for (ServletHolder holder : holders) {
                    registrations.put(holder.getName(), holder.getRegistration());
                }
            }
            return registrations;
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public SessionCookieConfig getSessionCookieConfig() {
            if (!this._enabled) {
                throw new UnsupportedOperationException();
            } else if (ServletContextHandler.this._sessionHandler != null) {
                return ServletContextHandler.this._sessionHandler.getSessionCookieConfig();
            } else {
                return null;
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public void setSessionTrackingModes(Set<SessionTrackingMode> sessionTrackingModes) {
            if (!ServletContextHandler.this.isStarting()) {
                throw new IllegalStateException();
            } else if (!this._enabled) {
                throw new UnsupportedOperationException();
            } else if (ServletContextHandler.this._sessionHandler != null) {
                ServletContextHandler.this._sessionHandler.setSessionTrackingModes(sessionTrackingModes);
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.Context, org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public void addListener(String className) {
            if (!ServletContextHandler.this.isStarting()) {
                throw new IllegalStateException();
            } else if (!this._enabled) {
                throw new UnsupportedOperationException();
            } else {
                addListener(className);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: org.eclipse.jetty.servlet.ServletContextHandler$Context */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.eclipse.jetty.server.handler.ContextHandler.Context, org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public <T extends EventListener> void addListener(T t) {
            if (!ServletContextHandler.this.isStarting()) {
                throw new IllegalStateException();
            } else if (!this._enabled) {
                throw new UnsupportedOperationException();
            } else {
                checkListener(t.getClass());
                ListenerHolder holder = ServletContextHandler.this.getServletHandler().newListenerHolder(Source.JAVAX_API);
                holder.setListener(t);
                ServletContextHandler.this.addProgrammaticListener(t);
                ServletContextHandler.this.getServletHandler().addListener(holder);
                if (ServletContextHandler.this._startListeners) {
                    try {
                        holder.start();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.Context, org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public void addListener(Class<? extends EventListener> listenerClass) {
            if (!ServletContextHandler.this.isStarting()) {
                throw new IllegalStateException();
            } else if (!this._enabled) {
                throw new UnsupportedOperationException();
            } else {
                addListener(listenerClass);
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.Context, org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public JspConfigDescriptor getJspConfigDescriptor() {
            return ServletContextHandler.this._jspConfig;
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.Context
        public void setJspConfigDescriptor(JspConfigDescriptor d) {
            ServletContextHandler.this._jspConfig = d;
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.Context, org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public void declareRoles(String... roleNames) {
            if (!ServletContextHandler.this.isStarting()) {
                throw new IllegalStateException();
            } else if (!this._enabled) {
                throw new UnsupportedOperationException();
            } else {
                ServletContextHandler.this.addRoles(roleNames);
            }
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletContextHandler$LegacyDecorator.class */
    private static class LegacyDecorator implements Decorator {
        private final org.eclipse.jetty.util.Decorator decorator;

        public LegacyDecorator(org.eclipse.jetty.util.Decorator decorator) {
            this.decorator = decorator;
        }

        @Override // org.eclipse.jetty.util.Decorator
        public <T> T decorate(T o) {
            return (T) this.decorator.decorate(o);
        }

        @Override // org.eclipse.jetty.util.Decorator
        public void destroy(Object o) {
            this.decorator.destroy(o);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletContextHandler$Initializer.class */
    public static class Initializer extends AbstractLifeCycle implements ServletContainerInitializerCaller {
        private final ServletContextHandler _context;
        private final ServletContainerInitializer _sci;
        private final Set<Class<?>> _classes;

        public Initializer(ServletContextHandler context, ServletContainerInitializer sci, Set<Class<?>> classes) {
            this._context = context;
            this._sci = sci;
            this._classes = classes;
        }

        public Initializer(ServletContextHandler context, ServletContainerInitializer sci) {
            this(context, sci, Collections.emptySet());
        }

        @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
        protected void doStart() throws Exception {
            boolean oldExtended = this._context.getServletContext().isExtendedListenerTypes();
            try {
                this._context.getServletContext().setExtendedListenerTypes(true);
                this._sci.onStartup(this._classes, this._context.getServletContext());
            } finally {
                this._context.getServletContext().setExtendedListenerTypes(oldExtended);
            }
        }
    }
}
