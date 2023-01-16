package nonapi.p019io.github.classgraph.classloaderhandler;

import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.SpringBootRestartClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/SpringBootRestartClassLoaderHandler.class */
class SpringBootRestartClassLoaderHandler implements ClassLoaderHandler {
    private SpringBootRestartClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return "org.springframework.boot.devtools.restart.classloader.RestartClassLoader".equals(classLoaderClass.getName());
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        classLoaderOrder.add(classLoader, log);
        classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
    }
}
