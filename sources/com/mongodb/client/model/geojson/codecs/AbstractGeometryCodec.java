package com.mongodb.client.model.geojson.codecs;

import com.mongodb.client.model.geojson.Geometry;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/codecs/AbstractGeometryCodec.class */
public abstract class AbstractGeometryCodec<T extends Geometry> implements Codec<T> {
    private final CodecRegistry registry;
    private final Class<T> encoderClass;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.mongodb.client.model.geojson.codecs.AbstractGeometryCodec<T extends com.mongodb.client.model.geojson.Geometry> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.bson.codecs.Encoder
    public /* bridge */ /* synthetic */ void encode(BsonWriter bsonWriter, Object obj, EncoderContext encoderContext) {
        encode(bsonWriter, (BsonWriter) ((Geometry) obj), encoderContext);
    }

    /* access modifiers changed from: package-private */
    public AbstractGeometryCodec(CodecRegistry registry, Class<T> encoderClass) {
        this.registry = registry;
        this.encoderClass = encoderClass;
    }

    public void encode(BsonWriter writer, T value, EncoderContext encoderContext) {
        GeometryEncoderHelper.encodeGeometry(writer, value, encoderContext, this.registry);
    }

    @Override // org.bson.codecs.Decoder
    public T decode(BsonReader reader, DecoderContext decoderContext) {
        return (T) GeometryDecoderHelper.decodeGeometry(reader, getEncoderClass());
    }

    @Override // org.bson.codecs.Encoder
    public Class<T> getEncoderClass() {
        return this.encoderClass;
    }
}
