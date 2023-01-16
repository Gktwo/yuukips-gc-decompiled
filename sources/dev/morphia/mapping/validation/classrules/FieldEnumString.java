package dev.morphia.mapping.validation.classrules;

import dev.morphia.mapping.codec.pojo.PropertyModel;
import java.util.Arrays;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/classrules/FieldEnumString.class */
public class FieldEnumString {
    private final String display;

    public FieldEnumString(PropertyModel... fields) {
        this(Arrays.asList(fields));
    }

    public FieldEnumString(List<PropertyModel> fields) {
        StringBuilder sb = new StringBuilder(128);
        for (PropertyModel mappedField : fields) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(mappedField.getMappedName());
        }
        this.display = sb.toString();
    }

    public String toString() {
        return this.display;
    }
}
