package org.bson.codecs;

import org.bson.BsonInvalidOperationException;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:org/bson/codecs/StringCodec.class */
public class StringCodec implements Codec<String>, RepresentationConfigurable<String> {
    private BsonType representation;

    public StringCodec() {
        this.representation = BsonType.STRING;
    }

    private StringCodec(BsonType representation) {
        this.representation = representation;
    }

    @Override // org.bson.codecs.RepresentationConfigurable
    public BsonType getRepresentation() {
        return this.representation;
    }

    @Override // org.bson.codecs.RepresentationConfigurable
    public Codec<String> withRepresentation(BsonType representation) {
        if (representation == BsonType.OBJECT_ID || representation == BsonType.STRING) {
            return new StringCodec(representation);
        }
        throw new CodecConfigurationException(representation + " is not a supported representation for StringCodec");
    }

    public void encode(BsonWriter writer, String value, EncoderContext encoderContext) {
        switch (this.representation) {
            case STRING:
                writer.writeString(value);
                return;
            case OBJECT_ID:
                writer.writeObjectId(new ObjectId(value));
                return;
            default:
                throw new BsonInvalidOperationException("Cannot encode a String to a " + this.representation);
        }
    }

    @Override // org.bson.codecs.Decoder
    public String decode(BsonReader reader, DecoderContext decoderContext) {
        switch (this.representation) {
            case STRING:
                if (reader.getCurrentBsonType() == BsonType.SYMBOL) {
                    return reader.readSymbol();
                }
                return reader.readString();
            case OBJECT_ID:
                return reader.readObjectId().toHexString();
            default:
                throw new CodecConfigurationException("Cannot decode " + this.representation + " to a String");
        }
    }

    @Override // org.bson.codecs.Encoder
    public Class<String> getEncoderClass() {
        return String.class;
    }
}
