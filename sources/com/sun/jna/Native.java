package com.sun.jna;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Structure;
import dev.morphia.mapping.Mapper;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Window;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.bytebuddy.ClassFileVersion;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:com/sun/jna/Native.class */
public final class Native implements Version {
    private static final Logger LOG = Logger.getLogger(Native.class.getName());
    public static final Charset DEFAULT_CHARSET;
    public static final String DEFAULT_ENCODING;
    public static final boolean DEBUG_LOAD;
    public static final boolean DEBUG_JNA_LOAD;
    private static final Level DEBUG_JNA_LOAD_LEVEL;
    static String jnidispatchPath;
    private static final Map<Class<?>, Map<String, Object>> typeOptions;
    private static final Map<Class<?>, Reference<?>> libraries;
    private static final String _OPTION_ENCLOSING_LIBRARY = "enclosing-library";
    private static final Callback.UncaughtExceptionHandler DEFAULT_HANDLER;
    private static Callback.UncaughtExceptionHandler callbackExceptionHandler;
    public static final int POINTER_SIZE;
    public static final int LONG_SIZE;
    public static final int WCHAR_SIZE;
    public static final int SIZE_T_SIZE;
    public static final int BOOL_SIZE;
    public static final int LONG_DOUBLE_SIZE;
    private static final int TYPE_VOIDP = 0;
    private static final int TYPE_LONG = 1;
    private static final int TYPE_WCHAR_T = 2;
    private static final int TYPE_SIZE_T = 3;
    private static final int TYPE_BOOL = 4;
    private static final int TYPE_LONG_DOUBLE = 5;
    static final int MAX_ALIGNMENT;
    static final int MAX_PADDING;
    private static final Object finalizer;
    static final String JNA_TMPLIB_PREFIX = "jna";
    private static final Map<Class<?>, long[]> registeredClasses;
    private static final Map<Class<?>, NativeLibrary> registeredLibraries;
    static final int CB_HAS_INITIALIZER = 1;
    private static final int CVT_UNSUPPORTED = -1;
    private static final int CVT_DEFAULT = 0;
    private static final int CVT_POINTER = 1;
    private static final int CVT_STRING = 2;
    private static final int CVT_STRUCTURE = 3;
    private static final int CVT_STRUCTURE_BYVAL = 4;
    private static final int CVT_BUFFER = 5;
    private static final int CVT_ARRAY_BYTE = 6;
    private static final int CVT_ARRAY_SHORT = 7;
    private static final int CVT_ARRAY_CHAR = 8;
    private static final int CVT_ARRAY_INT = 9;
    private static final int CVT_ARRAY_LONG = 10;
    private static final int CVT_ARRAY_FLOAT = 11;
    private static final int CVT_ARRAY_DOUBLE = 12;
    private static final int CVT_ARRAY_BOOLEAN = 13;
    private static final int CVT_BOOLEAN = 14;
    private static final int CVT_CALLBACK = 15;
    private static final int CVT_FLOAT = 16;
    private static final int CVT_NATIVE_MAPPED = 17;
    private static final int CVT_NATIVE_MAPPED_STRING = 18;
    private static final int CVT_NATIVE_MAPPED_WSTRING = 19;
    private static final int CVT_WSTRING = 20;
    private static final int CVT_INTEGER_TYPE = 21;
    private static final int CVT_POINTER_TYPE = 22;
    private static final int CVT_TYPE_MAPPER = 23;
    private static final int CVT_TYPE_MAPPER_STRING = 24;
    private static final int CVT_TYPE_MAPPER_WSTRING = 25;
    private static final int CVT_OBJECT = 26;
    private static final int CVT_JNIENV = 27;
    private static final int CVT_SHORT = 28;
    private static final int CVT_BYTE = 29;
    static final int CB_OPTION_DIRECT = 1;
    static final int CB_OPTION_IN_DLL = 2;
    private static final ThreadLocal<Memory> nativeThreadTerminationFlag;
    private static final Map<Thread, Pointer> nativeThreads;

    /* loaded from: grasscutter.jar:com/sun/jna/Native$ffi_callback.class */
    public interface ffi_callback {
        void invoke(long j, long j2, long j3);
    }

    private static native void initIDs();

    public static native synchronized void setProtected(boolean z);

    public static native synchronized boolean isProtected();

    static native long getWindowHandle0(Component component);

    private static native long _getDirectBufferPointer(Buffer buffer);

    private static native int sizeof(int i);

    private static native String getNativeVersion();

    private static native String getAPIChecksum();

    public static native int getLastError();

    public static native void setLastError(int i);

