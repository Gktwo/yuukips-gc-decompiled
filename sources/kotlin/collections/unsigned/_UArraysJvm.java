package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.RandomAccess;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedUtils;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��T\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010��\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007ø\u0001��¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010��\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007ø\u0001��¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010��\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007ø\u0001��¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010��\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007ø\u0001��¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001��¢\u0006\u0004\b\u0017\u0010\u0018\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001��¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001��¢\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001��¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\bø\u0001��¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\bø\u0001��¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\bø\u0001��¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\bø\u0001��¢\u0006\u0004\b'\u0010(\u001a.\u0010)\u001a\u00020**\u00020\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0,H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\b-\u0010.\u001a.\u0010)\u001a\u00020/*\u00020\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020/0,H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001a.\u0010)\u001a\u00020**\u00020\u00072\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020*0,H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\b-\u00102\u001a.\u0010)\u001a\u00020/*\u00020\u00072\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020/0,H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\b0\u00103\u001a.\u0010)\u001a\u00020**\u00020\u000b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020*0,H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\b-\u00104\u001a.\u0010)\u001a\u00020/*\u00020\u000b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020/0,H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\b0\u00105\u001a.\u0010)\u001a\u00020**\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020*0,H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\b-\u00106\u001a.\u0010)\u001a\u00020/*\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020/0,H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\b0\u00107\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u00068"}, m373d2 = {"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, m368xs = "kotlin/collections/unsigned/UArraysKt", m370pn = "kotlin.collections")
/* renamed from: kotlin.collections.unsigned.UArraysKt___UArraysJvmKt */
/* loaded from: grasscutter.jar:kotlin/collections/unsigned/UArraysKt___UArraysJvmKt.class */
class _UArraysJvm {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-qFRl0hI  reason: not valid java name */
    private static final int m7537elementAtqFRl0hI(int[] $this$elementAt_u2dqFRl0hI, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dqFRl0hI, "$this$elementAt");
        return UIntArray.m7204getpVg5ArA($this$elementAt_u2dqFRl0hI, index);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-r7IrZao  reason: not valid java name */
    private static final long m7538elementAtr7IrZao(long[] $this$elementAt_u2dr7IrZao, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dr7IrZao, "$this$elementAt");
        return ULongArray.m7283getsVKNKU($this$elementAt_u2dr7IrZao, index);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-PpDY95g  reason: not valid java name */
    private static final byte m7539elementAtPpDY95g(byte[] $this$elementAt_u2dPpDY95g, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dPpDY95g, "$this$elementAt");
        return UByteArray.m7125getw2LRezQ($this$elementAt_u2dPpDY95g, index);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-nggk6HY  reason: not valid java name */
    private static final short m7540elementAtnggk6HY(short[] $this$elementAt_u2dnggk6HY, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dnggk6HY, "$this$elementAt");
        return UShortArray.m7389getMh2AYeg($this$elementAt_u2dnggk6HY, index);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: asList--ajY-9A  reason: not valid java name */
    public static final List<UInt> m7541asListajY9A(@NotNull int[] $this$asList_u2d_u2dajY_u2d9A) {
        Intrinsics.checkNotNullParameter($this$asList_u2d_u2dajY_u2d9A, "$this$asList");
        return new RandomAccess($this$asList_u2d_u2dajY_u2d9A) { // from class: kotlin.collections.unsigned.UArraysKt___UArraysJvmKt$asList$1
            final /* synthetic */ int[] $this_asList;

            /* access modifiers changed from: package-private */
            {
                this.$this_asList = $receiver;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object element) {
                if (!(element instanceof UInt)) {
                    return false;
                }
                return m7553containsWZ4Q5Ns(((UInt) element).m7200unboximpl());
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public /* bridge */ /* synthetic */ Object get(int index) {
                return UInt.m7199boximpl(m7554getpVg5ArA(index));
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object element) {
                if (!(element instanceof UInt)) {
                    return -1;
                }
                return m7555indexOfWZ4Q5Ns(((UInt) element).m7200unboximpl());
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object element) {
                if (!(element instanceof UInt)) {
                    return -1;
                }
                return m7556lastIndexOfWZ4Q5Ns(((UInt) element).m7200unboximpl());
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return UIntArray.m7206getSizeimpl(this.$this_asList);
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return UIntArray.m7211isEmptyimpl(this.$this_asList);
            }

            /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
            public boolean m7553containsWZ4Q5Ns(int element) {
                return UIntArray.m7208containsWZ4Q5Ns(this.$this_asList, element);
            }

            /* renamed from: get-pVg5ArA  reason: not valid java name */
            public int m7554getpVg5ArA(int index) {
                return UIntArray.m7204getpVg5ArA(this.$this_asList, index);
            }

            /* renamed from: indexOf-WZ4Q5Ns  reason: not valid java name */
            public int m7555indexOfWZ4Q5Ns(int element) {
                return ArraysKt.indexOf(this.$this_asList, element);
            }

            /* renamed from: lastIndexOf-WZ4Q5Ns  reason: not valid java name */
            public int m7556lastIndexOfWZ4Q5Ns(int element) {
                return ArraysKt.lastIndexOf(this.$this_asList, element);
            }
        };
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: asList-QwZRm1k  reason: not valid java name */
    public static final List<ULong> m7542asListQwZRm1k(@NotNull long[] $this$asList_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$asList_u2dQwZRm1k, "$this$asList");
        return new RandomAccess($this$asList_u2dQwZRm1k) { // from class: kotlin.collections.unsigned.UArraysKt___UArraysJvmKt$asList$2
            final /* synthetic */ long[] $this_asList;

            /* access modifiers changed from: package-private */
            {
                this.$this_asList = $receiver;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object element) {
                if (!(element instanceof ULong)) {
                    return false;
                }
                return m7557containsVKZWuLQ(((ULong) element).m7279unboximpl());
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public /* bridge */ /* synthetic */ Object get(int index) {
                return ULong.m7278boximpl(m7558getsVKNKU(index));
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object element) {
                if (!(element instanceof ULong)) {
                    return -1;
                }
                return m7559indexOfVKZWuLQ(((ULong) element).m7279unboximpl());
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object element) {
                if (!(element instanceof ULong)) {
                    return -1;
                }
                return m7560lastIndexOfVKZWuLQ(((ULong) element).m7279unboximpl());
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return ULongArray.m7285getSizeimpl(this.$this_asList);
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return ULongArray.m7290isEmptyimpl(this.$this_asList);
            }

            /* renamed from: contains-VKZWuLQ  reason: not valid java name */
            public boolean m7557containsVKZWuLQ(long element) {
                return ULongArray.m7287containsVKZWuLQ(this.$this_asList, element);
            }

            /* renamed from: get-s-VKNKU  reason: not valid java name */
            public long m7558getsVKNKU(int index) {
                return ULongArray.m7283getsVKNKU(this.$this_asList, index);
            }

            /* renamed from: indexOf-VKZWuLQ  reason: not valid java name */
            public int m7559indexOfVKZWuLQ(long element) {
                return ArraysKt.indexOf(this.$this_asList, element);
            }

            /* renamed from: lastIndexOf-VKZWuLQ  reason: not valid java name */
            public int m7560lastIndexOfVKZWuLQ(long element) {
                return ArraysKt.lastIndexOf(this.$this_asList, element);
            }
        };
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: asList-GBYM_sE  reason: not valid java name */
    public static final List<UByte> m7543asListGBYM_sE(@NotNull byte[] $this$asList_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$asList_u2dGBYM_sE, "$this$asList");
        return new RandomAccess($this$asList_u2dGBYM_sE) { // from class: kotlin.collections.unsigned.UArraysKt___UArraysJvmKt$asList$3
            final /* synthetic */ byte[] $this_asList;

            /* access modifiers changed from: package-private */
            {
                this.$this_asList = $receiver;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object element) {
                if (!(element instanceof UByte)) {
                    return false;
                }
                return m7561contains7apg3OU(((UByte) element).m7121unboximpl());
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public /* bridge */ /* synthetic */ Object get(int index) {
                return UByte.m7120boximpl(m7562getw2LRezQ(index));
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object element) {
                if (!(element instanceof UByte)) {
                    return -1;
                }
                return m7563indexOf7apg3OU(((UByte) element).m7121unboximpl());
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object element) {
                if (!(element instanceof UByte)) {
                    return -1;
                }
                return m7564lastIndexOf7apg3OU(((UByte) element).m7121unboximpl());
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return UByteArray.m7127getSizeimpl(this.$this_asList);
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return UByteArray.m7132isEmptyimpl(this.$this_asList);
            }

            /* renamed from: contains-7apg3OU  reason: not valid java name */
            public boolean m7561contains7apg3OU(byte element) {
                return UByteArray.m7129contains7apg3OU(this.$this_asList, element);
            }

            /* renamed from: get-w2LRezQ  reason: not valid java name */
            public byte m7562getw2LRezQ(int index) {
                return UByteArray.m7125getw2LRezQ(this.$this_asList, index);
            }

            /* renamed from: indexOf-7apg3OU  reason: not valid java name */
            public int m7563indexOf7apg3OU(byte element) {
                return ArraysKt.indexOf(this.$this_asList, element);
            }

            /* renamed from: lastIndexOf-7apg3OU  reason: not valid java name */
            public int m7564lastIndexOf7apg3OU(byte element) {
                return ArraysKt.lastIndexOf(this.$this_asList, element);
            }
        };
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: asList-rL5Bavg  reason: not valid java name */
    public static final List<UShort> m7544asListrL5Bavg(@NotNull short[] $this$asList_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$asList_u2drL5Bavg, "$this$asList");
        return new RandomAccess($this$asList_u2drL5Bavg) { // from class: kotlin.collections.unsigned.UArraysKt___UArraysJvmKt$asList$4
            final /* synthetic */ short[] $this_asList;

            /* access modifiers changed from: package-private */
            {
                this.$this_asList = $receiver;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object element) {
                if (!(element instanceof UShort)) {
                    return false;
                }
                return m7565containsxj2QHRw(((UShort) element).m7385unboximpl());
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public /* bridge */ /* synthetic */ Object get(int index) {
                return UShort.m7384boximpl(m7566getMh2AYeg(index));
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object element) {
                if (!(element instanceof UShort)) {
                    return -1;
                }
                return m7567indexOfxj2QHRw(((UShort) element).m7385unboximpl());
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object element) {
                if (!(element instanceof UShort)) {
                    return -1;
                }
                return m7568lastIndexOfxj2QHRw(((UShort) element).m7385unboximpl());
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return UShortArray.m7391getSizeimpl(this.$this_asList);
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return UShortArray.m7396isEmptyimpl(this.$this_asList);
            }

            /* renamed from: contains-xj2QHRw  reason: not valid java name */
            public boolean m7565containsxj2QHRw(short element) {
                return UShortArray.m7393containsxj2QHRw(this.$this_asList, element);
            }

            /* renamed from: get-Mh2AYeg  reason: not valid java name */
            public short m7566getMh2AYeg(int index) {
                return UShortArray.m7389getMh2AYeg(this.$this_asList, index);
            }

            /* renamed from: indexOf-xj2QHRw  reason: not valid java name */
            public int m7567indexOfxj2QHRw(short element) {
                return ArraysKt.indexOf(this.$this_asList, element);
            }

            /* renamed from: lastIndexOf-xj2QHRw  reason: not valid java name */
            public int m7568lastIndexOfxj2QHRw(short element) {
                return ArraysKt.lastIndexOf(this.$this_asList, element);
            }
        };
    }

    /* renamed from: binarySearch-2fe2U9s$default  reason: not valid java name */
    public static /* synthetic */ int m7546binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m7206getSizeimpl(iArr);
        }
        return UArraysKt.m7545binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-2fe2U9s  reason: not valid java name */
    public static final int m7545binarySearch2fe2U9s(@NotNull int[] $this$binarySearch_u2d2fe2U9s, int element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2d2fe2U9s, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UIntArray.m7206getSizeimpl($this$binarySearch_u2d2fe2U9s));
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = UnsignedUtils.uintCompare($this$binarySearch_u2d2fe2U9s[mid], element);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    /* renamed from: binarySearch-K6DWlUc$default  reason: not valid java name */
    public static /* synthetic */ int m7548binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m7285getSizeimpl(jArr);
        }
        return UArraysKt.m7547binarySearchK6DWlUc(jArr, j, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-K6DWlUc  reason: not valid java name */
    public static final int m7547binarySearchK6DWlUc(@NotNull long[] $this$binarySearch_u2dK6DWlUc, long element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dK6DWlUc, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, ULongArray.m7285getSizeimpl($this$binarySearch_u2dK6DWlUc));
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = UnsignedUtils.ulongCompare($this$binarySearch_u2dK6DWlUc[mid], element);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    /* renamed from: binarySearch-WpHrYlw$default  reason: not valid java name */
    public static /* synthetic */ int m7550binarySearchWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m7127getSizeimpl(bArr);
        }
        return UArraysKt.m7549binarySearchWpHrYlw(bArr, b, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-WpHrYlw  reason: not valid java name */
    public static final int m7549binarySearchWpHrYlw(@NotNull byte[] $this$binarySearch_u2dWpHrYlw, byte element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dWpHrYlw, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UByteArray.m7127getSizeimpl($this$binarySearch_u2dWpHrYlw));
        int signedElement = element & 255;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = UnsignedUtils.uintCompare($this$binarySearch_u2dWpHrYlw[mid], signedElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    /* renamed from: binarySearch-EtDCXyQ$default  reason: not valid java name */
    public static /* synthetic */ int m7552binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m7391getSizeimpl(sArr);
        }
        return UArraysKt.m7551binarySearchEtDCXyQ(sArr, s, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-EtDCXyQ  reason: not valid java name */
    public static final int m7551binarySearchEtDCXyQ(@NotNull short[] $this$binarySearch_u2dEtDCXyQ, short element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dEtDCXyQ, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UShortArray.m7391getSizeimpl($this$binarySearch_u2dEtDCXyQ));
        int signedElement = element & 65535;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = UnsignedUtils.uintCompare($this$binarySearch_u2dEtDCXyQ[mid], signedElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "sumOfBigDecimal")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(int[] $this$sumOf_u2djgv0xPQ, Function1<? super UInt, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2djgv0xPQ, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        BigDecimal sum = valueOf;
        int r0 = UIntArray.m7206getSizeimpl($this$sumOf_u2djgv0xPQ);
        for (int i = 0; i < r0; i++) {
            BigDecimal add = sum.add((BigDecimal) function1.invoke(UInt.m7199boximpl(UIntArray.m7204getpVg5ArA($this$sumOf_u2djgv0xPQ, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "sumOfBigDecimal")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(long[] $this$sumOf_u2dMShoTSo, Function1<? super ULong, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dMShoTSo, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        BigDecimal sum = valueOf;
        int r0 = ULongArray.m7285getSizeimpl($this$sumOf_u2dMShoTSo);
        for (int i = 0; i < r0; i++) {
            BigDecimal add = sum.add((BigDecimal) function1.invoke(ULong.m7278boximpl(ULongArray.m7283getsVKNKU($this$sumOf_u2dMShoTSo, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "sumOfBigDecimal")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(byte[] $this$sumOf_u2dJOV_ifY, Function1<? super UByte, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dJOV_ifY, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        BigDecimal sum = valueOf;
        int r0 = UByteArray.m7127getSizeimpl($this$sumOf_u2dJOV_ifY);
        for (int i = 0; i < r0; i++) {
            BigDecimal add = sum.add((BigDecimal) function1.invoke(UByte.m7120boximpl(UByteArray.m7125getw2LRezQ($this$sumOf_u2dJOV_ifY, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "sumOfBigDecimal")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(short[] $this$sumOf_u2dxTcfx_M, Function1<? super UShort, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dxTcfx_M, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        BigDecimal sum = valueOf;
        int r0 = UShortArray.m7391getSizeimpl($this$sumOf_u2dxTcfx_M);
        for (int i = 0; i < r0; i++) {
            BigDecimal add = sum.add((BigDecimal) function1.invoke(UShort.m7384boximpl(UShortArray.m7389getMh2AYeg($this$sumOf_u2dxTcfx_M, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "sumOfBigInteger")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(int[] $this$sumOf_u2djgv0xPQ, Function1<? super UInt, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2djgv0xPQ, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        BigInteger sum = valueOf;
        int r0 = UIntArray.m7206getSizeimpl($this$sumOf_u2djgv0xPQ);
        for (int i = 0; i < r0; i++) {
            BigInteger add = sum.add((BigInteger) function1.invoke(UInt.m7199boximpl(UIntArray.m7204getpVg5ArA($this$sumOf_u2djgv0xPQ, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "sumOfBigInteger")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(long[] $this$sumOf_u2dMShoTSo, Function1<? super ULong, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dMShoTSo, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        BigInteger sum = valueOf;
        int r0 = ULongArray.m7285getSizeimpl($this$sumOf_u2dMShoTSo);
        for (int i = 0; i < r0; i++) {
            BigInteger add = sum.add((BigInteger) function1.invoke(ULong.m7278boximpl(ULongArray.m7283getsVKNKU($this$sumOf_u2dMShoTSo, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "sumOfBigInteger")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(byte[] $this$sumOf_u2dJOV_ifY, Function1<? super UByte, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dJOV_ifY, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        BigInteger sum = valueOf;
        int r0 = UByteArray.m7127getSizeimpl($this$sumOf_u2dJOV_ifY);
        for (int i = 0; i < r0; i++) {
            BigInteger add = sum.add((BigInteger) function1.invoke(UByte.m7120boximpl(UByteArray.m7125getw2LRezQ($this$sumOf_u2dJOV_ifY, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "sumOfBigInteger")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(short[] $this$sumOf_u2dxTcfx_M, Function1<? super UShort, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dxTcfx_M, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        BigInteger sum = valueOf;
        int r0 = UShortArray.m7391getSizeimpl($this$sumOf_u2dxTcfx_M);
        for (int i = 0; i < r0; i++) {
            BigInteger add = sum.add((BigInteger) function1.invoke(UShort.m7384boximpl(UShortArray.m7389getMh2AYeg($this$sumOf_u2dxTcfx_M, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
}
