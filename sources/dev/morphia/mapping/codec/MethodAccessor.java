package dev.morphia.mapping.codec;

import dev.morphia.mapping.MappingException;
import java.lang.reflect.Method;
import org.bson.codecs.pojo.PropertyAccessor;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MethodAccessor.class */
public class MethodAccessor implements PropertyAccessor<Object> {
    private final Method getter;
    private final Method setter;

    public MethodAccessor(Method getter, Method setter) {
        this.getter = getter;
        this.setter = setter;
    }

    @Override // org.bson.codecs.pojo.PropertyAccessor
    public <S> Object get(S instance) {
        try {
            return this.getter.invoke(instance, new Object[0]);
        } catch (ReflectiveOperationException e) {
            throw new MappingException(e.getMessage(), e);
        }
    }

    @Override // org.bson.codecs.pojo.PropertyAccessor
    public <S> void set(S instance, Object value) {
        try {
            this.setter.invoke(instance, value);
        } catch (ReflectiveOperationException e) {
            throw new MappingException(e.getMessage(), e);
        }
    }
}
