package nonapi.p019io.github.classgraph.classloaderhandler;

import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.UnoOneJarClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/UnoOneJarClassLoaderHandler.class */
class UnoOneJarClassLoaderHandler implements ClassLoaderHandler {
    private UnoOneJarClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return "com.needhamsoftware.unojar.JarClassLoader".equals(classLoaderClass.getName()) || "com.simontuffs.onejar.JarClassLoader".equals(classLoaderClass.getName());
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
        classLoaderOrder.add(classLoader, log);
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        classpathOrder.addClasspathEntry((String) ReflectionUtils.invokeMethod(classLoader, "getOneJarPath", false), classLoader, scanSpec, log);
        classpathOrder.addClasspathEntry(System.getProperty("uno-jar.jar.path"), classLoader, scanSpec, log);
        classpathOrder.addClasspathEntry(System.getProperty("one-jar.jar.path"), classLoader, scanSpec, log);
        String oneJarClassPath = System.getProperty("one-jar.class.path");
        if (oneJarClassPath != null) {
            classpathOrder.addClasspathEntryObject(oneJarClassPath.split("\\|"), classLoader, scanSpec, log);
        }
    }
}
