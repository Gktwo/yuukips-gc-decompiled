package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.aggregation.experimental.stages.Sort;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/SortCodec.class */
public class SortCodec extends StageCodec<Sort> {
    public SortCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<Sort> getEncoderClass() {
        return Sort.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, Sort value, EncoderContext encoderContext) {
        ExpressionHelper.document(writer, () -> {
            for (Sort.SortType sort : value.getSorts()) {
                writer.writeName(sort.getField());
                sort.getDirection().encode(writer);
            }
        });
    }
}
