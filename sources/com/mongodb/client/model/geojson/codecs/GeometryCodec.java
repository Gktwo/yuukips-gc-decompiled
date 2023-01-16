package com.mongodb.client.model.geojson.codecs;

import com.mongodb.client.model.geojson.Geometry;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/codecs/GeometryCodec.class */
public final class GeometryCodec extends AbstractGeometryCodec<Geometry> {
    @Override // com.mongodb.client.model.geojson.codecs.AbstractGeometryCodec, org.bson.codecs.Encoder
    public /* bridge */ /* synthetic */ Class getEncoderClass() {
        return getEncoderClass();
    }

    @Override // com.mongodb.client.model.geojson.codecs.AbstractGeometryCodec, org.bson.codecs.Decoder
    public /* bridge */ /* synthetic */ Geometry decode(BsonReader bsonReader, DecoderContext decoderContext) {
        return decode(bsonReader, decoderContext);
    }

    @Override // com.mongodb.client.model.geojson.codecs.AbstractGeometryCodec
    public /* bridge */ /* synthetic */ void encode(BsonWriter bsonWriter, Geometry geometry, EncoderContext encoderContext) {
        encode(bsonWriter, (BsonWriter) geometry, encoderContext);
    }

    public GeometryCodec(CodecRegistry registry) {
        super(registry, Geometry.class);
    }
}
