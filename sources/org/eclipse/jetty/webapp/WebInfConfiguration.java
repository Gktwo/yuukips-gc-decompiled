package org.eclipse.jetty.webapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.NetworkConnector;
import org.eclipse.jetty.util.C5739IO;
import org.eclipse.jetty.util.JavaVersion;
import org.eclipse.jetty.util.PatternMatcher;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.JarFileResource;
import org.eclipse.jetty.util.resource.JarResource;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceCollection;
import org.quartz.xml.XMLSchedulingDataProcessor;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/WebInfConfiguration.class */
public class WebInfConfiguration extends AbstractConfiguration {
    private static final Logger LOG = Log.getLogger(WebInfConfiguration.class);
    public static final String TEMPDIR_CONFIGURED = "org.eclipse.jetty.tmpdirConfigured";
    public static final String CONTAINER_JAR_PATTERN = "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern";
    public static final String WEBINF_JAR_PATTERN = "org.eclipse.jetty.server.webapp.WebInfIncludeJarPattern";
    public static final String RESOURCE_DIRS = "org.eclipse.jetty.resources";
    protected Resource _preUnpackBaseResource;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/WebInfConfiguration$ContainerPathNameMatcher.class */
    public class ContainerPathNameMatcher extends PatternMatcher {
        protected final WebAppContext _context;
        protected final Pattern _pattern;

        public ContainerPathNameMatcher(WebAppContext context, Pattern pattern) {
            if (context == null) {
                throw new IllegalArgumentException("Context null");
            }
            this._context = context;
            this._pattern = pattern;
        }

        public void match(List<URI> uris) throws Exception {
            if (uris != null) {
                match(this._pattern, (URI[]) uris.toArray(new URI[uris.size()]), false);
            }
        }

        @Override // org.eclipse.jetty.util.PatternMatcher
        public void matched(URI uri) throws Exception {
            this._context.getMetaData().addContainerResource(Resource.newResource(uri));
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/WebInfConfiguration$WebAppPathNameMatcher.class */
    public class WebAppPathNameMatcher extends PatternMatcher {
        protected final WebAppContext _context;
        protected final Pattern _pattern;

        public WebAppPathNameMatcher(WebAppContext context, Pattern pattern) {
            if (context == null) {
                throw new IllegalArgumentException("Context null");
            }
            this._context = context;
            this._pattern = pattern;
        }

        public void match(List<URI> uris) throws Exception {
            match(this._pattern, (URI[]) uris.toArray(new URI[uris.size()]), true);
        }

        @Override // org.eclipse.jetty.util.PatternMatcher
        public void matched(URI uri) throws Exception {
            this._context.getMetaData().addWebInfJar(Resource.newResource(uri));
        }
    }

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void preConfigure(WebAppContext context) throws Exception {
        resolveTempDirectory(context);
        unpack(context);
        findAndFilterContainerPaths(context);
        findAndFilterWebAppPaths(context);
        context.getMetaData().setWebInfClassesDirs(findClassDirs(context));
    }

    public void findAndFilterContainerPaths(WebAppContext context) throws Exception {
        String tmp;
        String tmp2;
        int currentPlatform = JavaVersion.VERSION.getPlatform();
        int targetPlatform = currentPlatform;
        Object target = context.getAttribute(JavaVersion.JAVA_TARGET_PLATFORM);
        if (target != null) {
            targetPlatform = Integer.parseInt(target.toString());
        }
        String tmp3 = (String) context.getAttribute(CONTAINER_JAR_PATTERN);
        ContainerPathNameMatcher containerPathNameMatcher = new ContainerPathNameMatcher(context, tmp3 == null ? null : Pattern.compile(tmp3));
        ClassLoader loader = null;
        if (context.getClassLoader() != null) {
            loader = context.getClassLoader().getParent();
        }
        List<URI> containerUris = new ArrayList<>();
        while (loader instanceof URLClassLoader) {
            URL[] urls = ((URLClassLoader) loader).getURLs();
            if (urls != null) {
                for (URL u : urls) {
                    try {
                        containerUris.add(u.toURI());
                    } catch (URISyntaxException e) {
                        containerUris.add(new URI(URIUtil.encodeSpaces(u.toString())));
                    }
                }
            }
            loader = loader.getParent();
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Matching container urls {}", containerUris);
        }
        containerPathNameMatcher.match(containerUris);
        if (currentPlatform >= 9 && (tmp2 = System.getProperty("java.class.path")) != null) {
            List<URI> cpUris = new ArrayList<>();
            for (String entry : tmp2.split(File.pathSeparator)) {
                cpUris.add(new File(entry).toURI());
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Matching java.class.path {}", cpUris);
            }
            containerPathNameMatcher.match(cpUris);
        }
        if (targetPlatform >= 9 && (tmp = System.getProperty("jdk.module.path")) != null) {
            List<URI> moduleUris = new ArrayList<>();
            for (String entry2 : tmp.split(File.pathSeparator)) {
                File file = new File(entry2);
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    if (files != null) {
                        for (File f : files) {
                            moduleUris.add(f.toURI());
                        }
                    }
                } else {
                    moduleUris.add(file.toURI());
                }
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Matching jdk.module.path {}", moduleUris);
            }
            containerPathNameMatcher.match(moduleUris);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Container paths selected:{}", context.getMetaData().getContainerResources());
        }
    }

