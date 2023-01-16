package p013io.github.classgraph;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import nonapi.p019io.github.classgraph.classloaderhandler.ClassLoaderHandlerRegistry;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.concurrency.WorkQueue;
import nonapi.p019io.github.classgraph.fastzipfilereader.LogicalZipFile;
import nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler;
import nonapi.p019io.github.classgraph.fileslice.PathSlice;
import nonapi.p019io.github.classgraph.fileslice.reader.ClassfileReader;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.FastPathResolver;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.VersionFinder;
import p013io.github.classgraph.Scanner;

/* access modifiers changed from: package-private */
/* renamed from: io.github.classgraph.ClasspathElementPathDir */
/* loaded from: grasscutter.jar:io/github/classgraph/ClasspathElementPathDir.class */
public class ClasspathElementPathDir extends ClasspathElement {
    private final Path classpathEltPath;
    private final Path packageRootPath;
    private final Set<Path> scannedCanonicalPaths = new HashSet();
    private final NestedJarHandler nestedJarHandler;

    /* access modifiers changed from: package-private */
    public ClasspathElementPathDir(Path classpathEltPath, String packageRoot, ClassLoader classLoader, NestedJarHandler nestedJarHandler, ScanSpec scanSpec) {
        super(classLoader, scanSpec);
        this.classpathEltPath = classpathEltPath;
        this.packageRootPath = classpathEltPath.resolve(packageRoot);
        this.nestedJarHandler = nestedJarHandler;
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public void open(WorkQueue<Scanner.ClasspathEntryWorkUnit> workQueue, LogNode log) {
        if (!this.scanSpec.scanDirs) {
            if (log != null) {
                log(this.classpathElementIdx, "Skipping classpath element, since dir scanning is disabled: " + this.classpathEltPath, log);
            }
            this.skipClasspathElement = true;
            return;
        }
        try {
            int childClasspathEntryIdx = 0;
            for (String libDirPrefix : ClassLoaderHandlerRegistry.AUTOMATIC_LIB_DIR_PREFIXES) {
                Path libDirPath = this.classpathEltPath.resolve(libDirPrefix);
                if (FileUtils.canReadAndIsDir(libDirPath)) {
                    try {
                        DirectoryStream<Path> stream = Files.newDirectoryStream(libDirPath);
                        Throwable th = null;
                        try {
                            try {
                                for (Path filePath : stream) {
                                    if (Files.isRegularFile(filePath, new LinkOption[0]) && filePath.getFileName().endsWith(".jar")) {
                                        if (log != null) {
                                            log(this.classpathElementIdx, "Found lib jar: " + filePath, log);
                                        }
                                        childClasspathEntryIdx++;
                                        workQueue.addWorkUnit(new Scanner.ClasspathEntryWorkUnit(new ClasspathOrder.ClasspathElementAndClassLoader(filePath, this.classLoader), this, childClasspathEntryIdx));
                                    }
                                }
                                if (stream != null) {
                                    if (0 != 0) {
                                        try {
                                            stream.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    } else {
                                        stream.close();
                                    }
                                }
                            } catch (Throwable th3) {
                                if (stream != null) {
                                    if (th != null) {
                                        try {
                                            stream.close();
                                        } catch (Throwable th4) {
                                            th.addSuppressed(th4);
                                        }
                                    } else {
                                        stream.close();
                                    }
                                }
                                throw th3;
                                break;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            throw th5;
                            break;
                        }
                    } catch (IOException e) {
                    }
                }
            }
            if (this.packageRootPath.equals(this.classpathEltPath)) {
                String[] strArr = ClassLoaderHandlerRegistry.AUTOMATIC_PACKAGE_ROOT_PREFIXES;
                for (String packageRootPrefix : strArr) {
                    if (FileUtils.canReadAndIsDir(this.classpathEltPath.resolve(packageRootPrefix))) {
                        if (log != null) {
                            log(this.classpathElementIdx, "Found package root: " + packageRootPrefix, log);
                        }
                        childClasspathEntryIdx++;
                        workQueue.addWorkUnit(new Scanner.ClasspathEntryWorkUnit(new ClasspathOrder.ClasspathElementAndClassLoader(this.classpathEltPath, packageRootPrefix, this.classLoader), this, childClasspathEntryIdx));
                    }
                }
            }
        } catch (SecurityException e2) {
            if (log != null) {
                log(this.classpathElementIdx, "Skipping classpath element, since dir cannot be accessed: " + this.classpathEltPath, log);
            }
            this.skipClasspathElement = true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    private Resource newResource(final Path resourcePath, final NestedJarHandler nestedJarHandler) {
        char c;
        try {
            c = Files.size(resourcePath);
        } catch (IOException | SecurityException e) {
            c = 65535;
        }
        return new Resource(this, c) { // from class: io.github.classgraph.ClasspathElementPathDir.1
            private PathSlice pathSlice;
            protected AtomicBoolean isOpen = new AtomicBoolean();

            @Override // p013io.github.classgraph.Resource
            public String getPath() {
                String path = FastPathResolver.resolve(ClasspathElementPathDir.this.packageRootPath.relativize(resourcePath).toString());
                while (path.startsWith("/")) {
                    path = path.substring(1);
                }
                return path;
            }

            @Override // p013io.github.classgraph.Resource
            public String getPathRelativeToClasspathElement() {
                String path = FastPathResolver.resolve(ClasspathElementPathDir.this.classpathEltPath.relativize(resourcePath).toString());
                while (path.startsWith("/")) {
                    path = path.substring(1);
                }
                return path;
            }

            @Override // p013io.github.classgraph.Resource
            public long getLastModified() {
                try {
                    return resourcePath.toFile().lastModified();
                } catch (UnsupportedOperationException e2) {
                    return 0;
                }
            }

            @Override // p013io.github.classgraph.Resource
            public Set<PosixFilePermission> getPosixFilePermissions() {
                Set<PosixFilePermission> posixFilePermissions = null;
                try {
                    posixFilePermissions = ((PosixFileAttributes) Files.readAttributes(resourcePath, PosixFileAttributes.class, new LinkOption[0])).permissions();
                } catch (IOException | SecurityException | UnsupportedOperationException e2) {
                }
                return posixFilePermissions;
            }

            @Override // p013io.github.classgraph.Resource
            public ByteBuffer read() throws IOException {
                if (ClasspathElementPathDir.this.skipClasspathElement) {
                    throw new IOException("Parent directory could not be opened");
                } else if (this.isOpen.getAndSet(true)) {
                    throw new IOException("Resource is already open -- cannot open it again without first calling close()");
                } else {
                    this.pathSlice = new PathSlice(resourcePath, nestedJarHandler, null);
                    this.length = this.pathSlice.sliceLength;
                    this.byteBuffer = this.pathSlice.read();
                    return this.byteBuffer;
                }
            }

            /* access modifiers changed from: package-private */
            @Override // p013io.github.classgraph.Resource
            public ClassfileReader openClassfile() throws IOException {
                if (ClasspathElementPathDir.this.skipClasspathElement) {
                    throw new IOException("Parent directory could not be opened");
                } else if (this.isOpen.getAndSet(true)) {
                    throw new IOException("Resource is already open -- cannot open it again without first calling close()");
                } else {
                    this.pathSlice = new PathSlice(resourcePath, nestedJarHandler, null);
                    this.length = this.pathSlice.sliceLength;
                    return new ClassfileReader(this.pathSlice);
                }
            }

            @Override // p013io.github.classgraph.Resource
            public InputStream open() throws IOException {
                if (ClasspathElementPathDir.this.skipClasspathElement) {
                    throw new IOException("Parent directory could not be opened");
                } else if (this.isOpen.getAndSet(true)) {
                    throw new IOException("Resource is already open -- cannot open it again without first calling close()");
                } else {
                    this.pathSlice = new PathSlice(resourcePath, nestedJarHandler, null);
                    this.inputStream = this.pathSlice.open();
                    this.length = this.pathSlice.sliceLength;
                    return this.inputStream;
                }
            }

            @Override // p013io.github.classgraph.Resource
            public byte[] load() throws IOException {
                read();
                Throwable th = null;
                try {
                    this.pathSlice = new PathSlice(resourcePath, nestedJarHandler, null);
                    byte[] bytes = this.pathSlice.load();
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
                    if (this.pathSlice != null) {
                        this.pathSlice.close();
                        nestedJarHandler.markSliceAsClosed(this.pathSlice);
                        this.pathSlice = null;
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public Resource getResource(String relativePath) {
        Path resourcePath = this.packageRootPath.resolve(relativePath);
        if (FileUtils.canReadAndIsFile(resourcePath)) {
            return newResource(resourcePath, this.nestedJarHandler);
        }
        return null;
    }

    private void scanPathRecursively(Path path, LogNode log) {
        LogNode subLog;
        if (!this.skipClasspathElement) {
            try {
                Path canonicalPath = path.toRealPath(new LinkOption[0]);
                if (this.scannedCanonicalPaths.add(canonicalPath)) {
                    String dirRelativePathStr = FastPathResolver.resolve(this.packageRootPath.relativize(path).toString());
                    while (dirRelativePathStr.startsWith("/")) {
                        dirRelativePathStr = dirRelativePathStr.substring(1);
                    }
                    if (!dirRelativePathStr.endsWith("/")) {
                        dirRelativePathStr = dirRelativePathStr + "/";
                    }
                    boolean isDefaultPackage = dirRelativePathStr.equals("/");
                    if (this.nestedClasspathRootPrefixes == null || !this.nestedClasspathRootPrefixes.contains(dirRelativePathStr)) {
                        if (!dirRelativePathStr.startsWith(LogicalZipFile.MULTI_RELEASE_PATH_PREFIX)) {
                            checkResourcePathWhiteBlackList(dirRelativePathStr, log);
                            if (!this.skipClasspathElement) {
                                ScanSpec.ScanSpecPathMatch parentMatchStatus = this.scanSpec.dirWhitelistMatchStatus(dirRelativePathStr);
                                if (parentMatchStatus == ScanSpec.ScanSpecPathMatch.HAS_BLACKLISTED_PATH_PREFIX) {
                                    if (log != null) {
                                        log.log("Reached blacklisted directory, stopping recursive scan: " + dirRelativePathStr);
                                    }
                                } else if (parentMatchStatus != ScanSpec.ScanSpecPathMatch.NOT_WITHIN_WHITELISTED_PATH) {
                                    if (log == null) {
                                        subLog = null;
                                    } else {
                                        subLog = log.log("1:" + canonicalPath, "Scanning Path: " + FastPathResolver.resolve(path.toString()) + (path.equals(canonicalPath) ? "" : " ; canonical path: " + FastPathResolver.resolve(canonicalPath.toString())));
                                    }
                                    List<Path> pathsInDir = new ArrayList<>();
                                    try {
                                        DirectoryStream<Path> stream = Files.newDirectoryStream(path);
                                        for (Path subPath : stream) {
                                            pathsInDir.add(subPath);
                                        }
                                        if (stream != null) {
                                            if (0 != 0) {
                                                stream.close();
                                            } else {
                                                stream.close();
                                            }
                                        }
                                        Collections.sort(pathsInDir);
                                        boolean isModularJar = VersionFinder.JAVA_MAJOR_VERSION >= 9 && getModuleName() != null;
                                        if (parentMatchStatus != ScanSpec.ScanSpecPathMatch.ANCESTOR_OF_WHITELISTED_PATH) {
                                            for (Path subPath2 : pathsInDir) {
                                                if (Files.isRegularFile(subPath2, new LinkOption[0])) {
                                                    Path subPathRelative = this.classpathEltPath.relativize(subPath2);
                                                    String subPathRelativeStr = subPathRelative.toString();
                                                    if (!isModularJar || !isDefaultPackage || !subPathRelativeStr.endsWith(".class") || subPathRelativeStr.equals("module-info.class")) {
                                                        checkResourcePathWhiteBlackList(subPathRelativeStr, subLog);
                                                        if (this.skipClasspathElement) {
                                                            return;
                                                        }
                                                        if (parentMatchStatus == ScanSpec.ScanSpecPathMatch.HAS_WHITELISTED_PATH_PREFIX || parentMatchStatus == ScanSpec.ScanSpecPathMatch.AT_WHITELISTED_PATH || (parentMatchStatus == ScanSpec.ScanSpecPathMatch.AT_WHITELISTED_CLASS_PACKAGE && this.scanSpec.classfileIsSpecificallyWhitelisted(subPathRelativeStr))) {
                                                            addWhitelistedResource(newResource(subPath2, this.nestedJarHandler), parentMatchStatus, false, subLog);
                                                            try {
                                                                this.fileToLastModified.put(subPath2.toFile(), Long.valueOf(subPath2.toFile().lastModified()));
                                                            } catch (UnsupportedOperationException e) {
                                                            }
                                                        } else if (subLog != null) {
                                                            subLog.log("Skipping non-whitelisted file: " + subPathRelative);
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (this.scanSpec.enableClassInfo && dirRelativePathStr.equals("/")) {
                                            Iterator<Path> it = pathsInDir.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                Path subPath3 = it.next();
                                                if (subPath3.getFileName().toString().equals("module-info.class") && Files.isRegularFile(subPath3, new LinkOption[0])) {
                                                    addWhitelistedResource(newResource(subPath3, this.nestedJarHandler), parentMatchStatus, true, subLog);
                                                    try {
                                                        this.fileToLastModified.put(subPath3.toFile(), Long.valueOf(subPath3.toFile().lastModified()));
                                                        break;
                                                    } catch (UnsupportedOperationException e2) {
                                                    }
                                                }
                                            }
                                        }
                                        for (Path subPath4 : pathsInDir) {
                                            try {
                                                if (Files.isDirectory(subPath4, new LinkOption[0])) {
                                                    scanPathRecursively(subPath4, subLog);
                                                    if (!this.skipClasspathElement) {
                                                        continue;
                                                    } else if (subLog != null) {
                                                        subLog.addElapsedTime();
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    continue;
                                                }
                                            } catch (SecurityException e3) {
                                                if (subLog != null) {
                                                    subLog.log("Could not read sub-directory " + subPath4 + " : " + e3.getMessage());
                                                }
                                            }
                                        }
                                        if (subLog != null) {
                                            subLog.addElapsedTime();
                                        }
                                        try {
                                            File file = path.toFile();
                                            this.fileToLastModified.put(file, Long.valueOf(file.lastModified()));
                                        } catch (UnsupportedOperationException e4) {
                                        }
                                    } catch (IOException | SecurityException e5) {
                                        if (log != null) {
                                            log.log("Could not read directory " + path + " : " + e5.getMessage());
                                        }
                                        this.skipClasspathElement = true;
                                    }
                                }
                            }
                        } else if (log != null) {
                            log.log("Found unexpected nested versioned entry in directory classpath element -- skipping: " + dirRelativePathStr);
                        }
                    } else if (log != null) {
                        log.log("Reached nested classpath root, stopping recursion to avoid duplicate scanning: " + dirRelativePathStr);
                    }
                } else if (log != null) {
                    log.log("Reached symlink cycle, stopping recursion: " + path);
                }
            } catch (IOException | SecurityException e6) {
                if (log != null) {
                    log.log("Could not canonicalize path: " + path, e6);
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
            LogNode subLog = log == null ? null : log(this.classpathElementIdx, "Scanning Path classpath element " + getURI(), log);
            scanPathRecursively(this.packageRootPath, subLog);
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
        try {
            return this.classpathEltPath.toFile();
        } catch (UnsupportedOperationException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public URI getURI() {
        return this.packageRootPath.toUri();
    }

    public String toString() {
        try {
            return this.packageRootPath.toUri().toString();
        } catch (IOError | SecurityException e) {
            return this.packageRootPath.toString();
        }
    }

    public int hashCode() {
        return Objects.hash(this.classpathEltPath, this.packageRootPath);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClasspathElementPathDir)) {
            return false;
        }
        ClasspathElementPathDir other = (ClasspathElementPathDir) obj;
        return Objects.equals(this.classpathEltPath, other.classpathEltPath) && Objects.equals(this.packageRootPath, other.packageRootPath);
    }
}
