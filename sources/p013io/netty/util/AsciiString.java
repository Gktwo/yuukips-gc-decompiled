package p013io.netty.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.InternalThreadLocalMap;
import p013io.netty.util.internal.MathUtil;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.util.AsciiString */
/* loaded from: grasscutter.jar:io/netty/util/AsciiString.class */
public final class AsciiString implements CharSequence, Comparable<CharSequence> {
    private static final char MAX_CHAR_VALUE = 255;
    public static final int INDEX_NOT_FOUND = -1;
    private final byte[] value;
    private final int offset;
    private final int length;
    private int hash;
    private String string;
    public static final AsciiString EMPTY_STRING = cached("");
    public static final HashingStrategy<CharSequence> CASE_INSENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.1
        public int hashCode(CharSequence o) {
            return AsciiString.hashCode(o);
        }

        public boolean equals(CharSequence a, CharSequence b) {
            return AsciiString.contentEqualsIgnoreCase(a, b);
        }
    };
    public static final HashingStrategy<CharSequence> CASE_SENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.2
        public int hashCode(CharSequence o) {
            return AsciiString.hashCode(o);
        }

        public boolean equals(CharSequence a, CharSequence b) {
            return AsciiString.contentEquals(a, b);
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.AsciiString$CharEqualityComparator */
    /* loaded from: grasscutter.jar:io/netty/util/AsciiString$CharEqualityComparator.class */
    public interface CharEqualityComparator {
        boolean equals(char c, char c2);
    }

    public AsciiString(byte[] value) {
        this(value, true);
    }

    public AsciiString(byte[] value, boolean copy) {
        this(value, 0, value.length, copy);
    }

    public AsciiString(byte[] value, int start, int length, boolean copy) {
        if (copy) {
            this.value = Arrays.copyOfRange(value, start, start + length);
            this.offset = 0;
        } else if (MathUtil.isOutOfBounds(start, length, value.length)) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= start + length(" + length + ") <= value.length(" + value.length + ')');
        } else {
            this.value = value;
            this.offset = start;
        }
        this.length = length;
    }

    public AsciiString(ByteBuffer value) {
        this(value, true);
    }

    public AsciiString(ByteBuffer value, boolean copy) {
        this(value, value.position(), value.remaining(), copy);
    }

    public AsciiString(ByteBuffer value, int start, int length, boolean copy) {
        if (MathUtil.isOutOfBounds(start, length, value.capacity())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= start + length(" + length + ") <= value.capacity(" + value.capacity() + ')');
        }
        if (!value.hasArray()) {
            this.value = PlatformDependent.allocateUninitializedArray(length);
            int oldPos = value.position();
            value.get(this.value, 0, length);
            value.position(oldPos);
            this.offset = 0;
        } else if (copy) {
            int bufferOffset = value.arrayOffset() + start;
            this.value = Arrays.copyOfRange(value.array(), bufferOffset, bufferOffset + length);
            this.offset = 0;
        } else {
            this.value = value.array();
            this.offset = start;
        }
        this.length = length;
    }

    public AsciiString(char[] value) {
        this(value, 0, value.length);
    }

    public AsciiString(char[] value, int start, int length) {
        if (MathUtil.isOutOfBounds(start, length, value.length)) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= start + length(" + length + ") <= value.length(" + value.length + ')');
        }
        this.value = PlatformDependent.allocateUninitializedArray(length);
        int i = 0;
        int j = start;
        while (i < length) {
            this.value[i] = c2b(value[j]);
            i++;
            j++;
        }
        this.offset = 0;
        this.length = length;
    }

    public AsciiString(char[] value, Charset charset) {
        this(value, charset, 0, value.length);
    }

    public AsciiString(char[] value, Charset charset, int start, int length) {
        CharBuffer cbuf = CharBuffer.wrap(value, start, length);
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        ByteBuffer nativeBuffer = ByteBuffer.allocate((int) (encoder.maxBytesPerChar() * ((float) length)));
        encoder.encode(cbuf, nativeBuffer, true);
        int bufferOffset = nativeBuffer.arrayOffset();
        this.value = Arrays.copyOfRange(nativeBuffer.array(), bufferOffset, bufferOffset + nativeBuffer.position());
        this.offset = 0;
        this.length = this.value.length;
    }

    public AsciiString(CharSequence value) {
        this(value, 0, value.length());
    }

    public AsciiString(CharSequence value, int start, int length) {
        if (MathUtil.isOutOfBounds(start, length, value.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= start + length(" + length + ") <= value.length(" + value.length() + ')');
        }
        this.value = PlatformDependent.allocateUninitializedArray(length);
        int i = 0;
        int j = start;
        while (i < length) {
            this.value[i] = c2b(value.charAt(j));
            i++;
            j++;
        }
        this.offset = 0;
        this.length = length;
    }

    public AsciiString(CharSequence value, Charset charset) {
        this(value, charset, 0, value.length());
    }

    public AsciiString(CharSequence value, Charset charset, int start, int length) {
        CharBuffer cbuf = CharBuffer.wrap(value, start, start + length);
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        ByteBuffer nativeBuffer = ByteBuffer.allocate((int) (encoder.maxBytesPerChar() * ((float) length)));
        encoder.encode(cbuf, nativeBuffer, true);
        int offset = nativeBuffer.arrayOffset();
        this.value = Arrays.copyOfRange(nativeBuffer.array(), offset, offset + nativeBuffer.position());
        this.offset = 0;
        this.length = this.value.length;
    }

    public int forEachByte(ByteProcessor visitor) throws Exception {
        return forEachByte0(0, length(), visitor);
    }

    public int forEachByte(int index, int length, ByteProcessor visitor) throws Exception {
        if (!MathUtil.isOutOfBounds(index, length, length())) {
            return forEachByte0(index, length, visitor);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= index(" + index + ") <= start + length(" + length + ") <= length(" + length() + ')');
    }

    private int forEachByte0(int index, int length, ByteProcessor visitor) throws Exception {
        int len = this.offset + index + length;
        for (int i = this.offset + index; i < len; i++) {
            if (!visitor.process(this.value[i])) {
                return i - this.offset;
            }
        }
        return -1;
    }

    public int forEachByteDesc(ByteProcessor visitor) throws Exception {
        return forEachByteDesc0(0, length(), visitor);
    }

    public int forEachByteDesc(int index, int length, ByteProcessor visitor) throws Exception {
        if (!MathUtil.isOutOfBounds(index, length, length())) {
            return forEachByteDesc0(index, length, visitor);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= index(" + index + ") <= start + length(" + length + ") <= length(" + length() + ')');
    }

    private int forEachByteDesc0(int index, int length, ByteProcessor visitor) throws Exception {
        int end = this.offset + index;
        for (int i = ((this.offset + index) + length) - 1; i >= end; i--) {
            if (!visitor.process(this.value[i])) {
                return i - this.offset;
            }
        }
        return -1;
    }

    public byte byteAt(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException("index: " + index + " must be in the range [0," + this.length + ")");
        } else if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getByte(this.value, index + this.offset);
        } else {
            return this.value[index + this.offset];
        }
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    public void arrayChanged() {
        this.string = null;
        this.hash = 0;
    }

    public byte[] array() {
        return this.value;
    }

    public int arrayOffset() {
        return this.offset;
    }

    public boolean isEntireArrayUsed() {
        return this.offset == 0 && this.length == this.value.length;
    }

    public byte[] toByteArray() {
        return toByteArray(0, length());
    }

    public byte[] toByteArray(int start, int end) {
        return Arrays.copyOfRange(this.value, start + this.offset, end + this.offset);
    }

    public void copy(int srcIdx, byte[] dst, int dstIdx, int length) {
        if (MathUtil.isOutOfBounds(srcIdx, length, length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + srcIdx + ") <= srcIdx + length(" + length + ") <= srcLen(" + length() + ')');
        }
        System.arraycopy(this.value, srcIdx + this.offset, ObjectUtil.checkNotNull(dst, "dst"), dstIdx, length);
    }

    @Override // java.lang.CharSequence
    public char charAt(int index) {
        return b2c(byteAt(index));
    }

    public boolean contains(CharSequence cs) {
        return indexOf(cs) >= 0;
    }

    public int compareTo(CharSequence string) {
        if (this == string) {
            return 0;
        }
        int length1 = length();
        int length2 = string.length();
        int minLength = Math.min(length1, length2);
        int i = 0;
        int j = arrayOffset();
        while (i < minLength) {
            int result = b2c(this.value[j]) - string.charAt(i);
            if (result != 0) {
                return result;
            }
            i++;
            j++;
        }
        return length1 - length2;
    }

    public AsciiString concat(CharSequence string) {
        int thisLen = length();
        int thatLen = string.length();
        if (thatLen == 0) {
            return this;
        }
        if (string instanceof AsciiString) {
            AsciiString that = (AsciiString) string;
            if (isEmpty()) {
                return that;
            }
            byte[] newValue = PlatformDependent.allocateUninitializedArray(thisLen + thatLen);
            System.arraycopy(this.value, arrayOffset(), newValue, 0, thisLen);
            System.arraycopy(that.value, that.arrayOffset(), newValue, thisLen, thatLen);
            return new AsciiString(newValue, false);
        } else if (isEmpty()) {
            return new AsciiString(string);
        } else {
            byte[] newValue2 = PlatformDependent.allocateUninitializedArray(thisLen + thatLen);
            System.arraycopy(this.value, arrayOffset(), newValue2, 0, thisLen);
            int i = thisLen;
            int j = 0;
            while (i < newValue2.length) {
                newValue2[i] = c2b(string.charAt(j));
                i++;
                j++;
            }
            return new AsciiString(newValue2, false);
        }
    }

    public boolean endsWith(CharSequence suffix) {
        int suffixLen = suffix.length();
        return regionMatches(length() - suffixLen, suffix, 0, suffixLen);
    }

    public boolean contentEqualsIgnoreCase(CharSequence string) {
        if (this == string) {
            return true;
        }
        if (string == null || string.length() != length()) {
            return false;
        }
        if (string instanceof AsciiString) {
            AsciiString rhs = (AsciiString) string;
            int i = arrayOffset();
            int j = rhs.arrayOffset();
            int end = i + length();
            while (i < end) {
                if (!equalsIgnoreCase(this.value[i], rhs.value[j])) {
                    return false;
                }
                i++;
                j++;
            }
            return true;
        }
        int i2 = arrayOffset();
        int end2 = length();
        for (int j2 = 0; j2 < end2; j2++) {
            if (!equalsIgnoreCase(b2c(this.value[i2]), string.charAt(j2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public char[] toCharArray() {
        return toCharArray(0, length());
    }

    public char[] toCharArray(int start, int end) {
        int length = end - start;
        if (length == 0) {
            return EmptyArrays.EMPTY_CHARS;
        }
        if (MathUtil.isOutOfBounds(start, length, length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= srcIdx + length(" + length + ") <= srcLen(" + length() + ')');
        }
        char[] buffer = new char[length];
        int i = 0;
        int j = start + arrayOffset();
        while (i < length) {
            buffer[i] = b2c(this.value[j]);
            i++;
            j++;
        }
        return buffer;
    }

    public void copy(int srcIdx, char[] dst, int dstIdx, int length) {
        ObjectUtil.checkNotNull(dst, "dst");
        if (MathUtil.isOutOfBounds(srcIdx, length, length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + srcIdx + ") <= srcIdx + length(" + length + ") <= srcLen(" + length() + ')');
        }
        int dstEnd = dstIdx + length;
        int i = dstIdx;
        int j = srcIdx + arrayOffset();
        while (i < dstEnd) {
            dst[i] = b2c(this.value[j]);
            i++;
            j++;
        }
    }

    public AsciiString subSequence(int start) {
        return subSequence(start, length());
    }

    @Override // java.lang.CharSequence
    public AsciiString subSequence(int start, int end) {
        return subSequence(start, end, true);
    }

    public AsciiString subSequence(int start, int end, boolean copy) {
        if (MathUtil.isOutOfBounds(start, end - start, length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= end (" + end + ") <= length(" + length() + ')');
        } else if (start == 0 && end == length()) {
            return this;
        } else {
            if (end == start) {
                return EMPTY_STRING;
            }
            return new AsciiString(this.value, start + this.offset, end - start, copy);
        }
    }

    public int indexOf(CharSequence string) {
        return indexOf(string, 0);
    }

    public int indexOf(CharSequence subString, int start) {
        char firstChar;
        int subCount = subString.length();
        if (start < 0) {
            start = 0;
        }
        if (subCount <= 0) {
            return start < this.length ? start : this.length;
        }
        if (subCount > this.length - start || (firstChar = subString.charAt(0)) > 255) {
            return -1;
        }
        byte firstCharAsByte = c2b0(firstChar);
        int len = (this.offset + this.length) - subCount;
        for (int i = start + this.offset; i <= len; i++) {
            if (this.value[i] == firstCharAsByte) {
                int o1 = i;
                int o2 = 0;
                do {
                    o2++;
                    if (o2 >= subCount) {
                        break;
                    }
                    o1++;
                } while (b2c(this.value[o1]) == subString.charAt(o2));
                if (o2 == subCount) {
                    return i - this.offset;
                }
            }
        }
        return -1;
    }

    public int indexOf(char ch, int start) {
        if (ch > 255) {
            return -1;
        }
        if (start < 0) {
            start = 0;
        }
        byte chAsByte = c2b0(ch);
        int len = this.offset + this.length;
        for (int i = start + this.offset; i < len; i++) {
            if (this.value[i] == chAsByte) {
                return i - this.offset;
            }
        }
        return -1;
    }

    public int lastIndexOf(CharSequence string) {
        return lastIndexOf(string, this.length);
    }

    public int lastIndexOf(CharSequence subString, int start) {
        int subCount = subString.length();
        int start2 = Math.min(start, this.length - subCount);
        if (start2 < 0) {
            return -1;
        }
        if (subCount == 0) {
            return start2;
        }
        char firstChar = subString.charAt(0);
        if (firstChar > 255) {
            return -1;
        }
        byte firstCharAsByte = c2b0(firstChar);
        for (int i = this.offset + start2; i >= 0; i--) {
            if (this.value[i] == firstCharAsByte) {
                int o1 = i;
                int o2 = 0;
                do {
                    o2++;
                    if (o2 >= subCount) {
                        break;
                    }
                    o1++;
                } while (b2c(this.value[o1]) == subString.charAt(o2));
                if (o2 == subCount) {
                    return i - this.offset;
                }
            }
        }
        return -1;
    }

    public boolean regionMatches(int thisStart, CharSequence string, int start, int length) {
        ObjectUtil.checkNotNull(string, "string");
        if (start < 0 || string.length() - start < length) {
            return false;
        }
        int thisLen = length();
        if (thisStart < 0 || thisLen - thisStart < length) {
            return false;
        }
        if (length <= 0) {
            return true;
        }
        int thatEnd = start + length;
        int i = start;
        int j = thisStart + arrayOffset();
        while (i < thatEnd) {
            if (b2c(this.value[j]) != string.charAt(i)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public boolean regionMatches(boolean ignoreCase, int thisStart, CharSequence string, int start, int length) {
        if (!ignoreCase) {
            return regionMatches(thisStart, string, start, length);
        }
        ObjectUtil.checkNotNull(string, "string");
        int thisLen = length();
        if (thisStart < 0 || length > thisLen - thisStart || start < 0 || length > string.length() - start) {
            return false;
        }
        int thisStart2 = thisStart + arrayOffset();
        int thisEnd = thisStart2 + length;
        while (thisStart2 < thisEnd) {
            thisStart2++;
            start++;
            if (!equalsIgnoreCase(b2c(this.value[thisStart2]), string.charAt(start))) {
                return false;
            }
        }
        return true;
    }

    public AsciiString replace(char oldChar, char newChar) {
        if (oldChar > 255) {
            return this;
        }
        byte oldCharAsByte = c2b0(oldChar);
        byte newCharAsByte = c2b(newChar);
        int len = this.offset + this.length;
        int i = this.offset;
        while (i < len) {
            if (this.value[i] == oldCharAsByte) {
                byte[] buffer = PlatformDependent.allocateUninitializedArray(length());
                System.arraycopy(this.value, this.offset, buffer, 0, i - this.offset);
                buffer[i - this.offset] = newCharAsByte;
                while (true) {
                    i++;
                    if (i >= len) {
                        return new AsciiString(buffer, false);
                    }
                    byte oldValue = this.value[i];
                    buffer[i - this.offset] = oldValue != oldCharAsByte ? oldValue : newCharAsByte;
                }
            } else {
                i++;
            }
        }
        return this;
    }

    public boolean startsWith(CharSequence prefix) {
        return startsWith(prefix, 0);
    }

    public boolean startsWith(CharSequence prefix, int start) {
        return regionMatches(start, prefix, 0, prefix.length());
    }

    public AsciiString toLowerCase() {
        boolean lowercased = true;
        int len = length() + arrayOffset();
        int i = arrayOffset();
        while (true) {
            if (i < len) {
                byte b = this.value[i];
                if (b >= 65 && b <= 90) {
                    lowercased = false;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        if (lowercased) {
            return this;
        }
        byte[] newValue = PlatformDependent.allocateUninitializedArray(length());
        int i2 = 0;
        int j = arrayOffset();
        while (i2 < newValue.length) {
            newValue[i2] = toLowerCase(this.value[j]);
            i2++;
            j++;
        }
        return new AsciiString(newValue, false);
    }

    public AsciiString toUpperCase() {
        boolean uppercased = true;
        int len = length() + arrayOffset();
        int i = arrayOffset();
        while (true) {
            if (i < len) {
                byte b = this.value[i];
                if (b >= 97 && b <= 122) {
                    uppercased = false;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        if (uppercased) {
            return this;
        }
        byte[] newValue = PlatformDependent.allocateUninitializedArray(length());
        int i2 = 0;
        int j = arrayOffset();
        while (i2 < newValue.length) {
            newValue[i2] = toUpperCase(this.value[j]);
            i2++;
            j++;
        }
        return new AsciiString(newValue, false);
    }

    public static CharSequence trim(CharSequence c) {
        if (c instanceof AsciiString) {
            return ((AsciiString) c).trim();
        }
        if (c instanceof String) {
            return ((String) c).trim();
        }
        int start = 0;
        int last = c.length() - 1;
        int end = last;
        while (start <= end && c.charAt(start) <= ' ') {
            start++;
        }
        while (end >= start && c.charAt(end) <= ' ') {
            end--;
        }
        if (start == 0 && end == last) {
            return c;
        }
        return c.subSequence(start, end);
    }

    public AsciiString trim() {
        int start = arrayOffset();
        int last = (arrayOffset() + length()) - 1;
        int end = last;
        while (start <= end && this.value[start] <= 32) {
            start++;
        }
        while (end >= start && this.value[end] <= 32) {
            end--;
        }
        if (start == 0 && end == last) {
            return this;
        }
        return new AsciiString(this.value, start, (end - start) + 1, false);
    }

    public boolean contentEquals(CharSequence a) {
        if (this == a) {
            return true;
        }
        if (a == null || a.length() != length()) {
            return false;
        }
        if (a instanceof AsciiString) {
            return equals(a);
        }
        int i = arrayOffset();
        for (int j = 0; j < a.length(); j++) {
            if (b2c(this.value[i]) != a.charAt(j)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean matches(String expr) {
        return Pattern.matches(expr, this);
    }

    public AsciiString[] split(String expr, int max) {
        return toAsciiStringArray(Pattern.compile(expr).split(this, max));
    }

    public AsciiString[] split(char delim) {
        List<AsciiString> res = InternalThreadLocalMap.get().arrayList();
        int start = 0;
        int length = length();
        for (int i = 0; i < length; i++) {
            if (charAt(i) == delim) {
                if (start == i) {
                    res.add(EMPTY_STRING);
                } else {
                    res.add(new AsciiString(this.value, start + arrayOffset(), i - start, false));
                }
                start = i + 1;
            }
        }
        if (start == 0) {
            res.add(this);
        } else if (start != length) {
            res.add(new AsciiString(this.value, start + arrayOffset(), length - start, false));
        } else {
            int i2 = res.size() - 1;
            while (i2 >= 0 && res.get(i2).isEmpty()) {
                res.remove(i2);
                i2--;
            }
        }
        return (AsciiString[]) res.toArray(new AsciiString[0]);
    }

    @Override // java.lang.Object
    public int hashCode() {
        int h = this.hash;
        if (h == 0) {
            h = PlatformDependent.hashCodeAscii(this.value, this.offset, this.length);
            this.hash = h;
        }
        return h;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != AsciiString.class) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        AsciiString other = (AsciiString) obj;
        return length() == other.length() && hashCode() == other.hashCode() && PlatformDependent.equals(array(), arrayOffset(), other.array(), other.arrayOffset(), length());
    }

    @Override // java.lang.CharSequence, java.lang.Object
    public String toString() {
        String cache = this.string;
        if (cache == null) {
            cache = toString(0);
            this.string = cache;
        }
        return cache;
    }

    public String toString(int start) {
        return toString(start, length());
    }

    public String toString(int start, int end) {
        int length = end - start;
        if (length == 0) {
            return "";
        }
        if (!MathUtil.isOutOfBounds(start, length, length())) {
            return new String(this.value, 0, start + this.offset, length);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= srcIdx + length(" + length + ") <= srcLen(" + length() + ')');
    }

    public boolean parseBoolean() {
        return this.length >= 1 && this.value[this.offset] != 0;
    }

    public char parseChar() {
        return parseChar(0);
    }

    public char parseChar(int start) {
        if (start + 1 >= length()) {
            throw new IndexOutOfBoundsException("2 bytes required to convert to character. index " + start + " would go out of bounds.");
        }
        int startWithOffset = start + this.offset;
        return (char) ((b2c(this.value[startWithOffset]) << '\b') | b2c(this.value[startWithOffset + 1]));
    }

    public short parseShort() {
        return parseShort(0, length(), 10);
    }

    public short parseShort(int radix) {
        return parseShort(0, length(), radix);
    }

    public short parseShort(int start, int end) {
        return parseShort(start, end, 10);
    }

    public short parseShort(int start, int end, int radix) {
        int intValue = parseInt(start, end, radix);
        short result = (short) intValue;
        if (result == intValue) {
            return result;
        }
        throw new NumberFormatException(subSequence(start, end, false).toString());
    }

    public int parseInt() {
        return parseInt(0, length(), 10);
    }

    public int parseInt(int radix) {
        return parseInt(0, length(), radix);
    }

    public int parseInt(int start, int end) {
        return parseInt(start, end, 10);
    }

    public int parseInt(int start, int end, int radix) {
        if (radix < 2 || radix > 36) {
            throw new NumberFormatException();
        } else if (start == end) {
            throw new NumberFormatException();
        } else {
            int i = start;
            boolean negative = byteAt(i) == 45;
            if (negative) {
                i++;
                if (i == end) {
                    throw new NumberFormatException(subSequence(start, end, false).toString());
                }
            }
            return parseInt(i, end, radix, negative);
        }
    }

    private int parseInt(int start, int end, int radix, boolean negative) {
        int max = Integer.MIN_VALUE / radix;
        int result = 0;
        int currOffset = start;
        while (currOffset < end) {
            currOffset++;
            int digit = Character.digit((char) (this.value[currOffset + this.offset] & 255), radix);
            if (digit == -1) {
                throw new NumberFormatException(subSequence(start, end, false).toString());
            } else if (max > result) {
                throw new NumberFormatException(subSequence(start, end, false).toString());
            } else {
                int next = (result * radix) - digit;
                if (next > result) {
                    throw new NumberFormatException(subSequence(start, end, false).toString());
                }
                result = next;
            }
        }
        if (!negative) {
            result = -result;
            if (result < 0) {
                throw new NumberFormatException(subSequence(start, end, false).toString());
            }
        }
        return result;
    }

    public long parseLong() {
        return parseLong(0, length(), 10);
    }

    public long parseLong(int radix) {
        return parseLong(0, length(), radix);
    }

    public long parseLong(int start, int end) {
        return parseLong(start, end, 10);
    }

    public long parseLong(int start, int end, int radix) {
        if (radix < 2 || radix > 36) {
            throw new NumberFormatException();
        } else if (start == end) {
            throw new NumberFormatException();
        } else {
            int i = start;
            boolean negative = byteAt(i) == 45;
            if (negative) {
                i++;
                if (i == end) {
                    throw new NumberFormatException(subSequence(start, end, false).toString());
                }
            }
            return parseLong(i, end, radix, negative);
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long parseLong(int r8, int r9, int r10, boolean r11) {
        /*
            r7 = this;
            r0 = -9223372036854775808
            r1 = r10
            long r1 = (long) r1
            long r0 = r0 / r1
            r12 = r0
            r0 = 0
            r14 = r0
            r0 = r8
            r16 = r0
        L_0x000e:
            r0 = r16
            r1 = r9
            if (r0 >= r1) goto L_0x008c
            r0 = r7
            byte[] r0 = r0.value
            r1 = r16
            int r16 = r16 + 1
            r2 = r7
            int r2 = r2.offset
            int r1 = r1 + r2
            r0 = r0[r1]
            r1 = 255(0xff, float:3.57E-43)
            r0 = r0 & r1
            char r0 = (char) r0
            r1 = r10
            int r0 = java.lang.Character.digit(r0, r1)
            r17 = r0
            r0 = r17
            r1 = -1
            if (r0 != r1) goto L_0x0046
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r9
            r5 = 0
            io.netty.util.AsciiString r2 = r2.subSequence(r3, r4, r5)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0046:
            r0 = r12
            r1 = r14
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0060
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r9
            r5 = 0
            io.netty.util.AsciiString r2 = r2.subSequence(r3, r4, r5)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0060:
            r0 = r14
            r1 = r10
            long r1 = (long) r1
            long r0 = r0 * r1
            r1 = r17
            long r1 = (long) r1
            long r0 = r0 - r1
            r18 = r0
            r0 = r18
            r1 = r14
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0085
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r9
            r5 = 0
            io.netty.util.AsciiString r2 = r2.subSequence(r3, r4, r5)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0085:
            r0 = r18
            r14 = r0
            goto L_0x000e
        L_0x008c:
            r0 = r11
            if (r0 != 0) goto L_0x00af
            r0 = r14
            long r0 = -r0
            r14 = r0
            r0 = r14
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00af
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r9
            r5 = 0
            io.netty.util.AsciiString r2 = r2.subSequence(r3, r4, r5)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x00af:
            r0 = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.AsciiString.parseLong(int, int, int, boolean):long");
    }

    public float parseFloat() {
        return parseFloat(0, length());
    }

    public float parseFloat(int start, int end) {
        return Float.parseFloat(toString(start, end));
    }

    public double parseDouble() {
        return parseDouble(0, length());
    }

    public double parseDouble(int start, int end) {
        return Double.parseDouble(toString(start, end));
    }

    /* renamed from: of */
    public static AsciiString m1174of(CharSequence string) {
        return string instanceof AsciiString ? (AsciiString) string : new AsciiString(string);
    }

    public static AsciiString cached(String string) {
        AsciiString asciiString = new AsciiString(string);
        asciiString.string = string;
        return asciiString;
    }

    public static int hashCode(CharSequence value) {
        if (value == null) {
            return 0;
        }
        if (value instanceof AsciiString) {
            return value.hashCode();
        }
        return PlatformDependent.hashCodeAscii(value);
    }

    public static boolean contains(CharSequence a, CharSequence b) {
        return contains(a, b, DefaultCharEqualityComparator.INSTANCE);
    }

    public static boolean containsIgnoreCase(CharSequence a, CharSequence b) {
        return contains(a, b, AsciiCaseInsensitiveCharEqualityComparator.INSTANCE);
    }

    public static boolean contentEqualsIgnoreCase(CharSequence a, CharSequence b) {
        if (a == null || b == null) {
            return a == b;
        }
        if (a instanceof AsciiString) {
            return ((AsciiString) a).contentEqualsIgnoreCase(b);
        }
        if (b instanceof AsciiString) {
            return ((AsciiString) b).contentEqualsIgnoreCase(a);
        }
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (!equalsIgnoreCase(a.charAt(i), b.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsContentEqualsIgnoreCase(Collection<CharSequence> collection, CharSequence value) {
        for (CharSequence v : collection) {
            if (contentEqualsIgnoreCase(value, v)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsAllContentEqualsIgnoreCase(Collection<CharSequence> a, Collection<CharSequence> b) {
        for (CharSequence v : b) {
            if (!containsContentEqualsIgnoreCase(a, v)) {
                return false;
            }
        }
        return true;
    }

    public static boolean contentEquals(CharSequence a, CharSequence b) {
        if (a == null || b == null) {
            return a == b;
        }
        if (a instanceof AsciiString) {
            return ((AsciiString) a).contentEquals(b);
        }
        if (b instanceof AsciiString) {
            return ((AsciiString) b).contentEquals(a);
        }
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static AsciiString[] toAsciiStringArray(String[] jdkResult) {
        AsciiString[] res = new AsciiString[jdkResult.length];
        for (int i = 0; i < jdkResult.length; i++) {
            res[i] = new AsciiString(jdkResult[i]);
        }
        return res;
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.AsciiString$DefaultCharEqualityComparator */
    /* loaded from: grasscutter.jar:io/netty/util/AsciiString$DefaultCharEqualityComparator.class */
    public static final class DefaultCharEqualityComparator implements CharEqualityComparator {
        static final DefaultCharEqualityComparator INSTANCE = new DefaultCharEqualityComparator();

        private DefaultCharEqualityComparator() {
        }

        @Override // p013io.netty.util.AsciiString.CharEqualityComparator
        public boolean equals(char a, char b) {
            return a == b;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.AsciiString$AsciiCaseInsensitiveCharEqualityComparator */
    /* loaded from: grasscutter.jar:io/netty/util/AsciiString$AsciiCaseInsensitiveCharEqualityComparator.class */
    public static final class AsciiCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final AsciiCaseInsensitiveCharEqualityComparator INSTANCE = new AsciiCaseInsensitiveCharEqualityComparator();

        private AsciiCaseInsensitiveCharEqualityComparator() {
        }

        @Override // p013io.netty.util.AsciiString.CharEqualityComparator
        public boolean equals(char a, char b) {
            return AsciiString.equalsIgnoreCase(a, b);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.AsciiString$GeneralCaseInsensitiveCharEqualityComparator */
    /* loaded from: grasscutter.jar:io/netty/util/AsciiString$GeneralCaseInsensitiveCharEqualityComparator.class */
    public static final class GeneralCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final GeneralCaseInsensitiveCharEqualityComparator INSTANCE = new GeneralCaseInsensitiveCharEqualityComparator();

        private GeneralCaseInsensitiveCharEqualityComparator() {
        }

        @Override // p013io.netty.util.AsciiString.CharEqualityComparator
        public boolean equals(char a, char b) {
            return Character.toUpperCase(a) == Character.toUpperCase(b) || Character.toLowerCase(a) == Character.toLowerCase(b);
        }
    }

    private static boolean contains(CharSequence a, CharSequence b, CharEqualityComparator cmp) {
        if (a == null || b == null || a.length() < b.length()) {
            return false;
        }
        if (b.length() == 0) {
            return true;
        }
        int bStart = 0;
        for (int i = 0; i < a.length(); i++) {
            if (cmp.equals(b.charAt(bStart), a.charAt(i))) {
                bStart++;
                if (bStart == b.length()) {
                    return true;
                }
            } else if (a.length() - i < b.length()) {
                return false;
            } else {
                bStart = 0;
            }
        }
        return false;
    }

    private static boolean regionMatchesCharSequences(CharSequence cs, int csStart, CharSequence string, int start, int length, CharEqualityComparator charEqualityComparator) {
        if (csStart < 0 || length > cs.length() - csStart || start < 0 || length > string.length() - start) {
            return false;
        }
        int csIndex = csStart;
        int csEnd = csIndex + length;
        int stringIndex = start;
        while (csIndex < csEnd) {
            csIndex++;
            stringIndex++;
            if (!charEqualityComparator.equals(cs.charAt(csIndex), string.charAt(stringIndex))) {
                return false;
            }
        }
        return true;
    }

    public static boolean regionMatches(CharSequence cs, boolean ignoreCase, int csStart, CharSequence string, int start, int length) {
        if (cs == null || string == null) {
            return false;
        }
        if ((cs instanceof String) && (string instanceof String)) {
            return ((String) cs).regionMatches(ignoreCase, csStart, (String) string, start, length);
        }
        if (cs instanceof AsciiString) {
            return ((AsciiString) cs).regionMatches(ignoreCase, csStart, string, start, length);
        }
        return regionMatchesCharSequences(cs, csStart, string, start, length, ignoreCase ? GeneralCaseInsensitiveCharEqualityComparator.INSTANCE : DefaultCharEqualityComparator.INSTANCE);
    }

    public static boolean regionMatchesAscii(CharSequence cs, boolean ignoreCase, int csStart, CharSequence string, int start, int length) {
        if (cs == null || string == null) {
            return false;
        }
        if (!ignoreCase && (cs instanceof String) && (string instanceof String)) {
            return ((String) cs).regionMatches(false, csStart, (String) string, start, length);
        }
        if (cs instanceof AsciiString) {
            return ((AsciiString) cs).regionMatches(ignoreCase, csStart, string, start, length);
        }
        return regionMatchesCharSequences(cs, csStart, string, start, length, ignoreCase ? AsciiCaseInsensitiveCharEqualityComparator.INSTANCE : DefaultCharEqualityComparator.INSTANCE);
    }

    public static int indexOfIgnoreCase(CharSequence str, CharSequence searchStr, int startPos) {
        if (str == null || searchStr == null) {
            return -1;
        }
        if (startPos < 0) {
            startPos = 0;
        }
        int searchStrLen = searchStr.length();
        int endLimit = (str.length() - searchStrLen) + 1;
        if (startPos > endLimit) {
            return -1;
        }
        if (searchStrLen == 0) {
            return startPos;
        }
        for (int i = startPos; i < endLimit; i++) {
            if (regionMatches(str, true, i, searchStr, 0, searchStrLen)) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfIgnoreCaseAscii(CharSequence str, CharSequence searchStr, int startPos) {
        if (str == null || searchStr == null) {
            return -1;
        }
        if (startPos < 0) {
            startPos = 0;
        }
        int searchStrLen = searchStr.length();
        int endLimit = (str.length() - searchStrLen) + 1;
        if (startPos > endLimit) {
            return -1;
        }
        if (searchStrLen == 0) {
            return startPos;
        }
        for (int i = startPos; i < endLimit; i++) {
            if (regionMatchesAscii(str, true, i, searchStr, 0, searchStrLen)) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(CharSequence cs, char searchChar, int start) {
        if (cs instanceof String) {
            return ((String) cs).indexOf(searchChar, start);
        }
        if (cs instanceof AsciiString) {
            return ((AsciiString) cs).indexOf(searchChar, start);
        }
        if (cs == null) {
            return -1;
        }
        int sz = cs.length();
        for (int i = start < 0 ? 0 : start; i < sz; i++) {
            if (cs.charAt(i) == searchChar) {
                return i;
            }
        }
        return -1;
    }

    private static boolean equalsIgnoreCase(byte a, byte b) {
        return a == b || toLowerCase(a) == toLowerCase(b);
    }

    /* access modifiers changed from: private */
    public static boolean equalsIgnoreCase(char a, char b) {
        return a == b || toLowerCase(a) == toLowerCase(b);
    }

    private static byte toLowerCase(byte b) {
        return isUpperCase(b) ? (byte) (b + 32) : b;
    }

    public static char toLowerCase(char c) {
        return isUpperCase(c) ? (char) (c + ' ') : c;
    }

    private static byte toUpperCase(byte b) {
        return isLowerCase(b) ? (byte) (b - 32) : b;
    }

    private static boolean isLowerCase(byte value) {
        return value >= 97 && value <= 122;
    }

    public static boolean isUpperCase(byte value) {
        return value >= 65 && value <= 90;
    }

    public static boolean isUpperCase(char value) {
        return value >= 'A' && value <= 'Z';
    }

    public static byte c2b(char c) {
        return (byte) (c > 255 ? '?' : c);
    }

    private static byte c2b0(char c) {
        return (byte) c;
    }

    public static char b2c(byte b) {
        return (char) (b & 255);
    }
}
