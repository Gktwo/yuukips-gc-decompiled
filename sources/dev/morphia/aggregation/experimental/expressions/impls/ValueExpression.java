package dev.morphia.aggregation.experimental.expressions.impls;

import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/impls/ValueExpression.class */
public class ValueExpression extends Expression {
    public ValueExpression(Object value) {
        super("unused", value);
    }

    @Override // dev.morphia.aggregation.experimental.expressions.impls.Expression
    public void encode(Mapper mapper, BsonWriter writer, EncoderContext encoderContext) {
        Object value = getValue();
        if (value != null) {
            encoderContext.encodeWithChildContext(mapper.getCodecRegistry().get(value.getClass()), writer, value);
        } else {
            writer.writeNull();
        }
    }
}
