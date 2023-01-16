package org.bson;

/* loaded from: grasscutter.jar:org/bson/FieldNameValidator.class */
public interface FieldNameValidator {
    boolean validate(String str);

    FieldNameValidator getValidatorForField(String str);

    default void start() {
    }

    default void end() {
    }
}
