package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.stages.Redact;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/RedactCodec.class */
public class RedactCodec extends StageCodec<Redact> {
    public RedactCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<Redact> getEncoderClass() {
        return Redact.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, Redact value, EncoderContext encoderContext) {
        value.getExpression().encode(getMapper(), writer, encoderContext);
    }
}
