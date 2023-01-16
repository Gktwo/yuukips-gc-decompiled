package org.reflections.util;

import dev.morphia.mapping.Mapper;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import javax.servlet.ServletContext;
import org.quartz.xml.XMLSchedulingDataProcessor;
import org.reflections.Reflections;

/* loaded from: grasscutter.jar:org/reflections/util/ClasspathHelper.class */
public abstract class ClasspathHelper {
    public static ClassLoader contextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static ClassLoader staticClassLoader() {
        return Reflections.class.getClassLoader();
    }

    public static ClassLoader[] classLoaders(ClassLoader... classLoaders) {
        if (classLoaders != null && classLoaders.length != 0) {
            return classLoaders;
        }
        ClassLoader contextClassLoader = contextClassLoader();
        ClassLoader staticClassLoader = staticClassLoader();
        return contextClassLoader != null ? (staticClassLoader == null || contextClassLoader == staticClassLoader) ? new ClassLoader[]{contextClassLoader} : new ClassLoader[]{contextClassLoader, staticClassLoader} : new ClassLoader[0];
    }

    public static Collection<URL> forPackage(String name, ClassLoader... classLoaders) {
        return forResource(resourceName(name), classLoaders);
    }

    public static Collection<URL> forResource(String resourceName, ClassLoader... classLoaders) {
        List<URL> result = new ArrayList<>();
        for (ClassLoader classLoader : classLoaders(classLoaders)) {
            try {
                Enumeration<URL> urls = classLoader.getResources(resourceName);
                while (urls.hasMoreElements()) {
                    URL url = urls.nextElement();
                    int index = url.toExternalForm().lastIndexOf(resourceName);
                    if (index != -1) {
                        result.add(new URL(url, url.toExternalForm().substring(0, index)));
                    } else {
                        result.add(url);
                    }
                }
            } catch (IOException e) {
                if (Reflections.log != null) {
                    Reflections.log.error("error getting resources for " + resourceName, (Throwable) e);
                }
            }
        }
        return distinctUrls(result);
    }

    public static URL forClass(Class<?> aClass, ClassLoader... classLoaders) {
        URL url;
        String resourceName = aClass.getName().replace(Mapper.IGNORED_FIELDNAME, "/") + ".class";
        for (ClassLoader classLoader : classLoaders(classLoaders)) {
            try {
                url = classLoader.getResource(resourceName);
            } catch (MalformedURLException e) {
                if (Reflections.log != null) {
                    Reflections.log.warn("Could not get URL", (Throwable) e);
                }
            }
            if (url != null) {
                return new URL(url.toExternalForm().substring(0, url.toExternalForm().lastIndexOf(aClass.getPackage().getName().replace(Mapper.IGNORED_FIELDNAME, "/"))));
            }
            continue;
        }
        return null;
    }

    public static Collection<URL> forClassLoader() {
        return forClassLoader(classLoaders(new ClassLoader[0]));
    }

    public static Collection<URL> forClassLoader(ClassLoader... classLoaders) {
        URL[] urls;
        Collection<URL> result = new ArrayList<>();
        ClassLoader[] loaders = classLoaders(classLoaders);
        int length = loaders.length;
        for (int i = 0; i < length; i++) {
            for (ClassLoader classLoader = loaders[i]; classLoader != null; classLoader = classLoader.getParent()) {
                if ((classLoader instanceof URLClassLoader) && (urls = ((URLClassLoader) classLoader).getURLs()) != null) {
                    result.addAll(Arrays.asList(urls));
                }
            }
        }
        return distinctUrls(result);
    }

    public static Collection<URL> forJavaClassPath() {
        Collection<URL> urls = new ArrayList<>();
        String javaClassPath = System.getProperty("java.class.path");
        if (javaClassPath != null) {
            for (String path : javaClassPath.split(File.pathSeparator)) {
                try {
                    urls.add(new File(path).toURI().toURL());
                } catch (Exception e) {
                    if (Reflections.log != null) {
                        Reflections.log.warn("Could not get URL", (Throwable) e);
                    }
                }
            }
        }
        return distinctUrls(urls);
    }

