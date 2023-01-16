package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.aggregation.experimental.stages.IndexStats;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/IndexStatsCodec.class */
public class IndexStatsCodec extends StageCodec<IndexStats> {
    public IndexStatsCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<IndexStats> getEncoderClass() {
        return IndexStats.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, IndexStats value, EncoderContext encoderContext) {
        ExpressionHelper.document(writer, () -> {
        });
    }
}
