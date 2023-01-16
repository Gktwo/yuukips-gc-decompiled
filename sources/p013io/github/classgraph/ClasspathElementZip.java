package p013io.github.classgraph;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import nonapi.p019io.github.classgraph.classloaderhandler.ClassLoaderHandlerRegistry;
import nonapi.p019io.github.classgraph.fastzipfilereader.FastZipEntry;
import nonapi.p019io.github.classgraph.fastzipfilereader.LogicalZipFile;
import nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler;
import nonapi.p019io.github.classgraph.fileslice.reader.ClassfileReader;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.FastPathResolver;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.JarUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.URLPathEncoder;
import nonapi.p019io.github.classgraph.utils.VersionFinder;

/* access modifiers changed from: package-private */
/* renamed from: io.github.classgraph.ClasspathElementZip */
/* loaded from: grasscutter.jar:io/github/classgraph/ClasspathElementZip.class */
public class ClasspathElementZip extends ClasspathElement {
    private final String rawPath;
    LogicalZipFile logicalZipFile;
    private String zipFilePath;
    private final NestedJarHandler nestedJarHandler;
    String moduleNameFromManifestFile;
    private String derivedAutomaticModuleName;
    private String packageRootPrefix = "";
    private final ConcurrentHashMap<String, Resource> relativePathToResource = new ConcurrentHashMap<>();

    /* access modifiers changed from: package-private */
    public ClasspathElementZip(Object rawPathObj, ClassLoader classLoader, NestedJarHandler nestedJarHandler, ScanSpec scanSpec) {
        super(classLoader, scanSpec);
        this.rawPath = rawPathObj.toString();
        this.zipFilePath = this.rawPath;
        this.nestedJarHandler = nestedJarHandler;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:25:0x00d0
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // p013io.github.classgraph.ClasspathElement
    void open(nonapi.p019io.github.classgraph.concurrency.WorkQueue<p013io.github.classgraph.Scanner.ClasspathEntryWorkUnit> r9, nonapi.p019io.github.classgraph.utils.LogNode r10) throws java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 1078
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.github.classgraph.ClasspathElementZip.open(nonapi.io.github.classgraph.concurrency.WorkQueue, nonapi.io.github.classgraph.utils.LogNode):void");
    }

