package org.eclipse.jetty.servlet;

import dev.morphia.mapping.Mapper;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.GenericServlet;
import javax.servlet.MultipartConfigElement;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletSecurityElement;
import javax.servlet.SingleThreadModel;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.security.IdentityService;
import org.eclipse.jetty.security.RunAsToken;
import org.eclipse.jetty.server.MultiPartCleanerListener;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.BaseHolder;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject("Servlet Holder")
/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHolder.class */
public class ServletHolder extends Holder<Servlet> implements UserIdentity.Scope, Comparable<ServletHolder> {
    private static final Logger LOG = Log.getLogger(ServletHolder.class);
    private int _initOrder;
    private boolean _initOnStartup;
    private Map<String, String> _roleMap;
    private String _forcedPath;
    private String _runAsRole;
    private ServletRegistration.Dynamic _registration;
    private JspContainer _jspContainer;
    private volatile Servlet _servlet;
    private Config _config;
    private boolean _enabled;
    public static final String APACHE_SENTINEL_CLASS = "org.apache.tomcat.InstanceManager";
    public static final String JSP_GENERATED_PACKAGE_NAME = "org.eclipse.jetty.servlet.jspPackagePrefix";

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHolder$JspContainer.class */
    public enum JspContainer {
        APACHE,
        OTHER
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHolder$WrapFunction.class */
    public interface WrapFunction {
        Servlet wrapServlet(Servlet servlet);
    }

    public ServletHolder() {
        this(Source.EMBEDDED);
    }

    public ServletHolder(Source creator) {
        super(creator);
        this._initOrder = -1;
        this._initOnStartup = false;
        this._enabled = true;
    }

    public ServletHolder(Servlet servlet) {
        this(Source.EMBEDDED);
        setServlet(servlet);
    }

    public ServletHolder(String name, Class<? extends Servlet> servlet) {
        this(Source.EMBEDDED);
        setName(name);
        setHeldClass(servlet);
    }

    public ServletHolder(String name, Servlet servlet) {
        this(Source.EMBEDDED);
        setName(name);
        setServlet(servlet);
    }

    public ServletHolder(Class<? extends Servlet> servlet) {
        this(Source.EMBEDDED);
        setHeldClass(servlet);
    }

    public UnavailableException getUnavailableException() {
        Servlet servlet = this._servlet;
        if (servlet instanceof UnavailableServlet) {
            return ((UnavailableServlet) servlet).getUnavailableException();
        }
        return null;
    }

    public synchronized void setServlet(Servlet servlet) {
        if (servlet == null || (servlet instanceof SingleThreadModel)) {
            throw new IllegalArgumentException();
        }
        setInstance(servlet);
    }

    @ManagedAttribute(value = "initialization order", readonly = true)
    public int getInitOrder() {
        return this._initOrder;
    }

    public void setInitOrder(int order) {
        this._initOnStartup = order >= 0;
        this._initOrder = order;
    }

    public int compareTo(ServletHolder sh) {
        int c;
        if (sh == this) {
            return 0;
        }
        if (sh._initOrder < this._initOrder) {
            return 1;
        }
        if (sh._initOrder > this._initOrder) {
            return -1;
        }
        if (getClassName() == null && sh.getClassName() == null) {
            c = 0;
        } else if (getClassName() == null) {
            c = -1;
        } else if (sh.getClassName() == null) {
            c = 1;
        } else {
            c = getClassName().compareTo(sh.getClassName());
        }
        if (c == 0) {
            c = getName().compareTo(sh.getName());
        }
        return c;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        return (o instanceof ServletHolder) && compareTo((ServletHolder) o) == 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getName() == null ? System.identityHashCode(this) : getName().hashCode();
    }

    public synchronized void setUserRoleLink(String name, String link) {
        if (this._roleMap == null) {
            this._roleMap = new HashMap();
        }
        this._roleMap.put(name, link);
    }

    public String getUserRoleLink(String name) {
        if (this._roleMap == null) {
            return name;
        }
        String link = this._roleMap.get(name);
        return link == null ? name : link;
    }

    @ManagedAttribute(value = "forced servlet path", readonly = true)
    public String getForcedPath() {
        return this._forcedPath;
    }

    public void setForcedPath(String forcedPath) {
        this._forcedPath = forcedPath;
    }

    private void setClassFrom(ServletHolder holder) throws ServletException {
        if (this._servlet == null && getInstance() == null) {
            setClassName(holder.getClassName());
            setHeldClass(holder.getHeldClass());
            return;
        }
        throw new IllegalStateException();
    }

    public boolean isEnabled() {
        return this._enabled;
    }

