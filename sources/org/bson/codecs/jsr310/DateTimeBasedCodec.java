package org.bson.codecs.jsr310;

import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecConfigurationException;

/* loaded from: grasscutter.jar:org/bson/codecs/jsr310/DateTimeBasedCodec.class */
abstract class DateTimeBasedCodec<T> implements Codec<T> {
    long validateAndReadDateTime(BsonReader reader) {
        BsonType currentType = reader.getCurrentBsonType();
        if (currentType.equals(BsonType.DATE_TIME)) {
            return reader.readDateTime();
        }
        throw new CodecConfigurationException(String.format("Could not decode into %s, expected '%s' BsonType but got '%s'.", getEncoderClass().getSimpleName(), BsonType.DATE_TIME, currentType));
    }
}