    private Resource newResource(final FastZipEntry zipEntry, final String pathRelativeToPackageRoot) {
        return new Resource(this, zipEntry.uncompressedSize) { // from class: io.github.classgraph.ClasspathElementZip.1
            protected AtomicBoolean isOpen = new AtomicBoolean();

            @Override // p013io.github.classgraph.Resource
            public String getPath() {
                return pathRelativeToPackageRoot;
            }

            @Override // p013io.github.classgraph.Resource
            public String getPathRelativeToClasspathElement() {
                return zipEntry.entryName;
            }

            @Override // p013io.github.classgraph.Resource
            public long getLastModified() {
                return zipEntry.getLastModifiedTimeMillis();
            }

            @Override // p013io.github.classgraph.Resource
            public Set<PosixFilePermission> getPosixFilePermissions() {
                Set<PosixFilePermission> perms;
                int fileAttributes = zipEntry.fileAttributes;
                if (fileAttributes == 0) {
                    perms = null;
                } else {
                    perms = new HashSet<>();
                    if ((fileAttributes & 256) > 0) {
                        perms.add(PosixFilePermission.OWNER_READ);
                    }
                    if ((fileAttributes & 128) > 0) {
                        perms.add(PosixFilePermission.OWNER_WRITE);
                    }
                    if ((fileAttributes & 64) > 0) {
                        perms.add(PosixFilePermission.OWNER_EXECUTE);
                    }
                    if ((fileAttributes & 32) > 0) {
                        perms.add(PosixFilePermission.GROUP_READ);
                    }
                    if ((fileAttributes & 16) > 0) {
                        perms.add(PosixFilePermission.GROUP_WRITE);
                    }
                    if ((fileAttributes & 8) > 0) {
                        perms.add(PosixFilePermission.GROUP_EXECUTE);
                    }
                    if ((fileAttributes & 4) > 0) {
                        perms.add(PosixFilePermission.OTHERS_READ);
                    }
                    if ((fileAttributes & 2) > 0) {
                        perms.add(PosixFilePermission.OTHERS_WRITE);
                    }
                    if ((fileAttributes & 1) > 0) {
                        perms.add(PosixFilePermission.OTHERS_EXECUTE);
                    }
                }
                return perms;
            }

            @Override // p013io.github.classgraph.Resource
            public InputStream open() throws IOException {
                if (ClasspathElementZip.this.skipClasspathElement) {
                    throw new IOException("Jarfile could not be opened");
                } else if (this.isOpen.getAndSet(true)) {
                    throw new IOException("Resource is already open -- cannot open it again without first calling close()");
                } else {
                    try {
                        this.inputStream = zipEntry.getSlice().open();
                        this.length = zipEntry.uncompressedSize;
                        return this.inputStream;
                    } catch (IOException e) {
                        close();
                        throw e;
                    }
                }
            }

            /* access modifiers changed from: package-private */
            @Override // p013io.github.classgraph.Resource
            public ClassfileReader openClassfile() throws IOException {
                return new ClassfileReader(open());
            }

            @Override // p013io.github.classgraph.Resource
            public ByteBuffer read() throws IOException {
                if (ClasspathElementZip.this.skipClasspathElement) {
                    throw new IOException("Jarfile could not be opened");
                } else if (this.isOpen.getAndSet(true)) {
                    throw new IOException("Resource is already open -- cannot open it again without first calling close()");
                } else {
                    try {
                        this.byteBuffer = zipEntry.getSlice().read();
                        this.length = (long) this.byteBuffer.remaining();
                        return this.byteBuffer;
                    } catch (IOException e) {
                        close();
                        throw e;
                    }
                }
            }

            @Override // p013io.github.classgraph.Resource
            public byte[] load() throws IOException {
                if (ClasspathElementZip.this.skipClasspathElement) {
                    throw new IOException("Jarfile could not be opened");
                } else if (this.isOpen.getAndSet(true)) {
                    throw new IOException("Resource is already open -- cannot open it again without first calling close()");
                } else {
                    Throwable th = null;
                    try {
                        byte[] byteArray = zipEntry.getSlice().load();
                        this.length = (long) byteArray.length;
                        if (this != null) {
                            if (0 != 0) {
                                try {
                                    close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                close();
                            }
                        }
                        return byteArray;
                    } catch (Throwable th3) {
                        if (this != null) {
                            if (0 != 0) {
                                try {
                                    close();
                                } catch (Throwable th4) {
                                    th.addSuppressed(th4);
                                }
                            } else {
                                close();
                            }
                        }
                        throw th3;
                    }
                }
            }

            @Override // p013io.github.classgraph.Resource, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                close();
                if (this.isOpen.getAndSet(false) && this.byteBuffer != null) {
                    this.byteBuffer = null;
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public Resource getResource(String relativePath) {
        return this.relativePathToResource.get(relativePath);
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public void scanPaths(LogNode log) {
        if (this.logicalZipFile == null) {
            this.skipClasspathElement = true;
        }
        if (!this.skipClasspathElement) {
            if (this.scanned.getAndSet(true)) {
                throw new IllegalArgumentException("Already scanned classpath element " + getZipFilePath());
            }
            LogNode subLog = log == null ? null : log(this.classpathElementIdx, "Scanning jarfile classpath element " + getZipFilePath(), log);
            boolean isModularJar = false;
            if (VersionFinder.JAVA_MAJOR_VERSION >= 9) {
                String moduleName = this.moduleNameFromModuleDescriptor;
                if (moduleName == null || moduleName.isEmpty()) {
                    moduleName = this.moduleNameFromManifestFile;
                }
                if (moduleName != null && moduleName.isEmpty()) {
                    moduleName = null;
                }
                if (moduleName != null) {
                    isModularJar = true;
                }
            }
            Set<String> loggedNestedClasspathRootPrefixes = null;
            String prevParentRelativePath = null;
            ScanSpec.ScanSpecPathMatch prevParentMatchStatus = null;
            for (FastZipEntry zipEntry : this.logicalZipFile.entries) {
                String relativePath = zipEntry.entryNameUnversioned;
                if (relativePath.startsWith(LogicalZipFile.MULTI_RELEASE_PATH_PREFIX)) {
                    if (subLog != null) {
                        if (VersionFinder.JAVA_MAJOR_VERSION < 9) {
                            subLog.log("Skipping versioned entry in jar, because JRE version " + VersionFinder.JAVA_MAJOR_VERSION + " does not support this: " + relativePath);
                        } else {
                            subLog.log("Found unexpected versioned entry in jar (the jar's manifest file may be missing the \"Multi-Release\" key) -- skipping: " + relativePath);
                        }
                    }
                } else if (!isModularJar || relativePath.indexOf(47) >= 0 || !relativePath.endsWith(".class") || relativePath.equals("module-info.class")) {
                    if (this.nestedClasspathRootPrefixes != null) {
                        boolean reachedNestedRoot = false;
                        Iterator it = this.nestedClasspathRootPrefixes.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String nestedClasspathRoot = (String) it.next();
                            if (relativePath.startsWith(nestedClasspathRoot)) {
                                if (subLog != null) {
                                    if (loggedNestedClasspathRootPrefixes == null) {
                                        loggedNestedClasspathRootPrefixes = new HashSet<>();
                                    }
                                    if (loggedNestedClasspathRootPrefixes.add(nestedClasspathRoot)) {
                                        subLog.log("Reached nested classpath root, stopping recursion to avoid duplicate scanning: " + nestedClasspathRoot);
                                    }
                                }
                                reachedNestedRoot = true;
                            }
                        }
                        if (reachedNestedRoot) {
                            continue;
                        }
                    }
                    if (this.packageRootPrefix.isEmpty() || relativePath.startsWith(this.packageRootPrefix)) {
                        if (!this.packageRootPrefix.isEmpty()) {
                            relativePath = relativePath.substring(this.packageRootPrefix.length());
                        } else {
                            for (int i = 0; i < ClassLoaderHandlerRegistry.AUTOMATIC_PACKAGE_ROOT_PREFIXES.length; i++) {
                                if (relativePath.startsWith(ClassLoaderHandlerRegistry.AUTOMATIC_PACKAGE_ROOT_PREFIXES[i])) {
                                    relativePath = relativePath.substring(ClassLoaderHandlerRegistry.AUTOMATIC_PACKAGE_ROOT_PREFIXES[i].length());
                                }
                            }
                        }
                        checkResourcePathWhiteBlackList(relativePath, log);
                        if (!this.skipClasspathElement) {
                            int lastSlashIdx = relativePath.lastIndexOf(47);
                            String parentRelativePath = lastSlashIdx < 0 ? "/" : relativePath.substring(0, lastSlashIdx + 1);
                            ScanSpec.ScanSpecPathMatch parentMatchStatus = !parentRelativePath.equals(prevParentRelativePath) ? this.scanSpec.dirWhitelistMatchStatus(parentRelativePath) : prevParentMatchStatus;
                            prevParentRelativePath = parentRelativePath;
                            prevParentMatchStatus = parentMatchStatus;
                            if (parentMatchStatus != ScanSpec.ScanSpecPathMatch.HAS_BLACKLISTED_PATH_PREFIX) {
                                Resource resource = newResource(zipEntry, relativePath);
                                if (this.relativePathToResource.putIfAbsent(relativePath, resource) == null) {
                                    if (parentMatchStatus == ScanSpec.ScanSpecPathMatch.HAS_WHITELISTED_PATH_PREFIX || parentMatchStatus == ScanSpec.ScanSpecPathMatch.AT_WHITELISTED_PATH || (parentMatchStatus == ScanSpec.ScanSpecPathMatch.AT_WHITELISTED_CLASS_PACKAGE && this.scanSpec.classfileIsSpecificallyWhitelisted(relativePath))) {
                                        addWhitelistedResource(resource, parentMatchStatus, false, subLog);
                                    } else if (this.scanSpec.enableClassInfo && relativePath.equals("module-info.class")) {
                                        addWhitelistedResource(resource, parentMatchStatus, true, subLog);
                                    }
                                }
                            } else if (subLog != null) {
                                subLog.log("Skipping blacklisted path: " + relativePath);
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
            File zipfile = getFile();
            if (zipfile != null) {
                this.fileToLastModified.put(zipfile, Long.valueOf(zipfile.lastModified()));
            }
            finishScanPaths(subLog);
        }
    }

    @Override // p013io.github.classgraph.ClasspathElement
    public String getModuleName() {
        String moduleName = this.moduleNameFromModuleDescriptor;
        if (moduleName == null || moduleName.isEmpty()) {
            moduleName = this.moduleNameFromManifestFile;
        }
        if (moduleName == null || moduleName.isEmpty()) {
            if (this.derivedAutomaticModuleName == null) {
                this.derivedAutomaticModuleName = JarUtils.derivedAutomaticModuleName(this.zipFilePath);
            }
            moduleName = this.derivedAutomaticModuleName;
        }
        if (moduleName == null || moduleName.isEmpty()) {
            return null;
        }
        return moduleName;
    }

    /* access modifiers changed from: package-private */
    public String getZipFilePath() {
        return this.packageRootPrefix.isEmpty() ? this.zipFilePath : this.zipFilePath + "!/" + this.packageRootPrefix.substring(0, this.packageRootPrefix.length() - 1);
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public URI getURI() {
        try {
            return new URI(URLPathEncoder.normalizeURLPath(getZipFilePath()));
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Could not form URI: " + e);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public File getFile() {
        if (this.logicalZipFile != null) {
            return this.logicalZipFile.getPhysicalFile();
        }
        int plingIdx = this.rawPath.indexOf(33);
        return new File(FastPathResolver.resolve(FileUtils.CURR_DIR_PATH, plingIdx < 0 ? this.rawPath : this.rawPath.substring(0, plingIdx)));
    }

    public String toString() {
        return getZipFilePath();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClasspathElementZip)) {
            return false;
        }
        return getZipFilePath().equals(((ClasspathElementZip) obj).getZipFilePath());
    }

    public int hashCode() {
        return getZipFilePath().hashCode();
    }
}
