package p013io.github.classgraph;

import dev.morphia.mapping.Mapper;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import nonapi.p019io.github.classgraph.classpath.SystemJarFinder;
import nonapi.p019io.github.classgraph.concurrency.AutoCloseableExecutorService;
import nonapi.p019io.github.classgraph.concurrency.InterruptionChecker;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.scanspec.WhiteBlackList;
import nonapi.p019io.github.classgraph.utils.JarUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.VersionFinder;
import org.eclipse.jetty.util.URIUtil;

/* renamed from: io.github.classgraph.ClassGraph */
/* loaded from: grasscutter.jar:io/github/classgraph/ClassGraph.class */
public class ClassGraph {
    ScanSpec scanSpec = new ScanSpec();
    static final int DEFAULT_NUM_WORKER_THREADS = Math.max(2, (int) Math.ceil(Math.min(4.0d, ((double) Runtime.getRuntime().availableProcessors()) * 0.75d) + (((double) Runtime.getRuntime().availableProcessors()) * 1.25d)));
    private LogNode topLevelLog;

    @FunctionalInterface
    /* renamed from: io.github.classgraph.ClassGraph$ClasspathElementFilter */
    /* loaded from: grasscutter.jar:io/github/classgraph/ClassGraph$ClasspathElementFilter.class */
    public interface ClasspathElementFilter {
        boolean includeClasspathElement(String str);
    }

    @FunctionalInterface
    /* renamed from: io.github.classgraph.ClassGraph$FailureHandler */
    /* loaded from: grasscutter.jar:io/github/classgraph/ClassGraph$FailureHandler.class */
    public interface FailureHandler {
        void onFailure(Throwable th);
    }

    @FunctionalInterface
    /* renamed from: io.github.classgraph.ClassGraph$ScanResultProcessor */
    /* loaded from: grasscutter.jar:io/github/classgraph/ClassGraph$ScanResultProcessor.class */
    public interface ScanResultProcessor {
        void processScanResult(ScanResult scanResult);
    }

    public ClassGraph() {
        ScanResult.init();
    }

    public static String getVersion() {
        return VersionFinder.getVersion();
    }

    public ClassGraph verbose() {
        if (this.topLevelLog == null) {
            this.topLevelLog = new LogNode();
        }
        return this;
    }

    public ClassGraph verbose(boolean verbose) {
        if (verbose) {
            verbose();
        }
        return this;
    }

    public ClassGraph enableAllInfo() {
        enableClassInfo();
        enableFieldInfo();
        enableMethodInfo();
        enableAnnotationInfo();
        enableStaticFinalFieldConstantInitializerValues();
        ignoreClassVisibility();
        ignoreFieldVisibility();
        ignoreMethodVisibility();
        return this;
    }

    public ClassGraph enableClassInfo() {
        this.scanSpec.enableClassInfo = true;
        return this;
    }

    public ClassGraph ignoreClassVisibility() {
        enableClassInfo();
        this.scanSpec.ignoreClassVisibility = true;
        return this;
    }

    public ClassGraph enableMethodInfo() {
        enableClassInfo();
        this.scanSpec.enableMethodInfo = true;
        return this;
    }

    public ClassGraph ignoreMethodVisibility() {
        enableClassInfo();
        enableMethodInfo();
        this.scanSpec.ignoreMethodVisibility = true;
        return this;
    }

    public ClassGraph enableFieldInfo() {
        enableClassInfo();
        this.scanSpec.enableFieldInfo = true;
        return this;
    }

    public ClassGraph ignoreFieldVisibility() {
        enableClassInfo();
        enableFieldInfo();
        this.scanSpec.ignoreFieldVisibility = true;
        return this;
    }

    public ClassGraph enableStaticFinalFieldConstantInitializerValues() {
        enableClassInfo();
        enableFieldInfo();
        this.scanSpec.enableStaticFinalFieldConstantInitializerValues = true;
        return this;
    }

    public ClassGraph enableAnnotationInfo() {
        enableClassInfo();
        this.scanSpec.enableAnnotationInfo = true;
        return this;
    }

    public ClassGraph enableInterClassDependencies() {
        enableClassInfo();
        enableFieldInfo();
        enableMethodInfo();
        enableAnnotationInfo();
        ignoreClassVisibility();
        ignoreFieldVisibility();
        ignoreMethodVisibility();
        this.scanSpec.enableInterClassDependencies = true;
        return this;
    }