    public void findAndFilterWebAppPaths(WebAppContext context) throws Exception {
        String tmp = (String) context.getAttribute(WEBINF_JAR_PATTERN);
        WebAppPathNameMatcher matcher = new WebAppPathNameMatcher(context, tmp == null ? null : Pattern.compile(tmp));
        List<Resource> jars = findJars(context);
        if (jars != null) {
            List<URI> uris = new ArrayList<>();
            for (Resource r : jars) {
                uris.add(r.getURI());
            }
            matcher.match(uris);
        }
    }

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void configure(WebAppContext context) throws Exception {
        if (!context.isStarted()) {
            Resource webInf = context.getWebInf();
            if (webInf != null && webInf.isDirectory() && (context.getClassLoader() instanceof WebAppClassLoader)) {
                Resource classes = webInf.addPath("classes/");
                if (classes.exists()) {
                    ((WebAppClassLoader) context.getClassLoader()).addClassPath(classes);
                }
                Resource lib = webInf.addPath("lib/");
                if (lib.exists() || lib.isDirectory()) {
                    ((WebAppClassLoader) context.getClassLoader()).addJars(lib);
                }
            }
            Set<Resource> resources = (Set) context.getAttribute("org.eclipse.jetty.resources");
            if (!(resources == null || resources.isEmpty())) {
                Resource[] collection = new Resource[resources.size() + 1];
                int i = 0 + 1;
                collection[0] = context.getBaseResource();
                for (Resource resource : resources) {
                    i++;
                    collection[i] = resource;
                }
                context.setBaseResource(new ResourceCollection(collection));
            }
        } else if (LOG.isDebugEnabled()) {
            LOG.debug("Cannot configure webapp " + context + " after it is started", new Object[0]);
        }
    }

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void deconfigure(WebAppContext context) throws Exception {
        File tempDirectory = context.getTempDirectory();
        if (!context.isPersistTempDirectory()) {
            C5739IO.delete(tempDirectory);
        }
        Boolean tmpdirConfigured = (Boolean) context.getAttribute(TEMPDIR_CONFIGURED);
        if (tmpdirConfigured != null && !tmpdirConfigured.booleanValue()) {
            context.setTempDirectory(null);
        }
        if (context.getBaseResource() != null) {
            context.getBaseResource().close();
        }
        context.setBaseResource(this._preUnpackBaseResource);
    }

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void cloneConfigure(WebAppContext template, WebAppContext context) throws Exception {
        File tmpDirAsFile = Files.createTempDirectory(template.getTempDirectory().getParentFile().toPath(), getCanonicalNameForWebAppTmpDir(context), new FileAttribute[0]).toFile();
        tmpDirAsFile.deleteOnExit();
        context.setTempDirectory(tmpDirAsFile);
    }

