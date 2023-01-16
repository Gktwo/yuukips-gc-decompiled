package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import okhttp3.internal.p021ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jline.console.Printer;

/* compiled from: ULong.kt */
@SinceKotlin(version = "1.5")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n��\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010��\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018�� |2\b\u0012\u0004\u0012\u00020��0\u0001:\u0001|B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001��¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\fø\u0001��¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001��¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001��¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001��¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020��H\nø\u0001��ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001��¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001��¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001��¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u000eH\bø\u0001��¢\u0006\u0004\b)\u0010\u001dJ\u001b\u0010(\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001��¢\u0006\u0004\b*\u0010\u001fJ\u001b\u0010(\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\bø\u0001��¢\u0006\u0004\b+\u0010\u000bJ\u001b\u0010(\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001��¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020��H\nø\u0001��ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u0016\u00102\u001a\u00020��H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\b3\u0010\u0005J\u001b\u00104\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001��¢\u0006\u0004\b5\u0010\u001dJ\u001b\u00104\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001��¢\u0006\u0004\b6\u0010\u001fJ\u001b\u00104\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001��¢\u0006\u0004\b8\u0010\"J\u001b\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\bø\u0001��¢\u0006\u0004\b:\u0010;J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001��¢\u0006\u0004\b<\u0010\u0013J\u001b\u00109\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\bø\u0001��¢\u0006\u0004\b=\u0010\u000bJ\u001b\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001��¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\fø\u0001��¢\u0006\u0004\bA\u0010\u000bJ\u001b\u0010B\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001��¢\u0006\u0004\bC\u0010\u001dJ\u001b\u0010B\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001��¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010B\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\bE\u0010\u000bJ\u001b\u0010B\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001��¢\u0006\u0004\bF\u0010\"J\u001b\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001��¢\u0006\u0004\bL\u0010\u001dJ\u001b\u0010K\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001��¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010K\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\bN\u0010\u000bJ\u001b\u0010K\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001��¢\u0006\u0004\bO\u0010\"J\u001e\u0010P\u001a\u00020��2\u0006\u0010Q\u001a\u00020\rH\fø\u0001��ø\u0001\u0001¢\u0006\u0004\bR\u0010\u001fJ\u001e\u0010S\u001a\u00020��2\u0006\u0010Q\u001a\u00020\rH\fø\u0001��ø\u0001\u0001¢\u0006\u0004\bT\u0010\u001fJ\u001b\u0010U\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001��¢\u0006\u0004\bV\u0010\u001dJ\u001b\u0010U\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001��¢\u0006\u0004\bW\u0010\u001fJ\u001b\u0010U\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\nø\u0001��¢\u0006\u0004\bX\u0010\u000bJ\u001b\u0010U\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001��¢\u0006\u0004\bY\u0010\"J\u0010\u0010Z\u001a\u00020[H\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020_H\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\rH\b¢\u0006\u0004\bg\u0010/J\u0010\u0010h\u001a\u00020\u0003H\b¢\u0006\u0004\bi\u0010\u0005J\u0010\u0010j\u001a\u00020kH\b¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020oH\u0016¢\u0006\u0004\bp\u0010qJ\u0016\u0010r\u001a\u00020\u000eH\bø\u0001��ø\u0001\u0001¢\u0006\u0004\bs\u0010]J\u0016\u0010t\u001a\u00020\u0011H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\bu\u0010/J\u0016\u0010v\u001a\u00020��H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\bw\u0010\u0005J\u0016\u0010x\u001a\u00020\u0016H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\by\u0010mJ\u001b\u0010z\u001a\u00020��2\u0006\u0010\t\u001a\u00020��H\fø\u0001��¢\u0006\u0004\b{\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038��X\u0004¢\u0006\b\n��\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006}"}, m373d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", Printer.TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"})
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: grasscutter.jar:kotlin/ULong.class */
public final class ULong implements Comparable<ULong> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final long data;
    public static final long MIN_VALUE = 0;
    public static final long MAX_VALUE = -1;
    public static final int SIZE_BYTES = 8;
    public static final int SIZE_BITS = 64;

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7278hashCodeimpl(long arg0) {
        return (int) (arg0 ^ (arg0 >>> 32));
    }

    @Override // java.lang.Object
    public int hashCode() {
        return m7278hashCodeimpl(this.data);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7279equalsimpl(long arg0, Object other) {
        return (other instanceof ULong) && arg0 == ((ULong) other).m7282unboximpl();
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        return m7279equalsimpl(this.data, other);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m7280constructorimpl(long data) {
        return data;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULong m7281boximpl(long v) {
        return new ULong(v);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m7282unboximpl() {
        return this.data;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7283equalsimpl0(long p1, long p2) {
        return p1 == p2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedUtils.ulongCompare(m7282unboximpl(), uLong.m7282unboximpl());
    }

    @PublishedApi
    private /* synthetic */ ULong(long data) {
        this.data = data;
    }

    /* compiled from: ULong.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001c\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001��ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001��ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, m373d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/ULong$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m7225compareTo7apg3OU(long arg0, byte other) {
        return UnsignedUtils.ulongCompare(arg0, m7280constructorimpl(((long) other) & 255));
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m7226compareToxj2QHRw(long arg0, short other) {
        return UnsignedUtils.ulongCompare(arg0, m7280constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m7227compareToWZ4Q5Ns(long arg0, int other) {
        return UnsignedUtils.ulongCompare(arg0, m7280constructorimpl(((long) other) & 4294967295L));
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static int m7228compareToVKZWuLQ(long arg0, long other) {
        return UnsignedUtils.ulongCompare(arg0, other);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private int m7229compareToVKZWuLQ(long other) {
        return UnsignedUtils.ulongCompare(m7282unboximpl(), other);
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final long m7230plus7apg3OU(long arg0, byte other) {
        return m7280constructorimpl(arg0 + m7280constructorimpl(((long) other) & 255));
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final long m7231plusxj2QHRw(long arg0, short other) {
        return m7280constructorimpl(arg0 + m7280constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final long m7232plusWZ4Q5Ns(long arg0, int other) {
        return m7280constructorimpl(arg0 + m7280constructorimpl(((long) other) & 4294967295L));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m7233plusVKZWuLQ(long arg0, long other) {
        return m7280constructorimpl(arg0 + other);
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final long m7234minus7apg3OU(long arg0, byte other) {
        return m7280constructorimpl(arg0 - m7280constructorimpl(((long) other) & 255));
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final long m7235minusxj2QHRw(long arg0, short other) {
        return m7280constructorimpl(arg0 - m7280constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final long m7236minusWZ4Q5Ns(long arg0, int other) {
        return m7280constructorimpl(arg0 - m7280constructorimpl(((long) other) & 4294967295L));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m7237minusVKZWuLQ(long arg0, long other) {
        return m7280constructorimpl(arg0 - other);
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final long m7238times7apg3OU(long arg0, byte other) {
        return m7280constructorimpl(arg0 * m7280constructorimpl(((long) other) & 255));
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final long m7239timesxj2QHRw(long arg0, short other) {
        return m7280constructorimpl(arg0 * m7280constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final long m7240timesWZ4Q5Ns(long arg0, int other) {
        return m7280constructorimpl(arg0 * m7280constructorimpl(((long) other) & 4294967295L));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m7241timesVKZWuLQ(long arg0, long other) {
        return m7280constructorimpl(arg0 * other);
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final long m7242div7apg3OU(long arg0, byte other) {
        return UnsignedUtils.m7413ulongDivideeb3DHEI(arg0, m7280constructorimpl(((long) other) & 255));
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final long m7243divxj2QHRw(long arg0, short other) {
        return UnsignedUtils.m7413ulongDivideeb3DHEI(arg0, m7280constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final long m7244divWZ4Q5Ns(long arg0, int other) {
        return UnsignedUtils.m7413ulongDivideeb3DHEI(arg0, m7280constructorimpl(((long) other) & 4294967295L));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m7245divVKZWuLQ(long arg0, long other) {
        return UnsignedUtils.m7413ulongDivideeb3DHEI(arg0, other);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final long m7246rem7apg3OU(long arg0, byte other) {
        return UnsignedUtils.m7414ulongRemaindereb3DHEI(arg0, m7280constructorimpl(((long) other) & 255));
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final long m7247remxj2QHRw(long arg0, short other) {
        return UnsignedUtils.m7414ulongRemaindereb3DHEI(arg0, m7280constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final long m7248remWZ4Q5Ns(long arg0, int other) {
        return UnsignedUtils.m7414ulongRemaindereb3DHEI(arg0, m7280constructorimpl(((long) other) & 4294967295L));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m7249remVKZWuLQ(long arg0, long other) {
        return UnsignedUtils.m7414ulongRemaindereb3DHEI(arg0, other);
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final long m7250floorDiv7apg3OU(long arg0, byte other) {
        return UnsignedUtils.m7413ulongDivideeb3DHEI(arg0, m7280constructorimpl(((long) other) & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final long m7251floorDivxj2QHRw(long arg0, short other) {
        return UnsignedUtils.m7413ulongDivideeb3DHEI(arg0, m7280constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final long m7252floorDivWZ4Q5Ns(long arg0, int other) {
        return UnsignedUtils.m7413ulongDivideeb3DHEI(arg0, m7280constructorimpl(((long) other) & 4294967295L));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m7253floorDivVKZWuLQ(long arg0, long other) {
        return UnsignedUtils.m7413ulongDivideeb3DHEI(arg0, other);
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m7254mod7apg3OU(long arg0, byte other) {
        return UByte.m7122constructorimpl((byte) ((int) UnsignedUtils.m7414ulongRemaindereb3DHEI(arg0, m7280constructorimpl(((long) other) & 255))));
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m7255modxj2QHRw(long arg0, short other) {
        return UShort.m7386constructorimpl((short) ((int) UnsignedUtils.m7414ulongRemaindereb3DHEI(arg0, m7280constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX))));
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m7256modWZ4Q5Ns(long arg0, int other) {
        return UInt.m7201constructorimpl((int) UnsignedUtils.m7414ulongRemaindereb3DHEI(arg0, m7280constructorimpl(((long) other) & 4294967295L)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m7257modVKZWuLQ(long arg0, long other) {
        return UnsignedUtils.m7414ulongRemaindereb3DHEI(arg0, other);
    }

    @InlineOnly
    /* renamed from: inc-s-VKNKU  reason: not valid java name */
    private static final long m7258incsVKNKU(long arg0) {
        return m7280constructorimpl(arg0 + 1);
    }

    @InlineOnly
    /* renamed from: dec-s-VKNKU  reason: not valid java name */
    private static final long m7259decsVKNKU(long arg0) {
        return m7280constructorimpl(arg0 - 1);
    }

    @InlineOnly
    /* renamed from: rangeTo-VKZWuLQ  reason: not valid java name */
    private static final ULongRange m7260rangeToVKZWuLQ(long arg0, long other) {
        return new ULongRange(arg0, other, null);
    }

    @InlineOnly
    /* renamed from: shl-s-VKNKU  reason: not valid java name */
    private static final long m7261shlsVKNKU(long arg0, int bitCount) {
        return m7280constructorimpl(arg0 << bitCount);
    }

    @InlineOnly
    /* renamed from: shr-s-VKNKU  reason: not valid java name */
    private static final long m7262shrsVKNKU(long arg0, int bitCount) {
        return m7280constructorimpl(arg0 >>> bitCount);
    }

    @InlineOnly
    /* renamed from: and-VKZWuLQ  reason: not valid java name */
    private static final long m7263andVKZWuLQ(long arg0, long other) {
        return m7280constructorimpl(arg0 & other);
    }

    @InlineOnly
    /* renamed from: or-VKZWuLQ  reason: not valid java name */
    private static final long m7264orVKZWuLQ(long arg0, long other) {
        return m7280constructorimpl(arg0 | other);
    }

    @InlineOnly
    /* renamed from: xor-VKZWuLQ  reason: not valid java name */
    private static final long m7265xorVKZWuLQ(long arg0, long other) {
        return m7280constructorimpl(arg0 ^ other);
    }

    @InlineOnly
    /* renamed from: inv-s-VKNKU  reason: not valid java name */
    private static final long m7266invsVKNKU(long arg0) {
        return m7280constructorimpl(arg0 ^ -1);
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m7267toByteimpl(long arg0) {
        return (byte) ((int) arg0);
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m7268toShortimpl(long arg0) {
        return (short) ((int) arg0);
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m7269toIntimpl(long arg0) {
        return (int) arg0;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m7270toLongimpl(long arg0) {
        return arg0;
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m7271toUBytew2LRezQ(long arg0) {
        return UByte.m7122constructorimpl((byte) ((int) arg0));
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m7272toUShortMh2AYeg(long arg0) {
        return UShort.m7386constructorimpl((short) ((int) arg0));
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m7273toUIntpVg5ArA(long arg0) {
        return UInt.m7201constructorimpl((int) arg0);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m7274toULongsVKNKU(long arg0) {
        return arg0;
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m7275toFloatimpl(long arg0) {
        return (float) UnsignedUtils.ulongToDouble(arg0);
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m7276toDoubleimpl(long arg0) {
        return UnsignedUtils.ulongToDouble(arg0);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7277toStringimpl(long arg0) {
        return UnsignedUtils.ulongToString(arg0);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return m7277toStringimpl(this.data);
    }
}
