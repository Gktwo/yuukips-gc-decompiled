package nonapi.p019io.github.classgraph.classloaderhandler;

import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.WeblogicClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/WeblogicClassLoaderHandler.class */
class WeblogicClassLoaderHandler implements ClassLoaderHandler {
    private WeblogicClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return "weblogic.utils.classloaders.ChangeAwareClassLoader".equals(classLoaderClass.getName()) || "weblogic.utils.classloaders.GenericClassLoader".equals(classLoaderClass.getName()) || "weblogic.utils.classloaders.FilteringClassLoader".equals(classLoaderClass.getName()) || "weblogic.servlet.jsp.JspClassLoader".equals(classLoaderClass.getName()) || "weblogic.servlet.jsp.TagFileClassLoader".equals(classLoaderClass.getName());
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
        classLoaderOrder.add(classLoader, log);
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        classpathOrder.addClasspathPathStr((String) ReflectionUtils.invokeMethod(classLoader, "getFinderClassPath", false), classLoader, scanSpec, log);
        classpathOrder.addClasspathPathStr((String) ReflectionUtils.invokeMethod(classLoader, "getClassPath", false), classLoader, scanSpec, log);
    }
}