    public void resolveTempDirectory(WebAppContext context) throws Exception {
        File tmpDir = context.getTempDirectory();
        if (tmpDir != null) {
            configureTempDirectory(tmpDir, context);
            context.setAttribute(TEMPDIR_CONFIGURED, Boolean.TRUE);
            return;
        }
        File servletTmpDir = asFile(context.getAttribute("javax.servlet.context.tempdir"));
        if (servletTmpDir != null) {
            configureTempDirectory(servletTmpDir, context);
            context.setAttribute("javax.servlet.context.tempdir", servletTmpDir);
            context.setTempDirectory(servletTmpDir);
            return;
        }
        File baseTemp = asFile(context.getAttribute(WebAppContext.BASETEMPDIR));
        if (baseTemp == null) {
            File jettyBase = asFile(System.getProperty("jetty.base"));
            if (jettyBase != null) {
                File work = new File(jettyBase, "work");
                if (work.exists() && work.isDirectory() && work.canWrite()) {
                    context.setPersistTempDirectory(true);
                    makeTempDirectory(work, context);
                    return;
                }
            }
            makeTempDirectory(new File(System.getProperty("java.io.tmpdir")), context);
        } else if (!baseTemp.isDirectory() || !baseTemp.canWrite()) {
            throw new IllegalStateException("BASETEMPDIR is not a writable directory");
        } else {
            makeTempDirectory(baseTemp, context);
        }
    }

    private File asFile(Object fileattr) {
        if (fileattr == null) {
            return null;
        }
        if (fileattr instanceof File) {
            return (File) fileattr;
        }
        if (fileattr instanceof String) {
            return new File((String) fileattr);
        }
        if (fileattr instanceof Path) {
            return ((Path) fileattr).toFile();
        }
        return null;
    }

    public void makeTempDirectory(File parent, WebAppContext context) throws Exception {
        File tmpDir;
        if (parent == null || !parent.exists() || !parent.canWrite() || !parent.isDirectory()) {
            throw new IllegalStateException("Parent for temp dir not configured correctly: " + (parent == null ? "null" : "writeable=" + parent.canWrite()));
        }
        String temp = getCanonicalNameForWebAppTmpDir(context);
        if (context.isPersistTempDirectory()) {
            tmpDir = new File(parent, temp);
            configureTempDirectory(tmpDir, context);
        } else {
            tmpDir = Files.createTempDirectory(parent.toPath(), temp, new FileAttribute[0]).toFile();
            tmpDir.deleteOnExit();
            ensureTempDirUsable(tmpDir);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Set temp dir " + tmpDir, new Object[0]);
        }
        context.setTempDirectory(tmpDir);
    }

    public void configureTempDirectory(File dir, WebAppContext context) {
        if (dir == null) {
            throw new IllegalArgumentException("Null temp dir");
        } else if (!context.isPersistTempDirectory() && dir.exists() && !C5739IO.delete(dir)) {
            throw new IllegalStateException("Failed to delete temp dir " + dir);
        } else if (dir.exists() || dir.mkdirs()) {
            if (!context.isPersistTempDirectory()) {
                dir.deleteOnExit();
            }
            ensureTempDirUsable(dir);
        } else {
            throw new IllegalStateException("Unable to create temp dir " + dir);
        }
    }

    private void ensureTempDirUsable(File dir) {
        if (!dir.canWrite() || !dir.isDirectory()) {
            throw new IllegalStateException("Temp dir " + dir + " not useable: writeable=" + dir.canWrite() + ", dir=" + dir.isDirectory());
        }
    }

