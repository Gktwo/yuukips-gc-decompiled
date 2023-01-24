package com.google.protobuf;

import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/CodedInputStreamReader.class */
public final class CodedInputStreamReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;
    private static final int NEXT_TAG_UNSET = 0;
    private final CodedInputStream input;
    private int tag;
    private int endGroupTag;
    private int nextTag = 0;

    public static CodedInputStreamReader forCodedInput(CodedInputStream input) {
        if (input.wrapper != null) {
            return input.wrapper;
        }
        return new CodedInputStreamReader(input);
    }

    private CodedInputStreamReader(CodedInputStream input) {
        this.input = (CodedInputStream) Internal.checkNotNull(input, "input");
        this.input.wrapper = this;
    }

    @Override // com.google.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return this.input.shouldDiscardUnknownFields();
    }

    @Override // com.google.protobuf.Reader
    public int getFieldNumber() throws IOException {
        if (this.nextTag != 0) {
            this.tag = this.nextTag;
            this.nextTag = 0;
        } else {
            this.tag = this.input.readTag();
        }
        if (this.tag == 0 || this.tag == this.endGroupTag) {
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
        if (this.input.isAtEnd() || this.tag == this.endGroupTag) {
            return false;
        }
        return this.input.skipField(this.tag);
    }

    private void requireWireType(int requiredWireType) throws IOException {
        if (WireFormat.getTagWireType(this.tag) != requiredWireType) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    @Override // com.google.protobuf.Reader
    public double readDouble() throws IOException {
        requireWireType(1);
        return this.input.readDouble();
    }

    @Override // com.google.protobuf.Reader
    public float readFloat() throws IOException {
        requireWireType(5);
        return this.input.readFloat();
    }

    @Override // com.google.protobuf.Reader
    public long readUInt64() throws IOException {
        requireWireType(0);
        return this.input.readUInt64();
    }

    @Override // com.google.protobuf.Reader
    public long readInt64() throws IOException {
        requireWireType(0);
        return this.input.readInt64();
    }

    @Override // com.google.protobuf.Reader
    public int readInt32() throws IOException {
        requireWireType(0);
        return this.input.readInt32();
    }

    @Override // com.google.protobuf.Reader
    public long readFixed64() throws IOException {
        requireWireType(1);
        return this.input.readFixed64();
    }

    @Override // com.google.protobuf.Reader
    public int readFixed32() throws IOException {
        requireWireType(5);
        return this.input.readFixed32();
    }

    @Override // com.google.protobuf.Reader
    public boolean readBool() throws IOException {
        requireWireType(0);
        return this.input.readBool();
    }

    @Override // com.google.protobuf.Reader
    public String readString() throws IOException {
        requireWireType(2);
        return this.input.readString();
    }

    @Override // com.google.protobuf.Reader
    public String readStringRequireUtf8() throws IOException {
        requireWireType(2);
        return this.input.readStringRequireUtf8();
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

    private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        int size = this.input.readUInt32();
        if (this.input.recursionDepth >= this.input.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int prevLimit = this.input.pushLimit(size);
        T message = schema.newInstance();
        this.input.recursionDepth++;
        schema.mergeFrom(message, this, extensionRegistry);
        schema.makeImmutable(message);
        this.input.checkLastTagWas(0);
        this.input.recursionDepth--;
        this.input.popLimit(prevLimit);
        return message;
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
        requireWireType(2);
        return this.input.readBytes();
    }

    @Override // com.google.protobuf.Reader
    public int readUInt32() throws IOException {
        requireWireType(0);
        return this.input.readUInt32();
    }

    @Override // com.google.protobuf.Reader
    public int readEnum() throws IOException {
        requireWireType(0);
        return this.input.readEnum();
    }

    @Override // com.google.protobuf.Reader
    public int readSFixed32() throws IOException {
        requireWireType(5);
        return this.input.readSFixed32();
    }

    @Override // com.google.protobuf.Reader
    public long readSFixed64() throws IOException {
        requireWireType(1);
        return this.input.readSFixed64();
    }

    @Override // com.google.protobuf.Reader
    public int readSInt32() throws IOException {
        requireWireType(0);
        return this.input.readSInt32();
    }

    @Override // com.google.protobuf.Reader
    public long readSInt64() throws IOException {
        requireWireType(0);
        return this.input.readSInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readDoubleList(List<Double> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof DoubleArrayList) {
            DoubleArrayList plist = (DoubleArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 1:
                    break;
                case 2:
                    int bytes = this.input.readUInt32();
                    verifyPackedFixed64Length(bytes);
                    int endPos = this.input.getTotalBytesRead() + bytes;
                    do {
                        plist.addDouble(this.input.readDouble());
                    } while (this.input.getTotalBytesRead() < endPos);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addDouble(this.input.readDouble());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 1:
                break;
            case 2:
                int bytes2 = this.input.readUInt32();
                verifyPackedFixed64Length(bytes2);
                int endPos2 = this.input.getTotalBytesRead() + bytes2;
                do {
                    target.add(Double.valueOf(this.input.readDouble()));
                } while (this.input.getTotalBytesRead() < endPos2);
                return;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Double.valueOf(this.input.readDouble()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readFloatList(List<Float> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof FloatArrayList) {
            FloatArrayList plist = (FloatArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 2:
                    int bytes = this.input.readUInt32();
                    verifyPackedFixed32Length(bytes);
                    int endPos = this.input.getTotalBytesRead() + bytes;
                    do {
                        plist.addFloat(this.input.readFloat());
                    } while (this.input.getTotalBytesRead() < endPos);
                    return;
                case 5:
                    break;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addFloat(this.input.readFloat());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 2:
                int bytes2 = this.input.readUInt32();
                verifyPackedFixed32Length(bytes2);
                int endPos2 = this.input.getTotalBytesRead() + bytes2;
                do {
                    target.add(Float.valueOf(this.input.readFloat()));
                } while (this.input.getTotalBytesRead() < endPos2);
                return;
            case 5:
                break;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Float.valueOf(this.input.readFloat()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readUInt64List(List<Long> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof LongArrayList) {
            LongArrayList plist = (LongArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int endPos = this.input.getTotalBytesRead() + this.input.readUInt32();
                    do {
                        plist.addLong(this.input.readUInt64());
                    } while (this.input.getTotalBytesRead() < endPos);
                    requirePosition(endPos);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addLong(this.input.readUInt64());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 0:
                break;
            case 2:
                int endPos2 = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    target.add(Long.valueOf(this.input.readUInt64()));
                } while (this.input.getTotalBytesRead() < endPos2);
                requirePosition(endPos2);
                return;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Long.valueOf(this.input.readUInt64()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readInt64List(List<Long> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof LongArrayList) {
            LongArrayList plist = (LongArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int endPos = this.input.getTotalBytesRead() + this.input.readUInt32();
                    do {
                        plist.addLong(this.input.readInt64());
                    } while (this.input.getTotalBytesRead() < endPos);
                    requirePosition(endPos);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addLong(this.input.readInt64());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 0:
                break;
            case 2:
                int endPos2 = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    target.add(Long.valueOf(this.input.readInt64()));
                } while (this.input.getTotalBytesRead() < endPos2);
                requirePosition(endPos2);
                return;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Long.valueOf(this.input.readInt64()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readInt32List(List<Integer> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof IntArrayList) {
            IntArrayList plist = (IntArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int endPos = this.input.getTotalBytesRead() + this.input.readUInt32();
                    do {
                        plist.addInt(this.input.readInt32());
                    } while (this.input.getTotalBytesRead() < endPos);
                    requirePosition(endPos);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addInt(this.input.readInt32());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 0:
                break;
            case 2:
                int endPos2 = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    target.add(Integer.valueOf(this.input.readInt32()));
                } while (this.input.getTotalBytesRead() < endPos2);
                requirePosition(endPos2);
                return;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Integer.valueOf(this.input.readInt32()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readFixed64List(List<Long> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof LongArrayList) {
            LongArrayList plist = (LongArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 1:
                    break;
                case 2:
                    int bytes = this.input.readUInt32();
                    verifyPackedFixed64Length(bytes);
                    int endPos = this.input.getTotalBytesRead() + bytes;
                    do {
                        plist.addLong(this.input.readFixed64());
                    } while (this.input.getTotalBytesRead() < endPos);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addLong(this.input.readFixed64());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 1:
                break;
            case 2:
                int bytes2 = this.input.readUInt32();
                verifyPackedFixed64Length(bytes2);
                int endPos2 = this.input.getTotalBytesRead() + bytes2;
                do {
                    target.add(Long.valueOf(this.input.readFixed64()));
                } while (this.input.getTotalBytesRead() < endPos2);
                return;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Long.valueOf(this.input.readFixed64()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readFixed32List(List<Integer> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof IntArrayList) {
            IntArrayList plist = (IntArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 2:
                    int bytes = this.input.readUInt32();
                    verifyPackedFixed32Length(bytes);
                    int endPos = this.input.getTotalBytesRead() + bytes;
                    do {
                        plist.addInt(this.input.readFixed32());
                    } while (this.input.getTotalBytesRead() < endPos);
                    return;
                case 5:
                    break;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addInt(this.input.readFixed32());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 2:
                int bytes2 = this.input.readUInt32();
                verifyPackedFixed32Length(bytes2);
                int endPos2 = this.input.getTotalBytesRead() + bytes2;
                do {
                    target.add(Integer.valueOf(this.input.readFixed32()));
                } while (this.input.getTotalBytesRead() < endPos2);
                return;
            case 5:
                break;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Integer.valueOf(this.input.readFixed32()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readBoolList(List<Boolean> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof BooleanArrayList) {
            BooleanArrayList plist = (BooleanArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int endPos = this.input.getTotalBytesRead() + this.input.readUInt32();
                    do {
                        plist.addBoolean(this.input.readBool());
                    } while (this.input.getTotalBytesRead() < endPos);
                    requirePosition(endPos);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addBoolean(this.input.readBool());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 0:
                break;
            case 2:
                int endPos2 = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    target.add(Boolean.valueOf(this.input.readBool()));
                } while (this.input.getTotalBytesRead() < endPos2);
                requirePosition(endPos2);
                return;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Boolean.valueOf(this.input.readBool()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
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
        int nextTag;
        int nextTag2;
        if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        } else if (!(target instanceof LazyStringList) || requireUtf8) {
            do {
                target.add(requireUtf8 ? readStringRequireUtf8() : readString());
                if (!this.input.isAtEnd()) {
                    nextTag = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag == this.tag);
            this.nextTag = nextTag;
        } else {
            LazyStringList lazyList = (LazyStringList) target;
            do {
                lazyList.add(readBytes());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
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
        int nextTag;
        if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int listTag = this.tag;
        do {
            target.add(readMessage(schema, extensionRegistry));
            if (!this.input.isAtEnd() && this.nextTag == 0) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == listTag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public <T> void readGroupList(List<T> target, Class<T> targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
        readGroupList(target, Protobuf.getInstance().schemaFor((Class) targetType), extensionRegistry);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    public <T> void readGroupList(List<T> target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        int nextTag;
        if (WireFormat.getTagWireType(this.tag) != 3) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int listTag = this.tag;
        do {
            target.add(readGroup(schema, extensionRegistry));
            if (!this.input.isAtEnd() && this.nextTag == 0) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == listTag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readBytesList(List<ByteString> target) throws IOException {
        int nextTag;
        if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(readBytes());
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readUInt32List(List<Integer> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof IntArrayList) {
            IntArrayList plist = (IntArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int endPos = this.input.getTotalBytesRead() + this.input.readUInt32();
                    do {
                        plist.addInt(this.input.readUInt32());
                    } while (this.input.getTotalBytesRead() < endPos);
                    requirePosition(endPos);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addInt(this.input.readUInt32());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 0:
                break;
            case 2:
                int endPos2 = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    target.add(Integer.valueOf(this.input.readUInt32()));
                } while (this.input.getTotalBytesRead() < endPos2);
                requirePosition(endPos2);
                return;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Integer.valueOf(this.input.readUInt32()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readEnumList(List<Integer> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof IntArrayList) {
            IntArrayList plist = (IntArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int endPos = this.input.getTotalBytesRead() + this.input.readUInt32();
                    do {
                        plist.addInt(this.input.readEnum());
                    } while (this.input.getTotalBytesRead() < endPos);
                    requirePosition(endPos);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addInt(this.input.readEnum());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 0:
                break;
            case 2:
                int endPos2 = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    target.add(Integer.valueOf(this.input.readEnum()));
                } while (this.input.getTotalBytesRead() < endPos2);
                requirePosition(endPos2);
                return;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Integer.valueOf(this.input.readEnum()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readSFixed32List(List<Integer> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof IntArrayList) {
            IntArrayList plist = (IntArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 2:
                    int bytes = this.input.readUInt32();
                    verifyPackedFixed32Length(bytes);
                    int endPos = this.input.getTotalBytesRead() + bytes;
                    do {
                        plist.addInt(this.input.readSFixed32());
                    } while (this.input.getTotalBytesRead() < endPos);
                    return;
                case 5:
                    break;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addInt(this.input.readSFixed32());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 2:
                int bytes2 = this.input.readUInt32();
                verifyPackedFixed32Length(bytes2);
                int endPos2 = this.input.getTotalBytesRead() + bytes2;
                do {
                    target.add(Integer.valueOf(this.input.readSFixed32()));
                } while (this.input.getTotalBytesRead() < endPos2);
                return;
            case 5:
                break;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Integer.valueOf(this.input.readSFixed32()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readSFixed64List(List<Long> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof LongArrayList) {
            LongArrayList plist = (LongArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 1:
                    break;
                case 2:
                    int bytes = this.input.readUInt32();
                    verifyPackedFixed64Length(bytes);
                    int endPos = this.input.getTotalBytesRead() + bytes;
                    do {
                        plist.addLong(this.input.readSFixed64());
                    } while (this.input.getTotalBytesRead() < endPos);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addLong(this.input.readSFixed64());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 1:
                break;
            case 2:
                int bytes2 = this.input.readUInt32();
                verifyPackedFixed64Length(bytes2);
                int endPos2 = this.input.getTotalBytesRead() + bytes2;
                do {
                    target.add(Long.valueOf(this.input.readSFixed64()));
                } while (this.input.getTotalBytesRead() < endPos2);
                return;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Long.valueOf(this.input.readSFixed64()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readSInt32List(List<Integer> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof IntArrayList) {
            IntArrayList plist = (IntArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int endPos = this.input.getTotalBytesRead() + this.input.readUInt32();
                    do {
                        plist.addInt(this.input.readSInt32());
                    } while (this.input.getTotalBytesRead() < endPos);
                    requirePosition(endPos);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addInt(this.input.readSInt32());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 0:
                break;
            case 2:
                int endPos2 = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    target.add(Integer.valueOf(this.input.readSInt32()));
                } while (this.input.getTotalBytesRead() < endPos2);
                requirePosition(endPos2);
                return;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Integer.valueOf(this.input.readSInt32()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    @Override // com.google.protobuf.Reader
    public void readSInt64List(List<Long> target) throws IOException {
        int nextTag;
        int nextTag2;
        if (target instanceof LongArrayList) {
            LongArrayList plist = (LongArrayList) target;
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 2:
                    int endPos = this.input.getTotalBytesRead() + this.input.readUInt32();
                    do {
                        plist.addLong(this.input.readSInt64());
                    } while (this.input.getTotalBytesRead() < endPos);
                    requirePosition(endPos);
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                plist.addLong(this.input.readSInt64());
                if (!this.input.isAtEnd()) {
                    nextTag2 = this.input.readTag();
                } else {
                    return;
                }
            } while (nextTag2 == this.tag);
            this.nextTag = nextTag2;
            return;
        }
        switch (WireFormat.getTagWireType(this.tag)) {
            case 0:
                break;
            case 2:
                int endPos2 = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    target.add(Long.valueOf(this.input.readSInt64()));
                } while (this.input.getTotalBytesRead() < endPos2);
                requirePosition(endPos2);
                return;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            target.add(Long.valueOf(this.input.readSInt64()));
            if (!this.input.isAtEnd()) {
                nextTag = this.input.readTag();
            } else {
                return;
            }
        } while (nextTag == this.tag);
        this.nextTag = nextTag;
    }

    private void verifyPackedFixed64Length(int bytes) throws IOException {
        if ((bytes & 7) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00aa, code lost:
        r6.put(r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b6, code lost:
        r5.input.popLimit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cf, code lost:
        return;
     */
    @Override // com.google.protobuf.Reader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <K, V> void readMap(java.util.Map<K, V> r6, com.google.protobuf.MapEntryLite.Metadata<K, V> r7, com.google.protobuf.ExtensionRegistryLite r8) throws java.io.IOException {
        /*
            r5 = this;
            r0 = r5
            r1 = 2
            r0.requireWireType(r1)
            r0 = r5
            com.google.protobuf.CodedInputStream r0 = r0.input
            int r0 = r0.readUInt32()
            r9 = r0
            r0 = r5
            com.google.protobuf.CodedInputStream r0 = r0.input
            r1 = r9
            int r0 = r0.pushLimit(r1)
            r10 = r0
            r0 = r7
            K r0 = r0.defaultKey
            r11 = r0
            r0 = r7
            V r0 = r0.defaultValue
            r12 = r0
        L_0x0025:
            r0 = r5
            int r0 = r0.getFieldNumber()     // Catch: all -> 0x00c1
            r13 = r0
            r0 = r13
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x00aa
            r0 = r5
            com.google.protobuf.CodedInputStream r0 = r0.input     // Catch: all -> 0x00c1
            boolean r0 = r0.isAtEnd()     // Catch: all -> 0x00c1
            if (r0 == 0) goto L_0x003f
            goto L_0x00aa
        L_0x003f:
            r0 = r13
            switch(r0) {
                case 1: goto L_0x005c;
                case 2: goto L_0x006b;
                default: goto L_0x0080;
            }     // Catch: all -> 0x00c1, InvalidWireTypeException -> 0x0094
        L_0x005c:
            r0 = r5
            r1 = r7
            com.google.protobuf.WireFormat$FieldType r1 = r1.keyType     // Catch: all -> 0x00c1, InvalidWireTypeException -> 0x0094
            r2 = 0
            r3 = 0
            java.lang.Object r0 = r0.readField(r1, r2, r3)     // Catch: all -> 0x00c1, InvalidWireTypeException -> 0x0094
            r11 = r0
            goto L_0x0091
        L_0x006b:
            r0 = r5
            r1 = r7
            com.google.protobuf.WireFormat$FieldType r1 = r1.valueType     // Catch: all -> 0x00c1, InvalidWireTypeException -> 0x0094
            r2 = r7
            V r2 = r2.defaultValue     // Catch: all -> 0x00c1, InvalidWireTypeException -> 0x0094
            java.lang.Class r2 = r2.getClass()     // Catch: all -> 0x00c1, InvalidWireTypeException -> 0x0094
            r3 = r8
            java.lang.Object r0 = r0.readField(r1, r2, r3)     // Catch: all -> 0x00c1, InvalidWireTypeException -> 0x0094
            r12 = r0
            goto L_0x0091
        L_0x0080:
            r0 = r5
            boolean r0 = r0.skipField()     // Catch: all -> 0x00c1, InvalidWireTypeException -> 0x0094
            if (r0 != 0) goto L_0x0091
            com.google.protobuf.InvalidProtocolBufferException r0 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: all -> 0x00c1, InvalidWireTypeException -> 0x0094
            r1 = r0
            java.lang.String r2 = "Unable to parse map entry."
            r1.<init>(r2)     // Catch: all -> 0x00c1, InvalidWireTypeException -> 0x0094
            throw r0     // Catch: all -> 0x00c1, InvalidWireTypeException -> 0x0094
        L_0x0091:
            goto L_0x00a7
        L_0x0094:
            r14 = move-exception
            r0 = r5
            boolean r0 = r0.skipField()     // Catch: all -> 0x00c1
            if (r0 != 0) goto L_0x00a7
            com.google.protobuf.InvalidProtocolBufferException r0 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: all -> 0x00c1
            r1 = r0
            java.lang.String r2 = "Unable to parse map entry."
            r1.<init>(r2)     // Catch: all -> 0x00c1
            throw r0     // Catch: all -> 0x00c1
        L_0x00a7:
            goto L_0x0025
        L_0x00aa:
            r0 = r6
            r1 = r11
            r2 = r12
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: all -> 0x00c1
            r0 = r5
            com.google.protobuf.CodedInputStream r0 = r0.input
            r1 = r10
            r0.popLimit(r1)
            goto L_0x00cf
        L_0x00c1:
            r15 = move-exception
            r0 = r5
            com.google.protobuf.CodedInputStream r0 = r0.input
            r1 = r10
            r0.popLimit(r1)
            r0 = r15
            throw r0
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStreamReader.readMap(java.util.Map, com.google.protobuf.MapEntryLite$Metadata, com.google.protobuf.ExtensionRegistryLite):void");
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

    private void verifyPackedFixed32Length(int bytes) throws IOException {
        if ((bytes & 3) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    private void requirePosition(int expectedPosition) throws IOException {
        if (this.input.getTotalBytesRead() != expectedPosition) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }
}
