package p013io.netty.util.internal;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p013io.netty.util.concurrent.FastThreadLocalThread;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.internal.InternalThreadLocalMap */
/* loaded from: grasscutter.jar:io/netty/util/internal/InternalThreadLocalMap.class */
public final class InternalThreadLocalMap extends UnpaddedInternalThreadLocalMap {
    private static final int DEFAULT_ARRAY_LIST_INITIAL_CAPACITY = 8;
    private static final int ARRAY_LIST_CAPACITY_EXPAND_THRESHOLD = 1073741824;
    private static final int ARRAY_LIST_CAPACITY_MAX_SIZE = 2147483639;
    private static final int HANDLER_SHARABLE_CACHE_INITIAL_CAPACITY = 4;
    private static final int INDEXED_VARIABLE_TABLE_INITIAL_SIZE = 32;
    private Object[] indexedVariables = newIndexedVariableTable();
    private int futureListenerStackDepth;
    private int localChannelReaderStackDepth;
    private Map<Class<?>, Boolean> handlerSharableCache;
    private IntegerHolder counterHashCode;
    private ThreadLocalRandom random;
    private Map<Class<?>, TypeParameterMatcher> typeParameterMatcherGetCache;
    private Map<Class<?>, Map<String, TypeParameterMatcher>> typeParameterMatcherFindCache;
    private StringBuilder stringBuilder;
    private Map<Charset, CharsetEncoder> charsetEncoderCache;
    private Map<Charset, CharsetDecoder> charsetDecoderCache;
    private ArrayList<Object> arrayList;
    private BitSet cleanerFlags;
    public long rp1;
    public long rp2;
    public long rp3;
    public long rp4;
    public long rp5;
    public long rp6;
    public long rp7;
    public long rp8;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(InternalThreadLocalMap.class);
    private static final ThreadLocal<InternalThreadLocalMap> slowThreadLocalMap = new ThreadLocal<>();
    private static final AtomicInteger nextIndex = new AtomicInteger();
    public static final Object UNSET = new Object();
    private static final int STRING_BUILDER_INITIAL_SIZE = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.initialSize", 1024);
    private static final int STRING_BUILDER_MAX_SIZE = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.maxSize", 4096);

    static {
        logger.debug("-Dio.netty.threadLocalMap.stringBuilder.initialSize: {}", Integer.valueOf(STRING_BUILDER_INITIAL_SIZE));
        logger.debug("-Dio.netty.threadLocalMap.stringBuilder.maxSize: {}", Integer.valueOf(STRING_BUILDER_MAX_SIZE));
    }

    public static InternalThreadLocalMap getIfSet() {
        Thread thread = Thread.currentThread();
        if (thread instanceof FastThreadLocalThread) {
            return ((FastThreadLocalThread) thread).threadLocalMap();
        }
        return slowThreadLocalMap.get();
    }

    public static InternalThreadLocalMap get() {
        Thread thread = Thread.currentThread();
        if (thread instanceof FastThreadLocalThread) {
            return fastGet((FastThreadLocalThread) thread);
        }
        return slowGet();
    }

    private static InternalThreadLocalMap fastGet(FastThreadLocalThread thread) {
        InternalThreadLocalMap threadLocalMap = thread.threadLocalMap();
        if (threadLocalMap == null) {
            InternalThreadLocalMap internalThreadLocalMap = new InternalThreadLocalMap();
            threadLocalMap = internalThreadLocalMap;
            thread.setThreadLocalMap(internalThreadLocalMap);
        }
        return threadLocalMap;
    }

    private static InternalThreadLocalMap slowGet() {
        InternalThreadLocalMap ret = slowThreadLocalMap.get();
        if (ret == null) {
            ret = new InternalThreadLocalMap();
            slowThreadLocalMap.set(ret);
        }
        return ret;
    }

    public static void remove() {
        Thread thread = Thread.currentThread();
        if (thread instanceof FastThreadLocalThread) {
            ((FastThreadLocalThread) thread).setThreadLocalMap(null);
        } else {
            slowThreadLocalMap.remove();
        }
    }

