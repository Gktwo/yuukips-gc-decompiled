package dev.morphia.aggregation.experimental.expressions.impls;

import dev.morphia.mapping.Mapper;
import java.util.Arrays;
import java.util.List;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/impls/ArrayLiteral.class */
public class ArrayLiteral extends ArrayExpression {
    private final List<Expression> values;

    public ArrayLiteral(Expression... values) {
        super("unused", null);
        this.values = Arrays.asList(values);
    }

    @Override // dev.morphia.aggregation.experimental.expressions.impls.ArrayExpression, dev.morphia.aggregation.experimental.expressions.impls.Expression
    public void encode(Mapper mapper, BsonWriter writer, EncoderContext encoderContext) {
        encoderContext.encodeWithChildContext(mapper.getCodecRegistry().get(this.values.getClass()), writer, this.values);
    }
}
