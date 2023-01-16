package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import okio.internal._SegmentedByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.core.joran.action.Action;

/* compiled from: SegmentedByteString.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n��\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n��\n\u0002\u0010��\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\b��\u0018��2\u00020\u0001B\u001d\b��\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\r\u0010 \u001a\u00020\u0015H\u0010¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001d\u0010$\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0001H\u0010¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J\r\u0010)\u001a\u00020\u0004H\u0010¢\u0006\u0002\b*J\u0015\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015H\u0010¢\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0001H\u0016J\b\u00109\u001a\u00020\u0001H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\u0001H\u0002J\b\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0016J%\u0010=\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0010¢\u0006\u0002\bBJ\b\u0010C\u001a\u00020DH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n��\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006E"}, m373d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "copyInto", "", "offset", "", TypeProxy.INSTANCE_FIELD, "targetOffset", "byteCount", "digest", "algorithm", "digest$okio", "equals", "", "other", "", "getSize", "getSize$okio", "hashCode", "hex", "hmac", Action.KEY_ATTRIBUTE, "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", "pos", "internalGet$okio", "lastIndexOf", "rangeEquals", "otherOffset", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", Printer.TO_STRING, "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, "okio"})
/* loaded from: grasscutter.jar:okio/SegmentedByteString.class */
public final class SegmentedByteString extends ByteString {
    @NotNull
    private final transient byte[][] segments;
    @NotNull
    private final transient int[] directory;