    public void setEnabled(boolean enabled) {
        this._enabled = enabled;
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._enabled) {
            if (this._forcedPath != null) {
                String precompiled = getClassNameForJsp(this._forcedPath);
                if (!StringUtil.isBlank(precompiled)) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Checking for precompiled servlet {} for jsp {}", precompiled, this._forcedPath);
                    }
                    ServletHolder jsp = getServletHandler().getServlet(precompiled);
                    if (jsp == null || jsp.getClassName() == null) {
                        ServletHolder jsp2 = getServletHandler().getServlet("jsp");
                        if (jsp2 != null) {
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("JSP file {} for {} mapped to JspServlet class {}", this._forcedPath, getName(), jsp2.getClassName());
                            }
                            setClassFrom(jsp2);
                            for (Map.Entry<String, String> entry : jsp2.getInitParameters().entrySet()) {
                                if (!getInitParameters().containsKey(entry.getKey())) {
                                    setInitParameter(entry.getKey(), entry.getValue());
                                }
                            }
                            setInitParameter("jspFile", this._forcedPath);
                        }
                    } else {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("JSP file {} for {} mapped to Servlet {}", this._forcedPath, getName(), jsp.getClassName());
                        }
                        setClassFrom(jsp);
                    }
                } else {
                    LOG.warn("Bad jsp-file {} conversion to classname in holder {}", this._forcedPath, getName());
                }
            }
            try {
                doStart();
                try {
                    checkServletType();
                    checkInitOnStartup();
                    this._config = new Config();
                } catch (UnavailableException ex) {
                    makeUnavailable(ex);
                    if (getServletHandler().isStartWithUnavailable()) {
                        LOG.ignore(ex);
                        return;
                    }
                    throw ex;
                }
            } catch (UnavailableException ex2) {
                makeUnavailable(ex2);
                if (getServletHandler().isStartWithUnavailable()) {
                    LOG.ignore(ex2);
                    return;
                }
                throw ex2;
            }
        }
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder
    public void initialize() throws Exception {
        synchronized (this) {
            if (this._servlet == null && (this._initOnStartup || isInstance())) {
                initialize();
                initServlet();
            }
        }
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        synchronized (this) {
            Servlet servlet = this._servlet;
            if (servlet != null) {
                this._servlet = null;
                try {
                    destroyInstance(servlet);
                } catch (Exception e) {
                    LOG.warn(e);
                }
            }
            this._config = null;
        }
    }

    @Override // org.eclipse.jetty.servlet.Holder
    public void destroyInstance(Object o) {
        if (o != null) {
            Servlet servlet = (Servlet) o;
            predestroyServlet(servlet);
            servlet.destroy();
        }
    }

    private void predestroyServlet(Servlet servlet) {
        getServletHandler().destroyServlet(unwrap(servlet));
    }

    public Servlet getServlet() throws ServletException {
        Servlet servlet = this._servlet;
        if (servlet == null) {
            synchronized (this) {
                if (this._servlet == null && isRunning() && getHeldClass() != null) {
                    initServlet();
                }
                servlet = this._servlet;
            }
        }
        return servlet;
    }

    public Servlet getServletInstance() {
        return this._servlet;
    }

    public void checkServletType() throws UnavailableException {
        if (getHeldClass() == null || !Servlet.class.isAssignableFrom(getHeldClass())) {
            throw new UnavailableException("Servlet " + getHeldClass() + " is not a javax.servlet.Servlet");
        }
    }

    public boolean isAvailable() {
        return isStarted() && !(this._servlet instanceof UnavailableServlet);
    }

    private void checkInitOnStartup() {
        if (getHeldClass() != null && getHeldClass().getAnnotation(ServletSecurity.class) != null && !this._initOnStartup) {
            setInitOrder(Integer.MAX_VALUE);
        }
    }

    private Servlet makeUnavailable(UnavailableException e) {
        Servlet servlet;
        synchronized (this) {
            if (this._servlet instanceof UnavailableServlet) {
                Throwable cause = ((UnavailableServlet) this._servlet).getUnavailableException();
                if (cause != e) {
                    cause.addSuppressed(e);
                }
            } else {
                this._servlet = new UnavailableServlet(e, this._servlet);
            }
            servlet = this._servlet;
        }
        return servlet;
    }

    private void makeUnavailable(final Throwable e) {
        if (e instanceof UnavailableException) {
            makeUnavailable((UnavailableException) e);
            return;
        }
        ServletContext ctx = getServletHandler().getServletContext();
        if (ctx == null) {
            LOG.info("unavailable", e);
        } else {
            ctx.log("unavailable", e);
        }
        makeUnavailable(new UnavailableException(String.valueOf(e), -1) { // from class: org.eclipse.jetty.servlet.ServletHolder.1
            {
                initCause(e);
            }
        });
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:34:0x0104
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void initServlet() throws javax.servlet.ServletException {
        /*
        // Method dump skipped, instructions count: 330
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.servlet.ServletHolder.initServlet():void");
    }

    protected void initJspServlet() throws Exception {
        ContextHandler ch = ContextHandler.getContextHandler(getServletHandler().getServletContext());
        ch.setAttribute("org.apache.catalina.jsp_classpath", ch.getClassPath());
        if ("?".equals(getInitParameter("classpath"))) {
            String classpath = ch.getClassPath();
            if (LOG.isDebugEnabled()) {
                LOG.debug("classpath=" + classpath, new Object[0]);
            }
            if (classpath != null) {
                setInitParameter("classpath", classpath);
            }
        }
        if (getInitParameter("scratchdir") == null) {
            setInitParameter("scratchdir", new File((File) getServletHandler().getServletContext().getAttribute("javax.servlet.context.tempdir"), "jsp").getAbsolutePath());
        }
        File scratch = new File(getInitParameter("scratchdir"));
        if (!scratch.exists() && !scratch.mkdir()) {
            throw new IllegalStateException("Could not create JSP scratch directory");
        }
    }

    protected void initMultiPart() throws Exception {
        if (((Registration) getRegistration()).getMultipartConfig() != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("multipart cleanup listener added for {}", this);
            }
            ContextHandler ch = ContextHandler.getContextHandler(getServletHandler().getServletContext());
            if (!Arrays.asList(ch.getEventListeners()).contains(MultiPartCleanerListener.INSTANCE)) {
                ch.addEventListener(MultiPartCleanerListener.INSTANCE);
            }
        }
    }

    @Override // org.eclipse.jetty.server.UserIdentity.Scope
    public ContextHandler getContextHandler() {
        return ContextHandler.getContextHandler(this._config.getServletContext());
    }

    @Override // org.eclipse.jetty.server.UserIdentity.Scope
    public String getContextPath() {
        return this._config.getServletContext().getContextPath();
    }

    @Override // org.eclipse.jetty.server.UserIdentity.Scope
    public Map<String, String> getRoleRefMap() {
        return this._roleMap;
    }

    @ManagedAttribute(value = "role to run servlet as", readonly = true)
    public String getRunAsRole() {
        return this._runAsRole;
    }

    public void setRunAsRole(String role) {
        this._runAsRole = role;
    }

    /* access modifiers changed from: protected */
    public void prepare(Request baseRequest, ServletRequest request, ServletResponse response) throws ServletException, UnavailableException {
        MultipartConfigElement mpce;
        getServlet();
        if (this._registration != null && (mpce = ((Registration) this._registration).getMultipartConfig()) != null) {
            baseRequest.setAttribute(Request.MULTIPART_CONFIG_ELEMENT, mpce);
        }
    }

    @Deprecated
    public Servlet ensureInstance() throws ServletException {
        return getServlet();
    }

    public void handle(Request baseRequest, ServletRequest request, ServletResponse response) throws ServletException, UnavailableException, IOException {
        try {
            Servlet servlet = getServletInstance();
            if (servlet == null) {
                throw new UnavailableException("Servlet Not Initialized");
            }
            servlet.service(request, response);
        } catch (UnavailableException e) {
            makeUnavailable(e).service(request, response);
        }
    }

    protected boolean isJspServlet() {
        Servlet servlet = getServletInstance();
        for (Class<?> c = servlet == null ? getHeldClass() : servlet.getClass(); c != null; c = c.getSuperclass()) {
            if (isJspServlet(c.getName())) {
                return true;
            }
        }
        return false;
    }

    protected boolean isJspServlet(String classname) {
        if (classname == null) {
            return false;
        }
        return "org.apache.jasper.servlet.JspServlet".equals(classname);
    }

    private void detectJspContainer() {
        if (this._jspContainer == null) {
            try {
                Loader.loadClass(APACHE_SENTINEL_CLASS);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Apache jasper detected", new Object[0]);
                }
                this._jspContainer = JspContainer.APACHE;
            } catch (ClassNotFoundException e) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Other jasper detected", new Object[0]);
                }
                this._jspContainer = JspContainer.OTHER;
            }
        }
    }

    public String getNameOfJspClass(String jsp) {
        int i;
        if (StringUtil.isBlank(jsp)) {
            return "";
        }
        String jsp2 = jsp.trim();
        if ("/".equals(jsp2) || (i = jsp2.lastIndexOf(47)) == jsp2.length() - 1) {
            return "";
        }
        String jsp3 = jsp2.substring(i + 1);
        try {
            return (String) Loader.loadClass("org.apache.jasper.compiler.JspUtil").getMethod("makeJavaIdentifier", String.class).invoke(null, jsp3);
        } catch (Exception e) {
            String tmp = StringUtil.replace(jsp3, '.', '_');
            if (LOG.isDebugEnabled()) {
                LOG.warn("JspUtil.makeJavaIdentifier failed for jsp " + jsp3 + " using " + tmp + " instead", new Object[0]);
                LOG.warn(e);
            }
            return tmp;
        }
    }

    public String getPackageOfJspClass(String jsp) {
        int i;
        if (jsp == null || (i = jsp.lastIndexOf(47)) <= 0) {
            return "";
        }
        try {
            return (String) Loader.loadClass("org.apache.jasper.compiler.JspUtil").getMethod("makeJavaPackage", String.class).invoke(null, jsp.substring(0, i));
        } catch (Exception e) {
            int s = 0;
            if ('/' == jsp.charAt(0)) {
                s = 1;
            }
            String tmp = StringUtil.replace(jsp.substring(s, i).trim(), '/', '.');
            String tmp2 = Mapper.IGNORED_FIELDNAME.equals(tmp) ? "" : tmp;
            if (LOG.isDebugEnabled()) {
                LOG.warn("JspUtil.makeJavaPackage failed for " + jsp + " using " + tmp2 + " instead", new Object[0]);
                LOG.warn(e);
            }
            return tmp2;
        }
    }

    public String getJspPackagePrefix() {
        String jspPackageName = null;
        if (!(getServletHandler() == null || getServletHandler().getServletContext() == null)) {
            jspPackageName = getServletHandler().getServletContext().getInitParameter(JSP_GENERATED_PACKAGE_NAME);
        }
        if (jspPackageName == null) {
            jspPackageName = "org.apache.jsp";
        }
        return jspPackageName;
    }

    public String getClassNameForJsp(String jsp) {
        if (jsp == null) {
            return null;
        }
        String name = getNameOfJspClass(jsp);
        if (StringUtil.isBlank(name)) {
            return null;
        }
        StringBuffer fullName = new StringBuffer();
        appendPath(fullName, getJspPackagePrefix());
        appendPath(fullName, getPackageOfJspClass(jsp));
        appendPath(fullName, name);
        return fullName.toString();
    }

    protected void appendPath(StringBuffer path, String element) {
        if (!StringUtil.isBlank(element)) {
            if (path.length() > 0) {
                path.append(Mapper.IGNORED_FIELDNAME);
            }
            path.append(element);
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHolder$Config.class */
    public class Config extends Holder<Servlet>.HolderConfig implements ServletConfig {
        protected Config() {
            super();
        }

        @Override // javax.servlet.ServletConfig
        public String getServletName() {
            return ServletHolder.this.getName();
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHolder$Registration.class */
    public class Registration extends Holder<Servlet>.HolderRegistration implements ServletRegistration.Dynamic {
        protected MultipartConfigElement _multipartConfig;

        public Registration() {
            super();
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration
        public /* bridge */ /* synthetic */ Set setInitParameters(Map map) {
            return setInitParameters(map);
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration
        public /* bridge */ /* synthetic */ boolean setInitParameter(String str, String str2) {
            return setInitParameter(str, str2);
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration
        public /* bridge */ /* synthetic */ String getName() {
            return getName();
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration
        public /* bridge */ /* synthetic */ Map getInitParameters() {
            return getInitParameters();
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration
        public /* bridge */ /* synthetic */ String getInitParameter(String str) {
            return getInitParameter(str);
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration
        public /* bridge */ /* synthetic */ String getClassName() {
            return getClassName();
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration
        public /* bridge */ /* synthetic */ void setDescription(String str) {
            setDescription(str);
        }

        @Override // org.eclipse.jetty.servlet.Holder.HolderRegistration, javax.servlet.Registration.Dynamic
        public /* bridge */ /* synthetic */ void setAsyncSupported(boolean z) {
            setAsyncSupported(z);
        }

        @Override // javax.servlet.ServletRegistration
        public Set<String> addMapping(String... urlPatterns) {
            ServletHolder.this.illegalStateIfContextStarted();
            Set<String> clash = null;
            for (String pattern : urlPatterns) {
                ServletMapping mapping = ServletHolder.this.getServletHandler().getServletMapping(pattern);
                if (mapping != null && !mapping.isDefault()) {
                    if (clash == null) {
                        clash = new HashSet<>();
                    }
                    clash.add(pattern);
                }
            }
            if (clash != null) {
                return clash;
            }
            ServletMapping mapping2 = new ServletMapping(Source.JAVAX_API);
            mapping2.setServletName(ServletHolder.this.getName());
            mapping2.setPathSpecs(urlPatterns);
            ServletHolder.this.getServletHandler().addServletMapping(mapping2);
            return Collections.emptySet();
        }

        @Override // javax.servlet.ServletRegistration
        public Collection<String> getMappings() {
            String[] specs;
            ServletMapping[] mappings = ServletHolder.this.getServletHandler().getServletMappings();
            List<String> patterns = new ArrayList<>();
            if (mappings != null) {
                for (ServletMapping mapping : mappings) {
                    if (mapping.getServletName().equals(getName()) && (specs = mapping.getPathSpecs()) != null && specs.length > 0) {
                        patterns.addAll(Arrays.asList(specs));
                    }
                }
            }
            return patterns;
        }

        @Override // javax.servlet.ServletRegistration
        public String getRunAsRole() {
            return ServletHolder.this._runAsRole;
        }

        @Override // javax.servlet.ServletRegistration.Dynamic
        public void setLoadOnStartup(int loadOnStartup) {
            ServletHolder.this.illegalStateIfContextStarted();
            ServletHolder.this.setInitOrder(loadOnStartup);
        }

        public int getInitOrder() {
            return ServletHolder.this.getInitOrder();
        }

        @Override // javax.servlet.ServletRegistration.Dynamic
        public void setMultipartConfig(MultipartConfigElement element) {
            this._multipartConfig = element;
        }

        public MultipartConfigElement getMultipartConfig() {
            return this._multipartConfig;
        }

        @Override // javax.servlet.ServletRegistration.Dynamic
        public void setRunAsRole(String role) {
            ServletHolder.this._runAsRole = role;
        }

        @Override // javax.servlet.ServletRegistration.Dynamic
        public Set<String> setServletSecurity(ServletSecurityElement securityElement) {
            return ServletHolder.this.getServletHandler().setServletSecurity(this, securityElement);
        }
    }

    public ServletRegistration.Dynamic getRegistration() {
        if (this._registration == null) {
            this._registration = new Registration();
        }
        return this._registration;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHolder$SingleThreadedWrapper.class */
    public class SingleThreadedWrapper implements Servlet {
        Stack<Servlet> _stack;

        private SingleThreadedWrapper() {
            this._stack = new Stack<>();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0020
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // javax.servlet.Servlet
        public void destroy() {
            /*
                r3 = this;
                r0 = r3
                r1 = r0
                r4 = r1
                monitor-enter(r0)
            L_0x0004:
                r0 = r3
                java.util.Stack<javax.servlet.Servlet> r0 = r0._stack     // Catch: all -> 0x0032
                int r0 = r0.size()     // Catch: all -> 0x0032
                if (r0 <= 0) goto L_0x002d
                r0 = r3
                java.util.Stack<javax.servlet.Servlet> r0 = r0._stack     // Catch: all -> 0x0032, Exception -> 0x0020
                java.lang.Object r0 = r0.pop()     // Catch: all -> 0x0032, Exception -> 0x0020
                javax.servlet.Servlet r0 = (javax.servlet.Servlet) r0     // Catch: all -> 0x0032, Exception -> 0x0020
                r0.destroy()     // Catch: all -> 0x0032, Exception -> 0x0020
                goto L_0x0004
            L_0x0020:
                r5 = move-exception
                org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.servlet.ServletHolder.access$200()     // Catch: all -> 0x0032
                r1 = r5
                r0.warn(r1)     // Catch: all -> 0x0032
                goto L_0x0004
            L_0x002d:
                r0 = r4
                monitor-exit(r0)     // Catch: all -> 0x0032
                goto L_0x0037
            L_0x0032:
                r6 = move-exception
                r0 = r4
                monitor-exit(r0)     // Catch: all -> 0x0032
                r0 = r6
                throw r0
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.servlet.ServletHolder.SingleThreadedWrapper.destroy():void");
        }

        @Override // javax.servlet.Servlet
        public ServletConfig getServletConfig() {
            return ServletHolder.this._config;
        }

        @Override // javax.servlet.Servlet
        public String getServletInfo() {
            return null;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0029
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // javax.servlet.Servlet
        public void init(javax.servlet.ServletConfig r5) throws javax.servlet.ServletException {
            /*
                r4 = this;
                r0 = r4
                r1 = r0
                r6 = r1
                monitor-enter(r0)
                r0 = r4
                java.util.Stack<javax.servlet.Servlet> r0 = r0._stack     // Catch: all -> 0x003b
                int r0 = r0.size()     // Catch: all -> 0x003b
                if (r0 != 0) goto L_0x0036
                r0 = r4
                org.eclipse.jetty.servlet.ServletHolder r0 = org.eclipse.jetty.servlet.ServletHolder.this     // Catch: all -> 0x003b, ServletException -> 0x0029, Exception -> 0x002c
                javax.servlet.Servlet r0 = r0.newInstance()     // Catch: all -> 0x003b, ServletException -> 0x0029, Exception -> 0x002c
                r7 = r0
                r0 = r7
                r1 = r5
                r0.init(r1)     // Catch: all -> 0x003b, ServletException -> 0x0029, Exception -> 0x002c
                r0 = r4
                java.util.Stack<javax.servlet.Servlet> r0 = r0._stack     // Catch: all -> 0x003b, ServletException -> 0x0029, Exception -> 0x002c
                r1 = r7
                java.lang.Object r0 = r0.push(r1)     // Catch: all -> 0x003b, ServletException -> 0x0029, Exception -> 0x002c
                goto L_0x0036
            L_0x0029:
                r7 = move-exception
                r0 = r7
                throw r0     // Catch: all -> 0x003b
            L_0x002c:
                r7 = move-exception
                javax.servlet.ServletException r0 = new javax.servlet.ServletException     // Catch: all -> 0x003b
                r1 = r0
                r2 = r7
                r1.<init>(r2)     // Catch: all -> 0x003b
                throw r0     // Catch: all -> 0x003b
            L_0x0036:
                r0 = r6
                monitor-exit(r0)     // Catch: all -> 0x003b
                goto L_0x0042
            L_0x003b:
                r8 = move-exception
                r0 = r6
                monitor-exit(r0)     // Catch: all -> 0x003b
                r0 = r8
                throw r0
            L_0x0042:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.servlet.ServletHolder.SingleThreadedWrapper.init(javax.servlet.ServletConfig):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0035
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // javax.servlet.Servlet
        public void service(javax.servlet.ServletRequest r5, javax.servlet.ServletResponse r6) throws javax.servlet.ServletException, java.io.IOException {
            /*
                r4 = this;
                r0 = r4
                r1 = r0
                r8 = r1
                monitor-enter(r0)
                r0 = r4
                java.util.Stack<javax.servlet.Servlet> r0 = r0._stack     // Catch: all -> 0x004c
                int r0 = r0.size()     // Catch: all -> 0x004c
                if (r0 <= 0) goto L_0x001d
                r0 = r4
                java.util.Stack<javax.servlet.Servlet> r0 = r0._stack     // Catch: all -> 0x004c
                java.lang.Object r0 = r0.pop()     // Catch: all -> 0x004c
                javax.servlet.Servlet r0 = (javax.servlet.Servlet) r0     // Catch: all -> 0x004c
                r7 = r0
                goto L_0x0046
            L_0x001d:
                r0 = r4
                org.eclipse.jetty.servlet.ServletHolder r0 = org.eclipse.jetty.servlet.ServletHolder.this     // Catch: ServletException -> 0x0035, Exception -> 0x003a, all -> 0x004c
                javax.servlet.Servlet r0 = r0.newInstance()     // Catch: ServletException -> 0x0035, Exception -> 0x003a, all -> 0x004c
                r7 = r0
                r0 = r7
                r1 = r4
                org.eclipse.jetty.servlet.ServletHolder r1 = org.eclipse.jetty.servlet.ServletHolder.this     // Catch: ServletException -> 0x0035, Exception -> 0x003a, all -> 0x004c
                org.eclipse.jetty.servlet.ServletHolder$Config r1 = org.eclipse.jetty.servlet.ServletHolder.access$300(r1)     // Catch: ServletException -> 0x0035, Exception -> 0x003a, all -> 0x004c
                r0.init(r1)     // Catch: ServletException -> 0x0035, Exception -> 0x003a, all -> 0x004c
                goto L_0x0046
            L_0x0035:
                r9 = move-exception
                r0 = r9
                throw r0     // Catch: all -> 0x004c
            L_0x003a:
                r9 = move-exception
                javax.servlet.ServletException r0 = new javax.servlet.ServletException     // Catch: all -> 0x004c
                r1 = r0
                r2 = r9
                r1.<init>(r2)     // Catch: all -> 0x004c
                throw r0     // Catch: all -> 0x004c
            L_0x0046:
                r0 = r8
                monitor-exit(r0)     // Catch: all -> 0x004c
                goto L_0x0054
            L_0x004c:
                r10 = move-exception
                r0 = r8
                monitor-exit(r0)     // Catch: all -> 0x004c
                r0 = r10
                throw r0
            L_0x0054:
                r0 = r7
                r1 = r5
                r2 = r6
                r0.service(r1, r2)     // Catch: all -> 0x007b
                r0 = r4
                r1 = r0
                r8 = r1
                monitor-enter(r0)
                r0 = r4
                java.util.Stack<javax.servlet.Servlet> r0 = r0._stack     // Catch: all -> 0x0070
                r1 = r7
                java.lang.Object r0 = r0.push(r1)     // Catch: all -> 0x0070
                r0 = r8
                monitor-exit(r0)     // Catch: all -> 0x0070
                goto L_0x0078
            L_0x0070:
                r11 = move-exception
                r0 = r8
                monitor-exit(r0)     // Catch: all -> 0x0070
                r0 = r11
                throw r0
            L_0x0078:
                goto L_0x009c
            L_0x007b:
                r12 = move-exception
                r0 = r4
                r1 = r0
                r13 = r1
                monitor-enter(r0)
                r0 = r4
                java.util.Stack<javax.servlet.Servlet> r0 = r0._stack     // Catch: all -> 0x0091
                r1 = r7
                java.lang.Object r0 = r0.push(r1)     // Catch: all -> 0x0091
                r0 = r13
                monitor-exit(r0)     // Catch: all -> 0x0091
                goto L_0x0099
            L_0x0091:
                r14 = move-exception
                r0 = r13
                monitor-exit(r0)     // Catch: all -> 0x0091
                r0 = r14
                throw r0
            L_0x0099:
                r0 = r12
                throw r0
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.servlet.ServletHolder.SingleThreadedWrapper.service(javax.servlet.ServletRequest, javax.servlet.ServletResponse):void");
        }
    }

    protected Servlet newInstance() throws ServletException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        try {
            ServletContext ctx = getServletHandler().getServletContext();
            if (ctx != null) {
                return ctx.createServlet(getHeldClass());
            }
            return (Servlet) getHeldClass().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ServletException ex) {
            Throwable cause = ex.getRootCause();
            if (cause instanceof InstantiationException) {
                throw ((InstantiationException) cause);
            } else if (cause instanceof IllegalAccessException) {
                throw ((IllegalAccessException) cause);
            } else if (cause instanceof NoSuchMethodException) {
                throw ((NoSuchMethodException) cause);
            } else if (cause instanceof InvocationTargetException) {
                throw ((InvocationTargetException) cause);
            } else {
                throw ex;
            }
        }
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        if (getInitParameters().isEmpty()) {
            Object[] objArr = new Object[1];
            objArr[0] = this._servlet == null ? getHeldClass() : this._servlet;
            Dumpable.dumpObjects(out, indent, this, objArr);
            return;
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = this._servlet == null ? getHeldClass() : this._servlet;
        objArr2[1] = new DumpableCollection("initParams", getInitParameters().entrySet());
        Dumpable.dumpObjects(out, indent, this, objArr2);
    }

    @Override // org.eclipse.jetty.servlet.Holder, org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        Object[] objArr = new Object[9];
        objArr[0] = getName();
        objArr[1] = getClassName();
        objArr[2] = Integer.valueOf(hashCode());
        objArr[3] = this._forcedPath;
        objArr[4] = Integer.valueOf(this._initOrder);
        objArr[5] = Boolean.valueOf(this._servlet != null);
        objArr[6] = Boolean.valueOf(isAsyncSupported());
        objArr[7] = getSource();
        objArr[8] = getState();
        return String.format("%s==%s@%x{jsp=%s,order=%d,inst=%b,async=%b,src=%s,%s}", objArr);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHolder$UnavailableServlet.class */
    public class UnavailableServlet extends Wrapper {
        final UnavailableException _unavailableException;
        final AtomicLong _unavailableStart;

        public UnavailableServlet(UnavailableException unavailableException, Servlet servlet) {
            super(servlet != null ? servlet : new GenericServlet() { // from class: org.eclipse.jetty.servlet.ServletHolder.UnavailableServlet.1
                @Override // javax.servlet.GenericServlet, javax.servlet.Servlet
                public void service(ServletRequest req, ServletResponse res) throws IOException {
                    ((HttpServletResponse) res).sendError(404);
                }
            });
            this._unavailableException = unavailableException;
            if (unavailableException.isPermanent()) {
                this._unavailableStart = null;
                return;
            }
            long start = System.nanoTime();
            while (start == 0) {
                start = System.nanoTime();
            }
            this._unavailableStart = new AtomicLong(start);
        }

        @Override // org.eclipse.jetty.servlet.ServletHolder.Wrapper, javax.servlet.Servlet
        public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            if (ServletHolder.LOG.isDebugEnabled()) {
                ServletHolder.LOG.debug("Unavailable {}", req, this._unavailableException);
            }
            if (this._unavailableStart == null) {
                ((HttpServletResponse) res).sendError(404);
                return;
            }
            long start = this._unavailableStart.get();
            if (start == 0 || System.nanoTime() - start < TimeUnit.SECONDS.toNanos((long) this._unavailableException.getUnavailableSeconds())) {
                ((HttpServletResponse) res).sendError(503);
            } else if (this._unavailableStart.compareAndSet(start, 0)) {
                synchronized (this) {
                    ServletHolder.this._servlet = getWrapped();
                }
                Request baseRequest = Request.getBaseRequest(req);
                ServletHolder.this.prepare(baseRequest, req, res);
                ServletHolder.this.handle(baseRequest, req, res);
            } else {
                ((HttpServletResponse) res).sendError(503);
            }
        }

        public UnavailableException getUnavailableException() {
            return this._unavailableException;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHolder$Wrapper.class */
    public static class Wrapper implements Servlet, BaseHolder.Wrapped<Servlet> {
        private final Servlet _wrappedServlet;

        public Wrapper(Servlet servlet) {
            this._wrappedServlet = (Servlet) Objects.requireNonNull(servlet, "Servlet cannot be null");
        }

        @Override // org.eclipse.jetty.servlet.BaseHolder.Wrapped
        public Servlet getWrapped() {
            return this._wrappedServlet;
        }

        @Override // javax.servlet.Servlet
        public void init(ServletConfig config) throws ServletException {
            this._wrappedServlet.init(config);
        }

        @Override // javax.servlet.Servlet
        public ServletConfig getServletConfig() {
            return this._wrappedServlet.getServletConfig();
        }

        @Override // javax.servlet.Servlet
        public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            this._wrappedServlet.service(req, res);
        }

        @Override // javax.servlet.Servlet
        public String getServletInfo() {
            return this._wrappedServlet.getServletInfo();
        }

        @Override // javax.servlet.Servlet
        public void destroy() {
            this._wrappedServlet.destroy();
        }

        public String toString() {
            return String.format("%s:%s", getClass().getSimpleName(), this._wrappedServlet.toString());
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHolder$RunAs.class */
    public static class RunAs extends Wrapper {
        final IdentityService _identityService;
        final RunAsToken _runAsToken;

        public RunAs(Servlet servlet, IdentityService identityService, RunAsToken runAsToken) {
            super(servlet);
            this._identityService = identityService;
            this._runAsToken = runAsToken;
        }

        @Override // org.eclipse.jetty.servlet.ServletHolder.Wrapper, javax.servlet.Servlet
        public void init(ServletConfig config) throws ServletException {
            Object oldRunAs = this._identityService.setRunAs(this._identityService.getSystemUserIdentity(), this._runAsToken);
            try {
                getWrapped().init(config);
            } finally {
                this._identityService.unsetRunAs(oldRunAs);
            }
        }

        @Override // org.eclipse.jetty.servlet.ServletHolder.Wrapper, javax.servlet.Servlet
        public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            Object oldRunAs = this._identityService.setRunAs(this._identityService.getSystemUserIdentity(), this._runAsToken);
            try {
                getWrapped().service(req, res);
                this._identityService.unsetRunAs(oldRunAs);
            } catch (Throwable th) {
                this._identityService.unsetRunAs(oldRunAs);
                throw th;
            }
        }

        @Override // org.eclipse.jetty.servlet.ServletHolder.Wrapper, javax.servlet.Servlet
        public void destroy() {
            Object oldRunAs = this._identityService.setRunAs(this._identityService.getSystemUserIdentity(), this._runAsToken);
            try {
                getWrapped().destroy();
            } finally {
                this._identityService.unsetRunAs(oldRunAs);
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ServletHolder$NotAsync.class */
    public static class NotAsync extends Wrapper {
        public NotAsync(Servlet servlet) {
            super(servlet);
        }

        @Override // org.eclipse.jetty.servlet.ServletHolder.Wrapper, javax.servlet.Servlet
        public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            if (req.isAsyncSupported()) {
                Request baseRequest = Request.getBaseRequest(req);
                try {
                    baseRequest.setAsyncSupported(false, toString());
                    getWrapped().service(req, res);
                    baseRequest.setAsyncSupported(true, null);
                } catch (Throwable th) {
                    baseRequest.setAsyncSupported(true, null);
                    throw th;
                }
            } else {
                getWrapped().service(req, res);
            }
        }
    }
}
