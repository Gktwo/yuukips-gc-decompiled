package p013io.netty.util.internal;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.PosixFilePermission;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import net.bytebuddy.utility.JavaConstant;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.internal.NativeLibraryLoader */
/* loaded from: grasscutter.jar:io/netty/util/internal/NativeLibraryLoader.class */
public final class NativeLibraryLoader {
    private static final InternalLogger logger;
    private static final String NATIVE_RESOURCE_HOME = "META-INF/native/";
    private static final File WORKDIR;
    private static final boolean DELETE_NATIVE_LIB_AFTER_LOADING;
    private static final boolean TRY_TO_PATCH_SHADED_ID;
    private static final boolean DETECT_NATIVE_LIBRARY_DUPLICATES;
    private static final byte[] UNIQUE_ID_BYTES;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !NativeLibraryLoader.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(NativeLibraryLoader.class);
        UNIQUE_ID_BYTES = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes(CharsetUtil.US_ASCII);
        String workdir = SystemPropertyUtil.get("io.netty.native.workdir");
        if (workdir != null) {
            File f = new File(workdir);
            f.mkdirs();
            try {
                f = f.getAbsoluteFile();
            } catch (Exception e) {
            }
            WORKDIR = f;
            logger.debug("-Dio.netty.native.workdir: " + WORKDIR);
        } else {
            WORKDIR = PlatformDependent.tmpdir();
            logger.debug("-Dio.netty.native.workdir: " + WORKDIR + " (io.netty.tmpdir)");
        }
        DELETE_NATIVE_LIB_AFTER_LOADING = SystemPropertyUtil.getBoolean("io.netty.native.deleteLibAfterLoading", true);
        logger.debug("-Dio.netty.native.deleteLibAfterLoading: {}", Boolean.valueOf(DELETE_NATIVE_LIB_AFTER_LOADING));
        TRY_TO_PATCH_SHADED_ID = SystemPropertyUtil.getBoolean("io.netty.native.tryPatchShadedId", true);
        logger.debug("-Dio.netty.native.tryPatchShadedId: {}", Boolean.valueOf(TRY_TO_PATCH_SHADED_ID));
        DETECT_NATIVE_LIBRARY_DUPLICATES = SystemPropertyUtil.getBoolean("io.netty.native.detectNativeLibraryDuplicates", true);
        logger.debug("-Dio.netty.native.detectNativeLibraryDuplicates: {}", Boolean.valueOf(DETECT_NATIVE_LIBRARY_DUPLICATES));
    }

    public static void loadFirstAvailable(ClassLoader loader, String... names) {
        List<Throwable> suppressed = new ArrayList<>();
        for (String name : names) {
            try {
                load(name, loader);
                logger.debug("Loaded library with name '{}'", name);
                return;
            } catch (Throwable t) {
                suppressed.add(t);
            }
        }
        IllegalArgumentException iae = new IllegalArgumentException("Failed to load any of the given libraries: " + Arrays.toString(names));
        ThrowableUtil.addSuppressedAndClear(iae, suppressed);
        throw iae;
    }

    private static String calculateMangledPackagePrefix() {
        String maybeShaded = NativeLibraryLoader.class.getName();
        String expected = "io!netty!util!internal!NativeLibraryLoader".replace('!', '.');
        if (maybeShaded.endsWith(expected)) {
            return maybeShaded.substring(0, maybeShaded.length() - expected.length()).replace(JavaConstant.Dynamic.DEFAULT_NAME, "_1").replace('.', '_');
        }
        throw new UnsatisfiedLinkError(String.format("Could not find prefix added to %s to get %s. When shading, only adding a package prefix is supported", expected, maybeShaded));
    }

    public static void load(String originalName, ClassLoader loader) {
        File tmpFile;
        String mangledPackagePrefix = calculateMangledPackagePrefix();
        String name = mangledPackagePrefix + originalName;
        List<Throwable> suppressed = new ArrayList<>();
        try {
            loadLibrary(loader, name, false);
        } catch (Throwable ex) {
            try {
                suppressed.add(ex);
                String libname = System.mapLibraryName(name);
                String path = NATIVE_RESOURCE_HOME + libname;
                tmpFile = null;
                URL url = getResource(path, loader);
                if (url == null) {
                    try {
                        try {
                            if (PlatformDependent.isOsx()) {
                                String fileName = path.endsWith(".jnilib") ? "META-INF/native/lib" + name + ".dynlib" : "META-INF/native/lib" + name + ".jnilib";
                                url = getResource(fileName, loader);
                                if (url == null) {
                                    FileNotFoundException fnf = new FileNotFoundException(fileName);
                                    ThrowableUtil.addSuppressedAndClear(fnf, suppressed);
                                    throw fnf;
                                }
                            } else {
                                FileNotFoundException fnf2 = new FileNotFoundException(path);
                                ThrowableUtil.addSuppressedAndClear(fnf2, suppressed);
                                throw fnf2;
                            }
                        } catch (UnsatisfiedLinkError e) {
                            if (0 != 0 && tmpFile.isFile() && tmpFile.canRead() && !NoexecVolumeDetector.canExecuteExecutable(null)) {
                                logger.info("{} exists but cannot be executed even when execute permissions set; check volume for \"noexec\" flag; use -D{}=[path] to set native working directory separately.", tmpFile.getPath(), "io.netty.native.workdir");
                            }
                            ThrowableUtil.addSuppressedAndClear(e, suppressed);
                            throw e;
                        }
                    } catch (Exception e2) {
                        UnsatisfiedLinkError ule = new UnsatisfiedLinkError("could not load a native library: " + name);
                        ule.initCause(e2);
                        ThrowableUtil.addSuppressedAndClear(ule, suppressed);
                        throw ule;
                    }
                }
                int index = libname.lastIndexOf(46);
                File tmpFile2 = PlatformDependent.createTempFile(libname.substring(0, index), libname.substring(index), WORKDIR);
                InputStream in = url.openStream();
                OutputStream out = new FileOutputStream(tmpFile2);
                byte[] buffer = new byte[8192];
                while (true) {
                    int length = in.read(buffer);
                    if (length <= 0) {
                        break;
                    }
                    out.write(buffer, 0, length);
                }
                out.flush();
                if (shouldShadedLibraryIdBePatched(mangledPackagePrefix)) {
                    tryPatchShadedLibraryIdAndSign(tmpFile2, originalName);
                }
                closeQuietly(out);
                loadLibrary(loader, tmpFile2.getPath(), true);
                closeQuietly(in);
                closeQuietly(null);
                if (tmpFile2 == null) {
                    return;
                }
                if (!DELETE_NATIVE_LIB_AFTER_LOADING || !tmpFile2.delete()) {
                    tmpFile2.deleteOnExit();
                }
            } catch (Throwable th) {
                closeQuietly(null);
                closeQuietly(null);
                if (0 != 0 && (!DELETE_NATIVE_LIB_AFTER_LOADING || !tmpFile.delete())) {
                    tmpFile.deleteOnExit();
                }
                throw th;
            }
        }
    }

    private static URL getResource(String path, ClassLoader loader) {
        Enumeration<URL> urls;
        try {
            if (loader == null) {
                urls = ClassLoader.getSystemResources(path);
            } else {
                urls = loader.getResources(path);
            }
            List<URL> urlsList = Collections.list(urls);
            int size = urlsList.size();
            switch (size) {
                case 0:
                    return null;
                case 1:
                    return urlsList.get(0);
                default:
                    if (DETECT_NATIVE_LIBRARY_DUPLICATES) {
                        try {
                            MessageDigest md = MessageDigest.getInstance("SHA-256");
                            URL url = urlsList.get(0);
                            byte[] digest = digest(md, url);
                            boolean allSame = true;
                            if (digest != null) {
                                for (int i = 1; i < size; i++) {
                                    byte[] digest2 = digest(md, urlsList.get(i));
                                    if (digest2 == null || !Arrays.equals(digest, digest2)) {
                                        allSame = false;
                                    }
                                }
                            } else {
                                allSame = false;
                            }
                            if (allSame) {
                                return url;
                            }
                        } catch (NoSuchAlgorithmException e) {
                            logger.debug("Don't support SHA-256, can't check if resources have same content.", (Throwable) e);
                        }
                        throw new IllegalStateException("Multiple resources found for '" + path + "' with different content: " + urlsList);
                    }
                    logger.warn("Multiple resources found for '" + path + "' with different content: " + urlsList + ". Please fix your dependency graph.");
                    return urlsList.get(0);
            }
        } catch (IOException iox) {
            throw new RuntimeException("An error occurred while getting the resources for " + path, iox);
        }
    }

    private static byte[] digest(MessageDigest digest, URL url) {
        InputStream in;
        try {
            in = null;
            try {
                in = url.openStream();
                byte[] bytes = new byte[8192];
                while (true) {
                    int i = in.read(bytes);
                    if (i != -1) {
                        digest.update(bytes, 0, i);
                    } else {
                        byte[] digest2 = digest.digest();
                        closeQuietly(in);
                        return digest2;
                    }
                }
            } catch (IOException e) {
                logger.debug("Can't read resource.", (Throwable) e);
                closeQuietly(in);
                return null;
            }
        } catch (Throwable th) {
            closeQuietly(in);
            throw th;
        }
    }

    static void tryPatchShadedLibraryIdAndSign(File libraryFile, String originalName) {
        if (tryExec("install_name_tool -id " + new String(generateUniqueId(originalName.length()), CharsetUtil.UTF_8) + " " + libraryFile.getAbsolutePath())) {
            tryExec("codesign -s - " + libraryFile.getAbsolutePath());
        }
    }

    private static boolean tryExec(String cmd) {
        try {
            int exitValue = Runtime.getRuntime().exec(cmd).waitFor();
            if (exitValue != 0) {
                logger.debug("Execution of '{}' failed: {}", cmd, Integer.valueOf(exitValue));
                return false;
            }
            logger.debug("Execution of '{}' succeed: {}", cmd, Integer.valueOf(exitValue));
            return true;
        } catch (IOException e) {
            logger.info("Execution of '{}' failed.", cmd, e);
            return false;
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            return false;
        } catch (SecurityException e3) {
            logger.error("Execution of '{}' failed.", cmd, e3);
            return false;
        }
    }

    private static boolean shouldShadedLibraryIdBePatched(String packagePrefix) {
        return TRY_TO_PATCH_SHADED_ID && PlatformDependent.isOsx() && !packagePrefix.isEmpty();
    }

    private static byte[] generateUniqueId(int length) {
        byte[] idBytes = new byte[length];
        for (int i = 0; i < idBytes.length; i++) {
            idBytes[i] = UNIQUE_ID_BYTES[PlatformDependent.threadLocalRandom().nextInt(UNIQUE_ID_BYTES.length)];
        }
        return idBytes;
    }

    private static void loadLibrary(ClassLoader loader, String name, boolean absolute) {
        Throwable suppressed = null;
        try {
            try {
                loadLibraryByHelper(tryToLoadClass(loader, NativeLibraryUtil.class), name, absolute);
                logger.debug("Successfully loaded the library {}", name);
            } catch (Exception e) {
                suppressed = e;
                NativeLibraryUtil.loadLibrary(name, absolute);
                logger.debug("Successfully loaded the library {}", name);
            } catch (UnsatisfiedLinkError e2) {
                suppressed = e2;
                NativeLibraryUtil.loadLibrary(name, absolute);
                logger.debug("Successfully loaded the library {}", name);
            }
        } catch (NoSuchMethodError nsme) {
            if (suppressed != null) {
                ThrowableUtil.addSuppressed(nsme, suppressed);
            }
            rethrowWithMoreDetailsIfPossible(name, nsme);
        } catch (UnsatisfiedLinkError ule) {
            if (suppressed != null) {
                ThrowableUtil.addSuppressed(ule, suppressed);
            }
            throw ule;
        }
    }

    @SuppressJava6Requirement(reason = "Guarded by version check")
    private static void rethrowWithMoreDetailsIfPossible(String name, NoSuchMethodError error) {
        if (PlatformDependent.javaVersion() >= 7) {
            throw new LinkageError("Possible multiple incompatible native libraries on the classpath for '" + name + "'?", error);
        }
        throw error;
    }

    private static void loadLibraryByHelper(final Class<?> helper, final String name, final boolean absolute) throws UnsatisfiedLinkError {
        Object ret = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.NativeLibraryLoader.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    Method method = helper.getMethod("loadLibrary", String.class, Boolean.TYPE);
                    method.setAccessible(true);
                    return method.invoke(null, name, Boolean.valueOf(absolute));
                } catch (Exception e) {
                    return e;
                }
            }
        });
        if (ret instanceof Throwable) {
            Throwable t = (Throwable) ret;
            if ($assertionsDisabled || !(t instanceof UnsatisfiedLinkError)) {
                Throwable cause = t.getCause();
                if (cause instanceof UnsatisfiedLinkError) {
                    throw ((UnsatisfiedLinkError) cause);
                }
                UnsatisfiedLinkError ule = new UnsatisfiedLinkError(t.getMessage());
                ule.initCause(t);
                throw ule;
            }
            throw new AssertionError(t + " should be a wrapper throwable");
        }
    }

    private static Class<?> tryToLoadClass(final ClassLoader loader, final Class<?> helper) throws ClassNotFoundException {
        try {
            return Class.forName(helper.getName(), false, loader);
        } catch (ClassNotFoundException e1) {
            if (loader == null) {
                throw e1;
            }
            try {
                final byte[] classBinary = classToByteArray(helper);
                return (Class) AccessController.doPrivileged(new PrivilegedAction<Class<?>>() { // from class: io.netty.util.internal.NativeLibraryLoader.2
                    @Override // java.security.PrivilegedAction
                    public Class<?> run() {
                        try {
                            Method defineClass = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE);
                            defineClass.setAccessible(true);
                            return (Class) defineClass.invoke(loader, helper.getName(), classBinary, 0, Integer.valueOf(classBinary.length));
                        } catch (Exception e) {
                            throw new IllegalStateException("Define class failed!", e);
                        }
                    }
                });
            } catch (ClassNotFoundException e2) {
                ThrowableUtil.addSuppressed(e2, e1);
                throw e2;
            } catch (Error e22) {
                ThrowableUtil.addSuppressed(e22, e1);
                throw e22;
            } catch (RuntimeException e23) {
                ThrowableUtil.addSuppressed(e23, e1);
                throw e23;
            }
        }
    }

    private static byte[] classToByteArray(Class<?> clazz) throws ClassNotFoundException {
        InputStream in;
        ByteArrayOutputStream out;
        String fileName = clazz.getName();
        int lastDot = fileName.lastIndexOf(46);
        if (lastDot > 0) {
            fileName = fileName.substring(lastDot + 1);
        }
        URL classUrl = clazz.getResource(fileName + ".class");
        if (classUrl == null) {
            throw new ClassNotFoundException(clazz.getName());
        }
        try {
            byte[] buf = new byte[1024];
            out = new ByteArrayOutputStream(4096);
            in = null;
            try {
                in = classUrl.openStream();
                while (true) {
                    int r = in.read(buf);
                    if (r != -1) {
                        out.write(buf, 0, r);
                    } else {
                        byte[] byteArray = out.toByteArray();
                        closeQuietly(in);
                        closeQuietly(out);
                        return byteArray;
                    }
                }
            } catch (IOException ex) {
                throw new ClassNotFoundException(clazz.getName(), ex);
            }
        } catch (Throwable th) {
            closeQuietly(in);
            closeQuietly(out);
            throw th;
        }
    }

    private static void closeQuietly(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
            }
        }
    }

    private NativeLibraryLoader() {
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.internal.NativeLibraryLoader$NoexecVolumeDetector */
    /* loaded from: grasscutter.jar:io/netty/util/internal/NativeLibraryLoader$NoexecVolumeDetector.class */
    public static final class NoexecVolumeDetector {
        /* access modifiers changed from: private */
        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        public static boolean canExecuteExecutable(File file) throws IOException {
            if (PlatformDependent.javaVersion() < 7 || file.canExecute()) {
                return true;
            }
            Set<PosixFilePermission> existingFilePermissions = Files.getPosixFilePermissions(file.toPath(), new LinkOption[0]);
            Collection<? extends PosixFilePermission> of = EnumSet.of(PosixFilePermission.OWNER_EXECUTE, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_EXECUTE);
            if (existingFilePermissions.containsAll(of)) {
                return false;
            }
            Set<PosixFilePermission> newPermissions = EnumSet.copyOf(existingFilePermissions);
            newPermissions.addAll(of);
            Files.setPosixFilePermissions(file.toPath(), newPermissions);
            return file.canExecute();
        }

        private NoexecVolumeDetector() {
        }
    }
}