    private static native void unregister(Class<?> cls, long[] jArr);

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: com.sun.jna.Native.register(java.lang.Class<?>, com.sun.jna.NativeLibrary):void, file: grasscutter.jar:com/sun/jna/Native.class
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:204)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.plugins.input.java.utils.JavaClassParseException: Unknown opcode: 0x5e
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:71)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	... 5 more
        */
    public static void register(java.lang.Class<?> r0, com.sun.jna.NativeLibrary r1) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: com.sun.jna.Native.register(java.lang.Class<?>, com.sun.jna.NativeLibrary):void, file: grasscutter.jar:com/sun/jna/Native.class
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.Native.register(java.lang.Class, com.sun.jna.NativeLibrary):void");
    }

    private static native long registerMethod(Class<?> cls, String str, String str2, int[] iArr, long[] jArr, long[] jArr2, int i, long j, long j2, Method method, long j3, int i2, boolean z, ToNativeConverter[] toNativeConverterArr, FromNativeConverter fromNativeConverter, String str3);

    public static native long ffi_prep_cif(int i, int i2, long j, long j2);

    public static native void ffi_call(long j, long j2, long j3, long j4);

    public static native long ffi_prep_closure(long j, ffi_callback ffi_callback2);

    public static native void ffi_free_closure(long j);

    static native int initialize_ffi_type(long j);

    /* access modifiers changed from: package-private */
    public static native synchronized void freeNativeCallback(long j);

    /* access modifiers changed from: package-private */
    public static native synchronized long createNativeCallback(Callback callback, Method method, Class<?>[] clsArr, Class<?> cls, int i, int i2, String str);

    /* access modifiers changed from: package-private */
    public static native int invokeInt(Function function, long j, int i, Object[] objArr);

    /* access modifiers changed from: package-private */
    public static native long invokeLong(Function function, long j, int i, Object[] objArr);

    /* access modifiers changed from: package-private */
    public static native void invokeVoid(Function function, long j, int i, Object[] objArr);

    /* access modifiers changed from: package-private */
    public static native float invokeFloat(Function function, long j, int i, Object[] objArr);

    /* access modifiers changed from: package-private */
    public static native double invokeDouble(Function function, long j, int i, Object[] objArr);

    /* access modifiers changed from: package-private */
    public static native long invokePointer(Function function, long j, int i, Object[] objArr);

    private static native void invokeStructure(Function function, long j, int i, Object[] objArr, long j2, long j3);

    /* access modifiers changed from: package-private */
    public static native Object invokeObject(Function function, long j, int i, Object[] objArr);

    /* access modifiers changed from: package-private */
    public static native long open(String str, int i);

    /* access modifiers changed from: package-private */
    public static native void close(long j);

    /* access modifiers changed from: package-private */
    public static native long findSymbol(long j, String str);

    /* access modifiers changed from: package-private */
    public static native long indexOf(Pointer pointer, long j, long j2, byte b);

    /* access modifiers changed from: package-private */
    public static native void read(Pointer pointer, long j, long j2, byte[] bArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void read(Pointer pointer, long j, long j2, short[] sArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void read(Pointer pointer, long j, long j2, char[] cArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void read(Pointer pointer, long j, long j2, int[] iArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void read(Pointer pointer, long j, long j2, long[] jArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void read(Pointer pointer, long j, long j2, float[] fArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void read(Pointer pointer, long j, long j2, double[] dArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void write(Pointer pointer, long j, long j2, byte[] bArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void write(Pointer pointer, long j, long j2, short[] sArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void write(Pointer pointer, long j, long j2, char[] cArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void write(Pointer pointer, long j, long j2, int[] iArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void write(Pointer pointer, long j, long j2, long[] jArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void write(Pointer pointer, long j, long j2, float[] fArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native void write(Pointer pointer, long j, long j2, double[] dArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public static native byte getByte(Pointer pointer, long j, long j2);

    /* access modifiers changed from: package-private */
    public static native char getChar(Pointer pointer, long j, long j2);

    /* access modifiers changed from: package-private */
    public static native short getShort(Pointer pointer, long j, long j2);

    /* access modifiers changed from: package-private */
    public static native int getInt(Pointer pointer, long j, long j2);

    /* access modifiers changed from: package-private */
    public static native long getLong(Pointer pointer, long j, long j2);

    /* access modifiers changed from: package-private */
    public static native float getFloat(Pointer pointer, long j, long j2);

    /* access modifiers changed from: package-private */
    public static native double getDouble(Pointer pointer, long j, long j2);

    private static native long _getPointer(long j);

    /* access modifiers changed from: package-private */
    public static native String getWideString(Pointer pointer, long j, long j2);

    static native byte[] getStringBytes(Pointer pointer, long j, long j2);

    /* access modifiers changed from: package-private */
    public static native void setMemory(Pointer pointer, long j, long j2, long j3, byte b);

    /* access modifiers changed from: package-private */
    public static native void setByte(Pointer pointer, long j, long j2, byte b);

    /* access modifiers changed from: package-private */
    public static native void setShort(Pointer pointer, long j, long j2, short s);

    /* access modifiers changed from: package-private */
    public static native void setChar(Pointer pointer, long j, long j2, char c);

    /* access modifiers changed from: package-private */
    public static native void setInt(Pointer pointer, long j, long j2, int i);

    /* access modifiers changed from: package-private */
    public static native void setLong(Pointer pointer, long j, long j2, long j3);

    /* access modifiers changed from: package-private */
    public static native void setFloat(Pointer pointer, long j, long j2, float f);

    /* access modifiers changed from: package-private */
    public static native void setDouble(Pointer pointer, long j, long j2, double d);

    /* access modifiers changed from: package-private */
    public static native void setPointer(Pointer pointer, long j, long j2, long j3);

    /* access modifiers changed from: package-private */
    public static native void setWideString(Pointer pointer, long j, long j2, String str);

    /* access modifiers changed from: package-private */
    public static native ByteBuffer getDirectByteBuffer(Pointer pointer, long j, long j2, long j3);

    public static native long malloc(long j);

    public static native void free(long j);

    private static native void setDetachState(boolean z, long j);

    static {
        String nativeEncoding = System.getProperty("native.encoding");
        Charset nativeCharset = null;
        if (nativeEncoding != null) {
            try {
                nativeCharset = Charset.forName(nativeEncoding);
            } catch (Exception ex) {
                LOG.log(Level.WARNING, "Failed to get charset for native.encoding value : '" + nativeEncoding + "'", (Throwable) ex);
            }
        }
        if (nativeCharset == null) {
            nativeCharset = Charset.defaultCharset();
        }
        DEFAULT_CHARSET = nativeCharset;
        DEFAULT_ENCODING = nativeCharset.name();
        DEBUG_LOAD = Boolean.getBoolean("jna.debug_load");
        DEBUG_JNA_LOAD = Boolean.getBoolean("jna.debug_load.jna");
        DEBUG_JNA_LOAD_LEVEL = DEBUG_JNA_LOAD ? Level.INFO : Level.FINE;
        jnidispatchPath = null;
        typeOptions = Collections.synchronizedMap(new WeakHashMap());
        libraries = Collections.synchronizedMap(new WeakHashMap());
        DEFAULT_HANDLER = new Callback.UncaughtExceptionHandler() { // from class: com.sun.jna.Native.1
            @Override // com.sun.jna.Callback.UncaughtExceptionHandler
            public void uncaughtException(Callback c, Throwable e) {
                Native.LOG.log(Level.WARNING, "JNA: Callback " + c + " threw the following exception", e);
            }
        };
        callbackExceptionHandler = DEFAULT_HANDLER;
        loadNativeDispatchLibrary();
        if (!isCompatibleVersion(Version.VERSION_NATIVE, getNativeVersion())) {
            String LS = System.getProperty("line.separator");
            throw new Error(LS + LS + "There is an incompatible JNA native library installed on this system" + LS + "Expected: " + Version.VERSION_NATIVE + LS + "Found:    " + getNativeVersion() + LS + (jnidispatchPath != null ? "(at " + jnidispatchPath + ")" : System.getProperty("java.library.path")) + Mapper.IGNORED_FIELDNAME + LS + "To resolve this issue you may do one of the following:" + LS + " - remove or uninstall the offending library" + LS + " - set the system property jna.nosys=true" + LS + " - set jna.boot.library.path to include the path to the version of the " + LS + "   jnidispatch library included with the JNA jar file you are using" + LS);
        }
        POINTER_SIZE = sizeof(0);
        LONG_SIZE = sizeof(1);
        WCHAR_SIZE = sizeof(2);
        SIZE_T_SIZE = sizeof(3);
        BOOL_SIZE = sizeof(4);
        LONG_DOUBLE_SIZE = sizeof(5);
        initIDs();
        if (Boolean.getBoolean("jna.protected")) {
            setProtected(true);
        }
        MAX_ALIGNMENT = (Platform.isSPARC() || Platform.isWindows() || (Platform.isLinux() && (Platform.isARM() || Platform.isPPC() || Platform.isMIPS())) || Platform.isAIX() || (Platform.isAndroid() && !Platform.isIntel())) ? 8 : LONG_SIZE;
        MAX_PADDING = (!Platform.isMac() || !Platform.isPPC()) ? MAX_ALIGNMENT : 8;
        System.setProperty("jna.loaded", C3P0Substitutions.DEBUG);
        finalizer = new Object() { // from class: com.sun.jna.Native.2
            protected void finalize() throws Throwable {
                Native.dispose();
                finalize();
            }
        };
        registeredClasses = new WeakHashMap();
        registeredLibraries = new WeakHashMap();
        nativeThreadTerminationFlag = new ThreadLocal<Memory>() { // from class: com.sun.jna.Native.7
            /* access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public Memory initialValue() {
                Memory m = new Memory(4);
                m.clear();
                return m;
            }
        };
        nativeThreads = Collections.synchronizedMap(new WeakHashMap());
    }

    static boolean isCompatibleVersion(String expectedVersion, String nativeVersion) {
        String[] expectedVersionParts = expectedVersion.split("\\.");
        String[] nativeVersionParts = nativeVersion.split("\\.");
        if (expectedVersionParts.length < 3 || nativeVersionParts.length < 3) {
            return false;
        }
        int expectedMajor = Integer.parseInt(expectedVersionParts[0]);
        int nativeMajor = Integer.parseInt(nativeVersionParts[0]);
        int expectedMinor = Integer.parseInt(expectedVersionParts[1]);
        int nativeMinor = Integer.parseInt(nativeVersionParts[1]);
        if (expectedMajor == nativeMajor && expectedMinor <= nativeMinor) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static void dispose() {
        CallbackReference.disposeAll();
        Memory.disposeAll();
        NativeLibrary.disposeAll();
        unregisterAll();
        jnidispatchPath = null;
        System.setProperty("jna.loaded", "false");
    }

    /* access modifiers changed from: package-private */
    public static boolean deleteLibrary(File lib) {
        if (lib.delete()) {
            return true;
        }
        markTemporaryFile(lib);
        return false;
    }

    private Native() {
    }

    public static long getWindowID(Window w) throws HeadlessException {
        return AWT.getWindowID(w);
    }

    public static long getComponentID(Component c) throws HeadlessException {
        return AWT.getComponentID(c);
    }

    public static Pointer getWindowPointer(Window w) throws HeadlessException {
        return new Pointer(AWT.getWindowID(w));
    }

    public static Pointer getComponentPointer(Component c) throws HeadlessException {
        return new Pointer(AWT.getComponentID(c));
    }

    public static Pointer getDirectBufferPointer(Buffer b) {
        long peer = _getDirectBufferPointer(b);
        if (peer == 0) {
            return null;
        }
        return new Pointer(peer);
    }

    private static Charset getCharset(String encoding) {
        Charset charset = null;
        if (encoding != null) {
            try {
                charset = Charset.forName(encoding);
            } catch (IllegalCharsetNameException e) {
                LOG.log(Level.WARNING, "JNA Warning: Encoding ''{0}'' is unsupported ({1})", new Object[]{encoding, e.getMessage()});
            } catch (UnsupportedCharsetException e2) {
                LOG.log(Level.WARNING, "JNA Warning: Encoding ''{0}'' is unsupported ({1})", new Object[]{encoding, e2.getMessage()});
            }
        }
        if (charset == null) {
            LOG.log(Level.WARNING, "JNA Warning: Using fallback encoding {0}", DEFAULT_CHARSET);
            charset = DEFAULT_CHARSET;
        }
        return charset;
    }

    public static String toString(byte[] buf) {
        return toString(buf, getDefaultStringEncoding());
    }

    public static String toString(byte[] buf, String encoding) {
        return toString(buf, getCharset(encoding));
    }

    public static String toString(byte[] buf, Charset charset) {
        int len = buf.length;
        int index = 0;
        while (true) {
            if (index >= len) {
                break;
            } else if (buf[index] == 0) {
                len = index;
                break;
            } else {
                index++;
            }
        }
        if (len == 0) {
            return "";
        }
        return new String(buf, 0, len, charset);
    }

    public static String toString(char[] buf) {
        int len = buf.length;
        int index = 0;
        while (true) {
            if (index >= len) {
                break;
            } else if (buf[index] == 0) {
                len = index;
                break;
            } else {
                index++;
            }
        }
        if (len == 0) {
            return "";
        }
        return new String(buf, 0, len);
    }

    public static List<String> toStringList(char[] buf) {
        return toStringList(buf, 0, buf.length);
    }

    public static List<String> toStringList(char[] buf, int offset, int len) {
        List<String> list = new ArrayList<>();
        int lastPos = offset;
        int maxPos = offset + len;
        for (int curPos = offset; curPos < maxPos; curPos++) {
            if (buf[curPos] == 0) {
                if (lastPos == curPos) {
                    return list;
                }
                list.add(new String(buf, lastPos, curPos - lastPos));
                lastPos = curPos + 1;
            }
        }
        if (lastPos < maxPos) {
            list.add(new String(buf, lastPos, maxPos - lastPos));
        }
        return list;
    }

    public static <T extends Library> T load(Class<T> interfaceClass) {
        return (T) load((String) null, interfaceClass);
    }

    public static <T extends Library> T load(Class<T> interfaceClass, Map<String, ?> options) {
        return (T) load(null, interfaceClass, options);
    }

    public static <T extends Library> T load(String name, Class<T> interfaceClass) {
        return (T) load(name, interfaceClass, Collections.emptyMap());
    }

    public static <T extends Library> T load(String name, Class<T> interfaceClass, Map<String, ?> options) {
        if (!Library.class.isAssignableFrom(interfaceClass)) {
            throw new IllegalArgumentException("Interface (" + interfaceClass.getSimpleName() + ") of library=" + name + " does not extend " + Library.class.getSimpleName());
        }
        Object proxy = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new Library.Handler(name, interfaceClass, options));
        cacheOptions(interfaceClass, options, proxy);
        return interfaceClass.cast(proxy);
    }

    @Deprecated
    public static <T> T loadLibrary(Class<T> interfaceClass) {
        return (T) loadLibrary((String) null, interfaceClass);
    }

    @Deprecated
    public static <T> T loadLibrary(Class<T> interfaceClass, Map<String, ?> options) {
        return (T) loadLibrary(null, interfaceClass, options);
    }

    @Deprecated
    public static <T> T loadLibrary(String name, Class<T> interfaceClass) {
        return (T) loadLibrary(name, interfaceClass, Collections.emptyMap());
    }

    @Deprecated
    public static <T> T loadLibrary(String name, Class<T> interfaceClass, Map<String, ?> options) {
        if (!Library.class.isAssignableFrom(interfaceClass)) {
            throw new IllegalArgumentException("Interface (" + interfaceClass.getSimpleName() + ") of library=" + name + " does not extend " + Library.class.getSimpleName());
        }
        Object proxy = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new Library.Handler(name, interfaceClass, options));
        cacheOptions(interfaceClass, options, proxy);
        return interfaceClass.cast(proxy);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        r0.setAccessible(true);
        com.sun.jna.Native.libraries.put(r7, new java.lang.ref.WeakReference(r0.get(null)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void loadLibraryInstance(java.lang.Class<?> r7) {
        /*
            r0 = r7
            if (r0 == 0) goto L_0x0084
            java.util.Map<java.lang.Class<?>, java.lang.ref.Reference<?>> r0 = com.sun.jna.Native.libraries
            r1 = r7
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x0084
            r0 = r7
            java.lang.reflect.Field[] r0 = r0.getFields()     // Catch: Exception -> 0x005a
            r8 = r0
            r0 = 0
            r9 = r0
        L_0x0017:
            r0 = r9
            r1 = r8
            int r1 = r1.length     // Catch: Exception -> 0x005a
            if (r0 >= r1) goto L_0x0057
            r0 = r8
            r1 = r9
            r0 = r0[r1]     // Catch: Exception -> 0x005a
            r10 = r0
            r0 = r10
            java.lang.Class r0 = r0.getType()     // Catch: Exception -> 0x005a
            r1 = r7
            if (r0 != r1) goto L_0x0051
            r0 = r10
            int r0 = r0.getModifiers()     // Catch: Exception -> 0x005a
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)     // Catch: Exception -> 0x005a
            if (r0 == 0) goto L_0x0051
            r0 = r10
            r1 = 1
            r0.setAccessible(r1)     // Catch: Exception -> 0x005a
            java.util.Map<java.lang.Class<?>, java.lang.ref.Reference<?>> r0 = com.sun.jna.Native.libraries     // Catch: Exception -> 0x005a
            r1 = r7
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch: Exception -> 0x005a
            r3 = r2
            r4 = r10
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: Exception -> 0x005a
            r3.<init>(r4)     // Catch: Exception -> 0x005a
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: Exception -> 0x005a
            goto L_0x0057
        L_0x0051:
            int r9 = r9 + 1
            goto L_0x0017
        L_0x0057:
            goto L_0x0084
        L_0x005a:
            r8 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Could not access instance of "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r8
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.Native.loadLibraryInstance(java.lang.Class):void");
    }

    static Class<?> findEnclosingLibraryClass(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Map<String, ?> libOptions = typeOptions.get(cls);
        if (libOptions != null) {
            Class<?> enclosingClass = (Class) libOptions.get(_OPTION_ENCLOSING_LIBRARY);
            if (enclosingClass != null) {
                return enclosingClass;
            }
            return cls;
        } else if (Library.class.isAssignableFrom(cls)) {
            return cls;
        } else {
            if (Callback.class.isAssignableFrom(cls)) {
                cls = CallbackReference.findCallbackClass(cls);
            }
            Class<?> fromDeclaring = findEnclosingLibraryClass(cls.getDeclaringClass());
            if (fromDeclaring != null) {
                return fromDeclaring;
            }
            return findEnclosingLibraryClass(cls.getSuperclass());
        }
    }

    public static Map<String, Object> getLibraryOptions(Class<?> type) {
        Map<String, Object> libraryOptions;
        Map<String, Object> libraryOptions2 = typeOptions.get(type);
        if (libraryOptions2 != null) {
            return libraryOptions2;
        }
        Class<?> mappingClass = findEnclosingLibraryClass(type);
        if (mappingClass != null) {
            loadLibraryInstance(mappingClass);
        } else {
            mappingClass = type;
        }
        Map<String, Object> libraryOptions3 = typeOptions.get(mappingClass);
        if (libraryOptions3 != null) {
            typeOptions.put(type, libraryOptions3);
            return libraryOptions3;
        }
        try {
            Field field = mappingClass.getField("OPTIONS");
            field.setAccessible(true);
            libraryOptions = (Map) field.get(null);
        } catch (NoSuchFieldException e) {
            libraryOptions = Collections.emptyMap();
        } catch (Exception e2) {
            throw new IllegalArgumentException("OPTIONS must be a public field of type java.util.Map (" + e2 + "): " + mappingClass);
        }
        if (libraryOptions == null) {
            throw new IllegalStateException("Null options field");
        }
        Map<String, Object> libraryOptions4 = new HashMap<>(libraryOptions);
        if (!libraryOptions4.containsKey(Library.OPTION_TYPE_MAPPER)) {
            libraryOptions4.put(Library.OPTION_TYPE_MAPPER, lookupField(mappingClass, "TYPE_MAPPER", TypeMapper.class));
        }
        if (!libraryOptions4.containsKey(Library.OPTION_STRUCTURE_ALIGNMENT)) {
            libraryOptions4.put(Library.OPTION_STRUCTURE_ALIGNMENT, lookupField(mappingClass, "STRUCTURE_ALIGNMENT", Integer.class));
        }
        if (!libraryOptions4.containsKey(Library.OPTION_STRING_ENCODING)) {
            libraryOptions4.put(Library.OPTION_STRING_ENCODING, lookupField(mappingClass, "STRING_ENCODING", String.class));
        }
        Map<String, Object> libraryOptions5 = cacheOptions(mappingClass, libraryOptions4, null);
        if (type != mappingClass) {
            typeOptions.put(type, libraryOptions5);
        }
        return libraryOptions5;
    }

    private static Object lookupField(Class<?> mappingClass, String fieldName, Class<?> resultClass) {
        try {
            Field field = mappingClass.getField(fieldName);
            field.setAccessible(true);
            return field.get(null);
        } catch (NoSuchFieldException e) {
            return null;
        } catch (Exception e2) {
            throw new IllegalArgumentException(fieldName + " must be a public field of type " + resultClass.getName() + " (" + e2 + "): " + mappingClass);
        }
    }

    public static TypeMapper getTypeMapper(Class<?> cls) {
        return (TypeMapper) getLibraryOptions(cls).get(Library.OPTION_TYPE_MAPPER);
    }

    public static String getStringEncoding(Class<?> cls) {
        String encoding = (String) getLibraryOptions(cls).get(Library.OPTION_STRING_ENCODING);
        return encoding != null ? encoding : getDefaultStringEncoding();
    }

    public static String getDefaultStringEncoding() {
        return System.getProperty("jna.encoding", DEFAULT_ENCODING);
    }

    public static int getStructureAlignment(Class<?> cls) {
        Integer alignment = (Integer) getLibraryOptions(cls).get(Library.OPTION_STRUCTURE_ALIGNMENT);
        if (alignment == null) {
            return 0;
        }
        return alignment.intValue();
    }

    static byte[] getBytes(String s) {
        return getBytes(s, getDefaultStringEncoding());
    }

    /* access modifiers changed from: package-private */
    public static byte[] getBytes(String s, String encoding) {
        return getBytes(s, getCharset(encoding));
    }

    static byte[] getBytes(String s, Charset charset) {
        return s.getBytes(charset);
    }

    public static byte[] toByteArray(String s) {
        return toByteArray(s, getDefaultStringEncoding());
    }

    public static byte[] toByteArray(String s, String encoding) {
        return toByteArray(s, getCharset(encoding));
    }

    public static byte[] toByteArray(String s, Charset charset) {
        byte[] bytes = getBytes(s, charset);
        byte[] buf = new byte[bytes.length + 1];
        System.arraycopy(bytes, 0, buf, 0, bytes.length);
        return buf;
    }

    public static char[] toCharArray(String s) {
        char[] chars = s.toCharArray();
        char[] buf = new char[chars.length + 1];
        System.arraycopy(chars, 0, buf, 0, chars.length);
        return buf;
    }

    private static void loadNativeDispatchLibrary() {
        String ext;
        String orig;
        if (!Boolean.getBoolean("jna.nounpack")) {
            try {
                removeTemporaryFiles();
            } catch (IOException e) {
                LOG.log(Level.WARNING, "JNA Warning: IOException removing temporary files", (Throwable) e);
            }
        }
        String libName = System.getProperty("jna.boot.library.name", "jnidispatch");
        String bootPath = System.getProperty("jna.boot.library.path");
        if (bootPath != null) {
            StringTokenizer dirs = new StringTokenizer(bootPath, File.pathSeparator);
            while (dirs.hasMoreTokens()) {
                File file = new File(new File(dirs.nextToken()), System.mapLibraryName(libName).replace(".dylib", ".jnilib"));
                String path = file.getAbsolutePath();
                LOG.log(DEBUG_JNA_LOAD_LEVEL, "Looking in {0}", path);
                if (file.exists()) {
                    try {
                        LOG.log(DEBUG_JNA_LOAD_LEVEL, "Trying {0}", path);
                        System.setProperty("jnidispatch.path", path);
                        System.load(path);
                        jnidispatchPath = path;
                        LOG.log(DEBUG_JNA_LOAD_LEVEL, "Found jnidispatch at {0}", path);
                        return;
                    } catch (UnsatisfiedLinkError e2) {
                    }
                }
                if (Platform.isMac()) {
                    if (path.endsWith("dylib")) {
                        orig = "dylib";
                        ext = "jnilib";
                    } else {
                        orig = "jnilib";
                        ext = "dylib";
                    }
                    String path2 = path.substring(0, path.lastIndexOf(orig)) + ext;
                    LOG.log(DEBUG_JNA_LOAD_LEVEL, "Looking in {0}", path2);
                    if (new File(path2).exists()) {
                        try {
                            LOG.log(DEBUG_JNA_LOAD_LEVEL, "Trying {0}", path2);
                            System.setProperty("jnidispatch.path", path2);
                            System.load(path2);
                            jnidispatchPath = path2;
                            LOG.log(DEBUG_JNA_LOAD_LEVEL, "Found jnidispatch at {0}", path2);
                            return;
                        } catch (UnsatisfiedLinkError ex) {
                            LOG.log(Level.WARNING, "File found at " + path2 + " but not loadable: " + ex.getMessage(), (Throwable) ex);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (!Boolean.parseBoolean(System.getProperty("jna.nosys", C3P0Substitutions.DEBUG)) || Platform.isAndroid()) {
            try {
                LOG.log(DEBUG_JNA_LOAD_LEVEL, "Trying (via loadLibrary) {0}", libName);
                System.loadLibrary(libName);
                LOG.log(DEBUG_JNA_LOAD_LEVEL, "Found jnidispatch on system path");
                return;
            } catch (UnsatisfiedLinkError e3) {
            }
        }
        if (!Boolean.getBoolean("jna.noclasspath")) {
            loadNativeDispatchLibraryFromClasspath();
            return;
        }
        throw new UnsatisfiedLinkError("Unable to locate JNA native support library");
    }

    private static void loadNativeDispatchLibraryFromClasspath() {
        try {
            String mappedName = System.mapLibraryName("jnidispatch").replace(".dylib", ".jnilib");
            if (Platform.isAIX()) {
                mappedName = "libjnidispatch.a";
            }
            File lib = extractFromResourcePath("/com/sun/jna/" + Platform.RESOURCE_PREFIX + "/" + mappedName, Native.class.getClassLoader());
            if (lib == null && lib == null) {
                throw new UnsatisfiedLinkError("Could not find JNA native support");
            }
            LOG.log(DEBUG_JNA_LOAD_LEVEL, "Trying {0}", lib.getAbsolutePath());
            System.setProperty("jnidispatch.path", lib.getAbsolutePath());
            System.load(lib.getAbsolutePath());
            jnidispatchPath = lib.getAbsolutePath();
            LOG.log(DEBUG_JNA_LOAD_LEVEL, "Found jnidispatch at {0}", jnidispatchPath);
            if (isUnpacked(lib) && !Boolean.getBoolean("jnidispatch.preserve")) {
                deleteLibrary(lib);
            }
        } catch (IOException e) {
            throw new UnsatisfiedLinkError(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean isUnpacked(File file) {
        return file.getName().startsWith(JNA_TMPLIB_PREFIX);
    }

    public static File extractFromResourcePath(String name) throws IOException {
        return extractFromResourcePath(name, null);
    }

    public static File extractFromResourcePath(String name, ClassLoader loader) throws IOException {
        Level DEBUG = (DEBUG_LOAD || (DEBUG_JNA_LOAD && name.contains("jnidispatch"))) ? Level.INFO : Level.FINE;
        if (loader == null) {
            loader = Thread.currentThread().getContextClassLoader();
            if (loader == null) {
                loader = Native.class.getClassLoader();
            }
        }
        LOG.log(DEBUG, "Looking in classpath from {0} for {1}", new Object[]{loader, name});
        String libname = name.startsWith("/") ? name : NativeLibrary.mapSharedLibraryName(name);
        String resourcePath = name.startsWith("/") ? name : Platform.RESOURCE_PREFIX + "/" + libname;
        if (resourcePath.startsWith("/")) {
            resourcePath = resourcePath.substring(1);
        }
        URL url = loader.getResource(resourcePath);
        if (url == null) {
            if (resourcePath.startsWith(Platform.RESOURCE_PREFIX)) {
                if (Platform.RESOURCE_PREFIX.startsWith("darwin")) {
                    url = loader.getResource("darwin/" + resourcePath.substring(Platform.RESOURCE_PREFIX.length() + 1));
                }
                if (url == null) {
                    url = loader.getResource(libname);
                }
            } else if (resourcePath.startsWith("com/sun/jna/" + Platform.RESOURCE_PREFIX + "/")) {
                if (Platform.RESOURCE_PREFIX.startsWith("com/sun/jna/darwin")) {
                    url = loader.getResource("com/sun/jna/darwin" + resourcePath.substring(("com/sun/jna/" + Platform.RESOURCE_PREFIX).length() + 1));
                }
                if (url == null) {
                    url = loader.getResource(libname);
                }
            }
        }
        if (url == null) {
            String path = System.getProperty("java.class.path");
            if (loader instanceof URLClassLoader) {
                path = Arrays.asList(((URLClassLoader) loader).getURLs()).toString();
            }
            throw new IOException("Native library (" + resourcePath + ") not found in resource path (" + path + ")");
        }
        LOG.log(DEBUG, "Found library resource at {0}", url);
        File lib = null;
        if (url.getProtocol().toLowerCase().equals(Action.FILE_ATTRIBUTE)) {
            try {
                lib = new File(new URI(url.toString()));
            } catch (URISyntaxException e) {
                lib = new File(url.getPath());
            }
            LOG.log(DEBUG, "Looking in {0}", lib.getAbsolutePath());
            if (!lib.exists()) {
                throw new IOException("File URL " + url + " could not be properly decoded");
            }
        } else if (!Boolean.getBoolean("jna.nounpack")) {
            InputStream is = url.openStream();
            if (is == null) {
                throw new IOException("Can't obtain InputStream for " + resourcePath);
            }
            FileOutputStream fos = null;
            try {
                try {
                    lib = File.createTempFile(JNA_TMPLIB_PREFIX, Platform.isWindows() ? ".dll" : null, getTempDir());
                    if (!Boolean.getBoolean("jnidispatch.preserve")) {
                        lib.deleteOnExit();
                    }
                    LOG.log(DEBUG, "Extracting library to {0}", lib.getAbsolutePath());
                    fos = new FileOutputStream(lib);
                    byte[] buf = new byte[1024];
                    while (true) {
                        int count = is.read(buf, 0, buf.length);
                        if (count <= 0) {
                            break;
                        }
                        fos.write(buf, 0, count);
                    }
                } catch (IOException e2) {
                    throw new IOException("Failed to create temporary file for " + name + " library: " + e2.getMessage());
                }
            } finally {
                try {
                    is.close();
                } catch (IOException e3) {
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e4) {
                    }
                }
            }
        }
        return lib;
    }

    public static Library synchronizedLibrary(final Library library) {
        Class<?> cls = library.getClass();
        if (!Proxy.isProxyClass(cls)) {
            throw new IllegalArgumentException("Library must be a proxy class");
        }
        InvocationHandler ih = Proxy.getInvocationHandler(library);
        if (!(ih instanceof Library.Handler)) {
            throw new IllegalArgumentException("Unrecognized proxy handler: " + ih);
        }
        final Library.Handler handler = (Library.Handler) ih;
        return (Library) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new InvocationHandler() { // from class: com.sun.jna.Native.3
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke;
                synchronized (handler.getNativeLibrary()) {
                    invoke = handler.invoke(library, method, args);
                }
                return invoke;
            }
        });
    }

    public static String getWebStartLibraryPath(String libName) {
        if (System.getProperty("javawebstart.version") == null) {
            return null;
        }
        try {
            String libpath = (String) ((Method) AccessController.doPrivileged(new PrivilegedAction<Method>() { // from class: com.sun.jna.Native.4
                @Override // java.security.PrivilegedAction
                public Method run() {
                    try {
                        Method m = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
                        m.setAccessible(true);
                        return m;
                    } catch (Exception e) {
                        return null;
                    }
                }
            })).invoke(Native.class.getClassLoader(), libName);
            if (libpath != null) {
                return new File(libpath).getParent();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    static void markTemporaryFile(File file) {
        try {
            new File(file.getParentFile(), file.getName() + ".x").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static File getTempDir() throws IOException {
        File jnatmp;
        File xdgCacheFile;
        String prop = System.getProperty("jna.tmpdir");
        if (prop != null) {
            jnatmp = new File(prop);
            jnatmp.mkdirs();
        } else {
            File tmp = new File(System.getProperty("java.io.tmpdir"));
            if (Platform.isMac()) {
                jnatmp = new File(System.getProperty("user.home"), "Library/Caches/JNA/temp");
            } else if (Platform.isLinux() || Platform.isSolaris() || Platform.isAIX() || Platform.isFreeBSD() || Platform.isNetBSD() || Platform.isOpenBSD() || Platform.iskFreeBSD()) {
                String xdgCacheEnvironment = System.getenv("XDG_CACHE_HOME");
                if (xdgCacheEnvironment == null || xdgCacheEnvironment.trim().isEmpty()) {
                    xdgCacheFile = new File(System.getProperty("user.home"), ".cache");
                } else {
                    xdgCacheFile = new File(xdgCacheEnvironment);
                }
                jnatmp = new File(xdgCacheFile, "JNA/temp");
            } else {
                jnatmp = new File(tmp, "jna-" + System.getProperty("user.name").hashCode());
            }
            jnatmp.mkdirs();
            if (!jnatmp.exists() || !jnatmp.canWrite()) {
                jnatmp = tmp;
            }
        }
        if (!jnatmp.exists()) {
            throw new IOException("JNA temporary directory '" + jnatmp + "' does not exist");
        } else if (jnatmp.canWrite()) {
            return jnatmp;
        } else {
            throw new IOException("JNA temporary directory '" + jnatmp + "' is not writable");
        }
    }

    static void removeTemporaryFiles() throws IOException {
        File[] files = getTempDir().listFiles(new FilenameFilter() { // from class: com.sun.jna.Native.5
            @Override // java.io.FilenameFilter
            public boolean accept(File dir, String name) {
                return name.endsWith(".x") && name.startsWith(Native.JNA_TMPLIB_PREFIX);
            }
        });
        int i = 0;
        while (files != null && i < files.length) {
            File marker = files[i];
            String name = marker.getName();
            File target = new File(marker.getParentFile(), name.substring(0, name.length() - 2));
            if (!target.exists() || target.delete()) {
                marker.delete();
            }
            i++;
        }
    }

    public static int getNativeSize(Class<?> type, Object value) {
        if (type.isArray()) {
            int len = Array.getLength(value);
            if (len > 0) {
                return len * getNativeSize(type.getComponentType(), Array.get(value, 0));
            }
            throw new IllegalArgumentException("Arrays of length zero not allowed: " + type);
        } else if (Structure.class.isAssignableFrom(type) && !Structure.ByReference.class.isAssignableFrom(type)) {
            return Structure.size(type, (Structure) value);
        } else {
            try {
                return getNativeSize(type);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("The type \"" + type.getName() + "\" is not supported: " + e.getMessage());
            }
        }
    }

    public static int getNativeSize(Class<?> cls) {
        if (NativeMapped.class.isAssignableFrom(cls)) {
            cls = NativeMappedConverter.getInstance(cls).nativeType();
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return 4;
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return 1;
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return 2;
        }
        if (cls == Character.TYPE || cls == Character.class) {
            return WCHAR_SIZE;
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return 4;
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return 8;
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return 4;
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return 8;
        }
        if (Structure.class.isAssignableFrom(cls)) {
            if (Structure.ByValue.class.isAssignableFrom(cls)) {
                return Structure.size(cls);
            }
            return POINTER_SIZE;
        } else if (Pointer.class.isAssignableFrom(cls) || ((Platform.HAS_BUFFERS && Buffers.isBuffer(cls)) || Callback.class.isAssignableFrom(cls) || String.class == cls || WString.class == cls)) {
            return POINTER_SIZE;
        } else {
            throw new IllegalArgumentException("Native size for type \"" + cls.getName() + "\" is unknown");
        }
    }

    public static boolean isSupportedNativeType(Class<?> cls) {
        if (Structure.class.isAssignableFrom(cls)) {
            return true;
        }
        try {
            return getNativeSize(cls) != 0;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static void setCallbackExceptionHandler(Callback.UncaughtExceptionHandler eh) {
        callbackExceptionHandler = eh == null ? DEFAULT_HANDLER : eh;
    }

    public static Callback.UncaughtExceptionHandler getCallbackExceptionHandler() {
        return callbackExceptionHandler;
    }

    public static void register(String libName) {
        register(findDirectMappedClass(getCallingClass()), libName);
    }

    public static void register(NativeLibrary lib) {
        register(findDirectMappedClass(getCallingClass()), lib);
    }

    static Class<?> findDirectMappedClass(Class<?> cls) {
        for (Method m : cls.getDeclaredMethods()) {
            if ((m.getModifiers() & 256) != 0) {
                return cls;
            }
        }
        int idx = cls.getName().lastIndexOf("$");
        if (idx != -1) {
            try {
                return findDirectMappedClass(Class.forName(cls.getName().substring(0, idx), true, cls.getClassLoader()));
            } catch (ClassNotFoundException e) {
            }
        }
        throw new IllegalArgumentException("Can't determine class with native methods from the current context (" + cls + ")");
    }

    static Class<?> getCallingClass() {
        Class<?>[] context = new SecurityManager() { // from class: com.sun.jna.Native.6
            @Override // java.lang.SecurityManager
            public Class<?>[] getClassContext() {
                return getClassContext();
            }
        }.getClassContext();
        if (context == null) {
            throw new IllegalStateException("The SecurityManager implementation on this platform is broken; you must explicitly provide the class to register");
        } else if (context.length >= 4) {
            return context[3];
        } else {
            throw new IllegalStateException("This method must be called from the static initializer of a class");
        }
    }

    public static void setCallbackThreadInitializer(Callback cb, CallbackThreadInitializer initializer) {
        CallbackReference.setCallbackThreadInitializer(cb, initializer);
    }

    private static void unregisterAll() {
        synchronized (registeredClasses) {
            for (Map.Entry<Class<?>, long[]> e : registeredClasses.entrySet()) {
                unregister(e.getKey(), e.getValue());
            }
            registeredClasses.clear();
        }
    }

    public static void unregister() {
        unregister(findDirectMappedClass(getCallingClass()));
    }

    public static void unregister(Class<?> cls) {
        synchronized (registeredClasses) {
            long[] handles = registeredClasses.get(cls);
            if (handles != null) {
                unregister(cls, handles);
                registeredClasses.remove(cls);
                registeredLibraries.remove(cls);
            }
        }
    }

    public static boolean registered(Class<?> cls) {
        boolean containsKey;
        synchronized (registeredClasses) {
            containsKey = registeredClasses.containsKey(cls);
        }
        return containsKey;
    }

    static String getSignature(Class<?> cls) {
        if (cls.isArray()) {
            return "[" + getSignature(cls.getComponentType());
        }
        if (cls.isPrimitive()) {
            if (cls == Void.TYPE) {
                return "V";
            }
            if (cls == Boolean.TYPE) {
                return "Z";
            }
            if (cls == Byte.TYPE) {
                return "B";
            }
            if (cls == Short.TYPE) {
                return "S";
            }
            if (cls == Character.TYPE) {
                return "C";
            }
            if (cls == Integer.TYPE) {
                return "I";
            }
            if (cls == Long.TYPE) {
                return "J";
            }
            if (cls == Float.TYPE) {
                return "F";
            }
            if (cls == Double.TYPE) {
                return "D";
            }
        }
        return "L" + replace(Mapper.IGNORED_FIELDNAME, "/", cls.getName()) + ";";
    }

    static String replace(String s1, String s2, String str) {
        StringBuilder buf = new StringBuilder();
        while (true) {
            int idx = str.indexOf(s1);
            if (idx == -1) {
                buf.append(str);
                return buf.toString();
            }
            buf.append(str.substring(0, idx));
            buf.append(s2);
            str = str.substring(idx + s1.length());
        }
    }

    private static int getConversion(Class<?> type, TypeMapper mapper, boolean allowObjects) {
        if (type == Void.class) {
            type = Void.TYPE;
        }
        if (mapper != null) {
            FromNativeConverter fromNative = mapper.getFromNativeConverter(type);
            ToNativeConverter toNative = mapper.getToNativeConverter(type);
            if (fromNative != null) {
                Class<?> nativeType = fromNative.nativeType();
                if (nativeType == String.class) {
                    return 24;
                }
                if (nativeType == WString.class) {
                    return 25;
                }
                return 23;
            } else if (toNative != null) {
                Class<?> nativeType2 = toNative.nativeType();
                if (nativeType2 == String.class) {
                    return 24;
                }
                if (nativeType2 == WString.class) {
                    return 25;
                }
                return 23;
            }
        }
        if (Pointer.class.isAssignableFrom(type)) {
            return 1;
        }
        if (String.class == type) {
            return 2;
        }
        if (WString.class.isAssignableFrom(type)) {
            return 20;
        }
        if (Platform.HAS_BUFFERS && Buffers.isBuffer(type)) {
            return 5;
        }
        if (!Structure.class.isAssignableFrom(type)) {
            if (type.isArray()) {
                switch (type.getName().charAt(1)) {
                    case 'B':
                        return 6;
                    case 'C':
                        return 8;
                    case 'D':
                        return 12;
                    case 'F':
                        return 11;
                    case 'I':
                        return 9;
                    case 'J':
                        return 10;
                    case 'S':
                        return 7;
                    case 'Z':
                        return 13;
                }
            }
            if (type.isPrimitive()) {
                return type == Boolean.TYPE ? 14 : 0;
            }
            if (Callback.class.isAssignableFrom(type)) {
                return 15;
            }
            if (IntegerType.class.isAssignableFrom(type)) {
                return 21;
            }
            if (PointerType.class.isAssignableFrom(type)) {
                return 22;
            }
            if (NativeMapped.class.isAssignableFrom(type)) {
                Class<?> nativeType3 = NativeMappedConverter.getInstance(type).nativeType();
                if (nativeType3 == String.class) {
                    return 18;
                }
                if (nativeType3 == WString.class) {
                    return 19;
                }
                return 17;
            } else if (JNIEnv.class == type) {
                return 27;
            } else {
                return allowObjects ? 26 : -1;
            }
        } else if (Structure.ByValue.class.isAssignableFrom(type)) {
            return 4;
        } else {
            return 3;
        }
    }

    public static void register(Class<?> cls, String libName) {
        register(cls, NativeLibrary.getInstance(libName, Collections.singletonMap(Library.OPTION_CLASSLOADER, cls.getClassLoader())));
    }

    private static Map<String, Object> cacheOptions(Class<?> cls, Map<String, ?> options, Object proxy) {
        Map<String, Object> libOptions = new HashMap<>(options);
        libOptions.put(_OPTION_ENCLOSING_LIBRARY, cls);
        typeOptions.put(cls, libOptions);
        if (proxy != null) {
            libraries.put(cls, new WeakReference(proxy));
        }
        if (!cls.isInterface() && Library.class.isAssignableFrom(cls)) {
            Class<?>[] ifaces = cls.getInterfaces();
            int length = ifaces.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Class<?> ifc = ifaces[i];
                if (Library.class.isAssignableFrom(ifc)) {
                    cacheOptions(ifc, libOptions, proxy);
                    break;
                }
                i++;
            }
        }
        return libOptions;
    }

    private static NativeMapped fromNative(Class<?> cls, Object value) {
        return (NativeMapped) NativeMappedConverter.getInstance(cls).fromNative(value, new FromNativeContext(cls));
    }

    private static NativeMapped fromNative(Method m, Object value) {
        Class<?> cls = m.getReturnType();
        return (NativeMapped) NativeMappedConverter.getInstance(cls).fromNative(value, new MethodResultContext(cls, null, null, m));
    }

    private static Class<?> nativeType(Class<?> cls) {
        return NativeMappedConverter.getInstance(cls).nativeType();
    }

    private static Object toNative(ToNativeConverter cvt, Object o) {
        return cvt.toNative(o, new ToNativeContext());
    }

    private static Object fromNative(FromNativeConverter cvt, Object o, Method m) {
        return cvt.fromNative(o, new MethodResultContext(m.getReturnType(), null, null, m));
    }

    public static void main(String[] args) {
        Package pkg = Native.class.getPackage();
        String title = pkg != null ? pkg.getSpecificationTitle() : "Java Native Access (JNA)";
        if (title == null) {
            title = "Java Native Access (JNA)";
        }
        String version = pkg != null ? pkg.getSpecificationVersion() : Version.VERSION;
        if (version == null) {
            version = Version.VERSION;
        }
        System.out.println(title + " API Version " + version);
        String version2 = pkg != null ? pkg.getImplementationVersion() : "5.10.0 (package information missing)";
        if (version2 == null) {
            version2 = "5.10.0 (package information missing)";
        }
        System.out.println("Version: " + version2);
        System.out.println(" Native: " + getNativeVersion() + " (" + getAPIChecksum() + ")");
        System.out.println(" Prefix: " + Platform.RESOURCE_PREFIX);
    }

    /* access modifiers changed from: package-private */
    public static Structure invokeStructure(Function function, long fp, int callFlags, Object[] args, Structure s) {
        invokeStructure(function, fp, callFlags, args, s.getPointer().peer, s.getTypeInfo().peer);
        return s;
    }

    static long open(String name) {
        return open(name, -1);
    }

    /* access modifiers changed from: package-private */
    public static Pointer getPointer(long addr) {
        long peer = _getPointer(addr);
        if (peer == 0) {
            return null;
        }
        return new Pointer(peer);
    }

    static String getString(Pointer pointer, long offset) {
        return getString(pointer, offset, getDefaultStringEncoding());
    }

    /* access modifiers changed from: package-private */
    public static String getString(Pointer pointer, long offset, String encoding) {
        byte[] data = getStringBytes(pointer, pointer.peer, offset);
        if (encoding != null) {
            try {
                return new String(data, encoding);
            } catch (UnsupportedEncodingException e) {
            }
        }
        return new String(data);
    }

    public static void detach(boolean detach) {
        Thread thread = Thread.currentThread();
        if (detach) {
            nativeThreads.remove(thread);
            nativeThreadTerminationFlag.get();
            setDetachState(true, 0);
        } else if (!nativeThreads.containsKey(thread)) {
            Pointer p = nativeThreadTerminationFlag.get();
            nativeThreads.put(thread, p);
            setDetachState(false, p.peer);
        }
    }

    static Pointer getTerminationFlag(Thread t) {
        return nativeThreads.get(t);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/sun/jna/Native$Buffers.class */
    public static class Buffers {
        private Buffers() {
        }

        static boolean isBuffer(Class<?> cls) {
            return Buffer.class.isAssignableFrom(cls);
        }
    }

    /* loaded from: grasscutter.jar:com/sun/jna/Native$AWT.class */
    private static class AWT {
        private AWT() {
        }

        static long getWindowID(Window w) throws HeadlessException {
            return getComponentID(w);
        }

        static long getComponentID(Object o) throws HeadlessException {
            if (GraphicsEnvironment.isHeadless()) {
                throw new HeadlessException("No native windows when headless");
            }
            Component c = (Component) o;
            if (c.isLightweight()) {
                throw new IllegalArgumentException("Component must be heavyweight");
            } else if (!c.isDisplayable()) {
                throw new IllegalStateException("Component must be displayable");
            } else if (!Platform.isX11() || !System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION).startsWith("1.4") || c.isVisible()) {
                return Native.getWindowHandle0(c);
            } else {
                throw new IllegalStateException("Component must be visible");
            }
        }
    }
}
