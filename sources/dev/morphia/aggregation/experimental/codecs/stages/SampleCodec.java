package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.aggregation.experimental.stages.Sample;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/SampleCodec.class */
public class SampleCodec extends StageCodec<Sample> {
    public SampleCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<Sample> getEncoderClass() {
        return Sample.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, Sample value, EncoderContext encoderContext) {
        ExpressionHelper.document(writer, () -> {
            writer.writeInt64("size", value.getSize());
        });
    }
}
