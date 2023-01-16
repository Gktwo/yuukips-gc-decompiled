package org.eclipse.jetty.webapp;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.PermissionCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletSecurityElement;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;
import org.eclipse.jetty.security.ConstraintAware;
import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.SecurityHandler;
import org.eclipse.jetty.server.ClassLoaderDump;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HandlerContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ErrorPageErrorHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.util.AttributesMap;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceCollection;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppClassLoader;

@ManagedObject("Web Application ContextHandler")
/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/WebAppContext.class */
public class WebAppContext extends ServletContextHandler implements WebAppClassLoader.Context {
    public static final String TEMPDIR = "javax.servlet.context.tempdir";
    public static final String BASETEMPDIR = "org.eclipse.jetty.webapp.basetempdir";
    public static final String WEB_DEFAULTS_XML = "org/eclipse/jetty/webapp/webdefault.xml";
    public static final String ERROR_PAGE = "org.eclipse.jetty.server.error_page";
    public static final String SERVER_SYS_CLASSES = "org.eclipse.jetty.webapp.systemClasses";
    public static final String SERVER_SRV_CLASSES = "org.eclipse.jetty.webapp.serverClasses";
    private final List<String> _configurationClasses;
    private ClasspathPattern _systemClasses;
    private ClasspathPattern _serverClasses;
    private final List<Configuration> _configurations;
    private String _defaultsDescriptor;
    private String _descriptor;
    private final List<String> _overrideDescriptors;
    private boolean _distributable;
    private boolean _extractWAR;
    private boolean _copyDir;
    private boolean _copyWebInf;
    private boolean _logUrlOnStart;
    private boolean _parentLoaderPriority;
    private PermissionCollection _permissions;
    private String[] _contextWhiteList;
    private File _tmpDir;
    private boolean _persistTmpDir;
    private String _war;
    private String _extraClasspath;
    private Throwable _unavailableException;
    private Map<String, String> _resourceAliases;
    private boolean _ownClassLoader;
    private boolean _configurationDiscovered;
    private boolean _allowDuplicateFragmentNames;
    private boolean _throwUnavailableOnStartupException;
    private MetaData _metadata;
    static final Logger LOG = Log.getLogger(WebAppContext.class);
    private static final String[] DEFAULT_PROTECTED_TARGETS = {"/WEB-INF", "/META-INF"};
    public static final String[] DEFAULT_CONFIGURATION_CLASSES = {"org.eclipse.jetty.webapp.WebInfConfiguration", "org.eclipse.jetty.webapp.WebXmlConfiguration", "org.eclipse.jetty.webapp.MetaInfConfiguration", "org.eclipse.jetty.webapp.FragmentConfiguration", JettyWebXmlConfiguration.XML_CONFIGURATION};
    public static final String[] __dftSystemClasses = {"java.", "javax.", "org.xml.", "org.w3c.", "org.eclipse.jetty.jmx.", "org.eclipse.jetty.util.annotation.", "org.eclipse.jetty.continuation.", "org.eclipse.jetty.jndi.", "org.eclipse.jetty.jaas.", "org.eclipse.jetty.websocket.", "org.eclipse.jetty.util.log.", "org.eclipse.jetty.servlet.DefaultServlet", "org.eclipse.jetty.jsp.JettyJspServlet", "org.eclipse.jetty.servlets.PushCacheFilter", "org.eclipse.jetty.servlets.PushSessionCacheFilter"};
    public static final String[] __dftServerClasses = {"-org.eclipse.jetty.server.session.SessionData", "-org.eclipse.jetty.jmx.", "-org.eclipse.jetty.util.annotation.", "-org.eclipse.jetty.continuation.", "-org.eclipse.jetty.jndi.", "-org.eclipse.jetty.jaas.", "-org.eclipse.jetty.servlets.", "-org.eclipse.jetty.servlet.DefaultServlet", "-org.eclipse.jetty.servlet.NoJspServlet", "-org.eclipse.jetty.jsp.", "-org.eclipse.jetty.servlet.listener.", "-org.eclipse.jetty.websocket.", "-org.eclipse.jetty.apache.", "-org.eclipse.jetty.util.log.", "-org.eclipse.jetty.alpn.", "org.objectweb.asm.", "org.eclipse.jdt.", "org.eclipse.jetty."};

