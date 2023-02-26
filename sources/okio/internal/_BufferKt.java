package okio.internal;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio._JvmPlatformKt;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.FileAppender;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

/* compiled from: -Buffer.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u0001\n��\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH��\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\b\u001a\r\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\b\u001a\r\u0010\u0018\u001a\u00020\u0007*\u00020\u0015H\b\u001a\r\u0010\u0019\u001a\u00020\u0015*\u00020\u0015H\b\u001a%\u0010\u001a\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\u0017\u0010\u001e\u001a\u00020\f*\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\b\u001a\u0015\u0010!\u001a\u00020\u0007*\u00020\u00172\u0006\u0010\"\u001a\u00020\nH\b\u001a\u0015\u0010#\u001a\u00020$*\u00020\u00152\u0006\u0010%\u001a\u00020\u0007H\b\u001a\r\u0010&\u001a\u00020\n*\u00020\u0015H\b\u001a%\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\b\u001a\u001d\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\b\u001a\u001d\u0010,\u001a\u00020\u0007*\u00020\u00152\u0006\u0010-\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\b\u001a\r\u0010.\u001a\u00020\n*\u00020\u0017H\b\u001a-\u0010/\u001a\u00020\f*\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\b\u001a\u0015\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\b\u001a%\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\b\u001a\u001d\u00100\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\u0015\u00102\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u000203H\b\u001a\u0014\u00104\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H��\u001a\r\u00106\u001a\u00020$*\u00020\u0015H\b\u001a\r\u00107\u001a\u00020\u0001*\u00020\u0015H\b\u001a\u0015\u00107\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u00108\u001a\u00020+*\u00020\u0015H\b\u001a\u0015\u00108\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u00109\u001a\u00020\u0007*\u00020\u0015H\b\u001a\u0015\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\b\u001a\u001d\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u0010;\u001a\u00020\u0007*\u00020\u0015H\b\u001a\r\u0010<\u001a\u00020\n*\u00020\u0015H\b\u001a\r\u0010=\u001a\u00020\u0007*\u00020\u0015H\b\u001a\r\u0010>\u001a\u00020?*\u00020\u0015H\b\u001a\u0014\u0010@\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H��\u001a\u0015\u0010A\u001a\u00020B*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u0010C\u001a\u00020\n*\u00020\u0015H\b\u001a\u000f\u0010D\u001a\u0004\u0018\u00010B*\u00020\u0015H\b\u001a\u0015\u0010E\u001a\u00020B*\u00020\u00152\u0006\u0010F\u001a\u00020\u0007H\b\u001a\u0015\u0010G\u001a\u00020\u0007*\u00020\u00172\u0006\u0010H\u001a\u00020\u0007H\b\u001a\u0015\u0010I\u001a\u00020\n*\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0007H\b\u001a\u0015\u0010J\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020LH\b\u001a\u0015\u0010M\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u0010N\u001a\u00020+*\u00020\u0015H\b\u001a\u0015\u0010N\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\nH\b\u001a\u0015\u0010O\u001a\u00020\u000e*\u00020\u00152\u0006\u0010P\u001a\u00020\nH\b\u001a\u0015\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u0001H\b\u001a%\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\b\u001a\u001d\u0010Q\u001a\u00020\u0014*\u00020\u00152\u0006\u0010R\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a)\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010S\u001a\u00020+2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\nH\b\u001a\u001d\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020T2\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\u0015\u0010U\u001a\u00020\u0007*\u00020\u00152\u0006\u0010R\u001a\u00020TH\b\u001a\u0015\u0010V\u001a\u00020\u0015*\u00020\u00152\u0006\u0010(\u001a\u00020\nH\b\u001a\u0015\u0010W\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\b\u001a\u0015\u0010Y\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\b\u001a\u0015\u0010Z\u001a\u00020\u0015*\u00020\u00152\u0006\u0010[\u001a\u00020\nH\b\u001a\u0015\u0010\\\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\b\u001a\u0015\u0010]\u001a\u00020\u0015*\u00020\u00152\u0006\u0010^\u001a\u00020\nH\b\u001a%\u0010_\u001a\u00020\u0015*\u00020\u00152\u0006\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\b\u001a\u0015\u0010c\u001a\u00020\u0015*\u00020\u00152\u0006\u0010d\u001a\u00020\nH\b\u001a\u0014\u0010e\u001a\u00020B*\u00020\u00152\u0006\u0010f\u001a\u00020\u0007H��\u001a?\u0010g\u001a\u0002Hh\"\u0004\b��\u0010h*\u00020\u00152\u0006\u0010)\u001a\u00020\u00072\u001a\u0010i\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002Hh0jH\bø\u0001��¢\u0006\u0002\u0010k\u001a\u001e\u0010l\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020L2\b\b\u0002\u0010m\u001a\u00020\fH��\"\u001c\u0010��\u001a\u00020\u00018��X\u0004¢\u0006\u000e\n��\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n��\"\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n��\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n��\u0002\u0007\n\u0005\b20\u0001¨\u0006n"}, m373d2 = {"HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES$annotations", "()V", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_DIGIT_START", "", "OVERFLOW_ZONE", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "commonClear", "", "Lokio/Buffer;", "commonClose", "Lokio/Buffer$UnsafeCursor;", "commonCompleteSegmentByteCount", "commonCopy", "commonCopyTo", "out", "offset", "byteCount", "commonEquals", "other", "", "commonExpandBuffer", "minByteCount", "commonGet", "", "pos", "commonHashCode", "commonIndexOf", "b", "fromIndex", "toIndex", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonNext", "commonRangeEquals", "commonRead", "sink", "commonReadAll", "Lokio/Sink;", "commonReadAndWriteUnsafe", "unsafeCursor", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadLong", "commonReadShort", "", "commonReadUnsafe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonResizeBuffer", "newSize", "commonSeek", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonSnapshot", "commonWritableSegment", "minimumCapacity", "commonWrite", "source", "byteString", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", IntegerTokenConverter.CONVERTER_KEY, "commonWriteLong", "commonWriteShort", "s", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "readUtf8Line", "newline", "seek", "T", "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "selectTruncated", "okio"})
/* loaded from: grasscutter.jar:okio/internal/_BufferKt.class */
public final class _BufferKt {
    @NotNull
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
    public static final int SEGMENTING_THRESHOLD;
    public static final long OVERFLOW_ZONE;
    public static final long OVERFLOW_DIGIT_START;

