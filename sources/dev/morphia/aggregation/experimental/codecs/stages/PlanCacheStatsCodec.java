package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.aggregation.experimental.stages.PlanCacheStats;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/PlanCacheStatsCodec.class */
public class PlanCacheStatsCodec extends StageCodec<PlanCacheStats> {
    public PlanCacheStatsCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<PlanCacheStats> getEncoderClass() {
        return PlanCacheStats.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, PlanCacheStats value, EncoderContext encoderContext) {
        ExpressionHelper.document(writer, () -> {
        });
    }
}
