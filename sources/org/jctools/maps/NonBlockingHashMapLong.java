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

/* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingHashMapLong.class */
public class NonBlockingHashMapLong<TypeV> extends AbstractMap<Long, TypeV> implements ConcurrentMap<Long, TypeV>, Serializable {
    private static final long serialVersionUID = 1234123412341234124L;
    private static final int REPROBE_LIMIT = 10;
    private static final int _Obase;
    private static final int _Oscale;
    private static final int _Lbase;
    private static final int _Lscale;
    private static final long _chm_offset;
    private static final long _val_1_offset;
    private transient CHM _chm;
    private transient Object _val_1;
    private transient long _last_resize_milli;
    private final boolean _opt_for_space;
    private static final int MIN_SIZE_LOG = 4;
    private static final int MIN_SIZE = 16;
    private static final Object NO_MATCH_OLD;
    private static final Object MATCH_ANY;
    private static final Object TOMBSTONE;
    private static final Prime TOMBPRIME;
    private static final long NO_KEY = 0;
    static final /* synthetic */ boolean $assertionsDisabled;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0033: INVOKE_CUSTOM r-2, r-1, r0, r0, r1
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
    /*  JADX ERROR: Failed to decode insn: 0x0033: INVOKE_CUSTOM r1, r2, r0, r3, r4, method: org.jctools.maps.NonBlockingHashMapLong.print_impl(int, long, java.lang.Object):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, J, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, []=(,)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, J, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, []=(,)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void print_impl(int r7, long r8, java.lang.Object r10) {
        /*
            r0 = r10
            boolean r0 = r0 instanceof org.jctools.maps.NonBlockingHashMapLong.Prime
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "prime_"
            goto L_0x000e
            java.lang.String r0 = ""
            r11 = r0
            r0 = r10
            java.lang.Object r0 = org.jctools.maps.NonBlockingHashMapLong.Prime.unbox(r0)
            r12 = r0
            r0 = r12
            java.lang.Object r1 = org.jctools.maps.NonBlockingHashMapLong.TOMBSTONE
            if (r0 != r1) goto L_0x0023
            java.lang.String r0 = "tombstone"
            goto L_0x0028
            r0 = r12
            java.lang.String r0 = r0.toString()
            r13 = r0
            java.io.PrintStream r0 = java.lang.System.out
            r1 = r7
            r2 = r8
            r3 = r11
            r4 = r13
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, J, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, []=(,)]}
            r0.println(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.maps.NonBlockingHashMapLong.print_impl(int, long, java.lang.Object):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((Long) obj, (Long) obj2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* bridge */ /* synthetic */ Object replace(Long l, Object obj) {
        return replace(l, (Long) obj);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* bridge */ /* synthetic */ Object putIfAbsent(Long l, Object obj) {
        return putIfAbsent(l, (Long) obj);
    }

    static {
        $assertionsDisabled = !NonBlockingHashMapLong.class.desiredAssertionStatus();
        _Obase = UnsafeAccess.UNSAFE.arrayBaseOffset(Object[].class);
        _Oscale = UnsafeAccess.UNSAFE.arrayIndexScale(Object[].class);
        _Lbase = UnsafeAccess.UNSAFE.arrayBaseOffset(long[].class);
        _Lscale = UnsafeAccess.UNSAFE.arrayIndexScale(long[].class);
        _chm_offset = UnsafeAccess.fieldOffset(NonBlockingHashMapLong.class, "_chm");
        _val_1_offset = UnsafeAccess.fieldOffset(NonBlockingHashMapLong.class, "_val_1");
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

    private static long rawIndex(long[] ary, int idx) {
        if ($assertionsDisabled || (idx >= 0 && idx < ary.length)) {
            return ((long) _Lbase) + (((long) idx) * ((long) _Lscale));
        }
        throw new AssertionError();
    }

    private final boolean CAS(long offset, Object old, Object nnn) {
        return UnsafeAccess.UNSAFE.compareAndSwapObject(this, offset, old, nnn);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingHashMapLong$Prime.class */
    public static final class Prime {

        /* renamed from: _V */
        final Object f3154_V;

        Prime(Object V) {
            this.f3154_V = V;
        }

        static Object unbox(Object V) {
            return V instanceof Prime ? ((Prime) V).f3154_V : V;
        }
    }

    public final void print() {
        System.out.println("=========");
        print_impl(-99, 0, this._val_1);
        this._chm.print();
        System.out.println("=========");
    }

    private void print2() {
        System.out.println("=========");
        print2_impl(-99, 0, this._val_1);
        this._chm.print();
        System.out.println("=========");
    }

    private static void print2_impl(int i, long K, Object V) {
        if (V != null && Prime.unbox(V) != TOMBSTONE) {
            print_impl(i, K, V);
        }
    }

    private static int reprobe_limit(int len) {
        return 10 + (len >> 4);
    }

    public NonBlockingHashMapLong() {
        this(16, true);
    }

    public NonBlockingHashMapLong(int initial_sz) {
        this(initial_sz, true);
    }

    public NonBlockingHashMapLong(boolean opt_for_space) {
        this(1, opt_for_space);
    }

    public NonBlockingHashMapLong(int initial_sz, boolean opt_for_space) {
        this._opt_for_space = opt_for_space;
        initialize(initial_sz);
    }

    private void initialize(int initial_sz) {
        RangeUtil.checkPositiveOrZero(initial_sz, "initial_sz");
        int i = 4;
        while ((1 << i) < initial_sz) {
            i++;
        }
        this._chm = new CHM(this, new ConcurrentAutoTable(), i);
        this._val_1 = TOMBSTONE;
        this._last_resize_milli = System.currentTimeMillis();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return (this._val_1 == TOMBSTONE ? 0 : 1) + this._chm.size();
    }

    public boolean containsKey(long key) {
        return get(key) != null;
    }

    public boolean contains(Object val) {
        return containsValue(val);
    }

    public TypeV put(long key, TypeV val) {
        return putIfMatch(key, val, NO_MATCH_OLD);
    }

    public TypeV putIfAbsent(long key, TypeV val) {
        return putIfMatch(key, val, TOMBSTONE);
    }

    public TypeV remove(long key) {
        return putIfMatch(key, TOMBSTONE, NO_MATCH_OLD);
    }

    public boolean remove(long key, Object val) {
        return putIfMatch(key, TOMBSTONE, val) == val;
    }

    public TypeV replace(long key, TypeV val) {
        return putIfMatch(key, val, MATCH_ANY);
    }

    public boolean replace(long key, TypeV oldValue, TypeV newValue) {
        return putIfMatch(key, newValue, oldValue) == oldValue;
    }

    private TypeV putIfMatch(long key, Object newVal, Object oldVal) {
        if (oldVal == null || newVal == null) {
            throw new NullPointerException();
        } else if (key == 0) {
            Object curVal = (TypeV) this._val_1;
            if ((oldVal == NO_MATCH_OLD || curVal == oldVal || ((oldVal == MATCH_ANY && curVal != TOMBSTONE) || oldVal.equals(curVal))) && !CAS(_val_1_offset, curVal, newVal)) {
                curVal = (TypeV) this._val_1;
            }
            if (curVal == TOMBSTONE) {
                return null;
            }
            return (TypeV) curVal;
        } else {
            TypeV typev = (TypeV) this._chm.putIfMatch(key, newVal, oldVal);
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
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        do {
        } while (!CAS(_chm_offset, this._chm, new CHM(this, new ConcurrentAutoTable(), 4)));
        CAS(_val_1_offset, this._val_1, TOMBSTONE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023  */
    @Override // java.util.AbstractMap, java.util.Map
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsValue(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = r4
            if (r0 != 0) goto L_0x0006
            r0 = 0
            return r0
        L_0x0006:
            r0 = r4
            r1 = r3
            java.lang.Object r1 = r1._val_1
            if (r0 != r1) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = r3
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
        L_0x001a:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x003c
            r0 = r5
            java.lang.Object r0 = r0.next()
            r6 = r0
            r0 = r6
            r1 = r4
            if (r0 == r1) goto L_0x0037
            r0 = r6
            r1 = r4
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0039
        L_0x0037:
            r0 = 1
            return r0
        L_0x0039:
            goto L_0x001a
        L_0x003c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.maps.NonBlockingHashMapLong.containsValue(java.lang.Object):boolean");
    }

    public final TypeV get(long key) {
        if (key == 0) {
            TypeV typev = (TypeV) this._val_1;
            if (typev == TOMBSTONE) {
                return null;
            }
            return typev;
        }
        TypeV typev2 = (TypeV) this._chm.get_impl(key);
        if (!$assertionsDisabled && (typev2 instanceof Prime)) {
            throw new AssertionError();
        } else if ($assertionsDisabled || typev2 != TOMBSTONE) {
            return typev2;
        } else {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public TypeV get(Object key) {
        if (key instanceof Long) {
            return get(((Long) key).longValue());
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public TypeV remove(Object key) {
        if (key instanceof Long) {
            return remove(((Long) key).longValue());
        }
        return null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object key, Object Val) {
        return (key instanceof Long) && remove(((Long) key).longValue(), Val);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return (key instanceof Long) && containsKey(((Long) key).longValue());
    }

    public TypeV putIfAbsent(Long key, TypeV val) {
        return putIfAbsent(key.longValue(), (long) val);
    }

    public TypeV replace(Long key, TypeV Val) {
        return replace(key.longValue(), (long) Val);
    }

    public TypeV put(Long key, TypeV val) {
        return put(key.longValue(), (long) val);
    }

    public boolean replace(Long key, TypeV oldValue, TypeV newValue) {
        return replace(key.longValue(), oldValue, newValue);
    }

    private void help_copy() {
        CHM topchm = this._chm;
        if (topchm._newchm != null) {
            topchm.help_copy_impl(false);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingHashMapLong$CHM.class */
    public static final class CHM implements Serializable {
        final NonBlockingHashMapLong _nbhml;
        private final ConcurrentAutoTable _size;
        volatile CHM _newchm;
        private static final AtomicReferenceFieldUpdater<CHM, CHM> _newchmUpdater;
        volatile long _resizers;
        private static final AtomicLongFieldUpdater<CHM> _resizerUpdater;
        final long[] _keys;
        final Object[] _vals;
        private static final AtomicLongFieldUpdater<CHM> _copyIdxUpdater;
        private static final AtomicLongFieldUpdater<CHM> _copyDoneUpdater;
        static final /* synthetic */ boolean $assertionsDisabled;
        volatile long _copyIdx = 0;
        volatile long _copyDone = 0;
        private final ConcurrentAutoTable _slots = new ConcurrentAutoTable();

        static {
            $assertionsDisabled = !NonBlockingHashMapLong.class.desiredAssertionStatus();
            _newchmUpdater = AtomicReferenceFieldUpdater.newUpdater(CHM.class, CHM.class, "_newchm");
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

        boolean CAS_newchm(CHM newchm) {
            return _newchmUpdater.compareAndSet(this, null, newchm);
        }

        private boolean CAS_key(int idx, long old, long key) {
            return UnsafeAccess.UNSAFE.compareAndSwapLong(this._keys, NonBlockingHashMapLong.rawIndex(this._keys, idx), old, key);
        }

        private boolean CAS_val(int idx, Object old, Object val) {
            return UnsafeAccess.UNSAFE.compareAndSwapObject(this._vals, NonBlockingHashMapLong.rawIndex(this._vals, idx), old, val);
        }

        CHM(NonBlockingHashMapLong nbhml, ConcurrentAutoTable size, int logsize) {
            this._nbhml = nbhml;
            this._size = size;
            this._keys = new long[1 << logsize];
            this._vals = new Object[1 << logsize];
        }

        private void print() {
            for (int i = 0; i < this._keys.length; i++) {
                long K = this._keys[i];
                if (K != 0) {
                    NonBlockingHashMapLong.print_impl(i, K, this._vals[i]);
                }
            }
            CHM newchm = this._newchm;
            if (newchm != null) {
                System.out.println("----");
                newchm.print();
            }
        }

        private void print2() {
            for (int i = 0; i < this._keys.length; i++) {
                long K = this._keys[i];
                if (K != 0) {
                    NonBlockingHashMapLong.print2_impl(i, K, this._vals[i]);
                }
            }
            CHM newchm = this._newchm;
            if (newchm != null) {
                System.out.println("----");
                newchm.print2();
            }
        }

        private Object get_impl(long key) {
            int len = this._keys.length;
            int idx = (int) (key & ((long) (len - 1)));
            int reprobe_cnt = 0;
            while (true) {
                long K = this._keys[idx];
                Object V = this._vals[idx];
                if (K == 0) {
                    return null;
                }
                if (key != K) {
                    reprobe_cnt++;
                    if (reprobe_cnt < NonBlockingHashMapLong.reprobe_limit(len)) {
                        idx = (idx + 1) & (len - 1);
                    } else if (this._newchm == null) {
                        return null;
                    } else {
                        return copy_slot_and_check(idx, Long.valueOf(key)).get_impl(key);
                    }
                } else if (V instanceof Prime) {
                    return copy_slot_and_check(idx, Long.valueOf(key)).get_impl(key);
                } else {
                    if (V == NonBlockingHashMapLong.TOMBSTONE) {
                        return null;
                    }
                    CHM chm = this._newchm;
                    return V;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x01cb, code lost:
            r7._size.add(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d5, code lost:
            if (r17 == null) goto L_0x01f1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x01dd, code lost:
            if (r17 == org.jctools.maps.NonBlockingHashMapLong.TOMBSTONE) goto L_0x01f1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e4, code lost:
            if (r10 != org.jctools.maps.NonBlockingHashMapLong.TOMBSTONE) goto L_0x01f1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x01e7, code lost:
            r7._size.add(-1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x01f3, code lost:
            if (r17 != null) goto L_0x0201;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x01f8, code lost:
            if (r11 == null) goto L_0x0201;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x0203, code lost:
            return r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
            return org.jctools.maps.NonBlockingHashMapLong.TOMBSTONE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
            return org.jctools.maps.NonBlockingHashMapLong.TOMBSTONE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f9, code lost:
            if (r10 != r17) goto L_0x00ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fe, code lost:
            return r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0101, code lost:
            if (r17 != null) goto L_0x010f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x010c, code lost:
            if (tableFull(r14, r0) != false) goto L_0x0117;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0114, code lost:
            if ((r17 instanceof org.jctools.maps.NonBlockingHashMapLong.Prime) == false) goto L_0x012c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0117, code lost:
            resize();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x012b, code lost:
            return copy_slot_and_check(r13, r11).putIfMatch(r8, r10, r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0131, code lost:
            if (r11 == org.jctools.maps.NonBlockingHashMapLong.NO_MATCH_OLD) goto L_0x017a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0138, code lost:
            if (r17 == r11) goto L_0x017a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0140, code lost:
            if (r11 != org.jctools.maps.NonBlockingHashMapLong.MATCH_ANY) goto L_0x0150;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0148, code lost:
            if (r17 == org.jctools.maps.NonBlockingHashMapLong.TOMBSTONE) goto L_0x0150;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x014d, code lost:
            if (r17 != null) goto L_0x017a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0152, code lost:
            if (r17 != null) goto L_0x015d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x015a, code lost:
            if (r11 == org.jctools.maps.NonBlockingHashMapLong.TOMBSTONE) goto L_0x017a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x015f, code lost:
            if (r11 == null) goto L_0x016c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0169, code lost:
            if (r11.equals(r17) != false) goto L_0x017a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x016e, code lost:
            if (r17 != null) goto L_0x0177;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0179, code lost:
            return r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0183, code lost:
            if (CAS_val(r13, r17, r10) == false) goto L_0x0189;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0189, code lost:
            r17 = r7._vals[r13];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x0197, code lost:
            if ((r17 instanceof org.jctools.maps.NonBlockingHashMapLong.Prime) == false) goto L_0x01aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a9, code lost:
            return copy_slot_and_check(r13, r11).putIfMatch(r8, r10, r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x01aa, code lost:
            r0 = org.jctools.maps.NonBlockingHashMap.DUMMY_VOLATILE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x01b4, code lost:
            if (r11 == null) goto L_0x01f1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x01b9, code lost:
            if (r17 == null) goto L_0x01c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x01c1, code lost:
            if (r17 != org.jctools.maps.NonBlockingHashMapLong.TOMBSTONE) goto L_0x01d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x01c8, code lost:
            if (r10 == org.jctools.maps.NonBlockingHashMapLong.TOMBSTONE) goto L_0x01d3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.Object putIfMatch(long r8, java.lang.Object r10, java.lang.Object r11) {
            /*
            // Method dump skipped, instructions count: 516
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jctools.maps.NonBlockingHashMapLong.CHM.putIfMatch(long, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        private final boolean tableFull(int reprobe_cnt, int len) {
            return reprobe_cnt >= 10 && (reprobe_cnt >= NonBlockingHashMapLong.reprobe_limit(len) || this._slots.estimate_get() >= ((long) (len >> 1)));
        }

        private final CHM resize() {
            CHM newchm = this._newchm;
            if (newchm != null) {
                return newchm;
            }
            int oldlen = this._keys.length;
            int sz = size();
            int newsz = sz;
            if (this._nbhml._opt_for_space) {
                if (sz >= (oldlen >> 1)) {
                    newsz = oldlen << 1;
                }
            } else if (sz >= (oldlen >> 2)) {
                newsz = oldlen << 1;
                if (sz >= (oldlen >> 1)) {
                    newsz = oldlen << 2;
                }
            }
            long tm = System.currentTimeMillis();
            if (newsz <= oldlen && tm <= this._nbhml._last_resize_milli + AbstractComponentTracker.LINGERING_TIMEOUT) {
                newsz = oldlen << 1;
            }
            if (newsz < oldlen) {
                newsz = oldlen;
            }
            int log2 = 4;
            while ((1 << log2) < newsz) {
                log2++;
            }
            long len = ((1 << log2) << 1) + 2;
            if (((long) ((int) len)) != len) {
                log2 = 30;
                long len2 = (1 << 30) + 2;
                if (((long) sz) > (len2 >> 2) + (len2 >> 1)) {
                    throw new RuntimeException("Table is full.");
                }
            }
            long r = this._resizers;
            while (!_resizerUpdater.compareAndSet(this, r, r + 1)) {
                r = this._resizers;
            }
            long megs = ((((1 << log2) << 1) + 8) << 3) >> 20;
            if (r >= 2 && megs > 0) {
                CHM newchm2 = this._newchm;
                if (newchm2 != null) {
                    return newchm2;
                }
                try {
                    Thread.sleep(megs);
                } catch (Exception e) {
                }
            }
            CHM newchm3 = this._newchm;
            if (newchm3 != null) {
                return newchm3;
            }
            CHM newchm4 = new CHM(this._nbhml, this._size, log2);
            if (this._newchm != null) {
                return this._newchm;
            }
            if (!CAS_newchm(newchm4)) {
                newchm4 = this._newchm;
            }
            return newchm4;
        }

        private final void help_copy_impl(boolean copy_all) {
            CHM newchm = this._newchm;
            if ($assertionsDisabled || newchm != null) {
                int oldlen = this._keys.length;
                int MIN_COPY_WORK = Math.min(oldlen, 1024);
                int panic_start = -1;
                int copyidx = -9999;
                while (this._copyDone < ((long) oldlen)) {
                    if (panic_start == -1) {
                        long j = this._copyIdx;
                        while (true) {
                            copyidx = (int) j;
                            if (_copyIdxUpdater.compareAndSet(this, (long) copyidx, (long) (copyidx + MIN_COPY_WORK))) {
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
                        if (copy_slot((copyidx + i) & (oldlen - 1))) {
                            workdone++;
                        }
                    }
                    if (workdone > 0) {
                        copy_check_and_promote(workdone);
                    }
                    copyidx += MIN_COPY_WORK;
                    if (!copy_all && panic_start == -1) {
                        return;
                    }
                }
                copy_check_and_promote(0);
                return;
            }
            throw new AssertionError();
        }

        private CHM copy_slot_and_check(int idx, Object should_help) {
            if ($assertionsDisabled || this._newchm != null) {
                if (copy_slot(idx)) {
                    copy_check_and_promote(1);
                }
                if (should_help != null) {
                    this._nbhml.help_copy();
                }
                return this._newchm;
            }
            throw new AssertionError();
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [long] */
        /* JADX WARN: Type inference failed for: r0v21, types: [long] */
        private final void copy_check_and_promote(int workdone) {
            int oldlen = this._keys.length;
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
                if (c + ((long) workdone) == ((long) oldlen) && this._nbhml._chm == this && this._nbhml.CAS(NonBlockingHashMapLong._chm_offset, this, this._newchm)) {
                    this._nbhml._last_resize_milli = System.currentTimeMillis();
                    return;
                }
                return;
            }
            throw new AssertionError();
        }

        private boolean copy_slot(int idx) {
            long key;
            while (true) {
                key = this._keys[idx];
                if (key != 0) {
                    break;
                }
                CAS_key(idx, 0, (long) (idx + this._keys.length));
            }
            Object oldval = this._vals[idx];
            while (true) {
                if (oldval instanceof Prime) {
                    break;
                }
                Object box = (oldval == null || oldval == NonBlockingHashMapLong.TOMBSTONE) ? NonBlockingHashMapLong.TOMBPRIME : new Prime(oldval);
                if (!CAS_val(idx, oldval, box)) {
                    oldval = this._vals[idx];
                } else if (box == NonBlockingHashMapLong.TOMBPRIME) {
                    return true;
                } else {
                    oldval = box;
                }
            }
            if (oldval == NonBlockingHashMapLong.TOMBPRIME) {
                return false;
            }
            Object old_unboxed = ((Prime) oldval).f3154_V;
            if ($assertionsDisabled || old_unboxed != NonBlockingHashMapLong.TOMBSTONE) {
                this._newchm.putIfMatch(key, old_unboxed, null);
                while (oldval != NonBlockingHashMapLong.TOMBPRIME && !CAS_val(idx, oldval, NonBlockingHashMapLong.TOMBPRIME)) {
                    oldval = this._vals[idx];
                }
                return oldval != NonBlockingHashMapLong.TOMBPRIME;
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingHashMapLong$SnapshotV.class */
    public class SnapshotV implements Iterator<TypeV>, Enumeration<TypeV> {
        final CHM _sschm;
        private int _idx;
        private long _nextK;
        private long _prevK;
        private TypeV _nextV;
        private TypeV _prevV;

        public SnapshotV() {
            while (true) {
                CHM topchm = NonBlockingHashMapLong.this._chm;
                if (topchm._newchm == null) {
                    this._sschm = topchm;
                    this._idx = -1;
                    next();
                    return;
                }
                topchm.help_copy_impl(true);
            }
        }

        int length() {
            return this._sschm._keys.length;
        }

        long key(int idx) {
            return this._sschm._keys[idx];
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this._nextV != null;
        }

        @Override // java.util.Iterator
        public TypeV next() {
            if (this._idx == -1 || this._nextV != null) {
                this._prevK = this._nextK;
                this._prevV = this._nextV;
                this._nextV = null;
                if (this._idx == -1) {
                    this._idx = 0;
                    this._nextK = 0;
                    TypeV typev = (TypeV) NonBlockingHashMapLong.this.get(this._nextK);
                    this._nextV = typev;
                    if (typev != null) {
                        return this._prevV;
                    }
                }
                while (this._idx < length()) {
                    int i = this._idx;
                    this._idx = i + 1;
                    this._nextK = key(i);
                    if (this._nextK != 0) {
                        TypeV typev2 = (TypeV) NonBlockingHashMapLong.this.get(this._nextK);
                        this._nextV = typev2;
                        if (typev2 != null) {
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
            NonBlockingHashMapLong.this.putIfMatch(this._prevK, NonBlockingHashMapLong.TOMBSTONE, NonBlockingHashMapLong.NO_MATCH_OLD);
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
        return new AbstractCollection<TypeV>() { // from class: org.jctools.maps.NonBlockingHashMapLong.1
            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                NonBlockingHashMapLong.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return NonBlockingHashMapLong.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean contains(Object v) {
                return NonBlockingHashMapLong.this.containsValue(v);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<TypeV> iterator() {
                return new SnapshotV();
            }
        };
    }

    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingHashMapLong$IteratorLong.class */
    public class IteratorLong implements Iterator<Long>, Enumeration<Long> {
        private final NonBlockingHashMapLong<TypeV>.SnapshotV _ss;

        public IteratorLong() {
            this._ss = new SnapshotV();
        }

        @Override // java.util.Iterator
        public void remove() {
            this._ss.removeKey();
        }

        @Override // java.util.Iterator
        public Long next() {
            this._ss.next();
            return Long.valueOf(((SnapshotV) this._ss)._prevK);
        }

        public long nextLong() {
            this._ss.next();
            return ((SnapshotV) this._ss)._prevK;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this._ss.hasNext();
        }

        @Override // java.util.Enumeration
        public Long nextElement() {
            return next();
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return hasNext();
        }
    }

    public Enumeration<Long> keys() {
        return new IteratorLong();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Long> keySet() {
        return new AbstractSet<Long>() { // from class: org.jctools.maps.NonBlockingHashMapLong.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                NonBlockingHashMapLong.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return NonBlockingHashMapLong.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object k) {
                return NonBlockingHashMapLong.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object k) {
                return NonBlockingHashMapLong.this.remove(k) != null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public NonBlockingHashMapLong<TypeV>.IteratorLong iterator() {
                return new IteratorLong();
            }
        };
    }

    public long[] keySetLong() {
        long[] dom = new long[size()];
        NonBlockingHashMapLong<TypeV>.IteratorLong i = (IteratorLong) keySet().iterator();
        int j = 0;
        while (j < dom.length && i.hasNext()) {
            j++;
            dom[j] = i.nextLong();
        }
        return dom;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingHashMapLong$NBHMLEntry.class */
    public class NBHMLEntry extends AbstractEntry<Long, TypeV> {
        NBHMLEntry(Long k, TypeV v) {
            super(k, v);
        }

        @Override // java.util.Map.Entry
        public TypeV setValue(TypeV val) {
            if (val == null) {
                throw new NullPointerException();
            }
            this._val = val;
            return (TypeV) NonBlockingHashMapLong.this.put((Long) this._key, (Long) val);
        }
    }

    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingHashMapLong$SnapshotE.class */
    private class SnapshotE implements Iterator<Map.Entry<Long, TypeV>> {
        final NonBlockingHashMapLong<TypeV>.SnapshotV _ss;

        public SnapshotE() {
            this._ss = new SnapshotV();
        }

        @Override // java.util.Iterator
        public void remove() {
            this._ss.removeKey();
        }

        @Override // java.util.Iterator
        public Map.Entry<Long, TypeV> next() {
            this._ss.next();
            return new NBHMLEntry(Long.valueOf(((SnapshotV) this._ss)._prevK), ((SnapshotV) this._ss)._prevV);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this._ss.hasNext();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Long, TypeV>> entrySet() {
        return new AbstractSet<Map.Entry<Long, TypeV>>() { // from class: org.jctools.maps.NonBlockingHashMapLong.3
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                NonBlockingHashMapLong.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return NonBlockingHashMapLong.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object o) {
                if (!(o instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> e = (Map.Entry) o;
                return NonBlockingHashMapLong.this.remove(e.getKey(), e.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object o) {
                if (!(o instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> e = (Map.Entry) o;
                Object obj = NonBlockingHashMapLong.this.get(e.getKey());
                return obj != null && obj.equals(e.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<Long, TypeV>> iterator() {
                return new SnapshotE();
            }
        };
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (Long l : keySet()) {
            long K = l.longValue();
            Object V = get(K);
            s.writeLong(K);
            s.writeObject(V);
        }
        s.writeLong(0);
        s.writeObject(null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: org.jctools.maps.NonBlockingHashMapLong<TypeV> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        initialize(16);
        while (true) {
            long K = s.readLong();
            Object readObject = s.readObject();
            if (K != 0 || readObject != null) {
                put(K, (long) readObject);
            } else {
                return;
            }
        }
    }
}
