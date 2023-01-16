package dev.morphia.aggregation.experimental.expressions.impls;

import com.mongodb.lang.Nullable;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/impls/ArrayExpression.class */
public class ArrayExpression extends Expression {
    public ArrayExpression(String operation, @Nullable Object value) {
        super(operation, value);
    }

    @Override // dev.morphia.aggregation.experimental.expressions.impls.Expression
    public void encode(Mapper mapper, BsonWriter writer, EncoderContext encoderContext) {
        encode(mapper, writer, encoderContext);
    }
}
