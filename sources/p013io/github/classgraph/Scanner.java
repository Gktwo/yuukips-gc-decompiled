package p013io.github.classgraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import net.bytebuddy.description.type.PackageDescription;
import nonapi.p019io.github.classgraph.classpath.ClasspathFinder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.classpath.ModuleFinder;
import nonapi.p019io.github.classgraph.concurrency.AutoCloseableExecutorService;
import nonapi.p019io.github.classgraph.concurrency.InterruptionChecker;
import nonapi.p019io.github.classgraph.concurrency.SingletonMap;
import nonapi.p019io.github.classgraph.concurrency.WorkQueue;
import nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;
import nonapi.p019io.github.classgraph.utils.FastPathResolver;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.JarUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;
import org.eclipse.jetty.util.URIUtil;
import org.quartz.xml.XMLSchedulingDataProcessor;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.github.classgraph.ClassGraph;
import p013io.github.classgraph.Classfile;

/* access modifiers changed from: package-private */
/* renamed from: io.github.classgraph.Scanner */
/* loaded from: grasscutter.jar:io/github/classgraph/Scanner.class */
public class Scanner implements Callable<ScanResult> {
    private final ScanSpec scanSpec;
    public boolean performScan;
    private final NestedJarHandler nestedJarHandler;
    private final ExecutorService executorService;
    private final InterruptionChecker interruptionChecker;
    private final int numParallelTasks;
    private final ClassGraph.ScanResultProcessor scanResultProcessor;
    private final ClassGraph.FailureHandler failureHandler;
    private final LogNode topLevelLog;
    private final ClasspathFinder classpathFinder;
    private final List<ClasspathElementModule> moduleOrder;
    private final ClassLoader[] classLoaderOrderRespectingParentDelegation;
    private static final Comparator<Map.Entry<Integer, ClasspathElement>> INDEXED_CLASSPATH_ELEMENT_COMPARATOR = new Comparator<Map.Entry<Integer, ClasspathElement>>() { // from class: io.github.classgraph.Scanner.1
        public int compare(Map.Entry<Integer, ClasspathElement> o1, Map.Entry<Integer, ClasspathElement> o2) {
            return o1.getKey().intValue() - o2.getKey().intValue();
        }
    };
    private final SingletonMap<ClasspathOrder.ClasspathElementAndClassLoader, ClasspathElement, IOException> classpathEntryToClasspathElementSingletonMap = new SingletonMap<ClasspathOrder.ClasspathElementAndClassLoader, ClasspathElement, IOException>() { // from class: io.github.classgraph.Scanner.2
        public ClasspathElement newInstance(ClasspathOrder.ClasspathElementAndClassLoader classpathEntry, LogNode log) throws IOException, InterruptedException {
            String classpathEntryPathStr;
            Object classpathEntryObj = classpathEntry.classpathElementRoot;
            String dirOrPathPackageRoot = classpathEntry.dirOrPathPackageRoot;
            while (dirOrPathPackageRoot.startsWith("/")) {
                dirOrPathPackageRoot = dirOrPathPackageRoot.substring(1);
            }
            if (classpathEntryObj instanceof String) {
                String classpathEntryStr = (String) classpathEntryObj;
                if (JarUtils.URL_SCHEME_PATTERN.matcher(classpathEntryStr).matches()) {
                    try {
                        classpathEntryObj = new URL(classpathEntryStr);
                    } catch (MalformedURLException e) {
                        throw new IOException("Malformed URL: " + classpathEntryStr);
                    }
                }
            }
            if (classpathEntryObj instanceof URL) {
                URL classpathEntryURL = (URL) classpathEntryObj;
                String scheme = classpathEntryURL.getProtocol();
                if ("jar".equals(scheme)) {
                    try {
                        classpathEntryURL = new URL(URLDecoder.decode(classpathEntryURL.toString(), "UTF-8").substring(4));
                        scheme = classpathEntryURL.getProtocol();
                    } catch (MalformedURLException e2) {
                        throw new IOException("Could not strip 'jar:' prefix from " + classpathEntryObj, e2);
                    }
                }
                if (Action.FILE_ATTRIBUTE.equals(scheme)) {
                    classpathEntryPathStr = URLDecoder.decode(classpathEntryURL.getPath(), "UTF-8");
                } else if (URIUtil.HTTP.equals(scheme) || URIUtil.HTTPS.equals(scheme)) {
                    return new ClasspathElementZip(classpathEntryURL, classpathEntry.classLoader, Scanner.this.nestedJarHandler, Scanner.this.scanSpec);
                } else {
                    try {
                        Path path = Paths.get(classpathEntryURL.toURI());
                        if (Files.isDirectory(path, new LinkOption[0])) {
                            return new ClasspathElementPathDir(path, dirOrPathPackageRoot, classpathEntry.classLoader, Scanner.this.nestedJarHandler, Scanner.this.scanSpec);
                        }
                    } catch (IllegalArgumentException | SecurityException | URISyntaxException e3) {
                        throw new IOException("Cannot handle URL " + classpathEntryURL + " : " + e3.getMessage());
                    } catch (FileSystemNotFoundException e4) {
                    }
                    return new ClasspathElementZip(classpathEntryURL, classpathEntry.classLoader, Scanner.this.nestedJarHandler, Scanner.this.scanSpec);
                }
            } else if (classpathEntryObj instanceof Path) {
                Path classpathEntryPath = (Path) classpathEntryObj;
                Path packageRootPath = classpathEntryPath.resolve(dirOrPathPackageRoot);
                if (FileUtils.canReadAndIsFile(packageRootPath)) {
                    return new ClasspathElementZip(classpathEntryPath.toUri(), classpathEntry.classLoader, Scanner.this.nestedJarHandler, Scanner.this.scanSpec);
                }
                if (FileUtils.canReadAndIsDir(packageRootPath)) {
                    return new ClasspathElementPathDir((Path) classpathEntryObj, dirOrPathPackageRoot, classpathEntry.classLoader, Scanner.this.nestedJarHandler, Scanner.this.scanSpec);
                }
                throw new IOException("Path is not a directory or file: " + classpathEntryPath);
            } else {
                classpathEntryPathStr = classpathEntryObj.toString();
            }
            String pathNormalized = FastPathResolver.resolve(FileUtils.CURR_DIR_PATH, classpathEntryPathStr);
            int plingIdx = pathNormalized.indexOf(33);
            File fileCanonicalized = new File(plingIdx < 0 ? pathNormalized : pathNormalized.substring(0, plingIdx)).getCanonicalFile();
            if (!fileCanonicalized.exists()) {
                throw new FileNotFoundException();
            } else if (!FileUtils.canRead(fileCanonicalized)) {
                throw new IOException("Cannot read file or directory");
            } else {
                boolean isJar = classpathEntryPathStr.regionMatches(true, 0, XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX, 0, 4) || plingIdx > 0;
                if (fileCanonicalized.isFile()) {
                    isJar = true;
                } else if (!fileCanonicalized.isDirectory()) {
                    throw new IOException("Not a normal file or directory");
                } else if (isJar) {
                    throw new IOException("Expected jar, found directory");
                }
                String baseFileCanonicalPathNormalized = FastPathResolver.resolve(FileUtils.CURR_DIR_PATH, fileCanonicalized.getPath());
                String canonicalPathNormalized = plingIdx < 0 ? baseFileCanonicalPathNormalized : baseFileCanonicalPathNormalized + pathNormalized.substring(plingIdx);
                if (canonicalPathNormalized.equals(pathNormalized)) {
                    return isJar ? new ClasspathElementZip(canonicalPathNormalized, classpathEntry.classLoader, Scanner.this.nestedJarHandler, Scanner.this.scanSpec) : new ClasspathElementFileDir(fileCanonicalized, dirOrPathPackageRoot, classpathEntry.classLoader, Scanner.this.nestedJarHandler, Scanner.this.scanSpec);
                }
                try {
                    return get(new ClasspathOrder.ClasspathElementAndClassLoader(canonicalPathNormalized, dirOrPathPackageRoot, classpathEntry.classLoader), log);
                } catch (SingletonMap.NullSingletonException e5) {
                    throw new IOException("Cannot get classpath element for canonical path " + canonicalPathNormalized + " : " + e5);
                }
            }
        }
    };

