package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import org.jetbrains.annotations.NotNull;
import org.jline.console.Printer;

/* compiled from: UByte.kt */
@SinceKotlin(version = "1.5")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n��\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010��\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018�� t2\b\u0012\u0004\u0012\u00020��0\u0001:\u0001tB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001��¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\fø\u0001��¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001��¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001��¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001��¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020��H\nø\u0001��ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001��¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001��¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001��¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020��H\bø\u0001��¢\u0006\u0004\b'\u0010\u000fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\bø\u0001��¢\u0006\u0004\b(\u0010\u0012J\u001b\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\bø\u0001��¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001��¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020��H\nø\u0001��ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020��H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\b3\u0010\u000fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001��¢\u0006\u0004\b4\u0010\u0012J\u001b\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001��¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001��¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\bø\u0001��¢\u0006\u0004\b8\u0010\u000bJ\u001b\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\bø\u0001��¢\u0006\u0004\b9\u0010\u0012J\u001b\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\bø\u0001��¢\u0006\u0004\b:\u0010\u001fJ\u001b\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001��¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\fø\u0001��¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\b@\u0010\u000fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001��¢\u0006\u0004\bA\u0010\u0012J\u001b\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001��¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001��¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\bI\u0010\u000fJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001��¢\u0006\u0004\bJ\u0010\u0012J\u001b\u0010H\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001��¢\u0006\u0004\bK\u0010\u001fJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001��¢\u0006\u0004\bL\u0010\u0018J\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\bN\u0010\u000fJ\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001��¢\u0006\u0004\bO\u0010\u0012J\u001b\u0010M\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001��¢\u0006\u0004\bP\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001��¢\u0006\u0004\bQ\u0010\u0018J\u0010\u0010R\u001a\u00020\u0003H\b¢\u0006\u0004\bS\u0010\u0005J\u0010\u0010T\u001a\u00020UH\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020\rH\b¢\u0006\u0004\b]\u0010-J\u0010\u0010^\u001a\u00020_H\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\b¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\u00020��H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\bk\u0010\u0005J\u0016\u0010l\u001a\u00020\u0010H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\bm\u0010-J\u0016\u0010n\u001a\u00020\u0013H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\bo\u0010aJ\u0016\u0010p\u001a\u00020\u0016H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\bq\u0010eJ\u001b\u0010r\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\fø\u0001��¢\u0006\u0004\bs\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038��X\u0004¢\u0006\b\n��\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006u"}, m373d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", Printer.TO_STRING, "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"})
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: grasscutter.jar:kotlin/UByte.class */
public final class UByte implements Comparable<UByte> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final byte data;
    public static final byte MIN_VALUE = 0;
    public static final byte MAX_VALUE = -1;
    public static final int SIZE_BYTES = 1;
    public static final int SIZE_BITS = 8;

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7120hashCodeimpl(byte arg0) {
        return arg0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return m7120hashCodeimpl(this.data);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7121equalsimpl(byte arg0, Object other) {
        return (other instanceof UByte) && arg0 == ((UByte) other).m7124unboximpl();
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        return m7121equalsimpl(this.data, other);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m7122constructorimpl(byte data) {
        return data;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m7123boximpl(byte v) {
        return new UByte(v);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m7124unboximpl() {
        return this.data;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7125equalsimpl0(byte p1, byte p2) {
        return p1 == p2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.compare(m7124unboximpl() & 255, uByte.m7124unboximpl() & 255);
    }

    @PublishedApi
    private /* synthetic */ UByte(byte data) {
        this.data = data;
    }

    /* compiled from: UByte.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001c\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001��ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001��ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, m373d2 = {"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/UByte$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static int m7069compareTo7apg3OU(byte arg0, byte other) {
        return Intrinsics.compare(arg0 & 255, other & 255);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private int m7070compareTo7apg3OU(byte other) {
        return Intrinsics.compare(m7124unboximpl() & 255, other & 255);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m7071compareToxj2QHRw(byte arg0, short other) {
        return Intrinsics.compare(arg0 & 255, other & 65535);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m7072compareToWZ4Q5Ns(byte arg0, int other) {
        return UnsignedUtils.uintCompare(UInt.m7201constructorimpl(arg0 & 255), other);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m7073compareToVKZWuLQ(byte arg0, long other) {
        return UnsignedUtils.ulongCompare(ULong.m7280constructorimpl(((long) arg0) & 255), other);
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m7074plus7apg3OU(byte arg0, byte other) {
        return UInt.m7201constructorimpl(UInt.m7201constructorimpl(arg0 & 255) + UInt.m7201constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m7075plusxj2QHRw(byte arg0, short other) {
        return UInt.m7201constructorimpl(UInt.m7201constructorimpl(arg0 & 255) + UInt.m7201constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m7076plusWZ4Q5Ns(byte arg0, int other) {
        return UInt.m7201constructorimpl(UInt.m7201constructorimpl(arg0 & 255) + other);
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m7077plusVKZWuLQ(byte arg0, long other) {
        return ULong.m7280constructorimpl(ULong.m7280constructorimpl(((long) arg0) & 255) + other);
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m7078minus7apg3OU(byte arg0, byte other) {
        return UInt.m7201constructorimpl(UInt.m7201constructorimpl(arg0 & 255) - UInt.m7201constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m7079minusxj2QHRw(byte arg0, short other) {
        return UInt.m7201constructorimpl(UInt.m7201constructorimpl(arg0 & 255) - UInt.m7201constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m7080minusWZ4Q5Ns(byte arg0, int other) {
        return UInt.m7201constructorimpl(UInt.m7201constructorimpl(arg0 & 255) - other);
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m7081minusVKZWuLQ(byte arg0, long other) {
        return ULong.m7280constructorimpl(ULong.m7280constructorimpl(((long) arg0) & 255) - other);
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m7082times7apg3OU(byte arg0, byte other) {
        return UInt.m7201constructorimpl(UInt.m7201constructorimpl(arg0 & 255) * UInt.m7201constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m7083timesxj2QHRw(byte arg0, short other) {
        return UInt.m7201constructorimpl(UInt.m7201constructorimpl(arg0 & 255) * UInt.m7201constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m7084timesWZ4Q5Ns(byte arg0, int other) {
        return UInt.m7201constructorimpl(UInt.m7201constructorimpl(arg0 & 255) * other);
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m7085timesVKZWuLQ(byte arg0, long other) {
        return ULong.m7280constructorimpl(ULong.m7280constructorimpl(((long) arg0) & 255) * other);
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m7086div7apg3OU(byte arg0, byte other) {
        return UnsignedUtils.m7411uintDivideJ1ME1BU(UInt.m7201constructorimpl(arg0 & 255), UInt.m7201constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m7087divxj2QHRw(byte arg0, short other) {
        return UnsignedUtils.m7411uintDivideJ1ME1BU(UInt.m7201constructorimpl(arg0 & 255), UInt.m7201constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m7088divWZ4Q5Ns(byte arg0, int other) {
        return UnsignedUtils.m7411uintDivideJ1ME1BU(UInt.m7201constructorimpl(arg0 & 255), other);
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m7089divVKZWuLQ(byte arg0, long other) {
        return UnsignedUtils.m7413ulongDivideeb3DHEI(ULong.m7280constructorimpl(((long) arg0) & 255), other);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m7090rem7apg3OU(byte arg0, byte other) {
        return UnsignedUtils.m7412uintRemainderJ1ME1BU(UInt.m7201constructorimpl(arg0 & 255), UInt.m7201constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m7091remxj2QHRw(byte arg0, short other) {
        return UnsignedUtils.m7412uintRemainderJ1ME1BU(UInt.m7201constructorimpl(arg0 & 255), UInt.m7201constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m7092remWZ4Q5Ns(byte arg0, int other) {
        return UnsignedUtils.m7412uintRemainderJ1ME1BU(UInt.m7201constructorimpl(arg0 & 255), other);
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m7093remVKZWuLQ(byte arg0, long other) {
        return UnsignedUtils.m7414ulongRemaindereb3DHEI(ULong.m7280constructorimpl(((long) arg0) & 255), other);
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m7094floorDiv7apg3OU(byte arg0, byte other) {
        return UnsignedUtils.m7411uintDivideJ1ME1BU(UInt.m7201constructorimpl(arg0 & 255), UInt.m7201constructorimpl(other & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m7095floorDivxj2QHRw(byte arg0, short other) {
        return UnsignedUtils.m7411uintDivideJ1ME1BU(UInt.m7201constructorimpl(arg0 & 255), UInt.m7201constructorimpl(other & 65535));
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m7096floorDivWZ4Q5Ns(byte arg0, int other) {
        return UnsignedUtils.m7411uintDivideJ1ME1BU(UInt.m7201constructorimpl(arg0 & 255), other);
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m7097floorDivVKZWuLQ(byte arg0, long other) {
        return UnsignedUtils.m7413ulongDivideeb3DHEI(ULong.m7280constructorimpl(((long) arg0) & 255), other);
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m7098mod7apg3OU(byte arg0, byte other) {
        return m7122constructorimpl((byte) UnsignedUtils.m7412uintRemainderJ1ME1BU(UInt.m7201constructorimpl(arg0 & 255), UInt.m7201constructorimpl(other & 255)));
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m7099modxj2QHRw(byte arg0, short other) {
        return UShort.m7386constructorimpl((short) UnsignedUtils.m7412uintRemainderJ1ME1BU(UInt.m7201constructorimpl(arg0 & 255), UInt.m7201constructorimpl(other & 65535)));
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m7100modWZ4Q5Ns(byte arg0, int other) {
        return UnsignedUtils.m7412uintRemainderJ1ME1BU(UInt.m7201constructorimpl(arg0 & 255), other);
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m7101modVKZWuLQ(byte arg0, long other) {
        return UnsignedUtils.m7414ulongRemaindereb3DHEI(ULong.m7280constructorimpl(((long) arg0) & 255), other);
    }

    @InlineOnly
    /* renamed from: inc-w2LRezQ  reason: not valid java name */
    private static final byte m7102incw2LRezQ(byte arg0) {
        return m7122constructorimpl((byte) (arg0 + 1));
    }

    @InlineOnly
    /* renamed from: dec-w2LRezQ  reason: not valid java name */
    private static final byte m7103decw2LRezQ(byte arg0) {
        return m7122constructorimpl((byte) (arg0 - 1));
    }

    @InlineOnly
    /* renamed from: rangeTo-7apg3OU  reason: not valid java name */
    private static final UIntRange m7104rangeTo7apg3OU(byte arg0, byte other) {
        return new UIntRange(UInt.m7201constructorimpl(arg0 & 255), UInt.m7201constructorimpl(other & 255), null);
    }

    @InlineOnly
    /* renamed from: and-7apg3OU  reason: not valid java name */
    private static final byte m7105and7apg3OU(byte arg0, byte other) {
        return m7122constructorimpl((byte) (arg0 & other));
    }

    @InlineOnly
    /* renamed from: or-7apg3OU  reason: not valid java name */
    private static final byte m7106or7apg3OU(byte arg0, byte other) {
        return m7122constructorimpl((byte) (arg0 | other));
    }

    @InlineOnly
    /* renamed from: xor-7apg3OU  reason: not valid java name */
    private static final byte m7107xor7apg3OU(byte arg0, byte other) {
        return m7122constructorimpl((byte) (arg0 ^ other));
    }

    @InlineOnly
    /* renamed from: inv-w2LRezQ  reason: not valid java name */
    private static final byte m7108invw2LRezQ(byte arg0) {
        return m7122constructorimpl((byte) (arg0 ^ -1));
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m7109toByteimpl(byte arg0) {
        return arg0;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m7110toShortimpl(byte arg0) {
        return (short) (((short) arg0) & 255);
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m7111toIntimpl(byte arg0) {
        return arg0 & 255;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m7112toLongimpl(byte arg0) {
        return ((long) arg0) & 255;
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m7113toUBytew2LRezQ(byte arg0) {
        return arg0;
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m7114toUShortMh2AYeg(byte arg0) {
        return UShort.m7386constructorimpl((short) (((short) arg0) & 255));
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m7115toUIntpVg5ArA(byte arg0) {
        return UInt.m7201constructorimpl(arg0 & 255);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m7116toULongsVKNKU(byte arg0) {
        return ULong.m7280constructorimpl(((long) arg0) & 255);
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m7117toFloatimpl(byte arg0) {
        return (float) (arg0 & 255);
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m7118toDoubleimpl(byte arg0) {
        return (double) (arg0 & 255);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7119toStringimpl(byte arg0) {
        return String.valueOf(arg0 & 255);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return m7119toStringimpl(this.data);
    }
}
