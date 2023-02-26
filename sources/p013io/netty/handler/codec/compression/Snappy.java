package p013io.netty.handler.codec.compression;

import emu.grasscutter.net.packet.PacketOpcodes;
import p013io.netty.buffer.ByteBuf;

/* renamed from: io.netty.handler.codec.compression.Snappy */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Snappy.class */
public final class Snappy {
    private static final int MAX_HT_SIZE = 16384;
    private static final int MIN_COMPRESSIBLE_BYTES = 15;
    private static final int PREAMBLE_NOT_FULL = -1;
    private static final int NOT_ENOUGH_INPUT = -1;
    private static final int LITERAL = 0;
    private static final int COPY_1_BYTE_OFFSET = 1;
    private static final int COPY_2_BYTE_OFFSET = 2;
    private static final int COPY_4_BYTE_OFFSET = 3;
    private State state = State.READING_PREAMBLE;
    private byte tag;
    private int written;

    /* renamed from: io.netty.handler.codec.compression.Snappy$State */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Snappy$State.class */
    private enum State {
        READING_PREAMBLE,
        READING_TAG,
        READING_LITERAL,
        READING_COPY
    }

    public void reset() {
        this.state = State.READING_PREAMBLE;
        this.tag = 0;
        this.written = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00c2, code lost:
        encodeLiteral(r7, r8, r10 - r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00cc, code lost:
        r0 = 4 + findMatchingLength(r7, r17 + 4, r10 + 4, r9);
        r10 = r10 + r0;
        encodeCopy(r8, r10 - r17, r0);
        r7.readerIndex(r7.readerIndex() + r0);
        r0 = r10 - 1;
        r14 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0112, code lost:
        if (r10 < (r9 - 4)) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0118, code lost:
        r0[hash(r7, r0, r0)] = (short) ((r10 - r0) - 1);
        r0 = hash(r7, r0 + 1, r0);
        r17 = r0 + r0[r0];
        r0[r0] = (short) (r10 - r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x015e, code lost:
        if (r7.getInt(r0 + 1) == r7.getInt(r17)) goto L_0x00cc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(p013io.netty.buffer.ByteBuf r7, p013io.netty.buffer.ByteBuf r8, int r9) {
        /*
        // Method dump skipped, instructions count: 387
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.Snappy.encode(io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf, int):void");
    }

    private static int hash(ByteBuf in, int index, int shift) {
        return (in.getInt(index) * 506832829) >>> shift;
    }

    private static short[] getHashTable(int inputSize) {
        int htSize = 256;
        while (htSize < 16384 && htSize < inputSize) {
            htSize <<= 1;
        }
        return new short[htSize];
    }

    private static int findMatchingLength(ByteBuf in, int minIndex, int inIndex, int maxIndex) {
        int matched = 0;
        while (inIndex <= maxIndex - 4 && in.getInt(inIndex) == in.getInt(minIndex + matched)) {
            inIndex += 4;
            matched += 4;
        }
        while (inIndex < maxIndex && in.getByte(minIndex + matched) == in.getByte(inIndex)) {
            inIndex++;
            matched++;
        }
        return matched;
    }

    private static int bitsToEncode(int value) {
        int highestOneBit = Integer.highestOneBit(value);
        int bitLength = 0;
        while (true) {
            int i = highestOneBit >> 1;
            highestOneBit = i;
            if (i == 0) {
                return bitLength;
            }
            bitLength++;
        }
    }

    static void encodeLiteral(ByteBuf in, ByteBuf out, int length) {
        if (length < 61) {
            out.writeByte((length - 1) << 2);
        } else {
            int bytesToEncode = 1 + (bitsToEncode(length - 1) / 8);
            out.writeByte((59 + bytesToEncode) << 2);
            for (int i = 0; i < bytesToEncode; i++) {
                out.writeByte(((length - 1) >> (i * 8)) & 255);
            }
        }
        out.writeBytes(in, length);
    }

    private static void encodeCopyWithOffset(ByteBuf out, int offset, int length) {
        if (length >= 12 || offset >= 2048) {
            out.writeByte(2 | ((length - 1) << 2));
            out.writeByte(offset & 255);
            out.writeByte((offset >> 8) & 255);
            return;
        }
        out.writeByte(1 | ((length - 4) << 2) | ((offset >> 8) << 5));
        out.writeByte(offset & 255);
    }

    private static void encodeCopy(ByteBuf out, int offset, int length) {
        while (length >= 68) {
            encodeCopyWithOffset(out, offset, 64);
            length -= 64;
        }
        if (length > 64) {
            encodeCopyWithOffset(out, offset, 60);
            length -= 60;
        }
        encodeCopyWithOffset(out, offset, length);
    }

    public void decode(ByteBuf in, ByteBuf out) {
        while (in.isReadable()) {
            switch (this.state) {
                case READING_PREAMBLE:
                    int uncompressedLength = readPreamble(in);
                    if (uncompressedLength != -1 && uncompressedLength != 0) {
                        out.ensureWritable(uncompressedLength);
                        this.state = State.READING_TAG;
                        break;
                    } else {
                        return;
                    }
                case READING_LITERAL:
                    int literalWritten = decodeLiteral(this.tag, in, out);
                    if (literalWritten != -1) {
                        this.state = State.READING_TAG;
                        this.written += literalWritten;
                        continue;
                    } else {
                        return;
                    }
                case READING_COPY:
                    switch (this.tag & 3) {
                        case 1:
                            int decodeWritten = decodeCopyWith1ByteOffset(this.tag, in, out, this.written);
                            if (decodeWritten != -1) {
                                this.state = State.READING_TAG;
                                this.written += decodeWritten;
                                continue;
                            } else {
                                return;
                            }
                        case 2:
                            int decodeWritten2 = decodeCopyWith2ByteOffset(this.tag, in, out, this.written);
                            if (decodeWritten2 != -1) {
                                this.state = State.READING_TAG;
                                this.written += decodeWritten2;
                                continue;
                            } else {
                                return;
                            }
                        case 3:
                            int decodeWritten3 = decodeCopyWith4ByteOffset(this.tag, in, out, this.written);
                            if (decodeWritten3 != -1) {
                                this.state = State.READING_TAG;
                                this.written += decodeWritten3;
                                continue;
                            } else {
                                return;
                            }
                        default:
                            continue;
                    }
            }
            if (in.isReadable()) {
                this.tag = in.readByte();
                switch (this.tag & 3) {
                    case 0:
                        this.state = State.READING_LITERAL;
                        continue;
                    case 1:
                    case 2:
                    case 3:
                        this.state = State.READING_COPY;
                        continue;
                }
            } else {
                return;
            }
        }
    }

    private static int readPreamble(ByteBuf in) {
        int length = 0;
        int byteIndex = 0;
        while (in.isReadable()) {
            int current = in.readUnsignedByte();
            byteIndex++;
            length |= (current & 127) << (byteIndex * 7);
            if ((current & 128) == 0) {
                return length;
            }
            if (byteIndex >= 4) {
                throw new DecompressionException("Preamble is greater than 4 bytes");
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getPreamble(ByteBuf in) {
        if (this.state != State.READING_PREAMBLE) {
            return 0;
        }
        int readerIndex = in.readerIndex();
        try {
            int readPreamble = readPreamble(in);
            in.readerIndex(readerIndex);
            return readPreamble;
        } catch (Throwable th) {
            in.readerIndex(readerIndex);
            throw th;
        }
    }

    static int decodeLiteral(byte tag, ByteBuf in, ByteBuf out) {
        int length;
        in.markReaderIndex();
        switch ((tag >> 2) & 63) {
            case 60:
                if (in.isReadable()) {
                    length = in.readUnsignedByte();
                    break;
                } else {
                    return -1;
                }
            case 61:
                if (in.readableBytes() >= 2) {
                    length = in.readUnsignedShortLE();
                    break;
                } else {
                    return -1;
                }
            case 62:
                if (in.readableBytes() >= 3) {
                    length = in.readUnsignedMediumLE();
                    break;
                } else {
                    return -1;
                }
            case 63:
                if (in.readableBytes() >= 4) {
                    length = in.readIntLE();
                    break;
                } else {
                    return -1;
                }
            default:
                length = (tag >> 2) & 63;
                break;
        }
        int length2 = length + 1;
        if (in.readableBytes() < length2) {
            in.resetReaderIndex();
            return -1;
        }
        out.writeBytes(in, length2);
        return length2;
    }

    private static int decodeCopyWith1ByteOffset(byte tag, ByteBuf in, ByteBuf out, int writtenSoFar) {
        if (!in.isReadable()) {
            return -1;
        }
        int initialIndex = out.writerIndex();
        int length = 4 + ((tag & 28) >> 2);
        int offset = (((tag & PacketOpcodes.SceneAvatarStaminaStepRsp) << 8) >> 5) | in.readUnsignedByte();
        validateOffset(offset, writtenSoFar);
        out.markReaderIndex();
        if (offset < length) {
            for (int copies = length / offset; copies > 0; copies--) {
                out.readerIndex(initialIndex - offset);
                out.readBytes(out, offset);
            }
            if (length % offset != 0) {
                out.readerIndex(initialIndex - offset);
                out.readBytes(out, length % offset);
            }
        } else {
            out.readerIndex(initialIndex - offset);
            out.readBytes(out, length);
        }
        out.resetReaderIndex();
        return length;
    }

    private static int decodeCopyWith2ByteOffset(byte tag, ByteBuf in, ByteBuf out, int writtenSoFar) {
        if (in.readableBytes() < 2) {
            return -1;
        }
        int initialIndex = out.writerIndex();
        int length = 1 + ((tag >> 2) & 63);
        int offset = in.readUnsignedShortLE();
        validateOffset(offset, writtenSoFar);
        out.markReaderIndex();
        if (offset < length) {
            for (int copies = length / offset; copies > 0; copies--) {
                out.readerIndex(initialIndex - offset);
                out.readBytes(out, offset);
            }
            if (length % offset != 0) {
                out.readerIndex(initialIndex - offset);
                out.readBytes(out, length % offset);
            }
        } else {
            out.readerIndex(initialIndex - offset);
            out.readBytes(out, length);
        }
        out.resetReaderIndex();
        return length;
    }

    private static int decodeCopyWith4ByteOffset(byte tag, ByteBuf in, ByteBuf out, int writtenSoFar) {
        if (in.readableBytes() < 4) {
            return -1;
        }
        int initialIndex = out.writerIndex();
        int length = 1 + ((tag >> 2) & 63);
        int offset = in.readIntLE();
        validateOffset(offset, writtenSoFar);
        out.markReaderIndex();
        if (offset < length) {
            for (int copies = length / offset; copies > 0; copies--) {
                out.readerIndex(initialIndex - offset);
                out.readBytes(out, offset);
            }
            if (length % offset != 0) {
                out.readerIndex(initialIndex - offset);
                out.readBytes(out, length % offset);
            }
        } else {
            out.readerIndex(initialIndex - offset);
            out.readBytes(out, length);
        }
        out.resetReaderIndex();
        return length;
    }

    private static void validateOffset(int offset, int chunkSizeSoFar) {
        if (offset == 0) {
            throw new DecompressionException("Offset is less than minimum permissible value");
        } else if (offset < 0) {
            throw new DecompressionException("Offset is greater than maximum value supported by this implementation");
        } else if (offset > chunkSizeSoFar) {
            throw new DecompressionException("Offset exceeds size of chunk");
        }
    }

    /* access modifiers changed from: package-private */
    public static int calculateChecksum(ByteBuf data) {
        return calculateChecksum(data, data.readerIndex(), data.readableBytes());
    }

    static int calculateChecksum(ByteBuf data, int offset, int length) {
        Crc32c crc32 = new Crc32c();
        try {
            crc32.update(data, offset, length);
            int maskChecksum = maskChecksum(crc32.getValue());
            crc32.reset();
            return maskChecksum;
        } catch (Throwable th) {
            crc32.reset();
            throw th;
        }
    }

    static void validateChecksum(int expectedChecksum, ByteBuf data) {
        validateChecksum(expectedChecksum, data, data.readerIndex(), data.readableBytes());
    }

    /* access modifiers changed from: package-private */
    public static void validateChecksum(int expectedChecksum, ByteBuf data, int offset, int length) {
        int actualChecksum = calculateChecksum(data, offset, length);
        if (actualChecksum != expectedChecksum) {
            throw new DecompressionException("mismatching checksum: " + Integer.toHexString(actualChecksum) + " (expected: " + Integer.toHexString(expectedChecksum) + ')');
        }
    }

    static int maskChecksum(long checksum) {
        return (int) (((checksum >> 15) | (checksum << 17)) - 1568478504);
    }
}
