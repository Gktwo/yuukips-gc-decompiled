package com.mongodb.internal.validator;

import dev.morphia.mapping.Mapper;
import java.util.Arrays;
import java.util.List;
import org.bson.FieldNameValidator;

/* loaded from: grasscutter.jar:com/mongodb/internal/validator/CollectibleDocumentFieldNameValidator.class */
public class CollectibleDocumentFieldNameValidator implements FieldNameValidator {
    private static final List<String> EXCEPTIONS = Arrays.asList("$db", "$ref", "$id");

    @Override // org.bson.FieldNameValidator
    public boolean validate(String fieldName) {
        if (fieldName == null) {
            throw new IllegalArgumentException("Field name can not be null");
        } else if (fieldName.contains(Mapper.IGNORED_FIELDNAME)) {
            return false;
        } else {
            if (!fieldName.startsWith("$") || EXCEPTIONS.contains(fieldName)) {
                return true;
            }
            return false;
        }
    }

    @Override // org.bson.FieldNameValidator
    public FieldNameValidator getValidatorForField(String fieldName) {
        return this;
    }
}
