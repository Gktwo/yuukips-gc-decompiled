package org.jctools.maps;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jctools.util.UnsafeAccess;

/* loaded from: grasscutter.jar:org/jctools/maps/ConcurrentAutoTable.class */
public class ConcurrentAutoTable implements Serializable {
    private volatile CAT _cat = new CAT(null, 16, 0);
    private static AtomicReferenceFieldUpdater<ConcurrentAutoTable, CAT> _catUpdater = AtomicReferenceFieldUpdater.newUpdater(ConcurrentAutoTable.class, CAT.class, "_cat");

    public void add(long x) {
        add_if(x);
    }

    public void decrement() {
        add_if(-1);
    }

    public void increment() {
        add_if(1);
    }

    public void set(long x) {
        do {
        } while (!CAS_cat(this._cat, new CAT(null, 4, x)));
    }

    public long get() {
        return this._cat.sum();
    }

    public int intValue() {
        return (int) this._cat.sum();
    }

    public long longValue() {
        return this._cat.sum();
    }

    public long estimate_get() {
        return this._cat.estimate_sum();
    }

    @Override // java.lang.Object
    public String toString() {
        return this._cat.toString();
    }

    public void print() {
        this._cat.print();
    }

    public int internal_size() {
        return this._cat.f3188_t.length;
    }

    private long add_if(long x) {
        return this._cat.add_if(x, hash(), this);
    }

    private boolean CAS_cat(CAT oldcat, CAT newcat) {
        return _catUpdater.compareAndSet(this, oldcat, newcat);
    }

    private static int hash() {
        return System.identityHashCode(Thread.currentThread()) << 3;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jctools/maps/ConcurrentAutoTable$CAT.class */
    public static class CAT implements Serializable {
        private static final int _Lbase;
        private static final int _Lscale;
        private final CAT _next;
        private volatile long _fuzzy_sum_cache;
        private volatile long _fuzzy_time;
        private static final int MAX_SPIN = 1;

        /* renamed from: _t */
        private final long[] f3188_t;
        static final /* synthetic */ boolean $assertionsDisabled;

        /*  JADX ERROR: Dependency scan failed at insn: 0x000B: INVOKE_CUSTOM r0, r0
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
        /*  JADX ERROR: Dependency scan failed at insn: 0x0021: INVOKE_CUSTOM r-1, r0
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
        /*  JADX ERROR: Failed to decode insn: 0x000B: INVOKE_CUSTOM r1, r0, method: org.jctools.maps.ConcurrentAutoTable.CAT.print():void
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, []}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, []}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        /*  JADX ERROR: Failed to decode insn: 0x0021: INVOKE_CUSTOM r1, r0, method: org.jctools.maps.ConcurrentAutoTable.CAT.print():void
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, ,]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, ,]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public void print() {
            /*
                r4 = this;
                r0 = r4
                long[] r0 = r0.f3188_t
                r5 = r0
                java.io.PrintStream r0 = java.lang.System.out
                r1 = r5
                r2 = 0
                r1 = r1[r2]
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, []}
                r0.print(r1)
                r0 = 1
                r6 = r0
                r0 = r6
                r1 = r5
                int r1 = r1.length
                if (r0 >= r1) goto L_0x002f
                java.io.PrintStream r0 = java.lang.System.out
                r1 = r5
                r2 = r6
                r1 = r1[r2]
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, ,]}
                r0.print(r1)
                int r6 = r6 + 1
                goto L_0x0015
                java.io.PrintStream r0 = java.lang.System.out
                java.lang.String r1 = "]"
                r0.print(r1)
                r0 = r4
                org.jctools.maps.ConcurrentAutoTable$CAT r0 = r0._next
                if (r0 == 0) goto L_0x0045
                r0 = r4
                org.jctools.maps.ConcurrentAutoTable$CAT r0 = r0._next
                r0.print()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jctools.maps.ConcurrentAutoTable.CAT.print():void");
        }

        static {
            $assertionsDisabled = !ConcurrentAutoTable.class.desiredAssertionStatus();
            _Lbase = UnsafeAccess.UNSAFE.arrayBaseOffset(long[].class);
            _Lscale = UnsafeAccess.UNSAFE.arrayIndexScale(long[].class);
        }

        private static long rawIndex(long[] ary, int i) {
            if ($assertionsDisabled || (i >= 0 && i < ary.length)) {
                return ((long) _Lbase) + (((long) i) * ((long) _Lscale));
            }
            throw new AssertionError();
        }

        private static boolean CAS(long[] A, int idx, long old, long nnn) {
            return UnsafeAccess.UNSAFE.compareAndSwapLong(A, rawIndex(A, idx), old, nnn);
        }

        CAT(CAT next, int sz, long init) {
            this._next = next;
            this.f3188_t = new long[sz];
            this.f3188_t[0] = init;
        }

        public long add_if(long x, int hash, ConcurrentAutoTable master) {
            long old;
            long[] t = this.f3188_t;
            int idx = hash & (t.length - 1);
            long old2 = t[idx];
            if (CAS(t, idx, old2, old2 + x)) {
                return old2;
            }
            int cnt = 0;
            while (true) {
                old = t[idx];
                if (CAS(t, idx, old, old + x)) {
                    break;
                }
                cnt++;
            }
            if (cnt >= 1 && t.length < 1048576 && master._cat == this) {
                CAT newcat = new CAT(this, t.length * 2, 0);
                while (master._cat == this && !master.CAS_cat(this, newcat)) {
                }
                return old;
            }
            return old;
        }

        public long sum() {
            long sum = this._next == null ? 0 : this._next.sum();
            for (long cnt : this.f3188_t) {
                sum += cnt;
            }
            return sum;
        }

        public long estimate_sum() {
            if (this.f3188_t.length <= 64) {
                return sum();
            }
            long millis = System.currentTimeMillis();
            if (this._fuzzy_time != millis) {
                this._fuzzy_sum_cache = sum();
                this._fuzzy_time = millis;
            }
            return this._fuzzy_sum_cache;
        }

        @Override // java.lang.Object
        public String toString() {
            return Long.toString(sum());
        }
    }
}
