package p013io.netty.util.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import p013io.netty.util.internal.logging.InternalLogger;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
@SuppressJava6Requirement(reason = "Unsafe access is guarded")
/* renamed from: io.netty.util.internal.PlatformDependent0 */
/* loaded from: grasscutter.jar:io/netty/util/internal/PlatformDependent0.class */
public final class PlatformDependent0 {
    private static final InternalLogger logger;
    private static final long ADDRESS_FIELD_OFFSET;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final Constructor<?> DIRECT_BUFFER_CONSTRUCTOR;
    private static final Throwable EXPLICIT_NO_UNSAFE_CAUSE;
    private static final Method ALLOCATE_ARRAY_METHOD;
    private static final Method ALIGN_SLICE;
    private static final int JAVA_VERSION;
    private static final boolean IS_ANDROID;
    private static final boolean STORE_FENCE_AVAILABLE;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final Object INTERNAL_UNSAFE;
    private static final boolean IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    private static final boolean RUNNING_IN_NATIVE_IMAGE;
    static final Unsafe UNSAFE;
    static final int HASH_CODE_ASCII_SEED = -1028477387;
    static final int HASH_CODE_C1 = -862048943;
    static final int HASH_CODE_C2 = 461845907;
    private static final long UNSAFE_COPY_THRESHOLD = 1048576;
    private static final boolean UNALIGNED;
    static final /* synthetic */ boolean $assertionsDisabled;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:57:0x02c2
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    static {
        /*
        // Method dump skipped, instructions count: 1333
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.PlatformDependent0.m6327clinit():void");
    }

    /* access modifiers changed from: private */
    public static boolean unsafeStaticFieldOffsetSupported() {
        return !RUNNING_IN_NATIVE_IMAGE;
    }

    /* access modifiers changed from: package-private */
    public static boolean isExplicitNoUnsafe() {
        return EXPLICIT_NO_UNSAFE_CAUSE != null;
    }

    private static Throwable explicitNoUnsafeCause0() {
        String unsafePropName;
        boolean noUnsafe = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        logger.debug("-Dio.netty.noUnsafe: {}", Boolean.valueOf(noUnsafe));
        if (noUnsafe) {
            logger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
        }
        if (SystemPropertyUtil.contains("io.netty.tryUnsafe")) {
            unsafePropName = "io.netty.tryUnsafe";
        } else {
            unsafePropName = "org.jboss.netty.tryUnsafe";
        }
        if (SystemPropertyUtil.getBoolean(unsafePropName, true)) {
            return null;
        }
        String msg = "sun.misc.Unsafe: unavailable (" + unsafePropName + ")";
        logger.debug(msg);
        return new UnsupportedOperationException(msg);
    }

    /* access modifiers changed from: package-private */
    public static boolean isUnaligned() {
        return UNALIGNED;
    }

    /* access modifiers changed from: package-private */
    public static boolean hasUnsafe() {
        return UNSAFE != null;
    }

    /* access modifiers changed from: package-private */
    public static Throwable getUnsafeUnavailabilityCause() {
        return UNSAFE_UNAVAILABILITY_CAUSE;
    }

    /* access modifiers changed from: package-private */
    public static boolean unalignedAccess() {
        return UNALIGNED;
    }

    /* access modifiers changed from: package-private */
    public static void throwException(Throwable cause) {
        UNSAFE.throwException((Throwable) ObjectUtil.checkNotNull(cause, "cause"));
    }

    /* access modifiers changed from: package-private */
    public static boolean hasDirectBufferNoCleanerConstructor() {
        return DIRECT_BUFFER_CONSTRUCTOR != null;
    }

    /* access modifiers changed from: package-private */
    public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer buffer, int capacity) {
        return newDirectBuffer(UNSAFE.reallocateMemory(directBufferAddress(buffer), (long) capacity), capacity);
    }

    /* access modifiers changed from: package-private */
    public static ByteBuffer allocateDirectNoCleaner(int capacity) {
        return newDirectBuffer(UNSAFE.allocateMemory((long) Math.max(1, capacity)), capacity);
    }

