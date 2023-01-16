package dev.morphia.mapping.codec;

import dev.morphia.mapping.Mapper;
import dev.morphia.query.LegacyQuery;
import dev.morphia.sofia.Sofia;
import java.util.Locale;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/LegacyQueryCodec.class */
public class LegacyQueryCodec implements Codec<LegacyQuery> {
    private final Mapper mapper;

    public LegacyQueryCodec(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override // org.bson.codecs.Decoder
    public LegacyQuery decode(BsonReader reader, DecoderContext decoderContext) {
        throw new UnsupportedOperationException(Sofia.encodingOnly(new Locale[0]));
    }

    public void encode(BsonWriter writer, LegacyQuery value, EncoderContext encoderContext) {
        this.mapper.getCodecRegistry().get(Document.class).encode(writer, value.toDocument(), encoderContext);
    }

    @Override // org.bson.codecs.Encoder
    public Class<LegacyQuery> getEncoderClass() {
        return LegacyQuery.class;
    }
}