    public ClassGraph disableRuntimeInvisibleAnnotations() {
        enableClassInfo();
        this.scanSpec.disableRuntimeInvisibleAnnotations = true;
        return this;
    }

    public ClassGraph disableJarScanning() {
        this.scanSpec.scanJars = false;
        return this;
    }

    public ClassGraph disableNestedJarScanning() {
        this.scanSpec.scanNestedJars = false;
        return this;
    }

    public ClassGraph disableDirScanning() {
        this.scanSpec.scanDirs = false;
        return this;
    }

    public ClassGraph disableModuleScanning() {
        this.scanSpec.scanModules = false;
        return this;
    }

    public ClassGraph enableExternalClasses() {
        enableClassInfo();
        this.scanSpec.enableExternalClasses = true;
        return this;
    }

    public ClassGraph initializeLoadedClasses() {
        this.scanSpec.initializeLoadedClasses = true;
        return this;
    }

    public ClassGraph removeTemporaryFilesAfterScan() {
        this.scanSpec.removeTemporaryFilesAfterScan = true;
        return this;
    }

    public ClassGraph overrideClasspath(String overrideClasspath) {
        if (overrideClasspath.isEmpty()) {
            throw new IllegalArgumentException("Can't override classpath with an empty path");
        }
        for (String classpathElement : JarUtils.smartPathSplit(overrideClasspath, this.scanSpec)) {
            this.scanSpec.addClasspathOverride(classpathElement);
        }
        return this;
    }

    public ClassGraph overrideClasspath(Iterable<?> overrideClasspathElements) {
        if (!overrideClasspathElements.iterator().hasNext()) {
            throw new IllegalArgumentException("Can't override classpath with an empty path");
        }
        Iterator<?> it = overrideClasspathElements.iterator();
        while (it.hasNext()) {
            this.scanSpec.addClasspathOverride(it.next());
        }
        return this;
    }

    public ClassGraph overrideClasspath(Object... overrideClasspathElements) {
        if (overrideClasspathElements.length == 0) {
            throw new IllegalArgumentException("Can't override classpath with an empty path");
        }
        for (Object classpathElement : overrideClasspathElements) {
            this.scanSpec.addClasspathOverride(classpathElement);
        }
        return this;
    }

    public ClassGraph filterClasspathElements(ClasspathElementFilter classpathElementFilter) {
        this.scanSpec.filterClasspathElements(classpathElementFilter);
        return this;
    }

    public ClassGraph addClassLoader(ClassLoader classLoader) {
        this.scanSpec.addClassLoader(classLoader);
        return this;
    }

    public ClassGraph overrideClassLoaders(ClassLoader... overrideClassLoaders) {
        this.scanSpec.overrideClassLoaders(overrideClassLoaders);
        return this;
    }

    public ClassGraph ignoreParentClassLoaders() {
        this.scanSpec.ignoreParentClassLoaders = true;
        return this;
    }

    public ClassGraph addModuleLayer(Object moduleLayer) {
        this.scanSpec.addModuleLayer(moduleLayer);
        return this;
    }

    public ClassGraph overrideModuleLayers(Object... overrideModuleLayers) {
        this.scanSpec.overrideModuleLayers(overrideModuleLayers);
        return this;
    }

    public ClassGraph ignoreParentModuleLayers() {
        this.scanSpec.ignoreParentModuleLayers = true;
        return this;
    }

    public ClassGraph whitelistPackages(String... packageNames) {
        enableClassInfo();
        for (String packageName : packageNames) {
            String packageNameNormalized = WhiteBlackList.normalizePackageOrClassName(packageName);
            if (packageNameNormalized.startsWith("!") || packageNameNormalized.startsWith("-")) {
                throw new IllegalArgumentException("This style of whitelisting/blacklisting is no longer supported: " + packageNameNormalized);
            }
            this.scanSpec.packageWhiteBlackList.addToWhitelist(packageNameNormalized);
            String path = WhiteBlackList.packageNameToPath(packageNameNormalized);
            this.scanSpec.pathWhiteBlackList.addToWhitelist(path + "/");
            if (packageNameNormalized.isEmpty()) {
                this.scanSpec.pathWhiteBlackList.addToWhitelist("");
            }
            if (!packageNameNormalized.contains("*")) {
                if (packageNameNormalized.isEmpty()) {
                    this.scanSpec.packagePrefixWhiteBlackList.addToWhitelist("");
                    this.scanSpec.pathPrefixWhiteBlackList.addToWhitelist("");
                } else {
                    this.scanSpec.packagePrefixWhiteBlackList.addToWhitelist(packageNameNormalized + Mapper.IGNORED_FIELDNAME);
                    this.scanSpec.pathPrefixWhiteBlackList.addToWhitelist(path + "/");
                }
            }
        }
        return this;
    }

