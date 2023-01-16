package com.mongodb.client.model.geojson.codecs;

import com.mongodb.client.model.geojson.Geometry;
import com.mongodb.client.model.geojson.Polygon;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/codecs/PolygonCodec.class */
public class PolygonCodec extends AbstractGeometryCodec<Polygon> {
    @Override // com.mongodb.client.model.geojson.codecs.AbstractGeometryCodec, org.bson.codecs.Encoder
    public /* bridge */ /* synthetic */ Class getEncoderClass() {
        return getEncoderClass();
    }

    @Override // com.mongodb.client.model.geojson.codecs.AbstractGeometryCodec, org.bson.codecs.Decoder
    public /* bridge */ /* synthetic */ Geometry decode(BsonReader bsonReader, DecoderContext decoderContext) {
        return decode(bsonReader, decoderContext);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [org.bson.BsonWriter, com.mongodb.client.model.geojson.Geometry, org.bson.codecs.EncoderContext] */
    @Override // com.mongodb.client.model.geojson.codecs.AbstractGeometryCodec
    public /* bridge */ /* synthetic */ void encode(BsonWriter bsonWriter, Polygon polygon, EncoderContext encoderContext) {
        encode(bsonWriter, (BsonWriter) polygon, encoderContext);
    }

    public PolygonCodec(CodecRegistry registry) {
        super(registry, Polygon.class);
    }
}