    /* access modifiers changed from: package-private */
    public Scanner(boolean performScan, ScanSpec scanSpec, ExecutorService executorService, int numParallelTasks, ClassGraph.ScanResultProcessor scanResultProcessor, ClassGraph.FailureHandler failureHandler, LogNode topLevelLog) throws InterruptedException {
        this.scanSpec = scanSpec;
        this.performScan = performScan;
        scanSpec.sortPrefixes();
        scanSpec.log(topLevelLog);
        if (topLevelLog != null) {
            if (scanSpec.pathWhiteBlackList != null && scanSpec.packagePrefixWhiteBlackList.isSpecificallyWhitelisted("")) {
                topLevelLog.log("Note: There is no need to whitelist the root package (\"\") -- not whitelisting anything will have the same effect of causing all packages to be scanned");
            }
            topLevelLog.log("Number of worker threads: " + numParallelTasks);
        }
        this.executorService = executorService;
        this.interruptionChecker = executorService instanceof AutoCloseableExecutorService ? ((AutoCloseableExecutorService) executorService).interruptionChecker : new InterruptionChecker();
        this.nestedJarHandler = new NestedJarHandler(scanSpec, this.interruptionChecker);
        this.numParallelTasks = numParallelTasks;
        this.scanResultProcessor = scanResultProcessor;
        this.failureHandler = failureHandler;
        this.topLevelLog = topLevelLog;
        LogNode classpathFinderLog = topLevelLog == null ? null : topLevelLog.log("Finding classpath");
        this.classpathFinder = new ClasspathFinder(scanSpec, classpathFinderLog);
        this.classLoaderOrderRespectingParentDelegation = this.classpathFinder.getClassLoaderOrderRespectingParentDelegation();
        try {
            this.moduleOrder = new ArrayList();
            ModuleFinder moduleFinder = this.classpathFinder.getModuleFinder();
            if (moduleFinder != null) {
                List<ModuleRef> systemModuleRefs = moduleFinder.getSystemModuleRefs();
                ClassLoader defaultClassLoader = (this.classLoaderOrderRespectingParentDelegation == null || this.classLoaderOrderRespectingParentDelegation.length == 0) ? null : this.classLoaderOrderRespectingParentDelegation[0];
                if (systemModuleRefs != null) {
                    for (ModuleRef systemModuleRef : systemModuleRefs) {
                        String moduleName = systemModuleRef.getName();
                        if ((scanSpec.enableSystemJarsAndModules && scanSpec.moduleWhiteBlackList.whitelistAndBlacklistAreEmpty()) || scanSpec.moduleWhiteBlackList.isSpecificallyWhitelistedAndNotBlacklisted(moduleName)) {
                            ClasspathElementModule classpathElementModule = new ClasspathElementModule(systemModuleRef, defaultClassLoader, this.nestedJarHandler.moduleRefToModuleReaderProxyRecyclerMap, scanSpec);
                            this.moduleOrder.add(classpathElementModule);
                            classpathElementModule.open(null, classpathFinderLog);
                        } else if (classpathFinderLog != null) {
                            classpathFinderLog.log("Skipping non-whitelisted or blacklisted system module: " + moduleName);
                        }
                    }
                }
                List<ModuleRef> nonSystemModuleRefs = moduleFinder.getNonSystemModuleRefs();
                if (nonSystemModuleRefs != null) {
                    for (ModuleRef nonSystemModuleRef : nonSystemModuleRefs) {
                        String moduleName2 = nonSystemModuleRef.getName();
                        moduleName2 = moduleName2 == null ? "" : moduleName2;
                        if (scanSpec.moduleWhiteBlackList.isWhitelistedAndNotBlacklisted(moduleName2)) {
                            ClasspathElementModule classpathElementModule2 = new ClasspathElementModule(nonSystemModuleRef, defaultClassLoader, this.nestedJarHandler.moduleRefToModuleReaderProxyRecyclerMap, scanSpec);
                            this.moduleOrder.add(classpathElementModule2);
                            classpathElementModule2.open(null, classpathFinderLog);
                        } else if (classpathFinderLog != null) {
                            classpathFinderLog.log("Skipping non-whitelisted or blacklisted module: " + moduleName2);
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            this.nestedJarHandler.close(null);
            throw e;
        }
    }

    private static void findClasspathOrderRec(ClasspathElement currClasspathElement, Set<ClasspathElement> visitedClasspathElts, List<ClasspathElement> order) {
        if (visitedClasspathElts.add(currClasspathElement)) {
            if (!currClasspathElement.skipClasspathElement) {
                order.add(currClasspathElement);
            }
            for (ClasspathElement childClasspathElt : currClasspathElement.childClasspathElementsOrdered) {
                findClasspathOrderRec(childClasspathElt, visitedClasspathElts, order);
            }
        }
    }

    private static List<ClasspathElement> orderClasspathElements(Collection<Map.Entry<Integer, ClasspathElement>> classpathEltsIndexed) {
        List<Map.Entry<Integer, ClasspathElement>> classpathEltsIndexedOrdered = new ArrayList<>(classpathEltsIndexed);
        CollectionUtils.sortIfNotEmpty(classpathEltsIndexedOrdered, INDEXED_CLASSPATH_ELEMENT_COMPARATOR);
        List<ClasspathElement> classpathEltsOrdered = new ArrayList<>(classpathEltsIndexedOrdered.size());
        for (Map.Entry<Integer, ClasspathElement> ent : classpathEltsIndexedOrdered) {
            classpathEltsOrdered.add(ent.getValue());
        }
        return classpathEltsOrdered;
    }

    private List<ClasspathElement> findClasspathOrder(Set<ClasspathElement> uniqueClasspathElements, Queue<Map.Entry<Integer, ClasspathElement>> toplevelClasspathEltsIndexed) {
        List<ClasspathElement> toplevelClasspathEltsOrdered = orderClasspathElements(toplevelClasspathEltsIndexed);
        for (ClasspathElement classpathElt : uniqueClasspathElements) {
            classpathElt.childClasspathElementsOrdered = orderClasspathElements(classpathElt.childClasspathElementsIndexed);
        }
        Set<ClasspathElement> visitedClasspathElts = new HashSet<>();
        List<ClasspathElement> order = new ArrayList<>();
        for (ClasspathElement toplevelClasspathElt : toplevelClasspathEltsOrdered) {
            findClasspathOrderRec(toplevelClasspathElt, visitedClasspathElts, order);
        }
        return order;
    }

    private <W> void processWorkUnits(Collection<W> workUnits, LogNode log, WorkQueue.WorkUnitProcessor<W> workUnitProcessor) throws InterruptedException, ExecutionException {
        WorkQueue.runWorkQueue(workUnits, this.executorService, this.interruptionChecker, this.numParallelTasks, log, workUnitProcessor);
        if (log != null) {
            log.addElapsedTime();
        }
        this.interruptionChecker.check();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.github.classgraph.Scanner$ClasspathEntryWorkUnit */
    /* loaded from: grasscutter.jar:io/github/classgraph/Scanner$ClasspathEntryWorkUnit.class */
    public static class ClasspathEntryWorkUnit {
        private final ClasspathOrder.ClasspathElementAndClassLoader rawClasspathEntry;
        private final ClasspathElement parentClasspathElement;
        private final int orderWithinParentClasspathElement;

        public ClasspathEntryWorkUnit(ClasspathOrder.ClasspathElementAndClassLoader rawClasspathEntry, ClasspathElement parentClasspathElement, int orderWithinParentClasspathElement) {
            this.rawClasspathEntry = rawClasspathEntry;
            this.parentClasspathElement = parentClasspathElement;
            this.orderWithinParentClasspathElement = orderWithinParentClasspathElement;
        }
    }

    private WorkQueue.WorkUnitProcessor<ClasspathEntryWorkUnit> newClasspathEntryWorkUnitProcessor(final Set<ClasspathElement> openedClasspathElementsSet, final Queue<Map.Entry<Integer, ClasspathElement>> toplevelClasspathEltOrder) {
        return new WorkQueue.WorkUnitProcessor<ClasspathEntryWorkUnit>() { // from class: io.github.classgraph.Scanner.3
            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Try blocks wrapping queue limit reached! Please report as an issue!
                	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:88)
                	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:58)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:452)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:51)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                */
            public void processWorkUnit(p013io.github.classgraph.Scanner.ClasspathEntryWorkUnit r6, nonapi.p019io.github.classgraph.concurrency.WorkQueue<p013io.github.classgraph.Scanner.ClasspathEntryWorkUnit> r7, nonapi.p019io.github.classgraph.utils.LogNode r8) throws java.lang.InterruptedException {
                /*
                // Method dump skipped, instructions count: 272
                */
                throw new UnsupportedOperationException("Method not decompiled: p013io.github.classgraph.Scanner.C27373.processWorkUnit(io.github.classgraph.Scanner$ClasspathEntryWorkUnit, nonapi.io.github.classgraph.concurrency.WorkQueue, nonapi.io.github.classgraph.utils.LogNode):void");
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.github.classgraph.Scanner$ClassfileScanWorkUnit */
    /* loaded from: grasscutter.jar:io/github/classgraph/Scanner$ClassfileScanWorkUnit.class */
    public static class ClassfileScanWorkUnit {
        private final ClasspathElement classpathElement;
        private final Resource classfileResource;
        private final boolean isExternalClass;

        /* access modifiers changed from: package-private */
        public ClassfileScanWorkUnit(ClasspathElement classpathElement, Resource classfileResource, boolean isExternalClass) {
            this.classpathElement = classpathElement;
            this.classfileResource = classfileResource;
            this.isExternalClass = isExternalClass;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.github.classgraph.Scanner$ClassfileScannerWorkUnitProcessor */
    /* loaded from: grasscutter.jar:io/github/classgraph/Scanner$ClassfileScannerWorkUnitProcessor.class */
    public static class ClassfileScannerWorkUnitProcessor implements WorkQueue.WorkUnitProcessor<ClassfileScanWorkUnit> {
        private final ScanSpec scanSpec;
        private final List<ClasspathElement> classpathOrder;
        private final Set<String> whitelistedClassNamesFound;
        private final Queue<Classfile> scannedClassfiles;
        private final Set<String> classNamesScheduledForExtendedScanning = Collections.newSetFromMap(new ConcurrentHashMap());
        private final ConcurrentHashMap<String, String> stringInternMap = new ConcurrentHashMap<>();

        public ClassfileScannerWorkUnitProcessor(ScanSpec scanSpec, List<ClasspathElement> classpathOrder, Set<String> whitelistedClassNamesFound, Queue<Classfile> scannedClassfiles) {
            this.scanSpec = scanSpec;
            this.classpathOrder = classpathOrder;
            this.whitelistedClassNamesFound = whitelistedClassNamesFound;
            this.scannedClassfiles = scannedClassfiles;
        }

        public void processWorkUnit(ClassfileScanWorkUnit workUnit, WorkQueue<ClassfileScanWorkUnit> workQueue, LogNode log) throws InterruptedException {
            LogNode subLog = workUnit.classfileResource.scanLog == null ? null : workUnit.classfileResource.scanLog.log(workUnit.classfileResource.getPath(), "Parsing classfile");
            try {
                try {
                    try {
                        this.scannedClassfiles.add(new Classfile(workUnit.classpathElement, this.classpathOrder, this.whitelistedClassNamesFound, this.classNamesScheduledForExtendedScanning, workUnit.classfileResource.getPath(), workUnit.classfileResource, workUnit.isExternalClass, this.stringInternMap, workQueue, this.scanSpec, subLog));
                        if (subLog != null) {
                            subLog.addElapsedTime();
                        }
                    } catch (IOException e) {
                        if (subLog != null) {
                            subLog.log(workUnit.classfileResource.getPath(), "Could not read classfile: " + e);
                        }
                        if (subLog != null) {
                            subLog.addElapsedTime();
                        }
                    }
                } catch (Classfile.ClassfileFormatException e2) {
                    if (subLog != null) {
                        subLog.log(workUnit.classfileResource.getPath(), "Invalid classfile: " + e2.getMessage());
                    }
                    if (subLog != null) {
                        subLog.addElapsedTime();
                    }
                } catch (Classfile.SkipClassException e3) {
                    if (subLog != null) {
                        subLog.log(workUnit.classfileResource.getPath(), "Skipping classfile: " + e3.getMessage());
                    }
                    if (subLog != null) {
                        subLog.addElapsedTime();
                    }
                }
            } catch (Throwable th) {
                if (subLog != null) {
                    subLog.addElapsedTime();
                }
                throw th;
            }
        }
    }

    private void findNestedClasspathElements(List<AbstractMap.SimpleEntry<String, ClasspathElement>> classpathElts, LogNode log) {
        char nextChar;
        CollectionUtils.sortIfNotEmpty(classpathElts, new Comparator<AbstractMap.SimpleEntry<String, ClasspathElement>>() { // from class: io.github.classgraph.Scanner.4
            public int compare(AbstractMap.SimpleEntry<String, ClasspathElement> o1, AbstractMap.SimpleEntry<String, ClasspathElement> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (int i = 0; i < classpathElts.size(); i++) {
            AbstractMap.SimpleEntry<String, ClasspathElement> ei = classpathElts.get(i);
            String basePath = ei.getKey();
            int basePathLen = basePath.length();
            for (int j = i + 1; j < classpathElts.size(); j++) {
                String comparePath = classpathElts.get(j).getKey();
                int comparePathLen = comparePath.length();
                boolean foundNestedClasspathRoot = false;
                if (comparePath.startsWith(basePath) && comparePathLen > basePathLen && ((nextChar = comparePath.charAt(basePathLen)) == '/' || nextChar == '!')) {
                    String nestedClasspathRelativePath = comparePath.substring(basePathLen + 1);
                    if (nestedClasspathRelativePath.indexOf(33) < 0) {
                        foundNestedClasspathRoot = true;
                        ClasspathElement baseElement = ei.getValue();
                        if (baseElement.nestedClasspathRootPrefixes == null) {
                            baseElement.nestedClasspathRootPrefixes = new ArrayList();
                        }
                        baseElement.nestedClasspathRootPrefixes.add(nestedClasspathRelativePath + "/");
                        if (log != null) {
                            log.log(basePath + " is a prefix of the nested element " + comparePath);
                        }
                    }
                }
                if (!foundNestedClasspathRoot) {
                    break;
                }
            }
        }
    }

    private void preprocessClasspathElementsByType(List<ClasspathElement> finalTraditionalClasspathEltOrder, LogNode classpathFinderLog) {
        List<AbstractMap.SimpleEntry<String, ClasspathElement>> classpathEltDirs = new ArrayList<>();
        List<AbstractMap.SimpleEntry<String, ClasspathElement>> classpathEltZips = new ArrayList<>();
        for (ClasspathElement classpathElt : finalTraditionalClasspathEltOrder) {
            if (classpathElt instanceof ClasspathElementFileDir) {
                classpathEltDirs.add(new AbstractMap.SimpleEntry<>(((ClasspathElementFileDir) classpathElt).getFile().getPath(), classpathElt));
            } else if (classpathElt instanceof ClasspathElementZip) {
                ClasspathElementZip classpathEltZip = (ClasspathElementZip) classpathElt;
                classpathEltZips.add(new AbstractMap.SimpleEntry<>(classpathEltZip.getZipFilePath(), classpathElt));
                if (classpathEltZip.logicalZipFile != null) {
                    if (classpathEltZip.logicalZipFile.addExportsManifestEntryValue != null) {
                        String[] smartPathSplit = JarUtils.smartPathSplit(classpathEltZip.logicalZipFile.addExportsManifestEntryValue, ' ', this.scanSpec);
                        int length = smartPathSplit.length;
                        for (int i = 0; i < length; i++) {
                            this.scanSpec.modulePathInfo.addExports.add(smartPathSplit[i] + "=ALL-UNNAMED");
                        }
                    }
                    if (classpathEltZip.logicalZipFile.addOpensManifestEntryValue != null) {
                        String[] smartPathSplit2 = JarUtils.smartPathSplit(classpathEltZip.logicalZipFile.addOpensManifestEntryValue, ' ', this.scanSpec);
                        int length2 = smartPathSplit2.length;
                        for (int i2 = 0; i2 < length2; i2++) {
                            this.scanSpec.modulePathInfo.addOpens.add(smartPathSplit2[i2] + "=ALL-UNNAMED");
                        }
                    }
                    if (classpathEltZip.logicalZipFile.automaticModuleNameManifestEntryValue != null) {
                        classpathEltZip.moduleNameFromManifestFile = classpathEltZip.logicalZipFile.automaticModuleNameManifestEntryValue;
                    }
                }
            }
        }
        findNestedClasspathElements(classpathEltDirs, classpathFinderLog);
        findNestedClasspathElements(classpathEltZips, classpathFinderLog);
    }

    private void maskClassfiles(List<ClasspathElement> classpathElementOrder, LogNode maskLog) {
        Set<String> whitelistedClasspathRelativePathsFound = new HashSet<>();
        for (int classpathIdx = 0; classpathIdx < classpathElementOrder.size(); classpathIdx++) {
            classpathElementOrder.get(classpathIdx).maskClassfiles(classpathIdx, whitelistedClasspathRelativePathsFound, maskLog);
        }
        if (maskLog != null) {
            maskLog.addElapsedTime();
        }
    }

    private ScanResult performScan(List<ClasspathElement> finalClasspathEltOrder, List<String> finalClasspathEltOrderStrs, ClassLoader[] classLoaderOrderRespectingParentDelegation) throws InterruptedException, ExecutionException {
        if (this.scanSpec.enableClassInfo) {
            maskClassfiles(finalClasspathEltOrder, this.topLevelLog == null ? null : this.topLevelLog.log("Masking classfiles"));
        }
        Map<File, Long> fileToLastModified = new HashMap<>();
        for (ClasspathElement classpathElement : finalClasspathEltOrder) {
            fileToLastModified.putAll(classpathElement.fileToLastModified);
        }
        Map<String, ClassInfo> classNameToClassInfo = new ConcurrentHashMap<>();
        Map<String, PackageInfo> packageNameToPackageInfo = new HashMap<>();
        Map<String, ModuleInfo> moduleNameToModuleInfo = new HashMap<>();
        if (this.scanSpec.enableClassInfo) {
            ArrayList arrayList = new ArrayList();
            Set<String> whitelistedClassNamesFound = new HashSet<>();
            for (ClasspathElement classpathElement2 : finalClasspathEltOrder) {
                for (Resource resource : classpathElement2.whitelistedClassfileResources) {
                    String className = JarUtils.classfilePathToClassName(resource.getPath());
                    if (whitelistedClassNamesFound.add(className) || className.equals("module-info") || className.equals(PackageDescription.PACKAGE_CLASS_NAME) || className.endsWith(".package-info")) {
                        arrayList.add(new ClassfileScanWorkUnit(classpathElement2, resource, false));
                    } else {
                        throw new IllegalArgumentException("Class " + className + " should not have been scheduled more than once for scanning due to classpath masking -- please report this bug at: https://github.com/classgraph/classgraph/issues");
                    }
                }
            }
            Queue<Classfile> scannedClassfiles = new ConcurrentLinkedQueue<>();
            processWorkUnits(arrayList, this.topLevelLog == null ? null : this.topLevelLog.log("Scanning classfiles"), new ClassfileScannerWorkUnitProcessor(this.scanSpec, finalClasspathEltOrder, Collections.unmodifiableSet(whitelistedClassNamesFound), scannedClassfiles));
            LogNode linkLog = this.topLevelLog == null ? null : this.topLevelLog.log("Linking related classfiles");
            while (!scannedClassfiles.isEmpty()) {
                scannedClassfiles.remove().link(classNameToClassInfo, packageNameToPackageInfo, moduleNameToModuleInfo);
            }
            if (linkLog != null) {
                linkLog.addElapsedTime();
            }
        } else if (this.topLevelLog != null) {
            this.topLevelLog.log("Classfile scanning is disabled");
        }
        return new ScanResult(this.scanSpec, finalClasspathEltOrder, finalClasspathEltOrderStrs, classLoaderOrderRespectingParentDelegation, classNameToClassInfo, packageNameToPackageInfo, moduleNameToModuleInfo, fileToLastModified, this.nestedJarHandler, this.topLevelLog);
    }

    private ScanResult openClasspathElementsThenScan() throws InterruptedException, ExecutionException {
        ArrayList arrayList = new ArrayList();
        for (ClasspathOrder.ClasspathElementAndClassLoader rawClasspathEntry : this.classpathFinder.getClasspathOrder().getOrder()) {
            arrayList.add(new ClasspathEntryWorkUnit(rawClasspathEntry, null, arrayList.size()));
        }
        Set<ClasspathElement> openedClasspathEltsSet = Collections.newSetFromMap(new ConcurrentHashMap());
        Queue<Map.Entry<Integer, ClasspathElement>> toplevelClasspathEltOrder = new ConcurrentLinkedQueue<>();
        processWorkUnits(arrayList, this.topLevelLog == null ? null : this.topLevelLog.log("Opening classpath elements"), newClasspathEntryWorkUnitProcessor(openedClasspathEltsSet, toplevelClasspathEltOrder));
        List<ClasspathElement> classpathEltOrder = findClasspathOrder(openedClasspathEltsSet, toplevelClasspathEltOrder);
        preprocessClasspathElementsByType(classpathEltOrder, this.topLevelLog == null ? null : this.topLevelLog.log("Finding nested classpath elements"));
        LogNode classpathOrderLog = this.topLevelLog == null ? null : this.topLevelLog.log("Final classpath element order:");
        int numElts = this.moduleOrder.size() + classpathEltOrder.size();
        ArrayList<ClasspathElement> arrayList2 = new ArrayList(numElts);
        List<String> finalClasspathEltOrderStrs = new ArrayList<>(numElts);
        int classpathOrderIdx = 0;
        for (ClasspathElementModule classpathElt : this.moduleOrder) {
            classpathOrderIdx++;
            classpathElt.classpathElementIdx = classpathOrderIdx;
            arrayList2.add(classpathElt);
            finalClasspathEltOrderStrs.add(classpathElt.toString());
            if (classpathOrderLog != null) {
                classpathOrderLog.log(classpathElt.getModuleRef().toString());
            }
        }
        for (ClasspathElement classpathElt2 : classpathEltOrder) {
            classpathOrderIdx++;
            classpathElt2.classpathElementIdx = classpathOrderIdx;
            arrayList2.add(classpathElt2);
            finalClasspathEltOrderStrs.add(classpathElt2.toString());
            if (classpathOrderLog != null) {
                classpathOrderLog.log(classpathElt2.toString());
            }
        }
        processWorkUnits(arrayList2, this.topLevelLog == null ? null : this.topLevelLog.log("Scanning classpath elements"), new WorkQueue.WorkUnitProcessor<ClasspathElement>() { // from class: io.github.classgraph.Scanner.5
            public void processWorkUnit(ClasspathElement classpathElement, WorkQueue<ClasspathElement> workQueueIgnored, LogNode pathScanLog) throws InterruptedException {
                classpathElement.scanPaths(pathScanLog);
            }
        });
        List<ClasspathElement> finalClasspathEltOrderFiltered = arrayList2;
        if (!this.scanSpec.classpathElementResourcePathWhiteBlackList.whitelistIsEmpty()) {
            finalClasspathEltOrderFiltered = new ArrayList<>(arrayList2.size());
            for (ClasspathElement classpathElement : arrayList2) {
                if (classpathElement.containsSpecificallyWhitelistedClasspathElementResourcePath) {
                    finalClasspathEltOrderFiltered.add(classpathElement);
                }
            }
        }
        if (this.performScan) {
            return performScan(finalClasspathEltOrderFiltered, finalClasspathEltOrderStrs, this.classLoaderOrderRespectingParentDelegation);
        }
        if (this.topLevelLog != null) {
            this.topLevelLog.log("Only returning classpath elements (not performing a scan)");
        }
        return new ScanResult(this.scanSpec, finalClasspathEltOrderFiltered, finalClasspathEltOrderStrs, this.classLoaderOrderRespectingParentDelegation, null, null, null, null, this.nestedJarHandler, this.topLevelLog);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x005d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.util.concurrent.Callable
    public p013io.github.classgraph.ScanResult call() throws java.lang.InterruptedException, java.util.concurrent.CancellationException, java.util.concurrent.ExecutionException {
        /*
        // Method dump skipped, instructions count: 328
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.github.classgraph.Scanner.call():io.github.classgraph.ScanResult");
    }
}
