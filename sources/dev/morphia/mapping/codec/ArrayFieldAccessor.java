package dev.morphia.mapping.codec;

import com.mongodb.lang.Nullable;
import dev.morphia.mapping.codec.pojo.TypeData;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/ArrayFieldAccessor.class */
public class ArrayFieldAccessor extends FieldAccessor {
    private final TypeData<?> typeData;
    private final Class<?> componentType;

    public ArrayFieldAccessor(TypeData<?> typeData, Field field) {
        super(field);
        this.typeData = typeData;
        this.componentType = field.getType().getComponentType();
    }

    @Override // dev.morphia.mapping.codec.FieldAccessor, org.bson.codecs.pojo.PropertyAccessor
    public void set(Object instance, Object value) {
        Object newValue = value;
        if (value.getClass().getComponentType() != this.componentType) {
            newValue = value instanceof List ? convert((List) value) : convert((Object[]) value);
        }
        set(instance, newValue);
    }

    private Object convert(Object[] value) {
        Object newArray = Array.newInstance(this.componentType, value.length);
        for (int i = 0; i < value.length; i++) {
            Array.set(newArray, i, convert(value[i], this.componentType));
        }
        return newArray;
    }

    private Object convert(List value) {
        Object newArray = Array.newInstance(this.componentType, value.size());
        for (int i = 0; i < value.size(); i++) {
            Object converted = convert(value.get(i), this.componentType);
            if (converted != null) {
                try {
                    Array.set(newArray, i, converted);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(String.format("Can't set %s with a value type of %s", getField(), converted.getClass()));
                }
            } else {
                throw new IllegalArgumentException(String.format("Can not convert '%s' to type '%s' ", value.get(i), this.componentType.getName()));
            }
        }
        return newArray;
    }

    @Nullable
    private Object convert(Object o, Class<?> type) {
        if (!(o instanceof List)) {
            return Conversions.convert(o, type);
        }
        List list = (List) o;
        Object newArray = Array.newInstance(type.getComponentType(), list.size());
        for (int i = 0; i < list.size(); i++) {
            Object converted = convert(list.get(i), type.getComponentType());
            try {
                Array.set(newArray, i, converted);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(String.format("Can't set %s with a value type of %s", getField(), converted.getClass()));
            }
        }
        return newArray;
    }
}
