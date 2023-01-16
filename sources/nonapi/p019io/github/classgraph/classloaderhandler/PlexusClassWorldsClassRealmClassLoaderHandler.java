package nonapi.p019io.github.classgraph.classloaderhandler;

import java.util.SortedSet;
import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.PlexusClassWorldsClassRealmClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/PlexusClassWorldsClassRealmClassLoaderHandler.class */
class PlexusClassWorldsClassRealmClassLoaderHandler implements ClassLoaderHandler {
    private PlexusClassWorldsClassRealmClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return "org.codehaus.plexus.classworlds.realm.ClassRealm".equals(classLoaderClass.getName());
    }

    private static boolean isParentFirstStrategy(ClassLoader classRealmInstance) {
        Object strategy = ReflectionUtils.getFieldVal(classRealmInstance, "strategy", false);
        if (strategy == null) {
            return true;
        }
        String strategyClassName = strategy.getClass().getName();
        if (strategyClassName.equals("org.codehaus.plexus.classworlds.strategy.SelfFirstStrategy") || strategyClassName.equals("org.codehaus.plexus.classworlds.strategy.OsgiBundleStrategy")) {
            return false;
        }
        return true;
    }

    public static void findClassLoaderOrder(ClassLoader classRealm, ClassLoaderOrder classLoaderOrder, LogNode log) {
        Object foreignImports = ReflectionUtils.getFieldVal(classRealm, "foreignImports", false);
        if (foreignImports != null) {
            for (Object entry : (SortedSet) foreignImports) {
                classLoaderOrder.delegateTo((ClassLoader) ReflectionUtils.invokeMethod(entry, "getClassLoader", false), true, log);
            }
        }
        boolean isParentFirst = isParentFirstStrategy(classRealm);
        if (!isParentFirst) {
            classLoaderOrder.add(classRealm, log);
        }
        classLoaderOrder.delegateTo((ClassLoader) ReflectionUtils.invokeMethod(classRealm, "getParentClassLoader", false), true, log);
        classLoaderOrder.delegateTo(classRealm.getParent(), true, log);
        if (isParentFirst) {
            classLoaderOrder.add(classRealm, log);
        }
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        URLClassLoaderHandler.findClasspathOrder(classLoader, classpathOrder, scanSpec, log);
    }
}
