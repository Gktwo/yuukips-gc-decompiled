package nonapi.p019io.github.classgraph.classpath;

import dev.morphia.mapping.Mapper;
import java.io.File;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.FastPathResolver;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.JarUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;
import p013io.github.classgraph.ClassGraph;

/* renamed from: nonapi.io.github.classgraph.classpath.ClasspathOrder */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classpath/ClasspathOrder.class */
public class ClasspathOrder {
    private final ScanSpec scanSpec;
    private final Set<String> classpathEntryUniqueResolvedPaths = new HashSet();
    private final List<ClasspathElementAndClassLoader> order = new ArrayList();

    /* renamed from: nonapi.io.github.classgraph.classpath.ClasspathOrder$ClasspathElementAndClassLoader */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classpath/ClasspathOrder$ClasspathElementAndClassLoader.class */
    public static class ClasspathElementAndClassLoader {
        public final Object classpathElementRoot;
        public final String dirOrPathPackageRoot;
        public final ClassLoader classLoader;

        public ClasspathElementAndClassLoader(Object classpathElementRoot, String dirOrPathPackageRoot, ClassLoader classLoader) {
            this.classpathElementRoot = classpathElementRoot;
            this.dirOrPathPackageRoot = dirOrPathPackageRoot;
            this.classLoader = classLoader;
        }

        public ClasspathElementAndClassLoader(Object classpathElementRoot, ClassLoader classLoader) {
            this.classpathElementRoot = classpathElementRoot;
            this.dirOrPathPackageRoot = "";
            this.classLoader = classLoader;
        }