    public void unpack(WebAppContext context) throws IOException {
        File warfile;
        Resource webApp = context.getBaseResource();
        this._preUnpackBaseResource = context.getBaseResource();
        if (webApp == null) {
            String war = context.getWar();
            if (war == null || war.length() <= 0) {
                webApp = context.getBaseResource();
            } else {
                webApp = context.newResource(war);
            }
            if (webApp == null) {
                throw new IllegalStateException("No resourceBase or war set for context");
            }
            if (webApp.isAlias()) {
                LOG.debug(webApp + " anti-aliased to " + webApp.getAlias(), new Object[0]);
                webApp = context.newResource(webApp.getAlias());
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Try webapp=" + webApp + ", exists=" + webApp.exists() + ", directory=" + webApp.isDirectory() + " file=" + webApp.getFile(), new Object[0]);
            }
            if (webApp.exists() && !webApp.isDirectory() && !webApp.toString().startsWith(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX)) {
                Resource jarWebApp = JarResource.newJarResource(webApp);
                if (jarWebApp.exists() && jarWebApp.isDirectory()) {
                    webApp = jarWebApp;
                }
            }
            if (webApp.exists() && ((context.isCopyWebDir() && webApp.getFile() != null && webApp.getFile().isDirectory()) || ((context.isExtractWAR() && webApp.getFile() != null && !webApp.getFile().isDirectory()) || ((context.isExtractWAR() && webApp.getFile() == null) || !webApp.isDirectory())))) {
                File extractedWebAppDir = null;
                if (!(war == null || (warfile = Resource.newResource(war).getFile()) == null || !warfile.getName().toLowerCase(Locale.ENGLISH).endsWith(".war"))) {
                    File sibling = new File(warfile.getParent(), warfile.getName().substring(0, warfile.getName().length() - 4));
                    if (sibling.exists() && sibling.isDirectory() && sibling.canWrite()) {
                        extractedWebAppDir = sibling;
                    }
                }
                if (extractedWebAppDir == null) {
                    extractedWebAppDir = new File(context.getTempDirectory(), "webapp");
                }
                if (webApp.getFile() == null || !webApp.getFile().isDirectory()) {
                    File extractionLock = new File(context.getTempDirectory(), ".extract_lock");
                    if (!extractedWebAppDir.exists()) {
                        extractionLock.createNewFile();
                        extractedWebAppDir.mkdir();
                        LOG.debug("Extract " + webApp + " to " + extractedWebAppDir, new Object[0]);
                        JarResource.newJarResource(webApp).copyTo(extractedWebAppDir);
                        extractionLock.delete();
                    } else if (webApp.lastModified() > extractedWebAppDir.lastModified() || extractionLock.exists()) {
                        extractionLock.createNewFile();
                        C5739IO.delete(extractedWebAppDir);
                        extractedWebAppDir.mkdir();
                        LOG.debug("Extract " + webApp + " to " + extractedWebAppDir, new Object[0]);
                        JarResource.newJarResource(webApp).copyTo(extractedWebAppDir);
                        extractionLock.delete();
                    }
                } else {
                    LOG.debug("Copy " + webApp + " to " + extractedWebAppDir, new Object[0]);
                    webApp.copyTo(extractedWebAppDir);
                }
                webApp = Resource.newResource(extractedWebAppDir.getCanonicalPath());
            }
            if (!webApp.exists() || !webApp.isDirectory()) {
                LOG.warn("Web application not found " + war, new Object[0]);
                throw new FileNotFoundException(war);
            }
            context.setBaseResource(webApp);
            if (LOG.isDebugEnabled()) {
                LOG.debug("webapp=" + webApp, new Object[0]);
            }
        }
        if (context.isCopyWebInf() && !context.isCopyWebDir()) {
            Resource webInf = webApp.addPath("WEB-INF/");
            File extractedWebInfDir = new File(context.getTempDirectory(), "webinf");
            if (extractedWebInfDir.exists()) {
                C5739IO.delete(extractedWebInfDir);
            }
            extractedWebInfDir.mkdir();
            Resource webInfLib = webInf.addPath("lib/");
            File webInfDir = new File(extractedWebInfDir, "WEB-INF");
            webInfDir.mkdir();
            if (webInfLib.exists()) {
                File webInfLibDir = new File(webInfDir, "lib");
                if (webInfLibDir.exists()) {
                    C5739IO.delete(webInfLibDir);
                }
                webInfLibDir.mkdir();
                LOG.debug("Copying WEB-INF/lib " + webInfLib + " to " + webInfLibDir, new Object[0]);
                webInfLib.copyTo(webInfLibDir);
            }
            Resource webInfClasses = webInf.addPath("classes/");
            if (webInfClasses.exists()) {
                File webInfClassesDir = new File(webInfDir, "classes");
                if (webInfClassesDir.exists()) {
                    C5739IO.delete(webInfClassesDir);
                }
                webInfClassesDir.mkdir();
                LOG.debug("Copying WEB-INF/classes from " + webInfClasses + " to " + webInfClassesDir.getAbsolutePath(), new Object[0]);
                webInfClasses.copyTo(webInfClassesDir);
            }
            ResourceCollection rc = new ResourceCollection(Resource.newResource(extractedWebInfDir.getCanonicalPath()), webApp);
            if (LOG.isDebugEnabled()) {
                LOG.debug("context.resourcebase = " + rc, new Object[0]);
            }
            context.setBaseResource(rc);
        }
    }

