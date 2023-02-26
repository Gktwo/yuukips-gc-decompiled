package nonapi.p019io.github.classgraph.json;

import dev.morphia.mapping.Mapper;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p013io.github.classgraph.ScanResult;

/* access modifiers changed from: package-private */
/* renamed from: nonapi.io.github.classgraph.json.ClassFields */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/ClassFields.class */
public class ClassFields {
    final List<FieldTypeInfo> fieldOrder = new ArrayList();
    final Map<String, FieldTypeInfo> fieldNameToFieldTypeInfo = new HashMap();
    Field idField;
    private static final Comparator<Field> FIELD_NAME_ORDER_COMPARATOR = new Comparator<Field>() { // from class: nonapi.io.github.classgraph.json.ClassFields.1
        public int compare(Field a, Field b) {
            return a.getName().compareTo(b.getName());
        }
    };
    private static final Comparator<Field> SERIALIZATION_FORMAT_FIELD_NAME_ORDER_COMPARATOR = new Comparator<Field>() { // from class: nonapi.io.github.classgraph.json.ClassFields.2
        public int compare(Field a, Field b) {
            if (a.getName().equals("format")) {
                return -1;
            }
            if (b.getName().equals("format")) {
                return 1;
            }
            return a.getName().compareTo(b.getName());
        }
    };
    private static final String SERIALIZATION_FORMAT_CLASS_NAME = ScanResult.class.getName() + "$SerializationFormat";

    public ClassFields(Class<?> cls, boolean resolveTypes, boolean onlySerializePublicFields, ClassFieldCache classFieldCache) {
        Class<?> currRawType;
        Set<String> visibleFieldNames = new HashSet<>();
        List<List<FieldTypeInfo>> fieldSuperclassReversedOrder = new ArrayList<>();
        TypeResolutions currTypeResolutions = null;
        Type currType = cls;
        while (currType != Object.class && currType != null) {
            if (currType instanceof ParameterizedType) {
                currRawType = (Class) ((ParameterizedType) currType).getRawType();
            } else if (currType instanceof Class) {
                currRawType = (Class) currType;
            } else {
                throw new IllegalArgumentException("Illegal class type: " + currType);
            }
            Field[] fields = currRawType.getDeclaredFields();
            Arrays.sort(fields, cls.getName().equals(SERIALIZATION_FORMAT_CLASS_NAME) ? SERIALIZATION_FORMAT_FIELD_NAME_ORDER_COMPARATOR : FIELD_NAME_ORDER_COMPARATOR);
            List<FieldTypeInfo> fieldOrderWithinClass = new ArrayList<>();
            for (Field field : fields) {
                if (visibleFieldNames.add(field.getName())) {
                    boolean isIdField = field.isAnnotationPresent(AbstractC5505Id.class);
                    if (isIdField) {
                        if (this.idField != null) {
                            throw new IllegalArgumentException("More than one @Id annotation: " + this.idField.getDeclaringClass() + Mapper.IGNORED_FIELDNAME + this.idField + " ; " + currRawType.getName() + Mapper.IGNORED_FIELDNAME + field.getName());
                        }
                        this.idField = field;
                    }
                    if (JSONUtils.fieldIsSerializable(field, onlySerializePublicFields)) {
                        Type fieldGenericType = field.getGenericType();
                        FieldTypeInfo fieldTypeInfo = new FieldTypeInfo(field, (currTypeResolutions == null || !resolveTypes) ? fieldGenericType : currTypeResolutions.resolveTypeVariables(fieldGenericType), classFieldCache);
                        this.fieldNameToFieldTypeInfo.put(field.getName(), fieldTypeInfo);
                        fieldOrderWithinClass.add(fieldTypeInfo);
                    } else if (isIdField) {
                        throw new IllegalArgumentException("@Id annotation field must be accessible, final, and non-transient: " + currRawType.getName() + Mapper.IGNORED_FIELDNAME + field.getName());
                    }
                }
            }
            fieldSuperclassReversedOrder.add(fieldOrderWithinClass);
            Type genericSuperType = currRawType.getGenericSuperclass();
            if (!resolveTypes) {
                currType = genericSuperType;
            } else if (genericSuperType instanceof ParameterizedType) {
                Type resolvedSupertype = currTypeResolutions == null ? genericSuperType : currTypeResolutions.resolveTypeVariables(genericSuperType);
                currTypeResolutions = resolvedSupertype instanceof ParameterizedType ? new TypeResolutions((ParameterizedType) resolvedSupertype) : null;
                currType = resolvedSupertype;
            } else if (genericSuperType instanceof Class) {
                currType = genericSuperType;
                currTypeResolutions = null;
            } else {
                throw new IllegalArgumentException("Got unexpected supertype " + genericSuperType);
            }
        }
        for (int i = fieldSuperclassReversedOrder.size() - 1; i >= 0; i--) {
            this.fieldOrder.addAll(fieldSuperclassReversedOrder.get(i));
        }
    }
}
