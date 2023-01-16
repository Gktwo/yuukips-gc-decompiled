package org.bson;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/NoOpFieldNameValidator.class */
public class NoOpFieldNameValidator implements FieldNameValidator {
    @Override // org.bson.FieldNameValidator
    public boolean validate(String fieldName) {
        return true;
    }

    @Override // org.bson.FieldNameValidator
    public FieldNameValidator getValidatorForField(String fieldName) {
        return this;
    }
}
