package dev.morphia.aggregation.experimental.expressions;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.mapping.Mapper;
import java.util.ArrayList;
import java.util.List;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/ObjectExpressions.class */
public final class ObjectExpressions {
    private ObjectExpressions() {
    }

    public static MergeObjects mergeObjects() {
        return new MergeObjects();
    }

    /* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/ObjectExpressions$MergeObjects.class */
    public static class MergeObjects extends Expression {
        protected MergeObjects() {
            super("$mergeObjects", new ArrayList());
        }

        public MergeObjects add(Expression expression) {
            List<Expression> value = (List) getValue();
            if (value != null) {
                value.add(expression);
            }
            return this;
        }

        @Override // dev.morphia.aggregation.experimental.expressions.impls.Expression
        public void encode(Mapper mapper, BsonWriter writer, EncoderContext encoderContext) {
            encode(mapper, writer, encoderContext);
        }
    }
}
