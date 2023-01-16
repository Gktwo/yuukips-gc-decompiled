package nonapi.p019io.github.classgraph.classloaderhandler;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.ClassLoaderHandlerRegistry */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/ClassLoaderHandlerRegistry.class */
public class ClassLoaderHandlerRegistry {
    public static final List<ClassLoaderHandlerRegistryEntry> CLASS_LOADER_HANDLERS = Collections.unmodifiableList(Arrays.asList(new ClassLoaderHandlerRegistryEntry(AntClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(EquinoxClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(EquinoxContextFinderClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(FelixClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(JBossClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(WeblogicClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(WebsphereLibertyClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(WebsphereTraditionalClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(OSGiDefaultClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(SpringBootRestartClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(TomcatWebappClassLoaderBaseHandler.class), new ClassLoaderHandlerRegistryEntry(PlexusClassWorldsClassRealmClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(QuarkusClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(UnoOneJarClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(ParentLastDelegationOrderTestClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(JPMSClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(URLClassLoaderHandler.class)));
    public static final ClassLoaderHandlerRegistryEntry FALLBACK_HANDLER = new ClassLoaderHandlerRegistryEntry(FallbackClassLoaderHandler.class);
    public static final String[] AUTOMATIC_LIB_DIR_PREFIXES = {"BOOT-INF/lib/", "BOOT-INF/lib-provided/", "WEB-INF/lib/", "WEB-INF/lib-provided/", "META-INF/lib/", "lib/", "lib/ext/", "main/"};
    public static final String[] AUTOMATIC_PACKAGE_ROOT_PREFIXES = {"classes/", "test-classes/", "BOOT-INF/classes/", "WEB-INF/classes/"};

    private ClassLoaderHandlerRegistry() {
    }

    /* renamed from: nonapi.io.github.classgraph.classloaderhandler.ClassLoaderHandlerRegistry$ClassLoaderHandlerRegistryEntry */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/ClassLoaderHandlerRegistry$ClassLoaderHandlerRegistryEntry.class */
    public static class ClassLoaderHandlerRegistryEntry {
        private final Method canHandleMethod;
        private final Method findClassLoaderOrderMethod;
        private final Method findClasspathOrderMethod;
        public final Class<? extends ClassLoaderHandler> classLoaderHandlerClass;

        private ClassLoaderHandlerRegistryEntry(Class<? extends ClassLoaderHandler> classLoaderHandlerClass) {
            this.classLoaderHandlerClass = classLoaderHandlerClass;
            try {
                this.canHandleMethod = classLoaderHandlerClass.getDeclaredMethod("canHandle", Class.class, LogNode.class);
                try {
                    this.findClassLoaderOrderMethod = classLoaderHandlerClass.getDeclaredMethod("findClassLoaderOrder", ClassLoader.class, ClassLoaderOrder.class, LogNode.class);
                    try {
                        this.findClasspathOrderMethod = classLoaderHandlerClass.getDeclaredMethod("findClasspathOrder", ClassLoader.class, ClasspathOrder.class, ScanSpec.class, LogNode.class);
                    } catch (Exception e) {
                        throw new RuntimeException("Could not find findClasspathOrder method for " + classLoaderHandlerClass.getName(), e);
                    }
                } catch (Exception e2) {
                    throw new RuntimeException("Could not find findClassLoaderOrder method for " + classLoaderHandlerClass.getName(), e2);
                }
            } catch (Exception e3) {
                throw new RuntimeException("Could not find canHandle method for " + classLoaderHandlerClass.getName(), e3);
            }
        }

        public boolean canHandle(Class<?> classLoader, LogNode log) {
            try {
                return ((Boolean) this.canHandleMethod.invoke(null, classLoader, log)).booleanValue();
            } catch (Throwable e) {
                throw new RuntimeException("Exception while calling canHandle for " + this.classLoaderHandlerClass.getName(), e);
            }
        }

        public void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
            try {
                this.findClassLoaderOrderMethod.invoke(null, classLoader, classLoaderOrder, log);
            } catch (Throwable e) {
                throw new RuntimeException("Exception while calling findClassLoaderOrder for " + this.classLoaderHandlerClass.getName(), e);
            }
        }

        public void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
            try {
                this.findClasspathOrderMethod.invoke(null, classLoader, classpathOrder, scanSpec, log);
            } catch (Throwable e) {
                throw new RuntimeException("Exception while calling findClassLoaderOrder for " + this.classLoaderHandlerClass.getName(), e);
            }
        }
    }
}
