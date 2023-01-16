package nonapi.p019io.github.classgraph.classloaderhandler;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.FelixClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/FelixClassLoaderHandler.class */
class FelixClassLoaderHandler implements ClassLoaderHandler {
    private FelixClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return "org.apache.felix.framework.BundleWiringImpl$BundleClassLoaderJava5".equals(classLoaderClass.getName()) || "org.apache.felix.framework.BundleWiringImpl$BundleClassLoader".equals(classLoaderClass.getName());
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
        classLoaderOrder.add(classLoader, log);
    }

    private static File getContentLocation(Object content) {
        return (File) ReflectionUtils.invokeMethod(content, "getFile", false);
    }

    private static void addBundle(Object bundleWiring, ClassLoader classLoader, ClasspathOrder classpathOrderOut, Set<Object> bundles, ScanSpec scanSpec, LogNode log) {
        bundles.add(bundleWiring);
        Object revision = ReflectionUtils.invokeMethod(bundleWiring, "getRevision", false);
        Object content = ReflectionUtils.invokeMethod(revision, "getContent", false);
        File location = content != null ? getContentLocation(content) : null;
        if (location != null) {
            classpathOrderOut.addClasspathEntry(location, classLoader, scanSpec, log);
            List<?> embeddedContent = (List) ReflectionUtils.invokeMethod(revision, "getContentPath", false);
            if (embeddedContent != null) {
                Iterator<?> it = embeddedContent.iterator();
                while (it.hasNext()) {
                    Object embedded = it.next();
                    if (embedded != content) {
                        File embeddedLocation = embedded != null ? getContentLocation(embedded) : null;
                        if (embeddedLocation != null) {
                            classpathOrderOut.addClasspathEntry(embeddedLocation, classLoader, scanSpec, log);
                        }
                    }
                }
            }
        }
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        Set<Object> bundles = new HashSet<>();
        Object bundleWiring = ReflectionUtils.getFieldVal(classLoader, "m_wiring", false);
        addBundle(bundleWiring, classLoader, classpathOrder, bundles, scanSpec, log);
        List<?> requiredWires = (List) ReflectionUtils.invokeMethod(bundleWiring, "getRequiredWires", String.class, null, false);
        if (requiredWires != null) {
            Iterator<?> it = requiredWires.iterator();
            while (it.hasNext()) {
                Object provider = ReflectionUtils.invokeMethod(it.next(), "getProviderWiring", false);
                if (!bundles.contains(provider)) {
                    addBundle(provider, classLoader, classpathOrder, bundles, scanSpec, log);
                }
            }
        }
    }
}
