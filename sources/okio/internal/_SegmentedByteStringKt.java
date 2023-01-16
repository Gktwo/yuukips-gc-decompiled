package okio.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: -SegmentedByteString.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��T\n��\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n��\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010��\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H��\u001a-\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\bH\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\bH\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\b\u001a\u001d\u0010\u001a\u001a\u00020\u0019*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\b\u001a\r\u0010\u001d\u001a\u00020\u000b*\u00020\bH\b\u001a%\u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\b\u001a]\u0010!\u001a\u00020\u0007*\u00020\b2K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\bø\u0001��\u001aj\u0010!\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\b\u001a\u0014\u0010'\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H��\u0002\u0007\n\u0005\b20\u0001¨\u0006("}, m373d2 = {"binarySearch", "", "", "value", "fromIndex", "toIndex", "commonCopyInto", "", "Lokio/SegmentedByteString;", "offset", TypeProxy.INSTANCE_FIELD, "", "targetOffset", "byteCount", "commonEquals", "", "other", "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "otherOffset", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "segment", "okio"})
/* loaded from: grasscutter.jar:okio/internal/_SegmentedByteStringKt.class */
public final class _SegmentedByteStringKt {
    public static final int binarySearch(@NotNull int[] $this$binarySearch, int value, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch, "<this>");
        int left = fromIndex;
        int right = toIndex - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = $this$binarySearch[mid];
            if (midVal < value) {
                left = mid + 1;
            } else if (midVal <= value) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return (-left) - 1;
    }

    public static final int segment(@NotNull SegmentedByteString $this$segment, int pos) {
        Intrinsics.checkNotNullParameter($this$segment, "<this>");
        int i = binarySearch($this$segment.getDirectory$okio(), pos + 1, 0, $this$segment.getSegments$okio().length);
        return i >= 0 ? i : i ^ -1;
    }

    public static final void forEachSegment(@NotNull SegmentedByteString $this$forEachSegment, @NotNull Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter($this$forEachSegment, "<this>");
        Intrinsics.checkNotNullParameter(function3, "action");
        int segmentCount = $this$forEachSegment.getSegments$okio().length;
        int pos = 0;
        for (int s = 0; s < segmentCount; s++) {
            int segmentPos = $this$forEachSegment.getDirectory$okio()[segmentCount + s];
            int nextSegmentOffset = $this$forEachSegment.getDirectory$okio()[s];
            function3.invoke($this$forEachSegment.getSegments$okio()[s], Integer.valueOf(segmentPos), Integer.valueOf(nextSegmentOffset - pos));
            pos = nextSegmentOffset;
        }
    }

    private static final void forEachSegment(SegmentedByteString $this$forEachSegment, int beginIndex, int endIndex, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int s = segment($this$forEachSegment, beginIndex);
        int pos = beginIndex;
        while (pos < endIndex) {
            int segmentOffset = s == 0 ? 0 : $this$forEachSegment.getDirectory$okio()[s - 1];
            int segmentSize = $this$forEachSegment.getDirectory$okio()[s] - segmentOffset;
            int segmentPos = $this$forEachSegment.getDirectory$okio()[$this$forEachSegment.getSegments$okio().length + s];
            int byteCount = Math.min(endIndex, segmentOffset + segmentSize) - pos;
            function3.invoke($this$forEachSegment.getSegments$okio()[s], Integer.valueOf(segmentPos + (pos - segmentOffset)), Integer.valueOf(byteCount));
            pos += byteCount;
            s++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01b8  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.ByteString commonSubstring(@org.jetbrains.annotations.NotNull okio.SegmentedByteString r6, int r7, int r8) {
        /*
        // Method dump skipped, instructions count: 493
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._SegmentedByteStringKt.commonSubstring(okio.SegmentedByteString, int, int):okio.ByteString");
    }

    public static final byte commonInternalGet(@NotNull SegmentedByteString $this$commonInternalGet, int pos) {
        Intrinsics.checkNotNullParameter($this$commonInternalGet, "<this>");
        _UtilKt.checkOffsetAndCount((long) $this$commonInternalGet.getDirectory$okio()[$this$commonInternalGet.getSegments$okio().length - 1], (long) pos, 1);
        int segment = segment($this$commonInternalGet, pos);
        return $this$commonInternalGet.getSegments$okio()[segment][(pos - (segment == 0 ? 0 : $this$commonInternalGet.getDirectory$okio()[segment - 1])) + $this$commonInternalGet.getDirectory$okio()[segment + $this$commonInternalGet.getSegments$okio().length]];
    }

    public static final int commonGetSize(@NotNull SegmentedByteString $this$commonGetSize) {
        Intrinsics.checkNotNullParameter($this$commonGetSize, "<this>");
        return $this$commonGetSize.getDirectory$okio()[$this$commonGetSize.getSegments$okio().length - 1];
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull SegmentedByteString $this$commonToByteArray) {
        Intrinsics.checkNotNullParameter($this$commonToByteArray, "<this>");
        byte[] result = new byte[$this$commonToByteArray.size()];
        int resultPos = 0;
        int segmentCount$iv = $this$commonToByteArray.getSegments$okio().length;
        int pos$iv = 0;
        for (int s$iv = 0; s$iv < segmentCount$iv; s$iv++) {
            int segmentPos$iv = $this$commonToByteArray.getDirectory$okio()[segmentCount$iv + s$iv];
            int nextSegmentOffset$iv = $this$commonToByteArray.getDirectory$okio()[s$iv];
            int byteCount = nextSegmentOffset$iv - pos$iv;
            ArraysKt.copyInto($this$commonToByteArray.getSegments$okio()[s$iv], result, resultPos, segmentPos$iv, segmentPos$iv + byteCount);
            resultPos += byteCount;
            pos$iv = nextSegmentOffset$iv;
        }
        return result;
    }

    public static final void commonWrite(@NotNull SegmentedByteString $this$commonWrite, @NotNull Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int endIndex$iv = offset + byteCount;
        int s$iv = segment($this$commonWrite, offset);
        int pos$iv = offset;
        while (pos$iv < endIndex$iv) {
            int segmentOffset$iv = s$iv == 0 ? 0 : $this$commonWrite.getDirectory$okio()[s$iv - 1];
            int segmentSize$iv = $this$commonWrite.getDirectory$okio()[s$iv] - segmentOffset$iv;
            int segmentPos$iv = $this$commonWrite.getDirectory$okio()[$this$commonWrite.getSegments$okio().length + s$iv];
            int byteCount$iv = Math.min(endIndex$iv, segmentOffset$iv + segmentSize$iv) - pos$iv;
            int offset$iv = segmentPos$iv + (pos$iv - segmentOffset$iv);
            Segment segment = new Segment($this$commonWrite.getSegments$okio()[s$iv], offset$iv, offset$iv + byteCount$iv, true, false);
            if (buffer.head == null) {
                segment.prev = segment;
                segment.next = segment.prev;
                buffer.head = segment.next;
            } else {
                Segment segment2 = buffer.head;
                Intrinsics.checkNotNull(segment2);
                Segment segment3 = segment2.prev;
                Intrinsics.checkNotNull(segment3);
                segment3.push(segment);
            }
            pos$iv += byteCount$iv;
            s$iv++;
        }
        buffer.setSize$okio(buffer.size() + ((long) byteCount));
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString $this$commonRangeEquals, int offset, @NotNull ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRangeEquals, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > $this$commonRangeEquals.size() - byteCount) {
            return false;
        }
        int otherOffset2 = otherOffset;
        int endIndex$iv = offset + byteCount;
        int s$iv = segment($this$commonRangeEquals, offset);
        int pos$iv = offset;
        while (pos$iv < endIndex$iv) {
            int segmentOffset$iv = s$iv == 0 ? 0 : $this$commonRangeEquals.getDirectory$okio()[s$iv - 1];
            int segmentSize$iv = $this$commonRangeEquals.getDirectory$okio()[s$iv] - segmentOffset$iv;
            int segmentPos$iv = $this$commonRangeEquals.getDirectory$okio()[$this$commonRangeEquals.getSegments$okio().length + s$iv];
            int byteCount$iv = Math.min(endIndex$iv, segmentOffset$iv + segmentSize$iv) - pos$iv;
            if (!other.rangeEquals(otherOffset2, $this$commonRangeEquals.getSegments$okio()[s$iv], segmentPos$iv + (pos$iv - segmentOffset$iv), byteCount$iv)) {
                return false;
            }
            otherOffset2 += byteCount$iv;
            pos$iv += byteCount$iv;
            s$iv++;
        }
        return true;
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString $this$commonRangeEquals, int offset, @NotNull byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRangeEquals, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > $this$commonRangeEquals.size() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int otherOffset2 = otherOffset;
        int endIndex$iv = offset + byteCount;
        int s$iv = segment($this$commonRangeEquals, offset);
        int pos$iv = offset;
        while (pos$iv < endIndex$iv) {
            int segmentOffset$iv = s$iv == 0 ? 0 : $this$commonRangeEquals.getDirectory$okio()[s$iv - 1];
            int segmentSize$iv = $this$commonRangeEquals.getDirectory$okio()[s$iv] - segmentOffset$iv;
            int segmentPos$iv = $this$commonRangeEquals.getDirectory$okio()[$this$commonRangeEquals.getSegments$okio().length + s$iv];
            int byteCount$iv = Math.min(endIndex$iv, segmentOffset$iv + segmentSize$iv) - pos$iv;
            if (!_UtilKt.arrayRangeEquals($this$commonRangeEquals.getSegments$okio()[s$iv], segmentPos$iv + (pos$iv - segmentOffset$iv), other, otherOffset2, byteCount$iv)) {
                return false;
            }
            otherOffset2 += byteCount$iv;
            pos$iv += byteCount$iv;
            s$iv++;
        }
        return true;
    }

    public static final void commonCopyInto(@NotNull SegmentedByteString $this$commonCopyInto, int offset, @NotNull byte[] target, int targetOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonCopyInto, "<this>");
        Intrinsics.checkNotNullParameter(target, TypeProxy.INSTANCE_FIELD);
        _UtilKt.checkOffsetAndCount((long) $this$commonCopyInto.size(), (long) offset, (long) byteCount);
        _UtilKt.checkOffsetAndCount((long) target.length, (long) targetOffset, (long) byteCount);
        int targetOffset2 = targetOffset;
        int endIndex$iv = offset + byteCount;
        int s$iv = segment($this$commonCopyInto, offset);
        int pos$iv = offset;
        while (pos$iv < endIndex$iv) {
            int segmentOffset$iv = s$iv == 0 ? 0 : $this$commonCopyInto.getDirectory$okio()[s$iv - 1];
            int segmentSize$iv = $this$commonCopyInto.getDirectory$okio()[s$iv] - segmentOffset$iv;
            int segmentPos$iv = $this$commonCopyInto.getDirectory$okio()[$this$commonCopyInto.getSegments$okio().length + s$iv];
            int byteCount$iv = Math.min(endIndex$iv, segmentOffset$iv + segmentSize$iv) - pos$iv;
            int offset$iv = segmentPos$iv + (pos$iv - segmentOffset$iv);
            ArraysKt.copyInto($this$commonCopyInto.getSegments$okio()[s$iv], target, targetOffset2, offset$iv, offset$iv + byteCount$iv);
            targetOffset2 += byteCount$iv;
            pos$iv += byteCount$iv;
            s$iv++;
        }
    }

    public static final boolean commonEquals(@NotNull SegmentedByteString $this$commonEquals, @Nullable Object other) {
        Intrinsics.checkNotNullParameter($this$commonEquals, "<this>");
        if (other == $this$commonEquals) {
            return true;
        }
        return (other instanceof ByteString) && ((ByteString) other).size() == $this$commonEquals.size() && $this$commonEquals.rangeEquals(0, (ByteString) other, 0, $this$commonEquals.size());
    }

    public static final int commonHashCode(@NotNull SegmentedByteString $this$commonHashCode) {
        Intrinsics.checkNotNullParameter($this$commonHashCode, "<this>");
        int result = $this$commonHashCode.getHashCode$okio();
        if (result != 0) {
            return result;
        }
        int result2 = 1;
        int segmentCount$iv = $this$commonHashCode.getSegments$okio().length;
        int pos$iv = 0;
        for (int s$iv = 0; s$iv < segmentCount$iv; s$iv++) {
            int segmentPos$iv = $this$commonHashCode.getDirectory$okio()[segmentCount$iv + s$iv];
            int nextSegmentOffset$iv = $this$commonHashCode.getDirectory$okio()[s$iv];
            byte[] data = $this$commonHashCode.getSegments$okio()[s$iv];
            int limit = segmentPos$iv + (nextSegmentOffset$iv - pos$iv);
            for (int i = segmentPos$iv; i < limit; i++) {
                result2 = (31 * result2) + data[i];
            }
            pos$iv = nextSegmentOffset$iv;
        }
        $this$commonHashCode.setHashCode$okio(result2);
        return result2;
    }
}
