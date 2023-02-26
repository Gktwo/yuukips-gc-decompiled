package org.jctools.maps;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jctools.util.RangeUtil;
import org.jctools.util.UnsafeAccess;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

/* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingIdentityHashMap.class */
public class NonBlockingIdentityHashMap<TypeK, TypeV> extends AbstractMap<TypeK, TypeV> implements ConcurrentMap<TypeK, TypeV>, Cloneable, Serializable {
    private static final long serialVersionUID = 1234123412341234123L;
    private static final int REPROBE_LIMIT = 10;
    private static final int _Obase;
    private static final int _Oscale;
    private static final long _kvs_offset;
    private transient Object[] _kvs;
    private transient long _last_resize_milli;
    private static final int MIN_SIZE_LOG = 3;
    private static final int MIN_SIZE = 8;
    private static final Object NO_MATCH_OLD;
    private static final Object MATCH_ANY;
    private static final Object TOMBSTONE;
    private static final Prime TOMBPRIME;
    private transient ConcurrentAutoTable _reprobes;
    static final /* synthetic */ boolean $assertionsDisabled;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0062: INVOKE_CUSTOM r-3, r-2, r-1, r0
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x0062: INVOKE_CUSTOM r1, r2, r3, r4, method: org.jctools.maps.NonBlockingIdentityHashMap.print(java.lang.Object[]):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;},  (,)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;},  (,)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private final void print(java.lang.Object[] r7) {
        /*
            r6 = this;
            r0 = 0
            r8 = r0
            r0 = r8
            r1 = r7
            int r1 = len(r1)
            if (r0 >= r1) goto L_0x0070
            r0 = r7
            r1 = r8
            java.lang.Object r0 = key(r0, r1)
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L_0x006a
            r0 = r9
            java.lang.Object r1 = org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE
            if (r0 != r1) goto L_0x0020
            java.lang.String r0 = "XXX"
            goto L_0x0024
            r0 = r9
            java.lang.String r0 = r0.toString()
            r10 = r0
            r0 = r7
            r1 = r8
            java.lang.Object r0 = val(r0, r1)
            r11 = r0
            r0 = r11
            java.lang.Object r0 = org.jctools.maps.NonBlockingIdentityHashMap.Prime.unbox(r0)
            r12 = r0
            r0 = r11
            r1 = r12
            if (r0 != r1) goto L_0x0040
            java.lang.String r0 = ""
            goto L_0x0042
            java.lang.String r0 = "prime_"
            r13 = r0
            r0 = r12
            java.lang.Object r1 = org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE
            if (r0 != r1) goto L_0x0051
            java.lang.String r0 = "tombstone"
            goto L_0x0056
            r0 = r12
            java.lang.String r0 = r0.toString()
            r14 = r0
            java.io.PrintStream r0 = java.lang.System.out
            r1 = r8
            r2 = r10
            r3 = r13
            r4 = r14
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;},  (,)]}
            r0.println(r1)
            int r8 = r8 + 1
            goto L_0x0002
            r0 = r7
            org.jctools.maps.NonBlockingIdentityHashMap$CHM r0 = chm(r0)
            java.lang.Object[] r0 = r0._newkvs
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L_0x0089
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.String r1 = "----"
            r0.println(r1)
            r0 = r6
            r1 = r8
            r0.print(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.maps.NonBlockingIdentityHashMap.print(java.lang.Object[]):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x004F: INVOKE_CUSTOM r-3, r-2, r-1, r0
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x004F: INVOKE_CUSTOM r1, r2, r3, r4, method: org.jctools.maps.NonBlockingIdentityHashMap.print2(java.lang.Object[]):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/Object;, Ljava/lang/String;, Ljava/lang/Object;)Ljava/lang/String;},  (,)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/Object;, Ljava/lang/String;, Ljava/lang/Object;)Ljava/lang/String;},  (,)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private final void print2(java.lang.Object[] r7) {
        /*
            r6 = this;
            r0 = 0
            r8 = r0
            r0 = r8
            r1 = r7
            int r1 = len(r1)
            if (r0 >= r1) goto L_0x005d
            r0 = r7
            r1 = r8
            java.lang.Object r0 = key(r0, r1)
            r9 = r0
            r0 = r7
            r1 = r8
            java.lang.Object r0 = val(r0, r1)
            r10 = r0
            r0 = r10
            java.lang.Object r0 = org.jctools.maps.NonBlockingIdentityHashMap.Prime.unbox(r0)
            r11 = r0
            r0 = r9
            if (r0 == 0) goto L_0x0057
            r0 = r9
            java.lang.Object r1 = org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE
            if (r0 == r1) goto L_0x0057
            r0 = r10
            if (r0 == 0) goto L_0x0057
            r0 = r11
            java.lang.Object r1 = org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE
            if (r0 == r1) goto L_0x0057
            r0 = r10
            r1 = r11
            if (r0 != r1) goto L_0x0042
            java.lang.String r0 = ""
            goto L_0x0044
            java.lang.String r0 = "prime_"
            r12 = r0
            java.io.PrintStream r0 = java.lang.System.out
            r1 = r8
            r2 = r9
            r3 = r12
            r4 = r10
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/Object;, Ljava/lang/String;, Ljava/lang/Object;)Ljava/lang/String;},  (,)]}
            r0.println(r1)
            int r8 = r8 + 1
            goto L_0x0002
            r0 = r7
            org.jctools.maps.NonBlockingIdentityHashMap$CHM r0 = chm(r0)
            java.lang.Object[] r0 = r0._newkvs
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L_0x0076
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.String r1 = "----"
            r0.println(r1)
            r0 = r6
            r1 = r8
            r0.print2(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.maps.NonBlockingIdentityHashMap.print2(java.lang.Object[]):void");
    }

    static {
        $assertionsDisabled = !NonBlockingIdentityHashMap.class.desiredAssertionStatus();
        _Obase = UnsafeAccess.UNSAFE.arrayBaseOffset(Object[].class);
        _Oscale = UnsafeAccess.UNSAFE.arrayIndexScale(Object[].class);
        _kvs_offset = UnsafeAccess.fieldOffset(NonBlockingHashMap.class, "_kvs");
        NO_MATCH_OLD = new Object();
        MATCH_ANY = new Object();
        TOMBSTONE = new Object();
        TOMBPRIME = new Prime(TOMBSTONE);
    }

    private static long rawIndex(Object[] ary, int idx) {
        if ($assertionsDisabled || (idx >= 0 && idx < ary.length)) {
            return ((long) _Obase) + (((long) idx) * ((long) _Oscale));
        }
        throw new AssertionError();
    }

    private final boolean CAS_kvs(Object[] oldkvs, Object[] newkvs) {
        return UnsafeAccess.UNSAFE.compareAndSwapObject(this, _kvs_offset, oldkvs, newkvs);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingIdentityHashMap$Prime.class */
    public static final class Prime {

        /* renamed from: _V */
        final Object f3156_V;

        Prime(Object V) {
            this.f3156_V = V;
        }

        static Object unbox(Object V) {
            return V instanceof Prime ? ((Prime) V).f3156_V : V;
        }
    }

    private static final int hash(Object key) {
        if (key != null) {
            return System.identityHashCode(key);
        }
        throw new NullPointerException();
    }

    private static final CHM chm(Object[] kvs) {
        return (CHM) kvs[0];
    }

    private static final int[] hashes(Object[] kvs) {
        return (int[]) kvs[1];
    }

    private static final int len(Object[] kvs) {
        return (kvs.length - 2) >> 1;
    }

    private static final Object key(Object[] kvs, int idx) {
        return kvs[(idx << 1) + 2];
    }

    private static final Object val(Object[] kvs, int idx) {
        return kvs[(idx << 1) + 3];
    }

    private static final boolean CAS_key(Object[] kvs, int idx, Object old, Object key) {
        return UnsafeAccess.UNSAFE.compareAndSwapObject(kvs, rawIndex(kvs, (idx << 1) + 2), old, key);
    }

    private static final boolean CAS_val(Object[] kvs, int idx, Object old, Object val) {
        return UnsafeAccess.UNSAFE.compareAndSwapObject(kvs, rawIndex(kvs, (idx << 1) + 3), old, val);
    }

    public final void print() {
        System.out.println("=========");
        print2(this._kvs);
        System.out.println("=========");
    }

    public long reprobes() {
        long r = this._reprobes.get();
        this._reprobes = new ConcurrentAutoTable();
        return r;
    }

    private static final int reprobe_limit(int len) {
        return 10 + (len >> 2);
    }

    public NonBlockingIdentityHashMap() {
        this(8);
    }

    public NonBlockingIdentityHashMap(int initial_sz) {
        this._reprobes = new ConcurrentAutoTable();
        initialize(initial_sz);
    }

    private final void initialize(int initial_sz) {
        RangeUtil.checkPositiveOrZero(initial_sz, "initial_sz");
        if (initial_sz > 1048576) {
            initial_sz = 1048576;
        }
        int i = 3;
        while ((1 << i) < (initial_sz << 2)) {
            i++;
        }
        this._kvs = new Object[((1 << i) << 1) + 2];
        this._kvs[0] = new CHM(new ConcurrentAutoTable());
        this._kvs[1] = new int[1 << i];
        this._last_resize_milli = System.currentTimeMillis();
    }

    protected final void initialize() {
        initialize(8);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return chm(this._kvs).size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    public boolean contains(Object val) {
        return containsValue(val);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public TypeV put(TypeK key, TypeV val) {
        return putIfMatch(key, val, NO_MATCH_OLD);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public TypeV putIfAbsent(TypeK key, TypeV val) {
        return putIfMatch(key, val, TOMBSTONE);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public TypeV remove(Object key) {
        return putIfMatch(key, TOMBSTONE, NO_MATCH_OLD);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object key, Object val) {
        return objectsEquals(putIfMatch(key, TOMBSTONE, val), val);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public TypeV replace(TypeK key, TypeV val) {
        return putIfMatch(key, val, MATCH_ANY);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(TypeK key, TypeV oldValue, TypeV newValue) {
        return objectsEquals(putIfMatch(key, newValue, oldValue), oldValue);
    }

    private static boolean objectsEquals(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    private final TypeV putIfMatch(Object key, Object newVal, Object oldVal) {
        if (oldVal == null || newVal == null) {
            throw new NullPointerException();
        }
        TypeV typev = (TypeV) putIfMatch0(this, this._kvs, key, newVal, oldVal);
        if (!$assertionsDisabled && (typev instanceof Prime)) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && typev == null) {
            throw new AssertionError();
        } else if (typev == TOMBSTONE) {
            return null;
        } else {
            return typev;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: org.jctools.maps.NonBlockingIdentityHashMap<TypeK, TypeV> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends TypeK, ? extends TypeV> m) {
        for (Map.Entry<? extends TypeK, ? extends TypeV> e : m.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        do {
        } while (!CAS_kvs(this._kvs, new NonBlockingIdentityHashMap(8)._kvs));
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    @Override // java.util.AbstractMap, java.util.Map
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsValue(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = r4
            if (r0 != 0) goto L_0x000c
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x000c:
            r0 = r3
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
        L_0x0016:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0038
            r0 = r5
            java.lang.Object r0 = r0.next()
            r6 = r0
            r0 = r6
            r1 = r4
            if (r0 == r1) goto L_0x0033
            r0 = r6
            r1 = r4
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0035
        L_0x0033:
            r0 = 1
            return r0
        L_0x0035:
            goto L_0x0016
        L_0x0038:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.maps.NonBlockingIdentityHashMap.containsValue(java.lang.Object):boolean");
    }

    protected void rehash() {
    }

    @Override // java.util.AbstractMap, java.lang.Object
    public Object clone() {
        try {
            NonBlockingIdentityHashMap<TypeK, TypeV> t = (NonBlockingIdentityHashMap) clone();
            t.clear();
            for (TypeK K : keySet()) {
                t.put(K, get(K));
            }
            return t;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // java.util.AbstractMap, java.lang.Object
    public String toString() {
        Iterator<Map.Entry<TypeK, TypeV>> i = entrySet().iterator();
        if (!i.hasNext()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        while (true) {
            Map.Entry<TypeK, TypeV> e = i.next();
            TypeK key = e.getKey();
            TypeV value = e.getValue();
            sb.append(key == this ? "(this Map)" : key);
            sb.append('=');
            sb.append(value == this ? "(this Map)" : value);
            if (!i.hasNext()) {
                return sb.append('}').toString();
            }
            sb.append(", ");
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public TypeV get(Object key) {
        TypeV typev = (TypeV) get_impl(this, this._kvs, key);
        if (!$assertionsDisabled && (typev instanceof Prime)) {
            throw new AssertionError();
        } else if ($assertionsDisabled || typev != TOMBSTONE) {
            return typev;
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        if (r0 != null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0081, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        return get_impl(r7, r7.help_copy(r0), r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.Object get_impl(org.jctools.maps.NonBlockingIdentityHashMap r7, java.lang.Object[] r8, java.lang.Object r9) {
        /*
            r0 = r9
            int r0 = hash(r0)
            r10 = r0
            r0 = r8
            int r0 = len(r0)
            r11 = r0
            r0 = r8
            org.jctools.maps.NonBlockingIdentityHashMap$CHM r0 = chm(r0)
            r12 = r0
            r0 = r10
            r1 = r11
            r2 = 1
            int r1 = r1 - r2
            r0 = r0 & r1
            r13 = r0
            r0 = 0
            r14 = r0
        L_0x001c:
            r0 = r8
            r1 = r13
            java.lang.Object r0 = key(r0, r1)
            r15 = r0
            r0 = r8
            r1 = r13
            java.lang.Object r0 = val(r0, r1)
            r16 = r0
            r0 = r15
            if (r0 != 0) goto L_0x0033
            r0 = 0
            return r0
        L_0x0033:
            r0 = r12
            java.lang.Object[] r0 = r0._newkvs
            r17 = r0
            r0 = r15
            r1 = r9
            if (r0 != r1) goto L_0x0067
            r0 = r16
            boolean r0 = r0 instanceof org.jctools.maps.NonBlockingIdentityHashMap.Prime
            if (r0 != 0) goto L_0x0057
            r0 = r16
            java.lang.Object r1 = org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE
            if (r0 != r1) goto L_0x0054
            r0 = 0
            goto L_0x0056
        L_0x0054:
            r0 = r16
        L_0x0056:
            return r0
        L_0x0057:
            r0 = r7
            r1 = r12
            r2 = r7
            r3 = r8
            r4 = r13
            r5 = r9
            java.lang.Object[] r1 = r1.copy_slot_and_check(r2, r3, r4, r5)
            r2 = r9
            java.lang.Object r0 = get_impl(r0, r1, r2)
            return r0
        L_0x0067:
            int r14 = r14 + 1
            r0 = r14
            r1 = r11
            int r1 = reprobe_limit(r1)
            if (r0 >= r1) goto L_0x007c
            r0 = r15
            java.lang.Object r1 = org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE
            if (r0 != r1) goto L_0x0091
        L_0x007c:
            r0 = r17
            if (r0 != 0) goto L_0x0085
            r0 = 0
            goto L_0x0090
        L_0x0085:
            r0 = r7
            r1 = r7
            r2 = r17
            java.lang.Object[] r1 = r1.help_copy(r2)
            r2 = r9
            java.lang.Object r0 = get_impl(r0, r1, r2)
        L_0x0090:
            return r0
        L_0x0091:
            r0 = r13
            r1 = 1
            int r0 = r0 + r1
            r1 = r11
            r2 = 1
            int r1 = r1 - r2
            r0 = r0 & r1
            r13 = r0
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.maps.NonBlockingIdentityHashMap.get_impl(org.jctools.maps.NonBlockingIdentityHashMap, java.lang.Object[], java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01ec, code lost:
        if (r11 == null) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01f1, code lost:
        if (r18 == null) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01f9, code lost:
        if (r18 != org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0200, code lost:
        if (r10 == org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0203, code lost:
        r0._size.add(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x020e, code lost:
        if (r18 == null) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0216, code lost:
        if (r18 == org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x021d, code lost:
        if (r10 != org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0220, code lost:
        r0._size.add(-1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x022d, code lost:
        if (r18 != null) goto L_0x023b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0232, code lost:
        if (r11 == null) goto L_0x023b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x023d, code lost:
        return r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
        return org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
        return org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d4, code lost:
        r0 = r0.resize(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00df, code lost:
        if (r11 == null) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e2, code lost:
        r7.help_copy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f3, code lost:
        return putIfMatch0(r7, r0, r9, r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0105, code lost:
        if (r10 != r18) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010a, code lost:
        return r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010d, code lost:
        if (r19 != null) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0112, code lost:
        if (r18 != null) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011e, code lost:
        if (r0.tableFull(r16, r0) != false) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0126, code lost:
        if ((r18 instanceof org.jctools.maps.NonBlockingIdentityHashMap.Prime) == false) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0129, code lost:
        r19 = r0.resize(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0134, code lost:
        if (r19 == null) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x014a, code lost:
        return putIfMatch0(r7, r0.copy_slot_and_check(r7, r8, r15, r11), r9, r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x014e, code lost:
        if (org.jctools.maps.NonBlockingIdentityHashMap.$assertionsDisabled != false) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0156, code lost:
        if ((r18 instanceof org.jctools.maps.NonBlockingIdentityHashMap.Prime) == false) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0160, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0166, code lost:
        if (r11 == org.jctools.maps.NonBlockingIdentityHashMap.NO_MATCH_OLD) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x016d, code lost:
        if (r18 == r11) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0175, code lost:
        if (r11 != org.jctools.maps.NonBlockingIdentityHashMap.MATCH_ANY) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x017d, code lost:
        if (r18 == org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0182, code lost:
        if (r18 != null) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0187, code lost:
        if (r18 != null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x018f, code lost:
        if (r11 == org.jctools.maps.NonBlockingIdentityHashMap.TOMBSTONE) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0194, code lost:
        if (r11 == null) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x019e, code lost:
        if (r11.equals(r18) != false) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a3, code lost:
        if (r18 != null) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01ae, code lost:
        return r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b8, code lost:
        if (CAS_val(r8, r15, r18, r10) == false) goto L_0x01be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01be, code lost:
        r18 = val(r8, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01cb, code lost:
        if ((r18 instanceof org.jctools.maps.NonBlockingIdentityHashMap.Prime) == false) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e1, code lost:
        return putIfMatch0(r7, r0.copy_slot_and_check(r7, r8, r15, r11), r9, r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01e2, code lost:
        r0 = org.jctools.maps.NonBlockingHashMap.DUMMY_VOLATILE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.Object putIfMatch0(org.jctools.maps.NonBlockingIdentityHashMap r7, java.lang.Object[] r8, java.lang.Object r9, java.lang.Object r10, java.lang.Object r11) {
        /*
        // Method dump skipped, instructions count: 574
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.maps.NonBlockingIdentityHashMap.putIfMatch0(org.jctools.maps.NonBlockingIdentityHashMap, java.lang.Object[], java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    private final Object[] help_copy(Object[] helper) {
        Object[] topkvs = this._kvs;
        CHM topchm = chm(topkvs);
        if (topchm._newkvs == null) {
            return helper;
        }
        topchm.help_copy_impl(this, topkvs, false);
        return helper;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingIdentityHashMap$CHM.class */
    public static final class CHM<TypeK, TypeV> {
        private final ConcurrentAutoTable _size;
        volatile Object[] _newkvs;
        private static final AtomicReferenceFieldUpdater<CHM, Object[]> _newkvsUpdater;
        volatile long _resizers;
        private static final AtomicLongFieldUpdater<CHM> _resizerUpdater;
        private static final AtomicLongFieldUpdater<CHM> _copyIdxUpdater;
        private static final AtomicLongFieldUpdater<CHM> _copyDoneUpdater;
        static final /* synthetic */ boolean $assertionsDisabled;
        volatile long _copyIdx = 0;
        volatile long _copyDone = 0;
        private final ConcurrentAutoTable _slots = new ConcurrentAutoTable();

        static {
            $assertionsDisabled = !NonBlockingIdentityHashMap.class.desiredAssertionStatus();
            _newkvsUpdater = AtomicReferenceFieldUpdater.newUpdater(CHM.class, Object[].class, "_newkvs");
            _resizerUpdater = AtomicLongFieldUpdater.newUpdater(CHM.class, "_resizers");
            _copyIdxUpdater = AtomicLongFieldUpdater.newUpdater(CHM.class, "_copyIdx");
            _copyDoneUpdater = AtomicLongFieldUpdater.newUpdater(CHM.class, "_copyDone");
        }

        public int size() {
            return (int) this._size.get();
        }

        public int slots() {
            return (int) this._slots.get();
        }

        boolean CAS_newkvs(Object[] newkvs) {
            while (this._newkvs == null) {
                if (_newkvsUpdater.compareAndSet(this, null, newkvs)) {
                    return true;
                }
            }
            return false;
        }

        CHM(ConcurrentAutoTable size) {
            this._size = size;
        }

        private final boolean tableFull(int reprobe_cnt, int len) {
            return reprobe_cnt >= 10 && this._slots.estimate_get() >= ((long) NonBlockingIdentityHashMap.reprobe_limit(len));
        }

        private final Object[] resize(NonBlockingIdentityHashMap topmap, Object[] kvs) {
            if ($assertionsDisabled || NonBlockingIdentityHashMap.chm(kvs) == this) {
                Object[] newkvs = this._newkvs;
                if (newkvs != null) {
                    return newkvs;
                }
                int oldlen = NonBlockingIdentityHashMap.len(kvs);
                int sz = size();
                int newsz = sz;
                if (sz >= (oldlen >> 2)) {
                    newsz = oldlen << 1;
                    if (sz >= (oldlen >> 1)) {
                        newsz = oldlen << 2;
                    }
                }
                long tm = System.currentTimeMillis();
                if (newsz <= oldlen && tm <= topmap._last_resize_milli + AbstractComponentTracker.LINGERING_TIMEOUT && this._slots.estimate_get() >= ((long) (sz << 1))) {
                    newsz = oldlen << 1;
                }
                if (newsz < oldlen) {
                    newsz = oldlen;
                }
                int log2 = 3;
                while ((1 << log2) < newsz) {
                    log2++;
                }
                long r = this._resizers;
                while (!_resizerUpdater.compareAndSet(this, r, r + 1)) {
                    r = this._resizers;
                }
                int megs = ((((1 << log2) << 1) + 4) << 3) >> 20;
                if (r >= 2 && megs > 0) {
                    Object[] newkvs2 = this._newkvs;
                    if (newkvs2 != null) {
                        return newkvs2;
                    }
                    try {
                        Thread.sleep(8 * ((long) megs));
                    } catch (Exception e) {
                    }
                }
                Object[] newkvs3 = this._newkvs;
                if (newkvs3 != null) {
                    return newkvs3;
                }
                Object[] newkvs4 = new Object[((1 << log2) << 1) + 2];
                newkvs4[0] = new CHM(this._size);
                newkvs4[1] = new int[1 << log2];
                if (this._newkvs != null) {
                    return this._newkvs;
                }
                if (CAS_newkvs(newkvs4)) {
                    topmap.rehash();
                } else {
                    newkvs4 = this._newkvs;
                }
                return newkvs4;
            }
            throw new AssertionError();
        }

        private final void help_copy_impl(NonBlockingIdentityHashMap topmap, Object[] oldkvs, boolean copy_all) {
            if ($assertionsDisabled || NonBlockingIdentityHashMap.chm(oldkvs) == this) {
                Object[] newkvs = this._newkvs;
                if ($assertionsDisabled || newkvs != null) {
                    int oldlen = NonBlockingIdentityHashMap.len(oldkvs);
                    int MIN_COPY_WORK = Math.min(oldlen, 1024);
                    int panic_start = -1;
                    int copyidx = -9999;
                    while (this._copyDone < ((long) oldlen)) {
                        if (panic_start == -1) {
                            long j = this._copyIdx;
                            while (true) {
                                copyidx = (int) j;
                                if (copyidx >= (oldlen << 1) || _copyIdxUpdater.compareAndSet(this, (long) copyidx, (long) (copyidx + MIN_COPY_WORK))) {
                                    break;
                                }
                                j = this._copyIdx;
                            }
                            if (copyidx >= (oldlen << 1)) {
                                panic_start = copyidx;
                            }
                        }
                        int workdone = 0;
                        for (int i = 0; i < MIN_COPY_WORK; i++) {
                            if (copy_slot(topmap, (copyidx + i) & (oldlen - 1), oldkvs, newkvs)) {
                                workdone++;
                            }
                        }
                        if (workdone > 0) {
                            copy_check_and_promote(topmap, oldkvs, workdone);
                        }
                        copyidx += MIN_COPY_WORK;
                        if (!copy_all && panic_start == -1) {
                            return;
                        }
                    }
                    copy_check_and_promote(topmap, oldkvs, 0);
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }

        private final Object[] copy_slot_and_check(NonBlockingIdentityHashMap topmap, Object[] oldkvs, int idx, Object should_help) {
            if ($assertionsDisabled || NonBlockingIdentityHashMap.chm(oldkvs) == this) {
                Object[] newkvs = this._newkvs;
                if ($assertionsDisabled || newkvs != null) {
                    if (copy_slot(topmap, idx, oldkvs, this._newkvs)) {
                        copy_check_and_promote(topmap, oldkvs, 1);
                    }
                    return should_help == null ? newkvs : topmap.help_copy(newkvs);
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [long] */
        /* JADX WARN: Type inference failed for: r0v18, types: [long] */
        private final void copy_check_and_promote(NonBlockingIdentityHashMap topmap, Object[] oldkvs, int workdone) {
            if ($assertionsDisabled || NonBlockingIdentityHashMap.chm(oldkvs) == this) {
                int oldlen = NonBlockingIdentityHashMap.len(oldkvs);
                char c = this._copyDone;
                if ($assertionsDisabled || c + ((long) workdone) <= ((long) oldlen)) {
                    if (workdone > 0) {
                        while (!_copyDoneUpdater.compareAndSet(this, c, c + ((long) workdone))) {
                            c = this._copyDone;
                            if (!$assertionsDisabled && c + ((long) workdone) > ((long) oldlen)) {
                                throw new AssertionError();
                            }
                        }
                    }
                    if (c + ((long) workdone) == ((long) oldlen) && topmap._kvs == oldkvs && topmap.CAS_kvs(oldkvs, this._newkvs)) {
                        topmap._last_resize_milli = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }

        private boolean copy_slot(NonBlockingIdentityHashMap topmap, int idx, Object[] oldkvs, Object[] newkvs) {
            Object key;
            while (true) {
                key = NonBlockingIdentityHashMap.key(oldkvs, idx);
                if (key != null) {
                    break;
                }
                NonBlockingIdentityHashMap.CAS_key(oldkvs, idx, null, NonBlockingIdentityHashMap.TOMBSTONE);
            }
            Object oldval = NonBlockingIdentityHashMap.val(oldkvs, idx);
            while (true) {
                if (oldval instanceof Prime) {
                    break;
                }
                Object box = (oldval == null || oldval == NonBlockingIdentityHashMap.TOMBSTONE) ? NonBlockingIdentityHashMap.TOMBPRIME : new Prime(oldval);
                if (!NonBlockingIdentityHashMap.CAS_val(oldkvs, idx, oldval, box)) {
                    oldval = NonBlockingIdentityHashMap.val(oldkvs, idx);
                } else if (box == NonBlockingIdentityHashMap.TOMBPRIME) {
                    return true;
                } else {
                    oldval = box;
                }
            }
            if (oldval == NonBlockingIdentityHashMap.TOMBPRIME) {
                return false;
            }
            Object old_unboxed = ((Prime) oldval).f3156_V;
            if ($assertionsDisabled || old_unboxed != NonBlockingIdentityHashMap.TOMBSTONE) {
                NonBlockingIdentityHashMap.putIfMatch0(topmap, newkvs, key, old_unboxed, null);
                while (oldval != NonBlockingIdentityHashMap.TOMBPRIME && !NonBlockingIdentityHashMap.CAS_val(oldkvs, idx, oldval, NonBlockingIdentityHashMap.TOMBPRIME)) {
                    oldval = NonBlockingIdentityHashMap.val(oldkvs, idx);
                }
                return oldval != NonBlockingIdentityHashMap.TOMBPRIME;
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingIdentityHashMap$SnapshotV.class */
    public class SnapshotV implements Iterator<TypeV>, Enumeration<TypeV> {
        final Object[] _sskvs;
        private int _idx;
        private Object _nextK;
        private Object _prevK;
        private TypeV _nextV;
        private TypeV _prevV;

        public SnapshotV() {
            while (true) {
                Object[] topkvs = NonBlockingIdentityHashMap.this._kvs;
                CHM topchm = NonBlockingIdentityHashMap.chm(topkvs);
                if (topchm._newkvs == null) {
                    this._sskvs = topkvs;
                    next();
                    return;
                }
                topchm.help_copy_impl(NonBlockingIdentityHashMap.this, topkvs, true);
            }
        }

        int length() {
            return NonBlockingIdentityHashMap.len(this._sskvs);
        }

        Object key(int idx) {
            return NonBlockingIdentityHashMap.key(this._sskvs, idx);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this._nextV != null;
        }

        @Override // java.util.Iterator
        public TypeV next() {
            if (this._idx == 0 || this._nextV != null) {
                this._prevK = this._nextK;
                this._prevV = this._nextV;
                this._nextV = null;
                while (this._idx < length()) {
                    int i = this._idx;
                    this._idx = i + 1;
                    this._nextK = key(i);
                    if (!(this._nextK == null || this._nextK == NonBlockingIdentityHashMap.TOMBSTONE)) {
                        TypeV typev = (TypeV) NonBlockingIdentityHashMap.this.get(this._nextK);
                        this._nextV = typev;
                        if (typev != null) {
                            break;
                        }
                    }
                }
                return this._prevV;
            }
            throw new NoSuchElementException();
        }

        public void removeKey() {
            if (this._prevV == null) {
                throw new IllegalStateException();
            }
            NonBlockingIdentityHashMap.this.putIfMatch(this._prevK, NonBlockingIdentityHashMap.TOMBSTONE, NonBlockingIdentityHashMap.NO_MATCH_OLD);
            this._prevV = null;
        }

        @Override // java.util.Iterator
        public void remove() {
            removeKey();
        }

        @Override // java.util.Enumeration
        public TypeV nextElement() {
            return (TypeV) next();
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return hasNext();
        }
    }

    public Enumeration<TypeV> elements() {
        return new SnapshotV();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<TypeV> values() {
        return new AbstractCollection<TypeV>() { // from class: org.jctools.maps.NonBlockingIdentityHashMap.1
            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                NonBlockingIdentityHashMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return NonBlockingIdentityHashMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean contains(Object v) {
                return NonBlockingIdentityHashMap.this.containsValue(v);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<TypeV> iterator() {
                return new SnapshotV();
            }
        };
    }

    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingIdentityHashMap$SnapshotK.class */
    private class SnapshotK implements Iterator<TypeK>, Enumeration<TypeK> {
        final NonBlockingIdentityHashMap<TypeK, TypeV>.SnapshotV _ss;

        public SnapshotK() {
            this._ss = new SnapshotV();
        }

        @Override // java.util.Iterator
        public void remove() {
            this._ss.removeKey();
        }

        @Override // java.util.Iterator
        public TypeK next() {
            this._ss.next();
            return (TypeK) ((SnapshotV) this._ss)._prevK;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this._ss.hasNext();
        }

        @Override // java.util.Enumeration
        public TypeK nextElement() {
            return (TypeK) next();
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return hasNext();
        }
    }

    public Enumeration<TypeK> keys() {
        return new SnapshotK();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<TypeK> keySet() {
        return new AbstractSet<TypeK>() { // from class: org.jctools.maps.NonBlockingIdentityHashMap.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                NonBlockingIdentityHashMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return NonBlockingIdentityHashMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object k) {
                return NonBlockingIdentityHashMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object k) {
                return NonBlockingIdentityHashMap.this.remove(k) != null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<TypeK> iterator() {
                return new SnapshotK();
            }
        };
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingIdentityHashMap$NBHMEntry.class */
    public class NBHMEntry extends AbstractEntry<TypeK, TypeV> {
        NBHMEntry(TypeK k, TypeV v) {
            super(k, v);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: org.jctools.maps.NonBlockingIdentityHashMap */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map.Entry
        public TypeV setValue(TypeV val) {
            if (val == null) {
                throw new NullPointerException();
            }
            this._val = val;
            return (TypeV) NonBlockingIdentityHashMap.this.put(this._key, val);
        }
    }

    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingIdentityHashMap$SnapshotE.class */
    private class SnapshotE implements Iterator<Map.Entry<TypeK, TypeV>> {
        final NonBlockingIdentityHashMap<TypeK, TypeV>.SnapshotV _ss;

        public SnapshotE() {
            this._ss = new SnapshotV();
        }

        @Override // java.util.Iterator
        public void remove() {
            this._ss.removeKey();
        }

        @Override // java.util.Iterator
        public Map.Entry<TypeK, TypeV> next() {
            this._ss.next();
            return new NBHMEntry(((SnapshotV) this._ss)._prevK, ((SnapshotV) this._ss)._prevV);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this._ss.hasNext();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<TypeK, TypeV>> entrySet() {
        return new AbstractSet<Map.Entry<TypeK, TypeV>>() { // from class: org.jctools.maps.NonBlockingIdentityHashMap.3
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                NonBlockingIdentityHashMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return NonBlockingIdentityHashMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object o) {
                if (!(o instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> e = (Map.Entry) o;
                return NonBlockingIdentityHashMap.this.remove(e.getKey(), e.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object o) {
                if (!(o instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> e = (Map.Entry) o;
                Object obj = NonBlockingIdentityHashMap.this.get(e.getKey());
                return obj != null && obj.equals(e.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<TypeK, TypeV>> iterator() {
                return new SnapshotE();
            }
        };
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (Object K : keySet()) {
            Object V = get(K);
            s.writeObject(K);
            s.writeObject(V);
        }
        s.writeObject(null);
        s.writeObject(null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: org.jctools.maps.NonBlockingIdentityHashMap<TypeK, TypeV> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        initialize(8);
        while (true) {
            Object readObject = s.readObject();
            Object readObject2 = s.readObject();
            if (readObject != null) {
                put(readObject, readObject2);
            } else {
                return;
            }
        }
    }
}
