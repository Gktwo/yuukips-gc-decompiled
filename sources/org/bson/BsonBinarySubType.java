package org.bson;

/* loaded from: grasscutter.jar:org/bson/BsonBinarySubType.class */
public enum BsonBinarySubType {
    BINARY((byte) 0),
    FUNCTION((byte) 1),
    OLD_BINARY((byte) 2),
    UUID_LEGACY((byte) 3),
    UUID_STANDARD((byte) 4),
    MD5((byte) 5),
    USER_DEFINED(Byte.MIN_VALUE);
    
    private final byte value;

    public static boolean isUuid(byte value) {
        return value == UUID_LEGACY.getValue() || value == UUID_STANDARD.getValue();
    }

    BsonBinarySubType(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return this.value;
    }
}
