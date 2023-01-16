package p000at.favre.lib.bytes;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import p000at.favre.lib.bytes.BinaryToTextEncoding;
import p000at.favre.lib.bytes.BytesTransformer;
import p000at.favre.lib.bytes.Util;

/* renamed from: at.favre.lib.bytes.Bytes */
/* loaded from: grasscutter.jar:at/favre/lib/bytes/Bytes.class */
public class Bytes implements Comparable<Bytes>, Serializable, Iterable<Byte> {
    private static final Bytes EMPTY = wrap(new byte[0]);
    private final byte[] byteArray;
    private final ByteOrder byteOrder;
    private final BytesFactory factory;
    private transient int hashCodeCache;
    static final long serialVersionUID = 1;

    public static Bytes allocate(int length) {
        return allocate(length, (byte) 0);
    }

    public static Bytes allocate(int length, byte defaultValue) {
        if (length == 0) {
            return empty();
        }
        byte[] array = new byte[length];
        if (defaultValue != 0) {
            Arrays.fill(array, defaultValue);
        }
        return wrap(array);
    }

    public static Bytes empty() {
        return EMPTY;
    }

    public static Bytes wrap(Bytes bytes) {
        return wrap(bytes.internalArray(), bytes.byteOrder);
    }

    public static Bytes wrapNullSafe(byte[] array) {
        return array != null ? wrap(array) : empty();
    }

    public static Bytes wrap(byte[] array) {
        return wrap(array, ByteOrder.BIG_ENDIAN);
    }

    public static Bytes wrap(byte[] array, ByteOrder byteOrder) {
        return new Bytes((byte[]) Objects.requireNonNull(array, "passed array must not be null"), byteOrder);
    }

    public static Bytes from(byte[] byteArrayToCopy) {
        return wrap(Arrays.copyOf((byte[]) Objects.requireNonNull(byteArrayToCopy, "must at least pass a single byte"), byteArrayToCopy.length));
    }

    public static Bytes fromNullSafe(byte[] byteArrayToCopy) {
        return byteArrayToCopy != null ? from(byteArrayToCopy) : empty();
    }

    public static Bytes from(byte[] array, int offset, int length) {
        Objects.requireNonNull(array, "passed array must not be null");
        byte[] part = new byte[length];
        System.arraycopy(array, offset, part, 0, length);
        return wrap(part);
    }

    public static Bytes from(byte[]... moreArrays) {
        return wrap(Util.Byte.concat(moreArrays));
    }

    public static Bytes from(Bytes... moreBytes) {
        Objects.requireNonNull(moreBytes, "bytes most not be null");
        byte[][] bytes = new byte[moreBytes.length];
        for (int i = 0; i < moreBytes.length; i++) {
            bytes[i] = moreBytes[i].array();
        }
        return from(bytes);
    }

    public static Bytes from(Collection<Byte> bytesCollection) {
        return wrap(Util.Converter.toArray(bytesCollection));
    }

    public static Bytes from(Byte[] boxedObjectArray) {
        return wrap(Util.Converter.toPrimitiveArray(boxedObjectArray));
    }

    public static Bytes from(byte singleByte) {
        return wrap(new byte[]{singleByte});
    }

    public static Bytes from(byte firstByte, byte... moreBytes) {
        return wrap(Util.Byte.concatVararg(firstByte, moreBytes));
    }

    public static Bytes from(boolean booleanValue) {
        byte[] bArr = new byte[1];
        bArr[0] = booleanValue ? (byte) 1 : 0;
        return wrap(bArr);
    }

    public static Bytes from(char char2Byte) {
        return wrap(ByteBuffer.allocate(2).putChar(char2Byte).array());
    }

    public static Bytes from(short short2Byte) {
        return wrap(ByteBuffer.allocate(2).putShort(short2Byte).array());
    }

    public static Bytes from(int integer4byte) {
        return wrap(ByteBuffer.allocate(4).putInt(integer4byte).array());
    }

    public static Bytes from(int... intArray) {
        return wrap(Util.Converter.toByteArray((int[]) Objects.requireNonNull(intArray, "must provide at least a single int")));
    }

