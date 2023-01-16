package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.stages.Out;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/OutCodec.class */
public class OutCodec extends StageCodec<Out> {
    public OutCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<Out> getEncoderClass() {
        return Out.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, Out value, EncoderContext encoderContext) {
        Class<?> type = value.getType();
        if (type != null) {
            writer.writeString(getMapper().getCollection(type).getNamespace().getCollectionName());
        } else {
            writer.writeString(value.getCollection());
        }
    }
}
