package dev.morphia.annotations.builders;

import dev.morphia.annotations.Field;
import dev.morphia.annotations.Index;
import dev.morphia.annotations.IndexOptions;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/annotations/builders/IndexBuilder.class */
public class IndexBuilder extends AnnotationBuilder<Index> implements Index {
    public IndexBuilder() {
    }

    /* access modifiers changed from: package-private */
    public IndexBuilder(Index original) {
        super(original);
    }

    @Override // dev.morphia.annotations.builders.AnnotationBuilder, java.lang.annotation.Annotation
    public Class<Index> annotationType() {
        return Index.class;
    }

    @Override // dev.morphia.annotations.Index
    public Field[] fields() {
        return (Field[]) get("fields");
    }

    @Override // dev.morphia.annotations.Index
    public IndexOptions options() {
        return (IndexOptions) get("options");
    }

    /* access modifiers changed from: package-private */
    public IndexBuilder fields(List<Field> fields) {
        put("fields", fields.toArray(new Field[0]));
        return this;
    }

    public IndexBuilder fields(Field... fields) {
        put("fields", fields);
        return this;
    }

    public IndexBuilder options(IndexOptions options) {
        put("options", options);
        return this;
    }

    IndexBuilder background(boolean background) {
        put("background", Boolean.valueOf(background));
        return this;
    }

    IndexBuilder name(String name) {
        put("name", name);
        return this;
    }

    IndexBuilder sparse(boolean sparse) {
        put("sparse", Boolean.valueOf(sparse));
        return this;
    }

    IndexBuilder unique(boolean unique) {
        put("unique", Boolean.valueOf(unique));
        return this;
    }

    IndexBuilder value(String value) {
        put("value", value);
        return this;
    }
}