    public static String getCanonicalNameForWebAppTmpDir(WebAppContext context) {
        StringBuffer canonicalName = new StringBuffer();
        canonicalName.append("jetty-");
        if (context.getServer() != null) {
            Connector[] connectors = context.getServer().getConnectors();
            if (connectors.length > 0) {
                String host = null;
                int port = 0;
                if (connectors != null && (connectors[0] instanceof NetworkConnector)) {
                    NetworkConnector connector = (NetworkConnector) connectors[0];
                    host = connector.getHost();
                    port = connector.getLocalPort();
                    if (port < 0) {
                        port = connector.getPort();
                    }
                }
                if (host == null) {
                    host = "0.0.0.0";
                }
                canonicalName.append(host);
                canonicalName.append("-");
                canonicalName.append(port);
                canonicalName.append("-");
            }
        }
        try {
            Resource resource = context.getBaseResource();
            if (resource == null) {
                if (context.getWar() == null || context.getWar().length() == 0) {
                    throw new IllegalStateException("No resourceBase or war set for context");
                }
                resource = context.newResource(context.getWar());
            }
            canonicalName.append(getResourceBaseName(resource));
            canonicalName.append("-");
        } catch (Exception e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Can't get resource base name", e);
            }
            canonicalName.append("-");
        }
        canonicalName.append(context.getContextPath());
        canonicalName.append("-");
        String[] vhosts = context.getVirtualHosts();
        if (vhosts == null || vhosts.length <= 0) {
            canonicalName.append("any");
        } else {
            canonicalName.append(vhosts[0]);
        }
        canonicalName.append("-");
        return StringUtil.sanitizeFileSystemName(canonicalName.toString());
    }

