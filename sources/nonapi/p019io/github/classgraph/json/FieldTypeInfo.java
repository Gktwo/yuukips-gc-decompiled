package nonapi.p019io.github.classgraph.json;

import dev.morphia.mapping.Mapper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.Map;

/* access modifiers changed from: package-private */
/* renamed from: nonapi.io.github.classgraph.json.FieldTypeInfo */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/FieldTypeInfo.class */
public class FieldTypeInfo {
    final Field field;
    private final Type fieldTypePartiallyResolved;
    private final boolean hasUnresolvedTypeVariables;
    private final boolean isTypeVariable;
    private final PrimitiveType primitiveType;
    private Constructor<?> constructorForFieldTypeWithSizeHint;
    private Constructor<?> defaultConstructorForFieldType;

    /* access modifiers changed from: private */
    /* renamed from: nonapi.io.github.classgraph.json.FieldTypeInfo$PrimitiveType */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/FieldTypeInfo$PrimitiveType.class */
    public enum PrimitiveType {
        NON_PRIMITIVE,
        INTEGER,
        LONG,
        SHORT,
        DOUBLE,
        FLOAT,
        BOOLEAN,
        BYTE,
        CHARACTER,
        CLASS_REF
    }

    private static boolean hasTypeVariables(Type type) {
        if ((type instanceof TypeVariable) || (type instanceof GenericArrayType)) {
            return true;
        }
        if (!(type instanceof ParameterizedType)) {
            return false;
        }
        for (Type arg : ((ParameterizedType) type).getActualTypeArguments()) {
            if (hasTypeVariables(arg)) {
                return true;
            }
        }
        return false;
    }

    public FieldTypeInfo(Field field, Type fieldTypePartiallyResolved, ClassFieldCache classFieldCache) {
        this.field = field;
        this.fieldTypePartiallyResolved = fieldTypePartiallyResolved;
        this.isTypeVariable = fieldTypePartiallyResolved instanceof TypeVariable;
        this.hasUnresolvedTypeVariables = this.isTypeVariable || hasTypeVariables(fieldTypePartiallyResolved);
        if (((fieldTypePartiallyResolved instanceof GenericArrayType) || ((fieldTypePartiallyResolved instanceof Class) && ((Class) fieldTypePartiallyResolved).isArray())) || this.isTypeVariable) {
            this.primitiveType = PrimitiveType.NON_PRIMITIVE;
            return;
        }
        Class<?> fieldRawType = JSONUtils.getRawType(fieldTypePartiallyResolved);
        if (fieldRawType == Integer.TYPE) {
            this.primitiveType = PrimitiveType.INTEGER;
        } else if (fieldRawType == Long.TYPE) {
            this.primitiveType = PrimitiveType.LONG;
        } else if (fieldRawType == Short.TYPE) {
            this.primitiveType = PrimitiveType.SHORT;
        } else if (fieldRawType == Double.TYPE) {
            this.primitiveType = PrimitiveType.DOUBLE;
        } else if (fieldRawType == Float.TYPE) {
            this.primitiveType = PrimitiveType.FLOAT;
        } else if (fieldRawType == Boolean.TYPE) {
            this.primitiveType = PrimitiveType.BOOLEAN;
        } else if (fieldRawType == Byte.TYPE) {
            this.primitiveType = PrimitiveType.BYTE;
        } else if (fieldRawType == Character.TYPE) {
            this.primitiveType = PrimitiveType.CHARACTER;
        } else if (fieldRawType == Class.class) {
            this.primitiveType = PrimitiveType.CLASS_REF;
        } else {
            this.primitiveType = PrimitiveType.NON_PRIMITIVE;
        }
        if (!JSONUtils.isBasicValueType(fieldRawType)) {
            if (Collection.class.isAssignableFrom(fieldRawType) || Map.class.isAssignableFrom(fieldRawType)) {
                this.constructorForFieldTypeWithSizeHint = classFieldCache.getConstructorWithSizeHintForConcreteTypeOf(fieldRawType);
            }
            if (this.constructorForFieldTypeWithSizeHint == null) {
                this.defaultConstructorForFieldType = classFieldCache.getDefaultConstructorForConcreteTypeOf(fieldRawType);
            }
        }
    }

