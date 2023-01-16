package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/MessageSchema.class */
public final class MessageSchema<T> implements Schema<T> {
    private static final int INTS_PER_FIELD = 3;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int REQUIRED_MASK = 268435456;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private final int[] buffer;
    private final Object[] objects;
    private final int minFieldNumber;
    private final int maxFieldNumber;
    private final MessageLite defaultInstance;
    private final boolean hasExtensions;
    private final boolean lite;
    private final boolean proto3;
    private final boolean useCachedSizeField;
    private final int[] intArray;
    private final int checkInitializedCount;
    private final int repeatedFieldOffsetStart;
    private final NewInstanceSchema newInstanceSchema;
    private final ListFieldSchema listFieldSchema;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final ExtensionSchema<?> extensionSchema;
    private final MapFieldSchema mapFieldSchema;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    private MessageSchema(int[] buffer, Object[] objects, int minFieldNumber, int maxFieldNumber, MessageLite defaultInstance, boolean proto3, boolean useCachedSizeField, int[] intArray, int checkInitialized, int mapFieldPositions, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = buffer;
        this.objects = objects;
        this.minFieldNumber = minFieldNumber;
        this.maxFieldNumber = maxFieldNumber;
        this.lite = defaultInstance instanceof GeneratedMessageLite;
        this.proto3 = proto3;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(defaultInstance);
        this.useCachedSizeField = useCachedSizeField;
        this.intArray = intArray;
        this.checkInitializedCount = checkInitialized;
        this.repeatedFieldOffsetStart = mapFieldPositions;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = defaultInstance;
        this.mapFieldSchema = mapFieldSchema;
    }

