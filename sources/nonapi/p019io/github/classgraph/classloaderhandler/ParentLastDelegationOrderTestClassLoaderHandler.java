package nonapi.p019io.github.classgraph.classloaderhandler;

import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.ParentLastDelegationOrderTestClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/ParentLastDelegationOrderTestClassLoaderHandler.class */
class ParentLastDelegationOrderTestClassLoaderHandler implements ClassLoaderHandler {
    private ParentLastDelegationOrderTestClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return "io.github.classgraph.issues.issue267.FakeRestartClassLoader".equals(classLoaderClass.getName());
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        classLoaderOrder.add(classLoader, log);
        classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        classpathOrder.addClasspathEntry((String) ReflectionUtils.invokeMethod(classLoader, "getClasspath", true), classLoader, scanSpec, log);
    }
}