        public int hashCode() {
            return Objects.hash(this.classpathElementRoot, this.dirOrPathPackageRoot, this.classLoader);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ClasspathElementAndClassLoader)) {
                return false;
            }
            ClasspathElementAndClassLoader other = (ClasspathElementAndClassLoader) obj;
            return Objects.equals(this.dirOrPathPackageRoot, other.dirOrPathPackageRoot) && Objects.equals(this.classpathElementRoot, other.classpathElementRoot) && Objects.equals(this.classLoader, other.classLoader);
        }
    }

    /* access modifiers changed from: package-private */
    public ClasspathOrder(ScanSpec scanSpec) {
        this.scanSpec = scanSpec;
    }

    public List<ClasspathElementAndClassLoader> getOrder() {
        return this.order;
    }

    public Set<String> getClasspathEntryUniqueResolvedPaths() {
        return this.classpathEntryUniqueResolvedPaths;
    }

    private boolean filter(String classpathElementPath) {
        if (this.scanSpec.classpathElementFilters == null) {
            return true;
        }
        for (ClassGraph.ClasspathElementFilter filter : this.scanSpec.classpathElementFilters) {
            if (!filter.includeClasspathElement(classpathElementPath)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean addSystemClasspathEntry(String pathEntry, ClassLoader classLoader) {
        if (!this.classpathEntryUniqueResolvedPaths.add(pathEntry)) {
            return false;
        }
        this.order.add(new ClasspathElementAndClassLoader(pathEntry, classLoader));
        return true;
    }

    private boolean addClasspathEntry(Object pathElement, String pathElementStr, ClassLoader classLoader, ScanSpec scanSpec) {
        if ((pathElement instanceof URL) || (pathElement instanceof URI)) {
            if (!this.classpathEntryUniqueResolvedPaths.add(pathElementStr)) {
                return false;
            }
            this.order.add(new ClasspathElementAndClassLoader(pathElement, classLoader));
            return true;
        } else if ((scanSpec.overrideClasspath == null && (SystemJarFinder.getJreLibOrExtJars().contains(pathElementStr) || pathElementStr.equals(SystemJarFinder.getJreRtJarPath()))) || !this.classpathEntryUniqueResolvedPaths.add(pathElementStr)) {
            return false;
        } else {
            this.order.add(new ClasspathElementAndClassLoader(pathElementStr, classLoader));
            return true;
        }
    }

    public boolean addClasspathEntry(Object pathElement, ClassLoader classLoader, ScanSpec scanSpec, LogNode log) {
        Object classpathElementObj;
        if (pathElement == null) {
            return false;
        }
        String pathElementStr = pathElement.toString();
        if (pathElementStr.isEmpty()) {
            return false;
        }
        if ((pathElement instanceof URL) || (pathElement instanceof URI) || (pathElement instanceof File)) {
            if (filter(pathElementStr)) {
                try {
                    if (pathElement instanceof File) {
                        classpathElementObj = pathElementStr;
                    } else {
                        classpathElementObj = pathElement instanceof URI ? ((URI) pathElement).toURL() : pathElement;
                    }
                    if (addClasspathEntry(classpathElementObj, pathElementStr, classLoader, scanSpec)) {
                        if (log == null) {
                            return true;
                        }
                        log.log("Found classpath element: " + pathElementStr);
                        return true;
                    } else if (log == null) {
                        return false;
                    } else {
                        log.log("Ignoring duplicate classpath element: " + pathElementStr);
                        return false;
                    }
                } catch (MalformedURLException e) {
                    if (log == null) {
                        return false;
                    }
                    log.log("Cannot convert from URI to URL: " + pathElementStr);
                    return false;
                }
            } else if (log == null) {
                return false;
            } else {
                log.log("Classpath element did not match filter criterion, skipping: " + pathElementStr);
                return false;
            }
        } else if (!pathElementStr.endsWith("*")) {
            String pathElementResolved = FastPathResolver.resolve(FileUtils.CURR_DIR_PATH, pathElementStr);
            if (!filter(pathElementStr) || (!pathElementResolved.equals(pathElementStr) && !filter(pathElementResolved))) {
                if (log == null) {
                    return false;
                }
                log.log("Classpath element did not match filter criterion, skipping: " + pathElementStr + (pathElementStr.equals(pathElementResolved) ? "" : " -> " + pathElementResolved));
                return false;
            } else if (addClasspathEntry(pathElementResolved, pathElementResolved, classLoader, scanSpec)) {
                if (log == null) {
                    return true;
                }
                log.log("Found classpath element: " + pathElementStr + (pathElementStr.equals(pathElementResolved) ? "" : " -> " + pathElementResolved));
                return true;
            } else if (log == null) {
                return false;
            } else {
                log.log("Ignoring duplicate classpath element: " + pathElementStr + (pathElementStr.equals(pathElementResolved) ? "" : " -> " + pathElementResolved));
                return false;
            }
        } else if (pathElementStr.length() == 1 || (pathElementStr.length() > 2 && pathElementStr.charAt(pathElementStr.length() - 1) == '*' && (pathElementStr.charAt(pathElementStr.length() - 2) == File.separatorChar || (File.separatorChar != '/' && pathElementStr.charAt(pathElementStr.length() - 2) == '/')))) {
            String baseDirPath = pathElementStr.length() == 1 ? "" : pathElementStr.substring(0, pathElementStr.length() - 2);
            String baseDirPathResolved = FastPathResolver.resolve(FileUtils.CURR_DIR_PATH, baseDirPath);
            if (filter(baseDirPath) && (baseDirPathResolved.equals(baseDirPath) || filter(baseDirPathResolved))) {
                File baseDir = new File(baseDirPathResolved);
                if (!baseDir.exists()) {
                    if (log == null) {
                        return false;
                    }
                    log.log("Directory does not exist for wildcard classpath element: " + pathElementStr);
                    return false;
                } else if (!FileUtils.canRead(baseDir)) {
                    if (log == null) {
                        return false;
                    }
                    log.log("Cannot read directory for wildcard classpath element: " + pathElementStr);
                    return false;
                } else if (baseDir.isDirectory()) {
                    LogNode dirLog = log == null ? null : log.log("Adding classpath elements from wildcarded directory: " + pathElementStr);
                    File[] baseDirFiles = baseDir.listFiles();
                    if (baseDirFiles == null) {
                        return false;
                    }
                    for (File fileInDir : baseDirFiles) {
                        String name = fileInDir.getName();
                        if (!name.equals(Mapper.IGNORED_FIELDNAME) && !name.equals(CallerDataConverter.DEFAULT_RANGE_DELIMITER)) {
                            String fileInDirPath = fileInDir.getPath();
                            String fileInDirPathResolved = FastPathResolver.resolve(FileUtils.CURR_DIR_PATH, fileInDirPath);
                            if (addClasspathEntry(fileInDirPathResolved, fileInDirPathResolved, classLoader, scanSpec)) {
                                if (dirLog != null) {
                                    dirLog.log("Found classpath element: " + fileInDirPath + (fileInDirPath.equals(fileInDirPathResolved) ? "" : " -> " + fileInDirPathResolved));
                                }
                            } else if (dirLog != null) {
                                dirLog.log("Ignoring duplicate classpath element: " + fileInDirPath + (fileInDirPath.equals(fileInDirPathResolved) ? "" : " -> " + fileInDirPathResolved));
                            }
                        }
                    }
                    return true;
                } else if (log == null) {
                    return false;
                } else {
                    log.log("Wildcard is appended to something other than a directory: " + pathElementStr);
                    return false;
                }
            } else if (log == null) {
                return false;
            } else {
                log.log("Classpath element did not match filter criterion, skipping: " + pathElementStr);
                return false;
            }
        } else if (log == null) {
            return false;
        } else {
            log.log("Wildcard classpath elements can only end with a leaf of \"*\", can't have a partial name and then a wildcard: " + pathElementStr);
            return false;
        }
    }

    public boolean addClasspathEntries(List<Object> overrideClasspath, ClassLoader classLoader, ScanSpec scanSpec, LogNode log) {
        if (overrideClasspath == null || overrideClasspath.isEmpty()) {
            return false;
        }
        for (Object pathElement : overrideClasspath) {
            addClasspathEntry(pathElement, classLoader, scanSpec, log);
        }
        return true;
    }

    public boolean addClasspathPathStr(String pathStr, ClassLoader classLoader, ScanSpec scanSpec, LogNode log) {
        if (pathStr == null || pathStr.isEmpty()) {
            return false;
        }
        String[] parts = JarUtils.smartPathSplit(pathStr, scanSpec);
        if (parts.length == 0) {
            return false;
        }
        for (String pathElement : parts) {
            addClasspathEntry(pathElement, classLoader, scanSpec, log);
        }
        return true;
    }

    public boolean addClasspathEntryObject(Object pathObject, ClassLoader classLoader, ScanSpec scanSpec, LogNode log) {
        boolean valid = false;
        if (pathObject != null) {
            if ((pathObject instanceof URL) || (pathObject instanceof URI)) {
                valid = false | addClasspathEntry(pathObject, classLoader, scanSpec, log);
            } else if (pathObject instanceof Iterable) {
                for (Object elt : (Iterable) pathObject) {
                    valid |= addClasspathEntryObject(elt, classLoader, scanSpec, log);
                }
            } else if (pathObject.getClass().isArray()) {
                int n = Array.getLength(pathObject);
                for (int j = 0; j < n; j++) {
                    valid |= addClasspathEntryObject(Array.get(pathObject, j), classLoader, scanSpec, log);
                }
            } else {
                valid = false | addClasspathPathStr(pathObject.toString(), classLoader, scanSpec, log);
            }
        }
        return valid;
    }
}
