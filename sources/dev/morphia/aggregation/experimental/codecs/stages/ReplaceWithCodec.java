package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.stages.ReplaceWith;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/ReplaceWithCodec.class */
public class ReplaceWithCodec extends StageCodec<ReplaceWith> {
    public ReplaceWithCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<ReplaceWith> getEncoderClass() {
        return ReplaceWith.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, ReplaceWith replace, EncoderContext encoderContext) {
        Expression value = replace.getValue();
        if (value != null) {
            value.encode(getMapper(), writer, encoderContext);
        } else {
            replace.getDocument().encode(getMapper(), writer, encoderContext);
        }
    }
}
