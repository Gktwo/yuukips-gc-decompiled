package org.eclipse.jetty.webapp;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.EmptyResource;
import org.eclipse.jetty.util.resource.Resource;
import org.quartz.xml.XMLSchedulingDataProcessor;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/MetaInfConfiguration.class */
public class MetaInfConfiguration extends AbstractConfiguration {
    public static final String USE_CONTAINER_METAINF_CACHE = "org.eclipse.jetty.metainf.useCache";
    public static final boolean DEFAULT_USE_CONTAINER_METAINF_CACHE = true;
    public static final String CACHED_CONTAINER_TLDS = "org.eclipse.jetty.tlds.cache";
    public static final String CACHED_CONTAINER_FRAGMENTS = "org.eclipse.jetty.webFragments.cache";
    public static final String CACHED_CONTAINER_RESOURCES = "org.eclipse.jetty.resources.cache";
    public static final String METAINF_FRAGMENTS = "org.eclipse.jetty.webFragments";
    public static final String METAINF_RESOURCES = "org.eclipse.jetty.resources";
    private static final Logger LOG = Log.getLogger(MetaInfConfiguration.class);
    public static final String METAINF_TLDS = "org.eclipse.jetty.tlds";
    public static final List<String> __allScanTypes = Arrays.asList(METAINF_TLDS, "org.eclipse.jetty.resources", "org.eclipse.jetty.webFragments");

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void preConfigure(WebAppContext context) throws Exception {
        Boolean attr;
        boolean useContainerCache = true;
        if (!(context.getServer() == null || (attr = (Boolean) context.getServer().getAttribute(USE_CONTAINER_METAINF_CACHE)) == null)) {
            useContainerCache = attr.booleanValue();
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} = {}", USE_CONTAINER_METAINF_CACHE, Boolean.valueOf(useContainerCache));
        }
        if (context.getAttribute(METAINF_TLDS) == null) {
            context.setAttribute(METAINF_TLDS, new HashSet());
        }
        if (context.getAttribute("org.eclipse.jetty.resources") == null) {
            context.setAttribute("org.eclipse.jetty.resources", new HashSet());
        }
        if (context.getAttribute("org.eclipse.jetty.webFragments") == null) {
            context.setAttribute("org.eclipse.jetty.webFragments", new HashMap());
        }
        scanJars(context, context.getMetaData().getContainerResources(), useContainerCache, __allScanTypes);
        List<String> scanTypes = new ArrayList<>(__allScanTypes);
        if (context.getMetaData().isMetaDataComplete() || (context.getServletContext().getEffectiveMajorVersion() < 3 && !context.isConfigurationDiscovered())) {
            scanTypes.remove("org.eclipse.jetty.webFragments");
        }
        scanJars(context, context.getMetaData().getWebInfJars(), false, scanTypes);
    }

    public void scanJars(WebAppContext context, Collection<Resource> jars, boolean useCaches) throws Exception {
        scanJars(context, jars, useCaches, __allScanTypes);
    }

    public void scanJars(WebAppContext context, Collection<Resource> jars, boolean useCaches, List<String> scanTypes) throws Exception {
        ConcurrentHashMap<Resource, Resource> metaInfResourceCache = null;
        ConcurrentHashMap<Resource, Resource> metaInfFragmentCache = null;
        ConcurrentHashMap<Resource, Collection<URL>> metaInfTldCache = null;
        if (useCaches) {
            metaInfResourceCache = (ConcurrentHashMap) context.getServer().getAttribute(CACHED_CONTAINER_RESOURCES);
            if (metaInfResourceCache == null) {
                metaInfResourceCache = new ConcurrentHashMap<>();
                context.getServer().setAttribute(CACHED_CONTAINER_RESOURCES, metaInfResourceCache);
            }
            metaInfFragmentCache = (ConcurrentHashMap) context.getServer().getAttribute(CACHED_CONTAINER_FRAGMENTS);
            if (metaInfFragmentCache == null) {
                metaInfFragmentCache = new ConcurrentHashMap<>();
                context.getServer().setAttribute(CACHED_CONTAINER_FRAGMENTS, metaInfFragmentCache);
            }
            metaInfTldCache = (ConcurrentHashMap) context.getServer().getAttribute(CACHED_CONTAINER_TLDS);
            if (metaInfTldCache == null) {
                metaInfTldCache = new ConcurrentHashMap<>();
                context.getServer().setAttribute(CACHED_CONTAINER_TLDS, metaInfTldCache);
            }
        }
        if (jars != null) {
            for (Resource r : jars) {
                if (scanTypes.contains("org.eclipse.jetty.resources")) {
                    scanForResources(context, r, metaInfResourceCache);
                }
                if (scanTypes.contains("org.eclipse.jetty.webFragments")) {
                    scanForFragment(context, r, metaInfFragmentCache);
                }
                if (scanTypes.contains(METAINF_TLDS)) {
                    scanForTlds(context, r, metaInfTldCache);
                }
            }
        }
    }

    public void scanForResources(WebAppContext context, Resource target, ConcurrentHashMap<Resource, Resource> cache) throws Exception {
        Resource resourcesDir;
        if (cache == null || !cache.containsKey(target)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(target + " META-INF/resources checked", new Object[0]);
            }
            if (target.isDirectory()) {
                resourcesDir = target.addPath("/META-INF/resources");
            } else {
                resourcesDir = Resource.newResource(uriJarPrefix(target.getURI(), "!/META-INF/resources"));
            }
            if (!resourcesDir.exists() || !resourcesDir.isDirectory()) {
                resourcesDir.close();
                resourcesDir = EmptyResource.INSTANCE;
            }
            if (cache != null) {
                Resource old = cache.putIfAbsent(target, resourcesDir);
                if (old != null) {
                    resourcesDir = old;
                } else if (LOG.isDebugEnabled()) {
                    LOG.debug(target + " META-INF/resources cache updated", new Object[0]);
                }
            }
            if (resourcesDir == EmptyResource.INSTANCE) {
                return;
            }
        } else {
            resourcesDir = cache.get(target);
            if (resourcesDir == EmptyResource.INSTANCE) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug(target + " cached as containing no META-INF/resources", new Object[0]);
                    return;
                }
                return;
            } else if (LOG.isDebugEnabled()) {
                LOG.debug(target + " META-INF/resources found in cache ", new Object[0]);
            }
        }
        Set<Resource> dirs = (Set) context.getAttribute("org.eclipse.jetty.resources");
        if (dirs == null) {
            dirs = new HashSet<>();
            context.setAttribute("org.eclipse.jetty.resources", dirs);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug(resourcesDir + " added to context", new Object[0]);
        }
        dirs.add(resourcesDir);
    }

    public void scanForFragment(WebAppContext context, Resource jar, ConcurrentHashMap<Resource, Resource> cache) throws Exception {
        Resource webFrag;
        if (cache == null || !cache.containsKey(jar)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(jar + " META-INF/web-fragment.xml checked", new Object[0]);
            }
            if (jar.isDirectory()) {
                webFrag = Resource.newResource(new File(jar.getFile(), "/META-INF/web-fragment.xml"));
            } else {
                webFrag = Resource.newResource(uriJarPrefix(jar.getURI(), "!/META-INF/web-fragment.xml"));
            }
            if (!webFrag.exists() || webFrag.isDirectory()) {
                webFrag.close();
                webFrag = EmptyResource.INSTANCE;
            }
            if (cache != null) {
                Resource old = cache.putIfAbsent(jar, webFrag);
                if (old != null) {
                    webFrag = old;
                } else if (LOG.isDebugEnabled()) {
                    LOG.debug(jar + " META-INF/web-fragment.xml cache updated", new Object[0]);
                }
            }
            if (webFrag == EmptyResource.INSTANCE) {
                return;
            }
        } else {
            webFrag = cache.get(jar);
            if (webFrag == EmptyResource.INSTANCE) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug(jar + " cached as containing no META-INF/web-fragment.xml", new Object[0]);
                    return;
                }
                return;
            } else if (LOG.isDebugEnabled()) {
                LOG.debug(jar + " META-INF/web-fragment.xml found in cache ", new Object[0]);
            }
        }
        Map<Resource, Resource> fragments = (Map) context.getAttribute("org.eclipse.jetty.webFragments");
        if (fragments == null) {
            fragments = new HashMap<>();
            context.setAttribute("org.eclipse.jetty.webFragments", fragments);
        }
        fragments.put(jar, webFrag);
        if (LOG.isDebugEnabled()) {
            LOG.debug(webFrag + " added to context", new Object[0]);
        }
    }

    public void scanForTlds(WebAppContext context, Resource jar, ConcurrentHashMap<Resource, Collection<URL>> cache) throws Exception {
        Collection<URL> tlds;
        if (cache == null || !cache.containsKey(jar)) {
            Collection<URL> tlds2 = new HashSet<>();
            if (jar.isDirectory()) {
                tlds2.addAll(getTlds(jar.getFile()));
            } else {
                tlds2.addAll(getTlds(jar.getURI()));
            }
            Collection<URL> tlds3 = tlds2;
            if (cache != null) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug(jar + " tld cache updated", new Object[0]);
                }
                Collection<URL> old = cache.putIfAbsent(jar, tlds2);
                tlds3 = tlds2;
                if (old != null) {
                    tlds3 = old;
                }
            }
            boolean isEmpty = tlds3.isEmpty();
            tlds = tlds3;
            if (isEmpty) {
                return;
            }
        } else {
            Collection<? extends URL> collection = cache.get(jar);
            if (!collection.isEmpty()) {
                Collection<? extends URL> collection2 = collection;
                tlds = collection2;
                if (LOG.isDebugEnabled()) {
                    LOG.debug(jar + " tlds found in cache ", new Object[0]);
                    tlds = collection2;
                }
            } else if (LOG.isDebugEnabled()) {
                LOG.debug(jar + " cached as containing no tlds", new Object[0]);
                return;
            } else {
                return;
            }
        }
        Collection<URL> metaInfTlds = (Collection) context.getAttribute(METAINF_TLDS);
        if (metaInfTlds == null) {
            metaInfTlds = new HashSet<>();
            context.setAttribute(METAINF_TLDS, metaInfTlds);
        }
        metaInfTlds.addAll(tlds);
        if (LOG.isDebugEnabled()) {
            LOG.debug("tlds added to context", new Object[0]);
        }
    }

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void postConfigure(WebAppContext context) throws Exception {
        context.setAttribute("org.eclipse.jetty.resources", null);
        context.setAttribute("org.eclipse.jetty.webFragments", null);
        context.setAttribute(METAINF_TLDS, null);
    }

    public Collection<URL> getTlds(File dir) throws IOException {
        if (dir == null || !dir.isDirectory()) {
            return Collections.emptySet();
        }
        HashSet<URL> tlds = new HashSet<>();
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    tlds.addAll(getTlds(f));
                } else {
                    String name = f.getCanonicalPath();
                    if (name.contains("META-INF") && name.endsWith(".tld")) {
                        tlds.add(f.toURI().toURL());
                    }
                }
            }
        }
        return tlds;
    }

    public Collection<URL> getTlds(URI uri) throws IOException {
        HashSet<URL> tlds = new HashSet<>();
        String jarUri = uriJarPrefix(uri, "!/");
        JarURLConnection jarConn = (JarURLConnection) new URL(jarUri).openConnection();
        jarConn.setUseCaches(Resource.getDefaultUseCaches());
        JarFile jarFile = jarConn.getJarFile();
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            String name = entries.nextElement().getName();
            if (name.startsWith("META-INF") && name.endsWith(".tld")) {
                tlds.add(new URL(jarUri + name));
            }
        }
        if (!Resource.getDefaultUseCaches()) {
            jarFile.close();
        }
        return tlds;
    }

    private String uriJarPrefix(URI uri, String suffix) {
        String uriString = uri.toString();
        if (uriString.startsWith(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX)) {
            return uriString + suffix;
        }
        return XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX + uriString + suffix;
    }
}