    public static WebAppContext getCurrentWebAppContext() {
        ContextHandler.Context context = ContextHandler.getCurrentContext();
        if (context == null) {
            return null;
        }
        ContextHandler handler = context.getContextHandler();
        if (handler instanceof WebAppContext) {
            return (WebAppContext) handler;
        }
        return null;
    }

    public WebAppContext() {
        this(null, null, null, null, null, new ErrorPageErrorHandler(), 3);
    }

    public WebAppContext(String webApp, String contextPath) {
        this(null, contextPath, null, null, null, new ErrorPageErrorHandler(), 3);
        setWar(webApp);
    }

    public WebAppContext(Resource webApp, String contextPath) {
        this(null, contextPath, null, null, null, new ErrorPageErrorHandler(), 3);
        setWarResource(webApp);
    }

    public WebAppContext(HandlerContainer parent, String webApp, String contextPath) {
        this(parent, contextPath, null, null, null, new ErrorPageErrorHandler(), 3);
        setWar(webApp);
    }

    public WebAppContext(HandlerContainer parent, Resource webApp, String contextPath) {
        this(parent, contextPath, null, null, null, new ErrorPageErrorHandler(), 3);
        setWarResource(webApp);
    }

    public WebAppContext(SessionHandler sessionHandler, SecurityHandler securityHandler, ServletHandler servletHandler, ErrorHandler errorHandler) {
        this(null, null, sessionHandler, securityHandler, servletHandler, errorHandler, 0);
    }