    public ClassGraph whitelistPaths(String... paths) {
        for (String path : paths) {
            String pathNormalized = WhiteBlackList.normalizePath(path);
            String packageName = WhiteBlackList.pathToPackageName(pathNormalized);
            this.scanSpec.packageWhiteBlackList.addToWhitelist(packageName);
            this.scanSpec.pathWhiteBlackList.addToWhitelist(pathNormalized + "/");
            if (pathNormalized.isEmpty()) {
                this.scanSpec.pathWhiteBlackList.addToWhitelist("");
            }
            if (!pathNormalized.contains("*")) {
                if (pathNormalized.isEmpty()) {
                    this.scanSpec.packagePrefixWhiteBlackList.addToWhitelist("");
                    this.scanSpec.pathPrefixWhiteBlackList.addToWhitelist("");
                } else {
                    this.scanSpec.packagePrefixWhiteBlackList.addToWhitelist(packageName + Mapper.IGNORED_FIELDNAME);
                    this.scanSpec.pathPrefixWhiteBlackList.addToWhitelist(pathNormalized + "/");
                }
            }
        }
        return this;
    }

    public ClassGraph whitelistPackagesNonRecursive(String... packageNames) {
        enableClassInfo();
        for (String packageName : packageNames) {
            String packageNameNormalized = WhiteBlackList.normalizePackageOrClassName(packageName);
            if (packageNameNormalized.contains("*")) {
                throw new IllegalArgumentException("Cannot use a glob wildcard here: " + packageNameNormalized);
            }
            this.scanSpec.packageWhiteBlackList.addToWhitelist(packageNameNormalized);
            this.scanSpec.pathWhiteBlackList.addToWhitelist(WhiteBlackList.packageNameToPath(packageNameNormalized) + "/");
            if (packageNameNormalized.isEmpty()) {
                this.scanSpec.pathWhiteBlackList.addToWhitelist("");
            }
        }
        return this;
    }

    public ClassGraph whitelistPathsNonRecursive(String... paths) {
        for (String path : paths) {
            if (path.contains("*")) {
                throw new IllegalArgumentException("Cannot use a glob wildcard here: " + path);
            }
            String pathNormalized = WhiteBlackList.normalizePath(path);
            this.scanSpec.packageWhiteBlackList.addToWhitelist(WhiteBlackList.pathToPackageName(pathNormalized));
            this.scanSpec.pathWhiteBlackList.addToWhitelist(pathNormalized + "/");
            if (pathNormalized.isEmpty()) {
                this.scanSpec.pathWhiteBlackList.addToWhitelist("");
            }
        }
        return this;
    }

    public ClassGraph blacklistPackages(String... packageNames) {
        enableClassInfo();
        for (String packageName : packageNames) {
            String packageNameNormalized = WhiteBlackList.normalizePackageOrClassName(packageName);
            if (packageNameNormalized.isEmpty()) {
                throw new IllegalArgumentException("Blacklisting the root package (\"\") will cause nothing to be scanned");
            }
            this.scanSpec.packageWhiteBlackList.addToBlacklist(packageNameNormalized);
            String path = WhiteBlackList.packageNameToPath(packageNameNormalized);
            this.scanSpec.pathWhiteBlackList.addToBlacklist(path + "/");
            if (!packageNameNormalized.contains("*")) {
                this.scanSpec.packagePrefixWhiteBlackList.addToBlacklist(packageNameNormalized + Mapper.IGNORED_FIELDNAME);
                this.scanSpec.pathPrefixWhiteBlackList.addToBlacklist(path + "/");
            }
        }
        return this;
    }

