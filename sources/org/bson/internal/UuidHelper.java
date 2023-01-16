package org.bson.internal;

import java.util.Arrays;
import java.util.UUID;
import org.bson.BSONException;
import org.bson.BsonBinarySubType;
import org.bson.BsonSerializationException;
import org.bson.UuidRepresentation;

/* loaded from: grasscutter.jar:org/bson/internal/UuidHelper.class */
public final class UuidHelper {
    private static void writeLongToArrayBigEndian(byte[] bytes, int offset, long x) {
        bytes[offset + 7] = (byte) ((int) (255 & x));
        bytes[offset + 6] = (byte) ((int) (255 & (x >> 8)));
        bytes[offset + 5] = (byte) ((int) (255 & (x >> 16)));
        bytes[offset + 4] = (byte) ((int) (255 & (x >> 24)));
        bytes[offset + 3] = (byte) ((int) (255 & (x >> 32)));
        bytes[offset + 2] = (byte) ((int) (255 & (x >> 40)));
        bytes[offset + 1] = (byte) ((int) (255 & (x >> 48)));
        bytes[offset] = (byte) ((int) (255 & (x >> 56)));
    }

    private static long readLongFromArrayBigEndian(byte[] bytes, int offset) {
        return 0 | (255 & ((long) bytes[offset + 7])) | ((255 & ((long) bytes[offset + 6])) << 8) | ((255 & ((long) bytes[offset + 5])) << 16) | ((255 & ((long) bytes[offset + 4])) << 24) | ((255 & ((long) bytes[offset + 3])) << 32) | ((255 & ((long) bytes[offset + 2])) << 40) | ((255 & ((long) bytes[offset + 1])) << 48) | ((255 & ((long) bytes[offset])) << 56);
    }

    private static void reverseByteArray(byte[] data, int start, int length) {
        int left = start;
        for (int right = (start + length) - 1; left < right; right--) {
            byte temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            left++;
        }
    }

    public static byte[] encodeUuidToBinary(UUID uuid, UuidRepresentation uuidRepresentation) {
        byte[] binaryData = new byte[16];
        writeLongToArrayBigEndian(binaryData, 0, uuid.getMostSignificantBits());
        writeLongToArrayBigEndian(binaryData, 8, uuid.getLeastSignificantBits());
        switch (uuidRepresentation) {
            case C_SHARP_LEGACY:
                reverseByteArray(binaryData, 0, 4);
                reverseByteArray(binaryData, 4, 2);
                reverseByteArray(binaryData, 6, 2);
                break;
            case JAVA_LEGACY:
                reverseByteArray(binaryData, 0, 8);
                reverseByteArray(binaryData, 8, 8);
                break;
            case PYTHON_LEGACY:
            case STANDARD:
                break;
            default:
                throw new BSONException("Unexpected UUID representation: " + uuidRepresentation);
        }
        return binaryData;
    }

    public static UUID decodeBinaryToUuid(byte[] data, byte type, UuidRepresentation uuidRepresentation) {
        if (data.length != 16) {
            throw new BsonSerializationException(String.format("Expected length to be 16, not %d.", Integer.valueOf(data.length)));
        }
        byte[] localData = data;
        if (type == BsonBinarySubType.UUID_LEGACY.getValue()) {
            switch (uuidRepresentation) {
                case C_SHARP_LEGACY:
                    localData = Arrays.copyOf(data, 16);
                    reverseByteArray(localData, 0, 4);
                    reverseByteArray(localData, 4, 2);
                    reverseByteArray(localData, 6, 2);
                    break;
                case JAVA_LEGACY:
                    localData = Arrays.copyOf(data, 16);
                    reverseByteArray(localData, 0, 8);
                    reverseByteArray(localData, 8, 8);
                    break;
                case PYTHON_LEGACY:
                    break;
                case STANDARD:
                    throw new BSONException("Can not decode a subtype 3 (UUID legacy) BSON binary when the decoder is configured to use the standard UUID representation");
                default:
                    throw new BSONException("Unexpected UUID representation: " + uuidRepresentation);
            }
        }
        return new UUID(readLongFromArrayBigEndian(localData, 0), readLongFromArrayBigEndian(localData, 8));
    }

    private UuidHelper() {
    }
}
