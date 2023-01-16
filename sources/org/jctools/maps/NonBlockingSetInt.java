package org.jctools.maps;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import org.jctools.util.RangeUtil;
import org.jctools.util.UnsafeAccess;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingSetInt.class */
public class NonBlockingSetInt extends AbstractSet<Integer> implements Serializable {
    private static final long serialVersionUID = 1234123412341234123L;
    private static final long _nbsi_offset = UnsafeAccess.fieldOffset(NonBlockingSetInt.class, "_nbsi");
    private transient NBSI _nbsi = new NBSI(63, new ConcurrentAutoTable(), this);

    private final boolean CAS_nbsi(NBSI old, NBSI nnn) {
        return UnsafeAccess.UNSAFE.compareAndSwapObject(this, _nbsi_offset, old, nnn);
    }

    public boolean add(Integer i) {
        return add(i.intValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o) {
        return (o instanceof Integer) && contains(((Integer) o).intValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o) {
        return (o instanceof Integer) && remove(((Integer) o).intValue());
    }

    public boolean add(int i) {
        RangeUtil.checkPositiveOrZero(i, IntegerTokenConverter.CONVERTER_KEY);
        return this._nbsi.add(i);
    }

    public boolean contains(int i) {
        return i >= 0 && this._nbsi.contains(i);
    }

    public boolean remove(int i) {
        return i >= 0 && this._nbsi.remove(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this._nbsi.size();
    }

    public int length() {
        return this._nbsi._bits.length << 6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        do {
        } while (!CAS_nbsi(this._nbsi, new NBSI(63, new ConcurrentAutoTable(), this)));
    }

    public void print() {
        this._nbsi.print(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new iter();
    }

    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingSetInt$iter.class */
    private class iter implements Iterator<Integer> {
        NBSI _nbsi2;
        int _idx = -1;
        int _prev = -1;

        iter() {
            this._nbsi2 = NonBlockingSetInt.this._nbsi;
            advance();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this._idx != -2;
        }

        private void advance() {
            do {
                this._idx++;
                while ((this._idx >> 6) >= this._nbsi2._bits.length) {
                    if (this._nbsi2._new == null) {
                        this._idx = -2;
                        return;
                    }
                    this._nbsi2 = this._nbsi2._new;
                }
            } while (!this._nbsi2.contains(this._idx));
        }

        @Override // java.util.Iterator
        public Integer next() {
            if (this._idx == -1) {
                throw new NoSuchElementException();
            }
            this._prev = this._idx;
            advance();
            return Integer.valueOf(this._prev);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this._prev == -1) {
                throw new IllegalStateException();
            }
            this._nbsi2.remove(this._prev);
            this._prev = -1;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        NBSI nbsi = this._nbsi;
        int len = this._nbsi._bits.length << 6;
        s.writeInt(len);
        for (int i = 0; i < len; i++) {
            s.writeBoolean(this._nbsi.contains(i));
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int len = s.readInt();
        this._nbsi = new NBSI(len, new ConcurrentAutoTable(), this);
        for (int i = 0; i < len; i++) {
            if (s.readBoolean()) {
                this._nbsi.add(i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jctools/maps/NonBlockingSetInt$NBSI.class */
    public static final class NBSI {
        private final transient NonBlockingSetInt _non_blocking_set_int;
        private final transient ConcurrentAutoTable _size;
        private final long[] _bits;
        private static final int _Lbase;
        private static final int _Lscale;
        private NBSI _new;
        private static final long _new_offset;
        private final transient AtomicInteger _copyIdx;
        private final transient AtomicInteger _copyDone;
        private final transient int _sum_bits_length;
        private final NBSI _nbsi64;
        static final /* synthetic */ boolean $assertionsDisabled;

        /*  JADX ERROR: Dependency scan failed at insn: 0x001B: INVOKE_CUSTOM r-2
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
        /*  JADX ERROR: Dependency scan failed at insn: 0x0055: INVOKE_CUSTOM r-5
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
        /*  JADX ERROR: Dependency scan failed at insn: 0x0099: INVOKE_CUSTOM r-9, r-8, r-7
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
        /*  JADX ERROR: Failed to decode insn: 0x001B: INVOKE_CUSTOM r1, method: org.jctools.maps.NonBlockingSetInt.NBSI.print(int):void
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;},  ]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;},  ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        /*  JADX ERROR: Failed to decode insn: 0x0055: INVOKE_CUSTOM r1, method: org.jctools.maps.NonBlockingSetInt.NBSI.print(int):void
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;},  ]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;},  ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        /*  JADX ERROR: Failed to decode insn: 0x0099: INVOKE_CUSTOM r2, r3, r4, method: org.jctools.maps.NonBlockingSetInt.NBSI.print(int):void
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, _copyIdx= _copyDone= _words_to_cpy=]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, _copyIdx= _copyDone= _words_to_cpy=]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        private void print(int r7) {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = r0
                r1.<init>()
                r8 = r0
                r0 = r8
                java.lang.String r1 = "NBSI - _bits.len="
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r6
                r9 = r0
                r0 = r9
                if (r0 == 0) goto L_0x002c
                r0 = r8
                r1 = r9
                long[] r1 = r1._bits
                int r1 = r1.length
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;},  ]}
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r9
                org.jctools.maps.NonBlockingSetInt$NBSI r0 = r0._nbsi64
                r9 = r0
                goto L_0x0011
                r0 = r6
                r1 = r7
                r2 = r8
                java.lang.String r2 = r2.toString()
                r0.print(r1, r2)
                r0 = r6
                r9 = r0
                r0 = r9
                if (r0 == 0) goto L_0x0071
                r0 = 0
                r10 = r0
                r0 = r10
                r1 = r9
                long[] r1 = r1._bits
                int r1 = r1.length
                if (r0 >= r1) goto L_0x0063
                java.io.PrintStream r0 = java.lang.System.out
                r1 = r9
                long[] r1 = r1._bits
                r2 = r10
                r1 = r1[r2]
                java.lang.String r1 = java.lang.Long.toHexString(r1)
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;},  ]}
                r0.print(r1)
                int r10 = r10 + 1
                goto L_0x003e
                r0 = r9
                org.jctools.maps.NonBlockingSetInt$NBSI r0 = r0._nbsi64
                r9 = r0
                java.io.PrintStream r0 = java.lang.System.out
                r0.println()
                goto L_0x0037
                r0 = r6
                java.util.concurrent.atomic.AtomicInteger r0 = r0._copyIdx
                int r0 = r0.get()
                if (r0 != 0) goto L_0x0085
                r0 = r6
                java.util.concurrent.atomic.AtomicInteger r0 = r0._copyDone
                int r0 = r0.get()
                if (r0 == 0) goto L_0x00a1
                r0 = r6
                r1 = r7
                r2 = r6
                java.util.concurrent.atomic.AtomicInteger r2 = r2._copyIdx
                int r2 = r2.get()
                r3 = r6
                java.util.concurrent.atomic.AtomicInteger r3 = r3._copyDone
                int r3 = r3.get()
                r4 = r6
                int r4 = r4._sum_bits_length
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, _copyIdx= _copyDone= _words_to_cpy=]}
                r0.print(r1, r2)
                r0 = r6
                org.jctools.maps.NonBlockingSetInt$NBSI r0 = r0._new
                if (r0 == 0) goto L_0x00b9
                r0 = r6
                r1 = r7
                java.lang.String r2 = "__has_new - "
                r0.print(r1, r2)
                r0 = r6
                org.jctools.maps.NonBlockingSetInt$NBSI r0 = r0._new
                r1 = r7
                r2 = 1
                int r1 = r1 + r2
                r0.print(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jctools.maps.NonBlockingSetInt.NBSI.print(int):void");
        }

        static {
            $assertionsDisabled = !NonBlockingSetInt.class.desiredAssertionStatus();
            _Lbase = UnsafeAccess.UNSAFE.arrayBaseOffset(long[].class);
            _Lscale = UnsafeAccess.UNSAFE.arrayIndexScale(long[].class);
            _new_offset = UnsafeAccess.fieldOffset(NBSI.class, "_new");
        }

        private static long rawIndex(long[] ary, int idx) {
            if ($assertionsDisabled || (idx >= 0 && idx < ary.length)) {
                return ((long) _Lbase) + (((long) idx) * ((long) _Lscale));
            }
            throw new AssertionError();
        }

        private final boolean CAS(int idx, long old, long nnn) {
            return UnsafeAccess.UNSAFE.compareAndSwapLong(this._bits, rawIndex(this._bits, idx), old, nnn);
        }

        private final boolean CAS_new(NBSI nnn) {
            return UnsafeAccess.UNSAFE.compareAndSwapObject(this, _new_offset, (Object) null, nnn);
        }

        private static final long mask(int i) {
            return 1 << (i & 63);
        }

        private NBSI(int max_elem, ConcurrentAutoTable ctr, NonBlockingSetInt nonb) {
            this._non_blocking_set_int = nonb;
            this._size = ctr;
            this._copyIdx = ctr == null ? null : new AtomicInteger();
            this._copyDone = ctr == null ? null : new AtomicInteger();
            this._bits = new long[(int) ((((long) max_elem) + 63) >>> 6)];
            this._nbsi64 = ((max_elem + 1) >>> 6) == 0 ? null : new NBSI((max_elem + 1) >>> 6, null, null);
            this._sum_bits_length = this._bits.length + (this._nbsi64 == null ? 0 : this._nbsi64._sum_bits_length);
        }

        public boolean add(int i) {
            long old;
            if ((i >> 6) >= this._bits.length) {
                return install_larger_new_bits(i).help_copy().add(i);
            }
            NBSI nbsi = this;
            int j = i;
            while ((j & 63) == 63) {
                nbsi = nbsi._nbsi64;
                j >>= 6;
            }
            long mask = mask(j);
            do {
                old = nbsi._bits[j >> 6];
                if (old < 0) {
                    return help_copy_impl(i).help_copy().add(i);
                }
                if ((old & mask) != 0) {
                    return false;
                }
            } while (!nbsi.CAS(j >> 6, old, old | mask));
            this._size.add(1);
            return true;
        }

        public boolean remove(int i) {
            long old;
            if ((i >> 6) >= this._bits.length) {
                return this._new != null && help_copy().remove(i);
            }
            NBSI nbsi = this;
            int j = i;
            while ((j & 63) == 63) {
                nbsi = nbsi._nbsi64;
                j >>= 6;
            }
            long mask = mask(j);
            do {
                old = nbsi._bits[j >> 6];
                if (old < 0) {
                    return help_copy_impl(i).help_copy().remove(i);
                }
                if ((old & mask) == 0) {
                    return false;
                }
            } while (!nbsi.CAS(j >> 6, old, old & (mask ^ -1)));
            this._size.add(-1);
            return true;
        }

        public boolean contains(int i) {
            if ((i >> 6) >= this._bits.length) {
                return this._new != null && help_copy().contains(i);
            }
            NBSI nbsi = this;
            int j = i;
            while ((j & 63) == 63) {
                nbsi = nbsi._nbsi64;
                j >>= 6;
            }
            long mask = mask(j);
            long old = nbsi._bits[j >> 6];
            if (old < 0) {
                return help_copy_impl(i).help_copy().contains(i);
            }
            return (old & mask) != 0;
        }

        public int size() {
            return (int) this._size.get();
        }

        private NBSI install_larger_new_bits(int i) {
            if (this._new == null) {
                CAS_new(new NBSI((this._bits.length << 6) << 1, this._size, this._non_blocking_set_int));
            }
            return this;
        }

        private NBSI help_copy() {
            NBSI top_nbsi = this._non_blocking_set_int._nbsi;
            int idx = top_nbsi._copyIdx.getAndAdd(512);
            for (int i = 0; i < 8; i++) {
                int j = (idx + (i * 64)) % (top_nbsi._bits.length << 6);
                top_nbsi.help_copy_impl(j);
                top_nbsi.help_copy_impl(j + 63);
            }
            if (top_nbsi._copyDone.get() != top_nbsi._sum_bits_length || this._non_blocking_set_int.CAS_nbsi(top_nbsi, top_nbsi._new)) {
            }
            return this._new;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0081 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v0, types: [long] */
        /* JADX WARN: Type inference failed for: r12v1, types: [long] */
        /* JADX WARN: Type inference failed for: r0v28, types: [long] */
        /* JADX WARN: Type inference failed for: r0v40, types: [long] */
        /* JADX WARN: Type inference failed for: r12v2 */
        /* JADX WARN: Type inference failed for: r0v57 */
        /* JADX WARN: Type inference failed for: r0v58 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private org.jctools.maps.NonBlockingSetInt.NBSI help_copy_impl(int r8) {
            /*
            // Method dump skipped, instructions count: 251
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jctools.maps.NonBlockingSetInt.NBSI.help_copy_impl(int):org.jctools.maps.NonBlockingSetInt$NBSI");
        }

        private void print(int d, String msg) {
            for (int i = 0; i < d; i++) {
                System.out.print("  ");
            }
            System.out.println(msg);
        }
    }
}