    public ClassGraph blacklistPaths(String... paths) {
        for (String path : paths) {
            String pathNormalized = WhiteBlackList.normalizePath(path);
            if (pathNormalized.isEmpty()) {
                throw new IllegalArgumentException("Blacklisting the root package (\"\") will cause nothing to be scanned");
            }
            String packageName = WhiteBlackList.pathToPackageName(pathNormalized);
            this.scanSpec.packageWhiteBlackList.addToBlacklist(packageName);
            this.scanSpec.pathWhiteBlackList.addToBlacklist(pathNormalized + "/");
            if (!pathNormalized.contains("*")) {
                this.scanSpec.packagePrefixWhiteBlackList.addToBlacklist(packageName + Mapper.IGNORED_FIELDNAME);
                this.scanSpec.pathPrefixWhiteBlackList.addToBlacklist(pathNormalized + "/");
            }
        }
        return this;
    }

    public ClassGraph whitelistClasses(String... classNames) {
        enableClassInfo();
        for (String className : classNames) {
            if (className.contains("*")) {
                throw new IllegalArgumentException("Cannot use a glob wildcard here: " + className);
            }
            String classNameNormalized = WhiteBlackList.normalizePackageOrClassName(className);
            this.scanSpec.classWhiteBlackList.addToWhitelist(classNameNormalized);
            this.scanSpec.classfilePathWhiteBlackList.addToWhitelist(WhiteBlackList.classNameToClassfilePath(classNameNormalized));
            String packageName = PackageInfo.getParentPackageName(classNameNormalized);
            this.scanSpec.classPackageWhiteBlackList.addToWhitelist(packageName);
            this.scanSpec.classPackagePathWhiteBlackList.addToWhitelist(WhiteBlackList.packageNameToPath(packageName) + "/");
        }
        return this;
    }

    public ClassGraph blacklistClasses(String... classNames) {
        enableClassInfo();
        for (String className : classNames) {
            if (className.contains("*")) {
                throw new IllegalArgumentException("Cannot use a glob wildcard here: " + className);
            }
            String classNameNormalized = WhiteBlackList.normalizePackageOrClassName(className);
            this.scanSpec.classWhiteBlackList.addToBlacklist(classNameNormalized);
            this.scanSpec.classfilePathWhiteBlackList.addToBlacklist(WhiteBlackList.classNameToClassfilePath(classNameNormalized));
        }
        return this;
    }

    public ClassGraph whitelistJars(String... jarLeafNames) {
        for (String jarLeafName : jarLeafNames) {
            String leafName = JarUtils.leafName(jarLeafName);
            if (!leafName.equals(jarLeafName)) {
                throw new IllegalArgumentException("Can only whitelist jars by leafname: " + jarLeafName);
            }
            this.scanSpec.jarWhiteBlackList.addToWhitelist(leafName);
        }
        return this;
    }

    public ClassGraph blacklistJars(String... jarLeafNames) {
        for (String jarLeafName : jarLeafNames) {
            String leafName = JarUtils.leafName(jarLeafName);
            if (!leafName.equals(jarLeafName)) {
                throw new IllegalArgumentException("Can only blacklist jars by leafname: " + jarLeafName);
            }
            this.scanSpec.jarWhiteBlackList.addToBlacklist(leafName);
        }
        return this;
    }

