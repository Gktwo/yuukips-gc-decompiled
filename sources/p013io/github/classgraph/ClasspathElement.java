package p013io.github.classgraph;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import nonapi.p019io.github.classgraph.concurrency.WorkQueue;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.JarUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;
import p013io.github.classgraph.Scanner;

/* access modifiers changed from: package-private */
/* renamed from: io.github.classgraph.ClasspathElement */
/* loaded from: grasscutter.jar:io/github/classgraph/ClasspathElement.class */
public abstract class ClasspathElement {
    int classpathElementIdx;
    List<String> nestedClasspathRootPrefixes;
    boolean skipClasspathElement;
    boolean containsSpecificallyWhitelistedClasspathElementResourcePath;
    List<ClasspathElement> childClasspathElementsOrdered;
    protected ClassLoader classLoader;
    String moduleNameFromModuleDescriptor;
    final ScanSpec scanSpec;
    final Queue<Map.Entry<Integer, ClasspathElement>> childClasspathElementsIndexed = new ConcurrentLinkedQueue();
    protected final List<Resource> whitelistedResources = new ArrayList();
    protected List<Resource> whitelistedClassfileResources = new ArrayList();
    protected final Map<File, Long> fileToLastModified = new ConcurrentHashMap();
    protected final AtomicBoolean scanned = new AtomicBoolean(false);

    /* access modifiers changed from: package-private */
    public abstract void open(WorkQueue<Scanner.ClasspathEntryWorkUnit> workQueue, LogNode logNode) throws InterruptedException;

    /* access modifiers changed from: package-private */
    public abstract void scanPaths(LogNode logNode);

    /* access modifiers changed from: package-private */
    public abstract Resource getResource(String str);

    /* access modifiers changed from: package-private */
    public abstract URI getURI();

    /* access modifiers changed from: package-private */
    public abstract File getFile();

    /* access modifiers changed from: package-private */
    public abstract String getModuleName();

    /* access modifiers changed from: package-private */
    public ClasspathElement(ClassLoader classLoader, ScanSpec scanSpec) {
        this.classLoader = classLoader;
        this.scanSpec = scanSpec;
    }

    /* access modifiers changed from: package-private */
    public ClassLoader getClassLoader() {
        return this.classLoader;
    }

    int getNumClassfileMatches() {
        if (this.whitelistedClassfileResources == null) {
            return 0;
        }
        return this.whitelistedClassfileResources.size();
    }

    protected void checkResourcePathWhiteBlackList(String relativePath, LogNode log) {
        if (this.scanSpec.classpathElementResourcePathWhiteBlackList.whitelistAndBlacklistAreEmpty()) {
            return;
        }
        if (this.scanSpec.classpathElementResourcePathWhiteBlackList.isBlacklisted(relativePath)) {
            if (log != null) {
                log.log("Reached blacklisted classpath element resource path, stopping scanning: " + relativePath);
            }
            this.skipClasspathElement = true;
        } else if (this.scanSpec.classpathElementResourcePathWhiteBlackList.isSpecificallyWhitelisted(relativePath)) {
            if (log != null) {
                log.log("Reached specifically whitelisted classpath element resource path: " + relativePath);
            }
            this.containsSpecificallyWhitelistedClasspathElementResourcePath = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void maskClassfiles(int classpathIdx, Set<String> classpathRelativePathsFound, LogNode log) {
        List<Resource> whitelistedClassfileResourcesFiltered = new ArrayList<>(this.whitelistedClassfileResources.size());
        boolean foundMasked = false;
        for (Resource res : this.whitelistedClassfileResources) {
            String pathRelativeToPackageRoot = res.getPath();
            if (pathRelativeToPackageRoot.equals("module-info.class") || pathRelativeToPackageRoot.equals("package-info.class") || pathRelativeToPackageRoot.endsWith("/package-info.class") || classpathRelativePathsFound.add(pathRelativeToPackageRoot)) {
                whitelistedClassfileResourcesFiltered.add(res);
            } else {
                foundMasked = true;
                if (log != null) {
                    log.log(String.format("%06d-1", Integer.valueOf(classpathIdx)), "Ignoring duplicate (masked) class " + JarUtils.classfilePathToClassName(pathRelativeToPackageRoot) + " found at " + res);
                }
            }
        }
        if (foundMasked) {
            this.whitelistedClassfileResources = whitelistedClassfileResourcesFiltered;
        }
    }

    protected void addWhitelistedResource(Resource resource, ScanSpec.ScanSpecPathMatch parentMatchStatus, boolean isClassfileOnly, LogNode log) {
        String logStr;
        String path = resource.getPath();
        boolean isClassFile = FileUtils.isClassfile(path);
        boolean isWhitelisted = false;
        if (!isClassFile) {
            isWhitelisted = true;
        } else if (this.scanSpec.enableClassInfo && !this.scanSpec.classfilePathWhiteBlackList.isBlacklisted(path)) {
            this.whitelistedClassfileResources.add(resource);
            isWhitelisted = true;
        }
        if (!isClassfileOnly) {
            this.whitelistedResources.add(resource);
        }
        if (log != null && isWhitelisted) {
            String type = isClassFile ? "classfile" : "resource";
            switch (parentMatchStatus) {
                case HAS_WHITELISTED_PATH_PREFIX:
                    logStr = "Found " + type + " within subpackage of whitelisted package: ";
                    break;
                case AT_WHITELISTED_PATH:
                    logStr = "Found " + type + " within whitelisted package: ";
                    break;
                case AT_WHITELISTED_CLASS_PACKAGE:
                    logStr = "Found specifically-whitelisted " + type + ": ";
                    break;
                default:
                    logStr = "Found whitelisted " + type + ": ";
                    break;
            }
            resource.scanLog = log.log("0:" + path, logStr + path + (path.equals(resource.getPathRelativeToClasspathElement()) ? "" : " ; full path: " + resource.getPathRelativeToClasspathElement()));
        }
    }

    protected void finishScanPaths(LogNode log) {
        if (log != null) {
            if (this.whitelistedResources.isEmpty() && this.whitelistedClassfileResources.isEmpty()) {
                log.log(this.scanSpec.enableClassInfo ? "No whitelisted classfiles or resources found" : "Classfile scanning is disabled, and no whitelisted resources found");
            } else if (this.whitelistedResources.isEmpty()) {
                log.log("No whitelisted resources found");
            } else if (this.whitelistedClassfileResources.isEmpty()) {
                log.log(this.scanSpec.enableClassInfo ? "No whitelisted classfiles found" : "Classfile scanning is disabled");
            }
        }
        if (log != null) {
            log.addElapsedTime();
        }
    }

    protected LogNode log(int classpathElementIdx, String msg, LogNode log) {
        return log.log(String.format("%07d", Integer.valueOf(classpathElementIdx)), msg);
    }
}
