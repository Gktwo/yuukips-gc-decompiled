package dev.morphia.aggregation.experimental.expressions.impls;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.aggregation.experimental.expressions.Expressions;
import dev.morphia.mapping.Mapper;
import java.util.ArrayList;
import java.util.List;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/impls/Fields.class */
public class Fields<T> {
    private final List<PipelineField> fields = new ArrayList();
    private T owner;

    protected Fields(T owner) {
        this.owner = owner;
    }

    private Fields() {
    }

    /* renamed from: on */
    public static <T> Fields<T> m1256on(T owner) {
        return new Fields<>(owner);
    }

    public T add(String name) {
        this.fields.add(new PipelineField(name, Expressions.field(name)));
        return this.owner;
    }

    public T add(String name, Expression expression) {
        this.fields.add(new PipelineField(name, expression));
        return this.owner;
    }

    public void encode(Mapper mapper, BsonWriter writer, EncoderContext encoderContext) {
        for (PipelineField field : this.fields) {
            ExpressionHelper.expression(mapper, writer, field.getName(), field.getValue(), encoderContext);
        }
    }

    public List<PipelineField> getFields() {
        return this.fields;
    }

    public int size() {
        return this.fields.size();
    }
}