    public static Bytes from(long long8byte) {
        return wrap(ByteBuffer.allocate(8).putLong(long8byte).array());
    }

    public static Bytes from(long... longArray) {
        return wrap(Util.Converter.toByteArray((long[]) Objects.requireNonNull(longArray, "must provide at least a single long")));
    }

    public static Bytes from(float float4byte) {
        return wrap(ByteBuffer.allocate(4).putFloat(float4byte).array());
    }

    public static Bytes from(double double8Byte) {
        return wrap(ByteBuffer.allocate(8).putDouble(double8Byte).array());
    }

    public static Bytes from(ByteBuffer buffer) {
        return wrap(((ByteBuffer) Objects.requireNonNull(buffer, "provided byte buffer must not be null")).array(), buffer.order());
    }

    public static Bytes from(CharBuffer buffer) {
        return from(((CharBuffer) Objects.requireNonNull(buffer, "provided char buffer must not be null")).array());
    }

    public static Bytes from(IntBuffer buffer) {
        return from(((IntBuffer) Objects.requireNonNull(buffer, "provided int buffer must not be null")).array());
    }

    public static Bytes from(BitSet set) {
        return wrap(set.toByteArray());
    }

    public static Bytes from(BigInteger bigInteger) {
        return wrap(bigInteger.toByteArray());
    }

    public static Bytes from(InputStream stream) {
        return wrap(Util.File.readFromStream(stream, -1));
    }

    public static Bytes from(InputStream stream, int maxLength) {
        return wrap(Util.File.readFromStream(stream, maxLength));
    }

    public static Bytes from(DataInput dataInput, int length) {
        return wrap(Util.File.readFromDataInput(dataInput, length));
    }

    public static Bytes from(File file) {
        return wrap(Util.File.readFromFile(file));
    }

    public static Bytes from(File file, int offset, int length) {
        return wrap(Util.File.readFromFile(file, offset, length));
    }

    public static Bytes from(CharSequence utf8String) {
        return from(utf8String, StandardCharsets.UTF_8);
    }

    public static Bytes from(CharSequence utf8String, Normalizer.Form form) {
        return from(Normalizer.normalize(utf8String, form), StandardCharsets.UTF_8);
    }

    public static Bytes from(CharSequence string, Charset charset) {
        return wrap(((CharSequence) Objects.requireNonNull(string, "provided string must not be null")).toString().getBytes((Charset) Objects.requireNonNull(charset, "provided charset must not be null")));
    }

    public static Bytes from(char[] charArray) {
        return from(charArray, StandardCharsets.UTF_8);
    }

    public static Bytes from(char[] charArray, Charset charset) {
        return from(charArray, charset, 0, charArray.length);
    }

    public static Bytes from(char[] charArray, Charset charset, int offset, int length) {
        return from(Util.Converter.charToByteArray(charArray, charset, offset, length));
    }

    public static Bytes from(UUID uuid) {
        return wrap(Util.Converter.toBytesFromUUID((UUID) Objects.requireNonNull(uuid)).array());
    }

    public static Bytes parseBinary(CharSequence binaryString) {
        return parseRadix(binaryString, 2);
    }

    public static Bytes parseOctal(CharSequence octalString) {
        return parseRadix(octalString, 8);
    }

    public static Bytes parseDec(CharSequence decString) {
        return parseRadix(decString, 10);
    }

    public static Bytes parseRadix(CharSequence radixNumberString, int radix) {
        return parse(radixNumberString, new BinaryToTextEncoding.BaseRadixNumber(radix));
    }

    public static Bytes parseHex(CharSequence hexString) {
        return parse(hexString, new BinaryToTextEncoding.Hex());
    }

    public static Bytes parseBase32(CharSequence base32Rfc4648String) {
        return parse(base32Rfc4648String, new BaseEncoding(BaseEncoding.BASE32_RFC4848, '='));
    }

    @Deprecated
    public static Bytes parseBase36(CharSequence base36String) {
        return parse(base36String, new BinaryToTextEncoding.BaseRadixNumber(36));
    }

