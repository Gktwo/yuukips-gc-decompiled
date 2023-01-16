package org.bson.codecs;

import java.math.BigDecimal;
import org.bson.BsonInvalidOperationException;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.types.Decimal128;

/* loaded from: grasscutter.jar:org/bson/codecs/NumberCodecHelper.class */
final class NumberCodecHelper {
    /* access modifiers changed from: package-private */
    public static int decodeInt(BsonReader reader) {
        int intValue;
        BsonType bsonType = reader.getCurrentBsonType();
        switch (bsonType) {
            case INT32:
                intValue = reader.readInt32();
                break;
            case INT64:
                long longValue = reader.readInt64();
                intValue = (int) longValue;
                if (longValue != ((long) intValue)) {
                    throw invalidConversion(Integer.class, Long.valueOf(longValue));
                }
                break;
            case DOUBLE:
                double doubleValue = reader.readDouble();
                intValue = (int) doubleValue;
                if (doubleValue != ((double) intValue)) {
                    throw invalidConversion(Integer.class, Double.valueOf(doubleValue));
                }
                break;
            case DECIMAL128:
                Decimal128 decimal128 = reader.readDecimal128();
                intValue = decimal128.intValue();
                if (!decimal128.equals(new Decimal128((long) intValue))) {
                    throw invalidConversion(Integer.class, decimal128);
                }
                break;
            default:
                throw new BsonInvalidOperationException(String.format("Invalid numeric type, found: %s", bsonType));
        }
        return intValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* access modifiers changed from: package-private */
    public static long decodeLong(BsonReader reader) {
        char c;
        BsonType bsonType = reader.getCurrentBsonType();
        switch (bsonType) {
            case INT32:
                c = (long) reader.readInt32();
                break;
            case INT64:
                c = reader.readInt64();
                break;
            case DOUBLE:
                double doubleValue = reader.readDouble();
                char c2 = (long) doubleValue;
                int i = (doubleValue > ((double) c2) ? 1 : (doubleValue == ((double) c2) ? 0 : -1));
                c = c2;
                if (i != 0) {
                    throw invalidConversion(Long.class, Double.valueOf(doubleValue));
                }
                break;
            case DECIMAL128:
                Decimal128 decimal128 = reader.readDecimal128();
                char longValue = decimal128.longValue();
                boolean equals = decimal128.equals(new Decimal128(longValue));
                c = longValue;
                if (!equals) {
                    throw invalidConversion(Long.class, decimal128);
                }
                break;
            default:
                throw new BsonInvalidOperationException(String.format("Invalid numeric type, found: %s", bsonType));
        }
        return c == 1 ? 1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [double] */
    /* JADX WARN: Type inference failed for: r0v17, types: [double] */
    /* JADX WARN: Type inference failed for: r0v21, types: [double] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* access modifiers changed from: package-private */
    public static double decodeDouble(BsonReader reader) {
        char c;
        BsonType bsonType = reader.getCurrentBsonType();
        switch (bsonType) {
            case INT32:
                c = (double) reader.readInt32();
                break;
            case INT64:
                long longValue = reader.readInt64();
                char c2 = (double) longValue;
                int i = (longValue > ((long) c2) ? 1 : (longValue == ((long) c2) ? 0 : -1));
                c = c2;
                if (i != 0) {
                    throw invalidConversion(Double.class, Long.valueOf(longValue));
                }
                break;
            case DOUBLE:
                c = reader.readDouble();
                break;
            case DECIMAL128:
                Decimal128 decimal128 = reader.readDecimal128();
                try {
                    char doubleValue = decimal128.doubleValue();
                    if (decimal128.equals(new Decimal128(new BigDecimal((double) doubleValue)))) {
                        c = doubleValue;
                        break;
                    } else {
                        throw invalidConversion(Double.class, decimal128);
                    }
                } catch (NumberFormatException e) {
                    throw invalidConversion(Double.class, decimal128);
                }
            default:
                throw new BsonInvalidOperationException(String.format("Invalid numeric type, found: %s", bsonType));
        }
        return c == 1 ? 1.0d : 0.0d;
    }

    private static <T extends Number> BsonInvalidOperationException invalidConversion(Class<T> clazz, Number value) {
        return new BsonInvalidOperationException(String.format("Could not convert `%s` to a %s without losing precision", value, clazz));
    }

    private NumberCodecHelper() {
    }
}
