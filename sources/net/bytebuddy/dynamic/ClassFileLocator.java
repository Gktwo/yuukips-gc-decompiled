package net.bytebuddy.dynamic;

import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.StreamDrainer;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

/* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator.class */
public interface ClassFileLocator extends Closeable {
    public static final String CLASS_FILE_EXTENSION = ".class";

    Resolution locate(String str) throws IOException;

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$Resolution.class */
    public interface Resolution {
        boolean isResolved();

        byte[] resolve();

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$Resolution$Illegal.class */
        public static class Illegal implements Resolution {
            private final String typeName;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeName.equals(((Illegal) obj).typeName);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.typeName.hashCode();
            }

            public Illegal(String typeName) {
                this.typeName = typeName;
            }

            @Override // net.bytebuddy.dynamic.ClassFileLocator.Resolution
            public boolean isResolved() {
                return false;
            }

            @Override // net.bytebuddy.dynamic.ClassFileLocator.Resolution
            public byte[] resolve() {
                throw new IllegalStateException("Could not locate class file for " + this.typeName);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$Resolution$Explicit.class */
        public static class Explicit implements Resolution {
            private final byte[] binaryRepresentation;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && Arrays.equals(this.binaryRepresentation, ((Explicit) obj).binaryRepresentation);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + Arrays.hashCode(this.binaryRepresentation);
            }

            @SuppressFBWarnings(value = {"EI_EXPOSE_REP2"}, justification = "The array is not to be modified by contract")
            public Explicit(byte[] binaryRepresentation) {
                this.binaryRepresentation = binaryRepresentation;
            }

            @Override // net.bytebuddy.dynamic.ClassFileLocator.Resolution
            public boolean isResolved() {
                return true;
            }

            @Override // net.bytebuddy.dynamic.ClassFileLocator.Resolution
            @SuppressFBWarnings(value = {"EI_EXPOSE_REP"}, justification = "The array is not to be modified by contract")
            public byte[] resolve() {
                return this.binaryRepresentation;
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$NoOp.class */
    public enum NoOp implements ClassFileLocator {
        INSTANCE;

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String name) {
            return new Resolution.Illegal(name);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$Simple.class */
    public static class Simple implements ClassFileLocator {
        private final Map<String, byte[]> classFiles;

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFiles.equals(((Simple) obj).classFiles);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classFiles.hashCode();
        }

        public Simple(Map<String, byte[]> classFiles) {
            this.classFiles = classFiles;
        }

        /* renamed from: of */
        public static ClassFileLocator m223of(String typeName, byte[] binaryRepresentation) {
            return new Simple(Collections.singletonMap(typeName, binaryRepresentation));
        }

        /* renamed from: of */
        public static ClassFileLocator m221of(DynamicType dynamicType) {
            return m222of(dynamicType.getAllTypes());
        }

        /* renamed from: of */
        public static ClassFileLocator m222of(Map<TypeDescription, byte[]> binaryRepresentations) {
            Map<String, byte[]> classFiles = new HashMap<>();
            for (Map.Entry<TypeDescription, byte[]> entry : binaryRepresentations.entrySet()) {
                classFiles.put(entry.getKey().getName(), entry.getValue());
            }
            return new Simple(classFiles);
        }

        public static ClassFileLocator ofResources(Map<String, byte[]> binaryRepresentations) {
            Map<String, byte[]> classFiles = new HashMap<>();
            for (Map.Entry<String, byte[]> entry : binaryRepresentations.entrySet()) {
                if (entry.getKey().endsWith(".class")) {
                    classFiles.put(entry.getKey().substring(0, entry.getKey().length() - ".class".length()).replace('/', '.'), entry.getValue());
                }
            }
            return new Simple(classFiles);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String name) {
            byte[] binaryRepresentation = this.classFiles.get(name);
            return binaryRepresentation == null ? new Resolution.Illegal(name) : new Resolution.Explicit(binaryRepresentation);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForClassLoader.class */
    public static class ForClassLoader implements ClassFileLocator {
        private static final ClassLoader BOOT_LOADER_PROXY = (ClassLoader) AccessController.doPrivileged(BootLoaderProxyCreationAction.INSTANCE);
        private final ClassLoader classLoader;

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classLoader.equals(((ForClassLoader) obj).classLoader);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classLoader.hashCode();
        }

        protected ForClassLoader(ClassLoader classLoader) {
            this.classLoader = classLoader;
        }

        public static ClassFileLocator ofSystemLoader() {
            return new ForClassLoader(ClassLoader.getSystemClassLoader());
        }

        public static ClassFileLocator ofPlatformLoader() {
            return m232of(ClassLoader.getSystemClassLoader().getParent());
        }

        public static ClassFileLocator ofBootLoader() {
            return new ForClassLoader(BOOT_LOADER_PROXY);
        }

        /* renamed from: of */
        public static ClassFileLocator m232of(ClassLoader classLoader) {
            return new ForClassLoader(classLoader == null ? BOOT_LOADER_PROXY : classLoader);
        }

        public static byte[] read(Class<?> type) {
            try {
                ClassLoader classLoader = type.getClassLoader();
                return locate(classLoader == null ? BOOT_LOADER_PROXY : classLoader, TypeDescription.ForLoadedType.getName(type)).resolve();
            } catch (IOException exception) {
                throw new IllegalStateException("Cannot read class file for " + type, exception);
            }
        }

        public static Map<Class<?>, byte[]> read(Class<?>... type) {
            return read(Arrays.asList(type));
        }

        public static Map<Class<?>, byte[]> read(Collection<? extends Class<?>> types) {
            Map<Class<?>, byte[]> result = new HashMap<>();
            for (Class<?> type : types) {
                result.put(type, read(type));
            }
            return result;
        }

        public static Map<String, byte[]> readToNames(Class<?>... type) {
            return readToNames(Arrays.asList(type));
        }

        public static Map<String, byte[]> readToNames(Collection<? extends Class<?>> types) {
            Map<String, byte[]> result = new HashMap<>();
            for (Class<?> type : types) {
                result.put(type.getName(), read(type));
            }
            return result;
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String name) throws IOException {
            return locate(this.classLoader, name);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        protected static Resolution locate(ClassLoader classLoader, String name) throws IOException {
            InputStream inputStream = classLoader.getResourceAsStream(name.replace('.', '/') + ".class");
            if (inputStream == null) {
                return new Resolution.Illegal(name);
            }
            try {
                Resolution.Explicit explicit = new Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
                inputStream.close();
                return explicit;
            } catch (Throwable th) {
                inputStream.close();
                throw th;
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForClassLoader$BootLoaderProxyCreationAction.class */
        protected enum BootLoaderProxyCreationAction implements PrivilegedAction<ClassLoader> {
            INSTANCE;

            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return new URLClassLoader(new URL[0], ClassLoadingStrategy.BOOTSTRAP_LOADER);
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForClassLoader$WeaklyReferenced.class */
        public static class WeaklyReferenced extends WeakReference<ClassLoader> implements ClassFileLocator {
            private final int hashCode;

            protected WeaklyReferenced(ClassLoader classLoader) {
                super(classLoader);
                this.hashCode = System.identityHashCode(classLoader);
            }

            /* renamed from: of */
            public static ClassFileLocator m231of(ClassLoader classLoader) {
                return (classLoader == null || classLoader == ClassLoader.getSystemClassLoader() || classLoader == ClassLoader.getSystemClassLoader().getParent()) ? ForClassLoader.m232of(classLoader) : new WeaklyReferenced(classLoader);
            }

            @Override // net.bytebuddy.dynamic.ClassFileLocator
            public Resolution locate(String name) throws IOException {
                ClassLoader classLoader = (ClassLoader) get();
                return classLoader == null ? new Resolution.Illegal(name) : ForClassLoader.locate(classLoader, name);
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.lang.Object
            public int hashCode() {
                return this.hashCode;
            }

            @Override // java.lang.Object
            public boolean equals(Object other) {
                ClassLoader classLoader;
                if (this == other) {
                    return true;
                }
                return other != null && getClass() == other.getClass() && (classLoader = (ClassLoader) ((WeaklyReferenced) other).get()) != null && get() == classLoader;
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForModule.class */
    public static class ForModule implements ClassFileLocator {
        private static final Object[] NO_ARGUMENT = new Object[0];
        private final JavaModule module;

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.module.equals(((ForModule) obj).module);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (getClass().hashCode() * 31) + this.module.hashCode();
        }

        protected ForModule(JavaModule module) {
            this.module = module;
        }

        @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should always be wrapped for clarity")
        public static ClassFileLocator ofBootLayer() {
            try {
                Map<String, ClassFileLocator> bootModules = new HashMap<>();
                Class<?> layerType = Class.forName("java.lang.ModuleLayer");
                Method getPackages = JavaType.MODULE.load().getMethod("getPackages", new Class[0]);
                for (Object rawModule : (Set) layerType.getMethod("modules", new Class[0]).invoke(layerType.getMethod("boot", new Class[0]).invoke(null, new Object[0]), new Object[0])) {
                    ClassFileLocator classFileLocator = m226of(JavaModule.m64of(rawModule));
                    for (String str : (Set) getPackages.invoke(rawModule, NO_ARGUMENT)) {
                        bootModules.put(str, classFileLocator);
                    }
                }
                return new PackageDiscriminating(bootModules);
            } catch (Exception exception) {
                throw new IllegalStateException("Cannot process boot layer", exception);
            }
        }

        /* renamed from: of */
        public static ClassFileLocator m226of(JavaModule module) {
            return module.isNamed() ? new ForModule(module) : ForClassLoader.m232of(module.getClassLoader());
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String name) throws IOException {
            return locate(this.module, name);
        }

        protected static Resolution locate(JavaModule module, String typeName) throws IOException {
            InputStream inputStream = module.getResourceAsStream(typeName.replace('.', '/') + ".class");
            if (inputStream == null) {
                return new Resolution.Illegal(typeName);
            }
            try {
                Resolution.Explicit explicit = new Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
                inputStream.close();
                return explicit;
            } catch (Throwable th) {
                inputStream.close();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForModule$WeaklyReferenced.class */
        public static class WeaklyReferenced extends WeakReference<Object> implements ClassFileLocator {
            private final int hashCode;

            protected WeaklyReferenced(Object module) {
                super(module);
                this.hashCode = System.identityHashCode(module);
            }

            /* renamed from: of */
            public static ClassFileLocator m225of(JavaModule module) {
                if (module.isNamed()) {
                    return (module.getClassLoader() == null || module.getClassLoader() == ClassLoader.getSystemClassLoader() || module.getClassLoader() == ClassLoader.getSystemClassLoader().getParent()) ? new ForModule(module) : new WeaklyReferenced(module.unwrap());
                }
                return ForClassLoader.WeaklyReferenced.m231of(module.getClassLoader());
            }

            @Override // net.bytebuddy.dynamic.ClassFileLocator
            public Resolution locate(String name) throws IOException {
                Object module = get();
                return module == null ? new Resolution.Illegal(name) : ForModule.locate(JavaModule.m64of(module), name);
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.lang.Object
            public int hashCode() {
                return this.hashCode;
            }

            @Override // java.lang.Object
            public boolean equals(Object other) {
                Object module;
                if (this == other) {
                    return true;
                }
                return other != null && getClass() == other.getClass() && (module = ((WeaklyReferenced) other).get()) != null && get() == module;
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForJarFile.class */
    public static class ForJarFile implements ClassFileLocator {
        private static final List<String> RUNTIME_LOCATIONS = Arrays.asList("lib/rt.jar", "../lib/rt.jar", "../Classes/classes.jar");
        private final JarFile jarFile;

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.jarFile.equals(((ForJarFile) obj).jarFile);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (getClass().hashCode() * 31) + this.jarFile.hashCode();
        }

        public ForJarFile(JarFile jarFile) {
            this.jarFile = jarFile;
        }

        /* renamed from: of */
        public static ClassFileLocator m227of(File file) throws IOException {
            return new ForJarFile(new JarFile(file));
        }

        public static ClassFileLocator ofClassPath() throws IOException {
            return ofClassPath(System.getProperty("java.class.path"));
        }

        public static ClassFileLocator ofClassPath(String classPath) throws IOException {
            List<ClassFileLocator> classFileLocators = new ArrayList<>();
            for (String element : Pattern.compile(System.getProperty("path.separator"), 16).split(classPath)) {
                File file = new File(element);
                if (file.isDirectory()) {
                    classFileLocators.add(new ForFolder(file));
                } else if (file.isFile()) {
                    classFileLocators.add(m227of(file));
                }
            }
            return new Compound(classFileLocators);
        }

        public static ClassFileLocator ofRuntimeJar() throws IOException {
            String javaHome = System.getProperty("java.home").replace('\\', '/');
            File runtimeJar = null;
            Iterator<String> it = RUNTIME_LOCATIONS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                File candidate = new File(javaHome, it.next());
                if (candidate.isFile()) {
                    runtimeJar = candidate;
                    break;
                }
            }
            if (runtimeJar != null) {
                return m227of(runtimeJar);
            }
            throw new IllegalStateException("Runtime jar does not exist in " + javaHome + " for any of " + RUNTIME_LOCATIONS);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String name) throws IOException {
            ZipEntry zipEntry = this.jarFile.getEntry(name.replace('.', '/') + ".class");
            if (zipEntry == null) {
                return new Resolution.Illegal(name);
            }
            InputStream inputStream = this.jarFile.getInputStream(zipEntry);
            try {
                Resolution.Explicit explicit = new Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
                inputStream.close();
                return explicit;
            } catch (Throwable th) {
                inputStream.close();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.jarFile.close();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForModuleFile.class */
    public static class ForModuleFile implements ClassFileLocator {
        private static final String JMOD_FILE_EXTENSION = ".jmod";
        private static final List<String> BOOT_LOCATIONS = Arrays.asList("jmods", "../jmods", "modules");
        private final ZipFile zipFile;

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.zipFile.equals(((ForModuleFile) obj).zipFile);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (getClass().hashCode() * 31) + this.zipFile.hashCode();
        }

        public ForModuleFile(ZipFile zipFile) {
            this.zipFile = zipFile;
        }

        public static ClassFileLocator ofBootPath() throws IOException {
            String javaHome = System.getProperty("java.home").replace('\\', '/');
            File bootPath = null;
            Iterator<String> it = BOOT_LOCATIONS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                File candidate = new File(javaHome, it.next());
                if (candidate.isDirectory()) {
                    bootPath = candidate;
                    break;
                }
            }
            if (bootPath != null) {
                return ofBootPath(bootPath);
            }
            throw new IllegalStateException("Boot modules do not exist in " + javaHome + " for any of " + BOOT_LOCATIONS);
        }

        public static ClassFileLocator ofBootPath(File bootPath) throws IOException {
            File[] module = bootPath.listFiles();
            if (module == null) {
                return NoOp.INSTANCE;
            }
            List<ClassFileLocator> classFileLocators = new ArrayList<>(module.length);
            for (File aModule : module) {
                if (aModule.isFile()) {
                    classFileLocators.add(m224of(aModule));
                } else if (aModule.isDirectory()) {
                    classFileLocators.add(new ForFolder(aModule));
                }
            }
            return new Compound(classFileLocators);
        }

        public static ClassFileLocator ofModulePath() throws IOException {
            String modulePath = System.getProperty("jdk.module.path");
            return modulePath == null ? NoOp.INSTANCE : ofModulePath(modulePath);
        }

        public static ClassFileLocator ofModulePath(String modulePath) throws IOException {
            return ofModulePath(modulePath, System.getProperty("user.dir"));
        }

        public static ClassFileLocator ofModulePath(String modulePath, String baseFolder) throws IOException {
            ClassFileLocator classFileLocator;
            ClassFileLocator classFileLocator2;
            List<ClassFileLocator> classFileLocators = new ArrayList<>();
            for (String element : Pattern.compile(System.getProperty("path.separator"), 16).split(modulePath)) {
                File file = new File(baseFolder, element);
                if (file.isDirectory()) {
                    File[] module = file.listFiles();
                    if (module != null) {
                        for (File aModule : module) {
                            if (aModule.isDirectory()) {
                                classFileLocators.add(new ForFolder(aModule));
                            } else if (aModule.isFile()) {
                                if (aModule.getName().endsWith(JMOD_FILE_EXTENSION)) {
                                    classFileLocator2 = m224of(aModule);
                                } else {
                                    classFileLocator2 = ForJarFile.m227of(aModule);
                                }
                                classFileLocators.add(classFileLocator2);
                            }
                        }
                    }
                } else if (file.isFile()) {
                    if (file.getName().endsWith(JMOD_FILE_EXTENSION)) {
                        classFileLocator = m224of(file);
                    } else {
                        classFileLocator = ForJarFile.m227of(file);
                    }
                    classFileLocators.add(classFileLocator);
                }
            }
            return new Compound(classFileLocators);
        }

        /* renamed from: of */
        public static ClassFileLocator m224of(File file) throws IOException {
            return new ForModuleFile(new ZipFile(file));
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String name) throws IOException {
            ZipEntry zipEntry = this.zipFile.getEntry("classes/" + name.replace('.', '/') + ".class");
            if (zipEntry == null) {
                return new Resolution.Illegal(name);
            }
            InputStream inputStream = this.zipFile.getInputStream(zipEntry);
            try {
                Resolution.Explicit explicit = new Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
                inputStream.close();
                return explicit;
            } catch (Throwable th) {
                inputStream.close();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.zipFile.close();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForFolder.class */
    public static class ForFolder implements ClassFileLocator {
        private final File folder;

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.folder.equals(((ForFolder) obj).folder);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (getClass().hashCode() * 31) + this.folder.hashCode();
        }

        public ForFolder(File folder) {
            this.folder = folder;
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String name) throws IOException {
            File file = new File(this.folder, name.replace('.', File.separatorChar) + ".class");
            if (!file.exists()) {
                return new Resolution.Illegal(name);
            }
            InputStream inputStream = new FileInputStream(file);
            try {
                Resolution.Explicit explicit = new Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
                inputStream.close();
                return explicit;
            } catch (Throwable th) {
                inputStream.close();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForUrl.class */
    public static class ForUrl implements ClassFileLocator {
        private final ClassLoader classLoader;

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classLoader.equals(((ForUrl) obj).classLoader);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classLoader.hashCode();
        }

        public ForUrl(URL... url) {
            this.classLoader = (ClassLoader) AccessController.doPrivileged(new ClassLoaderCreationAction(url));
        }

        public ForUrl(Collection<? extends URL> urls) {
            this((URL[]) urls.toArray(new URL[0]));
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String name) throws IOException {
            return ForClassLoader.locate(this.classLoader, name);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.classLoader instanceof Closeable) {
                ((Closeable) this.classLoader).close();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForUrl$ClassLoaderCreationAction.class */
        protected static class ClassLoaderCreationAction implements PrivilegedAction<ClassLoader> {
            private final URL[] url;

            @Override // java.lang.Object
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && Arrays.equals(this.url, ((ClassLoaderCreationAction) obj).url);
            }

            @Override // java.lang.Object
            public int hashCode() {
                return (getClass().hashCode() * 31) + Arrays.hashCode(this.url);
            }

            protected ClassLoaderCreationAction(URL[] url) {
                this.url = url;
            }

            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return new URLClassLoader(this.url, ClassLoadingStrategy.BOOTSTRAP_LOADER);
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForInstrumentation.class */
    public static class ForInstrumentation implements ClassFileLocator {
        private static final String INSTALLER_TYPE = "net.bytebuddy.agent.Installer";
        private static final String INSTRUMENTATION_GETTER = "getInstrumentation";
        private static final Object STATIC_MEMBER = null;
        private static final Dispatcher DISPATCHER = (Dispatcher) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.class));
        private final Instrumentation instrumentation;
        private final ClassLoadingDelegate classLoadingDelegate;

        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForInstrumentation$Dispatcher.class */
        protected interface Dispatcher {
            boolean isRetransformClassesSupported(Instrumentation instrumentation);

            void addTransformer(Instrumentation instrumentation, ClassFileTransformer classFileTransformer, boolean z);

            void retransformClasses(Instrumentation instrumentation, Class<?>[] clsArr) throws UnmodifiableClassException;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.instrumentation.equals(((ForInstrumentation) obj).instrumentation) && this.classLoadingDelegate.equals(((ForInstrumentation) obj).classLoadingDelegate);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.instrumentation.hashCode()) * 31) + this.classLoadingDelegate.hashCode();
        }

        public ForInstrumentation(Instrumentation instrumentation, ClassLoader classLoader) {
            this(instrumentation, ClassLoadingDelegate.Default.m229of(classLoader));
        }

        public ForInstrumentation(Instrumentation instrumentation, ClassLoadingDelegate classLoadingDelegate) {
            if (!DISPATCHER.isRetransformClassesSupported(instrumentation)) {
                throw new IllegalArgumentException(instrumentation + " does not support retransformation");
            }
            this.instrumentation = instrumentation;
            this.classLoadingDelegate = classLoadingDelegate;
        }

        public static ClassFileLocator fromInstalledAgent(ClassLoader classLoader) {
            try {
                return new ForInstrumentation((Instrumentation) ClassLoader.getSystemClassLoader().loadClass(INSTALLER_TYPE).getMethod(INSTRUMENTATION_GETTER, new Class[0]).invoke(STATIC_MEMBER, new Object[0]), classLoader);
            } catch (RuntimeException exception) {
                throw exception;
            } catch (Exception exception2) {
                throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", exception2);
            }
        }

        /* renamed from: of */
        public static ClassFileLocator m230of(Instrumentation instrumentation, Class<?> type) {
            return new ForInstrumentation(instrumentation, ClassLoadingDelegate.Explicit.m228of(type));
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0069
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public net.bytebuddy.dynamic.ClassFileLocator.Resolution locate(java.lang.String r9) {
            /*
                r8 = this;
                net.bytebuddy.dynamic.ClassFileLocator$ForInstrumentation$ExtractionClassFileTransformer r0 = new net.bytebuddy.dynamic.ClassFileLocator$ForInstrumentation$ExtractionClassFileTransformer     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c
                r1 = r0
                r2 = r8
                net.bytebuddy.dynamic.ClassFileLocator$ForInstrumentation$ClassLoadingDelegate r2 = r2.classLoadingDelegate     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c
                java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c
                r3 = r9
                r1.<init>(r2, r3)     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c
                r10 = r0
                net.bytebuddy.dynamic.ClassFileLocator$ForInstrumentation$Dispatcher r0 = net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.DISPATCHER     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c
                r1 = r8
                java.lang.instrument.Instrumentation r1 = r1.instrumentation     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c
                r2 = r10
                r3 = 1
                r0.addTransformer(r1, r2, r3)     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c
                net.bytebuddy.dynamic.ClassFileLocator$ForInstrumentation$Dispatcher r0 = net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.DISPATCHER     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c, all -> 0x0069
                r1 = r8
                java.lang.instrument.Instrumentation r1 = r1.instrumentation     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c, all -> 0x0069
                r2 = 1
                java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c, all -> 0x0069
                r3 = r2
                r4 = 0
                r5 = r8
                net.bytebuddy.dynamic.ClassFileLocator$ForInstrumentation$ClassLoadingDelegate r5 = r5.classLoadingDelegate     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c, all -> 0x0069
                r6 = r9
                java.lang.Class r5 = r5.locate(r6)     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c, all -> 0x0069
                r3[r4] = r5     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c, all -> 0x0069
                r0.retransformClasses(r1, r2)     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c, all -> 0x0069
                r0 = r10
                byte[] r0 = r0.getBinaryRepresentation()     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c, all -> 0x0069
                r11 = r0
                r0 = r11
                if (r0 != 0) goto L_0x0051
                net.bytebuddy.dynamic.ClassFileLocator$Resolution$Illegal r0 = new net.bytebuddy.dynamic.ClassFileLocator$Resolution$Illegal     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c, all -> 0x0069
                r1 = r0
                r2 = r9
                r1.<init>(r2)     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c, all -> 0x0069
                goto L_0x0059
            L_0x0051:
                net.bytebuddy.dynamic.ClassFileLocator$Resolution$Explicit r0 = new net.bytebuddy.dynamic.ClassFileLocator$Resolution$Explicit     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c, all -> 0x0069
                r1 = r0
                r2 = r11
                r1.<init>(r2)     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c, all -> 0x0069
            L_0x0059:
                r12 = r0
                r0 = r8
                java.lang.instrument.Instrumentation r0 = r0.instrumentation     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c
                r1 = r10
                boolean r0 = r0.removeTransformer(r1)     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c
                r0 = r12
                return r0
            L_0x0069:
                r13 = move-exception
                r0 = r8
                java.lang.instrument.Instrumentation r0 = r0.instrumentation     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c
                r1 = r10
                boolean r0 = r0.removeTransformer(r1)     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c
                r0 = r13
                throw r0     // Catch: RuntimeException -> 0x0079, Exception -> 0x007c
            L_0x0079:
                r10 = move-exception
                r0 = r10
                throw r0
            L_0x007c:
                r10 = move-exception
                net.bytebuddy.dynamic.ClassFileLocator$Resolution$Illegal r0 = new net.bytebuddy.dynamic.ClassFileLocator$Resolution$Illegal
                r1 = r0
                r2 = r9
                r1.<init>(r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.locate(java.lang.String):net.bytebuddy.dynamic.ClassFileLocator$Resolution");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForInstrumentation$ClassLoadingDelegate.class */
        public interface ClassLoadingDelegate {
            Class<?> locate(String str) throws ClassNotFoundException;

            ClassLoader getClassLoader();

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForInstrumentation$ClassLoadingDelegate$Default.class */
            public static class Default implements ClassLoadingDelegate {
                protected final ClassLoader classLoader;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.classLoader.equals(((Default) obj).classLoader);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.classLoader.hashCode();
                }

                protected Default(ClassLoader classLoader) {
                    this.classLoader = classLoader;
                }

                /* renamed from: of */
                public static ClassLoadingDelegate m229of(ClassLoader classLoader) {
                    if (ForDelegatingClassLoader.isDelegating(classLoader)) {
                        return new ForDelegatingClassLoader(classLoader);
                    }
                    return new Default(classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader);
                }

                @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate
                public Class<?> locate(String name) throws ClassNotFoundException {
                    return this.classLoader.loadClass(name);
                }

                @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate
                public ClassLoader getClassLoader() {
                    return this.classLoader;
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForInstrumentation$ClassLoadingDelegate$ForDelegatingClassLoader.class */
            public static class ForDelegatingClassLoader extends Default {
                private static final String DELEGATING_CLASS_LOADER_NAME = "sun.reflect.DelegatingClassLoader";
                private static final int ONLY = 0;
                private static final Dispatcher.Initializable DISPATCHER = (Dispatcher.Initializable) AccessController.doPrivileged(Dispatcher.CreationAction.INSTANCE);

                protected ForDelegatingClassLoader(ClassLoader classLoader) {
                    super(classLoader);
                }

                protected static boolean isDelegating(ClassLoader classLoader) {
                    return classLoader != null && classLoader.getClass().getName().equals(DELEGATING_CLASS_LOADER_NAME);
                }

                @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.Default, net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate
                public Class<?> locate(String name) throws ClassNotFoundException {
                    try {
                        Vector<Class<?>> classes = DISPATCHER.initialize().extract(this.classLoader);
                        if (classes.size() != 1) {
                            return locate(name);
                        }
                        Class<?> type = classes.get(0);
                        return TypeDescription.ForLoadedType.getName(type).equals(name) ? type : locate(name);
                    } catch (RuntimeException e) {
                        return locate(name);
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForInstrumentation$ClassLoadingDelegate$ForDelegatingClassLoader$Dispatcher.class */
                protected interface Dispatcher {

                    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForInstrumentation$ClassLoadingDelegate$ForDelegatingClassLoader$Dispatcher$Initializable.class */
                    public interface Initializable {
                        Dispatcher initialize();
                    }

                    Vector<Class<?>> extract(ClassLoader classLoader);

                    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForInstrumentation$ClassLoadingDelegate$ForDelegatingClassLoader$Dispatcher$CreationAction.class */
                    public enum CreationAction implements PrivilegedAction<Initializable> {
                        INSTANCE;

                        @Override // java.security.PrivilegedAction
                        public Initializable run() {
                            try {
                                return new Resolved(ClassLoader.class.getDeclaredField("classes"));
                            } catch (Exception exception) {
                                return new Unresolved(exception.getMessage());
                            }
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForInstrumentation$ClassLoadingDelegate$ForDelegatingClassLoader$Dispatcher$Resolved.class */
                    public static class Resolved implements Dispatcher, Initializable, PrivilegedAction<Dispatcher> {
                        private final Field field;

                        @Override // java.lang.Object
                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.field.equals(((Resolved) obj).field);
                        }

                        @Override // java.lang.Object
                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.field.hashCode();
                        }

                        public Resolved(Field field) {
                            this.field = field;
                        }

                        @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher.Initializable
                        public Dispatcher initialize() {
                            return (Dispatcher) AccessController.doPrivileged(this);
                        }

                        @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher
                        public Vector<Class<?>> extract(ClassLoader classLoader) {
                            try {
                                return (Vector) this.field.get(classLoader);
                            } catch (IllegalAccessException exception) {
                                throw new IllegalStateException("Cannot access field", exception);
                            }
                        }

                        @Override // java.security.PrivilegedAction
                        public Dispatcher run() {
                            this.field.setAccessible(true);
                            return this;
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForInstrumentation$ClassLoadingDelegate$ForDelegatingClassLoader$Dispatcher$Unresolved.class */
                    public static class Unresolved implements Initializable {
                        private final String message;

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.message.equals(((Unresolved) obj).message);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.message.hashCode();
                        }

                        public Unresolved(String message) {
                            this.message = message;
                        }

                        @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher.Initializable
                        public Dispatcher initialize() {
                            throw new UnsupportedOperationException("Could not locate classes vector: " + this.message);
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForInstrumentation$ClassLoadingDelegate$Explicit.class */
            public static class Explicit implements ClassLoadingDelegate {
                private final ClassLoadingDelegate fallbackDelegate;
                private final Map<String, Class<?>> types;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fallbackDelegate.equals(((Explicit) obj).fallbackDelegate) && this.types.equals(((Explicit) obj).types);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.fallbackDelegate.hashCode()) * 31) + this.types.hashCode();
                }

                public Explicit(ClassLoader classLoader, Collection<? extends Class<?>> types) {
                    this(Default.m229of(classLoader), types);
                }

                public Explicit(ClassLoadingDelegate fallbackDelegate, Collection<? extends Class<?>> types) {
                    this.fallbackDelegate = fallbackDelegate;
                    this.types = new HashMap();
                    for (Class<?> type : types) {
                        this.types.put(TypeDescription.ForLoadedType.getName(type), type);
                    }
                }

                /* renamed from: of */
                public static ClassLoadingDelegate m228of(Class<?> type) {
                    return new Explicit(type.getClassLoader(), Collections.singleton(type));
                }

                @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate
                public Class<?> locate(String name) throws ClassNotFoundException {
                    Class<?> type = this.types.get(name);
                    return type == null ? this.fallbackDelegate.locate(name) : type;
                }

                @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate
                public ClassLoader getClassLoader() {
                    return this.fallbackDelegate.getClassLoader();
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$ForInstrumentation$ExtractionClassFileTransformer.class */
        protected static class ExtractionClassFileTransformer implements ClassFileTransformer {
            private static final byte[] DO_NOT_TRANSFORM = null;
            private final ClassLoader classLoader;
            private final String typeName;
            @SuppressFBWarnings(value = {"VO_VOLATILE_REFERENCE_TO_ARRAY"}, justification = "The array is not to be modified by contract")
            private volatile byte[] binaryRepresentation;

            protected ExtractionClassFileTransformer(ClassLoader classLoader, String typeName) {
                this.classLoader = classLoader;
                this.typeName = typeName;
            }

            @SuppressFBWarnings(value = {"EI_EXPOSE_REP", "EI_EXPOSE_REP2"}, justification = "The array is not to be modified by contract")
            public byte[] transform(ClassLoader classLoader, String internalName, Class<?> redefinedType, ProtectionDomain protectionDomain, byte[] binaryRepresentation) {
                if (internalName != null && ElementMatchers.isChildOf(this.classLoader).matches(classLoader) && this.typeName.equals(internalName.replace('/', '.'))) {
                    this.binaryRepresentation = (byte[]) binaryRepresentation.clone();
                }
                return DO_NOT_TRANSFORM;
            }

            @SuppressFBWarnings(value = {"EI_EXPOSE_REP"}, justification = "The array is not to be modified by contract")
            protected byte[] getBinaryRepresentation() {
                return this.binaryRepresentation;
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$PackageDiscriminating.class */
    public static class PackageDiscriminating implements ClassFileLocator {
        private final Map<String, ClassFileLocator> classFileLocators;

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFileLocators.equals(((PackageDiscriminating) obj).classFileLocators);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classFileLocators.hashCode();
        }

        public PackageDiscriminating(Map<String, ClassFileLocator> classFileLocators) {
            this.classFileLocators = classFileLocators;
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String name) throws IOException {
            int packageIndex = name.lastIndexOf(46);
            ClassFileLocator classFileLocator = this.classFileLocators.get(packageIndex == -1 ? "" : name.substring(0, packageIndex));
            return classFileLocator == null ? new Resolution.Illegal(name) : classFileLocator.locate(name);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            for (ClassFileLocator classFileLocator : this.classFileLocators.values()) {
                classFileLocator.close();
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/ClassFileLocator$Compound.class */
    public static class Compound implements ClassFileLocator, Closeable {
        private final List<ClassFileLocator> classFileLocators;

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFileLocators.equals(((Compound) obj).classFileLocators);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classFileLocators.hashCode();
        }

        public Compound(ClassFileLocator... classFileLocator) {
            this(Arrays.asList(classFileLocator));
        }

        public Compound(List<? extends ClassFileLocator> classFileLocators) {
            this.classFileLocators = new ArrayList();
            for (ClassFileLocator classFileLocator : classFileLocators) {
                if (classFileLocator instanceof Compound) {
                    this.classFileLocators.addAll(((Compound) classFileLocator).classFileLocators);
                } else if (!(classFileLocator instanceof NoOp)) {
                    this.classFileLocators.add(classFileLocator);
                }
            }
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String name) throws IOException {
            for (ClassFileLocator classFileLocator : this.classFileLocators) {
                Resolution resolution = classFileLocator.locate(name);
                if (resolution.isResolved()) {
                    return resolution;
                }
            }
            return new Resolution.Illegal(name);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            for (ClassFileLocator classFileLocator : this.classFileLocators) {
                classFileLocator.close();
            }
        }
    }
}
