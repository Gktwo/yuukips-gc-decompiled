package com.mongodb;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.Encoder;
import org.bson.codecs.EncoderContext;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/CompoundDBObjectCodec.class */
public class CompoundDBObjectCodec implements Codec<DBObject> {
    private final Encoder<DBObject> encoder;
    private final Decoder<DBObject> decoder;

    /* access modifiers changed from: package-private */
    public CompoundDBObjectCodec(Encoder<DBObject> encoder, Decoder<DBObject> decoder) {
        this.encoder = encoder;
        this.decoder = decoder;
    }

    /* access modifiers changed from: package-private */
    public CompoundDBObjectCodec(Codec<DBObject> codec) {
        this(codec, codec);
    }

    @Override // org.bson.codecs.Decoder
    public DBObject decode(BsonReader reader, DecoderContext decoderContext) {
        return this.decoder.decode(reader, decoderContext);
    }

    public void encode(BsonWriter writer, DBObject value, EncoderContext encoderContext) {
        this.encoder.encode(writer, value, encoderContext);
    }

    @Override // org.bson.codecs.Encoder
    public Class<DBObject> getEncoderClass() {
        return DBObject.class;
    }

    public Encoder<DBObject> getEncoder() {
        return this.encoder;
    }

    public Decoder<DBObject> getDecoder() {
        return this.decoder;
    }
}
