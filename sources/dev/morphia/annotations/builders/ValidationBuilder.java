package dev.morphia.annotations.builders;

import com.mongodb.client.model.ValidationAction;
import com.mongodb.client.model.ValidationLevel;
import dev.morphia.annotations.Validation;

/* loaded from: grasscutter.jar:dev/morphia/annotations/builders/ValidationBuilder.class */
public class ValidationBuilder extends AnnotationBuilder<Validation> implements Validation {
    public ValidationBuilder action(ValidationAction action) {
        put("action", action);
        return this;
    }

    @Override // dev.morphia.annotations.builders.AnnotationBuilder, java.lang.annotation.Annotation
    public Class<Validation> annotationType() {
        return Validation.class;
    }

    public ValidationBuilder level(ValidationLevel level) {
        put("level", level);
        return this;
    }

    @Override // dev.morphia.annotations.Validation
    public String value() {
        return (String) get("value");
    }

    @Override // dev.morphia.annotations.Validation
    public ValidationLevel level() {
        return (ValidationLevel) get("level");
    }

    @Override // dev.morphia.annotations.Validation
    public ValidationAction action() {
        return (ValidationAction) get("action");
    }

    public ValidationBuilder value(String value) {
        put("value", value);
        return this;
    }
}
