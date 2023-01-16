package dev.morphia.aggregation.experimental.codecs;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.mapping.Mapper;
import dev.morphia.sofia.Sofia;
import java.util.Locale;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/ExpressionCodec.class */
public class ExpressionCodec<T extends Expression> implements Codec<T> {
    private final Mapper mapper;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: dev.morphia.aggregation.experimental.codecs.ExpressionCodec<T extends dev.morphia.aggregation.experimental.expressions.impls.Expression> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.bson.codecs.Encoder
    public /* bridge */ /* synthetic */ void encode(BsonWriter bsonWriter, Object obj, EncoderContext encoderContext) {
        encode(bsonWriter, (BsonWriter) ((Expression) obj), encoderContext);
    }

    public ExpressionCodec(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override // org.bson.codecs.Decoder
    public final T decode(BsonReader reader, DecoderContext decoderContext) {
        throw new UnsupportedOperationException(Sofia.encodingOnly(new Locale[0]));
    }

    public void encode(BsonWriter writer, T expression, EncoderContext encoderContext) {
        if (expression != null) {
            expression.encode(this.mapper, writer, encoderContext);
        } else {
            writer.writeNull();
        }
    }

    @Override // org.bson.codecs.Encoder
    public final Class<T> getEncoderClass() {
        return Expression.class;
    }

    protected CodecRegistry getCodecRegistry() {
        return this.mapper.getCodecRegistry();
    }

    protected Mapper getMapper() {
        return this.mapper;
    }
}
