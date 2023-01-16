package nonapi.p019io.github.classgraph.classloaderhandler;

import java.net.URL;
import java.net.URLClassLoader;
import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.URLClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/URLClassLoaderHandler.class */
class URLClassLoaderHandler implements ClassLoaderHandler {
    private URLClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return "java.net.URLClassLoader".equals(classLoaderClass.getName());
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
        classLoaderOrder.add(classLoader, log);
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        URL[] urls = ((URLClassLoader) classLoader).getURLs();
        if (urls != null) {
            for (URL url : urls) {
                if (url != null) {
                    classpathOrder.addClasspathEntry(url, classLoader, scanSpec, log);
                }
            }
        }
    }
}