    public static /* synthetic */ void getHEX_DIGIT_BYTES$annotations() {
    }

    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(@NotNull Segment segment, int segmentPos, @NotNull byte[] bytes, int bytesOffset, int bytesLimit) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Segment segment2 = segment;
        int segmentPos2 = segmentPos;
        int segmentLimit = segment2.limit;
        byte[] data = segment2.data;
        for (int i = bytesOffset; i < bytesLimit; i++) {
            if (segmentPos2 == segmentLimit) {
                Segment segment3 = segment2.next;
                Intrinsics.checkNotNull(segment3);
                segment2 = segment3;
                data = segment2.data;
                segmentPos2 = segment2.pos;
                segmentLimit = segment2.limit;
            }
            if (data[segmentPos2] != bytes[i]) {
                return false;
            }
            segmentPos2++;
        }
        return true;
    }

    @NotNull
    public static final String readUtf8Line(@NotNull Buffer $this$readUtf8Line, long newline) {
        Intrinsics.checkNotNullParameter($this$readUtf8Line, "<this>");
        if (newline <= 0 || $this$readUtf8Line.getByte(newline - 1) != ((byte) 13)) {
            String result = $this$readUtf8Line.readUtf8(newline);
            $this$readUtf8Line.skip(1);
            return result;
        }
        String result2 = $this$readUtf8Line.readUtf8(newline - 1);
        $this$readUtf8Line.skip(2);
        return result2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T seek(@org.jetbrains.annotations.NotNull okio.Buffer r5, long r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super okio.Segment, ? super java.lang.Long, ? extends T> r8) {
        /*
            r0 = r5
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r8
            java.lang.String r1 = "lambda"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r9 = r0
            r0 = r5
            okio.Segment r0 = r0.head
            r11 = r0
            r0 = r11
            if (r0 != 0) goto L_0x0028
            r0 = r8
            r1 = 0
            r2 = -1
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.Object r0 = r0.invoke(r1, r2)
            return r0
        L_0x0028:
            r0 = r11
            r10 = r0
            r0 = r5
            long r0 = r0.size()
            r1 = r6
            long r0 = r0 - r1
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0071
            r0 = r5
            long r0 = r0.size()
            r11 = r0
        L_0x003d:
            r0 = r11
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0063
            r0 = r10
            okio.Segment r0 = r0.prev
            r1 = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r10 = r0
            r0 = r11
            r1 = r10
            int r1 = r1.limit
            r2 = r10
            int r2 = r2.pos
            int r1 = r1 - r2
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x003d
        L_0x0063:
            r0 = r8
            r1 = r10
            r2 = r11
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.Object r0 = r0.invoke(r1, r2)
            return r0
        L_0x0071:
            r0 = 0
            r11 = r0
        L_0x0074:
            r0 = r11
            r1 = r10
            int r1 = r1.limit
            r2 = r10
            int r2 = r2.pos
            int r1 = r1 - r2
            long r1 = (long) r1
            long r0 = r0 + r1
            r13 = r0
            r0 = r13
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0090
            goto L_0x00a2
        L_0x0090:
            r0 = r10
            okio.Segment r0 = r0.next
            r1 = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r10 = r0
            r0 = r13
            r11 = r0
            goto L_0x0074
        L_0x00a2:
            r0 = r8
            r1 = r10
            r2 = r11
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.Object r0 = r0.invoke(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.seek(okio.Buffer, long, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int selectPrefix(@NotNull Buffer $this$selectPrefix, @NotNull Options options, boolean selectTruncated) {
        int nextStep;
        boolean scanComplete;
        Intrinsics.checkNotNullParameter($this$selectPrefix, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Segment head = $this$selectPrefix.head;
        if (head == null) {
            return selectTruncated ? -2 : -1;
        }
        Segment s = head;
        byte[] data = head.data;
        int pos = head.pos;
        int limit = head.limit;
        int[] trie = options.getTrie$okio();
        int triePos = 0;
        int prefixIndex = -1;
        loop0: while (true) {
            int triePos2 = triePos + 1;
            int scanOrSelect = trie[triePos];
            int triePos3 = triePos2 + 1;
            int possiblePrefixIndex = trie[triePos2];
            if (possiblePrefixIndex != -1) {
                prefixIndex = possiblePrefixIndex;
            }
            if (s == null) {
                break;
            }
            if (scanOrSelect < 0) {
                int trieLimit = triePos3 + (-1 * scanOrSelect);
                do {
                    pos++;
                    triePos3++;
                    if ((data[pos] & 255) != trie[triePos3]) {
                        return prefixIndex;
                    }
                    scanComplete = triePos3 == trieLimit;
                    if (pos == limit) {
                        Intrinsics.checkNotNull(s);
                        Segment segment = s.next;
                        Intrinsics.checkNotNull(segment);
                        s = segment;
                        pos = s.pos;
                        data = s.data;
                        limit = s.limit;
                        if (s == head) {
                            if (!scanComplete) {
                                break loop0;
                            }
                            s = null;
                        }
                    }
                } while (!scanComplete);
                nextStep = trie[triePos3];
            } else {
                pos++;
                int i = data[pos] & 255;
                int selectLimit = triePos3 + scanOrSelect;
                while (triePos3 != selectLimit) {
                    if (i == trie[triePos3]) {
                        nextStep = trie[triePos3 + scanOrSelect];
                        if (pos == limit) {
                            Segment segment2 = s.next;
                            Intrinsics.checkNotNull(segment2);
                            s = segment2;
                            pos = s.pos;
                            data = s.data;
                            limit = s.limit;
                            if (s == head) {
                                s = null;
                            }
                        }
                    } else {
                        triePos3++;
                    }
                }
                return prefixIndex;
            }
            if (nextStep >= 0) {
                return nextStep;
            }
            triePos = -nextStep;
        }
        if (selectTruncated) {
            return -2;
        }
        return prefixIndex;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARN: Type inference failed for: r0v39, types: [long] */
    @NotNull
    public static final Buffer commonCopyTo(@NotNull Buffer $this$commonCopyTo, @NotNull Buffer out, long offset, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonCopyTo, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        char c = offset;
        char c2 = byteCount;
        _UtilKt.checkOffsetAndCount($this$commonCopyTo.size(), c, c2);
        if (c2 == 0) {
            return $this$commonCopyTo;
        }
        out.setSize$okio(out.size() + c2);
        Segment s = $this$commonCopyTo.head;
        while (true) {
            Intrinsics.checkNotNull(s);
            if (c >= ((long) (s.limit - s.pos))) {
                c -= (long) (s.limit - s.pos);
                s = s.next;
            }
        }
        while (c2 > 0) {
            Intrinsics.checkNotNull(s);
            Segment copy = s.sharedCopy();
            copy.pos += (int) c;
            copy.limit = Math.min(copy.pos + ((int) c2), copy.limit);
            if (out.head == null) {
                copy.prev = copy;
                copy.next = copy.prev;
                out.head = copy.next;
            } else {
                Segment segment = out.head;
                Intrinsics.checkNotNull(segment);
                Segment segment2 = segment.prev;
                Intrinsics.checkNotNull(segment2);
                segment2.push(copy);
            }
            c2 -= (long) (copy.limit - copy.pos);
            c = 0;
            s = s.next;
        }
        return $this$commonCopyTo;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    public static final long commonCompleteSegmentByteCount(@NotNull Buffer $this$commonCompleteSegmentByteCount) {
        Intrinsics.checkNotNullParameter($this$commonCompleteSegmentByteCount, "<this>");
        char size = $this$commonCompleteSegmentByteCount.size();
        if (size == 0) {
            return 0;
        }
        Segment segment = $this$commonCompleteSegmentByteCount.head;
        Intrinsics.checkNotNull(segment);
        Segment tail = segment.prev;
        Intrinsics.checkNotNull(tail);
        if (tail.limit < 8192 && tail.owner) {
            size -= (long) (tail.limit - tail.pos);
        }
        return size;
    }

    public static final byte commonReadByte(@NotNull Buffer $this$commonReadByte) {
        Intrinsics.checkNotNullParameter($this$commonReadByte, "<this>");
        if ($this$commonReadByte.size() == 0) {
            throw new EOFException();
        }
        Segment segment = $this$commonReadByte.head;
        Intrinsics.checkNotNull(segment);
        int pos = segment.pos;
        int limit = segment.limit;
        int pos2 = pos + 1;
        byte b = segment.data[pos];
        $this$commonReadByte.setSize$okio($this$commonReadByte.size() - 1);
        if (pos2 == limit) {
            $this$commonReadByte.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos2;
        }
        return b;
    }

    public static final short commonReadShort(@NotNull Buffer $this$commonReadShort) {
        Intrinsics.checkNotNullParameter($this$commonReadShort, "<this>");
        if ($this$commonReadShort.size() < 2) {
            throw new EOFException();
        }
        Segment segment = $this$commonReadShort.head;
        Intrinsics.checkNotNull(segment);
        int pos = segment.pos;
        int limit = segment.limit;
        if (limit - pos < 2) {
            return (short) ((($this$commonReadShort.readByte() & 255) << 8) | ($this$commonReadShort.readByte() & 255));
        }
        byte[] data = segment.data;
        int pos2 = pos + 1;
        int pos3 = pos2 + 1;
        int s = ((data[pos] & 255) << 8) | (data[pos2] & 255);
        $this$commonReadShort.setSize$okio($this$commonReadShort.size() - 2);
        if (pos3 == limit) {
            $this$commonReadShort.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos3;
        }
        return (short) s;
    }

    public static final int commonReadInt(@NotNull Buffer $this$commonReadInt) {
        Intrinsics.checkNotNullParameter($this$commonReadInt, "<this>");
        if ($this$commonReadInt.size() < 4) {
            throw new EOFException();
        }
        Segment segment = $this$commonReadInt.head;
        Intrinsics.checkNotNull(segment);
        int pos = segment.pos;
        int limit = segment.limit;
        if (((long) (limit - pos)) < 4) {
            return (($this$commonReadInt.readByte() & 255) << 24) | (($this$commonReadInt.readByte() & 255) << 16) | (($this$commonReadInt.readByte() & 255) << 8) | ($this$commonReadInt.readByte() & 255);
        }
        byte[] data = segment.data;
        int pos2 = pos + 1;
        int pos3 = pos2 + 1;
        int pos4 = pos3 + 1;
        int pos5 = pos4 + 1;
        int i = ((data[pos] & 255) << 24) | ((data[pos2] & 255) << 16) | ((data[pos3] & 255) << 8) | (data[pos4] & 255);
        $this$commonReadInt.setSize$okio($this$commonReadInt.size() - 4);
        if (pos5 == limit) {
            $this$commonReadInt.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos5;
        }
        return i;
    }

    public static final long commonReadLong(@NotNull Buffer $this$commonReadLong) {
        Intrinsics.checkNotNullParameter($this$commonReadLong, "<this>");
        if ($this$commonReadLong.size() < 8) {
            throw new EOFException();
        }
        Segment segment = $this$commonReadLong.head;
        Intrinsics.checkNotNull(segment);
        int pos = segment.pos;
        int limit = segment.limit;
        if (((long) (limit - pos)) < 8) {
            return ((((long) $this$commonReadLong.readInt()) & 4294967295L) << 32) | (((long) $this$commonReadLong.readInt()) & 4294967295L);
        }
        byte[] data = segment.data;
        int pos2 = pos + 1;
        int pos3 = pos2 + 1;
        int pos4 = pos3 + 1;
        int pos5 = pos4 + 1;
        int pos6 = pos5 + 1;
        int pos7 = pos6 + 1;
        int pos8 = pos7 + 1;
        int pos9 = pos8 + 1;
        long v = ((((long) data[pos]) & 255) << 56) | ((((long) data[pos2]) & 255) << 48) | ((((long) data[pos3]) & 255) << 40) | ((((long) data[pos4]) & 255) << 32) | ((((long) data[pos5]) & 255) << 24) | ((((long) data[pos6]) & 255) << 16) | ((((long) data[pos7]) & 255) << 8) | (((long) data[pos8]) & 255);
        $this$commonReadLong.setSize$okio($this$commonReadLong.size() - 8);
        if (pos9 == limit) {
            $this$commonReadLong.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos9;
        }
        return v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte commonGet(@org.jetbrains.annotations.NotNull okio.Buffer r7, long r8) {
        /*
        // Method dump skipped, instructions count: 250
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonGet(okio.Buffer, long):byte");
    }

    public static final void commonClear(@NotNull Buffer $this$commonClear) {
        Intrinsics.checkNotNullParameter($this$commonClear, "<this>");
        $this$commonClear.skip($this$commonClear.size());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    public static final void commonSkip(@NotNull Buffer $this$commonSkip, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonSkip, "<this>");
        char c = byteCount;
        while (c > 0) {
            Segment head = $this$commonSkip.head;
            if (head == null) {
                throw new EOFException();
            }
            int toSkip = (int) Math.min((long) c, (long) (head.limit - head.pos));
            $this$commonSkip.setSize$okio($this$commonSkip.size() - ((long) toSkip));
            c -= (long) toSkip;
            head.pos += toSkip;
            if (head.pos == head.limit) {
                $this$commonSkip.head = head.pop();
                SegmentPool.recycle(head);
            }
        }
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer $this$commonWrite_u24default, ByteString byteString, int offset, int byteCount, int i, Object obj) {
        if ((i & 2) != 0) {
            offset = 0;
        }
        if ((i & 4) != 0) {
            byteCount = byteString.size();
        }
        Intrinsics.checkNotNullParameter($this$commonWrite_u24default, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio($this$commonWrite_u24default, offset, byteCount);
        return $this$commonWrite_u24default;
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer $this$commonWrite, @NotNull ByteString byteString, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio($this$commonWrite, offset, byteCount);
        return $this$commonWrite;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [long] */
    /* JADX WARN: Type inference failed for: r0v88, types: [long] */
    @NotNull
    public static final Buffer commonWriteDecimalLong(@NotNull Buffer $this$commonWriteDecimalLong, long v) {
        int i;
        Intrinsics.checkNotNullParameter($this$commonWriteDecimalLong, "<this>");
        char c = v;
        if (c == 0) {
            return $this$commonWriteDecimalLong.writeByte(48);
        }
        boolean negative = false;
        if (c < 0) {
            c = -c;
            if (c < 0) {
                return $this$commonWriteDecimalLong.writeUtf8("-9223372036854775808");
            }
            negative = true;
        }
        if (c < 100000000) {
            if (c < AbstractComponentTracker.LINGERING_TIMEOUT) {
                if (c < 100) {
                    i = c < 10 ? 1 : 2;
                } else {
                    i = c < 1000 ? 3 : 4;
                }
            } else if (c < 1000000) {
                i = c < 100000 ? 5 : 6;
            } else {
                i = c < 10000000 ? 7 : 8;
            }
        } else if (c < 1000000000000L) {
            if (c < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                i = c < 1000000000 ? 9 : 10;
            } else {
                i = c < 100000000000L ? 11 : 12;
            }
        } else if (c < 1000000000000000L) {
            if (c < 10000000000000L) {
                i = 13;
            } else {
                i = c < 100000000000000L ? 14 : 15;
            }
        } else if (c < 100000000000000000L) {
            i = c < 10000000000000000L ? 16 : 17;
        } else {
            i = c < 1000000000000000000L ? 18 : 19;
        }
        int width = i;
        if (negative) {
            width++;
        }
        Segment tail = $this$commonWriteDecimalLong.writableSegment$okio(width);
        byte[] data = tail.data;
        int pos = tail.limit + width;
        while (c != 0) {
            pos--;
            data[pos] = getHEX_DIGIT_BYTES()[(int) (c % ((long) 10))];
            c /= (long) 10;
        }
        if (negative) {
            data[pos - 1] = (byte) 45;
        }
        tail.limit += width;
        $this$commonWriteDecimalLong.setSize$okio($this$commonWriteDecimalLong.size() + ((long) width));
        return $this$commonWriteDecimalLong;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v57, types: [long] */
    @NotNull
    public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull Buffer $this$commonWriteHexadecimalUnsignedLong, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteHexadecimalUnsignedLong, "<this>");
        char c = v;
        if (c == 0) {
            return $this$commonWriteHexadecimalUnsignedLong.writeByte(48);
        }
        long x = c | (c >>> 1);
        long x2 = x | (x >>> 2);
        long x3 = x2 | (x2 >>> 4);
        long x4 = x3 | (x3 >>> 8);
        long x5 = x4 | (x4 >>> 16);
        long x6 = x5 | (x5 >>> 32);
        long x7 = x6 - ((x6 >>> 1) & 6148914691236517205L);
        long x8 = ((x7 >>> 2) & 3689348814741910323L) + (x7 & 3689348814741910323L);
        long x9 = ((x8 >>> 4) + x8) & 1085102592571150095L;
        long x10 = x9 + (x9 >>> 8);
        long x11 = x10 + (x10 >>> 16);
        int width = (int) ((((x11 & 63) + ((x11 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment tail = $this$commonWriteHexadecimalUnsignedLong.writableSegment$okio(width);
        byte[] data = tail.data;
        int start = tail.limit;
        for (int pos = (tail.limit + width) - 1; pos >= start; pos--) {
            data[pos] = getHEX_DIGIT_BYTES()[(int) (c & 15)];
            c >>>= 4;
        }
        tail.limit += width;
        $this$commonWriteHexadecimalUnsignedLong.setSize$okio($this$commonWriteHexadecimalUnsignedLong.size() + ((long) width));
        return $this$commonWriteHexadecimalUnsignedLong;
    }

    @NotNull
    public static final Segment commonWritableSegment(@NotNull Buffer $this$commonWritableSegment, int minimumCapacity) {
        Intrinsics.checkNotNullParameter($this$commonWritableSegment, "<this>");
        if (!(minimumCapacity >= 1 && minimumCapacity <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        } else if ($this$commonWritableSegment.head == null) {
            Segment result = SegmentPool.take();
            $this$commonWritableSegment.head = result;
            result.prev = result;
            result.next = result;
            return result;
        } else {
            Segment segment = $this$commonWritableSegment.head;
            Intrinsics.checkNotNull(segment);
            Segment tail = segment.prev;
            Intrinsics.checkNotNull(tail);
            if (tail.limit + minimumCapacity > 8192 || !tail.owner) {
                tail = tail.push(SegmentPool.take());
            }
            return tail;
        }
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer $this$commonWrite, @NotNull byte[] source) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return $this$commonWrite.write(source, 0, source.length);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer $this$commonWrite, @NotNull byte[] source, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int offset2 = offset;
        _UtilKt.checkOffsetAndCount((long) source.length, (long) offset2, (long) byteCount);
        int limit = offset2 + byteCount;
        while (offset2 < limit) {
            Segment tail = $this$commonWrite.writableSegment$okio(1);
            int toCopy = Math.min(limit - offset2, 8192 - tail.limit);
            ArraysKt.copyInto(source, tail.data, tail.limit, offset2, offset2 + toCopy);
            offset2 += toCopy;
            tail.limit += toCopy;
        }
        $this$commonWrite.setSize$okio($this$commonWrite.size() + ((long) byteCount));
        return $this$commonWrite;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer $this$commonReadByteArray) {
        Intrinsics.checkNotNullParameter($this$commonReadByteArray, "<this>");
        return $this$commonReadByteArray.readByteArray($this$commonReadByteArray.size());
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer $this$commonReadByteArray, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonReadByteArray, "<this>");
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(byteCount)).toString());
        } else if ($this$commonReadByteArray.size() < byteCount) {
            throw new EOFException();
        } else {
            byte[] result = new byte[(int) byteCount];
            $this$commonReadByteArray.readFully(result);
            return result;
        }
    }

    public static final int commonRead(@NotNull Buffer $this$commonRead, @NotNull byte[] sink) {
        Intrinsics.checkNotNullParameter($this$commonRead, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        return $this$commonRead.read(sink, 0, sink.length);
    }

    public static final void commonReadFully(@NotNull Buffer $this$commonReadFully, @NotNull byte[] sink) {
        Intrinsics.checkNotNullParameter($this$commonReadFully, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int offset = 0;
        while (offset < sink.length) {
            int read = $this$commonReadFully.read(sink, offset, sink.length - offset);
            if (read == -1) {
                throw new EOFException();
            }
            offset += read;
        }
    }

    public static final int commonRead(@NotNull Buffer $this$commonRead, @NotNull byte[] sink, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRead, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        _UtilKt.checkOffsetAndCount((long) sink.length, (long) offset, (long) byteCount);
        Segment s = $this$commonRead.head;
        if (s == null) {
            return -1;
        }
        int toCopy = Math.min(byteCount, s.limit - s.pos);
        ArraysKt.copyInto(s.data, sink, offset, s.pos, s.pos + toCopy);
        s.pos += toCopy;
        $this$commonRead.setSize$okio($this$commonRead.size() - ((long) toCopy));
        if (s.pos == s.limit) {
            $this$commonRead.head = s.pop();
            SegmentPool.recycle(s);
        }
        return toCopy;
    }

    /* JADX WARN: Type inference failed for: r0v60, types: [long] */
    /* JADX WARN: Type inference failed for: r0v81, types: [long] */
    public static final long commonReadDecimalLong(@NotNull Buffer $this$commonReadDecimalLong) {
        Intrinsics.checkNotNullParameter($this$commonReadDecimalLong, "<this>");
        if ($this$commonReadDecimalLong.size() == 0) {
            throw new EOFException();
        }
        char c = 0;
        int seen = 0;
        boolean negative = false;
        boolean done = false;
        char c2 = 65529;
        do {
            Segment segment = $this$commonReadDecimalLong.head;
            Intrinsics.checkNotNull(segment);
            byte[] data = segment.data;
            int pos = segment.pos;
            int limit = segment.limit;
            while (pos < limit) {
                byte b = data[pos];
                if (b >= ((byte) 48) && b <= ((byte) 57)) {
                    int digit = ((byte) 48) - b;
                    if (c < OVERFLOW_ZONE || (c == OVERFLOW_ZONE && ((long) digit) < c2)) {
                        Buffer buffer = new Buffer().writeDecimalLong((long) c).writeByte((int) b);
                        if (!negative) {
                            buffer.readByte();
                        }
                        throw new NumberFormatException(Intrinsics.stringPlus("Number too large: ", buffer.readUtf8()));
                    }
                    c = (c * '\n') + ((long) digit);
                } else if (b != ((byte) 45) || seen != 0) {
                    done = true;
                    break;
                } else {
                    negative = true;
                    c2--;
                }
                pos++;
                seen++;
            }
            if (pos == limit) {
                $this$commonReadDecimalLong.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = pos;
            }
            if (done) {
                break;
            }
        } while ($this$commonReadDecimalLong.head != null);
        $this$commonReadDecimalLong.setSize$okio($this$commonReadDecimalLong.size() - ((long) seen));
        if (seen >= (negative ? 2 : 1)) {
            return negative ? c : -c;
        }
        if ($this$commonReadDecimalLong.size() == 0) {
            throw new EOFException();
        }
        throw new NumberFormatException((negative ? "Expected a digit" : "Expected a digit or '-'") + " but was 0x" + _UtilKt.toHexString($this$commonReadDecimalLong.getByte(0)));
    }

    /* JADX WARN: Type inference failed for: r0v41, types: [long] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0180 A[EDGE_INSN: B:47:0x0180->B:43:0x0180 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadHexadecimalUnsignedLong(@org.jetbrains.annotations.NotNull okio.Buffer r6) {
        /*
        // Method dump skipped, instructions count: 403
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer $this$commonReadByteString) {
        Intrinsics.checkNotNullParameter($this$commonReadByteString, "<this>");
        return $this$commonReadByteString.readByteString($this$commonReadByteString.size());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer $this$commonReadByteString, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonReadByteString, "<this>");
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(byteCount)).toString());
        } else if ($this$commonReadByteString.size() < byteCount) {
            throw new EOFException();
        } else if (byteCount < 4096) {
            return new ByteString($this$commonReadByteString.readByteArray(byteCount));
        } else {
            ByteString snapshot = $this$commonReadByteString.snapshot((int) byteCount);
            $this$commonReadByteString.skip(byteCount);
            return snapshot;
        }
    }

    public static final int commonSelect(@NotNull Buffer $this$commonSelect, @NotNull Options options) {
        Intrinsics.checkNotNullParameter($this$commonSelect, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        int index = selectPrefix$default($this$commonSelect, options, false, 2, null);
        if (index == -1) {
            return -1;
        }
        $this$commonSelect.skip((long) options.getByteStrings$okio()[index].size());
        return index;
    }

    public static final void commonReadFully(@NotNull Buffer $this$commonReadFully, @NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonReadFully, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if ($this$commonReadFully.size() < byteCount) {
            sink.write($this$commonReadFully, $this$commonReadFully.size());
            throw new EOFException();
        } else {
            sink.write($this$commonReadFully, byteCount);
        }
    }

    public static final long commonReadAll(@NotNull Buffer $this$commonReadAll, @NotNull Sink sink) {
        Intrinsics.checkNotNullParameter($this$commonReadAll, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long byteCount = $this$commonReadAll.size();
        if (byteCount > 0) {
            sink.write($this$commonReadAll, byteCount);
        }
        return byteCount;
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull Buffer $this$commonReadUtf8, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8, "<this>");
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(byteCount)).toString());
        } else if ($this$commonReadUtf8.size() < byteCount) {
            throw new EOFException();
        } else if (byteCount == 0) {
            return "";
        } else {
            Segment s = $this$commonReadUtf8.head;
            Intrinsics.checkNotNull(s);
            if (((long) s.pos) + byteCount > ((long) s.limit)) {
                return _Utf8Kt.commonToUtf8String$default($this$commonReadUtf8.readByteArray(byteCount), 0, 0, 3, null);
            }
            String result = _Utf8Kt.commonToUtf8String(s.data, s.pos, s.pos + ((int) byteCount));
            s.pos += (int) byteCount;
            $this$commonReadUtf8.setSize$okio($this$commonReadUtf8.size() - byteCount);
            if (s.pos == s.limit) {
                $this$commonReadUtf8.head = s.pop();
                SegmentPool.recycle(s);
            }
            return result;
        }
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull Buffer $this$commonReadUtf8Line) {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8Line, "<this>");
        long newline = $this$commonReadUtf8Line.indexOf((byte) 10);
        if (newline != -1) {
            return readUtf8Line($this$commonReadUtf8Line, newline);
        }
        if ($this$commonReadUtf8Line.size() != 0) {
            return $this$commonReadUtf8Line.readUtf8($this$commonReadUtf8Line.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull Buffer $this$commonReadUtf8LineStrict, long limit) {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8LineStrict, "<this>");
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("limit < 0: ", Long.valueOf(limit)).toString());
        }
        long scanLength = limit == LongCompanionObject.MAX_VALUE ? LongCompanionObject.MAX_VALUE : limit + 1;
        long newline = $this$commonReadUtf8LineStrict.indexOf((byte) 10, 0, scanLength);
        if (newline != -1) {
            return readUtf8Line($this$commonReadUtf8LineStrict, newline);
        }
        if (scanLength < $this$commonReadUtf8LineStrict.size() && $this$commonReadUtf8LineStrict.getByte(scanLength - 1) == ((byte) 13) && $this$commonReadUtf8LineStrict.getByte(scanLength) == ((byte) 10)) {
            return readUtf8Line($this$commonReadUtf8LineStrict, scanLength);
        }
        Buffer data = new Buffer();
        $this$commonReadUtf8LineStrict.copyTo(data, 0, Math.min((long) 32, $this$commonReadUtf8LineStrict.size()));
        throw new EOFException("\\n not found: limit=" + Math.min($this$commonReadUtf8LineStrict.size(), limit) + " content=" + data.readByteString().hex() + (char) 8230);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x01a4 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int commonReadUtf8CodePoint(@org.jetbrains.annotations.NotNull okio.Buffer r6) {
        /*
        // Method dump skipped, instructions count: 472
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonReadUtf8CodePoint(okio.Buffer):int");
    }

    @NotNull
    public static final Buffer commonWriteUtf8(@NotNull Buffer $this$commonWriteUtf8, @NotNull String string, int beginIndex, int endIndex) {
        int c;
        Intrinsics.checkNotNullParameter($this$commonWriteUtf8, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("beginIndex < 0: ", Integer.valueOf(beginIndex)).toString());
        }
        if (!(endIndex >= beginIndex)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (!(endIndex <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        int i = beginIndex;
        while (i < endIndex) {
            int c2 = string.charAt(i);
            if (c2 < 128) {
                Segment tail = $this$commonWriteUtf8.writableSegment$okio(1);
                byte[] data = tail.data;
                int segmentOffset = tail.limit - i;
                int runLimit = Math.min(endIndex, 8192 - segmentOffset);
                i++;
                data[segmentOffset + i] = (byte) c2;
                while (i < runLimit && (c = string.charAt(i)) < 128) {
                    i++;
                    data[segmentOffset + i] = (byte) c;
                }
                int runSize = (i + segmentOffset) - tail.limit;
                tail.limit += runSize;
                $this$commonWriteUtf8.setSize$okio($this$commonWriteUtf8.size() + ((long) runSize));
            } else if (c2 < 2048) {
                Segment tail2 = $this$commonWriteUtf8.writableSegment$okio(2);
                tail2.data[tail2.limit] = (byte) ((c2 >> 6) | 192);
                tail2.data[tail2.limit + 1] = (byte) ((c2 & 63) | 128);
                tail2.limit += 2;
                $this$commonWriteUtf8.setSize$okio($this$commonWriteUtf8.size() + 2);
                i++;
            } else if (c2 < 55296 || c2 > 57343) {
                Segment tail3 = $this$commonWriteUtf8.writableSegment$okio(3);
                tail3.data[tail3.limit] = (byte) ((c2 >> 12) | PacketOpcodes.SceneAvatarStaminaStepRsp);
                tail3.data[tail3.limit + 1] = (byte) (((c2 >> 6) & 63) | 128);
                tail3.data[tail3.limit + 2] = (byte) ((c2 & 63) | 128);
                tail3.limit += 3;
                $this$commonWriteUtf8.setSize$okio($this$commonWriteUtf8.size() + 3);
                i++;
            } else {
                int low = i + 1 < endIndex ? string.charAt(i + 1) : 0;
                if (c2 <= 56319) {
                    if (56320 <= low ? low <= 57343 : false) {
                        int codePoint = 65536 + (((c2 & 1023) << 10) | (low & 1023));
                        Segment tail4 = $this$commonWriteUtf8.writableSegment$okio(4);
                        tail4.data[tail4.limit] = (byte) ((codePoint >> 18) | PacketOpcodes.SceneKickPlayerRsp);
                        tail4.data[tail4.limit + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                        tail4.data[tail4.limit + 2] = (byte) (((codePoint >> 6) & 63) | 128);
                        tail4.data[tail4.limit + 3] = (byte) ((codePoint & 63) | 128);
                        tail4.limit += 4;
                        $this$commonWriteUtf8.setSize$okio($this$commonWriteUtf8.size() + 4);
                        i += 2;
                    }
                }
                $this$commonWriteUtf8.writeByte(63);
                i++;
            }
        }
        return $this$commonWriteUtf8;
    }

    @NotNull
    public static final Buffer commonWriteUtf8CodePoint(@NotNull Buffer $this$commonWriteUtf8CodePoint, int codePoint) {
        Intrinsics.checkNotNullParameter($this$commonWriteUtf8CodePoint, "<this>");
        if (codePoint < 128) {
            $this$commonWriteUtf8CodePoint.writeByte(codePoint);
        } else if (codePoint < 2048) {
            Segment tail = $this$commonWriteUtf8CodePoint.writableSegment$okio(2);
            tail.data[tail.limit] = (byte) ((codePoint >> 6) | 192);
            tail.data[tail.limit + 1] = (byte) ((codePoint & 63) | 128);
            tail.limit += 2;
            $this$commonWriteUtf8CodePoint.setSize$okio($this$commonWriteUtf8CodePoint.size() + 2);
        } else {
            if (55296 <= codePoint ? codePoint <= 57343 : false) {
                $this$commonWriteUtf8CodePoint.writeByte(63);
            } else if (codePoint < 65536) {
                Segment tail2 = $this$commonWriteUtf8CodePoint.writableSegment$okio(3);
                tail2.data[tail2.limit] = (byte) ((codePoint >> 12) | PacketOpcodes.SceneAvatarStaminaStepRsp);
                tail2.data[tail2.limit + 1] = (byte) (((codePoint >> 6) & 63) | 128);
                tail2.data[tail2.limit + 2] = (byte) ((codePoint & 63) | 128);
                tail2.limit += 3;
                $this$commonWriteUtf8CodePoint.setSize$okio($this$commonWriteUtf8CodePoint.size() + 3);
            } else if (codePoint <= 1114111) {
                Segment tail3 = $this$commonWriteUtf8CodePoint.writableSegment$okio(4);
                tail3.data[tail3.limit] = (byte) ((codePoint >> 18) | PacketOpcodes.SceneKickPlayerRsp);
                tail3.data[tail3.limit + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                tail3.data[tail3.limit + 2] = (byte) (((codePoint >> 6) & 63) | 128);
                tail3.data[tail3.limit + 3] = (byte) ((codePoint & 63) | 128);
                tail3.limit += 4;
                $this$commonWriteUtf8CodePoint.setSize$okio($this$commonWriteUtf8CodePoint.size() + 4);
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected code point: 0x", _UtilKt.toHexString(codePoint)));
            }
        }
        return $this$commonWriteUtf8CodePoint;
    }

    public static final long commonWriteAll(@NotNull Buffer $this$commonWriteAll, @NotNull Source source) {
        Intrinsics.checkNotNullParameter($this$commonWriteAll, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long totalBytesRead = 0;
        while (true) {
            long readCount = source.read($this$commonWriteAll, FileAppender.DEFAULT_BUFFER_SIZE);
            if (readCount == -1) {
                return totalBytesRead;
            }
            totalBytesRead += readCount;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [okio.Source, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.Buffer commonWrite(@org.jetbrains.annotations.NotNull okio.Buffer r5, @org.jetbrains.annotations.NotNull okio.Source r6, long r7) {
        /*
            r0 = r5
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r6
            java.lang.String r1 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r9 = r0
            r0 = r7
            r10 = r0
        L_0x0013:
            r0 = r10
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0040
            r0 = r6
            r1 = r5
            r2 = r10
            long r0 = r0.read(r1, r2)
            r12 = r0
            r0 = r12
            r1 = -1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0036
            java.io.EOFException r0 = new java.io.EOFException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0036:
            r0 = r10
            r1 = r12
            long r0 = r0 - r1
            r10 = r0
            goto L_0x0013
        L_0x0040:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonWrite(okio.Buffer, okio.Source, long):okio.Buffer");
    }

    @NotNull
    public static final Buffer commonWriteByte(@NotNull Buffer $this$commonWriteByte, int b) {
        Intrinsics.checkNotNullParameter($this$commonWriteByte, "<this>");
        Segment tail = $this$commonWriteByte.writableSegment$okio(1);
        byte[] bArr = tail.data;
        int i = tail.limit;
        tail.limit = i + 1;
        bArr[i] = (byte) b;
        $this$commonWriteByte.setSize$okio($this$commonWriteByte.size() + 1);
        return $this$commonWriteByte;
    }

    @NotNull
    public static final Buffer commonWriteShort(@NotNull Buffer $this$commonWriteShort, int s) {
        Intrinsics.checkNotNullParameter($this$commonWriteShort, "<this>");
        Segment tail = $this$commonWriteShort.writableSegment$okio(2);
        byte[] data = tail.data;
        int limit = tail.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((s >>> 8) & 255);
        data[limit2] = (byte) (s & 255);
        tail.limit = limit2 + 1;
        $this$commonWriteShort.setSize$okio($this$commonWriteShort.size() + 2);
        return $this$commonWriteShort;
    }

    @NotNull
    public static final Buffer commonWriteInt(@NotNull Buffer $this$commonWriteInt, int i) {
        Intrinsics.checkNotNullParameter($this$commonWriteInt, "<this>");
        Segment tail = $this$commonWriteInt.writableSegment$okio(4);
        byte[] data = tail.data;
        int limit = tail.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((i >>> 24) & 255);
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((i >>> 16) & 255);
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((i >>> 8) & 255);
        data[limit4] = (byte) (i & 255);
        tail.limit = limit4 + 1;
        $this$commonWriteInt.setSize$okio($this$commonWriteInt.size() + 4);
        return $this$commonWriteInt;
    }

    @NotNull
    public static final Buffer commonWriteLong(@NotNull Buffer $this$commonWriteLong, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteLong, "<this>");
        Segment tail = $this$commonWriteLong.writableSegment$okio(8);
        byte[] data = tail.data;
        int limit = tail.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((int) ((v >>> 56) & 255));
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((int) ((v >>> 48) & 255));
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((int) ((v >>> 40) & 255));
        int limit5 = limit4 + 1;
        data[limit4] = (byte) ((int) ((v >>> 32) & 255));
        int limit6 = limit5 + 1;
        data[limit5] = (byte) ((int) ((v >>> 24) & 255));
        int limit7 = limit6 + 1;
        data[limit6] = (byte) ((int) ((v >>> 16) & 255));
        int limit8 = limit7 + 1;
        data[limit7] = (byte) ((int) ((v >>> 8) & 255));
        data[limit8] = (byte) ((int) (v & 255));
        tail.limit = limit8 + 1;
        $this$commonWriteLong.setSize$okio($this$commonWriteLong.size() + 8);
        return $this$commonWriteLong;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29, types: [long] */
    public static final void commonWrite(@NotNull Buffer $this$commonWrite, @NotNull Buffer source, long byteCount) {
        Segment tail;
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        char c = byteCount;
        if (!(source != $this$commonWrite)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        _UtilKt.checkOffsetAndCount(source.size(), 0, c);
        while (c > 0) {
            Segment segment = source.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.limit;
            Segment segment2 = source.head;
            Intrinsics.checkNotNull(segment2);
            if (c < ((long) (i - segment2.pos))) {
                if ($this$commonWrite.head != null) {
                    Segment segment3 = $this$commonWrite.head;
                    Intrinsics.checkNotNull(segment3);
                    tail = segment3.prev;
                } else {
                    tail = null;
                }
                if (tail != null && tail.owner) {
                    if ((c + ((long) tail.limit)) - ((long) (tail.shared ? 0 : tail.pos)) <= FileAppender.DEFAULT_BUFFER_SIZE) {
                        Segment segment4 = source.head;
                        Intrinsics.checkNotNull(segment4);
                        segment4.writeTo(tail, (int) c);
                        source.setSize$okio(source.size() - c);
                        $this$commonWrite.setSize$okio($this$commonWrite.size() + c);
                        return;
                    }
                }
                Segment segment5 = source.head;
                Intrinsics.checkNotNull(segment5);
                source.head = segment5.split((int) c);
            }
            Segment segmentToMove = source.head;
            Intrinsics.checkNotNull(segmentToMove);
            long movedByteCount = (long) (segmentToMove.limit - segmentToMove.pos);
            source.head = segmentToMove.pop();
            if ($this$commonWrite.head == null) {
                $this$commonWrite.head = segmentToMove;
                segmentToMove.prev = segmentToMove;
                segmentToMove.next = segmentToMove.prev;
            } else {
                Segment segment6 = $this$commonWrite.head;
                Intrinsics.checkNotNull(segment6);
                Segment tail2 = segment6.prev;
                Intrinsics.checkNotNull(tail2);
                tail2.push(segmentToMove).compact();
            }
            source.setSize$okio(source.size() - movedByteCount);
            $this$commonWrite.setSize$okio($this$commonWrite.size() + movedByteCount);
            c -= movedByteCount;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    public static final long commonRead(@NotNull Buffer $this$commonRead, @NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRead, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        char c = byteCount;
        if (!(c >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(c)).toString());
        } else if ($this$commonRead.size() == 0) {
            return -1;
        } else {
            int i = (c > $this$commonRead.size() ? 1 : (c == $this$commonRead.size() ? 0 : -1));
            long byteCount2 = c;
            if (i > 0) {
                byteCount2 = $this$commonRead.size();
            }
            sink.write($this$commonRead, byteCount2 == 1 ? 1 : 0);
            return byteCount2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r0v65, types: [long] */
    /* JADX WARN: Type inference failed for: r0v81 */
    /* JADX WARN: Type inference failed for: r0v119, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonIndexOf(@org.jetbrains.annotations.NotNull okio.Buffer r5, byte r6, long r7, long r9) {
        /*
        // Method dump skipped, instructions count: 667
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonIndexOf(okio.Buffer, byte, long, long):long");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v31, types: [long] */
    /* JADX WARN: Type inference failed for: r0v77, types: [long] */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r0v143, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonIndexOf(@org.jetbrains.annotations.NotNull okio.Buffer r6, @org.jetbrains.annotations.NotNull okio.ByteString r7, long r8) {
        /*
        // Method dump skipped, instructions count: 755
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonIndexOf(okio.Buffer, okio.ByteString, long):long");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    /* JADX WARN: Type inference failed for: r0v53, types: [long] */
    /* JADX WARN: Type inference failed for: r0v93, types: [long] */
    /* JADX WARN: Type inference failed for: r0v111 */
    /* JADX WARN: Type inference failed for: r0v142, types: [long] */
    /* JADX WARN: Type inference failed for: r0v182, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonIndexOfElement(@org.jetbrains.annotations.NotNull okio.Buffer r5, @org.jetbrains.annotations.NotNull okio.ByteString r6, long r7) {
        /*
        // Method dump skipped, instructions count: 921
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonIndexOfElement(okio.Buffer, okio.ByteString, long):long");
    }

    public static final boolean commonRangeEquals(@NotNull Buffer $this$commonRangeEquals, long offset, @NotNull ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRangeEquals, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (offset < 0 || bytesOffset < 0 || byteCount < 0 || $this$commonRangeEquals.size() - offset < ((long) byteCount) || bytes.size() - bytesOffset < byteCount) {
            return false;
        }
        int i = 0;
        if (0 >= byteCount) {
            return true;
        }
        do {
            i++;
            if ($this$commonRangeEquals.getByte(offset + ((long) i)) != bytes.getByte(bytesOffset + i)) {
                return false;
            }
        } while (i < byteCount);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r0v41, types: [long] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0100 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean commonEquals(@org.jetbrains.annotations.NotNull okio.Buffer r5, @org.jetbrains.annotations.Nullable java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 268
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonEquals(okio.Buffer, java.lang.Object):boolean");
    }

    public static final int commonHashCode(@NotNull Buffer $this$commonHashCode) {
        Intrinsics.checkNotNullParameter($this$commonHashCode, "<this>");
        Segment segment = $this$commonHashCode.head;
        if (segment == null) {
            return 0;
        }
        Segment s = segment;
        int result = 1;
        do {
            int limit = s.limit;
            for (int pos = s.pos; pos < limit; pos++) {
                result = (31 * result) + s.data[pos];
            }
            Segment segment2 = s.next;
            Intrinsics.checkNotNull(segment2);
            s = segment2;
        } while (s != $this$commonHashCode.head);
        return result;
    }

    @NotNull
    public static final Buffer commonCopy(@NotNull Buffer $this$commonCopy) {
        Intrinsics.checkNotNullParameter($this$commonCopy, "<this>");
        Buffer result = new Buffer();
        if ($this$commonCopy.size() == 0) {
            return result;
        }
        Segment head = $this$commonCopy.head;
        Intrinsics.checkNotNull(head);
        Segment headCopy = head.sharedCopy();
        result.head = headCopy;
        headCopy.prev = result.head;
        headCopy.next = headCopy.prev;
        for (Segment s = head.next; s != head; s = s.next) {
            Segment segment = headCopy.prev;
            Intrinsics.checkNotNull(segment);
            Intrinsics.checkNotNull(s);
            segment.push(s.sharedCopy());
        }
        result.setSize$okio($this$commonCopy.size());
        return result;
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer $this$commonSnapshot) {
        Intrinsics.checkNotNullParameter($this$commonSnapshot, "<this>");
        if ($this$commonSnapshot.size() <= 2147483647L) {
            return $this$commonSnapshot.snapshot((int) $this$commonSnapshot.size());
        }
        throw new IllegalStateException(Intrinsics.stringPlus("size > Int.MAX_VALUE: ", Long.valueOf($this$commonSnapshot.size())).toString());
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer $this$commonSnapshot, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonSnapshot, "<this>");
        if (byteCount == 0) {
            return ByteString.EMPTY;
        }
        _UtilKt.checkOffsetAndCount($this$commonSnapshot.size(), 0, (long) byteCount);
        int offset = 0;
        int segmentCount = 0;
        Segment s = $this$commonSnapshot.head;
        while (offset < byteCount) {
            Intrinsics.checkNotNull(s);
            if (s.limit == s.pos) {
                throw new AssertionError("s.limit == s.pos");
            }
            offset += s.limit - s.pos;
            segmentCount++;
            s = s.next;
        }
        byte[][] segments = new byte[segmentCount];
        int[] directory = new int[segmentCount * 2];
        int offset2 = 0;
        int segmentCount2 = 0;
        Segment s2 = $this$commonSnapshot.head;
        while (offset2 < byteCount) {
            Intrinsics.checkNotNull(s2);
            segments[segmentCount2] = s2.data;
            offset2 += s2.limit - s2.pos;
            directory[segmentCount2] = Math.min(offset2, byteCount);
            directory[segmentCount2 + segments.length] = s2.pos;
            s2.shared = true;
            segmentCount2++;
            s2 = s2.next;
        }
        return new SegmentedByteString(segments, directory);
    }

    @NotNull
    public static final Buffer.UnsafeCursor commonReadUnsafe(@NotNull Buffer $this$commonReadUnsafe, @NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter($this$commonReadUnsafe, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor unsafeCursor2 = _UtilKt.resolveDefaultParameter(unsafeCursor);
        if (!(unsafeCursor2.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor2.buffer = $this$commonReadUnsafe;
        unsafeCursor2.readWrite = false;
        return unsafeCursor2;
    }

    @NotNull
    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(@NotNull Buffer $this$commonReadAndWriteUnsafe, @NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter($this$commonReadAndWriteUnsafe, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor unsafeCursor2 = _UtilKt.resolveDefaultParameter(unsafeCursor);
        if (!(unsafeCursor2.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor2.buffer = $this$commonReadAndWriteUnsafe;
        unsafeCursor2.readWrite = true;
        return unsafeCursor2;
    }

    public static final int commonNext(@NotNull Buffer.UnsafeCursor $this$commonNext) {
        Intrinsics.checkNotNullParameter($this$commonNext, "<this>");
        long j = $this$commonNext.offset;
        Buffer buffer = $this$commonNext.buffer;
        Intrinsics.checkNotNull(buffer);
        if (j != buffer.size()) {
            return $this$commonNext.offset == -1 ? $this$commonNext.seek(0) : $this$commonNext.seek($this$commonNext.offset + ((long) ($this$commonNext.end - $this$commonNext.start)));
        }
        throw new IllegalStateException("no more bytes".toString());
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0172 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2, types: [long] */
    /* JADX WARN: Type inference failed for: r19v4, types: [long] */
    /* JADX WARN: Type inference failed for: r0v73, types: [long] */
    /* JADX WARN: Type inference failed for: r0v78, types: [long] */
    /* JADX WARN: Type inference failed for: r0v91 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int commonSeek(@org.jetbrains.annotations.NotNull okio.Buffer.UnsafeCursor r7, long r8) {
        /*
        // Method dump skipped, instructions count: 493
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonSeek(okio.Buffer$UnsafeCursor, long):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0133 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0133 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r0v40, types: [long] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r0v56, types: [long] */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonResizeBuffer(@org.jetbrains.annotations.NotNull okio.Buffer.UnsafeCursor r5, long r6) {
        /*
        // Method dump skipped, instructions count: 442
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonResizeBuffer(okio.Buffer$UnsafeCursor, long):long");
    }

    public static final long commonExpandBuffer(@NotNull Buffer.UnsafeCursor $this$commonExpandBuffer, int minByteCount) {
        Intrinsics.checkNotNullParameter($this$commonExpandBuffer, "<this>");
        if (!(minByteCount > 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("minByteCount <= 0: ", Integer.valueOf(minByteCount)).toString());
        }
        if (!(minByteCount <= 8192)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("minByteCount > Segment.SIZE: ", Integer.valueOf(minByteCount)).toString());
        }
        Buffer buffer = $this$commonExpandBuffer.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        } else if (!$this$commonExpandBuffer.readWrite) {
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
        } else {
            long oldSize = buffer.size();
            Segment tail = buffer.writableSegment$okio(minByteCount);
            int result = 8192 - tail.limit;
            tail.limit = 8192;
            buffer.setSize$okio(oldSize + ((long) result));
            $this$commonExpandBuffer.setSegment$okio(tail);
            $this$commonExpandBuffer.offset = oldSize;
            $this$commonExpandBuffer.data = tail.data;
            $this$commonExpandBuffer.start = 8192 - result;
            $this$commonExpandBuffer.end = 8192;
            return (long) result;
        }
    }

    public static final void commonClose(@NotNull Buffer.UnsafeCursor $this$commonClose) {
        Intrinsics.checkNotNullParameter($this$commonClose, "<this>");
        if (!($this$commonClose.buffer != null)) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        $this$commonClose.buffer = null;
        $this$commonClose.setSegment$okio(null);
        $this$commonClose.offset = -1;
        $this$commonClose.data = null;
        $this$commonClose.start = -1;
        $this$commonClose.end = -1;
    }
}