    public static void destroy() {
        slowThreadLocalMap.remove();
    }

    public static int nextVariableIndex() {
        int index = nextIndex.getAndIncrement();
        if (index < 2147483639 && index >= 0) {
            return index;
        }
        nextIndex.set(2147483639);
        throw new IllegalStateException("too many thread-local indexed variables");
    }

    public static int lastVariableIndex() {
        return nextIndex.get() - 1;
    }

    private InternalThreadLocalMap() {
    }

    private static Object[] newIndexedVariableTable() {
        Object[] array = new Object[32];
        Arrays.fill(array, UNSET);
        return array;
    }

    public int size() {
        int count = 0;
        if (this.futureListenerStackDepth != 0) {
            count = 0 + 1;
        }
        if (this.localChannelReaderStackDepth != 0) {
            count++;
        }
        if (this.handlerSharableCache != null) {
            count++;
        }
        if (this.counterHashCode != null) {
            count++;
        }
        if (this.random != null) {
            count++;
        }
        if (this.typeParameterMatcherGetCache != null) {
            count++;
        }
        if (this.typeParameterMatcherFindCache != null) {
            count++;
        }
        if (this.stringBuilder != null) {
            count++;
        }
        if (this.charsetEncoderCache != null) {
            count++;
        }
        if (this.charsetDecoderCache != null) {
            count++;
        }
        if (this.arrayList != null) {
            count++;
        }
        for (Object o : this.indexedVariables) {
            if (o != UNSET) {
                count++;
            }
        }
        return count - 1;
    }

    public StringBuilder stringBuilder() {
        StringBuilder sb = this.stringBuilder;
        if (sb == null) {
            StringBuilder sb2 = new StringBuilder(STRING_BUILDER_INITIAL_SIZE);
            this.stringBuilder = sb2;
            return sb2;
        }
        if (sb.capacity() > STRING_BUILDER_MAX_SIZE) {
            sb.setLength(STRING_BUILDER_INITIAL_SIZE);
            sb.trimToSize();
        }
        sb.setLength(0);
        return sb;
    }

    public Map<Charset, CharsetEncoder> charsetEncoderCache() {
        Map<Charset, CharsetEncoder> cache = this.charsetEncoderCache;
        if (cache == null) {
            Map<Charset, CharsetEncoder> identityHashMap = new IdentityHashMap<>();
            cache = identityHashMap;
            this.charsetEncoderCache = identityHashMap;
        }
        return cache;
    }

    public Map<Charset, CharsetDecoder> charsetDecoderCache() {
        Map<Charset, CharsetDecoder> cache = this.charsetDecoderCache;
        if (cache == null) {
            Map<Charset, CharsetDecoder> identityHashMap = new IdentityHashMap<>();
            cache = identityHashMap;
            this.charsetDecoderCache = identityHashMap;
        }
        return cache;
    }

    public <E> ArrayList<E> arrayList() {
        return arrayList(8);
    }

    public <E> ArrayList<E> arrayList(int minCapacity) {
        ArrayList<E> list = (ArrayList<E>) this.arrayList;
        if (list == null) {
            this.arrayList = new ArrayList<>(minCapacity);
            return (ArrayList<E>) this.arrayList;
        }
        list.clear();
        list.ensureCapacity(minCapacity);
        return list;
    }

    public int futureListenerStackDepth() {
        return this.futureListenerStackDepth;
    }

    public void setFutureListenerStackDepth(int futureListenerStackDepth) {
        this.futureListenerStackDepth = futureListenerStackDepth;
    }

    public ThreadLocalRandom random() {
        ThreadLocalRandom r = this.random;
        if (r == null) {
            ThreadLocalRandom threadLocalRandom = new ThreadLocalRandom();
            r = threadLocalRandom;
            this.random = threadLocalRandom;
        }
        return r;
    }

