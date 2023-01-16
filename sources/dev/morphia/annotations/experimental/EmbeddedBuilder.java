package dev.morphia.annotations.experimental;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.builders.AnnotationBuilder;

/* loaded from: grasscutter.jar:dev/morphia/annotations/experimental/EmbeddedBuilder.class */
public class EmbeddedBuilder extends AnnotationBuilder<Embedded> implements Embedded {
    public static EmbeddedBuilder builder() {
        return new EmbeddedBuilder();
    }

    @Override // dev.morphia.annotations.builders.AnnotationBuilder, java.lang.annotation.Annotation
    public Class<Embedded> annotationType() {
        return Embedded.class;
    }

    public EmbeddedBuilder discriminator(String discriminator) {
        put("discriminator", discriminator);
        return this;
    }

    public EmbeddedBuilder discriminatorKey(String discriminatorKey) {
        put("discriminatorKey", discriminatorKey);
        return this;
    }

    public EmbeddedBuilder useDiscriminator(boolean use) {
        put("useDiscriminator", Boolean.valueOf(use));
        return this;
    }

    @Override // dev.morphia.annotations.Embedded
    public String value() {
        return (String) get("value");
    }

    @Override // dev.morphia.annotations.Embedded
    public boolean useDiscriminator() {
        return ((Boolean) get("useDiscriminator")).booleanValue();
    }

    @Override // dev.morphia.annotations.Embedded
    public String discriminatorKey() {
        return (String) get("discriminatorKey");
    }

    @Override // dev.morphia.annotations.Embedded
    public String discriminator() {
        return (String) get("discriminator");
    }
}
