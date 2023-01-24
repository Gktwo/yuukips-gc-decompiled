package com.sun.jna;

import dev.morphia.mapping.Mapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler;

/* loaded from: grasscutter.jar:com/sun/jna/NativeLibrary.class */
public class NativeLibrary {
    private static final Logger LOG = Logger.getLogger(NativeLibrary.class.getName());
    private static final Level DEBUG_LOAD_LEVEL;
    private long handle;
    private final String libraryName;
    private final String libraryPath;
    private final Map<String, Function> functions = new HashMap();
    final int callFlags;
    private String encoding;
    final Map<String, ?> options;
    private static final Map<String, Reference<NativeLibrary>> libraries;
    private static final Map<String, List<String>> searchPaths;
    private static final LinkedHashSet<String> librarySearchPath;
    private static final int DEFAULT_OPEN_OPTIONS = -1;
    private static Method addSuppressedMethod;

    static {
        DEBUG_LOAD_LEVEL = Native.DEBUG_LOAD ? Level.INFO : Level.FINE;
        libraries = new HashMap();
        searchPaths = Collections.synchronizedMap(new HashMap());
        librarySearchPath = new LinkedHashSet<>();
        if (Native.POINTER_SIZE == 0) {
            throw new Error("Native library not initialized");
        }
        addSuppressedMethod = null;
        try {
            addSuppressedMethod = Throwable.class.getMethod("addSuppressed", Throwable.class);
        } catch (NoSuchMethodException e) {
        } catch (SecurityException ex) {
            Logger.getLogger(NativeLibrary.class.getName()).log(Level.SEVERE, "Failed to initialize 'addSuppressed' method", (Throwable) ex);
        }
        String webstartPath = Native.getWebStartLibraryPath("jnidispatch");
        if (webstartPath != null) {
            librarySearchPath.add(webstartPath);
        }
        if (System.getProperty("jna.platform.library.path") == null && !Platform.isWindows()) {
            String platformPath = "";
            String sep = "";
            String archPath = "";
            if (Platform.isLinux() || Platform.isSolaris() || Platform.isFreeBSD() || Platform.iskFreeBSD()) {
                archPath = (Platform.isSolaris() ? "/" : "") + (Native.POINTER_SIZE * 8);
            }
            String[] paths = {"/usr/lib" + archPath, "/lib" + archPath, "/usr/lib", "/lib"};
            if (Platform.isLinux() || Platform.iskFreeBSD() || Platform.isGNU()) {
                String multiArchPath = getMultiArchPath();
                paths = new String[]{"/usr/lib/" + multiArchPath, "/lib/" + multiArchPath, "/usr/lib" + archPath, "/lib" + archPath, "/usr/lib", "/lib"};
            }
            if (Platform.isLinux()) {
                ArrayList<String> ldPaths = getLinuxLdPaths();
                for (int i = paths.length - 1; 0 <= i; i--) {
                    int found = ldPaths.indexOf(paths[i]);
                    if (found != -1) {
                        ldPaths.remove(found);
                    }
                    ldPaths.add(0, paths[i]);
                }
                paths = (String[]) ldPaths.toArray(new String[0]);
            }
            for (int i2 = 0; i2 < paths.length; i2++) {
                File dir = new File(paths[i2]);
                if (dir.exists() && dir.isDirectory()) {
                    platformPath = platformPath + sep + paths[i2];
                    sep = File.pathSeparator;
                }
            }
            if (!"".equals(platformPath)) {
                System.setProperty("jna.platform.library.path", platformPath);
            }
        }
        librarySearchPath.addAll(initPaths("jna.platform.library.path"));
    }

    private static String functionKey(String name, int flags, String encoding) {
        return name + "|" + flags + "|" + encoding;
    }