    public Map<Class<?>, TypeParameterMatcher> typeParameterMatcherGetCache() {
        Map<Class<?>, TypeParameterMatcher> cache = this.typeParameterMatcherGetCache;
        if (cache == null) {
            Map<Class<?>, TypeParameterMatcher> identityHashMap = new IdentityHashMap<>();
            cache = identityHashMap;
            this.typeParameterMatcherGetCache = identityHashMap;
        }
        return cache;
    }

    public Map<Class<?>, Map<String, TypeParameterMatcher>> typeParameterMatcherFindCache() {
        Map<Class<?>, Map<String, TypeParameterMatcher>> cache = this.typeParameterMatcherFindCache;
        if (cache == null) {
            Map<Class<?>, Map<String, TypeParameterMatcher>> identityHashMap = new IdentityHashMap<>();
            cache = identityHashMap;
            this.typeParameterMatcherFindCache = identityHashMap;
        }
        return cache;
    }

    @Deprecated
    public IntegerHolder counterHashCode() {
        return this.counterHashCode;
    }

    @Deprecated
    public void setCounterHashCode(IntegerHolder counterHashCode) {
        this.counterHashCode = counterHashCode;
    }

    public Map<Class<?>, Boolean> handlerSharableCache() {
        Map<Class<?>, Boolean> cache = this.handlerSharableCache;
        if (cache == null) {
            Map<Class<?>, Boolean> weakHashMap = new WeakHashMap<>(4);
            cache = weakHashMap;
            this.handlerSharableCache = weakHashMap;
        }
        return cache;
    }

    public int localChannelReaderStackDepth() {
        return this.localChannelReaderStackDepth;
    }

    public void setLocalChannelReaderStackDepth(int localChannelReaderStackDepth) {
        this.localChannelReaderStackDepth = localChannelReaderStackDepth;
    }

    public Object indexedVariable(int index) {
        Object[] lookup = this.indexedVariables;
        return index < lookup.length ? lookup[index] : UNSET;
    }

    public boolean setIndexedVariable(int index, Object value) {
        Object[] lookup = this.indexedVariables;
        if (index < lookup.length) {
            Object oldValue = lookup[index];
            lookup[index] = value;
            return oldValue == UNSET;
        }
        expandIndexedVariableTableAndSet(index, value);
        return true;
    }

    private void expandIndexedVariableTableAndSet(int index, Object value) {
        int newCapacity;
        Object[] oldArray = this.indexedVariables;
        int oldCapacity = oldArray.length;
        if (index < 1073741824) {
            int newCapacity2 = index | (index >>> 1);
            int newCapacity3 = newCapacity2 | (newCapacity2 >>> 2);
            int newCapacity4 = newCapacity3 | (newCapacity3 >>> 4);
            int newCapacity5 = newCapacity4 | (newCapacity4 >>> 8);
            newCapacity = (newCapacity5 | (newCapacity5 >>> 16)) + 1;
        } else {
            newCapacity = 2147483639;
        }
        Object[] newArray = Arrays.copyOf(oldArray, newCapacity);
        Arrays.fill(newArray, oldCapacity, newArray.length, UNSET);
        newArray[index] = value;
        this.indexedVariables = newArray;
    }

    public Object removeIndexedVariable(int index) {
        Object[] lookup = this.indexedVariables;
        if (index >= lookup.length) {
            return UNSET;
        }
        Object v = lookup[index];
        lookup[index] = UNSET;
        return v;
    }

    public boolean isIndexedVariableSet(int index) {
        Object[] lookup = this.indexedVariables;
        return index < lookup.length && lookup[index] != UNSET;
    }

    public boolean isCleanerFlagSet(int index) {
        return this.cleanerFlags != null && this.cleanerFlags.get(index);
    }

    public void setCleanerFlag(int index) {
        if (this.cleanerFlags == null) {
            this.cleanerFlags = new BitSet();
        }
        this.cleanerFlags.set(index);
    }
}