    public static Bytes parseBase64(CharSequence base64String) {
        return parse(base64String, new BinaryToTextEncoding.Base64Encoding());
    }

    public static Bytes parse(CharSequence encoded, BinaryToTextEncoding.Decoder decoder) {
        return wrap(((BinaryToTextEncoding.Decoder) Objects.requireNonNull(decoder, "passed decoder instance must no be null")).decode((CharSequence) Objects.requireNonNull(encoded, "encoded data must not be null")));
    }

    public static Bytes random(int length) {
        return random(length, new SecureRandom());
    }

    public static Bytes unsecureRandom(int length) {
        return random(length, new Random());
    }

    public static Bytes unsecureRandom(int length, long seed) {
        return random(length, new Random(seed));
    }

    public static Bytes random(int length, Random random) {
        byte[] array = new byte[length];
        random.nextBytes(array);
        return wrap(array);
    }

    Bytes(byte[] byteArray, ByteOrder byteOrder) {
        this(byteArray, byteOrder, new Factory());
    }

    /* access modifiers changed from: package-private */
    public Bytes(byte[] byteArray, ByteOrder byteOrder, BytesFactory factory) {
        this.byteArray = byteArray;
        this.byteOrder = byteOrder;
        this.factory = factory;
    }

    public Bytes append(Bytes bytes) {
        return append(bytes.internalArray());
    }

    public Bytes append(byte singleByte) {
        return append(from(singleByte));
    }

    public Bytes append(char char2Bytes) {
        return append(from(char2Bytes));
    }

    public Bytes append(short short2Bytes) {
        return append(from(short2Bytes));
    }

    public Bytes append(int integer4Bytes) {
        return append(from(integer4Bytes));
    }

    public Bytes append(long long8Bytes) {
        return append(from(long8Bytes));
    }

    public Bytes append(byte[]... arrays) {
        return append(from(arrays));
    }

    public Bytes append(byte[] secondArray) {
        return transform(new BytesTransformer.ConcatTransformer(secondArray));
    }

    public Bytes appendNullSafe(byte[] secondArrayNullable) {
        return secondArrayNullable == null ? this : append(secondArrayNullable);
    }

    public Bytes append(CharSequence stringUtf8) {
        return append(stringUtf8, StandardCharsets.UTF_8);
    }

    public Bytes append(CharSequence string, Charset charset) {
        return transform(new BytesTransformer.ConcatTransformer(((CharSequence) Objects.requireNonNull(string)).toString().getBytes((Charset) Objects.requireNonNull(charset))));
    }

    public Bytes xor(Bytes bytes) {
        return xor(bytes.internalArray());
    }

    public Bytes xor(byte[] secondArray) {
        return transform(new BytesTransformer.BitWiseOperatorTransformer(secondArray, BytesTransformer.BitWiseOperatorTransformer.Mode.XOR));
    }

    public Bytes and(Bytes bytes) {
        return and(bytes.internalArray());
    }

    public Bytes and(byte[] secondArray) {
        return transform(new BytesTransformer.BitWiseOperatorTransformer(secondArray, BytesTransformer.BitWiseOperatorTransformer.Mode.AND));
    }

    /* renamed from: or */
    public Bytes m1595or(Bytes bytes) {
        return m1594or(bytes.internalArray());
    }

    /* renamed from: or */
    public Bytes m1594or(byte[] secondArray) {
        return transform(new BytesTransformer.BitWiseOperatorTransformer(secondArray, BytesTransformer.BitWiseOperatorTransformer.Mode.OR));
    }

    public Bytes not() {
        return transform(new BytesTransformer.NegateTransformer());
    }

    public Bytes leftShift(int shiftCount) {
        return transform(new BytesTransformer.ShiftTransformer(shiftCount, BytesTransformer.ShiftTransformer.Type.LEFT_SHIFT));
    }

    public Bytes rightShift(int shiftCount) {
        return transform(new BytesTransformer.ShiftTransformer(shiftCount, BytesTransformer.ShiftTransformer.Type.RIGHT_SHIFT));
    }

