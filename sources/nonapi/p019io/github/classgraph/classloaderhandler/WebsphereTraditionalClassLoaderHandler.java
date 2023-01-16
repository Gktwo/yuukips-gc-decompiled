package nonapi.p019io.github.classgraph.classloaderhandler;

import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.WebsphereTraditionalClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/WebsphereTraditionalClassLoaderHandler.class */
class WebsphereTraditionalClassLoaderHandler implements ClassLoaderHandler {
    private WebsphereTraditionalClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return "com.ibm.ws.classloader.CompoundClassLoader".equals(classLoaderClass.getName()) || "com.ibm.ws.classloader.ProtectionClassLoader".equals(classLoaderClass.getName()) || "com.ibm.ws.bootstrap.ExtClassLoader".equals(classLoaderClass.getName());
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
        classLoaderOrder.add(classLoader, log);
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        classpathOrder.addClasspathPathStr((String) ReflectionUtils.invokeMethod(classLoader, "getClassPath", false), classLoader, scanSpec, log);
    }
}
