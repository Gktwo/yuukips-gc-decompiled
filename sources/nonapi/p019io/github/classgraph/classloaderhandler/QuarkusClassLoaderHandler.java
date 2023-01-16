package nonapi.p019io.github.classgraph.classloaderhandler;

import java.nio.file.Path;
import java.util.Collection;
import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;
import p001ch.qos.logback.core.joran.action.Action;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.QuarkusClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/QuarkusClassLoaderHandler.class */
class QuarkusClassLoaderHandler implements ClassLoaderHandler {
    private static final String RUNTIME_CLASSLOADER = "io.quarkus.runner.RuntimeClassLoader";
    private static final String QUARKUS_CLASSLOADER = "io.quarkus.bootstrap.classloading.QuarkusClassLoader";

    private QuarkusClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return RUNTIME_CLASSLOADER.equals(classLoaderClass.getName()) || QUARKUS_CLASSLOADER.equals(classLoaderClass.getName());
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
        classLoaderOrder.add(classLoader, log);
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        String classLoaderName = classLoader.getClass().getName();
        if (RUNTIME_CLASSLOADER.equals(classLoaderName)) {
            findClasspathOrderForRuntimeClassloader(classLoader, classpathOrder, scanSpec, log);
        } else if (QUARKUS_CLASSLOADER.equals(classLoaderName)) {
            findClasspathOrderForQuarkusClassloader(classLoader, classpathOrder, scanSpec, log);
        }
    }

    private static void findClasspathOrderForQuarkusClassloader(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        for (Object element : (Collection) ReflectionUtils.getFieldVal(classLoader, "elements", false)) {
            String elementClassName = element.getClass().getName();
            if ("io.quarkus.bootstrap.classloading.JarClassPathElement".equals(elementClassName)) {
                classpathOrder.addClasspathEntry(ReflectionUtils.getFieldVal(element, Action.FILE_ATTRIBUTE, false), classLoader, scanSpec, log);
            } else if ("io.quarkus.bootstrap.classloading.DirectoryClassPathElement".equals(elementClassName)) {
                classpathOrder.addClasspathEntry(ReflectionUtils.getFieldVal(element, "root", false), classLoader, scanSpec, log);
            }
        }
    }

    private static void findClasspathOrderForRuntimeClassloader(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        Collection<Path> applicationClassDirectories = (Collection) ReflectionUtils.getFieldVal(classLoader, "applicationClassDirectories", false);
        if (applicationClassDirectories != null) {
            for (Path path : applicationClassDirectories) {
                classpathOrder.addClasspathEntryObject(path.toUri(), classLoader, scanSpec, log);
            }
        }
    }
}
