package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.stages.Count;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/CountCodec.class */
public class CountCodec extends StageCodec<Count> {
    public CountCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<Count> getEncoderClass() {
        return Count.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, Count value, EncoderContext encoderContext) {
        writer.writeString(value.getName());
    }
}
