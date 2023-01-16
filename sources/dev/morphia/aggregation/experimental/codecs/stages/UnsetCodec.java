package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.stages.Unset;
import dev.morphia.mapping.Mapper;
import java.util.List;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/UnsetCodec.class */
public class UnsetCodec extends StageCodec<Unset> {
    public UnsetCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<Unset> getEncoderClass() {
        return Unset.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, Unset value, EncoderContext encoderContext) {
        List<Expression> fields = value.getFields();
        if (fields.size() == 1) {
            fields.get(0).encode(getMapper(), writer, encoderContext);
        } else if (fields.size() > 1) {
            encoderContext.encodeWithChildContext(getCodecRegistry().get(fields.getClass()), writer, fields);
        }
    }
}