    public Constructor<?> getConstructorForFieldTypeWithSizeHint(Type fieldTypeFullyResolved, ClassFieldCache classFieldCache) {
        if (!this.isTypeVariable) {
            return this.constructorForFieldTypeWithSizeHint;
        }
        Class<?> fieldRawTypeFullyResolved = JSONUtils.getRawType(fieldTypeFullyResolved);
        if (Collection.class.isAssignableFrom(fieldRawTypeFullyResolved) || Map.class.isAssignableFrom(fieldRawTypeFullyResolved)) {
            return classFieldCache.getConstructorWithSizeHintForConcreteTypeOf(fieldRawTypeFullyResolved);
        }
        return null;
    }

    public Constructor<?> getDefaultConstructorForFieldType(Type fieldTypeFullyResolved, ClassFieldCache classFieldCache) {
        if (!this.isTypeVariable) {
            return this.defaultConstructorForFieldType;
        }
        return classFieldCache.getDefaultConstructorForConcreteTypeOf(JSONUtils.getRawType(fieldTypeFullyResolved));
    }

    public Type getFullyResolvedFieldType(TypeResolutions typeResolutions) {
        if (!this.hasUnresolvedTypeVariables) {
            return this.fieldTypePartiallyResolved;
        }
        return typeResolutions.resolveTypeVariables(this.fieldTypePartiallyResolved);
    }

    /* access modifiers changed from: package-private */
    public void setFieldValue(Object containingObj, Object value) {
        try {
            if (value != null) {
                switch (this.primitiveType) {
                    case NON_PRIMITIVE:
                        this.field.set(containingObj, value);
                        break;
                    case CLASS_REF:
                        if (value instanceof Class) {
                            this.field.set(containingObj, value);
                            break;
                        } else {
                            throw new IllegalArgumentException("Expected value of type Class<?>; got " + value.getClass().getName());
                        }
                    case INTEGER:
                        if (value instanceof Integer) {
                            this.field.setInt(containingObj, ((Integer) value).intValue());
                            break;
                        } else {
                            throw new IllegalArgumentException("Expected value of type Integer; got " + value.getClass().getName());
                        }
                    case LONG:
                        if (value instanceof Long) {
                            this.field.setLong(containingObj, ((Long) value).longValue());
                            break;
                        } else {
                            throw new IllegalArgumentException("Expected value of type Long; got " + value.getClass().getName());
                        }
                    case SHORT:
                        if (value instanceof Short) {
                            this.field.setShort(containingObj, ((Short) value).shortValue());
                            break;
                        } else {
                            throw new IllegalArgumentException("Expected value of type Short; got " + value.getClass().getName());
                        }
                    case DOUBLE:
                        if (value instanceof Double) {
                            this.field.setDouble(containingObj, ((Double) value).doubleValue());
                            break;
                        } else {
                            throw new IllegalArgumentException("Expected value of type Double; got " + value.getClass().getName());
                        }
                    case FLOAT:
                        if (value instanceof Float) {
                            this.field.setFloat(containingObj, ((Float) value).floatValue());
                            break;
                        } else {
                            throw new IllegalArgumentException("Expected value of type Float; got " + value.getClass().getName());
                        }
                    case BOOLEAN:
                        if (value instanceof Boolean) {
                            this.field.setBoolean(containingObj, ((Boolean) value).booleanValue());
                            break;
                        } else {
                            throw new IllegalArgumentException("Expected value of type Boolean; got " + value.getClass().getName());
                        }
                    case BYTE:
                        if (value instanceof Byte) {
                            this.field.setByte(containingObj, ((Byte) value).byteValue());
                            break;
                        } else {
                            throw new IllegalArgumentException("Expected value of type Byte; got " + value.getClass().getName());
                        }
                    case CHARACTER:
                        if (value instanceof Character) {
                            this.field.setChar(containingObj, ((Character) value).charValue());
                            break;
                        } else {
                            throw new IllegalArgumentException("Expected value of type Character; got " + value.getClass().getName());
                        }
                    default:
                        throw new IllegalArgumentException();
                }
            } else if (this.primitiveType != PrimitiveType.NON_PRIMITIVE) {
                throw new IllegalArgumentException("Tried to set primitive-typed field " + this.field.getDeclaringClass().getName() + Mapper.IGNORED_FIELDNAME + this.field.getName() + " to null value");
            } else {
                this.field.set(containingObj, null);
            }
        } catch (IllegalAccessException | IllegalArgumentException e) {
            throw new IllegalArgumentException("Could not set field " + this.field.getDeclaringClass().getName() + Mapper.IGNORED_FIELDNAME + this.field.getName(), e);
        }
    }

    public String toString() {
        return this.fieldTypePartiallyResolved + " " + this.field.getDeclaringClass().getName() + Mapper.IGNORED_FIELDNAME + this.field.getDeclaringClass().getName();
    }
}
