package nonapi.p019io.github.classgraph.classloaderhandler;

import java.io.File;
import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.OSGiDefaultClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/OSGiDefaultClassLoaderHandler.class */
class OSGiDefaultClassLoaderHandler implements ClassLoaderHandler {
    private OSGiDefaultClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return "org.eclipse.osgi.internal.baseadaptor.DefaultClassLoader".equals(classLoaderClass.getName());
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
        classLoaderOrder.add(classLoader, log);
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        Object[] entries = (Object[]) ReflectionUtils.getFieldVal(ReflectionUtils.invokeMethod(classLoader, "getClasspathManager", false), "entries", false);
        if (entries != null) {
            for (Object entry : entries) {
                File baseFile = (File) ReflectionUtils.invokeMethod(ReflectionUtils.invokeMethod(entry, "getBundleFile", false), "getBaseFile", false);
                if (baseFile != null) {
                    classpathOrder.addClasspathEntry(baseFile.getPath(), classLoader, scanSpec, log);
                }
            }
        }
    }
}
