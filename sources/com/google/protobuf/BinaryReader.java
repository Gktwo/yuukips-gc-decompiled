package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:com/google/protobuf/BinaryReader.class */
abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    public abstract int getTotalBytesRead();

    public static BinaryReader newInstance(ByteBuffer buffer, boolean bufferIsImmutable) {
        if (buffer.hasArray()) {
            return new SafeHeapReader(buffer, bufferIsImmutable);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    private BinaryReader() {
    }

    @Override // com.google.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return false;
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/BinaryReader$SafeHeapReader.class */
    private static final class SafeHeapReader extends BinaryReader {
        private final boolean bufferIsImmutable;
        private final byte[] buffer;
        private int pos;
        private final int initialPos;
        private int limit;
        private int tag;
        private int endGroupTag;

        public SafeHeapReader(ByteBuffer bytebuf, boolean bufferIsImmutable) {
            super();
            this.bufferIsImmutable = bufferIsImmutable;
            this.buffer = bytebuf.array();
            int arrayOffset = bytebuf.arrayOffset() + bytebuf.position();
            this.pos = arrayOffset;
            this.initialPos = arrayOffset;
            this.limit = bytebuf.arrayOffset() + bytebuf.limit();
        }

        private boolean isAtEnd() {
            return this.pos == this.limit;
        }

        @Override // com.google.protobuf.BinaryReader
        public int getTotalBytesRead() {
            return this.pos - this.initialPos;
        }

        @Override // com.google.protobuf.Reader
        public int getFieldNumber() throws IOException {
            if (isAtEnd()) {
                return Integer.MAX_VALUE;
            }
            this.tag = readVarint32();
            if (this.tag == this.endGroupTag) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(this.tag);
        }

        @Override // com.google.protobuf.Reader
        public int getTag() {
            return this.tag;
        }

        @Override // com.google.protobuf.Reader
        public boolean skipField() throws IOException {
            if (isAtEnd() || this.tag == this.endGroupTag) {
                return false;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    skipVarint();
                    return true;
                case 1:
                    skipBytes(8);
                    return true;
                case 2:
                    skipBytes(readVarint32());
                    return true;
                case 3:
                    skipGroup();
                    return true;
                case 4:
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
                case 5:
                    skipBytes(4);
                    return true;
            }
        }

        @Override // com.google.protobuf.Reader
        public double readDouble() throws IOException {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        @Override // com.google.protobuf.Reader
        public float readFloat() throws IOException {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        @Override // com.google.protobuf.Reader
        public long readUInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.protobuf.Reader
        public long readInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.protobuf.Reader
        public int readInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public long readFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.protobuf.Reader
        public int readFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.protobuf.Reader
        public boolean readBool() throws IOException {
            requireWireType(0);
            return readVarint32() != 0;
        }

        @Override // com.google.protobuf.Reader
        public String readString() throws IOException {
            return readStringInternal(false);
        }

        @Override // com.google.protobuf.Reader
        public String readStringRequireUtf8() throws IOException {
            return readStringInternal(true);
        }

        public String readStringInternal(boolean requireUtf8) throws IOException {
            requireWireType(2);
            int size = readVarint32();
            if (size == 0) {
                return "";
            }
            requireBytes(size);
            if (!requireUtf8 || Utf8.isValidUtf8(this.buffer, this.pos, this.pos + size)) {
                String result = new String(this.buffer, this.pos, size, Internal.UTF_8);
                this.pos += size;
                return result;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.google.protobuf.Reader
        public <T> T readMessage(Class<T> clazz, ExtensionRegistryLite extensionRegistry) throws IOException {
            requireWireType(2);
            return (T) readMessage(Protobuf.getInstance().schemaFor((Class) clazz), extensionRegistry);
        }

        @Override // com.google.protobuf.Reader
        public <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            requireWireType(2);
            return (T) readMessage(schema, extensionRegistry);
        }

        private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int size = readVarint32();
            requireBytes(size);
            int prevLimit = this.limit;
            int newLimit = this.pos + size;
            this.limit = newLimit;
            try {
                T message = schema.newInstance();
                schema.mergeFrom(message, this, extensionRegistry);
                schema.makeImmutable(message);
                if (this.pos == newLimit) {
                    return message;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } finally {
                this.limit = prevLimit;
            }
        }

        @Override // com.google.protobuf.Reader
        public <T> T readGroup(Class<T> clazz, ExtensionRegistryLite extensionRegistry) throws IOException {
            requireWireType(3);
            return (T) readGroup(Protobuf.getInstance().schemaFor((Class) clazz), extensionRegistry);
        }

        @Override // com.google.protobuf.Reader
        public <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            requireWireType(3);
            return (T) readGroup(schema, extensionRegistry);
        }

        private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int prevEndGroupTag = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            try {
                T message = schema.newInstance();
                schema.mergeFrom(message, this, extensionRegistry);
                schema.makeImmutable(message);
                if (this.tag == this.endGroupTag) {
                    return message;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } finally {
                this.endGroupTag = prevEndGroupTag;
            }
        }

        @Override // com.google.protobuf.Reader
        public ByteString readBytes() throws IOException {
            ByteString bytes;
            requireWireType(2);
            int size = readVarint32();
            if (size == 0) {
                return ByteString.EMPTY;
            }
            requireBytes(size);
            if (this.bufferIsImmutable) {
                bytes = ByteString.wrap(this.buffer, this.pos, size);
            } else {
                bytes = ByteString.copyFrom(this.buffer, this.pos, size);
            }
            this.pos += size;
            return bytes;
        }

        @Override // com.google.protobuf.Reader
        public int readUInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public int readEnum() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public int readSFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.protobuf.Reader
        public long readSFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.protobuf.Reader
        public int readSInt32() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        @Override // com.google.protobuf.Reader
        public long readSInt64() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        @Override // com.google.protobuf.Reader
        public void readDoubleList(List<Double> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof DoubleArrayList) {
                DoubleArrayList plist = (DoubleArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 1:
                        break;
                    case 2:
                        int bytes = readVarint32();
                        verifyPackedFixed64Length(bytes);
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
                        }
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addDouble(readDouble());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 1:
                    break;
                case 2:
                    int bytes2 = readVarint32();
                    verifyPackedFixed64Length(bytes2);
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
                    }
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Double.valueOf(readDouble()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readFloatList(List<Float> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof FloatArrayList) {
                FloatArrayList plist = (FloatArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 2:
                        int bytes = readVarint32();
                        verifyPackedFixed32Length(bytes);
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
                        }
                        return;
                    case 5:
                        break;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addFloat(readFloat());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 2:
                    int bytes2 = readVarint32();
                    verifyPackedFixed32Length(bytes2);
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
                    }
                    return;
                case 5:
                    break;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Float.valueOf(readFloat()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readUInt64List(List<Long> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof LongArrayList) {
                LongArrayList plist = (LongArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 2:
                        int fieldEndPos = this.pos + readVarint32();
                        while (this.pos < fieldEndPos) {
                            plist.addLong(readVarint64());
                        }
                        requirePosition(fieldEndPos);
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addLong(readUInt64());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int fieldEndPos2 = this.pos + readVarint32();
                    while (this.pos < fieldEndPos2) {
                        target.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(fieldEndPos2);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Long.valueOf(readUInt64()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readInt64List(List<Long> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof LongArrayList) {
                LongArrayList plist = (LongArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 2:
                        int fieldEndPos = this.pos + readVarint32();
                        while (this.pos < fieldEndPos) {
                            plist.addLong(readVarint64());
                        }
                        requirePosition(fieldEndPos);
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addLong(readInt64());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int fieldEndPos2 = this.pos + readVarint32();
                    while (this.pos < fieldEndPos2) {
                        target.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(fieldEndPos2);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Long.valueOf(readInt64()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readInt32List(List<Integer> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof IntArrayList) {
                IntArrayList plist = (IntArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 2:
                        int fieldEndPos = this.pos + readVarint32();
                        while (this.pos < fieldEndPos) {
                            plist.addInt(readVarint32());
                        }
                        requirePosition(fieldEndPos);
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addInt(readInt32());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int fieldEndPos2 = this.pos + readVarint32();
                    while (this.pos < fieldEndPos2) {
                        target.add(Integer.valueOf(readVarint32()));
                    }
                    requirePosition(fieldEndPos2);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readInt32()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readFixed64List(List<Long> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof LongArrayList) {
                LongArrayList plist = (LongArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 1:
                        break;
                    case 2:
                        int bytes = readVarint32();
                        verifyPackedFixed64Length(bytes);
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addLong(readLittleEndian64_NoCheck());
                        }
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addLong(readFixed64());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 1:
                    break;
                case 2:
                    int bytes2 = readVarint32();
                    verifyPackedFixed64Length(bytes2);
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Long.valueOf(readFixed64()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readFixed32List(List<Integer> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof IntArrayList) {
                IntArrayList plist = (IntArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 2:
                        int bytes = readVarint32();
                        verifyPackedFixed32Length(bytes);
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addInt(readLittleEndian32_NoCheck());
                        }
                        return;
                    case 5:
                        break;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addInt(readFixed32());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 2:
                    int bytes2 = readVarint32();
                    verifyPackedFixed32Length(bytes2);
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                    return;
                case 5:
                    break;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readFixed32()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readBoolList(List<Boolean> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof BooleanArrayList) {
                BooleanArrayList plist = (BooleanArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 2:
                        int fieldEndPos = this.pos + readVarint32();
                        while (this.pos < fieldEndPos) {
                            plist.addBoolean(readVarint32() != 0);
                        }
                        requirePosition(fieldEndPos);
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addBoolean(readBool());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int fieldEndPos2 = this.pos + readVarint32();
                    while (this.pos < fieldEndPos2) {
                        target.add(Boolean.valueOf(readVarint32() != 0));
                    }
                    requirePosition(fieldEndPos2);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Boolean.valueOf(readBool()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readStringList(List<String> target) throws IOException {
            readStringListInternal(target, false);
        }

        @Override // com.google.protobuf.Reader
        public void readStringListRequireUtf8(List<String> target) throws IOException {
            readStringListInternal(target, true);
        }

        public void readStringListInternal(List<String> target, boolean requireUtf8) throws IOException {
            int prevPos;
            int prevPos2;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            } else if (!(target instanceof LazyStringList) || requireUtf8) {
                do {
                    target.add(readStringInternal(requireUtf8));
                    if (!isAtEnd()) {
                        prevPos = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos;
            } else {
                LazyStringList lazyList = (LazyStringList) target;
                do {
                    lazyList.add(readBytes());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
            }
        }

        @Override // com.google.protobuf.Reader
        public <T> void readMessageList(List<T> target, Class<T> targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
            readMessageList(target, Protobuf.getInstance().schemaFor((Class) targetType), extensionRegistry);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public <T> void readMessageList(List<T> target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int prevPos;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int listTag = this.tag;
            do {
                target.add(readMessage(schema, extensionRegistry));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == listTag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public <T> void readGroupList(List<T> target, Class<T> targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
            readGroupList(target, Protobuf.getInstance().schemaFor((Class) targetType), extensionRegistry);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public <T> void readGroupList(List<T> target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int prevPos;
            if (WireFormat.getTagWireType(this.tag) != 3) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int listTag = this.tag;
            do {
                target.add(readGroup(schema, extensionRegistry));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == listTag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readBytesList(List<ByteString> target) throws IOException {
            int prevPos;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(readBytes());
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readUInt32List(List<Integer> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof IntArrayList) {
                IntArrayList plist = (IntArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 2:
                        int fieldEndPos = this.pos + readVarint32();
                        while (this.pos < fieldEndPos) {
                            plist.addInt(readVarint32());
                        }
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addInt(readUInt32());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int fieldEndPos2 = this.pos + readVarint32();
                    while (this.pos < fieldEndPos2) {
                        target.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readUInt32()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readEnumList(List<Integer> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof IntArrayList) {
                IntArrayList plist = (IntArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 2:
                        int fieldEndPos = this.pos + readVarint32();
                        while (this.pos < fieldEndPos) {
                            plist.addInt(readVarint32());
                        }
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addInt(readEnum());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int fieldEndPos2 = this.pos + readVarint32();
                    while (this.pos < fieldEndPos2) {
                        target.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readEnum()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readSFixed32List(List<Integer> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof IntArrayList) {
                IntArrayList plist = (IntArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 2:
                        int bytes = readVarint32();
                        verifyPackedFixed32Length(bytes);
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addInt(readLittleEndian32_NoCheck());
                        }
                        return;
                    case 5:
                        break;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addInt(readSFixed32());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 2:
                    int bytes2 = readVarint32();
                    verifyPackedFixed32Length(bytes2);
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                    return;
                case 5:
                    break;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readSFixed32()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readSFixed64List(List<Long> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof LongArrayList) {
                LongArrayList plist = (LongArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 1:
                        break;
                    case 2:
                        int bytes = readVarint32();
                        verifyPackedFixed64Length(bytes);
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addLong(readLittleEndian64_NoCheck());
                        }
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addLong(readSFixed64());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 1:
                    break;
                case 2:
                    int bytes2 = readVarint32();
                    verifyPackedFixed64Length(bytes2);
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Long.valueOf(readSFixed64()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readSInt32List(List<Integer> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof IntArrayList) {
                IntArrayList plist = (IntArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 2:
                        int fieldEndPos = this.pos + readVarint32();
                        while (this.pos < fieldEndPos) {
                            plist.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
                        }
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addInt(readSInt32());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int fieldEndPos2 = this.pos + readVarint32();
                    while (this.pos < fieldEndPos2) {
                        target.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
                    }
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readSInt32()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public void readSInt64List(List<Long> target) throws IOException {
            int prevPos;
            int prevPos2;
            if (target instanceof LongArrayList) {
                LongArrayList plist = (LongArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 2:
                        int fieldEndPos = this.pos + readVarint32();
                        while (this.pos < fieldEndPos) {
                            plist.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
                        }
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addLong(readSInt64());
                    if (!isAtEnd()) {
                        prevPos2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int fieldEndPos2 = this.pos + readVarint32();
                    while (this.pos < fieldEndPos2) {
                        target.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
                    }
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Long.valueOf(readSInt64()));
                if (!isAtEnd()) {
                    prevPos = this.pos;
                } else {
                    return;
                }
            } while (readVarint32() == this.tag);
            this.pos = prevPos;
        }

        @Override // com.google.protobuf.Reader
        public <K, V> void readMap(Map<K, V> target, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistry) throws IOException {
            requireWireType(2);
            int size = readVarint32();
            requireBytes(size);
            int prevLimit = this.limit;
            this.limit = this.pos + size;
            try {
                K key = metadata.defaultKey;
                V value = metadata.defaultValue;
                while (true) {
                    int number = getFieldNumber();
                    if (number == Integer.MAX_VALUE) {
                        target.put(key, value);
                        this.limit = prevLimit;
                        return;
                    }
                    try {
                        switch (number) {
                            case 1:
                                key = readField(metadata.keyType, null, null);
                                value = value;
                                break;
                            case 2:
                                value = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistry);
                                key = key;
                                break;
                            default:
                                key = key;
                                value = value;
                                if (!skipField()) {
                                    throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                    break;
                                }
                                break;
                        }
                    } catch (InvalidProtocolBufferException.InvalidWireTypeException e) {
                        if (!skipField()) {
                            throw new InvalidProtocolBufferException("Unable to parse map entry.");
                        }
                    }
                }
            } catch (Throwable th) {
                this.limit = prevLimit;
                throw th;
            }
        }

        private Object readField(WireFormat.FieldType fieldType, Class<?> messageType, ExtensionRegistryLite extensionRegistry) throws IOException {
            switch (fieldType) {
                case BOOL:
                    return Boolean.valueOf(readBool());
                case BYTES:
                    return readBytes();
                case DOUBLE:
                    return Double.valueOf(readDouble());
                case ENUM:
                    return Integer.valueOf(readEnum());
                case FIXED32:
                    return Integer.valueOf(readFixed32());
                case FIXED64:
                    return Long.valueOf(readFixed64());
                case FLOAT:
                    return Float.valueOf(readFloat());
                case INT32:
                    return Integer.valueOf(readInt32());
                case INT64:
                    return Long.valueOf(readInt64());
                case MESSAGE:
                    return readMessage(messageType, extensionRegistry);
                case SFIXED32:
                    return Integer.valueOf(readSFixed32());
                case SFIXED64:
                    return Long.valueOf(readSFixed64());
                case SINT32:
                    return Integer.valueOf(readSInt32());
                case SINT64:
                    return Long.valueOf(readSInt64());
                case STRING:
                    return readStringRequireUtf8();
                case UINT32:
                    return Integer.valueOf(readUInt32());
                case UINT64:
                    return Long.valueOf(readUInt64());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private int readVarint32() throws IOException {
            int x;
            int i = this.pos;
            if (this.limit == this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i2 = i + 1;
            byte b = this.buffer[i];
            if (b >= 0) {
                this.pos = i2;
                return b;
            } else if (this.limit - i2 < 9) {
                return (int) readVarint64SlowPath();
            } else {
                int i3 = i2 + 1;
                int x2 = b ^ (this.buffer[i2] << 7);
                if (x2 < 0) {
                    x = x2 ^ -128;
                } else {
                    i3++;
                    int x3 = x2 ^ (this.buffer[i3] << 14);
                    if (x3 >= 0) {
                        x = x3 ^ 16256;
                    } else {
                        i3++;
                        int x4 = x3 ^ (this.buffer[i3] << 21);
                        if (x4 < 0) {
                            x = x4 ^ -2080896;
                        } else {
                            i3++;
                            byte b2 = this.buffer[i3];
                            x = (x4 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i3++;
                                if (this.buffer[i3] < 0) {
                                    i3++;
                                    if (this.buffer[i3] < 0) {
                                        i3++;
                                        if (this.buffer[i3] < 0) {
                                            i3++;
                                            if (this.buffer[i3] < 0) {
                                                i3++;
                                                if (this.buffer[i3] < 0) {
                                                    throw InvalidProtocolBufferException.malformedVarint();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.pos = i3;
                return x;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v35, types: [long] */
        /* JADX WARN: Type inference failed for: r0v44, types: [long] */
        /* JADX WARN: Type inference failed for: r0v46, types: [long] */
        /* JADX WARN: Type inference failed for: r0v48, types: [long] */
        /* JADX WARN: Type inference failed for: r0v50, types: [long] */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v18 */
        /* JADX WARN: Type inference failed for: r9v19 */
        public long readVarint64() throws IOException {
            char c;
            int i = this.pos;
            if (this.limit == i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] buffer = this.buffer;
            int i2 = i + 1;
            byte b = buffer[i];
            if (b >= 0) {
                this.pos = i2;
                return (long) b;
            } else if (this.limit - i2 < 9) {
                return readVarint64SlowPath();
            } else {
                int i3 = i2 + 1;
                int y = b ^ (buffer[i2] << 7);
                if (y < 0) {
                    c = (long) (y ^ -128);
                } else {
                    i3++;
                    int y2 = y ^ (buffer[i3] << 14);
                    if (y2 >= 0) {
                        c = (long) (y2 ^ 16256);
                    } else {
                        i3++;
                        int y3 = y2 ^ (buffer[i3] << 21);
                        if (y3 < 0) {
                            c = (long) (y3 ^ -2080896);
                        } else {
                            i3++;
                            long x = ((long) y3) ^ (((long) buffer[i3]) << 28);
                            if (x >= 0) {
                                c = x ^ 266354560;
                            } else {
                                i3++;
                                long x2 = x ^ (((long) buffer[i3]) << 35);
                                if (x2 < 0) {
                                    c = x2 ^ -34093383808L;
                                } else {
                                    i3++;
                                    long x3 = x2 ^ (((long) buffer[i3]) << 42);
                                    if (x3 >= 0) {
                                        c = x3 ^ 4363953127296L;
                                    } else {
                                        i3++;
                                        long x4 = x3 ^ (((long) buffer[i3]) << 49);
                                        if (x4 < 0) {
                                            c = x4 ^ -558586000294016L;
                                        } else {
                                            i3++;
                                            char c2 = (x4 ^ (((long) buffer[i3]) << 56)) ^ 71499008037633920L;
                                            int i4 = (c2 > 0 ? 1 : (c2 == 0 ? 0 : -1));
                                            c = c2;
                                            if (i4 < 0) {
                                                i3++;
                                                c = c2;
                                                if (((long) buffer[i3]) < 0) {
                                                    throw InvalidProtocolBufferException.malformedVarint();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.pos = i3;
                return c == 1 ? 1 : 0;
            }
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [long] */
        private long readVarint64SlowPath() throws IOException {
            char c = 0;
            for (int shift = 0; shift < 64; shift += 7) {
                byte b = readByte();
                c |= ((long) (b & Byte.MAX_VALUE)) << shift;
                if ((b & 128) == 0) {
                    return c;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private byte readByte() throws IOException {
            if (this.pos == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i];
        }

        private int readLittleEndian32() throws IOException {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private long readLittleEndian64() throws IOException {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int p = this.pos;
            byte[] buffer = this.buffer;
            this.pos = p + 4;
            return (buffer[p] & 255) | ((buffer[p + 1] & 255) << 8) | ((buffer[p + 2] & 255) << 16) | ((buffer[p + 3] & 255) << 24);
        }

        private long readLittleEndian64_NoCheck() {
            int p = this.pos;
            byte[] buffer = this.buffer;
            this.pos = p + 8;
            return (((long) buffer[p]) & 255) | ((((long) buffer[p + 1]) & 255) << 8) | ((((long) buffer[p + 2]) & 255) << 16) | ((((long) buffer[p + 3]) & 255) << 24) | ((((long) buffer[p + 4]) & 255) << 32) | ((((long) buffer[p + 5]) & 255) << 40) | ((((long) buffer[p + 6]) & 255) << 48) | ((((long) buffer[p + 7]) & 255) << 56);
        }

        private void skipVarint() throws IOException {
            if (this.limit - this.pos >= 10) {
                byte[] buffer = this.buffer;
                int p = this.pos;
                for (int i = 0; i < 10; i++) {
                    p++;
                    if (buffer[p] >= 0) {
                        this.pos = p;
                        return;
                    }
                }
            }
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipBytes(int size) throws IOException {
            requireBytes(size);
            this.pos += size;
        }

        private void skipGroup() throws IOException {
            int prevEndGroupTag = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            while (getFieldNumber() != Integer.MAX_VALUE && skipField()) {
            }
            if (this.tag != this.endGroupTag) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            this.endGroupTag = prevEndGroupTag;
        }

        private void requireBytes(int size) throws IOException {
            if (size < 0 || size > this.limit - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requireWireType(int requiredWireType) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != requiredWireType) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private void verifyPackedFixed64Length(int bytes) throws IOException {
            requireBytes(bytes);
            if ((bytes & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void verifyPackedFixed32Length(int bytes) throws IOException {
            requireBytes(bytes);
            if ((bytes & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void requirePosition(int expectedPosition) throws IOException {
            if (this.pos != expectedPosition) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
    }
}
