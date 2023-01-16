package nonapi.p019io.github.classgraph.classpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nonapi.p019io.github.classgraph.classloaderhandler.ClassLoaderHandlerRegistry;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.FastPathResolver;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.JarUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;

/* renamed from: nonapi.io.github.classgraph.classpath.ClasspathFinder */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classpath/ClasspathFinder.class */
public class ClasspathFinder {
    private final ClasspathOrder classpathOrder;
    private final ModuleFinder moduleFinder;
    private ClassLoader[] classLoaderOrderRespectingParentDelegation;

    public ClasspathOrder getClasspathOrder() {
        return this.classpathOrder;
    }

    public ModuleFinder getModuleFinder() {
        return this.moduleFinder;
    }

    public ClassLoader[] getClassLoaderOrderRespectingParentDelegation() {
        return this.classLoaderOrderRespectingParentDelegation;
    }

    public ClasspathFinder(ScanSpec scanSpec, LogNode log) {
        boolean scanModules;
        LogNode classpathFinderLog = log == null ? null : log.log("Finding classpath and modules");
        if (scanSpec.overrideClasspath != null) {
            scanModules = false;
        } else if (scanSpec.overrideClassLoaders != null) {
            scanModules = false;
            for (ClassLoader classLoader : scanSpec.overrideClassLoaders) {
                String classLoaderClassName = classLoader.getClass().getName();
                if (classLoaderClassName.equals("jdk.internal.loader.ClassLoaders$AppClassLoader")) {
                    scanModules = true;
                } else if (classLoaderClassName.equals("jdk.internal.loader.ClassLoaders$PlatformClassLoader")) {
                    scanModules = true;
                    if (!scanSpec.enableSystemJarsAndModules) {
                        if (classpathFinderLog != null) {
                            classpathFinderLog.log("overrideClassLoaders() was called with an instance of jdk.internal.loader.ClassLoaders$PlatformClassLoader, which is a system classloader, so enableSystemJarsAndModules() was called automatically");
                        }
                        scanSpec.enableSystemJarsAndModules = true;
                    }
                }
            }
        } else {
            scanModules = scanSpec.scanModules;
        }
        this.moduleFinder = scanModules ? new ModuleFinder(CallStackReader.getClassContext(classpathFinderLog), scanSpec, classpathFinderLog) : null;
        this.classpathOrder = new ClasspathOrder(scanSpec);
        ClassLoaderFinder classLoaderFinder = (scanSpec.overrideClasspath == null && scanSpec.overrideClassLoaders == null) ? new ClassLoaderFinder(scanSpec, classpathFinderLog) : null;
        ClassLoader[] contextClassLoaders = classLoaderFinder == null ? new ClassLoader[0] : classLoaderFinder.getContextClassLoaders();
        ClassLoader defaultClassLoader = contextClassLoaders.length > 0 ? contextClassLoaders[0] : null;
        if (scanSpec.overrideClasspath != null) {
            if (!(scanSpec.overrideClassLoaders == null || classpathFinderLog == null)) {
                classpathFinderLog.log("It is not possible to override both the classpath and the ClassLoaders -- ignoring the ClassLoader override");
            }
            LogNode overrideLog = classpathFinderLog == null ? null : classpathFinderLog.log("Overriding classpath with: " + scanSpec.overrideClasspath);
            this.classpathOrder.addClasspathEntries(scanSpec.overrideClasspath, defaultClassLoader, scanSpec, overrideLog);
            if (overrideLog != null) {
                overrideLog.log("WARNING: when the classpath is overridden, there is no guarantee that the classes found by classpath scanning will be the same as the classes loaded by the context classloader");
            }
            this.classLoaderOrderRespectingParentDelegation = contextClassLoaders;
        } else if (scanSpec.overrideClassLoaders == null) {
            String jreRtJar = SystemJarFinder.getJreRtJarPath();
            LogNode systemJarsLog = classpathFinderLog == null ? null : classpathFinderLog.log("System jars:");
            if (jreRtJar != null) {
                if (scanSpec.enableSystemJarsAndModules) {
                    this.classpathOrder.addSystemClasspathEntry(jreRtJar, defaultClassLoader);
                    if (systemJarsLog != null) {
                        systemJarsLog.log("Found rt.jar: " + jreRtJar);
                    }
                } else if (systemJarsLog != null) {
                    systemJarsLog.log((scanSpec.enableSystemJarsAndModules ? "" : "Scanning disabled for rt.jar: ") + jreRtJar);
                }
            }
            boolean scanAllLibOrExtJars = !scanSpec.libOrExtJarWhiteBlackList.whitelistAndBlacklistAreEmpty();
            for (String libOrExtJarPath : SystemJarFinder.getJreLibOrExtJars()) {
                if (scanAllLibOrExtJars || scanSpec.libOrExtJarWhiteBlackList.isSpecificallyWhitelistedAndNotBlacklisted(libOrExtJarPath)) {
                    this.classpathOrder.addSystemClasspathEntry(libOrExtJarPath, defaultClassLoader);
                    if (systemJarsLog != null) {
                        systemJarsLog.log("Found lib or ext jar: " + libOrExtJarPath);
                    }
                } else if (systemJarsLog != null) {
                    systemJarsLog.log("Scanning disabled for lib or ext jar: " + libOrExtJarPath);
                }
            }
        }
        if (scanSpec.overrideClasspath == null) {
            if (classpathFinderLog != null) {
                LogNode classLoaderHandlerLog = classpathFinderLog.log("ClassLoaderHandlers:");
                for (ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry classLoaderHandlerEntry : ClassLoaderHandlerRegistry.CLASS_LOADER_HANDLERS) {
                    classLoaderHandlerLog.log(classLoaderHandlerEntry.classLoaderHandlerClass.getName());
                }
            }
            LogNode classloaderOrderLog = classpathFinderLog == null ? null : classpathFinderLog.log("Finding unique classloaders in delegation order");
            ClassLoaderOrder classLoaderOrder = new ClassLoaderOrder();
            ClassLoader[] origClassLoaderOrder = scanSpec.overrideClassLoaders != null ? (ClassLoader[]) scanSpec.overrideClassLoaders.toArray(new ClassLoader[0]) : contextClassLoaders;
            if (origClassLoaderOrder != null) {
                for (ClassLoader classLoader2 : origClassLoaderOrder) {
                    classLoaderOrder.delegateTo(classLoader2, false, classloaderOrderLog);
                }
            }
            Set<ClassLoader> allParentClassLoaders = classLoaderOrder.getAllParentClassLoaders();
            LogNode classloaderURLLog = classpathFinderLog == null ? null : classpathFinderLog.log("Obtaining URLs from classloaders in delegation order");
            List<ClassLoader> finalClassLoaderOrder = new ArrayList<>();
            for (Map.Entry<ClassLoader, ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry> ent : classLoaderOrder.getClassLoaderOrder()) {
                ClassLoader classLoader3 = ent.getKey();
                ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry classLoaderHandlerRegistryEntry = ent.getValue();
                if (!scanSpec.ignoreParentClassLoaders || !allParentClassLoaders.contains(classLoader3)) {
                    classLoaderHandlerRegistryEntry.findClasspathOrder(classLoader3, this.classpathOrder, scanSpec, classloaderURLLog == null ? null : classloaderURLLog.log("Classloader " + classLoader3 + " is handled by " + classLoaderHandlerRegistryEntry.classLoaderHandlerClass.getName()));
                    finalClassLoaderOrder.add(classLoader3);
                } else if (classloaderURLLog != null) {
                    classloaderURLLog.log("Ignoring parent classloader " + classLoader3 + ", normally handled by " + classLoaderHandlerRegistryEntry.classLoaderHandlerClass.getName());
                }
            }
            this.classLoaderOrderRespectingParentDelegation = (ClassLoader[]) finalClassLoaderOrder.toArray(new ClassLoader[0]);
        }
        if ((!scanSpec.ignoreParentClassLoaders && scanSpec.overrideClassLoaders == null && scanSpec.overrideClasspath == null) || (this.moduleFinder != null && this.moduleFinder.forceScanJavaClassPath())) {
            String[] pathElements = JarUtils.smartPathSplit(System.getProperty("java.class.path"), scanSpec);
            if (pathElements.length > 0) {
                LogNode sysPropLog = classpathFinderLog == null ? null : classpathFinderLog.log("Getting classpath entries from java.class.path");
                for (String pathElement : pathElements) {
                    this.classpathOrder.addClasspathEntry(FastPathResolver.resolve(FileUtils.CURR_DIR_PATH, pathElement), defaultClassLoader, scanSpec, sysPropLog);
                }
            }
        }
    }
}
