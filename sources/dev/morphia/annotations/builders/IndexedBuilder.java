package dev.morphia.annotations.builders;

import dev.morphia.annotations.IndexOptions;
import dev.morphia.annotations.Indexed;
import dev.morphia.utils.IndexDirection;

/* loaded from: grasscutter.jar:dev/morphia/annotations/builders/IndexedBuilder.class */
public class IndexedBuilder extends AnnotationBuilder<Indexed> implements Indexed {
    @Override // dev.morphia.annotations.builders.AnnotationBuilder, java.lang.annotation.Annotation
    public Class<Indexed> annotationType() {
        return Indexed.class;
    }

    @Override // dev.morphia.annotations.Indexed
    public IndexOptions options() {
        return (IndexOptions) get("options");
    }

    @Override // dev.morphia.annotations.Indexed
    public IndexDirection value() {
        return (IndexDirection) get("value");
    }

    public IndexedBuilder options(IndexOptions options) {
        put("options", options);
        return this;
    }

    public IndexedBuilder value(IndexDirection value) {
        put("value", value);
        return this;
    }
}
