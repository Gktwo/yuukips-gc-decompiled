package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/ArrayDecoders.class */
public final class ArrayDecoders {
    ArrayDecoders() {
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/protobuf/ArrayDecoders$Registers.class */
    public static final class Registers {
        public int int1;
        public long long1;
        public Object object1;
        public final ExtensionRegistryLite extensionRegistry;

        Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        /* access modifiers changed from: package-private */
        public Registers(ExtensionRegistryLite extensionRegistry) {
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            this.extensionRegistry = extensionRegistry;
        }
    }

    /* access modifiers changed from: package-private */
    public static int decodeVarint32(byte[] data, int position, Registers registers) {
        int position2 = position + 1;
        byte b = data[position];
        if (b < 0) {
            return decodeVarint32(b, data, position2, registers);
        }
        registers.int1 = b;
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeVarint32(int firstByte, byte[] data, int position, Registers registers) {
        int value = firstByte & 127;
        int position2 = position + 1;
        byte b2 = data[position];
        if (b2 >= 0) {
            registers.int1 = value | (b2 << 7);
            return position2;
        }
        int value2 = value | ((b2 & Byte.MAX_VALUE) << 7);
        int position3 = position2 + 1;
        byte b3 = data[position2];
        if (b3 >= 0) {
            registers.int1 = value2 | (b3 << 14);
            return position3;
        }
        int value3 = value2 | ((b3 & Byte.MAX_VALUE) << 14);
        int position4 = position3 + 1;
        byte b4 = data[position3];
        if (b4 >= 0) {
            registers.int1 = value3 | (b4 << 21);
            return position4;
        }
        int value4 = value3 | ((b4 & Byte.MAX_VALUE) << 21);
        int position5 = position4 + 1;
        byte b5 = data[position4];
        if (b5 >= 0) {
            registers.int1 = value4 | (b5 << 28);
            return position5;
        }
        int value5 = value4 | ((b5 & Byte.MAX_VALUE) << 28);
        do {
            position5++;
        } while (data[position5] < 0);
        registers.int1 = value5;
        return position5;
    }

    /* access modifiers changed from: package-private */
    public static int decodeVarint64(byte[] data, int position, Registers registers) {
        int position2 = position + 1;
        long value = (long) data[position];
        if (value < 0) {
            return decodeVarint64(value, data, position2, registers);
        }
        registers.long1 = value;
        return position2;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int decodeVarint64(long r6, byte[] r8, int r9, com.google.protobuf.ArrayDecoders.Registers r10) {
        /*
            r0 = r6
            r1 = 127(0x7f, double:6.27E-322)
            long r0 = r0 & r1
            r11 = r0
            r0 = r8
            r1 = r9
            int r9 = r9 + 1
            r0 = r0[r1]
            r13 = r0
            r0 = 7
            r14 = r0
            r0 = r11
            r1 = r13
            r2 = 127(0x7f, float:1.78E-43)
            r1 = r1 & r2
            long r1 = (long) r1
            r2 = 7
            long r1 = r1 << r2
            long r0 = r0 | r1
            r11 = r0
        L_0x0021:
            r0 = r13
            if (r0 >= 0) goto L_0x0042
            r0 = r8
            r1 = r9
            int r9 = r9 + 1
            r0 = r0[r1]
            r13 = r0
            int r14 = r14 + 7
            r0 = r11
            r1 = r13
            r2 = 127(0x7f, float:1.78E-43)
            r1 = r1 & r2
            long r1 = (long) r1
            r2 = r14
            long r1 = r1 << r2
            long r0 = r0 | r1
            r11 = r0
            goto L_0x0021
        L_0x0042:
            r0 = r10
            r1 = r11
            r0.long1 = r1
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.decodeVarint64(long, byte[], int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* access modifiers changed from: package-private */
    public static int decodeFixed32(byte[] data, int position) {
        return (data[position] & 255) | ((data[position + 1] & 255) << 8) | ((data[position + 2] & 255) << 16) | ((data[position + 3] & 255) << 24);
    }

    /* access modifiers changed from: package-private */
    public static long decodeFixed64(byte[] data, int position) {
        return (((long) data[position]) & 255) | ((((long) data[position + 1]) & 255) << 8) | ((((long) data[position + 2]) & 255) << 16) | ((((long) data[position + 3]) & 255) << 24) | ((((long) data[position + 4]) & 255) << 32) | ((((long) data[position + 5]) & 255) << 40) | ((((long) data[position + 6]) & 255) << 48) | ((((long) data[position + 7]) & 255) << 56);
    }

    /* access modifiers changed from: package-private */
    public static double decodeDouble(byte[] data, int position) {
        return Double.longBitsToDouble(decodeFixed64(data, position));
    }

    /* access modifiers changed from: package-private */
    public static float decodeFloat(byte[] data, int position) {
        return Float.intBitsToFloat(decodeFixed32(data, position));
    }

    /* access modifiers changed from: package-private */
    public static int decodeString(byte[] data, int position, Registers registers) throws InvalidProtocolBufferException {
        int position2 = decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (length == 0) {
            registers.object1 = "";
            return position2;
        } else {
            registers.object1 = new String(data, position2, length, Internal.UTF_8);
            return position2 + length;
        }
    }

    /* access modifiers changed from: package-private */
    public static int decodeStringRequireUtf8(byte[] data, int position, Registers registers) throws InvalidProtocolBufferException {
        int position2 = decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (length == 0) {
            registers.object1 = "";
            return position2;
        } else {
            registers.object1 = Utf8.decodeUtf8(data, position2, length);
            return position2 + length;
        }
    }

    /* access modifiers changed from: package-private */
    public static int decodeBytes(byte[] data, int position, Registers registers) throws InvalidProtocolBufferException {
        int position2 = decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (length > data.length - position2) {
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (length == 0) {
            registers.object1 = ByteString.EMPTY;
            return position2;
        } else {
            registers.object1 = ByteString.copyFrom(data, position2, length);
            return position2 + length;
        }
    }

    /* access modifiers changed from: package-private */
    public static int decodeMessageField(Schema schema, byte[] data, int position, int limit, Registers registers) throws IOException {
        int position2 = position + 1;
        int length = data[position];
        if (length < 0) {
            position2 = decodeVarint32(length, data, position2, registers);
            length = registers.int1;
        }
        if (length < 0 || length > limit - position2) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        Object result = schema.newInstance();
        schema.mergeFrom(result, data, position2, position2 + length, registers);
        schema.makeImmutable(result);
        registers.object1 = result;
        return position2 + length;
    }

    /* access modifiers changed from: package-private */
    public static int decodeGroupField(Schema schema, byte[] data, int position, int limit, int endGroup, Registers registers) throws IOException {
        MessageSchema messageSchema = (MessageSchema) schema;
        Object result = messageSchema.newInstance();
        int endPosition = messageSchema.parseProto2Message(result, data, position, limit, endGroup, registers);
        messageSchema.makeImmutable(result);
        registers.object1 = result;
        return endPosition;
    }

    /* access modifiers changed from: package-private */
    public static int decodeVarint32List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        IntArrayList output = (IntArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        output.addInt(registers.int1);
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            position2 = decodeVarint32(data, nextPosition, registers);
            output.addInt(registers.int1);
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeVarint64List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        LongArrayList output = (LongArrayList) list;
        int position2 = decodeVarint64(data, position, registers);
        output.addLong(registers.long1);
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            position2 = decodeVarint64(data, nextPosition, registers);
            output.addLong(registers.long1);
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeFixed32List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        IntArrayList output = (IntArrayList) list;
        output.addInt(decodeFixed32(data, position));
        int position2 = position + 4;
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            output.addInt(decodeFixed32(data, nextPosition));
            position2 = nextPosition + 4;
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeFixed64List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        LongArrayList output = (LongArrayList) list;
        output.addLong(decodeFixed64(data, position));
        int position2 = position + 8;
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            output.addLong(decodeFixed64(data, nextPosition));
            position2 = nextPosition + 8;
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeFloatList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        FloatArrayList output = (FloatArrayList) list;
        output.addFloat(decodeFloat(data, position));
        int position2 = position + 4;
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            output.addFloat(decodeFloat(data, nextPosition));
            position2 = nextPosition + 4;
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeDoubleList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        DoubleArrayList output = (DoubleArrayList) list;
        output.addDouble(decodeDouble(data, position));
        int position2 = position + 8;
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            output.addDouble(decodeDouble(data, nextPosition));
            position2 = nextPosition + 8;
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeBoolList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        BooleanArrayList output = (BooleanArrayList) list;
        int position2 = decodeVarint64(data, position, registers);
        output.addBoolean(registers.long1 != 0);
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            position2 = decodeVarint64(data, nextPosition, registers);
            output.addBoolean(registers.long1 != 0);
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeSInt32List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        IntArrayList output = (IntArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        output.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            position2 = decodeVarint32(data, nextPosition, registers);
            output.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeSInt64List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        LongArrayList output = (LongArrayList) list;
        int position2 = decodeVarint64(data, position, registers);
        output.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            position2 = decodeVarint64(data, nextPosition, registers);
            output.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodePackedVarint32List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        IntArrayList output = (IntArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = position2 + registers.int1;
        while (position2 < fieldLimit) {
            position2 = decodeVarint32(data, position2, registers);
            output.addInt(registers.int1);
        }
        if (position2 == fieldLimit) {
            return position2;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* access modifiers changed from: package-private */
    public static int decodePackedVarint64List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        LongArrayList output = (LongArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = position2 + registers.int1;
        while (position2 < fieldLimit) {
            position2 = decodeVarint64(data, position2, registers);
            output.addLong(registers.long1);
        }
        if (position2 == fieldLimit) {
            return position2;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* access modifiers changed from: package-private */
    public static int decodePackedFixed32List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        IntArrayList output = (IntArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = position2 + registers.int1;
        while (position2 < fieldLimit) {
            output.addInt(decodeFixed32(data, position2));
            position2 += 4;
        }
        if (position2 == fieldLimit) {
            return position2;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* access modifiers changed from: package-private */
    public static int decodePackedFixed64List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        LongArrayList output = (LongArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = position2 + registers.int1;
        while (position2 < fieldLimit) {
            output.addLong(decodeFixed64(data, position2));
            position2 += 8;
        }
        if (position2 == fieldLimit) {
            return position2;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* access modifiers changed from: package-private */
    public static int decodePackedFloatList(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        FloatArrayList output = (FloatArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = position2 + registers.int1;
        while (position2 < fieldLimit) {
            output.addFloat(decodeFloat(data, position2));
            position2 += 4;
        }
        if (position2 == fieldLimit) {
            return position2;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* access modifiers changed from: package-private */
    public static int decodePackedDoubleList(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        DoubleArrayList output = (DoubleArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = position2 + registers.int1;
        while (position2 < fieldLimit) {
            output.addDouble(decodeDouble(data, position2));
            position2 += 8;
        }
        if (position2 == fieldLimit) {
            return position2;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* access modifiers changed from: package-private */
    public static int decodePackedBoolList(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        BooleanArrayList output = (BooleanArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = position2 + registers.int1;
        while (position2 < fieldLimit) {
            position2 = decodeVarint64(data, position2, registers);
            output.addBoolean(registers.long1 != 0);
        }
        if (position2 == fieldLimit) {
            return position2;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* access modifiers changed from: package-private */
    public static int decodePackedSInt32List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        IntArrayList output = (IntArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = position2 + registers.int1;
        while (position2 < fieldLimit) {
            position2 = decodeVarint32(data, position2, registers);
            output.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        if (position2 == fieldLimit) {
            return position2;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* access modifiers changed from: package-private */
    public static int decodePackedSInt64List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        LongArrayList output = (LongArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = position2 + registers.int1;
        while (position2 < fieldLimit) {
            position2 = decodeVarint64(data, position2, registers);
            output.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        if (position2 == fieldLimit) {
            return position2;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* access modifiers changed from: package-private */
    public static int decodeStringList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws InvalidProtocolBufferException {
        int position2 = decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (length == 0) {
            list.add("");
        } else {
            list.add(new String(data, position2, length, Internal.UTF_8));
            position2 += length;
        }
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            position2 = decodeVarint32(data, nextPosition, registers);
            int nextLength = registers.int1;
            if (nextLength < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else if (nextLength == 0) {
                list.add("");
            } else {
                list.add(new String(data, position2, nextLength, Internal.UTF_8));
                position2 += nextLength;
            }
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeStringListRequireUtf8(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws InvalidProtocolBufferException {
        int position2 = decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (length == 0) {
            list.add("");
        } else if (!Utf8.isValidUtf8(data, position2, position2 + length)) {
            throw InvalidProtocolBufferException.invalidUtf8();
        } else {
            list.add(new String(data, position2, length, Internal.UTF_8));
            position2 += length;
        }
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            position2 = decodeVarint32(data, nextPosition, registers);
            int nextLength = registers.int1;
            if (nextLength < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else if (nextLength == 0) {
                list.add("");
            } else if (!Utf8.isValidUtf8(data, position2, position2 + nextLength)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            } else {
                list.add(new String(data, position2, nextLength, Internal.UTF_8));
                position2 += nextLength;
            }
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeBytesList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws InvalidProtocolBufferException {
        int position2 = decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (length > data.length - position2) {
            throw InvalidProtocolBufferException.truncatedMessage();
        } else {
            if (length == 0) {
                list.add(ByteString.EMPTY);
            } else {
                list.add(ByteString.copyFrom(data, position2, length));
                position2 += length;
            }
            while (position2 < limit) {
                int nextPosition = decodeVarint32(data, position2, registers);
                if (tag != registers.int1) {
                    break;
                }
                position2 = decodeVarint32(data, nextPosition, registers);
                int nextLength = registers.int1;
                if (nextLength < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                } else if (nextLength > data.length - position2) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                } else if (nextLength == 0) {
                    list.add(ByteString.EMPTY);
                } else {
                    list.add(ByteString.copyFrom(data, position2, nextLength));
                    position2 += nextLength;
                }
            }
            return position2;
        }
    }

    /* access modifiers changed from: package-private */
    public static int decodeMessageList(Schema<?> schema, int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        int position2 = decodeMessageField(schema, data, position, limit, registers);
        list.add(registers.object1);
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            position2 = decodeMessageField(schema, data, nextPosition, limit, registers);
            list.add(registers.object1);
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeGroupList(Schema schema, int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        int endgroup = (tag & -8) | 4;
        int position2 = decodeGroupField(schema, data, position, limit, endgroup, registers);
        list.add(registers.object1);
        while (position2 < limit) {
            int nextPosition = decodeVarint32(data, position2, registers);
            if (tag != registers.int1) {
                break;
            }
            position2 = decodeGroupField(schema, data, nextPosition, limit, endgroup, registers);
            list.add(registers.object1);
        }
        return position2;
    }

    /* access modifiers changed from: package-private */
    public static int decodeExtensionOrUnknownField(int tag, byte[] data, int position, int limit, Object message, MessageLite defaultInstance, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        GeneratedMessageLite.GeneratedExtension extension = registers.extensionRegistry.findLiteExtensionByNumber(defaultInstance, tag >>> 3);
        if (extension == null) {
            return decodeUnknownField(tag, data, position, limit, MessageSchema.getMutableUnknownFields(message), registers);
        }
        ((GeneratedMessageLite.ExtendableMessage) message).ensureExtensionsAreMutable();
        return decodeExtension(tag, data, position, limit, (GeneratedMessageLite.ExtendableMessage) message, extension, unknownFieldSchema, registers);
    }

    static int decodeExtension(int tag, byte[] data, int position, int limit, GeneratedMessageLite.ExtendableMessage<?, ?> message, GeneratedMessageLite.GeneratedExtension<?, ?> extension, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions = message.extensions;
        int fieldNumber = tag >>> 3;
        if (!extension.descriptor.isRepeated() || !extension.descriptor.isPacked()) {
            Object value = null;
            if (extension.getLiteType() != WireFormat.FieldType.ENUM) {
                switch (extension.getLiteType()) {
                    case DOUBLE:
                        value = Double.valueOf(decodeDouble(data, position));
                        position += 8;
                        break;
                    case FLOAT:
                        value = Float.valueOf(decodeFloat(data, position));
                        position += 4;
                        break;
                    case INT64:
                    case UINT64:
                        position = decodeVarint64(data, position, registers);
                        value = Long.valueOf(registers.long1);
                        break;
                    case INT32:
                    case UINT32:
                        position = decodeVarint32(data, position, registers);
                        value = Integer.valueOf(registers.int1);
                        break;
                    case FIXED64:
                    case SFIXED64:
                        value = Long.valueOf(decodeFixed64(data, position));
                        position += 8;
                        break;
                    case FIXED32:
                    case SFIXED32:
                        value = Integer.valueOf(decodeFixed32(data, position));
                        position += 4;
                        break;
                    case BOOL:
                        position = decodeVarint64(data, position, registers);
                        value = Boolean.valueOf(registers.long1 != 0);
                        break;
                    case SINT32:
                        position = decodeVarint32(data, position, registers);
                        value = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                        break;
                    case SINT64:
                        position = decodeVarint64(data, position, registers);
                        value = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                        break;
                    case ENUM:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case BYTES:
                        position = decodeBytes(data, position, registers);
                        value = registers.object1;
                        break;
                    case STRING:
                        position = decodeString(data, position, registers);
                        value = registers.object1;
                        break;
                    case GROUP:
                        position = decodeGroupField(Protobuf.getInstance().schemaFor((Class) extension.getMessageDefaultInstance().getClass()), data, position, limit, (fieldNumber << 3) | 4, registers);
                        value = registers.object1;
                        break;
                    case MESSAGE:
                        position = decodeMessageField(Protobuf.getInstance().schemaFor((Class) extension.getMessageDefaultInstance().getClass()), data, position, limit, registers);
                        value = registers.object1;
                        break;
                }
            } else {
                position = decodeVarint32(data, position, registers);
                if (extension.descriptor.getEnumType().findValueByNumber(registers.int1) == null) {
                    UnknownFieldSetLite unknownFields = message.unknownFields;
                    if (unknownFields == UnknownFieldSetLite.getDefaultInstance()) {
                        unknownFields = UnknownFieldSetLite.newInstance();
                        message.unknownFields = unknownFields;
                    }
                    SchemaUtil.storeUnknownEnum(fieldNumber, registers.int1, unknownFields, unknownFieldSchema);
                    return position;
                }
                value = Integer.valueOf(registers.int1);
            }
            if (extension.isRepeated()) {
                extensions.addRepeatedField(extension.descriptor, value);
            } else {
                switch (extension.getLiteType()) {
                    case GROUP:
                    case MESSAGE:
                        Object oldValue = extensions.getField(extension.descriptor);
                        if (oldValue != null) {
                            value = Internal.mergeMessage(oldValue, value);
                            break;
                        }
                        break;
                }
                extensions.setField(extension.descriptor, value);
            }
        } else {
            switch (extension.getLiteType()) {
                case DOUBLE:
                    DoubleArrayList list = new DoubleArrayList();
                    position = decodePackedDoubleList(data, position, list, registers);
                    extensions.setField(extension.descriptor, list);
                    break;
                case FLOAT:
                    FloatArrayList list2 = new FloatArrayList();
                    position = decodePackedFloatList(data, position, list2, registers);
                    extensions.setField(extension.descriptor, list2);
                    break;
                case INT64:
                case UINT64:
                    LongArrayList list3 = new LongArrayList();
                    position = decodePackedVarint64List(data, position, list3, registers);
                    extensions.setField(extension.descriptor, list3);
                    break;
                case INT32:
                case UINT32:
                    IntArrayList list4 = new IntArrayList();
                    position = decodePackedVarint32List(data, position, list4, registers);
                    extensions.setField(extension.descriptor, list4);
                    break;
                case FIXED64:
                case SFIXED64:
                    LongArrayList list5 = new LongArrayList();
                    position = decodePackedFixed64List(data, position, list5, registers);
                    extensions.setField(extension.descriptor, list5);
                    break;
                case FIXED32:
                case SFIXED32:
                    IntArrayList list6 = new IntArrayList();
                    position = decodePackedFixed32List(data, position, list6, registers);
                    extensions.setField(extension.descriptor, list6);
                    break;
                case BOOL:
                    BooleanArrayList list7 = new BooleanArrayList();
                    position = decodePackedBoolList(data, position, list7, registers);
                    extensions.setField(extension.descriptor, list7);
                    break;
                case SINT32:
                    IntArrayList list8 = new IntArrayList();
                    position = decodePackedSInt32List(data, position, list8, registers);
                    extensions.setField(extension.descriptor, list8);
                    break;
                case SINT64:
                    LongArrayList list9 = new LongArrayList();
                    position = decodePackedSInt64List(data, position, list9, registers);
                    extensions.setField(extension.descriptor, list9);
                    break;
                case ENUM:
                    IntArrayList list10 = new IntArrayList();
                    position = decodePackedVarint32List(data, position, list10, registers);
                    UnknownFieldSetLite unknownFields2 = message.unknownFields;
                    if (unknownFields2 == UnknownFieldSetLite.getDefaultInstance()) {
                        unknownFields2 = null;
                    }
                    UnknownFieldSetLite unknownFields3 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(fieldNumber, (List<Integer>) list10, extension.descriptor.getEnumType(), unknownFields2, (UnknownFieldSchema<UT, UnknownFieldSetLite>) unknownFieldSchema);
                    if (unknownFields3 != null) {
                        message.unknownFields = unknownFields3;
                    }
                    extensions.setField(extension.descriptor, list10);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + extension.descriptor.getLiteType());
            }
        }
        return position;
    }

    /* access modifiers changed from: package-private */
    public static int decodeUnknownField(int tag, byte[] data, int position, int limit, UnknownFieldSetLite unknownFields, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(tag) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        switch (WireFormat.getTagWireType(tag)) {
            case 0:
                int position2 = decodeVarint64(data, position, registers);
                unknownFields.storeField(tag, Long.valueOf(registers.long1));
                return position2;
            case 1:
                unknownFields.storeField(tag, Long.valueOf(decodeFixed64(data, position)));
                return position + 8;
            case 2:
                int position3 = decodeVarint32(data, position, registers);
                int length = registers.int1;
                if (length < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                } else if (length > data.length - position3) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                } else {
                    if (length == 0) {
                        unknownFields.storeField(tag, ByteString.EMPTY);
                    } else {
                        unknownFields.storeField(tag, ByteString.copyFrom(data, position3, length));
                    }
                    return position3 + length;
                }
            case 3:
                UnknownFieldSetLite child = UnknownFieldSetLite.newInstance();
                int endGroup = (tag & -8) | 4;
                int lastTag = 0;
                while (position < limit) {
                    position = decodeVarint32(data, position, registers);
                    lastTag = registers.int1;
                    if (lastTag != endGroup) {
                        position = decodeUnknownField(lastTag, data, position, limit, child, registers);
                    } else if (position <= limit || lastTag != endGroup) {
                        throw InvalidProtocolBufferException.parseFailure();
                    } else {
                        unknownFields.storeField(tag, child);
                        return position;
                    }
                }
                if (position <= limit) {
                }
                throw InvalidProtocolBufferException.parseFailure();
            case 4:
            default:
                throw InvalidProtocolBufferException.invalidTag();
            case 5:
                unknownFields.storeField(tag, Integer.valueOf(decodeFixed32(data, position)));
                return position + 4;
        }
    }

    /* access modifiers changed from: package-private */
    public static int skipField(int tag, byte[] data, int position, int limit, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(tag) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        switch (WireFormat.getTagWireType(tag)) {
            case 0:
                return decodeVarint64(data, position, registers);
            case 1:
                return position + 8;
            case 2:
                return decodeVarint32(data, position, registers) + registers.int1;
            case 3:
                int endGroup = (tag & -8) | 4;
                int lastTag = 0;
                while (position < limit) {
                    position = decodeVarint32(data, position, registers);
                    lastTag = registers.int1;
                    if (lastTag != endGroup) {
                        position = skipField(lastTag, data, position, limit, registers);
                    } else if (position > limit && lastTag == endGroup) {
                        return position;
                    } else {
                        throw InvalidProtocolBufferException.parseFailure();
                    }
                }
                if (position > limit) {
                }
                throw InvalidProtocolBufferException.parseFailure();
            case 4:
            default:
                throw InvalidProtocolBufferException.invalidTag();
            case 5:
                return position + 4;
        }
    }
}
