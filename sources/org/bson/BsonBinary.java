package org.bson;

import java.util.Arrays;
import java.util.UUID;
import org.bson.assertions.Assertions;
import org.bson.internal.UuidHelper;

/* loaded from: grasscutter.jar:org/bson/BsonBinary.class */
public class BsonBinary extends BsonValue {
    private final byte type;
    private final byte[] data;

    public BsonBinary(byte[] data) {
        this(BsonBinarySubType.BINARY, data);
    }

    public BsonBinary(BsonBinarySubType type, byte[] data) {
        if (type == null) {
            throw new IllegalArgumentException("type may not be null");
        } else if (data == null) {
            throw new IllegalArgumentException("data may not be null");
        } else {
            this.type = type.getValue();
            this.data = data;
        }
    }

    public BsonBinary(byte type, byte[] data) {
        if (data == null) {
            throw new IllegalArgumentException("data may not be null");
        }
        this.type = type;
        this.data = data;
    }

    public BsonBinary(UUID uuid) {
        this(uuid, UuidRepresentation.STANDARD);
    }

    public BsonBinary(UUID uuid, UuidRepresentation uuidRepresentation) {
        byte b;
        if (uuid == null) {
            throw new IllegalArgumentException("uuid may not be null");
        } else if (uuidRepresentation == null) {
            throw new IllegalArgumentException("uuidRepresentation may not be null");
        } else {
            this.data = UuidHelper.encodeUuidToBinary(uuid, uuidRepresentation);
            if (uuidRepresentation == UuidRepresentation.STANDARD) {
                b = BsonBinarySubType.UUID_STANDARD.getValue();
            } else {
                b = BsonBinarySubType.UUID_LEGACY.getValue();
            }
            this.type = b;
        }
    }

    public UUID asUuid() {
        if (!BsonBinarySubType.isUuid(this.type)) {
            throw new BsonInvalidOperationException("type must be a UUID subtype.");
        } else if (this.type == BsonBinarySubType.UUID_STANDARD.getValue()) {
            return UuidHelper.decodeBinaryToUuid((byte[]) this.data.clone(), this.type, UuidRepresentation.STANDARD);
        } else {
            throw new BsonInvalidOperationException("uuidRepresentation must be set to return the correct UUID.");
        }
    }

    public UUID asUuid(UuidRepresentation uuidRepresentation) {
        byte uuidType;
        Assertions.notNull("uuidRepresentation", uuidRepresentation);
        if (uuidRepresentation == UuidRepresentation.STANDARD) {
            uuidType = BsonBinarySubType.UUID_STANDARD.getValue();
        } else {
            uuidType = BsonBinarySubType.UUID_LEGACY.getValue();
        }
        if (this.type == uuidType) {
            return UuidHelper.decodeBinaryToUuid((byte[]) this.data.clone(), this.type, uuidRepresentation);
        }
        throw new BsonInvalidOperationException("uuidRepresentation does not match current uuidRepresentation.");
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.BINARY;
    }

    public byte getType() {
        return this.type;
    }

    public byte[] getData() {
        return this.data;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BsonBinary that = (BsonBinary) o;
        if (Arrays.equals(this.data, that.data) && this.type == that.type) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.type) + Arrays.hashCode(this.data);
    }

    public String toString() {
        return "BsonBinary{type=" + ((int) this.type) + ", data=" + Arrays.toString(this.data) + '}';
    }

    /* access modifiers changed from: package-private */
    public static BsonBinary clone(BsonBinary from) {
        return new BsonBinary(from.type, (byte[]) from.data.clone());
    }
}
