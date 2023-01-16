package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import okio.Buffer;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.builtins.Tmux;

/* compiled from: -ByteString.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��R\n��\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n��\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n��\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u0005\n\u0002\b\u0017\n\u0002\u0018\u0002\n��\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\b\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\fH\b\u001a\r\u0010\u0013\u001a\u00020\u0012*\u00020\fH\b\u001a\u0015\u0010\u0014\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\b\u001a-\u0010\u0016\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\u000f\u0010\u001c\u001a\u0004\u0018\u00010\f*\u00020\u0012H\b\u001a\r\u0010\u001d\u001a\u00020\f*\u00020\u0012H\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0012H\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\tH\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\fH\b\u001a\u0017\u0010\"\u001a\u00020 *\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010#H\b\u001a\u0015\u0010$\u001a\u00020%*\u00020\f2\u0006\u0010&\u001a\u00020\u0007H\b\u001a\r\u0010'\u001a\u00020\u0007*\u00020\fH\b\u001a\r\u0010(\u001a\u00020\u0007*\u00020\fH\b\u001a\r\u0010)\u001a\u00020\u0012*\u00020\fH\b\u001a\u001d\u0010*\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\r\u0010,\u001a\u00020\t*\u00020\fH\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007H\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\tH\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\fH\b\u001a\u001d\u00102\u001a\u00020\f*\u00020\f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\b\u001a\r\u00105\u001a\u00020\f*\u00020\fH\b\u001a\r\u00106\u001a\u00020\f*\u00020\fH\b\u001a\r\u00107\u001a\u00020\t*\u00020\fH\b\u001a\u001d\u00108\u001a\u00020\f*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\r\u00109\u001a\u00020\u0012*\u00020\fH\b\u001a\r\u0010:\u001a\u00020\u0012*\u00020\fH\b\u001a$\u0010;\u001a\u00020\u0017*\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H��\"\u001c\u0010��\u001a\u00020\u00018��X\u0004¢\u0006\u000e\n��\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006>"}, m373d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS$annotations", "()V", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonCopyInto", "", "offset", TypeProxy.INSTANCE_FIELD, "targetOffset", "byteCount", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "otherOffset", "commonStartsWith", Tmux.OPT_PREFIX, "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "buffer", "Lokio/Buffer;", "okio"})
/* loaded from: grasscutter.jar:okio/internal/_ByteStringKt.class */
public final class _ByteStringKt {
    @NotNull
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }

    @NotNull
    public static final String commonUtf8(@NotNull ByteString $this$commonUtf8) {
        Intrinsics.checkNotNullParameter($this$commonUtf8, "<this>");
        String result = $this$commonUtf8.getUtf8$okio();
        if (result == null) {
            result = _JvmPlatformKt.toUtf8String($this$commonUtf8.internalArray$okio());
            $this$commonUtf8.setUtf8$okio(result);
        }
        return result;
    }

    @NotNull
    public static final String commonBase64(@NotNull ByteString $this$commonBase64) {
        Intrinsics.checkNotNullParameter($this$commonBase64, "<this>");
        return _Base64Kt.encodeBase64$default($this$commonBase64.getData$okio(), null, 1, null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull ByteString $this$commonBase64Url) {
        Intrinsics.checkNotNullParameter($this$commonBase64Url, "<this>");
        return _Base64Kt.encodeBase64($this$commonBase64Url.getData$okio(), _Base64Kt.getBASE64_URL_SAFE());
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    @NotNull
    public static final String commonHex(@NotNull ByteString $this$commonHex) {
        Intrinsics.checkNotNullParameter($this$commonHex, "<this>");
        char[] result = new char[$this$commonHex.getData$okio().length * 2];
        int c = 0;
        byte[] data$okio = $this$commonHex.getData$okio();
        int i = 0;
        int length = data$okio.length;
        while (i < length) {
            byte b = data$okio[i];
            i++;
            int c2 = c + 1;
            result[c] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            c = c2 + 1;
            result[c2] = getHEX_DIGIT_CHARS()[b & 15];
        }
        return StringsKt.concatToString(result);
    }

    @NotNull
    public static final ByteString commonToAsciiLowercase(@NotNull ByteString $this$commonToAsciiLowercase) {
        Intrinsics.checkNotNullParameter($this$commonToAsciiLowercase, "<this>");
        for (int i = 0; i < $this$commonToAsciiLowercase.getData$okio().length; i++) {
            byte c = $this$commonToAsciiLowercase.getData$okio()[i];
            if (c >= ((byte) 65) && c <= ((byte) 90)) {
                byte[] data$okio = $this$commonToAsciiLowercase.getData$okio();
                byte[] lowercase = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(lowercase, "java.util.Arrays.copyOf(this, size)");
                int i2 = i + 1;
                lowercase[i] = (byte) (c - -32);
                while (i2 < lowercase.length) {
                    byte c2 = lowercase[i2];
                    if (c2 < ((byte) 65) || c2 > ((byte) 90)) {
                        i2++;
                    } else {
                        lowercase[i2] = (byte) (c2 - -32);
                        i2++;
                    }
                }
                return new ByteString(lowercase);
            }
        }
        return $this$commonToAsciiLowercase;
    }

    @NotNull
    public static final ByteString commonToAsciiUppercase(@NotNull ByteString $this$commonToAsciiUppercase) {
        Intrinsics.checkNotNullParameter($this$commonToAsciiUppercase, "<this>");
        for (int i = 0; i < $this$commonToAsciiUppercase.getData$okio().length; i++) {
            byte c = $this$commonToAsciiUppercase.getData$okio()[i];
            if (c >= ((byte) 97) && c <= ((byte) 122)) {
                byte[] data$okio = $this$commonToAsciiUppercase.getData$okio();
                byte[] lowercase = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(lowercase, "java.util.Arrays.copyOf(this, size)");
                int i2 = i + 1;
                lowercase[i] = (byte) (c - 32);
                while (i2 < lowercase.length) {
                    byte c2 = lowercase[i2];
                    if (c2 < ((byte) 97) || c2 > ((byte) 122)) {
                        i2++;
                    } else {
                        lowercase[i2] = (byte) (c2 - 32);
                        i2++;
                    }
                }
                return new ByteString(lowercase);
            }
        }
        return $this$commonToAsciiUppercase;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull ByteString $this$commonSubstring, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$commonSubstring, "<this>");
        int endIndex2 = _UtilKt.resolveDefaultParameter($this$commonSubstring, endIndex);
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (!(endIndex2 <= $this$commonSubstring.getData$okio().length)) {
            throw new IllegalArgumentException(("endIndex > length(" + $this$commonSubstring.getData$okio().length + ')').toString());
        }
        if (!(endIndex2 - beginIndex >= 0)) {
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        } else if (beginIndex == 0 && endIndex2 == $this$commonSubstring.getData$okio().length) {
            return $this$commonSubstring;
        } else {
            return new ByteString(ArraysKt.copyOfRange($this$commonSubstring.getData$okio(), beginIndex, endIndex2));
        }
    }

    public static final byte commonGetByte(@NotNull ByteString $this$commonGetByte, int pos) {
        Intrinsics.checkNotNullParameter($this$commonGetByte, "<this>");
        return $this$commonGetByte.getData$okio()[pos];
    }

    public static final int commonGetSize(@NotNull ByteString $this$commonGetSize) {
        Intrinsics.checkNotNullParameter($this$commonGetSize, "<this>");
        return $this$commonGetSize.getData$okio().length;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull ByteString $this$commonToByteArray) {
        Intrinsics.checkNotNullParameter($this$commonToByteArray, "<this>");
        byte[] data$okio = $this$commonToByteArray.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull ByteString $this$commonInternalArray) {
        Intrinsics.checkNotNullParameter($this$commonInternalArray, "<this>");
        return $this$commonInternalArray.getData$okio();
    }

    public static final boolean commonRangeEquals(@NotNull ByteString $this$commonRangeEquals, int offset, @NotNull ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRangeEquals, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(otherOffset, $this$commonRangeEquals.getData$okio(), offset, byteCount);
    }

    public static final boolean commonRangeEquals(@NotNull ByteString $this$commonRangeEquals, int offset, @NotNull byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRangeEquals, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return offset >= 0 && offset <= $this$commonRangeEquals.getData$okio().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && _UtilKt.arrayRangeEquals($this$commonRangeEquals.getData$okio(), offset, other, otherOffset, byteCount);
    }

    public static final void commonCopyInto(@NotNull ByteString $this$commonCopyInto, int offset, @NotNull byte[] target, int targetOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonCopyInto, "<this>");
        Intrinsics.checkNotNullParameter(target, TypeProxy.INSTANCE_FIELD);
        ArraysKt.copyInto($this$commonCopyInto.getData$okio(), target, targetOffset, offset, offset + byteCount);
    }

    public static final boolean commonStartsWith(@NotNull ByteString $this$commonStartsWith, @NotNull ByteString prefix) {
        Intrinsics.checkNotNullParameter($this$commonStartsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, Tmux.OPT_PREFIX);
        return $this$commonStartsWith.rangeEquals(0, prefix, 0, prefix.size());
    }

    public static final boolean commonStartsWith(@NotNull ByteString $this$commonStartsWith, @NotNull byte[] prefix) {
        Intrinsics.checkNotNullParameter($this$commonStartsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, Tmux.OPT_PREFIX);
        return $this$commonStartsWith.rangeEquals(0, prefix, 0, prefix.length);
    }

    public static final boolean commonEndsWith(@NotNull ByteString $this$commonEndsWith, @NotNull ByteString suffix) {
        Intrinsics.checkNotNullParameter($this$commonEndsWith, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return $this$commonEndsWith.rangeEquals($this$commonEndsWith.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEndsWith(@NotNull ByteString $this$commonEndsWith, @NotNull byte[] suffix) {
        Intrinsics.checkNotNullParameter($this$commonEndsWith, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return $this$commonEndsWith.rangeEquals($this$commonEndsWith.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonIndexOf(@NotNull ByteString $this$commonIndexOf, @NotNull byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$commonIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int limit = $this$commonIndexOf.getData$okio().length - other.length;
        int i = Math.max(fromIndex, 0);
        if (i > limit) {
            return -1;
        }
        do {
            i++;
            if (_UtilKt.arrayRangeEquals($this$commonIndexOf.getData$okio(), i, other, 0, other.length)) {
                return i;
            }
        } while (i != limit);
        return -1;
    }

    public static final int commonLastIndexOf(@NotNull ByteString $this$commonLastIndexOf, @NotNull ByteString other, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$commonLastIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return $this$commonLastIndexOf.lastIndexOf(other.internalArray$okio(), fromIndex);
    }

    public static final int commonLastIndexOf(@NotNull ByteString $this$commonLastIndexOf, @NotNull byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$commonLastIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int i = Math.min(_UtilKt.resolveDefaultParameter($this$commonLastIndexOf, fromIndex), $this$commonLastIndexOf.getData$okio().length - other.length);
        if (0 > i) {
            return -1;
        }
        do {
            i--;
            if (_UtilKt.arrayRangeEquals($this$commonLastIndexOf.getData$okio(), i, other, 0, other.length)) {
                return i;
            }
        } while (0 <= i);
        return -1;
    }

    public static final boolean commonEquals(@NotNull ByteString $this$commonEquals, @Nullable Object other) {
        Intrinsics.checkNotNullParameter($this$commonEquals, "<this>");
        if (other == $this$commonEquals) {
            return true;
        }
        return (other instanceof ByteString) && ((ByteString) other).size() == $this$commonEquals.getData$okio().length && ((ByteString) other).rangeEquals(0, $this$commonEquals.getData$okio(), 0, $this$commonEquals.getData$okio().length);
    }

    public static final int commonHashCode(@NotNull ByteString $this$commonHashCode) {
        Intrinsics.checkNotNullParameter($this$commonHashCode, "<this>");
        int result = $this$commonHashCode.getHashCode$okio();
        if (result != 0) {
            return result;
        }
        int it = Arrays.hashCode($this$commonHashCode.getData$okio());
        $this$commonHashCode.setHashCode$okio(it);
        return it;
    }

    public static final int commonCompareTo(@NotNull ByteString $this$commonCompareTo, @NotNull ByteString other) {
        Intrinsics.checkNotNullParameter($this$commonCompareTo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int sizeA = $this$commonCompareTo.size();
        int sizeB = other.size();
        int size = Math.min(sizeA, sizeB);
        for (int i = 0; i < size; i++) {
            int byteA = $this$commonCompareTo.getByte(i) & 255;
            int byteB = other.getByte(i) & 255;
            if (byteA != byteB) {
                return byteA < byteB ? -1 : 1;
            }
        }
        if (sizeA == sizeB) {
            return 0;
        }
        return sizeA < sizeB ? -1 : 1;
    }

    @NotNull
    public static final ByteString commonOf(@NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    @NotNull
    public static final ByteString commonToByteString(@NotNull byte[] $this$commonToByteString, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonToByteString, "<this>");
        _UtilKt.checkOffsetAndCount((long) $this$commonToByteString.length, (long) offset, (long) byteCount);
        return new ByteString(ArraysKt.copyOfRange($this$commonToByteString, offset, offset + byteCount));
    }

    @NotNull
    public static final ByteString commonEncodeUtf8(@NotNull String $this$commonEncodeUtf8) {
        Intrinsics.checkNotNullParameter($this$commonEncodeUtf8, "<this>");
        ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray($this$commonEncodeUtf8));
        byteString.setUtf8$okio($this$commonEncodeUtf8);
        return byteString;
    }

    @Nullable
    public static final ByteString commonDecodeBase64(@NotNull String $this$commonDecodeBase64) {
        Intrinsics.checkNotNullParameter($this$commonDecodeBase64, "<this>");
        byte[] decoded = _Base64Kt.decodeBase64ToArray($this$commonDecodeBase64);
        if (decoded != null) {
            return new ByteString(decoded);
        }
        return null;
    }

    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String $this$commonDecodeHex) {
        Intrinsics.checkNotNullParameter($this$commonDecodeHex, "<this>");
        if (!($this$commonDecodeHex.length() % 2 == 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected hex string: ", $this$commonDecodeHex).toString());
        }
        byte[] result = new byte[$this$commonDecodeHex.length() / 2];
        int i = 0;
        int length = result.length - 1;
        if (0 > length) {
            return new ByteString(result);
        }
        do {
            i++;
            result[i] = (byte) ((decodeHexDigit($this$commonDecodeHex.charAt(i * 2)) << 4) + decodeHexDigit($this$commonDecodeHex.charAt((i * 2) + 1)));
        } while (i <= length);
        return new ByteString(result);
    }

    public static final void commonWrite(@NotNull ByteString $this$commonWrite, @NotNull Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write($this$commonWrite.getData$okio(), offset, byteCount);
    }

    public static final int decodeHexDigit(char c) {
        boolean z;
        boolean z2;
        boolean z3;
        if ('0' <= c) {
            z = c <= '9';
        } else {
            z = false;
        }
        if (z) {
            return c - '0';
        }
        if ('a' <= c) {
            z2 = c <= 'f';
        } else {
            z2 = false;
        }
        if (z2) {
            return (c - 'a') + 10;
        }
        if ('A' <= c) {
            z3 = c <= 'F';
        } else {
            z3 = false;
        }
        if (z3) {
            return (c - 'A') + 10;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected hex digit: ", Character.valueOf(c)));
    }

    @NotNull
    public static final String commonToString(@NotNull ByteString $this$commonToString) {
        ByteString byteString;
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        if ($this$commonToString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int i = codePointIndexToCharIndex($this$commonToString.getData$okio(), 64);
        if (i != -1) {
            String text = $this$commonToString.utf8();
            if (text == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = text.substring(0, i);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String safeText = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            return i < text.length() ? "[size=" + $this$commonToString.getData$okio().length + " text=" + safeText + "…]" : "[text=" + safeText + ']';
        } else if ($this$commonToString.getData$okio().length <= 64) {
            return "[hex=" + $this$commonToString.hex() + ']';
        } else {
            StringBuilder append = new StringBuilder().append("[size=").append($this$commonToString.getData$okio().length).append(" hex=");
            int endIndex$iv = _UtilKt.resolveDefaultParameter($this$commonToString, 64);
            if (!(endIndex$iv <= $this$commonToString.getData$okio().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + $this$commonToString.getData$okio().length + ')').toString());
            }
            if (!(endIndex$iv - 0 >= 0)) {
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            if (endIndex$iv == $this$commonToString.getData$okio().length) {
                byteString = $this$commonToString;
            } else {
                byteString = new ByteString(ArraysKt.copyOfRange($this$commonToString.getData$okio(), 0, endIndex$iv));
            }
            return append.append(byteString.hex()).append("…]").toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:844:0x00a3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:849:0x0159 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0219 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:855:0x0446 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:860:0x03a6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:864:0x02ed A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:866:0x061d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0866 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x06ea A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:876:0x0906 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0511 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:882:0x07a9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:886:0x0e31 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:891:0x0caf A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x0eda A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:896:0x0b15 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:901:0x0d74 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:903:0x0f7a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:907:0x09d1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x0be2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:912:0x1016 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int codePointIndexToCharIndex(byte[] r5, int r6) {
        /*
        // Method dump skipped, instructions count: 4156
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }
}