    private void whitelistOrBlacklistLibOrExtJars(boolean whitelist, String... jarLeafNames) {
        if (jarLeafNames.length == 0) {
            Iterator<String> it = SystemJarFinder.getJreLibOrExtJars().iterator();
            while (it.hasNext()) {
                whitelistOrBlacklistLibOrExtJars(whitelist, JarUtils.leafName(it.next()));
            }
            return;
        }
        for (String jarLeafName : jarLeafNames) {
            if (!JarUtils.leafName(jarLeafName).equals(jarLeafName)) {
                throw new IllegalArgumentException("Can only " + (whitelist ? "whitelist" : "blacklist") + " jars by leafname: " + jarLeafName);
            }
            if (jarLeafName.contains("*")) {
                Pattern pattern = WhiteBlackList.globToPattern(jarLeafName);
                boolean found = false;
                for (String libOrExtJarPath : SystemJarFinder.getJreLibOrExtJars()) {
                    String libOrExtJarLeafName = JarUtils.leafName(libOrExtJarPath);
                    if (pattern.matcher(libOrExtJarLeafName).matches()) {
                        if (!libOrExtJarLeafName.contains("*")) {
                            whitelistOrBlacklistLibOrExtJars(whitelist, libOrExtJarLeafName);
                        }
                        found = true;
                    }
                }
                if (!found && this.topLevelLog != null) {
                    this.topLevelLog.log("Could not find lib or ext jar matching wildcard: " + jarLeafName);
                }
            } else {
                boolean found2 = false;
                Iterator<String> it2 = SystemJarFinder.getJreLibOrExtJars().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String libOrExtJarPath2 = it2.next();
                    if (jarLeafName.equals(JarUtils.leafName(libOrExtJarPath2))) {
                        if (whitelist) {
                            this.scanSpec.libOrExtJarWhiteBlackList.addToWhitelist(jarLeafName);
                        } else {
                            this.scanSpec.libOrExtJarWhiteBlackList.addToBlacklist(jarLeafName);
                        }
                        if (this.topLevelLog != null) {
                            this.topLevelLog.log((whitelist ? "Whitelisting" : "Blacklisting") + " lib or ext jar: " + libOrExtJarPath2);
                        }
                        found2 = true;
                    }
                }
                if (!found2 && this.topLevelLog != null) {
                    this.topLevelLog.log("Could not find lib or ext jar: " + jarLeafName);
                }
            }
        }
    }

    public ClassGraph whitelistLibOrExtJars(String... jarLeafNames) {
        whitelistOrBlacklistLibOrExtJars(true, jarLeafNames);
        return this;
    }

    public ClassGraph blacklistLibOrExtJars(String... jarLeafNames) {
        whitelistOrBlacklistLibOrExtJars(false, jarLeafNames);
        return this;
    }

    public ClassGraph whitelistModules(String... moduleNames) {
        for (String moduleName : moduleNames) {
            this.scanSpec.moduleWhiteBlackList.addToWhitelist(WhiteBlackList.normalizePackageOrClassName(moduleName));
        }
        return this;
    }

    public ClassGraph blacklistModules(String... moduleNames) {
        for (String moduleName : moduleNames) {
            this.scanSpec.moduleWhiteBlackList.addToBlacklist(WhiteBlackList.normalizePackageOrClassName(moduleName));
        }
        return this;
    }

    public ClassGraph whitelistClasspathElementsContainingResourcePath(String... resourcePaths) {
        for (String resourcePath : resourcePaths) {
            this.scanSpec.classpathElementResourcePathWhiteBlackList.addToWhitelist(WhiteBlackList.normalizePath(resourcePath));
        }
        return this;
    }

    public ClassGraph blacklistClasspathElementsContainingResourcePath(String... resourcePaths) {
        for (String resourcePath : resourcePaths) {
            this.scanSpec.classpathElementResourcePathWhiteBlackList.addToBlacklist(WhiteBlackList.normalizePath(resourcePath));
        }
        return this;
    }

    public ClassGraph enableRemoteJarScanning() {
        this.scanSpec.enableURLScheme(URIUtil.HTTP);
        this.scanSpec.enableURLScheme(URIUtil.HTTPS);
        return this;
    }

    public ClassGraph enableURLScheme(String scheme) {
        this.scanSpec.enableURLScheme(scheme);
        return this;
    }

    public ClassGraph enableSystemJarsAndModules() {
        enableClassInfo();
        this.scanSpec.enableSystemJarsAndModules = true;
        return this;
    }

    public ClassGraph setMaxBufferedJarRAMSize(int maxBufferedJarRAMSize) {
        this.scanSpec.maxBufferedJarRAMSize = maxBufferedJarRAMSize;
        return this;
    }

    public ClassGraph enableMemoryMapping() {
        this.scanSpec.enableMemoryMapping = true;
        return this;
    }

    public ClassGraph enableRealtimeLogging() {
        verbose();
        LogNode.logInRealtime(true);
        return this;
    }

    public void scanAsync(final ExecutorService executorService, final int numParallelTasks, final ScanResultProcessor scanResultProcessor, final FailureHandler failureHandler) {
        if (scanResultProcessor == null) {
            throw new IllegalArgumentException("scanResultProcessor cannot be null");
        } else if (failureHandler == null) {
            throw new IllegalArgumentException("failureHandler cannot be null");
        } else {
            executorService.execute(new Runnable() { // from class: io.github.classgraph.ClassGraph.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Scanner(true, ClassGraph.this.scanSpec, executorService, numParallelTasks, scanResultProcessor, failureHandler, ClassGraph.this.topLevelLog).call();
                    } catch (InterruptedException | CancellationException | ExecutionException e) {
                        failureHandler.onFailure(e);
                    }
                }
            });
        }
    }

    private Future<ScanResult> scanAsync(boolean performScan, ExecutorService executorService, int numParallelTasks) {
        try {
            return executorService.submit(new Scanner(performScan, this.scanSpec, executorService, numParallelTasks, null, null, this.topLevelLog));
        } catch (InterruptedException e) {
            return executorService.submit(new Callable<ScanResult>() { // from class: io.github.classgraph.ClassGraph.2
                @Override // java.util.concurrent.Callable
                public ScanResult call() throws Exception {
                    throw e;
                }
            });
        }
    }

    public Future<ScanResult> scanAsync(ExecutorService executorService, int numParallelTasks) {
        return scanAsync(true, executorService, numParallelTasks);
    }

    public ScanResult scan(ExecutorService executorService, int numParallelTasks) {
        try {
            ScanResult scanResult = scanAsync(executorService, numParallelTasks).get();
            if (scanResult != null) {
                return scanResult;
            }
            throw new NullPointerException();
        } catch (InterruptedException | CancellationException e) {
            throw ClassGraphException.newClassGraphException("Scan interrupted", e);
        } catch (ExecutionException e2) {
            throw ClassGraphException.newClassGraphException("Uncaught exception during scan", InterruptionChecker.getCause(e2));
        }
    }

    public ScanResult scan(int numThreads) {
        AutoCloseableExecutorService executorService = new AutoCloseableExecutorService(numThreads);
        Throwable th = null;
        try {
            ScanResult scan = scan(executorService, numThreads);
            if (executorService != null) {
                if (0 != 0) {
                    try {
                        executorService.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                } else {
                    executorService.close();
                }
            }
            return scan;
        } catch (Throwable th3) {
            if (executorService != null) {
                if (0 != 0) {
                    try {
                        executorService.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                } else {
                    executorService.close();
                }
            }
            throw th3;
        }
    }

    public ScanResult scan() {
        return scan(DEFAULT_NUM_WORKER_THREADS);
    }

    /* access modifiers changed from: package-private */
    public ScanResult getClasspathScanResult(AutoCloseableExecutorService executorService) {
        try {
            ScanResult scanResult = scanAsync(false, executorService, DEFAULT_NUM_WORKER_THREADS).get();
            if (scanResult != null) {
                return scanResult;
            }
            throw new NullPointerException();
        } catch (InterruptedException | CancellationException e) {
            throw ClassGraphException.newClassGraphException("Scan interrupted", e);
        } catch (ExecutionException e2) {
            throw ClassGraphException.newClassGraphException("Uncaught exception during scan", InterruptionChecker.getCause(e2));
        }
    }

    public List<File> getClasspathFiles() {
        AutoCloseableExecutorService executorService = new AutoCloseableExecutorService(DEFAULT_NUM_WORKER_THREADS);
        Throwable th = null;
        try {
            ScanResult scanResult = getClasspathScanResult(executorService);
            th = null;
            try {
                try {
                    List<File> classpathFiles = scanResult.getClasspathFiles();
                    if (scanResult != null) {
                        if (r8 != null) {
                            try {
                                scanResult.close();
                            } catch (Throwable th2) {
                                r8.addSuppressed(th2);
                            }
                        } else {
                            scanResult.close();
                        }
                    }
                    return classpathFiles;
                } finally {
                    r8 = th;
                }
            } catch (Throwable th3) {
                if (scanResult != null) {
                    if (r8 != null) {
                        try {
                            scanResult.close();
                        } catch (Throwable th4) {
                            r8.addSuppressed(th4);
                        }
                    } else {
                        scanResult.close();
                    }
                }
                throw th3;
            }
        } finally {
            if (executorService != null) {
                if (0 != 0) {
                    try {
                        executorService.close();
                    } catch (Throwable th5) {
                        th.addSuppressed(th5);
                    }
                } else {
                    executorService.close();
                }
            }
        }
    }

    public String getClasspath() {
        return JarUtils.pathElementsToPathStr(getClasspathFiles());
    }

    public List<URI> getClasspathURIs() {
        AutoCloseableExecutorService executorService = new AutoCloseableExecutorService(DEFAULT_NUM_WORKER_THREADS);
        Throwable th = null;
        try {
            ScanResult scanResult = getClasspathScanResult(executorService);
            th = null;
            try {
                try {
                    List<URI> classpathURIs = scanResult.getClasspathURIs();
                    if (scanResult != null) {
                        if (r8 != null) {
                            try {
                                scanResult.close();
                            } catch (Throwable th2) {
                                r8.addSuppressed(th2);
                            }
                        } else {
                            scanResult.close();
                        }
                    }
                    return classpathURIs;
                } finally {
                    r8 = th;
                }
            } catch (Throwable th3) {
                if (scanResult != null) {
                    if (r8 != null) {
                        try {
                            scanResult.close();
                        } catch (Throwable th4) {
                            r8.addSuppressed(th4);
                        }
                    } else {
                        scanResult.close();
                    }
                }
                throw th3;
            }
        } finally {
            if (executorService != null) {
                if (0 != 0) {
                    try {
                        executorService.close();
                    } catch (Throwable th5) {
                        th.addSuppressed(th5);
                    }
                } else {
                    executorService.close();
                }
            }
        }
    }

    public List<URL> getClasspathURLs() {
        AutoCloseableExecutorService executorService = new AutoCloseableExecutorService(DEFAULT_NUM_WORKER_THREADS);
        Throwable th = null;
        try {
            ScanResult scanResult = getClasspathScanResult(executorService);
            th = null;
            try {
                try {
                    List<URL> classpathURLs = scanResult.getClasspathURLs();
                    if (scanResult != null) {
                        if (r8 != null) {
                            try {
                                scanResult.close();
                            } catch (Throwable th2) {
                                r8.addSuppressed(th2);
                            }
                        } else {
                            scanResult.close();
                        }
                    }
                    return classpathURLs;
                } finally {
                    r8 = th;
                }
            } catch (Throwable th3) {
                if (scanResult != null) {
                    if (r8 != null) {
                        try {
                            scanResult.close();
                        } catch (Throwable th4) {
                            r8.addSuppressed(th4);
                        }
                    } else {
                        scanResult.close();
                    }
                }
                throw th3;
            }
        } finally {
            if (executorService != null) {
                if (0 != 0) {
                    try {
                        executorService.close();
                    } catch (Throwable th5) {
                        th.addSuppressed(th5);
                    }
                } else {
                    executorService.close();
                }
            }
        }
    }

    public List<ModuleRef> getModules() {
        AutoCloseableExecutorService executorService = new AutoCloseableExecutorService(DEFAULT_NUM_WORKER_THREADS);
        Throwable th = null;
        try {
            ScanResult scanResult = getClasspathScanResult(executorService);
            th = null;
            try {
                try {
                    List<ModuleRef> modules = scanResult.getModules();
                    if (scanResult != null) {
                        if (r8 != null) {
                            try {
                                scanResult.close();
                            } catch (Throwable th2) {
                                r8.addSuppressed(th2);
                            }
                        } else {
                            scanResult.close();
                        }
                    }
                    return modules;
                } finally {
                    r8 = th;
                }
            } catch (Throwable th3) {
                if (scanResult != null) {
                    if (r8 != null) {
                        try {
                            scanResult.close();
                        } catch (Throwable th4) {
                            r8.addSuppressed(th4);
                        }
                    } else {
                        scanResult.close();
                    }
                }
                throw th3;
            }
        } finally {
            if (executorService != null) {
                if (0 != 0) {
                    try {
                        executorService.close();
                    } catch (Throwable th5) {
                        th.addSuppressed(th5);
                    }
                } else {
                    executorService.close();
                }
            }
        }
    }

    public ModulePathInfo getModulePathInfo() {
        return this.scanSpec.modulePathInfo;
    }
}
