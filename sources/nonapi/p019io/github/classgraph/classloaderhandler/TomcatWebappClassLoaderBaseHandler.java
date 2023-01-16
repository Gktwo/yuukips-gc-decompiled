package nonapi.p019io.github.classgraph.classloaderhandler;

import java.io.File;
import java.util.List;
import net.bytebuddy.implementation.MethodDelegation;
import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.TomcatWebappClassLoaderBaseHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/TomcatWebappClassLoaderBaseHandler.class */
class TomcatWebappClassLoaderBaseHandler implements ClassLoaderHandler {
    private TomcatWebappClassLoaderBaseHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return "org.apache.catalina.loader.WebappClassLoaderBase".equals(classLoaderClass.getName());
    }

    private static boolean isParentFirst(ClassLoader classLoader) {
        Object delegateObject = ReflectionUtils.getFieldVal(classLoader, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, false);
        if (delegateObject != null) {
            return ((Boolean) delegateObject).booleanValue();
        }
        return true;
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        boolean isParentFirst = isParentFirst(classLoader);
        if (isParentFirst) {
            classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
        }
        classLoaderOrder.add(classLoader, log);
        if (!isParentFirst) {
            classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
        }
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        Object resources = ReflectionUtils.invokeMethod(classLoader, "getResources", false);
        classpathOrder.addClasspathEntryObject(ReflectionUtils.invokeMethod(resources, "getBaseUrls", false), classLoader, scanSpec, log);
        List<List<?>> allResources = (List) ReflectionUtils.getFieldVal(resources, "allResources", false);
        if (allResources != null) {
            for (List<?> webResourceSetList : allResources) {
                for (Object webResourceSet : webResourceSetList) {
                    if (webResourceSet != null) {
                        File file = (File) ReflectionUtils.invokeMethod(webResourceSet, "getFileBase", false);
                        String base = file == null ? null : file.getPath();
                        if (base == null) {
                            base = (String) ReflectionUtils.invokeMethod(webResourceSet, "getBase", false);
                        }
                        if (base == null) {
                            base = (String) ReflectionUtils.invokeMethod(webResourceSet, "getBaseUrlString", false);
                        }
                        if (base != null) {
                            String archivePath = (String) ReflectionUtils.getFieldVal(webResourceSet, "archivePath", false);
                            if (archivePath != null && !archivePath.isEmpty()) {
                                base = base + "!" + (archivePath.startsWith("/") ? archivePath : "/" + archivePath);
                            }
                            String className = webResourceSet.getClass().getName();
                            boolean isJar = className.equals("java.org.apache.catalina.webresources.JarResourceSet") || className.equals("java.org.apache.catalina.webresources.JarWarResourceSet");
                            String internalPath = (String) ReflectionUtils.invokeMethod(webResourceSet, "getInternalPath", false);
                            if (internalPath == null || internalPath.isEmpty() || internalPath.equals("/")) {
                                classpathOrder.addClasspathEntryObject(base, classLoader, scanSpec, log);
                            } else {
                                classpathOrder.addClasspathEntryObject(base + (isJar ? "!" : "") + (internalPath.startsWith("/") ? internalPath : "/" + internalPath), classLoader, scanSpec, log);
                            }
                        }
                    }
                }
            }
        }
        classpathOrder.addClasspathEntryObject(ReflectionUtils.invokeMethod(classLoader, "getURLs", false), classLoader, scanSpec, log);
    }
}
