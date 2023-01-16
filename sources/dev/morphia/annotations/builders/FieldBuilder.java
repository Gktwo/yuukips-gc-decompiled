package dev.morphia.annotations.builders;

import dev.morphia.annotations.Field;
import dev.morphia.utils.IndexType;

/* loaded from: grasscutter.jar:dev/morphia/annotations/builders/FieldBuilder.class */
public class FieldBuilder extends AnnotationBuilder<Field> implements Field {
    @Override // dev.morphia.annotations.builders.AnnotationBuilder, java.lang.annotation.Annotation
    public Class<Field> annotationType() {
        return Field.class;
    }

    @Override // dev.morphia.annotations.Field
    public IndexType type() {
        return (IndexType) get("type");
    }

    @Override // dev.morphia.annotations.Field
    public String value() {
        return (String) get("value");
    }

    @Override // dev.morphia.annotations.Field
    public int weight() {
        return ((Integer) get("weight")).intValue();
    }

    public FieldBuilder type(IndexType type) {
        put("type", type);
        return this;
    }

    public FieldBuilder value(String value) {
        put("value", value);
        return this;
    }

    public FieldBuilder weight(int weight) {
        put("weight", Integer.valueOf(weight));
        return this;
    }
}
