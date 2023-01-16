package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.aggregation.experimental.stages.CollectionStats;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/CollectionStatsCodec.class */
public class CollectionStatsCodec extends StageCodec<CollectionStats> {
    public CollectionStatsCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<CollectionStats> getEncoderClass() {
        return CollectionStats.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, CollectionStats value, EncoderContext encoderContext) {
        ExpressionHelper.document(writer, () -> {
            if (value.getHistogram()) {
                ExpressionHelper.document(writer, "latencyStats", () -> {
                    writer.writeBoolean("histograms", true);
                });
            }
            if (value.getScale() != null) {
                ExpressionHelper.document(writer, "storageStats", () -> {
                    writer.writeInt32("scale", value.getScale().intValue());
                });
            }
            if (value.getCount()) {
                ExpressionHelper.document(writer, "count", () -> {
                });
            }
        });
    }
}
