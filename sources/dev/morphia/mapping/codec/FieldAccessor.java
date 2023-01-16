package dev.morphia.mapping.codec;

import com.mongodb.lang.Nullable;
import dev.morphia.mapping.MappingException;
import java.lang.reflect.Field;
import org.bson.codecs.pojo.PropertyAccessor;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/FieldAccessor.class */
public class FieldAccessor implements PropertyAccessor<Object> {
    private final Field field;

    public FieldAccessor(Field field) {
        this.field = field;
        field.setAccessible(true);
    }

    protected Field getField() {
        return this.field;
    }

    @Override // org.bson.codecs.pojo.PropertyAccessor
    @Nullable
    public Object get(@Nullable Object instance) {
        if (instance == null) {
            return null;
        }
        try {
            return this.field.get(instance);
        } catch (IllegalAccessException e) {
            throw new MappingException(e.getMessage(), e);
        }
    }

    @Override // org.bson.codecs.pojo.PropertyAccessor
    public void set(Object instance, Object value) {
        try {
            this.field.set(instance, value);
        } catch (ReflectiveOperationException e) {
            throw new MappingException(e.getMessage(), e);
        }
    }
}
