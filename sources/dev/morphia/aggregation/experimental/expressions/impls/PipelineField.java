package dev.morphia.aggregation.experimental.expressions.impls;

import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/impls/PipelineField.class */
public class PipelineField {
    private final String name;
    private final Expression value;

    public PipelineField(String name, Expression value) {
        this.name = name;
        this.value = value;
    }

    public void encode(Mapper mapper, BsonWriter writer, EncoderContext encoderContext) {
        writer.writeName(this.name);
        this.value.encode(mapper, writer, encoderContext);
    }

    public String getName() {
        return this.name;
    }

    public Expression getValue() {
        return this.value;
    }
}
