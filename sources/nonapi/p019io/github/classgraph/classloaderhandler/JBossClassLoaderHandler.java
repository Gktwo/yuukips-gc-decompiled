package nonapi.p019io.github.classgraph.classloaderhandler;

import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.JBossClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/JBossClassLoaderHandler.class */
class JBossClassLoaderHandler implements ClassLoaderHandler {
    private JBossClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return "org.jboss.modules.ModuleClassLoader".equals(classLoaderClass.getName());
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
        classLoaderOrder.add(classLoader, log);
    }

    private static void handleResourceLoader(Object resourceLoader, ClassLoader classLoader, ClasspathOrder classpathOrderOut, ScanSpec scanSpec, LogNode log) {
        String path;
        File file;
        if (resourceLoader != null) {
            Object root = ReflectionUtils.getFieldVal(resourceLoader, "root", false);
            File physicalFile = (File) ReflectionUtils.invokeMethod(root, "getPhysicalFile", false);
            if (physicalFile != null) {
                String name = (String) ReflectionUtils.invokeMethod(root, "getName", false);
                if (name != null) {
                    File file2 = new File(physicalFile.getParentFile(), name);
                    path = FileUtils.canRead(file2) ? file2.getAbsolutePath() : physicalFile.getAbsolutePath();
                } else {
                    path = physicalFile.getAbsolutePath();
                }
            } else {
                path = (String) ReflectionUtils.invokeMethod(root, "getPathName", false);
                if (path == null) {
                    File file3 = root instanceof Path ? ((Path) root).toFile() : root instanceof File ? (File) root : null;
                    if (file3 != null) {
                        path = file3.getAbsolutePath();
                    }
                }
            }
            if (path == null && (file = (File) ReflectionUtils.getFieldVal(resourceLoader, "fileOfJar", false)) != null) {
                path = file.getAbsolutePath();
            }
            if (path != null) {
                classpathOrderOut.addClasspathEntry(path, classLoader, scanSpec, log);
            } else if (log != null) {
                log.log("Could not determine classpath for ResourceLoader: " + resourceLoader);
            }
        }
    }

    private static void handleRealModule(Object module, Set<Object> visitedModules, ClassLoader classLoader, ClasspathOrder classpathOrderOut, ScanSpec scanSpec, LogNode log) {
        if (visitedModules.add(module)) {
            ClassLoader moduleLoader = (ClassLoader) ReflectionUtils.invokeMethod(module, "getClassLoader", false);
            if (moduleLoader == null) {
                moduleLoader = classLoader;
            }
            Object vfsResourceLoaders = ReflectionUtils.invokeMethod(moduleLoader, "getResourceLoaders", false);
            if (vfsResourceLoaders != null) {
                int n = Array.getLength(vfsResourceLoaders);
                for (int i = 0; i < n; i++) {
                    handleResourceLoader(Array.get(vfsResourceLoaders, i), moduleLoader, classpathOrderOut, scanSpec, log);
                }
            }
        }
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        Object module = ReflectionUtils.invokeMethod(classLoader, "getModule", false);
        Object callerModuleLoader = ReflectionUtils.invokeMethod(module, "getCallerModuleLoader", false);
        Set<Object> visitedModules = new HashSet<>();
        for (Map.Entry<Object, Object> ent : ((Map) ReflectionUtils.getFieldVal(callerModuleLoader, "moduleMap", false)).entrySet()) {
            handleRealModule(ReflectionUtils.invokeMethod(ent.getValue(), "getModule", false), visitedModules, classLoader, classpathOrder, scanSpec, log);
        }
        for (Map.Entry<String, List<?>> ent2 : ((Map) ReflectionUtils.invokeMethod(module, "getPaths", false)).entrySet()) {
            Iterator<?> it = ent2.getValue().iterator();
            while (it.hasNext()) {
                handleRealModule(ReflectionUtils.getFieldVal(ReflectionUtils.getFieldVal(it.next(), "this$0", false), "module", false), visitedModules, classLoader, classpathOrder, scanSpec, log);
            }
        }
    }
}