    protected static String getResourceBaseName(Resource resource) {
        try {
            File resourceFile = resource.getFile();
            if (resourceFile != null && (resource instanceof JarFileResource)) {
                resourceFile = ((JarFileResource) resource).getJarFile();
            }
            if (resourceFile != null) {
                return resourceFile.getName();
            }
        } catch (IOException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Resource has no File reference: {}", resource);
            }
        }
        URI uri = resource.getURI();
        if (uri != null) {
            return URIUtil.getUriLastPathSegment(uri);
        }
        if (!LOG.isDebugEnabled()) {
            return "";
        }
        LOG.debug("Resource has no URI reference: {}", resource);
        return "";
    }

    protected List<Resource> findClassDirs(WebAppContext context) throws Exception {
        if (context == null) {
            return null;
        }
        List<Resource> classDirs = new ArrayList<>();
        Resource webInfClasses = findWebInfClassesDir(context);
        if (webInfClasses != null) {
            classDirs.add(webInfClasses);
        }
        List<Resource> extraClassDirs = findExtraClasspathDirs(context);
        if (extraClassDirs != null) {
            classDirs.addAll(extraClassDirs);
        }
        return classDirs;
    }

    protected List<Resource> findJars(WebAppContext context) throws Exception {
        List<Resource> jarResources = new ArrayList<>();
        List<Resource> webInfLibJars = findWebInfLibJars(context);
        if (webInfLibJars != null) {
            jarResources.addAll(webInfLibJars);
        }
        List<Resource> extraClasspathJars = findExtraClasspathJars(context);
        if (extraClasspathJars != null) {
            jarResources.addAll(extraClasspathJars);
        }
        return jarResources;
    }

    protected List<Resource> findWebInfLibJars(WebAppContext context) throws Exception {
        Resource webInf = context.getWebInf();
        if (webInf == null || !webInf.exists()) {
            return null;
        }
        List<Resource> jarResources = new ArrayList<>();
        Resource webInfLib = webInf.addPath("/lib");
        if (webInfLib.exists() && webInfLib.isDirectory()) {
            String[] files = webInfLib.list();
            if (files != null) {
                Arrays.sort(files);
            }
            int f = 0;
            while (files != null && f < files.length) {
                try {
                    Resource file = webInfLib.addPath(files[f]);
                    String fnlc = file.getName().toLowerCase(Locale.ENGLISH);
                    int dot = fnlc.lastIndexOf(46);
                    String extension = dot < 0 ? null : fnlc.substring(dot);
                    if (extension != null && (extension.equals(".jar") || extension.equals(".zip"))) {
                        jarResources.add(file);
                    }
                } catch (Exception ex) {
                    LOG.warn(Log.EXCEPTION, ex);
                }
                f++;
            }
        }
        return jarResources;
    }

    protected List<Resource> findExtraClasspathJars(WebAppContext context) throws Exception {
        String[] entries;
        if (context == null || context.getExtraClasspath() == null) {
            return null;
        }
        List<Resource> jarResources = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(context.getExtraClasspath(), ",;");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (isGlobReference(token)) {
                Resource dirResource = context.newResource(token.substring(0, token.length() - 2));
                if (dirResource.exists() && dirResource.isDirectory() && (entries = dirResource.list()) != null) {
                    Arrays.sort(entries);
                    for (String entry : entries) {
                        try {
                            Resource fileResource = dirResource.addPath(entry);
                            if (isFileSupported(fileResource)) {
                                jarResources.add(fileResource);
                            }
                        } catch (Exception ex) {
                            LOG.warn(Log.EXCEPTION, ex);
                        }
                    }
                }
            } else {
                Resource resource = context.newResource(token);
                if (isFileSupported(resource)) {
                    jarResources.add(resource);
                }
            }
        }
        return jarResources;
    }

    protected Resource findWebInfClassesDir(WebAppContext context) throws Exception {
        Resource webInf;
        if (context == null || (webInf = context.getWebInf()) == null || !webInf.isDirectory()) {
            return null;
        }
        Resource classes = webInf.addPath("classes/");
        if (classes.exists()) {
            return classes;
        }
        return null;
    }

    protected List<Resource> findExtraClasspathDirs(WebAppContext context) throws Exception {
        if (context == null || context.getExtraClasspath() == null) {
            return null;
        }
        List<Resource> dirResources = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(context.getExtraClasspath(), ",;");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!isGlobReference(token)) {
                Resource resource = context.newResource(token);
                if (resource.exists() && resource.isDirectory()) {
                    dirResources.add(resource);
                }
            }
        }
        return dirResources;
    }

    private boolean isGlobReference(String token) {
        return token.endsWith("/*") || token.endsWith("\\*");
    }

    private boolean isFileSupported(Resource resource) {
        String filenameLowercase = resource.getName().toLowerCase(Locale.ENGLISH);
        int dot = filenameLowercase.lastIndexOf(46);
        String extension = dot < 0 ? null : filenameLowercase.substring(dot);
        return extension != null && (extension.equals(".jar") || extension.equals(".zip"));
    }
}
