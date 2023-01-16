package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.stages.Skip;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/SkipCodec.class */
public class SkipCodec extends StageCodec<Skip> {
    public SkipCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<Skip> getEncoderClass() {
        return Skip.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, Skip value, EncoderContext encoderContext) {
        writer.writeInt64(value.getSize());
    }
}