    /* access modifiers changed from: package-private */
    public static <T> MessageSchema<T> newSchema(Class<T> messageClass, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int objectsPosition;
        int[] intArray;
        int checkInitialized;
        int mapFieldCount;
        int numEntries;
        int maxFieldNumber;
        int minFieldNumber;
        int oneofCount;
        int presenceFieldOffset;
        int presenceMaskShift;
        int fieldOffset;
        Field hasBitsField;
        int next;
        Field oneofField;
        Field oneofCaseField;
        int next2;
        int next3;
        int next4;
        int next5;
        int next6;
        int next7;
        int next8;
        int next9;
        int next10;
        int next11;
        int next12;
        int next13;
        int next14;
        boolean isProto3 = messageInfo.getSyntax() == ProtoSyntax.PROTO3;
        String info = messageInfo.getStringInfo();
        int length = info.length();
        int i = 0 + 1;
        int next15 = info.charAt(0);
        if (next15 >= 55296) {
            int result = next15 & 8191;
            int shift = 13;
            while (true) {
                i++;
                next14 = info.charAt(i);
                if (next14 < 55296) {
                    break;
                }
                result |= (next14 & 8191) << shift;
                shift += 13;
            }
            next15 = result | (next14 << shift);
        }
        int i2 = i + 1;
        int next16 = info.charAt(i);
        if (next16 >= 55296) {
            int result2 = next16 & 8191;
            int shift2 = 13;
            while (true) {
                i2++;
                next13 = info.charAt(i2);
                if (next13 < 55296) {
                    break;
                }
                result2 |= (next13 & 8191) << shift2;
                shift2 += 13;
            }
            next16 = result2 | (next13 << shift2);
        }
        if (next16 == 0) {
            oneofCount = 0;
            minFieldNumber = 0;
            maxFieldNumber = 0;
            numEntries = 0;
            mapFieldCount = 0;
            checkInitialized = 0;
            intArray = EMPTY_INT_ARRAY;
            objectsPosition = 0;
        } else {
            int i3 = i2 + 1;
            int next17 = info.charAt(i2);
            if (next17 >= 55296) {
                int result3 = next17 & 8191;
                int shift3 = 13;
                while (true) {
                    i3++;
                    next12 = info.charAt(i3);
                    if (next12 < 55296) {
                        break;
                    }
                    result3 |= (next12 & 8191) << shift3;
                    shift3 += 13;
                }
                next17 = result3 | (next12 << shift3);
            }
            oneofCount = next17;
            int i4 = i3 + 1;
            int next18 = info.charAt(i3);
            if (next18 >= 55296) {
                int result4 = next18 & 8191;
                int shift4 = 13;
                while (true) {
                    i4++;
                    next11 = info.charAt(i4);
                    if (next11 < 55296) {
                        break;
                    }
                    result4 |= (next11 & 8191) << shift4;
                    shift4 += 13;
                }
                next18 = result4 | (next11 << shift4);
            }
            int i5 = i4 + 1;
            int next19 = info.charAt(i4);
            if (next19 >= 55296) {
                int result5 = next19 & 8191;
                int shift5 = 13;
                while (true) {
                    i5++;
                    next10 = info.charAt(i5);
                    if (next10 < 55296) {
                        break;
                    }
                    result5 |= (next10 & 8191) << shift5;
                    shift5 += 13;
                }
                next19 = result5 | (next10 << shift5);
            }
            minFieldNumber = next19;
            int i6 = i5 + 1;
            int next20 = info.charAt(i5);
            if (next20 >= 55296) {
                int result6 = next20 & 8191;
                int shift6 = 13;
                while (true) {
                    i6++;
                    next9 = info.charAt(i6);
                    if (next9 < 55296) {
                        break;
                    }
                    result6 |= (next9 & 8191) << shift6;
                    shift6 += 13;
                }
                next20 = result6 | (next9 << shift6);
            }
            maxFieldNumber = next20;
            int i7 = i6 + 1;
            int next21 = info.charAt(i6);
            if (next21 >= 55296) {
                int result7 = next21 & 8191;
                int shift7 = 13;
                while (true) {
                    i7++;
                    next8 = info.charAt(i7);
                    if (next8 < 55296) {
                        break;
                    }
                    result7 |= (next8 & 8191) << shift7;
                    shift7 += 13;
                }
                next21 = result7 | (next8 << shift7);
            }
            numEntries = next21;
            int i8 = i7 + 1;
            int next22 = info.charAt(i7);
            if (next22 >= 55296) {
                int result8 = next22 & 8191;
                int shift8 = 13;
                while (true) {
                    i8++;
                    next7 = info.charAt(i8);
                    if (next7 < 55296) {
                        break;
                    }
                    result8 |= (next7 & 8191) << shift8;
                    shift8 += 13;
                }
                next22 = result8 | (next7 << shift8);
            }
            mapFieldCount = next22;
            int i9 = i8 + 1;
            int next23 = info.charAt(i8);
            if (next23 >= 55296) {
                int result9 = next23 & 8191;
                int shift9 = 13;
                while (true) {
                    i9++;
                    next6 = info.charAt(i9);
                    if (next6 < 55296) {
                        break;
                    }
                    result9 |= (next6 & 8191) << shift9;
                    shift9 += 13;
                }
                next23 = result9 | (next6 << shift9);
            }
            i2 = i9 + 1;
            int next24 = info.charAt(i9);
            if (next24 >= 55296) {
                int result10 = next24 & 8191;
                int shift10 = 13;
                while (true) {
                    i2++;
                    next5 = info.charAt(i2);
                    if (next5 < 55296) {
                        break;
                    }
                    result10 |= (next5 & 8191) << shift10;
                    shift10 += 13;
                }
                next24 = result10 | (next5 << shift10);
            }
            checkInitialized = next24;
            intArray = new int[checkInitialized + mapFieldCount + next23];
            objectsPosition = (oneofCount * 2) + next18;
        }
        Unsafe unsafe = UNSAFE;
        Object[] messageInfoObjects = messageInfo.getObjects();
        int checkInitializedPosition = 0;
        Class<?> messageClass = messageInfo.getDefaultInstance().getClass();
        int[] buffer = new int[numEntries * 3];
        Object[] objects = new Object[numEntries * 2];
        int mapFieldIndex = checkInitialized;
        int repeatedFieldIndex = checkInitialized + mapFieldCount;
        int bufferIndex = 0;
        while (i2 < length) {
            int i10 = i2 + 1;
            int next25 = info.charAt(i2);
            if (next25 >= 55296) {
                int result11 = next25 & 8191;
                int shift11 = 13;
                while (true) {
                    i10++;
                    next4 = info.charAt(i10);
                    if (next4 < 55296) {
                        break;
                    }
                    result11 |= (next4 & 8191) << shift11;
                    shift11 += 13;
                }
                next25 = result11 | (next4 << shift11);
            }
            i2 = i10 + 1;
            int next26 = info.charAt(i10);
            if (next26 >= 55296) {
                int result12 = next26 & 8191;
                int shift12 = 13;
                while (true) {
                    i2++;
                    next3 = info.charAt(i2);
                    if (next3 < 55296) {
                        break;
                    }
                    result12 |= (next3 & 8191) << shift12;
                    shift12 += 13;
                }
                next26 = result12 | (next3 << shift12);
            }
            int fieldType = next26 & 255;
            if ((next26 & 1024) != 0) {
                checkInitializedPosition++;
                intArray[checkInitializedPosition] = bufferIndex;
            }
            if (fieldType >= 51) {
                i2++;
                int next27 = info.charAt(i2);
                if (next27 >= 55296) {
                    int result13 = next27 & 8191;
                    int shift13 = 13;
                    while (true) {
                        i2++;
                        next2 = info.charAt(i2);
                        if (next2 < 55296) {
                            break;
                        }
                        result13 |= (next2 & 8191) << shift13;
                        shift13 += 13;
                    }
                    next27 = result13 | (next2 << shift13);
                }
                int oneofFieldType = fieldType - 51;
                if (oneofFieldType == 9 || oneofFieldType == 17) {
                    objectsPosition++;
                    objects[((bufferIndex / 3) * 2) + 1] = messageInfoObjects[objectsPosition];
                } else if (oneofFieldType == 12 && !isProto3) {
                    objectsPosition++;
                    objects[((bufferIndex / 3) * 2) + 1] = messageInfoObjects[objectsPosition];
                }
                int index = next27 * 2;
                Object o = messageInfoObjects[index];
                if (o instanceof Field) {
                    oneofField = (Field) o;
                } else {
                    oneofField = reflectField(messageClass, (String) o);
                    messageInfoObjects[index] = oneofField;
                }
                fieldOffset = (int) unsafe.objectFieldOffset(oneofField);
                int index2 = index + 1;
                Object o2 = messageInfoObjects[index2];
                if (o2 instanceof Field) {
                    oneofCaseField = (Field) o2;
                } else {
                    oneofCaseField = reflectField(messageClass, (String) o2);
                    messageInfoObjects[index2] = oneofCaseField;
                }
                presenceFieldOffset = (int) unsafe.objectFieldOffset(oneofCaseField);
                presenceMaskShift = 0;
            } else {
                objectsPosition++;
                Field field = reflectField(messageClass, (String) messageInfoObjects[objectsPosition]);
                if (fieldType == 9 || fieldType == 17) {
                    objects[((bufferIndex / 3) * 2) + 1] = field.getType();
                } else if (fieldType == 27 || fieldType == 49) {
                    objectsPosition++;
                    objects[((bufferIndex / 3) * 2) + 1] = messageInfoObjects[objectsPosition];
                } else if (fieldType == 12 || fieldType == 30 || fieldType == 44) {
                    if (!isProto3) {
                        objectsPosition++;
                        objects[((bufferIndex / 3) * 2) + 1] = messageInfoObjects[objectsPosition];
                    }
                } else if (fieldType == 50) {
                    mapFieldIndex++;
                    intArray[mapFieldIndex] = bufferIndex;
                    objectsPosition++;
                    objects[(bufferIndex / 3) * 2] = messageInfoObjects[objectsPosition];
                    if ((next26 & 2048) != 0) {
                        objectsPosition++;
                        objects[((bufferIndex / 3) * 2) + 1] = messageInfoObjects[objectsPosition];
                    }
                }
                fieldOffset = (int) unsafe.objectFieldOffset(field);
                if (!((next26 & 4096) == 4096) || fieldType > 17) {
                    presenceFieldOffset = 1048575;
                    presenceMaskShift = 0;
                } else {
                    i2++;
                    int next28 = info.charAt(i2);
                    if (next28 >= 55296) {
                        int result14 = next28 & 8191;
                        int shift14 = 13;
                        while (true) {
                            i2++;
                            next = info.charAt(i2);
                            if (next < 55296) {
                                break;
                            }
                            result14 |= (next & 8191) << shift14;
                            shift14 += 13;
                        }
                        next28 = result14 | (next << shift14);
                    }
                    int index3 = (oneofCount * 2) + (next28 / 32);
                    Object o3 = messageInfoObjects[index3];
                    if (o3 instanceof Field) {
                        hasBitsField = (Field) o3;
                    } else {
                        hasBitsField = reflectField(messageClass, (String) o3);
                        messageInfoObjects[index3] = hasBitsField;
                    }
                    presenceFieldOffset = (int) unsafe.objectFieldOffset(hasBitsField);
                    presenceMaskShift = next28 % 32;
                }
                if (fieldType >= 18 && fieldType <= 49) {
                    repeatedFieldIndex++;
                    intArray[repeatedFieldIndex] = fieldOffset;
                }
            }
            int bufferIndex2 = bufferIndex + 1;
            buffer[bufferIndex] = next25;
            int bufferIndex3 = bufferIndex2 + 1;
            buffer[bufferIndex2] = ((next26 & 512) != 0 ? 536870912 : 0) | ((next26 & 256) != 0 ? REQUIRED_MASK : 0) | (fieldType << 20) | fieldOffset;
            bufferIndex = bufferIndex3 + 1;
            buffer[bufferIndex3] = (presenceMaskShift << 20) | presenceFieldOffset;
        }
        return new MessageSchema<>(buffer, objects, minFieldNumber, maxFieldNumber, messageInfo.getDefaultInstance(), isProto3, false, intArray, checkInitialized, checkInitialized + mapFieldCount, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private static Field reflectField(Class<?> messageClass, String fieldName) {
        try {
            return messageClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Field[] fields = messageClass.getDeclaredFields();
            for (Field field : fields) {
                if (fieldName.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + fieldName + " for " + messageClass.getName() + " not found. Known fields are " + Arrays.toString(fields));
        }
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int maxFieldNumber;
        int minFieldNumber;
        boolean isProto3 = messageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fis = messageInfo.getFields();
        if (fis.length == 0) {
            minFieldNumber = 0;
            maxFieldNumber = 0;
        } else {
            minFieldNumber = fis[0].getFieldNumber();
            maxFieldNumber = fis[fis.length - 1].getFieldNumber();
        }
        int numEntries = fis.length;
        int[] buffer = new int[numEntries * 3];
        Object[] objects = new Object[numEntries * 2];
        int mapFieldCount = 0;
        int repeatedFieldCount = 0;
        for (FieldInfo fi : fis) {
            if (fi.getType() == FieldType.MAP) {
                mapFieldCount++;
            } else if (fi.getType().m1293id() >= 18 && fi.getType().m1293id() <= 49) {
                repeatedFieldCount++;
            }
        }
        int[] mapFieldPositions = mapFieldCount > 0 ? new int[mapFieldCount] : null;
        int[] repeatedFieldOffsets = repeatedFieldCount > 0 ? new int[repeatedFieldCount] : null;
        int mapFieldCount2 = 0;
        int repeatedFieldCount2 = 0;
        int[] checkInitialized = messageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int checkInitializedIndex = 0;
        int fieldIndex = 0;
        int bufferIndex = 0;
        while (fieldIndex < fis.length) {
            FieldInfo fi2 = fis[fieldIndex];
            int fieldNumber = fi2.getFieldNumber();
            storeFieldData(fi2, buffer, bufferIndex, objects);
            if (checkInitializedIndex < checkInitialized.length && checkInitialized[checkInitializedIndex] == fieldNumber) {
                checkInitializedIndex++;
                checkInitialized[checkInitializedIndex] = bufferIndex;
            }
            if (fi2.getType() == FieldType.MAP) {
                mapFieldCount2++;
                mapFieldPositions[mapFieldCount2] = bufferIndex;
            } else if (fi2.getType().m1293id() >= 18 && fi2.getType().m1293id() <= 49) {
                repeatedFieldCount2++;
                repeatedFieldOffsets[repeatedFieldCount2] = (int) UnsafeUtil.objectFieldOffset(fi2.getField());
            }
            fieldIndex++;
            bufferIndex += 3;
        }
        if (mapFieldPositions == null) {
            mapFieldPositions = EMPTY_INT_ARRAY;
        }
        if (repeatedFieldOffsets == null) {
            repeatedFieldOffsets = EMPTY_INT_ARRAY;
        }
        int[] combined = new int[checkInitialized.length + mapFieldPositions.length + repeatedFieldOffsets.length];
        System.arraycopy(checkInitialized, 0, combined, 0, checkInitialized.length);
        System.arraycopy(mapFieldPositions, 0, combined, checkInitialized.length, mapFieldPositions.length);
        System.arraycopy(repeatedFieldOffsets, 0, combined, checkInitialized.length + mapFieldPositions.length, repeatedFieldOffsets.length);
        return new MessageSchema<>(buffer, objects, minFieldNumber, maxFieldNumber, messageInfo.getDefaultInstance(), isProto3, true, combined, checkInitialized.length, checkInitialized.length + mapFieldPositions.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private static void storeFieldData(FieldInfo fi, int[] buffer, int bufferIndex, Object[] objects) {
        int presenceFieldOffset;
        int presenceMaskShift;
        int typeId;
        int fieldOffset;
        OneofInfo oneof = fi.getOneof();
        if (oneof != null) {
            typeId = fi.getType().m1293id() + 51;
            fieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
            presenceFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getCaseField());
            presenceMaskShift = 0;
        } else {
            FieldType type = fi.getType();
            fieldOffset = (int) UnsafeUtil.objectFieldOffset(fi.getField());
            typeId = type.m1293id();
            if (!type.isList() && !type.isMap()) {
                Field presenceField = fi.getPresenceField();
                if (presenceField == null) {
                    presenceFieldOffset = 1048575;
                } else {
                    presenceFieldOffset = (int) UnsafeUtil.objectFieldOffset(presenceField);
                }
                presenceMaskShift = Integer.numberOfTrailingZeros(fi.getPresenceMask());
            } else if (fi.getCachedSizeField() == null) {
                presenceFieldOffset = 0;
                presenceMaskShift = 0;
            } else {
                presenceFieldOffset = (int) UnsafeUtil.objectFieldOffset(fi.getCachedSizeField());
                presenceMaskShift = 0;
            }
        }
        buffer[bufferIndex] = fi.getFieldNumber();
        buffer[bufferIndex + 1] = (fi.isEnforceUtf8() ? 536870912 : 0) | (fi.isRequired() ? REQUIRED_MASK : 0) | (typeId << 20) | fieldOffset;
        buffer[bufferIndex + 2] = (presenceMaskShift << 20) | presenceFieldOffset;
        Object messageFieldClass = fi.getMessageFieldClass();
        if (fi.getMapDefaultEntry() != null) {
            objects[(bufferIndex / 3) * 2] = fi.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objects[((bufferIndex / 3) * 2) + 1] = messageFieldClass;
            } else if (fi.getEnumVerifier() != null) {
                objects[((bufferIndex / 3) * 2) + 1] = fi.getEnumVerifier();
            }
        } else if (messageFieldClass != null) {
            objects[((bufferIndex / 3) * 2) + 1] = messageFieldClass;
        } else if (fi.getEnumVerifier() != null) {
            objects[((bufferIndex / 3) * 2) + 1] = fi.getEnumVerifier();
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T message, T other) {
        int bufferLength = this.buffer.length;
        for (int pos = 0; pos < bufferLength; pos += 3) {
            if (!equals(message, other, pos)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(message).equals(this.unknownFieldSchema.getFromMessage(other))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(message).equals(this.extensionSchema.getExtensions(other));
        }
        return true;
    }

    private boolean equals(T message, T other, int pos) {
        int typeAndOffset = typeAndOffsetAt(pos);
        long offset = offset(typeAndOffset);
        switch (type(typeAndOffset)) {
            case 0:
                return arePresentForEquals(message, other, pos) && Double.doubleToLongBits(UnsafeUtil.getDouble(message, offset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(other, offset));
            case 1:
                return arePresentForEquals(message, other, pos) && Float.floatToIntBits(UnsafeUtil.getFloat(message, offset)) == Float.floatToIntBits(UnsafeUtil.getFloat(other, offset));
            case 2:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset);
            case 3:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset);
            case 4:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset);
            case 5:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset);
            case 6:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset);
            case 7:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getBoolean(message, offset) == UnsafeUtil.getBoolean(other, offset);
            case 8:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            case 9:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            case 10:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            case 11:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset);
            case 12:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset);
            case 13:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset);
            case 14:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset);
            case 15:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset);
            case 16:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset);
            case 17:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                return isOneofCaseEqual(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            default:
                return true;
        }
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T message) {
        int hashCode = 0;
        int bufferLength = this.buffer.length;
        for (int pos = 0; pos < bufferLength; pos += 3) {
            int typeAndOffset = typeAndOffsetAt(pos);
            int entryNumber = numberAt(pos);
            long offset = offset(typeAndOffset);
            switch (type(typeAndOffset)) {
                case 0:
                    hashCode = (hashCode * 53) + Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(message, offset)));
                    break;
                case 1:
                    hashCode = (hashCode * 53) + Float.floatToIntBits(UnsafeUtil.getFloat(message, offset));
                    break;
                case 2:
                    hashCode = (hashCode * 53) + Internal.hashLong(UnsafeUtil.getLong(message, offset));
                    break;
                case 3:
                    hashCode = (hashCode * 53) + Internal.hashLong(UnsafeUtil.getLong(message, offset));
                    break;
                case 4:
                    hashCode = (hashCode * 53) + UnsafeUtil.getInt(message, offset);
                    break;
                case 5:
                    hashCode = (hashCode * 53) + Internal.hashLong(UnsafeUtil.getLong(message, offset));
                    break;
                case 6:
                    hashCode = (hashCode * 53) + UnsafeUtil.getInt(message, offset);
                    break;
                case 7:
                    hashCode = (hashCode * 53) + Internal.hashBoolean(UnsafeUtil.getBoolean(message, offset));
                    break;
                case 8:
                    hashCode = (hashCode * 53) + ((String) UnsafeUtil.getObject(message, offset)).hashCode();
                    break;
                case 9:
                    int protoHash = 37;
                    Object submessage = UnsafeUtil.getObject(message, offset);
                    if (submessage != null) {
                        protoHash = submessage.hashCode();
                    }
                    hashCode = (53 * hashCode) + protoHash;
                    break;
                case 10:
                    hashCode = (hashCode * 53) + UnsafeUtil.getObject(message, offset).hashCode();
                    break;
                case 11:
                    hashCode = (hashCode * 53) + UnsafeUtil.getInt(message, offset);
                    break;
                case 12:
                    hashCode = (hashCode * 53) + UnsafeUtil.getInt(message, offset);
                    break;
                case 13:
                    hashCode = (hashCode * 53) + UnsafeUtil.getInt(message, offset);
                    break;
                case 14:
                    hashCode = (hashCode * 53) + Internal.hashLong(UnsafeUtil.getLong(message, offset));
                    break;
                case 15:
                    hashCode = (hashCode * 53) + UnsafeUtil.getInt(message, offset);
                    break;
                case 16:
                    hashCode = (hashCode * 53) + Internal.hashLong(UnsafeUtil.getLong(message, offset));
                    break;
                case 17:
                    int protoHash2 = 37;
                    Object submessage2 = UnsafeUtil.getObject(message, offset);
                    if (submessage2 != null) {
                        protoHash2 = submessage2.hashCode();
                    }
                    hashCode = (53 * hashCode) + protoHash2;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    hashCode = (hashCode * 53) + UnsafeUtil.getObject(message, offset).hashCode();
                    break;
                case 50:
                    hashCode = (hashCode * 53) + UnsafeUtil.getObject(message, offset).hashCode();
                    break;
                case 51:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(message, offset)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + Float.floatToIntBits(oneofFloatAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + Internal.hashLong(oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + Internal.hashLong(oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + oneofIntAt(message, offset);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + Internal.hashLong(oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + oneofIntAt(message, offset);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + Internal.hashBoolean(oneofBooleanAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + ((String) UnsafeUtil.getObject(message, offset)).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (53 * hashCode) + UnsafeUtil.getObject(message, offset).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + UnsafeUtil.getObject(message, offset).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + oneofIntAt(message, offset);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + oneofIntAt(message, offset);
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + oneofIntAt(message, offset);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + Internal.hashLong(oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + oneofIntAt(message, offset);
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (hashCode * 53) + Internal.hashLong(oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(message, entryNumber, pos)) {
                        hashCode = (53 * hashCode) + UnsafeUtil.getObject(message, offset).hashCode();
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode2 = (hashCode * 53) + this.unknownFieldSchema.getFromMessage(message).hashCode();
        if (this.hasExtensions) {
            hashCode2 = (hashCode2 * 53) + this.extensionSchema.getExtensions(message).hashCode();
        }
        return hashCode2;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T message, T other) {
        if (other == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(message, other, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, message, other);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, message, other);
        }
    }

    private void mergeSingleField(T message, T other, int pos) {
        int typeAndOffset = typeAndOffsetAt(pos);
        long offset = offset(typeAndOffset);
        int number = numberAt(pos);
        switch (type(typeAndOffset)) {
            case 0:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putDouble(message, offset, UnsafeUtil.getDouble(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putFloat(message, offset, UnsafeUtil.getFloat(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putBoolean(message, offset, UnsafeUtil.getBoolean(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 8:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putObject(message, offset, UnsafeUtil.getObject(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 9:
                mergeMessage(message, other, pos);
                return;
            case 10:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putObject(message, offset, UnsafeUtil.getObject(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 12:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 15:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 17:
                mergeMessage(message, other, pos);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(message, other, offset);
                return;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, message, other, offset);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(other, number, pos)) {
                    UnsafeUtil.putObject(message, offset, UnsafeUtil.getObject(other, offset));
                    setOneofPresent(message, number, pos);
                    return;
                }
                return;
            case 60:
                mergeOneofMessage(message, other, pos);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(other, number, pos)) {
                    UnsafeUtil.putObject(message, offset, UnsafeUtil.getObject(other, offset));
                    setOneofPresent(message, number, pos);
                    return;
                }
                return;
            case 68:
                mergeOneofMessage(message, other, pos);
                return;
            default:
                return;
        }
    }

    private void mergeMessage(T message, T other, int pos) {
        long offset = offset(typeAndOffsetAt(pos));
        if (isFieldPresent(other, pos)) {
            Object mine = UnsafeUtil.getObject(message, offset);
            Object theirs = UnsafeUtil.getObject(other, offset);
            if (mine != null && theirs != null) {
                UnsafeUtil.putObject(message, offset, Internal.mergeMessage(mine, theirs));
                setFieldPresent(message, pos);
            } else if (theirs != null) {
                UnsafeUtil.putObject(message, offset, theirs);
                setFieldPresent(message, pos);
            }
        }
    }

    private void mergeOneofMessage(T message, T other, int pos) {
        int typeAndOffset = typeAndOffsetAt(pos);
        int number = numberAt(pos);
        long offset = offset(typeAndOffset);
        if (isOneofPresent(other, number, pos)) {
            Object mine = null;
            if (isOneofPresent(message, number, pos)) {
                mine = UnsafeUtil.getObject(message, offset);
            }
            Object theirs = UnsafeUtil.getObject(other, offset);
            if (mine != null && theirs != null) {
                UnsafeUtil.putObject(message, offset, Internal.mergeMessage(mine, theirs));
                setOneofPresent(message, number, pos);
            } else if (theirs != null) {
                UnsafeUtil.putObject(message, offset, theirs);
                setOneofPresent(message, number, pos);
            }
        }
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T message) {
        return this.proto3 ? getSerializedSizeProto3(message) : getSerializedSizeProto2(message);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: com.google.protobuf.UnknownFieldSchema<?, ?>, com.google.protobuf.UnknownFieldSchema<UT, UB> */
    private int getSerializedSizeProto2(T message) {
        int size = 0;
        Unsafe unsafe = UNSAFE;
        int currentPresenceFieldOffset = 1048575;
        int currentPresenceField = 0;
        for (int i = 0; i < this.buffer.length; i += 3) {
            int typeAndOffset = typeAndOffsetAt(i);
            int number = numberAt(i);
            int fieldType = type(typeAndOffset);
            int presenceMaskAndOffset = 0;
            int presenceMask = 0;
            if (fieldType <= 17) {
                presenceMaskAndOffset = this.buffer[i + 2];
                int presenceFieldOffset = presenceMaskAndOffset & 1048575;
                presenceMask = 1 << (presenceMaskAndOffset >>> 20);
                if (presenceFieldOffset != currentPresenceFieldOffset) {
                    currentPresenceFieldOffset = presenceFieldOffset;
                    currentPresenceField = unsafe.getInt(message, (long) presenceFieldOffset);
                }
            } else if (this.useCachedSizeField && fieldType >= FieldType.DOUBLE_LIST_PACKED.m1293id() && fieldType <= FieldType.SINT64_LIST_PACKED.m1293id()) {
                presenceMaskAndOffset = this.buffer[i + 2] & 1048575;
            }
            long offset = offset(typeAndOffset);
            switch (fieldType) {
                case 0:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeDoubleSize(number, 0.0d);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeFloatSize(number, 0.0f);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeInt64Size(number, unsafe.getLong(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeUInt64Size(number, unsafe.getLong(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeInt32Size(number, unsafe.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeFixed64Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeFixed32Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeBoolSize(number, true);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((currentPresenceField & presenceMask) != 0) {
                        Object value = unsafe.getObject(message, offset);
                        if (value instanceof ByteString) {
                            size += CodedOutputStream.computeBytesSize(number, (ByteString) value);
                            break;
                        } else {
                            size += CodedOutputStream.computeStringSize(number, (String) value);
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += SchemaUtil.computeSizeMessage(number, unsafe.getObject(message, offset), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeBytesSize(number, (ByteString) unsafe.getObject(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeUInt32Size(number, unsafe.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeEnumSize(number, unsafe.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeSFixed32Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeSFixed64Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeSInt32Size(number, unsafe.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeSInt64Size(number, unsafe.getLong(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((currentPresenceField & presenceMask) != 0) {
                        size += CodedOutputStream.computeGroupSize(number, (MessageLite) unsafe.getObject(message, offset), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    size += SchemaUtil.computeSizeFixed64List(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 19:
                    size += SchemaUtil.computeSizeFixed32List(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 20:
                    size += SchemaUtil.computeSizeInt64List(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 21:
                    size += SchemaUtil.computeSizeUInt64List(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 22:
                    size += SchemaUtil.computeSizeInt32List(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 23:
                    size += SchemaUtil.computeSizeFixed64List(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 24:
                    size += SchemaUtil.computeSizeFixed32List(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 25:
                    size += SchemaUtil.computeSizeBoolList(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 26:
                    size += SchemaUtil.computeSizeStringList(number, (List) unsafe.getObject(message, offset));
                    break;
                case 27:
                    size += SchemaUtil.computeSizeMessageList(number, (List) unsafe.getObject(message, offset), getMessageFieldSchema(i));
                    break;
                case 28:
                    size += SchemaUtil.computeSizeByteStringList(number, (List) unsafe.getObject(message, offset));
                    break;
                case 29:
                    size += SchemaUtil.computeSizeUInt32List(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 30:
                    size += SchemaUtil.computeSizeEnumList(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 31:
                    size += SchemaUtil.computeSizeFixed32List(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 32:
                    size += SchemaUtil.computeSizeFixed64List(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 33:
                    size += SchemaUtil.computeSizeSInt32List(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 34:
                    size += SchemaUtil.computeSizeSInt64List(number, (List) unsafe.getObject(message, offset), false);
                    break;
                case 35:
                    int fieldSize = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize) + fieldSize;
                        break;
                    }
                case 36:
                    int fieldSize2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize2 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize2);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize2) + fieldSize2;
                        break;
                    }
                case 37:
                    int fieldSize3 = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize3 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize3);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize3) + fieldSize3;
                        break;
                    }
                case 38:
                    int fieldSize4 = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize4 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize4);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize4) + fieldSize4;
                        break;
                    }
                case 39:
                    int fieldSize5 = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize5 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize5);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize5) + fieldSize5;
                        break;
                    }
                case 40:
                    int fieldSize6 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize6 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize6);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize6) + fieldSize6;
                        break;
                    }
                case 41:
                    int fieldSize7 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize7 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize7);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize7) + fieldSize7;
                        break;
                    }
                case 42:
                    int fieldSize8 = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize8 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize8);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize8) + fieldSize8;
                        break;
                    }
                case 43:
                    int fieldSize9 = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize9 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize9);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize9) + fieldSize9;
                        break;
                    }
                case 44:
                    int fieldSize10 = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize10 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize10);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize10) + fieldSize10;
                        break;
                    }
                case 45:
                    int fieldSize11 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize11 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize11);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize11) + fieldSize11;
                        break;
                    }
                case 46:
                    int fieldSize12 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize12 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize12);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize12) + fieldSize12;
                        break;
                    }
                case 47:
                    int fieldSize13 = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize13 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize13);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize13) + fieldSize13;
                        break;
                    }
                case 48:
                    int fieldSize14 = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize14 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) presenceMaskAndOffset, fieldSize14);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize14) + fieldSize14;
                        break;
                    }
                case 49:
                    size += SchemaUtil.computeSizeGroupList(number, (List) unsafe.getObject(message, offset), getMessageFieldSchema(i));
                    break;
                case 50:
                    size += this.mapFieldSchema.getSerializedSize(number, unsafe.getObject(message, offset), getMapFieldDefaultEntry(i));
                    break;
                case 51:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeDoubleSize(number, 0.0d);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeFloatSize(number, 0.0f);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeInt64Size(number, oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeUInt64Size(number, oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeInt32Size(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeFixed64Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeFixed32Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeBoolSize(number, true);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(message, number, i)) {
                        Object value2 = unsafe.getObject(message, offset);
                        if (value2 instanceof ByteString) {
                            size += CodedOutputStream.computeBytesSize(number, (ByteString) value2);
                            break;
                        } else {
                            size += CodedOutputStream.computeStringSize(number, (String) value2);
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(message, number, i)) {
                        size += SchemaUtil.computeSizeMessage(number, unsafe.getObject(message, offset), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeBytesSize(number, (ByteString) unsafe.getObject(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeUInt32Size(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeEnumSize(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeSFixed32Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeSFixed64Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeSInt32Size(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeSInt64Size(number, oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeGroupSize(number, (MessageLite) unsafe.getObject(message, offset), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
            }
        }
        int size2 = size + getUnknownFieldsSerializedSize(this.unknownFieldSchema, message);
        if (this.hasExtensions) {
            size2 += this.extensionSchema.getExtensions(message).getSerializedSize();
        }
        return size2;
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: com.google.protobuf.UnknownFieldSchema<?, ?>, com.google.protobuf.UnknownFieldSchema<UT, UB> */
    private int getSerializedSizeProto3(T message) {
        Unsafe unsafe = UNSAFE;
        int size = 0;
        for (int i = 0; i < this.buffer.length; i += 3) {
            int typeAndOffset = typeAndOffsetAt(i);
            int fieldType = type(typeAndOffset);
            int number = numberAt(i);
            long offset = offset(typeAndOffset);
            int cachedSizeOffset = (fieldType < FieldType.DOUBLE_LIST_PACKED.m1293id() || fieldType > FieldType.SINT64_LIST_PACKED.m1293id()) ? 0 : this.buffer[i + 2] & 1048575;
            switch (fieldType) {
                case 0:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeDoubleSize(number, 0.0d);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeFloatSize(number, 0.0f);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeInt64Size(number, UnsafeUtil.getLong(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeUInt64Size(number, UnsafeUtil.getLong(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeInt32Size(number, UnsafeUtil.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeFixed64Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeFixed32Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeBoolSize(number, true);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(message, i)) {
                        Object value = UnsafeUtil.getObject(message, offset);
                        if (value instanceof ByteString) {
                            size += CodedOutputStream.computeBytesSize(number, (ByteString) value);
                            break;
                        } else {
                            size += CodedOutputStream.computeStringSize(number, (String) value);
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(message, i)) {
                        size += SchemaUtil.computeSizeMessage(number, UnsafeUtil.getObject(message, offset), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeBytesSize(number, (ByteString) UnsafeUtil.getObject(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeUInt32Size(number, UnsafeUtil.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeEnumSize(number, UnsafeUtil.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeSFixed32Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeSFixed64Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeSInt32Size(number, UnsafeUtil.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeSInt64Size(number, UnsafeUtil.getLong(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(message, i)) {
                        size += CodedOutputStream.computeGroupSize(number, (MessageLite) UnsafeUtil.getObject(message, offset), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    size += SchemaUtil.computeSizeFixed64List(number, listAt(message, offset), false);
                    break;
                case 19:
                    size += SchemaUtil.computeSizeFixed32List(number, listAt(message, offset), false);
                    break;
                case 20:
                    size += SchemaUtil.computeSizeInt64List(number, listAt(message, offset), false);
                    break;
                case 21:
                    size += SchemaUtil.computeSizeUInt64List(number, listAt(message, offset), false);
                    break;
                case 22:
                    size += SchemaUtil.computeSizeInt32List(number, listAt(message, offset), false);
                    break;
                case 23:
                    size += SchemaUtil.computeSizeFixed64List(number, listAt(message, offset), false);
                    break;
                case 24:
                    size += SchemaUtil.computeSizeFixed32List(number, listAt(message, offset), false);
                    break;
                case 25:
                    size += SchemaUtil.computeSizeBoolList(number, listAt(message, offset), false);
                    break;
                case 26:
                    size += SchemaUtil.computeSizeStringList(number, listAt(message, offset));
                    break;
                case 27:
                    size += SchemaUtil.computeSizeMessageList(number, listAt(message, offset), getMessageFieldSchema(i));
                    break;
                case 28:
                    size += SchemaUtil.computeSizeByteStringList(number, listAt(message, offset));
                    break;
                case 29:
                    size += SchemaUtil.computeSizeUInt32List(number, listAt(message, offset), false);
                    break;
                case 30:
                    size += SchemaUtil.computeSizeEnumList(number, listAt(message, offset), false);
                    break;
                case 31:
                    size += SchemaUtil.computeSizeFixed32List(number, listAt(message, offset), false);
                    break;
                case 32:
                    size += SchemaUtil.computeSizeFixed64List(number, listAt(message, offset), false);
                    break;
                case 33:
                    size += SchemaUtil.computeSizeSInt32List(number, listAt(message, offset), false);
                    break;
                case 34:
                    size += SchemaUtil.computeSizeSInt64List(number, listAt(message, offset), false);
                    break;
                case 35:
                    int fieldSize = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize) + fieldSize;
                        break;
                    }
                case 36:
                    int fieldSize2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize2 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize2);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize2) + fieldSize2;
                        break;
                    }
                case 37:
                    int fieldSize3 = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize3 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize3);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize3) + fieldSize3;
                        break;
                    }
                case 38:
                    int fieldSize4 = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize4 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize4);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize4) + fieldSize4;
                        break;
                    }
                case 39:
                    int fieldSize5 = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize5 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize5);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize5) + fieldSize5;
                        break;
                    }
                case 40:
                    int fieldSize6 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize6 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize6);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize6) + fieldSize6;
                        break;
                    }
                case 41:
                    int fieldSize7 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize7 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize7);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize7) + fieldSize7;
                        break;
                    }
                case 42:
                    int fieldSize8 = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize8 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize8);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize8) + fieldSize8;
                        break;
                    }
                case 43:
                    int fieldSize9 = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize9 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize9);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize9) + fieldSize9;
                        break;
                    }
                case 44:
                    int fieldSize10 = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize10 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize10);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize10) + fieldSize10;
                        break;
                    }
                case 45:
                    int fieldSize11 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize11 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize11);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize11) + fieldSize11;
                        break;
                    }
                case 46:
                    int fieldSize12 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize12 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize12);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize12) + fieldSize12;
                        break;
                    }
                case 47:
                    int fieldSize13 = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize13 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize13);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize13) + fieldSize13;
                        break;
                    }
                case 48:
                    int fieldSize14 = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(message, offset));
                    if (fieldSize14 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, (long) cachedSizeOffset, fieldSize14);
                        }
                        size += CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize14) + fieldSize14;
                        break;
                    }
                case 49:
                    size += SchemaUtil.computeSizeGroupList(number, listAt(message, offset), getMessageFieldSchema(i));
                    break;
                case 50:
                    size += this.mapFieldSchema.getSerializedSize(number, UnsafeUtil.getObject(message, offset), getMapFieldDefaultEntry(i));
                    break;
                case 51:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeDoubleSize(number, 0.0d);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeFloatSize(number, 0.0f);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeInt64Size(number, oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeUInt64Size(number, oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeInt32Size(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeFixed64Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeFixed32Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeBoolSize(number, true);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(message, number, i)) {
                        Object value2 = UnsafeUtil.getObject(message, offset);
                        if (value2 instanceof ByteString) {
                            size += CodedOutputStream.computeBytesSize(number, (ByteString) value2);
                            break;
                        } else {
                            size += CodedOutputStream.computeStringSize(number, (String) value2);
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(message, number, i)) {
                        size += SchemaUtil.computeSizeMessage(number, UnsafeUtil.getObject(message, offset), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeBytesSize(number, (ByteString) UnsafeUtil.getObject(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeUInt32Size(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeEnumSize(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeSFixed32Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeSFixed64Size(number, 0);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeSInt32Size(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeSInt64Size(number, oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(message, number, i)) {
                        size += CodedOutputStream.computeGroupSize(number, (MessageLite) UnsafeUtil.getObject(message, offset), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
            }
        }
        return size + getUnknownFieldsSerializedSize(this.unknownFieldSchema, message);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> schema, T message) {
        return schema.getSerializedSize(schema.getFromMessage(message));
    }

    private static List<?> listAt(Object message, long offset) {
        return (List) UnsafeUtil.getObject(message, offset);
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T message, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(message, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(message, writer);
        } else {
            writeFieldsInAscendingOrderProto2(message, writer);
        }
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: com.google.protobuf.UnknownFieldSchema<?, ?>, com.google.protobuf.UnknownFieldSchema<UT, UB> */
    private void writeFieldsInAscendingOrderProto2(T message, Writer writer) throws IOException {
        Iterator<? extends Map.Entry<?, ?>> extensionIterator = null;
        Map.Entry<?, Object> nextExtension = null;
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(message);
            if (!extensions.isEmpty()) {
                extensionIterator = extensions.iterator();
                nextExtension = extensionIterator.next();
            }
        }
        int currentPresenceFieldOffset = 1048575;
        int currentPresenceField = 0;
        int bufferLength = this.buffer.length;
        Unsafe unsafe = UNSAFE;
        for (int pos = 0; pos < bufferLength; pos += 3) {
            int typeAndOffset = typeAndOffsetAt(pos);
            int number = numberAt(pos);
            int fieldType = type(typeAndOffset);
            int presenceMask = 0;
            if (fieldType <= 17) {
                int presenceMaskAndOffset = this.buffer[pos + 2];
                int presenceFieldOffset = presenceMaskAndOffset & 1048575;
                if (presenceFieldOffset != currentPresenceFieldOffset) {
                    currentPresenceFieldOffset = presenceFieldOffset;
                    currentPresenceField = unsafe.getInt(message, (long) presenceFieldOffset);
                }
                presenceMask = 1 << (presenceMaskAndOffset >>> 20);
            }
            while (nextExtension != null && this.extensionSchema.extensionNumber(nextExtension) <= number) {
                this.extensionSchema.serializeExtension(writer, nextExtension);
                nextExtension = extensionIterator.hasNext() ? extensionIterator.next() : null;
            }
            long offset = offset(typeAndOffset);
            switch (fieldType) {
                case 0:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeDouble(number, doubleAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeFloat(number, floatAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeInt64(number, unsafe.getLong(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeUInt64(number, unsafe.getLong(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeInt32(number, unsafe.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeFixed64(number, unsafe.getLong(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeFixed32(number, unsafe.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeBool(number, booleanAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writeString(number, unsafe.getObject(message, offset), writer);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeMessage(number, unsafe.getObject(message, offset), getMessageFieldSchema(pos));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeBytes(number, (ByteString) unsafe.getObject(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeUInt32(number, unsafe.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeEnum(number, unsafe.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeSFixed32(number, unsafe.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeSFixed64(number, unsafe.getLong(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeSInt32(number, unsafe.getInt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeSInt64(number, unsafe.getLong(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((currentPresenceField & presenceMask) != 0) {
                        writer.writeGroup(number, unsafe.getObject(message, offset), getMessageFieldSchema(pos));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(pos), (List) unsafe.getObject(message, offset), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, getMessageFieldSchema(pos));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(pos), (List) unsafe.getObject(message, offset), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, getMessageFieldSchema(pos));
                    break;
                case 50:
                    writeMapHelper(writer, number, unsafe.getObject(message, offset), pos);
                    break;
                case 51:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeDouble(number, oneofDoubleAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeFloat(number, oneofFloatAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeInt64(number, oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeUInt64(number, oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeInt32(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeFixed64(number, oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeFixed32(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeBool(number, oneofBooleanAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(message, number, pos)) {
                        writeString(number, unsafe.getObject(message, offset), writer);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeMessage(number, unsafe.getObject(message, offset), getMessageFieldSchema(pos));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeBytes(number, (ByteString) unsafe.getObject(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeUInt32(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeEnum(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeSFixed32(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeSFixed64(number, oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeSInt32(number, oneofIntAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeSInt64(number, oneofLongAt(message, offset));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeGroup(number, unsafe.getObject(message, offset), getMessageFieldSchema(pos));
                        break;
                    } else {
                        break;
                    }
            }
        }
        while (nextExtension != null) {
            this.extensionSchema.serializeExtension(writer, nextExtension);
            nextExtension = extensionIterator.hasNext() ? extensionIterator.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: com.google.protobuf.UnknownFieldSchema<?, ?>, com.google.protobuf.UnknownFieldSchema<UT, UB> */
    private void writeFieldsInAscendingOrderProto3(T message, Writer writer) throws IOException {
        Iterator<? extends Map.Entry<?, ?>> extensionIterator = null;
        Map.Entry<?, Object> nextExtension = null;
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(message);
            if (!extensions.isEmpty()) {
                extensionIterator = extensions.iterator();
                nextExtension = extensionIterator.next();
            }
        }
        int bufferLength = this.buffer.length;
        for (int pos = 0; pos < bufferLength; pos += 3) {
            int typeAndOffset = typeAndOffsetAt(pos);
            int number = numberAt(pos);
            while (nextExtension != null && this.extensionSchema.extensionNumber(nextExtension) <= number) {
                this.extensionSchema.serializeExtension(writer, nextExtension);
                nextExtension = extensionIterator.hasNext() ? extensionIterator.next() : null;
            }
            switch (type(typeAndOffset)) {
                case 0:
                    if (isFieldPresent(message, pos)) {
                        writer.writeDouble(number, doubleAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(message, pos)) {
                        writer.writeFloat(number, floatAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(message, pos)) {
                        writer.writeInt64(number, longAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(message, pos)) {
                        writer.writeUInt64(number, longAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(message, pos)) {
                        writer.writeInt32(number, intAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(message, pos)) {
                        writer.writeFixed64(number, longAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(message, pos)) {
                        writer.writeFixed32(number, intAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(message, pos)) {
                        writer.writeBool(number, booleanAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(message, pos)) {
                        writeString(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(message, pos)) {
                        writer.writeMessage(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), getMessageFieldSchema(pos));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(message, pos)) {
                        writer.writeBytes(number, (ByteString) UnsafeUtil.getObject(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(message, pos)) {
                        writer.writeUInt32(number, intAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(message, pos)) {
                        writer.writeEnum(number, intAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(message, pos)) {
                        writer.writeSFixed32(number, intAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(message, pos)) {
                        writer.writeSFixed64(number, longAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(message, pos)) {
                        writer.writeSInt32(number, intAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(message, pos)) {
                        writer.writeSInt64(number, longAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(message, pos)) {
                        writer.writeGroup(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), getMessageFieldSchema(pos));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, getMessageFieldSchema(pos));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, getMessageFieldSchema(pos));
                    break;
                case 50:
                    writeMapHelper(writer, number, UnsafeUtil.getObject(message, offset(typeAndOffset)), pos);
                    break;
                case 51:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeDouble(number, oneofDoubleAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeFloat(number, oneofFloatAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeInt64(number, oneofLongAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeUInt64(number, oneofLongAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeInt32(number, oneofIntAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeFixed64(number, oneofLongAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeFixed32(number, oneofIntAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeBool(number, oneofBooleanAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(message, number, pos)) {
                        writeString(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeMessage(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), getMessageFieldSchema(pos));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeBytes(number, (ByteString) UnsafeUtil.getObject(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeUInt32(number, oneofIntAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeEnum(number, oneofIntAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeSFixed32(number, oneofIntAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeSFixed64(number, oneofLongAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeSInt32(number, oneofIntAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeSInt64(number, oneofLongAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeGroup(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), getMessageFieldSchema(pos));
                        break;
                    } else {
                        break;
                    }
            }
        }
        while (nextExtension != null) {
            this.extensionSchema.serializeExtension(writer, nextExtension);
            nextExtension = extensionIterator.hasNext() ? extensionIterator.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: com.google.protobuf.UnknownFieldSchema<?, ?>, com.google.protobuf.UnknownFieldSchema<UT, UB> */
    private void writeFieldsInDescendingOrder(T message, Writer writer) throws IOException {
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
        Iterator<? extends Map.Entry<?, ?>> extensionIterator = null;
        Map.Entry<?, Object> nextExtension = null;
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(message);
            if (!extensions.isEmpty()) {
                extensionIterator = extensions.descendingIterator();
                nextExtension = extensionIterator.next();
            }
        }
        for (int pos = this.buffer.length - 3; pos >= 0; pos -= 3) {
            int typeAndOffset = typeAndOffsetAt(pos);
            int number = numberAt(pos);
            while (nextExtension != null && this.extensionSchema.extensionNumber(nextExtension) > number) {
                this.extensionSchema.serializeExtension(writer, nextExtension);
                nextExtension = extensionIterator.hasNext() ? extensionIterator.next() : null;
            }
            switch (type(typeAndOffset)) {
                case 0:
                    if (isFieldPresent(message, pos)) {
                        writer.writeDouble(number, doubleAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(message, pos)) {
                        writer.writeFloat(number, floatAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(message, pos)) {
                        writer.writeInt64(number, longAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(message, pos)) {
                        writer.writeUInt64(number, longAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(message, pos)) {
                        writer.writeInt32(number, intAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(message, pos)) {
                        writer.writeFixed64(number, longAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(message, pos)) {
                        writer.writeFixed32(number, intAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(message, pos)) {
                        writer.writeBool(number, booleanAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(message, pos)) {
                        writeString(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(message, pos)) {
                        writer.writeMessage(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), getMessageFieldSchema(pos));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(message, pos)) {
                        writer.writeBytes(number, (ByteString) UnsafeUtil.getObject(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(message, pos)) {
                        writer.writeUInt32(number, intAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(message, pos)) {
                        writer.writeEnum(number, intAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(message, pos)) {
                        writer.writeSFixed32(number, intAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(message, pos)) {
                        writer.writeSFixed64(number, longAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(message, pos)) {
                        writer.writeSInt32(number, intAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(message, pos)) {
                        writer.writeSInt64(number, longAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(message, pos)) {
                        writer.writeGroup(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), getMessageFieldSchema(pos));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, getMessageFieldSchema(pos));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, getMessageFieldSchema(pos));
                    break;
                case 50:
                    writeMapHelper(writer, number, UnsafeUtil.getObject(message, offset(typeAndOffset)), pos);
                    break;
                case 51:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeDouble(number, oneofDoubleAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeFloat(number, oneofFloatAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeInt64(number, oneofLongAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeUInt64(number, oneofLongAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeInt32(number, oneofIntAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeFixed64(number, oneofLongAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeFixed32(number, oneofIntAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeBool(number, oneofBooleanAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(message, number, pos)) {
                        writeString(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeMessage(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), getMessageFieldSchema(pos));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeBytes(number, (ByteString) UnsafeUtil.getObject(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeUInt32(number, oneofIntAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeEnum(number, oneofIntAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeSFixed32(number, oneofIntAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeSFixed64(number, oneofLongAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeSInt32(number, oneofIntAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeSInt64(number, oneofLongAt(message, offset(typeAndOffset)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(message, number, pos)) {
                        writer.writeGroup(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), getMessageFieldSchema(pos));
                        break;
                    } else {
                        break;
                    }
            }
        }
        while (nextExtension != null) {
            this.extensionSchema.serializeExtension(writer, nextExtension);
            nextExtension = extensionIterator.hasNext() ? extensionIterator.next() : null;
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int number, Object mapField, int pos) throws IOException {
        if (mapField != null) {
            writer.writeMap(number, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(pos)), this.mapFieldSchema.forMapData(mapField));
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> schema, T message, Writer writer) throws IOException {
        schema.writeTo(schema.getFromMessage(message), writer);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: com.google.protobuf.UnknownFieldSchema<?, ?>, com.google.protobuf.UnknownFieldSchema<UT, UB> */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: com.google.protobuf.ExtensionSchema<?>, com.google.protobuf.ExtensionSchema<ET extends com.google.protobuf.FieldSet$FieldDescriptorLite<ET>> */
    @Override // com.google.protobuf.Schema
    public void mergeFrom(T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        if (extensionRegistry == null) {
            throw new NullPointerException();
        }
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, message, reader, extensionRegistry);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r0v22, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r0v29, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r0v64, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r0v75, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r0v87, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r0v110, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r0v153, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r0v172, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r0v211, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:221:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c6, code lost:
        r19 = r8.checkInitializedCount;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d1, code lost:
        if (r19 >= r8.repeatedFieldOffsetStart) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d4, code lost:
        r14 = filterMapUnknownEnumValues(r11, r8.intArray[r19], r14, r9);
        r19 = r19 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ed, code lost:
        if (r14 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f0, code lost:
        r9.setBuilderToMessage(r11, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> r9, com.google.protobuf.ExtensionSchema<ET> r10, T r11, com.google.protobuf.Reader r12, com.google.protobuf.ExtensionRegistryLite r13) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 2906
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.mergeFromHelper(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    /* access modifiers changed from: package-private */
    public static UnknownFieldSetLite getMutableUnknownFields(Object message) {
        UnknownFieldSetLite unknownFields = ((GeneratedMessageLite) message).unknownFields;
        if (unknownFields == UnknownFieldSetLite.getDefaultInstance()) {
            unknownFields = UnknownFieldSetLite.newInstance();
            ((GeneratedMessageLite) message).unknownFields = unknownFields;
        }
        return unknownFields;
    }

    private int decodeMapEntryValue(byte[] data, int position, int limit, WireFormat.FieldType fieldType, Class<?> messageType, ArrayDecoders.Registers registers) throws IOException {
        int position2;
        switch (fieldType) {
            case BOOL:
                position2 = ArrayDecoders.decodeVarint64(data, position, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                break;
            case BYTES:
                position2 = ArrayDecoders.decodeBytes(data, position, registers);
                break;
            case DOUBLE:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(data, position));
                position2 = position + 8;
                break;
            case FIXED32:
            case SFIXED32:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(data, position));
                position2 = position + 4;
                break;
            case FIXED64:
            case SFIXED64:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(data, position));
                position2 = position + 8;
                break;
            case FLOAT:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(data, position));
                position2 = position + 4;
                break;
            case ENUM:
            case INT32:
            case UINT32:
                position2 = ArrayDecoders.decodeVarint32(data, position, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                break;
            case INT64:
            case UINT64:
                position2 = ArrayDecoders.decodeVarint64(data, position, registers);
                registers.object1 = Long.valueOf(registers.long1);
                break;
            case MESSAGE:
                position2 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) messageType), data, position, limit, registers);
                break;
            case SINT32:
                position2 = ArrayDecoders.decodeVarint32(data, position, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                break;
            case SINT64:
                position2 = ArrayDecoders.decodeVarint64(data, position, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                break;
            case STRING:
                position2 = ArrayDecoders.decodeStringRequireUtf8(data, position, registers);
                break;
            default:
                throw new RuntimeException("unsupported field type.");
        }
        return position2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v36, types: [java.lang.Object] */
    private <K, V> int decodeMapEntry(byte[] data, int position, int limit, MapEntryLite.Metadata<K, V> metadata, Map<K, V> target, ArrayDecoders.Registers registers) throws IOException {
        int position2 = ArrayDecoders.decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0 || length > limit - position2) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int end = position2 + length;
        K key = metadata.defaultKey;
        V value = metadata.defaultValue;
        while (position2 < end) {
            int position3 = position2 + 1;
            int tag = data[position2];
            if (tag < 0) {
                position3 = ArrayDecoders.decodeVarint32(tag, data, position3, registers);
                tag = registers.int1;
            }
            int wireType = tag & 7;
            switch (tag >>> 3) {
                case 1:
                    if (wireType != metadata.keyType.getWireType()) {
                        break;
                    } else {
                        position2 = decodeMapEntryValue(data, position3, limit, metadata.keyType, null, registers);
                        key = registers.object1;
                        continue;
                    }
                case 2:
                    if (wireType != metadata.valueType.getWireType()) {
                        break;
                    } else {
                        position2 = decodeMapEntryValue(data, position3, limit, metadata.valueType, metadata.defaultValue.getClass(), registers);
                        value = registers.object1;
                        continue;
                    }
            }
            position2 = ArrayDecoders.skipField(tag, data, position3, limit, registers);
        }
        if (position2 != end) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        target.put(key, value);
        return end;
    }

    private int parseRepeatedField(T message, byte[] data, int position, int limit, int tag, int number, int wireType, int bufferPosition, long typeAndOffset, int fieldType, long fieldOffset, ArrayDecoders.Registers registers) throws IOException {
        Internal.ProtobufList<?> list = (Internal.ProtobufList) UNSAFE.getObject(message, fieldOffset);
        if (!list.isModifiable()) {
            int size = list.size();
            list = list.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            UNSAFE.putObject(message, fieldOffset, list);
        }
        switch (fieldType) {
            case 18:
            case 35:
                if (wireType != 2) {
                    if (wireType == 1) {
                        position = ArrayDecoders.decodeDoubleList(tag, data, position, limit, list, registers);
                        break;
                    }
                } else {
                    position = ArrayDecoders.decodePackedDoubleList(data, position, list, registers);
                    break;
                }
                break;
            case 19:
            case 36:
                if (wireType != 2) {
                    if (wireType == 5) {
                        position = ArrayDecoders.decodeFloatList(tag, data, position, limit, list, registers);
                        break;
                    }
                } else {
                    position = ArrayDecoders.decodePackedFloatList(data, position, list, registers);
                    break;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (wireType != 2) {
                    if (wireType == 0) {
                        position = ArrayDecoders.decodeVarint64List(tag, data, position, limit, list, registers);
                        break;
                    }
                } else {
                    position = ArrayDecoders.decodePackedVarint64List(data, position, list, registers);
                    break;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (wireType != 2) {
                    if (wireType == 0) {
                        position = ArrayDecoders.decodeVarint32List(tag, data, position, limit, list, registers);
                        break;
                    }
                } else {
                    position = ArrayDecoders.decodePackedVarint32List(data, position, list, registers);
                    break;
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (wireType != 2) {
                    if (wireType == 1) {
                        position = ArrayDecoders.decodeFixed64List(tag, data, position, limit, list, registers);
                        break;
                    }
                } else {
                    position = ArrayDecoders.decodePackedFixed64List(data, position, list, registers);
                    break;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (wireType != 2) {
                    if (wireType == 5) {
                        position = ArrayDecoders.decodeFixed32List(tag, data, position, limit, list, registers);
                        break;
                    }
                } else {
                    position = ArrayDecoders.decodePackedFixed32List(data, position, list, registers);
                    break;
                }
                break;
            case 25:
            case 42:
                if (wireType != 2) {
                    if (wireType == 0) {
                        position = ArrayDecoders.decodeBoolList(tag, data, position, limit, list, registers);
                        break;
                    }
                } else {
                    position = ArrayDecoders.decodePackedBoolList(data, position, list, registers);
                    break;
                }
                break;
            case 26:
                if (wireType == 2) {
                    if ((typeAndOffset & 536870912) != 0) {
                        position = ArrayDecoders.decodeStringListRequireUtf8(tag, data, position, limit, list, registers);
                        break;
                    } else {
                        position = ArrayDecoders.decodeStringList(tag, data, position, limit, list, registers);
                        break;
                    }
                }
                break;
            case 27:
                if (wireType == 2) {
                    position = ArrayDecoders.decodeMessageList(getMessageFieldSchema(bufferPosition), tag, data, position, limit, list, registers);
                    break;
                }
                break;
            case 28:
                if (wireType == 2) {
                    position = ArrayDecoders.decodeBytesList(tag, data, position, limit, list, registers);
                    break;
                }
                break;
            case 30:
            case 44:
                if (wireType == 2) {
                    position = ArrayDecoders.decodePackedVarint32List(data, position, list, registers);
                } else if (wireType == 0) {
                    position = ArrayDecoders.decodeVarint32List(tag, data, position, limit, list, registers);
                }
                UnknownFieldSetLite unknownFields = ((GeneratedMessageLite) message).unknownFields;
                if (unknownFields == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFields = null;
                }
                UnknownFieldSetLite unknownFields2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(number, (List<Integer>) list, getEnumFieldVerifier(bufferPosition), unknownFields, (UnknownFieldSchema<UT, UnknownFieldSetLite>) this.unknownFieldSchema);
                if (unknownFields2 != null) {
                    ((GeneratedMessageLite) message).unknownFields = unknownFields2;
                    break;
                }
                break;
            case 33:
            case 47:
                if (wireType != 2) {
                    if (wireType == 0) {
                        position = ArrayDecoders.decodeSInt32List(tag, data, position, limit, list, registers);
                        break;
                    }
                } else {
                    position = ArrayDecoders.decodePackedSInt32List(data, position, list, registers);
                    break;
                }
                break;
            case 34:
            case 48:
                if (wireType != 2) {
                    if (wireType == 0) {
                        position = ArrayDecoders.decodeSInt64List(tag, data, position, limit, list, registers);
                        break;
                    }
                } else {
                    position = ArrayDecoders.decodePackedSInt64List(data, position, list, registers);
                    break;
                }
                break;
            case 49:
                if (wireType == 3) {
                    position = ArrayDecoders.decodeGroupList(getMessageFieldSchema(bufferPosition), tag, data, position, limit, list, registers);
                    break;
                }
                break;
        }
        return position;
    }

    private <K, V> int parseMapField(T message, byte[] data, int position, int limit, int bufferPosition, long fieldOffset, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapDefaultEntry = getMapFieldDefaultEntry(bufferPosition);
        Object mapField = unsafe.getObject(message, fieldOffset);
        if (this.mapFieldSchema.isImmutable(mapField)) {
            mapField = this.mapFieldSchema.newMapField(mapDefaultEntry);
            this.mapFieldSchema.mergeFrom(mapField, mapField);
            unsafe.putObject(message, fieldOffset, mapField);
        }
        return decodeMapEntry(data, position, limit, this.mapFieldSchema.forMapMetadata(mapDefaultEntry), this.mapFieldSchema.forMutableMapData(mapField), registers);
    }

    private int parseOneofField(T message, byte[] data, int position, int limit, int tag, int number, int wireType, int typeAndOffset, int fieldType, long fieldOffset, int bufferPosition, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        long oneofCaseOffset = (long) (this.buffer[bufferPosition + 2] & 1048575);
        switch (fieldType) {
            case 51:
                if (wireType == 1) {
                    unsafe.putObject(message, fieldOffset, Double.valueOf(ArrayDecoders.decodeDouble(data, position)));
                    position += 8;
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
            case 52:
                if (wireType == 5) {
                    unsafe.putObject(message, fieldOffset, Float.valueOf(ArrayDecoders.decodeFloat(data, position)));
                    position += 4;
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
            case 53:
            case 54:
                if (wireType == 0) {
                    position = ArrayDecoders.decodeVarint64(data, position, registers);
                    unsafe.putObject(message, fieldOffset, Long.valueOf(registers.long1));
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
            case 55:
            case 62:
                if (wireType == 0) {
                    position = ArrayDecoders.decodeVarint32(data, position, registers);
                    unsafe.putObject(message, fieldOffset, Integer.valueOf(registers.int1));
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
            case 56:
            case 65:
                if (wireType == 1) {
                    unsafe.putObject(message, fieldOffset, Long.valueOf(ArrayDecoders.decodeFixed64(data, position)));
                    position += 8;
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
            case 57:
            case 64:
                if (wireType == 5) {
                    unsafe.putObject(message, fieldOffset, Integer.valueOf(ArrayDecoders.decodeFixed32(data, position)));
                    position += 4;
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
            case 58:
                if (wireType == 0) {
                    position = ArrayDecoders.decodeVarint64(data, position, registers);
                    unsafe.putObject(message, fieldOffset, Boolean.valueOf(registers.long1 != 0));
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
            case 59:
                if (wireType == 2) {
                    position = ArrayDecoders.decodeVarint32(data, position, registers);
                    int length = registers.int1;
                    if (length == 0) {
                        unsafe.putObject(message, fieldOffset, "");
                    } else if ((typeAndOffset & 536870912) == 0 || Utf8.isValidUtf8(data, position, position + length)) {
                        unsafe.putObject(message, fieldOffset, new String(data, position, length, Internal.UTF_8));
                        position += length;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
            case 60:
                if (wireType == 2) {
                    position = ArrayDecoders.decodeMessageField(getMessageFieldSchema(bufferPosition), data, position, limit, registers);
                    Object oldValue = unsafe.getInt(message, oneofCaseOffset) == number ? unsafe.getObject(message, fieldOffset) : null;
                    if (oldValue == null) {
                        unsafe.putObject(message, fieldOffset, registers.object1);
                    } else {
                        unsafe.putObject(message, fieldOffset, Internal.mergeMessage(oldValue, registers.object1));
                    }
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
            case 61:
                if (wireType == 2) {
                    position = ArrayDecoders.decodeBytes(data, position, registers);
                    unsafe.putObject(message, fieldOffset, registers.object1);
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
            case 63:
                if (wireType == 0) {
                    position = ArrayDecoders.decodeVarint32(data, position, registers);
                    int enumValue = registers.int1;
                    Internal.EnumVerifier enumVerifier = getEnumFieldVerifier(bufferPosition);
                    if (enumVerifier != null && !enumVerifier.isInRange(enumValue)) {
                        getMutableUnknownFields(message).storeField(tag, Long.valueOf((long) enumValue));
                        break;
                    } else {
                        unsafe.putObject(message, fieldOffset, Integer.valueOf(enumValue));
                        unsafe.putInt(message, oneofCaseOffset, number);
                        break;
                    }
                }
                break;
            case 66:
                if (wireType == 0) {
                    position = ArrayDecoders.decodeVarint32(data, position, registers);
                    unsafe.putObject(message, fieldOffset, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
            case 67:
                if (wireType == 0) {
                    position = ArrayDecoders.decodeVarint64(data, position, registers);
                    unsafe.putObject(message, fieldOffset, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
            case 68:
                if (wireType == 3) {
                    position = ArrayDecoders.decodeGroupField(getMessageFieldSchema(bufferPosition), data, position, limit, (tag & -8) | 4, registers);
                    Object oldValue2 = unsafe.getInt(message, oneofCaseOffset) == number ? unsafe.getObject(message, fieldOffset) : null;
                    if (oldValue2 == null) {
                        unsafe.putObject(message, fieldOffset, registers.object1);
                    } else {
                        unsafe.putObject(message, fieldOffset, Internal.mergeMessage(oldValue2, registers.object1));
                    }
                    unsafe.putInt(message, oneofCaseOffset, number);
                    break;
                }
                break;
        }
        return position;
    }

    private Schema getMessageFieldSchema(int pos) {
        int index = (pos / 3) * 2;
        Schema schema = (Schema) this.objects[index];
        if (schema != null) {
            return schema;
        }
        Schema schema2 = Protobuf.getInstance().schemaFor((Class) ((Class) this.objects[index + 1]));
        this.objects[index] = schema2;
        return schema2;
    }

    private Object getMapFieldDefaultEntry(int pos) {
        return this.objects[(pos / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int pos) {
        return (Internal.EnumVerifier) this.objects[((pos / 3) * 2) + 1];
    }

    /* JADX DEBUG: Type inference failed for r4v1. Raw type applied. Possible types: com.google.protobuf.UnknownFieldSchema<?, ?>, com.google.protobuf.UnknownFieldSchema<UT, UB> */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0523 A[LOOP:1: B:126:0x051a->B:128:0x0523, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0545  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0554  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x055e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseProto2Message(T r17, byte[] r18, int r19, int r20, int r21, com.google.protobuf.ArrayDecoders.Registers r22) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1393
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.parseProto2Message(java.lang.Object, byte[], int, int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int parseProto3Message(T message, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        int currentPresenceFieldOffset = 1048575;
        int currentPresenceField = 0;
        int oldNumber = -1;
        int pos = 0;
        while (position < limit) {
            position++;
            int tag = data[position];
            if (tag < 0) {
                position = ArrayDecoders.decodeVarint32(tag, data, position, registers);
                tag = registers.int1;
            }
            int number = tag >>> 3;
            int wireType = tag & 7;
            if (number > oldNumber) {
                pos = positionForFieldNumber(number, pos / 3);
            } else {
                pos = positionForFieldNumber(number);
            }
            oldNumber = number;
            if (pos == -1) {
                pos = 0;
            } else {
                int typeAndOffset = this.buffer[pos + 1];
                int fieldType = type(typeAndOffset);
                long fieldOffset = offset(typeAndOffset);
                if (fieldType <= 17) {
                    int presenceMaskAndOffset = this.buffer[pos + 2];
                    int presenceMask = 1 << (presenceMaskAndOffset >>> 20);
                    int presenceFieldOffset = presenceMaskAndOffset & 1048575;
                    if (presenceFieldOffset != currentPresenceFieldOffset) {
                        if (currentPresenceFieldOffset != 1048575) {
                            unsafe.putInt(message, (long) currentPresenceFieldOffset, currentPresenceField);
                        }
                        if (presenceFieldOffset != 1048575) {
                            currentPresenceField = unsafe.getInt(message, (long) presenceFieldOffset);
                        }
                        currentPresenceFieldOffset = presenceFieldOffset;
                    }
                    switch (fieldType) {
                        case 0:
                            if (wireType != 1) {
                                break;
                            } else {
                                UnsafeUtil.putDouble(message, fieldOffset, ArrayDecoders.decodeDouble(data, position));
                                position += 8;
                                currentPresenceField |= presenceMask;
                                break;
                            }
                        case 1:
                            if (wireType != 5) {
                                break;
                            } else {
                                UnsafeUtil.putFloat(message, fieldOffset, ArrayDecoders.decodeFloat(data, position));
                                position += 4;
                                currentPresenceField |= presenceMask;
                                break;
                            }
                        case 2:
                        case 3:
                            if (wireType != 0) {
                                break;
                            } else {
                                position = ArrayDecoders.decodeVarint64(data, position, registers);
                                unsafe.putLong(message, fieldOffset, registers.long1);
                                currentPresenceField |= presenceMask;
                                break;
                            }
                        case 4:
                        case 11:
                            if (wireType != 0) {
                                break;
                            } else {
                                position = ArrayDecoders.decodeVarint32(data, position, registers);
                                unsafe.putInt(message, fieldOffset, registers.int1);
                                currentPresenceField |= presenceMask;
                                break;
                            }
                        case 5:
                        case 14:
                            if (wireType != 1) {
                                break;
                            } else {
                                unsafe.putLong(message, fieldOffset, ArrayDecoders.decodeFixed64(data, position));
                                position += 8;
                                currentPresenceField |= presenceMask;
                                break;
                            }
                        case 6:
                        case 13:
                            if (wireType != 5) {
                                break;
                            } else {
                                unsafe.putInt(message, fieldOffset, ArrayDecoders.decodeFixed32(data, position));
                                position += 4;
                                currentPresenceField |= presenceMask;
                                break;
                            }
                        case 7:
                            if (wireType != 0) {
                                break;
                            } else {
                                position = ArrayDecoders.decodeVarint64(data, position, registers);
                                UnsafeUtil.putBoolean(message, fieldOffset, registers.long1 != 0);
                                currentPresenceField |= presenceMask;
                                break;
                            }
                        case 8:
                            if (wireType != 2) {
                                break;
                            } else {
                                if ((typeAndOffset & 536870912) == 0) {
                                    position = ArrayDecoders.decodeString(data, position, registers);
                                } else {
                                    position = ArrayDecoders.decodeStringRequireUtf8(data, position, registers);
                                }
                                unsafe.putObject(message, fieldOffset, registers.object1);
                                currentPresenceField |= presenceMask;
                                break;
                            }
                        case 9:
                            if (wireType != 2) {
                                break;
                            } else {
                                position = ArrayDecoders.decodeMessageField(getMessageFieldSchema(pos), data, position, limit, registers);
                                Object oldValue = unsafe.getObject(message, fieldOffset);
                                if (oldValue == null) {
                                    unsafe.putObject(message, fieldOffset, registers.object1);
                                } else {
                                    unsafe.putObject(message, fieldOffset, Internal.mergeMessage(oldValue, registers.object1));
                                }
                                currentPresenceField |= presenceMask;
                                break;
                            }
                        case 10:
                            if (wireType != 2) {
                                break;
                            } else {
                                position = ArrayDecoders.decodeBytes(data, position, registers);
                                unsafe.putObject(message, fieldOffset, registers.object1);
                                currentPresenceField |= presenceMask;
                                break;
                            }
                        case 12:
                            if (wireType != 0) {
                                break;
                            } else {
                                position = ArrayDecoders.decodeVarint32(data, position, registers);
                                unsafe.putInt(message, fieldOffset, registers.int1);
                                currentPresenceField |= presenceMask;
                                break;
                            }
                        case 15:
                            if (wireType != 0) {
                                break;
                            } else {
                                position = ArrayDecoders.decodeVarint32(data, position, registers);
                                unsafe.putInt(message, fieldOffset, CodedInputStream.decodeZigZag32(registers.int1));
                                currentPresenceField |= presenceMask;
                                break;
                            }
                        case 16:
                            if (wireType != 0) {
                                break;
                            } else {
                                position = ArrayDecoders.decodeVarint64(data, position, registers);
                                unsafe.putLong(message, fieldOffset, CodedInputStream.decodeZigZag64(registers.long1));
                                currentPresenceField |= presenceMask;
                                break;
                            }
                    }
                } else if (fieldType == 27) {
                    if (wireType == 2) {
                        Internal.ProtobufList<?> list = (Internal.ProtobufList) unsafe.getObject(message, fieldOffset);
                        if (!list.isModifiable()) {
                            int size = list.size();
                            list = list.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
                            unsafe.putObject(message, fieldOffset, list);
                        }
                        position = ArrayDecoders.decodeMessageList(getMessageFieldSchema(pos), tag, data, position, limit, list, registers);
                    }
                } else if (fieldType <= 49) {
                    position = parseRepeatedField(message, data, position, limit, tag, number, wireType, pos, (long) typeAndOffset, fieldType, fieldOffset, registers);
                    if (position != position) {
                    }
                } else if (fieldType != 50) {
                    position = parseOneofField(message, data, position, limit, tag, number, wireType, typeAndOffset, fieldType, fieldOffset, pos, registers);
                    if (position != position) {
                    }
                } else if (wireType == 2) {
                    position = parseMapField(message, data, position, limit, pos, fieldOffset, registers);
                    if (position != position) {
                    }
                }
            }
            position = ArrayDecoders.decodeUnknownField(tag, data, position, limit, getMutableUnknownFields(message), registers);
        }
        if (currentPresenceFieldOffset != 1048575) {
            unsafe.putInt(message, (long) currentPresenceFieldOffset, currentPresenceField);
        }
        if (position == limit) {
            return position;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T message, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(message, data, position, limit, registers);
        } else {
            parseProto2Message(message, data, position, limit, 0, registers);
        }
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T message) {
        for (int i = this.checkInitializedCount; i < this.repeatedFieldOffsetStart; i++) {
            long offset = offset(typeAndOffsetAt(this.intArray[i]));
            Object mapField = UnsafeUtil.getObject(message, offset);
            if (mapField != null) {
                UnsafeUtil.putObject(message, offset, this.mapFieldSchema.toImmutable(mapField));
            }
        }
        int length = this.intArray.length;
        for (int i2 = this.repeatedFieldOffsetStart; i2 < length; i2++) {
            this.listFieldSchema.makeImmutableListAt(message, (long) this.intArray[i2]);
        }
        this.unknownFieldSchema.makeImmutable(message);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(message);
        }
    }

    private final <K, V> void mergeMap(Object message, int pos, Object mapDefaultEntry, ExtensionRegistryLite extensionRegistry, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(pos));
        Object mapField = UnsafeUtil.getObject(message, offset);
        if (mapField == null) {
            mapField = this.mapFieldSchema.newMapField(mapDefaultEntry);
            UnsafeUtil.putObject(message, offset, mapField);
        } else if (this.mapFieldSchema.isImmutable(mapField)) {
            mapField = this.mapFieldSchema.newMapField(mapDefaultEntry);
            this.mapFieldSchema.mergeFrom(mapField, mapField);
            UnsafeUtil.putObject(message, offset, mapField);
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(mapField), this.mapFieldSchema.forMapMetadata(mapDefaultEntry), extensionRegistry);
    }

    /* JADX DEBUG: Type inference failed for r0v13. Raw type applied. Possible types: java.util.Map<?, ?>, java.util.Map<K, V> */
    private final <UT, UB> UB filterMapUnknownEnumValues(Object message, int pos, UB unknownFields, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        int fieldNumber = numberAt(pos);
        Object mapField = UnsafeUtil.getObject(message, offset(typeAndOffsetAt(pos)));
        if (mapField == null) {
            return unknownFields;
        }
        Internal.EnumVerifier enumVerifier = getEnumFieldVerifier(pos);
        if (enumVerifier == null) {
            return unknownFields;
        }
        return (UB) filterUnknownEnumMap(pos, fieldNumber, this.mapFieldSchema.forMutableMapData(mapField), enumVerifier, unknownFields, unknownFieldSchema);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int pos, int number, Map<K, V> mapData, Internal.EnumVerifier enumVerifier, UB unknownFields, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(pos));
        Iterator<Map.Entry<K, V>> it = mapData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> entry = it.next();
            if (!enumVerifier.isInRange(((Integer) entry.getValue()).intValue())) {
                if (unknownFields == null) {
                    unknownFields = unknownFieldSchema.newBuilder();
                }
                ByteString.CodedBuilder codedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, entry.getKey(), entry.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilder.getCodedOutput(), forMapMetadata, entry.getKey(), entry.getValue());
                    unknownFieldSchema.addLengthDelimited(unknownFields, number, codedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return unknownFields;
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T message) {
        int currentPresenceFieldOffset = 1048575;
        int currentPresenceField = 0;
        for (int i = 0; i < this.checkInitializedCount; i++) {
            int pos = this.intArray[i];
            int number = numberAt(pos);
            int typeAndOffset = typeAndOffsetAt(pos);
            int presenceMaskAndOffset = this.buffer[pos + 2];
            int presenceFieldOffset = presenceMaskAndOffset & 1048575;
            int presenceMask = 1 << (presenceMaskAndOffset >>> 20);
            if (presenceFieldOffset != currentPresenceFieldOffset) {
                currentPresenceFieldOffset = presenceFieldOffset;
                if (currentPresenceFieldOffset != 1048575) {
                    currentPresenceField = UNSAFE.getInt(message, (long) presenceFieldOffset);
                }
            }
            if (isRequired(typeAndOffset) && !isFieldPresent(message, pos, currentPresenceFieldOffset, currentPresenceField, presenceMask)) {
                return false;
            }
            switch (type(typeAndOffset)) {
                case 9:
                case 17:
                    if (isFieldPresent(message, pos, currentPresenceFieldOffset, currentPresenceField, presenceMask) && !isInitialized(message, typeAndOffset, getMessageFieldSchema(pos))) {
                        return false;
                    }
                    break;
                case 27:
                case 49:
                    if (isListInitialized(message, typeAndOffset, pos)) {
                        break;
                    } else {
                        return false;
                    }
                case 50:
                    if (isMapInitialized(message, typeAndOffset, pos)) {
                        break;
                    } else {
                        return false;
                    }
                case 60:
                case 68:
                    if (isOneofPresent(message, number, pos) && !isInitialized(message, typeAndOffset, getMessageFieldSchema(pos))) {
                        return false;
                    }
                    break;
            }
        }
        if (!this.hasExtensions || this.extensionSchema.getExtensions(message).isInitialized()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.protobuf.Schema */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object message, int typeAndOffset, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(message, offset(typeAndOffset)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.google.protobuf.Schema */
    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object message, int typeAndOffset, int pos) {
        List<N> list = (List) UnsafeUtil.getObject(message, offset(typeAndOffset));
        if (list.isEmpty()) {
            return true;
        }
        Schema schema = getMessageFieldSchema(pos);
        for (int i = 0; i < list.size(); i++) {
            if (!schema.isInitialized(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isMapInitialized(T message, int typeAndOffset, int pos) {
        Map<?, ?> map = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(message, offset(typeAndOffset)));
        if (map.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(pos)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema<T> schema = null;
        for (Object nested : map.values()) {
            if (schema == null) {
                schema = Protobuf.getInstance().schemaFor((Class) nested.getClass());
            }
            if (!schema.isInitialized(nested)) {
                return false;
            }
        }
        return true;
    }

    private void writeString(int fieldNumber, Object value, Writer writer) throws IOException {
        if (value instanceof String) {
            writer.writeString(fieldNumber, (String) value);
        } else {
            writer.writeBytes(fieldNumber, (ByteString) value);
        }
    }

    private void readString(Object message, int typeAndOffset, Reader reader) throws IOException {
        if (isEnforceUtf8(typeAndOffset)) {
            UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readString());
        } else {
            UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readBytes());
        }
    }

    private void readStringList(Object message, int typeAndOffset, Reader reader) throws IOException {
        if (isEnforceUtf8(typeAndOffset)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)));
        }
    }

    private <E> void readMessageList(Object message, int typeAndOffset, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)), schema, extensionRegistry);
    }

    private <E> void readGroupList(Object message, long offset, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(message, offset), schema, extensionRegistry);
    }

    private int numberAt(int pos) {
        return this.buffer[pos];
    }

    private int typeAndOffsetAt(int pos) {
        return this.buffer[pos + 1];
    }

    private int presenceMaskAndOffsetAt(int pos) {
        return this.buffer[pos + 2];
    }

    private static int type(int value) {
        return (value & FIELD_TYPE_MASK) >>> 20;
    }

    private static boolean isRequired(int value) {
        return (value & REQUIRED_MASK) != 0;
    }

    private static boolean isEnforceUtf8(int value) {
        return (value & 536870912) != 0;
    }

    private static long offset(int value) {
        return (long) (value & 1048575);
    }

    private static <T> double doubleAt(T message, long offset) {
        return UnsafeUtil.getDouble(message, offset);
    }

    private static <T> float floatAt(T message, long offset) {
        return UnsafeUtil.getFloat(message, offset);
    }

    private static <T> int intAt(T message, long offset) {
        return UnsafeUtil.getInt(message, offset);
    }

    private static <T> long longAt(T message, long offset) {
        return UnsafeUtil.getLong(message, offset);
    }

    private static <T> boolean booleanAt(T message, long offset) {
        return UnsafeUtil.getBoolean(message, offset);
    }

    private static <T> double oneofDoubleAt(T message, long offset) {
        return ((Double) UnsafeUtil.getObject(message, offset)).doubleValue();
    }

    private static <T> float oneofFloatAt(T message, long offset) {
        return ((Float) UnsafeUtil.getObject(message, offset)).floatValue();
    }

    private static <T> int oneofIntAt(T message, long offset) {
        return ((Integer) UnsafeUtil.getObject(message, offset)).intValue();
    }

    private static <T> long oneofLongAt(T message, long offset) {
        return ((Long) UnsafeUtil.getObject(message, offset)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T message, long offset) {
        return ((Boolean) UnsafeUtil.getObject(message, offset)).booleanValue();
    }

    private boolean arePresentForEquals(T message, T other, int pos) {
        return isFieldPresent(message, pos) == isFieldPresent(other, pos);
    }

    private boolean isFieldPresent(T message, int pos, int presenceFieldOffset, int presenceField, int presenceMask) {
        if (presenceFieldOffset == 1048575) {
            return isFieldPresent(message, pos);
        }
        return (presenceField & presenceMask) != 0;
    }

    private boolean isFieldPresent(T message, int pos) {
        int presenceMaskAndOffset = presenceMaskAndOffsetAt(pos);
        if (((long) (presenceMaskAndOffset & 1048575)) == 1048575) {
            int typeAndOffset = typeAndOffsetAt(pos);
            long offset = offset(typeAndOffset);
            switch (type(typeAndOffset)) {
                case 0:
                    return UnsafeUtil.getDouble(message, offset) != 0.0d;
                case 1:
                    return UnsafeUtil.getFloat(message, offset) != 0.0f;
                case 2:
                    return UnsafeUtil.getLong(message, offset) != 0;
                case 3:
                    return UnsafeUtil.getLong(message, offset) != 0;
                case 4:
                    return UnsafeUtil.getInt(message, offset) != 0;
                case 5:
                    return UnsafeUtil.getLong(message, offset) != 0;
                case 6:
                    return UnsafeUtil.getInt(message, offset) != 0;
                case 7:
                    return UnsafeUtil.getBoolean(message, offset);
                case 8:
                    Object value = UnsafeUtil.getObject(message, offset);
                    if (value instanceof String) {
                        return !((String) value).isEmpty();
                    }
                    if (value instanceof ByteString) {
                        return !ByteString.EMPTY.equals(value);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return UnsafeUtil.getObject(message, offset) != null;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.getObject(message, offset));
                case 11:
                    return UnsafeUtil.getInt(message, offset) != 0;
                case 12:
                    return UnsafeUtil.getInt(message, offset) != 0;
                case 13:
                    return UnsafeUtil.getInt(message, offset) != 0;
                case 14:
                    return UnsafeUtil.getLong(message, offset) != 0;
                case 15:
                    return UnsafeUtil.getInt(message, offset) != 0;
                case 16:
                    return UnsafeUtil.getLong(message, offset) != 0;
                case 17:
                    return UnsafeUtil.getObject(message, offset) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (UnsafeUtil.getInt(message, (long) (presenceMaskAndOffset & 1048575)) & (1 << (presenceMaskAndOffset >>> 20))) != 0;
        }
    }

    private void setFieldPresent(T message, int pos) {
        int presenceMaskAndOffset = presenceMaskAndOffsetAt(pos);
        long presenceFieldOffset = (long) (presenceMaskAndOffset & 1048575);
        if (presenceFieldOffset != 1048575) {
            UnsafeUtil.putInt(message, presenceFieldOffset, UnsafeUtil.getInt(message, presenceFieldOffset) | (1 << (presenceMaskAndOffset >>> 20)));
        }
    }

    private boolean isOneofPresent(T message, int fieldNumber, int pos) {
        return UnsafeUtil.getInt(message, (long) (presenceMaskAndOffsetAt(pos) & 1048575)) == fieldNumber;
    }

    private boolean isOneofCaseEqual(T message, T other, int pos) {
        int presenceMaskAndOffset = presenceMaskAndOffsetAt(pos);
        return UnsafeUtil.getInt(message, (long) (presenceMaskAndOffset & 1048575)) == UnsafeUtil.getInt(other, (long) (presenceMaskAndOffset & 1048575));
    }

    private void setOneofPresent(T message, int fieldNumber, int pos) {
        UnsafeUtil.putInt(message, (long) (presenceMaskAndOffsetAt(pos) & 1048575), fieldNumber);
    }

    private int positionForFieldNumber(int number) {
        if (number < this.minFieldNumber || number > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(number, 0);
    }

    private int positionForFieldNumber(int number, int min) {
        if (number < this.minFieldNumber || number > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(number, min);
    }

    private int slowPositionForFieldNumber(int number, int min) {
        int max = (this.buffer.length / 3) - 1;
        while (min <= max) {
            int mid = (max + min) >>> 1;
            int pos = mid * 3;
            int midFieldNumber = numberAt(pos);
            if (number == midFieldNumber) {
                return pos;
            }
            if (number < midFieldNumber) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
