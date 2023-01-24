package com.google.protobuf;

import java.nio.ByteBuffer;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/Utf8.class */
public final class Utf8 {
    private static final Processor processor;
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int MAX_BYTES_PER_CHAR = 3;
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;

    static {
        processor = (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    public static boolean isValidUtf8(byte[] bytes) {
        return processor.isValidUtf8(bytes, 0, bytes.length);
    }

    public static boolean isValidUtf8(byte[] bytes, int index, int limit) {
        return processor.isValidUtf8(bytes, index, limit);
    }

    public static int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
        return processor.partialIsValidUtf8(state, bytes, index, limit);
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(int byte1) {
        if (byte1 > -12) {
            return -1;
        }
        return byte1;
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(int byte1, int byte2) {
        if (byte1 > -12 || byte2 > -65) {
            return -1;
        }
        return byte1 ^ (byte2 << 8);
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(int byte1, int byte2, int byte3) {
        if (byte1 > -12 || byte2 > -65 || byte3 > -65) {
            return -1;
        }
        return (byte1 ^ (byte2 << 8)) ^ (byte3 << 16);
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bytes, int index, int limit) {
        byte b = bytes[index - 1];
        switch (limit - index) {
            case 0:
                return incompleteStateFor(b);
            case 1:
                return incompleteStateFor(b, bytes[index]);
            case 2:
                return incompleteStateFor(b, bytes[index], bytes[index + 1]);
            default:
                throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer buffer, int byte1, int index, int remaining) {
        switch (remaining) {
            case 0:
                return incompleteStateFor(byte1);
            case 1:
                return incompleteStateFor(byte1, buffer.get(index));
            case 2:
                return incompleteStateFor(byte1, buffer.get(index), buffer.get(index + 1));
            default:
                throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/protobuf/Utf8$UnpairedSurrogateException.class */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        /* access modifiers changed from: package-private */
        public UnpairedSurrogateException(int index, int length) {
            super("Unpaired surrogate at index " + index + " of " + length);
        }
    }

    /* access modifiers changed from: package-private */
    public static int encodedLength(CharSequence sequence) {
        int utf16Length = sequence.length();
        int utf8Length = utf16Length;
        int i = 0;
        while (i < utf16Length && sequence.charAt(i) < 128) {
            i++;
        }
        while (true) {
            if (i < utf16Length) {
                char c = sequence.charAt(i);
                if (c >= 2048) {
                    utf8Length += encodedLengthGeneral(sequence, i);
                    break;
                }
                utf8Length += (127 - c) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (utf8Length >= utf16Length) {
            return utf8Length;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) utf8Length) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence sequence, int start) {
        int utf16Length = sequence.length();
        int utf8Length = 0;
        int i = start;
        while (i < utf16Length) {
            char c = sequence.charAt(i);
            if (c < 2048) {
                utf8Length += (127 - c) >>> 31;
            } else {
                utf8Length += 2;
                if (55296 <= c && c <= 57343) {
                    if (Character.codePointAt(sequence, i) < 65536) {
                        throw new UnpairedSurrogateException(i, utf16Length);
                    }
                    i++;
                }
            }
            i++;
        }
        return utf8Length;
    }

    /* access modifiers changed from: package-private */
    public static int encode(CharSequence in, byte[] out, int offset, int length) {
        return processor.encodeUtf8(in, out, offset, length);
    }

    /* access modifiers changed from: package-private */
    public static boolean isValidUtf8(ByteBuffer buffer) {
        return processor.isValidUtf8(buffer, buffer.position(), buffer.remaining());
    }

    /* access modifiers changed from: package-private */
    public static int partialIsValidUtf8(int state, ByteBuffer buffer, int index, int limit) {
        return processor.partialIsValidUtf8(state, buffer, index, limit);
    }

    /* access modifiers changed from: package-private */
    public static String decodeUtf8(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(buffer, index, size);
    }

    /* access modifiers changed from: package-private */
    public static String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bytes, index, size);
    }

    /* access modifiers changed from: package-private */
    public static void encodeUtf8(CharSequence in, ByteBuffer out) {
        processor.encodeUtf8(in, out);
    }

    /* access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer buffer, int index, int limit) {
        int i = index;
        int lim = limit - 7;
        while (i < lim && (buffer.getLong(i) & ASCII_MASK_LONG) == 0) {
            i += 8;
        }
        return i - index;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/protobuf/Utf8$Processor.class */
    public static abstract class Processor {
        abstract int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3);

        abstract int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3);

        abstract String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException;

        abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2);

        abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        Processor() {
        }

        final boolean isValidUtf8(byte[] bytes, int index, int limit) {
            return partialIsValidUtf8(0, bytes, index, limit) == 0;
        }

        final boolean isValidUtf8(ByteBuffer buffer, int index, int limit) {
            return partialIsValidUtf8(0, buffer, index, limit) == 0;
        }

        final int partialIsValidUtf8(int state, ByteBuffer buffer, int index, int limit) {
            if (buffer.hasArray()) {
                int offset = buffer.arrayOffset();
                return partialIsValidUtf8(state, buffer.array(), offset + index, offset + limit);
            } else if (buffer.isDirect()) {
                return partialIsValidUtf8Direct(state, buffer, index, limit);
            } else {
                return partialIsValidUtf8Default(state, buffer, index, limit);
            }
        }

        final int partialIsValidUtf8Default(int state, ByteBuffer buffer, int index, int limit) {
            if (state != 0) {
                if (index >= limit) {
                    return state;
                }
                byte byte1 = (byte) state;
                if (byte1 < -32) {
                    if (byte1 < -62) {
                        return -1;
                    }
                    index++;
                    if (buffer.get(index) > -65) {
                        return -1;
                    }
                } else if (byte1 < -16) {
                    byte byte2 = (byte) ((state >> 8) ^ -1);
                    if (byte2 == 0) {
                        index++;
                        byte2 = buffer.get(index);
                        if (index >= limit) {
                            return Utf8.incompleteStateFor(byte1, byte2);
                        }
                    }
                    if (byte2 > -65) {
                        return -1;
                    }
                    if (byte1 == -32 && byte2 < -96) {
                        return -1;
                    }
                    if (byte1 == -19 && byte2 >= -96) {
                        return -1;
                    }
                    index++;
                    if (buffer.get(index) > -65) {
                        return -1;
                    }
                } else {
                    byte byte22 = (byte) ((state >> 8) ^ -1);
                    byte byte3 = 0;
                    if (byte22 == 0) {
                        index++;
                        byte22 = buffer.get(index);
                        if (index >= limit) {
                            return Utf8.incompleteStateFor(byte1, byte22);
                        }
                    } else {
                        byte3 = (byte) (state >> 16);
                    }
                    if (byte3 == 0) {
                        index++;
                        byte3 = buffer.get(index);
                        if (index >= limit) {
                            return Utf8.incompleteStateFor(byte1, byte22, byte3);
                        }
                    }
                    if (byte22 > -65 || (((byte1 << 28) + (byte22 - -112)) >> 30) != 0 || byte3 > -65) {
                        return -1;
                    }
                    index++;
                    if (buffer.get(index) > -65) {
                        return -1;
                    }
                }
            }
            return partialIsValidUtf8(buffer, index, limit);
        }

        private static int partialIsValidUtf8(ByteBuffer buffer, int index, int limit) {
            int index2 = index + Utf8.estimateConsecutiveAscii(buffer, index, limit);
            while (index2 < limit) {
                index2++;
                int byte1 = buffer.get(index2);
                if (byte1 < 0) {
                    if (byte1 < -32) {
                        if (index2 >= limit) {
                            return byte1;
                        }
                        if (byte1 < -62 || buffer.get(index2) > -65) {
                            return -1;
                        }
                        index2++;
                    } else if (byte1 < -16) {
                        if (index2 >= limit - 1) {
                            return Utf8.incompleteStateFor(buffer, byte1, index2, limit - index2);
                        }
                        int index3 = index2 + 1;
                        byte byte2 = buffer.get(index2);
                        if (byte2 > -65) {
                            return -1;
                        }
                        if (byte1 == -32 && byte2 < -96) {
                            return -1;
                        }
                        if ((byte1 == -19 && byte2 >= -96) || buffer.get(index3) > -65) {
                            return -1;
                        }
                        index2 = index3 + 1;
                    } else if (index2 >= limit - 2) {
                        return Utf8.incompleteStateFor(buffer, byte1, index2, limit - index2);
                    } else {
                        int index4 = index2 + 1;
                        int byte22 = buffer.get(index2);
                        if (byte22 > -65 || (((byte1 << 28) + (byte22 - -112)) >> 30) != 0) {
                            return -1;
                        }
                        int index5 = index4 + 1;
                        if (buffer.get(index4) > -65) {
                            return -1;
                        }
                        index2 = index5 + 1;
                        if (buffer.get(index5) > -65) {
                            return -1;
                        }
                    }
                }
            }
            return 0;
        }

        final String decodeUtf8(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if (buffer.hasArray()) {
                return decodeUtf8(buffer.array(), buffer.arrayOffset() + index, size);
            } else if (buffer.isDirect()) {
                return decodeUtf8Direct(buffer, index, size);
            } else {
                return decodeUtf8Default(buffer, index, size);
            }
        }

        final String decodeUtf8Default(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if ((index | size | ((buffer.limit() - index) - size)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(size)));
            }
            int offset = index;
            int limit = offset + size;
            char[] resultArr = new char[size];
            int resultPos = 0;
            while (offset < limit) {
                byte b = buffer.get(offset);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                offset++;
                resultPos++;
                DecodeUtil.handleOneByte(b, resultArr, resultPos);
            }
            while (offset < limit) {
                offset++;
                byte byte1 = buffer.get(offset);
                if (DecodeUtil.isOneByte(byte1)) {
                    resultPos++;
                    DecodeUtil.handleOneByte(byte1, resultArr, resultPos);
                    while (offset < limit) {
                        byte b2 = buffer.get(offset);
                        if (!DecodeUtil.isOneByte(b2)) {
                            break;
                        }
                        offset++;
                        resultPos++;
                        DecodeUtil.handleOneByte(b2, resultArr, resultPos);
                    }
                } else if (DecodeUtil.isTwoBytes(byte1)) {
                    if (offset >= limit) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    offset++;
                    resultPos++;
                    DecodeUtil.handleTwoBytes(byte1, buffer.get(offset), resultArr, resultPos);
                } else if (DecodeUtil.isThreeBytes(byte1)) {
                    if (offset >= limit - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int offset2 = offset + 1;
                    byte b3 = buffer.get(offset);
                    offset = offset2 + 1;
                    resultPos++;
                    DecodeUtil.handleThreeBytes(byte1, b3, buffer.get(offset2), resultArr, resultPos);
                } else if (offset >= limit - 2) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                } else {
                    int offset3 = offset + 1;
                    byte b4 = buffer.get(offset);
                    int offset4 = offset3 + 1;
                    byte b5 = buffer.get(offset3);
                    offset = offset4 + 1;
                    DecodeUtil.handleFourBytes(byte1, b4, b5, buffer.get(offset4), resultArr, resultPos);
                    resultPos = resultPos + 1 + 1;
                }
            }
            return new String(resultArr, 0, resultPos);
        }

        final void encodeUtf8(CharSequence in, ByteBuffer out) {
            if (out.hasArray()) {
                int offset = out.arrayOffset();
                out.position(Utf8.encode(in, out.array(), offset + out.position(), out.remaining()) - offset);
            } else if (out.isDirect()) {
                encodeUtf8Direct(in, out);
            } else {
                encodeUtf8Default(in, out);
            }
        }

        final void encodeUtf8Default(CharSequence in, ByteBuffer out) {
            int inLength = in.length();
            int outIx = out.position();
            int inIx = 0;
            while (inIx < inLength) {
                try {
                    char c = in.charAt(inIx);
                    if (c >= 128) {
                        break;
                    }
                    out.put(outIx + inIx, (byte) c);
                    inIx++;
                } catch (IndexOutOfBoundsException e) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(inIx) + " at index " + (out.position() + Math.max(inIx, (outIx - out.position()) + 1)));
                }
            }
            if (inIx == inLength) {
                out.position(outIx + inIx);
                return;
            }
            int outIx2 = outIx + inIx;
            while (inIx < inLength) {
                char c2 = in.charAt(inIx);
                if (c2 < 128) {
                    out.put(outIx2, (byte) c2);
                } else if (c2 < 2048) {
                    outIx2++;
                    out.put(outIx2, (byte) (192 | (c2 >>> 6)));
                    out.put(outIx2, (byte) (128 | ('?' & c2)));
                } else if (c2 < 55296 || 57343 < c2) {
                    int outIx3 = outIx2 + 1;
                    out.put(outIx2, (byte) (224 | (c2 >>> '\f')));
                    outIx2 = outIx3 + 1;
                    out.put(outIx3, (byte) (128 | (63 & (c2 >>> 6))));
                    out.put(outIx2, (byte) (128 | ('?' & c2)));
                } else {
                    if (inIx + 1 != inLength) {
                        inIx++;
                        char low = in.charAt(inIx);
                        if (Character.isSurrogatePair(c2, low)) {
                            int codePoint = Character.toCodePoint(c2, low);
                            int outIx4 = outIx2 + 1;
                            out.put(outIx2, (byte) (240 | (codePoint >>> 18)));
                            int outIx5 = outIx4 + 1;
                            out.put(outIx4, (byte) (128 | (63 & (codePoint >>> 12))));
                            outIx2 = outIx5 + 1;
                            out.put(outIx5, (byte) (128 | (63 & (codePoint >>> 6))));
                            out.put(outIx2, (byte) (128 | (63 & codePoint)));
                        }
                    }
                    throw new UnpairedSurrogateException(inIx, inLength);
                }
                inIx++;
                outIx2++;
            }
            out.position(outIx2);
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Utf8$SafeProcessor.class */
    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
            if (state != 0) {
                if (index >= limit) {
                    return state;
                }
                int byte1 = (byte) state;
                if (byte1 < -32) {
                    if (byte1 < -62) {
                        return -1;
                    }
                    index++;
                    if (bytes[index] > -65) {
                        return -1;
                    }
                } else if (byte1 < -16) {
                    int byte2 = (byte) ((state >> 8) ^ -1);
                    if (byte2 == 0) {
                        index++;
                        byte2 = bytes[index];
                        if (index >= limit) {
                            return Utf8.incompleteStateFor(byte1, byte2);
                        }
                    }
                    if (byte2 > -65) {
                        return -1;
                    }
                    if (byte1 == -32 && byte2 < -96) {
                        return -1;
                    }
                    if (byte1 == -19 && byte2 >= -96) {
                        return -1;
                    }
                    index++;
                    if (bytes[index] > -65) {
                        return -1;
                    }
                } else {
                    int byte22 = (byte) ((state >> 8) ^ -1);
                    int byte3 = 0;
                    if (byte22 == 0) {
                        index++;
                        byte22 = bytes[index];
                        if (index >= limit) {
                            return Utf8.incompleteStateFor(byte1, byte22);
                        }
                    } else {
                        byte3 = (byte) (state >> 16);
                    }
                    if (byte3 == 0) {
                        index++;
                        byte3 = bytes[index];
                        if (index >= limit) {
                            return Utf8.incompleteStateFor(byte1, byte22, byte3);
                        }
                    }
                    if (byte22 > -65 || (((byte1 << 28) + (byte22 - -112)) >> 30) != 0 || byte3 > -65) {
                        return -1;
                    }
                    index++;
                    if (bytes[index] > -65) {
                        return -1;
                    }
                }
            }
            return partialIsValidUtf8(bytes, index, limit);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int state, ByteBuffer buffer, int index, int limit) {
            return partialIsValidUtf8Default(state, buffer, index, limit);
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
            if ((index | size | ((bytes.length - index) - size)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bytes.length), Integer.valueOf(index), Integer.valueOf(size)));
            }
            int offset = index;
            int limit = offset + size;
            char[] resultArr = new char[size];
            int resultPos = 0;
            while (offset < limit) {
                byte b = bytes[offset];
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                offset++;
                resultPos++;
                DecodeUtil.handleOneByte(b, resultArr, resultPos);
            }
            while (offset < limit) {
                offset++;
                byte byte1 = bytes[offset];
                if (DecodeUtil.isOneByte(byte1)) {
                    resultPos++;
                    DecodeUtil.handleOneByte(byte1, resultArr, resultPos);
                    while (offset < limit) {
                        byte b2 = bytes[offset];
                        if (!DecodeUtil.isOneByte(b2)) {
                            break;
                        }
                        offset++;
                        resultPos++;
                        DecodeUtil.handleOneByte(b2, resultArr, resultPos);
                    }
                } else if (DecodeUtil.isTwoBytes(byte1)) {
                    if (offset >= limit) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    offset++;
                    resultPos++;
                    DecodeUtil.handleTwoBytes(byte1, bytes[offset], resultArr, resultPos);
                } else if (DecodeUtil.isThreeBytes(byte1)) {
                    if (offset >= limit - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int offset2 = offset + 1;
                    byte b3 = bytes[offset];
                    offset = offset2 + 1;
                    resultPos++;
                    DecodeUtil.handleThreeBytes(byte1, b3, bytes[offset2], resultArr, resultPos);
                } else if (offset >= limit - 2) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                } else {
                    int offset3 = offset + 1;
                    byte b4 = bytes[offset];
                    int offset4 = offset3 + 1;
                    byte b5 = bytes[offset3];
                    offset = offset4 + 1;
                    DecodeUtil.handleFourBytes(byte1, b4, b5, bytes[offset4], resultArr, resultPos);
                    resultPos = resultPos + 1 + 1;
                }
            }
            return new String(resultArr, 0, resultPos);
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            return decodeUtf8Default(buffer, index, size);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int encodeUtf8(CharSequence in, byte[] out, int offset, int length) {
            char c;
            int utf16Length = in.length();
            int i = 0;
            int limit = offset + length;
            while (i < utf16Length && i + offset < limit && (c = in.charAt(i)) < 128) {
                out[offset + i] = (byte) c;
                i++;
            }
            if (i == utf16Length) {
                return offset + utf16Length;
            }
            int j = offset + i;
            while (i < utf16Length) {
                char c2 = in.charAt(i);
                if (c2 < 128 && j < limit) {
                    j++;
                    out[j] = (byte) c2;
                } else if (c2 < 2048 && j <= limit - 2) {
                    int j2 = j + 1;
                    out[j] = (byte) (960 | (c2 >>> 6));
                    j = j2 + 1;
                    out[j2] = (byte) (128 | ('?' & c2));
                } else if ((c2 < 55296 || 57343 < c2) && j <= limit - 3) {
                    int j3 = j + 1;
                    out[j] = (byte) (480 | (c2 >>> '\f'));
                    int j4 = j3 + 1;
                    out[j3] = (byte) (128 | (63 & (c2 >>> 6)));
                    j = j4 + 1;
                    out[j4] = (byte) (128 | ('?' & c2));
                } else if (j <= limit - 4) {
                    if (i + 1 != in.length()) {
                        i++;
                        char low = in.charAt(i);
                        if (Character.isSurrogatePair(c2, low)) {
                            int codePoint = Character.toCodePoint(c2, low);
                            int j5 = j + 1;
                            out[j] = (byte) (240 | (codePoint >>> 18));
                            int j6 = j5 + 1;
                            out[j5] = (byte) (128 | (63 & (codePoint >>> 12)));
                            int j7 = j6 + 1;
                            out[j6] = (byte) (128 | (63 & (codePoint >>> 6)));
                            j = j7 + 1;
                            out[j7] = (byte) (128 | (63 & codePoint));
                        }
                    }
                    throw new UnpairedSurrogateException(i - 1, utf16Length);
                } else if (55296 > c2 || c2 > 57343 || (i + 1 != in.length() && Character.isSurrogatePair(c2, in.charAt(i + 1)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + c2 + " at index " + j);
                } else {
                    throw new UnpairedSurrogateException(i, utf16Length);
                }
                i++;
            }
            return j;
        }

        @Override // com.google.protobuf.Utf8.Processor
        void encodeUtf8Direct(CharSequence in, ByteBuffer out) {
            encodeUtf8Default(in, out);
        }

        private static int partialIsValidUtf8(byte[] bytes, int index, int limit) {
            while (index < limit && bytes[index] >= 0) {
                index++;
            }
            if (index >= limit) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bytes, index, limit);
        }

        private static int partialIsValidUtf8NonAscii(byte[] bytes, int index, int limit) {
            while (index < limit) {
                index++;
                byte b = bytes[index];
                if (b < 0) {
                    if (b < -32) {
                        if (index >= limit) {
                            return b;
                        }
                        if (b < -62) {
                            return -1;
                        }
                        index++;
                        if (bytes[index] > -65) {
                            return -1;
                        }
                    } else if (b < -16) {
                        if (index >= limit - 1) {
                            return Utf8.incompleteStateFor(bytes, index, limit);
                        }
                        int index2 = index + 1;
                        byte b2 = bytes[index];
                        if (b2 > -65) {
                            return -1;
                        }
                        if (b == -32 && b2 < -96) {
                            return -1;
                        }
                        if (b == -19 && b2 >= -96) {
                            return -1;
                        }
                        index = index2 + 1;
                        if (bytes[index2] > -65) {
                            return -1;
                        }
                    } else if (index >= limit - 2) {
                        return Utf8.incompleteStateFor(bytes, index, limit);
                    } else {
                        int index3 = index + 1;
                        byte b3 = bytes[index];
                        if (b3 > -65 || (((b << 28) + (b3 - -112)) >> 30) != 0) {
                            return -1;
                        }
                        int index4 = index3 + 1;
                        if (bytes[index3] > -65) {
                            return -1;
                        }
                        index = index4 + 1;
                        if (bytes[index4] > -65) {
                            return -1;
                        }
                    }
                }
            }
            return 0;
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Utf8$UnsafeProcessor.class */
    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: byte[] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [long] */
        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
            long offset;
            if ((index | limit | (bytes.length - limit)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bytes.length), Integer.valueOf(index), Integer.valueOf(limit)));
            }
            char c = (long) index;
            long offsetLimit = (long) limit;
            long offset2 = c;
            if (state != 0) {
                if (c >= offsetLimit) {
                    return state;
                }
                int byte1 = (byte) state;
                if (byte1 < -32) {
                    if (byte1 < -62) {
                        return -1;
                    }
                    offset2 = c + 1;
                    if (UnsafeUtil.getByte(bytes, (long) bytes) > -65) {
                        return -1;
                    }
                } else if (byte1 < -16) {
                    int byte2 = (byte) ((state >> 8) ^ -1);
                    long offset3 = c;
                    if (byte2 == 0) {
                        long offset4 = c + 1;
                        byte2 = UnsafeUtil.getByte(bytes, (long) bytes);
                        int i = (offset4 > offsetLimit ? 1 : (offset4 == offsetLimit ? 0 : -1));
                        offset3 = offset4;
                        if (i >= 0) {
                            return Utf8.incompleteStateFor(byte1, byte2);
                        }
                    }
                    if (byte2 > -65) {
                        return -1;
                    }
                    if (byte1 == -32 && byte2 < -96) {
                        return -1;
                    }
                    if (byte1 == -19 && byte2 >= -96) {
                        return -1;
                    }
                    byte b = UnsafeUtil.getByte(bytes, (long) bytes);
                    offset2 = (offset3 == 1 ? 1 : 0) + 1;
                    if (b > -65) {
                        return -1;
                    }
                } else {
                    int byte22 = (byte) ((state >> 8) ^ -1);
                    int byte3 = 0;
                    if (byte22 == 0) {
                        long offset5 = c + 1;
                        byte22 = UnsafeUtil.getByte(bytes, (long) bytes);
                        int i2 = (offset5 > offsetLimit ? 1 : (offset5 == offsetLimit ? 0 : -1));
                        offset = offset5;
                        if (i2 >= 0) {
                            return Utf8.incompleteStateFor(byte1, byte22);
                        }
                    } else {
                        byte3 = (byte) (state >> 16);
                        offset = c;
                    }
                    long offset6 = offset;
                    if (byte3 == 0) {
                        long offset7 = offset + 1;
                        byte3 = UnsafeUtil.getByte(bytes, (long) bytes);
                        int i3 = (offset7 > offsetLimit ? 1 : (offset7 == offsetLimit ? 0 : -1));
                        offset6 = offset7;
                        if (i3 >= 0) {
                            return Utf8.incompleteStateFor(byte1, byte22, byte3);
                        }
                    }
                    if (byte22 > -65 || (((byte1 << 28) + (byte22 - -112)) >> 30) != 0 || byte3 > -65) {
                        return -1;
                    }
                    byte b2 = UnsafeUtil.getByte(bytes, (long) bytes);
                    offset2 = (offset6 == 1 ? 1 : 0) + 1;
                    if (b2 > -65) {
                        return -1;
                    }
                }
            }
            return partialIsValidUtf8(bytes, offset2 == 1 ? 1 : 0, (int) (offsetLimit - offset2));
        }

        /* JADX WARN: Type inference failed for: r1v29, types: [long] */
        /* JADX WARN: Type inference failed for: r1v35, types: [long] */
        /* JADX WARN: Type inference failed for: r1v51, types: [long] */
        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int state, ByteBuffer buffer, int index, int limit) {
            long address;
            if ((index | limit | (buffer.limit() - limit)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(limit)));
            }
            long address2 = UnsafeUtil.addressOffset(buffer) + ((long) index);
            long addressLimit = address2 + ((long) (limit - index));
            long address3 = address2;
            if (state != 0) {
                if (address2 >= addressLimit) {
                    return state;
                }
                int byte1 = (byte) state;
                if (byte1 < -32) {
                    if (byte1 < -62) {
                        return -1;
                    }
                    byte b = UnsafeUtil.getByte(address2);
                    address3 = address2 + 1;
                    if (b > -65) {
                        return -1;
                    }
                } else if (byte1 < -16) {
                    int byte2 = (byte) ((state >> 8) ^ -1);
                    long address4 = address2;
                    if (byte2 == 0) {
                        char c = address2 + 1;
                        byte2 = UnsafeUtil.getByte(address2);
                        int i = (c > addressLimit ? 1 : (c == addressLimit ? 0 : -1));
                        address4 = c;
                        if (i >= 0) {
                            return Utf8.incompleteStateFor(byte1, byte2);
                        }
                    }
                    if (byte2 > -65) {
                        return -1;
                    }
                    if (byte1 == -32 && byte2 < -96) {
                        return -1;
                    }
                    if (byte1 == -19 && byte2 >= -96) {
                        return -1;
                    }
                    byte b2 = UnsafeUtil.getByte(address4 == 1 ? 1 : 0);
                    address3 = address4 + 1;
                    if (b2 > -65) {
                        return -1;
                    }
                } else {
                    int byte22 = (byte) ((state >> 8) ^ -1);
                    int byte3 = 0;
                    if (byte22 == 0) {
                        char c2 = address2 + 1;
                        byte22 = UnsafeUtil.getByte(address2);
                        int i2 = (c2 > addressLimit ? 1 : (c2 == addressLimit ? 0 : -1));
                        address = c2;
                        if (i2 >= 0) {
                            return Utf8.incompleteStateFor(byte1, byte22);
                        }
                    } else {
                        byte3 = (byte) (state >> 16);
                        address = address2;
                    }
                    long address5 = address;
                    if (byte3 == 0) {
                        char c3 = address + 1;
                        byte3 = UnsafeUtil.getByte(address == 1 ? 1 : 0);
                        int i3 = ((c3 == 1 ? 1 : 0) > addressLimit ? 1 : ((c3 == 1 ? 1 : 0) == addressLimit ? 0 : -1));
                        address5 = c3;
                        if (i3 >= 0) {
                            return Utf8.incompleteStateFor(byte1, byte22, byte3);
                        }
                    }
                    if (byte22 > -65 || (((byte1 << 28) + (byte22 - -112)) >> 30) != 0 || byte3 > -65) {
                        return -1;
                    }
                    byte b3 = UnsafeUtil.getByte(address5 == 1 ? 1 : 0);
                    address3 = address5 + 1;
                    if (b3 > -65) {
                        return -1;
                    }
                }
            }
            return partialIsValidUtf8(address3 == 1 ? 1 : 0, (int) (addressLimit - address3));
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
            if ((index | size | ((bytes.length - index) - size)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bytes.length), Integer.valueOf(index), Integer.valueOf(size)));
            }
            int offset = index;
            int limit = offset + size;
            char[] resultArr = new char[size];
            int resultPos = 0;
            while (offset < limit) {
                byte b = UnsafeUtil.getByte(bytes, (long) offset);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                offset++;
                resultPos++;
                DecodeUtil.handleOneByte(b, resultArr, resultPos);
            }
            while (offset < limit) {
                offset++;
                byte byte1 = UnsafeUtil.getByte(bytes, (long) offset);
                if (DecodeUtil.isOneByte(byte1)) {
                    resultPos++;
                    DecodeUtil.handleOneByte(byte1, resultArr, resultPos);
                    while (offset < limit) {
                        byte b2 = UnsafeUtil.getByte(bytes, (long) offset);
                        if (!DecodeUtil.isOneByte(b2)) {
                            break;
                        }
                        offset++;
                        resultPos++;
                        DecodeUtil.handleOneByte(b2, resultArr, resultPos);
                    }
                } else if (DecodeUtil.isTwoBytes(byte1)) {
                    if (offset >= limit) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    offset++;
                    resultPos++;
                    DecodeUtil.handleTwoBytes(byte1, UnsafeUtil.getByte(bytes, (long) offset), resultArr, resultPos);
                } else if (DecodeUtil.isThreeBytes(byte1)) {
                    if (offset >= limit - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int offset2 = offset + 1;
                    offset = offset2 + 1;
                    resultPos++;
                    DecodeUtil.handleThreeBytes(byte1, UnsafeUtil.getByte(bytes, (long) offset), UnsafeUtil.getByte(bytes, (long) offset2), resultArr, resultPos);
                } else if (offset >= limit - 2) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                } else {
                    int offset3 = offset + 1;
                    int offset4 = offset3 + 1;
                    offset = offset4 + 1;
                    DecodeUtil.handleFourBytes(byte1, UnsafeUtil.getByte(bytes, (long) offset), UnsafeUtil.getByte(bytes, (long) offset3), UnsafeUtil.getByte(bytes, (long) offset4), resultArr, resultPos);
                    resultPos = resultPos + 1 + 1;
                }
            }
            return new String(resultArr, 0, resultPos);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x007f */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x007f */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v1, types: [long] */
        /* JADX WARN: Type inference failed for: r14v2, types: [long] */
        /* JADX WARN: Type inference failed for: r1v14, types: [long] */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARN: Type inference failed for: r3v2, types: [long] */
        /* JADX WARN: Type inference failed for: r14v5, types: [long] */
        /* JADX WARN: Type inference failed for: r0v28, types: [long] */
        /* JADX WARN: Type inference failed for: r14v6 */
        /* JADX WARN: Type inference failed for: r14v7, types: [long] */
        /* JADX WARN: Type inference failed for: r3v4, types: [int] */
        /* JADX WARN: Type inference failed for: r3v9, types: [char[]] */
        /* JADX WARN: Type inference failed for: r3v15, types: [byte] */
        /* JADX WARN: Type inference failed for: r0v51, types: [long] */
        /* JADX WARN: Type inference failed for: r14v13 */
        /* JADX WARN: Type inference failed for: r14v18 */
        /* JADX WARN: Type inference failed for: r14v19 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.protobuf.Utf8.Processor
        /* Code decompiled incorrectly, please refer to instructions dump. */
        java.lang.String decodeUtf8Direct(java.nio.ByteBuffer r11, int r12, int r13) throws com.google.protobuf.InvalidProtocolBufferException {
            /*
            // Method dump skipped, instructions count: 393
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.decodeUtf8Direct(java.nio.ByteBuffer, int, int):java.lang.String");
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x025a */
        /* JADX WARN: Type inference failed for: r0v1, types: [long] */
        /* JADX WARN: Type inference failed for: r2v21, types: [long, byte[]] */
        /* JADX WARN: Type inference failed for: r2v26, types: [long, byte[]] */
        /* JADX WARN: Type inference failed for: r2v31, types: [long, byte[]] */
        /* JADX WARN: Type inference failed for: r2v42, types: [long, byte[]] */
        /* JADX WARN: Type inference failed for: r2v47, types: [long, byte[]] */
        /* JADX WARN: Type inference failed for: r2v58, types: [long, byte[]] */
        /* JADX WARNING: Unknown variable types count: 6 */
        @Override // com.google.protobuf.Utf8.Processor
        /* Code decompiled incorrectly, please refer to instructions dump. */
        int encodeUtf8(java.lang.CharSequence r9, byte[] r10, int r11, int r12) {
            /*
            // Method dump skipped, instructions count: 612
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.encodeUtf8(java.lang.CharSequence, byte[], int, int):int");
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [long] */
        /* JADX WARN: Type inference failed for: r1v53, types: [long] */
        /* JADX WARN: Type inference failed for: r1v73, types: [long] */
        /* JADX WARN: Type inference failed for: r1v88, types: [long] */
        /* JADX WARN: Type inference failed for: r1v95, types: [long] */
        /* JADX WARN: Type inference failed for: r1v105, types: [long] */
        @Override // com.google.protobuf.Utf8.Processor
        void encodeUtf8Direct(CharSequence in, ByteBuffer out) {
            char c;
            long address = UnsafeUtil.addressOffset(out);
            char position = address + ((long) out.position());
            long outLimit = address + ((long) out.limit());
            int inLimit = in.length();
            if (((long) inLimit) > outLimit - position) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(inLimit - 1) + " at index " + out.limit());
            }
            int inIx = 0;
            while (inIx < inLimit && (c = in.charAt(inIx)) < 128) {
                position++;
                UnsafeUtil.putByte(position, (byte) c);
                inIx++;
            }
            if (inIx == inLimit) {
                out.position((int) (position - address));
                return;
            }
            while (inIx < inLimit) {
                char c2 = in.charAt(inIx);
                if (c2 < 128 && position < outLimit) {
                    position++;
                    UnsafeUtil.putByte(position, (byte) c2);
                } else if (c2 < 2048 && position <= outLimit - 2) {
                    long outIx = position + 1;
                    UnsafeUtil.putByte(position, (byte) (960 | (c2 >>> 6)));
                    position = outIx + 1;
                    UnsafeUtil.putByte(outIx, (byte) (128 | ('?' & c2)));
                } else if ((c2 < 55296 || 57343 < c2) && position <= outLimit - 3) {
                    long outIx2 = position + 1;
                    UnsafeUtil.putByte(position, (byte) (480 | (c2 >>> '\f')));
                    long outIx3 = outIx2 + 1;
                    UnsafeUtil.putByte(outIx2, (byte) (128 | (63 & (c2 >>> 6))));
                    position = outIx3 + 1;
                    UnsafeUtil.putByte(outIx3, (byte) (128 | ('?' & c2)));
                } else if (position <= outLimit - 4) {
                    if (inIx + 1 != inLimit) {
                        inIx++;
                        char low = in.charAt(inIx);
                        if (Character.isSurrogatePair(c2, low)) {
                            int codePoint = Character.toCodePoint(c2, low);
                            long outIx4 = position + 1;
                            UnsafeUtil.putByte(position, (byte) (240 | (codePoint >>> 18)));
                            long outIx5 = outIx4 + 1;
                            UnsafeUtil.putByte(outIx4, (byte) (128 | (63 & (codePoint >>> 12))));
                            long outIx6 = outIx5 + 1;
                            UnsafeUtil.putByte(outIx5, (byte) (128 | (63 & (codePoint >>> 6))));
                            position = outIx6 + 1;
                            UnsafeUtil.putByte(outIx6, (byte) (128 | (63 & codePoint)));
                        }
                    }
                    throw new UnpairedSurrogateException(inIx - 1, inLimit);
                } else if (55296 > c2 || c2 > 57343 || (inIx + 1 != inLimit && Character.isSurrogatePair(c2, in.charAt(inIx + 1)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + c2 + " at index " + ((long) position));
                } else {
                    throw new UnpairedSurrogateException(inIx, inLimit);
                }
                inIx++;
            }
            out.position((int) (position - address));
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bytes, long offset, int maxChars) {
            if (maxChars < 16) {
                return 0;
            }
            for (int i = 0; i < maxChars; i++) {
                offset++;
                if (UnsafeUtil.getByte(bytes, offset) < 0) {
                    return i;
                }
            }
            return maxChars;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v1, types: [long] */
        /* JADX WARN: Type inference failed for: r0v16, types: [long] */
        /* JADX WARN: Type inference failed for: r1v12, types: [long] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int unsafeEstimateConsecutiveAscii(long r7, int r9) {
            /*
                r0 = r9
                r10 = r0
                r0 = r10
                r1 = 16
                if (r0 >= r1) goto L_0x000a
                r0 = 0
                return r0
            L_0x000a:
                r0 = 8
                r1 = r7
                int r1 = (int) r1
                r2 = 7
                r1 = r1 & r2
                int r0 = r0 - r1
                r11 = r0
                r0 = r11
                r12 = r0
            L_0x0018:
                r0 = r12
                if (r0 <= 0) goto L_0x0034
                r0 = r7
                r1 = r0; r1 = r0; 
                r2 = 1
                long r1 = r1 + r2
                r7 = r1
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r0)
                if (r0 >= 0) goto L_0x002e
                r0 = r11
                r1 = r12
                int r0 = r0 - r1
                return r0
            L_0x002e:
                int r12 = r12 + -1
                goto L_0x0018
            L_0x0034:
                r0 = r10
                r1 = r11
                int r0 = r0 - r1
                r10 = r0
            L_0x0039:
                r0 = r10
                r1 = 8
                if (r0 < r1) goto L_0x0058
                r0 = r7
                long r0 = com.google.protobuf.UnsafeUtil.getLong(r0)
                r1 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r0 = r0 & r1
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0058
                r0 = r7
                r1 = 8
                long r0 = r0 + r1
                r7 = r0
                int r10 = r10 + -8
                goto L_0x0039
            L_0x0058:
                r0 = r9
                r1 = r10
                int r0 = r0 - r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.unsafeEstimateConsecutiveAscii(long, int):int");
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x0013 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x002f */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x0013 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v0, types: [long, byte[]] */
        /* JADX WARN: Type inference failed for: r0v5, types: [long] */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v3, types: [long] */
        /* JADX WARN: Type inference failed for: r9v4, types: [long, byte[]] */
        /* JADX WARN: Type inference failed for: r9v5 */
        /* JADX WARN: Type inference failed for: r9v6, types: [long] */
        /* JADX WARN: Type inference failed for: r9v8, types: [long] */
        /* JADX WARN: Type inference failed for: r9v11, types: [long] */
        /* JADX WARN: Type inference failed for: r9v12, types: [long] */
        /* JADX WARN: Type inference failed for: r9v13 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int partialIsValidUtf8(byte[] r8, long r9, int r11) {
            /*
            // Method dump skipped, instructions count: 268
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(byte[], long, int):int");
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x000f */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x002a */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x000f */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [long] */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6, types: [long] */
        /* JADX WARN: Type inference failed for: r7v8, types: [long] */
        /* JADX WARN: Type inference failed for: r7v11, types: [long] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int partialIsValidUtf8(long r7, int r9) {
            /*
            // Method dump skipped, instructions count: 257
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(long, int):int");
        }

        private static int unsafeIncompleteStateFor(byte[] bytes, int byte1, long offset, int remaining) {
            switch (remaining) {
                case 0:
                    return Utf8.incompleteStateFor(byte1);
                case 1:
                    return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(bytes, offset));
                case 2:
                    return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(bytes, offset), UnsafeUtil.getByte(bytes, offset + 1));
                default:
                    throw new AssertionError();
            }
        }

        private static int unsafeIncompleteStateFor(long address, int byte1, int remaining) {
            switch (remaining) {
                case 0:
                    return Utf8.incompleteStateFor(byte1);
                case 1:
                    return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(address));
                case 2:
                    return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(address), UnsafeUtil.getByte(address + 1));
                default:
                    throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/Utf8$DecodeUtil.class */
    public static class DecodeUtil {
        private DecodeUtil() {
        }

        /* access modifiers changed from: private */
        public static boolean isOneByte(byte b) {
            return b >= 0;
        }

        /* access modifiers changed from: private */
        public static boolean isTwoBytes(byte b) {
            return b < -32;
        }

        /* access modifiers changed from: private */
        public static boolean isThreeBytes(byte b) {
            return b < -16;
        }

        /* access modifiers changed from: private */
        public static void handleOneByte(byte byte1, char[] resultArr, int resultPos) {
            resultArr[resultPos] = (char) byte1;
        }

        /* access modifiers changed from: private */
        public static void handleTwoBytes(byte byte1, byte byte2, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (byte1 < -62 || isNotTrailingByte(byte2)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            resultArr[resultPos] = (char) (((byte1 & 31) << 6) | trailingByteValue(byte2));
        }

        /* access modifiers changed from: private */
        public static void handleThreeBytes(byte byte1, byte byte2, byte byte3, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(byte2) || ((byte1 == -32 && byte2 < -96) || ((byte1 == -19 && byte2 >= -96) || isNotTrailingByte(byte3)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            resultArr[resultPos] = (char) (((byte1 & 15) << 12) | (trailingByteValue(byte2) << 6) | trailingByteValue(byte3));
        }

        /* access modifiers changed from: private */
        public static void handleFourBytes(byte byte1, byte byte2, byte byte3, byte byte4, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(byte2) || (((byte1 << 28) + (byte2 - -112)) >> 30) != 0 || isNotTrailingByte(byte3) || isNotTrailingByte(byte4)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int codepoint = ((byte1 & 7) << 18) | (trailingByteValue(byte2) << 12) | (trailingByteValue(byte3) << 6) | trailingByteValue(byte4);
            resultArr[resultPos] = highSurrogate(codepoint);
            resultArr[resultPos + 1] = lowSurrogate(codepoint);
        }

        private static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        private static int trailingByteValue(byte b) {
            return b & 63;
        }

        private static char highSurrogate(int codePoint) {
            return (char) (okio.Utf8.HIGH_SURROGATE_HEADER + (codePoint >>> 10));
        }

        private static char lowSurrogate(int codePoint) {
            return (char) (56320 + (codePoint & 1023));
        }
    }

    private Utf8() {
    }
}
