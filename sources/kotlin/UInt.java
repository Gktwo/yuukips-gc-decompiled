package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import org.jetbrains.annotations.NotNull;
import org.jline.console.Printer;

/* compiled from: UInt.kt */
@SinceKotlin(version = "1.5")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n��\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010��\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018�� y2\b\u0012\u0004\u0012\u00020��0\u0001:\u0001yB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001��¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\fø\u0001��¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\nø\u0001��¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\b\u0010\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001��¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001��¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020��H\nø\u0001��ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020��2\u0006\u0010\t\u001a\u00020\rH\nø\u0001��¢\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u0019\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\b\u001b\u0010\u000bJ\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001��¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0019\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001��¢\u0006\u0004\b\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020��2\u0006\u0010\t\u001a\u00020\rH\bø\u0001��¢\u0006\u0004\b%\u0010\u000fJ\u001b\u0010$\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\bø\u0001��¢\u0006\u0004\b&\u0010\u000bJ\u001b\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001��¢\u0006\u0004\b'\u0010\u001dJ\u001b\u0010$\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0014H\bø\u0001��¢\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b*\u0010\u0005J\u0016\u0010+\u001a\u00020��H\nø\u0001��ø\u0001\u0001¢\u0006\u0004\b,\u0010\u0005J\u0016\u0010-\u001a\u00020��H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\b.\u0010\u0005J\u001b\u0010/\u001a\u00020��2\u0006\u0010\t\u001a\u00020\rH\nø\u0001��¢\u0006\u0004\b0\u0010\u000fJ\u001b\u0010/\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\b1\u0010\u000bJ\u001b\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001��¢\u0006\u0004\b2\u0010\u001dJ\u001b\u0010/\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001��¢\u0006\u0004\b3\u0010\u0016J\u001b\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\bø\u0001��¢\u0006\u0004\b5\u00106J\u001b\u00104\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\bø\u0001��¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001��¢\u0006\u0004\b8\u0010\u001dJ\u001b\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\bø\u0001��¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\fø\u0001��¢\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020��2\u0006\u0010\t\u001a\u00020\rH\nø\u0001��¢\u0006\u0004\b>\u0010\u000fJ\u001b\u0010=\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\b?\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001��¢\u0006\u0004\b@\u0010\u001dJ\u001b\u0010=\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001��¢\u0006\u0004\bA\u0010\u0016J\u001b\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020��2\u0006\u0010\t\u001a\u00020\rH\nø\u0001��¢\u0006\u0004\bG\u0010\u000fJ\u001b\u0010F\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\bH\u0010\u000bJ\u001b\u0010F\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001��¢\u0006\u0004\bI\u0010\u001dJ\u001b\u0010F\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001��¢\u0006\u0004\bJ\u0010\u0016J\u001e\u0010K\u001a\u00020��2\u0006\u0010L\u001a\u00020\u0003H\fø\u0001��ø\u0001\u0001¢\u0006\u0004\bM\u0010\u000bJ\u001e\u0010N\u001a\u00020��2\u0006\u0010L\u001a\u00020\u0003H\fø\u0001��ø\u0001\u0001¢\u0006\u0004\bO\u0010\u000bJ\u001b\u0010P\u001a\u00020��2\u0006\u0010\t\u001a\u00020\rH\nø\u0001��¢\u0006\u0004\bQ\u0010\u000fJ\u001b\u0010P\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\bR\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001��¢\u0006\u0004\bS\u0010\u001dJ\u001b\u0010P\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001��¢\u0006\u0004\bT\u0010\u0016J\u0010\u0010U\u001a\u00020VH\b¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020ZH\b¢\u0006\u0004\b[\u0010\\J\u0010\u0010]\u001a\u00020^H\b¢\u0006\u0004\b_\u0010`J\u0010\u0010a\u001a\u00020\u0003H\b¢\u0006\u0004\bb\u0010\u0005J\u0010\u0010c\u001a\u00020dH\b¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020hH\b¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020lH\u0016¢\u0006\u0004\bm\u0010nJ\u0016\u0010o\u001a\u00020\rH\bø\u0001��ø\u0001\u0001¢\u0006\u0004\bp\u0010XJ\u0016\u0010q\u001a\u00020��H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\br\u0010\u0005J\u0016\u0010s\u001a\u00020\u0011H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\bt\u0010fJ\u0016\u0010u\u001a\u00020\u0014H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\bv\u0010jJ\u001b\u0010w\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\fø\u0001��¢\u0006\u0004\bx\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038��X\u0004¢\u0006\b\n��\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006z"}, m373d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", Printer.TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"})
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: grasscutter.jar:kotlin/UInt.class */
public final class UInt implements Comparable<UInt> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int data;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = -1;
    public static final int SIZE_BYTES = 4;
    public static final int SIZE_BITS = 32;

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7196hashCodeimpl(int arg0) {
        return arg0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return m7196hashCodeimpl(this.data);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7197equalsimpl(int arg0, Object other) {
        return (other instanceof UInt) && arg0 == ((UInt) other).m7200unboximpl();
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        return m7197equalsimpl(this.data, other);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m7198constructorimpl(int data) {
        return data;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UInt m7199boximpl(int v) {
        return new UInt(v);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m7200unboximpl() {
        return this.data;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7201equalsimpl0(int p1, int p2) {
        return p1 == p2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedUtils.uintCompare(m7200unboximpl(), uInt.m7200unboximpl());
    }

    @PublishedApi
    private /* synthetic */ UInt(int data) {
        this.data = data;
    }

    /* compiled from: UInt.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001c\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001��ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001��ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, m373d2 = {"Lkotlin/UInt$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UInt;", "I", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/UInt$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m7143compareTo7apg3OU(int arg0, byte other) {
        return UnsignedUtils.uintCompare(arg0, m7198constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m7144compareToxj2QHRw(int arg0, short other) {
        return UnsignedUtils.uintCompare(arg0, m7198constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static int m7145compareToWZ4Q5Ns(int arg0, int other) {
        return UnsignedUtils.uintCompare(arg0, other);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private int m7146compareToWZ4Q5Ns(int other) {
        return UnsignedUtils.uintCompare(m7200unboximpl(), other);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m7147compareToVKZWuLQ(int arg0, long other) {
        return UnsignedUtils.ulongCompare(ULong.m7277constructorimpl(((long) arg0) & 4294967295L), other);
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m7148plus7apg3OU(int arg0, byte other) {
        return m7198constructorimpl(arg0 + m7198constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m7149plusxj2QHRw(int arg0, short other) {
        return m7198constructorimpl(arg0 + m7198constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m7150plusWZ4Q5Ns(int arg0, int other) {
        return m7198constructorimpl(arg0 + other);
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m7151plusVKZWuLQ(int arg0, long other) {
        return ULong.m7277constructorimpl(ULong.m7277constructorimpl(((long) arg0) & 4294967295L) + other);
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m7152minus7apg3OU(int arg0, byte other) {
        return m7198constructorimpl(arg0 - m7198constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m7153minusxj2QHRw(int arg0, short other) {
        return m7198constructorimpl(arg0 - m7198constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m7154minusWZ4Q5Ns(int arg0, int other) {
        return m7198constructorimpl(arg0 - other);
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m7155minusVKZWuLQ(int arg0, long other) {
        return ULong.m7277constructorimpl(ULong.m7277constructorimpl(((long) arg0) & 4294967295L) - other);
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m7156times7apg3OU(int arg0, byte other) {
        return m7198constructorimpl(arg0 * m7198constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m7157timesxj2QHRw(int arg0, short other) {
        return m7198constructorimpl(arg0 * m7198constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m7158timesWZ4Q5Ns(int arg0, int other) {
        return m7198constructorimpl(arg0 * other);
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m7159timesVKZWuLQ(int arg0, long other) {
        return ULong.m7277constructorimpl(ULong.m7277constructorimpl(((long) arg0) & 4294967295L) * other);
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m7160div7apg3OU(int arg0, byte other) {
        return UnsignedUtils.m7408uintDivideJ1ME1BU(arg0, m7198constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m7161divxj2QHRw(int arg0, short other) {
        return UnsignedUtils.m7408uintDivideJ1ME1BU(arg0, m7198constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m7162divWZ4Q5Ns(int arg0, int other) {
        return UnsignedUtils.m7408uintDivideJ1ME1BU(arg0, other);
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m7163divVKZWuLQ(int arg0, long other) {
        return UnsignedUtils.m7410ulongDivideeb3DHEI(ULong.m7277constructorimpl(((long) arg0) & 4294967295L), other);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m7164rem7apg3OU(int arg0, byte other) {
        return UnsignedUtils.m7409uintRemainderJ1ME1BU(arg0, m7198constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m7165remxj2QHRw(int arg0, short other) {
        return UnsignedUtils.m7409uintRemainderJ1ME1BU(arg0, m7198constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m7166remWZ4Q5Ns(int arg0, int other) {
        return UnsignedUtils.m7409uintRemainderJ1ME1BU(arg0, other);
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m7167remVKZWuLQ(int arg0, long other) {
        return UnsignedUtils.m7411ulongRemaindereb3DHEI(ULong.m7277constructorimpl(((long) arg0) & 4294967295L), other);
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m7168floorDiv7apg3OU(int arg0, byte other) {
        return UnsignedUtils.m7408uintDivideJ1ME1BU(arg0, m7198constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m7169floorDivxj2QHRw(int arg0, short other) {
        return UnsignedUtils.m7408uintDivideJ1ME1BU(arg0, m7198constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m7170floorDivWZ4Q5Ns(int arg0, int other) {
        return UnsignedUtils.m7408uintDivideJ1ME1BU(arg0, other);
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m7171floorDivVKZWuLQ(int arg0, long other) {
        return UnsignedUtils.m7410ulongDivideeb3DHEI(ULong.m7277constructorimpl(((long) arg0) & 4294967295L), other);
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m7172mod7apg3OU(int arg0, byte other) {
        return UByte.m7119constructorimpl((byte) UnsignedUtils.m7409uintRemainderJ1ME1BU(arg0, m7198constructorimpl(other & 255)));
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m7173modxj2QHRw(int arg0, short other) {
        return UShort.m7383constructorimpl((short) UnsignedUtils.m7409uintRemainderJ1ME1BU(arg0, m7198constructorimpl(other & 65535)));
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m7174modWZ4Q5Ns(int arg0, int other) {
        return UnsignedUtils.m7409uintRemainderJ1ME1BU(arg0, other);
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m7175modVKZWuLQ(int arg0, long other) {
        return UnsignedUtils.m7411ulongRemaindereb3DHEI(ULong.m7277constructorimpl(((long) arg0) & 4294967295L), other);
    }

    @InlineOnly
    /* renamed from: inc-pVg5ArA  reason: not valid java name */
    private static final int m7176incpVg5ArA(int arg0) {
        return m7198constructorimpl(arg0 + 1);
    }

    @InlineOnly
    /* renamed from: dec-pVg5ArA  reason: not valid java name */
    private static final int m7177decpVg5ArA(int arg0) {
        return m7198constructorimpl(arg0 - 1);
    }

    @InlineOnly
    /* renamed from: rangeTo-WZ4Q5Ns  reason: not valid java name */
    private static final UIntRange m7178rangeToWZ4Q5Ns(int arg0, int other) {
        return new UIntRange(arg0, other, null);
    }

    @InlineOnly
    /* renamed from: shl-pVg5ArA  reason: not valid java name */
    private static final int m7179shlpVg5ArA(int arg0, int bitCount) {
        return m7198constructorimpl(arg0 << bitCount);
    }

    @InlineOnly
    /* renamed from: shr-pVg5ArA  reason: not valid java name */
    private static final int m7180shrpVg5ArA(int arg0, int bitCount) {
        return m7198constructorimpl(arg0 >>> bitCount);
    }

    @InlineOnly
    /* renamed from: and-WZ4Q5Ns  reason: not valid java name */
    private static final int m7181andWZ4Q5Ns(int arg0, int other) {
        return m7198constructorimpl(arg0 & other);
    }

    @InlineOnly
    /* renamed from: or-WZ4Q5Ns  reason: not valid java name */
    private static final int m7182orWZ4Q5Ns(int arg0, int other) {
        return m7198constructorimpl(arg0 | other);
    }

    @InlineOnly
    /* renamed from: xor-WZ4Q5Ns  reason: not valid java name */
    private static final int m7183xorWZ4Q5Ns(int arg0, int other) {
        return m7198constructorimpl(arg0 ^ other);
    }

    @InlineOnly
    /* renamed from: inv-pVg5ArA  reason: not valid java name */
    private static final int m7184invpVg5ArA(int arg0) {
        return m7198constructorimpl(arg0 ^ -1);
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m7185toByteimpl(int arg0) {
        return (byte) arg0;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m7186toShortimpl(int arg0) {
        return (short) arg0;
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m7187toIntimpl(int arg0) {
        return arg0;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m7188toLongimpl(int arg0) {
        return ((long) arg0) & 4294967295L;
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m7189toUBytew2LRezQ(int arg0) {
        return UByte.m7119constructorimpl((byte) arg0);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m7190toUShortMh2AYeg(int arg0) {
        return UShort.m7383constructorimpl((short) arg0);
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m7191toUIntpVg5ArA(int arg0) {
        return arg0;
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m7192toULongsVKNKU(int arg0) {
        return ULong.m7277constructorimpl(((long) arg0) & 4294967295L);
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m7193toFloatimpl(int arg0) {
        return (float) UnsignedUtils.uintToDouble(arg0);
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m7194toDoubleimpl(int arg0) {
        return UnsignedUtils.uintToDouble(arg0);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7195toStringimpl(int arg0) {
        return String.valueOf(((long) arg0) & 4294967295L);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return m7195toStringimpl(this.data);
    }
}