    @NotNull
    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @NotNull
    public final int[] getDirectory$okio() {
        return this.directory;
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@NotNull byte[][] segments, @NotNull int[] directory) {
        super(ByteString.EMPTY.getData$okio());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    @Override // okio.ByteString
    @NotNull
    public String string(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    @NotNull
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    @NotNull
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest $this$digest_u24lambda_u2d1 = MessageDigest.getInstance(algorithm);
        int segmentCount$iv = getSegments$okio().length;
        int pos$iv = 0;
        for (int s$iv = 0; s$iv < segmentCount$iv; s$iv++) {
            int segmentPos$iv = getDirectory$okio()[segmentCount$iv + s$iv];
            int nextSegmentOffset$iv = getDirectory$okio()[s$iv];
            $this$digest_u24lambda_u2d1.update(getSegments$okio()[s$iv], segmentPos$iv, nextSegmentOffset$iv - pos$iv);
            pos$iv = nextSegmentOffset$iv;
        }
        byte[] digestBytes = $this$digest_u24lambda_u2d1.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int segmentCount$iv = getSegments$okio().length;
            int pos$iv = 0;
            for (int s$iv = 0; s$iv < segmentCount$iv; s$iv++) {
                int segmentPos$iv = getDirectory$okio()[segmentCount$iv + s$iv];
                int nextSegmentOffset$iv = getDirectory$okio()[s$iv];
                mac.update(getSegments$okio()[s$iv], segmentPos$iv, nextSegmentOffset$iv - pos$iv);
                pos$iv = nextSegmentOffset$iv;
            }
            byte[] doFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // okio.ByteString
    @NotNull
    public String base64Url() {
        return toByteString().base64Url();
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01b9  */
    @Override // okio.ByteString
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okio.ByteString substring(int r7, int r8) {
        /*
        // Method dump skipped, instructions count: 494
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.SegmentedByteString.substring(int, int):okio.ByteString");
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int pos) {
        _UtilKt.checkOffsetAndCount((long) getDirectory$okio()[getSegments$okio().length - 1], (long) pos, 1);
        int segment$iv = _SegmentedByteStringKt.segment(this, pos);
        return getSegments$okio()[segment$iv][(pos - (segment$iv == 0 ? 0 : getDirectory$okio()[segment$iv - 1])) + getDirectory$okio()[segment$iv + getSegments$okio().length]];
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] toByteArray() {
        byte[] result$iv = new byte[size()];
        int resultPos$iv = 0;
        int segmentCount$iv$iv = getSegments$okio().length;
        int pos$iv$iv = 0;
        for (int s$iv$iv = 0; s$iv$iv < segmentCount$iv$iv; s$iv$iv++) {
            int segmentPos$iv$iv = getDirectory$okio()[segmentCount$iv$iv + s$iv$iv];
            int nextSegmentOffset$iv$iv = getDirectory$okio()[s$iv$iv];
            int byteCount$iv = nextSegmentOffset$iv$iv - pos$iv$iv;
            ArraysKt.copyInto(getSegments$okio()[s$iv$iv], result$iv, resultPos$iv, segmentPos$iv$iv, segmentPos$iv$iv + byteCount$iv);
            resultPos$iv += byteCount$iv;
            pos$iv$iv = nextSegmentOffset$iv$iv;
        }
        return result$iv;
    }

    @Override // okio.ByteString
    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    public void write(@NotNull OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        int segmentCount$iv = getSegments$okio().length;
        int pos$iv = 0;
        for (int s$iv = 0; s$iv < segmentCount$iv; s$iv++) {
            int segmentPos$iv = getDirectory$okio()[segmentCount$iv + s$iv];
            int nextSegmentOffset$iv = getDirectory$okio()[s$iv];
            out.write(getSegments$okio()[s$iv], segmentPos$iv, nextSegmentOffset$iv - pos$iv);
            pos$iv = nextSegmentOffset$iv;
        }
    }

    @Override // okio.ByteString
    public void write$okio(@NotNull Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int endIndex$iv$iv = offset + byteCount;
        int s$iv$iv = _SegmentedByteStringKt.segment(this, offset);
        int pos$iv$iv = offset;
        while (pos$iv$iv < endIndex$iv$iv) {
            int segmentOffset$iv$iv = s$iv$iv == 0 ? 0 : getDirectory$okio()[s$iv$iv - 1];
            int segmentSize$iv$iv = getDirectory$okio()[s$iv$iv] - segmentOffset$iv$iv;
            int segmentPos$iv$iv = getDirectory$okio()[getSegments$okio().length + s$iv$iv];
            int byteCount$iv$iv = Math.min(endIndex$iv$iv, segmentOffset$iv$iv + segmentSize$iv$iv) - pos$iv$iv;
            int offset$iv$iv = segmentPos$iv$iv + (pos$iv$iv - segmentOffset$iv$iv);
            Segment segment$iv = new Segment(getSegments$okio()[s$iv$iv], offset$iv$iv, offset$iv$iv + byteCount$iv$iv, true, false);
            if (buffer.head == null) {
                segment$iv.prev = segment$iv;
                segment$iv.next = segment$iv.prev;
                buffer.head = segment$iv.next;
            } else {
                Segment segment = buffer.head;
                Intrinsics.checkNotNull(segment);
                Segment segment2 = segment.prev;
                Intrinsics.checkNotNull(segment2);
                segment2.push(segment$iv);
            }
            pos$iv$iv += byteCount$iv$iv;
            s$iv$iv++;
        }
        buffer.setSize$okio(buffer.size() + ((long) byteCount));
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, @NotNull ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > size() - byteCount) {
            return false;
        }
        int otherOffset$iv = otherOffset;
        int endIndex$iv$iv = offset + byteCount;
        int s$iv$iv = _SegmentedByteStringKt.segment(this, offset);
        int pos$iv$iv = offset;
        while (pos$iv$iv < endIndex$iv$iv) {
            int segmentOffset$iv$iv = s$iv$iv == 0 ? 0 : getDirectory$okio()[s$iv$iv - 1];
            int segmentSize$iv$iv = getDirectory$okio()[s$iv$iv] - segmentOffset$iv$iv;
            int segmentPos$iv$iv = getDirectory$okio()[getSegments$okio().length + s$iv$iv];
            int byteCount$iv$iv = Math.min(endIndex$iv$iv, segmentOffset$iv$iv + segmentSize$iv$iv) - pos$iv$iv;
            if (!other.rangeEquals(otherOffset$iv, getSegments$okio()[s$iv$iv], segmentPos$iv$iv + (pos$iv$iv - segmentOffset$iv$iv), byteCount$iv$iv)) {
                return false;
            }
            otherOffset$iv += byteCount$iv$iv;
            pos$iv$iv += byteCount$iv$iv;
            s$iv$iv++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, @NotNull byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > size() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int otherOffset$iv = otherOffset;
        int endIndex$iv$iv = offset + byteCount;
        int s$iv$iv = _SegmentedByteStringKt.segment(this, offset);
        int pos$iv$iv = offset;
        while (pos$iv$iv < endIndex$iv$iv) {
            int segmentOffset$iv$iv = s$iv$iv == 0 ? 0 : getDirectory$okio()[s$iv$iv - 1];
            int segmentSize$iv$iv = getDirectory$okio()[s$iv$iv] - segmentOffset$iv$iv;
            int segmentPos$iv$iv = getDirectory$okio()[getSegments$okio().length + s$iv$iv];
            int byteCount$iv$iv = Math.min(endIndex$iv$iv, segmentOffset$iv$iv + segmentSize$iv$iv) - pos$iv$iv;
            if (!_UtilKt.arrayRangeEquals(getSegments$okio()[s$iv$iv], segmentPos$iv$iv + (pos$iv$iv - segmentOffset$iv$iv), other, otherOffset$iv, byteCount$iv$iv)) {
                return false;
            }
            otherOffset$iv += byteCount$iv$iv;
            pos$iv$iv += byteCount$iv$iv;
            s$iv$iv++;
        }
        return true;
    }

    @Override // okio.ByteString
    public void copyInto(int offset, @NotNull byte[] target, int targetOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(target, TypeProxy.INSTANCE_FIELD);
        _UtilKt.checkOffsetAndCount((long) size(), (long) offset, (long) byteCount);
        _UtilKt.checkOffsetAndCount((long) target.length, (long) targetOffset, (long) byteCount);
        int targetOffset$iv = targetOffset;
        int endIndex$iv$iv = offset + byteCount;
        int s$iv$iv = _SegmentedByteStringKt.segment(this, offset);
        int pos$iv$iv = offset;
        while (pos$iv$iv < endIndex$iv$iv) {
            int segmentOffset$iv$iv = s$iv$iv == 0 ? 0 : getDirectory$okio()[s$iv$iv - 1];
            int segmentSize$iv$iv = getDirectory$okio()[s$iv$iv] - segmentOffset$iv$iv;
            int segmentPos$iv$iv = getDirectory$okio()[getSegments$okio().length + s$iv$iv];
            int byteCount$iv$iv = Math.min(endIndex$iv$iv, segmentOffset$iv$iv + segmentSize$iv$iv) - pos$iv$iv;
            int offset$iv$iv = segmentPos$iv$iv + (pos$iv$iv - segmentOffset$iv$iv);
            ArraysKt.copyInto(getSegments$okio()[s$iv$iv], target, targetOffset$iv, offset$iv$iv, offset$iv$iv + byteCount$iv$iv);
            targetOffset$iv += byteCount$iv$iv;
            pos$iv$iv += byteCount$iv$iv;
            s$iv$iv++;
        }
    }

    @Override // okio.ByteString
    public int indexOf(@NotNull byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return toByteString().indexOf(other, fromIndex);
    }

    @Override // okio.ByteString
    public int lastIndexOf(@NotNull byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return toByteString().lastIndexOf(other, fromIndex);
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString, java.lang.Object
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        return (other instanceof ByteString) && ((ByteString) other).size() == size() && rangeEquals(0, (ByteString) other, 0, size());
    }

    @Override // okio.ByteString, java.lang.Object
    public int hashCode() {
        int result$iv = getHashCode$okio();
        if (result$iv != 0) {
            return result$iv;
        }
        int result$iv2 = 1;
        int segmentCount$iv$iv = getSegments$okio().length;
        int pos$iv$iv = 0;
        for (int s$iv$iv = 0; s$iv$iv < segmentCount$iv$iv; s$iv$iv++) {
            int segmentPos$iv$iv = getDirectory$okio()[segmentCount$iv$iv + s$iv$iv];
            int nextSegmentOffset$iv$iv = getDirectory$okio()[s$iv$iv];
            byte[] data$iv = getSegments$okio()[s$iv$iv];
            int limit$iv = segmentPos$iv$iv + (nextSegmentOffset$iv$iv - pos$iv$iv);
            for (int i$iv = segmentPos$iv$iv; i$iv < limit$iv; i$iv++) {
                result$iv2 = (31 * result$iv2) + data$iv[i$iv];
            }
            pos$iv$iv = nextSegmentOffset$iv$iv;
        }
        setHashCode$okio(result$iv2);
        return result$iv2;
    }

    @Override // okio.ByteString, java.lang.Object
    @NotNull
    public String toString() {
        return toByteString().toString();
    }

    private final Object writeReplace() {
        return toByteString();
    }
}
