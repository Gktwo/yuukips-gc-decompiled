package dev.morphia.mapping.codec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecConfigurationException;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/CollectionCodec.class */
public class CollectionCodec<T> implements Codec<Collection<T>> {
    private final Class<Collection<T>> encoderClass;
    private final Codec<T> codec;

    @Override // org.bson.codecs.Encoder
    public /* bridge */ /* synthetic */ void encode(BsonWriter bsonWriter, Object obj, EncoderContext encoderContext) {
        encode(bsonWriter, (Collection) ((Collection) obj), encoderContext);
    }

    /* access modifiers changed from: protected */
    public CollectionCodec(Class<Collection<T>> encoderClass, Codec<T> codec) {
        this.encoderClass = encoderClass;
        this.codec = codec;
    }

    protected Codec<T> getCodec() {
        return this.codec;
    }

    public void encode(BsonWriter writer, Collection<T> collection, EncoderContext encoderContext) {
        writer.writeStartArray();
        for (T value : collection) {
            if (value == null) {
                writer.writeNull();
            } else {
                this.codec.encode(writer, value, encoderContext);
            }
        }
        writer.writeEndArray();
    }

    @Override // org.bson.codecs.Decoder
    public Collection<T> decode(BsonReader reader, DecoderContext context) {
        Collection<T> collection = getInstance();
        reader.readStartArray();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            if (reader.getCurrentBsonType() == BsonType.NULL) {
                collection.add(null);
                reader.readNull();
            } else {
                collection.add(this.codec.decode(reader, context));
            }
        }
        reader.readEndArray();
        return collection;
    }

    @Override // org.bson.codecs.Encoder
    public Class<Collection<T>> getEncoderClass() {
        return this.encoderClass;
    }

    protected Collection<T> getInstance() {
        if (!this.encoderClass.isInterface()) {
            try {
                return this.encoderClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                throw new CodecConfigurationException(e.getMessage(), e);
            }
        } else if (this.encoderClass.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        } else {
            if (this.encoderClass.isAssignableFrom(HashSet.class)) {
                return new HashSet();
            }
            throw new CodecConfigurationException(String.format("Unsupported Collection interface of %s!", this.encoderClass.getName()));
        }
    }
}
