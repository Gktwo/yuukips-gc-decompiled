package com.mongodb.internal.validator;

import org.bson.FieldNameValidator;

/* loaded from: grasscutter.jar:com/mongodb/internal/validator/UpdateFieldNameValidator.class */
public class UpdateFieldNameValidator implements FieldNameValidator {
    private int numFields = 0;

    @Override // org.bson.FieldNameValidator
    public boolean validate(String fieldName) {
        this.numFields++;
        return fieldName.startsWith("$");
    }

    @Override // org.bson.FieldNameValidator
    public FieldNameValidator getValidatorForField(String fieldName) {
        return new NoOpFieldNameValidator();
    }

    @Override // org.bson.FieldNameValidator
    public void start() {
        this.numFields = 0;
    }

    @Override // org.bson.FieldNameValidator
    public void end() {
        if (this.numFields == 0) {
            throw new IllegalArgumentException("Invalid BSON document for an update. The document may not be empty.");
        }
    }
}