    /* access modifiers changed from: package-private */
    public static boolean hasAlignSliceMethod() {
        return ALIGN_SLICE != null;
    }

    /* access modifiers changed from: package-private */
    public static ByteBuffer alignSlice(ByteBuffer buffer, int alignment) {
        try {
            return (ByteBuffer) ALIGN_SLICE.invoke(buffer, Integer.valueOf(alignment));
        } catch (IllegalAccessException e) {
            throw new Error(e);
        } catch (InvocationTargetException e2) {
            throw new Error(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean hasAllocateArrayMethod() {
        return ALLOCATE_ARRAY_METHOD != null;
    }

    /* access modifiers changed from: package-private */
    public static byte[] allocateUninitializedArray(int size) {
        try {
            return (byte[]) ALLOCATE_ARRAY_METHOD.invoke(INTERNAL_UNSAFE, Byte.TYPE, Integer.valueOf(size));
        } catch (IllegalAccessException e) {
            throw new Error(e);
        } catch (InvocationTargetException e2) {
            throw new Error(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public static ByteBuffer newDirectBuffer(long address, int capacity) {
        ObjectUtil.checkPositiveOrZero(capacity, "capacity");
        try {
            return (ByteBuffer) DIRECT_BUFFER_CONSTRUCTOR.newInstance(Long.valueOf(address), Integer.valueOf(capacity));
        } catch (Throwable cause) {
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new Error(cause);
        }
    }

    /* access modifiers changed from: package-private */
    public static long directBufferAddress(ByteBuffer buffer) {
        return getLong(buffer, ADDRESS_FIELD_OFFSET);
    }

    /* access modifiers changed from: package-private */
    public static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    /* access modifiers changed from: package-private */
    public static Object getObject(Object object, long fieldOffset) {
        return UNSAFE.getObject(object, fieldOffset);
    }

    /* access modifiers changed from: package-private */
    public static int getInt(Object object, long fieldOffset) {
        return UNSAFE.getInt(object, fieldOffset);
    }

    /* access modifiers changed from: package-private */
    public static void safeConstructPutInt(Object object, long fieldOffset, int value) {
        if (STORE_FENCE_AVAILABLE) {
            UNSAFE.putInt(object, fieldOffset, value);
            UNSAFE.storeFence();
            return;
        }
        UNSAFE.putIntVolatile(object, fieldOffset, value);
    }

    private static long getLong(Object object, long fieldOffset) {
        return UNSAFE.getLong(object, fieldOffset);
    }

    /* access modifiers changed from: package-private */
    public static long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    /* access modifiers changed from: package-private */
    public static byte getByte(long address) {
        return UNSAFE.getByte(address);
    }

    /* access modifiers changed from: package-private */
    public static short getShort(long address) {
        return UNSAFE.getShort(address);
    }

    /* access modifiers changed from: package-private */
    public static int getInt(long address) {
        return UNSAFE.getInt(address);
    }

    /* access modifiers changed from: package-private */
    public static long getLong(long address) {
        return UNSAFE.getLong(address);
    }

    /* access modifiers changed from: package-private */
    public static byte getByte(byte[] data, int index) {
        return UNSAFE.getByte(data, BYTE_ARRAY_BASE_OFFSET + ((long) index));
    }

    /* access modifiers changed from: package-private */
    public static byte getByte(byte[] data, long index) {
        return UNSAFE.getByte(data, BYTE_ARRAY_BASE_OFFSET + index);
    }

    /* access modifiers changed from: package-private */
    public static short getShort(byte[] data, int index) {
        return UNSAFE.getShort(data, BYTE_ARRAY_BASE_OFFSET + ((long) index));
    }

    /* access modifiers changed from: package-private */
    public static int getInt(byte[] data, int index) {
        return UNSAFE.getInt(data, BYTE_ARRAY_BASE_OFFSET + ((long) index));
    }

    /* access modifiers changed from: package-private */
    public static int getInt(int[] data, long index) {
        return UNSAFE.getInt(data, INT_ARRAY_BASE_OFFSET + (INT_ARRAY_INDEX_SCALE * index));
    }

    /* access modifiers changed from: package-private */
    public static int getIntVolatile(long address) {
        return UNSAFE.getIntVolatile((Object) null, address);
    }

    /* access modifiers changed from: package-private */
    public static void putIntOrdered(long adddress, int newValue) {
        UNSAFE.putOrderedInt((Object) null, adddress, newValue);
    }

    /* access modifiers changed from: package-private */
    public static long getLong(byte[] data, int index) {
        return UNSAFE.getLong(data, BYTE_ARRAY_BASE_OFFSET + ((long) index));
    }

    /* access modifiers changed from: package-private */
    public static long getLong(long[] data, long index) {
        return UNSAFE.getLong(data, LONG_ARRAY_BASE_OFFSET + (LONG_ARRAY_INDEX_SCALE * index));
    }

    /* access modifiers changed from: package-private */
    public static void putByte(long address, byte value) {
        UNSAFE.putByte(address, value);
    }

    /* access modifiers changed from: package-private */
    public static void putShort(long address, short value) {
        UNSAFE.putShort(address, value);
    }

    /* access modifiers changed from: package-private */
    public static void putInt(long address, int value) {
        UNSAFE.putInt(address, value);
    }

    /* access modifiers changed from: package-private */
    public static void putLong(long address, long value) {
        UNSAFE.putLong(address, value);
    }

    /* access modifiers changed from: package-private */
    public static void putByte(byte[] data, int index, byte value) {
        UNSAFE.putByte(data, BYTE_ARRAY_BASE_OFFSET + ((long) index), value);
    }

    /* access modifiers changed from: package-private */
    public static void putByte(Object data, long offset, byte value) {
        UNSAFE.putByte(data, offset, value);
    }

    /* access modifiers changed from: package-private */
    public static void putShort(byte[] data, int index, short value) {
        UNSAFE.putShort(data, BYTE_ARRAY_BASE_OFFSET + ((long) index), value);
    }

    /* access modifiers changed from: package-private */
    public static void putInt(byte[] data, int index, int value) {
        UNSAFE.putInt(data, BYTE_ARRAY_BASE_OFFSET + ((long) index), value);
    }

    /* access modifiers changed from: package-private */
    public static void putLong(byte[] data, int index, long value) {
        UNSAFE.putLong(data, BYTE_ARRAY_BASE_OFFSET + ((long) index), value);
    }

    /* access modifiers changed from: package-private */
    public static void putObject(Object o, long offset, Object x) {
        UNSAFE.putObject(o, offset, x);
    }

    /* access modifiers changed from: package-private */
    public static void copyMemory(long srcAddr, long dstAddr, long length) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(srcAddr, dstAddr, length);
        } else {
            UNSAFE.copyMemory(srcAddr, dstAddr, length);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r10v1, types: [long] */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:0:?, code lost:
        r8 = r8;
        r10 = r10;
        r12 = r12;
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void copyMemoryWithSafePointPolling(long r8, long r10, long r12) {
        /*
        L_0x0000:
            r0 = r12
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x002f
            r0 = r12
            r1 = 1048576(0x100000, double:5.180654E-318)
            long r0 = java.lang.Math.min(r0, r1)
            r14 = r0
            sun.misc.Unsafe r0 = p013io.netty.util.internal.PlatformDependent0.UNSAFE
            r1 = r8
            r2 = r10
            r3 = r14
            r0.copyMemory(r1, r2, r3)
            r0 = r12
            r1 = r14
            long r0 = r0 - r1
            r12 = r0
            r0 = r8
            r1 = r14
            long r0 = r0 + r1
            r8 = r0
            r0 = r10
            r1 = r14
            long r0 = r0 + r1
            r10 = r0
            goto L_0x0000
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.PlatformDependent0.copyMemoryWithSafePointPolling(long, long, long):void");
    }

    /* access modifiers changed from: package-private */
    public static void copyMemory(Object src, long srcOffset, Object dst, long dstOffset, long length) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(src, srcOffset, dst, dstOffset, length);
        } else {
            UNSAFE.copyMemory(src, srcOffset, dst, dstOffset, length);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v1, types: [long] */
    /* JADX WARN: Type inference failed for: r14v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:0:?, code lost:
        r11 = r11;
        r14 = r14;
        r16 = r16;
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void copyMemoryWithSafePointPolling(java.lang.Object r10, long r11, java.lang.Object r13, long r14, long r16) {
        /*
        L_0x0000:
            r0 = r16
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0034
            r0 = r16
            r1 = 1048576(0x100000, double:5.180654E-318)
            long r0 = java.lang.Math.min(r0, r1)
            r18 = r0
            sun.misc.Unsafe r0 = p013io.netty.util.internal.PlatformDependent0.UNSAFE
            r1 = r10
            r2 = r11
            r3 = r13
            r4 = r14
            r5 = r18
            r0.copyMemory(r1, r2, r3, r4, r5)
            r0 = r16
            r1 = r18
            long r0 = r0 - r1
            r16 = r0
            r0 = r11
            r1 = r18
            long r0 = r0 + r1
            r11 = r0
            r0 = r14
            r1 = r18
            long r0 = r0 + r1
            r14 = r0
            goto L_0x0000
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.PlatformDependent0.copyMemoryWithSafePointPolling(java.lang.Object, long, java.lang.Object, long, long):void");
    }

    /* access modifiers changed from: package-private */
    public static void setMemory(long address, long bytes, byte value) {
        UNSAFE.setMemory(address, bytes, value);
    }

    /* access modifiers changed from: package-private */
    public static void setMemory(Object o, long offset, long bytes, byte value) {
        UNSAFE.setMemory(o, offset, bytes, value);
    }

    /* access modifiers changed from: package-private */
    public static boolean equals(byte[] bytes1, int startPos1, byte[] bytes2, int startPos2, int length) {
        int remainingBytes = length & 7;
        long baseOffset1 = BYTE_ARRAY_BASE_OFFSET + ((long) startPos1);
        long diff = (long) (startPos2 - startPos1);
        if (length >= 8) {
            long end = baseOffset1 + ((long) remainingBytes);
            for (long i = (baseOffset1 - 8) + ((long) length); i >= end; i -= 8) {
                if (UNSAFE.getLong(bytes1, i) != UNSAFE.getLong(bytes2, i + diff)) {
                    return false;
                }
            }
        }
        if (remainingBytes >= 4) {
            remainingBytes -= 4;
            long pos = baseOffset1 + ((long) remainingBytes);
            if (UNSAFE.getInt(bytes1, pos) != UNSAFE.getInt(bytes2, pos + diff)) {
                return false;
            }
        }
        long baseOffset2 = baseOffset1 + diff;
        return remainingBytes >= 2 ? UNSAFE.getChar(bytes1, baseOffset1) == UNSAFE.getChar(bytes2, baseOffset2) && (remainingBytes == 2 || UNSAFE.getByte(bytes1, baseOffset1 + 2) == UNSAFE.getByte(bytes2, baseOffset2 + 2)) : remainingBytes == 0 || UNSAFE.getByte(bytes1, baseOffset1) == UNSAFE.getByte(bytes2, baseOffset2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v28, types: [long] */
    /* JADX WARN: Type inference failed for: r0v32, types: [long] */
    /* JADX WARN: Type inference failed for: r0v34, types: [long] */
    /* JADX WARN: Type inference failed for: r0v36, types: [long] */
    /* JADX WARN: Type inference failed for: r0v38, types: [long] */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r0v40, types: [long] */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int equalsConstantTime(byte[] r11, int r12, byte[] r13, int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.PlatformDependent0.equalsConstantTime(byte[], int, byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    public static boolean isZero(byte[] bytes, int startPos, int length) {
        if (length <= 0) {
            return true;
        }
        long baseOffset = BYTE_ARRAY_BASE_OFFSET + ((long) startPos);
        int remainingBytes = length & 7;
        long end = baseOffset + ((long) remainingBytes);
        for (long i = (baseOffset - 8) + ((long) length); i >= end; i -= 8) {
            if (UNSAFE.getLong(bytes, i) != 0) {
                return false;
            }
        }
        if (remainingBytes >= 4) {
            remainingBytes -= 4;
            if (UNSAFE.getInt(bytes, baseOffset + ((long) remainingBytes)) != 0) {
                return false;
            }
        }
        return remainingBytes >= 2 ? UNSAFE.getChar(bytes, baseOffset) == 0 && (remainingBytes == 2 || bytes[startPos + 2] == 0) : bytes[startPos] == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v34, types: [long] */
    /* JADX WARN: Type inference failed for: r0v44, types: [long] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int hashCodeAscii(byte[] r6, int r7, int r8) {
        /*
        // Method dump skipped, instructions count: 253
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.PlatformDependent0.hashCodeAscii(byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    public static int hashCodeAsciiCompute(long value, int hash) {
        return (hash * HASH_CODE_C1) + (hashCodeAsciiSanitize((int) value) * HASH_CODE_C2) + ((int) ((value & 2242545357458243584L) >>> 32));
    }

    /* access modifiers changed from: package-private */
    public static int hashCodeAsciiSanitize(int value) {
        return value & 522133279;
    }

    /* access modifiers changed from: package-private */
    public static int hashCodeAsciiSanitize(short value) {
        return value & 7967;
    }

    /* access modifiers changed from: package-private */
    public static int hashCodeAsciiSanitize(byte value) {
        return value & 31;
    }

    /* access modifiers changed from: package-private */
    public static ClassLoader getClassLoader(final Class<?> clazz) {
        if (System.getSecurityManager() == null) {
            return clazz.getClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.10
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return clazz.getClassLoader();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static ClassLoader getContextClassLoader() {
        if (System.getSecurityManager() == null) {
            return Thread.currentThread().getContextClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.11
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.12
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static int addressSize() {
        return UNSAFE.addressSize();
    }

    /* access modifiers changed from: package-private */
    public static long allocateMemory(long size) {
        return UNSAFE.allocateMemory(size);
    }

    /* access modifiers changed from: package-private */
    public static void freeMemory(long address) {
        UNSAFE.freeMemory(address);
    }

    /* access modifiers changed from: package-private */
    public static long reallocateMemory(long address, long newSize) {
        return UNSAFE.reallocateMemory(address, newSize);
    }

    /* access modifiers changed from: package-private */
    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    private static boolean isAndroid0() {
        boolean isAndroid = "Dalvik".equals(SystemPropertyUtil.get("java.vm.name"));
        if (isAndroid) {
            logger.debug("Platform: Android");
        }
        return isAndroid;
    }

    private static boolean explicitTryReflectionSetAccessible0() {
        return SystemPropertyUtil.getBoolean("io.netty.tryReflectionSetAccessible", javaVersion() < 9);
    }

    /* access modifiers changed from: package-private */
    public static boolean isExplicitTryReflectionSetAccessible() {
        return IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    }

    /* access modifiers changed from: package-private */
    public static int javaVersion() {
        return JAVA_VERSION;
    }

    private static int javaVersion0() {
        int majorVersion;
        if (isAndroid0()) {
            majorVersion = 6;
        } else {
            majorVersion = majorVersionFromJavaSpecificationVersion();
        }
        logger.debug("Java version: {}", Integer.valueOf(majorVersion));
        return majorVersion;
    }

    static int majorVersionFromJavaSpecificationVersion() {
        return majorVersion(SystemPropertyUtil.get("java.specification.version", "1.6"));
    }

    static int majorVersion(String javaSpecVersion) {
        String[] components = javaSpecVersion.split("\\.");
        int[] version = new int[components.length];
        for (int i = 0; i < components.length; i++) {
            version[i] = Integer.parseInt(components[i]);
        }
        if (version[0] != 1) {
            return version[0];
        }
        if ($assertionsDisabled || version[1] >= 6) {
            return version[1];
        }
        throw new AssertionError();
    }

    private PlatformDependent0() {
    }
}