    public static Collection<URL> forWebInfLib(ServletContext servletContext) {
        Collection<URL> urls = new ArrayList<>();
        Set<?> resourcePaths = servletContext.getResourcePaths("/WEB-INF/lib");
        if (resourcePaths == null) {
            return urls;
        }
        Iterator<?> it = resourcePaths.iterator();
        while (it.hasNext()) {
            try {
                urls.add(servletContext.getResource((String) it.next()));
            } catch (MalformedURLException e) {
            }
        }
        return distinctUrls(urls);
    }

    public static URL forWebInfClasses(ServletContext servletContext) {
        try {
            String path = servletContext.getRealPath("/WEB-INF/classes");
            if (path == null) {
                return servletContext.getResource("/WEB-INF/classes");
            }
            File file = new File(path);
            if (file.exists()) {
                return file.toURL();
            }
            return null;
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public static Collection<URL> forManifest() {
        return forManifest(forClassLoader());
    }

    public static Collection<URL> forManifest(URL url) {
        String classPath;
        Collection<URL> result = new ArrayList<>();
        result.add(url);
        try {
            String part = cleanPath(url);
            File jarFile = new File(part);
            JarFile myJar = new JarFile(part);
            URL validUrl = tryToGetValidUrl(jarFile.getPath(), new File(part).getParent(), part);
            if (validUrl != null) {
                result.add(validUrl);
            }
            Manifest manifest = myJar.getManifest();
            if (!(manifest == null || (classPath = manifest.getMainAttributes().getValue(new Attributes.Name("Class-Path"))) == null)) {
                for (String jar : classPath.split(" ")) {
                    URL validUrl2 = tryToGetValidUrl(jarFile.getPath(), new File(part).getParent(), jar);
                    if (validUrl2 != null) {
                        result.add(validUrl2);
                    }
                }
            }
        } catch (IOException e) {
        }
        return distinctUrls(result);
    }

    public static Collection<URL> forManifest(Iterable<URL> urls) {
        Collection<URL> result = new ArrayList<>();
        for (URL url : urls) {
            result.addAll(forManifest(url));
        }
        return distinctUrls(result);
    }

    static URL tryToGetValidUrl(String workingDir, String path, String filename) {
        try {
            if (new File(filename).exists()) {
                return new File(filename).toURI().toURL();
            }
            if (new File(path + File.separator + filename).exists()) {
                return new File(path + File.separator + filename).toURI().toURL();
            }
            if (new File(workingDir + File.separator + filename).exists()) {
                return new File(workingDir + File.separator + filename).toURI().toURL();
            }
            if (new File(new URL(filename).getFile()).exists()) {
                return new File(new URL(filename).getFile()).toURI().toURL();
            }
            return null;
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public static String cleanPath(URL url) {
        String path = url.getPath();
        try {
            path = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        if (path.startsWith(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX)) {
            path = path.substring(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX.length());
        }
        if (path.startsWith("file:")) {
            path = path.substring("file:".length());
        }
        if (path.endsWith("!/")) {
            path = path.substring(0, path.lastIndexOf("!/")) + "/";
        }
        return path;
    }

    private static String resourceName(String name) {
        if (name == null) {
            return null;
        }
        String resourceName = name.replace(Mapper.IGNORED_FIELDNAME, "/").replace("\\", "/");
        if (resourceName.startsWith("/")) {
            resourceName = resourceName.substring(1);
        }
        return resourceName;
    }

    private static Collection<URL> distinctUrls(Collection<URL> urls) {
        Map<String, URL> distinct = new LinkedHashMap<>(urls.size());
        for (URL url : urls) {
            distinct.put(url.toExternalForm(), url);
        }
        return distinct.values();
    }
}
