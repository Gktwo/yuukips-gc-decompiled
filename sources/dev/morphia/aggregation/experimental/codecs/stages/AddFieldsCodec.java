package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.stages.AddFields;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/AddFieldsCodec.class */
public class AddFieldsCodec extends StageCodec<AddFields> {
    public AddFieldsCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<AddFields> getEncoderClass() {
        return AddFields.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, AddFields value, EncoderContext encoderContext) {
        value.getDocument().encode(getMapper(), writer, encoderContext);
    }
}