    public Bytes switchBit(int bitPosition, boolean newBitValue) {
        return transform(new BytesTransformer.BitSwitchTransformer(bitPosition, Boolean.valueOf(newBitValue)));
    }

    public Bytes switchBit(int bitPosition) {
        return transform(new BytesTransformer.BitSwitchTransformer(bitPosition, null));
    }

    public Bytes copy() {
        return transform(new BytesTransformer.CopyTransformer(0, length()));
    }

    public Bytes copy(int offset, int length) {
        return transform(new BytesTransformer.CopyTransformer(offset, length));
    }

    public Bytes reverse() {
        return transform(new BytesTransformer.ReverseTransformer());
    }

    public Bytes resize(int newByteLength) {
        return resize(newByteLength, BytesTransformer.ResizeTransformer.Mode.RESIZE_KEEP_FROM_MAX_LENGTH);
    }

    public Bytes resize(int newByteLength, BytesTransformer.ResizeTransformer.Mode mode) {
        return transform(new BytesTransformer.ResizeTransformer(newByteLength, mode));
    }

    public Bytes hashMd5() {
        return hash("MD5");
    }

    public Bytes hashSha1() {
        return hash("SHA-1");
    }

    public Bytes hashSha256() {
        return hash("SHA-256");
    }

    public Bytes hash(String algorithm) {
        return transform(new BytesTransformer.MessageDigestTransformer(algorithm));
    }

    public Bytes transform(BytesTransformer transformer) {
        return this.factory.wrap(transformer.transform(internalArray(), isMutable()), this.byteOrder);
    }

    public boolean validateNotOnlyZeros() {
        return validate(BytesValidators.notOnlyOf((byte) 0));
    }

    public boolean validate(BytesValidator... bytesValidators) {
        return BytesValidators.and((BytesValidator[]) Objects.requireNonNull(bytesValidators)).validate(internalArray());
    }

    public int length() {
        return internalArray().length;
    }

