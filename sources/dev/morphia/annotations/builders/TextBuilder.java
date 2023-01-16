package dev.morphia.annotations.builders;

import dev.morphia.annotations.IndexOptions;
import dev.morphia.annotations.Text;

/* loaded from: grasscutter.jar:dev/morphia/annotations/builders/TextBuilder.class */
public class TextBuilder extends AnnotationBuilder<Text> implements Text {
    @Override // dev.morphia.annotations.builders.AnnotationBuilder, java.lang.annotation.Annotation
    public Class<Text> annotationType() {
        return Text.class;
    }

    @Override // dev.morphia.annotations.Text
    public IndexOptions options() {
        return (IndexOptions) get("options");
    }

    @Override // dev.morphia.annotations.Text
    public int value() {
        return ((Integer) get("value")).intValue();
    }

    public TextBuilder options(IndexOptions options) {
        put("options", options);
        return this;
    }

    public TextBuilder value(int value) {
        put("value", Integer.valueOf(value));
        return this;
    }
}