    public WebAppContext(HandlerContainer parent, String contextPath, SessionHandler sessionHandler, SecurityHandler securityHandler, ServletHandler servletHandler, ErrorHandler errorHandler, int options) {
        super(parent, contextPath, sessionHandler, securityHandler, servletHandler, errorHandler, options);
        this._configurationClasses = new ArrayList();
        this._systemClasses = null;
        this._serverClasses = null;
        this._configurations = new ArrayList();
        this._defaultsDescriptor = WEB_DEFAULTS_XML;
        this._descriptor = null;
        this._overrideDescriptors = new ArrayList();
        this._distributable = false;
        this._extractWAR = true;
        this._copyDir = false;
        this._copyWebInf = false;
        this._logUrlOnStart = false;
        this._parentLoaderPriority = Boolean.getBoolean("org.eclipse.jetty.server.webapp.parentLoaderPriority");
        this._contextWhiteList = null;
        this._persistTmpDir = false;
        this._ownClassLoader = false;
        this._configurationDiscovered = false;
        this._allowDuplicateFragmentNames = false;
        this._throwUnavailableOnStartupException = false;
        this._metadata = new MetaData();
        this._scontext = new Context();
        setErrorHandler(errorHandler != null ? errorHandler : new ErrorPageErrorHandler());
        setProtectedTargets(DEFAULT_PROTECTED_TARGETS);
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler
    public void setDisplayName(String servletContextName) {
        setDisplayName(servletContextName);
        ClassLoader cl = getClassLoader();
        if ((cl instanceof WebAppClassLoader) && servletContextName != null) {
            ((WebAppClassLoader) cl).setName(servletContextName);
        }
    }

    public Throwable getUnavailableException() {
        return this._unavailableException;
    }

    public void setResourceAlias(String alias, String uri) {
        if (this._resourceAliases == null) {
            this._resourceAliases = new HashMap(5);
        }
        this._resourceAliases.put(alias, uri);
    }

    public Map<String, String> getResourceAliases() {
        if (this._resourceAliases == null) {
            return null;
        }
        return this._resourceAliases;
    }

    public void setResourceAliases(Map<String, String> map) {
        this._resourceAliases = map;
    }

    public String getResourceAlias(String path) {
        if (this._resourceAliases == null) {
            return null;
        }
        String alias = this._resourceAliases.get(path);
        int slash = path.length();
        while (alias == null) {
            slash = path.lastIndexOf("/", slash - 1);
            if (slash < 0) {
                break;
            }
            String match = this._resourceAliases.get(path.substring(0, slash + 1));
            if (match != null) {
                alias = match + path.substring(slash + 1);
            }
        }
        return alias;
    }

    public String removeResourceAlias(String alias) {
        if (this._resourceAliases == null) {
            return null;
        }
        return this._resourceAliases.remove(alias);
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler
    public void setClassLoader(ClassLoader classLoader) {
        setClassLoader(classLoader);
        String name = getDisplayName();
        if (name == null) {
            name = getContextPath();
        }
        if ((classLoader instanceof WebAppClassLoader) && getDisplayName() != null) {
            ((WebAppClassLoader) classLoader).setName(name);
        }
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler
    public Resource getResource(String uriInContext) throws MalformedURLException {
        if (uriInContext == null || !uriInContext.startsWith("/")) {
            throw new MalformedURLException(uriInContext);
        }
        MalformedURLException mue = null;
        Resource resource = null;
        int loop = 0;
        while (uriInContext != null) {
            loop++;
            if (loop >= 100) {
                break;
            }
            try {
                resource = getResource(uriInContext);
            } catch (MalformedURLException e) {
                LOG.ignore(e);
                if (mue == null) {
                    mue = e;
                }
            }
            if (resource != null && resource.exists()) {
                return resource;
            }
            uriInContext = getResourceAlias(uriInContext);
        }
        if (mue == null) {
            return resource;
        }
        throw mue;
    }

    public boolean isConfigurationDiscovered() {
        return this._configurationDiscovered;
    }

    public void setConfigurationDiscovered(boolean discovered) {
        this._configurationDiscovered = discovered;
    }

    public void preConfigure() throws Exception {
        loadConfigurations();
        loadSystemClasses();
        loadServerClasses();
        this._ownClassLoader = false;
        if (getClassLoader() == null) {
            setClassLoader(new WebAppClassLoader(this));
            this._ownClassLoader = true;
        }
        if (LOG.isDebugEnabled()) {
            ClassLoader loader = getClassLoader();
            LOG.debug("Thread Context classloader {}", loader);
            for (ClassLoader loader2 = loader.getParent(); loader2 != null; loader2 = loader2.getParent()) {
                LOG.debug("Parent class loader: {} ", loader2);
            }
        }
        for (Configuration configuration : this._configurations) {
            LOG.debug("preConfigure {} with {}", this, configuration);
            configuration.preConfigure(this);
        }
    }

    public void configure() throws Exception {
        for (Configuration configuration : this._configurations) {
            LOG.debug("configure {} with {}", this, configuration);
            configuration.configure(this);
        }
    }

    public void postConfigure() throws Exception {
        for (Configuration configuration : this._configurations) {
            LOG.debug("postConfigure {} with {}", this, configuration);
            configuration.postConfigure(this);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.servlet.ServletContextHandler, org.eclipse.jetty.server.handler.ContextHandler, org.eclipse.jetty.server.handler.ScopedHandler, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        boolean isThrowUnavailableOnStartupException;
        try {
            this._metadata.setAllowDuplicateFragmentNames(isAllowDuplicateFragmentNames());
            Boolean validate = (Boolean) getAttribute(MetaData.VALIDATE_XML);
            this._metadata.setValidateXml(validate != null && validate.booleanValue());
            preConfigure();
            doStart();
            postConfigure();
            if (isLogUrlOnStart()) {
                dumpUrl();
            }
        } finally {
            if (isThrowUnavailableOnStartupException) {
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.servlet.ServletContextHandler, org.eclipse.jetty.server.handler.ContextHandler, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Destroyable
    public void destroy() {
        MultiException mx = new MultiException();
        if (this._configurations != null) {
            int i = this._configurations.size();
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                try {
                    this._configurations.get(i).destroy(this);
                } catch (Exception e) {
                    mx.add(e);
                }
            }
        }
        this._configurations.clear();
        destroy();
        mx.ifExceptionThrowRuntime();
    }

    private void dumpUrl() {
        Connector[] connectors = getServer().getConnectors();
        for (int i = 0; i < connectors.length; i++) {
            String displayName = getDisplayName();
            if (displayName == null) {
                displayName = "WebApp@" + Arrays.hashCode(connectors);
            }
            LOG.info(displayName + " at http://" + connectors[i].toString() + getContextPath(), new Object[0]);
        }
    }

    @ManagedAttribute(value = "configuration classes used to configure webapp", readonly = true)
    public String[] getConfigurationClasses() {
        return (String[]) this._configurationClasses.toArray(new String[0]);
    }

    public Configuration[] getConfigurations() {
        return (Configuration[]) this._configurations.toArray(new Configuration[0]);
    }

    @ManagedAttribute(value = "default web.xml deascriptor applied before standard web.xml", readonly = true)
    public String getDefaultsDescriptor() {
        return this._defaultsDescriptor;
    }

    public String getOverrideDescriptor() {
        if (this._overrideDescriptors.size() != 1) {
            return null;
        }
        return this._overrideDescriptors.get(0);
    }

    @ManagedAttribute(value = "web.xml deascriptors applied after standard web.xml", readonly = true)
    public List<String> getOverrideDescriptors() {
        return Collections.unmodifiableList(this._overrideDescriptors);
    }

    @Override // org.eclipse.jetty.webapp.WebAppClassLoader.Context
    public PermissionCollection getPermissions() {
        return this._permissions;
    }

    @ManagedAttribute(value = "classes and packages hidden by the context classloader", readonly = true)
    public String[] getServerClasses() {
        if (this._serverClasses == null) {
            loadServerClasses();
        }
        return this._serverClasses.getPatterns();
    }

    public ClasspathPattern getServerClasspathPattern() {
        if (this._serverClasses == null) {
            loadServerClasses();
        }
        return this._serverClasses;
    }

    @Deprecated
    public void addServerClass(String classOrPackageOrLocation) {
        if (this._serverClasses == null) {
            loadServerClasses();
        }
        this._serverClasses.add(classOrPackageOrLocation);
    }

    @Deprecated
    public void prependServerClass(String classOrPackage) {
        if (this._serverClasses == null) {
            loadServerClasses();
        }
        this._serverClasses.add(classOrPackage);
    }

    @ManagedAttribute(value = "classes and packages given priority by context classloader", readonly = true)
    public String[] getSystemClasses() {
        if (this._systemClasses == null) {
            loadSystemClasses();
        }
        return this._systemClasses.getPatterns();
    }

    public ClasspathPattern getSystemClasspathPattern() {
        if (this._systemClasses == null) {
            loadSystemClasses();
        }
        return this._systemClasses;
    }

    @Deprecated
    public void addSystemClass(String classOrPackage) {
        if (this._systemClasses == null) {
            loadSystemClasses();
        }
        this._systemClasses.add(classOrPackage);
    }

    @Deprecated
    public void prependSystemClass(String classOrPackage) {
        if (this._systemClasses == null) {
            loadSystemClasses();
        }
        this._systemClasses.add(classOrPackage);
    }

    @Deprecated
    public boolean isServerClass(String name) {
        if (this._serverClasses == null) {
            loadServerClasses();
        }
        return this._serverClasses.match(name);
    }

    @Deprecated
    public boolean isSystemClass(String name) {
        if (this._systemClasses == null) {
            loadSystemClasses();
        }
        return this._systemClasses.match(name);
    }

    @Override // org.eclipse.jetty.util.ClassVisibilityChecker
    public boolean isServerClass(Class<?> clazz) {
        if (this._serverClasses == null) {
            loadServerClasses();
        }
        return this._serverClasses.match(clazz);
    }

    @Override // org.eclipse.jetty.util.ClassVisibilityChecker
    public boolean isSystemClass(Class<?> clazz) {
        if (this._systemClasses == null) {
            loadSystemClasses();
        }
        return this._systemClasses.match(clazz);
    }

    @Override // org.eclipse.jetty.webapp.WebAppClassLoader.Context
    public boolean isServerResource(String name, URL parentUrl) {
        if (this._serverClasses == null) {
            loadServerClasses();
        }
        return this._serverClasses.match(name, parentUrl);
    }

    @Override // org.eclipse.jetty.webapp.WebAppClassLoader.Context
    public boolean isSystemResource(String name, URL webappUrl) {
        if (this._systemClasses == null) {
            loadSystemClasses();
        }
        return this._systemClasses.match(name, webappUrl);
    }

    protected void loadSystemClasses() {
        if (this._systemClasses == null) {
            Server server = getServer();
            if (server != null) {
                Object systemClasses = server.getAttribute(SERVER_SYS_CLASSES);
                if (systemClasses instanceof String[]) {
                    this._systemClasses = new ClasspathPattern((String[]) systemClasses);
                } else if (systemClasses instanceof ClasspathPattern) {
                    this._systemClasses = new ClasspathPattern(((ClasspathPattern) systemClasses).getPatterns());
                }
            }
            if (this._systemClasses == null) {
                this._systemClasses = new ClasspathPattern(__dftSystemClasses);
            }
        }
    }

    protected void loadServerClasses() {
        if (this._serverClasses == null) {
            Server server = getServer();
            if (server != null) {
                Object serverClasses = server.getAttribute(SERVER_SRV_CLASSES);
                if (serverClasses instanceof String[]) {
                    this._serverClasses = new ClasspathPattern((String[]) serverClasses);
                } else if (serverClasses instanceof ClasspathPattern) {
                    this._serverClasses = new ClasspathPattern(((ClasspathPattern) serverClasses).getPatterns());
                }
            }
            if (this._serverClasses == null) {
                this._serverClasses = new ClasspathPattern(__dftServerClasses);
            }
        }
    }

    @ManagedAttribute(value = "war file location", readonly = true)
    public String getWar() {
        if (this._war == null) {
            this._war = getResourceBase();
        }
        return this._war;
    }

    public Resource getWebInf() throws IOException {
        if (getBaseResource() == null) {
            return null;
        }
        Resource webInf = getBaseResource().addPath("WEB-INF/");
        if (!webInf.exists() || !webInf.isDirectory()) {
            return null;
        }
        return webInf;
    }

    @ManagedAttribute("web application distributable")
    public boolean isDistributable() {
        return this._distributable;
    }

    @ManagedAttribute(value = "extract war", readonly = true)
    public boolean isExtractWAR() {
        return this._extractWAR;
    }

    @ManagedAttribute(value = "webdir copied on deploy (allows hot replacement on windows)", readonly = true)
    public boolean isCopyWebDir() {
        return this._copyDir;
    }

    public boolean isCopyWebInf() {
        return this._copyWebInf;
    }

    @Override // org.eclipse.jetty.webapp.WebAppClassLoader.Context
    @ManagedAttribute(value = "parent classloader given priority", readonly = true)
    public boolean isParentLoaderPriority() {
        return this._parentLoaderPriority;
    }

    public static String[] getDefaultConfigurationClasses() {
        return DEFAULT_CONFIGURATION_CLASSES;
    }

    public String[] getDefaultServerClasses() {
        return __dftServerClasses;
    }

    public String[] getDefaultSystemClasses() {
        return __dftSystemClasses;
    }

    protected void loadConfigurations() throws Exception {
        if (this._configurations.isEmpty()) {
            if (this._configurationClasses.isEmpty()) {
                this._configurationClasses.addAll(Configuration.ClassList.serverDefault(getServer()));
            }
            for (String configClass : this._configurationClasses) {
                this._configurations.add(wrap((Configuration) Loader.loadClass(configClass).getDeclaredConstructor(new Class[0]).newInstance(new Object[0])));
            }
        }
    }

    private Configuration wrap(Configuration configuration) {
        Configuration ret = configuration;
        for (Configuration.WrapperFunction wrapperFunction : getBeans(Configuration.WrapperFunction.class)) {
            ret = wrapperFunction.wrapConfiguration(ret);
        }
        return ret;
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler, org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        if (this._war != null) {
            return toString() + "{" + this._war + "}";
        }
        return toString();
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        List<String> systemClasses = null;
        if (this._systemClasses != null) {
            systemClasses = new ArrayList<>(this._systemClasses);
            Collections.sort(systemClasses);
        }
        List<String> serverClasses = null;
        if (this._serverClasses != null) {
            serverClasses = new ArrayList<>(this._serverClasses);
            Collections.sort(serverClasses);
        }
        String name = getDisplayName();
        if (name == null) {
            if (this._war != null) {
                int webapps = this._war.indexOf("/webapps/");
                if (webapps >= 0) {
                    name = this._war.substring(webapps + 8);
                } else {
                    name = this._war;
                }
            } else if (getResourceBase() != null) {
                name = getResourceBase();
                int webapps2 = name.indexOf("/webapps/");
                if (webapps2 >= 0) {
                    name = name.substring(webapps2 + 8);
                }
            } else {
                name = getClass().getSimpleName();
            }
        }
        String name2 = String.format("%s@%x", name, Integer.valueOf(hashCode()));
        dumpObjects(out, indent, new ClassLoaderDump(getClassLoader()), new DumpableCollection("Systemclasses " + name2, systemClasses), new DumpableCollection("Serverclasses " + name2, serverClasses), new DumpableCollection("Configurations " + name2, this._configurations), new DumpableCollection("Handler attributes " + name2, ((AttributesMap) getAttributes()).getAttributeEntrySet()), new DumpableCollection("Context attributes " + name2, getServletContext().getAttributeEntrySet()), new DumpableCollection("EventListeners " + this, Arrays.asList(getEventListeners())), new DumpableCollection("Initparams " + name2, getInitParams().entrySet()));
    }

    public void setConfigurationClasses(String[] configurations) {
        if (isStarted()) {
            throw new IllegalStateException();
        }
        this._configurationClasses.clear();
        if (configurations != null) {
            this._configurationClasses.addAll(Arrays.asList(configurations));
        }
        this._configurations.clear();
    }

    public void setConfigurationClasses(List<String> configurations) {
        setConfigurationClasses((String[]) configurations.toArray(new String[0]));
    }

    public void setConfigurations(Configuration[] configurations) {
        if (isStarted()) {
            throw new IllegalStateException();
        }
        this._configurations.clear();
        if (configurations != null) {
            this._configurations.addAll(Arrays.asList(configurations));
        }
    }

    public void setDefaultsDescriptor(String defaultsDescriptor) {
        this._defaultsDescriptor = defaultsDescriptor;
    }

    public void setOverrideDescriptor(String overrideDescriptor) {
        this._overrideDescriptors.clear();
        this._overrideDescriptors.add(overrideDescriptor);
    }

    public void setOverrideDescriptors(List<String> overrideDescriptors) {
        this._overrideDescriptors.clear();
        this._overrideDescriptors.addAll(overrideDescriptors);
    }

    public void addOverrideDescriptor(String overrideDescriptor) {
        this._overrideDescriptors.add(overrideDescriptor);
    }

    @ManagedAttribute(value = "standard web.xml descriptor", readonly = true)
    public String getDescriptor() {
        return this._descriptor;
    }

    public void setDescriptor(String descriptor) {
        this._descriptor = descriptor;
    }

    public void setDistributable(boolean distributable) {
        this._distributable = distributable;
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler
    public void setEventListeners(EventListener[] eventListeners) {
        if (this._sessionHandler != null) {
            this._sessionHandler.clearEventListeners();
        }
        setEventListeners(eventListeners);
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler
    public void removeEventListener(EventListener listener) {
        removeEventListener(listener);
        if (((listener instanceof HttpSessionActivationListener) || (listener instanceof HttpSessionAttributeListener) || (listener instanceof HttpSessionBindingListener) || (listener instanceof HttpSessionListener) || (listener instanceof HttpSessionIdListener)) && this._sessionHandler != null) {
            this._sessionHandler.removeEventListener(listener);
        }
    }

    public void setExtractWAR(boolean extractWAR) {
        this._extractWAR = extractWAR;
    }

    public void setCopyWebDir(boolean copy) {
        this._copyDir = copy;
    }

    public void setCopyWebInf(boolean copyWebInf) {
        this._copyWebInf = copyWebInf;
    }

    public void setParentLoaderPriority(boolean java2compliant) {
        this._parentLoaderPriority = java2compliant;
    }

    public void setPermissions(PermissionCollection permissions) {
        this._permissions = permissions;
    }

    public void setContextWhiteList(String[] contextWhiteList) {
        this._contextWhiteList = contextWhiteList;
    }

    public void setServerClasses(String[] serverClasses) {
        this._serverClasses = new ClasspathPattern(serverClasses);
    }

    public void setSystemClasses(String[] systemClasses) {
        this._systemClasses = new ClasspathPattern(systemClasses);
    }

    public void setTempDirectory(File dir) {
        if (isStarted()) {
            throw new IllegalStateException("Started");
        }
        if (dir != null) {
            try {
                dir = new File(dir.getCanonicalPath());
            } catch (IOException e) {
                LOG.warn(Log.EXCEPTION, e);
            }
        }
        this._tmpDir = dir;
        setAttribute("javax.servlet.context.tempdir", this._tmpDir);
    }

    @ManagedAttribute(value = "temporary directory location", readonly = true)
    public File getTempDirectory() {
        return this._tmpDir;
    }

    public void setPersistTempDirectory(boolean persist) {
        this._persistTmpDir = persist;
    }

    public boolean isPersistTempDirectory() {
        return this._persistTmpDir;
    }

    public void setWar(String war) {
        this._war = war;
    }

    public void setWarResource(Resource war) {
        setWar(war == null ? null : war.toString());
    }

    @Override // org.eclipse.jetty.webapp.WebAppClassLoader.Context
    @ManagedAttribute(value = "extra classpath for context classloader", readonly = true)
    public String getExtraClasspath() {
        return this._extraClasspath;
    }

    public void setExtraClasspath(String extraClasspath) {
        this._extraClasspath = extraClasspath;
    }

    public boolean isLogUrlOnStart() {
        return this._logUrlOnStart;
    }

    public void setLogUrlOnStart(boolean logOnStart) {
        this._logUrlOnStart = logOnStart;
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler, org.eclipse.jetty.server.handler.AbstractHandlerContainer, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void setServer(Server server) {
        setServer(server);
    }

    public boolean isAllowDuplicateFragmentNames() {
        return this._allowDuplicateFragmentNames;
    }

    public void setAllowDuplicateFragmentNames(boolean allowDuplicateFragmentNames) {
        this._allowDuplicateFragmentNames = allowDuplicateFragmentNames;
    }

    public void setThrowUnavailableOnStartupException(boolean throwIfStartupException) {
        this._throwUnavailableOnStartupException = throwIfStartupException;
    }

    public boolean isThrowUnavailableOnStartupException() {
        return this._throwUnavailableOnStartupException;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.servlet.ServletContextHandler, org.eclipse.jetty.server.handler.ContextHandler
    public void startContext() throws Exception {
        configure();
        this._metadata.resolve(this);
        startWebapp();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.servlet.ServletContextHandler, org.eclipse.jetty.server.handler.ContextHandler
    public void stopContext() throws Exception {
        stopWebapp();
        try {
            int i = this._configurations.size();
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                this._configurations.get(i).deconfigure(this);
            }
            if (this._metadata != null) {
                this._metadata.clear();
            }
            this._metadata = new MetaData();
        } finally {
            if (this._ownClassLoader) {
                ClassLoader loader = getClassLoader();
                if (loader instanceof URLClassLoader) {
                    ((URLClassLoader) loader).close();
                }
                setClassLoader(null);
            }
            this._unavailableException = null;
        }
    }

    protected void startWebapp() throws Exception {
        startContext();
    }

    protected void stopWebapp() throws Exception {
        stopContext();
    }

    @Override // org.eclipse.jetty.servlet.ServletContextHandler
    public Set<String> setServletSecurity(ServletRegistration.Dynamic registration, ServletSecurityElement servletSecurityElement) {
        Set<String> unchangedURLMappings = new HashSet<>();
        Collection<String> pathMappings = registration.getMappings();
        if (pathMappings != null) {
            ConstraintSecurityHandler.createConstraint(registration.getName(), servletSecurityElement);
            for (String pathSpec : pathMappings) {
                switch (getMetaData().getOrigin("constraint.url." + pathSpec)) {
                    case NotSet:
                        for (ConstraintMapping m : ConstraintSecurityHandler.createConstraintsWithMappingsForPath(registration.getName(), pathSpec, servletSecurityElement)) {
                            ((ConstraintAware) getSecurityHandler()).addConstraintMapping(m);
                        }
                        ((ConstraintAware) getSecurityHandler()).checkPathsWithUncoveredHttpMethods();
                        getMetaData().setOriginAPI("constraint.url." + pathSpec);
                        break;
                    case WebXml:
                    case WebDefaults:
                    case WebOverride:
                    case WebFragment:
                        unchangedURLMappings.add(pathSpec);
                        break;
                    case Annotation:
                    case API:
                        List<ConstraintMapping> constraintMappings = ConstraintSecurityHandler.removeConstraintMappingsForPath(pathSpec, ((ConstraintAware) getSecurityHandler()).getConstraintMappings());
                        constraintMappings.addAll(ConstraintSecurityHandler.createConstraintsWithMappingsForPath(registration.getName(), pathSpec, servletSecurityElement));
                        ((ConstraintSecurityHandler) getSecurityHandler()).setConstraintMappings(constraintMappings);
                        ((ConstraintAware) getSecurityHandler()).checkPathsWithUncoveredHttpMethods();
                        break;
                }
            }
        }
        return unchangedURLMappings;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/WebAppContext$Context.class */
    public class Context extends ServletContextHandler.Context {
        public Context() {
            super();
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.Context
        public void checkListener(Class<? extends EventListener> listener) throws IllegalStateException {
            try {
                checkListener(listener);
            } catch (IllegalArgumentException e) {
                boolean ok = false;
                Class<?>[] clsArr = SessionHandler.SESSION_LISTENER_TYPES;
                int length = clsArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (clsArr[i].isAssignableFrom(listener)) {
                        ok = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!ok) {
                    throw new IllegalArgumentException("Inappropriate listener type " + listener.getName());
                }
            }
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.Context, org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public URL getResource(String path) throws MalformedURLException {
            Resource resource;
            if (path == null || (resource = WebAppContext.this.getResource(path)) == null || !resource.exists()) {
                return null;
            }
            if (resource.isDirectory() && (resource instanceof ResourceCollection) && !WebAppContext.this.isExtractWAR()) {
                Resource[] resources = ((ResourceCollection) resource).getResources();
                int i = resources.length;
                do {
                    i--;
                    if (i > 0) {
                    }
                } while (!resources[i].getName().startsWith("jar:file"));
                return resources[i].getURI().toURL();
            }
            return resource.getURI().toURL();
        }

        @Override // org.eclipse.jetty.server.handler.ContextHandler.Context, org.eclipse.jetty.server.handler.ContextHandler.StaticContext, javax.servlet.ServletContext
        public ServletContext getContext(String uripath) {
            ServletContext servletContext = getContext(uripath);
            if (servletContext == null || WebAppContext.this._contextWhiteList == null) {
                return servletContext;
            }
            for (String context : WebAppContext.this._contextWhiteList) {
                if (context.equals(uripath)) {
                    return servletContext;
                }
            }
            return null;
        }
    }

    public MetaData getMetaData() {
        return this._metadata;
    }

    public static void addServerClasses(Server server, String... pattern) {
        String[] serverClasses;
        if (pattern != null && pattern.length != 0) {
            Object o = server.getAttribute(SERVER_SRV_CLASSES);
            if (o instanceof ClasspathPattern) {
                ((ClasspathPattern) o).add(pattern);
                return;
            }
            if (o instanceof String[]) {
                serverClasses = (String[]) o;
            } else {
                serverClasses = __dftServerClasses;
            }
            int l = serverClasses.length;
            String[] serverClasses2 = (String[]) Arrays.copyOf(serverClasses, l + pattern.length);
            System.arraycopy(pattern, 0, serverClasses2, l, pattern.length);
            server.setAttribute(SERVER_SRV_CLASSES, serverClasses2);
        }
    }

    public static void addSystemClasses(Server server, String... pattern) {
        String[] systemClasses;
        if (pattern != null && pattern.length != 0) {
            Object o = server.getAttribute(SERVER_SYS_CLASSES);
            if (o instanceof ClasspathPattern) {
                ((ClasspathPattern) o).add(pattern);
                return;
            }
            if (o instanceof String[]) {
                systemClasses = (String[]) o;
            } else {
                systemClasses = __dftSystemClasses;
            }
            int l = systemClasses.length;
            String[] systemClasses2 = (String[]) Arrays.copyOf(systemClasses, l + pattern.length);
            System.arraycopy(pattern, 0, systemClasses2, l, pattern.length);
            server.setAttribute(SERVER_SYS_CLASSES, systemClasses2);
        }
    }
}