    public int lengthBit() {
        return length() * 8;
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    public ByteOrder byteOrder() {
        return this.byteOrder;
    }

    public boolean isMutable() {
        return false;
    }

    public boolean isReadOnly() {
        return false;
    }

    public boolean contains(byte target) {
        return indexOf(target) != -1;
    }

    public int indexOf(byte target) {
        return indexOf(target, 0);
    }

    public int indexOf(byte target, int fromIndex) {
        return indexOf(new byte[]{target}, fromIndex);
    }

    public int indexOf(byte[] subArray) {
        return indexOf(subArray, 0);
    }

    public int indexOf(byte[] subArray, int fromIndex) {
        return Util.Byte.indexOf(internalArray(), subArray, fromIndex, length());
    }

    public boolean startsWith(byte[] subArray) {
        return Util.Byte.indexOf(internalArray(), subArray, 0, 1) == 0;
    }

    public int lastIndexOf(byte target) {
        return Util.Byte.lastIndexOf(internalArray(), target, 0, length());
    }

    public boolean endsWith(byte[] subArray) {
        int startIndex = length() - subArray.length;
        return startIndex >= 0 && Util.Byte.indexOf(internalArray(), subArray, startIndex, startIndex + 1) == startIndex;
    }

    public boolean bitAt(int bitIndex) {
        Util.Validation.checkIndexBounds(lengthBit(), bitIndex, 1, "bit");
        return ((byteAt((length() - 1) - (bitIndex / 8)) >>> (bitIndex % 8)) & 1) != 0;
    }

    public byte byteAt(int index) {
        Util.Validation.checkIndexBounds(length(), index, 1, "byte");
        return internalArray()[index];
    }

    public int unsignedByteAt(int index) {
        Util.Validation.checkIndexBounds(length(), index, 1, "unsigned byte");
        return 255 & internalArray()[index];
    }

    public char charAt(int index) {
        Util.Validation.checkIndexBounds(length(), index, 2, "char");
        return ((ByteBuffer) internalBuffer().position(index)).getChar();
    }

    public short shortAt(int index) {
        Util.Validation.checkIndexBounds(length(), index, 2, "short");
        return ((ByteBuffer) internalBuffer().position(index)).getShort();
    }

    public int intAt(int index) {
        Util.Validation.checkIndexBounds(length(), index, 4, "int");
        return ((ByteBuffer) internalBuffer().position(index)).getInt();
    }

    public long longAt(int index) {
        Util.Validation.checkIndexBounds(length(), index, 8, "long");
        return ((ByteBuffer) internalBuffer().position(index)).getLong();
    }

    public int count(byte target) {
        return Util.Byte.countByte(internalArray(), target);
    }

    public int count(byte[] pattern) {
        return Util.Byte.countByteArray(internalArray(), pattern);
    }

    public double entropy() {
        return Util.Byte.entropy(internalArray());
    }

    public Bytes duplicate() {
        return this.factory.wrap(internalArray(), this.byteOrder);
    }

    public Bytes byteOrder(ByteOrder byteOrder) {
        if (byteOrder != this.byteOrder) {
            return wrap(internalArray(), byteOrder);
        }
        return this;
    }

    public ReadOnlyBytes readOnly() {
        if (isReadOnly()) {
            return (ReadOnlyBytes) this;
        }
        return new ReadOnlyBytes(internalArray(), this.byteOrder);
    }

    public ByteBuffer buffer() {
        return ByteBuffer.wrap(array()).order(this.byteOrder);
    }

    private ByteBuffer internalBuffer() {
        return ByteBuffer.wrap(internalArray()).order(this.byteOrder);
    }

    public MutableBytes mutable() {
        if (this instanceof MutableBytes) {
            return (MutableBytes) this;
        }
        return new MutableBytes(array(), this.byteOrder);
    }

    public InputStream inputStream() {
        return new ByteArrayInputStream(array());
    }

    public byte[] array() {
        return internalArray();
    }

    byte[] internalArray() {
        return this.byteArray;
    }

    public String encodeBinary() {
        return encodeRadix(2);
    }

    public String encodeOctal() {
        return encodeRadix(8);
    }

    public String encodeDec() {
        return encodeRadix(10);
    }

    public String encodeRadix(int radix) {
        return encode(new BinaryToTextEncoding.BaseRadixNumber(radix));
    }

    public String encodeHex() {
        return encodeHex(false);
    }

    public String encodeHex(boolean upperCase) {
        return encode(new BinaryToTextEncoding.Hex(upperCase));
    }

    public String encodeBase32() {
        return encode(new BaseEncoding(BaseEncoding.BASE32_RFC4848, '='));
    }

    @Deprecated
    public String encodeBase36() {
        return encodeRadix(36);
    }

    public String encodeBase64() {
        return encodeBase64(false, true);
    }

    public String encodeBase64Url() {
        return encodeBase64(true, true);
    }

    public String encodeBase64(boolean urlSafe, boolean withPadding) {
        return encode(new BinaryToTextEncoding.Base64Encoding(urlSafe, withPadding));
    }

    public String encodeUtf8() {
        return encodeCharset(StandardCharsets.UTF_8);
    }

    public String encodeCharset(Charset charset) {
        return new String(internalArray(), (Charset) Objects.requireNonNull(charset, "given charset must not be null"));
    }

    public byte[] encodeUtf8ToBytes() {
        return encodeCharsetToBytes(StandardCharsets.UTF_8);
    }

    public byte[] encodeCharsetToBytes(Charset charset) {
        return encodeCharset(charset).getBytes(charset);
    }

    public String encode(BinaryToTextEncoding.Encoder encoder) {
        return encoder.encode(internalArray(), this.byteOrder);
    }

    public List<Byte> toList() {
        return Util.Converter.toList(internalArray());
    }

    public Byte[] toBoxedArray() {
        return Util.Converter.toBoxedArray(internalArray());
    }

    public BitSet toBitSet() {
        return BitSet.valueOf(internalArray());
    }

    public BigInteger toBigInteger() {
        if (this.byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return new BigInteger(new BytesTransformer.ReverseTransformer().transform(internalArray(), false));
        }
        return new BigInteger(internalArray());
    }

    public UUID toUUID() {
        if (length() != 16) {
            throw new IllegalStateException("creating UUID requires internal array to be exactly 16 bytes, was " + length());
        }
        ByteBuffer byteBuffer = buffer();
        return new UUID(byteBuffer.getLong(), byteBuffer.getLong());
    }

    public byte toByte() {
        Util.Validation.checkExactLength(length(), 1, "byte");
        return internalArray()[0];
    }

    public int toUnsignedByte() {
        Util.Validation.checkExactLength(length(), 1, "unsigned byte");
        return unsignedByteAt(0);
    }

    public char toChar() {
        Util.Validation.checkExactLength(length(), 2, "char");
        return charAt(0);
    }

    public short toShort() {
        Util.Validation.checkExactLength(length(), 2, "short");
        return shortAt(0);
    }

    public int toInt() {
        Util.Validation.checkExactLength(length(), 4, "int");
        return intAt(0);
    }

    public int[] toIntArray() {
        Util.Validation.checkModLength(length(), 4, "creating an int array");
        return Util.Converter.toIntArray(internalArray(), this.byteOrder);
    }

    public long toLong() {
        Util.Validation.checkExactLength(length(), 8, "long");
        return longAt(0);
    }

    public long[] toLongArray() {
        Util.Validation.checkModLength(length(), 8, "creating an long array");
        return Util.Converter.toLongArray(internalArray(), this.byteOrder);
    }

    public float toFloat() {
        Util.Validation.checkExactLength(length(), 4, "float");
        return internalBuffer().getFloat();
    }

    public float[] toFloatArray() {
        Util.Validation.checkModLength(length(), 4, "creating an float array");
        return Util.Converter.toFloatArray(internalArray(), this.byteOrder);
    }

    public double toDouble() {
        Util.Validation.checkExactLength(length(), 8, "double");
        return internalBuffer().getDouble();
    }

    public double[] toDoubleArray() {
        Util.Validation.checkModLength(length(), 8, "creating an double array");
        return Util.Converter.toDoubleArray(internalArray(), this.byteOrder);
    }

    public char[] toCharArray() {
        return toCharArray(StandardCharsets.UTF_8);
    }

    public char[] toCharArray(Charset charset) {
        return Util.Converter.byteToCharArray(internalArray(), charset, this.byteOrder);
    }

    public int compareTo(Bytes o) {
        return internalBuffer().compareTo(o.internalBuffer());
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bytes bytes = (Bytes) o;
        if (!Arrays.equals(this.byteArray, bytes.byteArray)) {
            return false;
        }
        return Objects.equals(this.byteOrder, bytes.byteOrder);
    }

    public boolean equals(byte[] anotherArray) {
        return anotherArray != null && Arrays.equals(internalArray(), anotherArray);
    }

    public boolean equalsConstantTime(byte[] anotherArray) {
        return anotherArray != null && Util.Byte.constantTimeEquals(internalArray(), anotherArray);
    }

    public boolean equals(Byte[] anotherArray) {
        return Util.Obj.equals(internalArray(), anotherArray);
    }

    public boolean equals(ByteBuffer buffer) {
        return buffer != null && this.byteOrder == buffer.order() && internalBuffer().equals(buffer);
    }

    public boolean equalsContent(Bytes other) {
        return other != null && Arrays.equals(internalArray(), other.internalArray());
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.hashCodeCache == 0) {
            this.hashCodeCache = Util.Obj.hashCode(internalArray(), byteOrder());
        }
        return this.hashCodeCache;
    }

    @Override // java.lang.Object
    public String toString() {
        return Util.Obj.toString(this);
    }

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new Util.BytesIterator(internalArray());
    }

    /* renamed from: at.favre.lib.bytes.Bytes$Factory */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/Bytes$Factory.class */
    private static class Factory implements BytesFactory {
        private Factory() {
        }

        @Override // p000at.favre.lib.bytes.BytesFactory
        public Bytes wrap(byte[] array, ByteOrder byteOrder) {
            return new Bytes(array, byteOrder);
        }
    }
}
