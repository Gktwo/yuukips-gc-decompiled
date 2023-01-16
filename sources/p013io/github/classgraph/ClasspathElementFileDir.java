package p013io.github.classgraph;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import nonapi.p019io.github.classgraph.classloaderhandler.ClassLoaderHandlerRegistry;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.concurrency.WorkQueue;
import nonapi.p019io.github.classgraph.fastzipfilereader.LogicalZipFile;
import nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler;
import nonapi.p019io.github.classgraph.fileslice.FileSlice;
import nonapi.p019io.github.classgraph.fileslice.reader.ClassfileReader;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.FastPathResolver;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.VersionFinder;
import p013io.github.classgraph.Scanner;

/* access modifiers changed from: package-private */
/* renamed from: io.github.classgraph.ClasspathElementFileDir */
/* loaded from: grasscutter.jar:io/github/classgraph/ClasspathElementFileDir.class */
public class ClasspathElementFileDir extends ClasspathElement {
    private final File classpathEltDir;
    private final File packageRootDir;
    private final Set<String> scannedCanonicalPaths = new HashSet();
    private final NestedJarHandler nestedJarHandler;

    /* access modifiers changed from: package-private */
    public ClasspathElementFileDir(File classpathEltDir, String packageRootPrefix, ClassLoader classLoader, NestedJarHandler nestedJarHandler, ScanSpec scanSpec) {
        super(classLoader, scanSpec);
        this.classpathEltDir = classpathEltDir;
        this.packageRootDir = new File(classpathEltDir, packageRootPrefix);
        this.nestedJarHandler = nestedJarHandler;
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public void open(WorkQueue<Scanner.ClasspathEntryWorkUnit> workQueue, LogNode log) {
        File[] listFiles;
        if (!this.scanSpec.scanDirs) {
            if (log != null) {
                log(this.classpathElementIdx, "Skipping classpath element, since dir scanning is disabled: " + this.classpathEltDir, log);
            }
            this.skipClasspathElement = true;
            return;
        }
        try {
            int childClasspathEntryIdx = 0;
            for (String libDirPrefix : ClassLoaderHandlerRegistry.AUTOMATIC_LIB_DIR_PREFIXES) {
                File libDir = new File(this.classpathEltDir, libDirPrefix);
                if (FileUtils.canReadAndIsDir(libDir) && (listFiles = libDir.listFiles()) != null) {
                    Arrays.sort(listFiles);
                    for (File file : listFiles) {
                        if (file.isFile() && file.getName().endsWith(".jar")) {
                            if (log != null) {
                                log(this.classpathElementIdx, "Found lib jar: " + file, log);
                            }
                            childClasspathEntryIdx++;
                            workQueue.addWorkUnit(new Scanner.ClasspathEntryWorkUnit(new ClasspathOrder.ClasspathElementAndClassLoader(file.getPath(), this.classLoader), this, childClasspathEntryIdx));
                        }
                    }
                }
            }
            if (this.packageRootDir.equals(this.classpathEltDir)) {
                String[] strArr = ClassLoaderHandlerRegistry.AUTOMATIC_PACKAGE_ROOT_PREFIXES;
                for (String packageRootPrefix : strArr) {
                    File packageRootDir = new File(this.classpathEltDir, packageRootPrefix);
                    if (FileUtils.canReadAndIsDir(packageRootDir)) {
                        if (log != null) {
                            log(this.classpathElementIdx, "Found package root: " + packageRootDir, log);
                        }
                        childClasspathEntryIdx++;
                        workQueue.addWorkUnit(new Scanner.ClasspathEntryWorkUnit(new ClasspathOrder.ClasspathElementAndClassLoader(this.classpathEltDir, packageRootPrefix, this.classLoader), this, childClasspathEntryIdx));
                    }
                }
            }
        } catch (SecurityException e) {
            if (log != null) {
                log(this.classpathElementIdx, "Skipping classpath element, since dir cannot be accessed: " + this.classpathEltDir, log);
            }
            this.skipClasspathElement = true;
        }
    }

    private Resource newResource(final String pathRelativeToPackageRoot, final File resourceFile, final NestedJarHandler nestedJarHandler) {
        return new Resource(this, resourceFile.length()) { // from class: io.github.classgraph.ClasspathElementFileDir.1
            private FileSlice fileSlice;
            protected AtomicBoolean isOpen = new AtomicBoolean();

            @Override // p013io.github.classgraph.Resource
            public String getPath() {
                String path = FastPathResolver.resolve(pathRelativeToPackageRoot);
                while (path.startsWith("/")) {
                    path = path.substring(1);
                }
                return path;
            }

            @Override // p013io.github.classgraph.Resource
            public String getPathRelativeToClasspathElement() {
                String pathRelativeToClasspathElt = FastPathResolver.resolve(new File(ClasspathElementFileDir.this.packageRootDir, pathRelativeToPackageRoot).getPath().substring(ClasspathElementFileDir.this.classpathEltDir.getPath().length()));
                while (pathRelativeToClasspathElt.startsWith("/")) {
                    pathRelativeToClasspathElt = pathRelativeToClasspathElt.substring(1);
                }
                return pathRelativeToClasspathElt;
            }

            @Override // p013io.github.classgraph.Resource
            public long getLastModified() {
                return resourceFile.lastModified();
            }

            @Override // p013io.github.classgraph.Resource
            public Set<PosixFilePermission> getPosixFilePermissions() {
                Set<PosixFilePermission> posixFilePermissions = null;
                try {
                    posixFilePermissions = ((PosixFileAttributes) Files.readAttributes(resourceFile.toPath(), PosixFileAttributes.class, new LinkOption[0])).permissions();
                } catch (IOException | SecurityException | UnsupportedOperationException e) {
                }
                return posixFilePermissions;
            }

            @Override // p013io.github.classgraph.Resource
            public ByteBuffer read() throws IOException {
                if (ClasspathElementFileDir.this.skipClasspathElement) {
                    throw new IOException("Parent directory could not be opened");
                } else if (this.isOpen.getAndSet(true)) {
                    throw new IOException("Resource is already open -- cannot open it again without first calling close()");
                } else {
                    this.fileSlice = new FileSlice(resourceFile, nestedJarHandler, null);
                    this.length = this.fileSlice.sliceLength;
                    this.byteBuffer = this.fileSlice.read();
                    return this.byteBuffer;
                }
            }

            /* access modifiers changed from: package-private */
            @Override // p013io.github.classgraph.Resource
            public ClassfileReader openClassfile() throws IOException {
                if (ClasspathElementFileDir.this.skipClasspathElement) {
                    throw new IOException("Parent directory could not be opened");
                } else if (this.isOpen.getAndSet(true)) {
                    throw new IOException("Resource is already open -- cannot open it again without first calling close()");
                } else {
                    this.fileSlice = new FileSlice(resourceFile, nestedJarHandler, null);
                    this.length = this.fileSlice.sliceLength;
                    return new ClassfileReader(this.fileSlice);
                }
            }

            @Override // p013io.github.classgraph.Resource
            public InputStream open() throws IOException {
                if (ClasspathElementFileDir.this.skipClasspathElement) {
                    throw new IOException("Parent directory could not be opened");
                } else if (this.isOpen.getAndSet(true)) {
                    throw new IOException("Resource is already open -- cannot open it again without first calling close()");
                } else {
                    this.fileSlice = new FileSlice(resourceFile, nestedJarHandler, null);
                    this.inputStream = this.fileSlice.open();
                    this.length = this.fileSlice.sliceLength;
                    return this.inputStream;
                }
            }

            @Override // p013io.github.classgraph.Resource
            public byte[] load() throws IOException {
                read();
                Throwable th = null;
                try {
                    this.fileSlice = new FileSlice(resourceFile, nestedJarHandler, null);
                    byte[] bytes = this.fileSlice.load();
                    this.length = (long) bytes.length;
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
                    return bytes;
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

            @Override // p013io.github.classgraph.Resource, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                close();
                if (this.isOpen.getAndSet(false)) {
                    if (this.byteBuffer != null) {
                        this.byteBuffer = null;
                    }
                    if (this.fileSlice != null) {
                        this.fileSlice.close();
                        nestedJarHandler.markSliceAsClosed(this.fileSlice);
                        this.fileSlice = null;
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public Resource getResource(String pathRelativeToPackageRoot) {
        File resourceFile = new File(this.packageRootDir, pathRelativeToPackageRoot);
        if (FileUtils.canReadAndIsFile(resourceFile)) {
            return newResource(pathRelativeToPackageRoot, resourceFile, this.nestedJarHandler);
        }
        return null;
    }

    private void scanDirRecursively(File dir, LogNode log) {
        LogNode subLog;
        String fileInDirRelativePath;
        if (!this.skipClasspathElement) {
            try {
                String canonicalPath = dir.getCanonicalPath();
                if (this.scannedCanonicalPaths.add(canonicalPath)) {
                    String dirPath = dir.getPath();
                    int ignorePrefixLen = this.packageRootDir.getPath().length() + 1;
                    String dirRelativePath = ignorePrefixLen > dirPath.length() ? "/" : dirPath.substring(ignorePrefixLen).replace(File.separatorChar, '/') + "/";
                    boolean isDefaultPackage = "/".equals(dirRelativePath);
                    if (this.nestedClasspathRootPrefixes == null || !this.nestedClasspathRootPrefixes.contains(dirRelativePath)) {
                        if (!dirRelativePath.startsWith(LogicalZipFile.MULTI_RELEASE_PATH_PREFIX)) {
                            checkResourcePathWhiteBlackList(dirRelativePath, log);
                            if (!this.skipClasspathElement) {
                                ScanSpec.ScanSpecPathMatch parentMatchStatus = this.scanSpec.dirWhitelistMatchStatus(dirRelativePath);
                                if (parentMatchStatus == ScanSpec.ScanSpecPathMatch.HAS_BLACKLISTED_PATH_PREFIX) {
                                    if (log != null) {
                                        log.log("Reached blacklisted directory, stopping recursive scan: " + dirRelativePath);
                                    }
                                } else if (parentMatchStatus != ScanSpec.ScanSpecPathMatch.NOT_WITHIN_WHITELISTED_PATH) {
                                    if (log == null) {
                                        subLog = null;
                                    } else {
                                        subLog = log.log("1:" + canonicalPath, "Scanning directory: " + dir + (dir.getPath().equals(canonicalPath) ? "" : " ; canonical path: " + canonicalPath));
                                    }
                                    File[] filesInDir = dir.listFiles();
                                    if (filesInDir != null) {
                                        Arrays.sort(filesInDir);
                                        boolean isModularJar = VersionFinder.JAVA_MAJOR_VERSION >= 9 && getModuleName() != null;
                                        if (parentMatchStatus != ScanSpec.ScanSpecPathMatch.ANCESTOR_OF_WHITELISTED_PATH) {
                                            for (File fileInDir : filesInDir) {
                                                if (fileInDir.isFile()) {
                                                    if (dirRelativePath.isEmpty() || isDefaultPackage) {
                                                        fileInDirRelativePath = fileInDir.getName();
                                                    } else {
                                                        fileInDirRelativePath = dirRelativePath + fileInDir.getName();
                                                    }
                                                    if (!isModularJar || !isDefaultPackage || !fileInDirRelativePath.endsWith(".class") || fileInDirRelativePath.equals("module-info.class")) {
                                                        checkResourcePathWhiteBlackList(fileInDirRelativePath, subLog);
                                                        if (this.skipClasspathElement) {
                                                            return;
                                                        }
                                                        if (parentMatchStatus == ScanSpec.ScanSpecPathMatch.HAS_WHITELISTED_PATH_PREFIX || parentMatchStatus == ScanSpec.ScanSpecPathMatch.AT_WHITELISTED_PATH || (parentMatchStatus == ScanSpec.ScanSpecPathMatch.AT_WHITELISTED_CLASS_PACKAGE && this.scanSpec.classfileIsSpecificallyWhitelisted(fileInDirRelativePath))) {
                                                            addWhitelistedResource(newResource(fileInDirRelativePath, fileInDir, this.nestedJarHandler), parentMatchStatus, false, subLog);
                                                            this.fileToLastModified.put(fileInDir, Long.valueOf(fileInDir.lastModified()));
                                                        } else if (subLog != null) {
                                                            subLog.log("Skipping non-whitelisted file: " + fileInDirRelativePath);
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (this.scanSpec.enableClassInfo && dirRelativePath.equals("/")) {
                                            int length = filesInDir.length;
                                            int i = 0;
                                            while (true) {
                                                if (i >= length) {
                                                    break;
                                                }
                                                File fileInDir2 = filesInDir[i];
                                                if (fileInDir2.getName().equals("module-info.class") && fileInDir2.isFile()) {
                                                    addWhitelistedResource(newResource("module-info.class", fileInDir2, this.nestedJarHandler), parentMatchStatus, true, subLog);
                                                    this.fileToLastModified.put(fileInDir2, Long.valueOf(fileInDir2.lastModified()));
                                                    break;
                                                }
                                                i++;
                                            }
                                        }
                                        for (File fileInDir3 : filesInDir) {
                                            if (fileInDir3.isDirectory()) {
                                                scanDirRecursively(fileInDir3, subLog);
                                                if (this.skipClasspathElement) {
                                                    if (subLog != null) {
                                                        subLog.addElapsedTime();
                                                        return;
                                                    }
                                                    return;
                                                }
                                            }
                                        }
                                        if (subLog != null) {
                                            subLog.addElapsedTime();
                                        }
                                        this.fileToLastModified.put(dir, Long.valueOf(dir.lastModified()));
                                    } else if (log != null) {
                                        log.log("Invalid directory " + dir);
                                    }
                                }
                            }
                        } else if (log != null) {
                            log.log("Found unexpected nested versioned entry in directory classpath element -- skipping: " + dirRelativePath);
                        }
                    } else if (log != null) {
                        log.log("Reached nested classpath root, stopping recursion to avoid duplicate scanning: " + dirRelativePath);
                    }
                } else if (log != null) {
                    log.log("Reached symlink cycle, stopping recursion: " + dir);
                }
            } catch (IOException | SecurityException e) {
                if (log != null) {
                    log.log("Could not canonicalize path: " + dir, e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public void scanPaths(LogNode log) {
        if (!this.skipClasspathElement) {
            if (this.scanned.getAndSet(true)) {
                throw new IllegalArgumentException("Already scanned classpath element " + toString());
            }
            LogNode subLog = log == null ? null : log(this.classpathElementIdx, "Scanning directory classpath element " + this.packageRootDir, log);
            scanDirRecursively(this.packageRootDir, subLog);
            finishScanPaths(subLog);
        }
    }

    @Override // p013io.github.classgraph.ClasspathElement
    public String getModuleName() {
        if (this.moduleNameFromModuleDescriptor == null || this.moduleNameFromModuleDescriptor.isEmpty()) {
            return null;
        }
        return this.moduleNameFromModuleDescriptor;
    }

    @Override // p013io.github.classgraph.ClasspathElement
    public File getFile() {
        return this.classpathEltDir;
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public URI getURI() {
        return this.packageRootDir.toURI();
    }

    public String toString() {
        return this.packageRootDir.toString();
    }

    public int hashCode() {
        return Objects.hash(this.classpathEltDir, this.packageRootDir);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClasspathElementFileDir)) {
            return false;
        }
        ClasspathElementFileDir other = (ClasspathElementFileDir) obj;
        return Objects.equals(this.classpathEltDir, other.classpathEltDir) && Objects.equals(this.packageRootDir, other.packageRootDir);
    }
}