    private NativeLibrary(String libraryName, String libraryPath, long handle, Map<String, ?> options) {
        this.libraryName = getLibraryName(libraryName);
        this.libraryPath = libraryPath;
        this.handle = handle;
        Object option = options.get(Library.OPTION_CALLING_CONVENTION);
        this.callFlags = option instanceof Number ? ((Number) option).intValue() : 0;
        this.options = options;
        this.encoding = (String) options.get(Library.OPTION_STRING_ENCODING);
        if (this.encoding == null) {
            this.encoding = Native.getDefaultStringEncoding();
        }
        if (Platform.isWindows() && "kernel32".equals(this.libraryName.toLowerCase())) {
            synchronized (this.functions) {
                this.functions.put(functionKey("GetLastError", this.callFlags, this.encoding), new Function(this, "GetLastError", 63, this.encoding) { // from class: com.sun.jna.NativeLibrary.1
                    @Override // com.sun.jna.Function
                    Object invoke(Object[] args, Class<?> returnType, boolean b, int fixedArgs) {
                        return Integer.valueOf(Native.getLastError());
                    }

                    /* access modifiers changed from: package-private */
                    @Override // com.sun.jna.Function
                    public Object invoke(Method invokingMethod, Class<?>[] paramTypes, Class<?> returnType, Object[] inArgs, Map<String, ?> options2) {
                        return Integer.valueOf(Native.getLastError());
                    }
                });
            }
        }
    }

