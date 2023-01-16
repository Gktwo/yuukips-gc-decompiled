package nonapi.p019io.github.classgraph.classloaderhandler;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import net.bytebuddy.implementation.MethodDelegation;
import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.WebsphereLibertyClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/WebsphereLibertyClassLoaderHandler.class */
class WebsphereLibertyClassLoaderHandler implements ClassLoaderHandler {
    private static final String PKG_PREFIX = "com.ibm.ws.classloading.internal.";
    private static final String IBM_APP_CLASS_LOADER = "com.ibm.ws.classloading.internal.AppClassLoader";
    private static final String IBM_THREAD_CONTEXT_CLASS_LOADER = "com.ibm.ws.classloading.internal.ThreadContextClassLoader";

    private WebsphereLibertyClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return IBM_APP_CLASS_LOADER.equals(classLoaderClass.getName()) || IBM_THREAD_CONTEXT_CLASS_LOADER.equals(classLoaderClass.getName());
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
        classLoaderOrder.add(classLoader, log);
    }

    private static Collection<Object> getPaths(Object containerClassLoader) {
        if (containerClassLoader == null) {
            return Collections.emptyList();
        }
        Collection<Object> urls = callGetUrls(containerClassLoader, "getContainerURLs");
        if (urls != null && !urls.isEmpty()) {
            return urls;
        }
        Object container = ReflectionUtils.getFieldVal(containerClassLoader, "container", false);
        if (container == null) {
            return Collections.emptyList();
        }
        Collection<Object> urls2 = callGetUrls(container, "getURLs");
        if (urls2 != null && !urls2.isEmpty()) {
            return urls2;
        }
        Object delegate = ReflectionUtils.getFieldVal(container, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, false);
        if (delegate == null) {
            return Collections.emptyList();
        }
        String path = (String) ReflectionUtils.getFieldVal(delegate, "path", false);
        if (path != null && path.length() > 0) {
            return Arrays.asList(path);
        }
        Object base = ReflectionUtils.getFieldVal(delegate, "base", false);
        if (base == null) {
            return Collections.emptyList();
        }
        Object archiveFile = ReflectionUtils.getFieldVal(base, "archiveFile", false);
        return archiveFile != null ? Arrays.asList(((File) archiveFile).getAbsolutePath()) : Collections.emptyList();
    }

    private static Collection<Object> callGetUrls(Object container, String methodName) {
        if (container != null) {
            try {
                Collection<Object> results = (Collection) ReflectionUtils.invokeMethod(container, methodName, false);
                if (results != null && !results.isEmpty()) {
                    Collection<Object> allUrls = new HashSet<>();
                    for (Object result : results) {
                        if (result instanceof Collection) {
                            for (Object url : (Collection) result) {
                                if (url != null) {
                                    allUrls.add(url);
                                }
                            }
                        } else if (result != null) {
                            allUrls.add(result);
                        }
                    }
                    return allUrls;
                }
            } catch (UnsupportedOperationException e) {
            }
        }
        return Collections.emptyList();
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        Object smartClassPath;
        Object appLoader = ReflectionUtils.getFieldVal(classLoader, "appLoader", false);
        if (appLoader != null) {
            smartClassPath = ReflectionUtils.getFieldVal(appLoader, "smartClassPath", false);
        } else {
            smartClassPath = ReflectionUtils.getFieldVal(classLoader, "smartClassPath", false);
        }
        if (smartClassPath != null) {
            Collection<Object> paths = callGetUrls(smartClassPath, "getClassPath");
            if (!paths.isEmpty()) {
                for (Object path : paths) {
                    classpathOrder.addClasspathEntry(path, classLoader, scanSpec, log);
                }
                return;
            }
            List<Object> classPathElements = (List) ReflectionUtils.getFieldVal(smartClassPath, "classPath", false);
            if (!(classPathElements == null || classPathElements.isEmpty())) {
                for (Object classPathElement : classPathElements) {
                    for (Object path2 : getPaths(classPathElement)) {
                        classpathOrder.addClasspathEntry(path2, classLoader, scanSpec, log);
                    }
                }
            }
        }
    }
}
