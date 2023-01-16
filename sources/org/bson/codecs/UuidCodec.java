package org.bson.codecs;

import java.util.UUID;
import org.bson.BSONException;
import org.bson.BsonBinary;
import org.bson.BsonBinarySubType;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.UuidRepresentation;
import org.bson.assertions.Assertions;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.internal.UuidHelper;

/* loaded from: grasscutter.jar:org/bson/codecs/UuidCodec.class */
public class UuidCodec implements Codec<UUID> {
    private final UuidRepresentation uuidRepresentation;

    public UuidCodec(UuidRepresentation uuidRepresentation) {
        Assertions.notNull("uuidRepresentation", uuidRepresentation);
        this.uuidRepresentation = uuidRepresentation;
    }

    public UuidCodec() {
        this.uuidRepresentation = UuidRepresentation.UNSPECIFIED;
    }

    public UuidRepresentation getUuidRepresentation() {
        return this.uuidRepresentation;
    }

    public void encode(BsonWriter writer, UUID value, EncoderContext encoderContext) {
        if (this.uuidRepresentation == UuidRepresentation.UNSPECIFIED) {
            throw new CodecConfigurationException("The uuidRepresentation has not been specified, so the UUID cannot be encoded.");
        }
        byte[] binaryData = UuidHelper.encodeUuidToBinary(value, this.uuidRepresentation);
        if (this.uuidRepresentation == UuidRepresentation.STANDARD) {
            writer.writeBinaryData(new BsonBinary(BsonBinarySubType.UUID_STANDARD, binaryData));
        } else {
            writer.writeBinaryData(new BsonBinary(BsonBinarySubType.UUID_LEGACY, binaryData));
        }
    }

    @Override // org.bson.codecs.Decoder
    public UUID decode(BsonReader reader, DecoderContext decoderContext) {
        byte subType = reader.peekBinarySubType();
        if (subType == BsonBinarySubType.UUID_LEGACY.getValue() || subType == BsonBinarySubType.UUID_STANDARD.getValue()) {
            return UuidHelper.decodeBinaryToUuid(reader.readBinaryData().getData(), subType, this.uuidRepresentation);
        }
        throw new BSONException("Unexpected BsonBinarySubType");
    }

    @Override // org.bson.codecs.Encoder
    public Class<UUID> getEncoderClass() {
        return UUID.class;
    }

    public String toString() {
        return "UuidCodec{uuidRepresentation=" + this.uuidRepresentation + '}';
    }
}