    private static int openFlags(Map<String, ?> options) {
        Object opt = options.get(Library.OPTION_OPEN_FLAGS);
        if (opt instanceof Number) {
            return ((Number) opt).intValue();
        }
        return -1;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:72:0x0405
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static com.sun.jna.NativeLibrary loadLibrary(java.lang.String r8, java.util.Map<java.lang.String, ?> r9) {
        /*
        // Method dump skipped, instructions count: 1294
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.NativeLibrary.loadLibrary(java.lang.String, java.util.Map):com.sun.jna.NativeLibrary");
    }

    private static void addSuppressedReflected(Throwable target, Throwable suppressed) {
        if (addSuppressedMethod != null) {
            try {
                addSuppressedMethod.invoke(target, suppressed);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException("Failed to call addSuppressedMethod", ex);
            } catch (IllegalArgumentException ex2) {
                throw new RuntimeException("Failed to call addSuppressedMethod", ex2);
            } catch (InvocationTargetException ex3) {
                throw new RuntimeException("Failed to call addSuppressedMethod", ex3);
            }
        }
    }

    static String[] matchFramework(String libraryName) {
        Set<String> paths = new LinkedHashSet<>();
        File framework = new File(libraryName);
        if (!framework.isAbsolute()) {
            String[] PREFIXES = {System.getProperty("user.home"), "", "/System"};
            String suffix = !libraryName.contains(".framework") ? libraryName + ".framework/" + libraryName : libraryName;
            int length = PREFIXES.length;
            for (int i = 0; i < length; i++) {
                File framework2 = new File(PREFIXES[i] + "/Library/Frameworks/" + suffix);
                if (framework2.exists()) {
                    return new String[]{framework2.getAbsolutePath()};
                }
                paths.add(framework2.getAbsolutePath());
            }
        } else if (!libraryName.contains(".framework")) {
            File framework3 = new File(new File(framework.getParentFile(), framework.getName() + ".framework"), framework.getName());
            if (framework3.exists()) {
                return new String[]{framework3.getAbsolutePath()};
            }
            paths.add(framework3.getAbsolutePath());
        } else if (framework.exists()) {
            return new String[]{framework.getAbsolutePath()};
        } else {
            paths.add(framework.getAbsolutePath());
        }
        return (String[]) paths.toArray(new String[0]);
    }

    private String getLibraryName(String libraryName) {
        String simplified = libraryName;
        String template = mapSharedLibraryName(NestedJarHandler.TEMP_FILENAME_LEAF_SEPARATOR);
        int prefixEnd = template.indexOf(NestedJarHandler.TEMP_FILENAME_LEAF_SEPARATOR);
        if (prefixEnd > 0 && simplified.startsWith(template.substring(0, prefixEnd))) {
            simplified = simplified.substring(prefixEnd);
        }
        int suffixStart = simplified.indexOf(template.substring(prefixEnd + NestedJarHandler.TEMP_FILENAME_LEAF_SEPARATOR.length()));
        if (suffixStart != -1) {
            simplified = simplified.substring(0, suffixStart);
        }
        return simplified;
    }

    public static final NativeLibrary getInstance(String libraryName) {
        return getInstance(libraryName, Collections.emptyMap());
    }

    public static final NativeLibrary getInstance(String libraryName, ClassLoader classLoader) {
        return getInstance(libraryName, Collections.singletonMap(Library.OPTION_CLASSLOADER, classLoader));
    }

    public static final NativeLibrary getInstance(String libraryName, Map<String, ?> libraryOptions) {
        NativeLibrary library;
        Map<String, Object> options = new HashMap<>(libraryOptions);
        if (options.get(Library.OPTION_CALLING_CONVENTION) == null) {
            options.put(Library.OPTION_CALLING_CONVENTION, 0);
        }
        if ((Platform.isLinux() || Platform.isFreeBSD() || Platform.isAIX()) && Platform.C_LIBRARY_NAME.equals(libraryName)) {
            libraryName = null;
        }
        synchronized (libraries) {
            Reference<NativeLibrary> ref = libraries.get(libraryName + options);
            library = ref != null ? ref.get() : null;
            if (library == null) {
                if (libraryName == null) {
                    library = new NativeLibrary("<process>", null, Native.open(null, openFlags(options)), options);
                } else {
                    library = loadLibrary(libraryName, options);
                }
                Reference<NativeLibrary> ref2 = new WeakReference<>(library);
                libraries.put(library.getName() + options, ref2);
                File file = library.getFile();
                if (file != null) {
                    libraries.put(file.getAbsolutePath() + options, ref2);
                    libraries.put(file.getName() + options, ref2);
                }
            }
        }
        return library;
    }

    public static final synchronized NativeLibrary getProcess() {
        return getInstance(null);
    }

    public static final synchronized NativeLibrary getProcess(Map<String, ?> options) {
        return getInstance((String) null, options);
    }

    public static final void addSearchPath(String libraryName, String path) {
        synchronized (searchPaths) {
            List<String> customPaths = searchPaths.get(libraryName);
            if (customPaths == null) {
                customPaths = Collections.synchronizedList(new ArrayList());
                searchPaths.put(libraryName, customPaths);
            }
            customPaths.add(path);
        }
    }

    public Function getFunction(String functionName) {
        return getFunction(functionName, this.callFlags);
    }

    /* access modifiers changed from: package-private */
    public Function getFunction(String name, Method method) {
        FunctionMapper mapper = (FunctionMapper) this.options.get(Library.OPTION_FUNCTION_MAPPER);
        if (mapper != null) {
            name = mapper.getFunctionName(this, method);
        }
        String prefix = System.getProperty("jna.profiler.prefix", "$$YJP$$");
        if (name.startsWith(prefix)) {
            name = name.substring(prefix.length());
        }
        int flags = this.callFlags;
        for (Class<?> cls : method.getExceptionTypes()) {
            if (LastErrorException.class.isAssignableFrom(cls)) {
                flags |= 64;
            }
        }
        return getFunction(name, flags);
    }

    public Function getFunction(String functionName, int callFlags) {
        return getFunction(functionName, callFlags, this.encoding);
    }

    public Function getFunction(String functionName, int callFlags, String encoding) {
        Function function;
        if (functionName == null) {
            throw new NullPointerException("Function name may not be null");
        }
        synchronized (this.functions) {
            String key = functionKey(functionName, callFlags, encoding);
            function = this.functions.get(key);
            if (function == null) {
                function = new Function(this, functionName, callFlags, encoding);
                this.functions.put(key, function);
            }
        }
        return function;
    }

    public Map<String, ?> getOptions() {
        return this.options;
    }

    public Pointer getGlobalVariableAddress(String symbolName) {
        try {
            return new Pointer(getSymbolAddress(symbolName));
        } catch (UnsatisfiedLinkError e) {
            throw new UnsatisfiedLinkError("Error looking up '" + symbolName + "': " + e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public long getSymbolAddress(String name) {
        if (this.handle != 0) {
            return Native.findSymbol(this.handle, name);
        }
        throw new UnsatisfiedLinkError("Library has been unloaded");
    }

    public String toString() {
        return "Native Library <" + this.libraryPath + "@" + this.handle + ">";
    }

    public String getName() {
        return this.libraryName;
    }

    public File getFile() {
        if (this.libraryPath == null) {
            return null;
        }
        return new File(this.libraryPath);
    }

    protected void finalize() {
        dispose();
    }

    /* access modifiers changed from: package-private */
    public static void disposeAll() {
        Set<Reference<NativeLibrary>> values;
        synchronized (libraries) {
            values = new LinkedHashSet<>(libraries.values());
        }
        for (Reference<NativeLibrary> ref : values) {
            NativeLibrary lib = ref.get();
            if (lib != null) {
                lib.dispose();
            }
        }
    }

    public void dispose() {
        Set<String> keys = new HashSet<>();
        synchronized (libraries) {
            for (Map.Entry<String, Reference<NativeLibrary>> e : libraries.entrySet()) {
                if (e.getValue().get() == this) {
                    keys.add(e.getKey());
                }
            }
            for (String k : keys) {
                libraries.remove(k);
            }
        }
        synchronized (this) {
            if (this.handle != 0) {
                Native.close(this.handle);
                this.handle = 0;
            }
        }
    }

    private static List<String> initPaths(String key) {
        String value = System.getProperty(key, "");
        if ("".equals(value)) {
            return Collections.emptyList();
        }
        StringTokenizer st = new StringTokenizer(value, File.pathSeparator);
        List<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String path = st.nextToken();
            if (!"".equals(path)) {
                list.add(path);
            }
        }
        return list;
    }

    private static String findLibraryPath(String libName, Collection<String> searchPath) {
        if (new File(libName).isAbsolute()) {
            return libName;
        }
        String name = mapSharedLibraryName(libName);
        for (String path : searchPath) {
            File file = new File(path, name);
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            if (Platform.isMac() && name.endsWith(".dylib")) {
                File file2 = new File(path, name.substring(0, name.lastIndexOf(".dylib")) + ".jnilib");
                if (file2.exists()) {
                    return file2.getAbsolutePath();
                }
            }
        }
        return name;
    }

    /* access modifiers changed from: package-private */
    public static String mapSharedLibraryName(String libName) {
        if (!Platform.isMac()) {
            if (Platform.isLinux() || Platform.isFreeBSD()) {
                if (isVersionedName(libName) || libName.endsWith(".so")) {
                    return libName;
                }
            } else if (Platform.isAIX()) {
                if (libName.startsWith("lib")) {
                    return libName;
                }
            } else if (Platform.isWindows() && (libName.endsWith(".drv") || libName.endsWith(".dll") || libName.endsWith(".ocx"))) {
                return libName;
            }
            return System.mapLibraryName(libName);
        } else if (libName.startsWith("lib") && (libName.endsWith(".dylib") || libName.endsWith(".jnilib"))) {
            return libName;
        } else {
            String name = System.mapLibraryName(libName);
            if (name.endsWith(".jnilib")) {
                return name.substring(0, name.lastIndexOf(".jnilib")) + ".dylib";
            }
            return name;
        }
    }

    /* access modifiers changed from: private */
    public static boolean isVersionedName(String name) {
        int so;
        if (!name.startsWith("lib") || (so = name.lastIndexOf(".so.")) == -1 || so + 4 >= name.length()) {
            return false;
        }
        for (int i = so + 4; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!(Character.isDigit(ch) || ch == '.')) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [double] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String matchLibrary(final java.lang.String r5, java.util.Collection<java.lang.String> r6) {
        /*
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            r7 = r0
            r0 = r7
            boolean r0 = r0.isAbsolute()
            if (r0 == 0) goto L_0x001f
            r0 = 1
            java.lang.String[] r0 = new java.lang.String[r0]
            r1 = r0
            r2 = 0
            r3 = r7
            java.lang.String r3 = r3.getParent()
            r1[r2] = r3
            java.util.List r0 = java.util.Arrays.asList(r0)
            r6 = r0
        L_0x001f:
            com.sun.jna.NativeLibrary$2 r0 = new com.sun.jna.NativeLibrary$2
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            r8 = r0
            java.util.LinkedList r0 = new java.util.LinkedList
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r6
            java.util.Iterator r0 = r0.iterator()
            r10 = r0
        L_0x0039:
            r0 = r10
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0079
            r0 = r10
            java.lang.Object r0 = r0.next()
            java.lang.String r0 = (java.lang.String) r0
            r11 = r0
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r11
            r1.<init>(r2)
            r1 = r8
            java.io.File[] r0 = r0.listFiles(r1)
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L_0x0076
            r0 = r12
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0076
            r0 = r9
            r1 = r12
            java.util.List r1 = java.util.Arrays.asList(r1)
            boolean r0 = r0.addAll(r1)
        L_0x0076:
            goto L_0x0039
        L_0x0079:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r10 = r0
            r0 = 0
            r12 = r0
            r0 = r9
            java.util.Iterator r0 = r0.iterator()
            r13 = r0
        L_0x008a:
            r0 = r13
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00d1
            r0 = r13
            java.lang.Object r0 = r0.next()
            java.io.File r0 = (java.io.File) r0
            r14 = r0
            r0 = r14
            java.lang.String r0 = r0.getAbsolutePath()
            r15 = r0
            r0 = r15
            r1 = r15
            java.lang.String r2 = ".so."
            int r1 = r1.lastIndexOf(r2)
            r2 = 4
            int r1 = r1 + r2
            java.lang.String r0 = r0.substring(r1)
            r16 = r0
            r0 = r16
            double r0 = parseVersion(r0)
            r17 = r0
            r0 = r17
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ce
            r0 = r17
            r10 = r0
            r0 = r15
            r12 = r0
        L_0x00ce:
            goto L_0x008a
        L_0x00d1:
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.NativeLibrary.matchLibrary(java.lang.String, java.util.Collection):java.lang.String");
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [double] */
    /* JADX WARN: Type inference failed for: r0v11, types: [double] */
    static double parseVersion(String ver) {
        String num;
        char c = 0;
        char c2 = 0;
        int dot = ver.indexOf(Mapper.IGNORED_FIELDNAME);
        while (ver != null) {
            if (dot != -1) {
                num = ver.substring(0, dot);
                ver = ver.substring(dot + 1);
                dot = ver.indexOf(Mapper.IGNORED_FIELDNAME);
            } else {
                num = ver;
                ver = null;
            }
            try {
                c += ((double) Integer.parseInt(num)) / c2;
                c2 *= 0;
            } catch (NumberFormatException e) {
                return 0.0d;
            }
        }
        return c;
    }

    private static String getMultiArchPath() {
        String kernel;
        String cpu = Platform.ARCH;
        if (Platform.iskFreeBSD()) {
            kernel = "-kfreebsd";
        } else {
            kernel = Platform.isGNU() ? "" : "-linux";
        }
        String libc = "-gnu";
        if (Platform.isIntel()) {
            cpu = Platform.is64Bit() ? "x86_64" : "i386";
        } else if (Platform.isPPC()) {
            cpu = Platform.is64Bit() ? "powerpc64" : "powerpc";
        } else if (Platform.isARM()) {
            cpu = "arm";
            libc = "-gnueabi";
        } else if (Platform.ARCH.equals("mips64el")) {
            libc = "-gnuabi64";
        }
        return cpu + kernel + libc;
    }

    private static ArrayList<String> getLinuxLdPaths() {
        ArrayList<String> ldPaths = new ArrayList<>();
        Process process = null;
        BufferedReader reader = null;
        try {
            process = Runtime.getRuntime().exec("/sbin/ldconfig -p");
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (true) {
                String buffer = reader.readLine();
                if (buffer == null) {
                    break;
                }
                int startPath = buffer.indexOf(" => ");
                int endPath = buffer.lastIndexOf(47);
                if (!(startPath == -1 || endPath == -1 || startPath >= endPath)) {
                    String path = buffer.substring(startPath + 4, endPath);
                    if (!ldPaths.contains(path)) {
                        ldPaths.add(path);
                    }
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
            if (process != null) {
                try {
                    process.waitFor();
                } catch (InterruptedException e2) {
                }
            }
        } catch (Exception e3) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e4) {
                }
            }
            if (process != null) {
                try {
                    process.waitFor();
                } catch (InterruptedException e5) {
                }
            }
        } catch (Throwable th) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e6) {
                }
            }
            if (process != null) {
                try {
                    process.waitFor();
                } catch (InterruptedException e7) {
                }
            }
            throw th;
        }
        return ldPaths;
    }
}
