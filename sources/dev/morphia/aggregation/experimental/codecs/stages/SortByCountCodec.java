package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.stages.SortByCount;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/SortByCountCodec.class */
public class SortByCountCodec extends StageCodec<SortByCount> {
    public SortByCountCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<SortByCount> getEncoderClass() {
        return SortByCount.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, SortByCount value, EncoderContext encoderContext) {
        value.getExpression().encode(getMapper(), writer, encoderContext);
    }
}
