package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.p004io.ByteSource;
import com.google.common.p004io.CharSource;
import com.google.common.p004io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Logger;
import p001ch.qos.logback.core.joran.action.Action;

@Beta
/* loaded from: grasscutter.jar:com/google/common/reflect/ClassPath.class */
public final class ClassPath {
    private static final Logger logger = Logger.getLogger(ClassPath.class.getName());
    private static final Predicate<ClassInfo> IS_TOP_LEVEL = new Predicate<ClassInfo>() { // from class: com.google.common.reflect.ClassPath.1
        public boolean apply(ClassInfo info) {
            return info.className.indexOf(36) == -1;
        }
    };
    private static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.m1452on(" ").omitEmptyStrings();
    private static final String CLASS_FILE_NAME_EXTENSION = ".class";
    private final ImmutableSet<ResourceInfo> resources;

    private ClassPath(ImmutableSet<ResourceInfo> resources) {
        this.resources = resources;
    }

    public static ClassPath from(ClassLoader classloader) throws IOException {
        DefaultScanner scanner = new DefaultScanner();
        scanner.scan(classloader);
        return new ClassPath(scanner.getResources());
    }

    public ImmutableSet<ResourceInfo> getResources() {
        return this.resources;
    }

    public ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).filter(IS_TOP_LEVEL).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses(String packageName) {
        Preconditions.checkNotNull(packageName);
        ImmutableSet.Builder<ClassInfo> builder = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo classInfo = it.next();
            if (classInfo.getPackageName().equals(packageName)) {
                builder.add((ImmutableSet.Builder<ClassInfo>) classInfo);
            }
        }
        return builder.build();
    }

    public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String packageName) {
        Preconditions.checkNotNull(packageName);
        String packagePrefix = packageName + '.';
        ImmutableSet.Builder<ClassInfo> builder = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo classInfo = it.next();
            if (classInfo.getName().startsWith(packagePrefix)) {
                builder.add((ImmutableSet.Builder<ClassInfo>) classInfo);
            }
        }
        return builder.build();
    }

    @Beta
    /* loaded from: grasscutter.jar:com/google/common/reflect/ClassPath$ResourceInfo.class */
    public static class ResourceInfo {
        private final String resourceName;
        final ClassLoader loader;

        /* renamed from: of */
        static ResourceInfo m1302of(String resourceName, ClassLoader loader) {
            if (resourceName.endsWith(".class")) {
                return new ClassInfo(resourceName, loader);
            }
            return new ResourceInfo(resourceName, loader);
        }

        ResourceInfo(String resourceName, ClassLoader loader) {
            this.resourceName = (String) Preconditions.checkNotNull(resourceName);
            this.loader = (ClassLoader) Preconditions.checkNotNull(loader);
        }

        public final URL url() {
            URL url = this.loader.getResource(this.resourceName);
            if (url != null) {
                return url;
            }
            throw new NoSuchElementException(this.resourceName);
        }

        public final ByteSource asByteSource() {
            return Resources.asByteSource(url());
        }

        public final CharSource asCharSource(Charset charset) {
            return Resources.asCharSource(url(), charset);
        }

        public final String getResourceName() {
            return this.resourceName;
        }

        public int hashCode() {
            return this.resourceName.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResourceInfo)) {
                return false;
            }
            ResourceInfo that = (ResourceInfo) obj;
            return this.resourceName.equals(that.resourceName) && this.loader == that.loader;
        }

        public String toString() {
            return this.resourceName;
        }
    }

    @Beta
    /* loaded from: grasscutter.jar:com/google/common/reflect/ClassPath$ClassInfo.class */
    public static final class ClassInfo extends ResourceInfo {
        private final String className;

        ClassInfo(String resourceName, ClassLoader loader) {
            super(resourceName, loader);
            this.className = ClassPath.getClassName(resourceName);
        }

        public String getPackageName() {
            return Reflection.getPackageName(this.className);
        }

        public String getSimpleName() {
            int lastDollarSign = this.className.lastIndexOf(36);
            if (lastDollarSign != -1) {
                return CharMatcher.digit().trimLeadingFrom(this.className.substring(lastDollarSign + 1));
            }
            String packageName = getPackageName();
            if (packageName.isEmpty()) {
                return this.className;
            }
            return this.className.substring(packageName.length() + 1);
        }

        public String getName() {
            return this.className;
        }

        public Class<?> load() {
            try {
                return this.loader.loadClass(this.className);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.reflect.ClassPath.ResourceInfo
        public String toString() {
            return this.className;
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/reflect/ClassPath$Scanner.class */
    static abstract class Scanner {
        private final Set<File> scannedUris = Sets.newHashSet();

        protected abstract void scanDirectory(ClassLoader classLoader, File file) throws IOException;

        protected abstract void scanJarFile(ClassLoader classLoader, JarFile jarFile) throws IOException;

        Scanner() {
        }

        public final void scan(ClassLoader classloader) throws IOException {
            UnmodifiableIterator<Map.Entry<File, ClassLoader>> it = getClassPathEntries(classloader).entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<File, ClassLoader> entry = it.next();
                scan(entry.getKey(), entry.getValue());
            }
        }

        @VisibleForTesting
        final void scan(File file, ClassLoader classloader) throws IOException {
            if (this.scannedUris.add(file.getCanonicalFile())) {
                scanFrom(file, classloader);
            }
        }

        private void scanFrom(File file, ClassLoader classloader) throws IOException {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        scanDirectory(classloader, file);
                    } else {
                        scanJar(file, classloader);
                    }
                }
            } catch (SecurityException e) {
                ClassPath.logger.warning("Cannot access " + file + ": " + e);
            }
        }

        private void scanJar(File file, ClassLoader classloader) throws IOException {
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    UnmodifiableIterator<File> it = getClassPathFromManifest(file, jarFile.getManifest()).iterator();
                    while (it.hasNext()) {
                        scan(it.next(), classloader);
                    }
                    scanJarFile(classloader, jarFile);
                    try {
                        jarFile.close();
                    } catch (IOException e) {
                    }
                } catch (Throwable th) {
                    try {
                        jarFile.close();
                    } catch (IOException e2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
            }
        }

        @VisibleForTesting
        static ImmutableSet<File> getClassPathFromManifest(File jarFile, Manifest manifest) {
            if (manifest == null) {
                return ImmutableSet.m1396of();
            }
            ImmutableSet.Builder<File> builder = ImmutableSet.builder();
            String classpathAttribute = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
            if (classpathAttribute != null) {
                for (String path : ClassPath.CLASS_PATH_ATTRIBUTE_SEPARATOR.split(classpathAttribute)) {
                    try {
                        URL url = getClassPathEntry(jarFile, path);
                        if (url.getProtocol().equals(Action.FILE_ATTRIBUTE)) {
                            builder.add((ImmutableSet.Builder<File>) ClassPath.toFile(url));
                        }
                    } catch (MalformedURLException e) {
                        ClassPath.logger.warning("Invalid Class-Path entry: " + path);
                    }
                }
            }
            return builder.build();
        }

        @VisibleForTesting
        static ImmutableMap<File, ClassLoader> getClassPathEntries(ClassLoader classloader) {
            LinkedHashMap<File, ClassLoader> entries = Maps.newLinkedHashMap();
            ClassLoader parent = classloader.getParent();
            if (parent != null) {
                entries.putAll(getClassPathEntries(parent));
            }
            UnmodifiableIterator<URL> it = getClassLoaderUrls(classloader).iterator();
            while (it.hasNext()) {
                URL url = it.next();
                if (url.getProtocol().equals(Action.FILE_ATTRIBUTE)) {
                    File file = ClassPath.toFile(url);
                    if (!entries.containsKey(file)) {
                        entries.put(file, classloader);
                    }
                }
            }
            return ImmutableMap.copyOf(entries);
        }

        private static ImmutableList<URL> getClassLoaderUrls(ClassLoader classloader) {
            if (classloader instanceof URLClassLoader) {
                return ImmutableList.copyOf(((URLClassLoader) classloader).getURLs());
            }
            if (classloader.equals(ClassLoader.getSystemClassLoader())) {
                return parseJavaClassPath();
            }
            return ImmutableList.m1438of();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0045
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @com.google.common.annotations.VisibleForTesting
        static com.google.common.collect.ImmutableList<java.net.URL> parseJavaClassPath() {
            /*
                com.google.common.collect.ImmutableList$Builder r0 = com.google.common.collect.ImmutableList.builder()
                r9 = r0
                com.google.common.base.StandardSystemProperty r0 = com.google.common.base.StandardSystemProperty.PATH_SEPARATOR
                java.lang.String r0 = r0.value()
                com.google.common.base.Splitter r0 = com.google.common.base.Splitter.m1452on(r0)
                com.google.common.base.StandardSystemProperty r1 = com.google.common.base.StandardSystemProperty.JAVA_CLASS_PATH
                java.lang.String r1 = r1.value()
                java.lang.Iterable r0 = r0.split(r1)
                java.util.Iterator r0 = r0.iterator()
                r10 = r0
            L_0x001c:
                r0 = r10
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L_0x0084
                r0 = r10
                java.lang.Object r0 = r0.next()
                java.lang.String r0 = (java.lang.String) r0
                r11 = r0
                r0 = r9
                java.io.File r1 = new java.io.File     // Catch: MalformedURLException -> 0x0063, SecurityException -> 0x0045
                r2 = r1
                r3 = r11
                r2.<init>(r3)     // Catch: MalformedURLException -> 0x0063, SecurityException -> 0x0045
                java.net.URI r1 = r1.toURI()     // Catch: MalformedURLException -> 0x0063, SecurityException -> 0x0045
                java.net.URL r1 = r1.toURL()     // Catch: MalformedURLException -> 0x0063, SecurityException -> 0x0045
                com.google.common.collect.ImmutableList$Builder r0 = r0.add(r1)     // Catch: MalformedURLException -> 0x0063, SecurityException -> 0x0045
                goto L_0x0060
            L_0x0045:
                r12 = move-exception
                r0 = r9
                java.net.URL r1 = new java.net.URL     // Catch: MalformedURLException -> 0x0063
                r2 = r1
                java.lang.String r3 = "file"
                r4 = 0
                java.io.File r5 = new java.io.File     // Catch: MalformedURLException -> 0x0063
                r6 = r5
                r7 = r11
                r6.<init>(r7)     // Catch: MalformedURLException -> 0x0063
                java.lang.String r5 = r5.getAbsolutePath()     // Catch: MalformedURLException -> 0x0063
                r2.<init>(r3, r4, r5)     // Catch: MalformedURLException -> 0x0063
                com.google.common.collect.ImmutableList$Builder r0 = r0.add(r1)     // Catch: MalformedURLException -> 0x0063
            L_0x0060:
                goto L_0x0081
            L_0x0063:
                r12 = move-exception
                java.util.logging.Logger r0 = com.google.common.reflect.ClassPath.access$100()
                java.util.logging.Level r1 = java.util.logging.Level.WARNING
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = r2
                r3.<init>()
                java.lang.String r3 = "malformed classpath entry: "
                java.lang.StringBuilder r2 = r2.append(r3)
                r3 = r11
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r2 = r2.toString()
                r3 = r12
                r0.log(r1, r2, r3)
            L_0x0081:
                goto L_0x001c
            L_0x0084:
                r0 = r9
                com.google.common.collect.ImmutableList r0 = r0.build()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.reflect.ClassPath.Scanner.parseJavaClassPath():com.google.common.collect.ImmutableList");
        }

        @VisibleForTesting
        static URL getClassPathEntry(File jarFile, String path) throws MalformedURLException {
            return new URL(jarFile.toURI().toURL(), path);
        }
    }

    @VisibleForTesting
    /* loaded from: grasscutter.jar:com/google/common/reflect/ClassPath$DefaultScanner.class */
    static final class DefaultScanner extends Scanner {
        private final SetMultimap<ClassLoader, String> resources = MultimapBuilder.hashKeys().linkedHashSetValues().build();

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: com.google.common.collect.SetMultimap<K extends K0, V extends V0>, com.google.common.collect.SetMultimap<java.lang.ClassLoader, java.lang.String> */
        DefaultScanner() {
        }

        ImmutableSet<ResourceInfo> getResources() {
            ImmutableSet.Builder<ResourceInfo> builder = ImmutableSet.builder();
            for (Map.Entry<ClassLoader, String> entry : this.resources.entries()) {
                builder.add((ImmutableSet.Builder<ResourceInfo>) ResourceInfo.m1302of(entry.getValue(), entry.getKey()));
            }
            return builder.build();
        }

        @Override // com.google.common.reflect.ClassPath.Scanner
        protected void scanJarFile(ClassLoader classloader, JarFile file) {
            Enumeration<JarEntry> entries = file.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (!entry.isDirectory() && !entry.getName().equals("META-INF/MANIFEST.MF")) {
                    this.resources.get((SetMultimap<ClassLoader, String>) classloader).add(entry.getName());
                }
            }
        }

        @Override // com.google.common.reflect.ClassPath.Scanner
        protected void scanDirectory(ClassLoader classloader, File directory) throws IOException {
            Set<File> currentPath = new HashSet<>();
            currentPath.add(directory.getCanonicalFile());
            scanDirectory(directory, classloader, "", currentPath);
        }

        private void scanDirectory(File directory, ClassLoader classloader, String packagePrefix, Set<File> currentPath) throws IOException {
            File[] files = directory.listFiles();
            if (files == null) {
                ClassPath.logger.warning("Cannot read directory " + directory);
                return;
            }
            for (File f : files) {
                String name = f.getName();
                if (f.isDirectory()) {
                    File deref = f.getCanonicalFile();
                    if (currentPath.add(deref)) {
                        scanDirectory(deref, classloader, packagePrefix + name + "/", currentPath);
                        currentPath.remove(deref);
                    }
                } else {
                    String resourceName = packagePrefix + name;
                    if (!resourceName.equals("META-INF/MANIFEST.MF")) {
                        this.resources.get((SetMultimap<ClassLoader, String>) classloader).add(resourceName);
                    }
                }
            }
        }
    }

    @VisibleForTesting
    static String getClassName(String filename) {
        return filename.substring(0, filename.length() - ".class".length()).replace('/', '.');
    }

    @VisibleForTesting
    static File toFile(URL url) {
        Preconditions.checkArgument(url.getProtocol().equals(Action.FILE_ATTRIBUTE));
        try {
            return new File(url.toURI());
        } catch (URISyntaxException e) {
            return new File(url.getPath());
        }
    }
}
